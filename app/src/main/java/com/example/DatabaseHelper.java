package com.example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "wedding_planner.db";
    private static final int DATABASE_VERSION = 1;

    // Define the table and column names
    // Offer table and columns
    private static final String TABLE_OFFERS = "offers";
    private static final String COLUMN_OFFER_ID = "id";
    private static final String COLUMN_OFFER_PLACE = "place";
    private static final String COLUMN_OFFER_FOOD_TYPE = "food_type";
    private static final String COLUMN_OFFER_DETAILS = "details";

    // SQL statement to create the offers table
    private static final String CREATE_TABLE_OFFERS = "CREATE TABLE " + TABLE_OFFERS + "("
            + COLUMN_OFFER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_OFFER_PLACE + " TEXT,"
            + COLUMN_OFFER_FOOD_TYPE + " TEXT,"
            + COLUMN_OFFER_DETAILS + " TEXT"
            + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Retrieve all offers from the database
    public List<Offer> getAllOffers() {
        List<Offer> offers = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_OFFERS, null);

        // Loop through the cursor and create Offer objects
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_OFFER_ID));
                String place = cursor.getString(cursor.getColumnIndex(COLUMN_OFFER_PLACE));
                String foodType = cursor.getString(cursor.getColumnIndex(COLUMN_OFFER_FOOD_TYPE));
                String details = cursor.getString(cursor.getColumnIndex(COLUMN_OFFER_DETAILS));

                Offer offer = new Offer(id, place, foodType, details);
                offers.add(offer);
            } while (cursor.moveToNext());
        }

        // Close the cursor and database
        cursor.close();
        db.close();

        return offers;
    }

    // Insert a new offer into the database and return the ID of the newly created offer
    public long createOffer(Offer offer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_OFFER_PLACE, offer.getPlace());
        values.put(COLUMN_OFFER_FOOD_TYPE, offer.getFoodType());
        values.put(COLUMN_OFFER_DETAILS, offer.getDetails());

        long offerId = db.insert(TABLE_OFFERS, null, values);
        db.close();

        return offerId;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the offers table
        db.execSQL(CREATE_TABLE_OFFERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop and recreate the table if the database version changes
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OFFERS);
        onCreate(db);
    }
}

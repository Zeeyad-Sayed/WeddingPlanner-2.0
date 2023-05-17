package com.example.weddingplanner20;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.DatabaseHelper;
import com.example.Offer;

public class VendorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private DatabaseHelper databaseHelper;
    private Spinner placeSpinner;
    private Spinner foodTypeSpinner;
    private EditText detailsEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);

        placeSpinner = findViewById(R.id.place_spinner);
        foodTypeSpinner = findViewById(R.id.food_type_spinner);
        detailsEditText = findViewById(R.id.details_edittext);
        submitButton = findViewById(R.id.submit_button);

        databaseHelper = new DatabaseHelper(this);

        // Set up spinner item selection listener if needed

        placeSpinner.setOnItemSelectedListener(this);
        foodTypeSpinner.setOnItemSelectedListener(this);
    }

    public void submitVendorDetails(View view) {
        String place = placeSpinner.getSelectedItem().toString();
        String foodType = foodTypeSpinner.getSelectedItem().toString();
        String details = detailsEditText.getText().toString();

        // Create an Offer object
        Offer offer = new Offer(place, foodType, details);

        // Save the offer to the database
        long offerId = databaseHelper.createOffer(offer);
        int offerIdInt = (int) offerId;

        offer.setId(offerIdInt);

        if (offerId != -1) {
            Toast.makeText(this, "Offer created with ID: " + offerId, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to create offer", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Handle spinner item selection if needed
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Handle no selection if needed
    }
}
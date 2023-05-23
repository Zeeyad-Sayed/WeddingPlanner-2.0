package com.example.weddingplanner20;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.DatabaseHelper;
import com.example.Offer;
import com.example.OfferAdapter;

import java.util.List;

public class ClientActivity extends AppCompatActivity {

    private RecyclerView offersRecyclerView;
    private OfferAdapter offerAdapter;
    private List<Offer> offers;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        offersRecyclerView = findViewById(R.id.offers_recycler_view);
        offersRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        databaseHelper = new DatabaseHelper(this);
        offers = databaseHelper.getAllOffers();
        offerAdapter = new OfferAdapter((List<Offer>) ClientActivity.this, (Context) offers); // Use 'ClientActivity.this' instead of 'this'
        offersRecyclerView.setAdapter(offerAdapter);
    }
}
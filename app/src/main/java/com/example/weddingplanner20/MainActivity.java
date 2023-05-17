package com.example.weddingplanner20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button clientButton;
    private Button vendorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientButton = findViewById(R.id.client_button);
        vendorButton = findViewById(R.id.vendor_button);

        clientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchClientActivity();
            }
        });

        vendorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchVendorActivity();
            }
        });
    }

    private void launchClientActivity() {
        Intent intent = new Intent(MainActivity.this, ClientActivity.class);
        startActivity(intent);
    }

    private void launchVendorActivity() {
        Intent intent = new Intent(MainActivity.this, VendorActivity.class);
        startActivity(intent);
    }
}

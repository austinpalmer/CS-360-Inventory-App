package com.example.test.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.test.ItemListAdapter;
import com.example.test.R;
import com.example.test.repo.ItemDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name, quantity;
    ItemDatabase itemDatabase;

    // WIP: ItemListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Item variables
        Button addItem = findViewById(R.id.addItemBtn);
        Button deleteItem = findViewById(R.id.deleteItemBtn);

        /* WIP: Unknown crash when updating recyclerview

        itemDatabase = new ItemDatabase(this);
        // Create list of name/quantity for RecyclerView to update
        name = new ArrayList<>();
        quantity = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ItemListAdapter(this, name, quantity);
        // Set the RecyclerView to ItemListAdapter
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();*/

        // Upon clicking on add item button, start the AddItem screen
        addItem.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), AddItemActivity.class);
            startActivity(intent);
        });

        // Upon clicking on delete item button, start the DeleteItem screen
        deleteItem.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), DeleteItemActivity.class);
            startActivity(intent);
        });

        // Notification button
        ImageButton notificationBtn = findViewById(R.id.notificationBtn);
        // On click of notification bell, open notification activity
        notificationBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), NotificationActivity.class);
            startActivity(intent);
        });
    }

    /* WIP: Need to implement recyclerview

    Select everything from SQLite itemDatabase
    private void displayData() {
        Cursor cursor = itemDatabase.getData();
        // If list is empty, display message. Otherwise get and display items
        if (cursor.getCount() == 0) {
            Toast.makeText(MainActivity.this, "No items in list", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext()) {
                name.add(cursor.getString(0));
                name.add(cursor.getString(1));
            }
        }
    }
     */

    // Send SMS to listed phone # w/ alert
    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }
}
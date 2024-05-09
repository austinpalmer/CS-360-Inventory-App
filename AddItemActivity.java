package com.example.test.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.repo.ItemDatabase;

/*
    Brings up the add item screen and allows the user to add an item
 */
public class AddItemActivity extends AppCompatActivity {
    EditText name, quantity;
    Button saveBtn;
    ItemDatabase itemDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        name = findViewById(R.id.addItemName);
        quantity = findViewById(R.id.changeQntTxt);
        saveBtn = findViewById(R.id.saveBtn);
        itemDatabase = new ItemDatabase(this);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTxt = name.getText().toString();
                String qntTxt = quantity.getText().toString();
                Boolean checkInsertData = itemDatabase.insertItemData(nameTxt, qntTxt);

                // Check if item was input successfully and output message
                if (checkInsertData == true) {
                    Toast.makeText(AddItemActivity.this, "Successfully inserted item", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(AddItemActivity.this, "Error when inserting item", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
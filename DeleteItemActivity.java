package com.example.test.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.repo.ItemDatabase;

public class DeleteItemActivity extends AppCompatActivity {
    EditText name;
    Button saveBtn;
    ItemDatabase itemDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_item);

        name = findViewById(R.id.deleteItemName);
        saveBtn = findViewById(R.id.saveBtnDelete);
        itemDatabase = new ItemDatabase(this);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTxt = name.getText().toString();
                Boolean checkDeleteData = itemDatabase.deleteItemData(nameTxt);

                // Check if item was input successfully and output message
                if (checkDeleteData == true) {
                    Toast.makeText(DeleteItemActivity.this, "Successfully deleted item", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(DeleteItemActivity.this, "Error when deleting item", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

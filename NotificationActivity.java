package com.example.test.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.test.R;

public class NotificationActivity extends AppCompatActivity {
    final int REQUEST_CODE_SMS = 1;
    Button smsPermissionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        smsPermissionBtn = findViewById(R.id.permissionButton);

        // Prompt user to accept permission to send SMS
        smsPermissionBtn.setOnClickListener(v -> {
            // Check for SMS permission
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                // if no permission, request permission
               ActivityCompat.requestPermissions(this, new String[]
                       { Manifest.permission.SEND_SMS}, REQUEST_CODE_SMS);
            }
            // Already signed up for SMS
            else {
                Toast.makeText(NotificationActivity.this, "You already are signed up for SMS", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


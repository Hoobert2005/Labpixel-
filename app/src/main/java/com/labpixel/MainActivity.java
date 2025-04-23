package com.labpixel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button editButton, viewProjectsButton, settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation des boutons
        editButton = findViewById(R.id.edit_image_button);
        viewProjectsButton = findViewById(R.id.view_projects_button);
        settingsButton = findViewById(R.id.settings_button);

        // OnClickListener pour EditImageActivity
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditImageActivity.class);
                startActivity(intent);
            }
        });

        // OnClickListener pour ViewProjectsActivity
        viewProjectsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewProjectsActivity.class);
                startActivity(intent);
            }
        });

        // OnClickListener pour SettingsActivity
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}


package com.labpixel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EditImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_image);

        Button btnText = findViewById(R.id.btn_text);
        Button btnImage = findViewById(R.id.btn_image);
        Button btnShape = findViewById(R.id.btn_shape);
        Button btnBackground = findViewById(R.id.btn_background);

        btnText.setOnClickListener(v -> showToast("Ajouter du texte"));
        btnImage.setOnClickListener(v -> showToast("Ajouter une image"));
        btnShape.setOnClickListener(v -> showToast("Ajouter une forme"));
        btnBackground.setOnClickListener(v -> showToast("Changer le fond"));
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}


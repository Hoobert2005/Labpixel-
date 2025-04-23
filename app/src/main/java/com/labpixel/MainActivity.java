package com.labpixel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    // Initialisation des boutons
    private Button editButton;
    private Button viewProjectsButton;
    private Button settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Lien avec le fichier XML de l'interface utilisateur

        // Initialisation des boutons
        editButton = findViewById(R.id.edit_image_button);
        viewProjectsButton = findViewById(R.id.view_projects_button);
        settingsButton = findViewById(R.id.settings_button);

        // Ajout des écouteurs d'événements pour chaque bouton
        setButtonListeners();
    }

    // Méthode pour ajouter des écouteurs d'événements sur les boutons
    private void setButtonListeners() {
        // L'écouteur pour le bouton "Modifier une image"
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vérifie si les permissions nécessaires sont accordées avant de lancer l'activité
                if (checkPermissions()) {
                    // Ouvrir l'activité pour modifier l'image
                    Intent intent = new Intent(MainActivity.this, EditImageActivity.class);
                    startActivity(intent);
                } else {
                    // Afficher un message si les permissions ne sont pas accordées
                    Toast.makeText(MainActivity.this, "Permission refusée. Veuillez accorder les permissions nécessaires.", Toast.LENGTH_LONG).show();
                }
            }
        });

        // L'écouteur pour le bouton "Voir les Projets"
        viewProjectsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vérifie si les projets sont disponibles et ouvre l'activité correspondante
                if (isProjectAvailable()) {
                    // Ouvrir l'activité pour voir les projets
                    Intent intent = new Intent(MainActivity.this, ViewProjectsActivity.class);
                    startActivity(intent);
                } else {
                    // Afficher un message si aucun projet n'est disponible
                    Toast.makeText(MainActivity.this, "Aucun projet disponible.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // L'écouteur pour le bouton "Paramètres"
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ouvrir l'activité de paramètres
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    // Vérifier si les permissions nécessaires sont accordées
    private boolean checkPermissions() {
        // Exemple de code pour vérifier les permissions, à adapter selon les besoins (comme la caméra ou les fichiers)
        // return ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        return true; // Pour l'exemple, on suppose que les permissions sont accordées
    }

    // Vérifie si des projets sont disponibles
    private boolean isProjectAvailable() {
        // Exemple d'une condition basique, il faudrait adapter cette méthode selon l'app et les projets réels
        return true; // Pour l'exemple, on suppose que des projets sont disponibles
    }
}


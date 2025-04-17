#!/data/data/com.termux/files/usr/bin/bash

echo "=== Création des dossiers ==="
mkdir -p $HOME/android-sdk/cmdline-tools
cd $HOME/android-sdk/cmdline-tools

echo "=== Téléchargement des Android Command Line Tools ==="
wget https://dl.google.com/android/repository/commandlinetools-linux-9477386_latest.zip

echo "=== Extraction des fichiers ==="
unzip -q commandlinetools-linux-9477386_latest.zip
rm commandlinetools-linux-9477386_latest.zip
mv cmdline-tools latest

echo "=== Configuration des variables d'environnement ==="
grep -q 'ANDROID_HOME' ~/.bashrc || echo 'export ANDROID_HOME=$HOME/android-sdk' >> ~/.bashrc
grep -q 'cmdline-tools/latest/bin' ~/.bashrc || echo 'export PATH=$ANDROID_HOME/cmdline-tools/latest/bin:$PATH' >> ~/.bashrc
source ~/.bashrc

echo "=== Acceptation des licences Android SDK ==="
yes | sdkmanager --licenses

echo "=== Mise à jour de sdkmanager ==="
sdkmanager --update

echo "=== Installation des composants essentiels ==="
sdkmanager "platform-tools" "platforms;android-33" "build-tools;33.0.2"

echo "=== Création du fichier local.properties dans le projet ==="
echo "sdk.dir=$HOME/android-sdk" > $HOME/LabPixel/local.properties

echo "=== Installation terminée avec succès ==="

# Dice Roller 🎲

Application Android développée en **Kotlin** avec **Jetpack Compose**, qui simule le lancer d'un dé à 6 faces.

## Fonctionnalités

- Lancer un dé virtuel en appuyant sur le bouton **Roll**
- Animation de rotation du dé (720°) pendant le lancer
- Effet de "cycle rapide" entre les faces (défilement aléatoire sur 1 à 6) avant d'afficher le résultat final
- Bouton désactivé pendant l'animation pour éviter les lancers multiples simultanés

## Aperçu

L'application affiche l'image du dé correspondant au résultat (face 1 à 6) au centre de l'écran, avec un bouton **Roll** en dessous pour relancer.

## Technologies utilisées

- **Kotlin**
- **Jetpack Compose** (UI déclarative)
- **Material 3**
- Animations Compose (`animate*AsState`, `FastOutSlowInEasing`)

## Prérequis

- Android Studio (Ladybug ou plus récent recommandé)
- SDK Android : min **24**, target/compile **37**

## Installation

1. Cloner le dépôt :
   ```bash
   git clone https://github.com/mylanpatisson740-bit/DiceRoller.git
   ```
2. Ouvrir le projet dans Android Studio
3. Lancer l'application sur un émulateur ou un appareil physique

## Auteur

Mylan Patisson — [GitHub](https://github.com/mylanpatisson740-bit)

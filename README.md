<div align="center">

<img src="https://raw.githubusercontent.com/Whiskers-Color-Scheme/assets/main/logos/readme-logo.png" width="100">

### Whiskers for [Kotlin](https://kotlinlang.org/)

<div>
    <img src="https://raw.githubusercontent.com/Whiskers-Color-Scheme/assets/f73d25d4aa4480b7c4d593fb6ae8f4288f3fb5c0/previews/panther-preview.svg" width="300">
    <img src="https://raw.githubusercontent.com/Whiskers-Color-Scheme/assets/f73d25d4aa4480b7c4d593fb6ae8f4288f3fb5c0/previews/tiger-preview.svg" width="300">
</div>
</div>

## 👷‍♂️ Install
#### Adding Jitpack URL
If you use Groovy DSL (app build.gradle)
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
If you use Kotlin DSL (settings.gradle):
```gradle
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
      ...
      maven("https://jitpack.io")
  }
}
```

#### Adding dependency in gradle
On your app gradle add:
```gradle
//If you use Groovy DSL
implementation 'com.github.Whiskers-Color-Scheme:whiskers-palette-kt:1.0.1'

//If you use Kotlin DSL
implementation ("com.github.Whiskers-Color-Scheme:whiskers-palette-kt:1.0.1")
```


## 🧠 How To Use

To get the palettes:
```kotlin
val palettes = getWhiskersPalette() //Provides both palettes
val palette = getPantherPalette()
val palette = getTigerPalette()
```

To get a color:
```kotlin
val color = getWhiskersPalette().panther.banana
val color = getPantherPalette().banana
val color = getTigerPalette().banana
```

To get a value from the color
```kotlin
val color = getPantherPalette().banana

val hex = color.hex

val rgb = color.rgb.rgb
val r = color.rgb.r
val g = color.rgb.g
val b = color.rgb.b

val hsl = color.hsl
val h = color.h
val s = color.s
val l = color.l
```

## Android App
This repo also provides an android app for getting the palette. It can be download in the [releases](https://github.com/Whiskers-Color-Scheme/whiskers-palette-kt/releases) page
<div>
<img src="https://github.com/user-attachments/assets/b2d04a5b-ed66-4e8f-bd2a-78e83c2b4468" width="200">
<img src="https://github.com/user-attachments/assets/217f2856-14b8-4015-8e44-7c13844e3638" width="200">
</div>
<br>
<div>
<img src="https://github.com/user-attachments/assets/149f542c-fa99-4102-ac45-a8dda2ff6a3c" width="400">    
<img src="https://github.com/user-attachments/assets/d9f2bd7e-57e6-4608-a3ce-a069901e06a5" width="400">    
</div>






## 💻 Maintainers

- [lighttigerXIV]()

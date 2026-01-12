# 📱 TechHub - Android App Instructions

## 🔹 Project Overview

Aplikasi Android **TechHub** untuk tugas UAS Praktikum BP3.
Katalog smartphone dengan **10 Activity lengkap**.

---

## 🗂️ Struktur Project

```
TechHub/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/techhub/app/
│   │       │   ├── activities/
│   │       │   │   ├── SplashActivity.kt
│   │       │   │   ├── OnboardingActivity.kt
│   │       │   │   ├── LoginActivity.kt
│   │       │   │   ├── RegisterActivity.kt
│   │       │   │   ├── MainActivity.kt
│   │       │   │   ├── DetailActivity.kt
│   │       │   │   ├── SearchActivity.kt
│   │       │   │   ├── CompareActivity.kt
│   │       │   │   ├── SettingsActivity.kt
│   │       │   │   └── AboutActivity.kt
│   │       │   ├── adapters/
│   │       │   │   └── SmartphoneAdapter.kt
│   │       │   └── models/
│   │       │       └── Smartphone.kt
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   ├── drawable/
│   │       │   ├── values/
│   │       │   └── menu/
│   │       └── AndroidManifest.xml
│   └── build.gradle
└── build.gradle (project level)
```

---

## 🚀 Langkah Setup di Android Studio

### 1. Buat Project Baru

* File → New → New Project → **Empty Views Activity**
* Name: `TechHub`
* Package name: `com.techhub.app`
* Language: **Kotlin**
* Minimum SDK: **API 28 (Android 9.0)**
* Build configuration language: **Kotlin DSL**

**A. Kotlin Files**

```
/android/activities/*.kt → app/src/main/java/com/techhub/app/activities/
/android/adapters/*.kt → app/src/main/java/com/techhub/app/adapters/
/android/models/*.kt → app/src/main/java/com/techhub/app/models/
```

**B. XML Layouts**

```
/android/res/layout/*.xml → app/src/main/res/layout/
```

**C. Resources**

```
/android/res/drawable/ → app/src/main/res/drawable/
/android/res/values/ → app/src/main/res/values/
/android/res/menu/ → app/src/main/res/menu/
```

**D. Config Files**

```
/android/AndroidManifest.xml → app/src/main/AndroidManifest.xml
/android/app/build.gradle → app/build.gradle
```

---

### 3. Sync Gradle

* Klik **Sync Now** atau **File → Sync Project with Gradle Files**
* Tunggu hingga semua dependencies terdownload

---

### 4. Enable ViewBinding

Pastikan di `app/build.gradle` sudah ada:

```gradle
buildFeatures {
    viewBinding true
}
```

---

### 5. Tambahkan Dependencies

```gradle
dependencies {
    implementation 'androidx.core:core-ktx:1.12.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.11.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.recyclerview:recyclerview:1.3.2'
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'androidx.viewpager2:viewpager2:1.0.0'
    implementation 'com.github.bumptech.glide:glide:4.16.0'
}
```

---

### 6. Tambahkan CircleImageView (AboutActivity)

```gradle
dependencies {
    implementation 'de.hdodenhof:circleimageview:3.1.0'
}
```

---

### 7. Setup Internet Permission

Pastikan di `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

---

## 🎨 Customization

### Ganti Foto Profil AboutActivity

1. Siapkan foto profil (JPG/PNG)
2. Rename: `profile_photo.jpg`
3. Paste ke: `app/src/main/res/drawable/`
4. Edit `AboutActivity.kt` & `activity_about.xml`

   * Ganti nama, email, GitHub, LinkedIn sesuai data Anda

### Edit Data Konten Smartphone

File: `app/src/main/java/com/techhub/app/models/Smartphone.kt`

* Tambah/kurangi smartphone
* Update spesifikasi sesuai kebutuhan

---

## 🏃 Run Aplikasi

**Emulator**

* Tools → Device Manager → Create Device → Pilih device → System Image (API 33+) → Run

**Physical Device**

* Aktifkan Developer Options & USB Debugging → Sambungkan via USB → Run

---

## 📋 Fitur Aplikasi

**10 Activity**

1. SplashActivity – Launcher (delay 3 detik)
2. OnboardingActivity – 3 slides perkenalan
3. LoginActivity – Form login
4. RegisterActivity – Form registrasi
5. MainActivity – Dashboard RecyclerView (12 smartphone)
6. DetailActivity – Detail spesifikasi lengkap
7. SearchActivity – Pencarian smartphone
8. CompareActivity – Perbandingan 2 smartphone
9. SettingsActivity – Pengaturan aplikasi
10. AboutActivity – Profil developer

**Fitur Tambahan**

* `Intent.putExtra` untuk kirim username
* RecyclerView GridLayoutManager (2 kolom)
* CardView untuk item smartphone
* Filter brand dengan ChipGroup
* SearchView real-time
* SharedPreferences untuk settings
* Material Design Components
* Glide untuk load images dari URL

---

## 🐛 Troubleshooting

**Unresolved reference: databinding** → Pastikan ViewBinding enable & sync gradle
**Cannot resolve symbol 'MaterialButton'** → Pastikan Material dependency ada
**Gambar tidak muncul (Glide)** → Cek internet permission & koneksi
**CircleImageView error** → Tambahkan dependency `de.hdodenhof:circleimageview:3.1.0`

---

## 📝 Catatan Penting

* Package name harus `com.techhub.app`
* Launcher Activity: `SplashActivity`
* Internet diperlukan untuk load gambar
* MinSDK: API 24 (Android 7.0)
* Foto Profil di drawable, ganti sesuai data Anda

---

## 🎓 Untuk Tugas UAS

* Edit **AboutActivity** (nama, email, foto, universitas)
* Edit/tambah **Smartphone data** (opsional)
* Sesuaikan **package name** jika diminta dosen

---

## 📞 Support

* Cek Logcat di Android Studio
* Pastikan semua file sudah tercopy
* Sync Gradle setelah perubahan

---

**Good luck dengan tugas UAS!** 🚀

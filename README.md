# Hi-Paw-VetCare-
# 🐾 Hi-Paw VetCare

Hi-Paw VetCare adalah aplikasi manajemen klinik hewan berbasis Java yang dikembangkan untuk membantu proses layanan klinik hewan, mulai dari reservasi, pemeriksaan, hingga pembayaran.

## 📖 Deskripsi

Aplikasi ini menyediakan sistem informasi klinik hewan yang mendukung tiga jenis pengguna:

- Customer
- Dokter
- Staff Administrasi

Setiap pengguna memiliki dashboard dan fitur yang berbeda sesuai perannya.

## 🎯 Tujuan

Membantu digitalisasi proses pelayanan klinik hewan agar lebih efisien, terorganisir, dan mudah digunakan.

## ✨ Fitur Utama

### Customer
- Login
- Melihat data hewan
- Membuat reservasi
- Melihat riwayat layanan

### Dokter
- Melihat jadwal pemeriksaan
- Mengisi hasil pemeriksaan
- Memberikan diagnosa
- Menambahkan resep obat

### Staff Administrasi
- Mengelola data customer
- Mengelola data hewan
- Mengelola reservasi
- Mengelola pembayaran
- Mengelola tagihan

## 🏗️ Struktur Sistem

```text
src/
│
├── model/
│   ├── User.java
│   ├── Customer.java
│   ├── Dokter.java
│   ├── StaffAdministrasi.java
│   ├── Hewan.java
│   ├── Reservasi.java
│   ├── Pemeriksaan.java
│   ├── Obat.java
│   ├── Tagihan.java
│   └── Pembayaran.java
│
├── view/
│   ├── LoginFrame.java
│   ├── CustomerDashboardFrame.java
│   ├── DokterDashboardFrame.java
│   ├── StaffDashboardFrame.java
│   └── Form*.java
│
├── util/
│   ├── DatabaseConnection.java
│   └── SessionManager.java
│
└── main/
    └── Main.java
```

## 🛠️ Teknologi

- Java
- Java Swing
- MySQL
- JDBC
- NetBeans IDE

## 🗄️ Database

Database digunakan untuk menyimpan:

- Data User
- Data Customer
- Data Dokter
- Data Hewan
- Data Reservasi
- Data Pemeriksaan
- Data Obat
- Data Tagihan
- Data Pembayaran

## 🚀 Cara Menjalankan

1. Clone repository

```bash
git clone https://github.com/Haditya06/Hi-Paw-VetCare-.git
```

2. Import project ke NetBeans

3. Buat database MySQL sesuai skema yang digunakan

4. Atur konfigurasi database pada:

```java
DatabaseConnection.java
```

5. Jalankan:

```java
Main.java
```

## 👥 Tim Pengembang

Proyek ini dikembangkan sebagai Tugas Besar Mata Kuliah DASAR PEMROGRAMAN BERORIENTASI OBJEK.

## 📄 Lisensi

Digunakan untuk kebutuhan akademik dan pembelajaran.

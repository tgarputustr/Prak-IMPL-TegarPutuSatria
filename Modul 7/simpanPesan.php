<?php
session_start();
$idPengirim = 1;
$idPenerima = $_POST['Penerima'];
$judul = $_POST['judul'];
$TextPesan = $_POST['TextPesan'];
$date = date('Y-m-d H:i:s');

$conn = mysqli_connect("localhost", "root", "", "dbimpal");

// Periksa koneksi
if (!$conn) {
    die("Koneksi gagal: " . mysqli_connect_error());
}

$sql = "INSERT INTO pesan (idPengirim, idPenerima, judul, TextPesan, date) VALUES ('$idPengirim', '$idPenerima', '$judul', '$TextPesan', '$date')";
if (mysqli_query($conn, $sql)) {
    echo "Pesan berhasil ditambahkan";
} else {
    echo "Pesan gagal ditambahkan: " . mysqli_error($conn);
}

mysqli_close($conn);

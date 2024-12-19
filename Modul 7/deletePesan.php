<?php
// Koneksi ke database
$connection = mysqli_connect("localhost", "root", "", "dbimpal");

if (!$connection) {
    die("Koneksi gagal: " . mysqli_connect_error());
}

// Cek apakah ada parameter 'delete' di URL
if (isset($_GET['delete'])) {
    $idPesan = $_GET['delete'];

    // Query untuk menghapus pesan berdasarkan idPesan
    $deleteQuery = "DELETE FROM pesan WHERE idPesan = ?";
    $stmt = mysqli_prepare($connection, $deleteQuery);
    mysqli_stmt_bind_param($stmt, "i", $idPesan); // Menyiapkan parameter

    if (mysqli_stmt_execute($stmt)) {
        // Redirect ke halaman FormTampilPesan.php setelah penghapusan
        header("Location: FormTampilPesan.php");
        exit();
    } else {
        die("Gagal menghapus pesan: " . mysqli_error($connection));
    }
}

// Menutup koneksi
mysqli_close($connection);
?>

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
        // Redirect untuk memperbarui tampilan setelah penghapusan
        header("Location: FormTampilPesan.php");
        exit();
    } else {
        die("Gagal menghapus pesan: " . mysqli_error($connection));
    }
}

// Menjalankan query untuk menampilkan pesan
$query = "SELECT * FROM pesan";
$result = mysqli_query($connection, $query);

if (!$result) {
    die("Query gagal: " . mysqli_error($connection));
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pesan</title>
    <link rel="stylesheet" href="styles.css"> <!-- Menghubungkan file CSS eksternal -->
</head>

<body>
    <div class="container">
        <h1>Daftar Pesan</h1>

        <table>
            <thead>
                <tr>
                    <th>ID Pesan</th>
                    <th>Pengirim</th>
                    <th>Penerima</th>
                    <th>Judul</th>
                    <th>Teks Pesan</th>
                    <th>Tanggal</th>
                    <th>Aksi</th>
                </tr>
            </thead>
            <tbody>
                <?php while ($row = mysqli_fetch_assoc($result)): ?>
                    <tr>
                        <td><?= htmlspecialchars($row['idPesan']) ?></td>
                        <td><?= htmlspecialchars($row['idPenerima']) ?></td>
                        <td><?= htmlspecialchars($row['idPengirim']) ?></td>
                        <td><?= htmlspecialchars($row['judul']) ?></td>
                        <td><?= htmlspecialchars($row['TextPesan']) ?></td>
                        <td><?= htmlspecialchars($row['date']) ?></td>
                        <td>
                            <!-- Tombol Tambah Pesan (bisa sesuaikan URL untuk form tambah pesan khusus) -->
                            <a href="formTambahPesan.php" class="btn btn-primary">Tambah Pesan</a>
                            
                            <!-- Tombol Hapus dengan parameter 'delete' yang di-encode -->
                            <a href="FormTampilPesan.php?delete=<?= urlencode($row['idPesan']) ?>" class="btn btn-danger">Hapus</a>
                        </td>
                    </tr>
                <?php endwhile; ?>
            </tbody>
        </table>
    </div>
</body>

</html>

<?php
// Menutup koneksi
mysqli_close($connection);
?>

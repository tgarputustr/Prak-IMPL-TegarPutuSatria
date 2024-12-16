<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tambah Pesan</title>
</head>

<body>
    <?php
    session_start();
    ?>
    <form action="simpanPesan.php" method="POST">
        <!-- diasumsikan idPengirim = id user login, didapatkan dari session dan idpesan auto_increment dan tanggal adalah tanggal saat ini sehingga tidak perlu input -->
        <input type="text" name="Penerima" placeholder="Penerima" required>
        <input type="text" name="judul" placeholder="Judul" required>
        <textarea name="TextPesan" placeholder="Teks Pesan" required></textarea>
        <input type="submit" name="submit" value="Simpan">
    </form>
</body>

</html>

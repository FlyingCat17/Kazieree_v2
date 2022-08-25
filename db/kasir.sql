-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 25, 2022 at 08:44 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kasir`
--

-- --------------------------------------------------------

--
-- Table structure for table `beli`
--

CREATE TABLE `beli` (
  `kode_transaksi` varchar(30) NOT NULL,
  `tgl_transaksi` datetime NOT NULL,
  `id_pengguna` varchar(10) NOT NULL,
  `id_pemasok` varchar(10) NOT NULL,
  `total_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cashbox`
--

CREATE TABLE `cashbox` (
  `id_cashbox` int(11) NOT NULL,
  `nama_cashbox` varchar(20) NOT NULL,
  `jumlah_saldo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cashbox`
--

INSERT INTO `cashbox` (`id_cashbox`, `nama_cashbox`, `jumlah_saldo`) VALUES
(1, 'Default', 281500);

-- --------------------------------------------------------

--
-- Table structure for table `detail_beli`
--

CREATE TABLE `detail_beli` (
  `kode_transaksi` varchar(20) NOT NULL,
  `kode_produk` varchar(45) NOT NULL,
  `nama_produk` varchar(80) NOT NULL,
  `harga_beli` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `detail_jual`
--

CREATE TABLE `detail_jual` (
  `kode_transaksi` varchar(30) NOT NULL,
  `kode_produk` varchar(45) NOT NULL,
  `nama_produk` varchar(80) NOT NULL,
  `harga_jual` varchar(11) NOT NULL,
  `qty` varchar(11) NOT NULL,
  `total_harga` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_jual`
--

INSERT INTO `detail_jual` (`kode_transaksi`, `kode_produk`, `nama_produk`, `harga_jual`, `qty`, `total_harga`) VALUES
('TJ/20220825/000001', '8998899995113', 'Baygon 0,3AE Flower Garden 200ml', '12000', '11', '132000'),
('TJ/20220825/000002', '8992752011408', 'Vit Air Mineral', '3500', '3', '10500'),
('TJ/20220825/000002', '8998866613736', 'Emeron Lovely Naturals Hand Body Lotion', '20000', '2', '40000'),
('TJ/20220825/000002', '8998899995113', 'Baygon 0,3AE Flower Garden 200ml', '12000', '2', '24000'),
('TJ/20220825/000003', '8998866613736', 'Emeron Lovely Naturals Hand Body Lotion', '20000', '2', '40000'),
('TJ/20220825/000003', 'JASA002', 'Jasa Pemasangan', '15000', '1', '15000');

-- --------------------------------------------------------

--
-- Table structure for table `detail_pengguna`
--

CREATE TABLE `detail_pengguna` (
  `id_pengguna` varchar(10) NOT NULL,
  `nama_lengkap` varchar(80) NOT NULL,
  `jenis_kelamin` char(2) NOT NULL,
  `no_telepon` varchar(13) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_pengguna`
--

INSERT INTO `detail_pengguna` (`id_pengguna`, `nama_lengkap`, `jenis_kelamin`, `no_telepon`, `alamat`) VALUES
('A00001', 'Fathan Maulana Rifqi Hartono', 'L', '085604982258', 'Gg. Pratama no. 30, Kec. Klabang, Kab. Bondowoso');

-- --------------------------------------------------------

--
-- Table structure for table `jual`
--

CREATE TABLE `jual` (
  `kode_transaksi` varchar(30) NOT NULL,
  `tgl_transaksi` datetime NOT NULL,
  `id_pengguna` varchar(10) NOT NULL,
  `id_cashbox` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL,
  `nominal_bayar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jual`
--

INSERT INTO `jual` (`kode_transaksi`, `tgl_transaksi`, `id_pengguna`, `id_cashbox`, `total_harga`, `nominal_bayar`) VALUES
('TJ/20220820/000001', '2022-08-20 00:00:00', 'K0019', 1, 20000, 30000),
('TJ/20220823/000001', '2022-08-23 00:00:00', 'K0019', 1, 20000, 20000),
('TJ/20220825/000001', '2022-08-25 13:11:51', 'A00001', 1, 132000, 140000),
('TJ/20220825/000002', '2022-08-25 13:18:09', 'A00001', 1, 74500, 75000),
('TJ/20220825/000003', '2022-08-25 13:38:13', 'A00001', 1, 55000, 60000);

--
-- Triggers `jual`
--
DELIMITER $$
CREATE TRIGGER `saldo_in` AFTER INSERT ON `jual` FOR EACH ROW BEGIN
	UPDATE cashbox SET cashbox.jumlah_saldo = cashbox.jumlah_saldo + NEW.total_harga
    WHERE cashbox.id_cashbox = NEW.id_cashbox;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` int(11) NOT NULL,
  `nama_kategori` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`) VALUES
(1, 'Barang'),
(2, 'Jasa');

-- --------------------------------------------------------

--
-- Table structure for table `log_pengguna`
--

CREATE TABLE `log_pengguna` (
  `no_log` int(11) NOT NULL,
  `id_pengguna` varchar(10) NOT NULL,
  `nama_pengguna` varchar(60) NOT NULL,
  `role` varchar(12) NOT NULL,
  `stamp` datetime NOT NULL,
  `tipe` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `log_pengguna`
--

INSERT INTO `log_pengguna` (`no_log`, `id_pengguna`, `nama_pengguna`, `role`, `stamp`, `tipe`) VALUES
(1, 'A00001', 'fthnmrh', 'admin', '2022-08-21 06:06:37', 'Masuk'),
(2, 'A00001', 'fthnmrh', 'admin', '2022-08-21 06:06:56', 'Keluar'),
(3, 'A00001', 'fthnmrh', 'admin', '2022-08-21 08:02:16', 'Masuk'),
(4, 'A00001', 'fthnmrh', 'admin', '2022-08-21 08:02:19', 'Keluar'),
(5, 'A00001', 'fthnmrh', 'admin', '2022-08-21 08:02:26', 'Masuk'),
(6, 'A00001', 'fthnmrh', 'admin', '2022-08-21 08:02:46', 'Keluar'),
(7, 'A00001', 'fthnmrh', 'admin', '2022-08-21 08:20:11', 'Masuk'),
(8, 'A00001', 'fthnmrh', 'admin', '2022-08-21 09:14:37', 'Masuk'),
(9, 'A00001', 'fthnmrh', 'admin', '2022-08-21 09:15:31', 'Masuk'),
(10, 'A00001', 'fthnmrh', 'admin', '2022-08-21 09:17:07', 'Keluar'),
(11, 'A00001', 'fthnmrh', 'admin', '2022-08-21 10:20:04', 'Masuk'),
(12, 'A00001', 'fthnmrh', 'admin', '2022-08-21 10:21:44', 'Keluar'),
(13, 'A00001', 'fthnmrh', 'admin', '2022-08-21 10:44:12', 'Masuk'),
(14, 'A00001', 'fthnmrh', 'admin', '2022-08-21 10:44:24', 'Keluar'),
(15, 'A00001', 'fthnmrh', 'admin', '2022-08-21 10:44:29', 'Masuk'),
(16, 'A00001', 'fthnmrh', 'admin', '2022-08-21 10:45:14', 'Masuk'),
(17, 'A00001', 'fthnmrh', 'admin', '2022-08-21 10:46:14', 'Masuk'),
(18, 'A00001', 'fthnmrh', 'admin', '2022-08-21 10:46:33', 'Keluar'),
(19, 'A00001', 'fthnmrh', 'admin', '2022-08-21 11:09:42', 'Masuk'),
(20, 'A00001', 'fthnmrh', 'admin', '2022-08-21 11:10:52', 'Masuk'),
(21, 'A00001', 'fthnmrh', 'admin', '2022-08-21 11:12:14', 'Masuk'),
(22, 'A00001', 'fthnmrh', 'admin', '2022-08-21 11:13:47', 'Keluar'),
(23, 'A00001', 'fthnmrh', 'admin', '2022-08-22 12:02:47', 'Masuk'),
(24, 'A00001', 'fthnmrh', 'admin', '2022-08-22 08:07:20', 'Masuk'),
(25, 'A00001', 'fthnmrh', 'admin', '2022-08-22 08:07:36', 'Keluar'),
(26, 'A00001', 'fthnmrh', 'admin', '2022-08-22 08:18:55', 'Masuk'),
(27, 'A00001', 'fthnmrh', 'admin', '2022-08-22 08:22:57', 'Masuk'),
(28, 'A00001', 'fthnmrh', 'admin', '2022-08-22 08:27:44', 'Masuk'),
(29, 'A00001', 'fthnmrh', 'admin', '2022-08-22 08:43:17', 'Masuk'),
(30, 'A00001', 'fthnmrh', 'admin', '2022-08-22 08:44:22', 'Masuk'),
(31, 'A00001', 'fthnmrh', 'admin', '2022-08-22 08:45:23', 'Masuk'),
(32, 'A00001', 'fthnmrh', 'admin', '2022-08-22 08:45:49', 'Keluar'),
(33, 'A00001', 'fthnmrh', 'admin', '2022-08-22 08:51:37', 'Masuk'),
(34, 'A00001', 'fthnmrh', 'admin', '2022-08-22 08:53:12', 'Masuk'),
(35, 'A00001', 'fthnmrh', 'admin', '2022-08-22 09:06:03', 'Masuk'),
(36, 'A00001', 'fthnmrh', 'admin', '2022-08-22 09:09:32', 'Masuk'),
(37, 'A00001', 'fthnmrh', 'admin', '2022-08-22 09:35:35', 'Masuk'),
(38, 'A00001', 'fthnmrh', 'admin', '2022-08-22 09:37:39', 'Keluar'),
(39, 'A00001', 'fthnmrh', 'admin', '2022-08-22 10:51:25', 'Masuk'),
(40, 'A00001', 'fthnmrh', 'admin', '2022-08-22 11:00:43', 'Masuk'),
(41, 'A00001', 'fthnmrh', 'admin', '2022-08-22 11:03:18', 'Masuk'),
(42, 'A00001', 'fthnmrh', 'admin', '2022-08-22 11:05:33', 'Keluar'),
(43, 'A00001', 'fthnmrh', 'admin', '2022-08-22 11:43:29', 'Masuk'),
(44, 'A00001', 'fthnmrh', 'admin', '2022-08-22 01:38:04', 'Masuk'),
(45, 'A00001', 'fthnmrh', 'admin', '2022-08-22 01:38:39', 'Keluar'),
(46, 'A00001', 'fthnmrh', 'admin', '2022-08-22 01:39:53', 'Masuk'),
(47, 'A00001', 'fthnmrh', 'admin', '2022-08-22 02:06:27', 'Masuk'),
(48, 'A00001', 'fthnmrh', 'admin', '2022-08-22 02:07:17', 'Masuk'),
(49, 'A00001', 'fthnmrh', 'admin', '2022-08-22 02:08:21', 'Masuk'),
(50, 'A00001', 'fthnmrh', 'admin', '2022-08-22 02:16:26', 'Masuk'),
(51, 'A00001', 'fthnmrh', 'admin', '2022-08-22 02:18:47', 'Masuk'),
(52, 'A00001', 'fthnmrh', 'admin', '2022-08-22 02:24:28', 'Masuk'),
(53, 'A00001', 'fthnmrh', 'admin', '2022-08-22 02:31:22', 'Masuk'),
(54, 'A00001', 'fthnmrh', 'admin', '2022-08-23 07:27:02', 'Masuk'),
(55, 'A00001', 'fthnmrh', 'admin', '2022-08-23 07:27:17', 'Keluar'),
(56, 'A00001', 'fthnmrh', 'admin', '2022-08-24 12:24:02', 'Masuk'),
(57, 'A00001', 'fthnmrh', 'admin', '2022-08-25 11:25:15', 'Masuk'),
(58, 'A00001', 'fthnmrh', 'admin', '2022-08-25 12:01:21', 'Masuk'),
(59, 'A00001', 'fthnmrh', 'admin', '2022-08-25 12:22:41', 'Masuk'),
(60, 'A00001', 'fthnmrh', 'admin', '2022-08-25 12:24:47', 'Masuk'),
(61, 'A00001', 'fthnmrh', 'admin', '2022-08-25 12:25:59', 'Masuk'),
(62, 'A00001', 'fthnmrh', 'admin', '2022-08-25 12:29:13', 'Keluar'),
(63, 'A00001', 'fthnmrh', 'admin', '2022-08-25 01:10:24', 'Masuk'),
(64, 'A00001', 'fthnmrh', 'admin', '2022-08-25 01:11:43', 'Masuk'),
(65, 'A00001', 'fthnmrh', 'admin', '2022-08-25 01:13:50', 'Masuk'),
(66, 'A00001', 'fthnmrh', 'admin', '2022-08-25 01:24:54', 'Masuk'),
(67, 'A00001', 'fthnmrh', 'admin', '2022-08-25 01:25:10', 'Keluar'),
(68, 'A00001', 'fthnmrh', 'admin', '2022-08-25 01:32:26', 'Masuk'),
(69, 'A00001', 'fthnmrh', 'admin', '2022-08-25 01:33:52', 'Masuk'),
(70, 'A00001', 'fthnmrh', 'admin', '2022-08-25 01:37:20', 'Masuk');

-- --------------------------------------------------------

--
-- Table structure for table `pemasok`
--

CREATE TABLE `pemasok` (
  `kode_pemasok` varchar(10) NOT NULL,
  `nama_pemasok` varchar(80) NOT NULL,
  `nama_usaha` varchar(50) NOT NULL,
  `no_telepon` varchar(13) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pemasok`
--

INSERT INTO `pemasok` (`kode_pemasok`, `nama_pemasok`, `nama_usaha`, `no_telepon`, `alamat`) VALUES
('P00001', 'Ahmad Ali', 'Toko Berkah Permai', '08192889211', 'Jl. Raya Situbondo no.122, Kec. Tapen, Kab. Bondowoso'),
('P00002', 'Mustafa Samsudin', 'D`Kazieree', '081992819922', 'Jl. Kedondong no.20, Sukowono');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id_pengguna` varchar(10) NOT NULL,
  `nama_pengguna` varchar(60) NOT NULL,
  `role` varchar(12) NOT NULL,
  `kata_sandi` varchar(30) NOT NULL,
  `status` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id_pengguna`, `nama_pengguna`, `role`, `kata_sandi`, `status`) VALUES
('A00001', 'fthnmrh', 'admin', 'fathan', 'aktif');

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `kode_produk` varchar(45) NOT NULL,
  `nama_produk` varchar(80) NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `satuan` char(12) NOT NULL,
  `harga_beli` int(11) NOT NULL,
  `harga_jual` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`kode_produk`, `nama_produk`, `id_kategori`, `satuan`, `harga_beli`, `harga_jual`) VALUES
('8992752011408', 'Vit Air Mineral', 1, 'pcs', 3000, 3500),
('8995858192620', 'MIXAGRIP Flu & Batuk', 1, 'strip', 500, 1000),
('8996006142511', 'Teh Botol Original 250ml', 1, 'pcs', 2000, 3300),
('8998866613736', 'Emeron Lovely Naturals Hand Body Lotion', 1, 'pcs', 15000, 20000),
('8998899995113', 'Baygon 0,3AE Flower Garden 200ml', 1, 'pcs', 10000, 12000),
('JASA001', 'Jasa Ongkir Kirim', 2, 'Jasa', 0, 21000),
('JASA002', 'Jasa Pemasangan', 2, 'Jasa', 0, 15000);

-- --------------------------------------------------------

--
-- Table structure for table `stok`
--

CREATE TABLE `stok` (
  `kode_produk` varchar(45) NOT NULL,
  `jumlah_stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stok`
--

INSERT INTO `stok` (`kode_produk`, `jumlah_stok`) VALUES
('8998899995113', 18),
('8996006142511', 10),
('8995858192620', 0),
('8992752011408', 7),
('8998866613736', 6);

-- --------------------------------------------------------

--
-- Table structure for table `temp_beli`
--

CREATE TABLE `temp_beli` (
  `kode_produk` varchar(45) NOT NULL,
  `nama_produk` varchar(80) NOT NULL,
  `qty` int(11) NOT NULL,
  `harga_jual` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Triggers `temp_beli`
--
DELIMITER $$
CREATE TRIGGER `stok_editbeli` AFTER UPDATE ON `temp_beli` FOR EACH ROW BEGIN
	UPDATE stok SET stok.jumlah_stok = stok.jumlah_stok + NEW.qty
    WHERE stok.kode_produk = NEW.kode_produk;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `stok_gagalbeli` AFTER DELETE ON `temp_beli` FOR EACH ROW BEGIN
	UPDATE stok SET stok.jumlah_stok = stok.jumlah_stok - OLD.qty
    WHERE stok.kode_produk = OLD.kode_produk;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `stok_masuk` AFTER INSERT ON `temp_beli` FOR EACH ROW BEGIN
	UPDATE stok SET stok.jumlah_stok = stok.jumlah_stok + NEW.qty
    WHERE stok.kode_produk = NEW.kode_produk;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `temp_jual`
--

CREATE TABLE `temp_jual` (
  `kode_produk` varchar(45) NOT NULL,
  `nama_produk` varchar(80) NOT NULL,
  `qty` int(11) NOT NULL,
  `harga_jual` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Triggers `temp_jual`
--
DELIMITER $$
CREATE TRIGGER `stok_gagal` AFTER DELETE ON `temp_jual` FOR EACH ROW BEGIN
	UPDATE stok SET stok.jumlah_stok = stok.jumlah_stok + OLD.qty
    WHERE stok.kode_produk = OLD.kode_produk;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `beli`
--
ALTER TABLE `beli`
  ADD PRIMARY KEY (`kode_transaksi`);

--
-- Indexes for table `cashbox`
--
ALTER TABLE `cashbox`
  ADD PRIMARY KEY (`id_cashbox`);

--
-- Indexes for table `detail_jual`
--
ALTER TABLE `detail_jual`
  ADD KEY `kode_transaksi` (`kode_transaksi`);

--
-- Indexes for table `detail_pengguna`
--
ALTER TABLE `detail_pengguna`
  ADD KEY `detail_pengguna` (`id_pengguna`);

--
-- Indexes for table `jual`
--
ALTER TABLE `jual`
  ADD PRIMARY KEY (`kode_transaksi`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `log_pengguna`
--
ALTER TABLE `log_pengguna`
  ADD PRIMARY KEY (`no_log`);

--
-- Indexes for table `pemasok`
--
ALTER TABLE `pemasok`
  ADD PRIMARY KEY (`kode_pemasok`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id_pengguna`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`kode_produk`),
  ADD KEY `kategori` (`id_kategori`);

--
-- Indexes for table `stok`
--
ALTER TABLE `stok`
  ADD KEY `jumlah_stok` (`kode_produk`);

--
-- Indexes for table `temp_beli`
--
ALTER TABLE `temp_beli`
  ADD UNIQUE KEY `kode_produk` (`kode_produk`);

--
-- Indexes for table `temp_jual`
--
ALTER TABLE `temp_jual`
  ADD UNIQUE KEY `kode_produk` (`kode_produk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cashbox`
--
ALTER TABLE `cashbox`
  MODIFY `id_cashbox` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
  MODIFY `id_kategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `log_pengguna`
--
ALTER TABLE `log_pengguna`
  MODIFY `no_log` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_jual`
--
ALTER TABLE `detail_jual`
  ADD CONSTRAINT `kode_transaksi` FOREIGN KEY (`kode_transaksi`) REFERENCES `jual` (`kode_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `detail_pengguna`
--
ALTER TABLE `detail_pengguna`
  ADD CONSTRAINT `detail_pengguna` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `produk`
--
ALTER TABLE `produk`
  ADD CONSTRAINT `kategori` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `stok`
--
ALTER TABLE `stok`
  ADD CONSTRAINT `jumlah_stok` FOREIGN KEY (`kode_produk`) REFERENCES `produk` (`kode_produk`) ON DELETE CASCADE ON UPDATE CASCADE;

DELIMITER $$
--
-- Events
--
$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

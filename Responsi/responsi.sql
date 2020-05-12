-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 12, 2020 at 07:34 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo_responsi`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_pegawai` int(11) NOT NULL,
  `nama_a` varchar(20) NOT NULL,
  `alamat_a` varchar(255) NOT NULL,
  `hp_a` varchar(20) NOT NULL,
  `posisi_a` varchar(20) NOT NULL,
  `gaji_a` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_pegawai`, `nama_a`, `alamat_a`, `hp_a`, `posisi_a`, `gaji_a`) VALUES
(144, 'Ccanni', 'Jakal', '08987654321', 'Diretor', 159900);

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` int(11) NOT NULL,
  `nama_p` varchar(20) NOT NULL,
  `posisi_p` varchar(20) NOT NULL,
  `alamat_p` varchar(255) NOT NULL,
  `hp_p` varchar(20) NOT NULL,
  `gaji_p` int(11) NOT NULL,
  `jam` int(11) NOT NULL,
  `tunjangan` int(11) NOT NULL,
  `pajak` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama_p`, `posisi_p`, `alamat_p`, `hp_p`, `gaji_p`, `jam`, `tunjangan`, `pajak`, `total`) VALUES
(105, 'Canni', 'Diretor', 'Kaliurang', '0812345678', 10000, 40, 600000, 100, 609900),
(111, 'YASS', 'Supervisor', 'Rumah', '089999999', 50000, 50, 750000, 500, 799500),
(123, 'John', 'Programmer', 'Jalan', '081111111', 1000, 10, 150000, 10, 150990),
(144, 'Ccanni', 'Diretor', 'Jakal', '08987654321', 10000, 10, 150000, 100, 159900);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

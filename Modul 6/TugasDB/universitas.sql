-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 09, 2024 at 03:04 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `universitas`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `AddressID` int(5) NOT NULL,
  `Kota` varchar(50) NOT NULL,
  `Jalan` varchar(30) NOT NULL,
  `No_Rumah` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `CourseID` int(5) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Code` varchar(50) NOT NULL,
  `DepartmentID` int(5) NOT NULL,
  `StudentID` int(5) NOT NULL,
  `FacultyID` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `DepartmentID` int(5) NOT NULL,
  `Nama` varchar(30) NOT NULL,
  `StudentID` int(5) NOT NULL,
  `FacultyID` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `FacultyID` int(5) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Gender` char(1) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `Designation` varchar(30) NOT NULL,
  `CourseID` int(5) NOT NULL,
  `Grade` varchar(10) NOT NULL,
  `Salary` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `researchproject`
--

CREATE TABLE `researchproject` (
  `ProjectID` int(5) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Area` varchar(30) NOT NULL,
  `Duration` int(11) NOT NULL,
  `FacultyID` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `StudentID` int(5) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `Gender` char(1) NOT NULL,
  `PhoneNumber` varchar(30) NOT NULL,
  `AddressID` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`AddressID`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`CourseID`),
  ADD KEY `DepartmentID` (`DepartmentID`),
  ADD KEY `FacultyID` (`FacultyID`),
  ADD KEY `StudentID` (`StudentID`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`DepartmentID`),
  ADD KEY `StudentID` (`StudentID`),
  ADD KEY `FacultyID` (`FacultyID`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`FacultyID`),
  ADD KEY `CourseID` (`CourseID`);

--
-- Indexes for table `researchproject`
--
ALTER TABLE `researchproject`
  ADD PRIMARY KEY (`ProjectID`),
  ADD KEY `FacultyID` (`FacultyID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`StudentID`),
  ADD KEY `AddressID` (`AddressID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `AddressID` int(5) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`DepartmentID`) REFERENCES `department` (`DepartmentID`),
  ADD CONSTRAINT `course_ibfk_2` FOREIGN KEY (`FacultyID`) REFERENCES `faculty` (`FacultyID`),
  ADD CONSTRAINT `course_ibfk_3` FOREIGN KEY (`StudentID`) REFERENCES `student` (`StudentID`);

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `department_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `student` (`StudentID`),
  ADD CONSTRAINT `department_ibfk_2` FOREIGN KEY (`FacultyID`) REFERENCES `faculty` (`FacultyID`);

--
-- Constraints for table `faculty`
--
ALTER TABLE `faculty`
  ADD CONSTRAINT `faculty_ibfk_1` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`);

--
-- Constraints for table `researchproject`
--
ALTER TABLE `researchproject`
  ADD CONSTRAINT `researchproject_ibfk_1` FOREIGN KEY (`FacultyID`) REFERENCES `faculty` (`FacultyID`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`AddressID`) REFERENCES `address` (`AddressID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

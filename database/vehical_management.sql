-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 25, 2018 at 07:20 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vehical_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `available_drivers`
--

CREATE TABLE `available_drivers` (
  `driver_id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `vehical_no` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `available_drivers`
--

INSERT INTO `available_drivers` (`driver_id`, `name`, `vehical_no`) VALUES
(8456985, 'dinesh', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `available_vehicals`
--

CREATE TABLE `available_vehicals` (
  `vehical_no` varchar(8) NOT NULL,
  `driver_name` varchar(50) DEFAULT NULL,
  `meter_reading` int(10) DEFAULT NULL,
  `arriving_time` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `available_vehicals`
--

INSERT INTO `available_vehicals` (`vehical_no`, `driver_name`, `meter_reading`, `arriving_time`) VALUES
('abd-3695', 'Ranjith', 115, '2018-02-08 15:26:09.000000'),
('kd-7346', 'Ranjith', 212112, '2016-09-21 22:19:09.000000'),
('ko-7264', 'sunil', 4141521, '2016-11-08 21:34:09.000000');

-- --------------------------------------------------------

--
-- Table structure for table `departing_drivers`
--

CREATE TABLE `departing_drivers` (
  `driver_id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `vehical_no` varchar(10) NOT NULL,
  `phone_no` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departing_drivers`
--

INSERT INTO `departing_drivers` (`driver_id`, `name`, `vehical_no`, `phone_no`) VALUES
('45236578', 'Ranjith', 'ko-7264', NULL),
('631660460', 'sunil', 'vo-4785', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `departing_vehicals`
--

CREATE TABLE `departing_vehicals` (
  `vehical_no` varchar(10) NOT NULL,
  `driver_name` varchar(20) NOT NULL,
  `meter_reading` int(20) NOT NULL,
  `purpose` text NOT NULL,
  `received_by` varchar(30) NOT NULL,
  `departure_time` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departing_vehicals`
--

INSERT INTO `departing_vehicals` (`vehical_no`, `driver_name`, `meter_reading`, `purpose`, `received_by`, `departure_time`) VALUES
('vo-4785', 'sunil', 4541, 'hjhj', 'hjhjk', '2016-11-08 21:33:48.000000');

-- --------------------------------------------------------

--
-- Table structure for table `driver_details`
--

CREATE TABLE `driver_details` (
  `driver_id` int(10) NOT NULL,
  `driver_name` varchar(50) NOT NULL,
  `phone` int(10) NOT NULL,
  `age` int(3) NOT NULL,
  `address` varchar(100) NOT NULL,
  `registered_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driver_details`
--

INSERT INTO `driver_details` (`driver_id`, `driver_name`, `phone`, `age`, `address`, `registered_date`) VALUES
(8456985, 'dinesh', 776955612, 32, 'dfdgdfd', '2016-09-07'),
(45236578, 'Ranjith', 1212121212, 29, 'bdsfhytj', '2016-09-07'),
(631660460, 'sunil', 779622152, 52, 'gfjngjhghdsfg', '2016-09-07');

-- --------------------------------------------------------

--
-- Table structure for table `trip_details`
--

CREATE TABLE `trip_details` (
  `vehical_no` int(10) NOT NULL,
  `driver_name` varchar(30) NOT NULL,
  `driver_id` int(10) NOT NULL,
  `departure_meter_reading` int(10) NOT NULL,
  `arrival_meter_reading` int(10) NOT NULL,
  `departure_time` datetime(6) NOT NULL,
  `arrival_time` datetime(6) NOT NULL,
  `trip_distance` int(5) NOT NULL,
  `recieved_by` varchar(50) NOT NULL,
  `trip_purpose` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `vehical_details`
--

CREATE TABLE `vehical_details` (
  `vehical_no` varchar(10) NOT NULL,
  `vehical_type` varchar(20) NOT NULL,
  `no_of_seats` int(4) NOT NULL,
  `fual_type` varchar(10) NOT NULL,
  `odo_meter` int(15) NOT NULL,
  `manufactured_year` int(4) NOT NULL,
  `registered_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehical_details`
--

INSERT INTO `vehical_details` (`vehical_no`, `vehical_type`, `no_of_seats`, `fual_type`, `odo_meter`, `manufactured_year`, `registered_date`) VALUES
('abd-3695', 'Three wheeler', 4, 'Petrol', 7000, 2015, '2016-09-07'),
('kd-7346', 'Car', 5, 'Petrol', 143000, 2002, '2016-08-29'),
('vo-4785', 'Motor Bike', 2, 'Petrol', 28350, 2010, '2016-09-07');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `available_drivers`
--
ALTER TABLE `available_drivers`
  ADD PRIMARY KEY (`driver_id`);

--
-- Indexes for table `available_vehicals`
--
ALTER TABLE `available_vehicals`
  ADD PRIMARY KEY (`vehical_no`);

--
-- Indexes for table `departing_drivers`
--
ALTER TABLE `departing_drivers`
  ADD PRIMARY KEY (`driver_id`);

--
-- Indexes for table `departing_vehicals`
--
ALTER TABLE `departing_vehicals`
  ADD PRIMARY KEY (`vehical_no`);

--
-- Indexes for table `driver_details`
--
ALTER TABLE `driver_details`
  ADD PRIMARY KEY (`driver_id`);

--
-- Indexes for table `trip_details`
--
ALTER TABLE `trip_details`
  ADD PRIMARY KEY (`vehical_no`);

--
-- Indexes for table `vehical_details`
--
ALTER TABLE `vehical_details`
  ADD PRIMARY KEY (`vehical_no`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

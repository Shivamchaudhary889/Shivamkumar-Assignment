-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 09, 2019 at 01:06 PM
-- Server version: 5.1.33
-- PHP Version: 5.2.9-2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `orphan`
--
CREATE DATABASE `orphan` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `orphan`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `uname` varchar(20) NOT NULL,
  `pword` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`uname`, `pword`) VALUES
('admin', 'password');

-- --------------------------------------------------------

--
-- Table structure for table `adoption`
--

CREATE TABLE IF NOT EXISTS `adoption` (
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adoption`
--

INSERT INTO `adoption` (`email`, `password`) VALUES
('imran@gmail.com', 'password'),
('deepak@desai.com', 'akshi'),
('sharat@imran.com', 'akshi'),
('sdfs@g.com', 'slooo');

-- --------------------------------------------------------

--
-- Table structure for table `pay`
--

CREATE TABLE IF NOT EXISTS `pay` (
  `cno` int(20) NOT NULL,
  `expries` date NOT NULL,
  `cvv` int(3) NOT NULL,
  `amount` int(255) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `state` varchar(100) NOT NULL,
  `postcode` int(10) NOT NULL,
  `pno` int(12) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pay`
--

INSERT INTO `pay` (`cno`, `expries`, `cvv`, `amount`, `fname`, `lname`, `address`, `country`, `state`, `postcode`, `pno`, `email`) VALUES
(2147483647, '2012-08-09', 566, 0, 'saf', 'sdf', 'sdf', 'sdf', 'sdf', 65546, 65846846, 'sdf@g.com');

-- --------------------------------------------------------

--
-- Table structure for table `pro1_vol`
--

CREATE TABLE IF NOT EXISTS `pro1_vol` (
  `vname` varchar(255) NOT NULL,
  `phone` int(12) NOT NULL,
  `nod` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pro1_vol`
--


-- --------------------------------------------------------

--
-- Table structure for table `pro1_vol_fin`
--

CREATE TABLE IF NOT EXISTS `pro1_vol_fin` (
  `cno` int(20) NOT NULL,
  `expries` date NOT NULL,
  `cvv` int(3) NOT NULL,
  `amount` int(255) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `country` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `postcode` int(10) NOT NULL,
  `pno` int(12) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pro1_vol_fin`
--


-- --------------------------------------------------------

--
-- Table structure for table `pro2_vol`
--

CREATE TABLE IF NOT EXISTS `pro2_vol` (
  `vname` varchar(255) NOT NULL,
  `phone` int(12) NOT NULL,
  `nod` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pro2_vol`
--


-- --------------------------------------------------------

--
-- Table structure for table `pro2_vol_fin`
--

CREATE TABLE IF NOT EXISTS `pro2_vol_fin` (
  `cno` int(20) NOT NULL,
  `expries` date NOT NULL,
  `cvv` int(3) NOT NULL,
  `amount` int(255) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `country` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `postcode` int(10) NOT NULL,
  `pno` int(12) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pro2_vol_fin`
--


-- --------------------------------------------------------

--
-- Table structure for table `reg`
--

CREATE TABLE IF NOT EXISTS `reg` (
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `mfname` varchar(50) NOT NULL,
  `mlname` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` int(12) NOT NULL,
  `country` varchar(50) NOT NULL,
  `city` varchar(100) NOT NULL,
  `fage` int(2) NOT NULL,
  `mage` int(2) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reg`
--

INSERT INTO `reg` (`fname`, `lname`, `mfname`, `mlname`, `email`, `phone`, `country`, `city`, `fage`, `mage`, `password`) VALUES
('Deepak', 'Desai', 'Shilpa', 'Desai', 'deepak@desai.com', 2147483647, 'india', 'Dharwad', 52, 55, 'akshi'),
('Sharat', 'Janageri', 'Amruta', 'Janager', 'sharat@imran.com', 2147483647, 'India', 'Dharwad', 25, 22, 'akshi');

-- --------------------------------------------------------

--
-- Table structure for table `reg_vol`
--

CREATE TABLE IF NOT EXISTS `reg_vol` (
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `nation` varchar(100) NOT NULL,
  `work` varchar(255) NOT NULL,
  `age` int(2) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reg_vol`
--


-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 23, 2015 at 02:42 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sims`
--
CREATE DATABASE IF NOT EXISTS `sims` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `sims`;

-- --------------------------------------------------------

--
-- Table structure for table `alogin`
--

CREATE TABLE IF NOT EXISTS `alogin` (
  `name` varchar(40) NOT NULL,
  `pass` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alogin`
--

INSERT INTO `alogin` (`name`, `pass`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `assignment`
--

CREATE TABLE IF NOT EXISTS `assignment` (
  `courseid` varchar(5) NOT NULL,
  `professor` varchar(50) NOT NULL,
  `batch` varchar(4) NOT NULL,
  `details` text NOT NULL,
  `deadline` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assignment`
--

INSERT INTO `assignment` (`courseid`, `professor`, `batch`, `details`, `deadline`) VALUES
('CS241', 'Ramesh Kumar Mohapatra', '2012', 'exercise 2.1,2.2 .\r\nsubmit the soft copy to rkm@nitrkl.ac.in.', '2015-04-15'),
('cs241', 'Ramesh Kumar Mohapatra', '2012', 'submit your class notebook in my office', '2015-04-17'),
('cs342', 'Ramesh Kumar Mohapatra', '2012', 'wap to implement avl tree.\r\nsend softcopy to turuk@gmail.com', '2015-04-14');

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE IF NOT EXISTS `attendance` (
  `sid` varchar(9) NOT NULL,
  `batch` varchar(4) NOT NULL,
  `cid` varchar(5) NOT NULL,
  `TP` int(11) NOT NULL,
  `TA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`sid`, `batch`, `cid`, `TP`, `TA`) VALUES
('112cs0144', '2012', 'cs441', 20, 3),
('112cs0144', '2012', 'cs343', 18, 1),
('112cs0144', '2012', 'cs341', 20, 4),
('112cs0454', '2012', 'cs343', 20, 2),
('111cs0122', '2011', 'cs441', 15, 6),
('112cs0454', '2012', 'cs241', 6, 3),
('112cs0144', '2012', 'cs241', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `cid` varchar(5) NOT NULL,
  `cname` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`cid`, `cname`) VALUES
('cs441', 'Database Management Systems'),
('cs241', 'Theory of Computation'),
('cs242', 'Computer Organisation and Architecture'),
('cs341', 'Principles of Programming Languages'),
('cs342', 'Data Structures and Algorithm'),
('cs343', 'System Software Engineering'),
('cs344', 'Algorithm Analysis and Design');

-- --------------------------------------------------------

--
-- Table structure for table `facad`
--

CREATE TABLE IF NOT EXISTS `facad` (
  `prof` varchar(50) NOT NULL,
  `branch` varchar(50) NOT NULL,
  `batch` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `facad`
--

INSERT INTO `facad` (`prof`, `branch`, `batch`) VALUES
('Ramesh Kumar Mohapatra', 'Computer Science and Engineering', '2012');

-- --------------------------------------------------------

--
-- Table structure for table `feepayment`
--

CREATE TABLE IF NOT EXISTS `feepayment` (
  `sid` varchar(9) NOT NULL,
  `amount` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feepayment`
--

INSERT INTO `feepayment` (`sid`, `amount`) VALUES
('112cs0144', '44000');

-- --------------------------------------------------------

--
-- Table structure for table `grade`
--

CREATE TABLE IF NOT EXISTS `grade` (
  `sid` varchar(9) NOT NULL,
  `cid` varchar(5) NOT NULL,
  `grade` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grade`
--

INSERT INTO `grade` (`sid`, `cid`, `grade`) VALUES
('112cs0144', 'cs441', 'A'),
('112cs0454', 'cs343', 'A'),
('112cs0144', 'cs341', 'B'),
('112cs0454', 'cs341', 'P'),
('112cs0144', 'cs343', 'B'),
('112cs0454', 'cs441', 'C'),
('112cs0454', 'cs241', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `personaldetails`
--

CREATE TABLE IF NOT EXISTS `personaldetails` (
  `name` varchar(50) NOT NULL,
  `roll` varchar(9) NOT NULL,
  `branch` varchar(40) NOT NULL,
  `batch` varchar(4) NOT NULL,
  `semester` int(11) NOT NULL,
  `room` varchar(10) NOT NULL,
  `hostel` varchar(50) NOT NULL,
  `mob` varchar(10) NOT NULL,
  `father` varchar(50) NOT NULL,
  `mother` varchar(50) NOT NULL,
  `parent_mob` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personaldetails`
--

INSERT INTO `personaldetails` (`name`, `roll`, `branch`, `batch`, `semester`, `room`, `hostel`, `mob`, `father`, `mother`, `parent_mob`) VALUES
('Bhubanananda Chhatriya', '112cs0144', 'Computer Science and Engineering', '2012', 6, 'B-109', 'Dhirubhai Ambani Hall of Residence', '7381828134', 'pqrs', 'tuvw', '9776256878'),
('Anup Das', '112cs0454', 'Computer Science and Engineering', '2012', 6, 'B-107', 'Dhirubhai Ambani Hall of Residence', '4343434343', 'abcd', 'efgh', '4343434343'),
('Arjun Kumar Agrawal', '112cs0134', 'Computer Science and Engineering', '2012', 6, 'B-109', 'Dhirubhai Ambani Hall of Residence', '5565656656', 'zxcv', 'poiu', '4545454545');

-- --------------------------------------------------------

--
-- Table structure for table `plogin`
--

CREATE TABLE IF NOT EXISTS `plogin` (
  `name` varchar(50) NOT NULL,
  `pass` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `plogin`
--

INSERT INTO `plogin` (`name`, `pass`) VALUES
('Ramesh Kumar Mohapatra', 'mohapatra'),
('B.D. Sahoo', 'sahoo');

-- --------------------------------------------------------

--
-- Table structure for table `preregistration`
--

CREATE TABLE IF NOT EXISTS `preregistration` (
  `sid` varchar(9) NOT NULL,
  `name` varchar(50) NOT NULL,
  `batch` varchar(4) NOT NULL,
  `course1` varchar(5) NOT NULL,
  `course2` varchar(5) NOT NULL,
  `course3` varchar(5) NOT NULL,
  `course4` varchar(5) NOT NULL,
  `course5` varchar(5) NOT NULL,
  `course1name` varchar(50) NOT NULL,
  `course2name` varchar(50) NOT NULL,
  `course3name` varchar(50) NOT NULL,
  `course4name` varchar(50) NOT NULL,
  `course5name` varchar(50) NOT NULL,
  `prof1` varchar(40) NOT NULL,
  `prof2` varchar(40) NOT NULL,
  `prof3` varchar(40) NOT NULL,
  `prof4` varchar(40) NOT NULL,
  `prof5` varchar(40) NOT NULL,
  `advisor` varchar(50) NOT NULL,
  PRIMARY KEY (`sid`),
  UNIQUE KEY `sid` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `preregistration`
--

INSERT INTO `preregistration` (`sid`, `name`, `batch`, `course1`, `course2`, `course3`, `course4`, `course5`, `course1name`, `course2name`, `course3name`, `course4name`, `course5name`, `prof1`, `prof2`, `prof3`, `prof4`, `prof5`, `advisor`) VALUES
('112cs0144', 'Bhubanananda Chhatriya', '2012', 'cs241', 'cs242', 'cs341', 'cs342', 'cs343', ' Theory of Computation', ' Computer Organisation and Architecture', ' Principles of Programming Languages', ' DataStructures and Algorithms', ' Systems Software Engineering', 'Ramesh Kumar Mohapatra', 'B.D. Sahoo', 'Manmath Narayan Sahoo', 'Ashok Kumar Turuk', 'Pabitra Mohan Khiller', 'Ramesh Kumar Mohapatra');

-- --------------------------------------------------------

--
-- Table structure for table `professor`
--

CREATE TABLE IF NOT EXISTS `professor` (
  `name` varchar(50) NOT NULL,
  `course1` varchar(5) NOT NULL,
  `course2` varchar(5) NOT NULL,
  `course3` varchar(5) NOT NULL,
  `course4` varchar(5) NOT NULL,
  `course5` varchar(5) NOT NULL,
  `course1name` varchar(50) NOT NULL,
  `course2name` varchar(50) NOT NULL,
  `course3name` varchar(50) NOT NULL,
  `course4name` varchar(50) NOT NULL,
  `course5name` varchar(50) NOT NULL,
  `batch1` varchar(4) NOT NULL,
  `batch2` varchar(4) NOT NULL,
  `batch3` varchar(4) NOT NULL,
  `batch4` varchar(4) NOT NULL,
  `batch5` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `professor`
--

INSERT INTO `professor` (`name`, `course1`, `course2`, `course3`, `course4`, `course5`, `course1name`, `course2name`, `course3name`, `course4name`, `course5name`, `batch1`, `batch2`, `batch3`, `batch4`, `batch5`) VALUES
('Ramesh Kumar Mohapatra', 'cs241', 'cs241', 'cs342', 'cs342', 'cs241', 'Theory of Computation', 'Theory of Computation', 'Data Structure and Algorithm', 'Data Structure and Algorithm', 'Theory of Computation', '2012', '2013', '2014', '2013', '2014');

-- --------------------------------------------------------

--
-- Table structure for table `registration_courses`
--

CREATE TABLE IF NOT EXISTS `registration_courses` (
  `id` varchar(5) NOT NULL,
  `name` varchar(40) NOT NULL,
  `professor` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration_courses`
--

INSERT INTO `registration_courses` (`id`, `name`, `professor`) VALUES
('cs241', 'Theory of Computation', 'Ramesh Kumar Mohapatra'),
('cs242', 'Computer Organisation and Architecture', 'B.D. Sahoo'),
('cs341', 'Principles of Programming Languages', 'Manmath Narayan Sahoo'),
('cs342', 'DataStructures and Algorithms', 'Ashok Kumar Turuk'),
('cs343', 'Systems Software Engineering', 'Pabitra Mohan Khiller'),
('cs344', 'Algorithm Analysis and Design', 'B.D. Sahoo'),
('CS212', 'Microprocessor and Microcontrollers', 'Pabitra Mohan Khiller');

-- --------------------------------------------------------

--
-- Table structure for table `slogin`
--

CREATE TABLE IF NOT EXISTS `slogin` (
  `id` varchar(50) DEFAULT NULL,
  `pass` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `slogin`
--

INSERT INTO `slogin` (`id`, `pass`) VALUES
('112cs0144', 'qwerty'),
('112cs0454', 'anup21d');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `roll` varchar(9) NOT NULL,
  `name` varchar(50) NOT NULL,
  `batch` varchar(4) NOT NULL,
  `course1` varchar(5) NOT NULL,
  `course2` varchar(5) NOT NULL,
  `course3` varchar(5) NOT NULL,
  `course4` varchar(5) NOT NULL,
  `course5` varchar(5) NOT NULL,
  `prof1` varchar(40) NOT NULL,
  `prof2` varchar(40) NOT NULL,
  `prof3` varchar(40) NOT NULL,
  `prof4` varchar(40) NOT NULL,
  `prof5` varchar(40) NOT NULL,
  `course1name` varchar(50) NOT NULL,
  `course2name` varchar(50) NOT NULL,
  `course3name` varchar(50) NOT NULL,
  `course4name` varchar(50) NOT NULL,
  `course5name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`roll`, `name`, `batch`, `course1`, `course2`, `course3`, `course4`, `course5`, `prof1`, `prof2`, `prof3`, `prof4`, `prof5`, `course1name`, `course2name`, `course3name`, `course4name`, `course5name`) VALUES
('112cs0454', 'Anup Das', '2012', 'cs241', 'cs242', 'cs341', 'cs342', 'cs343', 'Ramesh Kumar Mohapatra', 'B.D. Sahoo', 'Manmath Narayan Sahoo', 'Ashok Kumar Turuk', 'Pabitra Mohan Khiller', ' Theory of Computation', ' Computer Organisation and Architecture', ' Principles of Programming Languages', ' DataStructures and Algorithms', ' Systems Software Engineering'),
('112cs0144', 'Bhubanananda Chhatriya', '2012', 'cs241', 'cs242', 'cs341', 'cs342', 'cs343', 'Ramesh Kumar Mohapatra', 'B.D. Sahoo', 'Manmath Narayan Sahoo', 'Ashok Kumar Turuk', 'Pabitra Mohan Khiller', ' Theory of Computation', ' Computer Organisation and Architecture', ' Principles of Programming Languages', ' DataStructures and Algorithms', ' Systems Software Engineering');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

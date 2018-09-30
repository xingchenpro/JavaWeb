CREATE TABLE `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
   ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `article` (
    `articleId` int(11) NOT NULL AUTO_INCREMENT,
    `articleName` varchar(255) DEFAULT NULL,
    `articleContent` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`articleId`)
   ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `author` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `authorName` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
   ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `book` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `bookName` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
   ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `public` (
    `authorId` int(11) NOT NULL ,
    `bookId` int(11) NOT NULL,
   PRIMARY KEY (`authorId`,`bookId`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `boss` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `employee` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `people` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `car` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `student` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `studentName` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `course` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `courseName` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `selectcourse` (
    `studentId` int(11) NOT NULL,
    `courseId` int(11) NOT NULL,
   PRIMARY KEY (`studentId`,`courseId`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `classes` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `teacher` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `teaching` (
    `teacherId` int(11) NOT NULL,
    `classesId` int(11) NOT NULL,
   PRIMARY KEY (`teacherId`,`classesId`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
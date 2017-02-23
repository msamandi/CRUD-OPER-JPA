USE jobmanager;

-- Drop table scripts

DROP TABLE IF EXISTS `quote`;


-- Create table scripts

CREATE TABLE `quote`
(
  id INT(6) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  description VARCHAR (1024),
);

DROP TABLE IF EXISTS updates;
DROP TABLE IF EXISTS error;
DROP TABLE IF EXISTS report;


CREATE  TABLE IF NOT EXISTS updates (
  id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  otype VARCHAR(255) NOT NULL ,
  oid VARCHAR(255) NOT NULL ,
  `date` DATETIME NOT NULL ,
  status ENUM('NEW', 'MODIFIED', 'DELETED') NOT NULL
);

CREATE TABLE report (
  id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `date` Date NOT NULL UNIQUE
);

CREATE TABLE error (
  id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  reportId int(11) DEFAULT NULL,
  billId varchar(45) NOT NULL,
  errorType enum('summary','title','action','sponsor','cosponsor') DEFAULT NULL,
  lbdc text,
  json text,
  KEY `report_id_idx` (reportId),
  FOREIGN KEY (reportId) REFERENCES report (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

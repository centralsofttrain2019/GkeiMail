CREATE TABLE `mailserver` (
  `ServerID` int(11) NOT NULL AUTO_INCREMENT,
  `SMTPServer` varchar(45) NOT NULL,
  `SMTPPort` int(11) NOT NULL,
  `POPServer` varchar(45) NOT NULL,
  `POPPort` int(11) NOT NULL,
  PRIMARY KEY (`ServerID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
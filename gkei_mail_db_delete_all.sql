set foreign_key_checks = 0;

TRUNCATE TABLE Keyword;
TRUNCATE TABLE Template;
TRUNCATE TABLE TemplateKeyword;
TRUNCATE TABLE Jikou;
TRUNCATE TABLE Mail;
TRUNCATE TABLE User;
TRUNCATE TABLE MailContent;
TRUNCATE TABLE LikeAction;
TRUNCATE TABLE AddressType;
TRUNCATE TABLE PurposeType;

set foreign_key_checks = 1;

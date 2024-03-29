
INSERT
INTO AddressType(
AddressTypeName,
BuiltInType
)
VALUES(
'上司',
'BUILTIN'
);

INSERT
INTO AddressType(
AddressTypeName,
BuiltInType
)
VALUES(
'取引先',
'BUILTIN'
);

INSERT
INTO PurposeType(
PurposeTypeName,
MashiMashiType,
BuiltInType
)
VALUES(
'挨拶',
'KATASA',
'BUILTIN'
);

INSERT
INTO PurposeType(
PurposeTypeName,
MashiMashiType,
BuiltInType
)
VALUES(
'謝罪',
'ABURA',
'BUILTIN'
);

INSERT
INTO PurposeType(
PurposeTypeName,
MashiMashiType,
BuiltInType
)
VALUES(
'感謝',
'YASAI',
'BUILTIN'
);

INSERT
INTO PurposeType(
PurposeTypeName,
MashiMashiType,
BuiltInType
)
VALUES(
'依頼',
'KARAME',
'BUILTIN'
);

INSERT
INTO Keyword(
KeywordContent
)
VALUES(
'A'
);

INSERT
INTO Template(
TemplateName,
TemplateContent,
MashiMashiValue,
BuiltInType,
AddressTypeID,
PurposeTypeID
)
VALUES(
'A',
'A',
1,
'BUILTIN',
1,
1
);

INSERT
INTO Template(
TemplateName,
TemplateContent,
MashiMashiValue,
BuiltInType,
AddressTypeID,
PurposeTypeID
)
VALUES(
'B',
'B',
3,
'BUILTIN',
1,
1
);

INSERT
INTO Template(
TemplateName,
TemplateContent,
MashiMashiValue,
BuiltInType,
AddressTypeID,
PurposeTypeID
)
VALUES(
'C',
'C',
2,
'BUILTIN',
1,
2
);

INSERT
INTO TemplateKeyword (
KeywordID,
TemplateID
)
VALUES (
1,
1);

INSERT
INTO TemplateKeyword (
KeywordID,
TemplateID
)
VALUES (
1,
2);

INSERT
INTO User (
UserName,
UserPassword,
MailAddress,
MailPassword,
FirstName,
LastName,
Gender
)
VALUES (
'アンパンマン',
'password',
'anpanmandayooooo@gmail.com',
'XFcAguJk9F',
'アンパン',
'マン',
'WOMAN'
);

INSERT
INTO Mail (
_From,
_To,
Subject,
_Date,
UserID,
Folder
)
VALUES (
'ampanman@central-soft.co.jp',
'bykinman@central-soft.co.jp',
'やめるんだバイキンマン',
'2019-01-01',
1,
'INBOX'
);

INSERT
INTO MailContent (
Name,
ContentType,
ContentDisposition,
ContentBinary,
MailID
)
VALUES (
'バイバイ',
'text/plain',
'INLINE',
0x69048AEFDD010E,
1
);

INSERT
INTO mailserver (`ServerID`,`SMTPServer`,`SMTPPort`,`POPServer`,`POPPort`)
VALUES (1,'smtp.gmail.com',587,'pop.gmail.com',995);

INSERT
INTO mailserver (`ServerID`,`SMTPServer`,`SMTPPort`,`POPServer`,`POPPort`)
VALUES (2,'smtp.mail.yahoo.co.jp',465,'pop.mail.yahoo.co.jp',995);




INSERT
INTO AddressType(
AddressTypeName,
BuiltInType
)
VALUES(
'上司',
'BuiltIn'
);

INSERT
INTO AddressType(
AddressTypeName,
BuiltInType
)
VALUES(
'同僚',
'BuiltIn'
);

INSERT
INTO PurposeType(
PurposeTypeName,
MashiMashiType,
BuiltInType
)
VALUES(
'感謝',
1,
'BuiltIn'
);

INSERT
INTO PurposeType(
PurposeTypeName,
MashiMashiType,
BuiltInType
)
VALUES(
'謝罪',
2,
'BuiltIn'
);

INSERT
INTO PurposeType(
PurposeTypeName,
MashiMashiType,
BuiltInType
)
VALUES(
'見舞',
3,
'BuiltIn'
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
'BuiltIn',
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
'BuiltIn',
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
'BuiltIn',
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


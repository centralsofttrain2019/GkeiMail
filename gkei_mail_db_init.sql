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
'同僚',
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
'',
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
'',
'BUILTIN'
);

INSERT
INTO PurposeType(
PurposeTypeName,
MashiMashiType,
BuiltInType
)
VALUES(
'見舞',
'',
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


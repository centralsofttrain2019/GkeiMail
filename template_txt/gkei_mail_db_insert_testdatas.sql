set foreign_key_checks = 0;

TRUNCATE TABLE Template;
TRUNCATE TABLE AddressType;
TRUNCATE TABLE PurposeType;

set foreign_key_checks = 1;

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
INTO Template(
TemplateName,
TemplateContent,
MashiMashiValue,
BuiltInType,
AddressTypeID,
PurposeTypeID
)
VALUES(
'取引先に担当者交代の挨拶',
'
[相手方の会社名]　[相手方の役職]
[相手方の名前]

日頃大変お世話になっております。
[貴方の会社名]､[貴方の役職]の[貴方の名前]でございます。

さて、貴社を担当させて頂いております[前担当者の名前]が、
[交代する日付]付で[異動先]に異動となり、
新任として[新担当者の名前]が担当させて頂くこととなりました。

これまで貴社にご指導をいただいておりました担当者の交代で
貴社にご不便、ご迷惑をおかけしないよう、
万全の引き継ぎを行う所存でございます。

何かと至らぬ点も多いと存じますが、前任者同様、
お引き立てを賜わりますようお願い申し上げます。

とり急ぎのご報告、メールにて失礼いたします。
',
1,
'BUILTIN',
2,
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
'取引先に担当者交代の挨拶',
'
[相手方の会社名]　[相手方の役職]
[相手方の名前]

[貴方の会社名]､[貴方の役職]の[貴方の名前]でございます。
平素は格別のお力添えをいただき、厚くお礼申し上げます。

さて、貴社を担当させて頂いております[前担当者の名前]が、
[交代する日付]付で[異動先]に異動となり、
新任として[新担当者の名前]が担当させて頂くこととなりました。
長年のご厚情に対し、[前担当者の名前]ともどもご深謝申し上げます。

これまで貴社にご指導をいただいておりました担当者の交代で
貴社にご不便、ご迷惑をおかけしないよう、
万全の引き継ぎを行う所存でございます。

何かと至らぬ点も多いと存じますが、前任者同様、
今後とも倍旧のご愛顧をよろしくお願い申し上げます。

とり急ぎのご報告、メールにて失礼いたします。
',
2,
'BUILTIN',
2,
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
'取引先に担当者交代の挨拶',
'
[相手方の会社名]　[相手方の役職]
[相手方の名前]

[貴方の会社名]､[貴方の役職]の[貴方の名前]でございます。
平素は格別のお力添えをいただき、厚くお礼申し上げます。

さて、貴社を担当させて頂いております[前担当者の名前]が、
[交代する日付]付で[異動先]に異動となり、
新任として[新担当者の名前]が担当させて頂くこととなりました。

これまで貴社にご指導をいただいておりました担当者の交代で
貴社にご不便、ご迷惑をおかけしないよう、
万全の引き継ぎを行う所存でございます。

何かと至らぬ点も多いと存じますが、前任者同様、
今後とも倍旧のご愛顧をよろしくお願い申し上げます。

この件につきまして、近日中に本人ともどもご挨拶に伺う予定であります。
その節はよろしくお願い申し上げます。
大変恐縮ではございますが、とり急ぎのご報告、メールにて失礼いたします。
',
3,
'BUILTIN',
2,
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
'取引先に納期延期の依頼',
'
平素は格別のお引き立てを賜り、厚くお礼申しあげます。

[納入期限]に納期予定の[案件]の件ですが、納品期日を遅らせていただきたく
お願いのメールを差し上げております。

[理由]
[納期の延長度合い]のご猶予をいただきたく、お願い申し上げます。

こちらの不手際で、ご迷惑をおかけしますが、
何とぞ、ご容赦くださいますようにお願い申し上げます。

取り急ぎ、お詫びとお願いを申し上げます。
',
1,
'BUILTIN',
2,
4
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
'取引先に感謝',
'
[取引先の会社名]
[取引先の部署]　[取引先の苗字]様

いつもお世話になっております。
[貴方の会社名]・[貴方の部署]の[貴方の苗字]です。

本日はお忙しいところ、
打ち合わせのお時間を割いていただきまして
ありがとうございました。

本日ご指摘いただいた課題を
社内で再度検討させていただきます。
再度ご提示できる内容が固まり次第、
連絡を差し上げます。

その他気になる点・ご不明点などございましたら、
お気軽にお申し付けください。

メールにて恐縮ですが、引き続きのご対応、
どうぞよろしくお願い致します。
',
1,
'BUILTIN',
2,
3
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
'取引先に深く感謝',
'
[取引先の会社名]
[取引先の部署]　[取引先の苗字]様

平素より、大変お世話になっております。
[貴方の会社名]・[貴方の部署]の[貴方の苗字]です。

本日はご多忙なところ、
打ち合わせのお時間を割いていただきまして
御礼申し上げます。

本日[取引先の苗字]様からご指摘いただいた課題を
社内で再度検討させていただきます。
再度ご提示できる内容が固まり次第、
改めて[貴方の苗字]から連絡を差し上げます。

その他気になる点・ご不明点などございましたら、
[貴方の苗字]までお気軽にお申し付けください。

今後とも引き続きご愛顧賜りますよう、
よろしくお願い申し上げます。
',
2,
'BUILTIN',
2,
3
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
'取引先に圧倒的感謝',
'
[取引先の会社名]
[取引先の部署]　[取引先の役職]　[取引先のフルネーム]様

平素より格別のご高配にあずかり、厚くお礼申し上げます。
[貴方の会社名]・[貴方の部署]の[貴方の苗字]です。

本日はご多忙なところ、
当方のために打ち合わせのお時間を割いていただきまして
何とお礼を申してよいのやら、御礼の言葉もございません。

本日は、[取引先のフルネーム]様のお力添えのおかげで
多くの貴重なご意見を頂戴することができました。
[取引先のフルネーム]様からご指摘いただいた課題を
今後社内で再度検討させていただきます。
再度ご提示できる内容が固まり次第、
改めて[貴方の苗字]から連絡を差し上げます。

その他気になる点・ご不明点などございましたら、
何なりと[貴方の苗字]まで遠慮なくお気軽にお申し付けください。

至らぬ点もあるかとは存じますが、
全力で取り組んでまいりますので、
ご愛顧のほどよろしくお願いいたします。
',
3,
'BUILTIN',
2,
3
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
'取引先に謝罪',
'
[取引先の会社名]
[取引先の部署]　[取引先の苗字]様

いつもお世話になっております。
[貴方の会社名]・[貴方の部署]の[貴方の苗字]です。

先日は、私が未熟なばかりに
大変長い間お待たせしてしまい、
申し訳ございませんでした。

早めの行動を心がけていれば
防げたものだったと反省するとともに、
社会人としての意識の低さを痛感いたしております。
今後、このようなことがないよう、今回の反省をもとに、
これまで以上に気をつけます。

今後ともご指導のほど、よろしくお願い致します。

メールにて恐縮ですが、
この度は、申し訳ございませんでした。
',
1,
'BUILTIN',
2,
2
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
'取引先に深く謝罪',
'
[取引先の会社名]
[取引先の部署]　[取引先の苗字]様

平素より、大変お世話になっております。
[貴方の会社名]・[貴方の部署]の[貴方の苗字]です。

先日は、私の自覚が足りないばかりに
大変長い間お待たせしてしまい、
本当に申し訳ございませんでした。

早めの行動を心がけていれば
防げたものだったと反省するとともに、
社会人としての意識の低さを痛感いたしております。
今後、このようなことがないよう、今回の反省を充分に留意し、
より一層業務に配慮して参ります。

ご手数だとは存じますが、
今後ともご指導ご鞭撻のほど、よろしくお願い致します。

メールにて恐縮ではございますが、
この度は、誠に申し訳ございませんでした。
',
2,
'BUILTIN',
2,
2
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
'取引先に圧倒的謝罪',
'
[取引先の会社名]
[取引先の部署]　[取引先の役職]　[取引先のフルネーム]様

平素より格別のご高配にあずかり、厚くお礼申し上げます。
[貴方の会社名]・[貴方の部署]の[貴方の苗字]です。

先日は、私の自覚が足りないばかりに
大変長い間お待たせし、多大なるご迷惑をお掛けしたことを
深くお詫び申し上げます。

早めの行動を心がけていれば
防げたものだったと猛省するとともに、
社会人としての意識の低さを痛感し、
私の不徳のいたすところと、猛省しております。
今後は、このようなことが二度とないよう、
今回の件を肝に銘じ、自らを戒め、仕事に精進して参る所在です。
何卒、ご容赦いただきたく、お願い申し上げます。

ご手数だとは存じますが、
今後ともご指導ご鞭撻を賜りますよう、切にお願い申し上げます。

メールにて大変恐縮ではございますが、
この度は、今回の件を厳粛に受け止め陳謝いたします。
',
3,
'BUILTIN',
2,
2
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
'上司に異動完了の挨拶',
'
お世話になっております。
人事異動により本社　[貴方の部署][貴方の役職]を命ぜられました[貴方の名前]です。

[異動日付]、無事着任いたしましたので、お知らせ方々お礼申し上げます。

[異動前職場]在勤中は大変お世話になり、ありがとうございました。
新しい職場でも精一杯努力いたしますので、
今後とも何卒よろしくおつきあいのほど、お願い申し上げます。
',
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
'上司に資料確認の依頼',
'
お疲れ様です。[貴方の部署]の[貴方の苗字]です。

[提出期限]に、[提出先の部署]に提出する書類につきまして、
課内全員の分を集めて、[提出先の役職]のデスクの上に置いておきました。

出張からお戻りになりましたら、お目通りのうえ、
サインを入れて、私までお戻しいただけると幸いです。
お忙しいところ恐縮ですが、
[確認期限]中にお願いできませんでしょうか。

では、よろしくお願いいたします。
',
1,
'BUILTIN',
1,
4
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
'上司に日程調整の依頼',
'
お疲れ様です。[貴方の役職]の[貴方の苗字]です。

[予定日時]に予定していた営業会議の日程ですが、
できれば[変更前日時]から[変更後日時]に変更をお願いできないでしょうか。
[時間は[開始時間]からで変更ありません。]

もし、ご都合が悪いようでしたら、
別の日時をご指定いただければと思います。

ご無理を言いますが、
お取り計らいの件、よろしくお願いいたします。
',
1,
'BUILTIN',
1,
4
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
'上司に日程調整の依頼',
'
お疲れ様です。[貴方の役職]の[貴方の苗字]です。

[予定日時]に予定していた営業会議の日程ですが、
もし可能であれば[変更前日時]から[変更後日時]に変更をお願いできないでしょうか。
[時間は[開始時間]からで変更ありません。]

もし、ご都合が悪いようでしたら、
別の日時をご指定いただければと存じます。

誠に厚かましいお願いですが、
お取り計らいの件、何卒よろしくお願いいたします。
',
2,
'BUILTIN',
1,
4
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
'上司に感謝',
'
お疲れさまです。[貴方の部署]の[貴方の苗字]です。

先日はお忙しい中、私のためにお時間を割いていただきありがとうございました。
おかげさまで、[相手方の役職]からいただいたアドバイスで、随分と気持ちが楽になることができました。

正直、一人で考えていると、自分のできない部分ばかりが目につき、自信を無くしかけていました。
[相手方の役職]の経験に学んで、今後は前向きにやっていきます。

また、[相手方の役職]から、いつでも相談に来て良いとのお言葉を頂いたことがとてもありがたく、安心して仕事に打ち込めそうです。
これからも、何かとご相談に乗っていただくことがあるかと思いますが、どうぞよろしくお願いします。

取り急ぎメールにてお礼申し上げます。
',
1,
'BUILTIN',
1,
3
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
'上司に深く感謝',
'
お疲れさまです。[貴方の部署]の[貴方の苗字]です。

先日はお忙しい中、私のために貴重なお時間を割いていただき誠にありがとうございます。
[相手方の苗字][相手方の役職]からいただいた貴重なアドバイスのおかげで、随分と気持ちが楽になることができました。

正直なところ、一人で考えていますと、自身の至らない部分ばかりが目につき、自信を無くしかけていました。
[相手方の苗字][相手方の役職]の経験に学んで、今後は前向きにやって参りたいと存じます。

また、[相手方の苗字][相手方の役職]から、いつでも相談に来て良いとのお言葉を頂いたことがとてもありがたく、安心して仕事に打ち込めそうです。
今後ご相談に乗っていただくことがあるかと存じますが、何卒よろしくお願い申し上げます。

取り急ぎメールにてお礼申し上げます。
',
2,
'BUILTIN',
1,
3
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
'上司に圧倒的感謝',
'
平素は格別のご高配を賜り、厚く御礼申し上げます。[貴方の部署]の[貴方の苗字]と申します。

先日はご多忙の中、私のために[相手方のフルネーム][相手方の役職]の大変貴重なお時間を割いていただき心より感謝申し上げます。
[相手方のフルネーム][相手方の役職]からいただいた珠玉のアドバイスにより、随分と気持ちが楽になることができました。
[相手方のフルネーム][相手方の役職]の度重なる過分なる心遣いに拝謝いたします。

正直なところ、一人で考えていますと、自身の至らない部分ばかりが目につき、自信を無くしかけていました。
[相手方のフルネーム][相手方の役職]の貴重な経験に学んで、今後は前向きに取り組んで参ります。

また、[相手方のフルネーム][相手方の役職]から、いつでも相談に来て良いとのお言葉を頂いたことがとてもありがたく、何とお礼を申してよいのやら御礼の言葉もございません。
今後ご相談に乗っていただくことがあるかと存じますが、何卒よろしくお願い申し上げます。

取り急ぎメールにてお礼申し上げます。
',
3,
'BUILTIN',
1,
3
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
'上司に謝罪',
'
[相手方の部署]
[相手方の苗字]　[相手方の役職]

このたびは、[トラブル内容、用件]の件につきまして
私の対応が不十分で
大変ご迷惑をおかけしました。

幸い、先方も謝罪を受け入れてくださり
最小限のダメージにおさえることができました。
お心遣い本当にありがとうございました。

今後、このようなミスを繰り返さぬように、
細心の注意を払ってまいります。
誠に申し訳ございませんでした。
',
1,
'BUILTIN',
1,
2
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
'上司に深く謝罪',
'
[相手方の部署]
[相手方の苗字]　[相手方の役職]

このたびは、[トラブル内容、用件]の件につきまして
私の不手際な対応により大変ご迷惑をおかけしましたことを
お詫び申し上げます。

幸い、先方も謝罪を受け入れてくださり
最小限のダメージにおさえることができました。
[相手方の苗字]　[相手方の役職]のお心遣い御礼申し上げます。

今後、このようなミスを繰り返さぬように、
細心の注意を払って業務に取り組んでまいります。
心から申し訳なく存じます。
',
2,
'BUILTIN',
1,
2
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
'上司に圧倒的謝罪',
'
[相手方の部署]
[相手方のフルネーム]　[相手方の役職]

このたびは、[トラブル内容、用件]の件につきまして
私の不手際な対応により大変ご迷惑をおかけしましたことを
幾重にもお詫び申し上げます。

幸い、先方も当方の謝罪をお受け入れなさり
最小限のダメージにおさえることができました。
[相手方のフルネーム]　[相手方の役職]の過分なる心遣いに拝謝いたします。

単純ミスから生じたものとはいえ、
確実な作業を心がけていれば起き得なかったことと存じ、
猛省しております。
今後、このようなミスを繰り返さぬように、
今回の反省をもとにより一層細心の注意を払って業務に取り組んでまいります。
今回の件を厳粛に受け止め、陳謝いたします。
',
3,
'BUILTIN',
1,
2
);

ALTER TABLE `gkei_mail`.`template` 
CHARACTER SET = utf8;

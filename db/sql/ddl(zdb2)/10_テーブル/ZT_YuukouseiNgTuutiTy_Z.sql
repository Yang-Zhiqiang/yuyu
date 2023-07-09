CREATE TABLE ZT_YuukouseiNgTuutiTy_Z (
     ztysyoruicd                                        VARCHAR     (5)                                                                 ,  /* （中継用）書類コード */
     ztyhassoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）発送区分 */
     ztytyouhyouymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）帳票作成日 */
     ztytyouhyouymdkj                                   VARCHAR     (24)                                                                ,  /* （中継用）帳票作成日（漢字） */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyyobiv9                                          VARCHAR     (9)                                                                 ,  /* （中継用）予備項目Ｖ９ */
     ztyansyuyouyobin10                                 VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０ */
     ztyshskyno                                         VARCHAR     (7)                                                                 ,  /* （中継用）送付先郵便番号 */
     ztyshskadr1kj                                      VARCHAR     (62)                                                                ,  /* （中継用）送付先住所１（漢字） */
     ztyshskadr2kj                                      VARCHAR     (62)                                                                ,  /* （中継用）送付先住所２（漢字） */
     ztyshskadr3kj                                      VARCHAR     (62)                                                                ,  /* （中継用）送付先住所３（漢字） */
     ztyshsnmkj                                         VARCHAR     (32)                                                                ,  /* （中継用）送付先名（漢字） */
     ztyyobiv43                                         VARCHAR     (43)                                                                ,  /* （中継用）予備項目Ｖ４３ */
     ztyansyuyouyobin10x2                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿２ */
     ztytawsosikikj                                     VARCHAR     (32)                                                                ,  /* （中継用）問合せ先組織名（漢字） */
     ztytawyno                                          VARCHAR     (8)                                                                 ,  /* （中継用）問合せ先郵便番号 */
     ztytawadr1kj                                       VARCHAR     (32)                                                                ,  /* （中継用）問合せ先住所１（漢字） */
     ztytawadr2kj                                       VARCHAR     (32)                                                                ,  /* （中継用）問合せ先住所２（漢字） */
     ztytawadr3kj                                       VARCHAR     (32)                                                                ,  /* （中継用）問合せ先住所３（漢字） */
     ztytawtelnov14                                     VARCHAR     (14)                                                                ,  /* （中継用）問合せ先電話番号Ｖ１４ */
     ztytawteluktkkanou1                                VARCHAR     (52)                                                                ,  /* （中継用）問合せ先電話受付可能時間１ */
     ztytawteluktkkanou2                                VARCHAR     (52)                                                                ,  /* （中継用）問合せ先電話受付可能時間２ */
     ztydai2tawsosikinmkj                               VARCHAR     (32)                                                                ,  /* （中継用）第２問合せ先組織名（漢字） */
     ztydai2tawtelno                                    VARCHAR     (14)                                                                ,  /* （中継用）第２問合せ先電話番号 */
     ztyyobiv62                                         VARCHAR     (62)                                                                ,  /* （中継用）予備項目Ｖ６２ */
     ztyansyuyouyobin10x3                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿３ */
     ztyosirasemongon46keta1                            VARCHAR     (94)                                                                ,  /* （中継用）お知らせ文言（４６桁）１ */
     ztyosirasemongon46keta2                            VARCHAR     (94)                                                                ,  /* （中継用）お知らせ文言（４６桁）２ */
     ztyosirasemongon46keta3                            VARCHAR     (94)                                                                ,  /* （中継用）お知らせ文言（４６桁）３ */
     ztyosirasemongon46keta4                            VARCHAR     (94)                                                                ,  /* （中継用）お知らせ文言（４６桁）４ */
     ztyosirasemongon46keta5                            VARCHAR     (94)                                                                ,  /* （中継用）お知らせ文言（４６桁）５ */
     ztyosirasemongon46keta6                            VARCHAR     (94)                                                                ,  /* （中継用）お知らせ文言（４６桁）６ */
     ztyosirasemongon46keta7                            VARCHAR     (94)                                                                ,  /* （中継用）お知らせ文言（４６桁）７ */
     ztyosirasemongon46keta8                            VARCHAR     (94)                                                                ,  /* （中継用）お知らせ文言（４６桁）８ */
     ztyosirasemongon46keta9                            VARCHAR     (94)                                                                ,  /* （中継用）お知らせ文言（４６桁）９ */
     ztyosirasemongon46keta10                           VARCHAR     (94)                                                                ,  /* （中継用）お知らせ文言（４６桁）１０ */
     ztyyobiv184                                        VARCHAR     (184)                                                               ,  /* （中継用）予備項目Ｖ１８４ */
     ztyansyuyouyobin10x4                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿４ */
     ztykyknmkj                                         VARCHAR     (32)                                                                ,  /* （中継用）契約者名（漢字） */
     ztypkngk                                           VARCHAR     (13)                                                                ,  /* （中継用）保険料金額 */
     ztycreditcardinfo1                                 VARCHAR     (62)                                                                ,  /* （中継用）クレジットカード情報１ */
     ztycreditcardinfo2                                 VARCHAR     (62)                                                                ,  /* （中継用）クレジットカード情報２ */
     ztycreditcardinfo3                                 VARCHAR     (62)                                                                ,  /* （中継用）クレジットカード情報３ */
     ztycreditcardmaskingmsg                            VARCHAR     (80)                                                                ,  /* （中継用）クレジットカードマスキングＭＳＧ */
     ztygoiraijikoutoumongon1                           VARCHAR     (72)                                                                ,  /* （中継用）ご依頼事項等文言１ */
     ztygoiraijikoutoumongon2                           VARCHAR     (72)                                                                ,  /* （中継用）ご依頼事項等文言２ */
     ztygoiraijikoutoumongon3                           VARCHAR     (72)                                                                ,  /* （中継用）ご依頼事項等文言３ */
     ztyphrkmongon1                                     VARCHAR     (94)                                                                ,  /* （中継用）保険料のお払込み文言１ */
     ztyphrkmongon2                                     VARCHAR     (94)                                                                ,  /* （中継用）保険料のお払込み文言２ */
     ztyphrkmongon3                                     VARCHAR     (94)                                                                ,  /* （中継用）保険料のお払込み文言３ */
     ztyphrkmongon4                                     VARCHAR     (94)                                                                ,  /* （中継用）保険料のお払込み文言４ */
     ztyphrkmongon5                                     VARCHAR     (94)                                                                ,  /* （中継用）保険料のお払込み文言５ */
     ztyphrkmongon6                                     VARCHAR     (94)                                                                ,  /* （中継用）保険料のお払込み文言６ */
     ztyphrkmongon7                                     VARCHAR     (94)                                                                ,  /* （中継用）保険料のお払込み文言７ */
     ztyphrkmongon8                                     VARCHAR     (94)                                                                ,  /* （中継用）保険料のお払込み文言８ */
     ztyphrkmongon9                                     VARCHAR     (94)                                                                ,  /* （中継用）保険料のお払込み文言９ */
     ztyyobiv17                                         VARCHAR     (17)                                                                ,  /* （中継用）予備項目Ｖ１７ */
     ztyyobiv250                                        VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０ */
     ztyansyuyouyobin10x5                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿５ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_YuukouseiNgTuutiTy_Z ADD CONSTRAINT PK_YuukouseiNgTuutiTy PRIMARY KEY (
     ztytyouhyouymd                                           , /* （中継用）帳票作成日 */
     ztysyono                                                   /* （中継用）証券番号 */
) ;

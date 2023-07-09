CREATE TABLE ZT_CreditHnknTuutiTy (
     ztysyoruicd                                        VARCHAR     (5)                                                                 ,  /* （中継用）書類コード */
     ztyhassoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）発送区分 */
     ztytyouhyouymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）帳票作成日 */
     ztytyouhyouymdkj                                   VARCHAR     (11)                                                                ,  /* （中継用）帳票作成日（漢字） */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztysikibetuno                                      VARCHAR     (20)                                                      NOT NULL  ,  /* （中継用）識別番号 */
     ztyyobiv14                                         VARCHAR     (14)                                                                ,  /* （中継用）予備項目Ｖ１４ */
     ztyansyuyouyobin10                                 VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０ */
     ztyshskyno                                         VARCHAR     (7)                                                                 ,  /* （中継用）送付先郵便番号 */
     ztyshskadr1kj                                      VARCHAR     (30)                                                                ,  /* （中継用）送付先住所１（漢字） */
     ztyshskadr2kj                                      VARCHAR     (30)                                                                ,  /* （中継用）送付先住所２（漢字） */
     ztyshskadr3kj                                      VARCHAR     (30)                                                                ,  /* （中継用）送付先住所３（漢字） */
     ztyshsnmkj                                         VARCHAR     (15)                                                                ,  /* （中継用）送付先名（漢字） */
     ztyyobiv43                                         VARCHAR     (43)                                                                ,  /* （中継用）予備項目Ｖ４３ */
     ztyansyuyouyobin10x2                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿２ */
     ztytawsosikikj                                     VARCHAR     (15)                                                                ,  /* （中継用）問合せ先組織名（漢字） */
     ztytawyno                                          VARCHAR     (8)                                                                 ,  /* （中継用）問合せ先郵便番号 */
     ztytawadr1kj                                       VARCHAR     (15)                                                                ,  /* （中継用）問合せ先住所１（漢字） */
     ztytawadr2kj                                       VARCHAR     (15)                                                                ,  /* （中継用）問合せ先住所２（漢字） */
     ztytawadr3kj                                       VARCHAR     (15)                                                                ,  /* （中継用）問合せ先住所３（漢字） */
     ztytawtelnov14                                     VARCHAR     (14)                                                                ,  /* （中継用）問合せ先電話番号Ｖ１４ */
     ztytawteluktkkanou1                                VARCHAR     (25)                                                                ,  /* （中継用）問合せ先電話受付可能時間１ */
     ztytawteluktkkanou2                                VARCHAR     (25)                                                                ,  /* （中継用）問合せ先電話受付可能時間２ */
     ztydai2tawsosikinmkj                               VARCHAR     (15)                                                                ,  /* （中継用）第２問合せ先組織名（漢字） */
     ztydai2tawtelno                                    VARCHAR     (14)                                                                ,  /* （中継用）第２問合せ先電話番号 */
     ztysclatosyono                                     VARCHAR     (11)                                                                ,  /* （中継用）スクランブル後証券番号 */
     ztysakunm15keta                                    VARCHAR     (15)                                                                ,  /* （中継用）作成番号（１５桁） */
     ztyyobiv62                                         VARCHAR     (62)                                                                ,  /* （中継用）予備項目Ｖ６２ */
     ztyansyuyouyobin10x3                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿３ */
     ztyhnknmsgmongon1                                  VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ文言１ */
     ztyhnknmsgmongon2                                  VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ文言２ */
     ztyhnknmsgmongon3                                  VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ文言３ */
     ztyhnknmsgmongon4                                  VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ文言４ */
     ztyhnknmsgmongon5                                  VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ文言５ */
     ztyhnknmsgmongon6                                  VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ文言６ */
     ztyhnknmsgmongon7                                  VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ文言７ */
     ztyhnknmsgmongon8                                  VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ文言８ */
     ztyhnknmsgmongon9                                  VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ文言９ */
     ztyhnknmsgmongon10                                 VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ文言１０ */
     ztyyobiv128                                        VARCHAR     (128)                                                               ,  /* （中継用）予備項目Ｖ１２８ */
     ztyansyuyouyobin10x4                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿４ */
     ztytuutisakuseiymdv32                              VARCHAR     (32)                                                                ,  /* （中継用）通知作成年月日Ｖ３２ */
     ztyyobiv64                                         VARCHAR     (64)                                                                ,  /* （中継用）予備項目Ｖ６４ */
     ztyansyuyouyobin10x5                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿５ */
     ztyhnknnaiyoumongon1                               VARCHAR     (32)                                                                ,  /* （中継用）返金内容文言１ */
     ztyhnknnaiyoumongon2                               VARCHAR     (32)                                                                ,  /* （中継用）返金内容文言２ */
     ztyhnknnaiyoumongon3                               VARCHAR     (32)                                                                ,  /* （中継用）返金内容文言３ */
     ztyhnknnaiyoumongon4                               VARCHAR     (32)                                                                ,  /* （中継用）返金内容文言４ */
     ztyhnknnaiyoumongon5                               VARCHAR     (32)                                                                ,  /* （中継用）返金内容文言５ */
     ztyhnknnaiyoumongon6                               VARCHAR     (32)                                                                ,  /* （中継用）返金内容文言６ */
     ztyhnknnaiyoumongon7                               VARCHAR     (32)                                                                ,  /* （中継用）返金内容文言７ */
     ztyhnknnaiyoumongon8                               VARCHAR     (32)                                                                ,  /* （中継用）返金内容文言８ */
     ztyyobiv128x2                                      VARCHAR     (128)                                                               ,  /* （中継用）予備項目Ｖ１２８＿２ */
     ztyansyuyouyobin10x6                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿６ */
     ztyhnknmsghsk1                                     VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足１ */
     ztyhnknmsghsk2                                     VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足２ */
     ztyhnknmsghsk3                                     VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足３ */
     ztyhnknmsghsk4                                     VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足４ */
     ztyhnknmsghsk5                                     VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足５ */
     ztyhnknmsghsk6                                     VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足６ */
     ztyhnknmsghsk7                                     VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足７ */
     ztyhnknmsghsk8                                     VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足８ */
     ztyhnknmsghsk9                                     VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足９ */
     ztyhnknmsghsk10                                    VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足１０ */
     ztyhnknmsghsk11                                    VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足１１ */
     ztyhnknmsghsk12                                    VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足１２ */
     ztyhnknmsghsk13                                    VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足１３ */
     ztyhnknmsghsk14                                    VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足１４ */
     ztyhnknmsghsk15                                    VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足１５ */
     ztyhnknmsghsk16                                    VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足１６ */
     ztyhnknmsghsk17                                    VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足１７ */
     ztyhnknmsghsk18                                    VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足１８ */
     ztyhnknmsghsk19                                    VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足１９ */
     ztyhnknmsghsk20                                    VARCHAR     (32)                                                                ,  /* （中継用）返金メッセージ補足２０ */
     ztyyobiv128x3                                      VARCHAR     (128)                                                               ,  /* （中継用）予備項目Ｖ１２８＿３ */
     ztyansyuyouyobin10x7                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿７ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_CreditHnknTuutiTy ADD CONSTRAINT PK_CreditHnknTuutiTy PRIMARY KEY (
     ztysyono                                                 , /* （中継用）証券番号 */
     ztytyouhyouymd                                           , /* （中継用）帳票作成日 */
     ztysikibetuno                                              /* （中継用）識別番号 */
) ;

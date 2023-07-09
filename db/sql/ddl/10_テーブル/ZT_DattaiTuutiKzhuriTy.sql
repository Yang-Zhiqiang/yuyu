CREATE TABLE ZT_DattaiTuutiKzhuriTy (
     ztysyoruicd                                        VARCHAR     (5)                                                                 ,  /* （中継用）書類コード */
     ztyhassoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）発送区分 */
     ztytyouhyouymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）帳票作成日 */
     ztytyouhyouymdkj                                   VARCHAR     (11)                                                                ,  /* （中継用）帳票作成日（漢字） */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyyobiv9                                          VARCHAR     (9)                                                                 ,  /* （中継用）予備項目Ｖ９ */
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
     ztyosirasemongon1                                  VARCHAR     (52)                                                                ,  /* （中継用）お知らせ文言１ */
     ztyosirasemongon2                                  VARCHAR     (52)                                                                ,  /* （中継用）お知らせ文言２ */
     ztyosirasemongon3                                  VARCHAR     (52)                                                                ,  /* （中継用）お知らせ文言３ */
     ztyosirasemongon4                                  VARCHAR     (52)                                                                ,  /* （中継用）お知らせ文言４ */
     ztyosirasemongon5                                  VARCHAR     (52)                                                                ,  /* （中継用）お知らせ文言５ */
     ztyosirasemongon6                                  VARCHAR     (52)                                                                ,  /* （中継用）お知らせ文言６ */
     ztyosirasemongon7                                  VARCHAR     (52)                                                                ,  /* （中継用）お知らせ文言７ */
     ztyosirasemongon8                                  VARCHAR     (52)                                                                ,  /* （中継用）お知らせ文言８ */
     ztyosirasemongon9                                  VARCHAR     (52)                                                                ,  /* （中継用）お知らせ文言９ */
     ztyyobiv181                                        VARCHAR     (181)                                                               ,  /* （中継用）予備項目Ｖ１８１ */
     ztyansyuyouyobin10x4                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿４ */
     ztysyono2                                          VARCHAR     (11)                                                                ,  /* （中継用）証券番号２ */
     ztyhhknnmkj                                        VARCHAR     (15)                                                                ,  /* （中継用）被保険者名（漢字） */
     ztykzinfo30keta1                                   VARCHAR     (30)                                                                ,  /* （中継用）口座情報（３０桁）１ */
     ztykzinfo30keta2                                   VARCHAR     (30)                                                                ,  /* （中継用）口座情報（３０桁）２ */
     ztykzinfo30keta3                                   VARCHAR     (30)                                                                ,  /* （中継用）口座情報（３０桁）３ */
     ztykouzamaskingmsg                                 VARCHAR     (32)                                                                ,  /* （中継用）口座マスキングＭＳＧ */
     ztyyobiv50                                         VARCHAR     (50)                                                                ,  /* （中継用）予備項目Ｖ５０ */
     ztyansyuyouyobin10x5                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿５ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_DattaiTuutiKzhuriTy ADD CONSTRAINT PK_DattaiTuutiKzhuriTy PRIMARY KEY (
     ztytyouhyouymd                                           , /* （中継用）帳票作成日 */
     ztysyono                                                   /* （中継用）証券番号 */
) ;

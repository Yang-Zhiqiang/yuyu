CREATE TABLE ZT_KijituTouraiAnnaiTy (
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
     ztyyobiv60                                         VARCHAR     (60)                                                                ,  /* （中継用）予備項目Ｖ６０ */
     ztyansyuyouyobin10x3                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿３ */
     ztytuutinm                                         VARCHAR     (20)                                                                ,  /* （中継用）通知名称 */
     ztyhurikaeyokokumsg32keta1                         VARCHAR     (32)                                                                ,  /* （中継用）振替予告メッセージ（３２桁）１ */
     ztyhurikaeyokokumsg32keta2                         VARCHAR     (32)                                                                ,  /* （中継用）振替予告メッセージ（３２桁）２ */
     ztyhurikaeyokokumsg32keta3                         VARCHAR     (32)                                                                ,  /* （中継用）振替予告メッセージ（３２桁）３ */
     ztyhurikaeyokokumsg32keta4                         VARCHAR     (32)                                                                ,  /* （中継用）振替予告メッセージ（３２桁）４ */
     ztyhurikaeyokokumsg32keta5                         VARCHAR     (32)                                                                ,  /* （中継用）振替予告メッセージ（３２桁）５ */
     ztyhurikaeyokokumsg32keta6                         VARCHAR     (32)                                                                ,  /* （中継用）振替予告メッセージ（３２桁）６ */
     ztyhurikaeyokokumsg32keta7                         VARCHAR     (32)                                                                ,  /* （中継用）振替予告メッセージ（３２桁）７ */
     ztyhurikaeyokokumsg32keta8                         VARCHAR     (32)                                                                ,  /* （中継用）振替予告メッセージ（３２桁）８ */
     ztyyobiv110                                        VARCHAR     (110)                                                               ,  /* （中継用）予備項目Ｖ１１０ */
     ztyansyuyouyobin10x4                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿４ */
     ztyhrkkeiro                                        VARCHAR     (1)                                                                 ,  /* （中継用）払込経路 */
     ztysyono2                                          VARCHAR     (11)                                                                ,  /* （中継用）証券番号２ */
     ztysyouhnnm                                        VARCHAR     (40)                                                                ,  /* （中継用）商品名 */
     ztykykymdseireki                                   VARCHAR     (11)                                                                ,  /* （中継用）契約年月日（西暦） */
     ztyhhknnmkj                                        VARCHAR     (15)                                                                ,  /* （中継用）被保険者名（漢字） */
     ztyyobiv30                                         VARCHAR     (30)                                                                ,  /* （中継用）予備項目Ｖ３０ */
     ztyansyuyouyobin10x5                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿５ */
     ztykjttrnnfreearea1                                VARCHAR     (35)                                                                ,  /* （中継用）期日到来案内フリーエリア１ */
     ztykjttrnnfreearea2                                VARCHAR     (35)                                                                ,  /* （中継用）期日到来案内フリーエリア２ */
     ztykjttrnnfreearea3                                VARCHAR     (35)                                                                ,  /* （中継用）期日到来案内フリーエリア３ */
     ztykjttrnnfreearea4                                VARCHAR     (35)                                                                ,  /* （中継用）期日到来案内フリーエリア４ */
     ztykjttrnnfreearea5                                VARCHAR     (35)                                                                ,  /* （中継用）期日到来案内フリーエリア５ */
     ztykjttrnnfreearea6                                VARCHAR     (35)                                                                ,  /* （中継用）期日到来案内フリーエリア６ */
     ztykjttrnnfreearea7                                VARCHAR     (35)                                                                ,  /* （中継用）期日到来案内フリーエリア７ */
     ztyyobiv99                                         VARCHAR     (99)                                                                ,  /* （中継用）予備項目Ｖ９９ */
     ztyansyuyouyobin10x6                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿６ */
     ztytuutisakuseiymdseireki                          VARCHAR     (11)                                                                ,  /* （中継用）通知作成年月日（西暦） */
     ztykzhurikaeymdseireki                             VARCHAR     (11)                                                                ,  /* （中継用）口座振替日（西暦） */
     ztykzinfo1                                         VARCHAR     (27)                                                                ,  /* （中継用）口座情報１ */
     ztykzinfo2                                         VARCHAR     (27)                                                                ,  /* （中継用）口座情報２ */
     ztykzinfo3                                         VARCHAR     (27)                                                                ,  /* （中継用）口座情報３ */
     ztykzinfo4                                         VARCHAR     (27)                                                                ,  /* （中継用）口座情報４ */
     ztykzinfo5                                         VARCHAR     (27)                                                                ,  /* （中継用）口座情報５ */
     ztykzinfo6                                         VARCHAR     (27)                                                                ,  /* （中継用）口座情報６ */
     ztykzinfo7                                         VARCHAR     (27)                                                                ,  /* （中継用）口座情報７ */
     ztykzinfo8                                         VARCHAR     (27)                                                                ,  /* （中継用）口座情報８ */
     ztyhknjytukikan                                    VARCHAR     (18)                                                                ,  /* （中継用）保険料充当期間 */
     ztyhrkgk1                                          VARCHAR     (27)                                                                ,  /* （中継用）払込金額１ */
     ztyhrkgk2                                          VARCHAR     (27)                                                                ,  /* （中継用）払込金額２ */
     ztyhrkgk3                                          VARCHAR     (27)                                                                ,  /* （中継用）払込金額３ */
     ztyhrkgk4                                          VARCHAR     (27)                                                                ,  /* （中継用）払込金額４ */
     ztyyobiv146                                        VARCHAR     (146)                                                               ,  /* （中継用）予備項目Ｖ１４６ */
     ztyansyuyouyobin10x7                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿７ */
     ztykjttrnnfreearea8                                VARCHAR     (35)                                                                ,  /* （中継用）期日到来案内フリーエリア８ */
     ztykjttrnnfreearea9                                VARCHAR     (35)                                                                ,  /* （中継用）期日到来案内フリーエリア９ */
     ztykjttrnnfreearea10                               VARCHAR     (35)                                                                ,  /* （中継用）期日到来案内フリーエリア１０ */
     ztykjttrnnfreearea11                               VARCHAR     (35)                                                                ,  /* （中継用）期日到来案内フリーエリア１１ */
     ztykjttrnnfreearea12                               VARCHAR     (35)                                                                ,  /* （中継用）期日到来案内フリーエリア１２ */
     ztykjttrnnfreearea13                               VARCHAR     (35)                                                                ,  /* （中継用）期日到来案内フリーエリア１３ */
     ztyyobiv84                                         VARCHAR     (84)                                                                ,  /* （中継用）予備項目Ｖ８４ */
     ztyansyuyouyobin10x8                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿８ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_KijituTouraiAnnaiTy ADD CONSTRAINT PK_KijituTouraiAnnaiTy PRIMARY KEY (
     ztytyouhyouymd                                           , /* （中継用）帳票作成日 */
     ztysyono                                                   /* （中継用）証券番号 */
) ;

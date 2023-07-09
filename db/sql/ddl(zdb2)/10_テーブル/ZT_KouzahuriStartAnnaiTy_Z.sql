CREATE TABLE ZT_KouzahuriStartAnnaiTy_Z (
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
     ztysclatosyono                                     VARCHAR     (11)                                                                ,  /* （中継用）スクランブル後証券番号 */
     ztysakunm15keta                                    VARCHAR     (15)                                                                ,  /* （中継用）作成番号（１５桁） */
     ztyyobiv61                                         VARCHAR     (61)                                                                ,  /* （中継用）予備項目Ｖ６１ */
     ztyansyuyouyobin10x3                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿３ */
     ztytuutinm                                         VARCHAR     (42)                                                                ,  /* （中継用）通知名称 */
     ztyaisatumongon1                                   VARCHAR     (56)                                                                ,  /* （中継用）挨拶文言１ */
     ztyaisatumongon2                                   VARCHAR     (56)                                                                ,  /* （中継用）挨拶文言２ */
     ztyaisatumongon3                                   VARCHAR     (56)                                                                ,  /* （中継用）挨拶文言３ */
     ztyaisatumongon4                                   VARCHAR     (56)                                                                ,  /* （中継用）挨拶文言４ */
     ztyaisatumongon5                                   VARCHAR     (56)                                                                ,  /* （中継用）挨拶文言５ */
     ztyyobiv62                                         VARCHAR     (62)                                                                ,  /* （中継用）予備項目Ｖ６２ */
     ztyansyuyouyobin10x4                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿４ */
     ztykzhurikaeonegai1                                VARCHAR     (72)                                                                ,  /* （中継用）口座振替についてのお願い１ */
     ztykzhurikaeonegai2                                VARCHAR     (72)                                                                ,  /* （中継用）口座振替についてのお願い２ */
     ztykzhurikaeonegai3                                VARCHAR     (72)                                                                ,  /* （中継用）口座振替についてのお願い３ */
     ztykzhurikaeonegai4                                VARCHAR     (72)                                                                ,  /* （中継用）口座振替についてのお願い４ */
     ztykzhurikaeonegai5                                VARCHAR     (72)                                                                ,  /* （中継用）口座振替についてのお願い５ */
     ztykzhurikaeonegai6                                VARCHAR     (72)                                                                ,  /* （中継用）口座振替についてのお願い６ */
     ztykzhurikaeonegai7                                VARCHAR     (72)                                                                ,  /* （中継用）口座振替についてのお願い７ */
     ztykzhurikaeonegai8                                VARCHAR     (72)                                                                ,  /* （中継用）口座振替についてのお願い８ */
     ztykzhurikaeonegai9                                VARCHAR     (72)                                                                ,  /* （中継用）口座振替についてのお願い９ */
     ztykzhurikaeonegai10                               VARCHAR     (72)                                                                ,  /* （中継用）口座振替についてのお願い１０ */
     ztykzhurikaeonegai11                               VARCHAR     (72)                                                                ,  /* （中継用）口座振替についてのお願い１１ */
     ztykzhurikaeonegai12                               VARCHAR     (72)                                                                ,  /* （中継用）口座振替についてのお願い１２ */
     ztykzhurikaeonegai13                               VARCHAR     (72)                                                                ,  /* （中継用）口座振替についてのお願い１３ */
     ztykzhurikaeonegai14                               VARCHAR     (72)                                                                ,  /* （中継用）口座振替についてのお願い１４ */
     ztykzhurikaeonegai15                               VARCHAR     (72)                                                                ,  /* （中継用）口座振替についてのお願い１５ */
     ztyyobiv210                                        VARCHAR     (210)                                                               ,  /* （中継用）予備項目Ｖ２１０ */
     ztyansyuyouyobin10x5                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿５ */
     ztytuutisakuseiymdseireki                          VARCHAR     (24)                                                                ,  /* （中継用）通知作成年月日（西暦） */
     ztysyono2                                          VARCHAR     (11)                                                                ,  /* （中継用）証券番号２ */
     ztysyouhnnm                                        VARCHAR     (82)                                                                ,  /* （中継用）商品名 */
     ztykykymdseireki                                   VARCHAR     (24)                                                                ,  /* （中継用）契約年月日（西暦） */
     ztytkbriphurikaeyoteigk                            VARCHAR     (13)                                                                ,  /* （中継用）月払保険料（振替予定金額） */
     ztyhhknnmkj                                        VARCHAR     (32)                                                                ,  /* （中継用）被保険者名（漢字） */
     ztyhurikaekzhosokumongon                           VARCHAR     (62)                                                                ,  /* （中継用）振替口座補足文言 */
     ztyhurikaekz1                                      VARCHAR     (78)                                                                ,  /* （中継用）振替口座１ */
     ztyhurikaekz2                                      VARCHAR     (78)                                                                ,  /* （中継用）振替口座２ */
     ztyhurikaekz3                                      VARCHAR     (78)                                                                ,  /* （中継用）振替口座３ */
     ztyhurikaekz4                                      VARCHAR     (78)                                                                ,  /* （中継用）振替口座４ */
     ztyhurikaekz5                                      VARCHAR     (78)                                                                ,  /* （中継用）振替口座５ */
     ztyyobiv124                                        VARCHAR     (124)                                                               ,  /* （中継用）予備項目Ｖ１２４ */
     ztyansyuyouyobin10x7                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿７ */
     ztykzhuristartanfreearea1                          VARCHAR     (72)                                                                ,  /* （中継用）口座振替開始案内フリーエリア１ */
     ztykzhuristartanfreearea2                          VARCHAR     (72)                                                                ,  /* （中継用）口座振替開始案内フリーエリア２ */
     ztykzhuristartanfreearea3                          VARCHAR     (72)                                                                ,  /* （中継用）口座振替開始案内フリーエリア３ */
     ztykzhuristartanfreearea4                          VARCHAR     (72)                                                                ,  /* （中継用）口座振替開始案内フリーエリア４ */
     ztykzhuristartanfreearea5                          VARCHAR     (72)                                                                ,  /* （中継用）口座振替開始案内フリーエリア５ */
     ztykzhuristartanfreearea6                          VARCHAR     (72)                                                                ,  /* （中継用）口座振替開始案内フリーエリア６ */
     ztykzhuristartanfreearea7                          VARCHAR     (72)                                                                ,  /* （中継用）口座振替開始案内フリーエリア７ */
     ztykzhuristartanfreearea8                          VARCHAR     (72)                                                                ,  /* （中継用）口座振替開始案内フリーエリア８ */
     ztykzhuristartanfreearea9                          VARCHAR     (72)                                                                ,  /* （中継用）口座振替開始案内フリーエリア９ */
     ztykzhuristartanfreearea10                         VARCHAR     (72)                                                                ,  /* （中継用）口座振替開始案内フリーエリア１０ */
     ztyyobiv140                                        VARCHAR     (140)                                                               ,  /* （中継用）予備項目Ｖ１４０ */
     ztyansyuyouyobin10x8                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿８ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_KouzahuriStartAnnaiTy_Z ADD CONSTRAINT PK_KouzahuriStartAnnaiTy PRIMARY KEY (
     ztytyouhyouymd                                           , /* （中継用）帳票作成日 */
     ztysyono                                                   /* （中継用）証券番号 */
) ;

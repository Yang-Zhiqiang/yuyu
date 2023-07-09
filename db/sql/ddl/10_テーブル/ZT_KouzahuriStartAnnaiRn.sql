CREATE TABLE ZT_KouzahuriStartAnnaiRn (
     zrnsyoruicd                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）書類コード */
     zrnhassoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発送区分 */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrntyouhyouymdkj                                   VARCHAR     (11)                                                      NOT NULL  ,  /* （連携用）帳票作成日（漢字） */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnyobiv9                                          CHAR        (9)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ９ */
     zrnansyuyouyobin10                                 CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０ */
     zrnshskyno                                         CHAR        (7)                                                       NOT NULL  ,  /* （連携用）送付先郵便番号 */
     zrnshskadr1kj                                      VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所１（漢字） */
     zrnshskadr2kj                                      VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所２（漢字） */
     zrnshskadr3kj                                      VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所３（漢字） */
     zrnshsnmkj                                         VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）送付先名（漢字） */
     zrnyobiv43                                         CHAR        (43)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ４３ */
     zrnansyuyouyobin10x2                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿２ */
     zrntawsosikikj                                     VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先組織名（漢字） */
     zrntawyno                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）問合せ先郵便番号 */
     zrntawadr1kj                                       VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所１（漢字） */
     zrntawadr2kj                                       VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所２（漢字） */
     zrntawadr3kj                                       VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所３（漢字） */
     zrntawtelnov14                                     CHAR        (14)                                                      NOT NULL  ,  /* （連携用）問合せ先電話番号Ｖ１４ */
     zrntawteluktkkanou1                                VARCHAR     (25)                                                      NOT NULL  ,  /* （連携用）問合せ先電話受付可能時間１ */
     zrntawteluktkkanou2                                VARCHAR     (25)                                                      NOT NULL  ,  /* （連携用）問合せ先電話受付可能時間２ */
     zrndai2tawsosikinmkj                               VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）第２問合せ先組織名（漢字） */
     zrndai2tawtelno                                    CHAR        (14)                                                      NOT NULL  ,  /* （連携用）第２問合せ先電話番号 */
     zrnsclatosyono                                     CHAR        (11)                                                      NOT NULL  ,  /* （連携用）スクランブル後証券番号 */
     zrnsakunm15keta                                    CHAR        (15)                                                      NOT NULL  ,  /* （連携用）作成番号（１５桁） */
     zrnyobiv61                                         CHAR        (61)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ６１ */
     zrnansyuyouyobin10x3                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿３ */
     zrntuutinm                                         VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）通知名称 */
     zrnaisatumongon1                                   VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）挨拶文言１ */
     zrnaisatumongon2                                   VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）挨拶文言２ */
     zrnaisatumongon3                                   VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）挨拶文言３ */
     zrnaisatumongon4                                   VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）挨拶文言４ */
     zrnaisatumongon5                                   VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）挨拶文言５ */
     zrnyobiv62                                         CHAR        (62)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ６２ */
     zrnansyuyouyobin10x4                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿４ */
     zrnkzhurikaeonegai1                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替についてのお願い１ */
     zrnkzhurikaeonegai2                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替についてのお願い２ */
     zrnkzhurikaeonegai3                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替についてのお願い３ */
     zrnkzhurikaeonegai4                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替についてのお願い４ */
     zrnkzhurikaeonegai5                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替についてのお願い５ */
     zrnkzhurikaeonegai6                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替についてのお願い６ */
     zrnkzhurikaeonegai7                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替についてのお願い７ */
     zrnkzhurikaeonegai8                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替についてのお願い８ */
     zrnkzhurikaeonegai9                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替についてのお願い９ */
     zrnkzhurikaeonegai10                               VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替についてのお願い１０ */
     zrnkzhurikaeonegai11                               VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替についてのお願い１１ */
     zrnkzhurikaeonegai12                               VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替についてのお願い１２ */
     zrnkzhurikaeonegai13                               VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替についてのお願い１３ */
     zrnkzhurikaeonegai14                               VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替についてのお願い１４ */
     zrnkzhurikaeonegai15                               VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替についてのお願い１５ */
     zrnyobiv210                                        CHAR        (210)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２１０ */
     zrnansyuyouyobin10x5                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿５ */
     zrntuutisakuseiymdseireki                          VARCHAR     (11)                                                      NOT NULL  ,  /* （連携用）通知作成年月日（西暦） */
     zrnsyono2                                          CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号２ */
     zrnsyouhnnm                                        VARCHAR     (40)                                                      NOT NULL  ,  /* （連携用）商品名 */
     zrnkykymdseireki                                   VARCHAR     (11)                                                      NOT NULL  ,  /* （連携用）契約年月日（西暦） */
     zrntkbriphurikaeyoteigk                            CHAR        (13)                                                      NOT NULL  ,  /* （連携用）月払保険料（振替予定金額） */
     zrnhhknnmkj                                        VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）被保険者名（漢字） */
     zrnhurikaekzhosokumongon                           VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）振替口座補足文言 */
     zrnhurikaekz1                                      VARCHAR     (38)                                                      NOT NULL  ,  /* （連携用）振替口座１ */
     zrnhurikaekz2                                      VARCHAR     (38)                                                      NOT NULL  ,  /* （連携用）振替口座２ */
     zrnhurikaekz3                                      VARCHAR     (38)                                                      NOT NULL  ,  /* （連携用）振替口座３ */
     zrnhurikaekz4                                      VARCHAR     (38)                                                      NOT NULL  ,  /* （連携用）振替口座４ */
     zrnhurikaekz5                                      VARCHAR     (38)                                                      NOT NULL  ,  /* （連携用）振替口座５ */
     zrnyobiv124                                        CHAR        (124)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１２４ */
     zrnansyuyouyobin10x7                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿７ */
     zrnkzhuristartanfreearea1                          VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替開始案内フリーエリア１ */
     zrnkzhuristartanfreearea2                          VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替開始案内フリーエリア２ */
     zrnkzhuristartanfreearea3                          VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替開始案内フリーエリア３ */
     zrnkzhuristartanfreearea4                          VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替開始案内フリーエリア４ */
     zrnkzhuristartanfreearea5                          VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替開始案内フリーエリア５ */
     zrnkzhuristartanfreearea6                          VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替開始案内フリーエリア６ */
     zrnkzhuristartanfreearea7                          VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替開始案内フリーエリア７ */
     zrnkzhuristartanfreearea8                          VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替開始案内フリーエリア８ */
     zrnkzhuristartanfreearea9                          VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替開始案内フリーエリア９ */
     zrnkzhuristartanfreearea10                         VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）口座振替開始案内フリーエリア１０ */
     zrnyobiv140                                        CHAR        (140)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１４０ */
     zrnansyuyouyobin10x8                               CHAR        (10)                                                      NOT NULL     /* （連携用）案内収納用予備項目Ｎ１０＿８ */
)
;

ALTER TABLE ZT_KouzahuriStartAnnaiRn ADD CONSTRAINT PK_KouzahuriStartAnnaiRn PRIMARY KEY (
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;

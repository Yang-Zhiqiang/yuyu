CREATE TABLE ZT_KijituTouraiAnnaiRn (
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
     zrnyobiv60                                         CHAR        (60)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ６０ */
     zrnansyuyouyobin10x3                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿３ */
     zrntuutinm                                         VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）通知名称 */
     zrnhurikaeyokokumsg32keta1                         VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３２桁）１ */
     zrnhurikaeyokokumsg32keta2                         VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３２桁）２ */
     zrnhurikaeyokokumsg32keta3                         VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３２桁）３ */
     zrnhurikaeyokokumsg32keta4                         VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３２桁）４ */
     zrnhurikaeyokokumsg32keta5                         VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３２桁）５ */
     zrnhurikaeyokokumsg32keta6                         VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３２桁）６ */
     zrnhurikaeyokokumsg32keta7                         VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３２桁）７ */
     zrnhurikaeyokokumsg32keta8                         VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３２桁）８ */
     zrnyobiv110                                        CHAR        (110)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１１０ */
     zrnansyuyouyobin10x4                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿４ */
     zrnhrkkeiro                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路 */
     zrnsyono2                                          CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号２ */
     zrnsyouhnnm                                        VARCHAR     (40)                                                      NOT NULL  ,  /* （連携用）商品名 */
     zrnkykymdseireki                                   VARCHAR     (11)                                                      NOT NULL  ,  /* （連携用）契約年月日（西暦） */
     zrnhhknnmkj                                        VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）被保険者名（漢字） */
     zrnyobiv30                                         CHAR        (30)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ３０ */
     zrnansyuyouyobin10x5                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿５ */
     zrnkjttrnnfreearea1                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）期日到来案内フリーエリア１ */
     zrnkjttrnnfreearea2                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）期日到来案内フリーエリア２ */
     zrnkjttrnnfreearea3                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）期日到来案内フリーエリア３ */
     zrnkjttrnnfreearea4                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）期日到来案内フリーエリア４ */
     zrnkjttrnnfreearea5                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）期日到来案内フリーエリア５ */
     zrnkjttrnnfreearea6                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）期日到来案内フリーエリア６ */
     zrnkjttrnnfreearea7                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）期日到来案内フリーエリア７ */
     zrnyobiv99                                         CHAR        (99)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ９９ */
     zrnansyuyouyobin10x6                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿６ */
     zrntuutisakuseiymdseireki                          VARCHAR     (11)                                                      NOT NULL  ,  /* （連携用）通知作成年月日（西暦） */
     zrnkzhurikaeymdseireki                             VARCHAR     (11)                                                      NOT NULL  ,  /* （連携用）口座振替日（西暦） */
     zrnkzinfo1                                         VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）口座情報１ */
     zrnkzinfo2                                         VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）口座情報２ */
     zrnkzinfo3                                         VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）口座情報３ */
     zrnkzinfo4                                         VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）口座情報４ */
     zrnkzinfo5                                         VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）口座情報５ */
     zrnkzinfo6                                         VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）口座情報６ */
     zrnkzinfo7                                         VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）口座情報７ */
     zrnkzinfo8                                         VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）口座情報８ */
     zrnhknjytukikan                                    VARCHAR     (18)                                                      NOT NULL  ,  /* （連携用）保険料充当期間 */
     zrnhrkgk1                                          VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）払込金額１ */
     zrnhrkgk2                                          VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）払込金額２ */
     zrnhrkgk3                                          VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）払込金額３ */
     zrnhrkgk4                                          VARCHAR     (27)                                                      NOT NULL  ,  /* （連携用）払込金額４ */
     zrnyobiv146                                        CHAR        (146)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１４６ */
     zrnansyuyouyobin10x7                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿７ */
     zrnkjttrnnfreearea8                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）期日到来案内フリーエリア８ */
     zrnkjttrnnfreearea9                                VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）期日到来案内フリーエリア９ */
     zrnkjttrnnfreearea10                               VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）期日到来案内フリーエリア１０ */
     zrnkjttrnnfreearea11                               VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）期日到来案内フリーエリア１１ */
     zrnkjttrnnfreearea12                               VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）期日到来案内フリーエリア１２ */
     zrnkjttrnnfreearea13                               VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）期日到来案内フリーエリア１３ */
     zrnyobiv84                                         CHAR        (84)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ８４ */
     zrnansyuyouyobin10x8                               CHAR        (10)                                                      NOT NULL     /* （連携用）案内収納用予備項目Ｎ１０＿８ */
)
;

ALTER TABLE ZT_KijituTouraiAnnaiRn ADD CONSTRAINT PK_KijituTouraiAnnaiRn PRIMARY KEY (
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;

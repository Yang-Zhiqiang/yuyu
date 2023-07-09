CREATE TABLE ZT_KouzaHrkmTuutiRn (
     zrnsyoruicd                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）書類コード */
     zrnhassoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発送区分 */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrntyouhyouymdkj                                   VARCHAR     (11)                                                      NOT NULL  ,  /* （連携用）帳票作成日（漢字） */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnsikibetuno                                      CHAR        (20)                                                      NOT NULL  ,  /* （連携用）識別番号 */
     zrnyobiv14                                         CHAR        (14)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１４ */
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
     zrnyobiv62                                         CHAR        (62)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ６２ */
     zrnansyuyouyobin10x3                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿３ */
     zrntuutisakuseiymdV11                              VARCHAR     (11)                                                      NOT NULL  ,  /* （連携用）通知作成年月日Ｖ１１ */
     zrnsyono2                                          CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号２ */
     zrnhrkmymdseireki                                  VARCHAR     (11)                                                      NOT NULL  ,  /* （連携用）振込日（西暦） */
     zrnshrgk                                           CHAR        (13)                                                      NOT NULL  ,  /* （連携用）支払金額 */
     zrnshririyuu1                                      VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）支払理由１ */
     zrnshririyuu2                                      VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）支払理由２ */
     zrnshririyuu3                                      VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）支払理由３ */
     zrnsiteikouza1                                     VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）指定口座１ */
     zrnsiteikouza2                                     VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）指定口座２ */
     zrnsiteikouza3                                     VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）指定口座３ */
     zrnsiteikouza4                                     VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）指定口座４ */
     zrnsiteikouza5                                     VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）指定口座５ */
     zrnyobiv116                                        CHAR        (116)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１１６ */
     zrnansyuyouyobin10x4                               CHAR        (10)                                                      NOT NULL     /* （連携用）案内収納用予備項目Ｎ１０＿４ */
)
;

ALTER TABLE ZT_KouzaHrkmTuutiRn ADD CONSTRAINT PK_KouzaHrkmTuutiRn PRIMARY KEY (
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnsikibetuno                                              /* （連携用）識別番号 */
) ;

CREATE TABLE ZT_TmttHaitoukinMeisaiRn_Z (
     zrnsequenceno                                      DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）シーケンス番号 */
     zrnyuukourecordlength                              DECIMAL     (7)                                                       NOT NULL  ,  /* （連携用）有効レコード長 */
     zrnrdwarea                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）ＲＤＷ領域 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnhrkkeirokbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路区分 */
     zrnannaifuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内不要理由区分 */
     zrnzennendokurikosid                               DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）前年度繰越Ｄ */
     zrntounendod                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）当年度Ｄ */
     zrntounendomatutumitated                           DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）当年度末積立Ｄ */
     zrntumitaterisoku                                  DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）積立利息 */
     zrnhsys                                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）保障Ｓ */
     zrnsyuruicd1                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）種類コード１ */
     zrnsyuruicd3                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）種類コード３ */
     zrnsrutiwake                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）数理用内訳 */
     zrnsrkijyunym                                      CHAR        (6)                                                       NOT NULL  ,  /* （連携用）数理用基準年月 */
     zrnkbnkeiriyousegmentkbn                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）区分経理用セグメント区分 */
     zrnkbnkeiriyourgnbnskkbn                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）区分経理用利源分析区分 */
     zrnsyuruicd2                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）種類コード２ */
     zrnmankitouraiym                                   CHAR        (6)                                                       NOT NULL  ,  /* （連携用）満期到来年月 */
     zrnsyukeiyakusyuruicdv2                            CHAR        (2)                                                       NOT NULL  ,  /* （連携用）主契約種類コードＶ２ */
     zrnkeiyakunendo                                    CHAR        (4)                                                       NOT NULL  ,  /* （連携用）契約年度 */
     zrndaihyouyoteiriritu                              DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）代表予定利率 */
     zrnharaikatakbn                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）払方区分 */
     zrnyobiv20                                         CHAR        (20)                                                      NOT NULL     /* （連携用）予備項目Ｖ２０ */
)
;

ALTER TABLE ZT_TmttHaitoukinMeisaiRn_Z ADD CONSTRAINT PK_TmttHaitoukinMeisaiRn PRIMARY KEY (
     zrnsequenceno                                              /* （連携用）シーケンス番号 */
) ;

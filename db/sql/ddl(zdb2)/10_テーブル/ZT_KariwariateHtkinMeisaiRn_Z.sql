CREATE TABLE ZT_KariwariateHtkinMeisaiRn_Z (
     zrnsequenceno                                      DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）シーケンス番号 */
     zrnyuukourecordlength                              DECIMAL     (7)                                                       NOT NULL  ,  /* （連携用）有効レコード長 */
     zrnrdwarea                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）ＲＤＷ領域 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnhrkkeirokbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路区分 */
     zrnannaifuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内不要理由区分 */
     zrnznnndkrkskrwratdruigk                           DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）前年度繰越仮割当Ｄ累計額 */
     zrntounendokariwariated                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）当年度仮割当Ｄ */
     zrntndmatukrkskrwratdruigk                         DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）当年度末仮割当Ｄ累計額 */
     zrnkariwariatedrisoku                              DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）仮割当Ｄ利息 */
     zrnhsys                                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）保障Ｓ */
     zrnyobiv3                                          CHAR        (3)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ３ */
     zrnsrutiwake                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）数理用内訳 */
     zrnsrkijyunym                                      CHAR        (6)                                                       NOT NULL  ,  /* （連携用）数理用基準年月 */
     zrnkbnkeiriyousegmentkbn                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）区分経理用セグメント区分 */
     zrnkbnkeiriyourgnbnskkbn                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）区分経理用利源分析区分 */
     zrnseisikiwariatenendohyj                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）正式割当年度表示 */
     zrnmankitouraiym                                   CHAR        (6)                                                       NOT NULL  ,  /* （連携用）満期到来年月 */
     zrnsyukeiyakusyuruicdv2                            CHAR        (2)                                                       NOT NULL  ,  /* （連携用）主契約種類コードＶ２ */
     zrnkeiyakunendo                                    CHAR        (4)                                                       NOT NULL  ,  /* （連携用）契約年度 */
     zrndaihyouyoteiriritu                              DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）代表予定利率 */
     zrnharaikatakbn                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）払方区分 */
     zrnyobiv20                                         CHAR        (20)                                                      NOT NULL     /* （連携用）予備項目Ｖ２０ */
)
;

ALTER TABLE ZT_KariwariateHtkinMeisaiRn_Z ADD CONSTRAINT PK_KariwariateHtkinMeisaiRn PRIMARY KEY (
     zrnsequenceno                                              /* （連携用）シーケンス番号 */
) ;

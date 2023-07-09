CREATE TABLE ZT_DshrToukeiRn_Z (
     zrnsequenceno                                      DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）シーケンス番号 */
     zrnyuukourecordlength                              DECIMAL     (7)                                                       NOT NULL  ,  /* （連携用）有効レコード長 */
     zrnrdwarea                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）ＲＤＷ領域 */
     zrnmisskbn                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ミス区分 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrndshrym                                          CHAR        (6)                                                       NOT NULL  ,  /* （連携用）Ｄ支払年月 */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnsrsyoumetucd                                    CHAR        (4)                                                       NOT NULL  ,  /* （連携用）数理用消滅コード */
     zrnsyoricd                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）処理コード */
     zrnkeiyakunendo                                    CHAR        (4)                                                       NOT NULL  ,  /* （連携用）契約年度 */
     zrnannaikigetu                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内期月 */
     zrnshrriyuukbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）支払理由区分 */
     zrnannaikbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）案内区分 */
     zrnduketorihouhoukbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｄ受取方法区分 */
     zrnbikinhyj                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）備金表示 */
     zrnskskbn                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）作成区分 */
     zrnsegcd                                           CHAR        (4)                                                       NOT NULL  ,  /* （連携用）セグメントコード */
     zrnyobiv3                                          CHAR        (3)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ３ */
     zrnsrkensuu                                        DECIMAL     (7)                                                       NOT NULL  ,  /* （連携用）数理用件数 */
     zrnsrhsys                                          DECIMAL     (15)                                                      NOT NULL  ,  /* （連携用）数理用保障Ｓ */
     zrntoujigyounendod                                 DECIMAL     (13)                                                      NOT NULL  ,  /* （連携用）当事業年度Ｄ */
     zrntoujigyounendohasseidrsk                        DECIMAL     (13)                                                      NOT NULL  ,  /* （連携用）当事業年度発生Ｄ利息 */
     zrnzenjigyounendomatudzndk                         DECIMAL     (13)                                                      NOT NULL  ,  /* （連携用）前事業年度末Ｄ残高 */
     zrnyokujigyounendod                                DECIMAL     (13)                                                      NOT NULL  ,  /* （連携用）翌事業年度Ｄ */
     zrnhushrtoujigyounendod                            DECIMAL     (13)                                                      NOT NULL  ,  /* （連携用）不支払当事業年度Ｄ */
     zrnsyukeiyakusyuruicdv2                            CHAR        (2)                                                       NOT NULL  ,  /* （連携用）主契約種類コードＶ２ */
     zrndaihyouyoteiriritu                              DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）代表予定利率 */
     zrnharaikatakbn                                    CHAR        (2)                                                       NOT NULL     /* （連携用）払方区分 */
)
;

ALTER TABLE ZT_DshrToukeiRn_Z ADD CONSTRAINT PK_DshrToukeiRn PRIMARY KEY (
     zrnsequenceno                                              /* （連携用）シーケンス番号 */
) ;

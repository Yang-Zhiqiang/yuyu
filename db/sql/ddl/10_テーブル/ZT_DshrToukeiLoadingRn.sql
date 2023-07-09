CREATE TABLE ZT_DshrToukeiLoadingRn (
     zrnsequenceno                                      NUMBER      (8)                                                       NOT NULL  ,  /* （連携用）シーケンス番号 */
     zrnyuukourecordlength                              NUMBER      (7)                                                       NOT NULL  ,  /* （連携用）有効レコード長 */
     zrnrdwarea                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）ＲＤＷ領域 */
     zrndshrym                                          CHAR        (6)                                                       NOT NULL  ,  /* （連携用）Ｄ支払年月 */
     zrnkeiyakunendo                                    CHAR        (4)                                                       NOT NULL  ,  /* （連携用）契約年度 */
     zrnannaikigetu                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内期月 */
     zrnhknsyruikbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険種類区分 */
     zrnsegcd                                           CHAR        (4)                                                       NOT NULL  ,  /* （連携用）セグメントコード */
     zrnshrriyuukbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）支払理由区分 */
     zrnannaikbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）案内区分 */
     zrnduketorihouhoukbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｄ受取方法区分 */
     zrnsyoumetukbn                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）消滅区分 */
     zrnbikinhyj                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）備金表示 */
     zrnskskbn                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）作成区分 */
     zrnsrkensuu                                        NUMBER      (7)                                                       NOT NULL  ,  /* （連携用）数理用件数 */
     zrnsrhsys                                          NUMBER      (15)                                                      NOT NULL  ,  /* （連携用）数理用保障Ｓ */
     zrntoujigyounendod                                 NUMBER      (13)                                                      NOT NULL  ,  /* （連携用）当事業年度Ｄ */
     zrntoujigyounendohasseidrsk                        NUMBER      (13)                                                      NOT NULL  ,  /* （連携用）当事業年度発生Ｄ利息 */
     zrnzenjigyounendomatudzndk                         NUMBER      (13)                                                      NOT NULL  ,  /* （連携用）前事業年度末Ｄ残高 */
     zrnyokujigyounendod                                NUMBER      (13)                                                      NOT NULL  ,  /* （連携用）翌事業年度Ｄ */
     zrnhushrtoujigyounendod                            NUMBER      (13)                                                      NOT NULL     /* （連携用）不支払当事業年度Ｄ */
)
;

ALTER TABLE ZT_DshrToukeiLoadingRn ADD CONSTRAINT PK_DshrToukeiLoadingRn PRIMARY KEY (
     zrnsequenceno                                              /* （連携用）シーケンス番号 */
) ;

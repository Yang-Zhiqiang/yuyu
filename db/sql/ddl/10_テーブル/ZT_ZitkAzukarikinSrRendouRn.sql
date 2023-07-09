CREATE TABLE ZT_ZitkAzukarikinSrRendouRn (
     zrnsequenceno                                      NUMBER      (8)                                                       NOT NULL  ,  /* （連携用）シーケンス番号 */
     zrnyuukourecordlength                              NUMBER      (7)                                                       NOT NULL  ,  /* （連携用）有効レコード長 */
     zrnrdwarea                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）ＲＤＷ領域 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnjynbknkbn                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）準備金区分 */
     zrnkbnkeiriyousegmentcd                            CHAR        (4)                                                       NOT NULL  ,  /* （連携用）区分経理用セグメントコード */
     zrntndmatuzndk                                     NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）当年度末残高 */
     zrnyoteirisoku                                     NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）予定利息 */
     zrnkeiyakunendo                                    CHAR        (4)                                                       NOT NULL  ,  /* （連携用）契約年度 */
     zrnsuuriyouyobin4                                  CHAR        (4)                                                       NOT NULL  ,  /* （連携用）数理用予備項目Ｎ４ */
     zrnsuuriyouyobin8                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）数理用予備項目Ｎ８ */
     zrnyobin11                                         NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１ */
     zrnyobin11x2                                       NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿２ */
     zrnyobiv93                                         CHAR        (93)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ９３ */
     zrnraysystemhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＲＡＹシステム表示 */
     zrntndmatuzndkgaika                                NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）当年度末残高（外貨） */
     zrnyobiv3                                          CHAR        (3)                                                       NOT NULL     /* （連携用）予備項目Ｖ３ */
)
;

ALTER TABLE ZT_ZitkAzukarikinSrRendouRn ADD CONSTRAINT PK_ZitkAzukarikinSrRendouRn PRIMARY KEY (
     zrnsequenceno                                              /* （連携用）シーケンス番号 */
) ;

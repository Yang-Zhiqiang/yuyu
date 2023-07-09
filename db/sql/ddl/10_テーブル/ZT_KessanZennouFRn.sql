CREATE TABLE ZT_KessanZennouFRn (
     zrnraysystemhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＲＡＹシステム表示 */
     zrnyobiv9                                          CHAR        (9)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ９ */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnkbnkeiriyousegmentcd                            CHAR        (4)                                                       NOT NULL  ,  /* （連携用）区分経理用セグメントコード */
     zrnzennoutoukeilistkbn                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）前納統計リスト区分 */
     zrnzennoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）前納区分 */
     zrnzennoukaisiymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）前納開始年月日 */
     zrnzennoukaisijizndk                               NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）前納開始時残高 */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnzennouwrbkrt                                    NUMBER      (7,6)                                                     NOT NULL  ,  /* （連携用）前納割引率 */
     zrnrthndzndk1                                      NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）利率変動時残高１ */
     zrntkyrt1                                          NUMBER      (7,6)                                                     NOT NULL  ,  /* （連携用）適用利率１ */
     zrnrthndymd1                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）利率変動年月日１ */
     zrnrthndzndk2                                      NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）利率変動時残高２ */
     zrntkyrt2                                          NUMBER      (7,6)                                                     NOT NULL  ,  /* （連携用）適用利率２ */
     zrnrthndymd2                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）利率変動年月日２ */
     zrnrthndzndk3                                      NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）利率変動時残高３ */
     zrntkyrt3                                          NUMBER      (7,6)                                                     NOT NULL  ,  /* （連携用）適用利率３ */
     zrnrthndymd3                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）利率変動年月日３ */
     zrnrthndzndk4                                      NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）利率変動時残高４ */
     zrntkyrt4                                          NUMBER      (7,6)                                                     NOT NULL  ,  /* （連携用）適用利率４ */
     zrnrthndymd4                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）利率変動年月日４ */
     zrntndmatuzndk                                     NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）当年度末残高 */
     zrntndmatutkyrt                                    NUMBER      (7,6)                                                     NOT NULL  ,  /* （連携用）当年度末適用利率 */
     zrnzennounyuukinymd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）前納入金年月日 */
     zrntndzndkhikakukbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）当年度残高比較区分 */
     zrnzennoukikan                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）前納期間 */
     zrnyobi01xv1                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備０１＿Ｖ１ */
     zrnbosyuukeitaikbn                                 CHAR        (2)                                                       NOT NULL  ,  /* （連携用）募集形態区分 */
     zrnyobi02xv11                                      CHAR        (11)                                                      NOT NULL     /* （連携用）予備０２＿Ｖ１１ */
)
;

ALTER TABLE ZT_KessanZennouFRn ADD CONSTRAINT PK_KessanZennouFRn PRIMARY KEY (
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrnkbnkeiriyousegmentcd                                  , /* （連携用）区分経理用セグメントコード */
     zrnzennoutoukeilistkbn                                   , /* （連携用）前納統計リスト区分 */
     zrnzennoukbn                                               /* （連携用）前納区分 */
) ;

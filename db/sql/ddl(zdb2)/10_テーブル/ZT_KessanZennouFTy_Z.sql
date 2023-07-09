CREATE TABLE ZT_KessanZennouFTy_Z (
     ztyraysystemhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）ＲＡＹシステム表示 */
     ztyyobiv9                                          VARCHAR     (9)                                                                 ,  /* （中継用）予備項目Ｖ９ */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztykbnkeiriyousegmentcd                            VARCHAR     (4)                                                       NOT NULL  ,  /* （中継用）区分経理用セグメントコード */
     ztyzennoutoukeilistkbn                             VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）前納統計リスト区分 */
     ztyzennoukbn                                       VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）前納区分 */
     ztyzennoukaisiymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）前納開始年月日 */
     ztyzennoukaisijizndk                               DECIMAL     (11)                                                                ,  /* （中継用）前納開始時残高 */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztyzennouwrbkrt                                    DECIMAL     (7,6)                                                               ,  /* （中継用）前納割引率 */
     ztyrthndzndk1                                      DECIMAL     (11)                                                                ,  /* （中継用）利率変動時残高１ */
     ztytkyrt1                                          DECIMAL     (7,6)                                                               ,  /* （中継用）適用利率１ */
     ztyrthndymd1                                       VARCHAR     (8)                                                                 ,  /* （中継用）利率変動年月日１ */
     ztyrthndzndk2                                      DECIMAL     (11)                                                                ,  /* （中継用）利率変動時残高２ */
     ztytkyrt2                                          DECIMAL     (7,6)                                                               ,  /* （中継用）適用利率２ */
     ztyrthndymd2                                       VARCHAR     (8)                                                                 ,  /* （中継用）利率変動年月日２ */
     ztyrthndzndk3                                      DECIMAL     (11)                                                                ,  /* （中継用）利率変動時残高３ */
     ztytkyrt3                                          DECIMAL     (7,6)                                                               ,  /* （中継用）適用利率３ */
     ztyrthndymd3                                       VARCHAR     (8)                                                                 ,  /* （中継用）利率変動年月日３ */
     ztyrthndzndk4                                      DECIMAL     (11)                                                                ,  /* （中継用）利率変動時残高４ */
     ztytkyrt4                                          DECIMAL     (7,6)                                                               ,  /* （中継用）適用利率４ */
     ztyrthndymd4                                       VARCHAR     (8)                                                                 ,  /* （中継用）利率変動年月日４ */
     ztytndmatuzndk                                     DECIMAL     (11)                                                                ,  /* （中継用）当年度末残高 */
     ztytndmatutkyrt                                    DECIMAL     (7,6)                                                               ,  /* （中継用）当年度末適用利率 */
     ztyzennounyuukinymd                                VARCHAR     (8)                                                                 ,  /* （中継用）前納入金年月日 */
     ztytndzndkhikakukbn                                VARCHAR     (1)                                                                 ,  /* （中継用）当年度残高比較区分 */
     ztyzennoukikan                                     VARCHAR     (2)                                                                 ,  /* （中継用）前納期間 */
     ztyyobi01xv1                                       VARCHAR     (1)                                                                 ,  /* （中継用）予備０１＿Ｖ１ */
     ztybosyuukeitaikbn                                 VARCHAR     (2)                                                                 ,  /* （中継用）募集形態区分 */
     ztyyobi02xv11                                      VARCHAR     (11)                                                                ,  /* （中継用）予備０２＿Ｖ１１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_KessanZennouFTy_Z ADD CONSTRAINT PK_KessanZennouFTy PRIMARY KEY (
     ztysyono                                                 , /* （中継用）証券番号 */
     ztykbnkeiriyousegmentcd                                  , /* （中継用）区分経理用セグメントコード */
     ztyzennoutoukeilistkbn                                   , /* （中継用）前納統計リスト区分 */
     ztyzennoukbn                                               /* （中継用）前納区分 */
) ;

CREATE TABLE ZT_ZitkAzukarikinSrRendouTy (
     ztysequenceno                                      NUMBER      (8)                                                       NOT NULL  ,  /* （中継用）シーケンス番号 */
     ztyyuukourecordlength                              NUMBER      (7)                                                                 ,  /* （中継用）有効レコード長 */
     ztyrdwarea                                         VARCHAR     (4)                                                                 ,  /* （中継用）ＲＤＷ領域 */
     ztysyono                                           VARCHAR     (11)                                                                ,  /* （中継用）証券番号 */
     ztyjynbknkbn                                       VARCHAR     (2)                                                                 ,  /* （中継用）準備金区分 */
     ztykbnkeiriyousegmentcd                            VARCHAR     (4)                                                                 ,  /* （中継用）区分経理用セグメントコード */
     ztytndmatuzndk                                     NUMBER      (11)                                                                ,  /* （中継用）当年度末残高 */
     ztyyoteirisoku                                     NUMBER      (11)                                                                ,  /* （中継用）予定利息 */
     ztykeiyakunendo                                    VARCHAR     (4)                                                                 ,  /* （中継用）契約年度 */
     ztysuuriyouyobin4                                  VARCHAR     (4)                                                                 ,  /* （中継用）数理用予備項目Ｎ４ */
     ztysuuriyouyobin8                                  VARCHAR     (8)                                                                 ,  /* （中継用）数理用予備項目Ｎ８ */
     ztyyobin11                                         NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１ */
     ztyyobin11x2                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿２ */
     ztyyobiv93                                         VARCHAR     (93)                                                                ,  /* （中継用）予備項目Ｖ９３ */
     ztyraysystemhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）ＲＡＹシステム表示 */
     ztytndmatuzndkgaika                                NUMBER      (11)                                                                ,  /* （中継用）当年度末残高（外貨） */
     ztyyobiv3                                          VARCHAR     (3)                                                                 ,  /* （中継用）予備項目Ｖ３ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_ZitkAzukarikinSrRendouTy ADD CONSTRAINT PK_ZitkAzukarikinSrRendouTy PRIMARY KEY (
     ztysequenceno                                              /* （中継用）シーケンス番号 */
) ;

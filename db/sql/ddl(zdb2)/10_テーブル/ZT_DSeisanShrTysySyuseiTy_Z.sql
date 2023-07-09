CREATE TABLE ZT_DSeisanShrTysySyuseiTy_Z (
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyseisandshrymd                                   VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）精算Ｄ支払年月日 */
     ztyseisandkgk11                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （中継用）精算Ｄ金額Ｎ１１ */
     ztytyouseidkgk11                                   DECIMAL     (11)                                                      NOT NULL  ,  /* （中継用）調整Ｄ金額Ｎ１１ */
     ztyyobiv19                                         VARCHAR     (19)                                                      NOT NULL  ,  /* （中継用）予備項目Ｖ１９ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_DSeisanShrTysySyuseiTy_Z ADD CONSTRAINT PK_DSeisanShrTysySyuseiTy PRIMARY KEY (
     ztysyono                                                   /* （中継用）証券番号 */
) ;

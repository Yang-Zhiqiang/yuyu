CREATE TABLE AT_KyoutuuInfo (
     subSystemId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ                                      */
     categoryId                                         VARCHAR     (50)                                                      NOT NULL  ,  /* カテゴリＩＤ                                        */
     kinouId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 機能ＩＤ                                          */
     infoSeqNo                                          VARCHAR     (10)                                                      NOT NULL  ,  /* 情報連番                                          */
     hyoujiYmdFrom                                      VARCHAR     (8)                                                                 ,  /* 表示年月日（自）                                      */
     hyoujiYmdTo                                        VARCHAR     (8)                                                                 ,  /* 表示年月日（至）                                      */
     hyoujiNaiyou                                       VARCHAR     (200)                                                               ,  /* 表示内容                                          */
     infoSikibetuId                                     VARCHAR     (5)                                                                 ,  /* 情報識別ＩＤ                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_KyoutuuInfo ADD CONSTRAINT AT_KyoutuuInfoPk PRIMARY KEY (
     kinouId                                                  , /* 機能ＩＤ                                           */
     infoSeqNo                                                  /* 情報連番                                           */
) ;

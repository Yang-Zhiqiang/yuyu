CREATE TABLE AT_KyoutuuInfo (
     subSystemId                                        varchar     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ                                      */
     categoryId                                         varchar     (50)                                                      NOT NULL  ,  /* カテゴリＩＤ                                        */
     kinouId                                            varchar     (50)                                                      NOT NULL  ,  /* 機能ＩＤ                                          */
     infoSeqNo                                          varchar     (10)                                                      NOT NULL  ,  /* 情報連番                                          */
     hyoujiYmdFrom                                      varchar     (8)                                                                 ,  /* 表示年月日（自）                                      */
     hyoujiYmdTo                                        varchar     (8)                                                                 ,  /* 表示年月日（至）                                      */
     hyoujiNaiyou                                       varchar     (200)                                                               ,  /* 表示内容                                          */
     infoSikibetuId                                     varchar     (5)                                                                 ,  /* 情報識別ＩＤ                                        */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_KyoutuuInfo ADD CONSTRAINT AT_KyoutuuInfoPk PRIMARY KEY (
     kinouId                                                  , /* 機能ＩＤ                                           */
     infoSeqNo                                                  /* 情報連番                                           */
) ;

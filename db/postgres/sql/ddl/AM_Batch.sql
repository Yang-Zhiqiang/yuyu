CREATE TABLE AM_Batch (
     batchId                                            varchar     (50)                                                      NOT NULL  ,  /* バッチＩＤ                                         */
     subSystemId                                        varchar     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ                                      */
     categoryId                                         varchar     (50)                                                      NOT NULL  ,  /* カテゴリＩＤ                                        */
     kinouId                                            varchar     (50)                                                      NOT NULL  ,  /* 機能ＩＤ                                          */
     batchClass                                         varchar     (100)                                                     NOT NULL  ,  /* バッチクラス                                        */
     paramBeanClass                                     varchar     (100)                                                               ,  /* パラメータビーンクラス                                   */
     multiplex                                          varchar     (1)                                                       NOT NULL  ,  /* 多重起動可否                                        */
     batchMode                                          varchar     (1)                                                       NOT NULL  ,  /* バッチ起動モード                                      */
     tyuudanKahi                                        varchar     (1)                                                       NOT NULL  ,  /* 中断可否                                          */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AM_Batch ADD CONSTRAINT AM_BatchPk PRIMARY KEY (
     batchId                                                    /* バッチＩＤ                                          */
) ;

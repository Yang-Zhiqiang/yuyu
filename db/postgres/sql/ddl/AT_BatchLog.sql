CREATE TABLE AT_BatchLog (
     batchJobId                                         varchar     (20)                                                      NOT NULL  ,  /* バッチジョブID                                      */
     batchLogEdaNo                                      decimal     (9)                                                       NOT NULL  ,  /* バッチログ枝番                                       */
     logOutputTime                                      varchar     (17)                                                      NOT NULL  ,  /* ログ出力時間                                        */
     logLevelKbn                                        varchar     (1)                                                       NOT NULL  ,  /* ログレベル区分                                       */
     logNaiyou                                          varchar     (1000)                                                              ,  /* ログ内容                                          */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_BatchLog ADD CONSTRAINT AT_BatchLogPK PRIMARY KEY (
     batchJobId                                               , /* バッチジョブID                                       */
     batchLogEdaNo                                              /* バッチログ枝番                                        */
) ;

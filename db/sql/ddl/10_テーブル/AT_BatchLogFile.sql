CREATE TABLE AT_BatchLogFile (
     batchJobId                                         VARCHAR     (20)                                                      NOT NULL  ,  /* バッチジョブＩＤ                                      */
     uniqueId                                           VARCHAR     (100)                                                     NOT NULL  ,  /* ユニークＩＤ                                        */
     batchSyoriYmd                                      VARCHAR     (8)                                                                 ,  /* バッチ処理年月日                                      */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_BatchLogFile ADD CONSTRAINT AT_BatchLogFilePK PRIMARY KEY (
     batchJobId                                               , /* バッチジョブＩＤ                                       */
     uniqueId                                                   /* ユニークＩＤ                                         */
) ;

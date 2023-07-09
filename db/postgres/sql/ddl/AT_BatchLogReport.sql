CREATE TABLE AT_BatchLogReport (
     batchJobId                                         varchar     (20)                                                      NOT NULL  ,  /* バッチジョブID                                      */
     reportKey                                          varchar     (20)                                                      NOT NULL  ,  /* 帳票キー                                          */
     tyouhyouJoinKey                                    varchar     (20)                                                                ,  /* 帳票結合キー                                        */
     batchSyoriYmd                                      varchar     (8)                                                                 ,  /* バッチ処理年月日                                      */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_BatchLogReport ADD CONSTRAINT AT_BatchReportLogPK PRIMARY KEY (
     batchJobId                                               , /* バッチジョブID                                       */
     reportKey                                                  /* 帳票キー                                           */
) ;

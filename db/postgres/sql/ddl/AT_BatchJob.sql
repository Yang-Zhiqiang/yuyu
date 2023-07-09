CREATE TABLE AT_BatchJob (
     batchJobId                                         varchar     (20)                                                      NOT NULL  ,  /* バッチジョブID                                      */
     batchId                                            varchar     (50)                                                      NOT NULL  ,  /* バッチＩＤ                                         */
     batchKidouKbn                                      varchar     (1)                                                       NOT NULL  ,  /* バッチ起動区分                                       */
     batchJyoutaiKbn                                    varchar     (1)                                                       NOT NULL  ,  /* バッチ状態区分                                       */
     batchResultKbn                                     varchar     (1)                                                                 ,  /* バッチ結果区分                                       */
     batchSyoriYmd                                      varchar     (8)                                                                 ,  /* バッチ処理年月日                                      */
     batchStartTime                                     varchar     (17)                                                                ,  /* バッチ開始時間                                       */
     batchEndTime                                       varchar     (17)                                                                ,  /* バッチ終了時間                                       */
     elapsedTime                                        varchar     (10)                                                                ,  /* 経過時間                                          */
     elapsedSeconds                                     decimal     (18)                                                                ,  /* 経過秒数                                          */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_BatchJob ADD CONSTRAINT AT_BatchJobPk PRIMARY KEY (
     batchJobId                                                 /* バッチジョブID                                       */
) ;

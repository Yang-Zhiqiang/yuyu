CREATE TABLE AT_BatchJob (
     batchJobId                                         VARCHAR     (20)                                                      NOT NULL  ,  /* バッチジョブＩＤ                                      */
     batchId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* バッチＩＤ                                         */
     batchKidouKbn                                      VARCHAR     (1)                                                       NOT NULL  ,  /* バッチ起動区分                                       */
     batchJyoutaiKbn                                    VARCHAR     (1)                                                       NOT NULL  ,  /* バッチ状態区分                                       */
     batchResultKbn                                     VARCHAR     (1)                                                                 ,  /* バッチ結果区分                                       */
     batchSyoriYmd                                      VARCHAR     (8)                                                                 ,  /* バッチ処理年月日                                      */
     batchStartTime                                     VARCHAR     (17)                                                                ,  /* バッチ開始時間                                       */
     batchEndTime                                       VARCHAR     (17)                                                                ,  /* バッチ終了時間                                       */
     elapsedTime                                        VARCHAR     (10)                                                                ,  /* 経過時間                                          */
     elapsedSeconds                                     NUMBER      (18)                                                                ,  /* 経過秒数                                          */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_BatchJob ADD CONSTRAINT AT_BatchJobPk PRIMARY KEY (
     batchJobId                                                 /* バッチジョブＩＤ                                       */
) ;

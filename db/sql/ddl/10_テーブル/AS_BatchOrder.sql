CREATE TABLE AS_BatchOrder (
     batchJobId                                         VARCHAR     (20)                                                      NOT NULL  ,  /* バッチジョブＩＤ                                      */
     kinouId                                            VARCHAR     (50)                                                                ,  /* 機能ＩＤ                                          */
     orderStatus                                        VARCHAR     (1)                                                                 ,  /* 予約状態                                          */
     orderTime                                          VARCHAR     (17)                                                                ,  /* 予約時間                                          */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AS_BatchOrder ADD CONSTRAINT AS_BatchOrderPk PRIMARY KEY (
     batchJobId                                                 /* バッチジョブＩＤ                                       */
) ;

CREATE TABLE BM_MqBatchSosiki_Z (
     kinouId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 機能ＩＤ                                          */
     sosikicd                                           VARCHAR     (7)                                                                 ,  /* 組織コード                                         */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン                                        */
)
;

ALTER TABLE BM_MqBatchSosiki_Z ADD CONSTRAINT PK_MqBatchSosiki PRIMARY KEY (
     kinouId                                                    /* 機能ＩＤ                                           */
) ;

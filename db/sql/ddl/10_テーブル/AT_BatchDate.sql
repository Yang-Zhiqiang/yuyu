CREATE TABLE AT_BatchDate (
     batchExecDate                                      VARCHAR     (8)                                                       NOT NULL  ,  /* バッチ実行日                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_BatchDate ADD CONSTRAINT AT_BatchDatePk PRIMARY KEY (
     batchExecDate                                              /* バッチ実行日                                         */
) ;

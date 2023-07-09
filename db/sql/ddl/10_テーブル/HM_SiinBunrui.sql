CREATE TABLE HM_SiinBunrui (
     siincd                                             VARCHAR     (3)                                                       NOT NULL  ,  /* 死因コード                                         */
     siintyuubunnruicd                                  VARCHAR     (2)                                                                 ,  /* 死因中分類コード                                      */
     tyuusiincd                                         VARCHAR     (2)                                                                 ,  /* 中死因コード                                        */
     daisiincd                                          VARCHAR     (1)                                                                 ,  /* 大死因コード                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HM_SiinBunrui ADD CONSTRAINT PK_SiinBunrui PRIMARY KEY (
     siincd                                                     /* 死因コード                                          */
) ;

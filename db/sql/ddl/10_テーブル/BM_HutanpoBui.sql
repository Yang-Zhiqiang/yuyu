CREATE TABLE BM_HutanpoBui (
     htnpbuicd                                          VARCHAR     (3)                                                       NOT NULL  ,  /* 不担保部位コード                                      */
     htnpbuinm                                          VARCHAR     (30)                                                                ,  /* 不担保部位名                                        */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_HutanpoBui ADD CONSTRAINT PK_HutanpoBui PRIMARY KEY (
     htnpbuicd                                                  /* 不担保部位コード                                       */
) ;

CREATE TABLE BM_DensimeNenkanSchedule (
     syoriym                                            VARCHAR     (6)                                                       NOT NULL  ,  /* 処理年月                                          */
     zengetudensimeymd                                  VARCHAR     (8)                                                                 ,  /* 前月伝票締切日                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_DensimeNenkanSchedule ADD CONSTRAINT PK_DensimeNenkanSchedule PRIMARY KEY (
     syoriym                                                    /* 処理年月                                           */
) ;

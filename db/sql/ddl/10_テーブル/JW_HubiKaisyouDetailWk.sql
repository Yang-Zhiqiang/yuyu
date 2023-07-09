CREATE TABLE JW_HubiKaisyouDetailWk (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ                                        */
     renno3keta                                         NUMBER      (3)                                                       NOT NULL  ,  /* 連番（３桁）                                        */
     hubikaisyouumukbn                                  VARCHAR     (1)                                                                 ,  /* 不備解消有無区分                                      */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE JW_HubiKaisyouDetailWk ADD CONSTRAINT PK_HubiKaisyouDetailWk PRIMARY KEY (
     kouteikanriid                                            , /* 工程管理ＩＤ                                         */
     renno3keta                                                 /* 連番（３桁）                                         */
) ;

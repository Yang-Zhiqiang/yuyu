CREATE TABLE HT_SonotaTkykJktk (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号                                          */
     pmnjtkkbn                                          VARCHAR     (1)                                                       NOT NULL  ,  /* 保険料免除特約区分                                     */
     tknzkkbn                                           VARCHAR     (1)                                                                 ,  /* 特約除き区分                                        */
     seigens                                            NUMBER      (9)                                                                 ,  /* 制限Ｓ                                           */
     seigens$                                           VARCHAR     (10)                                                                ,  /* 制限Ｓ(通貨型)                                      */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HT_SonotaTkykJktk ADD CONSTRAINT PK_SonotaTkykJktk PRIMARY KEY (
     mosno                                                    , /* 申込番号                                           */
     pmnjtkkbn                                                  /* 保険料免除特約区分                                      */
) ;

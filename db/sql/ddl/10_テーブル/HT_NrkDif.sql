CREATE TABLE HT_NrkDif (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号                                          */
     vrfkinouid                                         VARCHAR     (40)                                                      NOT NULL  ,  /* ベリファイ機能ID                                     */
     renno3keta                                         NUMBER      (3)                                                       NOT NULL  ,  /* 連番（３桁）                                        */
     nrksouikm                                          VARCHAR     (30)                                                                ,  /* 入力相違項目                                        */
     itijinyuuroku                                      VARCHAR     (100)                                                               ,  /* １次入力                                          */
     nijinyrk                                           VARCHAR     (100)                                                               ,  /* ２次入力                                          */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HT_NrkDif ADD CONSTRAINT PK_NrkDif PRIMARY KEY (
     mosno                                                    , /* 申込番号                                           */
     vrfkinouid                                               , /* ベリファイ機能ID                                      */
     renno3keta                                                 /* 連番（３桁）                                         */
) ;

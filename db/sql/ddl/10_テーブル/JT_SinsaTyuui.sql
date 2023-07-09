CREATE TABLE JT_SinsaTyuui (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     sinsatyuui                                         VARCHAR     (418)                                                               ,  /* 審査注意                                          */
     sosikinm                                           VARCHAR     (20)                                                                ,  /* 組織名                                           */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード                                       */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE JT_SinsaTyuui ADD CONSTRAINT PK_SinsaTyuui PRIMARY KEY (
     syono                                                      /* 証券番号                                           */
) ;

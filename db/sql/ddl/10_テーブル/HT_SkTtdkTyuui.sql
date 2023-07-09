CREATE TABLE HT_SkTtdkTyuui (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号                                          */
     skeittdkrenrakukbn                                 VARCHAR     (1)                                                       NOT NULL  ,  /* 新契約手続連絡区分                                     */
     datarenno                                          NUMBER      (5)                                                       NOT NULL  ,  /* データ連番                                         */
     skeittdktyuuinaiyou                                VARCHAR     (480)                                                               ,  /* 新契約手続注意内容                                     */
     trkymd                                             VARCHAR     (8)                                                                 ,  /* 登録日                                           */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HT_SkTtdkTyuui ADD CONSTRAINT PK_SkTtdkTyuui PRIMARY KEY (
     mosno                                                    , /* 申込番号                                           */
     skeittdkrenrakukbn                                       , /* 新契約手続連絡区分                                      */
     datarenno                                                  /* データ連番                                          */
) ;

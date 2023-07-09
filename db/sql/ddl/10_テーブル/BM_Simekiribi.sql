CREATE TABLE BM_Simekiribi (
     bosyuuym                                           VARCHAR     (6)                                                       NOT NULL  ,  /* 募集年月                                          */
     mossimefromymd                                     VARCHAR     (8)                                                                 ,  /* 申込締切日自                                        */
     mossimetoymd                                       VARCHAR     (8)                                                                 ,  /* 申込締切日至                                        */
     mosnrksimefromymd                                  VARCHAR     (8)                                                                 ,  /* 申込書入力締切日自                                     */
     mosnrksimetoymd                                    VARCHAR     (8)                                                                 ,  /* 申込書入力締切日至                                     */
     kktsimefromymd                                     VARCHAR     (8)                                                                 ,  /* 告知締切日自                                        */
     kktsimetoymd                                       VARCHAR     (8)                                                                 ,  /* 告知締切日至                                        */
     hjysimefromymd                                     VARCHAR     (8)                                                                 ,  /* 報状締切日自                                        */
     hjysimetoymd                                       VARCHAR     (8)                                                                 ,  /* 報状締切日至                                        */
     nyknsimefromymd                                    VARCHAR     (8)                                                                 ,  /* 入金締切日自                                        */
     nyknsimetoymd                                      VARCHAR     (8)                                                                 ,  /* 入金締切日至                                        */
     syorisimefromymd                                   VARCHAR     (8)                                                                 ,  /* 処理締切日自                                        */
     syorisimetoymd                                     VARCHAR     (8)                                                                 ,  /* 処理締切日至                                        */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_Simekiribi ADD CONSTRAINT PK_Simekiribi PRIMARY KEY (
     bosyuuym                                                   /* 募集年月                                           */
) ;

CREATE TABLE BM_KawaseRate (
     kwsratekjymd                                       VARCHAR     (8)                                                       NOT NULL  ,  /* 為替レート基準日                                      */
     kwsrendoukbn                                       VARCHAR     (1)                                                       NOT NULL  ,  /* 為替レート連動区分                                     */
     mototuuka                                          VARCHAR     (3)                                                       NOT NULL  ,  /* 元通貨                                           */
     kanzantuuka                                        VARCHAR     (3)                                                       NOT NULL  ,  /* 換算通貨                                          */
     kawasetekiyokbn                                    VARCHAR     (3)                                                       NOT NULL  ,  /* 為替適用区分                                        */
     kawasetsrykbn                                      VARCHAR     (1)                                                       NOT NULL  ,  /* 為替手数料区分                                       */
     kawaserate                                         NUMBER      (7,4)                                                               ,  /* 為替レート                                         */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_KawaseRate ADD CONSTRAINT PK_KawaseRate PRIMARY KEY (
     kwsratekjymd                                             , /* 為替レート基準日                                       */
     kwsrendoukbn                                             , /* 為替レート連動区分                                      */
     mototuuka                                                , /* 元通貨                                            */
     kanzantuuka                                              , /* 換算通貨                                           */
     kawasetekiyokbn                                          , /* 為替適用区分                                         */
     kawasetsrykbn                                              /* 為替手数料区分                                        */
) ;

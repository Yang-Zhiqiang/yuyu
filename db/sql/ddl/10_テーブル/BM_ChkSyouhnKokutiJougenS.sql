CREATE TABLE BM_ChkSyouhnKokutiJougenS (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード                                         */
     syusyouhnsdnofrom                                  NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号自                                  */
     syusyouhnsdnoto                                    NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号至                                  */
     hhknfromnen                                        NUMBER      (3)                                                       NOT NULL  ,  /* 被保険者年齢自                                       */
     hhkntonen                                          NUMBER      (3)                                                       NOT NULL  ,  /* 被保険者年齢至                                       */
     moskbnfrom                                         NUMBER      (1)                                                       NOT NULL  ,  /* 申込区分自                                         */
     moskbnto                                           NUMBER      (1)                                                       NOT NULL  ,  /* 申込区分至                                         */
     saikous                                            NUMBER      (13)                                                                ,  /* 最高Ｓ                                           */
     saikous$                                           VARCHAR     (10)                                                                ,  /* 最高Ｓ(通貨型)                                      */
     bairitu                                            NUMBER      (3)                                                                 ,  /* 倍率                                            */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_ChkSyouhnKokutiJougenS ADD CONSTRAINT PK_ChkSyouhnKokutiJougenS PRIMARY KEY (
     syouhncd                                                 , /* 商品コード                                          */
     syusyouhnsdnofrom                                        , /* （主契約）商品世代番号自                                   */
     syusyouhnsdnoto                                          , /* （主契約）商品世代番号至                                   */
     hhknfromnen                                              , /* 被保険者年齢自                                        */
     hhkntonen                                                , /* 被保険者年齢至                                        */
     moskbnfrom                                               , /* 申込区分自                                          */
     moskbnto                                                   /* 申込区分至                                          */
) ;

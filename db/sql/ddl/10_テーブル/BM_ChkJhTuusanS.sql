CREATE TABLE BM_ChkJhTuusanS (
     hhknfromnen                                        NUMBER      (3)                                                       NOT NULL  ,  /* 被保険者年齢自                                       */
     hhkntonen                                          NUMBER      (3)                                                       NOT NULL  ,  /* 被保険者年齢至                                       */
     gnds1                                              NUMBER      (13)                                                                ,  /* 限度Ｓ１                                          */
     gnds1$                                             VARCHAR     (10)                                                                ,  /* 限度Ｓ１(通貨型)                                     */
     gnds2                                              NUMBER      (13)                                                                ,  /* 限度Ｓ２                                          */
     gnds2$                                             VARCHAR     (10)                                                                ,  /* 限度Ｓ２(通貨型)                                     */
     gnds3                                              NUMBER      (13)                                                                ,  /* 限度Ｓ３                                          */
     gnds3$                                             VARCHAR     (10)                                                                ,  /* 限度Ｓ３(通貨型)                                     */
     gnds4                                              NUMBER      (13)                                                                ,  /* 限度Ｓ４                                          */
     gnds4$                                             VARCHAR     (10)                                                                ,  /* 限度Ｓ４(通貨型)                                     */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_ChkJhTuusanS ADD CONSTRAINT PK_ChkJhTuusanS PRIMARY KEY (
     hhknfromnen                                              , /* 被保険者年齢自                                        */
     hhkntonen                                                  /* 被保険者年齢至                                        */
) ;

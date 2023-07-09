CREATE TABLE BM_ChkItijibrTuusanS (
     hhknfromnen                                        NUMBER      (3)                                                       NOT NULL  ,  /* 被保険者年齢自                                       */
     hhkntonen                                          NUMBER      (3)                                                       NOT NULL  ,  /* 被保険者年齢至                                       */
     gnds                                               NUMBER      (13)                                                                ,  /* 限度Ｓ                                           */
     gnds$                                              VARCHAR     (10)                                                                ,  /* 限度Ｓ(通貨型)                                      */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_ChkItijibrTuusanS ADD CONSTRAINT PK_ChkItijibrTuusanS PRIMARY KEY (
     hhknfromnen                                              , /* 被保険者年齢自                                        */
     hhkntonen                                                  /* 被保険者年齢至                                        */
) ;

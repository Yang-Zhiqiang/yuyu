CREATE TABLE BM_ChkSTani (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード                                         */
     syusyouhnsdnofrom                                  NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号自                                  */
     syusyouhnsdnoto                                    NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号至                                  */
     hhknfromnen                                        NUMBER      (3)                                                       NOT NULL  ,  /* 被保険者年齢自                                       */
     hhkntonen                                          NUMBER      (3)                                                       NOT NULL  ,  /* 被保険者年齢至                                       */
     tuukasyu                                           VARCHAR     (3)                                                       NOT NULL  ,  /* 通貨種類                                          */
     stani                                              NUMBER      (13)                                                                ,  /* Ｓ単位                                           */
     stani$                                             VARCHAR     (10)                                                                ,  /* Ｓ単位(通貨型)                                      */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_ChkSTani ADD CONSTRAINT PK_ChkSTani PRIMARY KEY (
     syouhncd                                                 , /* 商品コード                                          */
     syusyouhnsdnofrom                                        , /* （主契約）商品世代番号自                                   */
     syusyouhnsdnoto                                          , /* （主契約）商品世代番号至                                   */
     hhknfromnen                                              , /* 被保険者年齢自                                        */
     hhkntonen                                                , /* 被保険者年齢至                                        */
     tuukasyu                                                   /* 通貨種類                                           */
) ;

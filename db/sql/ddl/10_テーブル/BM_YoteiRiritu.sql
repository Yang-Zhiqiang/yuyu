CREATE TABLE BM_YoteiRiritu (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード                                         */
     tuukasyu                                           VARCHAR     (3)                                                       NOT NULL  ,  /* 通貨種類                                          */
     hhknnenkbn                                         VARCHAR     (1)                                                       NOT NULL  ,  /* 被保険者年齢区分                                      */
     kykfromymd                                         VARCHAR     (8)                                                       NOT NULL  ,  /* 契約日自                                          */
     kyktoymd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 契約日至                                          */
     yoteiriritu                                        NUMBER      (5,4)                                                               ,  /* 予定利率                                          */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_YoteiRiritu ADD CONSTRAINT PK_YoteiRiritu PRIMARY KEY (
     syouhncd                                                 , /* 商品コード                                          */
     tuukasyu                                                 , /* 通貨種類                                           */
     hhknnenkbn                                               , /* 被保険者年齢区分                                       */
     kykfromymd                                               , /* 契約日自                                           */
     kyktoymd                                                   /* 契約日至                                           */
) ;

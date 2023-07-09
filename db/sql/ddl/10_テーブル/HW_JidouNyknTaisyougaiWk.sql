CREATE TABLE HW_JidouNyknTaisyougaiWk (
     nyksyoriymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 入金処理日                                         */
     itirenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 一連番号                                          */
     nykmosno                                           VARCHAR     (20)                                                                ,  /* 入金用申込番号                                       */
     oyadrtencd                                         VARCHAR     (7)                                                                 ,  /* 親代理店コード                                       */
     trhkkgk                                            NUMBER      (13)                                                                ,  /* 取引金額                                          */
     trhkkgk$                                           VARCHAR     (10)                                                                ,  /* 取引金額(通貨型)                                     */
     rstuukasyu                                         VARCHAR     (3)                                                                 ,  /* 領収通貨種類                                        */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日                                         */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HW_JidouNyknTaisyougaiWk ADD CONSTRAINT PK_JidouNyknTaisyougaiWk PRIMARY KEY (
     nyksyoriymd                                              , /* 入金処理日                                          */
     itirenno                                                   /* 一連番号                                           */
) ;

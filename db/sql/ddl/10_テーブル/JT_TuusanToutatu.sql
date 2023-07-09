CREATE TABLE JT_TuusanToutatu (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号                                          */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     seikyuurirekino                                    NUMBER      (3)                                                       NOT NULL  ,  /* 請求履歴番号                                        */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード                                         */
     kyhgndkatakbn                                      VARCHAR     (1)                                                                 ,  /* 給付限度型区分                                       */
     syouhnsdno                                         NUMBER      (2)                                                                 ,  /* 商品世代番号                                        */
     kyksyouhnrenno                                     NUMBER      (2)                                                                 ,  /* 契約商品連番                                        */
     kyuuhucd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 給付コード                                         */
     kouryokuhasseiymd                                  VARCHAR     (8)                                                                 ,  /* 効力発生日                                         */
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

ALTER TABLE JT_TuusanToutatu ADD CONSTRAINT PK_TuusanToutatu PRIMARY KEY (
     skno                                                     , /* 請求番号                                           */
     syono                                                    , /* 証券番号                                           */
     seikyuurirekino                                          , /* 請求履歴番号                                         */
     kyuuhucd                                                   /* 給付コード                                          */
) ;

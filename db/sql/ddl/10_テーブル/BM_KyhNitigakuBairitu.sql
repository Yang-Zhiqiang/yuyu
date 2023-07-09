CREATE TABLE BM_KyhNitigakuBairitu (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード                                         */
     syouhnsdno                                         NUMBER      (2)                                                       NOT NULL  ,  /* 商品世代番号                                        */
     katakbn                                            VARCHAR     (2)                                                       NOT NULL  ,  /* 型区分                                           */
     kyhngbairitu                                       NUMBER      (5,4)                                                               ,  /* 給付日額倍率                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_KyhNitigakuBairitu ADD CONSTRAINT PK_KyhNitigakuBairitu PRIMARY KEY (
     syouhncd                                                 , /* 商品コード                                          */
     syouhnsdno                                               , /* 商品世代番号                                         */
     katakbn                                                    /* 型区分                                            */
) ;

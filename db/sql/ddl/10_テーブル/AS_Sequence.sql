CREATE TABLE AS_Sequence (
     id                                                 VARCHAR     (100)                                                     NOT NULL  ,  /* ＩＤ                                            */
     name                                               VARCHAR     (100)                                                     NOT NULL  ,  /* 名前                                            */
     startWith                                          NUMBER      (18)                                                      NOT NULL  ,  /* 初期値                                           */
     increase                                           NUMBER      (9)                                                       NOT NULL  ,  /* 増分値                                           */
     maxValue                                           NUMBER      (18)                                                      NOT NULL  ,  /* 最大値                                           */
     cacheSize                                          NUMBER      (3)                                                       NOT NULL  ,  /* キャッシュサイズ                                      */
     padding                                            VARCHAR     (1)                                                       NOT NULL  ,  /* ゼロパディング有無                                     */
     length                                             NUMBER      (2)                                                       NOT NULL  ,  /* 桁数                                            */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AS_Sequence ADD CONSTRAINT AS_SequencePk PRIMARY KEY (
     id                                                         /* ＩＤ                                             */
) ;

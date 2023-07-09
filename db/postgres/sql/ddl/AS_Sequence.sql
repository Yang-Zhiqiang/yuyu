CREATE TABLE AS_Sequence (
     id                                                 varchar     (100)                                                     NOT NULL  ,  /* ID                                            */
     name                                               varchar     (100)                                                     NOT NULL  ,  /* 名前                                            */
     startWith                                          decimal     (18)                                                      NOT NULL  ,  /* 初期値                                           */
     increase                                           decimal     (9)                                                       NOT NULL  ,  /* 増分値                                           */
     maxValue                                           decimal     (18)                                                      NOT NULL  ,  /* 最大値                                           */
     cacheSize                                          decimal     (3)                                                       NOT NULL  ,  /* キャッシュサイズ                                      */
     padding                                            varchar     (1)                                                       NOT NULL  ,  /* ゼロパディング有無                                     */
     length                                             decimal     (2)                                                       NOT NULL  ,  /* 桁数                                            */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AS_Sequence ADD CONSTRAINT AS_SequencePk PRIMARY KEY (
     id                                                         /* ID                                             */
) ;

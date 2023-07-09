CREATE TABLE AT_SequenceValue (
     id                                                 varchar     (100)                                                     NOT NULL  ,  /* ID                                            */
     keys                                               varchar     (100)                                                     NOT NULL  ,  /* キー                                            */
     currentValue                                       decimal     (18)                                                      NOT NULL  ,  /* 現在値                                           */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_SequenceValue ADD CONSTRAINT AT_SequenceValuePk PRIMARY KEY (
     id                                                       , /* ID                                             */
     keys                                                       /* キー                                             */
) ;

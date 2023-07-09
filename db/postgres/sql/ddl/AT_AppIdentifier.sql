CREATE TABLE AT_AppIdentifier (
     identifier                                         varchar     (3)                                                       NOT NULL  ,  /* 識別子                                           */
     touchTime                                          varchar     (17)                                                      NOT NULL  ,  /* タッチ時間                                         */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_AppIdentifier ADD CONSTRAINT AT_AppIdentifierPk PRIMARY KEY (
     identifier                                                 /* 識別子                                            */
) ;

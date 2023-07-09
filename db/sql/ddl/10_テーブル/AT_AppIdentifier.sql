CREATE TABLE AT_AppIdentifier (
     identifier                                         VARCHAR     (3)                                                       NOT NULL  ,  /* 識別子                                           */
     touchTime                                          VARCHAR     (17)                                                      NOT NULL  ,  /* タッチ時間                                         */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_AppIdentifier ADD CONSTRAINT AT_AppIdentifierPk PRIMARY KEY (
     identifier                                                 /* 識別子                                            */
) ;

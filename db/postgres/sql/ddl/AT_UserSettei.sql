CREATE TABLE AT_UserSettei (
     userId                                             varchar     (30)                                                      NOT NULL  ,  /* ユーザーID                                        */
     niGamenModKbn                                      decimal     (1)                                                                 ,  /* ２画面モード区分                                      */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_UserSettei ADD CONSTRAINT AT_USerSetteiPk PRIMARY KEY (
     userId                                                     /* ユーザーID                                         */
) ;

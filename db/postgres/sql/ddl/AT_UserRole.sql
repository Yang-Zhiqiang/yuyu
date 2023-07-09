CREATE TABLE AT_UserRole (
     userId                                             varchar     (30)                                                      NOT NULL  ,  /* ユーザーID                                        */
     roleCd                                             varchar     (30)                                                      NOT NULL  ,  /* ロールコード                                        */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_UserRole ADD CONSTRAINT AT_UserRolePk PRIMARY KEY (
     userId                                                   , /* ユーザーID                                         */
     roleCd                                                     /* ロールコード                                         */
) ;

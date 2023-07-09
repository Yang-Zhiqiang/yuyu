CREATE TABLE BW_UserRoleWk (
     userId                                             VARCHAR     (30)                                                      NOT NULL  ,  /* ユーザーＩＤ                                        */
     roleCd                                             VARCHAR     (30)                                                      NOT NULL  ,  /* ロールコード                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BW_UserRoleWk ADD CONSTRAINT PK_UserRoleWk PRIMARY KEY (
     userId                                                   , /* ユーザーＩＤ                                         */
     roleCd                                                     /* ロールコード                                         */
) ;

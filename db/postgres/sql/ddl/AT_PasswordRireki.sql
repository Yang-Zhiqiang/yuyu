CREATE TABLE AT_PasswordRireki (
     uniqueId                                           varchar     (100)                                                     NOT NULL  ,  /* ユニークID                                        */
     userId                                             varchar     (30)                                                                ,  /* ユーザーID                                        */
     password                                           varchar     (128)                                                               ,  /* パスワード                                         */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_PasswordRireki ADD CONSTRAINT AT_PasswordRirekiPK PRIMARY KEY (
     uniqueId                                                   /* ユニークID                                         */
) ;

CREATE INDEX AT_PasswordRirekiIdx1 ON AT_PasswordRireki (
     userId                                                     /* ユーザーID                                         */
) ;

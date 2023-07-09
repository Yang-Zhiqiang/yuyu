CREATE TABLE AT_PasswordRireki_Z (
     uniqueId                                           VARCHAR     (100)                                                     NOT NULL  ,  /* ユニークＩＤ */
     userId                                             VARCHAR     (30)                                                                ,  /* ユーザーＩＤ */
     password                                           VARCHAR     (128)                                                               ,  /* パスワード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_PasswordRireki_Z ADD CONSTRAINT AT_PasswordRirekiPK PRIMARY KEY (
     uniqueId                                                   /* ユニークＩＤ */
) ;

CREATE INDEX AT_PasswordRirekiIdx1 ON AT_PasswordRireki_Z (
     userId                                                     /* ユーザーＩＤ */
) ;

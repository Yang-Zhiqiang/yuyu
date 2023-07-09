CREATE TABLE AT_UserSettei_Z (
     userId                                             VARCHAR     (30)                                                      NOT NULL  ,  /* ユーザーＩＤ */
     niGamenModKbn                                      VARCHAR     (1)                                                                 ,  /* ２画面モード区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_UserSettei_Z ADD CONSTRAINT AT_USerSetteiPk PRIMARY KEY (
     userId                                                     /* ユーザーＩＤ */
) ;

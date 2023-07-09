CREATE TABLE BT_TestKykData (
     uniqueId                                           VARCHAR     (100)                                                     NOT NULL  ,  /* ユニークＩＤ */
     fileNm                                             VARCHAR     (100)                                                               ,  /* ファイル名 */
     testfilecontents                                   BLOB        (10485760)                                                          ,  /* テスト用ファイル内容 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_TestKykData ADD CONSTRAINT PK_TestKykData PRIMARY KEY (
     uniqueId                                                   /* ユニークＩＤ */
) ;

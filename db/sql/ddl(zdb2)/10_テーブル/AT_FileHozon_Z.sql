CREATE TABLE AT_FileHozon_Z (
     uniqueId                                           VARCHAR     (100)                                                     NOT NULL  ,  /* ユニークＩＤ */
     fileContents                                       BLOB        (1048576)                                                           ,  /* ファイル内容 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_FileHozon_Z ADD CONSTRAINT AT_FileHozonPk PRIMARY KEY (
     uniqueId                                                   /* ユニークＩＤ */
) ;

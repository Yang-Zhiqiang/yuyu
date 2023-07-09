CREATE TABLE AT_AccessLogSyousai_Z (
     logId                                              VARCHAR     (20)                                                      NOT NULL  ,  /* ログＩＤ */
     syousaiEdaNo                                       DECIMAL     (10)                                                      NOT NULL  ,  /* 詳細ログ枝番号 */
     logSyousaiData                                     VARCHAR     (10000)                                                             ,  /* ログ詳細データ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_AccessLogSyousai_Z ADD CONSTRAINT AT_AccessLogSyousaiPk PRIMARY KEY (
     logId                                                    , /* ログＩＤ */
     syousaiEdaNo                                               /* 詳細ログ枝番号 */
) ;

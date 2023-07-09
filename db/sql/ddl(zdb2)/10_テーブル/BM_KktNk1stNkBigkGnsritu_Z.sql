CREATE TABLE BM_KktNk1stNkBigkGnsritu_Z (
     ryouritusdno                                       VARCHAR     (3)                                                       NOT NULL  ,  /* 料率世代番号 */
     tuukasyu                                           VARCHAR     (3)                                                       NOT NULL  ,  /* 通貨種類 */
     shrkkn                                             DECIMAL     (2)                                                       NOT NULL  ,  /* 支払期間 */
     nkgnsritu                                          DECIMAL     (12,10)                                                             ,  /* 年金原資率 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_KktNk1stNkBigkGnsritu_Z ADD CONSTRAINT PK_KktNk1stNkBigkGnsritu PRIMARY KEY (
     ryouritusdno                                             , /* 料率世代番号 */
     tuukasyu                                                 , /* 通貨種類 */
     shrkkn                                                     /* 支払期間 */
) ;

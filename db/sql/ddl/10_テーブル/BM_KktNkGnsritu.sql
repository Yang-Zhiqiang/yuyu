CREATE TABLE BM_KktNkGnsritu (
     ryouritusdno                                       VARCHAR     (3)                                                       NOT NULL  ,  /* 料率世代番号 */
     tuukasyu                                           VARCHAR     (3)                                                       NOT NULL  ,  /* 通貨種類 */
     shrkkn                                             NUMBER      (2)                                                       NOT NULL  ,  /* 支払期間 */
     nkgnsritu                                          NUMBER      (12,10)                                                             ,  /* 年金原資率 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     nkgnsritu2                                         NUMBER      (12,10)                                                                /* 年金原資率２ */
)
;

ALTER TABLE BM_KktNkGnsritu ADD CONSTRAINT PK_KktNkGnsritu PRIMARY KEY (
     ryouritusdno                                             , /* 料率世代番号 */
     tuukasyu                                                 , /* 通貨種類 */
     shrkkn                                                     /* 支払期間 */
) ;

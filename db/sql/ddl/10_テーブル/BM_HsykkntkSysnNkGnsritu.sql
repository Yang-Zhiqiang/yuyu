CREATE TABLE BM_HsykkntkSysnNkGnsritu (
     ryouritusdno                                       VARCHAR     (3)                                                       NOT NULL  ,  /* 料率世代番号 */
     tuukasyu                                           VARCHAR     (3)                                                       NOT NULL  ,  /* 通貨種類 */
     seibetu                                            VARCHAR     (1)                                                       NOT NULL  ,  /* 性別 */
     nkshrstartnen                                      NUMBER      (2)                                                       NOT NULL  ,  /* 年金支払開始年齢 */
     hsykkn                                             NUMBER      (2)                                                                 ,  /* 保証期間 */
     nkgnsritu                                          NUMBER      (12,10)                                                             ,  /* 年金原資率 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_HsykkntkSysnNkGnsritu ADD CONSTRAINT PK_HsykkntkSysnNkGnsritu PRIMARY KEY (
     ryouritusdno                                             , /* 料率世代番号 */
     tuukasyu                                                 , /* 通貨種類 */
     seibetu                                                  , /* 性別 */
     nkshrstartnen                                              /* 年金支払開始年齢 */
) ;

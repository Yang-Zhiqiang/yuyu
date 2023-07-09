CREATE TABLE AT_AccessLogSyousai (
     logId                                              VARCHAR     (20)                                                      NOT NULL  ,  /* ログＩＤ                                          */
     syousaiEdaNo                                       NUMBER      (10)                                                      NOT NULL  ,  /* 詳細ログ枝番号                                       */
     logSyousaiData                                     VARCHAR     (4000)                                                              ,  /* ログ詳細データ                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_AccessLogSyousai ADD CONSTRAINT AT_AccessLogSyousaiPk PRIMARY KEY (
     logId                                                    , /* ログＩＤ                                           */
     syousaiEdaNo                                               /* 詳細ログ枝番号                                        */
) ;

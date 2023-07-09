CREATE TABLE AT_AccessLogSyousai (
     logId                                              varchar     (20)                                                      NOT NULL  ,  /* ログID                                          */
     syousaiEdaNo                                       decimal     (10)                                                      NOT NULL  ,  /* 詳細ログ枝番号                                       */
     logSyousaiData                                     varchar     (4000)                                                              ,  /* ログ詳細データ                                       */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_AccessLogSyousai ADD CONSTRAINT AT_AccessLogSyousaiPk PRIMARY KEY (
     logId                                                    , /* ログID                                           */
     syousaiEdaNo                                               /* 詳細ログ枝番号                                        */
) ;

CREATE TABLE AT_AccessLog (
     logId                                              varchar     (20)                                                      NOT NULL  ,  /* ログID                                          */
     timeStamp                                          decimal     (20)                                                      NOT NULL  ,  /* アクセスログ出力時刻                                    */
     syoriUserId                                        varchar     (30)                                                                ,  /* 処理ユーザーID                                      */
     ipAddress                                          varchar     (15)                                                                ,  /* IPアドレス                                        */
     sessionId                                          varchar     (100)                                                               ,  /* セッションID                                       */
     transactionId                                      varchar     (17)                                                                ,  /* トランザクションID                                    */
     logKindCd                                          varchar     (16)                                                      NOT NULL  ,  /* ログ種別コード                                       */
     subSystemId                                        varchar     (50)                                                                ,  /* サブシステムＩＤ                                      */
     categoryId                                         varchar     (50)                                                                ,  /* カテゴリＩＤ                                        */
     kinouId                                            varchar     (50)                                                                ,  /* 機能ＩＤ                                          */
     logData                                            varchar     (4000)                                                              ,  /* ログデータ                                         */
     syousaiKensuu                                      decimal     (10)                                                      NOT NULL  ,  /* 詳細ログ件数                                        */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_AccessLog ADD CONSTRAINT AT_AccessLogPk PRIMARY KEY (
     logId                                                      /* ログID                                           */
) ;

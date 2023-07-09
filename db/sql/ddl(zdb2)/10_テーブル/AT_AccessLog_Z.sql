CREATE TABLE AT_AccessLog_Z (
     logId                                              VARCHAR     (20)                                                      NOT NULL  ,  /* ログＩＤ */
     timeStamp                                          DECIMAL     (20)                                                      NOT NULL  ,  /* アクセスログ出力時刻 */
     syoriUserId                                        VARCHAR     (30)                                                                ,  /* 処理ユーザーＩＤ */
     ipAddress                                          VARCHAR     (15)                                                                ,  /* ＩＰアドレス */
     sessionId                                          VARCHAR     (100)                                                               ,  /* セッションＩＤ */
     transactionId                                      VARCHAR     (17)                                                                ,  /* トランザクションＩＤ */
     logKindCd                                          VARCHAR     (16)                                                      NOT NULL  ,  /* ログ種別コード */
     subSystemId                                        VARCHAR     (50)                                                                ,  /* サブシステムＩＤ */
     categoryId                                         VARCHAR     (50)                                                                ,  /* カテゴリＩＤ */
     kinouId                                            VARCHAR     (50)                                                                ,  /* 機能ＩＤ */
     tanmatuType                                        VARCHAR     (1)                                                                 ,  /* 端末タイプ */
     butsuriSosikiCd                                    VARCHAR     (7)                                                                 ,  /* 物理組織コード */
     ronriSosikiCd                                      VARCHAR     (7)                                                                 ,  /* 論理組織コード */
     tanmatuJyoutaiHyouji                               VARCHAR     (1)                                                                 ,  /* 端末状態表示 */
     logData                                            VARCHAR     (10000)                                                             ,  /* ログデータ */
     syousaiKensuu                                      DECIMAL     (10)                                                      NOT NULL  ,  /* 詳細ログ件数 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_AccessLog_Z ADD CONSTRAINT AT_AccessLogPk PRIMARY KEY (
     logId                                                      /* ログＩＤ */
) ;

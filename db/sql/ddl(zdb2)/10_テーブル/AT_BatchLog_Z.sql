CREATE TABLE AT_BatchLog_Z (
     batchJobId                                         VARCHAR     (20)                                                      NOT NULL  ,  /* バッチジョブＩＤ */
     batchLogEdaNo                                      DECIMAL     (9)                                                       NOT NULL  ,  /* バッチログ枝番 */
     logOutputTime                                      VARCHAR     (17)                                                      NOT NULL  ,  /* ログ出力時間 */
     logLevelKbn                                        VARCHAR     (1)                                                       NOT NULL  ,  /* ログレベル区分 */
     logNaiyou                                          VARCHAR     (2500)                                                              ,  /* ログ内容 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_BatchLog_Z ADD CONSTRAINT AT_BatchLogPK PRIMARY KEY (
     batchJobId                                               , /* バッチジョブＩＤ */
     batchLogEdaNo                                              /* バッチログ枝番 */
) ;

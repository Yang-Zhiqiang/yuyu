CREATE VIEW AT_BatchLog AS SELECT
     batchJobId ,         /* バッチジョブＩＤ */
     batchLogEdaNo ,         /* バッチログ枝番 */
     logOutputTime ,         /* ログ出力時間 */
     logLevelKbn ,         /* ログレベル区分 */
     logNaiyou ,         /* ログ内容 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_BatchLog_Z;
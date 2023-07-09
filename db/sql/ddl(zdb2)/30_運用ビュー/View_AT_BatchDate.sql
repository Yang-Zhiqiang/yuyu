CREATE VIEW AT_BatchDate AS SELECT
     batchExecDate ,         /* バッチ実行日 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_BatchDate_Z;
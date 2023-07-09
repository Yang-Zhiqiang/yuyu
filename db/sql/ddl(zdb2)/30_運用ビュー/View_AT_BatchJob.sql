CREATE VIEW AT_BatchJob AS SELECT
     batchJobId ,         /* バッチジョブＩＤ */
     batchId ,         /* バッチＩＤ */
     batchKidouKbn ,         /* バッチ起動区分 */
     batchJyoutaiKbn ,         /* バッチ状態区分 */
     batchResultKbn ,         /* バッチ結果区分 */
     batchSyoriYmd ,         /* バッチ処理年月日 */
     batchStartTime ,         /* バッチ開始時間 */
     batchEndTime ,         /* バッチ終了時間 */
     elapsedTime ,         /* 経過時間 */
     elapsedSeconds ,         /* 経過秒数 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_BatchJob_Z;
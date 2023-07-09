CREATE VIEW AS_BatchOrder AS SELECT
     batchJobId ,         /* バッチジョブＩＤ */
     kinouId ,         /* 機能ＩＤ */
     orderStatus ,         /* 予約状態 */
     orderTime ,         /* 予約時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AS_BatchOrder_Z;
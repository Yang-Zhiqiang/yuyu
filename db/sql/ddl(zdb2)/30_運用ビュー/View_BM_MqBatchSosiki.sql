CREATE VIEW BM_MqBatchSosiki AS SELECT
     kinouId ,         /* 機能ＩＤ */
     sosikicd ,         /* 組織コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_MqBatchSosiki_Z;
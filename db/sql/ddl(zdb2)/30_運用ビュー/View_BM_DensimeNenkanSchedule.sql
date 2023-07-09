CREATE VIEW BM_DensimeNenkanSchedule AS SELECT
     syoriym ,         /* 処理年月 */
     zengetudensimeymd ,         /* 前月伝票締切日 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_DensimeNenkanSchedule_Z;
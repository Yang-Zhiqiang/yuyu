CREATE VIEW AT_BatchLogReport AS SELECT
     batchJobId ,         /* バッチジョブＩＤ */
     reportKey ,         /* 帳票キー */
     tyouhyouJoinKey ,         /* 帳票結合キー */
     batchSyoriYmd ,         /* バッチ処理年月日 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_BatchLogReport_Z;
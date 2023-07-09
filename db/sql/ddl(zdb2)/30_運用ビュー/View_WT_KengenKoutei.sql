CREATE VIEW WT_KengenKoutei AS SELECT
     roleCd ,         /* ロールコード */
     flowId ,         /* フローＩＤ */
     nodeId ,         /* ノードＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM WT_KengenKoutei_Z;
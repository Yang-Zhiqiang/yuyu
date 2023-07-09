CREATE VIEW DM_JimutetuzukiTaskRireki AS SELECT
     kensuuHokanYmd ,         /* 件数保管日 */
     subSystemId ,         /* サブシステムＩＤ */
     jimutetuzukicd ,         /* 事務手続コード */
     workflowTskId ,         /* ワークフロータスクID */
     workflowTskNm ,         /* ワークフロータスク名 */
     hyoujijyun ,         /* 表示順 */
     worklistHyoujiFlag ,         /* 工程ワークリスト表示フラグ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM DM_JimutetuzukiTaskRireki_Z;
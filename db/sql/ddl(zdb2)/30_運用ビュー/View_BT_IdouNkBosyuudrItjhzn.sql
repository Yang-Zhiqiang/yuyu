CREATE VIEW BT_IdouNkBosyuudrItjhzn AS SELECT
     nksysyno ,         /* 年金証書番号 */
     renno3keta ,         /* 連番（３桁） */
     dairitencd1 ,         /* 代理店コード１ */
     bunwari1 ,         /* 分担割合１ */
     dairitencd2 ,         /* 代理店コード２ */
     bunwari2 ,         /* 分担割合２ */
     kanrisosikicd1 ,         /* 管理組織コード１ */
     kanrisosikicd2 ,         /* 管理組織コード２ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_IdouNkBosyuudrItjhzn_Z;
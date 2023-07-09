CREATE VIEW BM_WariateHukaInfoKanri AS SELECT
     subSystemId ,         /* サブシステムＩＤ */
     jimutetuzukicd ,         /* 事務手続コード */
     currenttskid ,         /* 現在タスクID */
     renno ,         /* 連番 */
     nexttskid ,         /* 次回タスクID */
     wrthukatskid ,         /* 割当不可タスクID */
     wrthukakaijyotskid ,         /* 割当不可解除用タスクID */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_WariateHukaInfoKanri_Z;
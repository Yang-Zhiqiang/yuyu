CREATE VIEW BT_WariateHukaInfo AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     subSystemId ,         /* サブシステムＩＤ */
     jimutetuzukicd ,         /* 事務手続コード */
     wrthukatskid ,         /* 割当不可タスクID */
     userId ,         /* ユーザーＩＤ */
     wrthukakaijyotskid ,         /* 割当不可解除用タスクID */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_WariateHukaInfo_Z;
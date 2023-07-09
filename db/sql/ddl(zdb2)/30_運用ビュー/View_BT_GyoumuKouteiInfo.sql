CREATE VIEW BT_GyoumuKouteiInfo AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     subSystemId ,         /* サブシステムＩＤ */
     jimutetuzukicd ,         /* 事務手続コード */
     mosno ,         /* 申込番号 */
     syono ,         /* 証券番号 */
     skno ,         /* 請求番号 */
     nksysyno ,         /* 年金証書番号 */
     syukouteikanriid ,         /* 主工程管理ＩＤ */
     syukouteijimutetuzukicd ,         /* 主工程事務手続コード */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_GyoumuKouteiInfo_Z;
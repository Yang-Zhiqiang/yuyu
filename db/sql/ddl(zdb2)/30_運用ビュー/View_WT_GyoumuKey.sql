CREATE VIEW WT_GyoumuKey AS SELECT
     flowId ,         /* フローＩＤ */
     gyoumuKey ,         /* 業務キー */
     tokenId ,         /* トークンＩＤ */
     createTime ,         /* 作成日時 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM WT_GyoumuKey_Z;
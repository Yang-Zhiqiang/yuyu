CREATE VIEW WT_KouteiLock AS SELECT
     lockTime ,         /* ロック時間 */
     lockKey ,         /* ロックキー */
     gyoumuKey ,         /* 業務キー */
     flowId ,         /* フローＩＤ */
     userId ,         /* ユーザーＩＤ */
     nodeNm ,         /* ノード名 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM WT_KouteiLock_Z;
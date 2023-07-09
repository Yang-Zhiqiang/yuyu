CREATE VIEW WT_KouteiRireki AS SELECT
     tokenId ,         /* トークンＩＤ */
     gyoumuKey ,         /* 業務キー */
     rirekiKbn ,         /* 履歴区分 */
     syoriTime ,         /* 処理時間 */
     flowId ,         /* フローＩＤ */
     nodeId ,         /* ノードＩＤ */
     nodeNm ,         /* ノード名 */
     userId ,         /* ユーザーＩＤ */
     iwfSyoriKbn ,         /* IWF処理区分 */
     rrkMsg ,         /* 履歴メッセージ */
     extInfo ,         /* 付加情報 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM WT_KouteiRireki_Z;
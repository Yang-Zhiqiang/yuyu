CREATE VIEW AT_MqInfo AS SELECT
     serverType ,         /* サーバ種別 */
     mqOnlineStatus ,         /* ＭＱオンライン状態区分 */
     mqEmgcyStopStatus ,         /* ＭＱ緊急停止状態区分 */
     rkmAtesaki ,         /* 連携元宛先 */
     contextPath ,         /* コンテキストパス */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_MqInfo_Z;
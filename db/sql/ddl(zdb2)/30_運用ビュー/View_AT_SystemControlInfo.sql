CREATE VIEW AT_SystemControlInfo AS SELECT
     systemCtrlInfo ,         /* システム制御情報 */
     mqEmgcyStopStatus ,         /* ＭＱ緊急停止状態区分 */
     onlineStatus ,         /* オンライン状態区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_SystemControlInfo_Z;
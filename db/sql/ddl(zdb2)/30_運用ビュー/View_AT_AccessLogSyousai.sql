CREATE VIEW AT_AccessLogSyousai AS SELECT
     logId ,         /* ログＩＤ */
     syousaiEdaNo ,         /* 詳細ログ枝番号 */
     logSyousaiData ,         /* ログ詳細データ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_AccessLogSyousai_Z;
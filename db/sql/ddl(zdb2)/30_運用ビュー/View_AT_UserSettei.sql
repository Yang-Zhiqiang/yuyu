CREATE VIEW AT_UserSettei AS SELECT
     userId ,         /* ユーザーＩＤ */
     niGamenModKbn ,         /* ２画面モード区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_UserSettei_Z;
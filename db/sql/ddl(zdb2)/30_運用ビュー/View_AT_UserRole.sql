CREATE VIEW AT_UserRole AS SELECT
     userId ,         /* ユーザーＩＤ */
     roleCd ,         /* ロールコード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_UserRole_Z;
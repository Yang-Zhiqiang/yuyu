CREATE VIEW BW_UserRoleWk AS SELECT
     userId ,         /* ユーザーＩＤ */
     roleCd ,         /* ロールコード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BW_UserRoleWk_Z;
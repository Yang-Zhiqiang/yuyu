CREATE VIEW AT_PasswordRireki AS SELECT
     uniqueId ,         /* ユニークＩＤ */
     userId ,         /* ユーザーＩＤ */
     password ,         /* パスワード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_PasswordRireki_Z;
CREATE VIEW AT_UserRoleRireki AS SELECT
     uniqueId ,         /* ユニークＩＤ */
     userId ,         /* ユーザーＩＤ */
     roleCd ,         /* ロールコード */
     rirekiSyuruiKbn ,         /* 履歴種類区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_UserRoleRireki_Z;
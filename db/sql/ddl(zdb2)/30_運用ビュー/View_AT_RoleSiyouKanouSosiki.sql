CREATE VIEW AT_RoleSiyouKanouSosiki AS SELECT
     syozokusosikicd ,         /* 所属組織コード */
     roleCd ,         /* ロールコード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_RoleSiyouKanouSosiki_Z;
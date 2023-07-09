CREATE VIEW AT_SosikiRole AS SELECT
     tanmatusettisosikicd ,         /* 端末設置組織コード */
     roleCd ,         /* ロールコード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_SosikiRole_Z;
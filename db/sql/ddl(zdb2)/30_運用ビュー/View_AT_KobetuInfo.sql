CREATE VIEW AT_KobetuInfo AS SELECT
     userId ,         /* ユーザーＩＤ */
     infoSeqNo ,         /* 情報連番 */
     hyoujiYmdFrom ,         /* 表示年月日（自） */
     hyoujiYmdTo ,         /* 表示年月日（至） */
     hyoujiNaiyou ,         /* 表示内容 */
     infoSikibetuId ,         /* 情報識別ＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_KobetuInfo_Z;
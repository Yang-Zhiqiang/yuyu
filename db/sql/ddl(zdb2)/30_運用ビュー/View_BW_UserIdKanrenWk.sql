CREATE VIEW BW_UserIdKanrenWk AS SELECT
     idkbn ,         /* ＩＤ区分 */
     idcd ,         /* ＩＤコード */
     userId ,         /* ユーザーＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BW_UserIdKanrenWk_Z;
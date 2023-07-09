CREATE VIEW AT_FileHozon AS SELECT
     uniqueId ,         /* ユニークＩＤ */
     fileContents ,         /* ファイル内容 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_FileHozon_Z;
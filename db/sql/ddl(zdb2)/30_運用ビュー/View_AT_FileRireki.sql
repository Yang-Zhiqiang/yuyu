CREATE VIEW AT_FileRireki AS SELECT
     uniqueId ,         /* ユニークＩＤ */
     historyId ,         /* 履歴ＩＤ */
     fileNm ,         /* ファイル名 */
     fileSize ,         /* ファイルサイズ */
     fileContents ,         /* ファイル内容 */
     tourokuTime ,         /* 登録時間 */
     fileNmSuffix ,         /* ファイル名サフィックス */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_FileRireki_Z;
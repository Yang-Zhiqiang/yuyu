CREATE VIEW BT_TestKykData AS SELECT
     uniqueId ,         /* ユニークＩＤ */
     fileNm ,         /* ファイル名 */
     testfilecontents ,         /* テスト用ファイル内容 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_TestKykData_Z;
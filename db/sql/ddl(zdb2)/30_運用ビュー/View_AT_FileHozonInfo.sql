CREATE VIEW AT_FileHozonInfo AS SELECT
     uniqueId ,         /* ユニークＩＤ */
     fileNm ,         /* ファイル名 */
     fileSyuruiCd ,         /* ファイル種類コード */
     fileStatusKbn ,         /* ファイルステータス区分 */
     haitaKey ,         /* 排他キー */
     tourokuTime ,         /* 登録時間 */
     sakuseiKinouId ,         /* 作成機能ＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_FileHozonInfo_Z;
CREATE VIEW AS_FileHozonKikan AS SELECT
     fileSyuruiCd ,         /* ファイル種類コード */
     hozonKikan ,         /* 保存期間 */
     nengappiKbn ,         /* 年月日区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AS_FileHozonKikan_Z;
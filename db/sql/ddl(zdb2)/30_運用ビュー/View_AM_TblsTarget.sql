CREATE VIEW AM_TblsTarget AS SELECT
     baseTableId ,         /* （ベース）テーブルID */
     baseTableNm ,         /* （ベース）テーブル名 */
     subSystemId ,         /* サブシステムＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AM_TblsTarget_Z;
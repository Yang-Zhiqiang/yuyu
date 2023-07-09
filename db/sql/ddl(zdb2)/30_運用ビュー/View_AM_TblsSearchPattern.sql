CREATE VIEW AM_TblsSearchPattern AS SELECT
     baseTableId ,         /* （ベース）テーブルID */
     baseSearchDdId ,         /* （ベース）検索項目ID */
     baseSearchPtnNm ,         /* （ベース）検索パターン名 */
     sortNo ,         /* ソート番号 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AM_TblsSearchPattern_Z;
CREATE VIEW AM_TblsRefLimitSosiki AS SELECT
     baseTableId ,         /* （ベース）テーブルID */
     baseDdId ,         /* （ベース）項目ID */
     tanmatusettisosikicd ,         /* 端末設置組織コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AM_TblsRefLimitSosiki_Z;
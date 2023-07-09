CREATE VIEW WT_PDFHozon AS SELECT
     iwfImageId ,         /* IWFイメージＩＤ */
     pageId ,         /* ページＩＤ */
     pdfData ,         /* ＰＤＦデータ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM WT_PDFHozon_Z;
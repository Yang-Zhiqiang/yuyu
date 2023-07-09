CREATE VIEW WT_Page AS SELECT
     iwfImageId ,         /* IWFイメージＩＤ */
     syoruittykymdtime ,         /* 書類到着日時 */
     pageno ,         /* ページ番号 */
     pageId ,         /* ページＩＤ */
     torikomiSousasyaId ,         /* 取込操作者ＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM WT_Page_Z;
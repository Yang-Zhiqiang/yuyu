CREATE VIEW AS_Category AS SELECT
     categoryId ,         /* カテゴリＩＤ */
     subSystemId ,         /* サブシステムＩＤ */
     categoryNm ,         /* カテゴリ名 */
     sortNo ,         /* ソート番号 */
     linkImage ,         /* リンクイメージ */
     titleStyle ,         /* タイトルスタイル */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AS_Category_Z;
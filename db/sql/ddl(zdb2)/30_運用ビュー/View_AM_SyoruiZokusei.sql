CREATE VIEW AM_SyoruiZokusei AS SELECT
     syoruiCd ,         /* 書類コード */
     syoruinm ,         /* 書類名 */
     syoruinmryaku ,         /* 書類名（略称） */
     tyouhyouid ,         /* 帳票フォームＩＤ */
     hozonKikan ,         /* 保存期間 */
     nengetukbn ,         /* 年月区分 */
     angoukaKbn ,         /* 暗号化区分 */
     pdfHozonKbn ,         /* ＰＤＦ保存区分 */
     zipHozonKbn ,         /* ＺＩＰ保存区分 */
     pageCount ,         /* ページ数 */
     sortNo ,         /* ソート番号 */
     kensakuKey1 ,         /* 検索キー１ */
     kensakuKey2 ,         /* 検索キー２ */
     kensakuKey3 ,         /* 検索キー３ */
     kensakuKey4 ,         /* 検索キー４ */
     kensakuKey5 ,         /* 検索キー５ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AM_SyoruiZokusei_Z;
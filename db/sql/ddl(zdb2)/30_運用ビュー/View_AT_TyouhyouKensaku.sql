CREATE VIEW AT_TyouhyouKensaku AS SELECT
     uniqueId ,         /* ユニークＩＤ */
     reportKey ,         /* 帳票キー */
     syoruiCd ,         /* 書類コード */
     subSystemId ,         /* サブシステムＩＤ */
     categoryId ,         /* カテゴリＩＤ */
     kinouId ,         /* 機能ＩＤ */
     kensakuKey1 ,         /* 検索キー１ */
     kensakuKey2 ,         /* 検索キー２ */
     kensakuKey3 ,         /* 検索キー３ */
     kensakuKey4 ,         /* 検索キー４ */
     kensakuKey5 ,         /* 検索キー５ */
     syoriYmd ,         /* 処理年月日 */
     firstOutYmd ,         /* 初回出力年月日 */
     lastOutYmd ,         /* 最終出力年月日 */
     outCount ,         /* 出力回数 */
     lastOutUserId ,         /* 最終出力ユーザーＩＤ */
     syoruiKetugouUmuKbn ,         /* 書類結合有無区分 */
     fileSize ,         /* ファイルサイズ */
     pageCount ,         /* ページ数 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_TyouhyouKensaku_Z;
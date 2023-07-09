CREATE VIEW BM_YoteiRiritu3 AS SELECT
     syouhncd ,         /* 商品コード */
     tuukasyu ,         /* 通貨種類 */
     yoteiriritutkybr1 ,         /* 予定利率適用分類１ */
     yoteiriritutkybr2 ,         /* 予定利率適用分類２ */
     kijyunfromymd ,         /* 基準日自 */
     kijyuntoymd ,         /* 基準日至 */
     yoteiriritu ,         /* 予定利率 */
     tumitateriritu ,         /* 積立利率 */
     tmttknzoukaritujygn ,         /* 積立金増加率上限 */
     setteibairitu ,         /* 設定倍率 */
     loadinghnkgtumitateriritu ,         /* ローディング変更後積立利率 */
     rendouritu ,         /* 連動率 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_YoteiRiritu3_Z;
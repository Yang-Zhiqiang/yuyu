CREATE VIEW BM_SjkkkTyouseiyouRiritu2 AS SELECT
     syouhncd ,         /* 商品コード */
     sjkkktyouseiriritutkybr1 ,         /* 市場価格調整用利率適用分類１ */
     sjkkktyouseiriritutkybr2 ,         /* 市場価格調整用利率適用分類２ */
     kijyunfromymd ,         /* 基準日自 */
     kijyuntoymd ,         /* 基準日至 */
     tuukasyu ,         /* 通貨種類 */
     sjkkktyouseiyouriritu ,         /* 市場価格調整用利率 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_SjkkkTyouseiyouRiritu2_Z;
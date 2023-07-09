CREATE VIEW BM_SjkkkTyouseiyouRiritu AS SELECT
     syouhncd ,         /* 商品コード */
     tuukasyu ,         /* 通貨種類 */
     hhknnenkbn ,         /* 被保険者年齢区分 */
     kykfromymd ,         /* 契約日自 */
     kyktoymd ,         /* 契約日至 */
     sjkkktyouseiyouriritu ,         /* 市場価格調整用利率 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_SjkkkTyouseiyouRiritu_Z;
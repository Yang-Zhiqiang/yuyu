CREATE VIEW HT_KnksateiRireki AS SELECT
     mosno ,         /* 申込番号 */
     renno ,         /* 連番 */
     syoriYmd ,         /* 処理年月日 */
     sateiketsyorinmkbn ,         /* 査定・決定処理名区分 */
     knksateikekkakbn ,         /* 環境査定結果区分 */
     tnsketsyacd ,         /* 転送先決定者コード */
     ketsyacd ,         /* 決定者コード */
     palketsyacd ,         /* ＰＡＬ決定者コード */
     knksateicomment ,         /* 環境査定コメント */
     ketkekkacd ,         /* 決定結果コード */
     ketriyuucd1 ,         /* 決定理由コード１ */
     ketriyuucd2 ,         /* 決定理由コード２ */
     ketriyuucd3 ,         /* 決定理由コード３ */
     ketriyuucd4 ,         /* 決定理由コード４ */
     mrriyuucdkbn ,         /* ＭＲ理由コード区分 */
     torikesisyousairiyuucd ,         /* 取消詳細理由コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_KnksateiRireki_Z;
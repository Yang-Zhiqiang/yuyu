CREATE VIEW HT_MostenkenRireki AS SELECT
     mosno ,         /* 申込番号 */
     renno ,         /* 連番 */
     syoriYmd ,         /* 処理年月日 */
     sateiketsyorinmkbn ,         /* 査定・決定処理名区分 */
     mostenkenkekkakbn ,         /* 申込点検結果区分 */
     tnsketsyacd ,         /* 転送先決定者コード */
     ketsyacd ,         /* 決定者コード */
     palketsyacd ,         /* ＰＡＬ決定者コード */
     mostenkencomment ,         /* 申込点検コメント */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_MostenkenRireki_Z;
CREATE VIEW HT_ImusateiRireki AS SELECT
     mosno ,         /* 申込番号 */
     renno ,         /* 連番 */
     syoriYmd ,         /* 処理年月日 */
     sateiketsyorinmkbn ,         /* 査定・決定処理名区分 */
     imusateikekkakbn ,         /* 医務査定結果区分 */
     tnsketsyacd ,         /* 転送先決定者コード */
     ketsyacd ,         /* 決定者コード */
     palketsyacd ,         /* ＰＡＬ決定者コード */
     imusateicomment ,         /* 医務査定コメント */
     ketkekkacd ,         /* 決定結果コード */
     ketriyuucd1 ,         /* 決定理由コード１ */
     ketriyuucd2 ,         /* 決定理由コード２ */
     ketriyuucd3 ,         /* 決定理由コード３ */
     ketriyuucd4 ,         /* 決定理由コード４ */
     syoubyoucd1 ,         /* 傷病コード１ */
     syoubyoujyoutaikbn1 ,         /* 傷病状態区分１ */
     kantiym1 ,         /* 完治年月１ */
     syoubyoucd2 ,         /* 傷病コード２ */
     syoubyoujyoutaikbn2 ,         /* 傷病状態区分２ */
     kantiym2 ,         /* 完治年月２ */
     sntkinfosakuseiyhkbn ,         /* 選択情報作成要否区分 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_ImusateiRireki_Z;
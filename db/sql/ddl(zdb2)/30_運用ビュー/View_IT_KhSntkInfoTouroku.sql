CREATE VIEW IT_KhSntkInfoTouroku AS SELECT
     syono ,         /* 証券番号 */
     renno ,         /* 連番 */
     syoriYmd ,         /* 処理年月日 */
     huho2kykno ,         /* 普保Ⅱ契約番号 */
     huho2kyknokbn ,         /* 普保Ⅱ契約番号区分 */
     syouhncd ,         /* 商品コード */
     sntkinfokankeisyakbn ,         /* 選択情報関係者区分 */
     taisyounmkn ,         /* 対象者氏名（カナ） */
     taisyounmkj ,         /* 対象者氏名（漢字） */
     taisyouseiymd ,         /* 対象者生年月日 */
     taisyouseibetu ,         /* 対象者性別 */
     dakuhiketnaiyouumukbn ,         /* 諾否決定内容有無区分 */
     kktnaiyouumukbn ,         /* 告知内容有無区分 */
     kijinaiyouumukbn ,         /* 記事内容有無区分 */
     mrumukbn ,         /* ＭＲ有無区分 */
     koudosyougaiumukbn ,         /* 高度障害有無区分 */
     torikaijoumukbn ,         /* 取消解除有無区分 */
     seiritukbn ,         /* 成立区分 */
     deckbn ,         /* ＤＥＣ区分 */
     ketymd ,         /* 決定日 */
     ketkekkacd ,         /* 決定結果コード */
     ketriyuucd1 ,         /* 決定理由コード１ */
     ketriyuucd2 ,         /* 決定理由コード２ */
     ketriyuucd3 ,         /* 決定理由コード３ */
     ketriyuucd4 ,         /* 決定理由コード４ */
     ketsyacd ,         /* 決定者コード */
     palketsyacd ,         /* ＰＡＬ決定者コード */
     sintyou ,         /* 身長 */
     taijyuu ,         /* 体重 */
     kktymd ,         /* 告知日 */
     syoubyoucd1 ,         /* 傷病コード１ */
     syoubyoujyoutaikbn1 ,         /* 傷病状態区分１ */
     kantiym1 ,         /* 完治年月１ */
     syoubyoucd2 ,         /* 傷病コード２ */
     syoubyoujyoutaikbn2 ,         /* 傷病状態区分２ */
     kantiym2 ,         /* 完治年月２ */
     mrriyuucdkbn ,         /* ＭＲ理由コード区分 */
     sntkinfokyktorikesikbn ,         /* 選択情報用契約取消処理区分 */
     syorizumiflg ,         /* 処理済フラグ */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KhSntkInfoTouroku_Z;
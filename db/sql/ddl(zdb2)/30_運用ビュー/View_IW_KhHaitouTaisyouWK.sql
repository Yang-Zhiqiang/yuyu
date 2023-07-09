CREATE VIEW IW_KhHaitouTaisyouWK AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     syoriYmd ,         /* 処理年月日 */
     haitoukinuketorihoukbn ,         /* 配当金受取方法区分 */
     haitoumeisaikbn ,         /* 配当明細区分 */
     renno ,         /* 連番 */
     haitoujyoutaihanteikbn ,         /* 配当状態判定区分 */
     haitoushrkijyunymd ,         /* 配当支払基準日 */
     haitoukbn ,         /* 配当区分 */
     kihons ,         /* 基本Ｓ */
     kihons$ ,         /* 基本Ｓ(通貨型) */
     haitoukaisuu ,         /* 配当回数 */
     syouhncd ,         /* 商品コード */
     ryouritusdno ,         /* 料率世代番号 */
     yoteiriritu ,         /* 予定利率 */
     hrkkaisuu ,         /* 払込回数 */
     hhknsei ,         /* 被保険者性別 */
     hhknnen ,         /* 被保険者年齢 */
     hknkknsmnkbn ,         /* 保険期間歳満期区分 */
     hknkkn ,         /* 保険期間 */
     hrkkkn ,         /* 払込期間 */
     dratenendo ,         /* Ｄレート年度 */
     keisandnendo ,         /* 計算Ｄ年度 */
     kyktuukasyu ,         /* 契約通貨種類 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     kykymd ,         /* 契約日 */
     kykjyoutai ,         /* 契約状態 */
     dai1hknkkn ,         /* 第１保険期間 */
     hrkkknsmnkbn           /* 払込期間歳満期区分 */
FROM IW_KhHaitouTaisyouWK_Z;
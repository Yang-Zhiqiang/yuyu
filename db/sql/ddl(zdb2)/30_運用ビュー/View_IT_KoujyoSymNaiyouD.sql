CREATE VIEW IT_KoujyoSymNaiyouD AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     syouhncd ,         /* 商品コード */
     renno3keta ,         /* 連番（３桁） */
     koujyosyoumeinnd ,         /* 控除証明年度 */
     koujyosyoumeid ,         /* 控除証明Ｄ */
     koujyosyoumeid$ ,         /* 控除証明Ｄ(通貨型) */
     haitounendo ,         /* 配当年度 */
     haitoukanrirenno ,         /* 配当管理連番 */
     haitoukinskskbn ,         /* 配当金作成区分 */
     haitoumeisaikbn ,         /* 配当明細区分 */
     kjsmhakkouzumiflg ,         /* 控除証明書発行済フラグ */
     sakujyoflg ,         /* 削除フラグ */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KoujyoSymNaiyouD_Z;
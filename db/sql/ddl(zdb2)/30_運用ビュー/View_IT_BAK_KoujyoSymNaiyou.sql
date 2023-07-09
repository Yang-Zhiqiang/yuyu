CREATE VIEW IT_BAK_KoujyoSymNaiyou AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     trkssikibetukey ,         /* 取消識別キー */
     syouhncd ,         /* 商品コード */
     renno3keta ,         /* 連番（３桁） */
     koujyosyoumeinnd ,         /* 控除証明年度 */
     syoumeistartym ,         /* 証明開始年月 */
     syoumeiendym ,         /* 証明終了年月 */
     koujyosyoumeipkbn ,         /* 控除証明保険料区分 */
     tekiyouseidokbn ,         /* 適用制度区分 */
     koujyosymnaiyoureckbn ,         /* 控除証明内容レコード区分 */
     koujyosyoumeigk ,         /* 控除証明額 */
     koujyosyoumeigk$ ,         /* 控除証明額(通貨型) */
     jyutoustartym ,         /* 充当開始年月 */
     nyknjskrrkrenno ,         /* 入金実績履歴連番 */
     kihrkpssrrkrenno ,         /* 既払込Ｐ精算履歴連番 */
     kjsmhakkouzumiflg ,         /* 控除証明書発行済フラグ */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_BAK_KoujyoSymNaiyou_Z;
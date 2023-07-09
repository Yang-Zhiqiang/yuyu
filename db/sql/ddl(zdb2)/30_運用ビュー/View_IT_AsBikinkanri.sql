CREATE VIEW IT_AsBikinkanri AS SELECT
     syono ,         /* 証券番号 */
     kessankijyunymd ,         /* 決算基準日 */
     bkncdkbn ,         /* 備金コード区分 */
     bknkktymd ,         /* 備金確定日 */
     renno ,         /* 連番 */
     calckijyunymd ,         /* 計算基準日 */
     sisyacd ,         /* 支社コード */
     kbnkeirisegcd ,         /* 区分経理用セグメントコード */
     syouhncd ,         /* 商品コード */
     bkngk ,         /* 備金額 */
     bkngk$ ,         /* 備金額(通貨型) */
     syoriumukbn ,         /* 処理有無区分 */
     bknjkukbn ,         /* 備金時効区分 */
     kaiyakuhrgaika ,         /* 解約返戻金（外貨） */
     kaiyakuhrgaika$ ,         /* 解約返戻金（外貨）(通貨型) */
     kyktuukasyu ,         /* 契約通貨種類 */
     shrtuukasyu ,         /* 支払通貨種類 */
     kwsratekjymd ,         /* 為替レート基準日 */
     kawaserate ,         /* 為替レート */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_AsBikinkanri_Z;
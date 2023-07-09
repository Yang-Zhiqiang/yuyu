CREATE VIEW IW_TmttkinYskWk AS SELECT
     syono ,         /* 証券番号 */
     syouhnbunruitmttkinyskkbn ,         /* 商品分類積立金予測区分 */
     kyktuukasyu ,         /* 契約通貨種類 */
     kykymd ,         /* 契約日 */
     kyksjkkktyouseiriritu ,         /* 契約時市場価格調整用利率 */
     targettkhkumu ,         /* ターゲット特約付加有無 */
     targettkmokuhyouti ,         /* ターゲット特約目標値 */
     kyktuukap ,         /* 契約通貨建保険料 */
     kyktuukap$ ,         /* 契約通貨建保険料(通貨型) */
     kyktuukatmttkngk ,         /* 契約通貨建積立金額 */
     kyktuukatmttkngk$ ,         /* 契約通貨建積立金額(通貨型) */
     kyktuukakaiyakuhrgk ,         /* 契約通貨建解約返戻金額 */
     kyktuukakaiyakuhrgk$ ,         /* 契約通貨建解約返戻金額(通貨型) */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IW_TmttkinYskWk_Z;
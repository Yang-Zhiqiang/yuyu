CREATE VIEW HT_GrossNykn AS SELECT
     ryosyuymd ,         /* 領収日 */
     oyadrtencd ,         /* 親代理店コード */
     renno ,         /* 連番 */
     hrktuukasyu ,         /* 払込通貨種類 */
     kyktuukasyu ,         /* 契約通貨種類 */
     kawaserate ,         /* 為替レート */
     grossnykngk ,         /* グロス入金額 */
     grossnykngk$ ,         /* グロス入金額(通貨型) */
     grossdengk ,         /* グロス入金伝票金額 */
     grossdengk$ ,         /* グロス入金伝票金額(通貨型) */
     meisaigoukeidengk ,         /* 明細合計伝票金額 */
     meisaigoukeidengk$ ,         /* 明細合計伝票金額(通貨型) */
     kawasesasonekikngk ,         /* 為替差損益金額 */
     kawasesasonekikngk$ ,         /* 為替差損益金額(通貨型) */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_GrossNykn_Z;
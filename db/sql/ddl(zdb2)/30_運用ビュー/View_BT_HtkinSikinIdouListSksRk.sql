CREATE VIEW BT_HtkinSikinIdouListSksRk AS SELECT
     syono ,         /* 証券番号 */
     kijyunymd ,         /* 基準年月日 */
     haitounendo ,         /* 配当年度 */
     siteituuka ,         /* 指定通貨 */
     siteituukagk ,         /* 指定通貨金額 */
     siteituukagk$ ,         /* 指定通貨金額(通貨型) */
     trhktuuka ,         /* 取引通貨 */
     trhktuukagk ,         /* 取引通貨金額 */
     trhktuukagk$ ,         /* 取引通貨金額(通貨型) */
     seg1cd ,         /* セグメント１コード */
     sikinidougroupkbn ,         /* 資金移動グループ区分 */
     sikinidoukawaserate ,         /* 資金移動用為替レート */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_HtkinSikinIdouListSksRk_Z;
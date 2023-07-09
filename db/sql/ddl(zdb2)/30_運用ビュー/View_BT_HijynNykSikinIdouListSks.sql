CREATE VIEW BT_HijynNykSikinIdouListSks AS SELECT
     syono ,         /* 証券番号 */
     sikinidoupjytym ,         /* 資金移動用保険料充当年月 */
     syoriYmd ,         /* 処理年月日 */
     siteituuka ,         /* 指定通貨 */
     siteituukagk ,         /* 指定通貨金額 */
     siteituukagk$ ,         /* 指定通貨金額(通貨型) */
     trhktuuka ,         /* 取引通貨 */
     trhktuukagk ,         /* 取引通貨金額 */
     trhktuukagk$ ,         /* 取引通貨金額(通貨型) */
     seg1cd ,         /* セグメント１コード */
     sikinidougroupkbn ,         /* 資金移動グループ区分 */
     sikinidoumeisaikbn ,         /* 資金移動明細区分 */
     sikinidoujtkbn ,         /* 資金移動状態区分 */
     sikinidoukawaserate ,         /* 資金移動用為替レート */
     sikinidoupkbn ,         /* 資金移動用保険料区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_HijynNykSikinIdouListSks_Z;
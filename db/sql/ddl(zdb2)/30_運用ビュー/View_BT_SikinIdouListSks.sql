CREATE VIEW BT_SikinIdouListSks AS SELECT
     densyskbn ,         /* 伝票用システム区分 */
     denrenno ,         /* 伝票データ連番 */
     edano ,         /* 枝番号 */
     syoriYmd ,         /* 処理年月日 */
     tyakkinymd ,         /* 着金日 */
     seg1cd ,         /* セグメント１コード */
     kyktuukasyu ,         /* 契約通貨種類 */
     keiyakutuukagk ,         /* 契約通貨金額 */
     keiyakutuukagk$ ,         /* 契約通貨金額(通貨型) */
     shrtuukasyu ,         /* 支払通貨種類 */
     siharaituukagk ,         /* 支払通貨金額 */
     siharaituukagk$ ,         /* 支払通貨金額(通貨型) */
     sikinidoukbn ,         /* 資金移動区分 */
     sikinidougroupkbn ,         /* 資金移動グループ区分 */
     sikinidoumeisaikbn ,         /* 資金移動明細区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_SikinIdouListSks_Z;
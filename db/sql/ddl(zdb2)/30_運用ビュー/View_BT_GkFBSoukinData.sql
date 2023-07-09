CREATE VIEW BT_GkFBSoukinData AS SELECT
     fbsoukindatasikibetukey ,         /* ＦＢ送金データ識別キー */
     denrenno ,         /* 伝票データ連番 */
     edano ,         /* 枝番号 */
     densyskbn ,         /* 伝票用システム区分 */
     gkgyoumucd ,         /* 外貨業務コード */
     tantositucd ,         /* 担当室コード */
     syoricd ,         /* 処理コード */
     syorisosikicd ,         /* 処理組織コード */
     syoriYmd ,         /* 処理年月日 */
     denymd ,         /* 伝票日付 */
     keirisyono ,         /* 経理用証券番号 */
     shrhousiteikbn ,         /* 支払方法指定区分 */
     bankcd ,         /* 銀行コード */
     banknmej ,         /* 銀行名（英字） */
     sitencd ,         /* 支店コード */
     sitennmej ,         /* 支店名（英字） */
     kouzano ,         /* 口座番号 */
     kzmeiginmei ,         /* 口座名義人名（英字） */
     shrtuukasyu ,         /* 支払通貨種類 */
     gaikashrgk ,         /* 外貨支払額 */
     gaikashrgk$ ,         /* 外貨支払額(通貨型) */
     kyktuukasyu ,         /* 契約通貨種類 */
     crossrateshrgk ,         /* クロスレート支払額 */
     crossrateshrgk$ ,         /* クロスレート支払額(通貨型) */
     soukinkwsrate ,         /* 送金用為替レート */
     irninnmei ,         /* 依頼人名（英字） */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_GkFBSoukinData_Z;
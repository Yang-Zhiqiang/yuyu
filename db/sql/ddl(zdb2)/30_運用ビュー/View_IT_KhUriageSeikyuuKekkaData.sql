CREATE VIEW IT_KhUriageSeikyuuKekkaData AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     creditkessaiyouno ,         /* クレジットカード決済用番号 */
     uriagenengappi ,         /* 売上年月日 */
     renno3keta ,         /* 連番（３桁） */
     recordno ,         /* レコード番号 */
     syoriYmd ,         /* 処理年月日 */
     authorikbn ,         /* オーソリ区分 */
     uriageseikyuutorihikicd ,         /* 売上請求取引コード */
     jyuutouym ,         /* 充当年月 */
     credityuukoukigen ,         /* クレジット有効期限 */
     credituriagegk ,         /* クレジットカード売上金額 */
     credituriagegk$ ,         /* クレジットカード売上金額(通貨型) */
     creditkaiinnokami6keta ,         /* クレジット会員番号（上６桁） */
     creditkaiinnosimo4keta ,         /* クレジット会員番号（下４桁） */
     uriageseikyuuerrorcd ,         /* 売上請求エラーコード */
     credituriagengjiyuu ,         /* クレジットカード売上請求ＮＧ事由 */
     fukusuukameitennokey ,         /* 複数加盟店番号設定キー情報 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KhUriageSeikyuuKekkaData_Z;
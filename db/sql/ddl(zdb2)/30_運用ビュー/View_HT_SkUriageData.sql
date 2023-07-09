CREATE VIEW HT_SkUriageData AS SELECT
     ansyuusyskbn ,         /* 案内収納用システム区分 */
     syoriYmd ,         /* 処理年月日 */
     mosno ,         /* 申込番号 */
     authorikaisuu ,         /* オーソリ回数 */
     jyuutouym ,         /* 充当年月 */
     jyutoukaisuum ,         /* 充当回数（月） */
     uriagegk ,         /* 売上金額 */
     uriagegk$ ,         /* 売上金額(通貨型) */
     uriageymd ,         /* 売上日 */
     hknsyuruino ,         /* 保険種類番号 */
     srsyoriymd ,         /* 成立処理日 */
     kykymd ,         /* 契約日 */
     authorikbn ,         /* オーソリ区分 */
     uriageseikyuutorihikicd ,         /* 売上請求取引コード */
     creditkessaiyouno ,         /* クレジットカード決済用番号 */
     creditkaiinnokami6keta ,         /* クレジット会員番号（上６桁） */
     creditkaiinnosimo4keta ,         /* クレジット会員番号（下４桁） */
     credituriagengjiyuu ,         /* クレジットカード売上請求ＮＧ事由 */
     fukusuukameitennokey ,         /* 複数加盟店番号設定キー情報 */
     cardbrandkbn ,         /* カードブランド区分 */
     carddatasousinymd ,         /* カードデータ送信日 */
     uriageseikyuuerrorcd ,         /* 売上請求エラーコード */
     uriagekekkakbn ,         /* 売上結果区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_SkUriageData_Z;
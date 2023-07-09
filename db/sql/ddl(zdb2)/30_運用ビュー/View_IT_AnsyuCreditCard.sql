CREATE VIEW IT_AnsyuCreditCard AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     yukoukachkymd ,         /* 有効性確認日 */
     yuukoukakujkkbn ,         /* 有効性確認状況区分 */
     authorijkkbn ,         /* オーソリ状況区分 */
     authoritrkkbn ,         /* オーソリ登録区分 */
     authorigk ,         /* オーソリ金額 */
     authorigk$ ,         /* オーソリ金額(通貨型) */
     authorikanryoymd ,         /* オーソリ完了日 */
     syouninno ,         /* 承認番号 */
     tanmatusyorino ,         /* 端末処理通番 */
     uriageymd ,         /* 売上日 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_AnsyuCreditCard_Z;
CREATE VIEW IT_HrhnCreditCardTouroku AS SELECT
     creditkessaiyouno ,         /* クレジットカード決済用番号 */
     syono ,         /* 証券番号 */
     authorijkkbn ,         /* オーソリ状況区分 */
     cardbrandkbn ,         /* カードブランド区分 */
     creditkaiinnosimo4keta ,         /* クレジット会員番号（下４桁） */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_HrhnCreditCardTouroku_Z;
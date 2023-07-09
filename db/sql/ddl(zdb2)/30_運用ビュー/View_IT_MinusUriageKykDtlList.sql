CREATE VIEW IT_MinusUriageKykDtlList AS SELECT
     syono ,         /* 証券番号 */
     creditkessaiyouno ,         /* クレジットカード決済用番号 */
     uriagenengappi ,         /* 売上年月日 */
     renno3keta ,         /* 連番（３桁） */
     jyuutouym ,         /* 充当年月 */
     syoriYmd ,         /* 処理年月日 */
     credituriagegk ,         /* クレジットカード売上金額 */
     credituriagegk$ ,         /* クレジットカード売上金額(通貨型) */
     kinouId ,         /* 機能ＩＤ */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_MinusUriageKykDtlList_Z;
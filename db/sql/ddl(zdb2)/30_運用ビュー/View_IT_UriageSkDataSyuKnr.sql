CREATE VIEW IT_UriageSkDataSyuKnr AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     creditkessaiyouno ,         /* クレジットカード決済用番号 */
     uriagenengappi ,         /* 売上年月日 */
     renno3keta ,         /* 連番（３桁） */
     credituriagekekkahaneiymd ,         /* クレジットカード売上請求結果反映日 */
     credituragskkkmhnkkchkzmflg ,         /* クレジットカード売上請求結果未返却チェック済フラグ */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_UriageSkDataSyuKnr_Z;
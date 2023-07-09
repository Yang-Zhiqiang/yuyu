CREATE VIEW IT_KhLincKihon AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     kykymd ,         /* 契約日 */
     linckanyuusyano ,         /* ＬＩＮＣ＿加入者番号 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KhLincKihon_Z;
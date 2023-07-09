CREATE VIEW IT_KhHubiMikaisyouList AS SELECT
     jimutetuzukicd ,         /* 事務手続コード */
     syono ,         /* 証券番号 */
     hassinsakikbn ,         /* 発信先区分 */
     kyknmkj ,         /* 契約者名（漢字） */
     sksreadymd ,         /* 請求書読込日 */
     genponhnkykumu ,         /* 原本返却有無 */
     hubitourokuktntnm ,         /* 不備登録担当者名 */
     hubisyouninktntnm ,         /* 不備承認担当者名 */
     hassinkaisuu ,         /* 発信回数 */
     fsthubbihasinymd ,         /* 初回不備発信日 */
     lasthubbihasinymd ,         /* 最終不備発信日 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KhHubiMikaisyouList_Z;
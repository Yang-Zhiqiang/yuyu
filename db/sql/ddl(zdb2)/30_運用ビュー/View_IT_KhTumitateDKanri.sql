CREATE VIEW IT_KhTumitateDKanri AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     tumitatedtumitateymd ,         /* 積立Ｄ積立年月日 */
     renno ,         /* 連番 */
     tumitatedskskbn ,         /* 積立Ｄ作成区分 */
     tumitated ,         /* 積立Ｄ */
     tumitated$ ,         /* 積立Ｄ(通貨型) */
     tumitatedshrkrkymd ,         /* 積立Ｄ支払効力日 */
     naiteikakuteikbn ,         /* 内定確定区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KhTumitateDKanri_Z;
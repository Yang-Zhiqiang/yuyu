CREATE VIEW IT_KoujyoSymKanri AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     nendo ,         /* 年度 */
     lastsyoumeiendym ,         /* 最終証明終了年月 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KoujyoSymKanri_Z;
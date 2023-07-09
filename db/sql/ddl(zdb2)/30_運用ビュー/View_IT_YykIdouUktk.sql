CREATE VIEW IT_YykIdouUktk AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     henkousikibetukey ,         /* 変更識別キー */
     kinouId ,         /* 機能ＩＤ */
     yykidousyorikbn ,         /* 予約異動処理区分 */
     uktkymd ,         /* 受付日 */
     syoriym ,         /* 処理年月 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_YykIdouUktk_Z;
CREATE VIEW IT_KhHenkouUktk AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     hozenhenkouuktkrenno ,         /* 保全変更受付連番 */
     uktkymd ,         /* 受付日 */
     tourokuroute ,         /* 登録ルート */
     uktksyorikbn ,         /* 受付処理区分 */
     kouryokuhasseiymd ,         /* 効力発生日 */
     syoriyoteiymd ,         /* 処理予定日 */
     uktkjyoutaikbn ,         /* 受付状態区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KhHenkouUktk_Z;
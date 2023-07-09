CREATE VIEW BM_Syonokanri AS SELECT
     seirekinen2keta ,         /* 西暦年（２桁） */
     bosyuusosikicd ,         /* 募集組織コード */
     syonorenno ,         /* 証券番号連番 */
     syono ,         /* 証券番号 */
     mosno ,         /* 申込番号 */
     saibanymd ,         /* 採番日 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_Syonokanri_Z;
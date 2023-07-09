CREATE VIEW HT_BosKoumokuCheckError AS SELECT
     mosno ,         /* 申込番号 */
     renno3keta ,         /* 連番（３桁） */
     errorkm ,         /* エラー項目 */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_BosKoumokuCheckError_Z;
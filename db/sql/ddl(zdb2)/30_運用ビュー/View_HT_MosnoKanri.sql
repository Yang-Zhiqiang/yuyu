CREATE VIEW HT_MosnoKanri AS SELECT
     mosno8keta ,         /* 申込番号（８桁） */
     saibankahikbn ,         /* 採番可否区分 */
     mossykykyoteiymd ,         /* 申込消却予定日 */
     saibanymd ,         /* 採番日 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_MosnoKanri_Z;
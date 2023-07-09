CREATE VIEW HT_NrkDif AS SELECT
     mosno ,         /* 申込番号 */
     vrfkinouid ,         /* ベリファイ機能ID */
     renno3keta ,         /* 連番（３桁） */
     nrksouikm ,         /* 入力相違項目 */
     itijinyuuroku ,         /* １次入力 */
     nijinyrk ,         /* ２次入力 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_NrkDif_Z;
CREATE VIEW HT_KmTsRireki AS SELECT
     mosno ,         /* 申込番号 */
     syoriTime ,         /* 処理時間 */
     renno3keta ,         /* 連番（３桁） */
     kinouId ,         /* 機能ＩＤ */
     kinouModeId ,         /* 機能モードＩＤ */
     tskmnm ,         /* 訂正項目名 */
     tsmaenaiyou ,         /* 訂正前内容 */
     tsgonaiyou ,         /* 訂正後内容 */
     tantid ,         /* 担当者ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_KmTsRireki_Z;
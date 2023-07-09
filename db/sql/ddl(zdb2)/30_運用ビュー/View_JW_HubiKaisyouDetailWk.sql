CREATE VIEW JW_HubiKaisyouDetailWk AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     renno3keta ,         /* 連番（３桁） */
     hubikaisyouumukbn ,         /* 不備解消有無区分 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JW_HubiKaisyouDetailWk_Z;
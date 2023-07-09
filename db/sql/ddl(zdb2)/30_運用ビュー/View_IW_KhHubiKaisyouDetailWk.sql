CREATE VIEW IW_KhHubiKaisyouDetailWk AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     renno3keta ,         /* 連番（３桁） */
     hubikaisyouumukbn ,         /* 不備解消有無区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IW_KhHubiKaisyouDetailWk_Z;
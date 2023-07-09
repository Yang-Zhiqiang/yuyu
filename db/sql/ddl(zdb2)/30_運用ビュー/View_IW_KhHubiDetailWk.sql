CREATE VIEW IW_KhHubiDetailWk AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     renno3keta ,         /* 連番（３桁） */
     hubisyoruicd ,         /* 不備書類コード */
     hubisyoruinm ,         /* 不備書類名 */
     hubinaiyoucd ,         /* 不備内容コード */
     hubinaiyoumsg ,         /* 不備内容メッセージ */
     genponhnkykumu ,         /* 原本返却有無 */
     hassinsakikbn ,         /* 発信先区分 */
     hubitourokuktntid ,         /* 不備登録担当者ＩＤ */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     trkymd ,         /* 登録日 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IW_KhHubiDetailWk_Z;
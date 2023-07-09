CREATE VIEW JT_SiHubiDetail AS SELECT
     hubisikibetukey ,         /* 不備識別キー */
     renno3keta ,         /* 連番（３桁） */
     hubisyoruicd ,         /* 不備書類コード */
     hubisyoruinm ,         /* 不備書類名 */
     hubinaiyoucd ,         /* 不備内容コード */
     hubinaiyoumsg ,         /* 不備内容メッセージ */
     genponhnkykumu ,         /* 原本返却有無 */
     trkymd ,         /* 登録日 */
     hasinymd ,         /* 発信日 */
     kaisyouymd ,         /* 解消日 */
     hassinsakikbn ,         /* 発信先区分 */
     hubitourokuktntid ,         /* 不備登録担当者ＩＤ */
     hubisyouninktntid ,         /* 不備承認担当者ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SiHubiDetail_Z;
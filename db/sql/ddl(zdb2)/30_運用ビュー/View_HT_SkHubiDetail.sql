CREATE VIEW HT_SkHubiDetail AS SELECT
     mosno ,         /* 申込番号 */
     hubisikibetukey ,         /* 不備識別キー */
     renno3keta ,         /* 連番（３桁） */
     syoruiCd ,         /* 書類コード */
     skhubikoumokucd ,         /* 新契約不備項目コード */
     skhubinaiyoucd ,         /* 新契約不備内容コード */
     skseibisijinaiyoucd ,         /* 新契約整備指示内容コード */
     tyoubunflg ,         /* 長文フラグ */
     skrenrakujikou ,         /* 新契約連絡事項 */
     trkymd ,         /* 登録日 */
     hasinymd ,         /* 発信日 */
     kaisyouymd ,         /* 解消日 */
     hassinsakikbn ,         /* 発信先区分 */
     hasinkyokakbn ,         /* 発信許可区分 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_SkHubiDetail_Z;
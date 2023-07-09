CREATE VIEW IT_KhLincSousinInfo AS SELECT
     kbnkey ,         /* 区分キー */
     lincsoujyusinsyskbn ,         /* ＬＩＮＣ送受信用システム区分 */
     syono ,         /* 証券番号 */
     renno ,         /* 連番 */
     lincsousinkbn ,         /* ＬＩＮＣ送信区分 */
     lincrecordsyubetu ,         /* ＬＩＮＣ＿レコード種別 */
     linchenkoutype ,         /* ＬＩＮＣ＿変更タイプ */
     linckanyuusyano ,         /* ＬＩＮＣ＿加入者番号 */
     linchhknnmkn ,         /* ＬＩＮＣ＿被保険者名（カナ） */
     linchhknnmkj ,         /* ＬＩＮＣ＿被保険者名（漢字） */
     linchhknsei ,         /* ＬＩＮＣ＿被保険者性別 */
     linchhknseiymd ,         /* ＬＩＮＣ＿被保険者生年月日 */
     linchhknadrkn ,         /* ＬＩＮＣ＿被保険者住所（カナ） */
     linckeihidjnhyouji ,         /* ＬＩＮＣ＿契被同人表示 */
     linckyknmkn ,         /* ＬＩＮＣ＿契約者名（カナ） */
     linckyknmkj ,         /* ＬＩＮＣ＿契約者名（漢字） */
     linckyksei ,         /* ＬＩＮＣ＿契約者性別 */
     linckykseiymd ,         /* ＬＩＮＣ＿契約者生年月日 */
     linckykadrkn ,         /* ＬＩＮＣ＿契約者住所（カナ） */
     linctrkmousideymd ,         /* ＬＩＮＣ＿登録申出年月日 */
     linckykytymd ,         /* ＬＩＮＣ＿契約予定年月日 */
     linckykymd ,         /* ＬＩＮＣ＿契約年月日 */
     linchozenytymd ,         /* ＬＩＮＣ＿保全予定年月日 */
     linchozenymd ,         /* ＬＩＮＣ＿保全年月日 */
     lincsgnyukyhng ,         /* ＬＩＮＣ＿災害入院給付金日額 */
     lincsgnyukyhng$ ,         /* ＬＩＮＣ＿災害入院給付金日額(通貨型) */
     lincsipnyukyhng ,         /* ＬＩＮＣ＿疾病入院給付金日額 */
     lincsipnyukyhng$ ,         /* ＬＩＮＣ＿疾病入院給付金日額(通貨型) */
     lincsjnyukyhng ,         /* ＬＩＮＣ＿成人病入院給付金日額 */
     lincsjnyukyhng$ ,         /* ＬＩＮＣ＿成人病入院給付金日額(通貨型) */
     lincsonotanyukyhng ,         /* ＬＩＮＣ＿その他入院給付金日額 */
     lincsonotanyukyhng$ ,         /* ＬＩＮＣ＿その他入院給付金日額(通貨型) */
     linchutuusbs ,         /* ＬＩＮＣ＿普通死亡保険金額 */
     linchutuusbs$ ,         /* ＬＩＮＣ＿普通死亡保険金額(通貨型) */
     lincsgsbksns ,         /* ＬＩＮＣ＿災害死亡時加算保険金額 */
     lincsgsbksns$ ,         /* ＬＩＮＣ＿災害死亡時加算保険金額(通貨型) */
     linckakusyasiyouran ,         /* ＬＩＮＣ＿各社使用欄 */
     lincmousideflg ,         /* ＬＩＮＣ＿申出フラグ */
     lincmousideflgsetymd ,         /* ＬＩＮＣ＿申出フラグ設定年月日 */
     lincmousideflgkaijyoymd ,         /* ＬＩＮＣ＿申出フラグ解除年月日 */
     lincjgyhknflg ,         /* ＬＩＮＣ＿事業保険フラグ */
     linctenkanflg ,         /* ＬＩＮＣ＿転換フラグ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KhLincSousinInfo_Z;
CREATE VIEW IT_BAK_HokenryouTmttkn AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     trkssikibetukey ,         /* 取消識別キー */
     tmttkntaisyouym ,         /* 積立金対象年月 */
     renno ,         /* 連番 */
     ptmttkngk ,         /* 保険料積立金額 */
     ptmttkngk$ ,         /* 保険料積立金額(通貨型) */
     kihrkmpstgk ,         /* 既払込保険料相当額 */
     kihrkmpstgk$ ,         /* 既払込保険料相当額(通貨型) */
     tyouseimaeptmttkngk ,         /* 調整前保険料積立金額 */
     tyouseimaeptmttkngk$ ,         /* 調整前保険料積立金額(通貨型) */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_BAK_HokenryouTmttkn_Z;
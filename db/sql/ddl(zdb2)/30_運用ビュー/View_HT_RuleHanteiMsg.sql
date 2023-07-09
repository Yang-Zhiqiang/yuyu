CREATE VIEW HT_RuleHanteiMsg AS SELECT
     mosno ,         /* 申込番号 */
     rulehanteimsg ,         /* ルール判定結果メッセージ区分 */
     renno ,         /* 連番 */
     rulehanteimsgid ,         /* ルール判定結果メッセージＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_RuleHanteiMsg_Z;
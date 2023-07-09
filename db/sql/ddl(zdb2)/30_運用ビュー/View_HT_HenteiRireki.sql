CREATE VIEW HT_HenteiRireki AS SELECT
     mosno ,         /* 申込番号 */
     renno ,         /* 連番 */
     henteiymd ,         /* 変更訂正日 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_HenteiRireki_Z;
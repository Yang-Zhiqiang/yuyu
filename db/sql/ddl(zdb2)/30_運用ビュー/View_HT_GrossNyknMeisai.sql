CREATE VIEW HT_GrossNyknMeisai AS SELECT
     ryosyuymd ,         /* 領収日 */
     oyadrtencd ,         /* 親代理店コード */
     renno ,         /* 連番 */
     meisairenno ,         /* 明細連番 */
     nykmosno ,         /* 入金用申込番号 */
     rsgaku ,         /* 領収金額 */
     rsgaku$ ,         /* 領収金額(通貨型) */
     dengk ,         /* 伝票金額 */
     dengk$ ,         /* 伝票金額(通貨型) */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_GrossNyknMeisai_Z;
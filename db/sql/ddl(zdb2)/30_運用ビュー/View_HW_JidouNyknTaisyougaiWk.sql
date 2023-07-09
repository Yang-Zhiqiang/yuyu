CREATE VIEW HW_JidouNyknTaisyougaiWk AS SELECT
     nyksyoriymd ,         /* 入金処理日 */
     itirenno ,         /* 一連番号 */
     nykmosno ,         /* 入金用申込番号 */
     oyadrtencd ,         /* 親代理店コード */
     trhkkgk ,         /* 取引金額 */
     trhkkgk$ ,         /* 取引金額(通貨型) */
     rstuukasyu ,         /* 領収通貨種類 */
     syoriYmd ,         /* 処理年月日 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HW_JidouNyknTaisyougaiWk_Z;
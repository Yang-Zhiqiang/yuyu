CREATE VIEW HW_HrkmNyknTaisyouWk AS SELECT
     syoriYmd ,         /* 処理年月日 */
     mosno ,         /* 申込番号 */
     renno ,         /* 連番 */
     oyadrtencd ,         /* 親代理店コード */
     ryosyuymd ,         /* 領収日 */
     hrkmirninnm ,         /* 振込依頼人名 */
     rsgaku ,         /* 領収金額 */
     rsgaku$ ,         /* 領収金額(通貨型) */
     rstuukasyu ,         /* 領収通貨種類 */
     rsgakuen ,         /* 領収金額（円） */
     rsgakuen$ ,         /* 領収金額（円）(通貨型) */
     hrkmtsry ,         /* 振込手数料 */
     hrkmtsry$ ,         /* 振込手数料(通貨型) */
     nyksyoriymd ,         /* 入金処理日 */
     hrkmnykndatarenmotoKbn ,         /* 振込入金データ連携元区分 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HW_HrkmNyknTaisyouWk_Z;
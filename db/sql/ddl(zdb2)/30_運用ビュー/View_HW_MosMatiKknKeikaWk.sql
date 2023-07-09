CREATE VIEW HW_MosMatiKknKeikaWk AS SELECT
     nyksyoriymd ,         /* 入金処理日 */
     itirenno ,         /* 一連番号 */
     oyadrtencd ,         /* 親代理店コード */
     knjyymd ,         /* 勘定日 */
     mosno ,         /* 申込番号 */
     hrkmirninnm ,         /* 振込依頼人名 */
     trhkkgk ,         /* 取引金額 */
     trhkkgk$ ,         /* 取引金額(通貨型) */
     rstuukasyu ,         /* 領収通貨種類 */
     syoriYmd ,         /* 処理年月日 */
     nyuukinoyadrtennm ,         /* 入金用親代理店名 */
     hrkmnykndatarenmotoKbn ,         /* 振込入金データ連携元区分 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HW_MosMatiKknKeikaWk_Z;
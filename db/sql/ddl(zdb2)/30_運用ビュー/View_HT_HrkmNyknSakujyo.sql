CREATE VIEW HT_HrkmNyknSakujyo AS SELECT
     hrkmdeldataskbtkey ,         /* 振込入金削除データ識別キー */
     trkymd ,         /* 登録日 */
     nyksyoriymd ,         /* 入金処理日 */
     itirenno ,         /* 一連番号 */
     oyadrtencd ,         /* 親代理店コード */
     nykmosno ,         /* 入金用申込番号 */
     hrkmirninnm ,         /* 振込依頼人名 */
     trhkkgk ,         /* 取引金額 */
     trhkkgk$ ,         /* 取引金額(通貨型) */
     rstuukasyu ,         /* 領収通貨種類 */
     knjyymd ,         /* 勘定日 */
     syoriYmd ,         /* 処理年月日 */
     kouzano ,         /* 口座番号 */
     hrkmirnincd ,         /* 振込依頼人コード */
     syorizumiflg ,         /* 処理済フラグ */
     hrkmnykndatarenmotoKbn ,         /* 振込入金データ連携元区分 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_HrkmNyknSakujyo_Z;
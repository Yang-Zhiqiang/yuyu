CREATE VIEW BT_Hjyblist AS SELECT
     hjybtantositucd ,         /* 補助簿統括担当室コード */
     kanjyoukmkcd ,         /* 勘定科目コード */
     syorisyokantantcd ,         /* 処理所管担当室コード */
     denymd ,         /* 伝票日付 */
     karikatagk ,         /* 借方金額 */
     karikatagk$ ,         /* 借方金額(通貨型) */
     kasikatagk ,         /* 貸方金額 */
     kasikatagk$ ,         /* 貸方金額(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_Hjyblist_Z;
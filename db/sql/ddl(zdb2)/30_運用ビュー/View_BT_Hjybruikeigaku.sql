CREATE VIEW BT_Hjybruikeigaku AS SELECT
     hjybtantositucd ,         /* 補助簿統括担当室コード */
     kanjyoukmkcd ,         /* 勘定科目コード */
     denym ,         /* 伝票年月 */
     karikatakmkkeigk ,         /* 借方科目合計額 */
     karikatakmkkeigk$ ,         /* 借方科目合計額(通貨型) */
     kasikatakmkkeigk ,         /* 貸方科目合計額 */
     kasikatakmkkeigk$ ,         /* 貸方科目合計額(通貨型) */
     karikataruigk ,         /* 借方年間累計額 */
     karikataruigk$ ,         /* 借方年間累計額(通貨型) */
     kasikataruigk ,         /* 貸方年間累計額 */
     kasikataruigk$ ,         /* 貸方年間累計額(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_Hjybruikeigaku_Z;
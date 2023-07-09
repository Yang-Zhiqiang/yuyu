CREATE VIEW BT_HjybruikeigakuTeisei AS SELECT
     hjybruigkteiseitantositucd ,         /* 補助簿累計額訂正担当室コード */
     kanjyoukmkcd ,         /* 勘定科目コード */
     kasikatateiseigk ,         /* 貸方訂正額 */
     kasikatateiseigk$ ,         /* 貸方訂正額(通貨型) */
     karikatateiseigk ,         /* 借方訂正額 */
     karikatateiseigk$ ,         /* 借方訂正額(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_HjybruikeigakuTeisei_Z;
CREATE VIEW BM_RateP AS SELECT
     palhokensyuruikigou ,         /* ＰＡＬ保険種類記号 */
     palhokensyuruikigousdicode ,         /* ＰＡＬ保険種類記号世代コード */
     palyoteiriritu ,         /* ＰＡＬ予定利率 */
     palpmencode ,         /* ＰＡＬＰ免コード */
     palharaikomikaisuu ,         /* ＰＡＬ払込回数 */
     palhhknsei ,         /* ＰＡＬ被保険者性別 */
     palkeiyakujihhknnen ,         /* ＰＡＬ契約時被保険者年令 */
     palsaimankihyouji ,         /* ＰＡＬ才満期契約表示 */
     palhokenkikan ,         /* ＰＡＬ保険期間 */
     palpharaikomikikan ,         /* ＰＡＬＰ払込期間 */
     prate ,         /* Ｐレート */
     pdatesrate ,         /* Ｐ建Ｓレート */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_RateP_Z;
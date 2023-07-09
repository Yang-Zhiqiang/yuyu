CREATE VIEW BM_RateP2 AS SELECT
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
     palannaihuyouriyuukbn ,         /* ＰＡＬ案内不要理由区分 */
     ratetuukasyukbn ,         /* レート用通貨種類区分 */
     ratedai1hknkkn ,         /* レート用第１保険期間 */
     palryouritukbn ,         /* ＰＡＬ料率区分 */
     prate ,         /* Ｐレート */
     pdatesrate ,         /* Ｐ建Ｓレート */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_RateP2_Z;
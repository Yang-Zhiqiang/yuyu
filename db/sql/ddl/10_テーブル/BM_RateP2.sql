CREATE TABLE BM_RateP2 (
     palhokensyuruikigou                                CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ保険種類記号 */
     palhokensyuruikigousdicode                         CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ保険種類記号世代コード */
     palyoteiriritu                                     CHAR        (3)                                                       NOT NULL  ,  /* ＰＡＬ予定利率 */
     palpmencode                                        CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬＰ免コード */
     palharaikomikaisuu                                 CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ払込回数 */
     palhhknsei                                         CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ被保険者性別 */
     palkeiyakujihhknnen                                CHAR        (3)                                                       NOT NULL  ,  /* ＰＡＬ契約時被保険者年令 */
     palsaimankihyouji                                  CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ才満期契約表示 */
     palhokenkikan                                      CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ保険期間 */
     palpharaikomikikan                                 CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬＰ払込期間 */
     palannaihuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ案内不要理由区分 */
     ratetuukasyukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* レート用通貨種類区分 */
     ratedai1hknkkn                                     CHAR        (2)                                                       NOT NULL  ,  /* レート用第１保険期間 */
     palryouritukbn                                     CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ料率区分 */
     prate                                              NUMBER      (9,6)                                                               ,  /* Ｐレート */
     pdatesrate                                         NUMBER      (9,6)                                                               ,  /* Ｐ建Ｓレート */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_RateP2 ADD CONSTRAINT PK_RateP2 PRIMARY KEY (
     palhokensyuruikigou                                      , /* ＰＡＬ保険種類記号 */
     palhokensyuruikigousdicode                               , /* ＰＡＬ保険種類記号世代コード */
     palyoteiriritu                                           , /* ＰＡＬ予定利率 */
     palpmencode                                              , /* ＰＡＬＰ免コード */
     palharaikomikaisuu                                       , /* ＰＡＬ払込回数 */
     palhhknsei                                               , /* ＰＡＬ被保険者性別 */
     palkeiyakujihhknnen                                      , /* ＰＡＬ契約時被保険者年令 */
     palsaimankihyouji                                        , /* ＰＡＬ才満期契約表示 */
     palhokenkikan                                            , /* ＰＡＬ保険期間 */
     palpharaikomikikan                                       , /* ＰＡＬＰ払込期間 */
     palannaihuyouriyuukbn                                    , /* ＰＡＬ案内不要理由区分 */
     ratetuukasyukbn                                          , /* レート用通貨種類区分 */
     ratedai1hknkkn                                           , /* レート用第１保険期間 */
     palryouritukbn                                             /* ＰＡＬ料率区分 */
) ;

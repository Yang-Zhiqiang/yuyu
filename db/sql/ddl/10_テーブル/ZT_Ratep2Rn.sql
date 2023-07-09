CREATE TABLE ZT_Ratep2Rn (
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnhknsyuruikigousedaikbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険種類記号世代区分 */
     zrnyoteiriritu                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）予定利率 */
     zrnpmenkbn                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｐ免区分 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnhhknsei                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別 */
     zrnkeiyakujihhknnen                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）契約時被保険者年令 */
     zrnsaimnkkykhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）才満期契約表示 */
     zrnhknkkn                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険期間 */
     zrnphrkkikn                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ払込期間 */
     zrnannaifuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内不要理由区分 */
     zrntuukasyukbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）通貨種類区分 */
     zrndai1hknkkn                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）第１保険期間 */
     zrnryouritukbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）料率区分 */
     zrnprate                                           NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｐレート */
     zrnpdatesrate                                      NUMBER      (9,6)                                                     NOT NULL     /* （連携用）Ｐ建Ｓレート */
)
;

ALTER TABLE ZT_Ratep2Rn ADD CONSTRAINT PK_Ratep2Rn PRIMARY KEY (
     zrnhknsyukigou                                           , /* （連携用）保険種類記号 */
     zrnhknsyuruikigousedaikbn                                , /* （連携用）保険種類記号世代区分 */
     zrnyoteiriritu                                           , /* （連携用）予定利率 */
     zrnpmenkbn                                               , /* （連携用）Ｐ免区分 */
     zrnhrkkaisuukbn                                          , /* （連携用）払込回数区分 */
     zrnhhknsei                                               , /* （連携用）被保険者性別 */
     zrnkeiyakujihhknnen                                      , /* （連携用）契約時被保険者年令 */
     zrnsaimnkkykhyj                                          , /* （連携用）才満期契約表示 */
     zrnhknkkn                                                , /* （連携用）保険期間 */
     zrnphrkkikn                                              , /* （連携用）Ｐ払込期間 */
     zrnannaifuyouriyuukbn                                    , /* （連携用）案内不要理由区分 */
     zrntuukasyukbn                                           , /* （連携用）通貨種類区分 */
     zrndai1hknkkn                                            , /* （連携用）第１保険期間 */
     zrnryouritukbn                                             /* （連携用）料率区分 */
) ;

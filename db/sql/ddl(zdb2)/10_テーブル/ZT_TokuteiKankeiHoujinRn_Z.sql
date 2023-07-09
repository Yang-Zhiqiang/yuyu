CREATE TABLE ZT_TokuteiKankeiHoujinRn_Z (
     zrnkinyuukikancd                                   CHAR        (4)                                                       NOT NULL  ,  /* （連携用）金融機関コード */
     zrnmeisaibangou                                    CHAR        (4)                                                       NOT NULL  ,  /* （連携用）明細番号 */
     zrnmarukinhyouji                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）マル金表示 */
     zrntkhjnkjdrtennm                                  GRAPHIC     (40)                                                      NOT NULL  ,  /* （連携用）特定関係法人漢字代理店名 */
     zrndairitenbetutuuban                              CHAR        (4)                                                       NOT NULL  ,  /* （連携用）代理店別通番 */
     zrnkanjitokuteikankeinm                            GRAPHIC     (100)                                                     NOT NULL  ,  /* （連携用）漢字特定関係法人名 */
     zrntokuteikankeihoujinnm                           CHAR        (100)                                                     NOT NULL  ,  /* （連携用）特定関係法人名 */
     zrnkousinymd                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）更新年月日 */
     zrnyobiv79                                         CHAR        (79)                                                      NOT NULL     /* （連携用）予備項目Ｖ７９ */
)
;

ALTER TABLE ZT_TokuteiKankeiHoujinRn_Z ADD CONSTRAINT PK_TokuteiKankeiHoujinRn PRIMARY KEY (
     zrnkinyuukikancd                                         , /* （連携用）金融機関コード */
     zrnmeisaibangou                                            /* （連携用）明細番号 */
) ;

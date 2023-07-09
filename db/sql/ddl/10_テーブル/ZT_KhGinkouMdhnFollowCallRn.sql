CREATE TABLE ZT_KhGinkouMdhnFollowCallRn (
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnsyorikbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）処理区分 */
     zrnannaip                                          NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）案内保険料 */
     zrnyobiv8                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ８ */
     zrnminyuuym                                        CHAR        (6)                                                       NOT NULL  ,  /* （連携用）未入年月 */
     zrnskymd                                           CHAR        (8)                                                       NOT NULL  ,  /* （連携用）失効年月日 */
     zrnskhr                                            NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）失効時返戻金 */
     zrnttkekin                                         NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）今期立替金額 */
     zrnttkeganri                                       NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）立替元利金合計 */
     zrnttkersk                                         NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）立替利息 */
     zrnttkeriritu                                      CHAR        (4)                                                       NOT NULL  ,  /* （連携用）立替利率 */
     zrnttkejyuutouym                                   CHAR        (6)                                                       NOT NULL  ,  /* （連携用）立替充当年月 */
     zrnttkejyuutounen                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）立替充当年数 */
     zrnttkejyuutoutuki                                 CHAR        (2)                                                       NOT NULL  ,  /* （連携用）立替充当月数 */
     zrnyobin11                                         NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１ */
     zrnyobiv8x2                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ８＿２ */
     zrnyobiv29                                         CHAR        (29)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２９ */
     zrnkyksyaskinmeino                                 CHAR        (10)                                                      NOT NULL  ,  /* （連携用）契約者索引名番号 */
     zrnkyksyaseiymd                                    CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約者生年月日 */
     zrnkyknmhnykkbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約者名翻訳結果区分 */
     zrnkjkyknm35keta                                   VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）漢字契約者名（３５桁） */
     zrnknkyksyamei                                     CHAR        (41)                                                      NOT NULL  ,  /* （連携用）カナ契約者名 */
     zrnhhknnmhnykkbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者名翻訳結果区分 */
     zrnknjhhknmei                                      VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）漢字被保険者名 */
     zrnknhhknmei                                       CHAR        (18)                                                      NOT NULL  ,  /* （連携用）カナ被保険者名 */
     zrnhhknseikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別区分 */
     zrnhhknseiymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）被保険者生年月日 */
     zrnkihontikucd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）基本地区コード */
     zrnkyksyaadr                                       VARCHAR     (62)                                                      NOT NULL  ,  /* （連携用）契約者住所 */
     zrntsintelno                                       CHAR        (14)                                                      NOT NULL  ,  /* （連携用）通信先電話番号 */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnjikaipjyuutouym                                 CHAR        (6)                                                       NOT NULL  ,  /* （連携用）次回Ｐ充当年月 */
     zrnhrkkeirokbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路区分 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnanniskcd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）案内先コード */
     zrnhknmeisyou15keta                                VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）保険名称（１５桁） */
     zrnbsyujdrtencd1                                   CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集時代理店コード１ */
     zrnbsyujbosyuucd1                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集時募集人コード１ */
     zrnbsyujdrtencd2                                   CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集時代理店コード２ */
     zrnbsyujbosyuucd2                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集時募集人コード２ */
     zrnbsyujdrtencd3                                   CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集時代理店コード３ */
     zrnbsyujbosyuucd3                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集時募集人コード３ */
     zrnbsyujdrtencd4                                   CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集時代理店コード４ */
     zrnbsyujbosyuucd4                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集時募集人コード４ */
     zrnbsyujdrtencd5                                   CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集時代理店コード５ */
     zrnbsyujbosyuucd5                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集時募集人コード５ */
     zrnsaisindrtencd                                   CHAR        (7)                                                       NOT NULL  ,  /* （連携用）最新代理店コード */
     zrnsaisinbosyuucd                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）最新募集人コード */
     zrnkzhurikaebankcd                                 CHAR        (4)                                                       NOT NULL  ,  /* （連携用）口座振替銀行番号 */
     zrnkzhurikaesitencd                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）口座振替支店番号 */
     zrnkzhurikaeyokinkbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座振替預金種目区分 */
     zrnkzhurikaekouzano                                CHAR        (7)                                                       NOT NULL  ,  /* （連携用）口座振替口座番号 */
     zrnhnsyugkhmignnmei                                CHAR        (30)                                                      NOT NULL  ,  /* （連携用）編集後口座振替名義人名 */
     zrnyobiv39                                         CHAR        (39)                                                      NOT NULL     /* （連携用）予備項目Ｖ３９ */
)
;

ALTER TABLE ZT_KhGinkouMdhnFollowCallRn ADD CONSTRAINT PK_KhGinkouMdhnFollowCallRn PRIMARY KEY (
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrnminyuuym                                                /* （連携用）未入年月 */
) ;

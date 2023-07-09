CREATE TABLE ZT_KinyuuKikanInfoRn (
     zrnkinyuukikancd                                   CHAR        (4)                                                       NOT NULL  ,  /* （連携用）金融機関コード */
     zrnsitencd                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）支店コード */
     zrntenpokbn                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）店舗区分 */
     zrnkousinymd                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）更新年月日 */
     zrnsinsetuymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）新設年月日 */
     zrnhaisiymd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）廃止年月日 */
     zrnkanakinyuukikannm                               CHAR        (25)                                                      NOT NULL  ,  /* （連携用）カナ金融機関名 */
     zrnkanasitennm                                     CHAR        (25)                                                      NOT NULL  ,  /* （連携用）カナ支店名 */
     zrnkanjikinyuukikannm                              VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）漢字金融機関名 */
     zrnkanjisitennm                                    VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）漢字支店名 */
     zrneijikinyuukikannm                               CHAR        (60)                                                      NOT NULL  ,  /* （連携用）英字金融機関名 */
     zrneijisitennm                                     CHAR        (60)                                                      NOT NULL  ,  /* （連携用）英字支店名 */
     zrncsskyouteikaisiymd                              CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＣＳＳ協定開始年月日 */
     zrncsskyouteikaijyoymd                             CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＣＳＳ協定解除年月日 */
     zrnkokunaikawasehyouji                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）内国為替制度加盟表示 */
     zrnhurikomikanousitenhyouji                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）振込可能支店表示 */
     zrngyoutaikbn                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）業態区分 */
     zrnyofurikyouteikaisiymd                           CHAR        (8)                                                       NOT NULL  ,  /* （連携用）預振協定開始年月日 */
     zrnyofurikyouteikaijyoymd                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）預振協定解除年月日 */
     zrnitakusyakinyuucd                                CHAR        (4)                                                       NOT NULL  ,  /* （連携用）委託者金融機関コード */
     zrnitakusyasitencd                                 CHAR        (4)                                                       NOT NULL  ,  /* （連携用）委託者支店コード */
     zrnitakusyayokinkbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）委託者預金種目区分 */
     zrnitakusyakouzano                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）委託者口座番号 */
     zrntsrkeisanhoukbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）手数料計算方法区分 */
     zrnkinyuutesuuryou                                 NUMBER      (5)                                                       NOT NULL  ,  /* （連携用）手数料 */
     zrnitakusyacd                                      CHAR        (10)                                                      NOT NULL  ,  /* （連携用）委託者コード */
     zrntapekoukankbn1                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）テープ交換区分１ */
     zrnmdsisyacd                                       CHAR        (7)                                                       NOT NULL  ,  /* （連携用）窓口支社コード */
     zrnzzkkyouteikaisiymd                              CHAR        (8)                                                       NOT NULL  ,  /* （連携用）全税共協定開始年月日 */
     zrnzzkkyouteikaijyoymd                             CHAR        (8)                                                       NOT NULL  ,  /* （連携用）全税共協定解除年月日 */
     zrnhuhoyofuriinfokousinymd                         CHAR        (8)                                                       NOT NULL  ,  /* （連携用）普保預振情報更新年月日 */
     zrnyobiv17                                         CHAR        (17)                                                      NOT NULL     /* （連携用）予備項目Ｖ１７ */
)
;

ALTER TABLE ZT_KinyuuKikanInfoRn ADD CONSTRAINT PK_KinyuuKikanInfoRn PRIMARY KEY (
     zrnkinyuukikancd                                         , /* （連携用）金融機関コード */
     zrnsitencd                                                 /* （連携用）支店コード */
) ;

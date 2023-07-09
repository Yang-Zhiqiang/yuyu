CREATE TABLE ZT_DairitenGtmtZndkRn_Z (
     zrndatakijyunymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）データ基準年月日 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnhknsyuruikigousedaikbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険種類記号世代区分 */
     zrnmdhnaisyoumeicd                                 CHAR        (3)                                                       NOT NULL  ,  /* （連携用）窓販用愛称名コード */
     zrntuuka                                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）通貨 */
     zrnhrkhuhukbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込方法区分 */
     zrnkyknmkndrtengtmtzndk                            CHAR        (70)                                                      NOT NULL  ,  /* （連携用）契約者名（カナ）（代理店月末残高） */
     zrnkyknmkjdrtengtmtzndk                            GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）契約者名（漢字）（代理店月末残高） */
     zrnhhknnmkjdrtengtmtzndk                           GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）被保険者名（漢字）（代理店月末残高） */
     zrnitijibrp                                        DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）一時払保険料 */
     zrngoukeip2                                        DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）合計保険料２ */
     zrnzennoup                                         DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）前納保険料 */
     zrntumitatekngk                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）積立金額 */
     zrntargettktoutatubi                               CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ターゲット到達日 */
     zrnmokuhyouti                                      DECIMAL     (3)                                                       NOT NULL  ,  /* （連携用）目標値 */
     zrnmokuhyoukngk                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）目標金額 */
     zrnkaiyakuhr                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）解約返戻金 */
     zrnkihrkmpjytym                                    CHAR        (6)                                                       NOT NULL  ,  /* （連携用）既払込保険料充当年月 */
     zrnkihrpruikeigk                                   DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）既払保険料累計額 */
     zrntousyokykjikawaserate                           DECIMAL     (7,2)                                                     NOT NULL  ,  /* （連携用）当初契約時為替レート */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnmankiymd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）満期年月日 */
     zrnkishrkinruikeigk                                DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）既支払金累計額 */
     zrnsjkkktyouseigk                                  DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）市場価格調整額 */
     zrnkaiyakukjgk                                     DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）解約控除額 */
     zrnsoneki                                          DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）損益 */
     zrnsonekicalchunouflg                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）損益計算不能フラグ */
     zrnsibous                                          DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）死亡Ｓ */
     zrngmeigyoubijiyenshrrate                          DECIMAL     (7,2)                                                     NOT NULL  ,  /* （連携用）月末営業日時円支払レート */
     zrngmeigyoubijikawaserate                          DECIMAL     (7,2)                                                     NOT NULL  ,  /* （連携用）月末営業日時為替レート */
     zrntousyokykjiyennyknrate                          DECIMAL     (7,2)                                                     NOT NULL  ,  /* （連携用）当初契約時円入金レート */
     zrntousyokykjigaikanyknrate                        DECIMAL     (7,4)                                                     NOT NULL  ,  /* （連携用）当初契約時外貨入金レート */
     zrnkanyuusyaknrno                                  CHAR        (15)                                                      NOT NULL  ,  /* （連携用）加入者管理番号 */
     zrnhrkstgktuuka                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）払込相当額通貨 */
     zrnmokuhyoukngktuuka                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）目標金額通貨 */
     zrnsonotaseisankin                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）その他精算金 */
     zrnyenkansansaiyousign                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）円換算採用為替サイン */
     zrnkykjiyoteitmttriritu                            DECIMAL     (3,2)                                                     NOT NULL  ,  /* （連携用）契約時予定利率・積立利率 */
     zrnhukusuutuukaflg                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）複数通貨フラグ */
     zrnyenkansanhunoflg                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）円換算不能フラグ */
     zrntyusyaku20                                      CHAR        (20)                                                      NOT NULL  ,  /* （連携用）注釈２０ */
     zrnyobiv187                                        CHAR        (187)                                                     NOT NULL     /* （連携用）予備項目Ｖ１８７ */
)
;

ALTER TABLE ZT_DairitenGtmtZndkRn_Z ADD CONSTRAINT PK_DairitenGtmtZndkRn PRIMARY KEY (
     zrndatakijyunymd                                         , /* （連携用）データ基準年月日 */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;

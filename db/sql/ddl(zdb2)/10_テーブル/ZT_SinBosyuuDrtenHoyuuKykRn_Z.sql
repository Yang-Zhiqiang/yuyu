CREATE TABLE ZT_SinBosyuuDrtenHoyuuKykRn_Z (
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnmdhnaisyoumeicd                                 CHAR        (3)                                                       NOT NULL  ,  /* （連携用）窓販用愛称名コード */
     zrnaisyoumeidrtengetuji                            GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）愛称名（代理店月次） */
     zrnharaikatakbndrtengetuji                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払方区分（代理店月次） */
     zrnsyohnbnrikbndrtengetuji                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）商品分類区分（代理店月次） */
     zrnteikaiyakuhrkngatahyj                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）低解約返戻金型表示 */
     zrnskeibsyaatkioydrtencd                           CHAR        (7)                                                       NOT NULL  ,  /* （連携用）新契約募集時Ａ扱親代理店コード */
     zrnskeibsybatkioydrtencd                           CHAR        (7)                                                       NOT NULL  ,  /* （連携用）新契約募集時Ｂ扱親代理店コード */
     zrnskeibsyaatkidrtencd                             CHAR        (7)                                                       NOT NULL  ,  /* （連携用）新契約募集時Ａ扱代理店コード */
     zrnskeibsybatkidrtencd                             CHAR        (7)                                                       NOT NULL  ,  /* （連携用）新契約募集時Ｂ扱代理店コード */
     zrnskeibsyaatkibosyuucd                            CHAR        (6)                                                       NOT NULL  ,  /* （連携用）新契約募集時Ａ扱募集人コード */
     zrnskeibsybatkibosyuucd                            CHAR        (6)                                                       NOT NULL  ,  /* （連携用）新契約募集時Ｂ扱募集人コード */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnhknsyuruikigousedaikbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険種類記号世代区分 */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnhknkknmanryouymd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）保険期間満了日 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnannaifuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内不要理由区分 */
     zrnsyoumetucd                                      CHAR        (4)                                                       NOT NULL  ,  /* （連携用）消滅コード */
     zrnsymtymd                                         CHAR        (8)                                                       NOT NULL  ,  /* （連携用）消滅年月日 */
     zrnhrkpdrtengetuji                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）払込保険料（代理店月次） */
     zrnnenkansanpheijyun                               DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）年換算保険料（平準払） */
     zrnknkyknm18                                       CHAR        (18)                                                      NOT NULL  ,  /* （連携用）カナ契約者名（１８文字） */
     zrnkyknmdrtengetuji                                GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）契約者名（代理店月次） */
     zrnkyknenkykji                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）契約者年齢（契約時） */
     zrnkyknengenzai                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）契約者年齢（現在） */
     zrnkyksyaseiymd                                    CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約者生年月日 */
     zrnkyksyaseikbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約者性別区分 */
     zrnhrkpjyuutouym                                   CHAR        (6)                                                       NOT NULL  ,  /* （連携用）払込保険料充当年月 */
     zrnkihrkmpjytym                                    CHAR        (6)                                                       NOT NULL  ,  /* （連携用）既払込保険料充当年月 */
     zrnkihrkmpmf                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）既払込保険料（ＭＦ） */
     zrnkihrkmpruikei                                   DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）既払込保険料（累計） */
     zrnkaiyksymtjiw                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）解約消滅時解約返戻金 */
     zrnkaiyksymtjikihrkmp                              DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）解約消滅時既払保険料 */
     zrnkaiyksymtjiunyousoneki                          DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）解約消滅時運用損益 */
     zrnkaiyksymtjiunyousonekirt                        DECIMAL     (3)                                                       NOT NULL  ,  /* （連携用）解約消滅時運用損益率 */
     zrnwkeisanerrkbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）解約返戻金計算エラー区分 */
     zrnmnknksjihenreikingk                             DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）満期年金開始時返戻金額 */
     zrnmnknksjikihrkmp                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）満期年金開始時既払保険料 */
     zrnmnknksjiunyousoneki                             DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）満期年金開始時運用損益 */
     zrnmnknksjiunyousonekirt                           DECIMAL     (3)                                                       NOT NULL  ,  /* （連携用）満期年金開始時運用損益率 */
     zrnmnknkskeisanerrkbn                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）満期年金開始計算エラー区分 */
     zrnnenkansanpanp                                   DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）年換算保険料（ＡＮ保険料） */
     zrnnenkansanpkeisanerrkbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）年換算保険料計算エラー区分 */
     zrncifcd                                           CHAR        (15)                                                      NOT NULL  ,  /* （連携用）ＣＩＦコード */
     zrnhrkpgaika                                       DECIMAL     (11,2)                                                    NOT NULL  ,  /* （連携用）払込Ｐ（外貨） */
     zrnkaiyksymtjiwgaika                               DECIMAL     (11,2)                                                    NOT NULL  ,  /* （連携用）解約消滅時解約返戻金（外貨） */
     zrntuuka                                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）通貨 */
     zrnitijibrpyendrtengetuji                          DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）一時払保険料（円）（代理店月次） */
     zrnitijibrpgaika                                   DECIMAL     (11,2)                                                    NOT NULL  ,  /* （連携用）一時払保険料（外貨） */
     zrnkiuktrknyen                                     DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）既受取金（円） */
     zrnkiuktrkngaika                                   DECIMAL     (11,2)                                                    NOT NULL  ,  /* （連携用）既受取金（外貨） */
     zrntmttknyen                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）積立金（円） */
     zrntmttkngaika                                     DECIMAL     (11,2)                                                    NOT NULL  ,  /* （連携用）積立金（外貨） */
     zrnkaiyakukjetcyen                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）解約控除等（円） */
     zrnkaiyakukjetcgaika                               DECIMAL     (11,2)                                                    NOT NULL  ,  /* （連携用）解約控除等（外貨） */
     zrnwyendrtengetuji                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円）（代理店月次） */
     zrnkaiyakuhrkngaika                                DECIMAL     (11,2)                                                    NOT NULL  ,  /* （連携用）解約返戻金（外貨） */
     zrnsonekiyen                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）損益（円） */
     zrnsonekigaika                                     DECIMAL     (11,2)                                                    NOT NULL  ,  /* （連携用）損益（外貨） */
     zrnsbsetcyen                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）死亡保険金等（円） */
     zrnsbsetcgaika                                     DECIMAL     (11,2)                                                    NOT NULL  ,  /* （連携用）死亡保険金等（外貨） */
     zrnsonekicalchunouflg                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）損益計算不能フラグ */
     zrnhhknnmkjdrtengetuji                             GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）被保険者名（漢字）（代理店月次） */
     zrntargettktoutatubi                               CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ターゲット到達日 */
     zrnmokuhyouti                                      DECIMAL     (3)                                                       NOT NULL  ,  /* （連携用）目標値 */
     zrnmokuhyoukngk                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）目標金額 */
     zrnkihrpruikeigk                                   DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）既払保険料累計額 */
     zrntousyokykjikawaserate                           DECIMAL     (7,2)                                                     NOT NULL  ,  /* （連携用）当初契約時為替レート */
     zrnwkeisanerrorhyj                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）解約返戻金計算エラー表示 */
     zrngmeigyoubijikawaserate                          DECIMAL     (7,2)                                                     NOT NULL  ,  /* （連携用）月末営業日時為替レート */
     zrnikueisikin                                      DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）育英資金 */
     zrngakusiiwaikn                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）学資祝金 */
     zrnzoukaseizonssueokikn                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）増加生存Ｓ据置金 */
     zrnknkuiwaikn                                      DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）健康祝金 */
     zrnkijyuiwaikn                                     DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）喜寿祝金 */
     zrnbeijyuiwaikn                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）米寿祝金 */
     zrnsznkyhkn                                        DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）生存給付金 */
     zrnkyktsnatkitkykkyhkn                             DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）契約通算扱特約給付金 */
     zrnzoukayourous                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）増加養老保険金 */
     zrntmtthaitoukin                                   DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）積立配当金 */
     zrntkbthaitoukin                                   DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）特別配当金 */
     zrnsonotahaitoukin                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）その他配当金 */
     zrngensentyousyuuzeigaku                           DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）源泉徴収税額 */
     zrnottkekinganrigoukei                             DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）お立替金元利合計 */
     zrnkstkknganrigoukei                               DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）貸付金元利合計 */
     zrnmikeikamisyuup                                  DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）未経過・未収保険料 */
     zrnsonotaseisankin                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）その他精算金 */
     zrnhuho2sjkkktyouseigkmva                          DECIMAL     (11,2)                                                    NOT NULL  ,  /* （連携用）（普保Ⅱ）市場価格調整額（ＭＶＡ） */
     zrnhuho2yendthnkhr                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）（普保Ⅱ）円建変更時返戻金 */
     zrnhuho2sjkkktyouseiriritu                         DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）（普保Ⅱ）市場価格調整用利率 */
     zrnhuho2kaiyakukoujyoritu                          DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）（普保Ⅱ）解約控除率 */
     zrnyobiv66                                         CHAR        (66)                                                      NOT NULL     /* （連携用）予備項目Ｖ６６ */
)
;

ALTER TABLE ZT_SinBosyuuDrtenHoyuuKykRn_Z ADD CONSTRAINT PK_SinBosyuuDrtenHoyuuKykRn PRIMARY KEY (
     zrnsyono                                                   /* （連携用）証券番号 */
) ;

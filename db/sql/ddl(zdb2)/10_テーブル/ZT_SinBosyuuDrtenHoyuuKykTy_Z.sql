CREATE TABLE ZT_SinBosyuuDrtenHoyuuKykTy_Z (
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztymdhnaisyoumeicd                                 VARCHAR     (3)                                                                 ,  /* （中継用）窓販用愛称名コード */
     ztyaisyoumeidrtengetuji                            VARCHAR     (62)                                                                ,  /* （中継用）愛称名（代理店月次） */
     ztyharaikatakbndrtengetuji                         VARCHAR     (1)                                                                 ,  /* （中継用）払方区分（代理店月次） */
     ztysyohnbnrikbndrtengetuji                         VARCHAR     (2)                                                                 ,  /* （中継用）商品分類区分（代理店月次） */
     ztyteikaiyakuhrkngatahyj                           VARCHAR     (1)                                                                 ,  /* （中継用）低解約返戻金型表示 */
     ztyskeibsyaatkioydrtencd                           VARCHAR     (7)                                                                 ,  /* （中継用）新契約募集時Ａ扱親代理店コード */
     ztyskeibsybatkioydrtencd                           VARCHAR     (7)                                                                 ,  /* （中継用）新契約募集時Ｂ扱親代理店コード */
     ztyskeibsyaatkidrtencd                             VARCHAR     (7)                                                                 ,  /* （中継用）新契約募集時Ａ扱代理店コード */
     ztyskeibsybatkidrtencd                             VARCHAR     (7)                                                                 ,  /* （中継用）新契約募集時Ｂ扱代理店コード */
     ztyskeibsyaatkibosyuucd                            VARCHAR     (6)                                                                 ,  /* （中継用）新契約募集時Ａ扱募集人コード */
     ztyskeibsybatkibosyuucd                            VARCHAR     (6)                                                                 ,  /* （中継用）新契約募集時Ｂ扱募集人コード */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztyhknsyuruikigousedaikbn                          VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号世代区分 */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztyhknkknmanryouymd                                VARCHAR     (8)                                                                 ,  /* （中継用）保険期間満了日 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyannaifuyouriyuukbn                              VARCHAR     (2)                                                                 ,  /* （中継用）案内不要理由区分 */
     ztysyoumetucd                                      VARCHAR     (4)                                                                 ,  /* （中継用）消滅コード */
     ztysymtymd                                         VARCHAR     (8)                                                                 ,  /* （中継用）消滅年月日 */
     ztyhrkpdrtengetuji                                 DECIMAL     (11)                                                                ,  /* （中継用）払込保険料（代理店月次） */
     ztynenkansanpheijyun                               DECIMAL     (11)                                                                ,  /* （中継用）年換算保険料（平準払） */
     ztyknkyknm18                                       VARCHAR     (38)                                                                ,  /* （中継用）カナ契約者名（１８文字） */
     ztykyknmdrtengetuji                                VARCHAR     (32)                                                                ,  /* （中継用）契約者名（代理店月次） */
     ztykyknenkykji                                     VARCHAR     (2)                                                                 ,  /* （中継用）契約者年齢（契約時） */
     ztykyknengenzai                                    VARCHAR     (3)                                                                 ,  /* （中継用）契約者年齢（現在） */
     ztykyksyaseiymd                                    VARCHAR     (8)                                                                 ,  /* （中継用）契約者生年月日 */
     ztykyksyaseikbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）契約者性別区分 */
     ztyhrkpjyuutouym                                   VARCHAR     (6)                                                                 ,  /* （中継用）払込保険料充当年月 */
     ztykihrkmpjytym                                    VARCHAR     (6)                                                                 ,  /* （中継用）既払込保険料充当年月 */
     ztykihrkmpmf                                       DECIMAL     (11)                                                                ,  /* （中継用）既払込保険料（ＭＦ） */
     ztykihrkmpruikei                                   DECIMAL     (11)                                                                ,  /* （中継用）既払込保険料（累計） */
     ztykaiyksymtjiw                                    DECIMAL     (11)                                                                ,  /* （中継用）解約消滅時解約返戻金 */
     ztykaiyksymtjikihrkmp                              DECIMAL     (11)                                                                ,  /* （中継用）解約消滅時既払保険料 */
     ztykaiyksymtjiunyousoneki                          DECIMAL     (11)                                                                ,  /* （中継用）解約消滅時運用損益 */
     ztykaiyksymtjiunyousonekirt                        DECIMAL     (3)                                                                 ,  /* （中継用）解約消滅時運用損益率 */
     ztywkeisanerrkbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）解約返戻金計算エラー区分 */
     ztymnknksjihenreikingk                             DECIMAL     (11)                                                                ,  /* （中継用）満期年金開始時返戻金額 */
     ztymnknksjikihrkmp                                 DECIMAL     (11)                                                                ,  /* （中継用）満期年金開始時既払保険料 */
     ztymnknksjiunyousoneki                             DECIMAL     (11)                                                                ,  /* （中継用）満期年金開始時運用損益 */
     ztymnknksjiunyousonekirt                           DECIMAL     (3)                                                                 ,  /* （中継用）満期年金開始時運用損益率 */
     ztymnknkskeisanerrkbn                              VARCHAR     (1)                                                                 ,  /* （中継用）満期年金開始計算エラー区分 */
     ztynenkansanpanp                                   DECIMAL     (11)                                                                ,  /* （中継用）年換算保険料（ＡＮ保険料） */
     ztynenkansanpkeisanerrkbn                          VARCHAR     (1)                                                                 ,  /* （中継用）年換算保険料計算エラー区分 */
     ztycifcd                                           VARCHAR     (15)                                                                ,  /* （中継用）ＣＩＦコード */
     ztyhrkpgaika                                       DECIMAL     (11,2)                                                              ,  /* （中継用）払込Ｐ（外貨） */
     ztykaiyksymtjiwgaika                               DECIMAL     (11,2)                                                              ,  /* （中継用）解約消滅時解約返戻金（外貨） */
     ztytuuka                                           VARCHAR     (2)                                                                 ,  /* （中継用）通貨 */
     ztyitijibrpyendrtengetuji                          DECIMAL     (11)                                                                ,  /* （中継用）一時払保険料（円）（代理店月次） */
     ztyitijibrpgaika                                   DECIMAL     (11,2)                                                              ,  /* （中継用）一時払保険料（外貨） */
     ztykiuktrknyen                                     DECIMAL     (11)                                                                ,  /* （中継用）既受取金（円） */
     ztykiuktrkngaika                                   DECIMAL     (11,2)                                                              ,  /* （中継用）既受取金（外貨） */
     ztytmttknyen                                       DECIMAL     (11)                                                                ,  /* （中継用）積立金（円） */
     ztytmttkngaika                                     DECIMAL     (11,2)                                                              ,  /* （中継用）積立金（外貨） */
     ztykaiyakukjetcyen                                 DECIMAL     (11)                                                                ,  /* （中継用）解約控除等（円） */
     ztykaiyakukjetcgaika                               DECIMAL     (11,2)                                                              ,  /* （中継用）解約控除等（外貨） */
     ztywyendrtengetuji                                 DECIMAL     (11)                                                                ,  /* （中継用）解約返戻金（円）（代理店月次） */
     ztykaiyakuhrkngaika                                DECIMAL     (11,2)                                                              ,  /* （中継用）解約返戻金（外貨） */
     ztysonekiyen                                       DECIMAL     (11)                                                                ,  /* （中継用）損益（円） */
     ztysonekigaika                                     DECIMAL     (11,2)                                                              ,  /* （中継用）損益（外貨） */
     ztysbsetcyen                                       DECIMAL     (11)                                                                ,  /* （中継用）死亡保険金等（円） */
     ztysbsetcgaika                                     DECIMAL     (11,2)                                                              ,  /* （中継用）死亡保険金等（外貨） */
     ztysonekicalchunouflg                              VARCHAR     (1)                                                                 ,  /* （中継用）損益計算不能フラグ */
     ztyhhknnmkjdrtengetuji                             VARCHAR     (72)                                                                ,  /* （中継用）被保険者名（漢字）（代理店月次） */
     ztytargettktoutatubi                               VARCHAR     (8)                                                                 ,  /* （中継用）ターゲット到達日 */
     ztymokuhyouti                                      DECIMAL     (3)                                                                 ,  /* （中継用）目標値 */
     ztymokuhyoukngk                                    DECIMAL     (11)                                                                ,  /* （中継用）目標金額 */
     ztykihrpruikeigk                                   DECIMAL     (11)                                                                ,  /* （中継用）既払保険料累計額 */
     ztytousyokykjikawaserate                           DECIMAL     (7,2)                                                               ,  /* （中継用）当初契約時為替レート */
     ztywkeisanerrorhyj                                 VARCHAR     (1)                                                                 ,  /* （中継用）解約返戻金計算エラー表示 */
     ztygmeigyoubijikawaserate                          DECIMAL     (7,2)                                                               ,  /* （中継用）月末営業日時為替レート */
     ztyikueisikin                                      DECIMAL     (11)                                                                ,  /* （中継用）育英資金 */
     ztygakusiiwaikn                                    DECIMAL     (11)                                                                ,  /* （中継用）学資祝金 */
     ztyzoukaseizonssueokikn                            DECIMAL     (11)                                                                ,  /* （中継用）増加生存Ｓ据置金 */
     ztyknkuiwaikn                                      DECIMAL     (11)                                                                ,  /* （中継用）健康祝金 */
     ztykijyuiwaikn                                     DECIMAL     (11)                                                                ,  /* （中継用）喜寿祝金 */
     ztybeijyuiwaikn                                    DECIMAL     (11)                                                                ,  /* （中継用）米寿祝金 */
     ztysznkyhkn                                        DECIMAL     (11)                                                                ,  /* （中継用）生存給付金 */
     ztykyktsnatkitkykkyhkn                             DECIMAL     (11)                                                                ,  /* （中継用）契約通算扱特約給付金 */
     ztyzoukayourous                                    DECIMAL     (11)                                                                ,  /* （中継用）増加養老保険金 */
     ztytmtthaitoukin                                   DECIMAL     (11)                                                                ,  /* （中継用）積立配当金 */
     ztytkbthaitoukin                                   DECIMAL     (11)                                                                ,  /* （中継用）特別配当金 */
     ztysonotahaitoukin                                 DECIMAL     (11)                                                                ,  /* （中継用）その他配当金 */
     ztygensentyousyuuzeigaku                           DECIMAL     (11)                                                                ,  /* （中継用）源泉徴収税額 */
     ztyottkekinganrigoukei                             DECIMAL     (11)                                                                ,  /* （中継用）お立替金元利合計 */
     ztykstkknganrigoukei                               DECIMAL     (11)                                                                ,  /* （中継用）貸付金元利合計 */
     ztymikeikamisyuup                                  DECIMAL     (11)                                                                ,  /* （中継用）未経過・未収保険料 */
     ztysonotaseisankin                                 DECIMAL     (11)                                                                ,  /* （中継用）その他精算金 */
     ztyhuho2sjkkktyouseigkmva                          DECIMAL     (11,2)                                                              ,  /* （中継用）（普保Ⅱ）市場価格調整額（ＭＶＡ） */
     ztyhuho2yendthnkhr                                 DECIMAL     (11)                                                                ,  /* （中継用）（普保Ⅱ）円建変更時返戻金 */
     ztyhuho2sjkkktyouseiriritu                         DECIMAL     (5,4)                                                               ,  /* （中継用）（普保Ⅱ）市場価格調整用利率 */
     ztyhuho2kaiyakukoujyoritu                          DECIMAL     (5,4)                                                               ,  /* （中継用）（普保Ⅱ）解約控除率 */
     ztyyobiv66                                         VARCHAR     (66)                                                                ,  /* （中継用）予備項目Ｖ６６ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_SinBosyuuDrtenHoyuuKykTy_Z ADD CONSTRAINT PK_SinBosyuuDrtenHoyuuKykTy PRIMARY KEY (
     ztysyono                                                   /* （中継用）証券番号 */
) ;

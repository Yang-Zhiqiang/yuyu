CREATE TABLE ZT_KesikomiSousinCreditRn (
     zrnkskmsousinrenno                                 CHAR        (20)                                                      NOT NULL  ,  /* （連携用）消込送信連番 */
     zrnkskmkamokucd                                    CHAR        (5)                                                       NOT NULL  ,  /* （連携用）消込科目コード */
     zrnsuitoukbn                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）出納区分 */
     zrnsuitousosikicd                                  CHAR        (7)                                                       NOT NULL  ,  /* （連携用）出納組織コード */
     zrnhasseidenymd                                    CHAR        (8)                                                       NOT NULL  ,  /* （連携用）発生伝票日付 */
     zrnkarikanjyono                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）仮勘定番号 */
     zrnnkkakusyounyuuryokuymd1                         CHAR        (8)                                                       NOT NULL  ,  /* （連携用）入金確証入力年月日１ */
     zrniktannaidantaizaikeikbn                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）一括案内団体財形区分 */
     zrnkskmfanniskcd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）（消込Ｆ）案内先コード */
     zrndantaiannaijyuutouym1                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）団体案内充当年月１ */
     zrnannaino1                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内番号１ */
     zrnbonusharaihyouji1                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ボーナス払表示１ */
     zrnkskmfkzhurikaebankcd                            CHAR        (4)                                                       NOT NULL  ,  /* （連携用）（消込Ｆ）口座振替銀行番号 */
     zrnkskmfhurikaeymd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）（消込Ｆ）振替年月日 */
     zrndairitenuketukeno1                              CHAR        (4)                                                       NOT NULL  ,  /* （連携用）代理店受付番号１ */
     zrnzaikeihrkkaisuukbn1                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）財形払込回数区分１ */
     zrnnoukinhyouno                                    CHAR        (9)                                                       NOT NULL  ,  /* （連携用）納金票番号 */
     zrnkskmfcreditkaisyacd                             CHAR        (5)                                                       NOT NULL  ,  /* （連携用）（消込Ｆ）クレジット会社コード */
     zrnkinyuukikankbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）金融機関区分 */
     zrnyobiv18                                         CHAR        (18)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１８ */
     zrnkskmfsyoriymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）（消込Ｆ）処理年月日 */
     zrnkskmfdenymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）（消込Ｆ）伝票日付 */
     zrndenatesakicd                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）伝票宛先部課コード */
     zrnkskmftaisyakukbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）（消込Ｆ）貸借区分 */
     zrnhutuuhokenkamokucd                              CHAR        (5)                                                       NOT NULL  ,  /* （連携用）普通保険用科目コード */
     zrndengk                                           NUMBER      (15)                                                      NOT NULL  ,  /* （連携用）伝票金額 */
     zrntabakariknjykskmdatakbn                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）束仮勘定消込項目データ区分 */
     zrnkskmfryousyuuymd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）（消込Ｆ）領収年月日 */
     zrnryousyuuhm                                      CHAR        (4)                                                       NOT NULL  ,  /* （連携用）領収時分 */
     zrnyobiv3                                          CHAR        (3)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ３ */
     zrnnkkakusyounyuuryokuymd2                         CHAR        (8)                                                       NOT NULL  ,  /* （連携用）入金確証入力年月日２ */
     zrnkskmfsyono                                      CHAR        (11)                                                      NOT NULL  ,  /* （連携用）（消込Ｆ）証券番号 */
     zrnnkhoukokuhyoutantouka                           CHAR        (3)                                                       NOT NULL  ,  /* （連携用）入金報告票担当課 */
     zrnnkhoukokuhyoukihyouymd                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）入金報告票起票年月日 */
     zrnnkhoukokuhyoubunkaino                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）入金報告票分解表番号 */
     zrnnkkakusyounyuuryokuno                           CHAR        (8)                                                       NOT NULL  ,  /* （連携用）入金確証入力番号 */
     zrnkskmfdantaicd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）（消込Ｆ）団体コード */
     zrndantaiannaijyuutouym2                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）団体案内充当年月２ */
     zrnbonusharaihyouji2                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ボーナス払表示２ */
     zrnannaino2                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内番号２ */
     zrndantaipkbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）団体保険料区分 */
     zrndantainyuukinymd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）団体入金年月日 */
     zrnkskmfjyuutouym                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）（消込Ｆ）充当年月 */
     zrnsuitouymd                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）出納年月日 */
     zrnnyuuryokuhouhoukbn                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）入力方法区分 */
     zrnkskmfnyknaiyoukbn                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）（消込Ｆ）入金内容区分 */
     zrnkzhurikaekykhndnkhyouji                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座振替契約ハンド入金表示 */
     zrnkskmfdairitencd                                 CHAR        (7)                                                       NOT NULL  ,  /* （連携用）（消込Ｆ）代理店コード */
     zrndairitenuketukeno2                              CHAR        (4)                                                       NOT NULL  ,  /* （連携用）代理店受付番号２ */
     zrnikkatudantaicd                                  CHAR        (11)                                                      NOT NULL  ,  /* （連携用）一括団体コード */
     zrnikkatuannaihikisariym                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）一括案内引去年月 */
     zrnikkatuannaino                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）一括案内番号 */
     zrnzaikeihrkkaisuukbn2                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）財形払込回数区分２ */
     zrnzaikeikyksyano                                  CHAR        (10)                                                      NOT NULL  ,  /* （連携用）財形契約者番号 */
     zrnhasseisosikicd                                  CHAR        (7)                                                       NOT NULL  ,  /* （連携用）発生組織コード */
     zrnteikeisakikaisyacd                              CHAR        (4)                                                       NOT NULL  ,  /* （連携用）提携先会社コード */
     zrnkskmfbankcd                                     CHAR        (4)                                                       NOT NULL  ,  /* （連携用）（消込Ｆ）銀行番号 */
     zrnsuitousyorisosikicd                             CHAR        (7)                                                       NOT NULL  ,  /* （連携用）出納処理組織コード */
     zrnaitekanjyouyomikaekbn                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）相手勘定読替区分 */
     zrncreditcardhrkskmkbn                             CHAR        (2)                                                       NOT NULL  ,  /* （連携用）クレ払消込区分 */
     zrnlastteiseiymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）最終訂正年月日 */
     zrnkskmkanryouymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）消込完了年月日 */
     zrnkskmteiseino                                    CHAR        (10)                                                      NOT NULL  ,  /* （連携用）消込訂正番号 */
     zrnkskmkanryousijihyouji                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）消込完了指示表示 */
     zrnuketuketencd                                    CHAR        (7)                                                       NOT NULL  ,  /* （連携用）受付店コード */
     zrncvscd                                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）ＣＶＳコード */
     zrnhurikomiyousinyuukinkbn                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）振込用紙入金区分 */
     zrnhurikomiyousiokyksmno                           CHAR        (12)                                                      NOT NULL  ,  /* （連携用）振込用紙お客さま番号 */
     zrnhurikomiyousikakuninno                          CHAR        (5)                                                       NOT NULL  ,  /* （連携用）振込用紙確認番号 */
     zrnegsyokuinhurikomiymd                            CHAR        (8)                                                       NOT NULL  ,  /* （連携用）営業職員振込年月日 */
     zrnvitkaiinno                                      CHAR        (10)                                                      NOT NULL  ,  /* （連携用）Ｖｉｔ会員番号 */
     zrnyobiv74                                         CHAR        (74)                                                      NOT NULL     /* （連携用）予備項目Ｖ７４ */
)
;

ALTER TABLE ZT_KesikomiSousinCreditRn ADD CONSTRAINT PK_KesikomiSousinCreditRn PRIMARY KEY (
     zrnkskmsousinrenno                                       , /* （連携用）消込送信連番 */
     zrnkskmfsyoriymd                                           /* （連携用）（消込Ｆ）処理年月日 */
) ;

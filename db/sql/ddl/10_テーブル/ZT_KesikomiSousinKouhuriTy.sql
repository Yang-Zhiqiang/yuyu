CREATE TABLE ZT_KesikomiSousinKouhuriTy (
     ztykskmsousinrenno                                 VARCHAR     (20)                                                      NOT NULL  ,  /* （中継用）消込送信連番 */
     ztykskmkamokucd                                    VARCHAR     (5)                                                                 ,  /* （中継用）消込科目コード */
     ztysuitoukbn                                       VARCHAR     (2)                                                                 ,  /* （中継用）出納区分 */
     ztysuitousosikicd                                  VARCHAR     (7)                                                                 ,  /* （中継用）出納組織コード */
     ztyhasseidenymd                                    VARCHAR     (8)                                                                 ,  /* （中継用）発生伝票日付 */
     ztykarikanjyono                                    VARCHAR     (2)                                                                 ,  /* （中継用）仮勘定番号 */
     ztynkkakusyounyuuryokuymd1                         VARCHAR     (8)                                                                 ,  /* （中継用）入金確証入力年月日１ */
     ztyiktannaidantaizaikeikbn                         VARCHAR     (1)                                                                 ,  /* （中継用）一括案内団体財形区分 */
     ztykskmfanniskcd                                   VARCHAR     (8)                                                                 ,  /* （中継用）（消込Ｆ）案内先コード */
     ztydantaiannaijyuutouym1                           VARCHAR     (6)                                                                 ,  /* （中継用）団体案内充当年月１ */
     ztyannaino1                                        VARCHAR     (2)                                                                 ,  /* （中継用）案内番号１ */
     ztybonusharaihyouji1                               VARCHAR     (1)                                                                 ,  /* （中継用）ボーナス払表示１ */
     ztykskmfkzhurikaebankcd                            VARCHAR     (4)                                                                 ,  /* （中継用）（消込Ｆ）口座振替銀行番号 */
     ztykskmfhurikaeymd                                 VARCHAR     (8)                                                                 ,  /* （中継用）（消込Ｆ）振替年月日 */
     ztydairitenuketukeno1                              VARCHAR     (4)                                                                 ,  /* （中継用）代理店受付番号１ */
     ztyzaikeihrkkaisuukbn1                             VARCHAR     (1)                                                                 ,  /* （中継用）財形払込回数区分１ */
     ztynoukinhyouno                                    VARCHAR     (9)                                                                 ,  /* （中継用）納金票番号 */
     ztykskmfcreditkaisyacd                             VARCHAR     (5)                                                                 ,  /* （中継用）（消込Ｆ）クレジット会社コード */
     ztykinyuukikankbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）金融機関区分 */
     ztyyobiv18                                         VARCHAR     (18)                                                                ,  /* （中継用）予備項目Ｖ１８ */
     ztykskmfsyoriymd                                   VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）（消込Ｆ）処理年月日 */
     ztykskmfdenymd                                     VARCHAR     (8)                                                                 ,  /* （中継用）（消込Ｆ）伝票日付 */
     ztydenatesakicd                                    VARCHAR     (3)                                                                 ,  /* （中継用）伝票宛先部課コード */
     ztykskmftaisyakukbn                                VARCHAR     (1)                                                                 ,  /* （中継用）（消込Ｆ）貸借区分 */
     ztyhutuuhokenkamokucd                              VARCHAR     (5)                                                                 ,  /* （中継用）普通保険用科目コード */
     ztydengk                                           NUMBER      (15)                                                                ,  /* （中継用）伝票金額 */
     ztytabakariknjykskmdatakbn                         VARCHAR     (2)                                                                 ,  /* （中継用）束仮勘定消込項目データ区分 */
     ztykskmfryousyuuymd                                VARCHAR     (8)                                                                 ,  /* （中継用）（消込Ｆ）領収年月日 */
     ztyryousyuuhm                                      VARCHAR     (4)                                                                 ,  /* （中継用）領収時分 */
     ztyyobiv3                                          VARCHAR     (3)                                                                 ,  /* （中継用）予備項目Ｖ３ */
     ztynkkakusyounyuuryokuymd2                         VARCHAR     (8)                                                                 ,  /* （中継用）入金確証入力年月日２ */
     ztykskmfsyono                                      VARCHAR     (11)                                                                ,  /* （中継用）（消込Ｆ）証券番号 */
     ztynkhoukokuhyoutantouka                           VARCHAR     (3)                                                                 ,  /* （中継用）入金報告票担当課 */
     ztynkhoukokuhyoukihyouymd                          VARCHAR     (8)                                                                 ,  /* （中継用）入金報告票起票年月日 */
     ztynkhoukokuhyoubunkaino                           VARCHAR     (2)                                                                 ,  /* （中継用）入金報告票分解表番号 */
     ztynkkakusyounyuuryokuno                           VARCHAR     (8)                                                                 ,  /* （中継用）入金確証入力番号 */
     ztykskmfdantaicd                                   VARCHAR     (8)                                                                 ,  /* （中継用）（消込Ｆ）団体コード */
     ztydantaiannaijyuutouym2                           VARCHAR     (6)                                                                 ,  /* （中継用）団体案内充当年月２ */
     ztybonusharaihyouji2                               VARCHAR     (1)                                                                 ,  /* （中継用）ボーナス払表示２ */
     ztyannaino2                                        VARCHAR     (2)                                                                 ,  /* （中継用）案内番号２ */
     ztydantaipkbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）団体保険料区分 */
     ztydantainyuukinymd                                VARCHAR     (8)                                                                 ,  /* （中継用）団体入金年月日 */
     ztykskmfjyuutouym                                  VARCHAR     (6)                                                                 ,  /* （中継用）（消込Ｆ）充当年月 */
     ztysuitouymd                                       VARCHAR     (8)                                                                 ,  /* （中継用）出納年月日 */
     ztynyuuryokuhouhoukbn                              VARCHAR     (1)                                                                 ,  /* （中継用）入力方法区分 */
     ztykskmfnyknaiyoukbn                               VARCHAR     (2)                                                                 ,  /* （中継用）（消込Ｆ）入金内容区分 */
     ztykzhurikaekykhndnkhyouji                         VARCHAR     (1)                                                                 ,  /* （中継用）口座振替契約ハンド入金表示 */
     ztykskmfdairitencd                                 VARCHAR     (7)                                                                 ,  /* （中継用）（消込Ｆ）代理店コード */
     ztydairitenuketukeno2                              VARCHAR     (4)                                                                 ,  /* （中継用）代理店受付番号２ */
     ztyikkatudantaicd                                  VARCHAR     (11)                                                                ,  /* （中継用）一括団体コード */
     ztyikkatuannaihikisariym                           VARCHAR     (6)                                                                 ,  /* （中継用）一括案内引去年月 */
     ztyikkatuannaino                                   VARCHAR     (1)                                                                 ,  /* （中継用）一括案内番号 */
     ztyzaikeihrkkaisuukbn2                             VARCHAR     (1)                                                                 ,  /* （中継用）財形払込回数区分２ */
     ztyzaikeikyksyano                                  VARCHAR     (10)                                                                ,  /* （中継用）財形契約者番号 */
     ztyhasseisosikicd                                  VARCHAR     (7)                                                                 ,  /* （中継用）発生組織コード */
     ztyteikeisakikaisyacd                              VARCHAR     (4)                                                                 ,  /* （中継用）提携先会社コード */
     ztykskmfbankcd                                     VARCHAR     (4)                                                                 ,  /* （中継用）（消込Ｆ）銀行番号 */
     ztysuitousyorisosikicd                             VARCHAR     (7)                                                                 ,  /* （中継用）出納処理組織コード */
     ztyaitekanjyouyomikaekbn                           VARCHAR     (2)                                                                 ,  /* （中継用）相手勘定読替区分 */
     ztycreditcardhrkskmkbn                             VARCHAR     (2)                                                                 ,  /* （中継用）クレ払消込区分 */
     ztylastteiseiymd                                   VARCHAR     (8)                                                                 ,  /* （中継用）最終訂正年月日 */
     ztykskmkanryouymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）消込完了年月日 */
     ztykskmteiseino                                    VARCHAR     (10)                                                                ,  /* （中継用）消込訂正番号 */
     ztykskmkanryousijihyouji                           VARCHAR     (1)                                                                 ,  /* （中継用）消込完了指示表示 */
     ztyuketuketencd                                    VARCHAR     (7)                                                                 ,  /* （中継用）受付店コード */
     ztycvscd                                           VARCHAR     (6)                                                                 ,  /* （中継用）ＣＶＳコード */
     ztyhurikomiyousinyuukinkbn                         VARCHAR     (1)                                                                 ,  /* （中継用）振込用紙入金区分 */
     ztyhurikomiyousiokyksmno                           VARCHAR     (12)                                                                ,  /* （中継用）振込用紙お客さま番号 */
     ztyhurikomiyousikakuninno                          VARCHAR     (5)                                                                 ,  /* （中継用）振込用紙確認番号 */
     ztyegsyokuinhurikomiymd                            VARCHAR     (8)                                                                 ,  /* （中継用）営業職員振込年月日 */
     ztyvitkaiinno                                      VARCHAR     (10)                                                                ,  /* （中継用）Ｖｉｔ会員番号 */
     ztyyobiv74                                         VARCHAR     (74)                                                                ,  /* （中継用）予備項目Ｖ７４ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_KesikomiSousinKouhuriTy ADD CONSTRAINT PK_KesikomiSousinKouhuriTy PRIMARY KEY (
     ztykskmsousinrenno                                       , /* （中継用）消込送信連番 */
     ztykskmfsyoriymd                                           /* （中継用）（消込Ｆ）処理年月日 */
) ;

CREATE TABLE ZT_DairitenGtmtZndkTy (
     ztydatakijyunymd                                   VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）データ基準年月日 */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztyhknsyuruikigousedaikbn                          VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号世代区分 */
     ztymdhnaisyoumeicd                                 VARCHAR     (3)                                                                 ,  /* （中継用）窓販用愛称名コード */
     ztytuuka                                           VARCHAR     (2)                                                                 ,  /* （中継用）通貨 */
     ztyhrkhuhukbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）払込方法区分 */
     ztykyknmkndrtengtmtzndk                            VARCHAR     (18)                                                                ,  /* （中継用）契約者名（カナ）（代理店月末残高） */
     ztykyknmkjdrtengtmtzndk                            VARCHAR     (15)                                                                ,  /* （中継用）契約者名（漢字）（代理店月末残高） */
     ztyhhknnmkjdrtengtmtzndk                           VARCHAR     (15)                                                                ,  /* （中継用）被保険者名（漢字）（代理店月末残高） */
     ztyitijibrp                                        NUMBER      (11)                                                                ,  /* （中継用）一時払保険料 */
     ztygoukeip2                                        NUMBER      (11)                                                                ,  /* （中継用）合計保険料２ */
     ztyzennoup                                         NUMBER      (11)                                                                ,  /* （中継用）前納保険料 */
     ztytumitatekngk                                    NUMBER      (11)                                                                ,  /* （中継用）積立金額 */
     ztytargettktoutatubi                               VARCHAR     (8)                                                                 ,  /* （中継用）ターゲット到達日 */
     ztymokuhyouti                                      NUMBER      (3)                                                                 ,  /* （中継用）目標値 */
     ztymokuhyoukngk                                    NUMBER      (11)                                                                ,  /* （中継用）目標金額 */
     ztykaiyakuhr                                       NUMBER      (11)                                                                ,  /* （中継用）解約返戻金 */
     ztykihrkmpjytym                                    VARCHAR     (6)                                                                 ,  /* （中継用）既払込保険料充当年月 */
     ztykihrpruikeigk                                   NUMBER      (11)                                                                ,  /* （中継用）既払保険料累計額 */
     ztytousyokykjikawaserate                           NUMBER      (7,2)                                                               ,  /* （中継用）当初契約時為替レート */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztymankiymd                                        VARCHAR     (8)                                                                 ,  /* （中継用）満期年月日 */
     ztykishrkinruikeigk                                NUMBER      (11)                                                                ,  /* （中継用）既支払金累計額 */
     ztysjkkktyouseigk                                  NUMBER      (11)                                                                ,  /* （中継用）市場価格調整額 */
     ztykaiyakukjgk                                     NUMBER      (11)                                                                ,  /* （中継用）解約控除額 */
     ztysoneki                                          NUMBER      (11)                                                                ,  /* （中継用）損益 */
     ztysonekicalchunouflg                              VARCHAR     (1)                                                                 ,  /* （中継用）損益計算不能フラグ */
     ztysibous                                          NUMBER      (11)                                                                ,  /* （中継用）死亡Ｓ */
     ztygmeigyoubijiyenshrrate                          NUMBER      (7,2)                                                               ,  /* （中継用）月末営業日時円支払レート */
     ztygmeigyoubijikawaserate                          NUMBER      (7,2)                                                               ,  /* （中継用）月末営業日時為替レート */
     ztytousyokykjiyennyknrate                          NUMBER      (7,2)                                                               ,  /* （中継用）当初契約時円入金レート */
     ztytousyokykjigaikanyknrate                        NUMBER      (7,4)                                                               ,  /* （中継用）当初契約時外貨入金レート */
     ztykanyuusyaknrno                                  VARCHAR     (15)                                                                ,  /* （中継用）加入者管理番号 */
     ztyhrkstgktuuka                                    VARCHAR     (2)                                                                 ,  /* （中継用）払込相当額通貨 */
     ztymokuhyoukngktuuka                               VARCHAR     (2)                                                                 ,  /* （中継用）目標金額通貨 */
     ztysonotaseisankin                                 NUMBER      (11)                                                                ,  /* （中継用）その他精算金 */
     ztyyenkansansaiyousign                             VARCHAR     (1)                                                                 ,  /* （中継用）円換算採用為替サイン */
     ztykykjiyoteitmttriritu                            NUMBER      (3,2)                                                               ,  /* （中継用）契約時予定利率・積立利率 */
     ztyhukusuutuukaflg                                 VARCHAR     (1)                                                                 ,  /* （中継用）複数通貨フラグ */
     ztyyenkansanhunoflg                                VARCHAR     (1)                                                                 ,  /* （中継用）円換算不能フラグ */
     ztytyusyaku20                                      VARCHAR     (20)                                                                ,  /* （中継用）注釈２０ */
     ztyyobiv187                                        VARCHAR     (187)                                                               ,  /* （中継用）予備項目Ｖ１８７ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_DairitenGtmtZndkTy ADD CONSTRAINT PK_DairitenGtmtZndkTy PRIMARY KEY (
     ztydatakijyunymd                                         , /* （中継用）データ基準年月日 */
     ztysyono                                                   /* （中継用）証券番号 */
) ;

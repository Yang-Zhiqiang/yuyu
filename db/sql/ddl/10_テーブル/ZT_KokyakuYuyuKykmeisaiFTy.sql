CREATE TABLE ZT_KokyakuYuyuKykmeisaiFTy (
     ztysequenceno                                      NUMBER      (8)                                                       NOT NULL  ,  /* （中継用）シーケンス番号 */
     ztysyono                                           VARCHAR     (11)                                                                ,  /* （中継用）証券番号 */
     ztyhrkmnenkansanp                                  NUMBER      (11)                                                                ,  /* （中継用）払込年換算Ｐ */
     ztyyengyousekihosyous                              NUMBER      (11)                                                                ,  /* （中継用）円換算業績保障Ｓ */
     ztyhknkkn                                          VARCHAR     (2)                                                                 ,  /* （中継用）保険期間 */
     ztyphrkkikn                                        VARCHAR     (2)                                                                 ,  /* （中継用）Ｐ払込期間 */
     ztysaimnkkykhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）才満期契約表示 */
     ztysymtymd                                         VARCHAR     (8)                                                                 ,  /* （中継用）消滅年月日 */
     ztysyukeiyakukigou                                 VARCHAR     (2)                                                                 ,  /* （中継用）主契約記号 */
     ztysykykratesedaikbn                               VARCHAR     (1)                                                                 ,  /* （中継用）主契約レート世代区分 */
     ztyjyudkaigomehrtkarihyj                           VARCHAR     (1)                                                                 ,  /* （中継用）重度介護前払特約有表示 */
     ztypmentokuyakukbn                                 VARCHAR     (1)                                                                 ,  /* （中継用）Ｐ免特約区分 */
     ztykykdrtkykarihyj                                 VARCHAR     (1)                                                                 ,  /* （中継用）契約者代理特約有表示 */
     ztyyobiv158                                        VARCHAR     (158)                                                               ,  /* （中継用）予備項目Ｖ１５８ */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztybsyym                                           VARCHAR     (6)                                                                 ,  /* （中継用）募集年月 */
     ztyknkyknm18                                       VARCHAR     (18)                                                                ,  /* （中継用）カナ契約者名（１８文字） */
     ztykjkyknm                                         VARCHAR     (15)                                                                ,  /* （中継用）漢字契約者名 */
     ztykyksyaseiymd                                    VARCHAR     (8)                                                                 ,  /* （中継用）契約者生年月日 */
     ztykyksyanen3                                      VARCHAR     (3)                                                                 ,  /* （中継用）契約者年齢（３桁） */
     ztykykjikyksyanen                                  VARCHAR     (2)                                                                 ,  /* （中継用）契約時契約者年齢 */
     ztytuusinsakihumeihyj                              VARCHAR     (1)                                                                 ,  /* （中継用）通信先不明表示 */
     ztykihontikucd                                     VARCHAR     (8)                                                                 ,  /* （中継用）基本地区コード */
     ztytodouhukencd                                    VARCHAR     (2)                                                                 ,  /* （中継用）都道府県コード */
     ztysikutyousoncd5                                  VARCHAR     (5)                                                                 ,  /* （中継用）市区町村コード（５桁） */
     ztykjadr62                                         VARCHAR     (62)                                                                ,  /* （中継用）漢字住所（６２文字） */
     ztytelno                                           VARCHAR     (14)                                                                ,  /* （中継用）電話番号 */
     ztydai2telno                                       VARCHAR     (14)                                                                ,  /* （中継用）第２電話番号 */
     ztyknhhknmei                                       VARCHAR     (18)                                                                ,  /* （中継用）カナ被保険者名 */
     ztyknjhhknmei                                      VARCHAR     (15)                                                                ,  /* （中継用）漢字被保険者名 */
     ztyhhknseiymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）被保険者生年月日 */
     ztyhhknnen                                         VARCHAR     (3)                                                                 ,  /* （中継用）被保険者年齢 */
     ztyhhknseikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）被保険者性別区分 */
     ztykykjihhknnen                                    VARCHAR     (2)                                                                 ,  /* （中継用）契約時被保険者年齢 */
     ztymannenreikykhyj                                 VARCHAR     (1)                                                                 ,  /* （中継用）満年齢契約表示 */
     ztykyksyhhknsydouituhyouji                         VARCHAR     (1)                                                                 ,  /* （中継用）契約者被保険者同一表示 */
     ztykykjyutikbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）契約状態区分 */
     ztyannaifuyouriyuukbn                              VARCHAR     (2)                                                                 ,  /* （中継用）案内不要理由区分 */
     ztysyoumetucd                                      VARCHAR     (4)                                                                 ,  /* （中継用）消滅コード */
     ztytorihikikaisiymd                                VARCHAR     (8)                                                                 ,  /* （中継用）取引開始年月日 */
     ztypowerfulhyj                                     VARCHAR     (1)                                                                 ,  /* （中継用）パワフル表示 */
     ztylargehyj                                        VARCHAR     (1)                                                                 ,  /* （中継用）ラージ表示 */
     ztysyouhinbunruikbn                                VARCHAR     (1)                                                                 ,  /* （中継用）商品分類区分 */
     ztysyouhnnmkbn                                     VARCHAR     (2)                                                                 ,  /* （中継用）商品名称区分 */
     ztyhknnmcd                                         VARCHAR     (2)                                                                 ,  /* （中継用）保険名称コード */
     ztytkbthsyukiknmanryouym                           VARCHAR     (6)                                                                 ,  /* （中継用）特別保障期間満了年月 */
     ztyldownym                                         VARCHAR     (6)                                                                 ,  /* （中継用）Ｌダウン年月 */
     ztyhrkmanryouym                                    VARCHAR     (6)                                                                 ,  /* （中継用）払込満了年月 */
     ztymankiym                                         VARCHAR     (6)                                                                 ,  /* （中継用）満期年月 */
     ztysykykyoteiriritu                                NUMBER      (9,6)                                                               ,  /* （中継用）主契約予定利率 */
     ztyrserieshyj                                      VARCHAR     (1)                                                                 ,  /* （中継用）Ｒシリーズ表示 */
     ztyduketorihouhoukbn                               VARCHAR     (1)                                                                 ,  /* （中継用）Ｄ受取方法区分 */
     ztyinfoteikyoutsghyj                               VARCHAR     (1)                                                                 ,  /* （中継用）情報提供対象外表示 */
     ztynaimitukykhyj                                   VARCHAR     (1)                                                                 ,  /* （中継用）内密契約表示 */
     ztymrarihyj                                        VARCHAR     (1)                                                                 ,  /* （中継用）ＭＲ有表示 */
     ztykasitukenaimituhyj                              VARCHAR     (1)                                                                 ,  /* （中継用）貸付内密表示 */
     ztyttdktyuuiarihyj                                 VARCHAR     (1)                                                                 ,  /* （中継用）手続注意情報有表示 */
     ztyttdktyuuisetkacd1                               VARCHAR     (3)                                                                 ,  /* （中継用）手続注意台帳設定課コード１ */
     ztyttdktyuuisetymd1                                VARCHAR     (8)                                                                 ,  /* （中継用）手続注意台帳設定年月日１ */
     ztyttdktyuuisetkbn1                                VARCHAR     (2)                                                                 ,  /* （中継用）手続注意台帳設定区分１ */
     ztyttdktyuuisetkacd2                               VARCHAR     (3)                                                                 ,  /* （中継用）手続注意台帳設定課コード２ */
     ztyttdktyuuisetymd2                                VARCHAR     (8)                                                                 ,  /* （中継用）手続注意台帳設定年月日２ */
     ztyttdktyuuisetkbn2                                VARCHAR     (2)                                                                 ,  /* （中継用）手続注意台帳設定区分２ */
     ztyttdktyuui3kenijyouhyj                           VARCHAR     (1)                                                                 ,  /* （中継用）手続注意３件以上あり表示 */
     ztysentakujyouhouarihyouji                         VARCHAR     (1)                                                                 ,  /* （中継用）選択情報有表示 */
     ztystknsetkykhyj                                   VARCHAR     (1)                                                                 ,  /* （中継用）質権設定契約表示 */
     ztyyenharaikomip                                   NUMBER      (11)                                                                ,  /* （中継用）円換算払込Ｐ */
     ztyyenkihons                                       NUMBER      (11)                                                                ,  /* （中継用）円換算基本Ｓ */
     ztyyensibous                                       NUMBER      (11)                                                                ,  /* （中継用）円換算死亡Ｓ */
     ztyhrkhuhukbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）払込方法区分 */
     ztysyuunoukeirokbn                                 VARCHAR     (1)                                                                 ,  /* （中継用）収納経路区分 */
     ztycalckijyunymd                                   VARCHAR     (8)                                                                 ,  /* （中継用）計算基準年月日 */
     ztytumitatedzndk                                   NUMBER      (11)                                                                ,  /* （中継用）積立Ｄ残高 */
     ztytumitatedzndkhunouhyj                           VARCHAR     (1)                                                                 ,  /* （中継用）積立Ｄ残高計算不能表示 */
     ztydairitenatkihyj                                 VARCHAR     (1)                                                                 ,  /* （中継用）代理店扱表示 */
     ztytantou1sisyacd                                  VARCHAR     (7)                                                                 ,  /* （中継用）担当１支社コード */
     ztytantou1sibucd                                   VARCHAR     (7)                                                                 ,  /* （中継用）担当１支部コード */
     ztytantou1kojincd                                  VARCHAR     (6)                                                                 ,  /* （中継用）担当１個人コード */
     ztytantou1tantoukaisiymd                           VARCHAR     (6)                                                                 ,  /* （中継用）担当１担当開始年月 */
     ztytantou1tantousyakbn                             VARCHAR     (1)                                                                 ,  /* （中継用）担当１担当者区分 */
     ztytantou2sisyacd                                  VARCHAR     (7)                                                                 ,  /* （中継用）担当２支社コード */
     ztytantou2sibucd                                   VARCHAR     (7)                                                                 ,  /* （中継用）担当２支部コード */
     ztytantou2kojincd                                  VARCHAR     (6)                                                                 ,  /* （中継用）担当２個人コード */
     ztytantou2tantoukaisiymd                           VARCHAR     (6)                                                                 ,  /* （中継用）担当２担当開始年月 */
     ztytantou2tantousyakbn                             VARCHAR     (1)                                                                 ,  /* （中継用）担当２担当者区分 */
     ztysikijikbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）職事区分 */
     ztyteikyou1sosikicd                                VARCHAR     (7)                                                                 ,  /* （中継用）情報提供先１組織コード */
     ztyteikyou1kojincd                                 VARCHAR     (6)                                                                 ,  /* （中継用）情報提供先１個人コード */
     ztyteikyou1tantoukbn                               VARCHAR     (1)                                                                 ,  /* （中継用）情報提供先１担当区分 */
     ztyteikyou2sosikicd                                VARCHAR     (7)                                                                 ,  /* （中継用）情報提供先２組織コード */
     ztyteikyou2kojincd                                 VARCHAR     (6)                                                                 ,  /* （中継用）情報提供先２個人コード */
     ztyteikyou2tantoukbn                               VARCHAR     (1)                                                                 ,  /* （中継用）情報提供先２担当区分 */
     ztyadrsyokansisyacd                                VARCHAR     (7)                                                                 ,  /* （中継用）住所所管支社コード */
     ztyhyukjsaki1sosikicd                              VARCHAR     (7)                                                                 ,  /* （中継用）保有計上先１組織コード */
     ztyhyukjsaki1kojincd                               VARCHAR     (6)                                                                 ,  /* （中継用）保有計上先１個人コード */
     ztyhyukjsaki1tantoukbn                             VARCHAR     (1)                                                                 ,  /* （中継用）保有計上先１担当区分 */
     ztyhyukjsaki2sosikicd                              VARCHAR     (7)                                                                 ,  /* （中継用）保有計上先２組織コード */
     ztyhyukjsaki2kojincd                               VARCHAR     (6)                                                                 ,  /* （中継用）保有計上先２個人コード */
     ztyhyukjsaki2tantoukbn                             VARCHAR     (1)                                                                 ,  /* （中継用）保有計上先２担当区分 */
     ztyinfotysytymd                                    VARCHAR     (8)                                                                 ,  /* （中継用）情報抽出年月日 */
     ztystdairiseikyuutkykarihyj                        VARCHAR     (1)                                                                 ,  /* （中継用）指定代理請求特約有表示 */
     ztyhouteityotikuhknhyj                             VARCHAR     (1)                                                                 ,  /* （中継用）法定貯蓄性保険表示 */
     ztydrctservicekbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）ダイレクトサービス区分 */
     ztyhksuhngktkbtknjgnkbn                            VARCHAR     (1)                                                                 ,  /* （中継用）複数変額特別勘定群区分 */
     ztysiteituukakbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）指定通貨区分 */
     ztymkhyouyenhknhentkarihyj                         VARCHAR     (1)                                                                 ,  /* （中継用）目標到達時円建保険変更特約有表示 */
     ztyyenkhrikmtkarihyj                               VARCHAR     (1)                                                                 ,  /* （中継用）円貨払込特約有表示 */
     ztystigihrikmtkarihyj                              VARCHAR     (1)                                                                 ,  /* （中継用）指定外通貨払込特約有表示 */
     ztyyenshrgksitihsyutkhyj                           VARCHAR     (1)                                                                 ,  /* （中継用）円換算支払額最低保証特約表示 */
     ztysiteituukaharaikomip                            NUMBER      (11,2)                                                              ,  /* （中継用）指定通貨建払込Ｐ */
     ztyhrktuukaharaikomip                              NUMBER      (11)                                                                ,  /* （中継用）払込通貨建払込Ｐ */
     ztysiteituukakihonsx2                              NUMBER      (11,2)                                                              ,  /* （中継用）指定通貨建基本Ｓ＿２ */
     ztysiteituukasibous                                NUMBER      (11,2)                                                              ,  /* （中継用）指定通貨建死亡Ｓ */
     ztyteikisiharaiarihyj                              VARCHAR     (1)                                                                 ,  /* （中継用）定期支払特約有表示 */
     ztyyenteikishrkngk                                 NUMBER      (11)                                                                ,  /* （中継用）円換算定期支払金額 */
     ztysiteituukateikishrkngk                          NUMBER      (11,2)                                                              ,  /* （中継用）指定通貨建定期支払金額 */
     ztyyobiv98                                         VARCHAR     (98)                                                                ,  /* （中継用）予備項目Ｖ９８ */
     ztyyenkihonhijynbris                               NUMBER      (11)                                                                ,  /* （中継用）円換算基本平準払Ｓ */
     ztyyenkihonitijibarais                             NUMBER      (11)                                                                ,  /* （中継用）円換算基本一時払Ｓ */
     ztyyenkihonhijynbrip                               NUMBER      (11)                                                                ,  /* （中継用）円換算基本平準払Ｐ */
     ztyyenkihonitijibaraip                             NUMBER      (11)                                                                ,  /* （中継用）円換算基本一時払Ｐ */
     ztytrkkzk1trkarihyj                                VARCHAR     (1)                                                                 ,  /* （中継用）登録家族１登録有表示 */
     ztytrkkzk2trkarihyj                                VARCHAR     (1)                                                                 ,  /* （中継用）登録家族２登録有表示 */
     ztyyno7keta                                        VARCHAR     (7)                                                                 ,  /* （中継用）郵便番号（７桁） */
     ztyyobiv241                                        VARCHAR     (241)                                                               ,  /* （中継用）予備項目Ｖ２４１ */
     ztyyobiv26                                         VARCHAR     (26)                                                                ,  /* （中継用）予備項目Ｖ２６ */
     ztyyobiv250x2                                      VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿２ */
     ztyyobiv50                                         VARCHAR     (50)                                                                ,  /* （中継用）予備項目Ｖ５０ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_KokyakuYuyuKykmeisaiFTy ADD CONSTRAINT PK_KokyakuYuyuKykmeisaiFTy PRIMARY KEY (
     ztysequenceno                                              /* （中継用）シーケンス番号 */
) ;

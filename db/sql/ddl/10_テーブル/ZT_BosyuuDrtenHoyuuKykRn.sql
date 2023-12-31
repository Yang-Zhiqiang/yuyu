CREATE TABLE ZT_BosyuuDrtenHoyuuKykRn (
     zrndatasyurui                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）データ種類 */
     zrnhknsyumoku                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種目 */
     zrntyoubokbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）帳簿区分 */
     zrnsyonosyuban                                     CHAR        (12)                                                      NOT NULL  ,  /* （連携用）証券番号主番 */
     zrnhknsyurui2keta                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類（２桁） */
     zrnhrkhuhukbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込方法区分 */
     zrnsyukinkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）集金区分 */
     zrnbnkaisuu                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）分割回数 */
     zrnkyouhocd                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）共保コード */
     zrndaibuncd                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）代分コード */
     zrndaibunkanjishare                                CHAR        (4)                                                       NOT NULL  ,  /* （連携用）代分幹事分シェア */
     zrndntcd7keta                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）団体コード（７桁） */
     zrnsyumokugrpkbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）種目グループ区分 */
     zrngoukeipbsdirtnhykyk                             CHAR        (10)                                                      NOT NULL  ,  /* （連携用）合計保険料（募集代理店保有契約） */
     zrnyno7keta                                        CHAR        (7)                                                       NOT NULL  ,  /* （連携用）郵便番号（７桁） */
     zrnsikiymd                                         CHAR        (8)                                                       NOT NULL  ,  /* （連携用）始期年月日 */
     zrnmankiymd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）満期年月日 */
     zrnidokaiyakuymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）異動解約年月日 */
     zrnmusymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）申込年月日 */
     zrnjikokykhyj                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）自己契約表示 */
     zrnmeisaioyakokbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）明細親子区分 */
     zrnkihontikucdkami3                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）基本地区コード上３桁 */
     zrnyobiv2                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ２ */
     zrntelnobsdirtnhykyk                               CHAR        (12)                                                      NOT NULL  ,  /* （連携用）電話番号（募集代理店保有契約） */
     zrnkyknmknbsdirtnhykyk                             CHAR        (70)                                                      NOT NULL  ,  /* （連携用）契約者名（カナ）（募集代理店保有契約） */
     zrnbnkyk1kaipbsdirtnhykyk                          CHAR        (10)                                                      NOT NULL  ,  /* （連携用）分割払契約１回分保険料（募集代理店保有契約） */
     zrnbnsyuruikbn                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）分割種類区分 */
     zrnhrkymd                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）払込日 */
     zrndntfsthrkym                                     CHAR        (6)                                                       NOT NULL  ,  /* （連携用）団体扱初回払込年月 */
     zrnfstpkzhurikbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）初回保険料口座振替区分 */
     zrnkeijyouym4keta                                  CHAR        (4)                                                       NOT NULL  ,  /* （連携用）計上年月（４桁） */
     zrnhknkaisyacd                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険会社コード */
     zrnhhknnmknbsdirtnhykyk                            CHAR        (20)                                                      NOT NULL  ,  /* （連携用）被保険者名（カナ）（募集代理店保有契約） */
     zrnknjhhknmei                                      VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）漢字被保険者名 */
     zrnhhknseiymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）被保険者生年月日 */
     zrnhhknnenbsdirtnhykyk                             CHAR        (3)                                                       NOT NULL  ,  /* （連携用）被保険者年令（募集代理店保有契約） */
     zrnhhknseikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別区分 */
     zrnhhkntdk                                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）被保険者続柄 */
     zrnhhknynobsdirtnhykyk                             CHAR        (8)                                                       NOT NULL  ,  /* （連携用）被保険者郵便番号（募集代理店保有契約） */
     zrnhhknadrkj50                                     VARCHAR     (50)                                                      NOT NULL  ,  /* （連携用）被保険者漢字住所５０ */
     zrnhrkkeiro                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路 */
     zrnitijibrpbsdirtnhykyk                            CHAR        (10)                                                      NOT NULL  ,  /* （連携用）一時払保険料（募集代理店保有契約） */
     zrnnkshrkknkbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）年金支払期間区分 */
     zrnnkshrkknnen                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）年金支払期間年 */
     zrnnkshrstartymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）年金支払開始年月日 */
     zrntokutaiumu                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特体有無 */
     zrntktyuutohuka                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約中途付加 */
     zrntksuu                                           CHAR        (3)                                                       NOT NULL  ,  /* （連携用）特約数 */
     zrnsinsakbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）診査区分 */
     zrnzeiseitekikaku                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）税制適格 */
     zrnlivingneeds                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）リビングニーズ */
     zrnknjsyuhsynm                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （連携用）漢字主契約保種名 */
     zrnsyusbsdirtnhykyk                                CHAR        (11)                                                      NOT NULL  ,  /* （連携用）主契約保険金額（募集代理店保有契約） */
     zrnsyuhknkknkbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）主契約保険期間区分 */
     zrnsyuhknkkn                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）主契約保険期間 */
     zrnsyuhrkkknkbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）主契約払込期間区分 */
     zrnsyuhrkkkn                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）主契約払込期間 */
     zrnkjtkhosyunm1                                    VARCHAR     (8)                                                       NOT NULL  ,  /* （連携用）漢字特約保種名１ */
     zrntks1bsdirtnhykyk                                CHAR        (11)                                                      NOT NULL  ,  /* （連携用）特約保険金額１（募集代理店保有契約） */
     zrntkhknkknkbn1                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約保険期間区分１ */
     zrntkhknkkn1                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特約保険期間１ */
     zrntkhrkkknkbn1                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約払込期間区分１ */
     zrntkhrkkkn1                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特約払込期間１ */
     zrnkjtkhosyunm2                                    VARCHAR     (8)                                                       NOT NULL  ,  /* （連携用）漢字特約保種名２ */
     zrntks2bsdirtnhykyk                                CHAR        (11)                                                      NOT NULL  ,  /* （連携用）特約保険金額２（募集代理店保有契約） */
     zrntkhknkknkbn2                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約保険期間区分２ */
     zrntkhknkkn2                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特約保険期間２ */
     zrntkhrkkknkbn2                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約払込期間区分２ */
     zrntkhrkkkn2                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特約払込期間２ */
     zrnkjtkhosyunm3                                    VARCHAR     (8)                                                       NOT NULL  ,  /* （連携用）漢字特約保種名３ */
     zrntks3bsdirtnhykyk                                CHAR        (11)                                                      NOT NULL  ,  /* （連携用）特約保険金額３（募集代理店保有契約） */
     zrntkhknkknkbn3                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約保険期間区分３ */
     zrntkhknkkn3                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特約保険期間３ */
     zrntkhrkkknkbn3                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約払込期間区分３ */
     zrntkhrkkkn3                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特約払込期間３ */
     zrnkjtkhosyunm4                                    VARCHAR     (8)                                                       NOT NULL  ,  /* （連携用）漢字特約保種名４ */
     zrntks4bsdirtnhykyk                                CHAR        (11)                                                      NOT NULL  ,  /* （連携用）特約保険金額４（募集代理店保有契約） */
     zrntkhknkknkbn4                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約保険期間区分４ */
     zrntkhknkkn4                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特約保険期間４ */
     zrntkhrkkknkbn4                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約払込期間区分４ */
     zrntkhrkkkn4                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特約払込期間４ */
     zrnkjtkhosyunm5                                    VARCHAR     (8)                                                       NOT NULL  ,  /* （連携用）漢字特約保種名５ */
     zrntks5bsdirtnhykyk                                CHAR        (11)                                                      NOT NULL  ,  /* （連携用）特約保険金額５（募集代理店保有契約） */
     zrntkhknkknkbn5                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約保険期間区分５ */
     zrntkhknkkn5                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特約保険期間５ */
     zrntkhrkkknkbn5                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約払込期間区分５ */
     zrntkhrkkkn5                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特約払込期間５ */
     zrnkjtkhosyunm6                                    VARCHAR     (8)                                                       NOT NULL  ,  /* （連携用）漢字特約保種名６ */
     zrntks6bsdirtnhykyk                                CHAR        (11)                                                      NOT NULL  ,  /* （連携用）特約保険金額６（募集代理店保有契約） */
     zrntkhknkknkbn6                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約保険期間区分６ */
     zrntkhknkkn6                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特約保険期間６ */
     zrntkhrkkknkbn6                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約払込期間区分６ */
     zrntkhrkkkn6                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特約払込期間６ */
     zrndatasyubetucd                                   CHAR        (2)                                                       NOT NULL  ,  /* （連携用）データ種別コード */
     zrnhjnkojinkbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）法人個人区分 */
     zrnkykadrkj50                                      VARCHAR     (50)                                                      NOT NULL  ,  /* （連携用）契約者漢字住所５０ */
     zrnkyknmkjbsdirtnhykyk                             VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）契約者名(漢字）（募集代理店保有契約） */
     zrnkyksyaseiymd                                    CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約者生年月日 */
     zrnsakuseiym                                       CHAR        (6)                                                       NOT NULL  ,  /* （連携用）作成年月 */
     zrndairitencd                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）代理店コード */
     zrndairitenkanrisskcd                              CHAR        (7)                                                       NOT NULL  ,  /* （連携用）代理店管理組織コード */
     zrnbosyuunincd                                     CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集人コード */
     zrnbosyuunm                                        VARCHAR     (17)                                                      NOT NULL  ,  /* （連携用）募集人氏名 */
     zrnbosyuujtkbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）募集人状態区分 */
     zrndairitenkbtinfo1                                CHAR        (15)                                                      NOT NULL  ,  /* （連携用）代理店個別情報１ */
     zrndairitenkbtinfo2                                CHAR        (15)                                                      NOT NULL  ,  /* （連携用）代理店個別情報２ */
     zrndairitenkbtinfo3                                CHAR        (15)                                                      NOT NULL  ,  /* （連携用）代理店個別情報３ */
     zrnsyouhinbunruikbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）商品分類区分 */
     zrnhknnmcd                                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険名称コード */
     zrnkykjyutikbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約状態区分 */
     zrntkbthsyukiknmanryouym                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）特別保障期間満了年月 */
     zrnldownym                                         CHAR        (6)                                                       NOT NULL  ,  /* （連携用）Ｌダウン年月 */
     zrnhrkmanryouym                                    CHAR        (6)                                                       NOT NULL  ,  /* （連携用）払込満了年月 */
     zrnmrtiksnym                                       CHAR        (6)                                                       NOT NULL  ,  /* （連携用）マル定更新年月 */
     zrnhaneikykhyj                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）繁栄契約表示 */
     zrnzenzeikyohyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）全税共表示 */
     zrnsikijikbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）職事区分 */
     zrnsbuktdisphukusuhyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）死亡受取人複数表示 */
     zrnsbuktnmbsdirtnhykyk                             CHAR        (22)                                                      NOT NULL  ,  /* （連携用）死亡受取人名（募集代理店保有契約） */
     zrnmnkuktdisphukusuhyj                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）満期受取人複数表示 */
     zrnmnkuktnmbsdirtnhykyk                            CHAR        (22)                                                      NOT NULL  ,  /* （連携用）満期受取人名（募集代理店保有契約） */
     zrntodouhukencd                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）都道府県コード */
     zrnbankcd                                          CHAR        (4)                                                       NOT NULL  ,  /* （連携用）銀行番号 */
     zrnshitencd                                        CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支店番号 */
     zrnyokinkbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）預金種目区分 */
     zrnkouzano7keta                                    CHAR        (7)                                                       NOT NULL  ,  /* （連携用）口座番号（７桁） */
     zrnalcardkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＡＬカード区分 */
     zrnsibous                                          NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）死亡Ｓ */
     zrnsgsbs                                           NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）災害死亡S */
     zrnsgwrmstksbsdirtnhykyk                           CHAR        (9)                                                       NOT NULL  ,  /* （連携用）災害割増特約Ｓ（募集代理店保有契約） */
     zrnsyougaitkkatakbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）傷害特約型区分 */
     zrnsyougaitksbsdirtnhykyk                          CHAR        (9)                                                       NOT NULL  ,  /* （連携用）傷害特約Ｓ（募集代理店保有契約） */
     zrnreguardtksbsdirtnhykyk                          CHAR        (9)                                                       NOT NULL  ,  /* （連携用）リガード特約Ｓ（募集代理店保有契約） */
     zrnreguardtkkbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）リガード特約区分 */
     zrnvreguardtksbsdirtnhykyk                         CHAR        (9)                                                       NOT NULL  ,  /* （連携用）Ｖガード特約Ｓ（募集代理店保有契約） */
     zrnkzkmrthgukatakbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）家族マル定配偶者型区分 */
     zrnkzkmrthgusbsdirtnhykyk                          CHAR        (9)                                                       NOT NULL  ,  /* （連携用）家族マル定配偶者Ｓ（募集代理店保有契約） */
     zrnkzkmrtkosbsdirtnhykyk                           CHAR        (9)                                                       NOT NULL  ,  /* （連携用）家族マル定子Ｓ（募集代理店保有契約） */
     zrnkaneeztkarihyj                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ケアニーズ特約有表示 */
     zrndrtenkinyuucd                                   CHAR        (4)                                                       NOT NULL  ,  /* （連携用）代理店金融機関コード */
     zrndrtensitencd                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）代理店支店コード */
     zrnstjmkbn                                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）集中事務組織区分 */
     zrnsyokaiphrkkeiro                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）初回Ｐ払込経路区分 */
     zrncifcd                                           CHAR        (15)                                                      NOT NULL  ,  /* （連携用）ＣＩＦコード */
     zrnkanjidairitennm                                 VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）漢字代理店名 */
     zrntsrybnwari                                      NUMBER      (3)                                                       NOT NULL  ,  /* （連携用）手数料分割割合 */
     zrndrtenkeijyouym                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）代理店計上年月 */
     zrnkydatkidairitencd                               CHAR        (7)                                                       NOT NULL  ,  /* （連携用）共同扱代理店コード */
     zrnmdhnsyouhntsryshrkbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）窓販商品手数料支払区分 */
     zrnkyksyanen                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）契約者年令 */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnmdhnaisyoumeicd                                 CHAR        (3)                                                       NOT NULL  ,  /* （連携用）窓販用愛称名コード */
     zrnsyokaipryosyuymd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）初回Ｐ領収年月日 */
     zrnsykgycd                                         CHAR        (3)                                                       NOT NULL  ,  /* （連携用）職業コード */
     zrnkaiyakuhrmkhritu                                NUMBER      (3,2)                                                     NOT NULL  ,  /* （連携用）解約返戻金目標率 */
     zrntoutatukaiyakuhrmkhritu                         CHAR        (3)                                                       NOT NULL  ,  /* （連携用）到達解約返戻金目標率（募集代理店保有契約） */
     zrnkaiyakuhrmkhtoutatuymd                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）解約返戻金目標到達年月日 */
     zrnanniskcd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）案内先コード */
     zrnhjnkykhyj                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）法人契約表示 */
     zrnhrkkeirokbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路区分 */
     zrnlivguardtkyks                                   CHAR        (9)                                                       NOT NULL  ,  /* （連携用）ＬｉＶガード特約Ｓ */
     zrnsiteituukaitijibrp                              NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）指定通貨建一時払保険料 */
     zrnsiteituukasyus                                  NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）指定通貨建主契約保険金額 */
     zrnsiteituukasbs                                   NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）指定通貨建死亡保険金額 */
     zrnsiteituukasaigaisbs                             NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）指定通貨建災害死亡保険金額 */
     zrnsiteituukacd                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）指定通貨コード */
     zrnhrktuukaitijibrp                                NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）払込通貨建一時払保険料 */
     zrnhrktuukacd                                      CHAR        (3)                                                       NOT NULL  ,  /* （連携用）払込通貨コード */
     zrntumitateriritu                                  NUMBER      (5,4)                                                     NOT NULL  ,  /* （連携用）積立利率 */
     zrntmttknzoukaritujygn                             NUMBER      (5,4)                                                     NOT NULL  ,  /* （連携用）積立金増加率上限 */
     zrnsetteibairitu                                   NUMBER      (3,2)                                                     NOT NULL  ,  /* （連携用）設定倍率 */
     zrntumitatekngk                                    NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）積立金額 */
     zrnkjsbuktnm30                                     VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）漢字死亡受取人名３０ */
     zrnmnkuktnm30                                      VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）漢字満期受取人名３０ */
     zrnkjkykdairinm                                    VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）漢字契約者代理人名 */
     zrnkjsiteidairinm30                                VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）漢字指定代理人名３０ */
     zrntrkkzknmkj1                                     VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）登録家族名（漢字）１ */
     zrntrkkzknmkj2                                     VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）登録家族名（漢字）２ */
     zrnikkatubaraikbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）一括払区分 */
     zrnikkatubaraikaisuu                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）一括払回数 */
     zrnannaifuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内不要理由区分 */
     zrnrendouritu                                      NUMBER      (5,4)                                                     NOT NULL  ,  /* （連携用）連動率 */
     zrnteikishrritu                                    NUMBER      (5,4)                                                     NOT NULL  ,  /* （連携用）定期支払率 */
     zrntikskzuktnmkj                                   VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）定期支払金受取人名（漢字） */
     zrntikskzbankcd                                    CHAR        (4)                                                       NOT NULL  ,  /* （連携用）定期支払金受取口座銀行コード */
     zrntikskzsitencd                                   CHAR        (3)                                                       NOT NULL  ,  /* （連携用）定期支払金受取口座支店コード */
     zrntikskzyokinkbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）定期支払金受取口座預金種目区分 */
     zrntikskzkouzano                                   CHAR        (12)                                                      NOT NULL  ,  /* （連携用）定期支払金受取口座番号 */
     zrntikskzkzmeiginmkn                               CHAR        (30)                                                      NOT NULL  ,  /* （連携用）定期支払金受取口座名義人氏名（カナ） */
     zrnteikishrkinshrtuukasyu                          CHAR        (3)                                                       NOT NULL  ,  /* （連携用）定期支払金支払通貨 */
     zrnyobiv58                                         CHAR        (58)                                                      NOT NULL     /* （連携用）予備項目Ｖ５８ */
)
;

ALTER TABLE ZT_BosyuuDrtenHoyuuKykRn ADD CONSTRAINT PK_BosyuuDrtenHoyuuKykRn PRIMARY KEY (
     zrnsyonosyuban                                             /* （連携用）証券番号主番 */
) ;

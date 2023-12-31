CREATE VIEW ZT_BosyuuDrtenHoyuuKykRn AS SELECT
     zrndatasyurui ,         /* （連携用）データ種類 */
     zrnhknsyumoku ,         /* （連携用）保険種目 */
     zrntyoubokbn ,         /* （連携用）帳簿区分 */
     zrnsyonosyuban ,         /* （連携用）証券番号主番 */
     zrnhknsyurui2keta ,         /* （連携用）保険種類（２桁） */
     zrnhrkhuhukbn ,         /* （連携用）払込方法区分 */
     zrnsyukinkbn ,         /* （連携用）集金区分 */
     zrnbnkaisuu ,         /* （連携用）分割回数 */
     zrnkyouhocd ,         /* （連携用）共保コード */
     zrndaibuncd ,         /* （連携用）代分コード */
     zrndaibunkanjishare ,         /* （連携用）代分幹事分シェア */
     zrndntcd7keta ,         /* （連携用）団体コード（７桁） */
     zrnsyumokugrpkbn ,         /* （連携用）種目グループ区分 */
     zrngoukeipbsdirtnhykyk ,         /* （連携用）合計保険料（募集代理店保有契約） */
     zrnyno7keta ,         /* （連携用）郵便番号（７桁） */
     zrnsikiymd ,         /* （連携用）始期年月日 */
     zrnmankiymd ,         /* （連携用）満期年月日 */
     zrnidokaiyakuymd ,         /* （連携用）異動解約年月日 */
     zrnmusymd ,         /* （連携用）申込年月日 */
     zrnjikokykhyj ,         /* （連携用）自己契約表示 */
     zrnmeisaioyakokbn ,         /* （連携用）明細親子区分 */
     zrnkihontikucdkami3 ,         /* （連携用）基本地区コード上３桁 */
     zrnyobiv2 ,         /* （連携用）予備項目Ｖ２ */
     zrntelnobsdirtnhykyk ,         /* （連携用）電話番号（募集代理店保有契約） */
     zrnkyknmknbsdirtnhykyk ,         /* （連携用）契約者名（カナ）（募集代理店保有契約） */
     zrnbnkyk1kaipbsdirtnhykyk ,         /* （連携用）分割払契約１回分保険料（募集代理店保有契約） */
     zrnbnsyuruikbn ,         /* （連携用）分割種類区分 */
     zrnhrkymd ,         /* （連携用）払込日 */
     zrndntfsthrkym ,         /* （連携用）団体扱初回払込年月 */
     zrnfstpkzhurikbn ,         /* （連携用）初回保険料口座振替区分 */
     zrnkeijyouym4keta ,         /* （連携用）計上年月（４桁） */
     zrnhknkaisyacd ,         /* （連携用）保険会社コード */
     zrnhhknnmknbsdirtnhykyk ,         /* （連携用）被保険者名（カナ）（募集代理店保有契約） */
     zrnknjhhknmei ,         /* （連携用）漢字被保険者名 */
     zrnhhknseiymd ,         /* （連携用）被保険者生年月日 */
     zrnhhknnenbsdirtnhykyk ,         /* （連携用）被保険者年令（募集代理店保有契約） */
     zrnhhknseikbn ,         /* （連携用）被保険者性別区分 */
     zrnhhkntdk ,         /* （連携用）被保険者続柄 */
     zrnhhknynobsdirtnhykyk ,         /* （連携用）被保険者郵便番号（募集代理店保有契約） */
     zrnhhknadrkj50 ,         /* （連携用）被保険者漢字住所５０ */
     zrnhrkkeiro ,         /* （連携用）払込経路 */
     zrnitijibrpbsdirtnhykyk ,         /* （連携用）一時払保険料（募集代理店保有契約） */
     zrnnkshrkknkbn ,         /* （連携用）年金支払期間区分 */
     zrnnkshrkknnen ,         /* （連携用）年金支払期間年 */
     zrnnkshrstartymd ,         /* （連携用）年金支払開始年月日 */
     zrntokutaiumu ,         /* （連携用）特体有無 */
     zrntktyuutohuka ,         /* （連携用）特約中途付加 */
     zrntksuu ,         /* （連携用）特約数 */
     zrnsinsakbn ,         /* （連携用）診査区分 */
     zrnzeiseitekikaku ,         /* （連携用）税制適格 */
     zrnlivingneeds ,         /* （連携用）リビングニーズ */
     zrnknjsyuhsynm ,         /* （連携用）漢字主契約保種名 */
     zrnsyusbsdirtnhykyk ,         /* （連携用）主契約保険金額（募集代理店保有契約） */
     zrnsyuhknkknkbn ,         /* （連携用）主契約保険期間区分 */
     zrnsyuhknkkn ,         /* （連携用）主契約保険期間 */
     zrnsyuhrkkknkbn ,         /* （連携用）主契約払込期間区分 */
     zrnsyuhrkkkn ,         /* （連携用）主契約払込期間 */
     zrnkjtkhosyunm1 ,         /* （連携用）漢字特約保種名１ */
     zrntks1bsdirtnhykyk ,         /* （連携用）特約保険金額１（募集代理店保有契約） */
     zrntkhknkknkbn1 ,         /* （連携用）特約保険期間区分１ */
     zrntkhknkkn1 ,         /* （連携用）特約保険期間１ */
     zrntkhrkkknkbn1 ,         /* （連携用）特約払込期間区分１ */
     zrntkhrkkkn1 ,         /* （連携用）特約払込期間１ */
     zrnkjtkhosyunm2 ,         /* （連携用）漢字特約保種名２ */
     zrntks2bsdirtnhykyk ,         /* （連携用）特約保険金額２（募集代理店保有契約） */
     zrntkhknkknkbn2 ,         /* （連携用）特約保険期間区分２ */
     zrntkhknkkn2 ,         /* （連携用）特約保険期間２ */
     zrntkhrkkknkbn2 ,         /* （連携用）特約払込期間区分２ */
     zrntkhrkkkn2 ,         /* （連携用）特約払込期間２ */
     zrnkjtkhosyunm3 ,         /* （連携用）漢字特約保種名３ */
     zrntks3bsdirtnhykyk ,         /* （連携用）特約保険金額３（募集代理店保有契約） */
     zrntkhknkknkbn3 ,         /* （連携用）特約保険期間区分３ */
     zrntkhknkkn3 ,         /* （連携用）特約保険期間３ */
     zrntkhrkkknkbn3 ,         /* （連携用）特約払込期間区分３ */
     zrntkhrkkkn3 ,         /* （連携用）特約払込期間３ */
     zrnkjtkhosyunm4 ,         /* （連携用）漢字特約保種名４ */
     zrntks4bsdirtnhykyk ,         /* （連携用）特約保険金額４（募集代理店保有契約） */
     zrntkhknkknkbn4 ,         /* （連携用）特約保険期間区分４ */
     zrntkhknkkn4 ,         /* （連携用）特約保険期間４ */
     zrntkhrkkknkbn4 ,         /* （連携用）特約払込期間区分４ */
     zrntkhrkkkn4 ,         /* （連携用）特約払込期間４ */
     zrnkjtkhosyunm5 ,         /* （連携用）漢字特約保種名５ */
     zrntks5bsdirtnhykyk ,         /* （連携用）特約保険金額５（募集代理店保有契約） */
     zrntkhknkknkbn5 ,         /* （連携用）特約保険期間区分５ */
     zrntkhknkkn5 ,         /* （連携用）特約保険期間５ */
     zrntkhrkkknkbn5 ,         /* （連携用）特約払込期間区分５ */
     zrntkhrkkkn5 ,         /* （連携用）特約払込期間５ */
     zrnkjtkhosyunm6 ,         /* （連携用）漢字特約保種名６ */
     zrntks6bsdirtnhykyk ,         /* （連携用）特約保険金額６（募集代理店保有契約） */
     zrntkhknkknkbn6 ,         /* （連携用）特約保険期間区分６ */
     zrntkhknkkn6 ,         /* （連携用）特約保険期間６ */
     zrntkhrkkknkbn6 ,         /* （連携用）特約払込期間区分６ */
     zrntkhrkkkn6 ,         /* （連携用）特約払込期間６ */
     zrndatasyubetucd ,         /* （連携用）データ種別コード */
     zrnhjnkojinkbn ,         /* （連携用）法人個人区分 */
     zrnkykadrkj50 ,         /* （連携用）契約者漢字住所５０ */
     zrnkyknmkjbsdirtnhykyk ,         /* （連携用）契約者名(漢字）（募集代理店保有契約） */
     zrnkyksyaseiymd ,         /* （連携用）契約者生年月日 */
     zrnsakuseiym ,         /* （連携用）作成年月 */
     zrndairitencd ,         /* （連携用）代理店コード */
     zrndairitenkanrisskcd ,         /* （連携用）代理店管理組織コード */
     zrnbosyuunincd ,         /* （連携用）募集人コード */
     zrnbosyuunm ,         /* （連携用）募集人氏名 */
     zrnbosyuujtkbn ,         /* （連携用）募集人状態区分 */
     zrndairitenkbtinfo1 ,         /* （連携用）代理店個別情報１ */
     zrndairitenkbtinfo2 ,         /* （連携用）代理店個別情報２ */
     zrndairitenkbtinfo3 ,         /* （連携用）代理店個別情報３ */
     zrnsyouhinbunruikbn ,         /* （連携用）商品分類区分 */
     zrnhknnmcd ,         /* （連携用）保険名称コード */
     zrnkykjyutikbn ,         /* （連携用）契約状態区分 */
     zrntkbthsyukiknmanryouym ,         /* （連携用）特別保障期間満了年月 */
     zrnldownym ,         /* （連携用）Ｌダウン年月 */
     zrnhrkmanryouym ,         /* （連携用）払込満了年月 */
     zrnmrtiksnym ,         /* （連携用）マル定更新年月 */
     zrnhaneikykhyj ,         /* （連携用）繁栄契約表示 */
     zrnzenzeikyohyj ,         /* （連携用）全税共表示 */
     zrnsikijikbn ,         /* （連携用）職事区分 */
     zrnsbuktdisphukusuhyj ,         /* （連携用）死亡受取人複数表示 */
     zrnsbuktnmbsdirtnhykyk ,         /* （連携用）死亡受取人名（募集代理店保有契約） */
     zrnmnkuktdisphukusuhyj ,         /* （連携用）満期受取人複数表示 */
     zrnmnkuktnmbsdirtnhykyk ,         /* （連携用）満期受取人名（募集代理店保有契約） */
     zrntodouhukencd ,         /* （連携用）都道府県コード */
     zrnbankcd ,         /* （連携用）銀行番号 */
     zrnshitencd ,         /* （連携用）支店番号 */
     zrnyokinkbn ,         /* （連携用）預金種目区分 */
     zrnkouzano7keta ,         /* （連携用）口座番号（７桁） */
     zrnalcardkbn ,         /* （連携用）ＡＬカード区分 */
     zrnsibous ,         /* （連携用）死亡Ｓ */
     zrnsgsbs ,         /* （連携用）災害死亡S */
     zrnsgwrmstksbsdirtnhykyk ,         /* （連携用）災害割増特約Ｓ（募集代理店保有契約） */
     zrnsyougaitkkatakbn ,         /* （連携用）傷害特約型区分 */
     zrnsyougaitksbsdirtnhykyk ,         /* （連携用）傷害特約Ｓ（募集代理店保有契約） */
     zrnreguardtksbsdirtnhykyk ,         /* （連携用）リガード特約Ｓ（募集代理店保有契約） */
     zrnreguardtkkbn ,         /* （連携用）リガード特約区分 */
     zrnvreguardtksbsdirtnhykyk ,         /* （連携用）Ｖガード特約Ｓ（募集代理店保有契約） */
     zrnkzkmrthgukatakbn ,         /* （連携用）家族マル定配偶者型区分 */
     zrnkzkmrthgusbsdirtnhykyk ,         /* （連携用）家族マル定配偶者Ｓ（募集代理店保有契約） */
     zrnkzkmrtkosbsdirtnhykyk ,         /* （連携用）家族マル定子Ｓ（募集代理店保有契約） */
     zrnkaneeztkarihyj ,         /* （連携用）ケアニーズ特約有表示 */
     zrndrtenkinyuucd ,         /* （連携用）代理店金融機関コード */
     zrndrtensitencd ,         /* （連携用）代理店支店コード */
     zrnstjmkbn ,         /* （連携用）集中事務組織区分 */
     zrnsyokaiphrkkeiro ,         /* （連携用）初回Ｐ払込経路区分 */
     zrncifcd ,         /* （連携用）ＣＩＦコード */
     zrnkanjidairitennm ,         /* （連携用）漢字代理店名 */
     zrntsrybnwari ,         /* （連携用）手数料分割割合 */
     zrndrtenkeijyouym ,         /* （連携用）代理店計上年月 */
     zrnkydatkidairitencd ,         /* （連携用）共同扱代理店コード */
     zrnmdhnsyouhntsryshrkbn ,         /* （連携用）窓販商品手数料支払区分 */
     zrnkyksyanen ,         /* （連携用）契約者年令 */
     zrnhknsyukigou ,         /* （連携用）保険種類記号 */
     zrnmdhnaisyoumeicd ,         /* （連携用）窓販用愛称名コード */
     zrnsyokaipryosyuymd ,         /* （連携用）初回Ｐ領収年月日 */
     zrnsykgycd ,         /* （連携用）職業コード */
     zrnkaiyakuhrmkhritu ,         /* （連携用）解約返戻金目標率 */
     zrntoutatukaiyakuhrmkhritu ,         /* （連携用）到達解約返戻金目標率（募集代理店保有契約） */
     zrnkaiyakuhrmkhtoutatuymd ,         /* （連携用）解約返戻金目標到達年月日 */
     zrnanniskcd ,         /* （連携用）案内先コード */
     zrnhjnkykhyj ,         /* （連携用）法人契約表示 */
     zrnhrkkeirokbn ,         /* （連携用）払込経路区分 */
     zrnlivguardtkyks ,         /* （連携用）ＬｉＶガード特約Ｓ */
     zrnsiteituukaitijibrp ,         /* （連携用）指定通貨建一時払保険料 */
     zrnsiteituukasyus ,         /* （連携用）指定通貨建主契約保険金額 */
     zrnsiteituukasbs ,         /* （連携用）指定通貨建死亡保険金額 */
     zrnsiteituukasaigaisbs ,         /* （連携用）指定通貨建災害死亡保険金額 */
     zrnsiteituukacd ,         /* （連携用）指定通貨コード */
     zrnhrktuukaitijibrp ,         /* （連携用）払込通貨建一時払保険料 */
     zrnhrktuukacd ,         /* （連携用）払込通貨コード */
     zrntumitateriritu ,         /* （連携用）積立利率 */
     zrntmttknzoukaritujygn ,         /* （連携用）積立金増加率上限 */
     zrnsetteibairitu ,         /* （連携用）設定倍率 */
     zrntumitatekngk ,         /* （連携用）積立金額 */
     zrnkjsbuktnm30 ,         /* （連携用）漢字死亡受取人名３０ */
     zrnmnkuktnm30 ,         /* （連携用）漢字満期受取人名３０ */
     zrnkjkykdairinm ,         /* （連携用）漢字契約者代理人名 */
     zrnkjsiteidairinm30 ,         /* （連携用）漢字指定代理人名３０ */
     zrntrkkzknmkj1 ,         /* （連携用）登録家族名（漢字）１ */
     zrntrkkzknmkj2 ,         /* （連携用）登録家族名（漢字）２ */
     zrnikkatubaraikbn ,         /* （連携用）一括払区分 */
     zrnikkatubaraikaisuu ,         /* （連携用）一括払回数 */
     zrnannaifuyouriyuukbn ,         /* （連携用）案内不要理由区分 */
     zrnrendouritu ,         /* （連携用）連動率 */
     zrnteikishrritu ,         /* （連携用）定期支払率 */
     zrntikskzuktnmkj ,         /* （連携用）定期支払金受取人名（漢字） */
     zrntikskzbankcd ,         /* （連携用）定期支払金受取口座銀行コード */
     zrntikskzsitencd ,         /* （連携用）定期支払金受取口座支店コード */
     zrntikskzyokinkbn ,         /* （連携用）定期支払金受取口座預金種目区分 */
     zrntikskzkouzano ,         /* （連携用）定期支払金受取口座番号 */
     zrntikskzkzmeiginmkn ,         /* （連携用）定期支払金受取口座名義人氏名（カナ） */
     zrnteikishrkinshrtuukasyu ,         /* （連携用）定期支払金支払通貨 */
     zrnyobiv58           /* （連携用）予備項目Ｖ５８ */
FROM ZT_BosyuuDrtenHoyuuKykRn_Z;
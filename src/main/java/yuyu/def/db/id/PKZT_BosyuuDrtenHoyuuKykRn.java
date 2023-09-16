package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_BosyuuDrtenHoyuuKykRn;
import yuyu.def.db.mapping.GenZT_BosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.GenQZT_BosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.QZT_BosyuuDrtenHoyuuKykRn;

/**
 * 募集代理店保有契約Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_BosyuuDrtenHoyuuKykRn}</td><td colspan="3">募集代理店保有契約Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrndatasyurui</td><td>（連携用）データ種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyumoku</td><td>（連携用）保険種目</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyoubokbn</td><td>（連携用）帳簿区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyonosyuban zrnsyonosyuban}</td><td>（連携用）証券番号主番</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyurui2keta</td><td>（連携用）保険種類（２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkhuhukbn</td><td>（連携用）払込方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukinkbn</td><td>（連携用）集金区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbnkaisuu</td><td>（連携用）分割回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyouhocd</td><td>（連携用）共保コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndaibuncd</td><td>（連携用）代分コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndaibunkanjishare</td><td>（連携用）代分幹事分シェア</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndntcd7keta</td><td>（連携用）団体コード（７桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyumokugrpkbn</td><td>（連携用）種目グループ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngoukeipbsdirtnhykyk</td><td>（連携用）合計保険料（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyno7keta</td><td>（連携用）郵便番号（７桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsikiymd</td><td>（連携用）始期年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmankiymd</td><td>（連携用）満期年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnidokaiyakuymd</td><td>（連携用）異動解約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmusymd</td><td>（連携用）申込年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjikokykhyj</td><td>（連携用）自己契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmeisaioyakokbn</td><td>（連携用）明細親子区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihontikucdkami3</td><td>（連携用）基本地区コード上３桁</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv2</td><td>（連携用）予備項目Ｖ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntelnobsdirtnhykyk</td><td>（連携用）電話番号（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmknbsdirtnhykyk</td><td>（連携用）契約者名（カナ）（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbnkyk1kaipbsdirtnhykyk</td><td>（連携用）分割払契約１回分保険料（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbnsyuruikbn</td><td>（連携用）分割種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkymd</td><td>（連携用）払込日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndntfsthrkym</td><td>（連携用）団体扱初回払込年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstpkzhurikbn</td><td>（連携用）初回保険料口座振替区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeijyouym4keta</td><td>（連携用）計上年月（４桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknkaisyacd</td><td>（連携用）保険会社コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmknbsdirtnhykyk</td><td>（連携用）被保険者名（カナ）（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknjhhknmei</td><td>（連携用）漢字被保険者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknseiymd</td><td>（連携用）被保険者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnenbsdirtnhykyk</td><td>（連携用）被保険者年令（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhkntdk</td><td>（連携用）被保険者続柄</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknynobsdirtnhykyk</td><td>（連携用）被保険者郵便番号（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknadrkj50</td><td>（連携用）被保険者漢字住所５０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeiro</td><td>（連携用）払込経路</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitijibrpbsdirtnhykyk</td><td>（連携用）一時払保険料（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkshrkknkbn</td><td>（連携用）年金支払期間区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkshrkknnen</td><td>（連携用）年金支払期間年</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkshrstartymd</td><td>（連携用）年金支払開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokutaiumu</td><td>（連携用）特体有無</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntktyuutohuka</td><td>（連携用）特約中途付加</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntksuu</td><td>（連携用）特約数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsinsakbn</td><td>（連携用）診査区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzeiseitekikaku</td><td>（連携用）税制適格</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnlivingneeds</td><td>（連携用）リビングニーズ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknjsyuhsynm</td><td>（連携用）漢字主契約保種名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyusbsdirtnhykyk</td><td>（連携用）主契約保険金額（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuhknkknkbn</td><td>（連携用）主契約保険期間区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuhknkkn</td><td>（連携用）主契約保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuhrkkknkbn</td><td>（連携用）主契約払込期間区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuhrkkkn</td><td>（連携用）主契約払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjtkhosyunm1</td><td>（連携用）漢字特約保種名１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntks1bsdirtnhykyk</td><td>（連携用）特約保険金額１（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkknkbn1</td><td>（連携用）特約保険期間区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkkn1</td><td>（連携用）特約保険期間１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkknkbn1</td><td>（連携用）特約払込期間区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkkn1</td><td>（連携用）特約払込期間１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjtkhosyunm2</td><td>（連携用）漢字特約保種名２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntks2bsdirtnhykyk</td><td>（連携用）特約保険金額２（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkknkbn2</td><td>（連携用）特約保険期間区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkkn2</td><td>（連携用）特約保険期間２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkknkbn2</td><td>（連携用）特約払込期間区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkkn2</td><td>（連携用）特約払込期間２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjtkhosyunm3</td><td>（連携用）漢字特約保種名３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntks3bsdirtnhykyk</td><td>（連携用）特約保険金額３（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkknkbn3</td><td>（連携用）特約保険期間区分３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkkn3</td><td>（連携用）特約保険期間３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkknkbn3</td><td>（連携用）特約払込期間区分３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkkn3</td><td>（連携用）特約払込期間３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjtkhosyunm4</td><td>（連携用）漢字特約保種名４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntks4bsdirtnhykyk</td><td>（連携用）特約保険金額４（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkknkbn4</td><td>（連携用）特約保険期間区分４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkkn4</td><td>（連携用）特約保険期間４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkknkbn4</td><td>（連携用）特約払込期間区分４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkkn4</td><td>（連携用）特約払込期間４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjtkhosyunm5</td><td>（連携用）漢字特約保種名５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntks5bsdirtnhykyk</td><td>（連携用）特約保険金額５（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkknkbn5</td><td>（連携用）特約保険期間区分５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkkn5</td><td>（連携用）特約保険期間５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkknkbn5</td><td>（連携用）特約払込期間区分５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkkn5</td><td>（連携用）特約払込期間５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjtkhosyunm6</td><td>（連携用）漢字特約保種名６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntks6bsdirtnhykyk</td><td>（連携用）特約保険金額６（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkknkbn6</td><td>（連携用）特約保険期間区分６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkkn6</td><td>（連携用）特約保険期間６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkknkbn6</td><td>（連携用）特約払込期間区分６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkkn6</td><td>（連携用）特約払込期間６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndatasyubetucd</td><td>（連携用）データ種別コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjnkojinkbn</td><td>（連携用）法人個人区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykadrkj50</td><td>（連携用）契約者漢字住所５０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkjbsdirtnhykyk</td><td>（連携用）契約者名(漢字）（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaseiymd</td><td>（連携用）契約者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsakuseiym</td><td>（連携用）作成年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitencd</td><td>（連携用）代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenkanrisskcd</td><td>（連携用）代理店管理組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuunincd</td><td>（連携用）募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuunm</td><td>（連携用）募集人氏名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnbosyuujtkbn</td><td>（連携用）募集人状態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenkbtinfo1</td><td>（連携用）代理店個別情報１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenkbtinfo2</td><td>（連携用）代理店個別情報２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenkbtinfo3</td><td>（連携用）代理店個別情報３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyouhinbunruikbn</td><td>（連携用）商品分類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknnmcd</td><td>（連携用）保険名称コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykjyutikbn</td><td>（連携用）契約状態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkbthsyukiknmanryouym</td><td>（連携用）特別保障期間満了年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnldownym</td><td>（連携用）Ｌダウン年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkmanryouym</td><td>（連携用）払込満了年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmrtiksnym</td><td>（連携用）マル定更新年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhaneikykhyj</td><td>（連携用）繁栄契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenzeikyohyj</td><td>（連携用）全税共表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsikijikbn</td><td>（連携用）職事区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbuktdisphukusuhyj</td><td>（連携用）死亡受取人複数表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbuktnmbsdirtnhykyk</td><td>（連携用）死亡受取人名（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmnkuktdisphukusuhyj</td><td>（連携用）満期受取人複数表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmnkuktnmbsdirtnhykyk</td><td>（連携用）満期受取人名（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntodouhukencd</td><td>（連携用）都道府県コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbankcd</td><td>（連携用）銀行番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshitencd</td><td>（連携用）支店番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyokinkbn</td><td>（連携用）預金種目区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouzano7keta</td><td>（連携用）口座番号（７桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnalcardkbn</td><td>（連携用）ＡＬカード区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsibous</td><td>（連携用）死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsgsbs</td><td>（連携用）災害死亡S</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsgwrmstksbsdirtnhykyk</td><td>（連携用）災害割増特約Ｓ（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyougaitkkatakbn</td><td>（連携用）傷害特約型区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyougaitksbsdirtnhykyk</td><td>（連携用）傷害特約Ｓ（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnreguardtksbsdirtnhykyk</td><td>（連携用）リガード特約Ｓ（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnreguardtkkbn</td><td>（連携用）リガード特約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnvreguardtksbsdirtnhykyk</td><td>（連携用）Ｖガード特約Ｓ（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkmrthgukatakbn</td><td>（連携用）家族マル定配偶者型区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkmrthgusbsdirtnhykyk</td><td>（連携用）家族マル定配偶者Ｓ（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkmrtkosbsdirtnhykyk</td><td>（連携用）家族マル定子Ｓ（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaneeztkarihyj</td><td>（連携用）ケアニーズ特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtenkinyuucd</td><td>（連携用）代理店金融機関コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensitencd</td><td>（連携用）代理店支店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstjmkbn</td><td>（連携用）集中事務組織区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokaiphrkkeiro</td><td>（連携用）初回Ｐ払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncifcd</td><td>（連携用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjidairitennm</td><td>（連携用）漢字代理店名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntsrybnwari</td><td>（連携用）手数料分割割合</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndrtenkeijyouym</td><td>（連携用）代理店計上年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkydatkidairitencd</td><td>（連携用）共同扱代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmdhnsyouhntsryshrkbn</td><td>（連携用）窓販商品手数料支払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyanen</td><td>（連携用）契約者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmdhnaisyoumeicd</td><td>（連携用）窓販用愛称名コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokaipryosyuymd</td><td>（連携用）初回Ｐ領収年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsykgycd</td><td>（連携用）職業コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiyakuhrmkhritu</td><td>（連携用）解約返戻金目標率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoutatukaiyakuhrmkhritu</td><td>（連携用）到達解約返戻金目標率（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiyakuhrmkhtoutatuymd</td><td>（連携用）解約返戻金目標到達年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnanniskcd</td><td>（連携用）案内先コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjnkykhyj</td><td>（連携用）法人契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnlivguardtkyks</td><td>（連携用）ＬｉＶガード特約Ｓ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiteituukaitijibrp</td><td>（連携用）指定通貨建一時払保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiteituukasyus</td><td>（連携用）指定通貨建主契約保険金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiteituukasbs</td><td>（連携用）指定通貨建死亡保険金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiteituukasaigaisbs</td><td>（連携用）指定通貨建災害死亡保険金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiteituukacd</td><td>（連携用）指定通貨コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrktuukaitijibrp</td><td>（連携用）払込通貨建一時払保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhrktuukacd</td><td>（連携用）払込通貨コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntumitateriritu</td><td>（連携用）積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntmttknzoukaritujygn</td><td>（連携用）積立金増加率上限</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsetteibairitu</td><td>（連携用）設定倍率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntumitatekngk</td><td>（連携用）積立金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkjsbuktnm30</td><td>（連携用）漢字死亡受取人名３０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnmnkuktnm30</td><td>（連携用）漢字満期受取人名３０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjkykdairinm</td><td>（連携用）漢字契約者代理人名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjsiteidairinm30</td><td>（連携用）漢字指定代理人名３０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntrkkzknmkj1</td><td>（連携用）登録家族名（漢字）１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntrkkzknmkj2</td><td>（連携用）登録家族名（漢字）２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnikkatubaraikbn</td><td>（連携用）一括払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikkatubaraikaisuu</td><td>（連携用）一括払回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaifuyouriyuukbn</td><td>（連携用）案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrendouritu</td><td>（連携用）連動率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnteikishrritu</td><td>（連携用）定期支払率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntikskzuktnmkj</td><td>（連携用）定期支払金受取人名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntikskzbankcd</td><td>（連携用）定期支払金受取口座銀行コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntikskzsitencd</td><td>（連携用）定期支払金受取口座支店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntikskzyokinkbn</td><td>（連携用）定期支払金受取口座預金種目区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntikskzkouzano</td><td>（連携用）定期支払金受取口座番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntikskzkzmeiginmkn</td><td>（連携用）定期支払金受取口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikishrkinshrtuukasyu</td><td>（連携用）定期支払金支払通貨</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnnknsnpssyhknsyukigou</td><td>（連携用）年換算Ｐ算出用保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnnknsnpssyhknkkn</td><td>（連携用）年換算Ｐ算出用保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnnknsnpssyphrkkikn</td><td>（連携用）年換算Ｐ算出用Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnnknsnpssysaimnkkykhyj</td><td>（連携用）年換算Ｐ算出用才満期契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnknsnpssyhrkkskbn</td><td>（連携用）年換算Ｐ算出用払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnnknsnpssyhhknnen</td><td>（連携用）年換算Ｐ算出用被保険者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnnknsnpssyitijibrpkyktk</td><td>（連携用）年換算Ｐ算出用一時払Ｐ（契約通貨建）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnnnknsnpssysyup</td><td>（連携用）年換算Ｐ算出用主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnnknsnpssykawaseraten5</td><td>（連携用）年換算Ｐ算出用為替レートＮ５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzennoup</td><td>（連携用）前納保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv25</td><td>（連携用）予備項目Ｖ２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_BosyuuDrtenHoyuuKykRn
 * @see     GenZT_BosyuuDrtenHoyuuKykRn
 * @see     QZT_BosyuuDrtenHoyuuKykRn
 * @see     GenQZT_BosyuuDrtenHoyuuKykRn
 */
public class PKZT_BosyuuDrtenHoyuuKykRn extends AbstractExDBPrimaryKey<ZT_BosyuuDrtenHoyuuKykRn, PKZT_BosyuuDrtenHoyuuKykRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_BosyuuDrtenHoyuuKykRn() {
    }

    public PKZT_BosyuuDrtenHoyuuKykRn(String pZrnsyonosyuban) {
        zrnsyonosyuban = pZrnsyonosyuban;
    }

    @Transient
    @Override
    public Class<ZT_BosyuuDrtenHoyuuKykRn> getEntityClass() {
        return ZT_BosyuuDrtenHoyuuKykRn.class;
    }

    private String zrnsyonosyuban;

    public String getZrnsyonosyuban() {
        return zrnsyonosyuban;
    }

    public void setZrnsyonosyuban(String pZrnsyonosyuban) {
        zrnsyonosyuban = pZrnsyonosyuban;
    }

}
package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_BosyuuDrtenHoyuuKykTy;
import yuyu.def.db.mapping.GenZT_BosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.GenQZT_BosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.QZT_BosyuuDrtenHoyuuKykTy;

/**
 * 募集代理店保有契約Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_BosyuuDrtenHoyuuKykTy}</td><td colspan="3">募集代理店保有契約Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztydatasyurui</td><td>（中継用）データ種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyumoku</td><td>（中継用）保険種目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyoubokbn</td><td>（中継用）帳簿区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyonosyuban ztysyonosyuban}</td><td>（中継用）証券番号主番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyurui2keta</td><td>（中継用）保険種類（２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkhuhukbn</td><td>（中継用）払込方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukinkbn</td><td>（中継用）集金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybnkaisuu</td><td>（中継用）分割回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyouhocd</td><td>（中継用）共保コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydaibuncd</td><td>（中継用）代分コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydaibunkanjishare</td><td>（中継用）代分幹事分シェア</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydntcd7keta</td><td>（中継用）団体コード（７桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyumokugrpkbn</td><td>（中継用）種目グループ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygoukeipbsdirtnhykyk</td><td>（中継用）合計保険料（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyno7keta</td><td>（中継用）郵便番号（７桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysikiymd</td><td>（中継用）始期年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymankiymd</td><td>（中継用）満期年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyidokaiyakuymd</td><td>（中継用）異動解約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymusymd</td><td>（中継用）申込年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjikokykhyj</td><td>（中継用）自己契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymeisaioyakokbn</td><td>（中継用）明細親子区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihontikucdkami3</td><td>（中継用）基本地区コード上３桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv2</td><td>（中継用）予備項目Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytelnobsdirtnhykyk</td><td>（中継用）電話番号（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmknbsdirtnhykyk</td><td>（中継用）契約者名（カナ）（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybnkyk1kaipbsdirtnhykyk</td><td>（中継用）分割払契約１回分保険料（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybnsyuruikbn</td><td>（中継用）分割種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkymd</td><td>（中継用）払込日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydntfsthrkym</td><td>（中継用）団体扱初回払込年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstpkzhurikbn</td><td>（中継用）初回保険料口座振替区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeijyouym4keta</td><td>（中継用）計上年月（４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknkaisyacd</td><td>（中継用）保険会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmknbsdirtnhykyk</td><td>（中継用）被保険者名（カナ）（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknjhhknmei</td><td>（中継用）漢字被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseiymd</td><td>（中継用）被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnenbsdirtnhykyk</td><td>（中継用）被保険者年令（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkntdk</td><td>（中継用）被保険者続柄</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknynobsdirtnhykyk</td><td>（中継用）被保険者郵便番号（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknadrkj50</td><td>（中継用）被保険者漢字住所５０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeiro</td><td>（中継用）払込経路</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyitijibrpbsdirtnhykyk</td><td>（中継用）一時払保険料（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkshrkknkbn</td><td>（中継用）年金支払期間区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkshrkknnen</td><td>（中継用）年金支払期間年</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkshrstartymd</td><td>（中継用）年金支払開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokutaiumu</td><td>（中継用）特体有無</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytktyuutohuka</td><td>（中継用）特約中途付加</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksuu</td><td>（中継用）特約数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinsakbn</td><td>（中継用）診査区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzeiseitekikaku</td><td>（中継用）税制適格</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztylivingneeds</td><td>（中継用）リビングニーズ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknjsyuhsynm</td><td>（中継用）漢字主契約保種名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyusbsdirtnhykyk</td><td>（中継用）主契約保険金額（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuhknkknkbn</td><td>（中継用）主契約保険期間区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuhknkkn</td><td>（中継用）主契約保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuhrkkknkbn</td><td>（中継用）主契約払込期間区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuhrkkkn</td><td>（中継用）主契約払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjtkhosyunm1</td><td>（中継用）漢字特約保種名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytks1bsdirtnhykyk</td><td>（中継用）特約保険金額１（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkknkbn1</td><td>（中継用）特約保険期間区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkkn1</td><td>（中継用）特約保険期間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkknkbn1</td><td>（中継用）特約払込期間区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkkn1</td><td>（中継用）特約払込期間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjtkhosyunm2</td><td>（中継用）漢字特約保種名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytks2bsdirtnhykyk</td><td>（中継用）特約保険金額２（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkknkbn2</td><td>（中継用）特約保険期間区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkkn2</td><td>（中継用）特約保険期間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkknkbn2</td><td>（中継用）特約払込期間区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkkn2</td><td>（中継用）特約払込期間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjtkhosyunm3</td><td>（中継用）漢字特約保種名３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytks3bsdirtnhykyk</td><td>（中継用）特約保険金額３（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkknkbn3</td><td>（中継用）特約保険期間区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkkn3</td><td>（中継用）特約保険期間３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkknkbn3</td><td>（中継用）特約払込期間区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkkn3</td><td>（中継用）特約払込期間３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjtkhosyunm4</td><td>（中継用）漢字特約保種名４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytks4bsdirtnhykyk</td><td>（中継用）特約保険金額４（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkknkbn4</td><td>（中継用）特約保険期間区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkkn4</td><td>（中継用）特約保険期間４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkknkbn4</td><td>（中継用）特約払込期間区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkkn4</td><td>（中継用）特約払込期間４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjtkhosyunm5</td><td>（中継用）漢字特約保種名５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytks5bsdirtnhykyk</td><td>（中継用）特約保険金額５（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkknkbn5</td><td>（中継用）特約保険期間区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkkn5</td><td>（中継用）特約保険期間５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkknkbn5</td><td>（中継用）特約払込期間区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkkn5</td><td>（中継用）特約払込期間５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjtkhosyunm6</td><td>（中継用）漢字特約保種名６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytks6bsdirtnhykyk</td><td>（中継用）特約保険金額６（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkknkbn6</td><td>（中継用）特約保険期間区分６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkkn6</td><td>（中継用）特約保険期間６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkknkbn6</td><td>（中継用）特約払込期間区分６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkkn6</td><td>（中継用）特約払込期間６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydatasyubetucd</td><td>（中継用）データ種別コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhjnkojinkbn</td><td>（中継用）法人個人区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykadrkj50</td><td>（中継用）契約者漢字住所５０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkjbsdirtnhykyk</td><td>（中継用）契約者名(漢字）（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaseiymd</td><td>（中継用）契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakuseiym</td><td>（中継用）作成年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitencd</td><td>（中継用）代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitenkanrisskcd</td><td>（中継用）代理店管理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuunincd</td><td>（中継用）募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuunm</td><td>（中継用）募集人氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuujtkbn</td><td>（中継用）募集人状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitenkbtinfo1</td><td>（中継用）代理店個別情報１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitenkbtinfo2</td><td>（中継用）代理店個別情報２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitenkbtinfo3</td><td>（中継用）代理店個別情報３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyouhinbunruikbn</td><td>（中継用）商品分類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknnmcd</td><td>（中継用）保険名称コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykjyutikbn</td><td>（中継用）契約状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkbthsyukiknmanryouym</td><td>（中継用）特別保障期間満了年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyldownym</td><td>（中継用）Ｌダウン年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkmanryouym</td><td>（中継用）払込満了年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymrtiksnym</td><td>（中継用）マル定更新年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhaneikykhyj</td><td>（中継用）繁栄契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenzeikyohyj</td><td>（中継用）全税共表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysikijikbn</td><td>（中継用）職事区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktdisphukusuhyj</td><td>（中継用）死亡受取人複数表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktnmbsdirtnhykyk</td><td>（中継用）死亡受取人名（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymnkuktdisphukusuhyj</td><td>（中継用）満期受取人複数表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymnkuktnmbsdirtnhykyk</td><td>（中継用）満期受取人名（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytodouhukencd</td><td>（中継用）都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybankcd</td><td>（中継用）銀行番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshitencd</td><td>（中継用）支店番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyokinkbn</td><td>（中継用）預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykouzano7keta</td><td>（中継用）口座番号（７桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyalcardkbn</td><td>（中継用）ＡＬカード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysibous</td><td>（中継用）死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysgsbs</td><td>（中継用）災害死亡S</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysgwrmstksbsdirtnhykyk</td><td>（中継用）災害割増特約Ｓ（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyougaitkkatakbn</td><td>（中継用）傷害特約型区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyougaitksbsdirtnhykyk</td><td>（中継用）傷害特約Ｓ（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyreguardtksbsdirtnhykyk</td><td>（中継用）リガード特約Ｓ（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyreguardtkkbn</td><td>（中継用）リガード特約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyvreguardtksbsdirtnhykyk</td><td>（中継用）Ｖガード特約Ｓ（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkmrthgukatakbn</td><td>（中継用）家族マル定配偶者型区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkmrthgusbsdirtnhykyk</td><td>（中継用）家族マル定配偶者Ｓ（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkmrtkosbsdirtnhykyk</td><td>（中継用）家族マル定子Ｓ（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaneeztkarihyj</td><td>（中継用）ケアニーズ特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydrtenkinyuucd</td><td>（中継用）代理店金融機関コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydrtensitencd</td><td>（中継用）代理店支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystjmkbn</td><td>（中継用）集中事務組織区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaiphrkkeiro</td><td>（中継用）初回Ｐ払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycifcd</td><td>（中継用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanjidairitennm</td><td>（中継用）漢字代理店名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsrybnwari</td><td>（中継用）手数料分割割合</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztydrtenkeijyouym</td><td>（中継用）代理店計上年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykydatkidairitencd</td><td>（中継用）共同扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymdhnsyouhntsryshrkbn</td><td>（中継用）窓販商品手数料支払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyanen</td><td>（中継用）契約者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymdhnaisyoumeicd</td><td>（中継用）窓販用愛称名コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaipryosyuymd</td><td>（中継用）初回Ｐ領収年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykgycd</td><td>（中継用）職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiyakuhrmkhritu</td><td>（中継用）解約返戻金目標率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoutatukaiyakuhrmkhritu</td><td>（中継用）到達解約返戻金目標率（募集代理店保有契約）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiyakuhrmkhtoutatuymd</td><td>（中継用）解約返戻金目標到達年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyanniskcd</td><td>（中継用）案内先コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhjnkykhyj</td><td>（中継用）法人契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztylivguardtkyks</td><td>（中継用）ＬｉＶガード特約Ｓ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiteituukaitijibrp</td><td>（中継用）指定通貨建一時払保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysiteituukasyus</td><td>（中継用）指定通貨建主契約保険金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysiteituukasbs</td><td>（中継用）指定通貨建死亡保険金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysiteituukasaigaisbs</td><td>（中継用）指定通貨建災害死亡保険金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysiteituukacd</td><td>（中継用）指定通貨コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrktuukaitijibrp</td><td>（中継用）払込通貨建一時払保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhrktuukacd</td><td>（中継用）払込通貨コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytumitateriritu</td><td>（中継用）積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytmttknzoukaritujygn</td><td>（中継用）積立金増加率上限</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysetteibairitu</td><td>（中継用）設定倍率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytumitatekngk</td><td>（中継用）積立金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykjsbuktnm30</td><td>（中継用）漢字死亡受取人名３０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymnkuktnm30</td><td>（中継用）漢字満期受取人名３０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkykdairinm</td><td>（中継用）漢字契約者代理人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjsiteidairinm30</td><td>（中継用）漢字指定代理人名３０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzknmkj1</td><td>（中継用）登録家族名（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzknmkj2</td><td>（中継用）登録家族名（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatubaraikbn</td><td>（中継用）一括払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatubaraikaisuu</td><td>（中継用）一括払回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrendouritu</td><td>（中継用）連動率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyteikishrritu</td><td>（中継用）定期支払率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytikskzuktnmkj</td><td>（中継用）定期支払金受取人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytikskzbankcd</td><td>（中継用）定期支払金受取口座銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytikskzsitencd</td><td>（中継用）定期支払金受取口座支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytikskzyokinkbn</td><td>（中継用）定期支払金受取口座預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytikskzkouzano</td><td>（中継用）定期支払金受取口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytikskzkzmeiginmkn</td><td>（中継用）定期支払金受取口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikishrkinshrtuukasyu</td><td>（中継用）定期支払金支払通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynnknsnpssyhknsyukigou</td><td>（中継用）年換算Ｐ算出用保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynnknsnpssyhknkkn</td><td>（中継用）年換算Ｐ算出用保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynnknsnpssyphrkkikn</td><td>（中継用）年換算Ｐ算出用Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynnknsnpssysaimnkkykhyj</td><td>（中継用）年換算Ｐ算出用才満期契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynknsnpssyhrkkskbn</td><td>（中継用）年換算Ｐ算出用払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynnknsnpssyhhknnen</td><td>（中継用）年換算Ｐ算出用被保険者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynnknsnpssyitijibrpkyktk</td><td>（中継用）年換算Ｐ算出用一時払Ｐ（契約通貨建）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztynnknsnpssysyup</td><td>（中継用）年換算Ｐ算出用主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynnknsnpssykawaseraten5</td><td>（中継用）年換算Ｐ算出用為替レートＮ５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzennoup</td><td>（中継用）前納保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv25</td><td>（中継用）予備項目Ｖ２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_BosyuuDrtenHoyuuKykTy
 * @see     GenZT_BosyuuDrtenHoyuuKykTy
 * @see     QZT_BosyuuDrtenHoyuuKykTy
 * @see     GenQZT_BosyuuDrtenHoyuuKykTy
 */
public class PKZT_BosyuuDrtenHoyuuKykTy extends AbstractExDBPrimaryKey<ZT_BosyuuDrtenHoyuuKykTy, PKZT_BosyuuDrtenHoyuuKykTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_BosyuuDrtenHoyuuKykTy() {
    }

    public PKZT_BosyuuDrtenHoyuuKykTy(String pZtysyonosyuban) {
        ztysyonosyuban = pZtysyonosyuban;
    }

    @Transient
    @Override
    public Class<ZT_BosyuuDrtenHoyuuKykTy> getEntityClass() {
        return ZT_BosyuuDrtenHoyuuKykTy.class;
    }

    private String ztysyonosyuban;

    public String getZtysyonosyuban() {
        return ztysyonosyuban;
    }

    public void setZtysyonosyuban(String pZtysyonosyuban) {
        ztysyonosyuban = pZtysyonosyuban;
    }

}
package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_BosyuuDrtenHoyuuKykTy;
import yuyu.def.db.id.PKZT_BosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.GenQZT_BosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.QZT_BosyuuDrtenHoyuuKykTy;

/**
 * 募集代理店保有契約Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_BosyuuDrtenHoyuuKykTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_BosyuuDrtenHoyuuKykTy}</td><td colspan="3">募集代理店保有契約Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtydatasyurui ztydatasyurui}</td><td>（中継用）データ種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyumoku ztyhknsyumoku}</td><td>（中継用）保険種目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyoubokbn ztytyoubokbn}</td><td>（中継用）帳簿区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyonosyuban ztysyonosyuban}</td><td>（中継用）証券番号主番</td><td align="center">{@link PKZT_BosyuuDrtenHoyuuKykTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyurui2keta ztyhknsyurui2keta}</td><td>（中継用）保険種類（２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkhuhukbn ztyhrkhuhukbn}</td><td>（中継用）払込方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukinkbn ztysyukinkbn}</td><td>（中継用）集金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnkaisuu ztybnkaisuu}</td><td>（中継用）分割回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyouhocd ztykyouhocd}</td><td>（中継用）共保コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydaibuncd ztydaibuncd}</td><td>（中継用）代分コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydaibunkanjishare ztydaibunkanjishare}</td><td>（中継用）代分幹事分シェア</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydntcd7keta ztydntcd7keta}</td><td>（中継用）団体コード（７桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyumokugrpkbn ztysyumokugrpkbn}</td><td>（中継用）種目グループ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeipbsdirtnhykyk ztygoukeipbsdirtnhykyk}</td><td>（中継用）合計保険料（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyno7keta ztyyno7keta}</td><td>（中継用）郵便番号（７桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikiymd ztysikiymd}</td><td>（中継用）始期年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymankiymd ztymankiymd}</td><td>（中継用）満期年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyidokaiyakuymd ztyidokaiyakuymd}</td><td>（中継用）異動解約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymusymd ztymusymd}</td><td>（中継用）申込年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikokykhyj ztyjikokykhyj}</td><td>（中継用）自己契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymeisaioyakokbn ztymeisaioyakokbn}</td><td>（中継用）明細親子区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihontikucdkami3 ztykihontikucdkami3}</td><td>（中継用）基本地区コード上３桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2 ztyyobiv2}</td><td>（中継用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytelnobsdirtnhykyk ztytelnobsdirtnhykyk}</td><td>（中継用）電話番号（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmknbsdirtnhykyk ztykyknmknbsdirtnhykyk}</td><td>（中継用）契約者名（カナ）（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnkyk1kaipbsdirtnhykyk ztybnkyk1kaipbsdirtnhykyk}</td><td>（中継用）分割払契約１回分保険料（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnsyuruikbn ztybnsyuruikbn}</td><td>（中継用）分割種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkymd ztyhrkymd}</td><td>（中継用）払込日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydntfsthrkym ztydntfsthrkym}</td><td>（中継用）団体扱初回払込年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstpkzhurikbn ztyfstpkzhurikbn}</td><td>（中継用）初回保険料口座振替区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeijyouym4keta ztykeijyouym4keta}</td><td>（中継用）計上年月（４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkaisyacd ztyhknkaisyacd}</td><td>（中継用）保険会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmknbsdirtnhykyk ztyhhknnmknbsdirtnhykyk}</td><td>（中継用）被保険者名（カナ）（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknjhhknmei ztyknjhhknmei}</td><td>（中継用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseiymd ztyhhknseiymd}</td><td>（中継用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnenbsdirtnhykyk ztyhhknnenbsdirtnhykyk}</td><td>（中継用）被保険者年令（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkntdk ztyhhkntdk}</td><td>（中継用）被保険者続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknynobsdirtnhykyk ztyhhknynobsdirtnhykyk}</td><td>（中継用）被保険者郵便番号（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknadrkj50 ztyhhknadrkj50}</td><td>（中継用）被保険者漢字住所５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeiro ztyhrkkeiro}</td><td>（中継用）払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijibrpbsdirtnhykyk ztyitijibrpbsdirtnhykyk}</td><td>（中継用）一時払保険料（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrkknkbn ztynkshrkknkbn}</td><td>（中継用）年金支払期間区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrkknnen ztynkshrkknnen}</td><td>（中継用）年金支払期間年</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrstartymd ztynkshrstartymd}</td><td>（中継用）年金支払開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokutaiumu ztytokutaiumu}</td><td>（中継用）特体有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytktyuutohuka ztytktyuutohuka}</td><td>（中継用）特約中途付加</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksuu ztytksuu}</td><td>（中継用）特約数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinsakbn ztysinsakbn}</td><td>（中継用）診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeiseitekikaku ztyzeiseitekikaku}</td><td>（中継用）税制適格</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylivingneeds ztylivingneeds}</td><td>（中継用）リビングニーズ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknjsyuhsynm ztyknjsyuhsynm}</td><td>（中継用）漢字主契約保種名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyusbsdirtnhykyk ztysyusbsdirtnhykyk}</td><td>（中継用）主契約保険金額（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuhknkknkbn ztysyuhknkknkbn}</td><td>（中継用）主契約保険期間区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuhknkkn ztysyuhknkkn}</td><td>（中継用）主契約保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuhrkkknkbn ztysyuhrkkknkbn}</td><td>（中継用）主契約払込期間区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuhrkkkn ztysyuhrkkkn}</td><td>（中継用）主契約払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjtkhosyunm1 ztykjtkhosyunm1}</td><td>（中継用）漢字特約保種名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytks1bsdirtnhykyk ztytks1bsdirtnhykyk}</td><td>（中継用）特約保険金額１（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkknkbn1 ztytkhknkknkbn1}</td><td>（中継用）特約保険期間区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkkn1 ztytkhknkkn1}</td><td>（中継用）特約保険期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkknkbn1 ztytkhrkkknkbn1}</td><td>（中継用）特約払込期間区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkkn1 ztytkhrkkkn1}</td><td>（中継用）特約払込期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjtkhosyunm2 ztykjtkhosyunm2}</td><td>（中継用）漢字特約保種名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytks2bsdirtnhykyk ztytks2bsdirtnhykyk}</td><td>（中継用）特約保険金額２（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkknkbn2 ztytkhknkknkbn2}</td><td>（中継用）特約保険期間区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkkn2 ztytkhknkkn2}</td><td>（中継用）特約保険期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkknkbn2 ztytkhrkkknkbn2}</td><td>（中継用）特約払込期間区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkkn2 ztytkhrkkkn2}</td><td>（中継用）特約払込期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjtkhosyunm3 ztykjtkhosyunm3}</td><td>（中継用）漢字特約保種名３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytks3bsdirtnhykyk ztytks3bsdirtnhykyk}</td><td>（中継用）特約保険金額３（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkknkbn3 ztytkhknkknkbn3}</td><td>（中継用）特約保険期間区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkkn3 ztytkhknkkn3}</td><td>（中継用）特約保険期間３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkknkbn3 ztytkhrkkknkbn3}</td><td>（中継用）特約払込期間区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkkn3 ztytkhrkkkn3}</td><td>（中継用）特約払込期間３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjtkhosyunm4 ztykjtkhosyunm4}</td><td>（中継用）漢字特約保種名４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytks4bsdirtnhykyk ztytks4bsdirtnhykyk}</td><td>（中継用）特約保険金額４（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkknkbn4 ztytkhknkknkbn4}</td><td>（中継用）特約保険期間区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkkn4 ztytkhknkkn4}</td><td>（中継用）特約保険期間４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkknkbn4 ztytkhrkkknkbn4}</td><td>（中継用）特約払込期間区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkkn4 ztytkhrkkkn4}</td><td>（中継用）特約払込期間４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjtkhosyunm5 ztykjtkhosyunm5}</td><td>（中継用）漢字特約保種名５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytks5bsdirtnhykyk ztytks5bsdirtnhykyk}</td><td>（中継用）特約保険金額５（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkknkbn5 ztytkhknkknkbn5}</td><td>（中継用）特約保険期間区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkkn5 ztytkhknkkn5}</td><td>（中継用）特約保険期間５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkknkbn5 ztytkhrkkknkbn5}</td><td>（中継用）特約払込期間区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkkn5 ztytkhrkkkn5}</td><td>（中継用）特約払込期間５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjtkhosyunm6 ztykjtkhosyunm6}</td><td>（中継用）漢字特約保種名６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytks6bsdirtnhykyk ztytks6bsdirtnhykyk}</td><td>（中継用）特約保険金額６（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkknkbn6 ztytkhknkknkbn6}</td><td>（中継用）特約保険期間区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkkn6 ztytkhknkkn6}</td><td>（中継用）特約保険期間６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkknkbn6 ztytkhrkkknkbn6}</td><td>（中継用）特約払込期間区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkkn6 ztytkhrkkkn6}</td><td>（中継用）特約払込期間６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatasyubetucd ztydatasyubetucd}</td><td>（中継用）データ種別コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjnkojinkbn ztyhjnkojinkbn}</td><td>（中継用）法人個人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykadrkj50 ztykykadrkj50}</td><td>（中継用）契約者漢字住所５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkjbsdirtnhykyk ztykyknmkjbsdirtnhykyk}</td><td>（中継用）契約者名(漢字）（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseiymd ztykyksyaseiymd}</td><td>（中継用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuseiym ztysakuseiym}</td><td>（中継用）作成年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitencd ztydairitencd}</td><td>（中継用）代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenkanrisskcd ztydairitenkanrisskcd}</td><td>（中継用）代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuunincd ztybosyuunincd}</td><td>（中継用）募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuunm ztybosyuunm}</td><td>（中継用）募集人氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuujtkbn ztybosyuujtkbn}</td><td>（中継用）募集人状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenkbtinfo1 ztydairitenkbtinfo1}</td><td>（中継用）代理店個別情報１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenkbtinfo2 ztydairitenkbtinfo2}</td><td>（中継用）代理店個別情報２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenkbtinfo3 ztydairitenkbtinfo3}</td><td>（中継用）代理店個別情報３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyouhinbunruikbn ztysyouhinbunruikbn}</td><td>（中継用）商品分類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknnmcd ztyhknnmcd}</td><td>（中継用）保険名称コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjyutikbn ztykykjyutikbn}</td><td>（中継用）契約状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkbthsyukiknmanryouym ztytkbthsyukiknmanryouym}</td><td>（中継用）特別保障期間満了年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyldownym ztyldownym}</td><td>（中継用）Ｌダウン年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkmanryouym ztyhrkmanryouym}</td><td>（中継用）払込満了年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrtiksnym ztymrtiksnym}</td><td>（中継用）マル定更新年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaneikykhyj ztyhaneikykhyj}</td><td>（中継用）繁栄契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenzeikyohyj ztyzenzeikyohyj}</td><td>（中継用）全税共表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikijikbn ztysikijikbn}</td><td>（中継用）職事区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktdisphukusuhyj ztysbuktdisphukusuhyj}</td><td>（中継用）死亡受取人複数表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktnmbsdirtnhykyk ztysbuktnmbsdirtnhykyk}</td><td>（中継用）死亡受取人名（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnkuktdisphukusuhyj ztymnkuktdisphukusuhyj}</td><td>（中継用）満期受取人複数表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnkuktnmbsdirtnhykyk ztymnkuktnmbsdirtnhykyk}</td><td>（中継用）満期受取人名（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytodouhukencd ztytodouhukencd}</td><td>（中継用）都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybankcd ztybankcd}</td><td>（中継用）銀行番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshitencd ztyshitencd}</td><td>（中継用）支店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyokinkbn ztyyokinkbn}</td><td>（中継用）預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouzano7keta ztykouzano7keta}</td><td>（中継用）口座番号（７桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyalcardkbn ztyalcardkbn}</td><td>（中継用）ＡＬカード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysibous ztysibous}</td><td>（中継用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysgsbs ztysgsbs}</td><td>（中継用）災害死亡S</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysgwrmstksbsdirtnhykyk ztysgwrmstksbsdirtnhykyk}</td><td>（中継用）災害割増特約Ｓ（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyougaitkkatakbn ztysyougaitkkatakbn}</td><td>（中継用）傷害特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyougaitksbsdirtnhykyk ztysyougaitksbsdirtnhykyk}</td><td>（中継用）傷害特約Ｓ（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyreguardtksbsdirtnhykyk ztyreguardtksbsdirtnhykyk}</td><td>（中継用）リガード特約Ｓ（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyreguardtkkbn ztyreguardtkkbn}</td><td>（中継用）リガード特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvreguardtksbsdirtnhykyk ztyvreguardtksbsdirtnhykyk}</td><td>（中継用）Ｖガード特約Ｓ（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrthgukatakbn ztykzkmrthgukatakbn}</td><td>（中継用）家族マル定配偶者型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrthgusbsdirtnhykyk ztykzkmrthgusbsdirtnhykyk}</td><td>（中継用）家族マル定配偶者Ｓ（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtkosbsdirtnhykyk ztykzkmrtkosbsdirtnhykyk}</td><td>（中継用）家族マル定子Ｓ（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaneeztkarihyj ztykaneeztkarihyj}</td><td>（中継用）ケアニーズ特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydrtenkinyuucd ztydrtenkinyuucd}</td><td>（中継用）代理店金融機関コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydrtensitencd ztydrtensitencd}</td><td>（中継用）代理店支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystjmkbn ztystjmkbn}</td><td>（中継用）集中事務組織区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaiphrkkeiro ztysyokaiphrkkeiro}</td><td>（中継用）初回Ｐ払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjidairitennm ztykanjidairitennm}</td><td>（中継用）漢字代理店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsrybnwari ztytsrybnwari}</td><td>（中継用）手数料分割割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydrtenkeijyouym ztydrtenkeijyouym}</td><td>（中継用）代理店計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykydatkidairitencd ztykydatkidairitencd}</td><td>（中継用）共同扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymdhnsyouhntsryshrkbn ztymdhnsyouhntsryshrkbn}</td><td>（中継用）窓販商品手数料支払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyanen ztykyksyanen}</td><td>（中継用）契約者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymdhnaisyoumeicd ztymdhnaisyoumeicd}</td><td>（中継用）窓販用愛称名コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaipryosyuymd ztysyokaipryosyuymd}</td><td>（中継用）初回Ｐ領収年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykgycd ztysykgycd}</td><td>（中継用）職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiyakuhrmkhritu ztykaiyakuhrmkhritu}</td><td>（中継用）解約返戻金目標率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoutatukaiyakuhrmkhritu ztytoutatukaiyakuhrmkhritu}</td><td>（中継用）到達解約返戻金目標率（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiyakuhrmkhtoutatuymd ztykaiyakuhrmkhtoutatuymd}</td><td>（中継用）解約返戻金目標到達年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyanniskcd ztyanniskcd}</td><td>（中継用）案内先コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjnkykhyj ztyhjnkykhyj}</td><td>（中継用）法人契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylivguardtkyks ztylivguardtkyks}</td><td>（中継用）ＬｉＶガード特約Ｓ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteituukaitijibrp ztysiteituukaitijibrp}</td><td>（中継用）指定通貨建一時払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiteituukasyus ztysiteituukasyus}</td><td>（中継用）指定通貨建主契約保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiteituukasbs ztysiteituukasbs}</td><td>（中継用）指定通貨建死亡保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiteituukasaigaisbs ztysiteituukasaigaisbs}</td><td>（中継用）指定通貨建災害死亡保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiteituukacd ztysiteituukacd}</td><td>（中継用）指定通貨コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrktuukaitijibrp ztyhrktuukaitijibrp}</td><td>（中継用）払込通貨建一時払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhrktuukacd ztyhrktuukacd}</td><td>（中継用）払込通貨コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytumitateriritu ztytumitateriritu}</td><td>（中継用）積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritujygn ztytmttknzoukaritujygn}</td><td>（中継用）積立金増加率上限</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysetteibairitu ztysetteibairitu}</td><td>（中継用）設定倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytumitatekngk ztytumitatekngk}</td><td>（中継用）積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykjsbuktnm30 ztykjsbuktnm30}</td><td>（中継用）漢字死亡受取人名３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnkuktnm30 ztymnkuktnm30}</td><td>（中継用）漢字満期受取人名３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkykdairinm ztykjkykdairinm}</td><td>（中継用）漢字契約者代理人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjsiteidairinm30 ztykjsiteidairinm30}</td><td>（中継用）漢字指定代理人名３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzknmkj1 ztytrkkzknmkj1}</td><td>（中継用）登録家族名（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzknmkj2 ztytrkkzknmkj2}</td><td>（中継用）登録家族名（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikbn ztyikkatubaraikbn}</td><td>（中継用）一括払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikaisuu ztyikkatubaraikaisuu}</td><td>（中継用）一括払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouritu ztyrendouritu}</td><td>（中継用）連動率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyteikishrritu ztyteikishrritu}</td><td>（中継用）定期支払率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytikskzuktnmkj ztytikskzuktnmkj}</td><td>（中継用）定期支払金受取人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytikskzbankcd ztytikskzbankcd}</td><td>（中継用）定期支払金受取口座銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytikskzsitencd ztytikskzsitencd}</td><td>（中継用）定期支払金受取口座支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytikskzyokinkbn ztytikskzyokinkbn}</td><td>（中継用）定期支払金受取口座預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytikskzkouzano ztytikskzkouzano}</td><td>（中継用）定期支払金受取口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytikskzkzmeiginmkn ztytikskzkzmeiginmkn}</td><td>（中継用）定期支払金受取口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikishrkinshrtuukasyu ztyteikishrkinshrtuukasyu}</td><td>（中継用）定期支払金支払通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynnknsnpssyhknsyukigou ztynnknsnpssyhknsyukigou}</td><td>（中継用）年換算Ｐ算出用保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynnknsnpssyhknkkn ztynnknsnpssyhknkkn}</td><td>（中継用）年換算Ｐ算出用保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynnknsnpssyphrkkikn ztynnknsnpssyphrkkikn}</td><td>（中継用）年換算Ｐ算出用Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynnknsnpssysaimnkkykhyj ztynnknsnpssysaimnkkykhyj}</td><td>（中継用）年換算Ｐ算出用才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynknsnpssyhrkkskbn ztynknsnpssyhrkkskbn}</td><td>（中継用）年換算Ｐ算出用払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynnknsnpssyhhknnen ztynnknsnpssyhhknnen}</td><td>（中継用）年換算Ｐ算出用被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynnknsnpssyitijibrpkyktk ztynnknsnpssyitijibrpkyktk}</td><td>（中継用）年換算Ｐ算出用一時払Ｐ（契約通貨建）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtynnknsnpssysyup ztynnknsnpssysyup}</td><td>（中継用）年換算Ｐ算出用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynnknsnpssykawaseraten5 ztynnknsnpssykawaseraten5}</td><td>（中継用）年換算Ｐ算出用為替レートＮ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzennoup ztyzennoup}</td><td>（中継用）前納保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv25 ztyyobiv25}</td><td>（中継用）予備項目Ｖ２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_BosyuuDrtenHoyuuKykTy
 * @see     PKZT_BosyuuDrtenHoyuuKykTy
 * @see     QZT_BosyuuDrtenHoyuuKykTy
 * @see     GenQZT_BosyuuDrtenHoyuuKykTy
 */
@MappedSuperclass
@Table(name=GenZT_BosyuuDrtenHoyuuKykTy.TABLE_NAME)
@IdClass(value=PKZT_BosyuuDrtenHoyuuKykTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_BosyuuDrtenHoyuuKykTy extends AbstractExDBEntity<ZT_BosyuuDrtenHoyuuKykTy, PKZT_BosyuuDrtenHoyuuKykTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_BosyuuDrtenHoyuuKykTy";
    public static final String ZTYDATASYURUI            = "ztydatasyurui";
    public static final String ZTYHKNSYUMOKU            = "ztyhknsyumoku";
    public static final String ZTYTYOUBOKBN             = "ztytyoubokbn";
    public static final String ZTYSYONOSYUBAN           = "ztysyonosyuban";
    public static final String ZTYHKNSYURUI2KETA        = "ztyhknsyurui2keta";
    public static final String ZTYHRKHUHUKBN            = "ztyhrkhuhukbn";
    public static final String ZTYSYUKINKBN             = "ztysyukinkbn";
    public static final String ZTYBNKAISUU              = "ztybnkaisuu";
    public static final String ZTYKYOUHOCD              = "ztykyouhocd";
    public static final String ZTYDAIBUNCD              = "ztydaibuncd";
    public static final String ZTYDAIBUNKANJISHARE      = "ztydaibunkanjishare";
    public static final String ZTYDNTCD7KETA            = "ztydntcd7keta";
    public static final String ZTYSYUMOKUGRPKBN         = "ztysyumokugrpkbn";
    public static final String ZTYGOUKEIPBSDIRTNHYKYK   = "ztygoukeipbsdirtnhykyk";
    public static final String ZTYYNO7KETA              = "ztyyno7keta";
    public static final String ZTYSIKIYMD               = "ztysikiymd";
    public static final String ZTYMANKIYMD              = "ztymankiymd";
    public static final String ZTYIDOKAIYAKUYMD         = "ztyidokaiyakuymd";
    public static final String ZTYMUSYMD                = "ztymusymd";
    public static final String ZTYJIKOKYKHYJ            = "ztyjikokykhyj";
    public static final String ZTYMEISAIOYAKOKBN        = "ztymeisaioyakokbn";
    public static final String ZTYKIHONTIKUCDKAMI3      = "ztykihontikucdkami3";
    public static final String ZTYYOBIV2                = "ztyyobiv2";
    public static final String ZTYTELNOBSDIRTNHYKYK     = "ztytelnobsdirtnhykyk";
    public static final String ZTYKYKNMKNBSDIRTNHYKYK   = "ztykyknmknbsdirtnhykyk";
    public static final String ZTYBNKYK1KAIPBSDIRTNHYKYK = "ztybnkyk1kaipbsdirtnhykyk";
    public static final String ZTYBNSYURUIKBN           = "ztybnsyuruikbn";
    public static final String ZTYHRKYMD                = "ztyhrkymd";
    public static final String ZTYDNTFSTHRKYM           = "ztydntfsthrkym";
    public static final String ZTYFSTPKZHURIKBN         = "ztyfstpkzhurikbn";
    public static final String ZTYKEIJYOUYM4KETA        = "ztykeijyouym4keta";
    public static final String ZTYHKNKAISYACD           = "ztyhknkaisyacd";
    public static final String ZTYHHKNNMKNBSDIRTNHYKYK  = "ztyhhknnmknbsdirtnhykyk";
    public static final String ZTYKNJHHKNMEI            = "ztyknjhhknmei";
    public static final String ZTYHHKNSEIYMD            = "ztyhhknseiymd";
    public static final String ZTYHHKNNENBSDIRTNHYKYK   = "ztyhhknnenbsdirtnhykyk";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHHKNTDK               = "ztyhhkntdk";
    public static final String ZTYHHKNYNOBSDIRTNHYKYK   = "ztyhhknynobsdirtnhykyk";
    public static final String ZTYHHKNADRKJ50           = "ztyhhknadrkj50";
    public static final String ZTYHRKKEIRO              = "ztyhrkkeiro";
    public static final String ZTYITIJIBRPBSDIRTNHYKYK  = "ztyitijibrpbsdirtnhykyk";
    public static final String ZTYNKSHRKKNKBN           = "ztynkshrkknkbn";
    public static final String ZTYNKSHRKKNNEN           = "ztynkshrkknnen";
    public static final String ZTYNKSHRSTARTYMD         = "ztynkshrstartymd";
    public static final String ZTYTOKUTAIUMU            = "ztytokutaiumu";
    public static final String ZTYTKTYUUTOHUKA          = "ztytktyuutohuka";
    public static final String ZTYTKSUU                 = "ztytksuu";
    public static final String ZTYSINSAKBN              = "ztysinsakbn";
    public static final String ZTYZEISEITEKIKAKU        = "ztyzeiseitekikaku";
    public static final String ZTYLIVINGNEEDS           = "ztylivingneeds";
    public static final String ZTYKNJSYUHSYNM           = "ztyknjsyuhsynm";
    public static final String ZTYSYUSBSDIRTNHYKYK      = "ztysyusbsdirtnhykyk";
    public static final String ZTYSYUHKNKKNKBN          = "ztysyuhknkknkbn";
    public static final String ZTYSYUHKNKKN             = "ztysyuhknkkn";
    public static final String ZTYSYUHRKKKNKBN          = "ztysyuhrkkknkbn";
    public static final String ZTYSYUHRKKKN             = "ztysyuhrkkkn";
    public static final String ZTYKJTKHOSYUNM1          = "ztykjtkhosyunm1";
    public static final String ZTYTKS1BSDIRTNHYKYK      = "ztytks1bsdirtnhykyk";
    public static final String ZTYTKHKNKKNKBN1          = "ztytkhknkknkbn1";
    public static final String ZTYTKHKNKKN1             = "ztytkhknkkn1";
    public static final String ZTYTKHRKKKNKBN1          = "ztytkhrkkknkbn1";
    public static final String ZTYTKHRKKKN1             = "ztytkhrkkkn1";
    public static final String ZTYKJTKHOSYUNM2          = "ztykjtkhosyunm2";
    public static final String ZTYTKS2BSDIRTNHYKYK      = "ztytks2bsdirtnhykyk";
    public static final String ZTYTKHKNKKNKBN2          = "ztytkhknkknkbn2";
    public static final String ZTYTKHKNKKN2             = "ztytkhknkkn2";
    public static final String ZTYTKHRKKKNKBN2          = "ztytkhrkkknkbn2";
    public static final String ZTYTKHRKKKN2             = "ztytkhrkkkn2";
    public static final String ZTYKJTKHOSYUNM3          = "ztykjtkhosyunm3";
    public static final String ZTYTKS3BSDIRTNHYKYK      = "ztytks3bsdirtnhykyk";
    public static final String ZTYTKHKNKKNKBN3          = "ztytkhknkknkbn3";
    public static final String ZTYTKHKNKKN3             = "ztytkhknkkn3";
    public static final String ZTYTKHRKKKNKBN3          = "ztytkhrkkknkbn3";
    public static final String ZTYTKHRKKKN3             = "ztytkhrkkkn3";
    public static final String ZTYKJTKHOSYUNM4          = "ztykjtkhosyunm4";
    public static final String ZTYTKS4BSDIRTNHYKYK      = "ztytks4bsdirtnhykyk";
    public static final String ZTYTKHKNKKNKBN4          = "ztytkhknkknkbn4";
    public static final String ZTYTKHKNKKN4             = "ztytkhknkkn4";
    public static final String ZTYTKHRKKKNKBN4          = "ztytkhrkkknkbn4";
    public static final String ZTYTKHRKKKN4             = "ztytkhrkkkn4";
    public static final String ZTYKJTKHOSYUNM5          = "ztykjtkhosyunm5";
    public static final String ZTYTKS5BSDIRTNHYKYK      = "ztytks5bsdirtnhykyk";
    public static final String ZTYTKHKNKKNKBN5          = "ztytkhknkknkbn5";
    public static final String ZTYTKHKNKKN5             = "ztytkhknkkn5";
    public static final String ZTYTKHRKKKNKBN5          = "ztytkhrkkknkbn5";
    public static final String ZTYTKHRKKKN5             = "ztytkhrkkkn5";
    public static final String ZTYKJTKHOSYUNM6          = "ztykjtkhosyunm6";
    public static final String ZTYTKS6BSDIRTNHYKYK      = "ztytks6bsdirtnhykyk";
    public static final String ZTYTKHKNKKNKBN6          = "ztytkhknkknkbn6";
    public static final String ZTYTKHKNKKN6             = "ztytkhknkkn6";
    public static final String ZTYTKHRKKKNKBN6          = "ztytkhrkkknkbn6";
    public static final String ZTYTKHRKKKN6             = "ztytkhrkkkn6";
    public static final String ZTYDATASYUBETUCD         = "ztydatasyubetucd";
    public static final String ZTYHJNKOJINKBN           = "ztyhjnkojinkbn";
    public static final String ZTYKYKADRKJ50            = "ztykykadrkj50";
    public static final String ZTYKYKNMKJBSDIRTNHYKYK   = "ztykyknmkjbsdirtnhykyk";
    public static final String ZTYKYKSYASEIYMD          = "ztykyksyaseiymd";
    public static final String ZTYSAKUSEIYM             = "ztysakuseiym";
    public static final String ZTYDAIRITENCD            = "ztydairitencd";
    public static final String ZTYDAIRITENKANRISSKCD    = "ztydairitenkanrisskcd";
    public static final String ZTYBOSYUUNINCD           = "ztybosyuunincd";
    public static final String ZTYBOSYUUNM              = "ztybosyuunm";
    public static final String ZTYBOSYUUJTKBN           = "ztybosyuujtkbn";
    public static final String ZTYDAIRITENKBTINFO1      = "ztydairitenkbtinfo1";
    public static final String ZTYDAIRITENKBTINFO2      = "ztydairitenkbtinfo2";
    public static final String ZTYDAIRITENKBTINFO3      = "ztydairitenkbtinfo3";
    public static final String ZTYSYOUHINBUNRUIKBN      = "ztysyouhinbunruikbn";
    public static final String ZTYHKNNMCD               = "ztyhknnmcd";
    public static final String ZTYKYKJYUTIKBN           = "ztykykjyutikbn";
    public static final String ZTYTKBTHSYUKIKNMANRYOUYM = "ztytkbthsyukiknmanryouym";
    public static final String ZTYLDOWNYM               = "ztyldownym";
    public static final String ZTYHRKMANRYOUYM          = "ztyhrkmanryouym";
    public static final String ZTYMRTIKSNYM             = "ztymrtiksnym";
    public static final String ZTYHANEIKYKHYJ           = "ztyhaneikykhyj";
    public static final String ZTYZENZEIKYOHYJ          = "ztyzenzeikyohyj";
    public static final String ZTYSIKIJIKBN             = "ztysikijikbn";
    public static final String ZTYSBUKTDISPHUKUSUHYJ    = "ztysbuktdisphukusuhyj";
    public static final String ZTYSBUKTNMBSDIRTNHYKYK   = "ztysbuktnmbsdirtnhykyk";
    public static final String ZTYMNKUKTDISPHUKUSUHYJ   = "ztymnkuktdisphukusuhyj";
    public static final String ZTYMNKUKTNMBSDIRTNHYKYK  = "ztymnkuktnmbsdirtnhykyk";
    public static final String ZTYTODOUHUKENCD          = "ztytodouhukencd";
    public static final String ZTYBANKCD                = "ztybankcd";
    public static final String ZTYSHITENCD              = "ztyshitencd";
    public static final String ZTYYOKINKBN              = "ztyyokinkbn";
    public static final String ZTYKOUZANO7KETA          = "ztykouzano7keta";
    public static final String ZTYALCARDKBN             = "ztyalcardkbn";
    public static final String ZTYSIBOUS                = "ztysibous";
    public static final String ZTYSGSBS                 = "ztysgsbs";
    public static final String ZTYSGWRMSTKSBSDIRTNHYKYK = "ztysgwrmstksbsdirtnhykyk";
    public static final String ZTYSYOUGAITKKATAKBN      = "ztysyougaitkkatakbn";
    public static final String ZTYSYOUGAITKSBSDIRTNHYKYK = "ztysyougaitksbsdirtnhykyk";
    public static final String ZTYREGUARDTKSBSDIRTNHYKYK = "ztyreguardtksbsdirtnhykyk";
    public static final String ZTYREGUARDTKKBN          = "ztyreguardtkkbn";
    public static final String ZTYVREGUARDTKSBSDIRTNHYKYK = "ztyvreguardtksbsdirtnhykyk";
    public static final String ZTYKZKMRTHGUKATAKBN      = "ztykzkmrthgukatakbn";
    public static final String ZTYKZKMRTHGUSBSDIRTNHYKYK = "ztykzkmrthgusbsdirtnhykyk";
    public static final String ZTYKZKMRTKOSBSDIRTNHYKYK = "ztykzkmrtkosbsdirtnhykyk";
    public static final String ZTYKANEEZTKARIHYJ        = "ztykaneeztkarihyj";
    public static final String ZTYDRTENKINYUUCD         = "ztydrtenkinyuucd";
    public static final String ZTYDRTENSITENCD          = "ztydrtensitencd";
    public static final String ZTYSTJMKBN               = "ztystjmkbn";
    public static final String ZTYSYOKAIPHRKKEIRO       = "ztysyokaiphrkkeiro";
    public static final String ZTYCIFCD                 = "ztycifcd";
    public static final String ZTYKANJIDAIRITENNM       = "ztykanjidairitennm";
    public static final String ZTYTSRYBNWARI            = "ztytsrybnwari";
    public static final String ZTYDRTENKEIJYOUYM        = "ztydrtenkeijyouym";
    public static final String ZTYKYDATKIDAIRITENCD     = "ztykydatkidairitencd";
    public static final String ZTYMDHNSYOUHNTSRYSHRKBN  = "ztymdhnsyouhntsryshrkbn";
    public static final String ZTYKYKSYANEN             = "ztykyksyanen";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYMDHNAISYOUMEICD       = "ztymdhnaisyoumeicd";
    public static final String ZTYSYOKAIPRYOSYUYMD      = "ztysyokaipryosyuymd";
    public static final String ZTYSYKGYCD               = "ztysykgycd";
    public static final String ZTYKAIYAKUHRMKHRITU      = "ztykaiyakuhrmkhritu";
    public static final String ZTYTOUTATUKAIYAKUHRMKHRITU = "ztytoutatukaiyakuhrmkhritu";
    public static final String ZTYKAIYAKUHRMKHTOUTATUYMD = "ztykaiyakuhrmkhtoutatuymd";
    public static final String ZTYANNISKCD              = "ztyanniskcd";
    public static final String ZTYHJNKYKHYJ             = "ztyhjnkykhyj";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYLIVGUARDTKYKS         = "ztylivguardtkyks";
    public static final String ZTYSITEITUUKAITIJIBRP    = "ztysiteituukaitijibrp";
    public static final String ZTYSITEITUUKASYUS        = "ztysiteituukasyus";
    public static final String ZTYSITEITUUKASBS         = "ztysiteituukasbs";
    public static final String ZTYSITEITUUKASAIGAISBS   = "ztysiteituukasaigaisbs";
    public static final String ZTYSITEITUUKACD          = "ztysiteituukacd";
    public static final String ZTYHRKTUUKAITIJIBRP      = "ztyhrktuukaitijibrp";
    public static final String ZTYHRKTUUKACD            = "ztyhrktuukacd";
    public static final String ZTYTUMITATERIRITU        = "ztytumitateriritu";
    public static final String ZTYTMTTKNZOUKARITUJYGN   = "ztytmttknzoukaritujygn";
    public static final String ZTYSETTEIBAIRITU         = "ztysetteibairitu";
    public static final String ZTYTUMITATEKNGK          = "ztytumitatekngk";
    public static final String ZTYKJSBUKTNM30           = "ztykjsbuktnm30";
    public static final String ZTYMNKUKTNM30            = "ztymnkuktnm30";
    public static final String ZTYKJKYKDAIRINM          = "ztykjkykdairinm";
    public static final String ZTYKJSITEIDAIRINM30      = "ztykjsiteidairinm30";
    public static final String ZTYTRKKZKNMKJ1           = "ztytrkkzknmkj1";
    public static final String ZTYTRKKZKNMKJ2           = "ztytrkkzknmkj2";
    public static final String ZTYIKKATUBARAIKBN        = "ztyikkatubaraikbn";
    public static final String ZTYIKKATUBARAIKAISUU     = "ztyikkatubaraikaisuu";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYRENDOURITU            = "ztyrendouritu";
    public static final String ZTYTEIKISHRRITU          = "ztyteikishrritu";
    public static final String ZTYTIKSKZUKTNMKJ         = "ztytikskzuktnmkj";
    public static final String ZTYTIKSKZBANKCD          = "ztytikskzbankcd";
    public static final String ZTYTIKSKZSITENCD         = "ztytikskzsitencd";
    public static final String ZTYTIKSKZYOKINKBN        = "ztytikskzyokinkbn";
    public static final String ZTYTIKSKZKOUZANO         = "ztytikskzkouzano";
    public static final String ZTYTIKSKZKZMEIGINMKN     = "ztytikskzkzmeiginmkn";
    public static final String ZTYTEIKISHRKINSHRTUUKASYU = "ztyteikishrkinshrtuukasyu";
    public static final String ZTYNNKNSNPSSYHKNSYUKIGOU = "ztynnknsnpssyhknsyukigou";
    public static final String ZTYNNKNSNPSSYHKNKKN      = "ztynnknsnpssyhknkkn";
    public static final String ZTYNNKNSNPSSYPHRKKIKN    = "ztynnknsnpssyphrkkikn";
    public static final String ZTYNNKNSNPSSYSAIMNKKYKHYJ = "ztynnknsnpssysaimnkkykhyj";
    public static final String ZTYNKNSNPSSYHRKKSKBN     = "ztynknsnpssyhrkkskbn";
    public static final String ZTYNNKNSNPSSYHHKNNEN     = "ztynnknsnpssyhhknnen";
    public static final String ZTYNNKNSNPSSYITIJIBRPKYKTK = "ztynnknsnpssyitijibrpkyktk";
    public static final String ZTYNNKNSNPSSYSYUP        = "ztynnknsnpssysyup";
    public static final String ZTYNNKNSNPSSYKAWASERATEN5 = "ztynnknsnpssykawaseraten5";
    public static final String ZTYZENNOUP               = "ztyzennoup";
    public static final String ZTYYOBIV25               = "ztyyobiv25";

    private final PKZT_BosyuuDrtenHoyuuKykTy primaryKey;

    public GenZT_BosyuuDrtenHoyuuKykTy() {
        primaryKey = new PKZT_BosyuuDrtenHoyuuKykTy();
    }

    public GenZT_BosyuuDrtenHoyuuKykTy(String pZtysyonosyuban) {
        primaryKey = new PKZT_BosyuuDrtenHoyuuKykTy(pZtysyonosyuban);
    }

    @Transient
    @Override
    public PKZT_BosyuuDrtenHoyuuKykTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_BosyuuDrtenHoyuuKykTy> getMetaClass() {
        return QZT_BosyuuDrtenHoyuuKykTy.class;
    }

    private String ztydatasyurui;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYDATASYURUI)
    public String getZtydatasyurui() {
        return ztydatasyurui;
    }

    public void setZtydatasyurui(String pZtydatasyurui) {
        ztydatasyurui = pZtydatasyurui;
    }

    private String ztyhknsyumoku;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHKNSYUMOKU)
    public String getZtyhknsyumoku() {
        return ztyhknsyumoku;
    }

    public void setZtyhknsyumoku(String pZtyhknsyumoku) {
        ztyhknsyumoku = pZtyhknsyumoku;
    }

    private String ztytyoubokbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTYOUBOKBN)
    public String getZtytyoubokbn() {
        return ztytyoubokbn;
    }

    public void setZtytyoubokbn(String pZtytyoubokbn) {
        ztytyoubokbn = pZtytyoubokbn;
    }

    @Id
    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSYONOSYUBAN)
    public String getZtysyonosyuban() {
        return getPrimaryKey().getZtysyonosyuban();
    }

    public void setZtysyonosyuban(String pZtysyonosyuban) {
        getPrimaryKey().setZtysyonosyuban(pZtysyonosyuban);
    }

    private String ztyhknsyurui2keta;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHKNSYURUI2KETA)
    public String getZtyhknsyurui2keta() {
        return ztyhknsyurui2keta;
    }

    public void setZtyhknsyurui2keta(String pZtyhknsyurui2keta) {
        ztyhknsyurui2keta = pZtyhknsyurui2keta;
    }

    private String ztyhrkhuhukbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHRKHUHUKBN)
    public String getZtyhrkhuhukbn() {
        return ztyhrkhuhukbn;
    }

    public void setZtyhrkhuhukbn(String pZtyhrkhuhukbn) {
        ztyhrkhuhukbn = pZtyhrkhuhukbn;
    }

    private String ztysyukinkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSYUKINKBN)
    public String getZtysyukinkbn() {
        return ztysyukinkbn;
    }

    public void setZtysyukinkbn(String pZtysyukinkbn) {
        ztysyukinkbn = pZtysyukinkbn;
    }

    private String ztybnkaisuu;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYBNKAISUU)
    public String getZtybnkaisuu() {
        return ztybnkaisuu;
    }

    public void setZtybnkaisuu(String pZtybnkaisuu) {
        ztybnkaisuu = pZtybnkaisuu;
    }

    private String ztykyouhocd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKYOUHOCD)
    public String getZtykyouhocd() {
        return ztykyouhocd;
    }

    public void setZtykyouhocd(String pZtykyouhocd) {
        ztykyouhocd = pZtykyouhocd;
    }

    private String ztydaibuncd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYDAIBUNCD)
    public String getZtydaibuncd() {
        return ztydaibuncd;
    }

    public void setZtydaibuncd(String pZtydaibuncd) {
        ztydaibuncd = pZtydaibuncd;
    }

    private String ztydaibunkanjishare;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYDAIBUNKANJISHARE)
    public String getZtydaibunkanjishare() {
        return ztydaibunkanjishare;
    }

    public void setZtydaibunkanjishare(String pZtydaibunkanjishare) {
        ztydaibunkanjishare = pZtydaibunkanjishare;
    }

    private String ztydntcd7keta;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYDNTCD7KETA)
    public String getZtydntcd7keta() {
        return ztydntcd7keta;
    }

    public void setZtydntcd7keta(String pZtydntcd7keta) {
        ztydntcd7keta = pZtydntcd7keta;
    }

    private String ztysyumokugrpkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSYUMOKUGRPKBN)
    public String getZtysyumokugrpkbn() {
        return ztysyumokugrpkbn;
    }

    public void setZtysyumokugrpkbn(String pZtysyumokugrpkbn) {
        ztysyumokugrpkbn = pZtysyumokugrpkbn;
    }

    private String ztygoukeipbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYGOUKEIPBSDIRTNHYKYK)
    public String getZtygoukeipbsdirtnhykyk() {
        return ztygoukeipbsdirtnhykyk;
    }

    public void setZtygoukeipbsdirtnhykyk(String pZtygoukeipbsdirtnhykyk) {
        ztygoukeipbsdirtnhykyk = pZtygoukeipbsdirtnhykyk;
    }

    private String ztyyno7keta;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYYNO7KETA)
    public String getZtyyno7keta() {
        return ztyyno7keta;
    }

    public void setZtyyno7keta(String pZtyyno7keta) {
        ztyyno7keta = pZtyyno7keta;
    }

    private String ztysikiymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSIKIYMD)
    public String getZtysikiymd() {
        return ztysikiymd;
    }

    public void setZtysikiymd(String pZtysikiymd) {
        ztysikiymd = pZtysikiymd;
    }

    private String ztymankiymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYMANKIYMD)
    public String getZtymankiymd() {
        return ztymankiymd;
    }

    public void setZtymankiymd(String pZtymankiymd) {
        ztymankiymd = pZtymankiymd;
    }

    private String ztyidokaiyakuymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYIDOKAIYAKUYMD)
    public String getZtyidokaiyakuymd() {
        return ztyidokaiyakuymd;
    }

    public void setZtyidokaiyakuymd(String pZtyidokaiyakuymd) {
        ztyidokaiyakuymd = pZtyidokaiyakuymd;
    }

    private String ztymusymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYMUSYMD)
    public String getZtymusymd() {
        return ztymusymd;
    }

    public void setZtymusymd(String pZtymusymd) {
        ztymusymd = pZtymusymd;
    }

    private String ztyjikokykhyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYJIKOKYKHYJ)
    public String getZtyjikokykhyj() {
        return ztyjikokykhyj;
    }

    public void setZtyjikokykhyj(String pZtyjikokykhyj) {
        ztyjikokykhyj = pZtyjikokykhyj;
    }

    private String ztymeisaioyakokbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYMEISAIOYAKOKBN)
    public String getZtymeisaioyakokbn() {
        return ztymeisaioyakokbn;
    }

    public void setZtymeisaioyakokbn(String pZtymeisaioyakokbn) {
        ztymeisaioyakokbn = pZtymeisaioyakokbn;
    }

    private String ztykihontikucdkami3;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKIHONTIKUCDKAMI3)
    public String getZtykihontikucdkami3() {
        return ztykihontikucdkami3;
    }

    public void setZtykihontikucdkami3(String pZtykihontikucdkami3) {
        ztykihontikucdkami3 = pZtykihontikucdkami3;
    }

    private String ztyyobiv2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYYOBIV2)
    public String getZtyyobiv2() {
        return ztyyobiv2;
    }

    public void setZtyyobiv2(String pZtyyobiv2) {
        ztyyobiv2 = pZtyyobiv2;
    }

    private String ztytelnobsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTELNOBSDIRTNHYKYK)
    public String getZtytelnobsdirtnhykyk() {
        return ztytelnobsdirtnhykyk;
    }

    public void setZtytelnobsdirtnhykyk(String pZtytelnobsdirtnhykyk) {
        ztytelnobsdirtnhykyk = pZtytelnobsdirtnhykyk;
    }

    private String ztykyknmknbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKYKNMKNBSDIRTNHYKYK)
    public String getZtykyknmknbsdirtnhykyk() {
        return ztykyknmknbsdirtnhykyk;
    }

    public void setZtykyknmknbsdirtnhykyk(String pZtykyknmknbsdirtnhykyk) {
        ztykyknmknbsdirtnhykyk = pZtykyknmknbsdirtnhykyk;
    }

    private String ztybnkyk1kaipbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYBNKYK1KAIPBSDIRTNHYKYK)
    public String getZtybnkyk1kaipbsdirtnhykyk() {
        return ztybnkyk1kaipbsdirtnhykyk;
    }

    public void setZtybnkyk1kaipbsdirtnhykyk(String pZtybnkyk1kaipbsdirtnhykyk) {
        ztybnkyk1kaipbsdirtnhykyk = pZtybnkyk1kaipbsdirtnhykyk;
    }

    private String ztybnsyuruikbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYBNSYURUIKBN)
    public String getZtybnsyuruikbn() {
        return ztybnsyuruikbn;
    }

    public void setZtybnsyuruikbn(String pZtybnsyuruikbn) {
        ztybnsyuruikbn = pZtybnsyuruikbn;
    }

    private String ztyhrkymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHRKYMD)
    public String getZtyhrkymd() {
        return ztyhrkymd;
    }

    public void setZtyhrkymd(String pZtyhrkymd) {
        ztyhrkymd = pZtyhrkymd;
    }

    private String ztydntfsthrkym;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYDNTFSTHRKYM)
    public String getZtydntfsthrkym() {
        return ztydntfsthrkym;
    }

    public void setZtydntfsthrkym(String pZtydntfsthrkym) {
        ztydntfsthrkym = pZtydntfsthrkym;
    }

    private String ztyfstpkzhurikbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYFSTPKZHURIKBN)
    public String getZtyfstpkzhurikbn() {
        return ztyfstpkzhurikbn;
    }

    public void setZtyfstpkzhurikbn(String pZtyfstpkzhurikbn) {
        ztyfstpkzhurikbn = pZtyfstpkzhurikbn;
    }

    private String ztykeijyouym4keta;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKEIJYOUYM4KETA)
    public String getZtykeijyouym4keta() {
        return ztykeijyouym4keta;
    }

    public void setZtykeijyouym4keta(String pZtykeijyouym4keta) {
        ztykeijyouym4keta = pZtykeijyouym4keta;
    }

    private String ztyhknkaisyacd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHKNKAISYACD)
    public String getZtyhknkaisyacd() {
        return ztyhknkaisyacd;
    }

    public void setZtyhknkaisyacd(String pZtyhknkaisyacd) {
        ztyhknkaisyacd = pZtyhknkaisyacd;
    }

    private String ztyhhknnmknbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHHKNNMKNBSDIRTNHYKYK)
    public String getZtyhhknnmknbsdirtnhykyk() {
        return ztyhhknnmknbsdirtnhykyk;
    }

    public void setZtyhhknnmknbsdirtnhykyk(String pZtyhhknnmknbsdirtnhykyk) {
        ztyhhknnmknbsdirtnhykyk = pZtyhhknnmknbsdirtnhykyk;
    }

    private String ztyknjhhknmei;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKNJHHKNMEI)
    public String getZtyknjhhknmei() {
        return ztyknjhhknmei;
    }

    public void setZtyknjhhknmei(String pZtyknjhhknmei) {
        ztyknjhhknmei = pZtyknjhhknmei;
    }

    private String ztyhhknseiymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHHKNSEIYMD)
    public String getZtyhhknseiymd() {
        return ztyhhknseiymd;
    }

    public void setZtyhhknseiymd(String pZtyhhknseiymd) {
        ztyhhknseiymd = pZtyhhknseiymd;
    }

    private String ztyhhknnenbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHHKNNENBSDIRTNHYKYK)
    public String getZtyhhknnenbsdirtnhykyk() {
        return ztyhhknnenbsdirtnhykyk;
    }

    public void setZtyhhknnenbsdirtnhykyk(String pZtyhhknnenbsdirtnhykyk) {
        ztyhhknnenbsdirtnhykyk = pZtyhhknnenbsdirtnhykyk;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhhkntdk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHHKNTDK)
    public String getZtyhhkntdk() {
        return ztyhhkntdk;
    }

    public void setZtyhhkntdk(String pZtyhhkntdk) {
        ztyhhkntdk = pZtyhhkntdk;
    }

    private String ztyhhknynobsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHHKNYNOBSDIRTNHYKYK)
    public String getZtyhhknynobsdirtnhykyk() {
        return ztyhhknynobsdirtnhykyk;
    }

    public void setZtyhhknynobsdirtnhykyk(String pZtyhhknynobsdirtnhykyk) {
        ztyhhknynobsdirtnhykyk = pZtyhhknynobsdirtnhykyk;
    }

    private String ztyhhknadrkj50;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHHKNADRKJ50)
    public String getZtyhhknadrkj50() {
        return ztyhhknadrkj50;
    }

    public void setZtyhhknadrkj50(String pZtyhhknadrkj50) {
        ztyhhknadrkj50 = pZtyhhknadrkj50;
    }

    private String ztyhrkkeiro;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHRKKEIRO)
    public String getZtyhrkkeiro() {
        return ztyhrkkeiro;
    }

    public void setZtyhrkkeiro(String pZtyhrkkeiro) {
        ztyhrkkeiro = pZtyhrkkeiro;
    }

    private String ztyitijibrpbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYITIJIBRPBSDIRTNHYKYK)
    public String getZtyitijibrpbsdirtnhykyk() {
        return ztyitijibrpbsdirtnhykyk;
    }

    public void setZtyitijibrpbsdirtnhykyk(String pZtyitijibrpbsdirtnhykyk) {
        ztyitijibrpbsdirtnhykyk = pZtyitijibrpbsdirtnhykyk;
    }

    private String ztynkshrkknkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYNKSHRKKNKBN)
    public String getZtynkshrkknkbn() {
        return ztynkshrkknkbn;
    }

    public void setZtynkshrkknkbn(String pZtynkshrkknkbn) {
        ztynkshrkknkbn = pZtynkshrkknkbn;
    }

    private String ztynkshrkknnen;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYNKSHRKKNNEN)
    public String getZtynkshrkknnen() {
        return ztynkshrkknnen;
    }

    public void setZtynkshrkknnen(String pZtynkshrkknnen) {
        ztynkshrkknnen = pZtynkshrkknnen;
    }

    private String ztynkshrstartymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYNKSHRSTARTYMD)
    public String getZtynkshrstartymd() {
        return ztynkshrstartymd;
    }

    public void setZtynkshrstartymd(String pZtynkshrstartymd) {
        ztynkshrstartymd = pZtynkshrstartymd;
    }

    private String ztytokutaiumu;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTOKUTAIUMU)
    public String getZtytokutaiumu() {
        return ztytokutaiumu;
    }

    public void setZtytokutaiumu(String pZtytokutaiumu) {
        ztytokutaiumu = pZtytokutaiumu;
    }

    private String ztytktyuutohuka;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKTYUUTOHUKA)
    public String getZtytktyuutohuka() {
        return ztytktyuutohuka;
    }

    public void setZtytktyuutohuka(String pZtytktyuutohuka) {
        ztytktyuutohuka = pZtytktyuutohuka;
    }

    private String ztytksuu;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKSUU)
    public String getZtytksuu() {
        return ztytksuu;
    }

    public void setZtytksuu(String pZtytksuu) {
        ztytksuu = pZtytksuu;
    }

    private String ztysinsakbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSINSAKBN)
    public String getZtysinsakbn() {
        return ztysinsakbn;
    }

    public void setZtysinsakbn(String pZtysinsakbn) {
        ztysinsakbn = pZtysinsakbn;
    }

    private String ztyzeiseitekikaku;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYZEISEITEKIKAKU)
    public String getZtyzeiseitekikaku() {
        return ztyzeiseitekikaku;
    }

    public void setZtyzeiseitekikaku(String pZtyzeiseitekikaku) {
        ztyzeiseitekikaku = pZtyzeiseitekikaku;
    }

    private String ztylivingneeds;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYLIVINGNEEDS)
    public String getZtylivingneeds() {
        return ztylivingneeds;
    }

    public void setZtylivingneeds(String pZtylivingneeds) {
        ztylivingneeds = pZtylivingneeds;
    }

    private String ztyknjsyuhsynm;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKNJSYUHSYNM)
    public String getZtyknjsyuhsynm() {
        return ztyknjsyuhsynm;
    }

    public void setZtyknjsyuhsynm(String pZtyknjsyuhsynm) {
        ztyknjsyuhsynm = pZtyknjsyuhsynm;
    }

    private String ztysyusbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSYUSBSDIRTNHYKYK)
    public String getZtysyusbsdirtnhykyk() {
        return ztysyusbsdirtnhykyk;
    }

    public void setZtysyusbsdirtnhykyk(String pZtysyusbsdirtnhykyk) {
        ztysyusbsdirtnhykyk = pZtysyusbsdirtnhykyk;
    }

    private String ztysyuhknkknkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSYUHKNKKNKBN)
    public String getZtysyuhknkknkbn() {
        return ztysyuhknkknkbn;
    }

    public void setZtysyuhknkknkbn(String pZtysyuhknkknkbn) {
        ztysyuhknkknkbn = pZtysyuhknkknkbn;
    }

    private String ztysyuhknkkn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSYUHKNKKN)
    public String getZtysyuhknkkn() {
        return ztysyuhknkkn;
    }

    public void setZtysyuhknkkn(String pZtysyuhknkkn) {
        ztysyuhknkkn = pZtysyuhknkkn;
    }

    private String ztysyuhrkkknkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSYUHRKKKNKBN)
    public String getZtysyuhrkkknkbn() {
        return ztysyuhrkkknkbn;
    }

    public void setZtysyuhrkkknkbn(String pZtysyuhrkkknkbn) {
        ztysyuhrkkknkbn = pZtysyuhrkkknkbn;
    }

    private String ztysyuhrkkkn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSYUHRKKKN)
    public String getZtysyuhrkkkn() {
        return ztysyuhrkkkn;
    }

    public void setZtysyuhrkkkn(String pZtysyuhrkkkn) {
        ztysyuhrkkkn = pZtysyuhrkkkn;
    }

    private String ztykjtkhosyunm1;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKJTKHOSYUNM1)
    public String getZtykjtkhosyunm1() {
        return ztykjtkhosyunm1;
    }

    public void setZtykjtkhosyunm1(String pZtykjtkhosyunm1) {
        ztykjtkhosyunm1 = pZtykjtkhosyunm1;
    }

    private String ztytks1bsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKS1BSDIRTNHYKYK)
    public String getZtytks1bsdirtnhykyk() {
        return ztytks1bsdirtnhykyk;
    }

    public void setZtytks1bsdirtnhykyk(String pZtytks1bsdirtnhykyk) {
        ztytks1bsdirtnhykyk = pZtytks1bsdirtnhykyk;
    }

    private String ztytkhknkknkbn1;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHKNKKNKBN1)
    public String getZtytkhknkknkbn1() {
        return ztytkhknkknkbn1;
    }

    public void setZtytkhknkknkbn1(String pZtytkhknkknkbn1) {
        ztytkhknkknkbn1 = pZtytkhknkknkbn1;
    }

    private String ztytkhknkkn1;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHKNKKN1)
    public String getZtytkhknkkn1() {
        return ztytkhknkkn1;
    }

    public void setZtytkhknkkn1(String pZtytkhknkkn1) {
        ztytkhknkkn1 = pZtytkhknkkn1;
    }

    private String ztytkhrkkknkbn1;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHRKKKNKBN1)
    public String getZtytkhrkkknkbn1() {
        return ztytkhrkkknkbn1;
    }

    public void setZtytkhrkkknkbn1(String pZtytkhrkkknkbn1) {
        ztytkhrkkknkbn1 = pZtytkhrkkknkbn1;
    }

    private String ztytkhrkkkn1;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHRKKKN1)
    public String getZtytkhrkkkn1() {
        return ztytkhrkkkn1;
    }

    public void setZtytkhrkkkn1(String pZtytkhrkkkn1) {
        ztytkhrkkkn1 = pZtytkhrkkkn1;
    }

    private String ztykjtkhosyunm2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKJTKHOSYUNM2)
    public String getZtykjtkhosyunm2() {
        return ztykjtkhosyunm2;
    }

    public void setZtykjtkhosyunm2(String pZtykjtkhosyunm2) {
        ztykjtkhosyunm2 = pZtykjtkhosyunm2;
    }

    private String ztytks2bsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKS2BSDIRTNHYKYK)
    public String getZtytks2bsdirtnhykyk() {
        return ztytks2bsdirtnhykyk;
    }

    public void setZtytks2bsdirtnhykyk(String pZtytks2bsdirtnhykyk) {
        ztytks2bsdirtnhykyk = pZtytks2bsdirtnhykyk;
    }

    private String ztytkhknkknkbn2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHKNKKNKBN2)
    public String getZtytkhknkknkbn2() {
        return ztytkhknkknkbn2;
    }

    public void setZtytkhknkknkbn2(String pZtytkhknkknkbn2) {
        ztytkhknkknkbn2 = pZtytkhknkknkbn2;
    }

    private String ztytkhknkkn2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHKNKKN2)
    public String getZtytkhknkkn2() {
        return ztytkhknkkn2;
    }

    public void setZtytkhknkkn2(String pZtytkhknkkn2) {
        ztytkhknkkn2 = pZtytkhknkkn2;
    }

    private String ztytkhrkkknkbn2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHRKKKNKBN2)
    public String getZtytkhrkkknkbn2() {
        return ztytkhrkkknkbn2;
    }

    public void setZtytkhrkkknkbn2(String pZtytkhrkkknkbn2) {
        ztytkhrkkknkbn2 = pZtytkhrkkknkbn2;
    }

    private String ztytkhrkkkn2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHRKKKN2)
    public String getZtytkhrkkkn2() {
        return ztytkhrkkkn2;
    }

    public void setZtytkhrkkkn2(String pZtytkhrkkkn2) {
        ztytkhrkkkn2 = pZtytkhrkkkn2;
    }

    private String ztykjtkhosyunm3;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKJTKHOSYUNM3)
    public String getZtykjtkhosyunm3() {
        return ztykjtkhosyunm3;
    }

    public void setZtykjtkhosyunm3(String pZtykjtkhosyunm3) {
        ztykjtkhosyunm3 = pZtykjtkhosyunm3;
    }

    private String ztytks3bsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKS3BSDIRTNHYKYK)
    public String getZtytks3bsdirtnhykyk() {
        return ztytks3bsdirtnhykyk;
    }

    public void setZtytks3bsdirtnhykyk(String pZtytks3bsdirtnhykyk) {
        ztytks3bsdirtnhykyk = pZtytks3bsdirtnhykyk;
    }

    private String ztytkhknkknkbn3;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHKNKKNKBN3)
    public String getZtytkhknkknkbn3() {
        return ztytkhknkknkbn3;
    }

    public void setZtytkhknkknkbn3(String pZtytkhknkknkbn3) {
        ztytkhknkknkbn3 = pZtytkhknkknkbn3;
    }

    private String ztytkhknkkn3;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHKNKKN3)
    public String getZtytkhknkkn3() {
        return ztytkhknkkn3;
    }

    public void setZtytkhknkkn3(String pZtytkhknkkn3) {
        ztytkhknkkn3 = pZtytkhknkkn3;
    }

    private String ztytkhrkkknkbn3;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHRKKKNKBN3)
    public String getZtytkhrkkknkbn3() {
        return ztytkhrkkknkbn3;
    }

    public void setZtytkhrkkknkbn3(String pZtytkhrkkknkbn3) {
        ztytkhrkkknkbn3 = pZtytkhrkkknkbn3;
    }

    private String ztytkhrkkkn3;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHRKKKN3)
    public String getZtytkhrkkkn3() {
        return ztytkhrkkkn3;
    }

    public void setZtytkhrkkkn3(String pZtytkhrkkkn3) {
        ztytkhrkkkn3 = pZtytkhrkkkn3;
    }

    private String ztykjtkhosyunm4;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKJTKHOSYUNM4)
    public String getZtykjtkhosyunm4() {
        return ztykjtkhosyunm4;
    }

    public void setZtykjtkhosyunm4(String pZtykjtkhosyunm4) {
        ztykjtkhosyunm4 = pZtykjtkhosyunm4;
    }

    private String ztytks4bsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKS4BSDIRTNHYKYK)
    public String getZtytks4bsdirtnhykyk() {
        return ztytks4bsdirtnhykyk;
    }

    public void setZtytks4bsdirtnhykyk(String pZtytks4bsdirtnhykyk) {
        ztytks4bsdirtnhykyk = pZtytks4bsdirtnhykyk;
    }

    private String ztytkhknkknkbn4;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHKNKKNKBN4)
    public String getZtytkhknkknkbn4() {
        return ztytkhknkknkbn4;
    }

    public void setZtytkhknkknkbn4(String pZtytkhknkknkbn4) {
        ztytkhknkknkbn4 = pZtytkhknkknkbn4;
    }

    private String ztytkhknkkn4;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHKNKKN4)
    public String getZtytkhknkkn4() {
        return ztytkhknkkn4;
    }

    public void setZtytkhknkkn4(String pZtytkhknkkn4) {
        ztytkhknkkn4 = pZtytkhknkkn4;
    }

    private String ztytkhrkkknkbn4;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHRKKKNKBN4)
    public String getZtytkhrkkknkbn4() {
        return ztytkhrkkknkbn4;
    }

    public void setZtytkhrkkknkbn4(String pZtytkhrkkknkbn4) {
        ztytkhrkkknkbn4 = pZtytkhrkkknkbn4;
    }

    private String ztytkhrkkkn4;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHRKKKN4)
    public String getZtytkhrkkkn4() {
        return ztytkhrkkkn4;
    }

    public void setZtytkhrkkkn4(String pZtytkhrkkkn4) {
        ztytkhrkkkn4 = pZtytkhrkkkn4;
    }

    private String ztykjtkhosyunm5;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKJTKHOSYUNM5)
    public String getZtykjtkhosyunm5() {
        return ztykjtkhosyunm5;
    }

    public void setZtykjtkhosyunm5(String pZtykjtkhosyunm5) {
        ztykjtkhosyunm5 = pZtykjtkhosyunm5;
    }

    private String ztytks5bsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKS5BSDIRTNHYKYK)
    public String getZtytks5bsdirtnhykyk() {
        return ztytks5bsdirtnhykyk;
    }

    public void setZtytks5bsdirtnhykyk(String pZtytks5bsdirtnhykyk) {
        ztytks5bsdirtnhykyk = pZtytks5bsdirtnhykyk;
    }

    private String ztytkhknkknkbn5;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHKNKKNKBN5)
    public String getZtytkhknkknkbn5() {
        return ztytkhknkknkbn5;
    }

    public void setZtytkhknkknkbn5(String pZtytkhknkknkbn5) {
        ztytkhknkknkbn5 = pZtytkhknkknkbn5;
    }

    private String ztytkhknkkn5;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHKNKKN5)
    public String getZtytkhknkkn5() {
        return ztytkhknkkn5;
    }

    public void setZtytkhknkkn5(String pZtytkhknkkn5) {
        ztytkhknkkn5 = pZtytkhknkkn5;
    }

    private String ztytkhrkkknkbn5;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHRKKKNKBN5)
    public String getZtytkhrkkknkbn5() {
        return ztytkhrkkknkbn5;
    }

    public void setZtytkhrkkknkbn5(String pZtytkhrkkknkbn5) {
        ztytkhrkkknkbn5 = pZtytkhrkkknkbn5;
    }

    private String ztytkhrkkkn5;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHRKKKN5)
    public String getZtytkhrkkkn5() {
        return ztytkhrkkkn5;
    }

    public void setZtytkhrkkkn5(String pZtytkhrkkkn5) {
        ztytkhrkkkn5 = pZtytkhrkkkn5;
    }

    private String ztykjtkhosyunm6;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKJTKHOSYUNM6)
    public String getZtykjtkhosyunm6() {
        return ztykjtkhosyunm6;
    }

    public void setZtykjtkhosyunm6(String pZtykjtkhosyunm6) {
        ztykjtkhosyunm6 = pZtykjtkhosyunm6;
    }

    private String ztytks6bsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKS6BSDIRTNHYKYK)
    public String getZtytks6bsdirtnhykyk() {
        return ztytks6bsdirtnhykyk;
    }

    public void setZtytks6bsdirtnhykyk(String pZtytks6bsdirtnhykyk) {
        ztytks6bsdirtnhykyk = pZtytks6bsdirtnhykyk;
    }

    private String ztytkhknkknkbn6;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHKNKKNKBN6)
    public String getZtytkhknkknkbn6() {
        return ztytkhknkknkbn6;
    }

    public void setZtytkhknkknkbn6(String pZtytkhknkknkbn6) {
        ztytkhknkknkbn6 = pZtytkhknkknkbn6;
    }

    private String ztytkhknkkn6;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHKNKKN6)
    public String getZtytkhknkkn6() {
        return ztytkhknkkn6;
    }

    public void setZtytkhknkkn6(String pZtytkhknkkn6) {
        ztytkhknkkn6 = pZtytkhknkkn6;
    }

    private String ztytkhrkkknkbn6;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHRKKKNKBN6)
    public String getZtytkhrkkknkbn6() {
        return ztytkhrkkknkbn6;
    }

    public void setZtytkhrkkknkbn6(String pZtytkhrkkknkbn6) {
        ztytkhrkkknkbn6 = pZtytkhrkkknkbn6;
    }

    private String ztytkhrkkkn6;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKHRKKKN6)
    public String getZtytkhrkkkn6() {
        return ztytkhrkkkn6;
    }

    public void setZtytkhrkkkn6(String pZtytkhrkkkn6) {
        ztytkhrkkkn6 = pZtytkhrkkkn6;
    }

    private String ztydatasyubetucd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYDATASYUBETUCD)
    public String getZtydatasyubetucd() {
        return ztydatasyubetucd;
    }

    public void setZtydatasyubetucd(String pZtydatasyubetucd) {
        ztydatasyubetucd = pZtydatasyubetucd;
    }

    private String ztyhjnkojinkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHJNKOJINKBN)
    public String getZtyhjnkojinkbn() {
        return ztyhjnkojinkbn;
    }

    public void setZtyhjnkojinkbn(String pZtyhjnkojinkbn) {
        ztyhjnkojinkbn = pZtyhjnkojinkbn;
    }

    private String ztykykadrkj50;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKYKADRKJ50)
    public String getZtykykadrkj50() {
        return ztykykadrkj50;
    }

    public void setZtykykadrkj50(String pZtykykadrkj50) {
        ztykykadrkj50 = pZtykykadrkj50;
    }

    private String ztykyknmkjbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKYKNMKJBSDIRTNHYKYK)
    public String getZtykyknmkjbsdirtnhykyk() {
        return ztykyknmkjbsdirtnhykyk;
    }

    public void setZtykyknmkjbsdirtnhykyk(String pZtykyknmkjbsdirtnhykyk) {
        ztykyknmkjbsdirtnhykyk = pZtykyknmkjbsdirtnhykyk;
    }

    private String ztykyksyaseiymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKYKSYASEIYMD)
    public String getZtykyksyaseiymd() {
        return ztykyksyaseiymd;
    }

    public void setZtykyksyaseiymd(String pZtykyksyaseiymd) {
        ztykyksyaseiymd = pZtykyksyaseiymd;
    }

    private String ztysakuseiym;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSAKUSEIYM)
    public String getZtysakuseiym() {
        return ztysakuseiym;
    }

    public void setZtysakuseiym(String pZtysakuseiym) {
        ztysakuseiym = pZtysakuseiym;
    }

    private String ztydairitencd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYDAIRITENCD)
    public String getZtydairitencd() {
        return ztydairitencd;
    }

    public void setZtydairitencd(String pZtydairitencd) {
        ztydairitencd = pZtydairitencd;
    }

    private String ztydairitenkanrisskcd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYDAIRITENKANRISSKCD)
    public String getZtydairitenkanrisskcd() {
        return ztydairitenkanrisskcd;
    }

    public void setZtydairitenkanrisskcd(String pZtydairitenkanrisskcd) {
        ztydairitenkanrisskcd = pZtydairitenkanrisskcd;
    }

    private String ztybosyuunincd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYBOSYUUNINCD)
    public String getZtybosyuunincd() {
        return ztybosyuunincd;
    }

    public void setZtybosyuunincd(String pZtybosyuunincd) {
        ztybosyuunincd = pZtybosyuunincd;
    }

    private String ztybosyuunm;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYBOSYUUNM)
    public String getZtybosyuunm() {
        return ztybosyuunm;
    }

    public void setZtybosyuunm(String pZtybosyuunm) {
        ztybosyuunm = pZtybosyuunm;
    }

    private String ztybosyuujtkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYBOSYUUJTKBN)
    public String getZtybosyuujtkbn() {
        return ztybosyuujtkbn;
    }

    public void setZtybosyuujtkbn(String pZtybosyuujtkbn) {
        ztybosyuujtkbn = pZtybosyuujtkbn;
    }

    private String ztydairitenkbtinfo1;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYDAIRITENKBTINFO1)
    public String getZtydairitenkbtinfo1() {
        return ztydairitenkbtinfo1;
    }

    public void setZtydairitenkbtinfo1(String pZtydairitenkbtinfo1) {
        ztydairitenkbtinfo1 = pZtydairitenkbtinfo1;
    }

    private String ztydairitenkbtinfo2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYDAIRITENKBTINFO2)
    public String getZtydairitenkbtinfo2() {
        return ztydairitenkbtinfo2;
    }

    public void setZtydairitenkbtinfo2(String pZtydairitenkbtinfo2) {
        ztydairitenkbtinfo2 = pZtydairitenkbtinfo2;
    }

    private String ztydairitenkbtinfo3;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYDAIRITENKBTINFO3)
    public String getZtydairitenkbtinfo3() {
        return ztydairitenkbtinfo3;
    }

    public void setZtydairitenkbtinfo3(String pZtydairitenkbtinfo3) {
        ztydairitenkbtinfo3 = pZtydairitenkbtinfo3;
    }

    private String ztysyouhinbunruikbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSYOUHINBUNRUIKBN)
    public String getZtysyouhinbunruikbn() {
        return ztysyouhinbunruikbn;
    }

    public void setZtysyouhinbunruikbn(String pZtysyouhinbunruikbn) {
        ztysyouhinbunruikbn = pZtysyouhinbunruikbn;
    }

    private String ztyhknnmcd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHKNNMCD)
    public String getZtyhknnmcd() {
        return ztyhknnmcd;
    }

    public void setZtyhknnmcd(String pZtyhknnmcd) {
        ztyhknnmcd = pZtyhknnmcd;
    }

    private String ztykykjyutikbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKYKJYUTIKBN)
    public String getZtykykjyutikbn() {
        return ztykykjyutikbn;
    }

    public void setZtykykjyutikbn(String pZtykykjyutikbn) {
        ztykykjyutikbn = pZtykykjyutikbn;
    }

    private String ztytkbthsyukiknmanryouym;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTKBTHSYUKIKNMANRYOUYM)
    public String getZtytkbthsyukiknmanryouym() {
        return ztytkbthsyukiknmanryouym;
    }

    public void setZtytkbthsyukiknmanryouym(String pZtytkbthsyukiknmanryouym) {
        ztytkbthsyukiknmanryouym = pZtytkbthsyukiknmanryouym;
    }

    private String ztyldownym;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYLDOWNYM)
    public String getZtyldownym() {
        return ztyldownym;
    }

    public void setZtyldownym(String pZtyldownym) {
        ztyldownym = pZtyldownym;
    }

    private String ztyhrkmanryouym;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHRKMANRYOUYM)
    public String getZtyhrkmanryouym() {
        return ztyhrkmanryouym;
    }

    public void setZtyhrkmanryouym(String pZtyhrkmanryouym) {
        ztyhrkmanryouym = pZtyhrkmanryouym;
    }

    private String ztymrtiksnym;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYMRTIKSNYM)
    public String getZtymrtiksnym() {
        return ztymrtiksnym;
    }

    public void setZtymrtiksnym(String pZtymrtiksnym) {
        ztymrtiksnym = pZtymrtiksnym;
    }

    private String ztyhaneikykhyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHANEIKYKHYJ)
    public String getZtyhaneikykhyj() {
        return ztyhaneikykhyj;
    }

    public void setZtyhaneikykhyj(String pZtyhaneikykhyj) {
        ztyhaneikykhyj = pZtyhaneikykhyj;
    }

    private String ztyzenzeikyohyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYZENZEIKYOHYJ)
    public String getZtyzenzeikyohyj() {
        return ztyzenzeikyohyj;
    }

    public void setZtyzenzeikyohyj(String pZtyzenzeikyohyj) {
        ztyzenzeikyohyj = pZtyzenzeikyohyj;
    }

    private String ztysikijikbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSIKIJIKBN)
    public String getZtysikijikbn() {
        return ztysikijikbn;
    }

    public void setZtysikijikbn(String pZtysikijikbn) {
        ztysikijikbn = pZtysikijikbn;
    }

    private String ztysbuktdisphukusuhyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSBUKTDISPHUKUSUHYJ)
    public String getZtysbuktdisphukusuhyj() {
        return ztysbuktdisphukusuhyj;
    }

    public void setZtysbuktdisphukusuhyj(String pZtysbuktdisphukusuhyj) {
        ztysbuktdisphukusuhyj = pZtysbuktdisphukusuhyj;
    }

    private String ztysbuktnmbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSBUKTNMBSDIRTNHYKYK)
    public String getZtysbuktnmbsdirtnhykyk() {
        return ztysbuktnmbsdirtnhykyk;
    }

    public void setZtysbuktnmbsdirtnhykyk(String pZtysbuktnmbsdirtnhykyk) {
        ztysbuktnmbsdirtnhykyk = pZtysbuktnmbsdirtnhykyk;
    }

    private String ztymnkuktdisphukusuhyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYMNKUKTDISPHUKUSUHYJ)
    public String getZtymnkuktdisphukusuhyj() {
        return ztymnkuktdisphukusuhyj;
    }

    public void setZtymnkuktdisphukusuhyj(String pZtymnkuktdisphukusuhyj) {
        ztymnkuktdisphukusuhyj = pZtymnkuktdisphukusuhyj;
    }

    private String ztymnkuktnmbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYMNKUKTNMBSDIRTNHYKYK)
    public String getZtymnkuktnmbsdirtnhykyk() {
        return ztymnkuktnmbsdirtnhykyk;
    }

    public void setZtymnkuktnmbsdirtnhykyk(String pZtymnkuktnmbsdirtnhykyk) {
        ztymnkuktnmbsdirtnhykyk = pZtymnkuktnmbsdirtnhykyk;
    }

    private String ztytodouhukencd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTODOUHUKENCD)
    public String getZtytodouhukencd() {
        return ztytodouhukencd;
    }

    public void setZtytodouhukencd(String pZtytodouhukencd) {
        ztytodouhukencd = pZtytodouhukencd;
    }

    private String ztybankcd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYBANKCD)
    public String getZtybankcd() {
        return ztybankcd;
    }

    public void setZtybankcd(String pZtybankcd) {
        ztybankcd = pZtybankcd;
    }

    private String ztyshitencd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSHITENCD)
    public String getZtyshitencd() {
        return ztyshitencd;
    }

    public void setZtyshitencd(String pZtyshitencd) {
        ztyshitencd = pZtyshitencd;
    }

    private String ztyyokinkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYYOKINKBN)
    public String getZtyyokinkbn() {
        return ztyyokinkbn;
    }

    public void setZtyyokinkbn(String pZtyyokinkbn) {
        ztyyokinkbn = pZtyyokinkbn;
    }

    private String ztykouzano7keta;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKOUZANO7KETA)
    public String getZtykouzano7keta() {
        return ztykouzano7keta;
    }

    public void setZtykouzano7keta(String pZtykouzano7keta) {
        ztykouzano7keta = pZtykouzano7keta;
    }

    private String ztyalcardkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYALCARDKBN)
    public String getZtyalcardkbn() {
        return ztyalcardkbn;
    }

    public void setZtyalcardkbn(String pZtyalcardkbn) {
        ztyalcardkbn = pZtyalcardkbn;
    }

    private Long ztysibous;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSIBOUS)
    public Long getZtysibous() {
        return ztysibous;
    }

    public void setZtysibous(Long pZtysibous) {
        ztysibous = pZtysibous;
    }

    private Long ztysgsbs;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSGSBS)
    public Long getZtysgsbs() {
        return ztysgsbs;
    }

    public void setZtysgsbs(Long pZtysgsbs) {
        ztysgsbs = pZtysgsbs;
    }

    private String ztysgwrmstksbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSGWRMSTKSBSDIRTNHYKYK)
    public String getZtysgwrmstksbsdirtnhykyk() {
        return ztysgwrmstksbsdirtnhykyk;
    }

    public void setZtysgwrmstksbsdirtnhykyk(String pZtysgwrmstksbsdirtnhykyk) {
        ztysgwrmstksbsdirtnhykyk = pZtysgwrmstksbsdirtnhykyk;
    }

    private String ztysyougaitkkatakbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSYOUGAITKKATAKBN)
    public String getZtysyougaitkkatakbn() {
        return ztysyougaitkkatakbn;
    }

    public void setZtysyougaitkkatakbn(String pZtysyougaitkkatakbn) {
        ztysyougaitkkatakbn = pZtysyougaitkkatakbn;
    }

    private String ztysyougaitksbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSYOUGAITKSBSDIRTNHYKYK)
    public String getZtysyougaitksbsdirtnhykyk() {
        return ztysyougaitksbsdirtnhykyk;
    }

    public void setZtysyougaitksbsdirtnhykyk(String pZtysyougaitksbsdirtnhykyk) {
        ztysyougaitksbsdirtnhykyk = pZtysyougaitksbsdirtnhykyk;
    }

    private String ztyreguardtksbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYREGUARDTKSBSDIRTNHYKYK)
    public String getZtyreguardtksbsdirtnhykyk() {
        return ztyreguardtksbsdirtnhykyk;
    }

    public void setZtyreguardtksbsdirtnhykyk(String pZtyreguardtksbsdirtnhykyk) {
        ztyreguardtksbsdirtnhykyk = pZtyreguardtksbsdirtnhykyk;
    }

    private String ztyreguardtkkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYREGUARDTKKBN)
    public String getZtyreguardtkkbn() {
        return ztyreguardtkkbn;
    }

    public void setZtyreguardtkkbn(String pZtyreguardtkkbn) {
        ztyreguardtkkbn = pZtyreguardtkkbn;
    }

    private String ztyvreguardtksbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYVREGUARDTKSBSDIRTNHYKYK)
    public String getZtyvreguardtksbsdirtnhykyk() {
        return ztyvreguardtksbsdirtnhykyk;
    }

    public void setZtyvreguardtksbsdirtnhykyk(String pZtyvreguardtksbsdirtnhykyk) {
        ztyvreguardtksbsdirtnhykyk = pZtyvreguardtksbsdirtnhykyk;
    }

    private String ztykzkmrthgukatakbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKZKMRTHGUKATAKBN)
    public String getZtykzkmrthgukatakbn() {
        return ztykzkmrthgukatakbn;
    }

    public void setZtykzkmrthgukatakbn(String pZtykzkmrthgukatakbn) {
        ztykzkmrthgukatakbn = pZtykzkmrthgukatakbn;
    }

    private String ztykzkmrthgusbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKZKMRTHGUSBSDIRTNHYKYK)
    public String getZtykzkmrthgusbsdirtnhykyk() {
        return ztykzkmrthgusbsdirtnhykyk;
    }

    public void setZtykzkmrthgusbsdirtnhykyk(String pZtykzkmrthgusbsdirtnhykyk) {
        ztykzkmrthgusbsdirtnhykyk = pZtykzkmrthgusbsdirtnhykyk;
    }

    private String ztykzkmrtkosbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKZKMRTKOSBSDIRTNHYKYK)
    public String getZtykzkmrtkosbsdirtnhykyk() {
        return ztykzkmrtkosbsdirtnhykyk;
    }

    public void setZtykzkmrtkosbsdirtnhykyk(String pZtykzkmrtkosbsdirtnhykyk) {
        ztykzkmrtkosbsdirtnhykyk = pZtykzkmrtkosbsdirtnhykyk;
    }

    private String ztykaneeztkarihyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKANEEZTKARIHYJ)
    public String getZtykaneeztkarihyj() {
        return ztykaneeztkarihyj;
    }

    public void setZtykaneeztkarihyj(String pZtykaneeztkarihyj) {
        ztykaneeztkarihyj = pZtykaneeztkarihyj;
    }

    private String ztydrtenkinyuucd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYDRTENKINYUUCD)
    public String getZtydrtenkinyuucd() {
        return ztydrtenkinyuucd;
    }

    public void setZtydrtenkinyuucd(String pZtydrtenkinyuucd) {
        ztydrtenkinyuucd = pZtydrtenkinyuucd;
    }

    private String ztydrtensitencd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYDRTENSITENCD)
    public String getZtydrtensitencd() {
        return ztydrtensitencd;
    }

    public void setZtydrtensitencd(String pZtydrtensitencd) {
        ztydrtensitencd = pZtydrtensitencd;
    }

    private String ztystjmkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSTJMKBN)
    public String getZtystjmkbn() {
        return ztystjmkbn;
    }

    public void setZtystjmkbn(String pZtystjmkbn) {
        ztystjmkbn = pZtystjmkbn;
    }

    private String ztysyokaiphrkkeiro;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSYOKAIPHRKKEIRO)
    public String getZtysyokaiphrkkeiro() {
        return ztysyokaiphrkkeiro;
    }

    public void setZtysyokaiphrkkeiro(String pZtysyokaiphrkkeiro) {
        ztysyokaiphrkkeiro = pZtysyokaiphrkkeiro;
    }

    private String ztycifcd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYCIFCD)
    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

    private String ztykanjidairitennm;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKANJIDAIRITENNM)
    public String getZtykanjidairitennm() {
        return ztykanjidairitennm;
    }

    public void setZtykanjidairitennm(String pZtykanjidairitennm) {
        ztykanjidairitennm = pZtykanjidairitennm;
    }

    private Long ztytsrybnwari;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTSRYBNWARI)
    public Long getZtytsrybnwari() {
        return ztytsrybnwari;
    }

    public void setZtytsrybnwari(Long pZtytsrybnwari) {
        ztytsrybnwari = pZtytsrybnwari;
    }

    private String ztydrtenkeijyouym;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYDRTENKEIJYOUYM)
    public String getZtydrtenkeijyouym() {
        return ztydrtenkeijyouym;
    }

    public void setZtydrtenkeijyouym(String pZtydrtenkeijyouym) {
        ztydrtenkeijyouym = pZtydrtenkeijyouym;
    }

    private String ztykydatkidairitencd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKYDATKIDAIRITENCD)
    public String getZtykydatkidairitencd() {
        return ztykydatkidairitencd;
    }

    public void setZtykydatkidairitencd(String pZtykydatkidairitencd) {
        ztykydatkidairitencd = pZtykydatkidairitencd;
    }

    private String ztymdhnsyouhntsryshrkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYMDHNSYOUHNTSRYSHRKBN)
    public String getZtymdhnsyouhntsryshrkbn() {
        return ztymdhnsyouhntsryshrkbn;
    }

    public void setZtymdhnsyouhntsryshrkbn(String pZtymdhnsyouhntsryshrkbn) {
        ztymdhnsyouhntsryshrkbn = pZtymdhnsyouhntsryshrkbn;
    }

    private String ztykyksyanen;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKYKSYANEN)
    public String getZtykyksyanen() {
        return ztykyksyanen;
    }

    public void setZtykyksyanen(String pZtykyksyanen) {
        ztykyksyanen = pZtykyksyanen;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztymdhnaisyoumeicd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYMDHNAISYOUMEICD)
    public String getZtymdhnaisyoumeicd() {
        return ztymdhnaisyoumeicd;
    }

    public void setZtymdhnaisyoumeicd(String pZtymdhnaisyoumeicd) {
        ztymdhnaisyoumeicd = pZtymdhnaisyoumeicd;
    }

    private String ztysyokaipryosyuymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSYOKAIPRYOSYUYMD)
    public String getZtysyokaipryosyuymd() {
        return ztysyokaipryosyuymd;
    }

    public void setZtysyokaipryosyuymd(String pZtysyokaipryosyuymd) {
        ztysyokaipryosyuymd = pZtysyokaipryosyuymd;
    }

    private String ztysykgycd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSYKGYCD)
    public String getZtysykgycd() {
        return ztysykgycd;
    }

    public void setZtysykgycd(String pZtysykgycd) {
        ztysykgycd = pZtysykgycd;
    }

    private BizNumber ztykaiyakuhrmkhritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKAIYAKUHRMKHRITU)
    public BizNumber getZtykaiyakuhrmkhritu() {
        return ztykaiyakuhrmkhritu;
    }

    public void setZtykaiyakuhrmkhritu(BizNumber pZtykaiyakuhrmkhritu) {
        ztykaiyakuhrmkhritu = pZtykaiyakuhrmkhritu;
    }

    private String ztytoutatukaiyakuhrmkhritu;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTOUTATUKAIYAKUHRMKHRITU)
    public String getZtytoutatukaiyakuhrmkhritu() {
        return ztytoutatukaiyakuhrmkhritu;
    }

    public void setZtytoutatukaiyakuhrmkhritu(String pZtytoutatukaiyakuhrmkhritu) {
        ztytoutatukaiyakuhrmkhritu = pZtytoutatukaiyakuhrmkhritu;
    }

    private String ztykaiyakuhrmkhtoutatuymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKAIYAKUHRMKHTOUTATUYMD)
    public String getZtykaiyakuhrmkhtoutatuymd() {
        return ztykaiyakuhrmkhtoutatuymd;
    }

    public void setZtykaiyakuhrmkhtoutatuymd(String pZtykaiyakuhrmkhtoutatuymd) {
        ztykaiyakuhrmkhtoutatuymd = pZtykaiyakuhrmkhtoutatuymd;
    }

    private String ztyanniskcd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYANNISKCD)
    public String getZtyanniskcd() {
        return ztyanniskcd;
    }

    public void setZtyanniskcd(String pZtyanniskcd) {
        ztyanniskcd = pZtyanniskcd;
    }

    private String ztyhjnkykhyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHJNKYKHYJ)
    public String getZtyhjnkykhyj() {
        return ztyhjnkykhyj;
    }

    public void setZtyhjnkykhyj(String pZtyhjnkykhyj) {
        ztyhjnkykhyj = pZtyhjnkykhyj;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztylivguardtkyks;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYLIVGUARDTKYKS)
    public String getZtylivguardtkyks() {
        return ztylivguardtkyks;
    }

    public void setZtylivguardtkyks(String pZtylivguardtkyks) {
        ztylivguardtkyks = pZtylivguardtkyks;
    }

    private Long ztysiteituukaitijibrp;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSITEITUUKAITIJIBRP)
    public Long getZtysiteituukaitijibrp() {
        return ztysiteituukaitijibrp;
    }

    public void setZtysiteituukaitijibrp(Long pZtysiteituukaitijibrp) {
        ztysiteituukaitijibrp = pZtysiteituukaitijibrp;
    }

    private Long ztysiteituukasyus;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSITEITUUKASYUS)
    public Long getZtysiteituukasyus() {
        return ztysiteituukasyus;
    }

    public void setZtysiteituukasyus(Long pZtysiteituukasyus) {
        ztysiteituukasyus = pZtysiteituukasyus;
    }

    private Long ztysiteituukasbs;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSITEITUUKASBS)
    public Long getZtysiteituukasbs() {
        return ztysiteituukasbs;
    }

    public void setZtysiteituukasbs(Long pZtysiteituukasbs) {
        ztysiteituukasbs = pZtysiteituukasbs;
    }

    private Long ztysiteituukasaigaisbs;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSITEITUUKASAIGAISBS)
    public Long getZtysiteituukasaigaisbs() {
        return ztysiteituukasaigaisbs;
    }

    public void setZtysiteituukasaigaisbs(Long pZtysiteituukasaigaisbs) {
        ztysiteituukasaigaisbs = pZtysiteituukasaigaisbs;
    }

    private String ztysiteituukacd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSITEITUUKACD)
    public String getZtysiteituukacd() {
        return ztysiteituukacd;
    }

    public void setZtysiteituukacd(String pZtysiteituukacd) {
        ztysiteituukacd = pZtysiteituukacd;
    }

    private Long ztyhrktuukaitijibrp;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHRKTUUKAITIJIBRP)
    public Long getZtyhrktuukaitijibrp() {
        return ztyhrktuukaitijibrp;
    }

    public void setZtyhrktuukaitijibrp(Long pZtyhrktuukaitijibrp) {
        ztyhrktuukaitijibrp = pZtyhrktuukaitijibrp;
    }

    private String ztyhrktuukacd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYHRKTUUKACD)
    public String getZtyhrktuukacd() {
        return ztyhrktuukacd;
    }

    public void setZtyhrktuukacd(String pZtyhrktuukacd) {
        ztyhrktuukacd = pZtyhrktuukacd;
    }

    private BizNumber ztytumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTUMITATERIRITU)
    public BizNumber getZtytumitateriritu() {
        return ztytumitateriritu;
    }

    public void setZtytumitateriritu(BizNumber pZtytumitateriritu) {
        ztytumitateriritu = pZtytumitateriritu;
    }

    private BizNumber ztytmttknzoukaritujygn;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTMTTKNZOUKARITUJYGN)
    public BizNumber getZtytmttknzoukaritujygn() {
        return ztytmttknzoukaritujygn;
    }

    public void setZtytmttknzoukaritujygn(BizNumber pZtytmttknzoukaritujygn) {
        ztytmttknzoukaritujygn = pZtytmttknzoukaritujygn;
    }

    private BizNumber ztysetteibairitu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYSETTEIBAIRITU)
    public BizNumber getZtysetteibairitu() {
        return ztysetteibairitu;
    }

    public void setZtysetteibairitu(BizNumber pZtysetteibairitu) {
        ztysetteibairitu = pZtysetteibairitu;
    }

    private Long ztytumitatekngk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTUMITATEKNGK)
    public Long getZtytumitatekngk() {
        return ztytumitatekngk;
    }

    public void setZtytumitatekngk(Long pZtytumitatekngk) {
        ztytumitatekngk = pZtytumitatekngk;
    }

    private String ztykjsbuktnm30;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKJSBUKTNM30)
    public String getZtykjsbuktnm30() {
        return ztykjsbuktnm30;
    }

    public void setZtykjsbuktnm30(String pZtykjsbuktnm30) {
        ztykjsbuktnm30 = pZtykjsbuktnm30;
    }

    private String ztymnkuktnm30;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYMNKUKTNM30)
    public String getZtymnkuktnm30() {
        return ztymnkuktnm30;
    }

    public void setZtymnkuktnm30(String pZtymnkuktnm30) {
        ztymnkuktnm30 = pZtymnkuktnm30;
    }

    private String ztykjkykdairinm;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKJKYKDAIRINM)
    public String getZtykjkykdairinm() {
        return ztykjkykdairinm;
    }

    public void setZtykjkykdairinm(String pZtykjkykdairinm) {
        ztykjkykdairinm = pZtykjkykdairinm;
    }

    private String ztykjsiteidairinm30;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYKJSITEIDAIRINM30)
    public String getZtykjsiteidairinm30() {
        return ztykjsiteidairinm30;
    }

    public void setZtykjsiteidairinm30(String pZtykjsiteidairinm30) {
        ztykjsiteidairinm30 = pZtykjsiteidairinm30;
    }

    private String ztytrkkzknmkj1;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTRKKZKNMKJ1)
    public String getZtytrkkzknmkj1() {
        return ztytrkkzknmkj1;
    }

    public void setZtytrkkzknmkj1(String pZtytrkkzknmkj1) {
        ztytrkkzknmkj1 = pZtytrkkzknmkj1;
    }

    private String ztytrkkzknmkj2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTRKKZKNMKJ2)
    public String getZtytrkkzknmkj2() {
        return ztytrkkzknmkj2;
    }

    public void setZtytrkkzknmkj2(String pZtytrkkzknmkj2) {
        ztytrkkzknmkj2 = pZtytrkkzknmkj2;
    }

    private String ztyikkatubaraikbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYIKKATUBARAIKBN)
    public String getZtyikkatubaraikbn() {
        return ztyikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyikkatubaraikbn(String pZtyikkatubaraikbn) {
        ztyikkatubaraikbn = pZtyikkatubaraikbn;
    }

    private String ztyikkatubaraikaisuu;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYIKKATUBARAIKAISUU)
    public String getZtyikkatubaraikaisuu() {
        return ztyikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyikkatubaraikaisuu(String pZtyikkatubaraikaisuu) {
        ztyikkatubaraikaisuu = pZtyikkatubaraikaisuu;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private BizNumber ztyrendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYRENDOURITU)
    public BizNumber getZtyrendouritu() {
        return ztyrendouritu;
    }

    public void setZtyrendouritu(BizNumber pZtyrendouritu) {
        ztyrendouritu = pZtyrendouritu;
    }

    private BizNumber ztyteikishrritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTEIKISHRRITU)
    public BizNumber getZtyteikishrritu() {
        return ztyteikishrritu;
    }

    public void setZtyteikishrritu(BizNumber pZtyteikishrritu) {
        ztyteikishrritu = pZtyteikishrritu;
    }

    private String ztytikskzuktnmkj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTIKSKZUKTNMKJ)
    public String getZtytikskzuktnmkj() {
        return ztytikskzuktnmkj;
    }

    public void setZtytikskzuktnmkj(String pZtytikskzuktnmkj) {
        ztytikskzuktnmkj = pZtytikskzuktnmkj;
    }

    private String ztytikskzbankcd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTIKSKZBANKCD)
    public String getZtytikskzbankcd() {
        return ztytikskzbankcd;
    }

    public void setZtytikskzbankcd(String pZtytikskzbankcd) {
        ztytikskzbankcd = pZtytikskzbankcd;
    }

    private String ztytikskzsitencd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTIKSKZSITENCD)
    public String getZtytikskzsitencd() {
        return ztytikskzsitencd;
    }

    public void setZtytikskzsitencd(String pZtytikskzsitencd) {
        ztytikskzsitencd = pZtytikskzsitencd;
    }

    private String ztytikskzyokinkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTIKSKZYOKINKBN)
    public String getZtytikskzyokinkbn() {
        return ztytikskzyokinkbn;
    }

    public void setZtytikskzyokinkbn(String pZtytikskzyokinkbn) {
        ztytikskzyokinkbn = pZtytikskzyokinkbn;
    }

    private String ztytikskzkouzano;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTIKSKZKOUZANO)
    public String getZtytikskzkouzano() {
        return ztytikskzkouzano;
    }

    public void setZtytikskzkouzano(String pZtytikskzkouzano) {
        ztytikskzkouzano = pZtytikskzkouzano;
    }

    private String ztytikskzkzmeiginmkn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTIKSKZKZMEIGINMKN)
    public String getZtytikskzkzmeiginmkn() {
        return ztytikskzkzmeiginmkn;
    }

    @DataConvert("toMultiByte")
    public void setZtytikskzkzmeiginmkn(String pZtytikskzkzmeiginmkn) {
        ztytikskzkzmeiginmkn = pZtytikskzkzmeiginmkn;
    }

    private String ztyteikishrkinshrtuukasyu;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYTEIKISHRKINSHRTUUKASYU)
    public String getZtyteikishrkinshrtuukasyu() {
        return ztyteikishrkinshrtuukasyu;
    }

    public void setZtyteikishrkinshrtuukasyu(String pZtyteikishrkinshrtuukasyu) {
        ztyteikishrkinshrtuukasyu = pZtyteikishrkinshrtuukasyu;
    }

    private String ztynnknsnpssyhknsyukigou;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYNNKNSNPSSYHKNSYUKIGOU)
    public String getZtynnknsnpssyhknsyukigou() {
        return ztynnknsnpssyhknsyukigou;
    }

    public void setZtynnknsnpssyhknsyukigou(String pZtynnknsnpssyhknsyukigou) {
        ztynnknsnpssyhknsyukigou = pZtynnknsnpssyhknsyukigou;
    }

    private String ztynnknsnpssyhknkkn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYNNKNSNPSSYHKNKKN)
    public String getZtynnknsnpssyhknkkn() {
        return ztynnknsnpssyhknkkn;
    }

    public void setZtynnknsnpssyhknkkn(String pZtynnknsnpssyhknkkn) {
        ztynnknsnpssyhknkkn = pZtynnknsnpssyhknkkn;
    }

    private String ztynnknsnpssyphrkkikn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYNNKNSNPSSYPHRKKIKN)
    public String getZtynnknsnpssyphrkkikn() {
        return ztynnknsnpssyphrkkikn;
    }

    public void setZtynnknsnpssyphrkkikn(String pZtynnknsnpssyphrkkikn) {
        ztynnknsnpssyphrkkikn = pZtynnknsnpssyphrkkikn;
    }

    private String ztynnknsnpssysaimnkkykhyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYNNKNSNPSSYSAIMNKKYKHYJ)
    public String getZtynnknsnpssysaimnkkykhyj() {
        return ztynnknsnpssysaimnkkykhyj;
    }

    public void setZtynnknsnpssysaimnkkykhyj(String pZtynnknsnpssysaimnkkykhyj) {
        ztynnknsnpssysaimnkkykhyj = pZtynnknsnpssysaimnkkykhyj;
    }

    private String ztynknsnpssyhrkkskbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYNKNSNPSSYHRKKSKBN)
    public String getZtynknsnpssyhrkkskbn() {
        return ztynknsnpssyhrkkskbn;
    }

    public void setZtynknsnpssyhrkkskbn(String pZtynknsnpssyhrkkskbn) {
        ztynknsnpssyhrkkskbn = pZtynknsnpssyhrkkskbn;
    }

    private String ztynnknsnpssyhhknnen;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYNNKNSNPSSYHHKNNEN)
    public String getZtynnknsnpssyhhknnen() {
        return ztynnknsnpssyhhknnen;
    }

    public void setZtynnknsnpssyhhknnen(String pZtynnknsnpssyhhknnen) {
        ztynnknsnpssyhhknnen = pZtynnknsnpssyhhknnen;
    }

    private BizNumber ztynnknsnpssyitijibrpkyktk;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYNNKNSNPSSYITIJIBRPKYKTK)
    public BizNumber getZtynnknsnpssyitijibrpkyktk() {
        return ztynnknsnpssyitijibrpkyktk;
    }

    public void setZtynnknsnpssyitijibrpkyktk(BizNumber pZtynnknsnpssyitijibrpkyktk) {
        ztynnknsnpssyitijibrpkyktk = pZtynnknsnpssyitijibrpkyktk;
    }

    private Long ztynnknsnpssysyup;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYNNKNSNPSSYSYUP)
    public Long getZtynnknsnpssysyup() {
        return ztynnknsnpssysyup;
    }

    public void setZtynnknsnpssysyup(Long pZtynnknsnpssysyup) {
        ztynnknsnpssysyup = pZtynnknsnpssysyup;
    }

    private BizNumber ztynnknsnpssykawaseraten5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYNNKNSNPSSYKAWASERATEN5)
    public BizNumber getZtynnknsnpssykawaseraten5() {
        return ztynnknsnpssykawaseraten5;
    }

    public void setZtynnknsnpssykawaseraten5(BizNumber pZtynnknsnpssykawaseraten5) {
        ztynnknsnpssykawaseraten5 = pZtynnknsnpssykawaseraten5;
    }

    private Long ztyzennoup;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYZENNOUP)
    public Long getZtyzennoup() {
        return ztyzennoup;
    }

    public void setZtyzennoup(Long pZtyzennoup) {
        ztyzennoup = pZtyzennoup;
    }

    private String ztyyobiv25;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykTy.ZTYYOBIV25)
    public String getZtyyobiv25() {
        return ztyyobiv25;
    }

    public void setZtyyobiv25(String pZtyyobiv25) {
        ztyyobiv25 = pZtyyobiv25;
    }
}
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
import yuyu.def.db.entity.ZT_BosyuuDrtenHoyuuKykRn;
import yuyu.def.db.id.PKZT_BosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.GenQZT_BosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.QZT_BosyuuDrtenHoyuuKykRn;

/**
 * 募集代理店保有契約Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_BosyuuDrtenHoyuuKykRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_BosyuuDrtenHoyuuKykRn}</td><td colspan="3">募集代理店保有契約Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrndatasyurui zrndatasyurui}</td><td>（連携用）データ種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyumoku zrnhknsyumoku}</td><td>（連携用）保険種目</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyoubokbn zrntyoubokbn}</td><td>（連携用）帳簿区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyonosyuban zrnsyonosyuban}</td><td>（連携用）証券番号主番</td><td align="center">{@link PKZT_BosyuuDrtenHoyuuKykRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyurui2keta zrnhknsyurui2keta}</td><td>（連携用）保険種類（２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkhuhukbn zrnhrkhuhukbn}</td><td>（連携用）払込方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukinkbn zrnsyukinkbn}</td><td>（連携用）集金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnkaisuu zrnbnkaisuu}</td><td>（連携用）分割回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyouhocd zrnkyouhocd}</td><td>（連携用）共保コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaibuncd zrndaibuncd}</td><td>（連携用）代分コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaibunkanjishare zrndaibunkanjishare}</td><td>（連携用）代分幹事分シェア</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndntcd7keta zrndntcd7keta}</td><td>（連携用）団体コード（７桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyumokugrpkbn zrnsyumokugrpkbn}</td><td>（連携用）種目グループ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeipbsdirtnhykyk zrngoukeipbsdirtnhykyk}</td><td>（連携用）合計保険料（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyno7keta zrnyno7keta}</td><td>（連携用）郵便番号（７桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikiymd zrnsikiymd}</td><td>（連携用）始期年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmankiymd zrnmankiymd}</td><td>（連携用）満期年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidokaiyakuymd zrnidokaiyakuymd}</td><td>（連携用）異動解約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmusymd zrnmusymd}</td><td>（連携用）申込年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikokykhyj zrnjikokykhyj}</td><td>（連携用）自己契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmeisaioyakokbn zrnmeisaioyakokbn}</td><td>（連携用）明細親子区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihontikucdkami3 zrnkihontikucdkami3}</td><td>（連携用）基本地区コード上３桁</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2 zrnyobiv2}</td><td>（連携用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntelnobsdirtnhykyk zrntelnobsdirtnhykyk}</td><td>（連携用）電話番号（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmknbsdirtnhykyk zrnkyknmknbsdirtnhykyk}</td><td>（連携用）契約者名（カナ）（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnkyk1kaipbsdirtnhykyk zrnbnkyk1kaipbsdirtnhykyk}</td><td>（連携用）分割払契約１回分保険料（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnsyuruikbn zrnbnsyuruikbn}</td><td>（連携用）分割種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkymd zrnhrkymd}</td><td>（連携用）払込日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndntfsthrkym zrndntfsthrkym}</td><td>（連携用）団体扱初回払込年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstpkzhurikbn zrnfstpkzhurikbn}</td><td>（連携用）初回保険料口座振替区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeijyouym4keta zrnkeijyouym4keta}</td><td>（連携用）計上年月（４桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkaisyacd zrnhknkaisyacd}</td><td>（連携用）保険会社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmknbsdirtnhykyk zrnhhknnmknbsdirtnhykyk}</td><td>（連携用）被保険者名（カナ）（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjhhknmei zrnknjhhknmei}</td><td>（連携用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseiymd zrnhhknseiymd}</td><td>（連携用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnenbsdirtnhykyk zrnhhknnenbsdirtnhykyk}</td><td>（連携用）被保険者年令（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkntdk zrnhhkntdk}</td><td>（連携用）被保険者続柄</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknynobsdirtnhykyk zrnhhknynobsdirtnhykyk}</td><td>（連携用）被保険者郵便番号（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknadrkj50 zrnhhknadrkj50}</td><td>（連携用）被保険者漢字住所５０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeiro zrnhrkkeiro}</td><td>（連携用）払込経路</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijibrpbsdirtnhykyk zrnitijibrpbsdirtnhykyk}</td><td>（連携用）一時払保険料（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrkknkbn zrnnkshrkknkbn}</td><td>（連携用）年金支払期間区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrkknnen zrnnkshrkknnen}</td><td>（連携用）年金支払期間年</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrstartymd zrnnkshrstartymd}</td><td>（連携用）年金支払開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokutaiumu zrntokutaiumu}</td><td>（連携用）特体有無</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntktyuutohuka zrntktyuutohuka}</td><td>（連携用）特約中途付加</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksuu zrntksuu}</td><td>（連携用）特約数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinsakbn zrnsinsakbn}</td><td>（連携用）診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeiseitekikaku zrnzeiseitekikaku}</td><td>（連携用）税制適格</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlivingneeds zrnlivingneeds}</td><td>（連携用）リビングニーズ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjsyuhsynm zrnknjsyuhsynm}</td><td>（連携用）漢字主契約保種名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyusbsdirtnhykyk zrnsyusbsdirtnhykyk}</td><td>（連携用）主契約保険金額（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuhknkknkbn zrnsyuhknkknkbn}</td><td>（連携用）主契約保険期間区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuhknkkn zrnsyuhknkkn}</td><td>（連携用）主契約保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuhrkkknkbn zrnsyuhrkkknkbn}</td><td>（連携用）主契約払込期間区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuhrkkkn zrnsyuhrkkkn}</td><td>（連携用）主契約払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjtkhosyunm1 zrnkjtkhosyunm1}</td><td>（連携用）漢字特約保種名１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntks1bsdirtnhykyk zrntks1bsdirtnhykyk}</td><td>（連携用）特約保険金額１（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkknkbn1 zrntkhknkknkbn1}</td><td>（連携用）特約保険期間区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkkn1 zrntkhknkkn1}</td><td>（連携用）特約保険期間１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkknkbn1 zrntkhrkkknkbn1}</td><td>（連携用）特約払込期間区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkkn1 zrntkhrkkkn1}</td><td>（連携用）特約払込期間１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjtkhosyunm2 zrnkjtkhosyunm2}</td><td>（連携用）漢字特約保種名２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntks2bsdirtnhykyk zrntks2bsdirtnhykyk}</td><td>（連携用）特約保険金額２（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkknkbn2 zrntkhknkknkbn2}</td><td>（連携用）特約保険期間区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkkn2 zrntkhknkkn2}</td><td>（連携用）特約保険期間２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkknkbn2 zrntkhrkkknkbn2}</td><td>（連携用）特約払込期間区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkkn2 zrntkhrkkkn2}</td><td>（連携用）特約払込期間２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjtkhosyunm3 zrnkjtkhosyunm3}</td><td>（連携用）漢字特約保種名３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntks3bsdirtnhykyk zrntks3bsdirtnhykyk}</td><td>（連携用）特約保険金額３（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkknkbn3 zrntkhknkknkbn3}</td><td>（連携用）特約保険期間区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkkn3 zrntkhknkkn3}</td><td>（連携用）特約保険期間３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkknkbn3 zrntkhrkkknkbn3}</td><td>（連携用）特約払込期間区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkkn3 zrntkhrkkkn3}</td><td>（連携用）特約払込期間３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjtkhosyunm4 zrnkjtkhosyunm4}</td><td>（連携用）漢字特約保種名４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntks4bsdirtnhykyk zrntks4bsdirtnhykyk}</td><td>（連携用）特約保険金額４（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkknkbn4 zrntkhknkknkbn4}</td><td>（連携用）特約保険期間区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkkn4 zrntkhknkkn4}</td><td>（連携用）特約保険期間４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkknkbn4 zrntkhrkkknkbn4}</td><td>（連携用）特約払込期間区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkkn4 zrntkhrkkkn4}</td><td>（連携用）特約払込期間４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjtkhosyunm5 zrnkjtkhosyunm5}</td><td>（連携用）漢字特約保種名５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntks5bsdirtnhykyk zrntks5bsdirtnhykyk}</td><td>（連携用）特約保険金額５（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkknkbn5 zrntkhknkknkbn5}</td><td>（連携用）特約保険期間区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkkn5 zrntkhknkkn5}</td><td>（連携用）特約保険期間５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkknkbn5 zrntkhrkkknkbn5}</td><td>（連携用）特約払込期間区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkkn5 zrntkhrkkkn5}</td><td>（連携用）特約払込期間５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjtkhosyunm6 zrnkjtkhosyunm6}</td><td>（連携用）漢字特約保種名６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntks6bsdirtnhykyk zrntks6bsdirtnhykyk}</td><td>（連携用）特約保険金額６（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkknkbn6 zrntkhknkknkbn6}</td><td>（連携用）特約保険期間区分６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkkn6 zrntkhknkkn6}</td><td>（連携用）特約保険期間６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkknkbn6 zrntkhrkkknkbn6}</td><td>（連携用）特約払込期間区分６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkkn6 zrntkhrkkkn6}</td><td>（連携用）特約払込期間６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatasyubetucd zrndatasyubetucd}</td><td>（連携用）データ種別コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjnkojinkbn zrnhjnkojinkbn}</td><td>（連携用）法人個人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykadrkj50 zrnkykadrkj50}</td><td>（連携用）契約者漢字住所５０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkjbsdirtnhykyk zrnkyknmkjbsdirtnhykyk}</td><td>（連携用）契約者名(漢字）（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseiymd zrnkyksyaseiymd}</td><td>（連携用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseiym zrnsakuseiym}</td><td>（連携用）作成年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitencd zrndairitencd}</td><td>（連携用）代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenkanrisskcd zrndairitenkanrisskcd}</td><td>（連携用）代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuunincd zrnbosyuunincd}</td><td>（連携用）募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuunm zrnbosyuunm}</td><td>（連携用）募集人氏名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuujtkbn zrnbosyuujtkbn}</td><td>（連携用）募集人状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenkbtinfo1 zrndairitenkbtinfo1}</td><td>（連携用）代理店個別情報１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenkbtinfo2 zrndairitenkbtinfo2}</td><td>（連携用）代理店個別情報２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenkbtinfo3 zrndairitenkbtinfo3}</td><td>（連携用）代理店個別情報３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyouhinbunruikbn zrnsyouhinbunruikbn}</td><td>（連携用）商品分類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknnmcd zrnhknnmcd}</td><td>（連携用）保険名称コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjyutikbn zrnkykjyutikbn}</td><td>（連携用）契約状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkbthsyukiknmanryouym zrntkbthsyukiknmanryouym}</td><td>（連携用）特別保障期間満了年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnldownym zrnldownym}</td><td>（連携用）Ｌダウン年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkmanryouym zrnhrkmanryouym}</td><td>（連携用）払込満了年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrtiksnym zrnmrtiksnym}</td><td>（連携用）マル定更新年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaneikykhyj zrnhaneikykhyj}</td><td>（連携用）繁栄契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenzeikyohyj zrnzenzeikyohyj}</td><td>（連携用）全税共表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikijikbn zrnsikijikbn}</td><td>（連携用）職事区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktdisphukusuhyj zrnsbuktdisphukusuhyj}</td><td>（連携用）死亡受取人複数表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktnmbsdirtnhykyk zrnsbuktnmbsdirtnhykyk}</td><td>（連携用）死亡受取人名（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnkuktdisphukusuhyj zrnmnkuktdisphukusuhyj}</td><td>（連携用）満期受取人複数表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnkuktnmbsdirtnhykyk zrnmnkuktnmbsdirtnhykyk}</td><td>（連携用）満期受取人名（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntodouhukencd zrntodouhukencd}</td><td>（連携用）都道府県コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbankcd zrnbankcd}</td><td>（連携用）銀行番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshitencd zrnshitencd}</td><td>（連携用）支店番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyokinkbn zrnyokinkbn}</td><td>（連携用）預金種目区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouzano7keta zrnkouzano7keta}</td><td>（連携用）口座番号（７桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnalcardkbn zrnalcardkbn}</td><td>（連携用）ＡＬカード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsibous zrnsibous}</td><td>（連携用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsgsbs zrnsgsbs}</td><td>（連携用）災害死亡S</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsgwrmstksbsdirtnhykyk zrnsgwrmstksbsdirtnhykyk}</td><td>（連携用）災害割増特約Ｓ（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyougaitkkatakbn zrnsyougaitkkatakbn}</td><td>（連携用）傷害特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyougaitksbsdirtnhykyk zrnsyougaitksbsdirtnhykyk}</td><td>（連携用）傷害特約Ｓ（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnreguardtksbsdirtnhykyk zrnreguardtksbsdirtnhykyk}</td><td>（連携用）リガード特約Ｓ（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnreguardtkkbn zrnreguardtkkbn}</td><td>（連携用）リガード特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvreguardtksbsdirtnhykyk zrnvreguardtksbsdirtnhykyk}</td><td>（連携用）Ｖガード特約Ｓ（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrthgukatakbn zrnkzkmrthgukatakbn}</td><td>（連携用）家族マル定配偶者型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrthgusbsdirtnhykyk zrnkzkmrthgusbsdirtnhykyk}</td><td>（連携用）家族マル定配偶者Ｓ（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtkosbsdirtnhykyk zrnkzkmrtkosbsdirtnhykyk}</td><td>（連携用）家族マル定子Ｓ（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaneeztkarihyj zrnkaneeztkarihyj}</td><td>（連携用）ケアニーズ特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtenkinyuucd zrndrtenkinyuucd}</td><td>（連携用）代理店金融機関コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensitencd zrndrtensitencd}</td><td>（連携用）代理店支店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstjmkbn zrnstjmkbn}</td><td>（連携用）集中事務組織区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaiphrkkeiro zrnsyokaiphrkkeiro}</td><td>（連携用）初回Ｐ払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncifcd zrncifcd}</td><td>（連携用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjidairitennm zrnkanjidairitennm}</td><td>（連携用）漢字代理店名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsrybnwari zrntsrybnwari}</td><td>（連携用）手数料分割割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndrtenkeijyouym zrndrtenkeijyouym}</td><td>（連携用）代理店計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkydatkidairitencd zrnkydatkidairitencd}</td><td>（連携用）共同扱代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmdhnsyouhntsryshrkbn zrnmdhnsyouhntsryshrkbn}</td><td>（連携用）窓販商品手数料支払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyanen zrnkyksyanen}</td><td>（連携用）契約者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmdhnaisyoumeicd zrnmdhnaisyoumeicd}</td><td>（連携用）窓販用愛称名コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaipryosyuymd zrnsyokaipryosyuymd}</td><td>（連携用）初回Ｐ領収年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykgycd zrnsykgycd}</td><td>（連携用）職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiyakuhrmkhritu zrnkaiyakuhrmkhritu}</td><td>（連携用）解約返戻金目標率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoutatukaiyakuhrmkhritu zrntoutatukaiyakuhrmkhritu}</td><td>（連携用）到達解約返戻金目標率（募集代理店保有契約）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiyakuhrmkhtoutatuymd zrnkaiyakuhrmkhtoutatuymd}</td><td>（連携用）解約返戻金目標到達年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnanniskcd zrnanniskcd}</td><td>（連携用）案内先コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjnkykhyj zrnhjnkykhyj}</td><td>（連携用）法人契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlivguardtkyks zrnlivguardtkyks}</td><td>（連携用）ＬｉＶガード特約Ｓ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteituukaitijibrp zrnsiteituukaitijibrp}</td><td>（連携用）指定通貨建一時払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiteituukasyus zrnsiteituukasyus}</td><td>（連携用）指定通貨建主契約保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiteituukasbs zrnsiteituukasbs}</td><td>（連携用）指定通貨建死亡保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiteituukasaigaisbs zrnsiteituukasaigaisbs}</td><td>（連携用）指定通貨建災害死亡保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiteituukacd zrnsiteituukacd}</td><td>（連携用）指定通貨コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrktuukaitijibrp zrnhrktuukaitijibrp}</td><td>（連携用）払込通貨建一時払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhrktuukacd zrnhrktuukacd}</td><td>（連携用）払込通貨コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntumitateriritu zrntumitateriritu}</td><td>（連携用）積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritujygn zrntmttknzoukaritujygn}</td><td>（連携用）積立金増加率上限</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsetteibairitu zrnsetteibairitu}</td><td>（連携用）設定倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntumitatekngk zrntumitatekngk}</td><td>（連携用）積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkjsbuktnm30 zrnkjsbuktnm30}</td><td>（連携用）漢字死亡受取人名３０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnkuktnm30 zrnmnkuktnm30}</td><td>（連携用）漢字満期受取人名３０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkykdairinm zrnkjkykdairinm}</td><td>（連携用）漢字契約者代理人名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjsiteidairinm30 zrnkjsiteidairinm30}</td><td>（連携用）漢字指定代理人名３０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzknmkj1 zrntrkkzknmkj1}</td><td>（連携用）登録家族名（漢字）１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzknmkj2 zrntrkkzknmkj2}</td><td>（連携用）登録家族名（漢字）２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikbn zrnikkatubaraikbn}</td><td>（連携用）一括払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikaisuu zrnikkatubaraikaisuu}</td><td>（連携用）一括払回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouritu zrnrendouritu}</td><td>（連携用）連動率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnteikishrritu zrnteikishrritu}</td><td>（連携用）定期支払率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntikskzuktnmkj zrntikskzuktnmkj}</td><td>（連携用）定期支払金受取人名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntikskzbankcd zrntikskzbankcd}</td><td>（連携用）定期支払金受取口座銀行コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntikskzsitencd zrntikskzsitencd}</td><td>（連携用）定期支払金受取口座支店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntikskzyokinkbn zrntikskzyokinkbn}</td><td>（連携用）定期支払金受取口座預金種目区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntikskzkouzano zrntikskzkouzano}</td><td>（連携用）定期支払金受取口座番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntikskzkzmeiginmkn zrntikskzkzmeiginmkn}</td><td>（連携用）定期支払金受取口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikishrkinshrtuukasyu zrnteikishrkinshrtuukasyu}</td><td>（連携用）定期支払金支払通貨</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnnknsnpssyhknsyukigou zrnnnknsnpssyhknsyukigou}</td><td>（連携用）年換算Ｐ算出用保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnnknsnpssyhknkkn zrnnnknsnpssyhknkkn}</td><td>（連携用）年換算Ｐ算出用保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnnknsnpssyphrkkikn zrnnnknsnpssyphrkkikn}</td><td>（連携用）年換算Ｐ算出用Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnnknsnpssysaimnkkykhyj zrnnnknsnpssysaimnkkykhyj}</td><td>（連携用）年換算Ｐ算出用才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknsnpssyhrkkskbn zrnnknsnpssyhrkkskbn}</td><td>（連携用）年換算Ｐ算出用払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnnknsnpssyhhknnen zrnnnknsnpssyhhknnen}</td><td>（連携用）年換算Ｐ算出用被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnnknsnpssyitijibrpkyktk zrnnnknsnpssyitijibrpkyktk}</td><td>（連携用）年換算Ｐ算出用一時払Ｐ（契約通貨建）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnnnknsnpssysyup zrnnnknsnpssysyup}</td><td>（連携用）年換算Ｐ算出用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnnknsnpssykawaseraten5 zrnnnknsnpssykawaseraten5}</td><td>（連携用）年換算Ｐ算出用為替レートＮ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzennoup zrnzennoup}</td><td>（連携用）前納保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv25 zrnyobiv25}</td><td>（連携用）予備項目Ｖ２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_BosyuuDrtenHoyuuKykRn
 * @see     PKZT_BosyuuDrtenHoyuuKykRn
 * @see     QZT_BosyuuDrtenHoyuuKykRn
 * @see     GenQZT_BosyuuDrtenHoyuuKykRn
 */
@MappedSuperclass
@Table(name=GenZT_BosyuuDrtenHoyuuKykRn.TABLE_NAME)
@IdClass(value=PKZT_BosyuuDrtenHoyuuKykRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_BosyuuDrtenHoyuuKykRn extends AbstractExDBEntityForZDB<ZT_BosyuuDrtenHoyuuKykRn, PKZT_BosyuuDrtenHoyuuKykRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_BosyuuDrtenHoyuuKykRn";
    public static final String ZRNDATASYURUI            = "zrndatasyurui";
    public static final String ZRNHKNSYUMOKU            = "zrnhknsyumoku";
    public static final String ZRNTYOUBOKBN             = "zrntyoubokbn";
    public static final String ZRNSYONOSYUBAN           = "zrnsyonosyuban";
    public static final String ZRNHKNSYURUI2KETA        = "zrnhknsyurui2keta";
    public static final String ZRNHRKHUHUKBN            = "zrnhrkhuhukbn";
    public static final String ZRNSYUKINKBN             = "zrnsyukinkbn";
    public static final String ZRNBNKAISUU              = "zrnbnkaisuu";
    public static final String ZRNKYOUHOCD              = "zrnkyouhocd";
    public static final String ZRNDAIBUNCD              = "zrndaibuncd";
    public static final String ZRNDAIBUNKANJISHARE      = "zrndaibunkanjishare";
    public static final String ZRNDNTCD7KETA            = "zrndntcd7keta";
    public static final String ZRNSYUMOKUGRPKBN         = "zrnsyumokugrpkbn";
    public static final String ZRNGOUKEIPBSDIRTNHYKYK   = "zrngoukeipbsdirtnhykyk";
    public static final String ZRNYNO7KETA              = "zrnyno7keta";
    public static final String ZRNSIKIYMD               = "zrnsikiymd";
    public static final String ZRNMANKIYMD              = "zrnmankiymd";
    public static final String ZRNIDOKAIYAKUYMD         = "zrnidokaiyakuymd";
    public static final String ZRNMUSYMD                = "zrnmusymd";
    public static final String ZRNJIKOKYKHYJ            = "zrnjikokykhyj";
    public static final String ZRNMEISAIOYAKOKBN        = "zrnmeisaioyakokbn";
    public static final String ZRNKIHONTIKUCDKAMI3      = "zrnkihontikucdkami3";
    public static final String ZRNYOBIV2                = "zrnyobiv2";
    public static final String ZRNTELNOBSDIRTNHYKYK     = "zrntelnobsdirtnhykyk";
    public static final String ZRNKYKNMKNBSDIRTNHYKYK   = "zrnkyknmknbsdirtnhykyk";
    public static final String ZRNBNKYK1KAIPBSDIRTNHYKYK = "zrnbnkyk1kaipbsdirtnhykyk";
    public static final String ZRNBNSYURUIKBN           = "zrnbnsyuruikbn";
    public static final String ZRNHRKYMD                = "zrnhrkymd";
    public static final String ZRNDNTFSTHRKYM           = "zrndntfsthrkym";
    public static final String ZRNFSTPKZHURIKBN         = "zrnfstpkzhurikbn";
    public static final String ZRNKEIJYOUYM4KETA        = "zrnkeijyouym4keta";
    public static final String ZRNHKNKAISYACD           = "zrnhknkaisyacd";
    public static final String ZRNHHKNNMKNBSDIRTNHYKYK  = "zrnhhknnmknbsdirtnhykyk";
    public static final String ZRNKNJHHKNMEI            = "zrnknjhhknmei";
    public static final String ZRNHHKNSEIYMD            = "zrnhhknseiymd";
    public static final String ZRNHHKNNENBSDIRTNHYKYK   = "zrnhhknnenbsdirtnhykyk";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHHKNTDK               = "zrnhhkntdk";
    public static final String ZRNHHKNYNOBSDIRTNHYKYK   = "zrnhhknynobsdirtnhykyk";
    public static final String ZRNHHKNADRKJ50           = "zrnhhknadrkj50";
    public static final String ZRNHRKKEIRO              = "zrnhrkkeiro";
    public static final String ZRNITIJIBRPBSDIRTNHYKYK  = "zrnitijibrpbsdirtnhykyk";
    public static final String ZRNNKSHRKKNKBN           = "zrnnkshrkknkbn";
    public static final String ZRNNKSHRKKNNEN           = "zrnnkshrkknnen";
    public static final String ZRNNKSHRSTARTYMD         = "zrnnkshrstartymd";
    public static final String ZRNTOKUTAIUMU            = "zrntokutaiumu";
    public static final String ZRNTKTYUUTOHUKA          = "zrntktyuutohuka";
    public static final String ZRNTKSUU                 = "zrntksuu";
    public static final String ZRNSINSAKBN              = "zrnsinsakbn";
    public static final String ZRNZEISEITEKIKAKU        = "zrnzeiseitekikaku";
    public static final String ZRNLIVINGNEEDS           = "zrnlivingneeds";
    public static final String ZRNKNJSYUHSYNM           = "zrnknjsyuhsynm";
    public static final String ZRNSYUSBSDIRTNHYKYK      = "zrnsyusbsdirtnhykyk";
    public static final String ZRNSYUHKNKKNKBN          = "zrnsyuhknkknkbn";
    public static final String ZRNSYUHKNKKN             = "zrnsyuhknkkn";
    public static final String ZRNSYUHRKKKNKBN          = "zrnsyuhrkkknkbn";
    public static final String ZRNSYUHRKKKN             = "zrnsyuhrkkkn";
    public static final String ZRNKJTKHOSYUNM1          = "zrnkjtkhosyunm1";
    public static final String ZRNTKS1BSDIRTNHYKYK      = "zrntks1bsdirtnhykyk";
    public static final String ZRNTKHKNKKNKBN1          = "zrntkhknkknkbn1";
    public static final String ZRNTKHKNKKN1             = "zrntkhknkkn1";
    public static final String ZRNTKHRKKKNKBN1          = "zrntkhrkkknkbn1";
    public static final String ZRNTKHRKKKN1             = "zrntkhrkkkn1";
    public static final String ZRNKJTKHOSYUNM2          = "zrnkjtkhosyunm2";
    public static final String ZRNTKS2BSDIRTNHYKYK      = "zrntks2bsdirtnhykyk";
    public static final String ZRNTKHKNKKNKBN2          = "zrntkhknkknkbn2";
    public static final String ZRNTKHKNKKN2             = "zrntkhknkkn2";
    public static final String ZRNTKHRKKKNKBN2          = "zrntkhrkkknkbn2";
    public static final String ZRNTKHRKKKN2             = "zrntkhrkkkn2";
    public static final String ZRNKJTKHOSYUNM3          = "zrnkjtkhosyunm3";
    public static final String ZRNTKS3BSDIRTNHYKYK      = "zrntks3bsdirtnhykyk";
    public static final String ZRNTKHKNKKNKBN3          = "zrntkhknkknkbn3";
    public static final String ZRNTKHKNKKN3             = "zrntkhknkkn3";
    public static final String ZRNTKHRKKKNKBN3          = "zrntkhrkkknkbn3";
    public static final String ZRNTKHRKKKN3             = "zrntkhrkkkn3";
    public static final String ZRNKJTKHOSYUNM4          = "zrnkjtkhosyunm4";
    public static final String ZRNTKS4BSDIRTNHYKYK      = "zrntks4bsdirtnhykyk";
    public static final String ZRNTKHKNKKNKBN4          = "zrntkhknkknkbn4";
    public static final String ZRNTKHKNKKN4             = "zrntkhknkkn4";
    public static final String ZRNTKHRKKKNKBN4          = "zrntkhrkkknkbn4";
    public static final String ZRNTKHRKKKN4             = "zrntkhrkkkn4";
    public static final String ZRNKJTKHOSYUNM5          = "zrnkjtkhosyunm5";
    public static final String ZRNTKS5BSDIRTNHYKYK      = "zrntks5bsdirtnhykyk";
    public static final String ZRNTKHKNKKNKBN5          = "zrntkhknkknkbn5";
    public static final String ZRNTKHKNKKN5             = "zrntkhknkkn5";
    public static final String ZRNTKHRKKKNKBN5          = "zrntkhrkkknkbn5";
    public static final String ZRNTKHRKKKN5             = "zrntkhrkkkn5";
    public static final String ZRNKJTKHOSYUNM6          = "zrnkjtkhosyunm6";
    public static final String ZRNTKS6BSDIRTNHYKYK      = "zrntks6bsdirtnhykyk";
    public static final String ZRNTKHKNKKNKBN6          = "zrntkhknkknkbn6";
    public static final String ZRNTKHKNKKN6             = "zrntkhknkkn6";
    public static final String ZRNTKHRKKKNKBN6          = "zrntkhrkkknkbn6";
    public static final String ZRNTKHRKKKN6             = "zrntkhrkkkn6";
    public static final String ZRNDATASYUBETUCD         = "zrndatasyubetucd";
    public static final String ZRNHJNKOJINKBN           = "zrnhjnkojinkbn";
    public static final String ZRNKYKADRKJ50            = "zrnkykadrkj50";
    public static final String ZRNKYKNMKJBSDIRTNHYKYK   = "zrnkyknmkjbsdirtnhykyk";
    public static final String ZRNKYKSYASEIYMD          = "zrnkyksyaseiymd";
    public static final String ZRNSAKUSEIYM             = "zrnsakuseiym";
    public static final String ZRNDAIRITENCD            = "zrndairitencd";
    public static final String ZRNDAIRITENKANRISSKCD    = "zrndairitenkanrisskcd";
    public static final String ZRNBOSYUUNINCD           = "zrnbosyuunincd";
    public static final String ZRNBOSYUUNM              = "zrnbosyuunm";
    public static final String ZRNBOSYUUJTKBN           = "zrnbosyuujtkbn";
    public static final String ZRNDAIRITENKBTINFO1      = "zrndairitenkbtinfo1";
    public static final String ZRNDAIRITENKBTINFO2      = "zrndairitenkbtinfo2";
    public static final String ZRNDAIRITENKBTINFO3      = "zrndairitenkbtinfo3";
    public static final String ZRNSYOUHINBUNRUIKBN      = "zrnsyouhinbunruikbn";
    public static final String ZRNHKNNMCD               = "zrnhknnmcd";
    public static final String ZRNKYKJYUTIKBN           = "zrnkykjyutikbn";
    public static final String ZRNTKBTHSYUKIKNMANRYOUYM = "zrntkbthsyukiknmanryouym";
    public static final String ZRNLDOWNYM               = "zrnldownym";
    public static final String ZRNHRKMANRYOUYM          = "zrnhrkmanryouym";
    public static final String ZRNMRTIKSNYM             = "zrnmrtiksnym";
    public static final String ZRNHANEIKYKHYJ           = "zrnhaneikykhyj";
    public static final String ZRNZENZEIKYOHYJ          = "zrnzenzeikyohyj";
    public static final String ZRNSIKIJIKBN             = "zrnsikijikbn";
    public static final String ZRNSBUKTDISPHUKUSUHYJ    = "zrnsbuktdisphukusuhyj";
    public static final String ZRNSBUKTNMBSDIRTNHYKYK   = "zrnsbuktnmbsdirtnhykyk";
    public static final String ZRNMNKUKTDISPHUKUSUHYJ   = "zrnmnkuktdisphukusuhyj";
    public static final String ZRNMNKUKTNMBSDIRTNHYKYK  = "zrnmnkuktnmbsdirtnhykyk";
    public static final String ZRNTODOUHUKENCD          = "zrntodouhukencd";
    public static final String ZRNBANKCD                = "zrnbankcd";
    public static final String ZRNSHITENCD              = "zrnshitencd";
    public static final String ZRNYOKINKBN              = "zrnyokinkbn";
    public static final String ZRNKOUZANO7KETA          = "zrnkouzano7keta";
    public static final String ZRNALCARDKBN             = "zrnalcardkbn";
    public static final String ZRNSIBOUS                = "zrnsibous";
    public static final String ZRNSGSBS                 = "zrnsgsbs";
    public static final String ZRNSGWRMSTKSBSDIRTNHYKYK = "zrnsgwrmstksbsdirtnhykyk";
    public static final String ZRNSYOUGAITKKATAKBN      = "zrnsyougaitkkatakbn";
    public static final String ZRNSYOUGAITKSBSDIRTNHYKYK = "zrnsyougaitksbsdirtnhykyk";
    public static final String ZRNREGUARDTKSBSDIRTNHYKYK = "zrnreguardtksbsdirtnhykyk";
    public static final String ZRNREGUARDTKKBN          = "zrnreguardtkkbn";
    public static final String ZRNVREGUARDTKSBSDIRTNHYKYK = "zrnvreguardtksbsdirtnhykyk";
    public static final String ZRNKZKMRTHGUKATAKBN      = "zrnkzkmrthgukatakbn";
    public static final String ZRNKZKMRTHGUSBSDIRTNHYKYK = "zrnkzkmrthgusbsdirtnhykyk";
    public static final String ZRNKZKMRTKOSBSDIRTNHYKYK = "zrnkzkmrtkosbsdirtnhykyk";
    public static final String ZRNKANEEZTKARIHYJ        = "zrnkaneeztkarihyj";
    public static final String ZRNDRTENKINYUUCD         = "zrndrtenkinyuucd";
    public static final String ZRNDRTENSITENCD          = "zrndrtensitencd";
    public static final String ZRNSTJMKBN               = "zrnstjmkbn";
    public static final String ZRNSYOKAIPHRKKEIRO       = "zrnsyokaiphrkkeiro";
    public static final String ZRNCIFCD                 = "zrncifcd";
    public static final String ZRNKANJIDAIRITENNM       = "zrnkanjidairitennm";
    public static final String ZRNTSRYBNWARI            = "zrntsrybnwari";
    public static final String ZRNDRTENKEIJYOUYM        = "zrndrtenkeijyouym";
    public static final String ZRNKYDATKIDAIRITENCD     = "zrnkydatkidairitencd";
    public static final String ZRNMDHNSYOUHNTSRYSHRKBN  = "zrnmdhnsyouhntsryshrkbn";
    public static final String ZRNKYKSYANEN             = "zrnkyksyanen";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNMDHNAISYOUMEICD       = "zrnmdhnaisyoumeicd";
    public static final String ZRNSYOKAIPRYOSYUYMD      = "zrnsyokaipryosyuymd";
    public static final String ZRNSYKGYCD               = "zrnsykgycd";
    public static final String ZRNKAIYAKUHRMKHRITU      = "zrnkaiyakuhrmkhritu";
    public static final String ZRNTOUTATUKAIYAKUHRMKHRITU = "zrntoutatukaiyakuhrmkhritu";
    public static final String ZRNKAIYAKUHRMKHTOUTATUYMD = "zrnkaiyakuhrmkhtoutatuymd";
    public static final String ZRNANNISKCD              = "zrnanniskcd";
    public static final String ZRNHJNKYKHYJ             = "zrnhjnkykhyj";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNLIVGUARDTKYKS         = "zrnlivguardtkyks";
    public static final String ZRNSITEITUUKAITIJIBRP    = "zrnsiteituukaitijibrp";
    public static final String ZRNSITEITUUKASYUS        = "zrnsiteituukasyus";
    public static final String ZRNSITEITUUKASBS         = "zrnsiteituukasbs";
    public static final String ZRNSITEITUUKASAIGAISBS   = "zrnsiteituukasaigaisbs";
    public static final String ZRNSITEITUUKACD          = "zrnsiteituukacd";
    public static final String ZRNHRKTUUKAITIJIBRP      = "zrnhrktuukaitijibrp";
    public static final String ZRNHRKTUUKACD            = "zrnhrktuukacd";
    public static final String ZRNTUMITATERIRITU        = "zrntumitateriritu";
    public static final String ZRNTMTTKNZOUKARITUJYGN   = "zrntmttknzoukaritujygn";
    public static final String ZRNSETTEIBAIRITU         = "zrnsetteibairitu";
    public static final String ZRNTUMITATEKNGK          = "zrntumitatekngk";
    public static final String ZRNKJSBUKTNM30           = "zrnkjsbuktnm30";
    public static final String ZRNMNKUKTNM30            = "zrnmnkuktnm30";
    public static final String ZRNKJKYKDAIRINM          = "zrnkjkykdairinm";
    public static final String ZRNKJSITEIDAIRINM30      = "zrnkjsiteidairinm30";
    public static final String ZRNTRKKZKNMKJ1           = "zrntrkkzknmkj1";
    public static final String ZRNTRKKZKNMKJ2           = "zrntrkkzknmkj2";
    public static final String ZRNIKKATUBARAIKBN        = "zrnikkatubaraikbn";
    public static final String ZRNIKKATUBARAIKAISUU     = "zrnikkatubaraikaisuu";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNRENDOURITU            = "zrnrendouritu";
    public static final String ZRNTEIKISHRRITU          = "zrnteikishrritu";
    public static final String ZRNTIKSKZUKTNMKJ         = "zrntikskzuktnmkj";
    public static final String ZRNTIKSKZBANKCD          = "zrntikskzbankcd";
    public static final String ZRNTIKSKZSITENCD         = "zrntikskzsitencd";
    public static final String ZRNTIKSKZYOKINKBN        = "zrntikskzyokinkbn";
    public static final String ZRNTIKSKZKOUZANO         = "zrntikskzkouzano";
    public static final String ZRNTIKSKZKZMEIGINMKN     = "zrntikskzkzmeiginmkn";
    public static final String ZRNTEIKISHRKINSHRTUUKASYU = "zrnteikishrkinshrtuukasyu";
    public static final String ZRNNNKNSNPSSYHKNSYUKIGOU = "zrnnnknsnpssyhknsyukigou";
    public static final String ZRNNNKNSNPSSYHKNKKN      = "zrnnnknsnpssyhknkkn";
    public static final String ZRNNNKNSNPSSYPHRKKIKN    = "zrnnnknsnpssyphrkkikn";
    public static final String ZRNNNKNSNPSSYSAIMNKKYKHYJ = "zrnnnknsnpssysaimnkkykhyj";
    public static final String ZRNNKNSNPSSYHRKKSKBN     = "zrnnknsnpssyhrkkskbn";
    public static final String ZRNNNKNSNPSSYHHKNNEN     = "zrnnnknsnpssyhhknnen";
    public static final String ZRNNNKNSNPSSYITIJIBRPKYKTK = "zrnnnknsnpssyitijibrpkyktk";
    public static final String ZRNNNKNSNPSSYSYUP        = "zrnnnknsnpssysyup";
    public static final String ZRNNNKNSNPSSYKAWASERATEN5 = "zrnnnknsnpssykawaseraten5";
    public static final String ZRNZENNOUP               = "zrnzennoup";
    public static final String ZRNYOBIV25               = "zrnyobiv25";

    private final PKZT_BosyuuDrtenHoyuuKykRn primaryKey;

    public GenZT_BosyuuDrtenHoyuuKykRn() {
        primaryKey = new PKZT_BosyuuDrtenHoyuuKykRn();
    }

    public GenZT_BosyuuDrtenHoyuuKykRn(String pZrnsyonosyuban) {
        primaryKey = new PKZT_BosyuuDrtenHoyuuKykRn(pZrnsyonosyuban);
    }

    @Transient
    @Override
    public PKZT_BosyuuDrtenHoyuuKykRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_BosyuuDrtenHoyuuKykRn> getMetaClass() {
        return QZT_BosyuuDrtenHoyuuKykRn.class;
    }

    private String zrndatasyurui;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNDATASYURUI)
    public String getZrndatasyurui() {
        return zrndatasyurui;
    }

    public void setZrndatasyurui(String pZrndatasyurui) {
        zrndatasyurui = pZrndatasyurui;
    }

    private String zrnhknsyumoku;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHKNSYUMOKU)
    public String getZrnhknsyumoku() {
        return zrnhknsyumoku;
    }

    public void setZrnhknsyumoku(String pZrnhknsyumoku) {
        zrnhknsyumoku = pZrnhknsyumoku;
    }

    private String zrntyoubokbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTYOUBOKBN)
    public String getZrntyoubokbn() {
        return zrntyoubokbn;
    }

    public void setZrntyoubokbn(String pZrntyoubokbn) {
        zrntyoubokbn = pZrntyoubokbn;
    }

    @Id
    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSYONOSYUBAN)
    public String getZrnsyonosyuban() {
        return getPrimaryKey().getZrnsyonosyuban();
    }

    public void setZrnsyonosyuban(String pZrnsyonosyuban) {
        getPrimaryKey().setZrnsyonosyuban(pZrnsyonosyuban);
    }

    private String zrnhknsyurui2keta;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHKNSYURUI2KETA)
    public String getZrnhknsyurui2keta() {
        return zrnhknsyurui2keta;
    }

    public void setZrnhknsyurui2keta(String pZrnhknsyurui2keta) {
        zrnhknsyurui2keta = pZrnhknsyurui2keta;
    }

    private String zrnhrkhuhukbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHRKHUHUKBN)
    public String getZrnhrkhuhukbn() {
        return zrnhrkhuhukbn;
    }

    public void setZrnhrkhuhukbn(String pZrnhrkhuhukbn) {
        zrnhrkhuhukbn = pZrnhrkhuhukbn;
    }

    private String zrnsyukinkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSYUKINKBN)
    public String getZrnsyukinkbn() {
        return zrnsyukinkbn;
    }

    public void setZrnsyukinkbn(String pZrnsyukinkbn) {
        zrnsyukinkbn = pZrnsyukinkbn;
    }

    private String zrnbnkaisuu;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNBNKAISUU)
    public String getZrnbnkaisuu() {
        return zrnbnkaisuu;
    }

    public void setZrnbnkaisuu(String pZrnbnkaisuu) {
        zrnbnkaisuu = pZrnbnkaisuu;
    }

    private String zrnkyouhocd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKYOUHOCD)
    public String getZrnkyouhocd() {
        return zrnkyouhocd;
    }

    public void setZrnkyouhocd(String pZrnkyouhocd) {
        zrnkyouhocd = pZrnkyouhocd;
    }

    private String zrndaibuncd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNDAIBUNCD)
    public String getZrndaibuncd() {
        return zrndaibuncd;
    }

    public void setZrndaibuncd(String pZrndaibuncd) {
        zrndaibuncd = pZrndaibuncd;
    }

    private String zrndaibunkanjishare;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNDAIBUNKANJISHARE)
    public String getZrndaibunkanjishare() {
        return zrndaibunkanjishare;
    }

    public void setZrndaibunkanjishare(String pZrndaibunkanjishare) {
        zrndaibunkanjishare = pZrndaibunkanjishare;
    }

    private String zrndntcd7keta;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNDNTCD7KETA)
    public String getZrndntcd7keta() {
        return zrndntcd7keta;
    }

    public void setZrndntcd7keta(String pZrndntcd7keta) {
        zrndntcd7keta = pZrndntcd7keta;
    }

    private String zrnsyumokugrpkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSYUMOKUGRPKBN)
    public String getZrnsyumokugrpkbn() {
        return zrnsyumokugrpkbn;
    }

    public void setZrnsyumokugrpkbn(String pZrnsyumokugrpkbn) {
        zrnsyumokugrpkbn = pZrnsyumokugrpkbn;
    }

    private String zrngoukeipbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNGOUKEIPBSDIRTNHYKYK)
    public String getZrngoukeipbsdirtnhykyk() {
        return zrngoukeipbsdirtnhykyk;
    }

    public void setZrngoukeipbsdirtnhykyk(String pZrngoukeipbsdirtnhykyk) {
        zrngoukeipbsdirtnhykyk = pZrngoukeipbsdirtnhykyk;
    }

    private String zrnyno7keta;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNYNO7KETA)
    public String getZrnyno7keta() {
        return zrnyno7keta;
    }

    public void setZrnyno7keta(String pZrnyno7keta) {
        zrnyno7keta = pZrnyno7keta;
    }

    private String zrnsikiymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSIKIYMD)
    public String getZrnsikiymd() {
        return zrnsikiymd;
    }

    public void setZrnsikiymd(String pZrnsikiymd) {
        zrnsikiymd = pZrnsikiymd;
    }

    private String zrnmankiymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNMANKIYMD)
    public String getZrnmankiymd() {
        return zrnmankiymd;
    }

    public void setZrnmankiymd(String pZrnmankiymd) {
        zrnmankiymd = pZrnmankiymd;
    }

    private String zrnidokaiyakuymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNIDOKAIYAKUYMD)
    public String getZrnidokaiyakuymd() {
        return zrnidokaiyakuymd;
    }

    public void setZrnidokaiyakuymd(String pZrnidokaiyakuymd) {
        zrnidokaiyakuymd = pZrnidokaiyakuymd;
    }

    private String zrnmusymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNMUSYMD)
    public String getZrnmusymd() {
        return zrnmusymd;
    }

    public void setZrnmusymd(String pZrnmusymd) {
        zrnmusymd = pZrnmusymd;
    }

    private String zrnjikokykhyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNJIKOKYKHYJ)
    public String getZrnjikokykhyj() {
        return zrnjikokykhyj;
    }

    public void setZrnjikokykhyj(String pZrnjikokykhyj) {
        zrnjikokykhyj = pZrnjikokykhyj;
    }

    private String zrnmeisaioyakokbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNMEISAIOYAKOKBN)
    public String getZrnmeisaioyakokbn() {
        return zrnmeisaioyakokbn;
    }

    public void setZrnmeisaioyakokbn(String pZrnmeisaioyakokbn) {
        zrnmeisaioyakokbn = pZrnmeisaioyakokbn;
    }

    private String zrnkihontikucdkami3;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKIHONTIKUCDKAMI3)
    public String getZrnkihontikucdkami3() {
        return zrnkihontikucdkami3;
    }

    public void setZrnkihontikucdkami3(String pZrnkihontikucdkami3) {
        zrnkihontikucdkami3 = pZrnkihontikucdkami3;
    }

    private String zrnyobiv2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNYOBIV2)
    public String getZrnyobiv2() {
        return zrnyobiv2;
    }

    public void setZrnyobiv2(String pZrnyobiv2) {
        zrnyobiv2 = pZrnyobiv2;
    }

    private String zrntelnobsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTELNOBSDIRTNHYKYK)
    public String getZrntelnobsdirtnhykyk() {
        return zrntelnobsdirtnhykyk;
    }

    public void setZrntelnobsdirtnhykyk(String pZrntelnobsdirtnhykyk) {
        zrntelnobsdirtnhykyk = pZrntelnobsdirtnhykyk;
    }

    private String zrnkyknmknbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKYKNMKNBSDIRTNHYKYK)
    public String getZrnkyknmknbsdirtnhykyk() {
        return zrnkyknmknbsdirtnhykyk;
    }

    public void setZrnkyknmknbsdirtnhykyk(String pZrnkyknmknbsdirtnhykyk) {
        zrnkyknmknbsdirtnhykyk = pZrnkyknmknbsdirtnhykyk;
    }

    private String zrnbnkyk1kaipbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNBNKYK1KAIPBSDIRTNHYKYK)
    public String getZrnbnkyk1kaipbsdirtnhykyk() {
        return zrnbnkyk1kaipbsdirtnhykyk;
    }

    public void setZrnbnkyk1kaipbsdirtnhykyk(String pZrnbnkyk1kaipbsdirtnhykyk) {
        zrnbnkyk1kaipbsdirtnhykyk = pZrnbnkyk1kaipbsdirtnhykyk;
    }

    private String zrnbnsyuruikbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNBNSYURUIKBN)
    public String getZrnbnsyuruikbn() {
        return zrnbnsyuruikbn;
    }

    public void setZrnbnsyuruikbn(String pZrnbnsyuruikbn) {
        zrnbnsyuruikbn = pZrnbnsyuruikbn;
    }

    private String zrnhrkymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHRKYMD)
    public String getZrnhrkymd() {
        return zrnhrkymd;
    }

    public void setZrnhrkymd(String pZrnhrkymd) {
        zrnhrkymd = pZrnhrkymd;
    }

    private String zrndntfsthrkym;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNDNTFSTHRKYM)
    public String getZrndntfsthrkym() {
        return zrndntfsthrkym;
    }

    public void setZrndntfsthrkym(String pZrndntfsthrkym) {
        zrndntfsthrkym = pZrndntfsthrkym;
    }

    private String zrnfstpkzhurikbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNFSTPKZHURIKBN)
    public String getZrnfstpkzhurikbn() {
        return zrnfstpkzhurikbn;
    }

    public void setZrnfstpkzhurikbn(String pZrnfstpkzhurikbn) {
        zrnfstpkzhurikbn = pZrnfstpkzhurikbn;
    }

    private String zrnkeijyouym4keta;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKEIJYOUYM4KETA)
    public String getZrnkeijyouym4keta() {
        return zrnkeijyouym4keta;
    }

    public void setZrnkeijyouym4keta(String pZrnkeijyouym4keta) {
        zrnkeijyouym4keta = pZrnkeijyouym4keta;
    }

    private String zrnhknkaisyacd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHKNKAISYACD)
    public String getZrnhknkaisyacd() {
        return zrnhknkaisyacd;
    }

    public void setZrnhknkaisyacd(String pZrnhknkaisyacd) {
        zrnhknkaisyacd = pZrnhknkaisyacd;
    }

    private String zrnhhknnmknbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHHKNNMKNBSDIRTNHYKYK)
    public String getZrnhhknnmknbsdirtnhykyk() {
        return zrnhhknnmknbsdirtnhykyk;
    }

    public void setZrnhhknnmknbsdirtnhykyk(String pZrnhhknnmknbsdirtnhykyk) {
        zrnhhknnmknbsdirtnhykyk = pZrnhhknnmknbsdirtnhykyk;
    }

    private String zrnknjhhknmei;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKNJHHKNMEI)
    public String getZrnknjhhknmei() {
        return zrnknjhhknmei;
    }

    @DataConvert("toMultiByte")
    public void setZrnknjhhknmei(String pZrnknjhhknmei) {
        zrnknjhhknmei = pZrnknjhhknmei;
    }

    private String zrnhhknseiymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHHKNSEIYMD)
    public String getZrnhhknseiymd() {
        return zrnhhknseiymd;
    }

    public void setZrnhhknseiymd(String pZrnhhknseiymd) {
        zrnhhknseiymd = pZrnhhknseiymd;
    }

    private String zrnhhknnenbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHHKNNENBSDIRTNHYKYK)
    public String getZrnhhknnenbsdirtnhykyk() {
        return zrnhhknnenbsdirtnhykyk;
    }

    public void setZrnhhknnenbsdirtnhykyk(String pZrnhhknnenbsdirtnhykyk) {
        zrnhhknnenbsdirtnhykyk = pZrnhhknnenbsdirtnhykyk;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhhkntdk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHHKNTDK)
    public String getZrnhhkntdk() {
        return zrnhhkntdk;
    }

    public void setZrnhhkntdk(String pZrnhhkntdk) {
        zrnhhkntdk = pZrnhhkntdk;
    }

    private String zrnhhknynobsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHHKNYNOBSDIRTNHYKYK)
    public String getZrnhhknynobsdirtnhykyk() {
        return zrnhhknynobsdirtnhykyk;
    }

    public void setZrnhhknynobsdirtnhykyk(String pZrnhhknynobsdirtnhykyk) {
        zrnhhknynobsdirtnhykyk = pZrnhhknynobsdirtnhykyk;
    }

    private String zrnhhknadrkj50;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHHKNADRKJ50)
    public String getZrnhhknadrkj50() {
        return zrnhhknadrkj50;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknadrkj50(String pZrnhhknadrkj50) {
        zrnhhknadrkj50 = pZrnhhknadrkj50;
    }

    private String zrnhrkkeiro;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHRKKEIRO)
    public String getZrnhrkkeiro() {
        return zrnhrkkeiro;
    }

    public void setZrnhrkkeiro(String pZrnhrkkeiro) {
        zrnhrkkeiro = pZrnhrkkeiro;
    }

    private String zrnitijibrpbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNITIJIBRPBSDIRTNHYKYK)
    public String getZrnitijibrpbsdirtnhykyk() {
        return zrnitijibrpbsdirtnhykyk;
    }

    public void setZrnitijibrpbsdirtnhykyk(String pZrnitijibrpbsdirtnhykyk) {
        zrnitijibrpbsdirtnhykyk = pZrnitijibrpbsdirtnhykyk;
    }

    private String zrnnkshrkknkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNNKSHRKKNKBN)
    public String getZrnnkshrkknkbn() {
        return zrnnkshrkknkbn;
    }

    public void setZrnnkshrkknkbn(String pZrnnkshrkknkbn) {
        zrnnkshrkknkbn = pZrnnkshrkknkbn;
    }

    private String zrnnkshrkknnen;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNNKSHRKKNNEN)
    public String getZrnnkshrkknnen() {
        return zrnnkshrkknnen;
    }

    public void setZrnnkshrkknnen(String pZrnnkshrkknnen) {
        zrnnkshrkknnen = pZrnnkshrkknnen;
    }

    private String zrnnkshrstartymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNNKSHRSTARTYMD)
    public String getZrnnkshrstartymd() {
        return zrnnkshrstartymd;
    }

    public void setZrnnkshrstartymd(String pZrnnkshrstartymd) {
        zrnnkshrstartymd = pZrnnkshrstartymd;
    }

    private String zrntokutaiumu;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTOKUTAIUMU)
    public String getZrntokutaiumu() {
        return zrntokutaiumu;
    }

    public void setZrntokutaiumu(String pZrntokutaiumu) {
        zrntokutaiumu = pZrntokutaiumu;
    }

    private String zrntktyuutohuka;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKTYUUTOHUKA)
    public String getZrntktyuutohuka() {
        return zrntktyuutohuka;
    }

    public void setZrntktyuutohuka(String pZrntktyuutohuka) {
        zrntktyuutohuka = pZrntktyuutohuka;
    }

    private String zrntksuu;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKSUU)
    public String getZrntksuu() {
        return zrntksuu;
    }

    public void setZrntksuu(String pZrntksuu) {
        zrntksuu = pZrntksuu;
    }

    private String zrnsinsakbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSINSAKBN)
    public String getZrnsinsakbn() {
        return zrnsinsakbn;
    }

    public void setZrnsinsakbn(String pZrnsinsakbn) {
        zrnsinsakbn = pZrnsinsakbn;
    }

    private String zrnzeiseitekikaku;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNZEISEITEKIKAKU)
    public String getZrnzeiseitekikaku() {
        return zrnzeiseitekikaku;
    }

    public void setZrnzeiseitekikaku(String pZrnzeiseitekikaku) {
        zrnzeiseitekikaku = pZrnzeiseitekikaku;
    }

    private String zrnlivingneeds;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNLIVINGNEEDS)
    public String getZrnlivingneeds() {
        return zrnlivingneeds;
    }

    public void setZrnlivingneeds(String pZrnlivingneeds) {
        zrnlivingneeds = pZrnlivingneeds;
    }

    private String zrnknjsyuhsynm;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKNJSYUHSYNM)
    public String getZrnknjsyuhsynm() {
        return zrnknjsyuhsynm;
    }

    @DataConvert("toMultiByte")
    public void setZrnknjsyuhsynm(String pZrnknjsyuhsynm) {
        zrnknjsyuhsynm = pZrnknjsyuhsynm;
    }

    private String zrnsyusbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSYUSBSDIRTNHYKYK)
    public String getZrnsyusbsdirtnhykyk() {
        return zrnsyusbsdirtnhykyk;
    }

    public void setZrnsyusbsdirtnhykyk(String pZrnsyusbsdirtnhykyk) {
        zrnsyusbsdirtnhykyk = pZrnsyusbsdirtnhykyk;
    }

    private String zrnsyuhknkknkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSYUHKNKKNKBN)
    public String getZrnsyuhknkknkbn() {
        return zrnsyuhknkknkbn;
    }

    public void setZrnsyuhknkknkbn(String pZrnsyuhknkknkbn) {
        zrnsyuhknkknkbn = pZrnsyuhknkknkbn;
    }

    private String zrnsyuhknkkn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSYUHKNKKN)
    public String getZrnsyuhknkkn() {
        return zrnsyuhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyuhknkkn(String pZrnsyuhknkkn) {
        zrnsyuhknkkn = pZrnsyuhknkkn;
    }

    private String zrnsyuhrkkknkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSYUHRKKKNKBN)
    public String getZrnsyuhrkkknkbn() {
        return zrnsyuhrkkknkbn;
    }

    public void setZrnsyuhrkkknkbn(String pZrnsyuhrkkknkbn) {
        zrnsyuhrkkknkbn = pZrnsyuhrkkknkbn;
    }

    private String zrnsyuhrkkkn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSYUHRKKKN)
    public String getZrnsyuhrkkkn() {
        return zrnsyuhrkkkn;
    }

    public void setZrnsyuhrkkkn(String pZrnsyuhrkkkn) {
        zrnsyuhrkkkn = pZrnsyuhrkkkn;
    }

    private String zrnkjtkhosyunm1;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKJTKHOSYUNM1)
    public String getZrnkjtkhosyunm1() {
        return zrnkjtkhosyunm1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjtkhosyunm1(String pZrnkjtkhosyunm1) {
        zrnkjtkhosyunm1 = pZrnkjtkhosyunm1;
    }

    private String zrntks1bsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKS1BSDIRTNHYKYK)
    public String getZrntks1bsdirtnhykyk() {
        return zrntks1bsdirtnhykyk;
    }

    public void setZrntks1bsdirtnhykyk(String pZrntks1bsdirtnhykyk) {
        zrntks1bsdirtnhykyk = pZrntks1bsdirtnhykyk;
    }

    private String zrntkhknkknkbn1;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHKNKKNKBN1)
    public String getZrntkhknkknkbn1() {
        return zrntkhknkknkbn1;
    }

    public void setZrntkhknkknkbn1(String pZrntkhknkknkbn1) {
        zrntkhknkknkbn1 = pZrntkhknkknkbn1;
    }

    private String zrntkhknkkn1;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHKNKKN1)
    public String getZrntkhknkkn1() {
        return zrntkhknkkn1;
    }

    public void setZrntkhknkkn1(String pZrntkhknkkn1) {
        zrntkhknkkn1 = pZrntkhknkkn1;
    }

    private String zrntkhrkkknkbn1;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHRKKKNKBN1)
    public String getZrntkhrkkknkbn1() {
        return zrntkhrkkknkbn1;
    }

    public void setZrntkhrkkknkbn1(String pZrntkhrkkknkbn1) {
        zrntkhrkkknkbn1 = pZrntkhrkkknkbn1;
    }

    private String zrntkhrkkkn1;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHRKKKN1)
    public String getZrntkhrkkkn1() {
        return zrntkhrkkkn1;
    }

    public void setZrntkhrkkkn1(String pZrntkhrkkkn1) {
        zrntkhrkkkn1 = pZrntkhrkkkn1;
    }

    private String zrnkjtkhosyunm2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKJTKHOSYUNM2)
    public String getZrnkjtkhosyunm2() {
        return zrnkjtkhosyunm2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjtkhosyunm2(String pZrnkjtkhosyunm2) {
        zrnkjtkhosyunm2 = pZrnkjtkhosyunm2;
    }

    private String zrntks2bsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKS2BSDIRTNHYKYK)
    public String getZrntks2bsdirtnhykyk() {
        return zrntks2bsdirtnhykyk;
    }

    public void setZrntks2bsdirtnhykyk(String pZrntks2bsdirtnhykyk) {
        zrntks2bsdirtnhykyk = pZrntks2bsdirtnhykyk;
    }

    private String zrntkhknkknkbn2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHKNKKNKBN2)
    public String getZrntkhknkknkbn2() {
        return zrntkhknkknkbn2;
    }

    public void setZrntkhknkknkbn2(String pZrntkhknkknkbn2) {
        zrntkhknkknkbn2 = pZrntkhknkknkbn2;
    }

    private String zrntkhknkkn2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHKNKKN2)
    public String getZrntkhknkkn2() {
        return zrntkhknkkn2;
    }

    public void setZrntkhknkkn2(String pZrntkhknkkn2) {
        zrntkhknkkn2 = pZrntkhknkkn2;
    }

    private String zrntkhrkkknkbn2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHRKKKNKBN2)
    public String getZrntkhrkkknkbn2() {
        return zrntkhrkkknkbn2;
    }

    public void setZrntkhrkkknkbn2(String pZrntkhrkkknkbn2) {
        zrntkhrkkknkbn2 = pZrntkhrkkknkbn2;
    }

    private String zrntkhrkkkn2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHRKKKN2)
    public String getZrntkhrkkkn2() {
        return zrntkhrkkkn2;
    }

    public void setZrntkhrkkkn2(String pZrntkhrkkkn2) {
        zrntkhrkkkn2 = pZrntkhrkkkn2;
    }

    private String zrnkjtkhosyunm3;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKJTKHOSYUNM3)
    public String getZrnkjtkhosyunm3() {
        return zrnkjtkhosyunm3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjtkhosyunm3(String pZrnkjtkhosyunm3) {
        zrnkjtkhosyunm3 = pZrnkjtkhosyunm3;
    }

    private String zrntks3bsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKS3BSDIRTNHYKYK)
    public String getZrntks3bsdirtnhykyk() {
        return zrntks3bsdirtnhykyk;
    }

    public void setZrntks3bsdirtnhykyk(String pZrntks3bsdirtnhykyk) {
        zrntks3bsdirtnhykyk = pZrntks3bsdirtnhykyk;
    }

    private String zrntkhknkknkbn3;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHKNKKNKBN3)
    public String getZrntkhknkknkbn3() {
        return zrntkhknkknkbn3;
    }

    public void setZrntkhknkknkbn3(String pZrntkhknkknkbn3) {
        zrntkhknkknkbn3 = pZrntkhknkknkbn3;
    }

    private String zrntkhknkkn3;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHKNKKN3)
    public String getZrntkhknkkn3() {
        return zrntkhknkkn3;
    }

    public void setZrntkhknkkn3(String pZrntkhknkkn3) {
        zrntkhknkkn3 = pZrntkhknkkn3;
    }

    private String zrntkhrkkknkbn3;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHRKKKNKBN3)
    public String getZrntkhrkkknkbn3() {
        return zrntkhrkkknkbn3;
    }

    public void setZrntkhrkkknkbn3(String pZrntkhrkkknkbn3) {
        zrntkhrkkknkbn3 = pZrntkhrkkknkbn3;
    }

    private String zrntkhrkkkn3;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHRKKKN3)
    public String getZrntkhrkkkn3() {
        return zrntkhrkkkn3;
    }

    public void setZrntkhrkkkn3(String pZrntkhrkkkn3) {
        zrntkhrkkkn3 = pZrntkhrkkkn3;
    }

    private String zrnkjtkhosyunm4;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKJTKHOSYUNM4)
    public String getZrnkjtkhosyunm4() {
        return zrnkjtkhosyunm4;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjtkhosyunm4(String pZrnkjtkhosyunm4) {
        zrnkjtkhosyunm4 = pZrnkjtkhosyunm4;
    }

    private String zrntks4bsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKS4BSDIRTNHYKYK)
    public String getZrntks4bsdirtnhykyk() {
        return zrntks4bsdirtnhykyk;
    }

    public void setZrntks4bsdirtnhykyk(String pZrntks4bsdirtnhykyk) {
        zrntks4bsdirtnhykyk = pZrntks4bsdirtnhykyk;
    }

    private String zrntkhknkknkbn4;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHKNKKNKBN4)
    public String getZrntkhknkknkbn4() {
        return zrntkhknkknkbn4;
    }

    public void setZrntkhknkknkbn4(String pZrntkhknkknkbn4) {
        zrntkhknkknkbn4 = pZrntkhknkknkbn4;
    }

    private String zrntkhknkkn4;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHKNKKN4)
    public String getZrntkhknkkn4() {
        return zrntkhknkkn4;
    }

    public void setZrntkhknkkn4(String pZrntkhknkkn4) {
        zrntkhknkkn4 = pZrntkhknkkn4;
    }

    private String zrntkhrkkknkbn4;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHRKKKNKBN4)
    public String getZrntkhrkkknkbn4() {
        return zrntkhrkkknkbn4;
    }

    public void setZrntkhrkkknkbn4(String pZrntkhrkkknkbn4) {
        zrntkhrkkknkbn4 = pZrntkhrkkknkbn4;
    }

    private String zrntkhrkkkn4;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHRKKKN4)
    public String getZrntkhrkkkn4() {
        return zrntkhrkkkn4;
    }

    public void setZrntkhrkkkn4(String pZrntkhrkkkn4) {
        zrntkhrkkkn4 = pZrntkhrkkkn4;
    }

    private String zrnkjtkhosyunm5;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKJTKHOSYUNM5)
    public String getZrnkjtkhosyunm5() {
        return zrnkjtkhosyunm5;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjtkhosyunm5(String pZrnkjtkhosyunm5) {
        zrnkjtkhosyunm5 = pZrnkjtkhosyunm5;
    }

    private String zrntks5bsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKS5BSDIRTNHYKYK)
    public String getZrntks5bsdirtnhykyk() {
        return zrntks5bsdirtnhykyk;
    }

    public void setZrntks5bsdirtnhykyk(String pZrntks5bsdirtnhykyk) {
        zrntks5bsdirtnhykyk = pZrntks5bsdirtnhykyk;
    }

    private String zrntkhknkknkbn5;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHKNKKNKBN5)
    public String getZrntkhknkknkbn5() {
        return zrntkhknkknkbn5;
    }

    public void setZrntkhknkknkbn5(String pZrntkhknkknkbn5) {
        zrntkhknkknkbn5 = pZrntkhknkknkbn5;
    }

    private String zrntkhknkkn5;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHKNKKN5)
    public String getZrntkhknkkn5() {
        return zrntkhknkkn5;
    }

    public void setZrntkhknkkn5(String pZrntkhknkkn5) {
        zrntkhknkkn5 = pZrntkhknkkn5;
    }

    private String zrntkhrkkknkbn5;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHRKKKNKBN5)
    public String getZrntkhrkkknkbn5() {
        return zrntkhrkkknkbn5;
    }

    public void setZrntkhrkkknkbn5(String pZrntkhrkkknkbn5) {
        zrntkhrkkknkbn5 = pZrntkhrkkknkbn5;
    }

    private String zrntkhrkkkn5;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHRKKKN5)
    public String getZrntkhrkkkn5() {
        return zrntkhrkkkn5;
    }

    public void setZrntkhrkkkn5(String pZrntkhrkkkn5) {
        zrntkhrkkkn5 = pZrntkhrkkkn5;
    }

    private String zrnkjtkhosyunm6;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKJTKHOSYUNM6)
    public String getZrnkjtkhosyunm6() {
        return zrnkjtkhosyunm6;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjtkhosyunm6(String pZrnkjtkhosyunm6) {
        zrnkjtkhosyunm6 = pZrnkjtkhosyunm6;
    }

    private String zrntks6bsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKS6BSDIRTNHYKYK)
    public String getZrntks6bsdirtnhykyk() {
        return zrntks6bsdirtnhykyk;
    }

    public void setZrntks6bsdirtnhykyk(String pZrntks6bsdirtnhykyk) {
        zrntks6bsdirtnhykyk = pZrntks6bsdirtnhykyk;
    }

    private String zrntkhknkknkbn6;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHKNKKNKBN6)
    public String getZrntkhknkknkbn6() {
        return zrntkhknkknkbn6;
    }

    public void setZrntkhknkknkbn6(String pZrntkhknkknkbn6) {
        zrntkhknkknkbn6 = pZrntkhknkknkbn6;
    }

    private String zrntkhknkkn6;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHKNKKN6)
    public String getZrntkhknkkn6() {
        return zrntkhknkkn6;
    }

    public void setZrntkhknkkn6(String pZrntkhknkkn6) {
        zrntkhknkkn6 = pZrntkhknkkn6;
    }

    private String zrntkhrkkknkbn6;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHRKKKNKBN6)
    public String getZrntkhrkkknkbn6() {
        return zrntkhrkkknkbn6;
    }

    public void setZrntkhrkkknkbn6(String pZrntkhrkkknkbn6) {
        zrntkhrkkknkbn6 = pZrntkhrkkknkbn6;
    }

    private String zrntkhrkkkn6;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKHRKKKN6)
    public String getZrntkhrkkkn6() {
        return zrntkhrkkkn6;
    }

    public void setZrntkhrkkkn6(String pZrntkhrkkkn6) {
        zrntkhrkkkn6 = pZrntkhrkkkn6;
    }

    private String zrndatasyubetucd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNDATASYUBETUCD)
    public String getZrndatasyubetucd() {
        return zrndatasyubetucd;
    }

    public void setZrndatasyubetucd(String pZrndatasyubetucd) {
        zrndatasyubetucd = pZrndatasyubetucd;
    }

    private String zrnhjnkojinkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHJNKOJINKBN)
    public String getZrnhjnkojinkbn() {
        return zrnhjnkojinkbn;
    }

    public void setZrnhjnkojinkbn(String pZrnhjnkojinkbn) {
        zrnhjnkojinkbn = pZrnhjnkojinkbn;
    }

    private String zrnkykadrkj50;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKYKADRKJ50)
    public String getZrnkykadrkj50() {
        return zrnkykadrkj50;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykadrkj50(String pZrnkykadrkj50) {
        zrnkykadrkj50 = pZrnkykadrkj50;
    }

    private String zrnkyknmkjbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKYKNMKJBSDIRTNHYKYK)
    public String getZrnkyknmkjbsdirtnhykyk() {
        return zrnkyknmkjbsdirtnhykyk;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkjbsdirtnhykyk(String pZrnkyknmkjbsdirtnhykyk) {
        zrnkyknmkjbsdirtnhykyk = pZrnkyknmkjbsdirtnhykyk;
    }

    private String zrnkyksyaseiymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKYKSYASEIYMD)
    public String getZrnkyksyaseiymd() {
        return zrnkyksyaseiymd;
    }

    public void setZrnkyksyaseiymd(String pZrnkyksyaseiymd) {
        zrnkyksyaseiymd = pZrnkyksyaseiymd;
    }

    private String zrnsakuseiym;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSAKUSEIYM)
    public String getZrnsakuseiym() {
        return zrnsakuseiym;
    }

    public void setZrnsakuseiym(String pZrnsakuseiym) {
        zrnsakuseiym = pZrnsakuseiym;
    }

    private String zrndairitencd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNDAIRITENCD)
    public String getZrndairitencd() {
        return zrndairitencd;
    }

    public void setZrndairitencd(String pZrndairitencd) {
        zrndairitencd = pZrndairitencd;
    }

    private String zrndairitenkanrisskcd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNDAIRITENKANRISSKCD)
    public String getZrndairitenkanrisskcd() {
        return zrndairitenkanrisskcd;
    }

    public void setZrndairitenkanrisskcd(String pZrndairitenkanrisskcd) {
        zrndairitenkanrisskcd = pZrndairitenkanrisskcd;
    }

    private String zrnbosyuunincd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNBOSYUUNINCD)
    public String getZrnbosyuunincd() {
        return zrnbosyuunincd;
    }

    public void setZrnbosyuunincd(String pZrnbosyuunincd) {
        zrnbosyuunincd = pZrnbosyuunincd;
    }

    private String zrnbosyuunm;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNBOSYUUNM)
    public String getZrnbosyuunm() {
        return zrnbosyuunm;
    }

    @DataConvert("toMultiByte")
    public void setZrnbosyuunm(String pZrnbosyuunm) {
        zrnbosyuunm = pZrnbosyuunm;
    }

    private String zrnbosyuujtkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNBOSYUUJTKBN)
    public String getZrnbosyuujtkbn() {
        return zrnbosyuujtkbn;
    }

    public void setZrnbosyuujtkbn(String pZrnbosyuujtkbn) {
        zrnbosyuujtkbn = pZrnbosyuujtkbn;
    }

    private String zrndairitenkbtinfo1;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNDAIRITENKBTINFO1)
    public String getZrndairitenkbtinfo1() {
        return zrndairitenkbtinfo1;
    }

    public void setZrndairitenkbtinfo1(String pZrndairitenkbtinfo1) {
        zrndairitenkbtinfo1 = pZrndairitenkbtinfo1;
    }

    private String zrndairitenkbtinfo2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNDAIRITENKBTINFO2)
    public String getZrndairitenkbtinfo2() {
        return zrndairitenkbtinfo2;
    }

    public void setZrndairitenkbtinfo2(String pZrndairitenkbtinfo2) {
        zrndairitenkbtinfo2 = pZrndairitenkbtinfo2;
    }

    private String zrndairitenkbtinfo3;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNDAIRITENKBTINFO3)
    public String getZrndairitenkbtinfo3() {
        return zrndairitenkbtinfo3;
    }

    public void setZrndairitenkbtinfo3(String pZrndairitenkbtinfo3) {
        zrndairitenkbtinfo3 = pZrndairitenkbtinfo3;
    }

    private String zrnsyouhinbunruikbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSYOUHINBUNRUIKBN)
    public String getZrnsyouhinbunruikbn() {
        return zrnsyouhinbunruikbn;
    }

    public void setZrnsyouhinbunruikbn(String pZrnsyouhinbunruikbn) {
        zrnsyouhinbunruikbn = pZrnsyouhinbunruikbn;
    }

    private String zrnhknnmcd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHKNNMCD)
    public String getZrnhknnmcd() {
        return zrnhknnmcd;
    }

    public void setZrnhknnmcd(String pZrnhknnmcd) {
        zrnhknnmcd = pZrnhknnmcd;
    }

    private String zrnkykjyutikbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKYKJYUTIKBN)
    public String getZrnkykjyutikbn() {
        return zrnkykjyutikbn;
    }

    public void setZrnkykjyutikbn(String pZrnkykjyutikbn) {
        zrnkykjyutikbn = pZrnkykjyutikbn;
    }

    private String zrntkbthsyukiknmanryouym;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTKBTHSYUKIKNMANRYOUYM)
    public String getZrntkbthsyukiknmanryouym() {
        return zrntkbthsyukiknmanryouym;
    }

    public void setZrntkbthsyukiknmanryouym(String pZrntkbthsyukiknmanryouym) {
        zrntkbthsyukiknmanryouym = pZrntkbthsyukiknmanryouym;
    }

    private String zrnldownym;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNLDOWNYM)
    public String getZrnldownym() {
        return zrnldownym;
    }

    public void setZrnldownym(String pZrnldownym) {
        zrnldownym = pZrnldownym;
    }

    private String zrnhrkmanryouym;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHRKMANRYOUYM)
    public String getZrnhrkmanryouym() {
        return zrnhrkmanryouym;
    }

    public void setZrnhrkmanryouym(String pZrnhrkmanryouym) {
        zrnhrkmanryouym = pZrnhrkmanryouym;
    }

    private String zrnmrtiksnym;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNMRTIKSNYM)
    public String getZrnmrtiksnym() {
        return zrnmrtiksnym;
    }

    public void setZrnmrtiksnym(String pZrnmrtiksnym) {
        zrnmrtiksnym = pZrnmrtiksnym;
    }

    private String zrnhaneikykhyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHANEIKYKHYJ)
    public String getZrnhaneikykhyj() {
        return zrnhaneikykhyj;
    }

    public void setZrnhaneikykhyj(String pZrnhaneikykhyj) {
        zrnhaneikykhyj = pZrnhaneikykhyj;
    }

    private String zrnzenzeikyohyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNZENZEIKYOHYJ)
    public String getZrnzenzeikyohyj() {
        return zrnzenzeikyohyj;
    }

    public void setZrnzenzeikyohyj(String pZrnzenzeikyohyj) {
        zrnzenzeikyohyj = pZrnzenzeikyohyj;
    }

    private String zrnsikijikbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSIKIJIKBN)
    public String getZrnsikijikbn() {
        return zrnsikijikbn;
    }

    public void setZrnsikijikbn(String pZrnsikijikbn) {
        zrnsikijikbn = pZrnsikijikbn;
    }

    private String zrnsbuktdisphukusuhyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSBUKTDISPHUKUSUHYJ)
    public String getZrnsbuktdisphukusuhyj() {
        return zrnsbuktdisphukusuhyj;
    }

    public void setZrnsbuktdisphukusuhyj(String pZrnsbuktdisphukusuhyj) {
        zrnsbuktdisphukusuhyj = pZrnsbuktdisphukusuhyj;
    }

    private String zrnsbuktnmbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSBUKTNMBSDIRTNHYKYK)
    public String getZrnsbuktnmbsdirtnhykyk() {
        return zrnsbuktnmbsdirtnhykyk;
    }

    public void setZrnsbuktnmbsdirtnhykyk(String pZrnsbuktnmbsdirtnhykyk) {
        zrnsbuktnmbsdirtnhykyk = pZrnsbuktnmbsdirtnhykyk;
    }

    private String zrnmnkuktdisphukusuhyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNMNKUKTDISPHUKUSUHYJ)
    public String getZrnmnkuktdisphukusuhyj() {
        return zrnmnkuktdisphukusuhyj;
    }

    public void setZrnmnkuktdisphukusuhyj(String pZrnmnkuktdisphukusuhyj) {
        zrnmnkuktdisphukusuhyj = pZrnmnkuktdisphukusuhyj;
    }

    private String zrnmnkuktnmbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNMNKUKTNMBSDIRTNHYKYK)
    public String getZrnmnkuktnmbsdirtnhykyk() {
        return zrnmnkuktnmbsdirtnhykyk;
    }

    public void setZrnmnkuktnmbsdirtnhykyk(String pZrnmnkuktnmbsdirtnhykyk) {
        zrnmnkuktnmbsdirtnhykyk = pZrnmnkuktnmbsdirtnhykyk;
    }

    private String zrntodouhukencd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTODOUHUKENCD)
    public String getZrntodouhukencd() {
        return zrntodouhukencd;
    }

    public void setZrntodouhukencd(String pZrntodouhukencd) {
        zrntodouhukencd = pZrntodouhukencd;
    }

    private String zrnbankcd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNBANKCD)
    public String getZrnbankcd() {
        return zrnbankcd;
    }

    public void setZrnbankcd(String pZrnbankcd) {
        zrnbankcd = pZrnbankcd;
    }

    private String zrnshitencd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSHITENCD)
    public String getZrnshitencd() {
        return zrnshitencd;
    }

    public void setZrnshitencd(String pZrnshitencd) {
        zrnshitencd = pZrnshitencd;
    }

    private String zrnyokinkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNYOKINKBN)
    public String getZrnyokinkbn() {
        return zrnyokinkbn;
    }

    public void setZrnyokinkbn(String pZrnyokinkbn) {
        zrnyokinkbn = pZrnyokinkbn;
    }

    private String zrnkouzano7keta;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKOUZANO7KETA)
    public String getZrnkouzano7keta() {
        return zrnkouzano7keta;
    }

    public void setZrnkouzano7keta(String pZrnkouzano7keta) {
        zrnkouzano7keta = pZrnkouzano7keta;
    }

    private String zrnalcardkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNALCARDKBN)
    public String getZrnalcardkbn() {
        return zrnalcardkbn;
    }

    public void setZrnalcardkbn(String pZrnalcardkbn) {
        zrnalcardkbn = pZrnalcardkbn;
    }

    private Long zrnsibous;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSIBOUS)
    public Long getZrnsibous() {
        return zrnsibous;
    }

    public void setZrnsibous(Long pZrnsibous) {
        zrnsibous = pZrnsibous;
    }

    private Long zrnsgsbs;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSGSBS)
    public Long getZrnsgsbs() {
        return zrnsgsbs;
    }

    public void setZrnsgsbs(Long pZrnsgsbs) {
        zrnsgsbs = pZrnsgsbs;
    }

    private String zrnsgwrmstksbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSGWRMSTKSBSDIRTNHYKYK)
    public String getZrnsgwrmstksbsdirtnhykyk() {
        return zrnsgwrmstksbsdirtnhykyk;
    }

    public void setZrnsgwrmstksbsdirtnhykyk(String pZrnsgwrmstksbsdirtnhykyk) {
        zrnsgwrmstksbsdirtnhykyk = pZrnsgwrmstksbsdirtnhykyk;
    }

    private String zrnsyougaitkkatakbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSYOUGAITKKATAKBN)
    public String getZrnsyougaitkkatakbn() {
        return zrnsyougaitkkatakbn;
    }

    public void setZrnsyougaitkkatakbn(String pZrnsyougaitkkatakbn) {
        zrnsyougaitkkatakbn = pZrnsyougaitkkatakbn;
    }

    private String zrnsyougaitksbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSYOUGAITKSBSDIRTNHYKYK)
    public String getZrnsyougaitksbsdirtnhykyk() {
        return zrnsyougaitksbsdirtnhykyk;
    }

    public void setZrnsyougaitksbsdirtnhykyk(String pZrnsyougaitksbsdirtnhykyk) {
        zrnsyougaitksbsdirtnhykyk = pZrnsyougaitksbsdirtnhykyk;
    }

    private String zrnreguardtksbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNREGUARDTKSBSDIRTNHYKYK)
    public String getZrnreguardtksbsdirtnhykyk() {
        return zrnreguardtksbsdirtnhykyk;
    }

    public void setZrnreguardtksbsdirtnhykyk(String pZrnreguardtksbsdirtnhykyk) {
        zrnreguardtksbsdirtnhykyk = pZrnreguardtksbsdirtnhykyk;
    }

    private String zrnreguardtkkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNREGUARDTKKBN)
    public String getZrnreguardtkkbn() {
        return zrnreguardtkkbn;
    }

    public void setZrnreguardtkkbn(String pZrnreguardtkkbn) {
        zrnreguardtkkbn = pZrnreguardtkkbn;
    }

    private String zrnvreguardtksbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNVREGUARDTKSBSDIRTNHYKYK)
    public String getZrnvreguardtksbsdirtnhykyk() {
        return zrnvreguardtksbsdirtnhykyk;
    }

    public void setZrnvreguardtksbsdirtnhykyk(String pZrnvreguardtksbsdirtnhykyk) {
        zrnvreguardtksbsdirtnhykyk = pZrnvreguardtksbsdirtnhykyk;
    }

    private String zrnkzkmrthgukatakbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKZKMRTHGUKATAKBN)
    public String getZrnkzkmrthgukatakbn() {
        return zrnkzkmrthgukatakbn;
    }

    public void setZrnkzkmrthgukatakbn(String pZrnkzkmrthgukatakbn) {
        zrnkzkmrthgukatakbn = pZrnkzkmrthgukatakbn;
    }

    private String zrnkzkmrthgusbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKZKMRTHGUSBSDIRTNHYKYK)
    public String getZrnkzkmrthgusbsdirtnhykyk() {
        return zrnkzkmrthgusbsdirtnhykyk;
    }

    public void setZrnkzkmrthgusbsdirtnhykyk(String pZrnkzkmrthgusbsdirtnhykyk) {
        zrnkzkmrthgusbsdirtnhykyk = pZrnkzkmrthgusbsdirtnhykyk;
    }

    private String zrnkzkmrtkosbsdirtnhykyk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKZKMRTKOSBSDIRTNHYKYK)
    public String getZrnkzkmrtkosbsdirtnhykyk() {
        return zrnkzkmrtkosbsdirtnhykyk;
    }

    public void setZrnkzkmrtkosbsdirtnhykyk(String pZrnkzkmrtkosbsdirtnhykyk) {
        zrnkzkmrtkosbsdirtnhykyk = pZrnkzkmrtkosbsdirtnhykyk;
    }

    private String zrnkaneeztkarihyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKANEEZTKARIHYJ)
    public String getZrnkaneeztkarihyj() {
        return zrnkaneeztkarihyj;
    }

    public void setZrnkaneeztkarihyj(String pZrnkaneeztkarihyj) {
        zrnkaneeztkarihyj = pZrnkaneeztkarihyj;
    }

    private String zrndrtenkinyuucd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNDRTENKINYUUCD)
    public String getZrndrtenkinyuucd() {
        return zrndrtenkinyuucd;
    }

    public void setZrndrtenkinyuucd(String pZrndrtenkinyuucd) {
        zrndrtenkinyuucd = pZrndrtenkinyuucd;
    }

    private String zrndrtensitencd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNDRTENSITENCD)
    public String getZrndrtensitencd() {
        return zrndrtensitencd;
    }

    public void setZrndrtensitencd(String pZrndrtensitencd) {
        zrndrtensitencd = pZrndrtensitencd;
    }

    private String zrnstjmkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSTJMKBN)
    public String getZrnstjmkbn() {
        return zrnstjmkbn;
    }

    public void setZrnstjmkbn(String pZrnstjmkbn) {
        zrnstjmkbn = pZrnstjmkbn;
    }

    private String zrnsyokaiphrkkeiro;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSYOKAIPHRKKEIRO)
    public String getZrnsyokaiphrkkeiro() {
        return zrnsyokaiphrkkeiro;
    }

    public void setZrnsyokaiphrkkeiro(String pZrnsyokaiphrkkeiro) {
        zrnsyokaiphrkkeiro = pZrnsyokaiphrkkeiro;
    }

    private String zrncifcd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNCIFCD)
    public String getZrncifcd() {
        return zrncifcd;
    }

    public void setZrncifcd(String pZrncifcd) {
        zrncifcd = pZrncifcd;
    }

    private String zrnkanjidairitennm;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKANJIDAIRITENNM)
    public String getZrnkanjidairitennm() {
        return zrnkanjidairitennm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjidairitennm(String pZrnkanjidairitennm) {
        zrnkanjidairitennm = pZrnkanjidairitennm;
    }

    private Long zrntsrybnwari;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTSRYBNWARI)
    public Long getZrntsrybnwari() {
        return zrntsrybnwari;
    }

    public void setZrntsrybnwari(Long pZrntsrybnwari) {
        zrntsrybnwari = pZrntsrybnwari;
    }

    private String zrndrtenkeijyouym;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNDRTENKEIJYOUYM)
    public String getZrndrtenkeijyouym() {
        return zrndrtenkeijyouym;
    }

    public void setZrndrtenkeijyouym(String pZrndrtenkeijyouym) {
        zrndrtenkeijyouym = pZrndrtenkeijyouym;
    }

    private String zrnkydatkidairitencd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKYDATKIDAIRITENCD)
    public String getZrnkydatkidairitencd() {
        return zrnkydatkidairitencd;
    }

    public void setZrnkydatkidairitencd(String pZrnkydatkidairitencd) {
        zrnkydatkidairitencd = pZrnkydatkidairitencd;
    }

    private String zrnmdhnsyouhntsryshrkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNMDHNSYOUHNTSRYSHRKBN)
    public String getZrnmdhnsyouhntsryshrkbn() {
        return zrnmdhnsyouhntsryshrkbn;
    }

    public void setZrnmdhnsyouhntsryshrkbn(String pZrnmdhnsyouhntsryshrkbn) {
        zrnmdhnsyouhntsryshrkbn = pZrnmdhnsyouhntsryshrkbn;
    }

    private String zrnkyksyanen;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKYKSYANEN)
    public String getZrnkyksyanen() {
        return zrnkyksyanen;
    }

    public void setZrnkyksyanen(String pZrnkyksyanen) {
        zrnkyksyanen = pZrnkyksyanen;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnmdhnaisyoumeicd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNMDHNAISYOUMEICD)
    public String getZrnmdhnaisyoumeicd() {
        return zrnmdhnaisyoumeicd;
    }

    public void setZrnmdhnaisyoumeicd(String pZrnmdhnaisyoumeicd) {
        zrnmdhnaisyoumeicd = pZrnmdhnaisyoumeicd;
    }

    private String zrnsyokaipryosyuymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSYOKAIPRYOSYUYMD)
    public String getZrnsyokaipryosyuymd() {
        return zrnsyokaipryosyuymd;
    }

    public void setZrnsyokaipryosyuymd(String pZrnsyokaipryosyuymd) {
        zrnsyokaipryosyuymd = pZrnsyokaipryosyuymd;
    }

    private String zrnsykgycd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSYKGYCD)
    public String getZrnsykgycd() {
        return zrnsykgycd;
    }

    public void setZrnsykgycd(String pZrnsykgycd) {
        zrnsykgycd = pZrnsykgycd;
    }

    private BizNumber zrnkaiyakuhrmkhritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKAIYAKUHRMKHRITU)
    public BizNumber getZrnkaiyakuhrmkhritu() {
        return zrnkaiyakuhrmkhritu;
    }

    public void setZrnkaiyakuhrmkhritu(BizNumber pZrnkaiyakuhrmkhritu) {
        zrnkaiyakuhrmkhritu = pZrnkaiyakuhrmkhritu;
    }

    private String zrntoutatukaiyakuhrmkhritu;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTOUTATUKAIYAKUHRMKHRITU)
    public String getZrntoutatukaiyakuhrmkhritu() {
        return zrntoutatukaiyakuhrmkhritu;
    }

    public void setZrntoutatukaiyakuhrmkhritu(String pZrntoutatukaiyakuhrmkhritu) {
        zrntoutatukaiyakuhrmkhritu = pZrntoutatukaiyakuhrmkhritu;
    }

    private String zrnkaiyakuhrmkhtoutatuymd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKAIYAKUHRMKHTOUTATUYMD)
    public String getZrnkaiyakuhrmkhtoutatuymd() {
        return zrnkaiyakuhrmkhtoutatuymd;
    }

    public void setZrnkaiyakuhrmkhtoutatuymd(String pZrnkaiyakuhrmkhtoutatuymd) {
        zrnkaiyakuhrmkhtoutatuymd = pZrnkaiyakuhrmkhtoutatuymd;
    }

    private String zrnanniskcd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNANNISKCD)
    public String getZrnanniskcd() {
        return zrnanniskcd;
    }

    public void setZrnanniskcd(String pZrnanniskcd) {
        zrnanniskcd = pZrnanniskcd;
    }

    private String zrnhjnkykhyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHJNKYKHYJ)
    public String getZrnhjnkykhyj() {
        return zrnhjnkykhyj;
    }

    public void setZrnhjnkykhyj(String pZrnhjnkykhyj) {
        zrnhjnkykhyj = pZrnhjnkykhyj;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnlivguardtkyks;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNLIVGUARDTKYKS)
    public String getZrnlivguardtkyks() {
        return zrnlivguardtkyks;
    }

    public void setZrnlivguardtkyks(String pZrnlivguardtkyks) {
        zrnlivguardtkyks = pZrnlivguardtkyks;
    }

    private Long zrnsiteituukaitijibrp;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSITEITUUKAITIJIBRP)
    public Long getZrnsiteituukaitijibrp() {
        return zrnsiteituukaitijibrp;
    }

    public void setZrnsiteituukaitijibrp(Long pZrnsiteituukaitijibrp) {
        zrnsiteituukaitijibrp = pZrnsiteituukaitijibrp;
    }

    private Long zrnsiteituukasyus;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSITEITUUKASYUS)
    public Long getZrnsiteituukasyus() {
        return zrnsiteituukasyus;
    }

    public void setZrnsiteituukasyus(Long pZrnsiteituukasyus) {
        zrnsiteituukasyus = pZrnsiteituukasyus;
    }

    private Long zrnsiteituukasbs;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSITEITUUKASBS)
    public Long getZrnsiteituukasbs() {
        return zrnsiteituukasbs;
    }

    public void setZrnsiteituukasbs(Long pZrnsiteituukasbs) {
        zrnsiteituukasbs = pZrnsiteituukasbs;
    }

    private Long zrnsiteituukasaigaisbs;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSITEITUUKASAIGAISBS)
    public Long getZrnsiteituukasaigaisbs() {
        return zrnsiteituukasaigaisbs;
    }

    public void setZrnsiteituukasaigaisbs(Long pZrnsiteituukasaigaisbs) {
        zrnsiteituukasaigaisbs = pZrnsiteituukasaigaisbs;
    }

    private String zrnsiteituukacd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSITEITUUKACD)
    public String getZrnsiteituukacd() {
        return zrnsiteituukacd;
    }

    public void setZrnsiteituukacd(String pZrnsiteituukacd) {
        zrnsiteituukacd = pZrnsiteituukacd;
    }

    private Long zrnhrktuukaitijibrp;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHRKTUUKAITIJIBRP)
    public Long getZrnhrktuukaitijibrp() {
        return zrnhrktuukaitijibrp;
    }

    public void setZrnhrktuukaitijibrp(Long pZrnhrktuukaitijibrp) {
        zrnhrktuukaitijibrp = pZrnhrktuukaitijibrp;
    }

    private String zrnhrktuukacd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNHRKTUUKACD)
    public String getZrnhrktuukacd() {
        return zrnhrktuukacd;
    }

    public void setZrnhrktuukacd(String pZrnhrktuukacd) {
        zrnhrktuukacd = pZrnhrktuukacd;
    }

    private BizNumber zrntumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTUMITATERIRITU)
    public BizNumber getZrntumitateriritu() {
        return zrntumitateriritu;
    }

    public void setZrntumitateriritu(BizNumber pZrntumitateriritu) {
        zrntumitateriritu = pZrntumitateriritu;
    }

    private BizNumber zrntmttknzoukaritujygn;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTMTTKNZOUKARITUJYGN)
    public BizNumber getZrntmttknzoukaritujygn() {
        return zrntmttknzoukaritujygn;
    }

    public void setZrntmttknzoukaritujygn(BizNumber pZrntmttknzoukaritujygn) {
        zrntmttknzoukaritujygn = pZrntmttknzoukaritujygn;
    }

    private BizNumber zrnsetteibairitu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNSETTEIBAIRITU)
    public BizNumber getZrnsetteibairitu() {
        return zrnsetteibairitu;
    }

    public void setZrnsetteibairitu(BizNumber pZrnsetteibairitu) {
        zrnsetteibairitu = pZrnsetteibairitu;
    }

    private Long zrntumitatekngk;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTUMITATEKNGK)
    public Long getZrntumitatekngk() {
        return zrntumitatekngk;
    }

    public void setZrntumitatekngk(Long pZrntumitatekngk) {
        zrntumitatekngk = pZrntumitatekngk;
    }

    private String zrnkjsbuktnm30;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKJSBUKTNM30)
    public String getZrnkjsbuktnm30() {
        return zrnkjsbuktnm30;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjsbuktnm30(String pZrnkjsbuktnm30) {
        zrnkjsbuktnm30 = pZrnkjsbuktnm30;
    }

    private String zrnmnkuktnm30;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNMNKUKTNM30)
    public String getZrnmnkuktnm30() {
        return zrnmnkuktnm30;
    }

    @DataConvert("toMultiByte")
    public void setZrnmnkuktnm30(String pZrnmnkuktnm30) {
        zrnmnkuktnm30 = pZrnmnkuktnm30;
    }

    private String zrnkjkykdairinm;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKJKYKDAIRINM)
    public String getZrnkjkykdairinm() {
        return zrnkjkykdairinm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkykdairinm(String pZrnkjkykdairinm) {
        zrnkjkykdairinm = pZrnkjkykdairinm;
    }

    private String zrnkjsiteidairinm30;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNKJSITEIDAIRINM30)
    public String getZrnkjsiteidairinm30() {
        return zrnkjsiteidairinm30;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjsiteidairinm30(String pZrnkjsiteidairinm30) {
        zrnkjsiteidairinm30 = pZrnkjsiteidairinm30;
    }

    private String zrntrkkzknmkj1;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTRKKZKNMKJ1)
    public String getZrntrkkzknmkj1() {
        return zrntrkkzknmkj1;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzknmkj1(String pZrntrkkzknmkj1) {
        zrntrkkzknmkj1 = pZrntrkkzknmkj1;
    }

    private String zrntrkkzknmkj2;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTRKKZKNMKJ2)
    public String getZrntrkkzknmkj2() {
        return zrntrkkzknmkj2;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzknmkj2(String pZrntrkkzknmkj2) {
        zrntrkkzknmkj2 = pZrntrkkzknmkj2;
    }

    private String zrnikkatubaraikbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNIKKATUBARAIKBN)
    public String getZrnikkatubaraikbn() {
        return zrnikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnikkatubaraikbn(String pZrnikkatubaraikbn) {
        zrnikkatubaraikbn = pZrnikkatubaraikbn;
    }

    private String zrnikkatubaraikaisuu;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNIKKATUBARAIKAISUU)
    public String getZrnikkatubaraikaisuu() {
        return zrnikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnikkatubaraikaisuu(String pZrnikkatubaraikaisuu) {
        zrnikkatubaraikaisuu = pZrnikkatubaraikaisuu;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private BizNumber zrnrendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNRENDOURITU)
    public BizNumber getZrnrendouritu() {
        return zrnrendouritu;
    }

    public void setZrnrendouritu(BizNumber pZrnrendouritu) {
        zrnrendouritu = pZrnrendouritu;
    }

    private BizNumber zrnteikishrritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTEIKISHRRITU)
    public BizNumber getZrnteikishrritu() {
        return zrnteikishrritu;
    }

    public void setZrnteikishrritu(BizNumber pZrnteikishrritu) {
        zrnteikishrritu = pZrnteikishrritu;
    }

    private String zrntikskzuktnmkj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTIKSKZUKTNMKJ)
    public String getZrntikskzuktnmkj() {
        return zrntikskzuktnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrntikskzuktnmkj(String pZrntikskzuktnmkj) {
        zrntikskzuktnmkj = pZrntikskzuktnmkj;
    }

    private String zrntikskzbankcd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTIKSKZBANKCD)
    public String getZrntikskzbankcd() {
        return zrntikskzbankcd;
    }

    public void setZrntikskzbankcd(String pZrntikskzbankcd) {
        zrntikskzbankcd = pZrntikskzbankcd;
    }

    private String zrntikskzsitencd;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTIKSKZSITENCD)
    public String getZrntikskzsitencd() {
        return zrntikskzsitencd;
    }

    public void setZrntikskzsitencd(String pZrntikskzsitencd) {
        zrntikskzsitencd = pZrntikskzsitencd;
    }

    private String zrntikskzyokinkbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTIKSKZYOKINKBN)
    public String getZrntikskzyokinkbn() {
        return zrntikskzyokinkbn;
    }

    public void setZrntikskzyokinkbn(String pZrntikskzyokinkbn) {
        zrntikskzyokinkbn = pZrntikskzyokinkbn;
    }

    private String zrntikskzkouzano;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTIKSKZKOUZANO)
    public String getZrntikskzkouzano() {
        return zrntikskzkouzano;
    }

    public void setZrntikskzkouzano(String pZrntikskzkouzano) {
        zrntikskzkouzano = pZrntikskzkouzano;
    }

    private String zrntikskzkzmeiginmkn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTIKSKZKZMEIGINMKN)
    public String getZrntikskzkzmeiginmkn() {
        return zrntikskzkzmeiginmkn;
    }

    public void setZrntikskzkzmeiginmkn(String pZrntikskzkzmeiginmkn) {
        zrntikskzkzmeiginmkn = pZrntikskzkzmeiginmkn;
    }

    private String zrnteikishrkinshrtuukasyu;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNTEIKISHRKINSHRTUUKASYU)
    public String getZrnteikishrkinshrtuukasyu() {
        return zrnteikishrkinshrtuukasyu;
    }

    public void setZrnteikishrkinshrtuukasyu(String pZrnteikishrkinshrtuukasyu) {
        zrnteikishrkinshrtuukasyu = pZrnteikishrkinshrtuukasyu;
    }

    private String zrnnnknsnpssyhknsyukigou;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNNNKNSNPSSYHKNSYUKIGOU)
    public String getZrnnnknsnpssyhknsyukigou() {
        return zrnnnknsnpssyhknsyukigou;
    }

    public void setZrnnnknsnpssyhknsyukigou(String pZrnnnknsnpssyhknsyukigou) {
        zrnnnknsnpssyhknsyukigou = pZrnnnknsnpssyhknsyukigou;
    }

    private String zrnnnknsnpssyhknkkn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNNNKNSNPSSYHKNKKN)
    public String getZrnnnknsnpssyhknkkn() {
        return zrnnnknsnpssyhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnnknsnpssyhknkkn(String pZrnnnknsnpssyhknkkn) {
        zrnnnknsnpssyhknkkn = pZrnnnknsnpssyhknkkn;
    }

    private String zrnnnknsnpssyphrkkikn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNNNKNSNPSSYPHRKKIKN)
    public String getZrnnnknsnpssyphrkkikn() {
        return zrnnnknsnpssyphrkkikn;
    }

    public void setZrnnnknsnpssyphrkkikn(String pZrnnnknsnpssyphrkkikn) {
        zrnnnknsnpssyphrkkikn = pZrnnnknsnpssyphrkkikn;
    }

    private String zrnnnknsnpssysaimnkkykhyj;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNNNKNSNPSSYSAIMNKKYKHYJ)
    public String getZrnnnknsnpssysaimnkkykhyj() {
        return zrnnnknsnpssysaimnkkykhyj;
    }

    public void setZrnnnknsnpssysaimnkkykhyj(String pZrnnnknsnpssysaimnkkykhyj) {
        zrnnnknsnpssysaimnkkykhyj = pZrnnnknsnpssysaimnkkykhyj;
    }

    private String zrnnknsnpssyhrkkskbn;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNNKNSNPSSYHRKKSKBN)
    public String getZrnnknsnpssyhrkkskbn() {
        return zrnnknsnpssyhrkkskbn;
    }

    public void setZrnnknsnpssyhrkkskbn(String pZrnnknsnpssyhrkkskbn) {
        zrnnknsnpssyhrkkskbn = pZrnnknsnpssyhrkkskbn;
    }

    private String zrnnnknsnpssyhhknnen;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNNNKNSNPSSYHHKNNEN)
    public String getZrnnnknsnpssyhhknnen() {
        return zrnnnknsnpssyhhknnen;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnnknsnpssyhhknnen(String pZrnnnknsnpssyhhknnen) {
        zrnnnknsnpssyhhknnen = pZrnnnknsnpssyhhknnen;
    }

    private BizNumber zrnnnknsnpssyitijibrpkyktk;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNNNKNSNPSSYITIJIBRPKYKTK)
    public BizNumber getZrnnnknsnpssyitijibrpkyktk() {
        return zrnnnknsnpssyitijibrpkyktk;
    }

    public void setZrnnnknsnpssyitijibrpkyktk(BizNumber pZrnnnknsnpssyitijibrpkyktk) {
        zrnnnknsnpssyitijibrpkyktk = pZrnnnknsnpssyitijibrpkyktk;
    }

    private Long zrnnnknsnpssysyup;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNNNKNSNPSSYSYUP)
    public Long getZrnnnknsnpssysyup() {
        return zrnnnknsnpssysyup;
    }

    public void setZrnnnknsnpssysyup(Long pZrnnnknsnpssysyup) {
        zrnnnknsnpssysyup = pZrnnnknsnpssysyup;
    }

    private BizNumber zrnnnknsnpssykawaseraten5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNNNKNSNPSSYKAWASERATEN5)
    public BizNumber getZrnnnknsnpssykawaseraten5() {
        return zrnnnknsnpssykawaseraten5;
    }

    public void setZrnnnknsnpssykawaseraten5(BizNumber pZrnnnknsnpssykawaseraten5) {
        zrnnnknsnpssykawaseraten5 = pZrnnnknsnpssykawaseraten5;
    }

    private Long zrnzennoup;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNZENNOUP)
    public Long getZrnzennoup() {
        return zrnzennoup;
    }

    public void setZrnzennoup(Long pZrnzennoup) {
        zrnzennoup = pZrnzennoup;
    }

    private String zrnyobiv25;

    @Column(name=GenZT_BosyuuDrtenHoyuuKykRn.ZRNYOBIV25)
    public String getZrnyobiv25() {
        return zrnyobiv25;
    }

    public void setZrnyobiv25(String pZrnyobiv25) {
        zrnyobiv25 = pZrnyobiv25;
    }
}
package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_KydGWKykInfoTy;
import yuyu.def.db.id.PKZT_KydGWKykInfoTy;
import yuyu.def.db.meta.GenQZT_KydGWKykInfoTy;
import yuyu.def.db.meta.QZT_KydGWKykInfoTy;

/**
 * 共同ＧＷ用契約情報Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KydGWKykInfoTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KydGWKykInfoTy}</td><td colspan="3">共同ＧＷ用契約情報Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_KydGWKykInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyurui2keta ztyhknsyurui2keta}</td><td>（中継用）保険種類（２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinkeizkkbn ztysinkeizkkbn}</td><td>（中継用）新規継続区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuhosyucd ztysyuhosyucd}</td><td>（中継用）主契約保種コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymdhnaisyoumeicd ztymdhnaisyoumeicd}</td><td>（中継用）窓販用愛称名コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyouhncd ztysyouhncd}</td><td>（中継用）商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymusymd ztymusymd}</td><td>（中継用）申込年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykseirituymd ztykykseirituymd}</td><td>（中継用）契約成立年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysekininkaisiymd ztysekininkaisiymd}</td><td>（中継用）責任開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaipymd ztysyokaipymd}</td><td>（中継用）初回Ｐ入金年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjnkojinkbn ztyhjnkojinkbn}</td><td>（中継用）法人個人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkhuhukbn ztyhrkhuhukbn}</td><td>（中継用）払込方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkymd ztyhrkymd}</td><td>（中継用）払込日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeip2 ztygoukeip2}</td><td>（中継用）合計保険料２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitijibrp ztyitijibrp}</td><td>（中継用）一時払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybnkaisuu ztybnkaisuu}</td><td>（中継用）分割回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnsyuruikbn ztybnsyuruikbn}</td><td>（中継用）分割種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnkyk1kaip ztybnkyk1kaip}</td><td>（中継用）分割払契約１回分保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv20 ztyyobiv20}</td><td>（中継用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuhknkknkbn ztysyuhknkknkbn}</td><td>（中継用）主契約保険期間区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuhknkkn ztysyuhknkkn}</td><td>（中継用）主契約保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuhrkkknkbn ztysyuhrkkknkbn}</td><td>（中継用）主契約払込期間区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuhrkkkn ztysyuhrkkkn}</td><td>（中継用）主契約払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyus ztysyus}</td><td>（中継用）主契約保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyunm ztysyunm}</td><td>（中継用）主契約名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyidojiyukbn ztyidojiyukbn}</td><td>（中継用）異動事由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoumetucd ztysyoumetucd}</td><td>（中継用）消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyidokaiyakuymd ztyidokaiyakuymd}</td><td>（中継用）異動解約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymankiymd ztymankiymd}</td><td>（中継用）満期年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysibous ztysibous}</td><td>（中継用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyidoukaiyakup ztyidoukaiyakup}</td><td>（中継用）異動解約保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukinkbn ztysyukinkbn}</td><td>（中継用）集金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaitoukbn ztyhaitoukbn}</td><td>（中継用）配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycreditcardhrkbn ztycreditcardhrkbn}</td><td>（中継用）クレジットカード払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkjykbn ztytkjykbn}</td><td>（中継用）特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinsakbn ztysinsakbn}</td><td>（中継用）診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeiseitekikakuhyj ztyzeiseitekikakuhyj}</td><td>（中継用）税制適格表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylivhukauhyj ztylivhukauhyj}</td><td>（中継用）リビングニーズ付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrizmentyouhyj ztyhrizmentyouhyj}</td><td>（中継用）払済延長表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykisokyknkshrhsykn ztykisokyknkshrhsykn}</td><td>（中継用）基礎契約年金支払保証期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrkknkbn ztynkshrkknkbn}</td><td>（中継用）年金支払期間区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrkknnen ztynkshrkknnen}</td><td>（中継用）年金支払期間年</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksueokikn ztynksueokikn}</td><td>（中継用）年金据置期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrstartymd ztynkshrstartymd}</td><td>（中継用）年金支払開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkuketorininkbn ztynkuketorininkbn}</td><td>（中継用）年金受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoup ztyzennoup}</td><td>（中継用）前納保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzennouendym ztyzennouendym}</td><td>（中継用）前納終了年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikaiyakuhrkn ztyteikaiyakuhrkn}</td><td>（中継用）低解約返戻金期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosno ztymosno}</td><td>（中継用）申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytratkisyacd1 ztytratkisyacd1}</td><td>（中継用）取扱者コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytratkisyacd2 ztytratkisyacd2}</td><td>（中継用）取扱者コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairiten1cd ztydairiten1cd}</td><td>（中継用）代理店１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairiten2cd ztydairiten2cd}</td><td>（中継用）代理店２コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsudirtnatkikeitaikbn ztybsudirtnatkikeitaikbn}</td><td>（中継用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyudiritnatkiwari1 ztybsyudiritnatkiwari1}</td><td>（中継用）募集代理店扱割合１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybsyudiritnatkiwari2 ztybsyudiritnatkiwari2}</td><td>（中継用）募集代理店扱割合２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv20x2 ztyyobiv20x2}</td><td>（中継用）予備項目Ｖ２０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytktyuutohukahyj ztytktyuutohukahyj}</td><td>（中継用）特約中途付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksuu ztytksuu}</td><td>（中継用）特約数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhosyucd1 ztytkhosyucd1}</td><td>（中継用）特約保種コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytknm1 ztytknm1}</td><td>（中継用）特約名称１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytks1 ztytks1}</td><td>（中継用）特約保険金額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytkhknkknkbn1 ztytkhknkknkbn1}</td><td>（中継用）特約保険期間区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkkn1 ztytkhknkkn1}</td><td>（中継用）特約保険期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkknkbn1 ztytkhrkkknkbn1}</td><td>（中継用）特約払込期間区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkkn1 ztytkhrkkkn1}</td><td>（中継用）特約払込期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhosyucd2 ztytkhosyucd2}</td><td>（中継用）特約保種コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytknm2 ztytknm2}</td><td>（中継用）特約名称２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytks2 ztytks2}</td><td>（中継用）特約保険金額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytkhknkknkbn2 ztytkhknkknkbn2}</td><td>（中継用）特約保険期間区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkkn2 ztytkhknkkn2}</td><td>（中継用）特約保険期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkknkbn2 ztytkhrkkknkbn2}</td><td>（中継用）特約払込期間区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkkn2 ztytkhrkkkn2}</td><td>（中継用）特約払込期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhosyucd3 ztytkhosyucd3}</td><td>（中継用）特約保種コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytknm3 ztytknm3}</td><td>（中継用）特約名称３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytks3 ztytks3}</td><td>（中継用）特約保険金額３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytkhknkknkbn3 ztytkhknkknkbn3}</td><td>（中継用）特約保険期間区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkkn3 ztytkhknkkn3}</td><td>（中継用）特約保険期間３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkknkbn3 ztytkhrkkknkbn3}</td><td>（中継用）特約払込期間区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkkn3 ztytkhrkkkn3}</td><td>（中継用）特約払込期間３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhosyucd4 ztytkhosyucd4}</td><td>（中継用）特約保種コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytknm4 ztytknm4}</td><td>（中継用）特約名称４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytks4 ztytks4}</td><td>（中継用）特約保険金額４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytkhknkknkbn4 ztytkhknkknkbn4}</td><td>（中継用）特約保険期間区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkkn4 ztytkhknkkn4}</td><td>（中継用）特約保険期間４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkknkbn4 ztytkhrkkknkbn4}</td><td>（中継用）特約払込期間区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkkn4 ztytkhrkkkn4}</td><td>（中継用）特約払込期間４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhosyucd5 ztytkhosyucd5}</td><td>（中継用）特約保種コード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytknm5 ztytknm5}</td><td>（中継用）特約名称５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytks5 ztytks5}</td><td>（中継用）特約保険金額５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytkhknkknkbn5 ztytkhknkknkbn5}</td><td>（中継用）特約保険期間区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkkn5 ztytkhknkkn5}</td><td>（中継用）特約保険期間５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkknkbn5 ztytkhrkkknkbn5}</td><td>（中継用）特約払込期間区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkkn5 ztytkhrkkkn5}</td><td>（中継用）特約払込期間５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhosyucd6 ztytkhosyucd6}</td><td>（中継用）特約保種コード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytknm6 ztytknm6}</td><td>（中継用）特約名称６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytks6 ztytks6}</td><td>（中継用）特約保険金額６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytkhknkknkbn6 ztytkhknkknkbn6}</td><td>（中継用）特約保険期間区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhknkkn6 ztytkhknkkn6}</td><td>（中継用）特約保険期間６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkknkbn6 ztytkhrkkknkbn6}</td><td>（中継用）特約払込期間区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkhrkkkn6 ztytkhrkkkn6}</td><td>（中継用）特約払込期間６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktnm ztysbuktnm}</td><td>（中継用）死亡受取人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjsbuktnm ztykjsbuktnm}</td><td>（中継用）漢字死亡受取人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbukttdk ztysbukttdk}</td><td>（中継用）死亡受取人続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktnin ztysbuktnin}</td><td>（中継用）死亡受取人人数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv28 ztyyobiv28}</td><td>（中継用）予備項目Ｖ２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyno7keta ztyyno7keta}</td><td>（中継用）郵便番号（７桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytelnokydgw ztytelnokydgw}</td><td>（中継用）電話番号（共同ＧＷ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmknkydgw ztykyknmknkydgw}</td><td>（中継用）契約者名（カナ）（共同ＧＷ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseiymd ztykyksyaseiymd}</td><td>（中継用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseikbn ztykyksyaseikbn}</td><td>（中継用）契約者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsinkihontikucd ztytsinkihontikucd}</td><td>（中継用）通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykadrkj50 ztykykadrkj50}</td><td>（中継用）契約者漢字住所５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkjkydgw ztykyknmkjkydgw}</td><td>（中継用）契約者名（漢字）（共同ＧＷ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknmei ztyhhknmei}</td><td>（中継用）被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj ztyhhknnmkj}</td><td>（中継用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseiymd ztyhhknseiymd}</td><td>（中継用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen ztyhhknnen}</td><td>（中継用）被保険者年齢</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkntdk ztyhhkntdk}</td><td>（中継用）被保険者続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzsyurui ztykzsyurui}</td><td>（中継用）口座種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouzano7keta ztykouzano7keta}</td><td>（中継用）口座番号（７桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaebankcd ztykzhurikaebankcd}</td><td>（中継用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaesitencd ztykzhurikaesitencd}</td><td>（中継用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanyuusyaknrno ztykanyuusyaknrno}</td><td>（中継用）加入者管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksiboumeighnkhyj ztykyksiboumeighnkhyj}</td><td>（中継用）契約者死亡名義変更表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv11 ztyyobiv11}</td><td>（中継用）予備項目Ｖ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnkuktkbn ztymnkuktkbn}</td><td>（中継用）満期受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnkuktnm1 ztymnkuktnm1}</td><td>（中継用）満期受取人名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnkuktnm2 ztymnkuktnm2}</td><td>（中継用）満期受取人名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnkuktnm3 ztymnkuktnm3}</td><td>（中継用）満期受取人名３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnkuktnm4 ztymnkuktnm4}</td><td>（中継用）満期受取人名４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktkbn ztysbuktkbn}</td><td>（中継用）死亡受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktnm1 ztysbuktnm1}</td><td>（中継用）死亡受取人名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktnm2 ztysbuktnm2}</td><td>（中継用）死亡受取人名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktnm3 ztysbuktnm3}</td><td>（中継用）死亡受取人名３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktnm4 ztysbuktnm4}</td><td>（中継用）死亡受取人名４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv20x3 ztyyobiv20x3}</td><td>（中継用）予備項目Ｖ２０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoriymd ztysyoriymd}</td><td>（中継用）処理年月日</td><td align="center">{@link PKZT_KydGWKykInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfksnctrlkh ztykykmfksnctrlkh}</td><td>（中継用）契約ＭＦ更新ＣＴＲ（保全）</td><td align="center">{@link PKZT_KydGWKykInfoTy ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymkhtoutatuymd ztymkhtoutatuymd}</td><td>（中継用）目標到達年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykhrkmtuuka ztykykhrkmtuuka}</td><td>（中継用）契約者振込通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykhrkmgk ztykykhrkmgk}</td><td>（中継用）契約者振込金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikbn ztyikkatubaraikbn}</td><td>（中継用）一括払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikaisuu ztyikkatubaraikaisuu}</td><td>（中継用）一括払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytousyokykjiyennyknrate ztytousyokykjiyennyknrate}</td><td>（中継用）当初契約時円入金レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyrendouritu ztyrendouritu}</td><td>（中継用）連動率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyteikishrritu ztyteikishrritu}</td><td>（中継用）定期支払率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykosyasbskttdkstartflg ztykosyasbskttdkstartflg}</td><td>（中継用）個社死亡請求手続き開始フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykosyasbukthukusuflg ztykosyasbukthukusuflg}</td><td>（中継用）個社死亡受取人複数フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykosyahhknsbymd ztykosyahhknsbymd}</td><td>（中継用）個社被保険者死亡日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykosyassksjyuriymd ztykosyassksjyuriymd}</td><td>（中継用）個社保険金請求書受理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykosyasshrkanryoymd ztykosyasshrkanryoymd}</td><td>（中継用）個社保険金支払完了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykosyasbuktseiymd ztykosyasbuktseiymd}</td><td>（中継用）個社死亡保険金受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykosyasbuktkjadr ztykosyasbuktkjadr}</td><td>（中継用）個社死亡保険金受取人住所漢字</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykosyasbukttelno ztykosyasbukttelno}</td><td>（中継用）個社死亡保険金受取人電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv252 ztyyobiv252}</td><td>（中継用）予備項目Ｖ２５２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KydGWKykInfoTy
 * @see     PKZT_KydGWKykInfoTy
 * @see     QZT_KydGWKykInfoTy
 * @see     GenQZT_KydGWKykInfoTy
 */
@MappedSuperclass
@Table(name=GenZT_KydGWKykInfoTy.TABLE_NAME)
@IdClass(value=PKZT_KydGWKykInfoTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_KydGWKykInfoTy extends AbstractExDBEntity<ZT_KydGWKykInfoTy, PKZT_KydGWKykInfoTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KydGWKykInfoTy";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHKNSYURUI2KETA        = "ztyhknsyurui2keta";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYSINKEIZKKBN           = "ztysinkeizkkbn";
    public static final String ZTYSYUHOSYUCD            = "ztysyuhosyucd";
    public static final String ZTYMDHNAISYOUMEICD       = "ztymdhnaisyoumeicd";
    public static final String ZTYSYOUHNCD              = "ztysyouhncd";
    public static final String ZTYMUSYMD                = "ztymusymd";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYKYKSEIRITUYMD         = "ztykykseirituymd";
    public static final String ZTYSEKININKAISIYMD       = "ztysekininkaisiymd";
    public static final String ZTYSYOKAIPYMD            = "ztysyokaipymd";
    public static final String ZTYHJNKOJINKBN           = "ztyhjnkojinkbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYHRKHUHUKBN            = "ztyhrkhuhukbn";
    public static final String ZTYHRKYMD                = "ztyhrkymd";
    public static final String ZTYGOUKEIP2              = "ztygoukeip2";
    public static final String ZTYITIJIBRP              = "ztyitijibrp";
    public static final String ZTYBNKAISUU              = "ztybnkaisuu";
    public static final String ZTYBNSYURUIKBN           = "ztybnsyuruikbn";
    public static final String ZTYBNKYK1KAIP            = "ztybnkyk1kaip";
    public static final String ZTYYOBIV20               = "ztyyobiv20";
    public static final String ZTYSYUHKNKKNKBN          = "ztysyuhknkknkbn";
    public static final String ZTYSYUHKNKKN             = "ztysyuhknkkn";
    public static final String ZTYSYUHRKKKNKBN          = "ztysyuhrkkknkbn";
    public static final String ZTYSYUHRKKKN             = "ztysyuhrkkkn";
    public static final String ZTYSYUS                  = "ztysyus";
    public static final String ZTYSYUNM                 = "ztysyunm";
    public static final String ZTYIDOJIYUKBN            = "ztyidojiyukbn";
    public static final String ZTYSYOUMETUCD            = "ztysyoumetucd";
    public static final String ZTYIDOKAIYAKUYMD         = "ztyidokaiyakuymd";
    public static final String ZTYMANKIYMD              = "ztymankiymd";
    public static final String ZTYSIBOUS                = "ztysibous";
    public static final String ZTYIDOUKAIYAKUP          = "ztyidoukaiyakup";
    public static final String ZTYSYUKINKBN             = "ztysyukinkbn";
    public static final String ZTYHAITOUKBN             = "ztyhaitoukbn";
    public static final String ZTYCREDITCARDHRKBN       = "ztycreditcardhrkbn";
    public static final String ZTYTKJYKBN               = "ztytkjykbn";
    public static final String ZTYSINSAKBN              = "ztysinsakbn";
    public static final String ZTYZEISEITEKIKAKUHYJ     = "ztyzeiseitekikakuhyj";
    public static final String ZTYLIVHUKAUHYJ           = "ztylivhukauhyj";
    public static final String ZTYHRIZMENTYOUHYJ        = "ztyhrizmentyouhyj";
    public static final String ZTYKISOKYKNKSHRHSYKN     = "ztykisokyknkshrhsykn";
    public static final String ZTYNKSHRKKNKBN           = "ztynkshrkknkbn";
    public static final String ZTYNKSHRKKNNEN           = "ztynkshrkknnen";
    public static final String ZTYNKSUEOKIKN            = "ztynksueokikn";
    public static final String ZTYNKSHRSTARTYMD         = "ztynkshrstartymd";
    public static final String ZTYNKUKETORININKBN       = "ztynkuketorininkbn";
    public static final String ZTYZENNOUP               = "ztyzennoup";
    public static final String ZTYZENNOUENDYM           = "ztyzennouendym";
    public static final String ZTYTEIKAIYAKUHRKN        = "ztyteikaiyakuhrkn";
    public static final String ZTYMOSNO                 = "ztymosno";
    public static final String ZTYTRATKISYACD1          = "ztytratkisyacd1";
    public static final String ZTYTRATKISYACD2          = "ztytratkisyacd2";
    public static final String ZTYDAIRITEN1CD           = "ztydairiten1cd";
    public static final String ZTYDAIRITEN2CD           = "ztydairiten2cd";
    public static final String ZTYBSUDIRTNATKIKEITAIKBN = "ztybsudirtnatkikeitaikbn";
    public static final String ZTYBSYUDIRITNATKIWARI1   = "ztybsyudiritnatkiwari1";
    public static final String ZTYBSYUDIRITNATKIWARI2   = "ztybsyudiritnatkiwari2";
    public static final String ZTYYOBIV20X2             = "ztyyobiv20x2";
    public static final String ZTYTKTYUUTOHUKAHYJ       = "ztytktyuutohukahyj";
    public static final String ZTYTKSUU                 = "ztytksuu";
    public static final String ZTYTKHOSYUCD1            = "ztytkhosyucd1";
    public static final String ZTYTKNM1                 = "ztytknm1";
    public static final String ZTYTKS1                  = "ztytks1";
    public static final String ZTYTKHKNKKNKBN1          = "ztytkhknkknkbn1";
    public static final String ZTYTKHKNKKN1             = "ztytkhknkkn1";
    public static final String ZTYTKHRKKKNKBN1          = "ztytkhrkkknkbn1";
    public static final String ZTYTKHRKKKN1             = "ztytkhrkkkn1";
    public static final String ZTYTKHOSYUCD2            = "ztytkhosyucd2";
    public static final String ZTYTKNM2                 = "ztytknm2";
    public static final String ZTYTKS2                  = "ztytks2";
    public static final String ZTYTKHKNKKNKBN2          = "ztytkhknkknkbn2";
    public static final String ZTYTKHKNKKN2             = "ztytkhknkkn2";
    public static final String ZTYTKHRKKKNKBN2          = "ztytkhrkkknkbn2";
    public static final String ZTYTKHRKKKN2             = "ztytkhrkkkn2";
    public static final String ZTYTKHOSYUCD3            = "ztytkhosyucd3";
    public static final String ZTYTKNM3                 = "ztytknm3";
    public static final String ZTYTKS3                  = "ztytks3";
    public static final String ZTYTKHKNKKNKBN3          = "ztytkhknkknkbn3";
    public static final String ZTYTKHKNKKN3             = "ztytkhknkkn3";
    public static final String ZTYTKHRKKKNKBN3          = "ztytkhrkkknkbn3";
    public static final String ZTYTKHRKKKN3             = "ztytkhrkkkn3";
    public static final String ZTYTKHOSYUCD4            = "ztytkhosyucd4";
    public static final String ZTYTKNM4                 = "ztytknm4";
    public static final String ZTYTKS4                  = "ztytks4";
    public static final String ZTYTKHKNKKNKBN4          = "ztytkhknkknkbn4";
    public static final String ZTYTKHKNKKN4             = "ztytkhknkkn4";
    public static final String ZTYTKHRKKKNKBN4          = "ztytkhrkkknkbn4";
    public static final String ZTYTKHRKKKN4             = "ztytkhrkkkn4";
    public static final String ZTYTKHOSYUCD5            = "ztytkhosyucd5";
    public static final String ZTYTKNM5                 = "ztytknm5";
    public static final String ZTYTKS5                  = "ztytks5";
    public static final String ZTYTKHKNKKNKBN5          = "ztytkhknkknkbn5";
    public static final String ZTYTKHKNKKN5             = "ztytkhknkkn5";
    public static final String ZTYTKHRKKKNKBN5          = "ztytkhrkkknkbn5";
    public static final String ZTYTKHRKKKN5             = "ztytkhrkkkn5";
    public static final String ZTYTKHOSYUCD6            = "ztytkhosyucd6";
    public static final String ZTYTKNM6                 = "ztytknm6";
    public static final String ZTYTKS6                  = "ztytks6";
    public static final String ZTYTKHKNKKNKBN6          = "ztytkhknkknkbn6";
    public static final String ZTYTKHKNKKN6             = "ztytkhknkkn6";
    public static final String ZTYTKHRKKKNKBN6          = "ztytkhrkkknkbn6";
    public static final String ZTYTKHRKKKN6             = "ztytkhrkkkn6";
    public static final String ZTYSBUKTNM               = "ztysbuktnm";
    public static final String ZTYKJSBUKTNM             = "ztykjsbuktnm";
    public static final String ZTYSBUKTTDK              = "ztysbukttdk";
    public static final String ZTYSBUKTNIN              = "ztysbuktnin";
    public static final String ZTYYOBIV28               = "ztyyobiv28";
    public static final String ZTYYNO7KETA              = "ztyyno7keta";
    public static final String ZTYTELNOKYDGW            = "ztytelnokydgw";
    public static final String ZTYKYKNMKNKYDGW          = "ztykyknmknkydgw";
    public static final String ZTYKYKSYASEIYMD          = "ztykyksyaseiymd";
    public static final String ZTYKYKSYASEIKBN          = "ztykyksyaseikbn";
    public static final String ZTYTSINKIHONTIKUCD       = "ztytsinkihontikucd";
    public static final String ZTYKYKADRKJ50            = "ztykykadrkj50";
    public static final String ZTYKYKNMKJKYDGW          = "ztykyknmkjkydgw";
    public static final String ZTYHHKNMEI               = "ztyhhknmei";
    public static final String ZTYHHKNNMKJ              = "ztyhhknnmkj";
    public static final String ZTYHHKNSEIYMD            = "ztyhhknseiymd";
    public static final String ZTYHHKNNEN               = "ztyhhknnen";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHHKNTDK               = "ztyhhkntdk";
    public static final String ZTYKZSYURUI              = "ztykzsyurui";
    public static final String ZTYKOUZANO7KETA          = "ztykouzano7keta";
    public static final String ZTYKZHURIKAEBANKCD       = "ztykzhurikaebankcd";
    public static final String ZTYKZHURIKAESITENCD      = "ztykzhurikaesitencd";
    public static final String ZTYKANYUUSYAKNRNO        = "ztykanyuusyaknrno";
    public static final String ZTYKYKSIBOUMEIGHNKHYJ    = "ztykyksiboumeighnkhyj";
    public static final String ZTYYOBIV11               = "ztyyobiv11";
    public static final String ZTYMNKUKTKBN             = "ztymnkuktkbn";
    public static final String ZTYMNKUKTNM1             = "ztymnkuktnm1";
    public static final String ZTYMNKUKTNM2             = "ztymnkuktnm2";
    public static final String ZTYMNKUKTNM3             = "ztymnkuktnm3";
    public static final String ZTYMNKUKTNM4             = "ztymnkuktnm4";
    public static final String ZTYSBUKTKBN              = "ztysbuktkbn";
    public static final String ZTYSBUKTNM1              = "ztysbuktnm1";
    public static final String ZTYSBUKTNM2              = "ztysbuktnm2";
    public static final String ZTYSBUKTNM3              = "ztysbuktnm3";
    public static final String ZTYSBUKTNM4              = "ztysbuktnm4";
    public static final String ZTYYOBIV20X3             = "ztyyobiv20x3";
    public static final String ZTYSYORIYMD              = "ztysyoriymd";
    public static final String ZTYKYKMFKSNCTRLKH        = "ztykykmfksnctrlkh";
    public static final String ZTYMKHTOUTATUYMD         = "ztymkhtoutatuymd";
    public static final String ZTYKYKHRKMTUUKA          = "ztykykhrkmtuuka";
    public static final String ZTYKYKHRKMGK             = "ztykykhrkmgk";
    public static final String ZTYIKKATUBARAIKBN        = "ztyikkatubaraikbn";
    public static final String ZTYIKKATUBARAIKAISUU     = "ztyikkatubaraikaisuu";
    public static final String ZTYTOUSYOKYKJIYENNYKNRATE = "ztytousyokykjiyennyknrate";
    public static final String ZTYRENDOURITU            = "ztyrendouritu";
    public static final String ZTYTEIKISHRRITU          = "ztyteikishrritu";
    public static final String ZTYKOSYASBSKTTDKSTARTFLG = "ztykosyasbskttdkstartflg";
    public static final String ZTYKOSYASBUKTHUKUSUFLG   = "ztykosyasbukthukusuflg";
    public static final String ZTYKOSYAHHKNSBYMD        = "ztykosyahhknsbymd";
    public static final String ZTYKOSYASSKSJYURIYMD     = "ztykosyassksjyuriymd";
    public static final String ZTYKOSYASSHRKANRYOYMD    = "ztykosyasshrkanryoymd";
    public static final String ZTYKOSYASBUKTSEIYMD      = "ztykosyasbuktseiymd";
    public static final String ZTYKOSYASBUKTKJADR       = "ztykosyasbuktkjadr";
    public static final String ZTYKOSYASBUKTTELNO       = "ztykosyasbukttelno";
    public static final String ZTYYOBIV252              = "ztyyobiv252";

    private final PKZT_KydGWKykInfoTy primaryKey;

    public GenZT_KydGWKykInfoTy() {
        primaryKey = new PKZT_KydGWKykInfoTy();
    }

    public GenZT_KydGWKykInfoTy(
        String pZtysyono,
        String pZtysyoriymd,
        Long pZtykykmfksnctrlkh
    ) {
        primaryKey = new PKZT_KydGWKykInfoTy(
            pZtysyono,
            pZtysyoriymd,
            pZtykykmfksnctrlkh
        );
    }

    @Transient
    @Override
    public PKZT_KydGWKykInfoTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KydGWKykInfoTy> getMetaClass() {
        return QZT_KydGWKykInfoTy.class;
    }

    @Id
    @Column(name=GenZT_KydGWKykInfoTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyhknsyurui2keta;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYHKNSYURUI2KETA)
    public String getZtyhknsyurui2keta() {
        return ztyhknsyurui2keta;
    }

    public void setZtyhknsyurui2keta(String pZtyhknsyurui2keta) {
        ztyhknsyurui2keta = pZtyhknsyurui2keta;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztysinkeizkkbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSINKEIZKKBN)
    public String getZtysinkeizkkbn() {
        return ztysinkeizkkbn;
    }

    public void setZtysinkeizkkbn(String pZtysinkeizkkbn) {
        ztysinkeizkkbn = pZtysinkeizkkbn;
    }

    private String ztysyuhosyucd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSYUHOSYUCD)
    public String getZtysyuhosyucd() {
        return ztysyuhosyucd;
    }

    public void setZtysyuhosyucd(String pZtysyuhosyucd) {
        ztysyuhosyucd = pZtysyuhosyucd;
    }

    private String ztymdhnaisyoumeicd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYMDHNAISYOUMEICD)
    public String getZtymdhnaisyoumeicd() {
        return ztymdhnaisyoumeicd;
    }

    public void setZtymdhnaisyoumeicd(String pZtymdhnaisyoumeicd) {
        ztymdhnaisyoumeicd = pZtymdhnaisyoumeicd;
    }

    private String ztysyouhncd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSYOUHNCD)
    public String getZtysyouhncd() {
        return ztysyouhncd;
    }

    public void setZtysyouhncd(String pZtysyouhncd) {
        ztysyouhncd = pZtysyouhncd;
    }

    private String ztymusymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYMUSYMD)
    public String getZtymusymd() {
        return ztymusymd;
    }

    public void setZtymusymd(String pZtymusymd) {
        ztymusymd = pZtymusymd;
    }

    private String ztykykymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztykykseirituymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKYKSEIRITUYMD)
    public String getZtykykseirituymd() {
        return ztykykseirituymd;
    }

    public void setZtykykseirituymd(String pZtykykseirituymd) {
        ztykykseirituymd = pZtykykseirituymd;
    }

    private String ztysekininkaisiymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSEKININKAISIYMD)
    public String getZtysekininkaisiymd() {
        return ztysekininkaisiymd;
    }

    public void setZtysekininkaisiymd(String pZtysekininkaisiymd) {
        ztysekininkaisiymd = pZtysekininkaisiymd;
    }

    private String ztysyokaipymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSYOKAIPYMD)
    public String getZtysyokaipymd() {
        return ztysyokaipymd;
    }

    public void setZtysyokaipymd(String pZtysyokaipymd) {
        ztysyokaipymd = pZtysyokaipymd;
    }

    private String ztyhjnkojinkbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYHJNKOJINKBN)
    public String getZtyhjnkojinkbn() {
        return ztyhjnkojinkbn;
    }

    public void setZtyhjnkojinkbn(String pZtyhjnkojinkbn) {
        ztyhjnkojinkbn = pZtyhjnkojinkbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztyhrkhuhukbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYHRKHUHUKBN)
    public String getZtyhrkhuhukbn() {
        return ztyhrkhuhukbn;
    }

    public void setZtyhrkhuhukbn(String pZtyhrkhuhukbn) {
        ztyhrkhuhukbn = pZtyhrkhuhukbn;
    }

    private String ztyhrkymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYHRKYMD)
    public String getZtyhrkymd() {
        return ztyhrkymd;
    }

    public void setZtyhrkymd(String pZtyhrkymd) {
        ztyhrkymd = pZtyhrkymd;
    }

    private Long ztygoukeip2;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYGOUKEIP2)
    public Long getZtygoukeip2() {
        return ztygoukeip2;
    }

    public void setZtygoukeip2(Long pZtygoukeip2) {
        ztygoukeip2 = pZtygoukeip2;
    }

    private Long ztyitijibrp;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYITIJIBRP)
    public Long getZtyitijibrp() {
        return ztyitijibrp;
    }

    public void setZtyitijibrp(Long pZtyitijibrp) {
        ztyitijibrp = pZtyitijibrp;
    }

    private String ztybnkaisuu;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYBNKAISUU)
    public String getZtybnkaisuu() {
        return ztybnkaisuu;
    }

    public void setZtybnkaisuu(String pZtybnkaisuu) {
        ztybnkaisuu = pZtybnkaisuu;
    }

    private String ztybnsyuruikbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYBNSYURUIKBN)
    public String getZtybnsyuruikbn() {
        return ztybnsyuruikbn;
    }

    public void setZtybnsyuruikbn(String pZtybnsyuruikbn) {
        ztybnsyuruikbn = pZtybnsyuruikbn;
    }

    private Long ztybnkyk1kaip;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYBNKYK1KAIP)
    public Long getZtybnkyk1kaip() {
        return ztybnkyk1kaip;
    }

    public void setZtybnkyk1kaip(Long pZtybnkyk1kaip) {
        ztybnkyk1kaip = pZtybnkyk1kaip;
    }

    private String ztyyobiv20;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYYOBIV20)
    public String getZtyyobiv20() {
        return ztyyobiv20;
    }

    public void setZtyyobiv20(String pZtyyobiv20) {
        ztyyobiv20 = pZtyyobiv20;
    }

    private String ztysyuhknkknkbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSYUHKNKKNKBN)
    public String getZtysyuhknkknkbn() {
        return ztysyuhknkknkbn;
    }

    public void setZtysyuhknkknkbn(String pZtysyuhknkknkbn) {
        ztysyuhknkknkbn = pZtysyuhknkknkbn;
    }

    private String ztysyuhknkkn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSYUHKNKKN)
    public String getZtysyuhknkkn() {
        return ztysyuhknkkn;
    }

    public void setZtysyuhknkkn(String pZtysyuhknkkn) {
        ztysyuhknkkn = pZtysyuhknkkn;
    }

    private String ztysyuhrkkknkbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSYUHRKKKNKBN)
    public String getZtysyuhrkkknkbn() {
        return ztysyuhrkkknkbn;
    }

    public void setZtysyuhrkkknkbn(String pZtysyuhrkkknkbn) {
        ztysyuhrkkknkbn = pZtysyuhrkkknkbn;
    }

    private String ztysyuhrkkkn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSYUHRKKKN)
    public String getZtysyuhrkkkn() {
        return ztysyuhrkkkn;
    }

    public void setZtysyuhrkkkn(String pZtysyuhrkkkn) {
        ztysyuhrkkkn = pZtysyuhrkkkn;
    }

    private Long ztysyus;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSYUS)
    public Long getZtysyus() {
        return ztysyus;
    }

    public void setZtysyus(Long pZtysyus) {
        ztysyus = pZtysyus;
    }

    private String ztysyunm;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSYUNM)
    public String getZtysyunm() {
        return ztysyunm;
    }

    public void setZtysyunm(String pZtysyunm) {
        ztysyunm = pZtysyunm;
    }

    private String ztyidojiyukbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYIDOJIYUKBN)
    public String getZtyidojiyukbn() {
        return ztyidojiyukbn;
    }

    public void setZtyidojiyukbn(String pZtyidojiyukbn) {
        ztyidojiyukbn = pZtyidojiyukbn;
    }

    private String ztysyoumetucd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSYOUMETUCD)
    public String getZtysyoumetucd() {
        return ztysyoumetucd;
    }

    public void setZtysyoumetucd(String pZtysyoumetucd) {
        ztysyoumetucd = pZtysyoumetucd;
    }

    private String ztyidokaiyakuymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYIDOKAIYAKUYMD)
    public String getZtyidokaiyakuymd() {
        return ztyidokaiyakuymd;
    }

    public void setZtyidokaiyakuymd(String pZtyidokaiyakuymd) {
        ztyidokaiyakuymd = pZtyidokaiyakuymd;
    }

    private String ztymankiymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYMANKIYMD)
    public String getZtymankiymd() {
        return ztymankiymd;
    }

    public void setZtymankiymd(String pZtymankiymd) {
        ztymankiymd = pZtymankiymd;
    }

    private Long ztysibous;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSIBOUS)
    public Long getZtysibous() {
        return ztysibous;
    }

    public void setZtysibous(Long pZtysibous) {
        ztysibous = pZtysibous;
    }

    private Long ztyidoukaiyakup;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYIDOUKAIYAKUP)
    public Long getZtyidoukaiyakup() {
        return ztyidoukaiyakup;
    }

    public void setZtyidoukaiyakup(Long pZtyidoukaiyakup) {
        ztyidoukaiyakup = pZtyidoukaiyakup;
    }

    private String ztysyukinkbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSYUKINKBN)
    public String getZtysyukinkbn() {
        return ztysyukinkbn;
    }

    public void setZtysyukinkbn(String pZtysyukinkbn) {
        ztysyukinkbn = pZtysyukinkbn;
    }

    private String ztyhaitoukbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYHAITOUKBN)
    public String getZtyhaitoukbn() {
        return ztyhaitoukbn;
    }

    public void setZtyhaitoukbn(String pZtyhaitoukbn) {
        ztyhaitoukbn = pZtyhaitoukbn;
    }

    private String ztycreditcardhrkbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYCREDITCARDHRKBN)
    public String getZtycreditcardhrkbn() {
        return ztycreditcardhrkbn;
    }

    public void setZtycreditcardhrkbn(String pZtycreditcardhrkbn) {
        ztycreditcardhrkbn = pZtycreditcardhrkbn;
    }

    private String ztytkjykbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKJYKBN)
    public String getZtytkjykbn() {
        return ztytkjykbn;
    }

    public void setZtytkjykbn(String pZtytkjykbn) {
        ztytkjykbn = pZtytkjykbn;
    }

    private String ztysinsakbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSINSAKBN)
    public String getZtysinsakbn() {
        return ztysinsakbn;
    }

    public void setZtysinsakbn(String pZtysinsakbn) {
        ztysinsakbn = pZtysinsakbn;
    }

    private String ztyzeiseitekikakuhyj;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYZEISEITEKIKAKUHYJ)
    public String getZtyzeiseitekikakuhyj() {
        return ztyzeiseitekikakuhyj;
    }

    public void setZtyzeiseitekikakuhyj(String pZtyzeiseitekikakuhyj) {
        ztyzeiseitekikakuhyj = pZtyzeiseitekikakuhyj;
    }

    private String ztylivhukauhyj;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYLIVHUKAUHYJ)
    public String getZtylivhukauhyj() {
        return ztylivhukauhyj;
    }

    public void setZtylivhukauhyj(String pZtylivhukauhyj) {
        ztylivhukauhyj = pZtylivhukauhyj;
    }

    private String ztyhrizmentyouhyj;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYHRIZMENTYOUHYJ)
    public String getZtyhrizmentyouhyj() {
        return ztyhrizmentyouhyj;
    }

    public void setZtyhrizmentyouhyj(String pZtyhrizmentyouhyj) {
        ztyhrizmentyouhyj = pZtyhrizmentyouhyj;
    }

    private String ztykisokyknkshrhsykn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKISOKYKNKSHRHSYKN)
    public String getZtykisokyknkshrhsykn() {
        return ztykisokyknkshrhsykn;
    }

    public void setZtykisokyknkshrhsykn(String pZtykisokyknkshrhsykn) {
        ztykisokyknkshrhsykn = pZtykisokyknkshrhsykn;
    }

    private String ztynkshrkknkbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYNKSHRKKNKBN)
    public String getZtynkshrkknkbn() {
        return ztynkshrkknkbn;
    }

    public void setZtynkshrkknkbn(String pZtynkshrkknkbn) {
        ztynkshrkknkbn = pZtynkshrkknkbn;
    }

    private String ztynkshrkknnen;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYNKSHRKKNNEN)
    public String getZtynkshrkknnen() {
        return ztynkshrkknnen;
    }

    public void setZtynkshrkknnen(String pZtynkshrkknnen) {
        ztynkshrkknnen = pZtynkshrkknnen;
    }

    private String ztynksueokikn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYNKSUEOKIKN)
    public String getZtynksueokikn() {
        return ztynksueokikn;
    }

    public void setZtynksueokikn(String pZtynksueokikn) {
        ztynksueokikn = pZtynksueokikn;
    }

    private String ztynkshrstartymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYNKSHRSTARTYMD)
    public String getZtynkshrstartymd() {
        return ztynkshrstartymd;
    }

    public void setZtynkshrstartymd(String pZtynkshrstartymd) {
        ztynkshrstartymd = pZtynkshrstartymd;
    }

    private String ztynkuketorininkbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYNKUKETORININKBN)
    public String getZtynkuketorininkbn() {
        return ztynkuketorininkbn;
    }

    public void setZtynkuketorininkbn(String pZtynkuketorininkbn) {
        ztynkuketorininkbn = pZtynkuketorininkbn;
    }

    private Long ztyzennoup;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYZENNOUP)
    public Long getZtyzennoup() {
        return ztyzennoup;
    }

    public void setZtyzennoup(Long pZtyzennoup) {
        ztyzennoup = pZtyzennoup;
    }

    private String ztyzennouendym;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYZENNOUENDYM)
    public String getZtyzennouendym() {
        return ztyzennouendym;
    }

    public void setZtyzennouendym(String pZtyzennouendym) {
        ztyzennouendym = pZtyzennouendym;
    }

    private String ztyteikaiyakuhrkn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTEIKAIYAKUHRKN)
    public String getZtyteikaiyakuhrkn() {
        return ztyteikaiyakuhrkn;
    }

    public void setZtyteikaiyakuhrkn(String pZtyteikaiyakuhrkn) {
        ztyteikaiyakuhrkn = pZtyteikaiyakuhrkn;
    }

    private String ztymosno;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYMOSNO)
    public String getZtymosno() {
        return ztymosno;
    }

    public void setZtymosno(String pZtymosno) {
        ztymosno = pZtymosno;
    }

    private String ztytratkisyacd1;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTRATKISYACD1)
    public String getZtytratkisyacd1() {
        return ztytratkisyacd1;
    }

    public void setZtytratkisyacd1(String pZtytratkisyacd1) {
        ztytratkisyacd1 = pZtytratkisyacd1;
    }

    private String ztytratkisyacd2;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTRATKISYACD2)
    public String getZtytratkisyacd2() {
        return ztytratkisyacd2;
    }

    public void setZtytratkisyacd2(String pZtytratkisyacd2) {
        ztytratkisyacd2 = pZtytratkisyacd2;
    }

    private String ztydairiten1cd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYDAIRITEN1CD)
    public String getZtydairiten1cd() {
        return ztydairiten1cd;
    }

    public void setZtydairiten1cd(String pZtydairiten1cd) {
        ztydairiten1cd = pZtydairiten1cd;
    }

    private String ztydairiten2cd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYDAIRITEN2CD)
    public String getZtydairiten2cd() {
        return ztydairiten2cd;
    }

    public void setZtydairiten2cd(String pZtydairiten2cd) {
        ztydairiten2cd = pZtydairiten2cd;
    }

    private String ztybsudirtnatkikeitaikbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYBSUDIRTNATKIKEITAIKBN)
    public String getZtybsudirtnatkikeitaikbn() {
        return ztybsudirtnatkikeitaikbn;
    }

    public void setZtybsudirtnatkikeitaikbn(String pZtybsudirtnatkikeitaikbn) {
        ztybsudirtnatkikeitaikbn = pZtybsudirtnatkikeitaikbn;
    }

    private Long ztybsyudiritnatkiwari1;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYBSYUDIRITNATKIWARI1)
    public Long getZtybsyudiritnatkiwari1() {
        return ztybsyudiritnatkiwari1;
    }

    public void setZtybsyudiritnatkiwari1(Long pZtybsyudiritnatkiwari1) {
        ztybsyudiritnatkiwari1 = pZtybsyudiritnatkiwari1;
    }

    private Long ztybsyudiritnatkiwari2;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYBSYUDIRITNATKIWARI2)
    public Long getZtybsyudiritnatkiwari2() {
        return ztybsyudiritnatkiwari2;
    }

    public void setZtybsyudiritnatkiwari2(Long pZtybsyudiritnatkiwari2) {
        ztybsyudiritnatkiwari2 = pZtybsyudiritnatkiwari2;
    }

    private String ztyyobiv20x2;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYYOBIV20X2)
    public String getZtyyobiv20x2() {
        return ztyyobiv20x2;
    }

    public void setZtyyobiv20x2(String pZtyyobiv20x2) {
        ztyyobiv20x2 = pZtyyobiv20x2;
    }

    private String ztytktyuutohukahyj;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKTYUUTOHUKAHYJ)
    public String getZtytktyuutohukahyj() {
        return ztytktyuutohukahyj;
    }

    public void setZtytktyuutohukahyj(String pZtytktyuutohukahyj) {
        ztytktyuutohukahyj = pZtytktyuutohukahyj;
    }

    private String ztytksuu;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKSUU)
    public String getZtytksuu() {
        return ztytksuu;
    }

    public void setZtytksuu(String pZtytksuu) {
        ztytksuu = pZtytksuu;
    }

    private String ztytkhosyucd1;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHOSYUCD1)
    public String getZtytkhosyucd1() {
        return ztytkhosyucd1;
    }

    public void setZtytkhosyucd1(String pZtytkhosyucd1) {
        ztytkhosyucd1 = pZtytkhosyucd1;
    }

    private String ztytknm1;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKNM1)
    public String getZtytknm1() {
        return ztytknm1;
    }

    public void setZtytknm1(String pZtytknm1) {
        ztytknm1 = pZtytknm1;
    }

    private Long ztytks1;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKS1)
    public Long getZtytks1() {
        return ztytks1;
    }

    public void setZtytks1(Long pZtytks1) {
        ztytks1 = pZtytks1;
    }

    private String ztytkhknkknkbn1;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHKNKKNKBN1)
    public String getZtytkhknkknkbn1() {
        return ztytkhknkknkbn1;
    }

    public void setZtytkhknkknkbn1(String pZtytkhknkknkbn1) {
        ztytkhknkknkbn1 = pZtytkhknkknkbn1;
    }

    private String ztytkhknkkn1;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHKNKKN1)
    public String getZtytkhknkkn1() {
        return ztytkhknkkn1;
    }

    public void setZtytkhknkkn1(String pZtytkhknkkn1) {
        ztytkhknkkn1 = pZtytkhknkkn1;
    }

    private String ztytkhrkkknkbn1;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHRKKKNKBN1)
    public String getZtytkhrkkknkbn1() {
        return ztytkhrkkknkbn1;
    }

    public void setZtytkhrkkknkbn1(String pZtytkhrkkknkbn1) {
        ztytkhrkkknkbn1 = pZtytkhrkkknkbn1;
    }

    private String ztytkhrkkkn1;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHRKKKN1)
    public String getZtytkhrkkkn1() {
        return ztytkhrkkkn1;
    }

    public void setZtytkhrkkkn1(String pZtytkhrkkkn1) {
        ztytkhrkkkn1 = pZtytkhrkkkn1;
    }

    private String ztytkhosyucd2;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHOSYUCD2)
    public String getZtytkhosyucd2() {
        return ztytkhosyucd2;
    }

    public void setZtytkhosyucd2(String pZtytkhosyucd2) {
        ztytkhosyucd2 = pZtytkhosyucd2;
    }

    private String ztytknm2;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKNM2)
    public String getZtytknm2() {
        return ztytknm2;
    }

    public void setZtytknm2(String pZtytknm2) {
        ztytknm2 = pZtytknm2;
    }

    private Long ztytks2;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKS2)
    public Long getZtytks2() {
        return ztytks2;
    }

    public void setZtytks2(Long pZtytks2) {
        ztytks2 = pZtytks2;
    }

    private String ztytkhknkknkbn2;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHKNKKNKBN2)
    public String getZtytkhknkknkbn2() {
        return ztytkhknkknkbn2;
    }

    public void setZtytkhknkknkbn2(String pZtytkhknkknkbn2) {
        ztytkhknkknkbn2 = pZtytkhknkknkbn2;
    }

    private String ztytkhknkkn2;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHKNKKN2)
    public String getZtytkhknkkn2() {
        return ztytkhknkkn2;
    }

    public void setZtytkhknkkn2(String pZtytkhknkkn2) {
        ztytkhknkkn2 = pZtytkhknkkn2;
    }

    private String ztytkhrkkknkbn2;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHRKKKNKBN2)
    public String getZtytkhrkkknkbn2() {
        return ztytkhrkkknkbn2;
    }

    public void setZtytkhrkkknkbn2(String pZtytkhrkkknkbn2) {
        ztytkhrkkknkbn2 = pZtytkhrkkknkbn2;
    }

    private String ztytkhrkkkn2;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHRKKKN2)
    public String getZtytkhrkkkn2() {
        return ztytkhrkkkn2;
    }

    public void setZtytkhrkkkn2(String pZtytkhrkkkn2) {
        ztytkhrkkkn2 = pZtytkhrkkkn2;
    }

    private String ztytkhosyucd3;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHOSYUCD3)
    public String getZtytkhosyucd3() {
        return ztytkhosyucd3;
    }

    public void setZtytkhosyucd3(String pZtytkhosyucd3) {
        ztytkhosyucd3 = pZtytkhosyucd3;
    }

    private String ztytknm3;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKNM3)
    public String getZtytknm3() {
        return ztytknm3;
    }

    public void setZtytknm3(String pZtytknm3) {
        ztytknm3 = pZtytknm3;
    }

    private Long ztytks3;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKS3)
    public Long getZtytks3() {
        return ztytks3;
    }

    public void setZtytks3(Long pZtytks3) {
        ztytks3 = pZtytks3;
    }

    private String ztytkhknkknkbn3;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHKNKKNKBN3)
    public String getZtytkhknkknkbn3() {
        return ztytkhknkknkbn3;
    }

    public void setZtytkhknkknkbn3(String pZtytkhknkknkbn3) {
        ztytkhknkknkbn3 = pZtytkhknkknkbn3;
    }

    private String ztytkhknkkn3;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHKNKKN3)
    public String getZtytkhknkkn3() {
        return ztytkhknkkn3;
    }

    public void setZtytkhknkkn3(String pZtytkhknkkn3) {
        ztytkhknkkn3 = pZtytkhknkkn3;
    }

    private String ztytkhrkkknkbn3;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHRKKKNKBN3)
    public String getZtytkhrkkknkbn3() {
        return ztytkhrkkknkbn3;
    }

    public void setZtytkhrkkknkbn3(String pZtytkhrkkknkbn3) {
        ztytkhrkkknkbn3 = pZtytkhrkkknkbn3;
    }

    private String ztytkhrkkkn3;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHRKKKN3)
    public String getZtytkhrkkkn3() {
        return ztytkhrkkkn3;
    }

    public void setZtytkhrkkkn3(String pZtytkhrkkkn3) {
        ztytkhrkkkn3 = pZtytkhrkkkn3;
    }

    private String ztytkhosyucd4;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHOSYUCD4)
    public String getZtytkhosyucd4() {
        return ztytkhosyucd4;
    }

    public void setZtytkhosyucd4(String pZtytkhosyucd4) {
        ztytkhosyucd4 = pZtytkhosyucd4;
    }

    private String ztytknm4;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKNM4)
    public String getZtytknm4() {
        return ztytknm4;
    }

    public void setZtytknm4(String pZtytknm4) {
        ztytknm4 = pZtytknm4;
    }

    private Long ztytks4;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKS4)
    public Long getZtytks4() {
        return ztytks4;
    }

    public void setZtytks4(Long pZtytks4) {
        ztytks4 = pZtytks4;
    }

    private String ztytkhknkknkbn4;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHKNKKNKBN4)
    public String getZtytkhknkknkbn4() {
        return ztytkhknkknkbn4;
    }

    public void setZtytkhknkknkbn4(String pZtytkhknkknkbn4) {
        ztytkhknkknkbn4 = pZtytkhknkknkbn4;
    }

    private String ztytkhknkkn4;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHKNKKN4)
    public String getZtytkhknkkn4() {
        return ztytkhknkkn4;
    }

    public void setZtytkhknkkn4(String pZtytkhknkkn4) {
        ztytkhknkkn4 = pZtytkhknkkn4;
    }

    private String ztytkhrkkknkbn4;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHRKKKNKBN4)
    public String getZtytkhrkkknkbn4() {
        return ztytkhrkkknkbn4;
    }

    public void setZtytkhrkkknkbn4(String pZtytkhrkkknkbn4) {
        ztytkhrkkknkbn4 = pZtytkhrkkknkbn4;
    }

    private String ztytkhrkkkn4;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHRKKKN4)
    public String getZtytkhrkkkn4() {
        return ztytkhrkkkn4;
    }

    public void setZtytkhrkkkn4(String pZtytkhrkkkn4) {
        ztytkhrkkkn4 = pZtytkhrkkkn4;
    }

    private String ztytkhosyucd5;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHOSYUCD5)
    public String getZtytkhosyucd5() {
        return ztytkhosyucd5;
    }

    public void setZtytkhosyucd5(String pZtytkhosyucd5) {
        ztytkhosyucd5 = pZtytkhosyucd5;
    }

    private String ztytknm5;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKNM5)
    public String getZtytknm5() {
        return ztytknm5;
    }

    public void setZtytknm5(String pZtytknm5) {
        ztytknm5 = pZtytknm5;
    }

    private Long ztytks5;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKS5)
    public Long getZtytks5() {
        return ztytks5;
    }

    public void setZtytks5(Long pZtytks5) {
        ztytks5 = pZtytks5;
    }

    private String ztytkhknkknkbn5;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHKNKKNKBN5)
    public String getZtytkhknkknkbn5() {
        return ztytkhknkknkbn5;
    }

    public void setZtytkhknkknkbn5(String pZtytkhknkknkbn5) {
        ztytkhknkknkbn5 = pZtytkhknkknkbn5;
    }

    private String ztytkhknkkn5;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHKNKKN5)
    public String getZtytkhknkkn5() {
        return ztytkhknkkn5;
    }

    public void setZtytkhknkkn5(String pZtytkhknkkn5) {
        ztytkhknkkn5 = pZtytkhknkkn5;
    }

    private String ztytkhrkkknkbn5;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHRKKKNKBN5)
    public String getZtytkhrkkknkbn5() {
        return ztytkhrkkknkbn5;
    }

    public void setZtytkhrkkknkbn5(String pZtytkhrkkknkbn5) {
        ztytkhrkkknkbn5 = pZtytkhrkkknkbn5;
    }

    private String ztytkhrkkkn5;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHRKKKN5)
    public String getZtytkhrkkkn5() {
        return ztytkhrkkkn5;
    }

    public void setZtytkhrkkkn5(String pZtytkhrkkkn5) {
        ztytkhrkkkn5 = pZtytkhrkkkn5;
    }

    private String ztytkhosyucd6;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHOSYUCD6)
    public String getZtytkhosyucd6() {
        return ztytkhosyucd6;
    }

    public void setZtytkhosyucd6(String pZtytkhosyucd6) {
        ztytkhosyucd6 = pZtytkhosyucd6;
    }

    private String ztytknm6;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKNM6)
    public String getZtytknm6() {
        return ztytknm6;
    }

    public void setZtytknm6(String pZtytknm6) {
        ztytknm6 = pZtytknm6;
    }

    private Long ztytks6;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKS6)
    public Long getZtytks6() {
        return ztytks6;
    }

    public void setZtytks6(Long pZtytks6) {
        ztytks6 = pZtytks6;
    }

    private String ztytkhknkknkbn6;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHKNKKNKBN6)
    public String getZtytkhknkknkbn6() {
        return ztytkhknkknkbn6;
    }

    public void setZtytkhknkknkbn6(String pZtytkhknkknkbn6) {
        ztytkhknkknkbn6 = pZtytkhknkknkbn6;
    }

    private String ztytkhknkkn6;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHKNKKN6)
    public String getZtytkhknkkn6() {
        return ztytkhknkkn6;
    }

    public void setZtytkhknkkn6(String pZtytkhknkkn6) {
        ztytkhknkkn6 = pZtytkhknkkn6;
    }

    private String ztytkhrkkknkbn6;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHRKKKNKBN6)
    public String getZtytkhrkkknkbn6() {
        return ztytkhrkkknkbn6;
    }

    public void setZtytkhrkkknkbn6(String pZtytkhrkkknkbn6) {
        ztytkhrkkknkbn6 = pZtytkhrkkknkbn6;
    }

    private String ztytkhrkkkn6;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTKHRKKKN6)
    public String getZtytkhrkkkn6() {
        return ztytkhrkkkn6;
    }

    public void setZtytkhrkkkn6(String pZtytkhrkkkn6) {
        ztytkhrkkkn6 = pZtytkhrkkkn6;
    }

    private String ztysbuktnm;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSBUKTNM)
    public String getZtysbuktnm() {
        return ztysbuktnm;
    }

    public void setZtysbuktnm(String pZtysbuktnm) {
        ztysbuktnm = pZtysbuktnm;
    }

    private String ztykjsbuktnm;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKJSBUKTNM)
    public String getZtykjsbuktnm() {
        return ztykjsbuktnm;
    }

    public void setZtykjsbuktnm(String pZtykjsbuktnm) {
        ztykjsbuktnm = pZtykjsbuktnm;
    }

    private String ztysbukttdk;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSBUKTTDK)
    public String getZtysbukttdk() {
        return ztysbukttdk;
    }

    public void setZtysbukttdk(String pZtysbukttdk) {
        ztysbukttdk = pZtysbukttdk;
    }

    private String ztysbuktnin;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSBUKTNIN)
    public String getZtysbuktnin() {
        return ztysbuktnin;
    }

    public void setZtysbuktnin(String pZtysbuktnin) {
        ztysbuktnin = pZtysbuktnin;
    }

    private String ztyyobiv28;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYYOBIV28)
    public String getZtyyobiv28() {
        return ztyyobiv28;
    }

    public void setZtyyobiv28(String pZtyyobiv28) {
        ztyyobiv28 = pZtyyobiv28;
    }

    private String ztyyno7keta;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYYNO7KETA)
    public String getZtyyno7keta() {
        return ztyyno7keta;
    }

    public void setZtyyno7keta(String pZtyyno7keta) {
        ztyyno7keta = pZtyyno7keta;
    }

    private String ztytelnokydgw;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTELNOKYDGW)
    public String getZtytelnokydgw() {
        return ztytelnokydgw;
    }

    public void setZtytelnokydgw(String pZtytelnokydgw) {
        ztytelnokydgw = pZtytelnokydgw;
    }

    private String ztykyknmknkydgw;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKYKNMKNKYDGW)
    public String getZtykyknmknkydgw() {
        return ztykyknmknkydgw;
    }

    public void setZtykyknmknkydgw(String pZtykyknmknkydgw) {
        ztykyknmknkydgw = pZtykyknmknkydgw;
    }

    private String ztykyksyaseiymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKYKSYASEIYMD)
    public String getZtykyksyaseiymd() {
        return ztykyksyaseiymd;
    }

    public void setZtykyksyaseiymd(String pZtykyksyaseiymd) {
        ztykyksyaseiymd = pZtykyksyaseiymd;
    }

    private String ztykyksyaseikbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKYKSYASEIKBN)
    public String getZtykyksyaseikbn() {
        return ztykyksyaseikbn;
    }

    public void setZtykyksyaseikbn(String pZtykyksyaseikbn) {
        ztykyksyaseikbn = pZtykyksyaseikbn;
    }

    private String ztytsinkihontikucd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYTSINKIHONTIKUCD)
    public String getZtytsinkihontikucd() {
        return ztytsinkihontikucd;
    }

    public void setZtytsinkihontikucd(String pZtytsinkihontikucd) {
        ztytsinkihontikucd = pZtytsinkihontikucd;
    }

    private String ztykykadrkj50;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKYKADRKJ50)
    public String getZtykykadrkj50() {
        return ztykykadrkj50;
    }

    public void setZtykykadrkj50(String pZtykykadrkj50) {
        ztykykadrkj50 = pZtykykadrkj50;
    }

    private String ztykyknmkjkydgw;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKYKNMKJKYDGW)
    public String getZtykyknmkjkydgw() {
        return ztykyknmkjkydgw;
    }

    public void setZtykyknmkjkydgw(String pZtykyknmkjkydgw) {
        ztykyknmkjkydgw = pZtykyknmkjkydgw;
    }

    private String ztyhhknmei;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYHHKNMEI)
    public String getZtyhhknmei() {
        return ztyhhknmei;
    }

    public void setZtyhhknmei(String pZtyhhknmei) {
        ztyhhknmei = pZtyhhknmei;
    }

    private String ztyhhknnmkj;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYHHKNNMKJ)
    public String getZtyhhknnmkj() {
        return ztyhhknnmkj;
    }

    public void setZtyhhknnmkj(String pZtyhhknnmkj) {
        ztyhhknnmkj = pZtyhhknnmkj;
    }

    private String ztyhhknseiymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYHHKNSEIYMD)
    public String getZtyhhknseiymd() {
        return ztyhhknseiymd;
    }

    public void setZtyhhknseiymd(String pZtyhhknseiymd) {
        ztyhhknseiymd = pZtyhhknseiymd;
    }

    private String ztyhhknnen;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYHHKNNEN)
    public String getZtyhhknnen() {
        return ztyhhknnen;
    }

    public void setZtyhhknnen(String pZtyhhknnen) {
        ztyhhknnen = pZtyhhknnen;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhhkntdk;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYHHKNTDK)
    public String getZtyhhkntdk() {
        return ztyhhkntdk;
    }

    public void setZtyhhkntdk(String pZtyhhkntdk) {
        ztyhhkntdk = pZtyhhkntdk;
    }

    private String ztykzsyurui;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKZSYURUI)
    public String getZtykzsyurui() {
        return ztykzsyurui;
    }

    public void setZtykzsyurui(String pZtykzsyurui) {
        ztykzsyurui = pZtykzsyurui;
    }

    private String ztykouzano7keta;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKOUZANO7KETA)
    public String getZtykouzano7keta() {
        return ztykouzano7keta;
    }

    public void setZtykouzano7keta(String pZtykouzano7keta) {
        ztykouzano7keta = pZtykouzano7keta;
    }

    private String ztykzhurikaebankcd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKZHURIKAEBANKCD)
    public String getZtykzhurikaebankcd() {
        return ztykzhurikaebankcd;
    }

    public void setZtykzhurikaebankcd(String pZtykzhurikaebankcd) {
        ztykzhurikaebankcd = pZtykzhurikaebankcd;
    }

    private String ztykzhurikaesitencd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKZHURIKAESITENCD)
    public String getZtykzhurikaesitencd() {
        return ztykzhurikaesitencd;
    }

    public void setZtykzhurikaesitencd(String pZtykzhurikaesitencd) {
        ztykzhurikaesitencd = pZtykzhurikaesitencd;
    }

    private String ztykanyuusyaknrno;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKANYUUSYAKNRNO)
    public String getZtykanyuusyaknrno() {
        return ztykanyuusyaknrno;
    }

    public void setZtykanyuusyaknrno(String pZtykanyuusyaknrno) {
        ztykanyuusyaknrno = pZtykanyuusyaknrno;
    }

    private String ztykyksiboumeighnkhyj;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKYKSIBOUMEIGHNKHYJ)
    public String getZtykyksiboumeighnkhyj() {
        return ztykyksiboumeighnkhyj;
    }

    public void setZtykyksiboumeighnkhyj(String pZtykyksiboumeighnkhyj) {
        ztykyksiboumeighnkhyj = pZtykyksiboumeighnkhyj;
    }

    private String ztyyobiv11;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYYOBIV11)
    public String getZtyyobiv11() {
        return ztyyobiv11;
    }

    public void setZtyyobiv11(String pZtyyobiv11) {
        ztyyobiv11 = pZtyyobiv11;
    }

    private String ztymnkuktkbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYMNKUKTKBN)
    public String getZtymnkuktkbn() {
        return ztymnkuktkbn;
    }

    public void setZtymnkuktkbn(String pZtymnkuktkbn) {
        ztymnkuktkbn = pZtymnkuktkbn;
    }

    private String ztymnkuktnm1;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYMNKUKTNM1)
    public String getZtymnkuktnm1() {
        return ztymnkuktnm1;
    }

    public void setZtymnkuktnm1(String pZtymnkuktnm1) {
        ztymnkuktnm1 = pZtymnkuktnm1;
    }

    private String ztymnkuktnm2;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYMNKUKTNM2)
    public String getZtymnkuktnm2() {
        return ztymnkuktnm2;
    }

    public void setZtymnkuktnm2(String pZtymnkuktnm2) {
        ztymnkuktnm2 = pZtymnkuktnm2;
    }

    private String ztymnkuktnm3;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYMNKUKTNM3)
    public String getZtymnkuktnm3() {
        return ztymnkuktnm3;
    }

    public void setZtymnkuktnm3(String pZtymnkuktnm3) {
        ztymnkuktnm3 = pZtymnkuktnm3;
    }

    private String ztymnkuktnm4;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYMNKUKTNM4)
    public String getZtymnkuktnm4() {
        return ztymnkuktnm4;
    }

    public void setZtymnkuktnm4(String pZtymnkuktnm4) {
        ztymnkuktnm4 = pZtymnkuktnm4;
    }

    private String ztysbuktkbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSBUKTKBN)
    public String getZtysbuktkbn() {
        return ztysbuktkbn;
    }

    public void setZtysbuktkbn(String pZtysbuktkbn) {
        ztysbuktkbn = pZtysbuktkbn;
    }

    private String ztysbuktnm1;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSBUKTNM1)
    public String getZtysbuktnm1() {
        return ztysbuktnm1;
    }

    public void setZtysbuktnm1(String pZtysbuktnm1) {
        ztysbuktnm1 = pZtysbuktnm1;
    }

    private String ztysbuktnm2;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSBUKTNM2)
    public String getZtysbuktnm2() {
        return ztysbuktnm2;
    }

    public void setZtysbuktnm2(String pZtysbuktnm2) {
        ztysbuktnm2 = pZtysbuktnm2;
    }

    private String ztysbuktnm3;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSBUKTNM3)
    public String getZtysbuktnm3() {
        return ztysbuktnm3;
    }

    public void setZtysbuktnm3(String pZtysbuktnm3) {
        ztysbuktnm3 = pZtysbuktnm3;
    }

    private String ztysbuktnm4;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYSBUKTNM4)
    public String getZtysbuktnm4() {
        return ztysbuktnm4;
    }

    public void setZtysbuktnm4(String pZtysbuktnm4) {
        ztysbuktnm4 = pZtysbuktnm4;
    }

    private String ztyyobiv20x3;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYYOBIV20X3)
    public String getZtyyobiv20x3() {
        return ztyyobiv20x3;
    }

    public void setZtyyobiv20x3(String pZtyyobiv20x3) {
        ztyyobiv20x3 = pZtyyobiv20x3;
    }

    @Id
    @Column(name=GenZT_KydGWKykInfoTy.ZTYSYORIYMD)
    public String getZtysyoriymd() {
        return getPrimaryKey().getZtysyoriymd();
    }

    public void setZtysyoriymd(String pZtysyoriymd) {
        getPrimaryKey().setZtysyoriymd(pZtysyoriymd);
    }

    @Id
    @Column(name=GenZT_KydGWKykInfoTy.ZTYKYKMFKSNCTRLKH)
    public Long getZtykykmfksnctrlkh() {
        return getPrimaryKey().getZtykykmfksnctrlkh();
    }

    public void setZtykykmfksnctrlkh(Long pZtykykmfksnctrlkh) {
        getPrimaryKey().setZtykykmfksnctrlkh(pZtykykmfksnctrlkh);
    }

    private String ztymkhtoutatuymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYMKHTOUTATUYMD)
    public String getZtymkhtoutatuymd() {
        return ztymkhtoutatuymd;
    }

    public void setZtymkhtoutatuymd(String pZtymkhtoutatuymd) {
        ztymkhtoutatuymd = pZtymkhtoutatuymd;
    }

    private String ztykykhrkmtuuka;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKYKHRKMTUUKA)
    public String getZtykykhrkmtuuka() {
        return ztykykhrkmtuuka;
    }

    public void setZtykykhrkmtuuka(String pZtykykhrkmtuuka) {
        ztykykhrkmtuuka = pZtykykhrkmtuuka;
    }

    private Long ztykykhrkmgk;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKYKHRKMGK)
    public Long getZtykykhrkmgk() {
        return ztykykhrkmgk;
    }

    public void setZtykykhrkmgk(Long pZtykykhrkmgk) {
        ztykykhrkmgk = pZtykykhrkmgk;
    }

    private String ztyikkatubaraikbn;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYIKKATUBARAIKBN)
    public String getZtyikkatubaraikbn() {
        return ztyikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyikkatubaraikbn(String pZtyikkatubaraikbn) {
        ztyikkatubaraikbn = pZtyikkatubaraikbn;
    }

    private String ztyikkatubaraikaisuu;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYIKKATUBARAIKAISUU)
    public String getZtyikkatubaraikaisuu() {
        return ztyikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyikkatubaraikaisuu(String pZtyikkatubaraikaisuu) {
        ztyikkatubaraikaisuu = pZtyikkatubaraikaisuu;
    }

    private BizNumber ztytousyokykjiyennyknrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KydGWKykInfoTy.ZTYTOUSYOKYKJIYENNYKNRATE)
    public BizNumber getZtytousyokykjiyennyknrate() {
        return ztytousyokykjiyennyknrate;
    }

    public void setZtytousyokykjiyennyknrate(BizNumber pZtytousyokykjiyennyknrate) {
        ztytousyokykjiyennyknrate = pZtytousyokykjiyennyknrate;
    }

    private BizNumber ztyrendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KydGWKykInfoTy.ZTYRENDOURITU)
    public BizNumber getZtyrendouritu() {
        return ztyrendouritu;
    }

    public void setZtyrendouritu(BizNumber pZtyrendouritu) {
        ztyrendouritu = pZtyrendouritu;
    }

    private BizNumber ztyteikishrritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KydGWKykInfoTy.ZTYTEIKISHRRITU)
    public BizNumber getZtyteikishrritu() {
        return ztyteikishrritu;
    }

    public void setZtyteikishrritu(BizNumber pZtyteikishrritu) {
        ztyteikishrritu = pZtyteikishrritu;
    }

    private String ztykosyasbskttdkstartflg;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKOSYASBSKTTDKSTARTFLG)
    public String getZtykosyasbskttdkstartflg() {
        return ztykosyasbskttdkstartflg;
    }

    public void setZtykosyasbskttdkstartflg(String pZtykosyasbskttdkstartflg) {
        ztykosyasbskttdkstartflg = pZtykosyasbskttdkstartflg;
    }

    private String ztykosyasbukthukusuflg;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKOSYASBUKTHUKUSUFLG)
    public String getZtykosyasbukthukusuflg() {
        return ztykosyasbukthukusuflg;
    }

    public void setZtykosyasbukthukusuflg(String pZtykosyasbukthukusuflg) {
        ztykosyasbukthukusuflg = pZtykosyasbukthukusuflg;
    }

    private String ztykosyahhknsbymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKOSYAHHKNSBYMD)
    public String getZtykosyahhknsbymd() {
        return ztykosyahhknsbymd;
    }

    public void setZtykosyahhknsbymd(String pZtykosyahhknsbymd) {
        ztykosyahhknsbymd = pZtykosyahhknsbymd;
    }

    private String ztykosyassksjyuriymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKOSYASSKSJYURIYMD)
    public String getZtykosyassksjyuriymd() {
        return ztykosyassksjyuriymd;
    }

    public void setZtykosyassksjyuriymd(String pZtykosyassksjyuriymd) {
        ztykosyassksjyuriymd = pZtykosyassksjyuriymd;
    }

    private String ztykosyasshrkanryoymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKOSYASSHRKANRYOYMD)
    public String getZtykosyasshrkanryoymd() {
        return ztykosyasshrkanryoymd;
    }

    public void setZtykosyasshrkanryoymd(String pZtykosyasshrkanryoymd) {
        ztykosyasshrkanryoymd = pZtykosyasshrkanryoymd;
    }

    private String ztykosyasbuktseiymd;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKOSYASBUKTSEIYMD)
    public String getZtykosyasbuktseiymd() {
        return ztykosyasbuktseiymd;
    }

    public void setZtykosyasbuktseiymd(String pZtykosyasbuktseiymd) {
        ztykosyasbuktseiymd = pZtykosyasbuktseiymd;
    }

    private String ztykosyasbuktkjadr;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKOSYASBUKTKJADR)
    public String getZtykosyasbuktkjadr() {
        return ztykosyasbuktkjadr;
    }

    public void setZtykosyasbuktkjadr(String pZtykosyasbuktkjadr) {
        ztykosyasbuktkjadr = pZtykosyasbuktkjadr;
    }

    private String ztykosyasbukttelno;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYKOSYASBUKTTELNO)
    public String getZtykosyasbukttelno() {
        return ztykosyasbukttelno;
    }

    public void setZtykosyasbukttelno(String pZtykosyasbukttelno) {
        ztykosyasbukttelno = pZtykosyasbukttelno;
    }

    private String ztyyobiv252;

    @Column(name=GenZT_KydGWKykInfoTy.ZTYYOBIV252)
    public String getZtyyobiv252() {
        return ztyyobiv252;
    }

    public void setZtyyobiv252(String pZtyyobiv252) {
        ztyyobiv252 = pZtyyobiv252;
    }
}
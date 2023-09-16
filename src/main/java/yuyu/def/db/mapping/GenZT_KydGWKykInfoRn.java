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
import yuyu.def.db.entity.ZT_KydGWKykInfoRn;
import yuyu.def.db.id.PKZT_KydGWKykInfoRn;
import yuyu.def.db.meta.GenQZT_KydGWKykInfoRn;
import yuyu.def.db.meta.QZT_KydGWKykInfoRn;

/**
 * 共同ＧＷ用契約情報Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KydGWKykInfoRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KydGWKykInfoRn}</td><td colspan="3">共同ＧＷ用契約情報Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_KydGWKykInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyurui2keta zrnhknsyurui2keta}</td><td>（連携用）保険種類（２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinkeizkkbn zrnsinkeizkkbn}</td><td>（連携用）新規継続区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuhosyucd zrnsyuhosyucd}</td><td>（連携用）主契約保種コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmdhnaisyoumeicd zrnmdhnaisyoumeicd}</td><td>（連携用）窓販用愛称名コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyouhncd zrnsyouhncd}</td><td>（連携用）商品コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmusymd zrnmusymd}</td><td>（連携用）申込年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykseirituymd zrnkykseirituymd}</td><td>（連携用）契約成立年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsekininkaisiymd zrnsekininkaisiymd}</td><td>（連携用）責任開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaipymd zrnsyokaipymd}</td><td>（連携用）初回Ｐ入金年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjnkojinkbn zrnhjnkojinkbn}</td><td>（連携用）法人個人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkhuhukbn zrnhrkhuhukbn}</td><td>（連携用）払込方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkymd zrnhrkymd}</td><td>（連携用）払込日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeip2 zrngoukeip2}</td><td>（連携用）合計保険料２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitijibrp zrnitijibrp}</td><td>（連携用）一時払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbnkaisuu zrnbnkaisuu}</td><td>（連携用）分割回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnsyuruikbn zrnbnsyuruikbn}</td><td>（連携用）分割種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnkyk1kaip zrnbnkyk1kaip}</td><td>（連携用）分割払契約１回分保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv20 zrnyobiv20}</td><td>（連携用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuhknkknkbn zrnsyuhknkknkbn}</td><td>（連携用）主契約保険期間区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuhknkkn zrnsyuhknkkn}</td><td>（連携用）主契約保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuhrkkknkbn zrnsyuhrkkknkbn}</td><td>（連携用）主契約払込期間区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuhrkkkn zrnsyuhrkkkn}</td><td>（連携用）主契約払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyus zrnsyus}</td><td>（連携用）主契約保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyunm zrnsyunm}</td><td>（連携用）主契約名称</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidojiyukbn zrnidojiyukbn}</td><td>（連携用）異動事由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoumetucd zrnsyoumetucd}</td><td>（連携用）消滅コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidokaiyakuymd zrnidokaiyakuymd}</td><td>（連携用）異動解約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmankiymd zrnmankiymd}</td><td>（連携用）満期年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsibous zrnsibous}</td><td>（連携用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnidoukaiyakup zrnidoukaiyakup}</td><td>（連携用）異動解約保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukinkbn zrnsyukinkbn}</td><td>（連携用）集金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaitoukbn zrnhaitoukbn}</td><td>（連携用）配当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditcardhrkbn zrncreditcardhrkbn}</td><td>（連携用）クレジットカード払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkjykbn zrntkjykbn}</td><td>（連携用）特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinsakbn zrnsinsakbn}</td><td>（連携用）診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeiseitekikakuhyj zrnzeiseitekikakuhyj}</td><td>（連携用）税制適格表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlivhukauhyj zrnlivhukauhyj}</td><td>（連携用）リビングニーズ付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrizmentyouhyj zrnhrizmentyouhyj}</td><td>（連携用）払済延長表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkisokyknkshrhsykn zrnkisokyknkshrhsykn}</td><td>（連携用）基礎契約年金支払保証期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrkknkbn zrnnkshrkknkbn}</td><td>（連携用）年金支払期間区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrkknnen zrnnkshrkknnen}</td><td>（連携用）年金支払期間年</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksueokikn zrnnksueokikn}</td><td>（連携用）年金据置期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrstartymd zrnnkshrstartymd}</td><td>（連携用）年金支払開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkuketorininkbn zrnnkuketorininkbn}</td><td>（連携用）年金受取人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoup zrnzennoup}</td><td>（連携用）前納保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzennouendym zrnzennouendym}</td><td>（連携用）前納終了年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikaiyakuhrkn zrnteikaiyakuhrkn}</td><td>（連携用）低解約返戻金期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosno zrnmosno}</td><td>（連携用）申込番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntratkisyacd1 zrntratkisyacd1}</td><td>（連携用）取扱者コード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntratkisyacd2 zrntratkisyacd2}</td><td>（連携用）取扱者コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairiten1cd zrndairiten1cd}</td><td>（連携用）代理店１コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairiten2cd zrndairiten2cd}</td><td>（連携用）代理店２コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsudirtnatkikeitaikbn zrnbsudirtnatkikeitaikbn}</td><td>（連携用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyudiritnatkiwari1 zrnbsyudiritnatkiwari1}</td><td>（連携用）募集代理店扱割合１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbsyudiritnatkiwari2 zrnbsyudiritnatkiwari2}</td><td>（連携用）募集代理店扱割合２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv20x2 zrnyobiv20x2}</td><td>（連携用）予備項目Ｖ２０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntktyuutohukahyj zrntktyuutohukahyj}</td><td>（連携用）特約中途付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksuu zrntksuu}</td><td>（連携用）特約数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhosyucd1 zrntkhosyucd1}</td><td>（連携用）特約保種コード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntknm1 zrntknm1}</td><td>（連携用）特約名称１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntks1 zrntks1}</td><td>（連携用）特約保険金額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntkhknkknkbn1 zrntkhknkknkbn1}</td><td>（連携用）特約保険期間区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkkn1 zrntkhknkkn1}</td><td>（連携用）特約保険期間１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkknkbn1 zrntkhrkkknkbn1}</td><td>（連携用）特約払込期間区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkkn1 zrntkhrkkkn1}</td><td>（連携用）特約払込期間１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhosyucd2 zrntkhosyucd2}</td><td>（連携用）特約保種コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntknm2 zrntknm2}</td><td>（連携用）特約名称２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntks2 zrntks2}</td><td>（連携用）特約保険金額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntkhknkknkbn2 zrntkhknkknkbn2}</td><td>（連携用）特約保険期間区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkkn2 zrntkhknkkn2}</td><td>（連携用）特約保険期間２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkknkbn2 zrntkhrkkknkbn2}</td><td>（連携用）特約払込期間区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkkn2 zrntkhrkkkn2}</td><td>（連携用）特約払込期間２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhosyucd3 zrntkhosyucd3}</td><td>（連携用）特約保種コード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntknm3 zrntknm3}</td><td>（連携用）特約名称３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntks3 zrntks3}</td><td>（連携用）特約保険金額３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntkhknkknkbn3 zrntkhknkknkbn3}</td><td>（連携用）特約保険期間区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkkn3 zrntkhknkkn3}</td><td>（連携用）特約保険期間３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkknkbn3 zrntkhrkkknkbn3}</td><td>（連携用）特約払込期間区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkkn3 zrntkhrkkkn3}</td><td>（連携用）特約払込期間３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhosyucd4 zrntkhosyucd4}</td><td>（連携用）特約保種コード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntknm4 zrntknm4}</td><td>（連携用）特約名称４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntks4 zrntks4}</td><td>（連携用）特約保険金額４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntkhknkknkbn4 zrntkhknkknkbn4}</td><td>（連携用）特約保険期間区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkkn4 zrntkhknkkn4}</td><td>（連携用）特約保険期間４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkknkbn4 zrntkhrkkknkbn4}</td><td>（連携用）特約払込期間区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkkn4 zrntkhrkkkn4}</td><td>（連携用）特約払込期間４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhosyucd5 zrntkhosyucd5}</td><td>（連携用）特約保種コード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntknm5 zrntknm5}</td><td>（連携用）特約名称５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntks5 zrntks5}</td><td>（連携用）特約保険金額５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntkhknkknkbn5 zrntkhknkknkbn5}</td><td>（連携用）特約保険期間区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkkn5 zrntkhknkkn5}</td><td>（連携用）特約保険期間５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkknkbn5 zrntkhrkkknkbn5}</td><td>（連携用）特約払込期間区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkkn5 zrntkhrkkkn5}</td><td>（連携用）特約払込期間５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhosyucd6 zrntkhosyucd6}</td><td>（連携用）特約保種コード６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntknm6 zrntknm6}</td><td>（連携用）特約名称６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntks6 zrntks6}</td><td>（連携用）特約保険金額６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntkhknkknkbn6 zrntkhknkknkbn6}</td><td>（連携用）特約保険期間区分６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhknkkn6 zrntkhknkkn6}</td><td>（連携用）特約保険期間６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkknkbn6 zrntkhrkkknkbn6}</td><td>（連携用）特約払込期間区分６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhrkkkn6 zrntkhrkkkn6}</td><td>（連携用）特約払込期間６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktnm zrnsbuktnm}</td><td>（連携用）死亡受取人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjsbuktnm zrnkjsbuktnm}</td><td>（連携用）漢字死亡受取人名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbukttdk zrnsbukttdk}</td><td>（連携用）死亡受取人続柄</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktnin zrnsbuktnin}</td><td>（連携用）死亡受取人人数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv28 zrnyobiv28}</td><td>（連携用）予備項目Ｖ２８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyno7keta zrnyno7keta}</td><td>（連携用）郵便番号（７桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntelnokydgw zrntelnokydgw}</td><td>（連携用）電話番号（共同ＧＷ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmknkydgw zrnkyknmknkydgw}</td><td>（連携用）契約者名（カナ）（共同ＧＷ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseiymd zrnkyksyaseiymd}</td><td>（連携用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseikbn zrnkyksyaseikbn}</td><td>（連携用）契約者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsinkihontikucd zrntsinkihontikucd}</td><td>（連携用）通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykadrkj50 zrnkykadrkj50}</td><td>（連携用）契約者漢字住所５０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkjkydgw zrnkyknmkjkydgw}</td><td>（連携用）契約者名（漢字）（共同ＧＷ）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknmei zrnhhknmei}</td><td>（連携用）被保険者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj zrnhhknnmkj}</td><td>（連携用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseiymd zrnhhknseiymd}</td><td>（連携用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen zrnhhknnen}</td><td>（連携用）被保険者年齢</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkntdk zrnhhkntdk}</td><td>（連携用）被保険者続柄</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzsyurui zrnkzsyurui}</td><td>（連携用）口座種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouzano7keta zrnkouzano7keta}</td><td>（連携用）口座番号（７桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaebankcd zrnkzhurikaebankcd}</td><td>（連携用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaesitencd zrnkzhurikaesitencd}</td><td>（連携用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanyuusyaknrno zrnkanyuusyaknrno}</td><td>（連携用）加入者管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksiboumeighnkhyj zrnkyksiboumeighnkhyj}</td><td>（連携用）契約者死亡名義変更表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv11 zrnyobiv11}</td><td>（連携用）予備項目Ｖ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnkuktkbn zrnmnkuktkbn}</td><td>（連携用）満期受取人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnkuktnm1 zrnmnkuktnm1}</td><td>（連携用）満期受取人名１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnkuktnm2 zrnmnkuktnm2}</td><td>（連携用）満期受取人名２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnkuktnm3 zrnmnkuktnm3}</td><td>（連携用）満期受取人名３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnkuktnm4 zrnmnkuktnm4}</td><td>（連携用）満期受取人名４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktkbn zrnsbuktkbn}</td><td>（連携用）死亡受取人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktnm1 zrnsbuktnm1}</td><td>（連携用）死亡受取人名１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktnm2 zrnsbuktnm2}</td><td>（連携用）死亡受取人名２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktnm3 zrnsbuktnm3}</td><td>（連携用）死亡受取人名３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktnm4 zrnsbuktnm4}</td><td>（連携用）死亡受取人名４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv20x3 zrnyobiv20x3}</td><td>（連携用）予備項目Ｖ２０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoriymd zrnsyoriymd}</td><td>（連携用）処理年月日</td><td align="center">{@link PKZT_KydGWKykInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfksnctrlkh zrnkykmfksnctrlkh}</td><td>（連携用）契約ＭＦ更新ＣＴＲ（保全）</td><td align="center">{@link PKZT_KydGWKykInfoRn ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmkhtoutatuymd zrnmkhtoutatuymd}</td><td>（連携用）目標到達年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykhrkmtuuka zrnkykhrkmtuuka}</td><td>（連携用）契約者振込通貨</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykhrkmgk zrnkykhrkmgk}</td><td>（連携用）契約者振込金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikbn zrnikkatubaraikbn}</td><td>（連携用）一括払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikaisuu zrnikkatubaraikaisuu}</td><td>（連携用）一括払回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntousyokykjiyennyknrate zrntousyokykjiyennyknrate}</td><td>（連携用）当初契約時円入金レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnrendouritu zrnrendouritu}</td><td>（連携用）連動率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnteikishrritu zrnteikishrritu}</td><td>（連携用）定期支払率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkosyasbskttdkstartflg zrnkosyasbskttdkstartflg}</td><td>（連携用）個社死亡請求手続き開始フラグ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkosyasbukthukusuflg zrnkosyasbukthukusuflg}</td><td>（連携用）個社死亡受取人複数フラグ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkosyahhknsbymd zrnkosyahhknsbymd}</td><td>（連携用）個社被保険者死亡日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkosyassksjyuriymd zrnkosyassksjyuriymd}</td><td>（連携用）個社保険金請求書受理日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkosyasshrkanryoymd zrnkosyasshrkanryoymd}</td><td>（連携用）個社保険金支払完了日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkosyasbuktseiymd zrnkosyasbuktseiymd}</td><td>（連携用）個社死亡保険金受取人生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkosyasbuktkjadr zrnkosyasbuktkjadr}</td><td>（連携用）個社死亡保険金受取人住所漢字</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkosyasbukttelno zrnkosyasbukttelno}</td><td>（連携用）個社死亡保険金受取人電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv252 zrnyobiv252}</td><td>（連携用）予備項目Ｖ２５２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KydGWKykInfoRn
 * @see     PKZT_KydGWKykInfoRn
 * @see     QZT_KydGWKykInfoRn
 * @see     GenQZT_KydGWKykInfoRn
 */
@MappedSuperclass
@Table(name=GenZT_KydGWKykInfoRn.TABLE_NAME)
@IdClass(value=PKZT_KydGWKykInfoRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_KydGWKykInfoRn extends AbstractExDBEntityForZDB<ZT_KydGWKykInfoRn, PKZT_KydGWKykInfoRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KydGWKykInfoRn";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHKNSYURUI2KETA        = "zrnhknsyurui2keta";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNSINKEIZKKBN           = "zrnsinkeizkkbn";
    public static final String ZRNSYUHOSYUCD            = "zrnsyuhosyucd";
    public static final String ZRNMDHNAISYOUMEICD       = "zrnmdhnaisyoumeicd";
    public static final String ZRNSYOUHNCD              = "zrnsyouhncd";
    public static final String ZRNMUSYMD                = "zrnmusymd";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNKYKSEIRITUYMD         = "zrnkykseirituymd";
    public static final String ZRNSEKININKAISIYMD       = "zrnsekininkaisiymd";
    public static final String ZRNSYOKAIPYMD            = "zrnsyokaipymd";
    public static final String ZRNHJNKOJINKBN           = "zrnhjnkojinkbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNHRKHUHUKBN            = "zrnhrkhuhukbn";
    public static final String ZRNHRKYMD                = "zrnhrkymd";
    public static final String ZRNGOUKEIP2              = "zrngoukeip2";
    public static final String ZRNITIJIBRP              = "zrnitijibrp";
    public static final String ZRNBNKAISUU              = "zrnbnkaisuu";
    public static final String ZRNBNSYURUIKBN           = "zrnbnsyuruikbn";
    public static final String ZRNBNKYK1KAIP            = "zrnbnkyk1kaip";
    public static final String ZRNYOBIV20               = "zrnyobiv20";
    public static final String ZRNSYUHKNKKNKBN          = "zrnsyuhknkknkbn";
    public static final String ZRNSYUHKNKKN             = "zrnsyuhknkkn";
    public static final String ZRNSYUHRKKKNKBN          = "zrnsyuhrkkknkbn";
    public static final String ZRNSYUHRKKKN             = "zrnsyuhrkkkn";
    public static final String ZRNSYUS                  = "zrnsyus";
    public static final String ZRNSYUNM                 = "zrnsyunm";
    public static final String ZRNIDOJIYUKBN            = "zrnidojiyukbn";
    public static final String ZRNSYOUMETUCD            = "zrnsyoumetucd";
    public static final String ZRNIDOKAIYAKUYMD         = "zrnidokaiyakuymd";
    public static final String ZRNMANKIYMD              = "zrnmankiymd";
    public static final String ZRNSIBOUS                = "zrnsibous";
    public static final String ZRNIDOUKAIYAKUP          = "zrnidoukaiyakup";
    public static final String ZRNSYUKINKBN             = "zrnsyukinkbn";
    public static final String ZRNHAITOUKBN             = "zrnhaitoukbn";
    public static final String ZRNCREDITCARDHRKBN       = "zrncreditcardhrkbn";
    public static final String ZRNTKJYKBN               = "zrntkjykbn";
    public static final String ZRNSINSAKBN              = "zrnsinsakbn";
    public static final String ZRNZEISEITEKIKAKUHYJ     = "zrnzeiseitekikakuhyj";
    public static final String ZRNLIVHUKAUHYJ           = "zrnlivhukauhyj";
    public static final String ZRNHRIZMENTYOUHYJ        = "zrnhrizmentyouhyj";
    public static final String ZRNKISOKYKNKSHRHSYKN     = "zrnkisokyknkshrhsykn";
    public static final String ZRNNKSHRKKNKBN           = "zrnnkshrkknkbn";
    public static final String ZRNNKSHRKKNNEN           = "zrnnkshrkknnen";
    public static final String ZRNNKSUEOKIKN            = "zrnnksueokikn";
    public static final String ZRNNKSHRSTARTYMD         = "zrnnkshrstartymd";
    public static final String ZRNNKUKETORININKBN       = "zrnnkuketorininkbn";
    public static final String ZRNZENNOUP               = "zrnzennoup";
    public static final String ZRNZENNOUENDYM           = "zrnzennouendym";
    public static final String ZRNTEIKAIYAKUHRKN        = "zrnteikaiyakuhrkn";
    public static final String ZRNMOSNO                 = "zrnmosno";
    public static final String ZRNTRATKISYACD1          = "zrntratkisyacd1";
    public static final String ZRNTRATKISYACD2          = "zrntratkisyacd2";
    public static final String ZRNDAIRITEN1CD           = "zrndairiten1cd";
    public static final String ZRNDAIRITEN2CD           = "zrndairiten2cd";
    public static final String ZRNBSUDIRTNATKIKEITAIKBN = "zrnbsudirtnatkikeitaikbn";
    public static final String ZRNBSYUDIRITNATKIWARI1   = "zrnbsyudiritnatkiwari1";
    public static final String ZRNBSYUDIRITNATKIWARI2   = "zrnbsyudiritnatkiwari2";
    public static final String ZRNYOBIV20X2             = "zrnyobiv20x2";
    public static final String ZRNTKTYUUTOHUKAHYJ       = "zrntktyuutohukahyj";
    public static final String ZRNTKSUU                 = "zrntksuu";
    public static final String ZRNTKHOSYUCD1            = "zrntkhosyucd1";
    public static final String ZRNTKNM1                 = "zrntknm1";
    public static final String ZRNTKS1                  = "zrntks1";
    public static final String ZRNTKHKNKKNKBN1          = "zrntkhknkknkbn1";
    public static final String ZRNTKHKNKKN1             = "zrntkhknkkn1";
    public static final String ZRNTKHRKKKNKBN1          = "zrntkhrkkknkbn1";
    public static final String ZRNTKHRKKKN1             = "zrntkhrkkkn1";
    public static final String ZRNTKHOSYUCD2            = "zrntkhosyucd2";
    public static final String ZRNTKNM2                 = "zrntknm2";
    public static final String ZRNTKS2                  = "zrntks2";
    public static final String ZRNTKHKNKKNKBN2          = "zrntkhknkknkbn2";
    public static final String ZRNTKHKNKKN2             = "zrntkhknkkn2";
    public static final String ZRNTKHRKKKNKBN2          = "zrntkhrkkknkbn2";
    public static final String ZRNTKHRKKKN2             = "zrntkhrkkkn2";
    public static final String ZRNTKHOSYUCD3            = "zrntkhosyucd3";
    public static final String ZRNTKNM3                 = "zrntknm3";
    public static final String ZRNTKS3                  = "zrntks3";
    public static final String ZRNTKHKNKKNKBN3          = "zrntkhknkknkbn3";
    public static final String ZRNTKHKNKKN3             = "zrntkhknkkn3";
    public static final String ZRNTKHRKKKNKBN3          = "zrntkhrkkknkbn3";
    public static final String ZRNTKHRKKKN3             = "zrntkhrkkkn3";
    public static final String ZRNTKHOSYUCD4            = "zrntkhosyucd4";
    public static final String ZRNTKNM4                 = "zrntknm4";
    public static final String ZRNTKS4                  = "zrntks4";
    public static final String ZRNTKHKNKKNKBN4          = "zrntkhknkknkbn4";
    public static final String ZRNTKHKNKKN4             = "zrntkhknkkn4";
    public static final String ZRNTKHRKKKNKBN4          = "zrntkhrkkknkbn4";
    public static final String ZRNTKHRKKKN4             = "zrntkhrkkkn4";
    public static final String ZRNTKHOSYUCD5            = "zrntkhosyucd5";
    public static final String ZRNTKNM5                 = "zrntknm5";
    public static final String ZRNTKS5                  = "zrntks5";
    public static final String ZRNTKHKNKKNKBN5          = "zrntkhknkknkbn5";
    public static final String ZRNTKHKNKKN5             = "zrntkhknkkn5";
    public static final String ZRNTKHRKKKNKBN5          = "zrntkhrkkknkbn5";
    public static final String ZRNTKHRKKKN5             = "zrntkhrkkkn5";
    public static final String ZRNTKHOSYUCD6            = "zrntkhosyucd6";
    public static final String ZRNTKNM6                 = "zrntknm6";
    public static final String ZRNTKS6                  = "zrntks6";
    public static final String ZRNTKHKNKKNKBN6          = "zrntkhknkknkbn6";
    public static final String ZRNTKHKNKKN6             = "zrntkhknkkn6";
    public static final String ZRNTKHRKKKNKBN6          = "zrntkhrkkknkbn6";
    public static final String ZRNTKHRKKKN6             = "zrntkhrkkkn6";
    public static final String ZRNSBUKTNM               = "zrnsbuktnm";
    public static final String ZRNKJSBUKTNM             = "zrnkjsbuktnm";
    public static final String ZRNSBUKTTDK              = "zrnsbukttdk";
    public static final String ZRNSBUKTNIN              = "zrnsbuktnin";
    public static final String ZRNYOBIV28               = "zrnyobiv28";
    public static final String ZRNYNO7KETA              = "zrnyno7keta";
    public static final String ZRNTELNOKYDGW            = "zrntelnokydgw";
    public static final String ZRNKYKNMKNKYDGW          = "zrnkyknmknkydgw";
    public static final String ZRNKYKSYASEIYMD          = "zrnkyksyaseiymd";
    public static final String ZRNKYKSYASEIKBN          = "zrnkyksyaseikbn";
    public static final String ZRNTSINKIHONTIKUCD       = "zrntsinkihontikucd";
    public static final String ZRNKYKADRKJ50            = "zrnkykadrkj50";
    public static final String ZRNKYKNMKJKYDGW          = "zrnkyknmkjkydgw";
    public static final String ZRNHHKNMEI               = "zrnhhknmei";
    public static final String ZRNHHKNNMKJ              = "zrnhhknnmkj";
    public static final String ZRNHHKNSEIYMD            = "zrnhhknseiymd";
    public static final String ZRNHHKNNEN               = "zrnhhknnen";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHHKNTDK               = "zrnhhkntdk";
    public static final String ZRNKZSYURUI              = "zrnkzsyurui";
    public static final String ZRNKOUZANO7KETA          = "zrnkouzano7keta";
    public static final String ZRNKZHURIKAEBANKCD       = "zrnkzhurikaebankcd";
    public static final String ZRNKZHURIKAESITENCD      = "zrnkzhurikaesitencd";
    public static final String ZRNKANYUUSYAKNRNO        = "zrnkanyuusyaknrno";
    public static final String ZRNKYKSIBOUMEIGHNKHYJ    = "zrnkyksiboumeighnkhyj";
    public static final String ZRNYOBIV11               = "zrnyobiv11";
    public static final String ZRNMNKUKTKBN             = "zrnmnkuktkbn";
    public static final String ZRNMNKUKTNM1             = "zrnmnkuktnm1";
    public static final String ZRNMNKUKTNM2             = "zrnmnkuktnm2";
    public static final String ZRNMNKUKTNM3             = "zrnmnkuktnm3";
    public static final String ZRNMNKUKTNM4             = "zrnmnkuktnm4";
    public static final String ZRNSBUKTKBN              = "zrnsbuktkbn";
    public static final String ZRNSBUKTNM1              = "zrnsbuktnm1";
    public static final String ZRNSBUKTNM2              = "zrnsbuktnm2";
    public static final String ZRNSBUKTNM3              = "zrnsbuktnm3";
    public static final String ZRNSBUKTNM4              = "zrnsbuktnm4";
    public static final String ZRNYOBIV20X3             = "zrnyobiv20x3";
    public static final String ZRNSYORIYMD              = "zrnsyoriymd";
    public static final String ZRNKYKMFKSNCTRLKH        = "zrnkykmfksnctrlkh";
    public static final String ZRNMKHTOUTATUYMD         = "zrnmkhtoutatuymd";
    public static final String ZRNKYKHRKMTUUKA          = "zrnkykhrkmtuuka";
    public static final String ZRNKYKHRKMGK             = "zrnkykhrkmgk";
    public static final String ZRNIKKATUBARAIKBN        = "zrnikkatubaraikbn";
    public static final String ZRNIKKATUBARAIKAISUU     = "zrnikkatubaraikaisuu";
    public static final String ZRNTOUSYOKYKJIYENNYKNRATE = "zrntousyokykjiyennyknrate";
    public static final String ZRNRENDOURITU            = "zrnrendouritu";
    public static final String ZRNTEIKISHRRITU          = "zrnteikishrritu";
    public static final String ZRNKOSYASBSKTTDKSTARTFLG = "zrnkosyasbskttdkstartflg";
    public static final String ZRNKOSYASBUKTHUKUSUFLG   = "zrnkosyasbukthukusuflg";
    public static final String ZRNKOSYAHHKNSBYMD        = "zrnkosyahhknsbymd";
    public static final String ZRNKOSYASSKSJYURIYMD     = "zrnkosyassksjyuriymd";
    public static final String ZRNKOSYASSHRKANRYOYMD    = "zrnkosyasshrkanryoymd";
    public static final String ZRNKOSYASBUKTSEIYMD      = "zrnkosyasbuktseiymd";
    public static final String ZRNKOSYASBUKTKJADR       = "zrnkosyasbuktkjadr";
    public static final String ZRNKOSYASBUKTTELNO       = "zrnkosyasbukttelno";
    public static final String ZRNYOBIV252              = "zrnyobiv252";

    private final PKZT_KydGWKykInfoRn primaryKey;

    public GenZT_KydGWKykInfoRn() {
        primaryKey = new PKZT_KydGWKykInfoRn();
    }

    public GenZT_KydGWKykInfoRn(
        String pZrnsyono,
        String pZrnsyoriymd,
        Long pZrnkykmfksnctrlkh
    ) {
        primaryKey = new PKZT_KydGWKykInfoRn(
            pZrnsyono,
            pZrnsyoriymd,
            pZrnkykmfksnctrlkh
        );
    }

    @Transient
    @Override
    public PKZT_KydGWKykInfoRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KydGWKykInfoRn> getMetaClass() {
        return QZT_KydGWKykInfoRn.class;
    }

    @Id
    @Column(name=GenZT_KydGWKykInfoRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnhknsyurui2keta;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNHKNSYURUI2KETA)
    public String getZrnhknsyurui2keta() {
        return zrnhknsyurui2keta;
    }

    public void setZrnhknsyurui2keta(String pZrnhknsyurui2keta) {
        zrnhknsyurui2keta = pZrnhknsyurui2keta;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnsinkeizkkbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSINKEIZKKBN)
    public String getZrnsinkeizkkbn() {
        return zrnsinkeizkkbn;
    }

    public void setZrnsinkeizkkbn(String pZrnsinkeizkkbn) {
        zrnsinkeizkkbn = pZrnsinkeizkkbn;
    }

    private String zrnsyuhosyucd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSYUHOSYUCD)
    public String getZrnsyuhosyucd() {
        return zrnsyuhosyucd;
    }

    public void setZrnsyuhosyucd(String pZrnsyuhosyucd) {
        zrnsyuhosyucd = pZrnsyuhosyucd;
    }

    private String zrnmdhnaisyoumeicd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNMDHNAISYOUMEICD)
    public String getZrnmdhnaisyoumeicd() {
        return zrnmdhnaisyoumeicd;
    }

    public void setZrnmdhnaisyoumeicd(String pZrnmdhnaisyoumeicd) {
        zrnmdhnaisyoumeicd = pZrnmdhnaisyoumeicd;
    }

    private String zrnsyouhncd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSYOUHNCD)
    public String getZrnsyouhncd() {
        return zrnsyouhncd;
    }

    public void setZrnsyouhncd(String pZrnsyouhncd) {
        zrnsyouhncd = pZrnsyouhncd;
    }

    private String zrnmusymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNMUSYMD)
    public String getZrnmusymd() {
        return zrnmusymd;
    }

    public void setZrnmusymd(String pZrnmusymd) {
        zrnmusymd = pZrnmusymd;
    }

    private String zrnkykymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnkykseirituymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKYKSEIRITUYMD)
    public String getZrnkykseirituymd() {
        return zrnkykseirituymd;
    }

    public void setZrnkykseirituymd(String pZrnkykseirituymd) {
        zrnkykseirituymd = pZrnkykseirituymd;
    }

    private String zrnsekininkaisiymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSEKININKAISIYMD)
    public String getZrnsekininkaisiymd() {
        return zrnsekininkaisiymd;
    }

    public void setZrnsekininkaisiymd(String pZrnsekininkaisiymd) {
        zrnsekininkaisiymd = pZrnsekininkaisiymd;
    }

    private String zrnsyokaipymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSYOKAIPYMD)
    public String getZrnsyokaipymd() {
        return zrnsyokaipymd;
    }

    public void setZrnsyokaipymd(String pZrnsyokaipymd) {
        zrnsyokaipymd = pZrnsyokaipymd;
    }

    private String zrnhjnkojinkbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNHJNKOJINKBN)
    public String getZrnhjnkojinkbn() {
        return zrnhjnkojinkbn;
    }

    public void setZrnhjnkojinkbn(String pZrnhjnkojinkbn) {
        zrnhjnkojinkbn = pZrnhjnkojinkbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnhrkhuhukbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNHRKHUHUKBN)
    public String getZrnhrkhuhukbn() {
        return zrnhrkhuhukbn;
    }

    public void setZrnhrkhuhukbn(String pZrnhrkhuhukbn) {
        zrnhrkhuhukbn = pZrnhrkhuhukbn;
    }

    private String zrnhrkymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNHRKYMD)
    public String getZrnhrkymd() {
        return zrnhrkymd;
    }

    public void setZrnhrkymd(String pZrnhrkymd) {
        zrnhrkymd = pZrnhrkymd;
    }

    private Long zrngoukeip2;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNGOUKEIP2)
    public Long getZrngoukeip2() {
        return zrngoukeip2;
    }

    public void setZrngoukeip2(Long pZrngoukeip2) {
        zrngoukeip2 = pZrngoukeip2;
    }

    private Long zrnitijibrp;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNITIJIBRP)
    public Long getZrnitijibrp() {
        return zrnitijibrp;
    }

    public void setZrnitijibrp(Long pZrnitijibrp) {
        zrnitijibrp = pZrnitijibrp;
    }

    private String zrnbnkaisuu;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNBNKAISUU)
    public String getZrnbnkaisuu() {
        return zrnbnkaisuu;
    }

    public void setZrnbnkaisuu(String pZrnbnkaisuu) {
        zrnbnkaisuu = pZrnbnkaisuu;
    }

    private String zrnbnsyuruikbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNBNSYURUIKBN)
    public String getZrnbnsyuruikbn() {
        return zrnbnsyuruikbn;
    }

    public void setZrnbnsyuruikbn(String pZrnbnsyuruikbn) {
        zrnbnsyuruikbn = pZrnbnsyuruikbn;
    }

    private Long zrnbnkyk1kaip;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNBNKYK1KAIP)
    public Long getZrnbnkyk1kaip() {
        return zrnbnkyk1kaip;
    }

    public void setZrnbnkyk1kaip(Long pZrnbnkyk1kaip) {
        zrnbnkyk1kaip = pZrnbnkyk1kaip;
    }

    private String zrnyobiv20;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNYOBIV20)
    public String getZrnyobiv20() {
        return zrnyobiv20;
    }

    public void setZrnyobiv20(String pZrnyobiv20) {
        zrnyobiv20 = pZrnyobiv20;
    }

    private String zrnsyuhknkknkbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSYUHKNKKNKBN)
    public String getZrnsyuhknkknkbn() {
        return zrnsyuhknkknkbn;
    }

    public void setZrnsyuhknkknkbn(String pZrnsyuhknkknkbn) {
        zrnsyuhknkknkbn = pZrnsyuhknkknkbn;
    }

    private String zrnsyuhknkkn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSYUHKNKKN)
    public String getZrnsyuhknkkn() {
        return zrnsyuhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyuhknkkn(String pZrnsyuhknkkn) {
        zrnsyuhknkkn = pZrnsyuhknkkn;
    }

    private String zrnsyuhrkkknkbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSYUHRKKKNKBN)
    public String getZrnsyuhrkkknkbn() {
        return zrnsyuhrkkknkbn;
    }

    public void setZrnsyuhrkkknkbn(String pZrnsyuhrkkknkbn) {
        zrnsyuhrkkknkbn = pZrnsyuhrkkknkbn;
    }

    private String zrnsyuhrkkkn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSYUHRKKKN)
    public String getZrnsyuhrkkkn() {
        return zrnsyuhrkkkn;
    }

    public void setZrnsyuhrkkkn(String pZrnsyuhrkkkn) {
        zrnsyuhrkkkn = pZrnsyuhrkkkn;
    }

    private Long zrnsyus;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSYUS)
    public Long getZrnsyus() {
        return zrnsyus;
    }

    public void setZrnsyus(Long pZrnsyus) {
        zrnsyus = pZrnsyus;
    }

    private String zrnsyunm;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSYUNM)
    public String getZrnsyunm() {
        return zrnsyunm;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyunm(String pZrnsyunm) {
        zrnsyunm = pZrnsyunm;
    }

    private String zrnidojiyukbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNIDOJIYUKBN)
    public String getZrnidojiyukbn() {
        return zrnidojiyukbn;
    }

    public void setZrnidojiyukbn(String pZrnidojiyukbn) {
        zrnidojiyukbn = pZrnidojiyukbn;
    }

    private String zrnsyoumetucd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSYOUMETUCD)
    public String getZrnsyoumetucd() {
        return zrnsyoumetucd;
    }

    public void setZrnsyoumetucd(String pZrnsyoumetucd) {
        zrnsyoumetucd = pZrnsyoumetucd;
    }

    private String zrnidokaiyakuymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNIDOKAIYAKUYMD)
    public String getZrnidokaiyakuymd() {
        return zrnidokaiyakuymd;
    }

    public void setZrnidokaiyakuymd(String pZrnidokaiyakuymd) {
        zrnidokaiyakuymd = pZrnidokaiyakuymd;
    }

    private String zrnmankiymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNMANKIYMD)
    public String getZrnmankiymd() {
        return zrnmankiymd;
    }

    public void setZrnmankiymd(String pZrnmankiymd) {
        zrnmankiymd = pZrnmankiymd;
    }

    private Long zrnsibous;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSIBOUS)
    public Long getZrnsibous() {
        return zrnsibous;
    }

    public void setZrnsibous(Long pZrnsibous) {
        zrnsibous = pZrnsibous;
    }

    private Long zrnidoukaiyakup;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNIDOUKAIYAKUP)
    public Long getZrnidoukaiyakup() {
        return zrnidoukaiyakup;
    }

    public void setZrnidoukaiyakup(Long pZrnidoukaiyakup) {
        zrnidoukaiyakup = pZrnidoukaiyakup;
    }

    private String zrnsyukinkbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSYUKINKBN)
    public String getZrnsyukinkbn() {
        return zrnsyukinkbn;
    }

    public void setZrnsyukinkbn(String pZrnsyukinkbn) {
        zrnsyukinkbn = pZrnsyukinkbn;
    }

    private String zrnhaitoukbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNHAITOUKBN)
    public String getZrnhaitoukbn() {
        return zrnhaitoukbn;
    }

    public void setZrnhaitoukbn(String pZrnhaitoukbn) {
        zrnhaitoukbn = pZrnhaitoukbn;
    }

    private String zrncreditcardhrkbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNCREDITCARDHRKBN)
    public String getZrncreditcardhrkbn() {
        return zrncreditcardhrkbn;
    }

    public void setZrncreditcardhrkbn(String pZrncreditcardhrkbn) {
        zrncreditcardhrkbn = pZrncreditcardhrkbn;
    }

    private String zrntkjykbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKJYKBN)
    public String getZrntkjykbn() {
        return zrntkjykbn;
    }

    public void setZrntkjykbn(String pZrntkjykbn) {
        zrntkjykbn = pZrntkjykbn;
    }

    private String zrnsinsakbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSINSAKBN)
    public String getZrnsinsakbn() {
        return zrnsinsakbn;
    }

    public void setZrnsinsakbn(String pZrnsinsakbn) {
        zrnsinsakbn = pZrnsinsakbn;
    }

    private String zrnzeiseitekikakuhyj;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNZEISEITEKIKAKUHYJ)
    public String getZrnzeiseitekikakuhyj() {
        return zrnzeiseitekikakuhyj;
    }

    public void setZrnzeiseitekikakuhyj(String pZrnzeiseitekikakuhyj) {
        zrnzeiseitekikakuhyj = pZrnzeiseitekikakuhyj;
    }

    private String zrnlivhukauhyj;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNLIVHUKAUHYJ)
    public String getZrnlivhukauhyj() {
        return zrnlivhukauhyj;
    }

    public void setZrnlivhukauhyj(String pZrnlivhukauhyj) {
        zrnlivhukauhyj = pZrnlivhukauhyj;
    }

    private String zrnhrizmentyouhyj;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNHRIZMENTYOUHYJ)
    public String getZrnhrizmentyouhyj() {
        return zrnhrizmentyouhyj;
    }

    public void setZrnhrizmentyouhyj(String pZrnhrizmentyouhyj) {
        zrnhrizmentyouhyj = pZrnhrizmentyouhyj;
    }

    private String zrnkisokyknkshrhsykn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKISOKYKNKSHRHSYKN)
    public String getZrnkisokyknkshrhsykn() {
        return zrnkisokyknkshrhsykn;
    }

    public void setZrnkisokyknkshrhsykn(String pZrnkisokyknkshrhsykn) {
        zrnkisokyknkshrhsykn = pZrnkisokyknkshrhsykn;
    }

    private String zrnnkshrkknkbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNNKSHRKKNKBN)
    public String getZrnnkshrkknkbn() {
        return zrnnkshrkknkbn;
    }

    public void setZrnnkshrkknkbn(String pZrnnkshrkknkbn) {
        zrnnkshrkknkbn = pZrnnkshrkknkbn;
    }

    private String zrnnkshrkknnen;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNNKSHRKKNNEN)
    public String getZrnnkshrkknnen() {
        return zrnnkshrkknnen;
    }

    public void setZrnnkshrkknnen(String pZrnnkshrkknnen) {
        zrnnkshrkknnen = pZrnnkshrkknnen;
    }

    private String zrnnksueokikn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNNKSUEOKIKN)
    public String getZrnnksueokikn() {
        return zrnnksueokikn;
    }

    public void setZrnnksueokikn(String pZrnnksueokikn) {
        zrnnksueokikn = pZrnnksueokikn;
    }

    private String zrnnkshrstartymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNNKSHRSTARTYMD)
    public String getZrnnkshrstartymd() {
        return zrnnkshrstartymd;
    }

    public void setZrnnkshrstartymd(String pZrnnkshrstartymd) {
        zrnnkshrstartymd = pZrnnkshrstartymd;
    }

    private String zrnnkuketorininkbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNNKUKETORININKBN)
    public String getZrnnkuketorininkbn() {
        return zrnnkuketorininkbn;
    }

    public void setZrnnkuketorininkbn(String pZrnnkuketorininkbn) {
        zrnnkuketorininkbn = pZrnnkuketorininkbn;
    }

    private Long zrnzennoup;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNZENNOUP)
    public Long getZrnzennoup() {
        return zrnzennoup;
    }

    public void setZrnzennoup(Long pZrnzennoup) {
        zrnzennoup = pZrnzennoup;
    }

    private String zrnzennouendym;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNZENNOUENDYM)
    public String getZrnzennouendym() {
        return zrnzennouendym;
    }

    public void setZrnzennouendym(String pZrnzennouendym) {
        zrnzennouendym = pZrnzennouendym;
    }

    private String zrnteikaiyakuhrkn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTEIKAIYAKUHRKN)
    public String getZrnteikaiyakuhrkn() {
        return zrnteikaiyakuhrkn;
    }

    public void setZrnteikaiyakuhrkn(String pZrnteikaiyakuhrkn) {
        zrnteikaiyakuhrkn = pZrnteikaiyakuhrkn;
    }

    private String zrnmosno;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNMOSNO)
    public String getZrnmosno() {
        return zrnmosno;
    }

    public void setZrnmosno(String pZrnmosno) {
        zrnmosno = pZrnmosno;
    }

    private String zrntratkisyacd1;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTRATKISYACD1)
    public String getZrntratkisyacd1() {
        return zrntratkisyacd1;
    }

    public void setZrntratkisyacd1(String pZrntratkisyacd1) {
        zrntratkisyacd1 = pZrntratkisyacd1;
    }

    private String zrntratkisyacd2;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTRATKISYACD2)
    public String getZrntratkisyacd2() {
        return zrntratkisyacd2;
    }

    public void setZrntratkisyacd2(String pZrntratkisyacd2) {
        zrntratkisyacd2 = pZrntratkisyacd2;
    }

    private String zrndairiten1cd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNDAIRITEN1CD)
    public String getZrndairiten1cd() {
        return zrndairiten1cd;
    }

    public void setZrndairiten1cd(String pZrndairiten1cd) {
        zrndairiten1cd = pZrndairiten1cd;
    }

    private String zrndairiten2cd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNDAIRITEN2CD)
    public String getZrndairiten2cd() {
        return zrndairiten2cd;
    }

    public void setZrndairiten2cd(String pZrndairiten2cd) {
        zrndairiten2cd = pZrndairiten2cd;
    }

    private String zrnbsudirtnatkikeitaikbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNBSUDIRTNATKIKEITAIKBN)
    public String getZrnbsudirtnatkikeitaikbn() {
        return zrnbsudirtnatkikeitaikbn;
    }

    public void setZrnbsudirtnatkikeitaikbn(String pZrnbsudirtnatkikeitaikbn) {
        zrnbsudirtnatkikeitaikbn = pZrnbsudirtnatkikeitaikbn;
    }

    private Long zrnbsyudiritnatkiwari1;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNBSYUDIRITNATKIWARI1)
    public Long getZrnbsyudiritnatkiwari1() {
        return zrnbsyudiritnatkiwari1;
    }

    public void setZrnbsyudiritnatkiwari1(Long pZrnbsyudiritnatkiwari1) {
        zrnbsyudiritnatkiwari1 = pZrnbsyudiritnatkiwari1;
    }

    private Long zrnbsyudiritnatkiwari2;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNBSYUDIRITNATKIWARI2)
    public Long getZrnbsyudiritnatkiwari2() {
        return zrnbsyudiritnatkiwari2;
    }

    public void setZrnbsyudiritnatkiwari2(Long pZrnbsyudiritnatkiwari2) {
        zrnbsyudiritnatkiwari2 = pZrnbsyudiritnatkiwari2;
    }

    private String zrnyobiv20x2;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNYOBIV20X2)
    public String getZrnyobiv20x2() {
        return zrnyobiv20x2;
    }

    public void setZrnyobiv20x2(String pZrnyobiv20x2) {
        zrnyobiv20x2 = pZrnyobiv20x2;
    }

    private String zrntktyuutohukahyj;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKTYUUTOHUKAHYJ)
    public String getZrntktyuutohukahyj() {
        return zrntktyuutohukahyj;
    }

    public void setZrntktyuutohukahyj(String pZrntktyuutohukahyj) {
        zrntktyuutohukahyj = pZrntktyuutohukahyj;
    }

    private String zrntksuu;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKSUU)
    public String getZrntksuu() {
        return zrntksuu;
    }

    public void setZrntksuu(String pZrntksuu) {
        zrntksuu = pZrntksuu;
    }

    private String zrntkhosyucd1;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHOSYUCD1)
    public String getZrntkhosyucd1() {
        return zrntkhosyucd1;
    }

    public void setZrntkhosyucd1(String pZrntkhosyucd1) {
        zrntkhosyucd1 = pZrntkhosyucd1;
    }

    private String zrntknm1;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKNM1)
    public String getZrntknm1() {
        return zrntknm1;
    }

    @DataConvert("toMultiByte")
    public void setZrntknm1(String pZrntknm1) {
        zrntknm1 = pZrntknm1;
    }

    private Long zrntks1;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKS1)
    public Long getZrntks1() {
        return zrntks1;
    }

    public void setZrntks1(Long pZrntks1) {
        zrntks1 = pZrntks1;
    }

    private String zrntkhknkknkbn1;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHKNKKNKBN1)
    public String getZrntkhknkknkbn1() {
        return zrntkhknkknkbn1;
    }

    public void setZrntkhknkknkbn1(String pZrntkhknkknkbn1) {
        zrntkhknkknkbn1 = pZrntkhknkknkbn1;
    }

    private String zrntkhknkkn1;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHKNKKN1)
    public String getZrntkhknkkn1() {
        return zrntkhknkkn1;
    }

    public void setZrntkhknkkn1(String pZrntkhknkkn1) {
        zrntkhknkkn1 = pZrntkhknkkn1;
    }

    private String zrntkhrkkknkbn1;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHRKKKNKBN1)
    public String getZrntkhrkkknkbn1() {
        return zrntkhrkkknkbn1;
    }

    public void setZrntkhrkkknkbn1(String pZrntkhrkkknkbn1) {
        zrntkhrkkknkbn1 = pZrntkhrkkknkbn1;
    }

    private String zrntkhrkkkn1;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHRKKKN1)
    public String getZrntkhrkkkn1() {
        return zrntkhrkkkn1;
    }

    public void setZrntkhrkkkn1(String pZrntkhrkkkn1) {
        zrntkhrkkkn1 = pZrntkhrkkkn1;
    }

    private String zrntkhosyucd2;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHOSYUCD2)
    public String getZrntkhosyucd2() {
        return zrntkhosyucd2;
    }

    public void setZrntkhosyucd2(String pZrntkhosyucd2) {
        zrntkhosyucd2 = pZrntkhosyucd2;
    }

    private String zrntknm2;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKNM2)
    public String getZrntknm2() {
        return zrntknm2;
    }

    @DataConvert("toMultiByte")
    public void setZrntknm2(String pZrntknm2) {
        zrntknm2 = pZrntknm2;
    }

    private Long zrntks2;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKS2)
    public Long getZrntks2() {
        return zrntks2;
    }

    public void setZrntks2(Long pZrntks2) {
        zrntks2 = pZrntks2;
    }

    private String zrntkhknkknkbn2;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHKNKKNKBN2)
    public String getZrntkhknkknkbn2() {
        return zrntkhknkknkbn2;
    }

    public void setZrntkhknkknkbn2(String pZrntkhknkknkbn2) {
        zrntkhknkknkbn2 = pZrntkhknkknkbn2;
    }

    private String zrntkhknkkn2;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHKNKKN2)
    public String getZrntkhknkkn2() {
        return zrntkhknkkn2;
    }

    public void setZrntkhknkkn2(String pZrntkhknkkn2) {
        zrntkhknkkn2 = pZrntkhknkkn2;
    }

    private String zrntkhrkkknkbn2;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHRKKKNKBN2)
    public String getZrntkhrkkknkbn2() {
        return zrntkhrkkknkbn2;
    }

    public void setZrntkhrkkknkbn2(String pZrntkhrkkknkbn2) {
        zrntkhrkkknkbn2 = pZrntkhrkkknkbn2;
    }

    private String zrntkhrkkkn2;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHRKKKN2)
    public String getZrntkhrkkkn2() {
        return zrntkhrkkkn2;
    }

    public void setZrntkhrkkkn2(String pZrntkhrkkkn2) {
        zrntkhrkkkn2 = pZrntkhrkkkn2;
    }

    private String zrntkhosyucd3;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHOSYUCD3)
    public String getZrntkhosyucd3() {
        return zrntkhosyucd3;
    }

    public void setZrntkhosyucd3(String pZrntkhosyucd3) {
        zrntkhosyucd3 = pZrntkhosyucd3;
    }

    private String zrntknm3;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKNM3)
    public String getZrntknm3() {
        return zrntknm3;
    }

    @DataConvert("toMultiByte")
    public void setZrntknm3(String pZrntknm3) {
        zrntknm3 = pZrntknm3;
    }

    private Long zrntks3;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKS3)
    public Long getZrntks3() {
        return zrntks3;
    }

    public void setZrntks3(Long pZrntks3) {
        zrntks3 = pZrntks3;
    }

    private String zrntkhknkknkbn3;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHKNKKNKBN3)
    public String getZrntkhknkknkbn3() {
        return zrntkhknkknkbn3;
    }

    public void setZrntkhknkknkbn3(String pZrntkhknkknkbn3) {
        zrntkhknkknkbn3 = pZrntkhknkknkbn3;
    }

    private String zrntkhknkkn3;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHKNKKN3)
    public String getZrntkhknkkn3() {
        return zrntkhknkkn3;
    }

    public void setZrntkhknkkn3(String pZrntkhknkkn3) {
        zrntkhknkkn3 = pZrntkhknkkn3;
    }

    private String zrntkhrkkknkbn3;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHRKKKNKBN3)
    public String getZrntkhrkkknkbn3() {
        return zrntkhrkkknkbn3;
    }

    public void setZrntkhrkkknkbn3(String pZrntkhrkkknkbn3) {
        zrntkhrkkknkbn3 = pZrntkhrkkknkbn3;
    }

    private String zrntkhrkkkn3;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHRKKKN3)
    public String getZrntkhrkkkn3() {
        return zrntkhrkkkn3;
    }

    public void setZrntkhrkkkn3(String pZrntkhrkkkn3) {
        zrntkhrkkkn3 = pZrntkhrkkkn3;
    }

    private String zrntkhosyucd4;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHOSYUCD4)
    public String getZrntkhosyucd4() {
        return zrntkhosyucd4;
    }

    public void setZrntkhosyucd4(String pZrntkhosyucd4) {
        zrntkhosyucd4 = pZrntkhosyucd4;
    }

    private String zrntknm4;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKNM4)
    public String getZrntknm4() {
        return zrntknm4;
    }

    @DataConvert("toMultiByte")
    public void setZrntknm4(String pZrntknm4) {
        zrntknm4 = pZrntknm4;
    }

    private Long zrntks4;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKS4)
    public Long getZrntks4() {
        return zrntks4;
    }

    public void setZrntks4(Long pZrntks4) {
        zrntks4 = pZrntks4;
    }

    private String zrntkhknkknkbn4;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHKNKKNKBN4)
    public String getZrntkhknkknkbn4() {
        return zrntkhknkknkbn4;
    }

    public void setZrntkhknkknkbn4(String pZrntkhknkknkbn4) {
        zrntkhknkknkbn4 = pZrntkhknkknkbn4;
    }

    private String zrntkhknkkn4;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHKNKKN4)
    public String getZrntkhknkkn4() {
        return zrntkhknkkn4;
    }

    public void setZrntkhknkkn4(String pZrntkhknkkn4) {
        zrntkhknkkn4 = pZrntkhknkkn4;
    }

    private String zrntkhrkkknkbn4;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHRKKKNKBN4)
    public String getZrntkhrkkknkbn4() {
        return zrntkhrkkknkbn4;
    }

    public void setZrntkhrkkknkbn4(String pZrntkhrkkknkbn4) {
        zrntkhrkkknkbn4 = pZrntkhrkkknkbn4;
    }

    private String zrntkhrkkkn4;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHRKKKN4)
    public String getZrntkhrkkkn4() {
        return zrntkhrkkkn4;
    }

    public void setZrntkhrkkkn4(String pZrntkhrkkkn4) {
        zrntkhrkkkn4 = pZrntkhrkkkn4;
    }

    private String zrntkhosyucd5;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHOSYUCD5)
    public String getZrntkhosyucd5() {
        return zrntkhosyucd5;
    }

    public void setZrntkhosyucd5(String pZrntkhosyucd5) {
        zrntkhosyucd5 = pZrntkhosyucd5;
    }

    private String zrntknm5;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKNM5)
    public String getZrntknm5() {
        return zrntknm5;
    }

    @DataConvert("toMultiByte")
    public void setZrntknm5(String pZrntknm5) {
        zrntknm5 = pZrntknm5;
    }

    private Long zrntks5;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKS5)
    public Long getZrntks5() {
        return zrntks5;
    }

    public void setZrntks5(Long pZrntks5) {
        zrntks5 = pZrntks5;
    }

    private String zrntkhknkknkbn5;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHKNKKNKBN5)
    public String getZrntkhknkknkbn5() {
        return zrntkhknkknkbn5;
    }

    public void setZrntkhknkknkbn5(String pZrntkhknkknkbn5) {
        zrntkhknkknkbn5 = pZrntkhknkknkbn5;
    }

    private String zrntkhknkkn5;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHKNKKN5)
    public String getZrntkhknkkn5() {
        return zrntkhknkkn5;
    }

    public void setZrntkhknkkn5(String pZrntkhknkkn5) {
        zrntkhknkkn5 = pZrntkhknkkn5;
    }

    private String zrntkhrkkknkbn5;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHRKKKNKBN5)
    public String getZrntkhrkkknkbn5() {
        return zrntkhrkkknkbn5;
    }

    public void setZrntkhrkkknkbn5(String pZrntkhrkkknkbn5) {
        zrntkhrkkknkbn5 = pZrntkhrkkknkbn5;
    }

    private String zrntkhrkkkn5;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHRKKKN5)
    public String getZrntkhrkkkn5() {
        return zrntkhrkkkn5;
    }

    public void setZrntkhrkkkn5(String pZrntkhrkkkn5) {
        zrntkhrkkkn5 = pZrntkhrkkkn5;
    }

    private String zrntkhosyucd6;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHOSYUCD6)
    public String getZrntkhosyucd6() {
        return zrntkhosyucd6;
    }

    public void setZrntkhosyucd6(String pZrntkhosyucd6) {
        zrntkhosyucd6 = pZrntkhosyucd6;
    }

    private String zrntknm6;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKNM6)
    public String getZrntknm6() {
        return zrntknm6;
    }

    @DataConvert("toMultiByte")
    public void setZrntknm6(String pZrntknm6) {
        zrntknm6 = pZrntknm6;
    }

    private Long zrntks6;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKS6)
    public Long getZrntks6() {
        return zrntks6;
    }

    public void setZrntks6(Long pZrntks6) {
        zrntks6 = pZrntks6;
    }

    private String zrntkhknkknkbn6;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHKNKKNKBN6)
    public String getZrntkhknkknkbn6() {
        return zrntkhknkknkbn6;
    }

    public void setZrntkhknkknkbn6(String pZrntkhknkknkbn6) {
        zrntkhknkknkbn6 = pZrntkhknkknkbn6;
    }

    private String zrntkhknkkn6;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHKNKKN6)
    public String getZrntkhknkkn6() {
        return zrntkhknkkn6;
    }

    public void setZrntkhknkkn6(String pZrntkhknkkn6) {
        zrntkhknkkn6 = pZrntkhknkkn6;
    }

    private String zrntkhrkkknkbn6;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHRKKKNKBN6)
    public String getZrntkhrkkknkbn6() {
        return zrntkhrkkknkbn6;
    }

    public void setZrntkhrkkknkbn6(String pZrntkhrkkknkbn6) {
        zrntkhrkkknkbn6 = pZrntkhrkkknkbn6;
    }

    private String zrntkhrkkkn6;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTKHRKKKN6)
    public String getZrntkhrkkkn6() {
        return zrntkhrkkkn6;
    }

    public void setZrntkhrkkkn6(String pZrntkhrkkkn6) {
        zrntkhrkkkn6 = pZrntkhrkkkn6;
    }

    private String zrnsbuktnm;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSBUKTNM)
    public String getZrnsbuktnm() {
        return zrnsbuktnm;
    }

    public void setZrnsbuktnm(String pZrnsbuktnm) {
        zrnsbuktnm = pZrnsbuktnm;
    }

    private String zrnkjsbuktnm;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKJSBUKTNM)
    public String getZrnkjsbuktnm() {
        return zrnkjsbuktnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjsbuktnm(String pZrnkjsbuktnm) {
        zrnkjsbuktnm = pZrnkjsbuktnm;
    }

    private String zrnsbukttdk;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSBUKTTDK)
    public String getZrnsbukttdk() {
        return zrnsbukttdk;
    }

    public void setZrnsbukttdk(String pZrnsbukttdk) {
        zrnsbukttdk = pZrnsbukttdk;
    }

    private String zrnsbuktnin;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSBUKTNIN)
    public String getZrnsbuktnin() {
        return zrnsbuktnin;
    }

    public void setZrnsbuktnin(String pZrnsbuktnin) {
        zrnsbuktnin = pZrnsbuktnin;
    }

    private String zrnyobiv28;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNYOBIV28)
    public String getZrnyobiv28() {
        return zrnyobiv28;
    }

    public void setZrnyobiv28(String pZrnyobiv28) {
        zrnyobiv28 = pZrnyobiv28;
    }

    private String zrnyno7keta;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNYNO7KETA)
    public String getZrnyno7keta() {
        return zrnyno7keta;
    }

    public void setZrnyno7keta(String pZrnyno7keta) {
        zrnyno7keta = pZrnyno7keta;
    }

    private String zrntelnokydgw;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTELNOKYDGW)
    public String getZrntelnokydgw() {
        return zrntelnokydgw;
    }

    public void setZrntelnokydgw(String pZrntelnokydgw) {
        zrntelnokydgw = pZrntelnokydgw;
    }

    private String zrnkyknmknkydgw;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKYKNMKNKYDGW)
    public String getZrnkyknmknkydgw() {
        return zrnkyknmknkydgw;
    }

    public void setZrnkyknmknkydgw(String pZrnkyknmknkydgw) {
        zrnkyknmknkydgw = pZrnkyknmknkydgw;
    }

    private String zrnkyksyaseiymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKYKSYASEIYMD)
    public String getZrnkyksyaseiymd() {
        return zrnkyksyaseiymd;
    }

    public void setZrnkyksyaseiymd(String pZrnkyksyaseiymd) {
        zrnkyksyaseiymd = pZrnkyksyaseiymd;
    }

    private String zrnkyksyaseikbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKYKSYASEIKBN)
    public String getZrnkyksyaseikbn() {
        return zrnkyksyaseikbn;
    }

    public void setZrnkyksyaseikbn(String pZrnkyksyaseikbn) {
        zrnkyksyaseikbn = pZrnkyksyaseikbn;
    }

    private String zrntsinkihontikucd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNTSINKIHONTIKUCD)
    public String getZrntsinkihontikucd() {
        return zrntsinkihontikucd;
    }

    public void setZrntsinkihontikucd(String pZrntsinkihontikucd) {
        zrntsinkihontikucd = pZrntsinkihontikucd;
    }

    private String zrnkykadrkj50;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKYKADRKJ50)
    public String getZrnkykadrkj50() {
        return zrnkykadrkj50;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykadrkj50(String pZrnkykadrkj50) {
        zrnkykadrkj50 = pZrnkykadrkj50;
    }

    private String zrnkyknmkjkydgw;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKYKNMKJKYDGW)
    public String getZrnkyknmkjkydgw() {
        return zrnkyknmkjkydgw;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkjkydgw(String pZrnkyknmkjkydgw) {
        zrnkyknmkjkydgw = pZrnkyknmkjkydgw;
    }

    private String zrnhhknmei;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNHHKNMEI)
    public String getZrnhhknmei() {
        return zrnhhknmei;
    }

    public void setZrnhhknmei(String pZrnhhknmei) {
        zrnhhknmei = pZrnhhknmei;
    }

    private String zrnhhknnmkj;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNHHKNNMKJ)
    public String getZrnhhknnmkj() {
        return zrnhhknnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj(String pZrnhhknnmkj) {
        zrnhhknnmkj = pZrnhhknnmkj;
    }

    private String zrnhhknseiymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNHHKNSEIYMD)
    public String getZrnhhknseiymd() {
        return zrnhhknseiymd;
    }

    public void setZrnhhknseiymd(String pZrnhhknseiymd) {
        zrnhhknseiymd = pZrnhhknseiymd;
    }

    private String zrnhhknnen;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNHHKNNEN)
    public String getZrnhhknnen() {
        return zrnhhknnen;
    }

    public void setZrnhhknnen(String pZrnhhknnen) {
        zrnhhknnen = pZrnhhknnen;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhhkntdk;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNHHKNTDK)
    public String getZrnhhkntdk() {
        return zrnhhkntdk;
    }

    public void setZrnhhkntdk(String pZrnhhkntdk) {
        zrnhhkntdk = pZrnhhkntdk;
    }

    private String zrnkzsyurui;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKZSYURUI)
    public String getZrnkzsyurui() {
        return zrnkzsyurui;
    }

    public void setZrnkzsyurui(String pZrnkzsyurui) {
        zrnkzsyurui = pZrnkzsyurui;
    }

    private String zrnkouzano7keta;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKOUZANO7KETA)
    public String getZrnkouzano7keta() {
        return zrnkouzano7keta;
    }

    public void setZrnkouzano7keta(String pZrnkouzano7keta) {
        zrnkouzano7keta = pZrnkouzano7keta;
    }

    private String zrnkzhurikaebankcd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKZHURIKAEBANKCD)
    public String getZrnkzhurikaebankcd() {
        return zrnkzhurikaebankcd;
    }

    public void setZrnkzhurikaebankcd(String pZrnkzhurikaebankcd) {
        zrnkzhurikaebankcd = pZrnkzhurikaebankcd;
    }

    private String zrnkzhurikaesitencd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKZHURIKAESITENCD)
    public String getZrnkzhurikaesitencd() {
        return zrnkzhurikaesitencd;
    }

    public void setZrnkzhurikaesitencd(String pZrnkzhurikaesitencd) {
        zrnkzhurikaesitencd = pZrnkzhurikaesitencd;
    }

    private String zrnkanyuusyaknrno;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKANYUUSYAKNRNO)
    public String getZrnkanyuusyaknrno() {
        return zrnkanyuusyaknrno;
    }

    public void setZrnkanyuusyaknrno(String pZrnkanyuusyaknrno) {
        zrnkanyuusyaknrno = pZrnkanyuusyaknrno;
    }

    private String zrnkyksiboumeighnkhyj;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKYKSIBOUMEIGHNKHYJ)
    public String getZrnkyksiboumeighnkhyj() {
        return zrnkyksiboumeighnkhyj;
    }

    public void setZrnkyksiboumeighnkhyj(String pZrnkyksiboumeighnkhyj) {
        zrnkyksiboumeighnkhyj = pZrnkyksiboumeighnkhyj;
    }

    private String zrnyobiv11;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNYOBIV11)
    public String getZrnyobiv11() {
        return zrnyobiv11;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnyobiv11(String pZrnyobiv11) {
        zrnyobiv11 = pZrnyobiv11;
    }

    private String zrnmnkuktkbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNMNKUKTKBN)
    public String getZrnmnkuktkbn() {
        return zrnmnkuktkbn;
    }

    public void setZrnmnkuktkbn(String pZrnmnkuktkbn) {
        zrnmnkuktkbn = pZrnmnkuktkbn;
    }

    private String zrnmnkuktnm1;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNMNKUKTNM1)
    public String getZrnmnkuktnm1() {
        return zrnmnkuktnm1;
    }

    public void setZrnmnkuktnm1(String pZrnmnkuktnm1) {
        zrnmnkuktnm1 = pZrnmnkuktnm1;
    }

    private String zrnmnkuktnm2;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNMNKUKTNM2)
    public String getZrnmnkuktnm2() {
        return zrnmnkuktnm2;
    }

    public void setZrnmnkuktnm2(String pZrnmnkuktnm2) {
        zrnmnkuktnm2 = pZrnmnkuktnm2;
    }

    private String zrnmnkuktnm3;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNMNKUKTNM3)
    public String getZrnmnkuktnm3() {
        return zrnmnkuktnm3;
    }

    public void setZrnmnkuktnm3(String pZrnmnkuktnm3) {
        zrnmnkuktnm3 = pZrnmnkuktnm3;
    }

    private String zrnmnkuktnm4;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNMNKUKTNM4)
    public String getZrnmnkuktnm4() {
        return zrnmnkuktnm4;
    }

    public void setZrnmnkuktnm4(String pZrnmnkuktnm4) {
        zrnmnkuktnm4 = pZrnmnkuktnm4;
    }

    private String zrnsbuktkbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSBUKTKBN)
    public String getZrnsbuktkbn() {
        return zrnsbuktkbn;
    }

    public void setZrnsbuktkbn(String pZrnsbuktkbn) {
        zrnsbuktkbn = pZrnsbuktkbn;
    }

    private String zrnsbuktnm1;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSBUKTNM1)
    public String getZrnsbuktnm1() {
        return zrnsbuktnm1;
    }

    public void setZrnsbuktnm1(String pZrnsbuktnm1) {
        zrnsbuktnm1 = pZrnsbuktnm1;
    }

    private String zrnsbuktnm2;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSBUKTNM2)
    public String getZrnsbuktnm2() {
        return zrnsbuktnm2;
    }

    public void setZrnsbuktnm2(String pZrnsbuktnm2) {
        zrnsbuktnm2 = pZrnsbuktnm2;
    }

    private String zrnsbuktnm3;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSBUKTNM3)
    public String getZrnsbuktnm3() {
        return zrnsbuktnm3;
    }

    public void setZrnsbuktnm3(String pZrnsbuktnm3) {
        zrnsbuktnm3 = pZrnsbuktnm3;
    }

    private String zrnsbuktnm4;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNSBUKTNM4)
    public String getZrnsbuktnm4() {
        return zrnsbuktnm4;
    }

    public void setZrnsbuktnm4(String pZrnsbuktnm4) {
        zrnsbuktnm4 = pZrnsbuktnm4;
    }

    private String zrnyobiv20x3;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNYOBIV20X3)
    public String getZrnyobiv20x3() {
        return zrnyobiv20x3;
    }

    public void setZrnyobiv20x3(String pZrnyobiv20x3) {
        zrnyobiv20x3 = pZrnyobiv20x3;
    }

    @Id
    @Column(name=GenZT_KydGWKykInfoRn.ZRNSYORIYMD)
    public String getZrnsyoriymd() {
        return getPrimaryKey().getZrnsyoriymd();
    }

    public void setZrnsyoriymd(String pZrnsyoriymd) {
        getPrimaryKey().setZrnsyoriymd(pZrnsyoriymd);
    }

    @Id
    @Column(name=GenZT_KydGWKykInfoRn.ZRNKYKMFKSNCTRLKH)
    public Long getZrnkykmfksnctrlkh() {
        return getPrimaryKey().getZrnkykmfksnctrlkh();
    }

    public void setZrnkykmfksnctrlkh(Long pZrnkykmfksnctrlkh) {
        getPrimaryKey().setZrnkykmfksnctrlkh(pZrnkykmfksnctrlkh);
    }

    private String zrnmkhtoutatuymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNMKHTOUTATUYMD)
    public String getZrnmkhtoutatuymd() {
        return zrnmkhtoutatuymd;
    }

    public void setZrnmkhtoutatuymd(String pZrnmkhtoutatuymd) {
        zrnmkhtoutatuymd = pZrnmkhtoutatuymd;
    }

    private String zrnkykhrkmtuuka;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKYKHRKMTUUKA)
    public String getZrnkykhrkmtuuka() {
        return zrnkykhrkmtuuka;
    }

    public void setZrnkykhrkmtuuka(String pZrnkykhrkmtuuka) {
        zrnkykhrkmtuuka = pZrnkykhrkmtuuka;
    }

    private Long zrnkykhrkmgk;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKYKHRKMGK)
    public Long getZrnkykhrkmgk() {
        return zrnkykhrkmgk;
    }

    public void setZrnkykhrkmgk(Long pZrnkykhrkmgk) {
        zrnkykhrkmgk = pZrnkykhrkmgk;
    }

    private String zrnikkatubaraikbn;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNIKKATUBARAIKBN)
    public String getZrnikkatubaraikbn() {
        return zrnikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnikkatubaraikbn(String pZrnikkatubaraikbn) {
        zrnikkatubaraikbn = pZrnikkatubaraikbn;
    }

    private String zrnikkatubaraikaisuu;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNIKKATUBARAIKAISUU)
    public String getZrnikkatubaraikaisuu() {
        return zrnikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnikkatubaraikaisuu(String pZrnikkatubaraikaisuu) {
        zrnikkatubaraikaisuu = pZrnikkatubaraikaisuu;
    }

    private BizNumber zrntousyokykjiyennyknrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KydGWKykInfoRn.ZRNTOUSYOKYKJIYENNYKNRATE)
    public BizNumber getZrntousyokykjiyennyknrate() {
        return zrntousyokykjiyennyknrate;
    }

    public void setZrntousyokykjiyennyknrate(BizNumber pZrntousyokykjiyennyknrate) {
        zrntousyokykjiyennyknrate = pZrntousyokykjiyennyknrate;
    }

    private BizNumber zrnrendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KydGWKykInfoRn.ZRNRENDOURITU)
    public BizNumber getZrnrendouritu() {
        return zrnrendouritu;
    }

    public void setZrnrendouritu(BizNumber pZrnrendouritu) {
        zrnrendouritu = pZrnrendouritu;
    }

    private BizNumber zrnteikishrritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KydGWKykInfoRn.ZRNTEIKISHRRITU)
    public BizNumber getZrnteikishrritu() {
        return zrnteikishrritu;
    }

    public void setZrnteikishrritu(BizNumber pZrnteikishrritu) {
        zrnteikishrritu = pZrnteikishrritu;
    }

    private String zrnkosyasbskttdkstartflg;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKOSYASBSKTTDKSTARTFLG)
    public String getZrnkosyasbskttdkstartflg() {
        return zrnkosyasbskttdkstartflg;
    }

    public void setZrnkosyasbskttdkstartflg(String pZrnkosyasbskttdkstartflg) {
        zrnkosyasbskttdkstartflg = pZrnkosyasbskttdkstartflg;
    }

    private String zrnkosyasbukthukusuflg;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKOSYASBUKTHUKUSUFLG)
    public String getZrnkosyasbukthukusuflg() {
        return zrnkosyasbukthukusuflg;
    }

    public void setZrnkosyasbukthukusuflg(String pZrnkosyasbukthukusuflg) {
        zrnkosyasbukthukusuflg = pZrnkosyasbukthukusuflg;
    }

    private String zrnkosyahhknsbymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKOSYAHHKNSBYMD)
    public String getZrnkosyahhknsbymd() {
        return zrnkosyahhknsbymd;
    }

    public void setZrnkosyahhknsbymd(String pZrnkosyahhknsbymd) {
        zrnkosyahhknsbymd = pZrnkosyahhknsbymd;
    }

    private String zrnkosyassksjyuriymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKOSYASSKSJYURIYMD)
    public String getZrnkosyassksjyuriymd() {
        return zrnkosyassksjyuriymd;
    }

    public void setZrnkosyassksjyuriymd(String pZrnkosyassksjyuriymd) {
        zrnkosyassksjyuriymd = pZrnkosyassksjyuriymd;
    }

    private String zrnkosyasshrkanryoymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKOSYASSHRKANRYOYMD)
    public String getZrnkosyasshrkanryoymd() {
        return zrnkosyasshrkanryoymd;
    }

    public void setZrnkosyasshrkanryoymd(String pZrnkosyasshrkanryoymd) {
        zrnkosyasshrkanryoymd = pZrnkosyasshrkanryoymd;
    }

    private String zrnkosyasbuktseiymd;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKOSYASBUKTSEIYMD)
    public String getZrnkosyasbuktseiymd() {
        return zrnkosyasbuktseiymd;
    }

    public void setZrnkosyasbuktseiymd(String pZrnkosyasbuktseiymd) {
        zrnkosyasbuktseiymd = pZrnkosyasbuktseiymd;
    }

    private String zrnkosyasbuktkjadr;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKOSYASBUKTKJADR)
    public String getZrnkosyasbuktkjadr() {
        return zrnkosyasbuktkjadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnkosyasbuktkjadr(String pZrnkosyasbuktkjadr) {
        zrnkosyasbuktkjadr = pZrnkosyasbuktkjadr;
    }

    private String zrnkosyasbukttelno;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNKOSYASBUKTTELNO)
    public String getZrnkosyasbukttelno() {
        return zrnkosyasbukttelno;
    }

    public void setZrnkosyasbukttelno(String pZrnkosyasbukttelno) {
        zrnkosyasbukttelno = pZrnkosyasbukttelno;
    }

    private String zrnyobiv252;

    @Column(name=GenZT_KydGWKykInfoRn.ZRNYOBIV252)
    public String getZrnyobiv252() {
        return zrnyobiv252;
    }

    public void setZrnyobiv252(String pZrnyobiv252) {
        zrnyobiv252 = pZrnyobiv252;
    }
}
package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KydGWKykInfoTy;
import yuyu.def.db.mapping.GenZT_KydGWKykInfoTy;
import yuyu.def.db.meta.GenQZT_KydGWKykInfoTy;
import yuyu.def.db.meta.QZT_KydGWKykInfoTy;

/**
 * 共同ＧＷ用契約情報Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KydGWKykInfoTy}</td><td colspan="3">共同ＧＷ用契約情報Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyurui2keta</td><td>（中継用）保険種類（２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinkeizkkbn</td><td>（中継用）新規継続区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuhosyucd</td><td>（中継用）主契約保種コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymdhnaisyoumeicd</td><td>（中継用）窓販用愛称名コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyouhncd</td><td>（中継用）商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymusymd</td><td>（中継用）申込年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykseirituymd</td><td>（中継用）契約成立年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysekininkaisiymd</td><td>（中継用）責任開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaipymd</td><td>（中継用）初回Ｐ入金年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhjnkojinkbn</td><td>（中継用）法人個人区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkhuhukbn</td><td>（中継用）払込方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkymd</td><td>（中継用）払込日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygoukeip2</td><td>（中継用）合計保険料２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyitijibrp</td><td>（中継用）一時払保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybnkaisuu</td><td>（中継用）分割回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybnsyuruikbn</td><td>（中継用）分割種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybnkyk1kaip</td><td>（中継用）分割払契約１回分保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv20</td><td>（中継用）予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuhknkknkbn</td><td>（中継用）主契約保険期間区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuhknkkn</td><td>（中継用）主契約保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuhrkkknkbn</td><td>（中継用）主契約払込期間区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuhrkkkn</td><td>（中継用）主契約払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyus</td><td>（中継用）主契約保険金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyunm</td><td>（中継用）主契約名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyidojiyukbn</td><td>（中継用）異動事由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoumetucd</td><td>（中継用）消滅コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyidokaiyakuymd</td><td>（中継用）異動解約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymankiymd</td><td>（中継用）満期年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysibous</td><td>（中継用）死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyidoukaiyakup</td><td>（中継用）異動解約保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukinkbn</td><td>（中継用）集金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhaitoukbn</td><td>（中継用）配当区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycreditcardhrkbn</td><td>（中継用）クレジットカード払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkjykbn</td><td>（中継用）特条区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinsakbn</td><td>（中継用）診査区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzeiseitekikakuhyj</td><td>（中継用）税制適格表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztylivhukauhyj</td><td>（中継用）リビングニーズ付加表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrizmentyouhyj</td><td>（中継用）払済延長表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykisokyknkshrhsykn</td><td>（中継用）基礎契約年金支払保証期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkshrkknkbn</td><td>（中継用）年金支払期間区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkshrkknnen</td><td>（中継用）年金支払期間年</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksueokikn</td><td>（中継用）年金据置期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkshrstartymd</td><td>（中継用）年金支払開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkuketorininkbn</td><td>（中継用）年金受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennoup</td><td>（中継用）前納保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzennouendym</td><td>（中継用）前納終了年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikaiyakuhrkn</td><td>（中継用）低解約返戻金期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymosno</td><td>（中継用）申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytratkisyacd1</td><td>（中継用）取扱者コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytratkisyacd2</td><td>（中継用）取扱者コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairiten1cd</td><td>（中継用）代理店１コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairiten2cd</td><td>（中継用）代理店２コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsudirtnatkikeitaikbn</td><td>（中継用）募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyudiritnatkiwari1</td><td>（中継用）募集代理店扱割合１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybsyudiritnatkiwari2</td><td>（中継用）募集代理店扱割合２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv20x2</td><td>（中継用）予備項目Ｖ２０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytktyuutohukahyj</td><td>（中継用）特約中途付加表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksuu</td><td>（中継用）特約数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhosyucd1</td><td>（中継用）特約保種コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytknm1</td><td>（中継用）特約名称１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytks1</td><td>（中継用）特約保険金額１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytkhknkknkbn1</td><td>（中継用）特約保険期間区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkkn1</td><td>（中継用）特約保険期間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkknkbn1</td><td>（中継用）特約払込期間区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkkn1</td><td>（中継用）特約払込期間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhosyucd2</td><td>（中継用）特約保種コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytknm2</td><td>（中継用）特約名称２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytks2</td><td>（中継用）特約保険金額２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytkhknkknkbn2</td><td>（中継用）特約保険期間区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkkn2</td><td>（中継用）特約保険期間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkknkbn2</td><td>（中継用）特約払込期間区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkkn2</td><td>（中継用）特約払込期間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhosyucd3</td><td>（中継用）特約保種コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytknm3</td><td>（中継用）特約名称３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytks3</td><td>（中継用）特約保険金額３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytkhknkknkbn3</td><td>（中継用）特約保険期間区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkkn3</td><td>（中継用）特約保険期間３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkknkbn3</td><td>（中継用）特約払込期間区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkkn3</td><td>（中継用）特約払込期間３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhosyucd4</td><td>（中継用）特約保種コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytknm4</td><td>（中継用）特約名称４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytks4</td><td>（中継用）特約保険金額４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytkhknkknkbn4</td><td>（中継用）特約保険期間区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkkn4</td><td>（中継用）特約保険期間４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkknkbn4</td><td>（中継用）特約払込期間区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkkn4</td><td>（中継用）特約払込期間４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhosyucd5</td><td>（中継用）特約保種コード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytknm5</td><td>（中継用）特約名称５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytks5</td><td>（中継用）特約保険金額５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytkhknkknkbn5</td><td>（中継用）特約保険期間区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkkn5</td><td>（中継用）特約保険期間５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkknkbn5</td><td>（中継用）特約払込期間区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkkn5</td><td>（中継用）特約払込期間５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhosyucd6</td><td>（中継用）特約保種コード６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytknm6</td><td>（中継用）特約名称６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytks6</td><td>（中継用）特約保険金額６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytkhknkknkbn6</td><td>（中継用）特約保険期間区分６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhknkkn6</td><td>（中継用）特約保険期間６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkknkbn6</td><td>（中継用）特約払込期間区分６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkhrkkkn6</td><td>（中継用）特約払込期間６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktnm</td><td>（中継用）死亡受取人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjsbuktnm</td><td>（中継用）漢字死亡受取人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbukttdk</td><td>（中継用）死亡受取人続柄</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktnin</td><td>（中継用）死亡受取人人数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv28</td><td>（中継用）予備項目Ｖ２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyno7keta</td><td>（中継用）郵便番号（７桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytelnokydgw</td><td>（中継用）電話番号（共同ＧＷ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmknkydgw</td><td>（中継用）契約者名（カナ）（共同ＧＷ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaseiymd</td><td>（中継用）契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaseikbn</td><td>（中継用）契約者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsinkihontikucd</td><td>（中継用）通信先基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykadrkj50</td><td>（中継用）契約者漢字住所５０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkjkydgw</td><td>（中継用）契約者名（漢字）（共同ＧＷ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknmei</td><td>（中継用）被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkj</td><td>（中継用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseiymd</td><td>（中継用）被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnen</td><td>（中継用）被保険者年齢</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkntdk</td><td>（中継用）被保険者続柄</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzsyurui</td><td>（中継用）口座種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykouzano7keta</td><td>（中継用）口座番号（７桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaebankcd</td><td>（中継用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaesitencd</td><td>（中継用）口座振替支店番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanyuusyaknrno</td><td>（中継用）加入者管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksiboumeighnkhyj</td><td>（中継用）契約者死亡名義変更表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv11</td><td>（中継用）予備項目Ｖ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymnkuktkbn</td><td>（中継用）満期受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymnkuktnm1</td><td>（中継用）満期受取人名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymnkuktnm2</td><td>（中継用）満期受取人名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymnkuktnm3</td><td>（中継用）満期受取人名３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymnkuktnm4</td><td>（中継用）満期受取人名４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktkbn</td><td>（中継用）死亡受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktnm1</td><td>（中継用）死亡受取人名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktnm2</td><td>（中継用）死亡受取人名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktnm3</td><td>（中継用）死亡受取人名３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktnm4</td><td>（中継用）死亡受取人名４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv20x3</td><td>（中継用）予備項目Ｖ２０＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyoriymd ztysyoriymd}</td><td>（中継用）処理年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykykmfksnctrlkh ztykykmfksnctrlkh}</td><td>（中継用）契約ＭＦ更新ＣＴＲ（保全）</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymkhtoutatuymd</td><td>（中継用）目標到達年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykhrkmtuuka</td><td>（中継用）契約者振込通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykhrkmgk</td><td>（中継用）契約者振込金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyikkatubaraikbn</td><td>（中継用）一括払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatubaraikaisuu</td><td>（中継用）一括払回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytousyokykjiyennyknrate</td><td>（中継用）当初契約時円入金レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyrendouritu</td><td>（中継用）連動率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyteikishrritu</td><td>（中継用）定期支払率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykosyasbskttdkstartflg</td><td>（中継用）個社死亡請求手続き開始フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykosyasbukthukusuflg</td><td>（中継用）個社死亡受取人複数フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykosyahhknsbymd</td><td>（中継用）個社被保険者死亡日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykosyassksjyuriymd</td><td>（中継用）個社保険金請求書受理日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykosyasshrkanryoymd</td><td>（中継用）個社保険金支払完了日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykosyasbuktseiymd</td><td>（中継用）個社死亡保険金受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykosyasbuktkjadr</td><td>（中継用）個社死亡保険金受取人住所漢字</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykosyasbukttelno</td><td>（中継用）個社死亡保険金受取人電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv252</td><td>（中継用）予備項目Ｖ２５２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KydGWKykInfoTy
 * @see     GenZT_KydGWKykInfoTy
 * @see     QZT_KydGWKykInfoTy
 * @see     GenQZT_KydGWKykInfoTy
 */
public class PKZT_KydGWKykInfoTy extends AbstractExDBPrimaryKey<ZT_KydGWKykInfoTy, PKZT_KydGWKykInfoTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_KydGWKykInfoTy() {
    }

    public PKZT_KydGWKykInfoTy(
        String pZtysyono,
        String pZtysyoriymd,
        Long pZtykykmfksnctrlkh
    ) {
        ztysyono = pZtysyono;
        ztysyoriymd = pZtysyoriymd;
        ztykykmfksnctrlkh = pZtykykmfksnctrlkh;
    }

    @Transient
    @Override
    public Class<ZT_KydGWKykInfoTy> getEntityClass() {
        return ZT_KydGWKykInfoTy.class;
    }

    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztysyoriymd;

    public String getZtysyoriymd() {
        return ztysyoriymd;
    }

    public void setZtysyoriymd(String pZtysyoriymd) {
        ztysyoriymd = pZtysyoriymd;
    }
    private Long ztykykmfksnctrlkh;

    public Long getZtykykmfksnctrlkh() {
        return ztykykmfksnctrlkh;
    }

    public void setZtykykmfksnctrlkh(Long pZtykykmfksnctrlkh) {
        ztykykmfksnctrlkh = pZtykykmfksnctrlkh;
    }

}
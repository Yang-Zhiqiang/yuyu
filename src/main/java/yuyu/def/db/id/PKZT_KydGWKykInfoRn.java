package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KydGWKykInfoRn;
import yuyu.def.db.mapping.GenZT_KydGWKykInfoRn;
import yuyu.def.db.meta.GenQZT_KydGWKykInfoRn;
import yuyu.def.db.meta.QZT_KydGWKykInfoRn;

/**
 * 共同ＧＷ用契約情報Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KydGWKykInfoRn}</td><td colspan="3">共同ＧＷ用契約情報Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyurui2keta</td><td>（連携用）保険種類（２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsinkeizkkbn</td><td>（連携用）新規継続区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuhosyucd</td><td>（連携用）主契約保種コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmdhnaisyoumeicd</td><td>（連携用）窓販用愛称名コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyouhncd</td><td>（連携用）商品コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmusymd</td><td>（連携用）申込年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykseirituymd</td><td>（連携用）契約成立年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsekininkaisiymd</td><td>（連携用）責任開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokaipymd</td><td>（連携用）初回Ｐ入金年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjnkojinkbn</td><td>（連携用）法人個人区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkhuhukbn</td><td>（連携用）払込方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkymd</td><td>（連携用）払込日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngoukeip2</td><td>（連携用）合計保険料２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnitijibrp</td><td>（連携用）一時払保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbnkaisuu</td><td>（連携用）分割回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbnsyuruikbn</td><td>（連携用）分割種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbnkyk1kaip</td><td>（連携用）分割払契約１回分保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv20</td><td>（連携用）予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuhknkknkbn</td><td>（連携用）主契約保険期間区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuhknkkn</td><td>（連携用）主契約保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuhrkkknkbn</td><td>（連携用）主契約払込期間区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuhrkkkn</td><td>（連携用）主契約払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyus</td><td>（連携用）主契約保険金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyunm</td><td>（連携用）主契約名称</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnidojiyukbn</td><td>（連携用）異動事由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoumetucd</td><td>（連携用）消滅コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnidokaiyakuymd</td><td>（連携用）異動解約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmankiymd</td><td>（連携用）満期年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsibous</td><td>（連携用）死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnidoukaiyakup</td><td>（連携用）異動解約保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukinkbn</td><td>（連携用）集金区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhaitoukbn</td><td>（連携用）配当区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncreditcardhrkbn</td><td>（連携用）クレジットカード払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkjykbn</td><td>（連携用）特条区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsinsakbn</td><td>（連携用）診査区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzeiseitekikakuhyj</td><td>（連携用）税制適格表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnlivhukauhyj</td><td>（連携用）リビングニーズ付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrizmentyouhyj</td><td>（連携用）払済延長表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkisokyknkshrhsykn</td><td>（連携用）基礎契約年金支払保証期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkshrkknkbn</td><td>（連携用）年金支払期間区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkshrkknnen</td><td>（連携用）年金支払期間年</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksueokikn</td><td>（連携用）年金据置期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkshrstartymd</td><td>（連携用）年金支払開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkuketorininkbn</td><td>（連携用）年金受取人区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennoup</td><td>（連携用）前納保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzennouendym</td><td>（連携用）前納終了年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikaiyakuhrkn</td><td>（連携用）低解約返戻金期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmosno</td><td>（連携用）申込番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntratkisyacd1</td><td>（連携用）取扱者コード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntratkisyacd2</td><td>（連携用）取扱者コード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairiten1cd</td><td>（連携用）代理店１コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairiten2cd</td><td>（連携用）代理店２コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsudirtnatkikeitaikbn</td><td>（連携用）募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyudiritnatkiwari1</td><td>（連携用）募集代理店扱割合１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbsyudiritnatkiwari2</td><td>（連携用）募集代理店扱割合２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv20x2</td><td>（連携用）予備項目Ｖ２０＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntktyuutohukahyj</td><td>（連携用）特約中途付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntksuu</td><td>（連携用）特約数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhosyucd1</td><td>（連携用）特約保種コード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntknm1</td><td>（連携用）特約名称１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntks1</td><td>（連携用）特約保険金額１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntkhknkknkbn1</td><td>（連携用）特約保険期間区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkkn1</td><td>（連携用）特約保険期間１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkknkbn1</td><td>（連携用）特約払込期間区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkkn1</td><td>（連携用）特約払込期間１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhosyucd2</td><td>（連携用）特約保種コード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntknm2</td><td>（連携用）特約名称２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntks2</td><td>（連携用）特約保険金額２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntkhknkknkbn2</td><td>（連携用）特約保険期間区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkkn2</td><td>（連携用）特約保険期間２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkknkbn2</td><td>（連携用）特約払込期間区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkkn2</td><td>（連携用）特約払込期間２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhosyucd3</td><td>（連携用）特約保種コード３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntknm3</td><td>（連携用）特約名称３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntks3</td><td>（連携用）特約保険金額３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntkhknkknkbn3</td><td>（連携用）特約保険期間区分３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkkn3</td><td>（連携用）特約保険期間３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkknkbn3</td><td>（連携用）特約払込期間区分３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkkn3</td><td>（連携用）特約払込期間３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhosyucd4</td><td>（連携用）特約保種コード４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntknm4</td><td>（連携用）特約名称４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntks4</td><td>（連携用）特約保険金額４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntkhknkknkbn4</td><td>（連携用）特約保険期間区分４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkkn4</td><td>（連携用）特約保険期間４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkknkbn4</td><td>（連携用）特約払込期間区分４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkkn4</td><td>（連携用）特約払込期間４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhosyucd5</td><td>（連携用）特約保種コード５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntknm5</td><td>（連携用）特約名称５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntks5</td><td>（連携用）特約保険金額５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntkhknkknkbn5</td><td>（連携用）特約保険期間区分５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkkn5</td><td>（連携用）特約保険期間５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkknkbn5</td><td>（連携用）特約払込期間区分５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkkn5</td><td>（連携用）特約払込期間５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhosyucd6</td><td>（連携用）特約保種コード６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntknm6</td><td>（連携用）特約名称６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntks6</td><td>（連携用）特約保険金額６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntkhknkknkbn6</td><td>（連携用）特約保険期間区分６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhknkkn6</td><td>（連携用）特約保険期間６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkknkbn6</td><td>（連携用）特約払込期間区分６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhrkkkn6</td><td>（連携用）特約払込期間６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbuktnm</td><td>（連携用）死亡受取人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjsbuktnm</td><td>（連携用）漢字死亡受取人名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsbukttdk</td><td>（連携用）死亡受取人続柄</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbuktnin</td><td>（連携用）死亡受取人人数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv28</td><td>（連携用）予備項目Ｖ２８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyno7keta</td><td>（連携用）郵便番号（７桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntelnokydgw</td><td>（連携用）電話番号（共同ＧＷ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmknkydgw</td><td>（連携用）契約者名（カナ）（共同ＧＷ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaseiymd</td><td>（連携用）契約者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaseikbn</td><td>（連携用）契約者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsinkihontikucd</td><td>（連携用）通信先基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykadrkj50</td><td>（連携用）契約者漢字住所５０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkjkydgw</td><td>（連携用）契約者名（漢字）（共同ＧＷ）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknmei</td><td>（連携用）被保険者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmkj</td><td>（連携用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknseiymd</td><td>（連携用）被保険者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnen</td><td>（連携用）被保険者年齢</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhkntdk</td><td>（連携用）被保険者続柄</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzsyurui</td><td>（連携用）口座種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouzano7keta</td><td>（連携用）口座番号（７桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaebankcd</td><td>（連携用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaesitencd</td><td>（連携用）口座振替支店番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanyuusyaknrno</td><td>（連携用）加入者管理番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksiboumeighnkhyj</td><td>（連携用）契約者死亡名義変更表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv11</td><td>（連携用）予備項目Ｖ１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmnkuktkbn</td><td>（連携用）満期受取人区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmnkuktnm1</td><td>（連携用）満期受取人名１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmnkuktnm2</td><td>（連携用）満期受取人名２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmnkuktnm3</td><td>（連携用）満期受取人名３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmnkuktnm4</td><td>（連携用）満期受取人名４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbuktkbn</td><td>（連携用）死亡受取人区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbuktnm1</td><td>（連携用）死亡受取人名１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbuktnm2</td><td>（連携用）死亡受取人名２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbuktnm3</td><td>（連携用）死亡受取人名３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbuktnm4</td><td>（連携用）死亡受取人名４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv20x3</td><td>（連携用）予備項目Ｖ２０＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyoriymd zrnsyoriymd}</td><td>（連携用）処理年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkykmfksnctrlkh zrnkykmfksnctrlkh}</td><td>（連携用）契約ＭＦ更新ＣＴＲ（保全）</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmkhtoutatuymd</td><td>（連携用）目標到達年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykhrkmtuuka</td><td>（連携用）契約者振込通貨</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykhrkmgk</td><td>（連携用）契約者振込金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnikkatubaraikbn</td><td>（連携用）一括払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikkatubaraikaisuu</td><td>（連携用）一括払回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntousyokykjiyennyknrate</td><td>（連携用）当初契約時円入金レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnrendouritu</td><td>（連携用）連動率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnteikishrritu</td><td>（連携用）定期支払率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkosyasbskttdkstartflg</td><td>（連携用）個社死亡請求手続き開始フラグ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkosyasbukthukusuflg</td><td>（連携用）個社死亡受取人複数フラグ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkosyahhknsbymd</td><td>（連携用）個社被保険者死亡日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkosyassksjyuriymd</td><td>（連携用）個社保険金請求書受理日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkosyasshrkanryoymd</td><td>（連携用）個社保険金支払完了日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkosyasbuktseiymd</td><td>（連携用）個社死亡保険金受取人生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkosyasbuktkjadr</td><td>（連携用）個社死亡保険金受取人住所漢字</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkosyasbukttelno</td><td>（連携用）個社死亡保険金受取人電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv252</td><td>（連携用）予備項目Ｖ２５２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KydGWKykInfoRn
 * @see     GenZT_KydGWKykInfoRn
 * @see     QZT_KydGWKykInfoRn
 * @see     GenQZT_KydGWKykInfoRn
 */
public class PKZT_KydGWKykInfoRn extends AbstractExDBPrimaryKey<ZT_KydGWKykInfoRn, PKZT_KydGWKykInfoRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KydGWKykInfoRn() {
    }

    public PKZT_KydGWKykInfoRn(
        String pZrnsyono,
        String pZrnsyoriymd,
        Long pZrnkykmfksnctrlkh
    ) {
        zrnsyono = pZrnsyono;
        zrnsyoriymd = pZrnsyoriymd;
        zrnkykmfksnctrlkh = pZrnkykmfksnctrlkh;
    }

    @Transient
    @Override
    public Class<ZT_KydGWKykInfoRn> getEntityClass() {
        return ZT_KydGWKykInfoRn.class;
    }

    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }
    private String zrnsyoriymd;

    public String getZrnsyoriymd() {
        return zrnsyoriymd;
    }

    public void setZrnsyoriymd(String pZrnsyoriymd) {
        zrnsyoriymd = pZrnsyoriymd;
    }
    private Long zrnkykmfksnctrlkh;

    public Long getZrnkykmfksnctrlkh() {
        return zrnkykmfksnctrlkh;
    }

    public void setZrnkykmfksnctrlkh(Long pZrnkykmfksnctrlkh) {
        zrnkykmfksnctrlkh = pZrnkykmfksnctrlkh;
    }

}
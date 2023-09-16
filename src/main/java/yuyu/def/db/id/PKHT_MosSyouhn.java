package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.mapping.GenHT_MosSyouhn;
import yuyu.def.db.meta.GenQHT_MosSyouhn;
import yuyu.def.db.meta.QHT_MosSyouhn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 申込商品テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_MosSyouhn}</td><td colspan="3">申込商品テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ryouritusdno</td><td>料率世代番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syutkkbn</td><td>主契約特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>yoteiriritu</td><td>予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sknenkinsyu</td><td>新契約年金種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sknenkinsyu C_Sknenkinsyu}</td></tr>
 *  <tr><td>kihons</td><td>基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>seitoukihons</td><td>正当基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syutkp</td><td>主契約・特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hrktuukasyutkp</td><td>申込主契約・特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tkjyp</td><td>特条保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>katakbn</td><td>型区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KataKbn C_KataKbn}</td></tr>
 *  <tr><td>kyhkatakbn</td><td>給付型区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyhgndkataKbn C_KyhgndkataKbn}</td></tr>
 *  <tr><td>syukyhkinkatakbn</td><td>手術給付金型区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyukyhkinkataKbn C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>khnkyhkgbairitukbn</td><td>基本給付金額倍率区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KhnkyhkgbairituKbn C_KhnkyhkgbairituKbn}</td></tr>
 *  <tr><td>rokudaildkbn</td><td>６大生活習慣病追加給付型区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_6daiLdKbn C_6daiLdKbn}</td></tr>
 *  <tr><td>hknkkn</td><td>保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkkn</td><td>払込期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hknkknsmnkbn</td><td>保険期間歳満期区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hrkkknsmnkbn</td><td>払込期間歳満期区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkkknsmnKbn C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>dai1hknkkn</td><td>第１保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tumitateriritu</td><td>積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tmttknzoukaritujygn</td><td>積立金増加率上限</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>setteibairitu</td><td>設定倍率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>rendouritu</td><td>連動率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>teikisiharaikin</td><td>定期支払金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>loadinghnkgtumitateriritu</td><td>ローディング変更後積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kihons2</td><td>基本Ｓ_2</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hrktuukasyutkp2</td><td>払込通貨主契約・特約Ｐ＿２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_MosSyouhn
 * @see     GenHT_MosSyouhn
 * @see     QHT_MosSyouhn
 * @see     GenQHT_MosSyouhn
 */
public class PKHT_MosSyouhn extends AbstractExDBPrimaryKey<HT_MosSyouhn, PKHT_MosSyouhn> {

    private static final long serialVersionUID = 1L;

    public PKHT_MosSyouhn() {
    }

    public PKHT_MosSyouhn(String pMosno, String pSyouhncd) {
        mosno = pMosno;
        syouhncd = pSyouhncd;
    }

    @Transient
    @Override
    public Class<HT_MosSyouhn> getEntityClass() {
        return HT_MosSyouhn.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

}
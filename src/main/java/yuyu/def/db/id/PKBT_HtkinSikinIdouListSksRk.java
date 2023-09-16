package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BT_HtkinSikinIdouListSksRk;
import yuyu.def.db.mapping.GenBT_HtkinSikinIdouListSksRk;
import yuyu.def.db.meta.GenQBT_HtkinSikinIdouListSksRk;
import yuyu.def.db.meta.QBT_HtkinSikinIdouListSksRk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 配当金資金移動リスト作成用履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_HtkinSikinIdouListSksRk}</td><td colspan="3">配当金資金移動リスト作成用履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKijyunymd kijyunymd}</td><td>基準年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>haitounendo</td><td>配当年度</td><td>&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>siteituuka</td><td>指定通貨</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>siteituukagk</td><td>指定通貨金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>trhktuuka</td><td>取引通貨</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>trhktuukagk</td><td>取引通貨金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>seg1cd</td><td>セグメント１コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>sikinidougroupkbn</td><td>資金移動グループ区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SikinidougroupKbn C_SikinidougroupKbn}</td></tr>
 *  <tr><td>sikinidoukawaserate</td><td>資金移動用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BT_HtkinSikinIdouListSksRk
 * @see     GenBT_HtkinSikinIdouListSksRk
 * @see     QBT_HtkinSikinIdouListSksRk
 * @see     GenQBT_HtkinSikinIdouListSksRk
 */
public class PKBT_HtkinSikinIdouListSksRk extends AbstractExDBPrimaryKey<BT_HtkinSikinIdouListSksRk, PKBT_HtkinSikinIdouListSksRk> {

    private static final long serialVersionUID = 1L;

    public PKBT_HtkinSikinIdouListSksRk() {
    }

    public PKBT_HtkinSikinIdouListSksRk(String pSyono, BizDate pKijyunymd) {
        syono = pSyono;
        kijyunymd = pKijyunymd;
    }

    @Transient
    @Override
    public Class<BT_HtkinSikinIdouListSksRk> getEntityClass() {
        return BT_HtkinSikinIdouListSksRk.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDate kijyunymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }

}
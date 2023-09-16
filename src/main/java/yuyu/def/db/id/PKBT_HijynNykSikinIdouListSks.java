package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BT_HijynNykSikinIdouListSks;
import yuyu.def.db.mapping.GenBT_HijynNykSikinIdouListSks;
import yuyu.def.db.meta.GenQBT_HijynNykSikinIdouListSks;
import yuyu.def.db.meta.QBT_HijynNykSikinIdouListSks;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 平準払入金用資金移動リスト作成用テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_HijynNykSikinIdouListSks}</td><td colspan="3">平準払入金用資金移動リスト作成用テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSikinidoupjytym sikinidoupjytym}</td><td>資金移動用保険料充当年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>siteituuka</td><td>指定通貨</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>siteituukagk</td><td>指定通貨金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>trhktuuka</td><td>取引通貨</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>trhktuukagk</td><td>取引通貨金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>seg1cd</td><td>セグメント１コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>sikinidougroupkbn</td><td>資金移動グループ区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SikinidougroupKbn C_SikinidougroupKbn}</td></tr>
 *  <tr><td>sikinidoumeisaikbn</td><td>資金移動明細区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SikinidoumeisaiKbn C_SikinidoumeisaiKbn}</td></tr>
 *  <tr><td>sikinidoujtkbn</td><td>資金移動状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SikinidouJtKbn C_SikinidouJtKbn}</td></tr>
 *  <tr><td>sikinidoukawaserate</td><td>資金移動用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sikinidoupkbn</td><td>資金移動用保険料区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SikinidouPKbn C_SikinidouPKbn}</td></tr>
 * </table>
 * @see     BT_HijynNykSikinIdouListSks
 * @see     GenBT_HijynNykSikinIdouListSks
 * @see     QBT_HijynNykSikinIdouListSks
 * @see     GenQBT_HijynNykSikinIdouListSks
 */
public class PKBT_HijynNykSikinIdouListSks extends AbstractExDBPrimaryKey<BT_HijynNykSikinIdouListSks, PKBT_HijynNykSikinIdouListSks> {

    private static final long serialVersionUID = 1L;

    public PKBT_HijynNykSikinIdouListSks() {
    }

    public PKBT_HijynNykSikinIdouListSks(String pSyono, BizDateYM pSikinidoupjytym) {
        syono = pSyono;
        sikinidoupjytym = pSikinidoupjytym;
    }

    @Transient
    @Override
    public Class<BT_HijynNykSikinIdouListSks> getEntityClass() {
        return BT_HijynNykSikinIdouListSks.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDateYM sikinidoupjytym;

    @org.hibernate.annotations.Type(type="BizDateYMType")
    public BizDateYM getSikinidoupjytym() {
        return sikinidoupjytym;
    }

    public void setSikinidoupjytym(BizDateYM pSikinidoupjytym) {
        sikinidoupjytym = pSikinidoupjytym;
    }

}
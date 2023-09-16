package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SikinidouPKbn;
import yuyu.def.db.entity.BT_HijynNykSiknIdouLstSksGk;
import yuyu.def.db.mapping.GenBT_HijynNykSiknIdouLstSksGk;
import yuyu.def.db.meta.GenQBT_HijynNykSiknIdouLstSksGk;
import yuyu.def.db.meta.QBT_HijynNykSiknIdouLstSksGk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 平準払入金用資金移動リスト作成用テーブル（外貨） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_HijynNykSiknIdouLstSksGk}</td><td colspan="3">平準払入金用資金移動リスト作成用テーブル（外貨）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSikinidoupkbn sikinidoupkbn}</td><td>資金移動用保険料区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SikinidouPKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>siteituuka</td><td>指定通貨</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>siteituukagk</td><td>指定通貨金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>trhktuuka</td><td>取引通貨</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>trhktuukagk</td><td>取引通貨金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>seg1cd</td><td>セグメント１コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>sikinidougroupkbn</td><td>資金移動グループ区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SikinidougroupKbn C_SikinidougroupKbn}</td></tr>
 *  <tr><td>sikinidoumeisaikbn</td><td>資金移動明細区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SikinidoumeisaiKbn C_SikinidoumeisaiKbn}</td></tr>
 *  <tr><td>sikinidoujtkbn</td><td>資金移動状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SikinidouJtKbn C_SikinidouJtKbn}</td></tr>
 *  <tr><td>sikinidoukawaserate</td><td>資金移動用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BT_HijynNykSiknIdouLstSksGk
 * @see     GenBT_HijynNykSiknIdouLstSksGk
 * @see     QBT_HijynNykSiknIdouLstSksGk
 * @see     GenQBT_HijynNykSiknIdouLstSksGk
 */
public class PKBT_HijynNykSiknIdouLstSksGk extends AbstractExDBPrimaryKey<BT_HijynNykSiknIdouLstSksGk, PKBT_HijynNykSiknIdouLstSksGk> {

    private static final long serialVersionUID = 1L;

    public PKBT_HijynNykSiknIdouLstSksGk() {
    }

    public PKBT_HijynNykSiknIdouLstSksGk(
        BizDate pSyoriYmd,
        C_SikinidouPKbn pSikinidoupkbn,
        String pSyono,
        Integer pRenno
    ) {
        syoriYmd = pSyoriYmd;
        sikinidoupkbn = pSikinidoupkbn;
        syono = pSyono;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<BT_HijynNykSiknIdouLstSksGk> getEntityClass() {
        return BT_HijynNykSiknIdouLstSksGk.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private C_SikinidouPKbn sikinidoupkbn;

    @org.hibernate.annotations.Type(type="UserType_C_SikinidouPKbn")
    public C_SikinidouPKbn getSikinidoupkbn() {
        return sikinidoupkbn;
    }

    public void setSikinidoupkbn(C_SikinidouPKbn pSikinidoupkbn) {
        sikinidoupkbn = pSikinidoupkbn;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}
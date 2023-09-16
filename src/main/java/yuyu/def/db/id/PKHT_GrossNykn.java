package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HT_GrossNykn;
import yuyu.def.db.mapping.GenHT_GrossNykn;
import yuyu.def.db.meta.GenQHT_GrossNykn;
import yuyu.def.db.meta.QHT_GrossNykn;

/**
 * グロス入金テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_GrossNykn}</td><td colspan="3">グロス入金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nyksyoriymd</td><td>入金処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hrktuukasyu</td><td>払込通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyuukinoyadrtennm</td><td>入金用親代理店名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kawaserate</td><td>為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>grossnykngk</td><td>グロス入金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>grossdengk</td><td>グロス入金伝票金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>meisaigoukeidengk</td><td>明細合計伝票金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kawasesasonekikngk</td><td>為替差損益金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_GrossNykn
 * @see     GenHT_GrossNykn
 * @see     QHT_GrossNykn
 * @see     GenQHT_GrossNykn
 */
public class PKHT_GrossNykn extends AbstractExDBPrimaryKey<HT_GrossNykn, PKHT_GrossNykn> {

    private static final long serialVersionUID = 1L;

    public PKHT_GrossNykn() {
    }

    public PKHT_GrossNykn(
        BizDate pRyosyuymd,
        String pOyadrtencd,
        Integer pRenno
    ) {
        ryosyuymd = pRyosyuymd;
        oyadrtencd = pOyadrtencd;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HT_GrossNykn> getEntityClass() {
        return HT_GrossNykn.class;
    }

    private BizDate ryosyuymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }
    private String oyadrtencd;

    public String getOyadrtencd() {
        return oyadrtencd;
    }

    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}
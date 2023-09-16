package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_ChkJhNkgns;
import yuyu.def.db.id.PKBM_ChkJhNkgns;
import yuyu.def.db.meta.GenQBM_ChkJhNkgns;
import yuyu.def.db.meta.QBM_ChkJhNkgns;

/**
 * 年金原資限度事方書チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkJhNkgns} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkJhNkgns}</td><td colspan="3">年金原資限度事方書チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">{@link PKBM_ChkJhNkgns ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">{@link PKBM_ChkJhNkgns ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getNkgnsgndgk nkgnsgndgk}</td><td>年金原資限度額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkJhNkgns
 * @see     PKBM_ChkJhNkgns
 * @see     QBM_ChkJhNkgns
 * @see     GenQBM_ChkJhNkgns
 */
@MappedSuperclass
@Table(name=GenBM_ChkJhNkgns.TABLE_NAME)
@IdClass(value=PKBM_ChkJhNkgns.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_ChkJhNkgns extends AbstractExDBEntity<BM_ChkJhNkgns, PKBM_ChkJhNkgns> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkJhNkgns";
    public static final String HHKNFROMNEN              = "hhknfromnen";
    public static final String HHKNTONEN                = "hhkntonen";
    public static final String NKGNSGNDGK               = "nkgnsgndgk";

    private final PKBM_ChkJhNkgns primaryKey;

    public GenBM_ChkJhNkgns() {
        primaryKey = new PKBM_ChkJhNkgns();
    }

    public GenBM_ChkJhNkgns(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        primaryKey = new PKBM_ChkJhNkgns(pHhknfromnen, pHhkntonen);
    }

    @Transient
    @Override
    public PKBM_ChkJhNkgns getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkJhNkgns> getMetaClass() {
        return QBM_ChkJhNkgns.class;
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkJhNkgns.HHKNFROMNEN)
    public BizNumber getHhknfromnen() {
        return getPrimaryKey().getHhknfromnen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknfromnen(BizNumber pHhknfromnen) {
        getPrimaryKey().setHhknfromnen(pHhknfromnen);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkJhNkgns.HHKNTONEN)
    public BizNumber getHhkntonen() {
        return getPrimaryKey().getHhkntonen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntonen(BizNumber pHhkntonen) {
        getPrimaryKey().setHhkntonen(pHhkntonen);
    }

    private BizCurrency nkgnsgndgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNkgnsgndgk() {
        return nkgnsgndgk;
    }

    public void setNkgnsgndgk(BizCurrency pNkgnsgndgk) {
        nkgnsgndgk = pNkgnsgndgk;
        nkgnsgndgkValue = null;
        nkgnsgndgkType  = null;
    }

    transient private BigDecimal nkgnsgndgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NKGNSGNDGK, nullable=true)
    protected BigDecimal getNkgnsgndgkValue() {
        if (nkgnsgndgkValue == null && nkgnsgndgk != null) {
            if (nkgnsgndgk.isOptional()) return null;
            return nkgnsgndgk.absolute();
        }
        return nkgnsgndgkValue;
    }

    protected void setNkgnsgndgkValue(BigDecimal value) {
        nkgnsgndgkValue = value;
        nkgnsgndgk = Optional.fromNullable(toCurrencyType(nkgnsgndgkType))
            .transform(bizCurrencyTransformer(getNkgnsgndgkValue()))
            .orNull();
    }

    transient private String nkgnsgndgkType = null;

    @Column(name=NKGNSGNDGK + "$", nullable=true)
    protected String getNkgnsgndgkType() {
        if (nkgnsgndgkType == null && nkgnsgndgk != null) return nkgnsgndgk.getType().toString();
        if (nkgnsgndgkType == null && getNkgnsgndgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'nkgnsgndgk$' should not be NULL."));
        }
        return nkgnsgndgkType;
    }

    protected void setNkgnsgndgkType(String type) {
        nkgnsgndgkType = type;
        nkgnsgndgk = Optional.fromNullable(toCurrencyType(nkgnsgndgkType))
            .transform(bizCurrencyTransformer(getNkgnsgndgkValue()))
            .orNull();
    }
}

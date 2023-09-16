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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_ChkJhNkgnsHonken;
import yuyu.def.db.id.PKBM_ChkJhNkgnsHonken;
import yuyu.def.db.meta.GenQBM_ChkJhNkgnsHonken;
import yuyu.def.db.meta.QBM_ChkJhNkgnsHonken;

/**
 * 年金原資本件事方書チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkJhNkgnsHonken} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkJhNkgnsHonken}</td><td colspan="3">年金原資本件事方書チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_ChkJhNkgnsHonken ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkJhNkgnsHonken ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkJhNkgnsHonken ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">{@link PKBM_ChkJhNkgnsHonken ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">{@link PKBM_ChkJhNkgnsHonken ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getNkgnsgndgk nkgnsgndgk}</td><td>年金原資限度額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkJhNkgnsHonken
 * @see     PKBM_ChkJhNkgnsHonken
 * @see     QBM_ChkJhNkgnsHonken
 * @see     GenQBM_ChkJhNkgnsHonken
 */
@MappedSuperclass
@Table(name=GenBM_ChkJhNkgnsHonken.TABLE_NAME)
@IdClass(value=PKBM_ChkJhNkgnsHonken.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_ChkJhNkgnsHonken extends AbstractExDBEntity<BM_ChkJhNkgnsHonken, PKBM_ChkJhNkgnsHonken> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkJhNkgnsHonken";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String HHKNFROMNEN              = "hhknfromnen";
    public static final String HHKNTONEN                = "hhkntonen";
    public static final String NKGNSGNDGK               = "nkgnsgndgk";

    private final PKBM_ChkJhNkgnsHonken primaryKey;

    public GenBM_ChkJhNkgnsHonken() {
        primaryKey = new PKBM_ChkJhNkgnsHonken();
    }

    public GenBM_ChkJhNkgnsHonken(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen
    ) {
        primaryKey = new PKBM_ChkJhNkgnsHonken(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pHhknfromnen,
            pHhkntonen
        );
    }

    @Transient
    @Override
    public PKBM_ChkJhNkgnsHonken getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkJhNkgnsHonken> getMetaClass() {
        return QBM_ChkJhNkgnsHonken.class;
    }

    @Id
    @Column(name=GenBM_ChkJhNkgnsHonken.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Column(name=GenBM_ChkJhNkgnsHonken.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkJhNkgnsHonken.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkJhNkgnsHonken.HHKNFROMNEN)
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
    @Column(name=GenBM_ChkJhNkgnsHonken.HHKNTONEN)
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
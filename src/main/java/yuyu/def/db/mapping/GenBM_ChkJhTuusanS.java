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
import yuyu.def.db.entity.BM_ChkJhTuusanS;
import yuyu.def.db.id.PKBM_ChkJhTuusanS;
import yuyu.def.db.meta.GenQBM_ChkJhTuusanS;
import yuyu.def.db.meta.QBM_ChkJhTuusanS;

/**
 * 通算限度Ｓ事方書チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkJhTuusanS} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkJhTuusanS}</td><td colspan="3">通算限度Ｓ事方書チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">{@link PKBM_ChkJhTuusanS ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">{@link PKBM_ChkJhTuusanS ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGnds1 gnds1}</td><td>限度Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGnds2 gnds2}</td><td>限度Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGnds3 gnds3}</td><td>限度Ｓ３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGnds4 gnds4}</td><td>限度Ｓ４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGnds5 gnds5}</td><td>限度Ｓ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getOldkijyungnds1 oldkijyungnds1}</td><td>旧基準限度Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getOldkijyungnds2 oldkijyungnds2}</td><td>旧基準限度Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkJhTuusanS
 * @see     PKBM_ChkJhTuusanS
 * @see     QBM_ChkJhTuusanS
 * @see     GenQBM_ChkJhTuusanS
 */
@MappedSuperclass
@Table(name=GenBM_ChkJhTuusanS.TABLE_NAME)
@IdClass(value=PKBM_ChkJhTuusanS.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_ChkJhTuusanS extends AbstractExDBEntity<BM_ChkJhTuusanS, PKBM_ChkJhTuusanS> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkJhTuusanS";
    public static final String HHKNFROMNEN              = "hhknfromnen";
    public static final String HHKNTONEN                = "hhkntonen";
    public static final String GNDS1                    = "gnds1";
    public static final String GNDS2                    = "gnds2";
    public static final String GNDS3                    = "gnds3";
    public static final String GNDS4                    = "gnds4";
    public static final String GNDS5                    = "gnds5";
    public static final String OLDKIJYUNGNDS1           = "oldkijyungnds1";
    public static final String OLDKIJYUNGNDS2           = "oldkijyungnds2";

    private final PKBM_ChkJhTuusanS primaryKey;

    public GenBM_ChkJhTuusanS() {
        primaryKey = new PKBM_ChkJhTuusanS();
    }

    public GenBM_ChkJhTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        primaryKey = new PKBM_ChkJhTuusanS(pHhknfromnen, pHhkntonen);
    }

    @Transient
    @Override
    public PKBM_ChkJhTuusanS getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkJhTuusanS> getMetaClass() {
        return QBM_ChkJhTuusanS.class;
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkJhTuusanS.HHKNFROMNEN)
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
    @Column(name=GenBM_ChkJhTuusanS.HHKNTONEN)
    public BizNumber getHhkntonen() {
        return getPrimaryKey().getHhkntonen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntonen(BizNumber pHhkntonen) {
        getPrimaryKey().setHhkntonen(pHhkntonen);
    }

    private BizCurrency gnds1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGnds1() {
        return gnds1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGnds1(BizCurrency pGnds1) {
        gnds1 = pGnds1;
        gnds1Value = null;
        gnds1Type  = null;
    }

    transient private BigDecimal gnds1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=GNDS1, nullable=true)
    protected BigDecimal getGnds1Value() {
        if (gnds1Value == null && gnds1 != null) {
            if (gnds1.isOptional()) return null;
            return gnds1.absolute();
        }
        return gnds1Value;
    }

    protected void setGnds1Value(BigDecimal value) {
        gnds1Value = value;
        gnds1 = Optional.fromNullable(toCurrencyType(gnds1Type))
            .transform(bizCurrencyTransformer(getGnds1Value()))
            .orNull();
    }

    transient private String gnds1Type = null;

    @Column(name=GNDS1 + "$", nullable=true)
    protected String getGnds1Type() {
        if (gnds1Type == null && gnds1 != null) return gnds1.getType().toString();
        if (gnds1Type == null && getGnds1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gnds1$' should not be NULL."));
        }
        return gnds1Type;
    }

    protected void setGnds1Type(String type) {
        gnds1Type = type;
        gnds1 = Optional.fromNullable(toCurrencyType(gnds1Type))
            .transform(bizCurrencyTransformer(getGnds1Value()))
            .orNull();
    }

    private BizCurrency gnds2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGnds2() {
        return gnds2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGnds2(BizCurrency pGnds2) {
        gnds2 = pGnds2;
        gnds2Value = null;
        gnds2Type  = null;
    }

    transient private BigDecimal gnds2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=GNDS2, nullable=true)
    protected BigDecimal getGnds2Value() {
        if (gnds2Value == null && gnds2 != null) {
            if (gnds2.isOptional()) return null;
            return gnds2.absolute();
        }
        return gnds2Value;
    }

    protected void setGnds2Value(BigDecimal value) {
        gnds2Value = value;
        gnds2 = Optional.fromNullable(toCurrencyType(gnds2Type))
            .transform(bizCurrencyTransformer(getGnds2Value()))
            .orNull();
    }

    transient private String gnds2Type = null;

    @Column(name=GNDS2 + "$", nullable=true)
    protected String getGnds2Type() {
        if (gnds2Type == null && gnds2 != null) return gnds2.getType().toString();
        if (gnds2Type == null && getGnds2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gnds2$' should not be NULL."));
        }
        return gnds2Type;
    }

    protected void setGnds2Type(String type) {
        gnds2Type = type;
        gnds2 = Optional.fromNullable(toCurrencyType(gnds2Type))
            .transform(bizCurrencyTransformer(getGnds2Value()))
            .orNull();
    }

    private BizCurrency gnds3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGnds3() {
        return gnds3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGnds3(BizCurrency pGnds3) {
        gnds3 = pGnds3;
        gnds3Value = null;
        gnds3Type  = null;
    }

    transient private BigDecimal gnds3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=GNDS3, nullable=true)
    protected BigDecimal getGnds3Value() {
        if (gnds3Value == null && gnds3 != null) {
            if (gnds3.isOptional()) return null;
            return gnds3.absolute();
        }
        return gnds3Value;
    }

    protected void setGnds3Value(BigDecimal value) {
        gnds3Value = value;
        gnds3 = Optional.fromNullable(toCurrencyType(gnds3Type))
            .transform(bizCurrencyTransformer(getGnds3Value()))
            .orNull();
    }

    transient private String gnds3Type = null;

    @Column(name=GNDS3 + "$", nullable=true)
    protected String getGnds3Type() {
        if (gnds3Type == null && gnds3 != null) return gnds3.getType().toString();
        if (gnds3Type == null && getGnds3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gnds3$' should not be NULL."));
        }
        return gnds3Type;
    }

    protected void setGnds3Type(String type) {
        gnds3Type = type;
        gnds3 = Optional.fromNullable(toCurrencyType(gnds3Type))
            .transform(bizCurrencyTransformer(getGnds3Value()))
            .orNull();
    }

    private BizCurrency gnds4;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGnds4() {
        return gnds4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGnds4(BizCurrency pGnds4) {
        gnds4 = pGnds4;
        gnds4Value = null;
        gnds4Type  = null;
    }

    transient private BigDecimal gnds4Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=GNDS4, nullable=true)
    protected BigDecimal getGnds4Value() {
        if (gnds4Value == null && gnds4 != null) {
            if (gnds4.isOptional()) return null;
            return gnds4.absolute();
        }
        return gnds4Value;
    }

    protected void setGnds4Value(BigDecimal value) {
        gnds4Value = value;
        gnds4 = Optional.fromNullable(toCurrencyType(gnds4Type))
            .transform(bizCurrencyTransformer(getGnds4Value()))
            .orNull();
    }

    transient private String gnds4Type = null;

    @Column(name=GNDS4 + "$", nullable=true)
    protected String getGnds4Type() {
        if (gnds4Type == null && gnds4 != null) return gnds4.getType().toString();
        if (gnds4Type == null && getGnds4Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gnds4$' should not be NULL."));
        }
        return gnds4Type;
    }

    protected void setGnds4Type(String type) {
        gnds4Type = type;
        gnds4 = Optional.fromNullable(toCurrencyType(gnds4Type))
            .transform(bizCurrencyTransformer(getGnds4Value()))
            .orNull();
    }

    private BizCurrency gnds5;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGnds5() {
        return gnds5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGnds5(BizCurrency pGnds5) {
        gnds5 = pGnds5;
        gnds5Value = null;
        gnds5Type  = null;
    }

    transient private BigDecimal gnds5Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=GNDS5, nullable=true)
    protected BigDecimal getGnds5Value() {
        if (gnds5Value == null && gnds5 != null) {
            if (gnds5.isOptional()) return null;
            return gnds5.absolute();
        }
        return gnds5Value;
    }

    protected void setGnds5Value(BigDecimal value) {
        gnds5Value = value;
        gnds5 = Optional.fromNullable(toCurrencyType(gnds5Type))
            .transform(bizCurrencyTransformer(getGnds5Value()))
            .orNull();
    }

    transient private String gnds5Type = null;

    @Column(name=GNDS5 + "$", nullable=true)
    protected String getGnds5Type() {
        if (gnds5Type == null && gnds5 != null) return gnds5.getType().toString();
        if (gnds5Type == null && getGnds5Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gnds5$' should not be NULL."));
        }
        return gnds5Type;
    }

    protected void setGnds5Type(String type) {
        gnds5Type = type;
        gnds5 = Optional.fromNullable(toCurrencyType(gnds5Type))
            .transform(bizCurrencyTransformer(getGnds5Value()))
            .orNull();
    }

    private BizCurrency oldkijyungnds1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getOldkijyungnds1() {
        return oldkijyungnds1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOldkijyungnds1(BizCurrency pOldkijyungnds1) {
        oldkijyungnds1 = pOldkijyungnds1;
        oldkijyungnds1Value = null;
        oldkijyungnds1Type  = null;
    }

    transient private BigDecimal oldkijyungnds1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=OLDKIJYUNGNDS1, nullable=true)
    protected BigDecimal getOldkijyungnds1Value() {
        if (oldkijyungnds1Value == null && oldkijyungnds1 != null) {
            if (oldkijyungnds1.isOptional()) return null;
            return oldkijyungnds1.absolute();
        }
        return oldkijyungnds1Value;
    }

    protected void setOldkijyungnds1Value(BigDecimal value) {
        oldkijyungnds1Value = value;
        oldkijyungnds1 = Optional.fromNullable(toCurrencyType(oldkijyungnds1Type))
            .transform(bizCurrencyTransformer(getOldkijyungnds1Value()))
            .orNull();
    }

    transient private String oldkijyungnds1Type = null;

    @Column(name=OLDKIJYUNGNDS1 + "$", nullable=true)
    protected String getOldkijyungnds1Type() {
        if (oldkijyungnds1Type == null && oldkijyungnds1 != null) return oldkijyungnds1.getType().toString();
        if (oldkijyungnds1Type == null && getOldkijyungnds1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'oldkijyungnds1$' should not be NULL."));
        }
        return oldkijyungnds1Type;
    }

    protected void setOldkijyungnds1Type(String type) {
        oldkijyungnds1Type = type;
        oldkijyungnds1 = Optional.fromNullable(toCurrencyType(oldkijyungnds1Type))
            .transform(bizCurrencyTransformer(getOldkijyungnds1Value()))
            .orNull();
    }

    private BizCurrency oldkijyungnds2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getOldkijyungnds2() {
        return oldkijyungnds2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOldkijyungnds2(BizCurrency pOldkijyungnds2) {
        oldkijyungnds2 = pOldkijyungnds2;
        oldkijyungnds2Value = null;
        oldkijyungnds2Type  = null;
    }

    transient private BigDecimal oldkijyungnds2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=OLDKIJYUNGNDS2, nullable=true)
    protected BigDecimal getOldkijyungnds2Value() {
        if (oldkijyungnds2Value == null && oldkijyungnds2 != null) {
            if (oldkijyungnds2.isOptional()) return null;
            return oldkijyungnds2.absolute();
        }
        return oldkijyungnds2Value;
    }

    protected void setOldkijyungnds2Value(BigDecimal value) {
        oldkijyungnds2Value = value;
        oldkijyungnds2 = Optional.fromNullable(toCurrencyType(oldkijyungnds2Type))
            .transform(bizCurrencyTransformer(getOldkijyungnds2Value()))
            .orNull();
    }

    transient private String oldkijyungnds2Type = null;

    @Column(name=OLDKIJYUNGNDS2 + "$", nullable=true)
    protected String getOldkijyungnds2Type() {
        if (oldkijyungnds2Type == null && oldkijyungnds2 != null) return oldkijyungnds2.getType().toString();
        if (oldkijyungnds2Type == null && getOldkijyungnds2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'oldkijyungnds2$' should not be NULL."));
        }
        return oldkijyungnds2Type;
    }

    protected void setOldkijyungnds2Type(String type) {
        oldkijyungnds2Type = type;
        oldkijyungnds2 = Optional.fromNullable(toCurrencyType(oldkijyungnds2Type))
            .transform(bizCurrencyTransformer(getOldkijyungnds2Value()))
            .orNull();
    }
}
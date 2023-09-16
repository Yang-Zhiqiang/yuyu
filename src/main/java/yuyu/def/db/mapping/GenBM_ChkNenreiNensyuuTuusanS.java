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
import yuyu.def.db.entity.BM_ChkNenreiNensyuuTuusanS;
import yuyu.def.db.id.PKBM_ChkNenreiNensyuuTuusanS;
import yuyu.def.db.meta.GenQBM_ChkNenreiNensyuuTuusanS;
import yuyu.def.db.meta.QBM_ChkNenreiNensyuuTuusanS;

/**
 * 年齢年収制限通算限度Ｓチェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkNenreiNensyuuTuusanS} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkNenreiNensyuuTuusanS}</td><td colspan="3">年齢年収制限通算限度Ｓチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">{@link PKBM_ChkNenreiNensyuuTuusanS ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">{@link PKBM_ChkNenreiNensyuuTuusanS ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHhknfromnensyuu hhknfromnensyuu}</td><td>被保険者年収区分自</td><td align="center">{@link PKBM_ChkNenreiNensyuuTuusanS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhkntonensyuu hhkntonensyuu}</td><td>被保険者年収区分至</td><td align="center">{@link PKBM_ChkNenreiNensyuuTuusanS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGnds1 gnds1}</td><td>限度Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGnds2 gnds2}</td><td>限度Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getItijibrgnds1 itijibrgnds1}</td><td>一時払限度Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getItijibrgnds2 itijibrgnds2}</td><td>一時払限度Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkNenreiNensyuuTuusanS
 * @see     PKBM_ChkNenreiNensyuuTuusanS
 * @see     QBM_ChkNenreiNensyuuTuusanS
 * @see     GenQBM_ChkNenreiNensyuuTuusanS
 */
@MappedSuperclass
@Table(name=GenBM_ChkNenreiNensyuuTuusanS.TABLE_NAME)
@IdClass(value=PKBM_ChkNenreiNensyuuTuusanS.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_ChkNenreiNensyuuTuusanS extends AbstractExDBEntity<BM_ChkNenreiNensyuuTuusanS, PKBM_ChkNenreiNensyuuTuusanS> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkNenreiNensyuuTuusanS";
    public static final String HHKNFROMNEN              = "hhknfromnen";
    public static final String HHKNTONEN                = "hhkntonen";
    public static final String HHKNFROMNENSYUU          = "hhknfromnensyuu";
    public static final String HHKNTONENSYUU            = "hhkntonensyuu";
    public static final String GNDS1                    = "gnds1";
    public static final String GNDS2                    = "gnds2";
    public static final String ITIJIBRGNDS1             = "itijibrgnds1";
    public static final String ITIJIBRGNDS2             = "itijibrgnds2";

    private final PKBM_ChkNenreiNensyuuTuusanS primaryKey;

    public GenBM_ChkNenreiNensyuuTuusanS() {
        primaryKey = new PKBM_ChkNenreiNensyuuTuusanS();
    }

    public GenBM_ChkNenreiNensyuuTuusanS(
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        Integer pHhknfromnensyuu,
        Integer pHhkntonensyuu
    ) {
        primaryKey = new PKBM_ChkNenreiNensyuuTuusanS(
            pHhknfromnen,
            pHhkntonen,
            pHhknfromnensyuu,
            pHhkntonensyuu
        );
    }

    @Transient
    @Override
    public PKBM_ChkNenreiNensyuuTuusanS getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkNenreiNensyuuTuusanS> getMetaClass() {
        return QBM_ChkNenreiNensyuuTuusanS.class;
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkNenreiNensyuuTuusanS.HHKNFROMNEN)
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
    @Column(name=GenBM_ChkNenreiNensyuuTuusanS.HHKNTONEN)
    public BizNumber getHhkntonen() {
        return getPrimaryKey().getHhkntonen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntonen(BizNumber pHhkntonen) {
        getPrimaryKey().setHhkntonen(pHhkntonen);
    }

    @Id
    @Column(name=GenBM_ChkNenreiNensyuuTuusanS.HHKNFROMNENSYUU)
    public Integer getHhknfromnensyuu() {
        return getPrimaryKey().getHhknfromnensyuu();
    }

    public void setHhknfromnensyuu(Integer pHhknfromnensyuu) {
        getPrimaryKey().setHhknfromnensyuu(pHhknfromnensyuu);
    }

    @Id
    @Column(name=GenBM_ChkNenreiNensyuuTuusanS.HHKNTONENSYUU)
    public Integer getHhkntonensyuu() {
        return getPrimaryKey().getHhkntonensyuu();
    }

    public void setHhkntonensyuu(Integer pHhkntonensyuu) {
        getPrimaryKey().setHhkntonensyuu(pHhkntonensyuu);
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

    private BizCurrency itijibrgnds1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getItijibrgnds1() {
        return itijibrgnds1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setItijibrgnds1(BizCurrency pItijibrgnds1) {
        itijibrgnds1 = pItijibrgnds1;
        itijibrgnds1Value = null;
        itijibrgnds1Type  = null;
    }

    transient private BigDecimal itijibrgnds1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=ITIJIBRGNDS1, nullable=true)
    protected BigDecimal getItijibrgnds1Value() {
        if (itijibrgnds1Value == null && itijibrgnds1 != null) {
            if (itijibrgnds1.isOptional()) return null;
            return itijibrgnds1.absolute();
        }
        return itijibrgnds1Value;
    }

    protected void setItijibrgnds1Value(BigDecimal value) {
        itijibrgnds1Value = value;
        itijibrgnds1 = Optional.fromNullable(toCurrencyType(itijibrgnds1Type))
            .transform(bizCurrencyTransformer(getItijibrgnds1Value()))
            .orNull();
    }

    transient private String itijibrgnds1Type = null;

    @Column(name=ITIJIBRGNDS1 + "$", nullable=true)
    protected String getItijibrgnds1Type() {
        if (itijibrgnds1Type == null && itijibrgnds1 != null) return itijibrgnds1.getType().toString();
        if (itijibrgnds1Type == null && getItijibrgnds1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'itijibrgnds1$' should not be NULL."));
        }
        return itijibrgnds1Type;
    }

    protected void setItijibrgnds1Type(String type) {
        itijibrgnds1Type = type;
        itijibrgnds1 = Optional.fromNullable(toCurrencyType(itijibrgnds1Type))
            .transform(bizCurrencyTransformer(getItijibrgnds1Value()))
            .orNull();
    }

    private BizCurrency itijibrgnds2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getItijibrgnds2() {
        return itijibrgnds2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setItijibrgnds2(BizCurrency pItijibrgnds2) {
        itijibrgnds2 = pItijibrgnds2;
        itijibrgnds2Value = null;
        itijibrgnds2Type  = null;
    }

    transient private BigDecimal itijibrgnds2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=ITIJIBRGNDS2, nullable=true)
    protected BigDecimal getItijibrgnds2Value() {
        if (itijibrgnds2Value == null && itijibrgnds2 != null) {
            if (itijibrgnds2.isOptional()) return null;
            return itijibrgnds2.absolute();
        }
        return itijibrgnds2Value;
    }

    protected void setItijibrgnds2Value(BigDecimal value) {
        itijibrgnds2Value = value;
        itijibrgnds2 = Optional.fromNullable(toCurrencyType(itijibrgnds2Type))
            .transform(bizCurrencyTransformer(getItijibrgnds2Value()))
            .orNull();
    }

    transient private String itijibrgnds2Type = null;

    @Column(name=ITIJIBRGNDS2 + "$", nullable=true)
    protected String getItijibrgnds2Type() {
        if (itijibrgnds2Type == null && itijibrgnds2 != null) return itijibrgnds2.getType().toString();
        if (itijibrgnds2Type == null && getItijibrgnds2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'itijibrgnds2$' should not be NULL."));
        }
        return itijibrgnds2Type;
    }

    protected void setItijibrgnds2Type(String type) {
        itijibrgnds2Type = type;
        itijibrgnds2 = Optional.fromNullable(toCurrencyType(itijibrgnds2Type))
            .transform(bizCurrencyTransformer(getItijibrgnds2Value()))
            .orNull();
    }
}

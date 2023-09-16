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
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.db.entity.BM_ChkJhKokutiTuusanS;
import yuyu.def.db.id.PKBM_ChkJhKokutiTuusanS;
import yuyu.def.db.meta.GenQBM_ChkJhKokutiTuusanS;
import yuyu.def.db.meta.QBM_ChkJhKokutiTuusanS;
import yuyu.def.db.type.UserType_C_KijiKbn;

/**
 * 告知扱通算限度Ｓ事方書チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkJhKokutiTuusanS} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkJhKokutiTuusanS}</td><td colspan="3">告知扱通算限度Ｓ事方書チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">{@link PKBM_ChkJhKokutiTuusanS ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">{@link PKBM_ChkJhKokutiTuusanS ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKijikbn kijikbn}</td><td>記事区分</td><td align="center">{@link PKBM_ChkJhKokutiTuusanS ○}</td><td align="center">V</td><td>{@link C_KijiKbn}</td></tr>
 *  <tr><td>{@link #getIktkktkbnfrom iktkktkbnfrom}</td><td>一括告知区分自</td><td align="center">{@link PKBM_ChkJhKokutiTuusanS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getIktkktkbnto iktkktkbnto}</td><td>一括告知区分至</td><td align="center">{@link PKBM_ChkJhKokutiTuusanS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGnds1 gnds1}</td><td>限度Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGnds2 gnds2}</td><td>限度Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGnds3 gnds3}</td><td>限度Ｓ３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkJhKokutiTuusanS
 * @see     PKBM_ChkJhKokutiTuusanS
 * @see     QBM_ChkJhKokutiTuusanS
 * @see     GenQBM_ChkJhKokutiTuusanS
 */
@MappedSuperclass
@Table(name=GenBM_ChkJhKokutiTuusanS.TABLE_NAME)
@IdClass(value=PKBM_ChkJhKokutiTuusanS.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_KijiKbn", typeClass=UserType_C_KijiKbn.class)
})
public abstract class GenBM_ChkJhKokutiTuusanS extends AbstractExDBEntity<BM_ChkJhKokutiTuusanS, PKBM_ChkJhKokutiTuusanS> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkJhKokutiTuusanS";
    public static final String HHKNFROMNEN              = "hhknfromnen";
    public static final String HHKNTONEN                = "hhkntonen";
    public static final String KIJIKBN                  = "kijikbn";
    public static final String IKTKKTKBNFROM            = "iktkktkbnfrom";
    public static final String IKTKKTKBNTO              = "iktkktkbnto";
    public static final String GNDS1                    = "gnds1";
    public static final String GNDS2                    = "gnds2";
    public static final String GNDS3                    = "gnds3";

    private final PKBM_ChkJhKokutiTuusanS primaryKey;

    public GenBM_ChkJhKokutiTuusanS() {
        primaryKey = new PKBM_ChkJhKokutiTuusanS();
    }

    public GenBM_ChkJhKokutiTuusanS(
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        C_KijiKbn pKijikbn,
        Integer pIktkktkbnfrom,
        Integer pIktkktkbnto
    ) {
        primaryKey = new PKBM_ChkJhKokutiTuusanS(
            pHhknfromnen,
            pHhkntonen,
            pKijikbn,
            pIktkktkbnfrom,
            pIktkktkbnto
        );
    }

    @Transient
    @Override
    public PKBM_ChkJhKokutiTuusanS getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkJhKokutiTuusanS> getMetaClass() {
        return QBM_ChkJhKokutiTuusanS.class;
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkJhKokutiTuusanS.HHKNFROMNEN)
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
    @Column(name=GenBM_ChkJhKokutiTuusanS.HHKNTONEN)
    public BizNumber getHhkntonen() {
        return getPrimaryKey().getHhkntonen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntonen(BizNumber pHhkntonen) {
        getPrimaryKey().setHhkntonen(pHhkntonen);
    }

    @Id
    @Type(type="UserType_C_KijiKbn")
    @Column(name=GenBM_ChkJhKokutiTuusanS.KIJIKBN)
    public C_KijiKbn getKijikbn() {
        return getPrimaryKey().getKijikbn();
    }

    public void setKijikbn(C_KijiKbn pKijikbn) {
        getPrimaryKey().setKijikbn(pKijikbn);
    }

    @Id
    @Column(name=GenBM_ChkJhKokutiTuusanS.IKTKKTKBNFROM)
    public Integer getIktkktkbnfrom() {
        return getPrimaryKey().getIktkktkbnfrom();
    }

    public void setIktkktkbnfrom(Integer pIktkktkbnfrom) {
        getPrimaryKey().setIktkktkbnfrom(pIktkktkbnfrom);
    }

    @Id
    @Column(name=GenBM_ChkJhKokutiTuusanS.IKTKKTKBNTO)
    public Integer getIktkktkbnto() {
        return getPrimaryKey().getIktkktkbnto();
    }

    public void setIktkktkbnto(Integer pIktkktkbnto) {
        getPrimaryKey().setIktkktkbnto(pIktkktkbnto);
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
}

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
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_GrossNykn;
import yuyu.def.db.id.PKHT_GrossNykn;
import yuyu.def.db.meta.GenQHT_GrossNykn;
import yuyu.def.db.meta.QHT_GrossNykn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.HostInvalidCharacter;

/**
 * グロス入金テーブル テーブルのマッピング情報クラスで、 {@link HT_GrossNykn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_GrossNykn}</td><td colspan="3">グロス入金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">{@link PKHT_GrossNykn ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">{@link PKHT_GrossNykn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_GrossNykn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNyksyoriymd nyksyoriymd}</td><td>入金処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrktuukasyu hrktuukasyu}</td><td>払込通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyuukinoyadrtennm nyuukinoyadrtennm}</td><td>入金用親代理店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKawaserate kawaserate}</td><td>為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGrossnykngk grossnykngk}</td><td>グロス入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGrossdengk grossdengk}</td><td>グロス入金伝票金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMeisaigoukeidengk meisaigoukeidengk}</td><td>明細合計伝票金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKawasesasonekikngk kawasesasonekikngk}</td><td>為替差損益金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_GrossNykn
 * @see     PKHT_GrossNykn
 * @see     QHT_GrossNykn
 * @see     GenQHT_GrossNykn
 */
@MappedSuperclass
@Table(name=GenHT_GrossNykn.TABLE_NAME)
@IdClass(value=PKHT_GrossNykn.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenHT_GrossNykn extends AbstractExDBEntity<HT_GrossNykn, PKHT_GrossNykn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_GrossNykn";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String RENNO                    = "renno";
    public static final String NYKSYORIYMD              = "nyksyoriymd";
    public static final String HRKTUUKASYU              = "hrktuukasyu";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String KOUZANO                  = "kouzano";
    public static final String NYUUKINOYADRTENNM        = "nyuukinoyadrtennm";
    public static final String KAWASERATE               = "kawaserate";
    public static final String GROSSNYKNGK              = "grossnykngk";
    public static final String GROSSDENGK               = "grossdengk";
    public static final String MEISAIGOUKEIDENGK        = "meisaigoukeidengk";
    public static final String KAWASESASONEKIKNGK       = "kawasesasonekikngk";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_GrossNykn primaryKey;

    public GenHT_GrossNykn() {
        primaryKey = new PKHT_GrossNykn();
    }

    public GenHT_GrossNykn(
        BizDate pRyosyuymd,
        String pOyadrtencd,
        Integer pRenno
    ) {
        primaryKey = new PKHT_GrossNykn(
            pRyosyuymd,
            pOyadrtencd,
            pRenno
        );
    }

    @Transient
    @Override
    public PKHT_GrossNykn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_GrossNykn> getMetaClass() {
        return QHT_GrossNykn.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_GrossNykn.RYOSYUYMD)
    @ValidDate
    public BizDate getRyosyuymd() {
        return getPrimaryKey().getRyosyuymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        getPrimaryKey().setRyosyuymd(pRyosyuymd);
    }

    @Id
    @Column(name=GenHT_GrossNykn.OYADRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getOyadrtencd() {
        return getPrimaryKey().getOyadrtencd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        getPrimaryKey().setOyadrtencd(pOyadrtencd);
    }

    @Id
    @Column(name=GenHT_GrossNykn.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate nyksyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_GrossNykn.NYKSYORIYMD)
    public BizDate getNyksyoriymd() {
        return nyksyoriymd;
    }

    public void setNyksyoriymd(BizDate pNyksyoriymd) {
        nyksyoriymd = pNyksyoriymd;
    }

    private C_Tuukasyu hrktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_GrossNykn.HRKTUUKASYU)
    public C_Tuukasyu getHrktuukasyu() {
        return hrktuukasyu;
    }

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        hrktuukasyu = pHrktuukasyu;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_GrossNykn.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private String kouzano;

    @Column(name=GenHT_GrossNykn.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private String nyuukinoyadrtennm;

    @Column(name=GenHT_GrossNykn.NYUUKINOYADRTENNM)
    public String getNyuukinoyadrtennm() {
        return nyuukinoyadrtennm;
    }

    public void setNyuukinoyadrtennm(String pNyuukinoyadrtennm) {
        nyuukinoyadrtennm = pNyuukinoyadrtennm;
    }

    private BizNumber kawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenHT_GrossNykn.KAWASERATE)
    public BizNumber getKawaserate() {
        return kawaserate;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKawaserate(BizNumber pKawaserate) {
        kawaserate = pKawaserate;
    }

    private BizCurrency grossnykngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGrossnykngk() {
        return grossnykngk;
    }

    public void setGrossnykngk(BizCurrency pGrossnykngk) {
        grossnykngk = pGrossnykngk;
        grossnykngkValue = null;
        grossnykngkType  = null;
    }

    transient private BigDecimal grossnykngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GROSSNYKNGK, nullable=true)
    protected BigDecimal getGrossnykngkValue() {
        if (grossnykngkValue == null && grossnykngk != null) {
            if (grossnykngk.isOptional()) return null;
            return grossnykngk.absolute();
        }
        return grossnykngkValue;
    }

    protected void setGrossnykngkValue(BigDecimal value) {
        grossnykngkValue = value;
        grossnykngk = Optional.fromNullable(toCurrencyType(grossnykngkType))
            .transform(bizCurrencyTransformer(getGrossnykngkValue()))
            .orNull();
    }

    transient private String grossnykngkType = null;

    @Column(name=GROSSNYKNGK + "$", nullable=true)
    protected String getGrossnykngkType() {
        if (grossnykngkType == null && grossnykngk != null) return grossnykngk.getType().toString();
        if (grossnykngkType == null && getGrossnykngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'grossnykngk$' should not be NULL."));
        }
        return grossnykngkType;
    }

    protected void setGrossnykngkType(String type) {
        grossnykngkType = type;
        grossnykngk = Optional.fromNullable(toCurrencyType(grossnykngkType))
            .transform(bizCurrencyTransformer(getGrossnykngkValue()))
            .orNull();
    }

    private BizCurrency grossdengk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGrossdengk() {
        return grossdengk;
    }

    public void setGrossdengk(BizCurrency pGrossdengk) {
        grossdengk = pGrossdengk;
        grossdengkValue = null;
        grossdengkType  = null;
    }

    transient private BigDecimal grossdengkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GROSSDENGK, nullable=true)
    protected BigDecimal getGrossdengkValue() {
        if (grossdengkValue == null && grossdengk != null) {
            if (grossdengk.isOptional()) return null;
            return grossdengk.absolute();
        }
        return grossdengkValue;
    }

    protected void setGrossdengkValue(BigDecimal value) {
        grossdengkValue = value;
        grossdengk = Optional.fromNullable(toCurrencyType(grossdengkType))
            .transform(bizCurrencyTransformer(getGrossdengkValue()))
            .orNull();
    }

    transient private String grossdengkType = null;

    @Column(name=GROSSDENGK + "$", nullable=true)
    protected String getGrossdengkType() {
        if (grossdengkType == null && grossdengk != null) return grossdengk.getType().toString();
        if (grossdengkType == null && getGrossdengkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'grossdengk$' should not be NULL."));
        }
        return grossdengkType;
    }

    protected void setGrossdengkType(String type) {
        grossdengkType = type;
        grossdengk = Optional.fromNullable(toCurrencyType(grossdengkType))
            .transform(bizCurrencyTransformer(getGrossdengkValue()))
            .orNull();
    }

    private BizCurrency meisaigoukeidengk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMeisaigoukeidengk() {
        return meisaigoukeidengk;
    }

    public void setMeisaigoukeidengk(BizCurrency pMeisaigoukeidengk) {
        meisaigoukeidengk = pMeisaigoukeidengk;
        meisaigoukeidengkValue = null;
        meisaigoukeidengkType  = null;
    }

    transient private BigDecimal meisaigoukeidengkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MEISAIGOUKEIDENGK, nullable=true)
    protected BigDecimal getMeisaigoukeidengkValue() {
        if (meisaigoukeidengkValue == null && meisaigoukeidengk != null) {
            if (meisaigoukeidengk.isOptional()) return null;
            return meisaigoukeidengk.absolute();
        }
        return meisaigoukeidengkValue;
    }

    protected void setMeisaigoukeidengkValue(BigDecimal value) {
        meisaigoukeidengkValue = value;
        meisaigoukeidengk = Optional.fromNullable(toCurrencyType(meisaigoukeidengkType))
            .transform(bizCurrencyTransformer(getMeisaigoukeidengkValue()))
            .orNull();
    }

    transient private String meisaigoukeidengkType = null;

    @Column(name=MEISAIGOUKEIDENGK + "$", nullable=true)
    protected String getMeisaigoukeidengkType() {
        if (meisaigoukeidengkType == null && meisaigoukeidengk != null) return meisaigoukeidengk.getType().toString();
        if (meisaigoukeidengkType == null && getMeisaigoukeidengkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'meisaigoukeidengk$' should not be NULL."));
        }
        return meisaigoukeidengkType;
    }

    protected void setMeisaigoukeidengkType(String type) {
        meisaigoukeidengkType = type;
        meisaigoukeidengk = Optional.fromNullable(toCurrencyType(meisaigoukeidengkType))
            .transform(bizCurrencyTransformer(getMeisaigoukeidengkValue()))
            .orNull();
    }

    private BizCurrency kawasesasonekikngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKawasesasonekikngk() {
        return kawasesasonekikngk;
    }

    public void setKawasesasonekikngk(BizCurrency pKawasesasonekikngk) {
        kawasesasonekikngk = pKawasesasonekikngk;
        kawasesasonekikngkValue = null;
        kawasesasonekikngkType  = null;
    }

    transient private BigDecimal kawasesasonekikngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAWASESASONEKIKNGK, nullable=true)
    protected BigDecimal getKawasesasonekikngkValue() {
        if (kawasesasonekikngkValue == null && kawasesasonekikngk != null) {
            if (kawasesasonekikngk.isOptional()) return null;
            return kawasesasonekikngk.absolute();
        }
        return kawasesasonekikngkValue;
    }

    protected void setKawasesasonekikngkValue(BigDecimal value) {
        kawasesasonekikngkValue = value;
        kawasesasonekikngk = Optional.fromNullable(toCurrencyType(kawasesasonekikngkType))
            .transform(bizCurrencyTransformer(getKawasesasonekikngkValue()))
            .orNull();
    }

    transient private String kawasesasonekikngkType = null;

    @Column(name=KAWASESASONEKIKNGK + "$", nullable=true)
    protected String getKawasesasonekikngkType() {
        if (kawasesasonekikngkType == null && kawasesasonekikngk != null) return kawasesasonekikngk.getType().toString();
        if (kawasesasonekikngkType == null && getKawasesasonekikngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kawasesasonekikngk$' should not be NULL."));
        }
        return kawasesasonekikngkType;
    }

    protected void setKawasesasonekikngkType(String type) {
        kawasesasonekikngkType = type;
        kawasesasonekikngk = Optional.fromNullable(toCurrencyType(kawasesasonekikngkType))
            .transform(bizCurrencyTransformer(getKawasesasonekikngkValue()))
            .orNull();
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_GrossNykn.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_GrossNykn.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
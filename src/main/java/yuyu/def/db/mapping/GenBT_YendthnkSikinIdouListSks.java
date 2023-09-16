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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KeiriyendthnkKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_YendthnkSikinIdouListSks;
import yuyu.def.db.id.PKBT_YendthnkSikinIdouListSks;
import yuyu.def.db.meta.GenQBT_YendthnkSikinIdouListSks;
import yuyu.def.db.meta.QBT_YendthnkSikinIdouListSks;
import yuyu.def.db.type.UserType_C_KeiriyendthnkKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SikinidougroupKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 円建変更資金移動リスト作成用テーブル テーブルのマッピング情報クラスで、 {@link BT_YendthnkSikinIdouListSks} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_YendthnkSikinIdouListSks}</td><td colspan="3">円建変更資金移動リスト作成用テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKBT_YendthnkSikinIdouListSks ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeiriyendthnkkbn keiriyendthnkkbn}</td><td>経理用円建変更区分</td><td align="center">{@link PKBT_YendthnkSikinIdouListSks ○}</td><td align="center">V</td><td>{@link C_KeiriyendthnkKbn}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKBT_YendthnkSikinIdouListSks ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSiteituuka siteituuka}</td><td>指定通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSiteituukagk siteituukagk}</td><td>指定通貨金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTrhktuuka trhktuuka}</td><td>取引通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getTrhktuukagk trhktuukagk}</td><td>取引通貨金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKbnkeirisegcd kbnkeirisegcd}</td><td>区分経理用セグメントコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getSikinidougroupkbn sikinidougroupkbn}</td><td>資金移動グループ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SikinidougroupKbn}</td></tr>
 * </table>
 * @see     BT_YendthnkSikinIdouListSks
 * @see     PKBT_YendthnkSikinIdouListSks
 * @see     QBT_YendthnkSikinIdouListSks
 * @see     GenQBT_YendthnkSikinIdouListSks
 */
@MappedSuperclass
@Table(name=GenBT_YendthnkSikinIdouListSks.TABLE_NAME)
@IdClass(value=PKBT_YendthnkSikinIdouListSks.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KeiriyendthnkKbn", typeClass=UserType_C_KeiriyendthnkKbn.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_SikinidougroupKbn", typeClass=UserType_C_SikinidougroupKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBT_YendthnkSikinIdouListSks extends AbstractExDBEntity<BT_YendthnkSikinIdouListSks, PKBT_YendthnkSikinIdouListSks> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_YendthnkSikinIdouListSks";
    public static final String SYONO                    = "syono";
    public static final String KEIRIYENDTHNKKBN         = "keiriyendthnkkbn";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SITEITUUKA               = "siteituuka";
    public static final String SITEITUUKAGK             = "siteituukagk";
    public static final String TRHKTUUKA                = "trhktuuka";
    public static final String TRHKTUUKAGK              = "trhktuukagk";
    public static final String KBNKEIRISEGCD            = "kbnkeirisegcd";
    public static final String SIKINIDOUGROUPKBN        = "sikinidougroupkbn";

    private final PKBT_YendthnkSikinIdouListSks primaryKey;

    public GenBT_YendthnkSikinIdouListSks() {
        primaryKey = new PKBT_YendthnkSikinIdouListSks();
    }

    public GenBT_YendthnkSikinIdouListSks(
        String pSyono,
        C_KeiriyendthnkKbn pKeiriyendthnkkbn,
        BizDate pSyoriYmd
    ) {
        primaryKey = new PKBT_YendthnkSikinIdouListSks(
            pSyono,
            pKeiriyendthnkkbn,
            pSyoriYmd
        );
    }

    @Transient
    @Override
    public PKBT_YendthnkSikinIdouListSks getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_YendthnkSikinIdouListSks> getMetaClass() {
        return QBT_YendthnkSikinIdouListSks.class;
    }

    @Id
    @Column(name=GenBT_YendthnkSikinIdouListSks.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Type(type="UserType_C_KeiriyendthnkKbn")
    @Column(name=GenBT_YendthnkSikinIdouListSks.KEIRIYENDTHNKKBN)
    public C_KeiriyendthnkKbn getKeiriyendthnkkbn() {
        return getPrimaryKey().getKeiriyendthnkkbn();
    }

    public void setKeiriyendthnkkbn(C_KeiriyendthnkKbn pKeiriyendthnkkbn) {
        getPrimaryKey().setKeiriyendthnkkbn(pKeiriyendthnkkbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBT_YendthnkSikinIdouListSks.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    private C_Tuukasyu siteituuka;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_YendthnkSikinIdouListSks.SITEITUUKA)
    public C_Tuukasyu getSiteituuka() {
        return siteituuka;
    }

    public void setSiteituuka(C_Tuukasyu pSiteituuka) {
        siteituuka = pSiteituuka;
    }

    private BizCurrency siteituukagk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSiteituukagk() {
        return siteituukagk;
    }

    public void setSiteituukagk(BizCurrency pSiteituukagk) {
        siteituukagk = pSiteituukagk;
        siteituukagkValue = null;
        siteituukagkType  = null;
    }

    transient private BigDecimal siteituukagkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SITEITUUKAGK, nullable=true)
    protected BigDecimal getSiteituukagkValue() {
        if (siteituukagkValue == null && siteituukagk != null) {
            if (siteituukagk.isOptional()) return null;
            return siteituukagk.absolute();
        }
        return siteituukagkValue;
    }

    protected void setSiteituukagkValue(BigDecimal value) {
        siteituukagkValue = value;
        siteituukagk = Optional.fromNullable(toCurrencyType(siteituukagkType))
            .transform(bizCurrencyTransformer(getSiteituukagkValue()))
            .orNull();
    }

    transient private String siteituukagkType = null;

    @Column(name=SITEITUUKAGK + "$", nullable=true)
    protected String getSiteituukagkType() {
        if (siteituukagkType == null && siteituukagk != null) return siteituukagk.getType().toString();
        if (siteituukagkType == null && getSiteituukagkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'siteituukagk$' should not be NULL."));
        }
        return siteituukagkType;
    }

    protected void setSiteituukagkType(String type) {
        siteituukagkType = type;
        siteituukagk = Optional.fromNullable(toCurrencyType(siteituukagkType))
            .transform(bizCurrencyTransformer(getSiteituukagkValue()))
            .orNull();
    }

    private C_Tuukasyu trhktuuka;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_YendthnkSikinIdouListSks.TRHKTUUKA)
    public C_Tuukasyu getTrhktuuka() {
        return trhktuuka;
    }

    public void setTrhktuuka(C_Tuukasyu pTrhktuuka) {
        trhktuuka = pTrhktuuka;
    }

    private BizCurrency trhktuukagk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTrhktuukagk() {
        return trhktuukagk;
    }

    public void setTrhktuukagk(BizCurrency pTrhktuukagk) {
        trhktuukagk = pTrhktuukagk;
        trhktuukagkValue = null;
        trhktuukagkType  = null;
    }

    transient private BigDecimal trhktuukagkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TRHKTUUKAGK, nullable=true)
    protected BigDecimal getTrhktuukagkValue() {
        if (trhktuukagkValue == null && trhktuukagk != null) {
            if (trhktuukagk.isOptional()) return null;
            return trhktuukagk.absolute();
        }
        return trhktuukagkValue;
    }

    protected void setTrhktuukagkValue(BigDecimal value) {
        trhktuukagkValue = value;
        trhktuukagk = Optional.fromNullable(toCurrencyType(trhktuukagkType))
            .transform(bizCurrencyTransformer(getTrhktuukagkValue()))
            .orNull();
    }

    transient private String trhktuukagkType = null;

    @Column(name=TRHKTUUKAGK + "$", nullable=true)
    protected String getTrhktuukagkType() {
        if (trhktuukagkType == null && trhktuukagk != null) return trhktuukagk.getType().toString();
        if (trhktuukagkType == null && getTrhktuukagkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'trhktuukagk$' should not be NULL."));
        }
        return trhktuukagkType;
    }

    protected void setTrhktuukagkType(String type) {
        trhktuukagkType = type;
        trhktuukagk = Optional.fromNullable(toCurrencyType(trhktuukagkType))
            .transform(bizCurrencyTransformer(getTrhktuukagkValue()))
            .orNull();
    }

    private C_Segcd kbnkeirisegcd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenBT_YendthnkSikinIdouListSks.KBNKEIRISEGCD)
    public C_Segcd getKbnkeirisegcd() {
        return kbnkeirisegcd;
    }

    public void setKbnkeirisegcd(C_Segcd pKbnkeirisegcd) {
        kbnkeirisegcd = pKbnkeirisegcd;
    }

    private C_SikinidougroupKbn sikinidougroupkbn;

    @Type(type="UserType_C_SikinidougroupKbn")
    @Column(name=GenBT_YendthnkSikinIdouListSks.SIKINIDOUGROUPKBN)
    public C_SikinidougroupKbn getSikinidougroupkbn() {
        return sikinidougroupkbn;
    }

    public void setSikinidougroupkbn(C_SikinidougroupKbn pSikinidougroupkbn) {
        sikinidougroupkbn = pSikinidougroupkbn;
    }
}
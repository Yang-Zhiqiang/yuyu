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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidouJtKbn;
import yuyu.def.classification.C_SikinidouPKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_HijynNykSiknIdouLstSksGk;
import yuyu.def.db.id.PKBT_HijynNykSiknIdouLstSksGk;
import yuyu.def.db.meta.GenQBT_HijynNykSiknIdouLstSksGk;
import yuyu.def.db.meta.QBT_HijynNykSiknIdouLstSksGk;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SikinidouJtKbn;
import yuyu.def.db.type.UserType_C_SikinidouPKbn;
import yuyu.def.db.type.UserType_C_SikinidougroupKbn;
import yuyu.def.db.type.UserType_C_SikinidoumeisaiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 平準払入金用資金移動リスト作成用テーブル（外貨） テーブルのマッピング情報クラスで、 {@link BT_HijynNykSiknIdouLstSksGk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_HijynNykSiknIdouLstSksGk}</td><td colspan="3">平準払入金用資金移動リスト作成用テーブル（外貨）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKBT_HijynNykSiknIdouLstSksGk ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSikinidoupkbn sikinidoupkbn}</td><td>資金移動用保険料区分</td><td align="center">{@link PKBT_HijynNykSiknIdouLstSksGk ○}</td><td align="center">V</td><td>{@link C_SikinidouPKbn}</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKBT_HijynNykSiknIdouLstSksGk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKBT_HijynNykSiknIdouLstSksGk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSiteituuka siteituuka}</td><td>指定通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSiteituukagk siteituukagk}</td><td>指定通貨金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTrhktuuka trhktuuka}</td><td>取引通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getTrhktuukagk trhktuukagk}</td><td>取引通貨金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getSikinidougroupkbn sikinidougroupkbn}</td><td>資金移動グループ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SikinidougroupKbn}</td></tr>
 *  <tr><td>{@link #getSikinidoumeisaikbn sikinidoumeisaikbn}</td><td>資金移動明細区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SikinidoumeisaiKbn}</td></tr>
 *  <tr><td>{@link #getSikinidoujtkbn sikinidoujtkbn}</td><td>資金移動状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SikinidouJtKbn}</td></tr>
 *  <tr><td>{@link #getSikinidoukawaserate sikinidoukawaserate}</td><td>資金移動用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BT_HijynNykSiknIdouLstSksGk
 * @see     PKBT_HijynNykSiknIdouLstSksGk
 * @see     QBT_HijynNykSiknIdouLstSksGk
 * @see     GenQBT_HijynNykSiknIdouLstSksGk
 */
@MappedSuperclass
@Table(name=GenBT_HijynNykSiknIdouLstSksGk.TABLE_NAME)
@IdClass(value=PKBT_HijynNykSiknIdouLstSksGk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_SikinidouJtKbn", typeClass=UserType_C_SikinidouJtKbn.class),
    @TypeDef(name="UserType_C_SikinidouPKbn", typeClass=UserType_C_SikinidouPKbn.class),
    @TypeDef(name="UserType_C_SikinidougroupKbn", typeClass=UserType_C_SikinidougroupKbn.class),
    @TypeDef(name="UserType_C_SikinidoumeisaiKbn", typeClass=UserType_C_SikinidoumeisaiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBT_HijynNykSiknIdouLstSksGk extends AbstractExDBEntity<BT_HijynNykSiknIdouLstSksGk, PKBT_HijynNykSiknIdouLstSksGk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_HijynNykSiknIdouLstSksGk";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SIKINIDOUPKBN            = "sikinidoupkbn";
    public static final String SYONO                    = "syono";
    public static final String RENNO                    = "renno";
    public static final String SITEITUUKA               = "siteituuka";
    public static final String SITEITUUKAGK             = "siteituukagk";
    public static final String TRHKTUUKA                = "trhktuuka";
    public static final String TRHKTUUKAGK              = "trhktuukagk";
    public static final String SEG1CD                   = "seg1cd";
    public static final String SIKINIDOUGROUPKBN        = "sikinidougroupkbn";
    public static final String SIKINIDOUMEISAIKBN       = "sikinidoumeisaikbn";
    public static final String SIKINIDOUJTKBN           = "sikinidoujtkbn";
    public static final String SIKINIDOUKAWASERATE      = "sikinidoukawaserate";

    private final PKBT_HijynNykSiknIdouLstSksGk primaryKey;

    public GenBT_HijynNykSiknIdouLstSksGk() {
        primaryKey = new PKBT_HijynNykSiknIdouLstSksGk();
    }

    public GenBT_HijynNykSiknIdouLstSksGk(
        BizDate pSyoriYmd,
        C_SikinidouPKbn pSikinidoupkbn,
        String pSyono,
        Integer pRenno
    ) {
        primaryKey = new PKBT_HijynNykSiknIdouLstSksGk(
            pSyoriYmd,
            pSikinidoupkbn,
            pSyono,
            pRenno
        );
    }

    @Transient
    @Override
    public PKBT_HijynNykSiknIdouLstSksGk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_HijynNykSiknIdouLstSksGk> getMetaClass() {
        return QBT_HijynNykSiknIdouLstSksGk.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBT_HijynNykSiknIdouLstSksGk.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    @Id
    @Type(type="UserType_C_SikinidouPKbn")
    @Column(name=GenBT_HijynNykSiknIdouLstSksGk.SIKINIDOUPKBN)
    public C_SikinidouPKbn getSikinidoupkbn() {
        return getPrimaryKey().getSikinidoupkbn();
    }

    public void setSikinidoupkbn(C_SikinidouPKbn pSikinidoupkbn) {
        getPrimaryKey().setSikinidoupkbn(pSikinidoupkbn);
    }

    @Id
    @Column(name=GenBT_HijynNykSiknIdouLstSksGk.SYONO)
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
    @Column(name=GenBT_HijynNykSiknIdouLstSksGk.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private C_Tuukasyu siteituuka;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_HijynNykSiknIdouLstSksGk.SITEITUUKA)
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
    @Column(name=GenBT_HijynNykSiknIdouLstSksGk.TRHKTUUKA)
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

    private C_Segcd seg1cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenBT_HijynNykSiknIdouLstSksGk.SEG1CD)
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }

    private C_SikinidougroupKbn sikinidougroupkbn;

    @Type(type="UserType_C_SikinidougroupKbn")
    @Column(name=GenBT_HijynNykSiknIdouLstSksGk.SIKINIDOUGROUPKBN)
    public C_SikinidougroupKbn getSikinidougroupkbn() {
        return sikinidougroupkbn;
    }

    public void setSikinidougroupkbn(C_SikinidougroupKbn pSikinidougroupkbn) {
        sikinidougroupkbn = pSikinidougroupkbn;
    }

    private C_SikinidoumeisaiKbn sikinidoumeisaikbn;

    @Type(type="UserType_C_SikinidoumeisaiKbn")
    @Column(name=GenBT_HijynNykSiknIdouLstSksGk.SIKINIDOUMEISAIKBN)
    public C_SikinidoumeisaiKbn getSikinidoumeisaikbn() {
        return sikinidoumeisaikbn;
    }

    public void setSikinidoumeisaikbn(C_SikinidoumeisaiKbn pSikinidoumeisaikbn) {
        sikinidoumeisaikbn = pSikinidoumeisaikbn;
    }

    private C_SikinidouJtKbn sikinidoujtkbn;

    @Type(type="UserType_C_SikinidouJtKbn")
    @Column(name=GenBT_HijynNykSiknIdouLstSksGk.SIKINIDOUJTKBN)
    public C_SikinidouJtKbn getSikinidoujtkbn() {
        return sikinidoujtkbn;
    }

    public void setSikinidoujtkbn(C_SikinidouJtKbn pSikinidoujtkbn) {
        sikinidoujtkbn = pSikinidoujtkbn;
    }

    private BizNumber sikinidoukawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenBT_HijynNykSiknIdouLstSksGk.SIKINIDOUKAWASERATE)
    public BizNumber getSikinidoukawaserate() {
        return sikinidoukawaserate;
    }

    public void setSikinidoukawaserate(BizNumber pSikinidoukawaserate) {
        sikinidoukawaserate = pSikinidoukawaserate;
    }
}
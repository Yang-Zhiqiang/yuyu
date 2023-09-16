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
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_HtkinSikinIdouListSksRk;
import yuyu.def.db.id.PKBT_HtkinSikinIdouListSksRk;
import yuyu.def.db.meta.GenQBT_HtkinSikinIdouListSksRk;
import yuyu.def.db.meta.QBT_HtkinSikinIdouListSksRk;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SikinidougroupKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 配当金資金移動リスト作成用履歴テーブル テーブルのマッピング情報クラスで、 {@link BT_HtkinSikinIdouListSksRk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_HtkinSikinIdouListSksRk}</td><td colspan="3">配当金資金移動リスト作成用履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKBT_HtkinSikinIdouListSksRk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKijyunymd kijyunymd}</td><td>基準年月日</td><td align="center">{@link PKBT_HtkinSikinIdouListSksRk ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHaitounendo haitounendo}</td><td>配当年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getSiteituuka siteituuka}</td><td>指定通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSiteituukagk siteituukagk}</td><td>指定通貨金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTrhktuuka trhktuuka}</td><td>取引通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getTrhktuukagk trhktuukagk}</td><td>取引通貨金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getSikinidougroupkbn sikinidougroupkbn}</td><td>資金移動グループ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SikinidougroupKbn}</td></tr>
 *  <tr><td>{@link #getSikinidoukawaserate sikinidoukawaserate}</td><td>資金移動用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BT_HtkinSikinIdouListSksRk
 * @see     PKBT_HtkinSikinIdouListSksRk
 * @see     QBT_HtkinSikinIdouListSksRk
 * @see     GenQBT_HtkinSikinIdouListSksRk
 */
@MappedSuperclass
@Table(name=GenBT_HtkinSikinIdouListSksRk.TABLE_NAME)
@IdClass(value=PKBT_HtkinSikinIdouListSksRk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYType", typeClass=BizDateYType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_SikinidougroupKbn", typeClass=UserType_C_SikinidougroupKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBT_HtkinSikinIdouListSksRk extends AbstractExDBEntity<BT_HtkinSikinIdouListSksRk, PKBT_HtkinSikinIdouListSksRk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_HtkinSikinIdouListSksRk";
    public static final String SYONO                    = "syono";
    public static final String KIJYUNYMD                = "kijyunymd";
    public static final String HAITOUNENDO              = "haitounendo";
    public static final String SITEITUUKA               = "siteituuka";
    public static final String SITEITUUKAGK             = "siteituukagk";
    public static final String TRHKTUUKA                = "trhktuuka";
    public static final String TRHKTUUKAGK              = "trhktuukagk";
    public static final String SEG1CD                   = "seg1cd";
    public static final String SIKINIDOUGROUPKBN        = "sikinidougroupkbn";
    public static final String SIKINIDOUKAWASERATE      = "sikinidoukawaserate";

    private final PKBT_HtkinSikinIdouListSksRk primaryKey;

    public GenBT_HtkinSikinIdouListSksRk() {
        primaryKey = new PKBT_HtkinSikinIdouListSksRk();
    }

    public GenBT_HtkinSikinIdouListSksRk(String pSyono, BizDate pKijyunymd) {
        primaryKey = new PKBT_HtkinSikinIdouListSksRk(pSyono, pKijyunymd);
    }

    @Transient
    @Override
    public PKBT_HtkinSikinIdouListSksRk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_HtkinSikinIdouListSksRk> getMetaClass() {
        return QBT_HtkinSikinIdouListSksRk.class;
    }

    @Id
    @Column(name=GenBT_HtkinSikinIdouListSksRk.SYONO)
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
    @Type(type="BizDateType")
    @Column(name=GenBT_HtkinSikinIdouListSksRk.KIJYUNYMD)
    public BizDate getKijyunymd() {
        return getPrimaryKey().getKijyunymd();
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        getPrimaryKey().setKijyunymd(pKijyunymd);
    }

    private BizDateY haitounendo;

    @Type(type="BizDateYType")
    @Column(name=GenBT_HtkinSikinIdouListSksRk.HAITOUNENDO)
    public BizDateY getHaitounendo() {
        return haitounendo;
    }

    public void setHaitounendo(BizDateY pHaitounendo) {
        haitounendo = pHaitounendo;
    }

    private C_Tuukasyu siteituuka;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_HtkinSikinIdouListSksRk.SITEITUUKA)
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
    @Column(name=GenBT_HtkinSikinIdouListSksRk.TRHKTUUKA)
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
    @Column(name=GenBT_HtkinSikinIdouListSksRk.SEG1CD)
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }

    private C_SikinidougroupKbn sikinidougroupkbn;

    @Type(type="UserType_C_SikinidougroupKbn")
    @Column(name=GenBT_HtkinSikinIdouListSksRk.SIKINIDOUGROUPKBN)
    public C_SikinidougroupKbn getSikinidougroupkbn() {
        return sikinidougroupkbn;
    }

    public void setSikinidougroupkbn(C_SikinidougroupKbn pSikinidougroupkbn) {
        sikinidougroupkbn = pSikinidougroupkbn;
    }

    private BizNumber sikinidoukawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenBT_HtkinSikinIdouListSksRk.SIKINIDOUKAWASERATE)
    public BizNumber getSikinidoukawaserate() {
        return sikinidoukawaserate;
    }

    public void setSikinidoukawaserate(BizNumber pSikinidoukawaserate) {
        sikinidoukawaserate = pSikinidoukawaserate;
    }
}
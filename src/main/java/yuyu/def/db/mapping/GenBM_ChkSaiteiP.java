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
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkSaiteiP;
import yuyu.def.db.id.PKBM_ChkSaiteiP;
import yuyu.def.db.meta.GenQBM_ChkSaiteiP;
import yuyu.def.db.meta.QBM_ChkSaiteiP;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 最低Ｐチェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkSaiteiP} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkSaiteiP}</td><td colspan="3">最低Ｐチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_ChkSaiteiP ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">{@link PKBM_ChkSaiteiP ○}</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkknfrom hrkkknfrom}</td><td>払込期間自</td><td align="center">{@link PKBM_ChkSaiteiP ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHrkkknto hrkkknto}</td><td>払込期間至</td><td align="center">{@link PKBM_ChkSaiteiP ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkSaiteiP ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkSaiteiP ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">{@link PKBM_ChkSaiteiP ○}</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKBM_ChkSaiteiP ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyouhinbetukey1 syouhinbetukey1}</td><td>商品別キー１</td><td align="center">{@link PKBM_ChkSaiteiP ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaiteip saiteip}</td><td>最低Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getPtani ptani}</td><td>Ｐ単位</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkSaiteiP
 * @see     PKBM_ChkSaiteiP
 * @see     QBM_ChkSaiteiP
 * @see     GenQBM_ChkSaiteiP
 */
@MappedSuperclass
@Table(name=GenBM_ChkSaiteiP.TABLE_NAME)
@IdClass(value=PKBM_ChkSaiteiP.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Channelcd", typeClass=UserType_C_Channelcd.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_ChkSaiteiP extends AbstractExDBEntity<BM_ChkSaiteiP, PKBM_ChkSaiteiP> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkSaiteiP";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKKNFROM               = "hrkkknfrom";
    public static final String HRKKKNTO                 = "hrkkknto";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String CHANNELCD                = "channelcd";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String SYOUHINBETUKEY1          = "syouhinbetukey1";
    public static final String SAITEIP                  = "saiteip";
    public static final String PTANI                    = "ptani";

    private final PKBM_ChkSaiteiP primaryKey;

    public GenBM_ChkSaiteiP() {
        primaryKey = new PKBM_ChkSaiteiP();
    }

    public GenBM_ChkSaiteiP(
        String pSyouhncd,
        C_Hrkkaisuu pHrkkaisuu,
        BizNumber pHrkkknfrom,
        BizNumber pHrkkknto,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Channelcd pChannelcd,
        C_Tuukasyu pTuukasyu,
        String pSyouhinbetukey1
    ) {
        primaryKey = new PKBM_ChkSaiteiP(
            pSyouhncd,
            pHrkkaisuu,
            pHrkkknfrom,
            pHrkkknto,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pChannelcd,
            pTuukasyu,
            pSyouhinbetukey1
        );
    }

    @Transient
    @Override
    public PKBM_ChkSaiteiP getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkSaiteiP> getMetaClass() {
        return QBM_ChkSaiteiP.class;
    }

    @Id
    @Column(name=GenBM_ChkSaiteiP.SYOUHNCD)
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
    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenBM_ChkSaiteiP.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return getPrimaryKey().getHrkkaisuu();
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        getPrimaryKey().setHrkkaisuu(pHrkkaisuu);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkSaiteiP.HRKKKNFROM)
    public BizNumber getHrkkknfrom() {
        return getPrimaryKey().getHrkkknfrom();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrkkknfrom(BizNumber pHrkkknfrom) {
        getPrimaryKey().setHrkkknfrom(pHrkkknfrom);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkSaiteiP.HRKKKNTO)
    public BizNumber getHrkkknto() {
        return getPrimaryKey().getHrkkknto();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrkkknto(BizNumber pHrkkknto) {
        getPrimaryKey().setHrkkknto(pHrkkknto);
    }

    @Id
    @Column(name=GenBM_ChkSaiteiP.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkSaiteiP.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Type(type="UserType_C_Channelcd")
    @Column(name=GenBM_ChkSaiteiP.CHANNELCD)
    public C_Channelcd getChannelcd() {
        return getPrimaryKey().getChannelcd();
    }

    public void setChannelcd(C_Channelcd pChannelcd) {
        getPrimaryKey().setChannelcd(pChannelcd);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_ChkSaiteiP.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    @Id
    @Column(name=GenBM_ChkSaiteiP.SYOUHINBETUKEY1)
    public String getSyouhinbetukey1() {
        return getPrimaryKey().getSyouhinbetukey1();
    }

    public void setSyouhinbetukey1(String pSyouhinbetukey1) {
        getPrimaryKey().setSyouhinbetukey1(pSyouhinbetukey1);
    }

    private BizCurrency saiteip;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSaiteip() {
        return saiteip;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSaiteip(BizCurrency pSaiteip) {
        saiteip = pSaiteip;
        saiteipValue = null;
        saiteipType  = null;
    }

    transient private BigDecimal saiteipValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SAITEIP, nullable=true)
    protected BigDecimal getSaiteipValue() {
        if (saiteipValue == null && saiteip != null) {
            if (saiteip.isOptional()) return null;
            return saiteip.absolute();
        }
        return saiteipValue;
    }

    protected void setSaiteipValue(BigDecimal value) {
        saiteipValue = value;
        saiteip = Optional.fromNullable(toCurrencyType(saiteipType))
            .transform(bizCurrencyTransformer(getSaiteipValue()))
            .orNull();
    }

    transient private String saiteipType = null;

    @Column(name=SAITEIP + "$", nullable=true)
    protected String getSaiteipType() {
        if (saiteipType == null && saiteip != null) return saiteip.getType().toString();
        if (saiteipType == null && getSaiteipValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'saiteip$' should not be NULL."));
        }
        return saiteipType;
    }

    protected void setSaiteipType(String type) {
        saiteipType = type;
        saiteip = Optional.fromNullable(toCurrencyType(saiteipType))
            .transform(bizCurrencyTransformer(getSaiteipValue()))
            .orNull();
    }

    private BizCurrency ptani;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getPtani() {
        return ptani;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPtani(BizCurrency pPtani) {
        ptani = pPtani;
        ptaniValue = null;
        ptaniType  = null;
    }

    transient private BigDecimal ptaniValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=PTANI, nullable=true)
    protected BigDecimal getPtaniValue() {
        if (ptaniValue == null && ptani != null) {
            if (ptani.isOptional()) return null;
            return ptani.absolute();
        }
        return ptaniValue;
    }

    protected void setPtaniValue(BigDecimal value) {
        ptaniValue = value;
        ptani = Optional.fromNullable(toCurrencyType(ptaniType))
            .transform(bizCurrencyTransformer(getPtaniValue()))
            .orNull();
    }

    transient private String ptaniType = null;

    @Column(name=PTANI + "$", nullable=true)
    protected String getPtaniType() {
        if (ptaniType == null && ptani != null) return ptani.getType().toString();
        if (ptaniType == null && getPtaniValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'ptani$' should not be NULL."));
        }
        return ptaniType;
    }

    protected void setPtaniType(String type) {
        ptaniType = type;
        ptani = Optional.fromNullable(toCurrencyType(ptaniType))
            .transform(bizCurrencyTransformer(getPtaniValue()))
            .orNull();
    }
}
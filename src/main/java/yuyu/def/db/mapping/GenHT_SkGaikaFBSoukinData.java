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
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_SkGaikaFBSoukinData;
import yuyu.def.db.id.PKHT_SkGaikaFBSoukinData;
import yuyu.def.db.meta.GenQHT_SkGaikaFBSoukinData;
import yuyu.def.db.meta.QHT_SkGaikaFBSoukinData;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_Gkgyoumucd;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Tantositucd;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約外貨ＦＢ送金データテーブル テーブルのマッピング情報クラスで、 {@link HT_SkGaikaFBSoukinData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkGaikaFBSoukinData}</td><td colspan="3">新契約外貨ＦＢ送金データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getFbsoukindatasikibetukey fbsoukindatasikibetukey}</td><td>ＦＢ送金データ識別キー</td><td align="center">{@link PKHT_SkGaikaFBSoukinData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDensyskbn densyskbn}</td><td>伝票用システム区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DensysKbn}</td></tr>
 *  <tr><td>{@link #getGkgyoumucd gkgyoumucd}</td><td>外貨業務コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Gkgyoumucd}</td></tr>
 *  <tr><td>{@link #getTantositucd tantositucd}</td><td>担当室コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tantositucd}</td></tr>
 *  <tr><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrhousiteikbn shrhousiteikbn}</td><td>支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBanknmej banknmej}</td><td>銀行名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitennmej sitennmej}</td><td>支店名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmei kzmeiginmei}</td><td>口座名義人名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getGaikashrgk gaikashrgk}</td><td>外貨支払額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getCrossrateshrgk crossrateshrgk}</td><td>クロスレート支払額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSoukinkwsrate soukinkwsrate}</td><td>送金用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getIrninnmei irninnmei}</td><td>依頼人名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkGaikaFBSoukinData
 * @see     PKHT_SkGaikaFBSoukinData
 * @see     QHT_SkGaikaFBSoukinData
 * @see     GenQHT_SkGaikaFBSoukinData
 */
@MappedSuperclass
@Table(name=GenHT_SkGaikaFBSoukinData.TABLE_NAME)
@IdClass(value=PKHT_SkGaikaFBSoukinData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_DensysKbn", typeClass=UserType_C_DensysKbn.class),
    @TypeDef(name="UserType_C_Gkgyoumucd", typeClass=UserType_C_Gkgyoumucd.class),
    @TypeDef(name="UserType_C_ShrhousiteiKbn", typeClass=UserType_C_ShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_Tantositucd", typeClass=UserType_C_Tantositucd.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenHT_SkGaikaFBSoukinData extends AbstractExDBEntity<HT_SkGaikaFBSoukinData, PKHT_SkGaikaFBSoukinData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SkGaikaFBSoukinData";
    public static final String FBSOUKINDATASIKIBETUKEY  = "fbsoukindatasikibetukey";
    public static final String DENRENNO                 = "denrenno";
    public static final String EDANO                    = "edano";
    public static final String DENSYSKBN                = "densyskbn";
    public static final String GKGYOUMUCD               = "gkgyoumucd";
    public static final String TANTOSITUCD              = "tantositucd";
    public static final String SYORICD                  = "syoricd";
    public static final String SYORISOSIKICD            = "syorisosikicd";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String DENYMD                   = "denymd";
    public static final String MOSNO                    = "mosno";
    public static final String SHRHOUSITEIKBN           = "shrhousiteikbn";
    public static final String BANKCD                   = "bankcd";
    public static final String BANKNMEJ                 = "banknmej";
    public static final String SITENCD                  = "sitencd";
    public static final String SITENNMEJ                = "sitennmej";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZMEIGINMEI              = "kzmeiginmei";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String GAIKASHRGK               = "gaikashrgk";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String CROSSRATESHRGK           = "crossrateshrgk";
    public static final String SOUKINKWSRATE            = "soukinkwsrate";
    public static final String IRNINNMEI                = "irninnmei";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SkGaikaFBSoukinData primaryKey;

    public GenHT_SkGaikaFBSoukinData() {
        primaryKey = new PKHT_SkGaikaFBSoukinData();
    }

    public GenHT_SkGaikaFBSoukinData(String pFbsoukindatasikibetukey) {
        primaryKey = new PKHT_SkGaikaFBSoukinData(pFbsoukindatasikibetukey);
    }

    @Transient
    @Override
    public PKHT_SkGaikaFBSoukinData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SkGaikaFBSoukinData> getMetaClass() {
        return QHT_SkGaikaFBSoukinData.class;
    }

    @Id
    @Column(name=GenHT_SkGaikaFBSoukinData.FBSOUKINDATASIKIBETUKEY)
    public String getFbsoukindatasikibetukey() {
        return getPrimaryKey().getFbsoukindatasikibetukey();
    }

    public void setFbsoukindatasikibetukey(String pFbsoukindatasikibetukey) {
        getPrimaryKey().setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
    }

    private String denrenno;

    @Column(name=GenHT_SkGaikaFBSoukinData.DENRENNO)
    public String getDenrenno() {
        return denrenno;
    }

    public void setDenrenno(String pDenrenno) {
        denrenno = pDenrenno;
    }

    private Integer edano;

    @Column(name=GenHT_SkGaikaFBSoukinData.EDANO)
    public Integer getEdano() {
        return edano;
    }

    public void setEdano(Integer pEdano) {
        edano = pEdano;
    }

    private C_DensysKbn densyskbn;

    @Type(type="UserType_C_DensysKbn")
    @Column(name=GenHT_SkGaikaFBSoukinData.DENSYSKBN)
    public C_DensysKbn getDensyskbn() {
        return densyskbn;
    }

    public void setDensyskbn(C_DensysKbn pDensyskbn) {
        densyskbn = pDensyskbn;
    }

    private C_Gkgyoumucd gkgyoumucd;

    @Type(type="UserType_C_Gkgyoumucd")
    @Column(name=GenHT_SkGaikaFBSoukinData.GKGYOUMUCD)
    public C_Gkgyoumucd getGkgyoumucd() {
        return gkgyoumucd;
    }

    public void setGkgyoumucd(C_Gkgyoumucd pGkgyoumucd) {
        gkgyoumucd = pGkgyoumucd;
    }

    private C_Tantositucd tantositucd;

    @Type(type="UserType_C_Tantositucd")
    @Column(name=GenHT_SkGaikaFBSoukinData.TANTOSITUCD)
    public C_Tantositucd getTantositucd() {
        return tantositucd;
    }

    public void setTantositucd(C_Tantositucd pTantositucd) {
        tantositucd = pTantositucd;
    }

    private String syoricd;

    @Column(name=GenHT_SkGaikaFBSoukinData.SYORICD)
    public String getSyoricd() {
        return syoricd;
    }

    public void setSyoricd(String pSyoricd) {
        syoricd = pSyoricd;
    }

    private String syorisosikicd;

    @Column(name=GenHT_SkGaikaFBSoukinData.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkGaikaFBSoukinData.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private BizDate denymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkGaikaFBSoukinData.DENYMD)
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    private String mosno;

    @Column(name=GenHT_SkGaikaFBSoukinData.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private C_ShrhousiteiKbn shrhousiteikbn;

    @Type(type="UserType_C_ShrhousiteiKbn")
    @Column(name=GenHT_SkGaikaFBSoukinData.SHRHOUSITEIKBN)
    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    public void setShrhousiteikbn(C_ShrhousiteiKbn pShrhousiteikbn) {
        shrhousiteikbn = pShrhousiteikbn;
    }

    private String bankcd;

    @Column(name=GenHT_SkGaikaFBSoukinData.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private String banknmej;

    @Column(name=GenHT_SkGaikaFBSoukinData.BANKNMEJ)
    public String getBanknmej() {
        return banknmej;
    }

    public void setBanknmej(String pBanknmej) {
        banknmej = pBanknmej;
    }

    private String sitencd;

    @Column(name=GenHT_SkGaikaFBSoukinData.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    private String sitennmej;

    @Column(name=GenHT_SkGaikaFBSoukinData.SITENNMEJ)
    public String getSitennmej() {
        return sitennmej;
    }

    public void setSitennmej(String pSitennmej) {
        sitennmej = pSitennmej;
    }

    private String kouzano;

    @Column(name=GenHT_SkGaikaFBSoukinData.KOUZANO)
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

    private String kzmeiginmei;

    @Column(name=GenHT_SkGaikaFBSoukinData.KZMEIGINMEI)
    @HostInvalidCharacter
    public String getKzmeiginmei() {
        return kzmeiginmei;
    }

    public void setKzmeiginmei(String pKzmeiginmei) {
        kzmeiginmei = pKzmeiginmei;
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_SkGaikaFBSoukinData.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private BizCurrency gaikashrgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGaikashrgk() {
        return gaikashrgk;
    }

    public void setGaikashrgk(BizCurrency pGaikashrgk) {
        gaikashrgk = pGaikashrgk;
        gaikashrgkValue = null;
        gaikashrgkType  = null;
    }

    transient private BigDecimal gaikashrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GAIKASHRGK, nullable=true)
    protected BigDecimal getGaikashrgkValue() {
        if (gaikashrgkValue == null && gaikashrgk != null) {
            if (gaikashrgk.isOptional()) return null;
            return gaikashrgk.absolute();
        }
        return gaikashrgkValue;
    }

    protected void setGaikashrgkValue(BigDecimal value) {
        gaikashrgkValue = value;
        gaikashrgk = Optional.fromNullable(toCurrencyType(gaikashrgkType))
            .transform(bizCurrencyTransformer(getGaikashrgkValue()))
            .orNull();
    }

    transient private String gaikashrgkType = null;

    @Column(name=GAIKASHRGK + "$", nullable=true)
    protected String getGaikashrgkType() {
        if (gaikashrgkType == null && gaikashrgk != null) return gaikashrgk.getType().toString();
        if (gaikashrgkType == null && getGaikashrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gaikashrgk$' should not be NULL."));
        }
        return gaikashrgkType;
    }

    protected void setGaikashrgkType(String type) {
        gaikashrgkType = type;
        gaikashrgk = Optional.fromNullable(toCurrencyType(gaikashrgkType))
            .transform(bizCurrencyTransformer(getGaikashrgkValue()))
            .orNull();
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_SkGaikaFBSoukinData.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private BizCurrency crossrateshrgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getCrossrateshrgk() {
        return crossrateshrgk;
    }

    public void setCrossrateshrgk(BizCurrency pCrossrateshrgk) {
        crossrateshrgk = pCrossrateshrgk;
        crossrateshrgkValue = null;
        crossrateshrgkType  = null;
    }

    transient private BigDecimal crossrateshrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=CROSSRATESHRGK, nullable=true)
    protected BigDecimal getCrossrateshrgkValue() {
        if (crossrateshrgkValue == null && crossrateshrgk != null) {
            if (crossrateshrgk.isOptional()) return null;
            return crossrateshrgk.absolute();
        }
        return crossrateshrgkValue;
    }

    protected void setCrossrateshrgkValue(BigDecimal value) {
        crossrateshrgkValue = value;
        crossrateshrgk = Optional.fromNullable(toCurrencyType(crossrateshrgkType))
            .transform(bizCurrencyTransformer(getCrossrateshrgkValue()))
            .orNull();
    }

    transient private String crossrateshrgkType = null;

    @Column(name=CROSSRATESHRGK + "$", nullable=true)
    protected String getCrossrateshrgkType() {
        if (crossrateshrgkType == null && crossrateshrgk != null) return crossrateshrgk.getType().toString();
        if (crossrateshrgkType == null && getCrossrateshrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'crossrateshrgk$' should not be NULL."));
        }
        return crossrateshrgkType;
    }

    protected void setCrossrateshrgkType(String type) {
        crossrateshrgkType = type;
        crossrateshrgk = Optional.fromNullable(toCurrencyType(crossrateshrgkType))
            .transform(bizCurrencyTransformer(getCrossrateshrgkValue()))
            .orNull();
    }

    private BizNumber soukinkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenHT_SkGaikaFBSoukinData.SOUKINKWSRATE)
    public BizNumber getSoukinkwsrate() {
        return soukinkwsrate;
    }

    public void setSoukinkwsrate(BizNumber pSoukinkwsrate) {
        soukinkwsrate = pSoukinkwsrate;
    }

    private String irninnmei;

    @Column(name=GenHT_SkGaikaFBSoukinData.IRNINNMEI)
    public String getIrninnmei() {
        return irninnmei;
    }

    public void setIrninnmei(String pIrninnmei) {
        irninnmei = pIrninnmei;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenHT_SkGaikaFBSoukinData.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SkGaikaFBSoukinData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SkGaikaFBSoukinData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
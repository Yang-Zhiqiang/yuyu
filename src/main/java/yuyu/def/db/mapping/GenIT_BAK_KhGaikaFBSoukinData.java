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
import yuyu.def.db.entity.IT_BAK_KhGaikaFBSoukinData;
import yuyu.def.db.id.PKIT_BAK_KhGaikaFBSoukinData;
import yuyu.def.db.meta.GenQIT_BAK_KhGaikaFBSoukinData;
import yuyu.def.db.meta.QIT_BAK_KhGaikaFBSoukinData;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_Gkgyoumucd;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Tantositucd;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全外貨ＦＢ送金データバックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_KhGaikaFBSoukinData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhGaikaFBSoukinData}</td><td colspan="3">契約保全外貨ＦＢ送金データバックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getFbsoukindatasikibetukey fbsoukindatasikibetukey}</td><td>ＦＢ送金データ識別キー</td><td align="center">{@link PKIT_BAK_KhGaikaFBSoukinData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_KhGaikaFBSoukinData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDensyskbn densyskbn}</td><td>伝票用システム区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DensysKbn}</td></tr>
 *  <tr><td>{@link #getGkgyoumucd gkgyoumucd}</td><td>外貨業務コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Gkgyoumucd}</td></tr>
 *  <tr><td>{@link #getTantositucd tantositucd}</td><td>担当室コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tantositucd}</td></tr>
 *  <tr><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 * @see     IT_BAK_KhGaikaFBSoukinData
 * @see     PKIT_BAK_KhGaikaFBSoukinData
 * @see     QIT_BAK_KhGaikaFBSoukinData
 * @see     GenQIT_BAK_KhGaikaFBSoukinData
 */
@MappedSuperclass
@Table(name=GenIT_BAK_KhGaikaFBSoukinData.TABLE_NAME)
@IdClass(value=PKIT_BAK_KhGaikaFBSoukinData.class)
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
public abstract class GenIT_BAK_KhGaikaFBSoukinData extends AbstractExDBEntity<IT_BAK_KhGaikaFBSoukinData, PKIT_BAK_KhGaikaFBSoukinData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_KhGaikaFBSoukinData";
    public static final String FBSOUKINDATASIKIBETUKEY  = "fbsoukindatasikibetukey";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String DENRENNO                 = "denrenno";
    public static final String EDANO                    = "edano";
    public static final String DENSYSKBN                = "densyskbn";
    public static final String GKGYOUMUCD               = "gkgyoumucd";
    public static final String TANTOSITUCD              = "tantositucd";
    public static final String SYORICD                  = "syoricd";
    public static final String SYORISOSIKICD            = "syorisosikicd";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String DENYMD                   = "denymd";
    public static final String SYONO                    = "syono";
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

    private final PKIT_BAK_KhGaikaFBSoukinData primaryKey;

    public GenIT_BAK_KhGaikaFBSoukinData() {
        primaryKey = new PKIT_BAK_KhGaikaFBSoukinData();
    }

    public GenIT_BAK_KhGaikaFBSoukinData(String pFbsoukindatasikibetukey, String pTrkssikibetukey) {
        primaryKey = new PKIT_BAK_KhGaikaFBSoukinData(pFbsoukindatasikibetukey, pTrkssikibetukey);
    }

    @Transient
    @Override
    public PKIT_BAK_KhGaikaFBSoukinData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_KhGaikaFBSoukinData> getMetaClass() {
        return QIT_BAK_KhGaikaFBSoukinData.class;
    }

    @Id
    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.FBSOUKINDATASIKIBETUKEY)
    public String getFbsoukindatasikibetukey() {
        return getPrimaryKey().getFbsoukindatasikibetukey();
    }

    public void setFbsoukindatasikibetukey(String pFbsoukindatasikibetukey) {
        getPrimaryKey().setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    private String denrenno;

    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.DENRENNO)
    public String getDenrenno() {
        return denrenno;
    }

    public void setDenrenno(String pDenrenno) {
        denrenno = pDenrenno;
    }

    private Integer edano;

    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.EDANO)
    public Integer getEdano() {
        return edano;
    }

    public void setEdano(Integer pEdano) {
        edano = pEdano;
    }

    private C_DensysKbn densyskbn;

    @Type(type="UserType_C_DensysKbn")
    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.DENSYSKBN)
    public C_DensysKbn getDensyskbn() {
        return densyskbn;
    }

    public void setDensyskbn(C_DensysKbn pDensyskbn) {
        densyskbn = pDensyskbn;
    }

    private C_Gkgyoumucd gkgyoumucd;

    @Type(type="UserType_C_Gkgyoumucd")
    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.GKGYOUMUCD)
    public C_Gkgyoumucd getGkgyoumucd() {
        return gkgyoumucd;
    }

    public void setGkgyoumucd(C_Gkgyoumucd pGkgyoumucd) {
        gkgyoumucd = pGkgyoumucd;
    }

    private C_Tantositucd tantositucd;

    @Type(type="UserType_C_Tantositucd")
    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.TANTOSITUCD)
    public C_Tantositucd getTantositucd() {
        return tantositucd;
    }

    public void setTantositucd(C_Tantositucd pTantositucd) {
        tantositucd = pTantositucd;
    }

    private String syoricd;

    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.SYORICD)
    public String getSyoricd() {
        return syoricd;
    }

    public void setSyoricd(String pSyoricd) {
        syoricd = pSyoricd;
    }

    private String syorisosikicd;

    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.SYORIYMD)
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
    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.DENYMD)
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    private String syono;

    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private C_ShrhousiteiKbn shrhousiteikbn;

    @Type(type="UserType_C_ShrhousiteiKbn")
    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.SHRHOUSITEIKBN)
    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    public void setShrhousiteikbn(C_ShrhousiteiKbn pShrhousiteikbn) {
        shrhousiteikbn = pShrhousiteikbn;
    }

    private String bankcd;

    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.BANKCD)
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

    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.BANKNMEJ)
    public String getBanknmej() {
        return banknmej;
    }

    public void setBanknmej(String pBanknmej) {
        banknmej = pBanknmej;
    }

    private String sitencd;

    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.SITENCD)
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

    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.SITENNMEJ)
    public String getSitennmej() {
        return sitennmej;
    }

    public void setSitennmej(String pSitennmej) {
        sitennmej = pSitennmej;
    }

    private String kouzano;

    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.KOUZANO)
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

    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.KZMEIGINMEI)
    @HostInvalidCharacter
    public String getKzmeiginmei() {
        return kzmeiginmei;
    }

    public void setKzmeiginmei(String pKzmeiginmei) {
        kzmeiginmei = pKzmeiginmei;
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.SHRTUUKASYU)
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
    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.KYKTUUKASYU)
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
    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.SOUKINKWSRATE)
    public BizNumber getSoukinkwsrate() {
        return soukinkwsrate;
    }

    public void setSoukinkwsrate(BizNumber pSoukinkwsrate) {
        soukinkwsrate = pSoukinkwsrate;
    }

    private String irninnmei;

    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.IRNINNMEI)
    public String getIrninnmei() {
        return irninnmei;
    }

    public void setIrninnmei(String pIrninnmei) {
        irninnmei = pIrninnmei;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_KhGaikaFBSoukinData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_JidousoukinHukaRiyuuKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_PMinyuuSyoumetuInfo;
import yuyu.def.db.id.PKIT_PMinyuuSyoumetuInfo;
import yuyu.def.db.meta.GenQIT_PMinyuuSyoumetuInfo;
import yuyu.def.db.meta.QIT_PMinyuuSyoumetuInfo;
import yuyu.def.db.type.UserType_C_JidousoukinHukaRiyuuKbn;
import yuyu.def.db.type.UserType_C_StknsetKbn;
import yuyu.def.db.type.UserType_C_SyorikahiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * Ｐ未入消滅情報テーブル テーブルのマッピング情報クラスで、 {@link IT_PMinyuuSyoumetuInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_PMinyuuSyoumetuInfo}</td><td colspan="3">Ｐ未入消滅情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_PMinyuuSyoumetuInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_PMinyuuSyoumetuInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoriym syoriym}</td><td>処理年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSyoumetuymd syoumetuymd}</td><td>消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJidousoukinhukariyuu jidousoukinhukariyuu}</td><td>自動送金不可理由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_JidousoukinHukaRiyuuKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuihanteikekka ttdktyuuihanteikekka}</td><td>手続注意判定結果</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikahiKbn}</td></tr>
 *  <tr><td>{@link #getStknsetkbn stknsetkbn}</td><td>質権設定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_StknsetKbn}</td></tr>
 *  <tr><td>{@link #getShrgkkei shrgkkei}</td><td>支払額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrkwsrate shrkwsrate}</td><td>支払時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getShrtuukakaiyakuhrkngkkei shrtuukakaiyakuhrkngkkei}</td><td>支払通貨解約返戻金額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakuhrkngkkeisiteituuka kaiyakuhrkngkkeisiteituuka}</td><td>解約返戻金額合計（指定通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotaseisan sonotaseisan}</td><td>その他精算金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkansanhaitoukin yenkansanhaitoukin}</td><td>円換算配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYensonotahaitoukin yensonotahaitoukin}</td><td>円換算その他配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukagstszeigk shrtuukagstszeigk}</td><td>支払通貨源泉徴収税額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZitkazukarikingksiteituuka zitkazukarikingksiteituuka}</td><td>税適預り金額（指定通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZitkazukarikingkyen zitkazukarikingkyen}</td><td>税適預り金額（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakuhrknsiteituuka kaiyakuhrknsiteituuka}</td><td>解約返戻金（指定通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakuhryen kaiyakuhryen}</td><td>解約返戻金（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkrkgk yenkrkgk}</td><td>円換算仮受金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_PMinyuuSyoumetuInfo
 * @see     PKIT_PMinyuuSyoumetuInfo
 * @see     QIT_PMinyuuSyoumetuInfo
 * @see     GenQIT_PMinyuuSyoumetuInfo
 */
@MappedSuperclass
@Table(name=GenIT_PMinyuuSyoumetuInfo.TABLE_NAME)
@IdClass(value=PKIT_PMinyuuSyoumetuInfo.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_JidousoukinHukaRiyuuKbn", typeClass=UserType_C_JidousoukinHukaRiyuuKbn.class),
    @TypeDef(name="UserType_C_StknsetKbn", typeClass=UserType_C_StknsetKbn.class),
    @TypeDef(name="UserType_C_SyorikahiKbn", typeClass=UserType_C_SyorikahiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenIT_PMinyuuSyoumetuInfo extends AbstractExDBEntity<IT_PMinyuuSyoumetuInfo, PKIT_PMinyuuSyoumetuInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_PMinyuuSyoumetuInfo";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYORIYM                  = "syoriym";
    public static final String SYOUMETUYMD              = "syoumetuymd";
    public static final String JIDOUSOUKINHUKARIYUU     = "jidousoukinhukariyuu";
    public static final String TTDKTYUUIHANTEIKEKKA     = "ttdktyuuihanteikekka";
    public static final String STKNSETKBN               = "stknsetkbn";
    public static final String SHRGKKEI                 = "shrgkkei";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String SHRKWSRATE               = "shrkwsrate";
    public static final String SHRTUUKAKAIYAKUHRKNGKKEI = "shrtuukakaiyakuhrkngkkei";
    public static final String KAIYAKUHRKNGKKEISITEITUUKA = "kaiyakuhrkngkkeisiteituuka";
    public static final String SONOTASEISAN             = "sonotaseisan";
    public static final String YENKANSANHAITOUKIN       = "yenkansanhaitoukin";
    public static final String YENSONOTAHAITOUKIN       = "yensonotahaitoukin";
    public static final String SHRTUUKAGSTSZEIGK        = "shrtuukagstszeigk";
    public static final String ZITKAZUKARIKINGKSITEITUUKA = "zitkazukarikingksiteituuka";
    public static final String ZITKAZUKARIKINGKYEN      = "zitkazukarikingkyen";
    public static final String KAIYAKUHRKNSITEITUUKA    = "kaiyakuhrknsiteituuka";
    public static final String KAIYAKUHRYEN             = "kaiyakuhryen";
    public static final String YENKRKGK                 = "yenkrkgk";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_PMinyuuSyoumetuInfo primaryKey;

    public GenIT_PMinyuuSyoumetuInfo() {
        primaryKey = new PKIT_PMinyuuSyoumetuInfo();
    }

    public GenIT_PMinyuuSyoumetuInfo(String pKbnkey, String pSyono) {
        primaryKey = new PKIT_PMinyuuSyoumetuInfo(pKbnkey, pSyono);
    }

    @Transient
    @Override
    public PKIT_PMinyuuSyoumetuInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_PMinyuuSyoumetuInfo> getMetaClass() {
        return QIT_PMinyuuSyoumetuInfo.class;
    }

    @Id
    @Column(name=GenIT_PMinyuuSyoumetuInfo.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_PMinyuuSyoumetuInfo.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private String henkousikibetukey;

    @Column(name=GenIT_PMinyuuSyoumetuInfo.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_PMinyuuSyoumetuInfo.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private BizDateYM syoriym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_PMinyuuSyoumetuInfo.SYORIYM)
    public BizDateYM getSyoriym() {
        return syoriym;
    }

    public void setSyoriym(BizDateYM pSyoriym) {
        syoriym = pSyoriym;
    }

    private BizDate syoumetuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_PMinyuuSyoumetuInfo.SYOUMETUYMD)
    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }

    private C_JidousoukinHukaRiyuuKbn jidousoukinhukariyuu;

    @Type(type="UserType_C_JidousoukinHukaRiyuuKbn")
    @Column(name=GenIT_PMinyuuSyoumetuInfo.JIDOUSOUKINHUKARIYUU)
    public C_JidousoukinHukaRiyuuKbn getJidousoukinhukariyuu() {
        return jidousoukinhukariyuu;
    }

    public void setJidousoukinhukariyuu(C_JidousoukinHukaRiyuuKbn pJidousoukinhukariyuu) {
        jidousoukinhukariyuu = pJidousoukinhukariyuu;
    }

    private C_SyorikahiKbn ttdktyuuihanteikekka;

    @Type(type="UserType_C_SyorikahiKbn")
    @Column(name=GenIT_PMinyuuSyoumetuInfo.TTDKTYUUIHANTEIKEKKA)
    public C_SyorikahiKbn getTtdktyuuihanteikekka() {
        return ttdktyuuihanteikekka;
    }

    public void setTtdktyuuihanteikekka(C_SyorikahiKbn pTtdktyuuihanteikekka) {
        ttdktyuuihanteikekka = pTtdktyuuihanteikekka;
    }

    private C_StknsetKbn stknsetkbn;

    @Type(type="UserType_C_StknsetKbn")
    @Column(name=GenIT_PMinyuuSyoumetuInfo.STKNSETKBN)
    public C_StknsetKbn getStknsetkbn() {
        return stknsetkbn;
    }

    public void setStknsetkbn(C_StknsetKbn pStknsetkbn) {
        stknsetkbn = pStknsetkbn;
    }

    private BizCurrency shrgkkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrgkkei() {
        return shrgkkei;
    }

    public void setShrgkkei(BizCurrency pShrgkkei) {
        shrgkkei = pShrgkkei;
        shrgkkeiValue = null;
        shrgkkeiType  = null;
    }

    transient private BigDecimal shrgkkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRGKKEI, nullable=true)
    protected BigDecimal getShrgkkeiValue() {
        if (shrgkkeiValue == null && shrgkkei != null) {
            if (shrgkkei.isOptional()) return null;
            return shrgkkei.absolute();
        }
        return shrgkkeiValue;
    }

    protected void setShrgkkeiValue(BigDecimal value) {
        shrgkkeiValue = value;
        shrgkkei = Optional.fromNullable(toCurrencyType(shrgkkeiType))
            .transform(bizCurrencyTransformer(getShrgkkeiValue()))
            .orNull();
    }

    transient private String shrgkkeiType = null;

    @Column(name=SHRGKKEI + "$", nullable=true)
    protected String getShrgkkeiType() {
        if (shrgkkeiType == null && shrgkkei != null) return shrgkkei.getType().toString();
        if (shrgkkeiType == null && getShrgkkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrgkkei$' should not be NULL."));
        }
        return shrgkkeiType;
    }

    protected void setShrgkkeiType(String type) {
        shrgkkeiType = type;
        shrgkkei = Optional.fromNullable(toCurrencyType(shrgkkeiType))
            .transform(bizCurrencyTransformer(getShrgkkeiValue()))
            .orNull();
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_PMinyuuSyoumetuInfo.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private BizNumber shrkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_PMinyuuSyoumetuInfo.SHRKWSRATE)
    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    private BizCurrency shrtuukakaiyakuhrkngkkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtuukakaiyakuhrkngkkei() {
        return shrtuukakaiyakuhrkngkkei;
    }

    public void setShrtuukakaiyakuhrkngkkei(BizCurrency pShrtuukakaiyakuhrkngkkei) {
        shrtuukakaiyakuhrkngkkei = pShrtuukakaiyakuhrkngkkei;
        shrtuukakaiyakuhrkngkkeiValue = null;
        shrtuukakaiyakuhrkngkkeiType  = null;
    }

    transient private BigDecimal shrtuukakaiyakuhrkngkkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTUUKAKAIYAKUHRKNGKKEI, nullable=true)
    protected BigDecimal getShrtuukakaiyakuhrkngkkeiValue() {
        if (shrtuukakaiyakuhrkngkkeiValue == null && shrtuukakaiyakuhrkngkkei != null) {
            if (shrtuukakaiyakuhrkngkkei.isOptional()) return null;
            return shrtuukakaiyakuhrkngkkei.absolute();
        }
        return shrtuukakaiyakuhrkngkkeiValue;
    }

    protected void setShrtuukakaiyakuhrkngkkeiValue(BigDecimal value) {
        shrtuukakaiyakuhrkngkkeiValue = value;
        shrtuukakaiyakuhrkngkkei = Optional.fromNullable(toCurrencyType(shrtuukakaiyakuhrkngkkeiType))
            .transform(bizCurrencyTransformer(getShrtuukakaiyakuhrkngkkeiValue()))
            .orNull();
    }

    transient private String shrtuukakaiyakuhrkngkkeiType = null;

    @Column(name=SHRTUUKAKAIYAKUHRKNGKKEI + "$", nullable=true)
    protected String getShrtuukakaiyakuhrkngkkeiType() {
        if (shrtuukakaiyakuhrkngkkeiType == null && shrtuukakaiyakuhrkngkkei != null) return shrtuukakaiyakuhrkngkkei.getType().toString();
        if (shrtuukakaiyakuhrkngkkeiType == null && getShrtuukakaiyakuhrkngkkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtuukakaiyakuhrkngkkei$' should not be NULL."));
        }
        return shrtuukakaiyakuhrkngkkeiType;
    }

    protected void setShrtuukakaiyakuhrkngkkeiType(String type) {
        shrtuukakaiyakuhrkngkkeiType = type;
        shrtuukakaiyakuhrkngkkei = Optional.fromNullable(toCurrencyType(shrtuukakaiyakuhrkngkkeiType))
            .transform(bizCurrencyTransformer(getShrtuukakaiyakuhrkngkkeiValue()))
            .orNull();
    }

    private BizCurrency kaiyakuhrkngkkeisiteituuka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakuhrkngkkeisiteituuka() {
        return kaiyakuhrkngkkeisiteituuka;
    }

    public void setKaiyakuhrkngkkeisiteituuka(BizCurrency pKaiyakuhrkngkkeisiteituuka) {
        kaiyakuhrkngkkeisiteituuka = pKaiyakuhrkngkkeisiteituuka;
        kaiyakuhrkngkkeisiteituukaValue = null;
        kaiyakuhrkngkkeisiteituukaType  = null;
    }

    transient private BigDecimal kaiyakuhrkngkkeisiteituukaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUHRKNGKKEISITEITUUKA, nullable=true)
    protected BigDecimal getKaiyakuhrkngkkeisiteituukaValue() {
        if (kaiyakuhrkngkkeisiteituukaValue == null && kaiyakuhrkngkkeisiteituuka != null) {
            if (kaiyakuhrkngkkeisiteituuka.isOptional()) return null;
            return kaiyakuhrkngkkeisiteituuka.absolute();
        }
        return kaiyakuhrkngkkeisiteituukaValue;
    }

    protected void setKaiyakuhrkngkkeisiteituukaValue(BigDecimal value) {
        kaiyakuhrkngkkeisiteituukaValue = value;
        kaiyakuhrkngkkeisiteituuka = Optional.fromNullable(toCurrencyType(kaiyakuhrkngkkeisiteituukaType))
            .transform(bizCurrencyTransformer(getKaiyakuhrkngkkeisiteituukaValue()))
            .orNull();
    }

    transient private String kaiyakuhrkngkkeisiteituukaType = null;

    @Column(name=KAIYAKUHRKNGKKEISITEITUUKA + "$", nullable=true)
    protected String getKaiyakuhrkngkkeisiteituukaType() {
        if (kaiyakuhrkngkkeisiteituukaType == null && kaiyakuhrkngkkeisiteituuka != null) return kaiyakuhrkngkkeisiteituuka.getType().toString();
        if (kaiyakuhrkngkkeisiteituukaType == null && getKaiyakuhrkngkkeisiteituukaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakuhrkngkkeisiteituuka$' should not be NULL."));
        }
        return kaiyakuhrkngkkeisiteituukaType;
    }

    protected void setKaiyakuhrkngkkeisiteituukaType(String type) {
        kaiyakuhrkngkkeisiteituukaType = type;
        kaiyakuhrkngkkeisiteituuka = Optional.fromNullable(toCurrencyType(kaiyakuhrkngkkeisiteituukaType))
            .transform(bizCurrencyTransformer(getKaiyakuhrkngkkeisiteituukaValue()))
            .orNull();
    }

    private BizCurrency sonotaseisan;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSonotaseisan() {
        return sonotaseisan;
    }

    public void setSonotaseisan(BizCurrency pSonotaseisan) {
        sonotaseisan = pSonotaseisan;
        sonotaseisanValue = null;
        sonotaseisanType  = null;
    }

    transient private BigDecimal sonotaseisanValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SONOTASEISAN, nullable=true)
    protected BigDecimal getSonotaseisanValue() {
        if (sonotaseisanValue == null && sonotaseisan != null) {
            if (sonotaseisan.isOptional()) return null;
            return sonotaseisan.absolute();
        }
        return sonotaseisanValue;
    }

    protected void setSonotaseisanValue(BigDecimal value) {
        sonotaseisanValue = value;
        sonotaseisan = Optional.fromNullable(toCurrencyType(sonotaseisanType))
            .transform(bizCurrencyTransformer(getSonotaseisanValue()))
            .orNull();
    }

    transient private String sonotaseisanType = null;

    @Column(name=SONOTASEISAN + "$", nullable=true)
    protected String getSonotaseisanType() {
        if (sonotaseisanType == null && sonotaseisan != null) return sonotaseisan.getType().toString();
        if (sonotaseisanType == null && getSonotaseisanValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sonotaseisan$' should not be NULL."));
        }
        return sonotaseisanType;
    }

    protected void setSonotaseisanType(String type) {
        sonotaseisanType = type;
        sonotaseisan = Optional.fromNullable(toCurrencyType(sonotaseisanType))
            .transform(bizCurrencyTransformer(getSonotaseisanValue()))
            .orNull();
    }

    private BizCurrency yenkansanhaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkansanhaitoukin() {
        return yenkansanhaitoukin;
    }

    public void setYenkansanhaitoukin(BizCurrency pYenkansanhaitoukin) {
        yenkansanhaitoukin = pYenkansanhaitoukin;
        yenkansanhaitoukinValue = null;
        yenkansanhaitoukinType  = null;
    }

    transient private BigDecimal yenkansanhaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKANSANHAITOUKIN, nullable=true)
    protected BigDecimal getYenkansanhaitoukinValue() {
        if (yenkansanhaitoukinValue == null && yenkansanhaitoukin != null) {
            if (yenkansanhaitoukin.isOptional()) return null;
            return yenkansanhaitoukin.absolute();
        }
        return yenkansanhaitoukinValue;
    }

    protected void setYenkansanhaitoukinValue(BigDecimal value) {
        yenkansanhaitoukinValue = value;
        yenkansanhaitoukin = Optional.fromNullable(toCurrencyType(yenkansanhaitoukinType))
            .transform(bizCurrencyTransformer(getYenkansanhaitoukinValue()))
            .orNull();
    }

    transient private String yenkansanhaitoukinType = null;

    @Column(name=YENKANSANHAITOUKIN + "$", nullable=true)
    protected String getYenkansanhaitoukinType() {
        if (yenkansanhaitoukinType == null && yenkansanhaitoukin != null) return yenkansanhaitoukin.getType().toString();
        if (yenkansanhaitoukinType == null && getYenkansanhaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkansanhaitoukin$' should not be NULL."));
        }
        return yenkansanhaitoukinType;
    }

    protected void setYenkansanhaitoukinType(String type) {
        yenkansanhaitoukinType = type;
        yenkansanhaitoukin = Optional.fromNullable(toCurrencyType(yenkansanhaitoukinType))
            .transform(bizCurrencyTransformer(getYenkansanhaitoukinValue()))
            .orNull();
    }

    private BizCurrency yensonotahaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYensonotahaitoukin() {
        return yensonotahaitoukin;
    }

    public void setYensonotahaitoukin(BizCurrency pYensonotahaitoukin) {
        yensonotahaitoukin = pYensonotahaitoukin;
        yensonotahaitoukinValue = null;
        yensonotahaitoukinType  = null;
    }

    transient private BigDecimal yensonotahaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENSONOTAHAITOUKIN, nullable=true)
    protected BigDecimal getYensonotahaitoukinValue() {
        if (yensonotahaitoukinValue == null && yensonotahaitoukin != null) {
            if (yensonotahaitoukin.isOptional()) return null;
            return yensonotahaitoukin.absolute();
        }
        return yensonotahaitoukinValue;
    }

    protected void setYensonotahaitoukinValue(BigDecimal value) {
        yensonotahaitoukinValue = value;
        yensonotahaitoukin = Optional.fromNullable(toCurrencyType(yensonotahaitoukinType))
            .transform(bizCurrencyTransformer(getYensonotahaitoukinValue()))
            .orNull();
    }

    transient private String yensonotahaitoukinType = null;

    @Column(name=YENSONOTAHAITOUKIN + "$", nullable=true)
    protected String getYensonotahaitoukinType() {
        if (yensonotahaitoukinType == null && yensonotahaitoukin != null) return yensonotahaitoukin.getType().toString();
        if (yensonotahaitoukinType == null && getYensonotahaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yensonotahaitoukin$' should not be NULL."));
        }
        return yensonotahaitoukinType;
    }

    protected void setYensonotahaitoukinType(String type) {
        yensonotahaitoukinType = type;
        yensonotahaitoukin = Optional.fromNullable(toCurrencyType(yensonotahaitoukinType))
            .transform(bizCurrencyTransformer(getYensonotahaitoukinValue()))
            .orNull();
    }

    private BizCurrency shrtuukagstszeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtuukagstszeigk() {
        return shrtuukagstszeigk;
    }

    public void setShrtuukagstszeigk(BizCurrency pShrtuukagstszeigk) {
        shrtuukagstszeigk = pShrtuukagstszeigk;
        shrtuukagstszeigkValue = null;
        shrtuukagstszeigkType  = null;
    }

    transient private BigDecimal shrtuukagstszeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTUUKAGSTSZEIGK, nullable=true)
    protected BigDecimal getShrtuukagstszeigkValue() {
        if (shrtuukagstszeigkValue == null && shrtuukagstszeigk != null) {
            if (shrtuukagstszeigk.isOptional()) return null;
            return shrtuukagstszeigk.absolute();
        }
        return shrtuukagstszeigkValue;
    }

    protected void setShrtuukagstszeigkValue(BigDecimal value) {
        shrtuukagstszeigkValue = value;
        shrtuukagstszeigk = Optional.fromNullable(toCurrencyType(shrtuukagstszeigkType))
            .transform(bizCurrencyTransformer(getShrtuukagstszeigkValue()))
            .orNull();
    }

    transient private String shrtuukagstszeigkType = null;

    @Column(name=SHRTUUKAGSTSZEIGK + "$", nullable=true)
    protected String getShrtuukagstszeigkType() {
        if (shrtuukagstszeigkType == null && shrtuukagstszeigk != null) return shrtuukagstszeigk.getType().toString();
        if (shrtuukagstszeigkType == null && getShrtuukagstszeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtuukagstszeigk$' should not be NULL."));
        }
        return shrtuukagstszeigkType;
    }

    protected void setShrtuukagstszeigkType(String type) {
        shrtuukagstszeigkType = type;
        shrtuukagstszeigk = Optional.fromNullable(toCurrencyType(shrtuukagstszeigkType))
            .transform(bizCurrencyTransformer(getShrtuukagstszeigkValue()))
            .orNull();
    }

    private BizCurrency zitkazukarikingksiteituuka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZitkazukarikingksiteituuka() {
        return zitkazukarikingksiteituuka;
    }

    public void setZitkazukarikingksiteituuka(BizCurrency pZitkazukarikingksiteituuka) {
        zitkazukarikingksiteituuka = pZitkazukarikingksiteituuka;
        zitkazukarikingksiteituukaValue = null;
        zitkazukarikingksiteituukaType  = null;
    }

    transient private BigDecimal zitkazukarikingksiteituukaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZITKAZUKARIKINGKSITEITUUKA, nullable=true)
    protected BigDecimal getZitkazukarikingksiteituukaValue() {
        if (zitkazukarikingksiteituukaValue == null && zitkazukarikingksiteituuka != null) {
            if (zitkazukarikingksiteituuka.isOptional()) return null;
            return zitkazukarikingksiteituuka.absolute();
        }
        return zitkazukarikingksiteituukaValue;
    }

    protected void setZitkazukarikingksiteituukaValue(BigDecimal value) {
        zitkazukarikingksiteituukaValue = value;
        zitkazukarikingksiteituuka = Optional.fromNullable(toCurrencyType(zitkazukarikingksiteituukaType))
            .transform(bizCurrencyTransformer(getZitkazukarikingksiteituukaValue()))
            .orNull();
    }

    transient private String zitkazukarikingksiteituukaType = null;

    @Column(name=ZITKAZUKARIKINGKSITEITUUKA + "$", nullable=true)
    protected String getZitkazukarikingksiteituukaType() {
        if (zitkazukarikingksiteituukaType == null && zitkazukarikingksiteituuka != null) return zitkazukarikingksiteituuka.getType().toString();
        if (zitkazukarikingksiteituukaType == null && getZitkazukarikingksiteituukaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zitkazukarikingksiteituuka$' should not be NULL."));
        }
        return zitkazukarikingksiteituukaType;
    }

    protected void setZitkazukarikingksiteituukaType(String type) {
        zitkazukarikingksiteituukaType = type;
        zitkazukarikingksiteituuka = Optional.fromNullable(toCurrencyType(zitkazukarikingksiteituukaType))
            .transform(bizCurrencyTransformer(getZitkazukarikingksiteituukaValue()))
            .orNull();
    }

    private BizCurrency zitkazukarikingkyen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZitkazukarikingkyen() {
        return zitkazukarikingkyen;
    }

    public void setZitkazukarikingkyen(BizCurrency pZitkazukarikingkyen) {
        zitkazukarikingkyen = pZitkazukarikingkyen;
        zitkazukarikingkyenValue = null;
        zitkazukarikingkyenType  = null;
    }

    transient private BigDecimal zitkazukarikingkyenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZITKAZUKARIKINGKYEN, nullable=true)
    protected BigDecimal getZitkazukarikingkyenValue() {
        if (zitkazukarikingkyenValue == null && zitkazukarikingkyen != null) {
            if (zitkazukarikingkyen.isOptional()) return null;
            return zitkazukarikingkyen.absolute();
        }
        return zitkazukarikingkyenValue;
    }

    protected void setZitkazukarikingkyenValue(BigDecimal value) {
        zitkazukarikingkyenValue = value;
        zitkazukarikingkyen = Optional.fromNullable(toCurrencyType(zitkazukarikingkyenType))
            .transform(bizCurrencyTransformer(getZitkazukarikingkyenValue()))
            .orNull();
    }

    transient private String zitkazukarikingkyenType = null;

    @Column(name=ZITKAZUKARIKINGKYEN + "$", nullable=true)
    protected String getZitkazukarikingkyenType() {
        if (zitkazukarikingkyenType == null && zitkazukarikingkyen != null) return zitkazukarikingkyen.getType().toString();
        if (zitkazukarikingkyenType == null && getZitkazukarikingkyenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zitkazukarikingkyen$' should not be NULL."));
        }
        return zitkazukarikingkyenType;
    }

    protected void setZitkazukarikingkyenType(String type) {
        zitkazukarikingkyenType = type;
        zitkazukarikingkyen = Optional.fromNullable(toCurrencyType(zitkazukarikingkyenType))
            .transform(bizCurrencyTransformer(getZitkazukarikingkyenValue()))
            .orNull();
    }

    private BizCurrency kaiyakuhrknsiteituuka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakuhrknsiteituuka() {
        return kaiyakuhrknsiteituuka;
    }

    public void setKaiyakuhrknsiteituuka(BizCurrency pKaiyakuhrknsiteituuka) {
        kaiyakuhrknsiteituuka = pKaiyakuhrknsiteituuka;
        kaiyakuhrknsiteituukaValue = null;
        kaiyakuhrknsiteituukaType  = null;
    }

    transient private BigDecimal kaiyakuhrknsiteituukaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUHRKNSITEITUUKA, nullable=true)
    protected BigDecimal getKaiyakuhrknsiteituukaValue() {
        if (kaiyakuhrknsiteituukaValue == null && kaiyakuhrknsiteituuka != null) {
            if (kaiyakuhrknsiteituuka.isOptional()) return null;
            return kaiyakuhrknsiteituuka.absolute();
        }
        return kaiyakuhrknsiteituukaValue;
    }

    protected void setKaiyakuhrknsiteituukaValue(BigDecimal value) {
        kaiyakuhrknsiteituukaValue = value;
        kaiyakuhrknsiteituuka = Optional.fromNullable(toCurrencyType(kaiyakuhrknsiteituukaType))
            .transform(bizCurrencyTransformer(getKaiyakuhrknsiteituukaValue()))
            .orNull();
    }

    transient private String kaiyakuhrknsiteituukaType = null;

    @Column(name=KAIYAKUHRKNSITEITUUKA + "$", nullable=true)
    protected String getKaiyakuhrknsiteituukaType() {
        if (kaiyakuhrknsiteituukaType == null && kaiyakuhrknsiteituuka != null) return kaiyakuhrknsiteituuka.getType().toString();
        if (kaiyakuhrknsiteituukaType == null && getKaiyakuhrknsiteituukaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakuhrknsiteituuka$' should not be NULL."));
        }
        return kaiyakuhrknsiteituukaType;
    }

    protected void setKaiyakuhrknsiteituukaType(String type) {
        kaiyakuhrknsiteituukaType = type;
        kaiyakuhrknsiteituuka = Optional.fromNullable(toCurrencyType(kaiyakuhrknsiteituukaType))
            .transform(bizCurrencyTransformer(getKaiyakuhrknsiteituukaValue()))
            .orNull();
    }

    private BizCurrency kaiyakuhryen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakuhryen() {
        return kaiyakuhryen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaiyakuhryen(BizCurrency pKaiyakuhryen) {
        kaiyakuhryen = pKaiyakuhryen;
        kaiyakuhryenValue = null;
        kaiyakuhryenType  = null;
    }

    transient private BigDecimal kaiyakuhryenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUHRYEN, nullable=true)
    protected BigDecimal getKaiyakuhryenValue() {
        if (kaiyakuhryenValue == null && kaiyakuhryen != null) {
            if (kaiyakuhryen.isOptional()) return null;
            return kaiyakuhryen.absolute();
        }
        return kaiyakuhryenValue;
    }

    protected void setKaiyakuhryenValue(BigDecimal value) {
        kaiyakuhryenValue = value;
        kaiyakuhryen = Optional.fromNullable(toCurrencyType(kaiyakuhryenType))
            .transform(bizCurrencyTransformer(getKaiyakuhryenValue()))
            .orNull();
    }

    transient private String kaiyakuhryenType = null;

    @Column(name=KAIYAKUHRYEN + "$", nullable=true)
    protected String getKaiyakuhryenType() {
        if (kaiyakuhryenType == null && kaiyakuhryen != null) return kaiyakuhryen.getType().toString();
        if (kaiyakuhryenType == null && getKaiyakuhryenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakuhryen$' should not be NULL."));
        }
        return kaiyakuhryenType;
    }

    protected void setKaiyakuhryenType(String type) {
        kaiyakuhryenType = type;
        kaiyakuhryen = Optional.fromNullable(toCurrencyType(kaiyakuhryenType))
            .transform(bizCurrencyTransformer(getKaiyakuhryenValue()))
            .orNull();
    }

    private BizCurrency yenkrkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkrkgk() {
        return yenkrkgk;
    }

    public void setYenkrkgk(BizCurrency pYenkrkgk) {
        yenkrkgk = pYenkrkgk;
        yenkrkgkValue = null;
        yenkrkgkType  = null;
    }

    transient private BigDecimal yenkrkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKRKGK, nullable=true)
    protected BigDecimal getYenkrkgkValue() {
        if (yenkrkgkValue == null && yenkrkgk != null) {
            if (yenkrkgk.isOptional()) return null;
            return yenkrkgk.absolute();
        }
        return yenkrkgkValue;
    }

    protected void setYenkrkgkValue(BigDecimal value) {
        yenkrkgkValue = value;
        yenkrkgk = Optional.fromNullable(toCurrencyType(yenkrkgkType))
            .transform(bizCurrencyTransformer(getYenkrkgkValue()))
            .orNull();
    }

    transient private String yenkrkgkType = null;

    @Column(name=YENKRKGK + "$", nullable=true)
    protected String getYenkrkgkType() {
        if (yenkrkgkType == null && yenkrkgk != null) return yenkrkgk.getType().toString();
        if (yenkrkgkType == null && getYenkrkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkrkgk$' should not be NULL."));
        }
        return yenkrkgkType;
    }

    protected void setYenkrkgkType(String type) {
        yenkrkgkType = type;
        yenkrkgk = Optional.fromNullable(toCurrencyType(yenkrkgkType))
            .transform(bizCurrencyTransformer(getYenkrkgkValue()))
            .orNull();
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_PMinyuuSyoumetuInfo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_PMinyuuSyoumetuInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_PMinyuuSyoumetuInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_UriagekekkaKbn;
import yuyu.def.db.entity.HT_SkUriageData;
import yuyu.def.db.id.PKHT_SkUriageData;
import yuyu.def.db.meta.GenQHT_SkUriageData;
import yuyu.def.db.meta.QHT_SkUriageData;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_AuthoriKbn;
import yuyu.def.db.type.UserType_C_CardBrandKbn;
import yuyu.def.db.type.UserType_C_CreditUriageNgJiyuuKbn;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;
import yuyu.def.db.type.UserType_C_UriagekekkaKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約売上データテーブル テーブルのマッピング情報クラスで、 {@link HT_SkUriageData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkUriageData}</td><td colspan="3">新契約売上データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getAnsyuusyskbn ansyuusyskbn}</td><td>案内収納用システム区分</td><td align="center">{@link PKHT_SkUriageData ○}</td><td align="center">V</td><td>{@link C_AnsyuusysKbn}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKHT_SkUriageData ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_SkUriageData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAuthorikaisuu authorikaisuu}</td><td>オーソリ回数</td><td align="center">{@link PKHT_SkUriageData ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUriagegk uriagegk}</td><td>売上金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getUriageymd uriageymd}</td><td>売上日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHknsyuruino hknsyuruino}</td><td>保険種類番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknsyuruiNo}</td></tr>
 *  <tr><td>{@link #getSrsyoriymd srsyoriymd}</td><td>成立処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAuthorikbn authorikbn}</td><td>オーソリ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AuthoriKbn}</td></tr>
 *  <tr><td>{@link #getUriageseikyuutorihikicd uriageseikyuutorihikicd}</td><td>売上請求取引コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkaiinnokami6keta creditkaiinnokami6keta}</td><td>クレジット会員番号（上６桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkaiinnosimo4keta creditkaiinnosimo4keta}</td><td>クレジット会員番号（下４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCredituriagengjiyuu credituriagengjiyuu}</td><td>クレジットカード売上請求ＮＧ事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CreditUriageNgJiyuuKbn}</td></tr>
 *  <tr><td>{@link #getFukusuukameitennokey fukusuukameitennokey}</td><td>複数加盟店番号設定キー情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCardbrandkbn cardbrandkbn}</td><td>カードブランド区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CardBrandKbn}</td></tr>
 *  <tr><td>{@link #getCarddatasousinymd carddatasousinymd}</td><td>カードデータ送信日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getUriageseikyuuerrorcd uriageseikyuuerrorcd}</td><td>売上請求エラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUriagekekkakbn uriagekekkakbn}</td><td>売上結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UriagekekkaKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkUriageData
 * @see     PKHT_SkUriageData
 * @see     QHT_SkUriageData
 * @see     GenQHT_SkUriageData
 */
@MappedSuperclass
@Table(name=GenHT_SkUriageData.TABLE_NAME)
@IdClass(value=PKHT_SkUriageData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_AnsyuusysKbn", typeClass=UserType_C_AnsyuusysKbn.class),
    @TypeDef(name="UserType_C_AuthoriKbn", typeClass=UserType_C_AuthoriKbn.class),
    @TypeDef(name="UserType_C_CardBrandKbn", typeClass=UserType_C_CardBrandKbn.class),
    @TypeDef(name="UserType_C_CreditUriageNgJiyuuKbn", typeClass=UserType_C_CreditUriageNgJiyuuKbn.class),
    @TypeDef(name="UserType_C_HknsyuruiNo", typeClass=UserType_C_HknsyuruiNo.class),
    @TypeDef(name="UserType_C_UriagekekkaKbn", typeClass=UserType_C_UriagekekkaKbn.class)
})
public abstract class GenHT_SkUriageData extends AbstractExDBEntity<HT_SkUriageData, PKHT_SkUriageData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SkUriageData";
    public static final String ANSYUUSYSKBN             = "ansyuusyskbn";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String MOSNO                    = "mosno";
    public static final String AUTHORIKAISUU            = "authorikaisuu";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String URIAGEGK                 = "uriagegk";
    public static final String URIAGEYMD                = "uriageymd";
    public static final String HKNSYURUINO              = "hknsyuruino";
    public static final String SRSYORIYMD               = "srsyoriymd";
    public static final String KYKYMD                   = "kykymd";
    public static final String AUTHORIKBN               = "authorikbn";
    public static final String URIAGESEIKYUUTORIHIKICD  = "uriageseikyuutorihikicd";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String CREDITKAIINNOKAMI6KETA   = "creditkaiinnokami6keta";
    public static final String CREDITKAIINNOSIMO4KETA   = "creditkaiinnosimo4keta";
    public static final String CREDITURIAGENGJIYUU      = "credituriagengjiyuu";
    public static final String FUKUSUUKAMEITENNOKEY     = "fukusuukameitennokey";
    public static final String CARDBRANDKBN             = "cardbrandkbn";
    public static final String CARDDATASOUSINYMD        = "carddatasousinymd";
    public static final String URIAGESEIKYUUERRORCD     = "uriageseikyuuerrorcd";
    public static final String URIAGEKEKKAKBN           = "uriagekekkakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SkUriageData primaryKey;

    public GenHT_SkUriageData() {
        primaryKey = new PKHT_SkUriageData();
    }

    public GenHT_SkUriageData(
        C_AnsyuusysKbn pAnsyuusyskbn,
        BizDate pSyoriYmd,
        String pMosno,
        Integer pAuthorikaisuu
    ) {
        primaryKey = new PKHT_SkUriageData(
            pAnsyuusyskbn,
            pSyoriYmd,
            pMosno,
            pAuthorikaisuu
        );
    }

    @Transient
    @Override
    public PKHT_SkUriageData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SkUriageData> getMetaClass() {
        return QHT_SkUriageData.class;
    }

    @Id
    @Type(type="UserType_C_AnsyuusysKbn")
    @Column(name=GenHT_SkUriageData.ANSYUUSYSKBN)
    public C_AnsyuusysKbn getAnsyuusyskbn() {
        return getPrimaryKey().getAnsyuusyskbn();
    }

    public void setAnsyuusyskbn(C_AnsyuusysKbn pAnsyuusyskbn) {
        getPrimaryKey().setAnsyuusyskbn(pAnsyuusyskbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_SkUriageData.SYORIYMD)
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
    @Column(name=GenHT_SkUriageData.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Column(name=GenHT_SkUriageData.AUTHORIKAISUU)
    public Integer getAuthorikaisuu() {
        return getPrimaryKey().getAuthorikaisuu();
    }

    public void setAuthorikaisuu(Integer pAuthorikaisuu) {
        getPrimaryKey().setAuthorikaisuu(pAuthorikaisuu);
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenHT_SkUriageData.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenHT_SkUriageData.JYUTOUKAISUUM)
    @Range(min="0", max="12")
    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
    }

    private BizCurrency uriagegk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getUriagegk() {
        return uriagegk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUriagegk(BizCurrency pUriagegk) {
        uriagegk = pUriagegk;
        uriagegkValue = null;
        uriagegkType  = null;
    }

    transient private BigDecimal uriagegkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=URIAGEGK, nullable=true)
    protected BigDecimal getUriagegkValue() {
        if (uriagegkValue == null && uriagegk != null) {
            if (uriagegk.isOptional()) return null;
            return uriagegk.absolute();
        }
        return uriagegkValue;
    }

    protected void setUriagegkValue(BigDecimal value) {
        uriagegkValue = value;
        uriagegk = Optional.fromNullable(toCurrencyType(uriagegkType))
            .transform(bizCurrencyTransformer(getUriagegkValue()))
            .orNull();
    }

    transient private String uriagegkType = null;

    @Column(name=URIAGEGK + "$", nullable=true)
    protected String getUriagegkType() {
        if (uriagegkType == null && uriagegk != null) return uriagegk.getType().toString();
        if (uriagegkType == null && getUriagegkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'uriagegk$' should not be NULL."));
        }
        return uriagegkType;
    }

    protected void setUriagegkType(String type) {
        uriagegkType = type;
        uriagegk = Optional.fromNullable(toCurrencyType(uriagegkType))
            .transform(bizCurrencyTransformer(getUriagegkValue()))
            .orNull();
    }

    private BizDate uriageymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkUriageData.URIAGEYMD)
    public BizDate getUriageymd() {
        return uriageymd;
    }

    public void setUriageymd(BizDate pUriageymd) {
        uriageymd = pUriageymd;
    }

    private C_HknsyuruiNo hknsyuruino;

    @Type(type="UserType_C_HknsyuruiNo")
    @Column(name=GenHT_SkUriageData.HKNSYURUINO)
    public C_HknsyuruiNo getHknsyuruino() {
        return hknsyuruino;
    }

    public void setHknsyuruino(C_HknsyuruiNo pHknsyuruino) {
        hknsyuruino = pHknsyuruino;
    }

    private BizDate srsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkUriageData.SRSYORIYMD)
    public BizDate getSrsyoriymd() {
        return srsyoriymd;
    }

    public void setSrsyoriymd(BizDate pSrsyoriymd) {
        srsyoriymd = pSrsyoriymd;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkUriageData.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_AuthoriKbn authorikbn;

    @Type(type="UserType_C_AuthoriKbn")
    @Column(name=GenHT_SkUriageData.AUTHORIKBN)
    public C_AuthoriKbn getAuthorikbn() {
        return authorikbn;
    }

    public void setAuthorikbn(C_AuthoriKbn pAuthorikbn) {
        authorikbn = pAuthorikbn;
    }

    private String uriageseikyuutorihikicd;

    @Column(name=GenHT_SkUriageData.URIAGESEIKYUUTORIHIKICD)
    public String getUriageseikyuutorihikicd() {
        return uriageseikyuutorihikicd;
    }

    public void setUriageseikyuutorihikicd(String pUriageseikyuutorihikicd) {
        uriageseikyuutorihikicd = pUriageseikyuutorihikicd;
    }

    private String creditkessaiyouno;

    @Column(name=GenHT_SkUriageData.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

    private String creditkaiinnokami6keta;

    @Column(name=GenHT_SkUriageData.CREDITKAIINNOKAMI6KETA)
    public String getCreditkaiinnokami6keta() {
        return creditkaiinnokami6keta;
    }

    public void setCreditkaiinnokami6keta(String pCreditkaiinnokami6keta) {
        creditkaiinnokami6keta = pCreditkaiinnokami6keta;
    }

    private String creditkaiinnosimo4keta;

    @Column(name=GenHT_SkUriageData.CREDITKAIINNOSIMO4KETA)
    public String getCreditkaiinnosimo4keta() {
        return creditkaiinnosimo4keta;
    }

    public void setCreditkaiinnosimo4keta(String pCreditkaiinnosimo4keta) {
        creditkaiinnosimo4keta = pCreditkaiinnosimo4keta;
    }

    private C_CreditUriageNgJiyuuKbn credituriagengjiyuu;

    @Type(type="UserType_C_CreditUriageNgJiyuuKbn")
    @Column(name=GenHT_SkUriageData.CREDITURIAGENGJIYUU)
    public C_CreditUriageNgJiyuuKbn getCredituriagengjiyuu() {
        return credituriagengjiyuu;
    }

    public void setCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn pCredituriagengjiyuu) {
        credituriagengjiyuu = pCredituriagengjiyuu;
    }

    private String fukusuukameitennokey;

    @Column(name=GenHT_SkUriageData.FUKUSUUKAMEITENNOKEY)
    public String getFukusuukameitennokey() {
        return fukusuukameitennokey;
    }

    public void setFukusuukameitennokey(String pFukusuukameitennokey) {
        fukusuukameitennokey = pFukusuukameitennokey;
    }

    private C_CardBrandKbn cardbrandkbn;

    @Type(type="UserType_C_CardBrandKbn")
    @Column(name=GenHT_SkUriageData.CARDBRANDKBN)
    public C_CardBrandKbn getCardbrandkbn() {
        return cardbrandkbn;
    }

    public void setCardbrandkbn(C_CardBrandKbn pCardbrandkbn) {
        cardbrandkbn = pCardbrandkbn;
    }

    private BizDate carddatasousinymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkUriageData.CARDDATASOUSINYMD)
    public BizDate getCarddatasousinymd() {
        return carddatasousinymd;
    }

    public void setCarddatasousinymd(BizDate pCarddatasousinymd) {
        carddatasousinymd = pCarddatasousinymd;
    }

    private String uriageseikyuuerrorcd;

    @Column(name=GenHT_SkUriageData.URIAGESEIKYUUERRORCD)
    public String getUriageseikyuuerrorcd() {
        return uriageseikyuuerrorcd;
    }

    public void setUriageseikyuuerrorcd(String pUriageseikyuuerrorcd) {
        uriageseikyuuerrorcd = pUriageseikyuuerrorcd;
    }

    private C_UriagekekkaKbn uriagekekkakbn;

    @Type(type="UserType_C_UriagekekkaKbn")
    @Column(name=GenHT_SkUriageData.URIAGEKEKKAKBN)
    public C_UriagekekkaKbn getUriagekekkakbn() {
        return uriagekekkakbn;
    }

    public void setUriagekekkakbn(C_UriagekekkaKbn pUriagekekkakbn) {
        uriagekekkakbn = pUriagekekkakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenHT_SkUriageData.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SkUriageData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SkUriageData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
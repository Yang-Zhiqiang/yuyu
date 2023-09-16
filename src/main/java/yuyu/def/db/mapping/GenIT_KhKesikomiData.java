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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_CreditcardHrKskmKbn;
import yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NyuuryokuKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.IT_KhKesikomiData;
import yuyu.def.db.id.PKIT_KhKesikomiData;
import yuyu.def.db.meta.GenQIT_KhKesikomiData;
import yuyu.def.db.meta.QIT_KhKesikomiData;
import yuyu.def.db.type.UserType_C_CreditcardHrKskmKbn;
import yuyu.def.db.type.UserType_C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_NyuuryokuKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 消込データテーブル テーブルのマッピング情報クラスで、 {@link IT_KhKesikomiData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhKesikomiData}</td><td colspan="3">消込データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KhKesikomiData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyuukinkakusyouno nyuukinkakusyouno}</td><td>入金確証番号</td><td align="center">{@link PKIT_KhKesikomiData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhKesikomiData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr><td>{@link #getNyuuryokukbn nyuuryokukbn}</td><td>入力区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyuuryokuKbn}</td></tr>
 *  <tr><td>{@link #getNykkeiro nykkeiro}</td><td>入金経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nykkeiro}</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getNyuukinkakusyounrkymd nyuukinkakusyounrkymd}</td><td>入金確証入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRsgaku rsgaku}</td><td>領収金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNykdenymd nykdenymd}</td><td>入金伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNyuukinkakusyounrkno nyuukinkakusyounrkno}</td><td>入金確証入力番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTaisyakukbn taisyakukbn}</td><td>貸借区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TaisyakuKbn}</td></tr>
 *  <tr><td>{@link #getSuitono suitono}</td><td>出納番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSuitoubumoncd suitoubumoncd}</td><td>出納部門コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKarikanjyono karikanjyono}</td><td>仮勘定番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaebankcd kzhurikaebankcd}</td><td>口座振替銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmyousinkkbn hrkmyousinkkbn}</td><td>振込用紙入金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KrkPayEasyHrkmyousiNkKbn}</td></tr>
 *  <tr><td>{@link #getSuitososhikicd suitososhikicd}</td><td>出納組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardhrkskmkbn creditcardhrkskmkbn}</td><td>クレ払消込区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CreditcardHrKskmKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyuudaikocd syuudaikocd}</td><td>収納代行社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syuudaikocd}</td></tr>
 * </table>
 * @see     IT_KhKesikomiData
 * @see     PKIT_KhKesikomiData
 * @see     QIT_KhKesikomiData
 * @see     GenQIT_KhKesikomiData
 */
@MappedSuperclass
@Table(name=GenIT_KhKesikomiData.TABLE_NAME)
@IdClass(value=PKIT_KhKesikomiData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_CreditcardHrKskmKbn", typeClass=UserType_C_CreditcardHrKskmKbn.class),
    @TypeDef(name="UserType_C_KrkPayEasyHrkmyousiNkKbn", typeClass=UserType_C_KrkPayEasyHrkmyousiNkKbn.class),
    @TypeDef(name="UserType_C_Nykkeiro", typeClass=UserType_C_Nykkeiro.class),
    @TypeDef(name="UserType_C_NyknaiyouKbn", typeClass=UserType_C_NyknaiyouKbn.class),
    @TypeDef(name="UserType_C_NyuuryokuKbn", typeClass=UserType_C_NyuuryokuKbn.class),
    @TypeDef(name="UserType_C_Syuudaikocd", typeClass=UserType_C_Syuudaikocd.class),
    @TypeDef(name="UserType_C_TaisyakuKbn", typeClass=UserType_C_TaisyakuKbn.class)
})
public abstract class GenIT_KhKesikomiData extends AbstractExDBEntity<IT_KhKesikomiData, PKIT_KhKesikomiData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhKesikomiData";
    public static final String KBNKEY                   = "kbnkey";
    public static final String NYUUKINKAKUSYOUNO        = "nyuukinkakusyouno";
    public static final String SYONO                    = "syono";
    public static final String NYKNAIYOUKBN             = "nyknaiyoukbn";
    public static final String NYUURYOKUKBN             = "nyuuryokukbn";
    public static final String NYKKEIRO                 = "nykkeiro";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String NYUUKINKAKUSYOUNRKYMD    = "nyuukinkakusyounrkymd";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String RSGAKU                   = "rsgaku";
    public static final String NYKDENYMD                = "nykdenymd";
    public static final String NYUUKINKAKUSYOUNRKNO     = "nyuukinkakusyounrkno";
    public static final String TAISYAKUKBN              = "taisyakukbn";
    public static final String SUITONO                  = "suitono";
    public static final String SUITOUBUMONCD            = "suitoubumoncd";
    public static final String KARIKANJYONO             = "karikanjyono";
    public static final String KZHURIKAEBANKCD          = "kzhurikaebankcd";
    public static final String HRKMYOUSINKKBN           = "hrkmyousinkkbn";
    public static final String SUITOSOSHIKICD           = "suitososhikicd";
    public static final String CREDITCARDHRKSKMKBN      = "creditcardhrkskmkbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String SYUUDAIKOCD              = "syuudaikocd";

    private final PKIT_KhKesikomiData primaryKey;

    public GenIT_KhKesikomiData() {
        primaryKey = new PKIT_KhKesikomiData();
    }

    public GenIT_KhKesikomiData(
        String pKbnkey,
        String pNyuukinkakusyouno,
        String pSyono
    ) {
        primaryKey = new PKIT_KhKesikomiData(
            pKbnkey,
            pNyuukinkakusyouno,
            pSyono
        );
    }

    @Transient
    @Override
    public PKIT_KhKesikomiData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhKesikomiData> getMetaClass() {
        return QIT_KhKesikomiData.class;
    }

    @Id
    @Column(name=GenIT_KhKesikomiData.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KhKesikomiData.NYUUKINKAKUSYOUNO)
    public String getNyuukinkakusyouno() {
        return getPrimaryKey().getNyuukinkakusyouno();
    }

    public void setNyuukinkakusyouno(String pNyuukinkakusyouno) {
        getPrimaryKey().setNyuukinkakusyouno(pNyuukinkakusyouno);
    }

    @Id
    @Column(name=GenIT_KhKesikomiData.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private C_NyknaiyouKbn nyknaiyoukbn;

    @Type(type="UserType_C_NyknaiyouKbn")
    @Column(name=GenIT_KhKesikomiData.NYKNAIYOUKBN)
    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        nyknaiyoukbn = pNyknaiyoukbn;
    }

    private C_NyuuryokuKbn nyuuryokukbn;

    @Type(type="UserType_C_NyuuryokuKbn")
    @Column(name=GenIT_KhKesikomiData.NYUURYOKUKBN)
    public C_NyuuryokuKbn getNyuuryokukbn() {
        return nyuuryokukbn;
    }

    public void setNyuuryokukbn(C_NyuuryokuKbn pNyuuryokukbn) {
        nyuuryokukbn = pNyuuryokukbn;
    }

    private C_Nykkeiro nykkeiro;

    @Type(type="UserType_C_Nykkeiro")
    @Column(name=GenIT_KhKesikomiData.NYKKEIRO)
    public C_Nykkeiro getNykkeiro() {
        return nykkeiro;
    }

    public void setNykkeiro(C_Nykkeiro pNykkeiro) {
        nykkeiro = pNykkeiro;
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KhKesikomiData.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private BizDate nyuukinkakusyounrkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhKesikomiData.NYUUKINKAKUSYOUNRKYMD)
    public BizDate getNyuukinkakusyounrkymd() {
        return nyuukinkakusyounrkymd;
    }

    public void setNyuukinkakusyounrkymd(BizDate pNyuukinkakusyounrkymd) {
        nyuukinkakusyounrkymd = pNyuukinkakusyounrkymd;
    }

    private BizDate ryosyuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhKesikomiData.RYOSYUYMD)
    @ValidDate
    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private BizCurrency rsgaku;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getRsgaku() {
        return rsgaku;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRsgaku(BizCurrency pRsgaku) {
        rsgaku = pRsgaku;
        rsgakuValue = null;
        rsgakuType  = null;
    }

    transient private BigDecimal rsgakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=RSGAKU, nullable=true)
    protected BigDecimal getRsgakuValue() {
        if (rsgakuValue == null && rsgaku != null) {
            if (rsgaku.isOptional()) return null;
            return rsgaku.absolute();
        }
        return rsgakuValue;
    }

    protected void setRsgakuValue(BigDecimal value) {
        rsgakuValue = value;
        rsgaku = Optional.fromNullable(toCurrencyType(rsgakuType))
            .transform(bizCurrencyTransformer(getRsgakuValue()))
            .orNull();
    }

    transient private String rsgakuType = null;

    @Column(name=RSGAKU + "$", nullable=true)
    protected String getRsgakuType() {
        if (rsgakuType == null && rsgaku != null) return rsgaku.getType().toString();
        if (rsgakuType == null && getRsgakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rsgaku$' should not be NULL."));
        }
        return rsgakuType;
    }

    protected void setRsgakuType(String type) {
        rsgakuType = type;
        rsgaku = Optional.fromNullable(toCurrencyType(rsgakuType))
            .transform(bizCurrencyTransformer(getRsgakuValue()))
            .orNull();
    }

    private BizDate nykdenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhKesikomiData.NYKDENYMD)
    public BizDate getNykdenymd() {
        return nykdenymd;
    }

    public void setNykdenymd(BizDate pNykdenymd) {
        nykdenymd = pNykdenymd;
    }

    private String nyuukinkakusyounrkno;

    @Column(name=GenIT_KhKesikomiData.NYUUKINKAKUSYOUNRKNO)
    public String getNyuukinkakusyounrkno() {
        return nyuukinkakusyounrkno;
    }

    public void setNyuukinkakusyounrkno(String pNyuukinkakusyounrkno) {
        nyuukinkakusyounrkno = pNyuukinkakusyounrkno;
    }

    private C_TaisyakuKbn taisyakukbn;

    @Type(type="UserType_C_TaisyakuKbn")
    @Column(name=GenIT_KhKesikomiData.TAISYAKUKBN)
    public C_TaisyakuKbn getTaisyakukbn() {
        return taisyakukbn;
    }

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        taisyakukbn = pTaisyakukbn;
    }

    private String suitono;

    @Column(name=GenIT_KhKesikomiData.SUITONO)
    @Length(length=2)
    @Digit
    public String getSuitono() {
        return suitono;
    }

    public void setSuitono(String pSuitono) {
        suitono = pSuitono;
    }

    private String suitoubumoncd;

    @Column(name=GenIT_KhKesikomiData.SUITOUBUMONCD)
    public String getSuitoubumoncd() {
        return suitoubumoncd;
    }

    public void setSuitoubumoncd(String pSuitoubumoncd) {
        suitoubumoncd = pSuitoubumoncd;
    }

    private String karikanjyono;

    @Column(name=GenIT_KhKesikomiData.KARIKANJYONO)
    public String getKarikanjyono() {
        return karikanjyono;
    }

    public void setKarikanjyono(String pKarikanjyono) {
        karikanjyono = pKarikanjyono;
    }

    private String kzhurikaebankcd;

    @Column(name=GenIT_KhKesikomiData.KZHURIKAEBANKCD)
    @Length(length=4)
    @Digit
    public String getKzhurikaebankcd() {
        return kzhurikaebankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKzhurikaebankcd(String pKzhurikaebankcd) {
        kzhurikaebankcd = pKzhurikaebankcd;
    }

    private C_KrkPayEasyHrkmyousiNkKbn hrkmyousinkkbn;

    @Type(type="UserType_C_KrkPayEasyHrkmyousiNkKbn")
    @Column(name=GenIT_KhKesikomiData.HRKMYOUSINKKBN)
    public C_KrkPayEasyHrkmyousiNkKbn getHrkmyousinkkbn() {
        return hrkmyousinkkbn;
    }

    public void setHrkmyousinkkbn(C_KrkPayEasyHrkmyousiNkKbn pHrkmyousinkkbn) {
        hrkmyousinkkbn = pHrkmyousinkkbn;
    }

    private String suitososhikicd;

    @Column(name=GenIT_KhKesikomiData.SUITOSOSHIKICD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getSuitososhikicd() {
        return suitososhikicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSuitososhikicd(String pSuitososhikicd) {
        suitososhikicd = pSuitososhikicd;
    }

    private C_CreditcardHrKskmKbn creditcardhrkskmkbn;

    @Type(type="UserType_C_CreditcardHrKskmKbn")
    @Column(name=GenIT_KhKesikomiData.CREDITCARDHRKSKMKBN)
    public C_CreditcardHrKskmKbn getCreditcardhrkskmkbn() {
        return creditcardhrkskmkbn;
    }

    public void setCreditcardhrkskmkbn(C_CreditcardHrKskmKbn pCreditcardhrkskmkbn) {
        creditcardhrkskmkbn = pCreditcardhrkskmkbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhKesikomiData.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhKesikomiData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhKesikomiData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_Syuudaikocd syuudaikocd;

    @Type(type="UserType_C_Syuudaikocd")
    @Column(name=GenIT_KhKesikomiData.SYUUDAIKOCD)
    public C_Syuudaikocd getSyuudaikocd() {
        return syuudaikocd;
    }

    public void setSyuudaikocd(C_Syuudaikocd pSyuudaikocd) {
        syuudaikocd = pSyuudaikocd;
    }
}
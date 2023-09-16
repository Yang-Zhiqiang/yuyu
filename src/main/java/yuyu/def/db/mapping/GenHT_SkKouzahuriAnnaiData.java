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
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_SyuyakukyohiKbn;
import yuyu.def.classification.C_TratkidrtenKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_SkKouzahuriAnnaiData;
import yuyu.def.db.id.PKHT_SkKouzahuriAnnaiData;
import yuyu.def.db.meta.GenQHT_SkKouzahuriAnnaiData;
import yuyu.def.db.meta.QHT_SkKouzahuriAnnaiData;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_SinkeizkKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_SyuyakukyohiKbn;
import yuyu.def.db.type.UserType_C_TratkidrtenKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約口座振替案内データテーブル テーブルのマッピング情報クラスで、 {@link HT_SkKouzahuriAnnaiData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkKouzahuriAnnaiData}</td><td colspan="3">新契約口座振替案内データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getAnsyuusyskbn ansyuusyskbn}</td><td>案内収納用システム区分</td><td align="center">{@link PKHT_SkKouzahuriAnnaiData ○}</td><td align="center">V</td><td>{@link C_AnsyuusysKbn}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKHT_SkKouzahuriAnnaiData ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_SkKouzahuriAnnaiData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">{@link PKHT_SkKouzahuriAnnaiData ○}</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">{@link PKHT_SkKouzahuriAnnaiData ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyutoukaisuuy jyutoukaisuuy}</td><td>充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRsgaku rsgaku}</td><td>領収金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHurikaeymd hurikaeymd}</td><td>振替日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyuudaikocd syuudaikocd}</td><td>収納代行社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syuudaikocd}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSinkeizkkbn sinkeizkkbn}</td><td>新規継続区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SinkeizkKbn}</td></tr>
 *  <tr><td>{@link #getSyuyakukyohikbn syuyakukyohikbn}</td><td>集約拒否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyuyakukyohiKbn}</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaimosno daimosno}</td><td>代表申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyuruicd hknsyuruicd}</td><td>保険種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknkaisyacd hknkaisyacd}</td><td>保険会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTratkidrtenkbn tratkidrtenkbn}</td><td>取扱代理店区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TratkidrtenKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkKouzahuriAnnaiData
 * @see     PKHT_SkKouzahuriAnnaiData
 * @see     QHT_SkKouzahuriAnnaiData
 * @see     GenQHT_SkKouzahuriAnnaiData
 */
@MappedSuperclass
@Table(name=GenHT_SkKouzahuriAnnaiData.TABLE_NAME)
@IdClass(value=PKHT_SkKouzahuriAnnaiData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_AnsyuusysKbn", typeClass=UserType_C_AnsyuusysKbn.class),
    @TypeDef(name="UserType_C_NyknaiyouKbn", typeClass=UserType_C_NyknaiyouKbn.class),
    @TypeDef(name="UserType_C_SinkeizkKbn", typeClass=UserType_C_SinkeizkKbn.class),
    @TypeDef(name="UserType_C_Syuudaikocd", typeClass=UserType_C_Syuudaikocd.class),
    @TypeDef(name="UserType_C_SyuyakukyohiKbn", typeClass=UserType_C_SyuyakukyohiKbn.class),
    @TypeDef(name="UserType_C_TratkidrtenKbn", typeClass=UserType_C_TratkidrtenKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenHT_SkKouzahuriAnnaiData extends AbstractExDBEntity<HT_SkKouzahuriAnnaiData, PKHT_SkKouzahuriAnnaiData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SkKouzahuriAnnaiData";
    public static final String ANSYUUSYSKBN             = "ansyuusyskbn";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String MOSNO                    = "mosno";
    public static final String NYKNAIYOUKBN             = "nyknaiyoukbn";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String JYUTOUKAISUUY            = "jyutoukaisuuy";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String RSGAKU                   = "rsgaku";
    public static final String HURIKAEYMD               = "hurikaeymd";
    public static final String SYUUDAIKOCD              = "syuudaikocd";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String SINKEIZKKBN              = "sinkeizkkbn";
    public static final String SYUYAKUKYOHIKBN          = "syuyakukyohikbn";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String DAIMOSNO                 = "daimosno";
    public static final String HKNSYURUICD              = "hknsyuruicd";
    public static final String HKNKAISYACD              = "hknkaisyacd";
    public static final String TRATKIDRTENKBN           = "tratkidrtenkbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SkKouzahuriAnnaiData primaryKey;

    public GenHT_SkKouzahuriAnnaiData() {
        primaryKey = new PKHT_SkKouzahuriAnnaiData();
    }

    public GenHT_SkKouzahuriAnnaiData(
        C_AnsyuusysKbn pAnsyuusyskbn,
        BizDate pSyoriYmd,
        String pMosno,
        C_NyknaiyouKbn pNyknaiyoukbn,
        BizDateYM pJyuutouym
    ) {
        primaryKey = new PKHT_SkKouzahuriAnnaiData(
            pAnsyuusyskbn,
            pSyoriYmd,
            pMosno,
            pNyknaiyoukbn,
            pJyuutouym
        );
    }

    @Transient
    @Override
    public PKHT_SkKouzahuriAnnaiData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SkKouzahuriAnnaiData> getMetaClass() {
        return QHT_SkKouzahuriAnnaiData.class;
    }

    @Id
    @Type(type="UserType_C_AnsyuusysKbn")
    @Column(name=GenHT_SkKouzahuriAnnaiData.ANSYUUSYSKBN)
    public C_AnsyuusysKbn getAnsyuusyskbn() {
        return getPrimaryKey().getAnsyuusyskbn();
    }

    public void setAnsyuusyskbn(C_AnsyuusysKbn pAnsyuusyskbn) {
        getPrimaryKey().setAnsyuusyskbn(pAnsyuusyskbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_SkKouzahuriAnnaiData.SYORIYMD)
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
    @Column(name=GenHT_SkKouzahuriAnnaiData.MOSNO)
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
    @Type(type="UserType_C_NyknaiyouKbn")
    @Column(name=GenHT_SkKouzahuriAnnaiData.NYKNAIYOUKBN)
    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return getPrimaryKey().getNyknaiyoukbn();
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        getPrimaryKey().setNyknaiyoukbn(pNyknaiyoukbn);
    }

    @Id
    @Type(type="BizDateYMType")
    @Column(name=GenHT_SkKouzahuriAnnaiData.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return getPrimaryKey().getJyuutouym();
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        getPrimaryKey().setJyuutouym(pJyuutouym);
    }

    private Integer jyutoukaisuuy;

    @Column(name=GenHT_SkKouzahuriAnnaiData.JYUTOUKAISUUY)
    @Range(min="0", max="99")
    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenHT_SkKouzahuriAnnaiData.JYUTOUKAISUUM)
    @Range(min="0", max="12")
    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
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

    private BizDate hurikaeymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkKouzahuriAnnaiData.HURIKAEYMD)
    public BizDate getHurikaeymd() {
        return hurikaeymd;
    }

    public void setHurikaeymd(BizDate pHurikaeymd) {
        hurikaeymd = pHurikaeymd;
    }

    private C_Syuudaikocd syuudaikocd;

    @Type(type="UserType_C_Syuudaikocd")
    @Column(name=GenHT_SkKouzahuriAnnaiData.SYUUDAIKOCD)
    public C_Syuudaikocd getSyuudaikocd() {
        return syuudaikocd;
    }

    public void setSyuudaikocd(C_Syuudaikocd pSyuudaikocd) {
        syuudaikocd = pSyuudaikocd;
    }

    private String bankcd;

    @Column(name=GenHT_SkKouzahuriAnnaiData.BANKCD)
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

    private String sitencd;

    @Column(name=GenHT_SkKouzahuriAnnaiData.SITENCD)
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

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenHT_SkKouzahuriAnnaiData.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenHT_SkKouzahuriAnnaiData.KOUZANO)
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

    private String kzmeiginmkn;

    @Column(name=GenHT_SkKouzahuriAnnaiData.KZMEIGINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private C_SinkeizkKbn sinkeizkkbn;

    @Type(type="UserType_C_SinkeizkKbn")
    @Column(name=GenHT_SkKouzahuriAnnaiData.SINKEIZKKBN)
    public C_SinkeizkKbn getSinkeizkkbn() {
        return sinkeizkkbn;
    }

    public void setSinkeizkkbn(C_SinkeizkKbn pSinkeizkkbn) {
        sinkeizkkbn = pSinkeizkkbn;
    }

    private C_SyuyakukyohiKbn syuyakukyohikbn;

    @Type(type="UserType_C_SyuyakukyohiKbn")
    @Column(name=GenHT_SkKouzahuriAnnaiData.SYUYAKUKYOHIKBN)
    public C_SyuyakukyohiKbn getSyuyakukyohikbn() {
        return syuyakukyohikbn;
    }

    public void setSyuyakukyohikbn(C_SyuyakukyohiKbn pSyuyakukyohikbn) {
        syuyakukyohikbn = pSyuyakukyohikbn;
    }

    private String kyknmkn;

    @Column(name=GenHT_SkKouzahuriAnnaiData.KYKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    private String daimosno;

    @Column(name=GenHT_SkKouzahuriAnnaiData.DAIMOSNO)
    @MousikomiNo
    public String getDaimosno() {
        return daimosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDaimosno(String pDaimosno) {
        daimosno = pDaimosno;
    }

    private String hknsyuruicd;

    @Column(name=GenHT_SkKouzahuriAnnaiData.HKNSYURUICD)
    public String getHknsyuruicd() {
        return hknsyuruicd;
    }

    public void setHknsyuruicd(String pHknsyuruicd) {
        hknsyuruicd = pHknsyuruicd;
    }

    private String hknkaisyacd;

    @Column(name=GenHT_SkKouzahuriAnnaiData.HKNKAISYACD)
    public String getHknkaisyacd() {
        return hknkaisyacd;
    }

    public void setHknkaisyacd(String pHknkaisyacd) {
        hknkaisyacd = pHknkaisyacd;
    }

    private C_TratkidrtenKbn tratkidrtenkbn;

    @Type(type="UserType_C_TratkidrtenKbn")
    @Column(name=GenHT_SkKouzahuriAnnaiData.TRATKIDRTENKBN)
    public C_TratkidrtenKbn getTratkidrtenkbn() {
        return tratkidrtenkbn;
    }

    public void setTratkidrtenkbn(C_TratkidrtenKbn pTratkidrtenkbn) {
        tratkidrtenkbn = pTratkidrtenkbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenHT_SkKouzahuriAnnaiData.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SkKouzahuriAnnaiData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SkKouzahuriAnnaiData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
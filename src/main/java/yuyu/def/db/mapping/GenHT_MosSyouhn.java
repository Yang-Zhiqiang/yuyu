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
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.id.PKHT_MosSyouhn;
import yuyu.def.db.meta.GenQHT_MosSyouhn;
import yuyu.def.db.meta.QHT_MosSyouhn;
import yuyu.def.db.type.UserType_C_6daiLdKbn;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_HrkkknsmnKbn;
import yuyu.def.db.type.UserType_C_KataKbn;
import yuyu.def.db.type.UserType_C_KhnkyhkgbairituKbn;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;
import yuyu.def.db.type.UserType_C_Sknenkinsyu;
import yuyu.def.db.type.UserType_C_SyukyhkinkataKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 申込商品テーブル テーブルのマッピング情報クラスで、 {@link HT_MosSyouhn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_MosSyouhn}</td><td colspan="3">申込商品テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_MosSyouhn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKHT_MosSyouhn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getYoteiriritu yoteiriritu}</td><td>予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSknenkinsyu sknenkinsyu}</td><td>新契約年金種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sknenkinsyu}</td></tr>
 *  <tr><td>{@link #getKihons kihons}</td><td>基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSeitoukihons seitoukihons}</td><td>正当基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyutkp syutkp}</td><td>主契約・特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrktuukasyutkp hrktuukasyutkp}</td><td>申込主契約・特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTkjyp tkjyp}</td><td>特条保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKatakbn katakbn}</td><td>型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getKyhkatakbn kyhkatakbn}</td><td>給付型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getSyukyhkinkatakbn syukyhkinkatakbn}</td><td>手術給付金型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>{@link #getKhnkyhkgbairitukbn khnkyhkgbairitukbn}</td><td>基本給付金額倍率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KhnkyhkgbairituKbn}</td></tr>
 *  <tr><td>{@link #getRokudaildkbn rokudaildkbn}</td><td>６大生活習慣病追加給付型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_6daiLdKbn}</td></tr>
 *  <tr><td>{@link #getHknkkn hknkkn}</td><td>保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkkn hrkkkn}</td><td>払込期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn hknkknsmnkbn}</td><td>保険期間歳満期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbn hrkkknsmnkbn}</td><td>払込期間歳満期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getDai1hknkkn dai1hknkkn}</td><td>第１保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTumitateriritu tumitateriritu}</td><td>積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTmttknzoukaritujygn tmttknzoukaritujygn}</td><td>積立金増加率上限</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSetteibairitu setteibairitu}</td><td>設定倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRendouritu rendouritu}</td><td>連動率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTeikisiharaikin teikisiharaikin}</td><td>定期支払金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLoadinghnkgtumitateriritu loadinghnkgtumitateriritu}</td><td>ローディング変更後積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKihons2 kihons2}</td><td>基本Ｓ_2</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrktuukasyutkp2 hrktuukasyutkp2}</td><td>払込通貨主契約・特約Ｐ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_MosSyouhn
 * @see     PKHT_MosSyouhn
 * @see     QHT_MosSyouhn
 * @see     GenQHT_MosSyouhn
 */
@MappedSuperclass
@Table(name=GenHT_MosSyouhn.TABLE_NAME)
@IdClass(value=PKHT_MosSyouhn.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_6daiLdKbn", typeClass=UserType_C_6daiLdKbn.class),
    @TypeDef(name="UserType_C_HknkknsmnKbn", typeClass=UserType_C_HknkknsmnKbn.class),
    @TypeDef(name="UserType_C_HrkkknsmnKbn", typeClass=UserType_C_HrkkknsmnKbn.class),
    @TypeDef(name="UserType_C_KataKbn", typeClass=UserType_C_KataKbn.class),
    @TypeDef(name="UserType_C_KhnkyhkgbairituKbn", typeClass=UserType_C_KhnkyhkgbairituKbn.class),
    @TypeDef(name="UserType_C_KyhgndkataKbn", typeClass=UserType_C_KyhgndkataKbn.class),
    @TypeDef(name="UserType_C_Sknenkinsyu", typeClass=UserType_C_Sknenkinsyu.class),
    @TypeDef(name="UserType_C_SyukyhkinkataKbn", typeClass=UserType_C_SyukyhkinkataKbn.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class)
})
public abstract class GenHT_MosSyouhn extends AbstractExDBEntity<HT_MosSyouhn, PKHT_MosSyouhn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_MosSyouhn";
    public static final String MOSNO                    = "mosno";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String SYUTKKBN                 = "syutkkbn";
    public static final String YOTEIRIRITU              = "yoteiriritu";
    public static final String SKNENKINSYU              = "sknenkinsyu";
    public static final String KIHONS                   = "kihons";
    public static final String SEITOUKIHONS             = "seitoukihons";
    public static final String SYUTKP                   = "syutkp";
    public static final String HRKTUUKASYUTKP           = "hrktuukasyutkp";
    public static final String TKJYP                    = "tkjyp";
    public static final String KATAKBN                  = "katakbn";
    public static final String KYHKATAKBN               = "kyhkatakbn";
    public static final String SYUKYHKINKATAKBN         = "syukyhkinkatakbn";
    public static final String KHNKYHKGBAIRITUKBN       = "khnkyhkgbairitukbn";
    public static final String ROKUDAILDKBN             = "rokudaildkbn";
    public static final String HKNKKN                   = "hknkkn";
    public static final String HRKKKN                   = "hrkkkn";
    public static final String HKNKKNSMNKBN             = "hknkknsmnkbn";
    public static final String HRKKKNSMNKBN             = "hrkkknsmnkbn";
    public static final String DAI1HKNKKN               = "dai1hknkkn";
    public static final String TUMITATERIRITU           = "tumitateriritu";
    public static final String TMTTKNZOUKARITUJYGN      = "tmttknzoukaritujygn";
    public static final String SETTEIBAIRITU            = "setteibairitu";
    public static final String RENDOURITU               = "rendouritu";
    public static final String TEIKISIHARAIKIN          = "teikisiharaikin";
    public static final String LOADINGHNKGTUMITATERIRITU = "loadinghnkgtumitateriritu";
    public static final String KIHONS2                  = "kihons2";
    public static final String HRKTUUKASYUTKP2          = "hrktuukasyutkp2";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_MosSyouhn primaryKey;

    public GenHT_MosSyouhn() {
        primaryKey = new PKHT_MosSyouhn();
    }

    public GenHT_MosSyouhn(String pMosno, String pSyouhncd) {
        primaryKey = new PKHT_MosSyouhn(pMosno, pSyouhncd);
    }

    @Transient
    @Override
    public PKHT_MosSyouhn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_MosSyouhn> getMetaClass() {
        return QHT_MosSyouhn.class;
    }

    @Id
    @Column(name=GenHT_MosSyouhn.MOSNO)
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
    @Column(name=GenHT_MosSyouhn.SYOUHNCD)
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

    private Integer syouhnsdno;

    @Column(name=GenHT_MosSyouhn.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private String ryouritusdno;

    @Column(name=GenHT_MosSyouhn.RYOURITUSDNO)
    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }

    private C_SyutkKbn syutkkbn;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenHT_MosSyouhn.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }

    private BizNumber yoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenHT_MosSyouhn.YOTEIRIRITU)
    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYoteiriritu(BizNumber pYoteiriritu) {
        yoteiriritu = pYoteiriritu;
    }

    private C_Sknenkinsyu sknenkinsyu;

    @Type(type="UserType_C_Sknenkinsyu")
    @Column(name=GenHT_MosSyouhn.SKNENKINSYU)
    public C_Sknenkinsyu getSknenkinsyu() {
        return sknenkinsyu;
    }

    public void setSknenkinsyu(C_Sknenkinsyu pSknenkinsyu) {
        sknenkinsyu = pSknenkinsyu;
    }

    private BizCurrency kihons;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    public BizCurrency getKihons() {
        return kihons;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons(BizCurrency pKihons) {
        kihons = pKihons;
        kihonsValue = null;
        kihonsType  = null;
    }

    transient private BigDecimal kihonsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS, nullable=true)
    protected BigDecimal getKihonsValue() {
        if (kihonsValue == null && kihons != null) {
            if (kihons.isOptional()) return null;
            return kihons.absolute();
        }
        return kihonsValue;
    }

    protected void setKihonsValue(BigDecimal value) {
        kihonsValue = value;
        kihons = Optional.fromNullable(toCurrencyType(kihonsType))
            .transform(bizCurrencyTransformer(getKihonsValue()))
            .orNull();
    }

    transient private String kihonsType = null;

    @Column(name=KIHONS + "$", nullable=true)
    protected String getKihonsType() {
        if (kihonsType == null && kihons != null) return kihons.getType().toString();
        if (kihonsType == null && getKihonsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons$' should not be NULL."));
        }
        return kihonsType;
    }

    protected void setKihonsType(String type) {
        kihonsType = type;
        kihons = Optional.fromNullable(toCurrencyType(kihonsType))
            .transform(bizCurrencyTransformer(getKihonsValue()))
            .orNull();
    }

    private BizCurrency seitoukihons;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSeitoukihons() {
        return seitoukihons;
    }

    public void setSeitoukihons(BizCurrency pSeitoukihons) {
        seitoukihons = pSeitoukihons;
        seitoukihonsValue = null;
        seitoukihonsType  = null;
    }

    transient private BigDecimal seitoukihonsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SEITOUKIHONS, nullable=true)
    protected BigDecimal getSeitoukihonsValue() {
        if (seitoukihonsValue == null && seitoukihons != null) {
            if (seitoukihons.isOptional()) return null;
            return seitoukihons.absolute();
        }
        return seitoukihonsValue;
    }

    protected void setSeitoukihonsValue(BigDecimal value) {
        seitoukihonsValue = value;
        seitoukihons = Optional.fromNullable(toCurrencyType(seitoukihonsType))
            .transform(bizCurrencyTransformer(getSeitoukihonsValue()))
            .orNull();
    }

    transient private String seitoukihonsType = null;

    @Column(name=SEITOUKIHONS + "$", nullable=true)
    protected String getSeitoukihonsType() {
        if (seitoukihonsType == null && seitoukihons != null) return seitoukihons.getType().toString();
        if (seitoukihonsType == null && getSeitoukihonsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'seitoukihons$' should not be NULL."));
        }
        return seitoukihonsType;
    }

    protected void setSeitoukihonsType(String type) {
        seitoukihonsType = type;
        seitoukihons = Optional.fromNullable(toCurrencyType(seitoukihonsType))
            .transform(bizCurrencyTransformer(getSeitoukihonsValue()))
            .orNull();
    }

    private BizCurrency syutkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyutkp() {
        return syutkp;
    }

    public void setSyutkp(BizCurrency pSyutkp) {
        syutkp = pSyutkp;
        syutkpValue = null;
        syutkpType  = null;
    }

    transient private BigDecimal syutkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUTKP, nullable=true)
    protected BigDecimal getSyutkpValue() {
        if (syutkpValue == null && syutkp != null) {
            if (syutkp.isOptional()) return null;
            return syutkp.absolute();
        }
        return syutkpValue;
    }

    protected void setSyutkpValue(BigDecimal value) {
        syutkpValue = value;
        syutkp = Optional.fromNullable(toCurrencyType(syutkpType))
            .transform(bizCurrencyTransformer(getSyutkpValue()))
            .orNull();
    }

    transient private String syutkpType = null;

    @Column(name=SYUTKP + "$", nullable=true)
    protected String getSyutkpType() {
        if (syutkpType == null && syutkp != null) return syutkp.getType().toString();
        if (syutkpType == null && getSyutkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syutkp$' should not be NULL."));
        }
        return syutkpType;
    }

    protected void setSyutkpType(String type) {
        syutkpType = type;
        syutkp = Optional.fromNullable(toCurrencyType(syutkpType))
            .transform(bizCurrencyTransformer(getSyutkpValue()))
            .orNull();
    }

    private BizCurrency hrktuukasyutkp;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    public BizCurrency getHrktuukasyutkp() {
        return hrktuukasyutkp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrktuukasyutkp(BizCurrency pHrktuukasyutkp) {
        hrktuukasyutkp = pHrktuukasyutkp;
        hrktuukasyutkpValue = null;
        hrktuukasyutkpType  = null;
    }

    transient private BigDecimal hrktuukasyutkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKTUUKASYUTKP, nullable=true)
    protected BigDecimal getHrktuukasyutkpValue() {
        if (hrktuukasyutkpValue == null && hrktuukasyutkp != null) {
            if (hrktuukasyutkp.isOptional()) return null;
            return hrktuukasyutkp.absolute();
        }
        return hrktuukasyutkpValue;
    }

    protected void setHrktuukasyutkpValue(BigDecimal value) {
        hrktuukasyutkpValue = value;
        hrktuukasyutkp = Optional.fromNullable(toCurrencyType(hrktuukasyutkpType))
            .transform(bizCurrencyTransformer(getHrktuukasyutkpValue()))
            .orNull();
    }

    transient private String hrktuukasyutkpType = null;

    @Column(name=HRKTUUKASYUTKP + "$", nullable=true)
    protected String getHrktuukasyutkpType() {
        if (hrktuukasyutkpType == null && hrktuukasyutkp != null) return hrktuukasyutkp.getType().toString();
        if (hrktuukasyutkpType == null && getHrktuukasyutkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrktuukasyutkp$' should not be NULL."));
        }
        return hrktuukasyutkpType;
    }

    protected void setHrktuukasyutkpType(String type) {
        hrktuukasyutkpType = type;
        hrktuukasyutkp = Optional.fromNullable(toCurrencyType(hrktuukasyutkpType))
            .transform(bizCurrencyTransformer(getHrktuukasyutkpValue()))
            .orNull();
    }

    private BizCurrency tkjyp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTkjyp() {
        return tkjyp;
    }

    public void setTkjyp(BizCurrency pTkjyp) {
        tkjyp = pTkjyp;
        tkjypValue = null;
        tkjypType  = null;
    }

    transient private BigDecimal tkjypValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TKJYP, nullable=true)
    protected BigDecimal getTkjypValue() {
        if (tkjypValue == null && tkjyp != null) {
            if (tkjyp.isOptional()) return null;
            return tkjyp.absolute();
        }
        return tkjypValue;
    }

    protected void setTkjypValue(BigDecimal value) {
        tkjypValue = value;
        tkjyp = Optional.fromNullable(toCurrencyType(tkjypType))
            .transform(bizCurrencyTransformer(getTkjypValue()))
            .orNull();
    }

    transient private String tkjypType = null;

    @Column(name=TKJYP + "$", nullable=true)
    protected String getTkjypType() {
        if (tkjypType == null && tkjyp != null) return tkjyp.getType().toString();
        if (tkjypType == null && getTkjypValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tkjyp$' should not be NULL."));
        }
        return tkjypType;
    }

    protected void setTkjypType(String type) {
        tkjypType = type;
        tkjyp = Optional.fromNullable(toCurrencyType(tkjypType))
            .transform(bizCurrencyTransformer(getTkjypValue()))
            .orNull();
    }

    private C_KataKbn katakbn;

    @Type(type="UserType_C_KataKbn")
    @Column(name=GenHT_MosSyouhn.KATAKBN)
    public C_KataKbn getKatakbn() {
        return katakbn;
    }

    public void setKatakbn(C_KataKbn pKatakbn) {
        katakbn = pKatakbn;
    }

    private C_KyhgndkataKbn kyhkatakbn;

    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenHT_MosSyouhn.KYHKATAKBN)
    public C_KyhgndkataKbn getKyhkatakbn() {
        return kyhkatakbn;
    }

    public void setKyhkatakbn(C_KyhgndkataKbn pKyhkatakbn) {
        kyhkatakbn = pKyhkatakbn;
    }

    private C_SyukyhkinkataKbn syukyhkinkatakbn;

    @Type(type="UserType_C_SyukyhkinkataKbn")
    @Column(name=GenHT_MosSyouhn.SYUKYHKINKATAKBN)
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn() {
        return syukyhkinkatakbn;
    }

    public void setSyukyhkinkatakbn(C_SyukyhkinkataKbn pSyukyhkinkatakbn) {
        syukyhkinkatakbn = pSyukyhkinkatakbn;
    }

    private C_KhnkyhkgbairituKbn khnkyhkgbairitukbn;

    @Type(type="UserType_C_KhnkyhkgbairituKbn")
    @Column(name=GenHT_MosSyouhn.KHNKYHKGBAIRITUKBN)
    public C_KhnkyhkgbairituKbn getKhnkyhkgbairitukbn() {
        return khnkyhkgbairitukbn;
    }

    public void setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn) {
        khnkyhkgbairitukbn = pKhnkyhkgbairitukbn;
    }

    private C_6daiLdKbn rokudaildkbn;

    @Type(type="UserType_C_6daiLdKbn")
    @Column(name=GenHT_MosSyouhn.ROKUDAILDKBN)
    public C_6daiLdKbn getRokudaildkbn() {
        return rokudaildkbn;
    }

    public void setRokudaildkbn(C_6daiLdKbn pRokudaildkbn) {
        rokudaildkbn = pRokudaildkbn;
    }

    private Integer hknkkn;

    @Column(name=GenHT_MosSyouhn.HKNKKN)
    @Range(min="0", max="99")
    public Integer getHknkkn() {
        return hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkkn(Integer pHknkkn) {
        hknkkn = pHknkkn;
    }

    private Integer hrkkkn;

    @Column(name=GenHT_MosSyouhn.HRKKKN)
    @Range(min="0", max="99")
    public Integer getHrkkkn() {
        return hrkkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrkkkn(Integer pHrkkkn) {
        hrkkkn = pHrkkkn;
    }

    private C_HknkknsmnKbn hknkknsmnkbn;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenHT_MosSyouhn.HKNKKNSMNKBN)
    public C_HknkknsmnKbn getHknkknsmnkbn() {
        return hknkknsmnkbn;
    }

    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn) {
        hknkknsmnkbn = pHknkknsmnkbn;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenHT_MosSyouhn.HRKKKNSMNKBN)
    public C_HrkkknsmnKbn getHrkkknsmnkbn() {
        return hrkkknsmnkbn;
    }

    public void setHrkkknsmnkbn(C_HrkkknsmnKbn pHrkkknsmnkbn) {
        hrkkknsmnkbn = pHrkkknsmnkbn;
    }

    private Integer dai1hknkkn;

    @Column(name=GenHT_MosSyouhn.DAI1HKNKKN)
    @Range(min="0", max="99")
    public Integer getDai1hknkkn() {
        return dai1hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai1hknkkn(Integer pDai1hknkkn) {
        dai1hknkkn = pDai1hknkkn;
    }

    private BizNumber tumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenHT_MosSyouhn.TUMITATERIRITU)
    public BizNumber getTumitateriritu() {
        return tumitateriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTumitateriritu(BizNumber pTumitateriritu) {
        tumitateriritu = pTumitateriritu;
    }

    private BizNumber tmttknzoukaritujygn;

    @Type(type="BizNumberType")
    @Column(name=GenHT_MosSyouhn.TMTTKNZOUKARITUJYGN)
    public BizNumber getTmttknzoukaritujygn() {
        return tmttknzoukaritujygn;
    }

    public void setTmttknzoukaritujygn(BizNumber pTmttknzoukaritujygn) {
        tmttknzoukaritujygn = pTmttknzoukaritujygn;
    }

    private BizNumber setteibairitu;

    @Type(type="BizNumberType")
    @Column(name=GenHT_MosSyouhn.SETTEIBAIRITU)
    public BizNumber getSetteibairitu() {
        return setteibairitu;
    }

    public void setSetteibairitu(BizNumber pSetteibairitu) {
        setteibairitu = pSetteibairitu;
    }

    private BizNumber rendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenHT_MosSyouhn.RENDOURITU)
    public BizNumber getRendouritu() {
        return rendouritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRendouritu(BizNumber pRendouritu) {
        rendouritu = pRendouritu;
    }

    private BizCurrency teikisiharaikin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeikisiharaikin() {
        return teikisiharaikin;
    }

    public void setTeikisiharaikin(BizCurrency pTeikisiharaikin) {
        teikisiharaikin = pTeikisiharaikin;
        teikisiharaikinValue = null;
        teikisiharaikinType  = null;
    }

    transient private BigDecimal teikisiharaikinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEIKISIHARAIKIN, nullable=true)
    protected BigDecimal getTeikisiharaikinValue() {
        if (teikisiharaikinValue == null && teikisiharaikin != null) {
            if (teikisiharaikin.isOptional()) return null;
            return teikisiharaikin.absolute();
        }
        return teikisiharaikinValue;
    }

    protected void setTeikisiharaikinValue(BigDecimal value) {
        teikisiharaikinValue = value;
        teikisiharaikin = Optional.fromNullable(toCurrencyType(teikisiharaikinType))
            .transform(bizCurrencyTransformer(getTeikisiharaikinValue()))
            .orNull();
    }

    transient private String teikisiharaikinType = null;

    @Column(name=TEIKISIHARAIKIN + "$", nullable=true)
    protected String getTeikisiharaikinType() {
        if (teikisiharaikinType == null && teikisiharaikin != null) return teikisiharaikin.getType().toString();
        if (teikisiharaikinType == null && getTeikisiharaikinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teikisiharaikin$' should not be NULL."));
        }
        return teikisiharaikinType;
    }

    protected void setTeikisiharaikinType(String type) {
        teikisiharaikinType = type;
        teikisiharaikin = Optional.fromNullable(toCurrencyType(teikisiharaikinType))
            .transform(bizCurrencyTransformer(getTeikisiharaikinValue()))
            .orNull();
    }

    private BizNumber loadinghnkgtumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenHT_MosSyouhn.LOADINGHNKGTUMITATERIRITU)
    public BizNumber getLoadinghnkgtumitateriritu() {
        return loadinghnkgtumitateriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLoadinghnkgtumitateriritu(BizNumber pLoadinghnkgtumitateriritu) {
        loadinghnkgtumitateriritu = pLoadinghnkgtumitateriritu;
    }

    private BizCurrency kihons2;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getKihons2() {
        return kihons2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons2(BizCurrency pKihons2) {
        kihons2 = pKihons2;
        kihons2Value = null;
        kihons2Type  = null;
    }

    transient private BigDecimal kihons2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS2, nullable=true)
    protected BigDecimal getKihons2Value() {
        if (kihons2Value == null && kihons2 != null) {
            if (kihons2.isOptional()) return null;
            return kihons2.absolute();
        }
        return kihons2Value;
    }

    protected void setKihons2Value(BigDecimal value) {
        kihons2Value = value;
        kihons2 = Optional.fromNullable(toCurrencyType(kihons2Type))
            .transform(bizCurrencyTransformer(getKihons2Value()))
            .orNull();
    }

    transient private String kihons2Type = null;

    @Column(name=KIHONS2 + "$", nullable=true)
    protected String getKihons2Type() {
        if (kihons2Type == null && kihons2 != null) return kihons2.getType().toString();
        if (kihons2Type == null && getKihons2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons2$' should not be NULL."));
        }
        return kihons2Type;
    }

    protected void setKihons2Type(String type) {
        kihons2Type = type;
        kihons2 = Optional.fromNullable(toCurrencyType(kihons2Type))
            .transform(bizCurrencyTransformer(getKihons2Value()))
            .orNull();
    }

    private BizCurrency hrktuukasyutkp2;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getHrktuukasyutkp2() {
        return hrktuukasyutkp2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrktuukasyutkp2(BizCurrency pHrktuukasyutkp2) {
        hrktuukasyutkp2 = pHrktuukasyutkp2;
        hrktuukasyutkp2Value = null;
        hrktuukasyutkp2Type  = null;
    }

    transient private BigDecimal hrktuukasyutkp2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKTUUKASYUTKP2, nullable=true)
    protected BigDecimal getHrktuukasyutkp2Value() {
        if (hrktuukasyutkp2Value == null && hrktuukasyutkp2 != null) {
            if (hrktuukasyutkp2.isOptional()) return null;
            return hrktuukasyutkp2.absolute();
        }
        return hrktuukasyutkp2Value;
    }

    protected void setHrktuukasyutkp2Value(BigDecimal value) {
        hrktuukasyutkp2Value = value;
        hrktuukasyutkp2 = Optional.fromNullable(toCurrencyType(hrktuukasyutkp2Type))
            .transform(bizCurrencyTransformer(getHrktuukasyutkp2Value()))
            .orNull();
    }

    transient private String hrktuukasyutkp2Type = null;

    @Column(name=HRKTUUKASYUTKP2 + "$", nullable=true)
    protected String getHrktuukasyutkp2Type() {
        if (hrktuukasyutkp2Type == null && hrktuukasyutkp2 != null) return hrktuukasyutkp2.getType().toString();
        if (hrktuukasyutkp2Type == null && getHrktuukasyutkp2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrktuukasyutkp2$' should not be NULL."));
        }
        return hrktuukasyutkp2Type;
    }

    protected void setHrktuukasyutkp2Type(String type) {
        hrktuukasyutkp2Type = type;
        hrktuukasyutkp2 = Optional.fromNullable(toCurrencyType(hrktuukasyutkp2Type))
            .transform(bizCurrencyTransformer(getHrktuukasyutkp2Value()))
            .orNull();
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_MosSyouhn.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_MosSyouhn.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
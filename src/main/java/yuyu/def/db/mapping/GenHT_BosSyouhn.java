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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
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
import yuyu.def.db.entity.HT_BosSyouhn;
import yuyu.def.db.id.PKHT_BosSyouhn;
import yuyu.def.db.meta.GenQHT_BosSyouhn;
import yuyu.def.db.meta.QHT_BosSyouhn;
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
 * 募集商品テーブル テーブルのマッピング情報クラスで、 {@link HT_BosSyouhn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_BosSyouhn}</td><td colspan="3">募集商品テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_BosSyouhn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKHT_BosSyouhn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
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
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_BosSyouhn
 * @see     PKHT_BosSyouhn
 * @see     QHT_BosSyouhn
 * @see     GenQHT_BosSyouhn
 */
@MappedSuperclass
@Table(name=GenHT_BosSyouhn.TABLE_NAME)
@IdClass(value=PKHT_BosSyouhn.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
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
public abstract class GenHT_BosSyouhn extends AbstractExDBEntity<HT_BosSyouhn, PKHT_BosSyouhn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_BosSyouhn";
    public static final String MOSNO                    = "mosno";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String SYUTKKBN                 = "syutkkbn";
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
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_BosSyouhn primaryKey;

    public GenHT_BosSyouhn() {
        primaryKey = new PKHT_BosSyouhn();
    }

    public GenHT_BosSyouhn(String pMosno, String pSyouhncd) {
        primaryKey = new PKHT_BosSyouhn(pMosno, pSyouhncd);
    }

    @Transient
    @Override
    public PKHT_BosSyouhn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_BosSyouhn> getMetaClass() {
        return QHT_BosSyouhn.class;
    }

    @Id
    @Column(name=GenHT_BosSyouhn.MOSNO)
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
    @Column(name=GenHT_BosSyouhn.SYOUHNCD)
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

    @Column(name=GenHT_BosSyouhn.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private String ryouritusdno;

    @Column(name=GenHT_BosSyouhn.RYOURITUSDNO)
    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }

    private C_SyutkKbn syutkkbn;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenHT_BosSyouhn.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }

    private C_Sknenkinsyu sknenkinsyu;

    @Type(type="UserType_C_Sknenkinsyu")
    @Column(name=GenHT_BosSyouhn.SKNENKINSYU)
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
    @Column(name=GenHT_BosSyouhn.KATAKBN)
    public C_KataKbn getKatakbn() {
        return katakbn;
    }

    public void setKatakbn(C_KataKbn pKatakbn) {
        katakbn = pKatakbn;
    }

    private C_KyhgndkataKbn kyhkatakbn;

    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenHT_BosSyouhn.KYHKATAKBN)
    public C_KyhgndkataKbn getKyhkatakbn() {
        return kyhkatakbn;
    }

    public void setKyhkatakbn(C_KyhgndkataKbn pKyhkatakbn) {
        kyhkatakbn = pKyhkatakbn;
    }

    private C_SyukyhkinkataKbn syukyhkinkatakbn;

    @Type(type="UserType_C_SyukyhkinkataKbn")
    @Column(name=GenHT_BosSyouhn.SYUKYHKINKATAKBN)
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn() {
        return syukyhkinkatakbn;
    }

    public void setSyukyhkinkatakbn(C_SyukyhkinkataKbn pSyukyhkinkatakbn) {
        syukyhkinkatakbn = pSyukyhkinkatakbn;
    }

    private C_KhnkyhkgbairituKbn khnkyhkgbairitukbn;

    @Type(type="UserType_C_KhnkyhkgbairituKbn")
    @Column(name=GenHT_BosSyouhn.KHNKYHKGBAIRITUKBN)
    public C_KhnkyhkgbairituKbn getKhnkyhkgbairitukbn() {
        return khnkyhkgbairitukbn;
    }

    public void setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn) {
        khnkyhkgbairitukbn = pKhnkyhkgbairitukbn;
    }

    private C_6daiLdKbn rokudaildkbn;

    @Type(type="UserType_C_6daiLdKbn")
    @Column(name=GenHT_BosSyouhn.ROKUDAILDKBN)
    public C_6daiLdKbn getRokudaildkbn() {
        return rokudaildkbn;
    }

    public void setRokudaildkbn(C_6daiLdKbn pRokudaildkbn) {
        rokudaildkbn = pRokudaildkbn;
    }

    private Integer hknkkn;

    @Column(name=GenHT_BosSyouhn.HKNKKN)
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

    @Column(name=GenHT_BosSyouhn.HRKKKN)
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
    @Column(name=GenHT_BosSyouhn.HKNKKNSMNKBN)
    public C_HknkknsmnKbn getHknkknsmnkbn() {
        return hknkknsmnkbn;
    }

    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn) {
        hknkknsmnkbn = pHknkknsmnkbn;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenHT_BosSyouhn.HRKKKNSMNKBN)
    public C_HrkkknsmnKbn getHrkkknsmnkbn() {
        return hrkkknsmnkbn;
    }

    public void setHrkkknsmnkbn(C_HrkkknsmnKbn pHrkkknsmnkbn) {
        hrkkknsmnkbn = pHrkkknsmnkbn;
    }

    private Integer dai1hknkkn;

    @Column(name=GenHT_BosSyouhn.DAI1HKNKKN)
    @Range(min="0", max="99")
    public Integer getDai1hknkkn() {
        return dai1hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai1hknkkn(Integer pDai1hknkkn) {
        dai1hknkkn = pDai1hknkkn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_BosSyouhn.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_BosSyouhn.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
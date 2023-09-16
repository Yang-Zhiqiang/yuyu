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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_MiseirijiyuuMeisai;
import yuyu.def.db.id.PKHT_MiseirijiyuuMeisai;
import yuyu.def.db.meta.GenQHT_MiseirijiyuuMeisai;
import yuyu.def.db.meta.QHT_MiseirijiyuuMeisai;
import yuyu.def.db.type.UserType_C_NyuukinjyoutaiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 未整理事由別明細テーブル テーブルのマッピング情報クラスで、 {@link HT_MiseirijiyuuMeisai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_MiseirijiyuuMeisai}</td><td colspan="3">未整理事由別明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_MiseirijiyuuMeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSknnkaisiymd sknnkaisiymd}</td><td>責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMiseirijiyuukbn miseirijiyuukbn}</td><td>未整理事由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMiseirijiyuudetailkbn miseirijiyuudetailkbn}</td><td>未整理事由詳細区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyuukinjoutaikbn nyuukinjoutaikbn}</td><td>入金状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyuukinjyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getSyoruikbn1 syoruikbn1}</td><td>書類区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruikbn2 syoruikbn2}</td><td>書類区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruikbn3 syoruikbn3}</td><td>書類区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruikbn4 syoruikbn4}</td><td>書類区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruikbn5 syoruikbn5}</td><td>書類区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruikbn6 syoruikbn6}</td><td>書類区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruikbn7 syoruikbn7}</td><td>書類区分７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruikbn8 syoruikbn8}</td><td>書類区分８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruikbn9 syoruikbn9}</td><td>書類区分９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruikbn10 syoruikbn10}</td><td>書類区分１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruihubikensuu syoruihubikensuu}</td><td>書類不備件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyokaidenymd syokaidenymd}</td><td>初回伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyokairsymd syokairsymd}</td><td>初回領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRsgakuen rsgakuen}</td><td>領収金額（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRsgakugaika rsgakugaika}</td><td>領収金額（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRstuukasyu rstuukasyu}</td><td>領収通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKrkhuho2syoukai krkhuho2syoukai}</td><td>仮受金（普保Ⅱ初回）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKrkhuho2kobetu krkhuho2kobetu}</td><td>仮受金（普保Ⅱ個別）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKrkdai1kaikeijyougkyen krkdai1kaikeijyougkyen}</td><td>仮受金（第１回）計上額（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKrkdai1kaikeijyougkgaika krkdai1kaikeijyougkgaika}</td><td>仮受金（第１回）計上額（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKrkdai1kaituukasyu krkdai1kaituukasyu}</td><td>仮受金（第１回）通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_MiseirijiyuuMeisai
 * @see     PKHT_MiseirijiyuuMeisai
 * @see     QHT_MiseirijiyuuMeisai
 * @see     GenQHT_MiseirijiyuuMeisai
 */
@MappedSuperclass
@Table(name=GenHT_MiseirijiyuuMeisai.TABLE_NAME)
@IdClass(value=PKHT_MiseirijiyuuMeisai.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_NyuukinjyoutaiKbn", typeClass=UserType_C_NyuukinjyoutaiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenHT_MiseirijiyuuMeisai extends AbstractExDBEntity<HT_MiseirijiyuuMeisai, PKHT_MiseirijiyuuMeisai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_MiseirijiyuuMeisai";
    public static final String MOSNO                    = "mosno";
    public static final String SYONO                    = "syono";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String SKNNKAISIYMD             = "sknnkaisiymd";
    public static final String KYKYMD                   = "kykymd";
    public static final String MISEIRIJIYUUKBN          = "miseirijiyuukbn";
    public static final String MISEIRIJIYUUDETAILKBN    = "miseirijiyuudetailkbn";
    public static final String NYUUKINJOUTAIKBN         = "nyuukinjoutaikbn";
    public static final String SYORUIKBN1               = "syoruikbn1";
    public static final String SYORUIKBN2               = "syoruikbn2";
    public static final String SYORUIKBN3               = "syoruikbn3";
    public static final String SYORUIKBN4               = "syoruikbn4";
    public static final String SYORUIKBN5               = "syoruikbn5";
    public static final String SYORUIKBN6               = "syoruikbn6";
    public static final String SYORUIKBN7               = "syoruikbn7";
    public static final String SYORUIKBN8               = "syoruikbn8";
    public static final String SYORUIKBN9               = "syoruikbn9";
    public static final String SYORUIKBN10              = "syoruikbn10";
    public static final String SYORUIHUBIKENSUU         = "syoruihubikensuu";
    public static final String SYOKAIDENYMD             = "syokaidenymd";
    public static final String SYOKAIRSYMD              = "syokairsymd";
    public static final String RSGAKUEN                 = "rsgakuen";
    public static final String RSGAKUGAIKA              = "rsgakugaika";
    public static final String RSTUUKASYU               = "rstuukasyu";
    public static final String KRKHUHO2SYOUKAI          = "krkhuho2syoukai";
    public static final String KRKHUHO2KOBETU           = "krkhuho2kobetu";
    public static final String KRKDAI1KAIKEIJYOUGKYEN   = "krkdai1kaikeijyougkyen";
    public static final String KRKDAI1KAIKEIJYOUGKGAIKA = "krkdai1kaikeijyougkgaika";
    public static final String KRKDAI1KAITUUKASYU       = "krkdai1kaituukasyu";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_MiseirijiyuuMeisai primaryKey;

    public GenHT_MiseirijiyuuMeisai() {
        primaryKey = new PKHT_MiseirijiyuuMeisai();
    }

    public GenHT_MiseirijiyuuMeisai(String pMosno) {
        primaryKey = new PKHT_MiseirijiyuuMeisai(pMosno);
    }

    @Transient
    @Override
    public PKHT_MiseirijiyuuMeisai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_MiseirijiyuuMeisai> getMetaClass() {
        return QHT_MiseirijiyuuMeisai.class;
    }

    @Id
    @Column(name=GenHT_MiseirijiyuuMeisai.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    private String syono;

    @Column(name=GenHT_MiseirijiyuuMeisai.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String kyknmkn;

    @Column(name=GenHT_MiseirijiyuuMeisai.KYKNMKN)
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

    private BizDate sknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MiseirijiyuuMeisai.SKNNKAISIYMD)
    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    @Trim("both")
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MiseirijiyuuMeisai.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private String miseirijiyuukbn;

    @Column(name=GenHT_MiseirijiyuuMeisai.MISEIRIJIYUUKBN)
    public String getMiseirijiyuukbn() {
        return miseirijiyuukbn;
    }

    public void setMiseirijiyuukbn(String pMiseirijiyuukbn) {
        miseirijiyuukbn = pMiseirijiyuukbn;
    }

    private String miseirijiyuudetailkbn;

    @Column(name=GenHT_MiseirijiyuuMeisai.MISEIRIJIYUUDETAILKBN)
    public String getMiseirijiyuudetailkbn() {
        return miseirijiyuudetailkbn;
    }

    public void setMiseirijiyuudetailkbn(String pMiseirijiyuudetailkbn) {
        miseirijiyuudetailkbn = pMiseirijiyuudetailkbn;
    }

    private C_NyuukinjyoutaiKbn nyuukinjoutaikbn;

    @Type(type="UserType_C_NyuukinjyoutaiKbn")
    @Column(name=GenHT_MiseirijiyuuMeisai.NYUUKINJOUTAIKBN)
    public C_NyuukinjyoutaiKbn getNyuukinjoutaikbn() {
        return nyuukinjoutaikbn;
    }

    public void setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn pNyuukinjoutaikbn) {
        nyuukinjoutaikbn = pNyuukinjoutaikbn;
    }

    private String syoruikbn1;

    @Column(name=GenHT_MiseirijiyuuMeisai.SYORUIKBN1)
    public String getSyoruikbn1() {
        return syoruikbn1;
    }

    public void setSyoruikbn1(String pSyoruikbn1) {
        syoruikbn1 = pSyoruikbn1;
    }

    private String syoruikbn2;

    @Column(name=GenHT_MiseirijiyuuMeisai.SYORUIKBN2)
    public String getSyoruikbn2() {
        return syoruikbn2;
    }

    public void setSyoruikbn2(String pSyoruikbn2) {
        syoruikbn2 = pSyoruikbn2;
    }

    private String syoruikbn3;

    @Column(name=GenHT_MiseirijiyuuMeisai.SYORUIKBN3)
    public String getSyoruikbn3() {
        return syoruikbn3;
    }

    public void setSyoruikbn3(String pSyoruikbn3) {
        syoruikbn3 = pSyoruikbn3;
    }

    private String syoruikbn4;

    @Column(name=GenHT_MiseirijiyuuMeisai.SYORUIKBN4)
    public String getSyoruikbn4() {
        return syoruikbn4;
    }

    public void setSyoruikbn4(String pSyoruikbn4) {
        syoruikbn4 = pSyoruikbn4;
    }

    private String syoruikbn5;

    @Column(name=GenHT_MiseirijiyuuMeisai.SYORUIKBN5)
    public String getSyoruikbn5() {
        return syoruikbn5;
    }

    public void setSyoruikbn5(String pSyoruikbn5) {
        syoruikbn5 = pSyoruikbn5;
    }

    private String syoruikbn6;

    @Column(name=GenHT_MiseirijiyuuMeisai.SYORUIKBN6)
    public String getSyoruikbn6() {
        return syoruikbn6;
    }

    public void setSyoruikbn6(String pSyoruikbn6) {
        syoruikbn6 = pSyoruikbn6;
    }

    private String syoruikbn7;

    @Column(name=GenHT_MiseirijiyuuMeisai.SYORUIKBN7)
    public String getSyoruikbn7() {
        return syoruikbn7;
    }

    public void setSyoruikbn7(String pSyoruikbn7) {
        syoruikbn7 = pSyoruikbn7;
    }

    private String syoruikbn8;

    @Column(name=GenHT_MiseirijiyuuMeisai.SYORUIKBN8)
    public String getSyoruikbn8() {
        return syoruikbn8;
    }

    public void setSyoruikbn8(String pSyoruikbn8) {
        syoruikbn8 = pSyoruikbn8;
    }

    private String syoruikbn9;

    @Column(name=GenHT_MiseirijiyuuMeisai.SYORUIKBN9)
    public String getSyoruikbn9() {
        return syoruikbn9;
    }

    public void setSyoruikbn9(String pSyoruikbn9) {
        syoruikbn9 = pSyoruikbn9;
    }

    private String syoruikbn10;

    @Column(name=GenHT_MiseirijiyuuMeisai.SYORUIKBN10)
    public String getSyoruikbn10() {
        return syoruikbn10;
    }

    public void setSyoruikbn10(String pSyoruikbn10) {
        syoruikbn10 = pSyoruikbn10;
    }

    private Integer syoruihubikensuu;

    @Column(name=GenHT_MiseirijiyuuMeisai.SYORUIHUBIKENSUU)
    public Integer getSyoruihubikensuu() {
        return syoruihubikensuu;
    }

    public void setSyoruihubikensuu(Integer pSyoruihubikensuu) {
        syoruihubikensuu = pSyoruihubikensuu;
    }

    private BizDate syokaidenymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MiseirijiyuuMeisai.SYOKAIDENYMD)
    public BizDate getSyokaidenymd() {
        return syokaidenymd;
    }

    public void setSyokaidenymd(BizDate pSyokaidenymd) {
        syokaidenymd = pSyokaidenymd;
    }

    private BizDate syokairsymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MiseirijiyuuMeisai.SYOKAIRSYMD)
    public BizDate getSyokairsymd() {
        return syokairsymd;
    }

    public void setSyokairsymd(BizDate pSyokairsymd) {
        syokairsymd = pSyokairsymd;
    }

    private BizCurrency rsgakuen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getRsgakuen() {
        return rsgakuen;
    }

    public void setRsgakuen(BizCurrency pRsgakuen) {
        rsgakuen = pRsgakuen;
        rsgakuenValue = null;
        rsgakuenType  = null;
    }

    transient private BigDecimal rsgakuenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=RSGAKUEN, nullable=true)
    protected BigDecimal getRsgakuenValue() {
        if (rsgakuenValue == null && rsgakuen != null) {
            if (rsgakuen.isOptional()) return null;
            return rsgakuen.absolute();
        }
        return rsgakuenValue;
    }

    protected void setRsgakuenValue(BigDecimal value) {
        rsgakuenValue = value;
        rsgakuen = Optional.fromNullable(toCurrencyType(rsgakuenType))
            .transform(bizCurrencyTransformer(getRsgakuenValue()))
            .orNull();
    }

    transient private String rsgakuenType = null;

    @Column(name=RSGAKUEN + "$", nullable=true)
    protected String getRsgakuenType() {
        if (rsgakuenType == null && rsgakuen != null) return rsgakuen.getType().toString();
        if (rsgakuenType == null && getRsgakuenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rsgakuen$' should not be NULL."));
        }
        return rsgakuenType;
    }

    protected void setRsgakuenType(String type) {
        rsgakuenType = type;
        rsgakuen = Optional.fromNullable(toCurrencyType(rsgakuenType))
            .transform(bizCurrencyTransformer(getRsgakuenValue()))
            .orNull();
    }

    private BizCurrency rsgakugaika;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getRsgakugaika() {
        return rsgakugaika;
    }

    public void setRsgakugaika(BizCurrency pRsgakugaika) {
        rsgakugaika = pRsgakugaika;
        rsgakugaikaValue = null;
        rsgakugaikaType  = null;
    }

    transient private BigDecimal rsgakugaikaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=RSGAKUGAIKA, nullable=true)
    protected BigDecimal getRsgakugaikaValue() {
        if (rsgakugaikaValue == null && rsgakugaika != null) {
            if (rsgakugaika.isOptional()) return null;
            return rsgakugaika.absolute();
        }
        return rsgakugaikaValue;
    }

    protected void setRsgakugaikaValue(BigDecimal value) {
        rsgakugaikaValue = value;
        rsgakugaika = Optional.fromNullable(toCurrencyType(rsgakugaikaType))
            .transform(bizCurrencyTransformer(getRsgakugaikaValue()))
            .orNull();
    }

    transient private String rsgakugaikaType = null;

    @Column(name=RSGAKUGAIKA + "$", nullable=true)
    protected String getRsgakugaikaType() {
        if (rsgakugaikaType == null && rsgakugaika != null) return rsgakugaika.getType().toString();
        if (rsgakugaikaType == null && getRsgakugaikaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rsgakugaika$' should not be NULL."));
        }
        return rsgakugaikaType;
    }

    protected void setRsgakugaikaType(String type) {
        rsgakugaikaType = type;
        rsgakugaika = Optional.fromNullable(toCurrencyType(rsgakugaikaType))
            .transform(bizCurrencyTransformer(getRsgakugaikaValue()))
            .orNull();
    }

    private C_Tuukasyu rstuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_MiseirijiyuuMeisai.RSTUUKASYU)
    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        rstuukasyu = pRstuukasyu;
    }

    private BizCurrency krkhuho2syoukai;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKrkhuho2syoukai() {
        return krkhuho2syoukai;
    }

    public void setKrkhuho2syoukai(BizCurrency pKrkhuho2syoukai) {
        krkhuho2syoukai = pKrkhuho2syoukai;
        krkhuho2syoukaiValue = null;
        krkhuho2syoukaiType  = null;
    }

    transient private BigDecimal krkhuho2syoukaiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KRKHUHO2SYOUKAI, nullable=true)
    protected BigDecimal getKrkhuho2syoukaiValue() {
        if (krkhuho2syoukaiValue == null && krkhuho2syoukai != null) {
            if (krkhuho2syoukai.isOptional()) return null;
            return krkhuho2syoukai.absolute();
        }
        return krkhuho2syoukaiValue;
    }

    protected void setKrkhuho2syoukaiValue(BigDecimal value) {
        krkhuho2syoukaiValue = value;
        krkhuho2syoukai = Optional.fromNullable(toCurrencyType(krkhuho2syoukaiType))
            .transform(bizCurrencyTransformer(getKrkhuho2syoukaiValue()))
            .orNull();
    }

    transient private String krkhuho2syoukaiType = null;

    @Column(name=KRKHUHO2SYOUKAI + "$", nullable=true)
    protected String getKrkhuho2syoukaiType() {
        if (krkhuho2syoukaiType == null && krkhuho2syoukai != null) return krkhuho2syoukai.getType().toString();
        if (krkhuho2syoukaiType == null && getKrkhuho2syoukaiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'krkhuho2syoukai$' should not be NULL."));
        }
        return krkhuho2syoukaiType;
    }

    protected void setKrkhuho2syoukaiType(String type) {
        krkhuho2syoukaiType = type;
        krkhuho2syoukai = Optional.fromNullable(toCurrencyType(krkhuho2syoukaiType))
            .transform(bizCurrencyTransformer(getKrkhuho2syoukaiValue()))
            .orNull();
    }

    private BizCurrency krkhuho2kobetu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKrkhuho2kobetu() {
        return krkhuho2kobetu;
    }

    public void setKrkhuho2kobetu(BizCurrency pKrkhuho2kobetu) {
        krkhuho2kobetu = pKrkhuho2kobetu;
        krkhuho2kobetuValue = null;
        krkhuho2kobetuType  = null;
    }

    transient private BigDecimal krkhuho2kobetuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KRKHUHO2KOBETU, nullable=true)
    protected BigDecimal getKrkhuho2kobetuValue() {
        if (krkhuho2kobetuValue == null && krkhuho2kobetu != null) {
            if (krkhuho2kobetu.isOptional()) return null;
            return krkhuho2kobetu.absolute();
        }
        return krkhuho2kobetuValue;
    }

    protected void setKrkhuho2kobetuValue(BigDecimal value) {
        krkhuho2kobetuValue = value;
        krkhuho2kobetu = Optional.fromNullable(toCurrencyType(krkhuho2kobetuType))
            .transform(bizCurrencyTransformer(getKrkhuho2kobetuValue()))
            .orNull();
    }

    transient private String krkhuho2kobetuType = null;

    @Column(name=KRKHUHO2KOBETU + "$", nullable=true)
    protected String getKrkhuho2kobetuType() {
        if (krkhuho2kobetuType == null && krkhuho2kobetu != null) return krkhuho2kobetu.getType().toString();
        if (krkhuho2kobetuType == null && getKrkhuho2kobetuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'krkhuho2kobetu$' should not be NULL."));
        }
        return krkhuho2kobetuType;
    }

    protected void setKrkhuho2kobetuType(String type) {
        krkhuho2kobetuType = type;
        krkhuho2kobetu = Optional.fromNullable(toCurrencyType(krkhuho2kobetuType))
            .transform(bizCurrencyTransformer(getKrkhuho2kobetuValue()))
            .orNull();
    }

    private BizCurrency krkdai1kaikeijyougkyen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKrkdai1kaikeijyougkyen() {
        return krkdai1kaikeijyougkyen;
    }

    public void setKrkdai1kaikeijyougkyen(BizCurrency pKrkdai1kaikeijyougkyen) {
        krkdai1kaikeijyougkyen = pKrkdai1kaikeijyougkyen;
        krkdai1kaikeijyougkyenValue = null;
        krkdai1kaikeijyougkyenType  = null;
    }

    transient private BigDecimal krkdai1kaikeijyougkyenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KRKDAI1KAIKEIJYOUGKYEN, nullable=true)
    protected BigDecimal getKrkdai1kaikeijyougkyenValue() {
        if (krkdai1kaikeijyougkyenValue == null && krkdai1kaikeijyougkyen != null) {
            if (krkdai1kaikeijyougkyen.isOptional()) return null;
            return krkdai1kaikeijyougkyen.absolute();
        }
        return krkdai1kaikeijyougkyenValue;
    }

    protected void setKrkdai1kaikeijyougkyenValue(BigDecimal value) {
        krkdai1kaikeijyougkyenValue = value;
        krkdai1kaikeijyougkyen = Optional.fromNullable(toCurrencyType(krkdai1kaikeijyougkyenType))
            .transform(bizCurrencyTransformer(getKrkdai1kaikeijyougkyenValue()))
            .orNull();
    }

    transient private String krkdai1kaikeijyougkyenType = null;

    @Column(name=KRKDAI1KAIKEIJYOUGKYEN + "$", nullable=true)
    protected String getKrkdai1kaikeijyougkyenType() {
        if (krkdai1kaikeijyougkyenType == null && krkdai1kaikeijyougkyen != null) return krkdai1kaikeijyougkyen.getType().toString();
        if (krkdai1kaikeijyougkyenType == null && getKrkdai1kaikeijyougkyenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'krkdai1kaikeijyougkyen$' should not be NULL."));
        }
        return krkdai1kaikeijyougkyenType;
    }

    protected void setKrkdai1kaikeijyougkyenType(String type) {
        krkdai1kaikeijyougkyenType = type;
        krkdai1kaikeijyougkyen = Optional.fromNullable(toCurrencyType(krkdai1kaikeijyougkyenType))
            .transform(bizCurrencyTransformer(getKrkdai1kaikeijyougkyenValue()))
            .orNull();
    }

    private BizCurrency krkdai1kaikeijyougkgaika;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKrkdai1kaikeijyougkgaika() {
        return krkdai1kaikeijyougkgaika;
    }

    public void setKrkdai1kaikeijyougkgaika(BizCurrency pKrkdai1kaikeijyougkgaika) {
        krkdai1kaikeijyougkgaika = pKrkdai1kaikeijyougkgaika;
        krkdai1kaikeijyougkgaikaValue = null;
        krkdai1kaikeijyougkgaikaType  = null;
    }

    transient private BigDecimal krkdai1kaikeijyougkgaikaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KRKDAI1KAIKEIJYOUGKGAIKA, nullable=true)
    protected BigDecimal getKrkdai1kaikeijyougkgaikaValue() {
        if (krkdai1kaikeijyougkgaikaValue == null && krkdai1kaikeijyougkgaika != null) {
            if (krkdai1kaikeijyougkgaika.isOptional()) return null;
            return krkdai1kaikeijyougkgaika.absolute();
        }
        return krkdai1kaikeijyougkgaikaValue;
    }

    protected void setKrkdai1kaikeijyougkgaikaValue(BigDecimal value) {
        krkdai1kaikeijyougkgaikaValue = value;
        krkdai1kaikeijyougkgaika = Optional.fromNullable(toCurrencyType(krkdai1kaikeijyougkgaikaType))
            .transform(bizCurrencyTransformer(getKrkdai1kaikeijyougkgaikaValue()))
            .orNull();
    }

    transient private String krkdai1kaikeijyougkgaikaType = null;

    @Column(name=KRKDAI1KAIKEIJYOUGKGAIKA + "$", nullable=true)
    protected String getKrkdai1kaikeijyougkgaikaType() {
        if (krkdai1kaikeijyougkgaikaType == null && krkdai1kaikeijyougkgaika != null) return krkdai1kaikeijyougkgaika.getType().toString();
        if (krkdai1kaikeijyougkgaikaType == null && getKrkdai1kaikeijyougkgaikaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'krkdai1kaikeijyougkgaika$' should not be NULL."));
        }
        return krkdai1kaikeijyougkgaikaType;
    }

    protected void setKrkdai1kaikeijyougkgaikaType(String type) {
        krkdai1kaikeijyougkgaikaType = type;
        krkdai1kaikeijyougkgaika = Optional.fromNullable(toCurrencyType(krkdai1kaikeijyougkgaikaType))
            .transform(bizCurrencyTransformer(getKrkdai1kaikeijyougkgaikaValue()))
            .orNull();
    }

    private C_Tuukasyu krkdai1kaituukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_MiseirijiyuuMeisai.KRKDAI1KAITUUKASYU)
    public C_Tuukasyu getKrkdai1kaituukasyu() {
        return krkdai1kaituukasyu;
    }

    public void setKrkdai1kaituukasyu(C_Tuukasyu pKrkdai1kaituukasyu) {
        krkdai1kaituukasyu = pKrkdai1kaituukasyu;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_MiseirijiyuuMeisai.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_MiseirijiyuuMeisai.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_MiseirijiyuuMeisai.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
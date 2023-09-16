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
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kaiyakuhrtype;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.SV_KiykHnriknSutugkData;
import yuyu.def.db.id.PKSV_KiykHnriknSutugkData;
import yuyu.def.db.meta.GenQSV_KiykHnriknSutugkData;
import yuyu.def.db.meta.QSV_KiykHnriknSutugkData;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_HrkkknsmnKbn;
import yuyu.def.db.type.UserType_C_Kaiyakuhrtype;
import yuyu.def.db.type.UserType_C_KataKbn;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SyutkKbn;

/**
 * 解約返戻金相当額情報ビュー テーブルのマッピング情報クラスで、 {@link SV_KiykHnriknSutugkData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_KiykHnriknSutugkData}</td><td colspan="3">解約返戻金相当額情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRenno8keta renno8keta}</td><td>連番（８桁）</td><td align="center">{@link PKSV_KiykHnriknSutugkData ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn hknkknsmnkbn}</td><td>保険期間歳満期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHknkkn hknkkn}</td><td>保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbn hrkkknsmnkbn}</td><td>払込期間歳満期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHrkkkn hrkkkn}</td><td>払込期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getKatakbn katakbn}</td><td>型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getKyhgndkatakbn kyhgndkatakbn}</td><td>給付限度型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getKihons kihons}</td><td>基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakuhrtype kaiyakuhrtype}</td><td>解約返戻金支払タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kaiyakuhrtype}</td></tr>
 *  <tr><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 * </table>
 * @see     SV_KiykHnriknSutugkData
 * @see     PKSV_KiykHnriknSutugkData
 * @see     QSV_KiykHnriknSutugkData
 * @see     GenQSV_KiykHnriknSutugkData
 */
@MappedSuperclass
@Table(name=GenSV_KiykHnriknSutugkData.TABLE_NAME)
@IdClass(value=PKSV_KiykHnriknSutugkData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_HknkknsmnKbn", typeClass=UserType_C_HknkknsmnKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_HrkkknsmnKbn", typeClass=UserType_C_HrkkknsmnKbn.class),
    @TypeDef(name="UserType_C_Kaiyakuhrtype", typeClass=UserType_C_Kaiyakuhrtype.class),
    @TypeDef(name="UserType_C_KataKbn", typeClass=UserType_C_KataKbn.class),
    @TypeDef(name="UserType_C_KyhgndkataKbn", typeClass=UserType_C_KyhgndkataKbn.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class)
})
public abstract class GenSV_KiykHnriknSutugkData extends AbstractExDBEntity<SV_KiykHnriknSutugkData, PKSV_KiykHnriknSutugkData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "SV_KiykHnriknSutugkData";
    public static final String RENNO8KETA               = "renno8keta";
    public static final String SYONO                    = "syono";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String SYUTKKBN                 = "syutkkbn";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KYKYMD                   = "kykymd";
    public static final String HKNKKNSMNKBN             = "hknkknsmnkbn";
    public static final String HKNKKN                   = "hknkkn";
    public static final String HRKKKNSMNKBN             = "hrkkknsmnkbn";
    public static final String HRKKKN                   = "hrkkkn";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String KATAKBN                  = "katakbn";
    public static final String KYHGNDKATAKBN            = "kyhgndkatakbn";
    public static final String KIHONS                   = "kihons";
    public static final String KAIYAKUHRTYPE            = "kaiyakuhrtype";
    public static final String SEG1CD                   = "seg1cd";

    private final PKSV_KiykHnriknSutugkData primaryKey;

    public GenSV_KiykHnriknSutugkData() {
        primaryKey = new PKSV_KiykHnriknSutugkData();
    }

    public GenSV_KiykHnriknSutugkData(Integer pRenno8keta) {
        primaryKey = new PKSV_KiykHnriknSutugkData(pRenno8keta);
    }

    @Transient
    @Override
    public PKSV_KiykHnriknSutugkData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QSV_KiykHnriknSutugkData> getMetaClass() {
        return QSV_KiykHnriknSutugkData.class;
    }

    @Id
    @Column(name=GenSV_KiykHnriknSutugkData.RENNO8KETA)
    public Integer getRenno8keta() {
        return getPrimaryKey().getRenno8keta();
    }

    public void setRenno8keta(Integer pRenno8keta) {
        getPrimaryKey().setRenno8keta(pRenno8keta);
    }

    private String syono;

    @Column(name=GenSV_KiykHnriknSutugkData.SYONO)
    @Pattern(message="{pattern.SyoukenNo.message}", regex="^[a-zA-Z0-9]{1,11}$")
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenSV_KiykHnriknSutugkData.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_SyutkKbn syutkkbn;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenSV_KiykHnriknSutugkData.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }

    private String syouhncd;

    @Column(name=GenSV_KiykHnriknSutugkData.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return syouhncd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    private Integer syouhnsdno;

    @Column(name=GenSV_KiykHnriknSutugkData.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_KiykHnriknSutugkData.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_HknkknsmnKbn hknkknsmnkbn;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenSV_KiykHnriknSutugkData.HKNKKNSMNKBN)
    public C_HknkknsmnKbn getHknkknsmnkbn() {
        return hknkknsmnkbn;
    }

    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn) {
        hknkknsmnkbn = pHknkknsmnkbn;
    }

    private Integer hknkkn;

    @Column(name=GenSV_KiykHnriknSutugkData.HKNKKN)
    @Range(min="0", max="99")
    public Integer getHknkkn() {
        return hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkkn(Integer pHknkkn) {
        hknkkn = pHknkkn;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenSV_KiykHnriknSutugkData.HRKKKNSMNKBN)
    public C_HrkkknsmnKbn getHrkkknsmnkbn() {
        return hrkkknsmnkbn;
    }

    public void setHrkkknsmnkbn(C_HrkkknsmnKbn pHrkkknsmnkbn) {
        hrkkknsmnkbn = pHrkkknsmnkbn;
    }

    private Integer hrkkkn;

    @Column(name=GenSV_KiykHnriknSutugkData.HRKKKN)
    @Range(min="0", max="99")
    public Integer getHrkkkn() {
        return hrkkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrkkkn(Integer pHrkkkn) {
        hrkkkn = pHrkkkn;
    }

    private Integer hhknnen;

    @Column(name=GenSV_KiykHnriknSutugkData.HHKNNEN)
    @NaturalNumber
    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenSV_KiykHnriknSutugkData.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private C_KataKbn katakbn;

    @Type(type="UserType_C_KataKbn")
    @Column(name=GenSV_KiykHnriknSutugkData.KATAKBN)
    public C_KataKbn getKatakbn() {
        return katakbn;
    }

    public void setKatakbn(C_KataKbn pKatakbn) {
        katakbn = pKatakbn;
    }

    private C_KyhgndkataKbn kyhgndkatakbn;

    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenSV_KiykHnriknSutugkData.KYHGNDKATAKBN)
    public C_KyhgndkataKbn getKyhgndkatakbn() {
        return kyhgndkatakbn;
    }

    public void setKyhgndkatakbn(C_KyhgndkataKbn pKyhgndkatakbn) {
        kyhgndkatakbn = pKyhgndkatakbn;
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

    private C_Kaiyakuhrtype kaiyakuhrtype;

    @Type(type="UserType_C_Kaiyakuhrtype")
    @Column(name=GenSV_KiykHnriknSutugkData.KAIYAKUHRTYPE)
    public C_Kaiyakuhrtype getKaiyakuhrtype() {
        return kaiyakuhrtype;
    }

    public void setKaiyakuhrtype(C_Kaiyakuhrtype pKaiyakuhrtype) {
        kaiyakuhrtype = pKaiyakuhrtype;
    }

    private C_Segcd seg1cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenSV_KiykHnriknSutugkData.SEG1CD)
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }
}

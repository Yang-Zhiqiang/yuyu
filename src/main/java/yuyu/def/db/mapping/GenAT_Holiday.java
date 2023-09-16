package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HolidayPtn;
import yuyu.def.classification.C_LegalHolidayKbn;
import yuyu.def.db.entity.AT_Holiday;
import yuyu.def.db.id.PKAT_Holiday;
import yuyu.def.db.meta.GenQAT_Holiday;
import yuyu.def.db.meta.QAT_Holiday;
import yuyu.def.db.type.UserType_C_HolidayPtn;
import yuyu.def.db.type.UserType_C_LegalHolidayKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 休日テーブル テーブルのマッピング情報クラスで、 {@link AT_Holiday} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_Holiday}</td><td colspan="3">休日テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHolidayGroupCd holidayGroupCd}</td><td>休日グループコード</td><td align="center">{@link PKAT_Holiday ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHolidayCd holidayCd}</td><td>休日コード</td><td align="center">{@link PKAT_Holiday ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLegalHolidayKbn legalHolidayKbn}</td><td>法定休日区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_LegalHolidayKbn}</td></tr>
 *  <tr><td>{@link #getTekiyouYmdFrom tekiyouYmdFrom}</td><td>適用年月日（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTekiyouYmdTo tekiyouYmdTo}</td><td>適用年月日（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHolidayPattern holidayPattern}</td><td>休日パターン</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HolidayPtn}</td></tr>
 *  <tr><td>{@link #getHolidayPatternParam holidayPatternParam}</td><td>休日パターンパラメータ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHolidayPatternNm holidayPatternNm}</td><td>休日パターン名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHolidayPatternDescription holidayPatternDescription}</td><td>休日パターン備考</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_Holiday
 * @see     PKAT_Holiday
 * @see     QAT_Holiday
 * @see     GenQAT_Holiday
 */
@MappedSuperclass
@Table(name=GenAT_Holiday.TABLE_NAME)
@IdClass(value=PKAT_Holiday.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HolidayPtn", typeClass=UserType_C_HolidayPtn.class),
    @TypeDef(name="UserType_C_LegalHolidayKbn", typeClass=UserType_C_LegalHolidayKbn.class)
})
public abstract class GenAT_Holiday extends AbstractExDBEntity<AT_Holiday, PKAT_Holiday> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_Holiday";
    public static final String HOLIDAYGROUPCD           = "holidayGroupCd";
    public static final String HOLIDAYCD                = "holidayCd";
    public static final String LEGALHOLIDAYKBN          = "legalHolidayKbn";
    public static final String TEKIYOUYMDFROM           = "tekiyouYmdFrom";
    public static final String TEKIYOUYMDTO             = "tekiyouYmdTo";
    public static final String HOLIDAYPATTERN           = "holidayPattern";
    public static final String HOLIDAYPATTERNPARAM      = "holidayPatternParam";
    public static final String HOLIDAYPATTERNNM         = "holidayPatternNm";
    public static final String HOLIDAYPATTERNDESCRIPTION = "holidayPatternDescription";

    private final PKAT_Holiday primaryKey;

    public GenAT_Holiday() {
        primaryKey = new PKAT_Holiday();
    }

    public GenAT_Holiday(String pHolidayGroupCd, String pHolidayCd) {
        primaryKey = new PKAT_Holiday(pHolidayGroupCd, pHolidayCd);
    }

    @Transient
    @Override
    public PKAT_Holiday getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_Holiday> getMetaClass() {
        return QAT_Holiday.class;
    }

    @Id
    @Column(name=GenAT_Holiday.HOLIDAYGROUPCD)
    @MaxLength(max=20)
    @AlphaDigit
    public String getHolidayGroupCd() {
        return getPrimaryKey().getHolidayGroupCd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHolidayGroupCd(String pHolidayGroupCd) {
        getPrimaryKey().setHolidayGroupCd(pHolidayGroupCd);
    }

    @Id
    @Column(name=GenAT_Holiday.HOLIDAYCD)
    public String getHolidayCd() {
        return getPrimaryKey().getHolidayCd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHolidayCd(String pHolidayCd) {
        getPrimaryKey().setHolidayCd(pHolidayCd);
    }

    private C_LegalHolidayKbn legalHolidayKbn;

    @Type(type="UserType_C_LegalHolidayKbn")
    @Column(name=GenAT_Holiday.LEGALHOLIDAYKBN)
    public C_LegalHolidayKbn getLegalHolidayKbn() {
        return legalHolidayKbn;
    }

    public void setLegalHolidayKbn(C_LegalHolidayKbn pLegalHolidayKbn) {
        legalHolidayKbn = pLegalHolidayKbn;
    }

    private BizDate tekiyouYmdFrom;

    @Type(type="BizDateType")
    @Column(name=GenAT_Holiday.TEKIYOUYMDFROM)
    @ValidDate
    public BizDate getTekiyouYmdFrom() {
        return tekiyouYmdFrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTekiyouYmdFrom(BizDate pTekiyouYmdFrom) {
        tekiyouYmdFrom = pTekiyouYmdFrom;
    }

    private BizDate tekiyouYmdTo;

    @Type(type="BizDateType")
    @Column(name=GenAT_Holiday.TEKIYOUYMDTO)
    @ValidDate
    public BizDate getTekiyouYmdTo() {
        return tekiyouYmdTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTekiyouYmdTo(BizDate pTekiyouYmdTo) {
        tekiyouYmdTo = pTekiyouYmdTo;
    }

    private C_HolidayPtn holidayPattern;

    @Type(type="UserType_C_HolidayPtn")
    @Column(name=GenAT_Holiday.HOLIDAYPATTERN)
    public C_HolidayPtn getHolidayPattern() {
        return holidayPattern;
    }

    public void setHolidayPattern(C_HolidayPtn pHolidayPattern) {
        holidayPattern = pHolidayPattern;
    }

    private String holidayPatternParam;

    @Column(name=GenAT_Holiday.HOLIDAYPATTERNPARAM)
    public String getHolidayPatternParam() {
        return holidayPatternParam;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHolidayPatternParam(String pHolidayPatternParam) {
        holidayPatternParam = pHolidayPatternParam;
    }

    private String holidayPatternNm;

    @Column(name=GenAT_Holiday.HOLIDAYPATTERNNM)
    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    public String getHolidayPatternNm() {
        return holidayPatternNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHolidayPatternNm(String pHolidayPatternNm) {
        holidayPatternNm = pHolidayPatternNm;
    }

    private String holidayPatternDescription;

    @Column(name=GenAT_Holiday.HOLIDAYPATTERNDESCRIPTION)
    @MaxLength(max=100)
    @InvalidCharacter
    public String getHolidayPatternDescription() {
        return holidayPatternDescription;
    }

    @Trim("right")
    public void setHolidayPatternDescription(String pHolidayPatternDescription) {
        holidayPatternDescription = pHolidayPatternDescription;
    }
}
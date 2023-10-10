package yuyu.app.base.system.holidaytouroku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import yuyu.def.classification.C_HolidayPtn;
import yuyu.def.classification.C_LegalHolidayKbn;
import yuyu.def.classification.C_YoyakuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 休日登録 - holidayPatternInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHolidayPatternInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String holidayPatternNm;

    public String getHolidayPatternNm() {
        return holidayPatternNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHolidayPatternNm(String pHolidayPatternNm) {
        holidayPatternNm = pHolidayPatternNm;
    }


    private C_HolidayPtn holidayPattern;

    public C_HolidayPtn getHolidayPattern() {
        return holidayPattern;
    }

    public void setHolidayPattern(C_HolidayPtn pHolidayPattern) {
        holidayPattern = pHolidayPattern;
    }


    @ValidDate
    private BizDate tekiyouYmdFrom;

    public BizDate getTekiyouYmdFrom() {
        return tekiyouYmdFrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTekiyouYmdFrom(BizDate pTekiyouYmdFrom) {
        tekiyouYmdFrom = pTekiyouYmdFrom;
    }


    @ValidDate
    private BizDate tekiyouYmdTo;

    public BizDate getTekiyouYmdTo() {
        return tekiyouYmdTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTekiyouYmdTo(BizDate pTekiyouYmdTo) {
        tekiyouYmdTo = pTekiyouYmdTo;
    }


    private C_LegalHolidayKbn legalHolidayKbn;

    public C_LegalHolidayKbn getLegalHolidayKbn() {
        return legalHolidayKbn;
    }

    public void setLegalHolidayKbn(C_LegalHolidayKbn pLegalHolidayKbn) {
        legalHolidayKbn = pLegalHolidayKbn;
    }


    private C_YoyakuKbn yoyakuKbn;

    public C_YoyakuKbn getYoyakuKbn() {
        return yoyakuKbn;
    }

    public void setYoyakuKbn(C_YoyakuKbn pYoyakuKbn) {
        yoyakuKbn = pYoyakuKbn;
    }


    private String henkouLink;

    public String getHenkouLink() {
        return henkouLink;
    }

    public void setHenkouLink(String pHenkouLink) {
        henkouLink = pHenkouLink;
    }


    private String sakujyoLink;

    public String getSakujyoLink() {
        return sakujyoLink;
    }

    public void setSakujyoLink(String pSakujyoLink) {
        sakujyoLink = pSakujyoLink;
    }

}

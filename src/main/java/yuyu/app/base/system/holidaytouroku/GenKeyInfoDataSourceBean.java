package yuyu.app.base.system.holidaytouroku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 休日登録 - keyInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKeyInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @MaxLength(max=20)
    @AlphaDigit
    private String holidayGroupCd;

    public String getHolidayGroupCd() {
        return holidayGroupCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHolidayGroupCd(String pHolidayGroupCd) {
        holidayGroupCd = pHolidayGroupCd;
    }


    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String holidayGroupNm;

    public String getHolidayGroupNm() {
        return holidayGroupNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHolidayGroupNm(String pHolidayGroupNm) {
        holidayGroupNm = pHolidayGroupNm;
    }


    @MaxLength(max=100)
    @InvalidCharacter
    private String holidayGroupDescription;

    public String getHolidayGroupDescription() {
        return holidayGroupDescription;
    }

    @Trim("right")
    public void setHolidayGroupDescription(String pHolidayGroupDescription) {
        holidayGroupDescription = pHolidayGroupDescription;
    }

}

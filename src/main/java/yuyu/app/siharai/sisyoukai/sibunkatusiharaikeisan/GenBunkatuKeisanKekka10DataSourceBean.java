package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●分割計算結果１０ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBunkatuKeisanKekka10DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou10;

    public Boolean getShrtaisyou10() {
        return shrtaisyou10 == null ? Boolean.FALSE : shrtaisyou10;
    }

    public void setShrtaisyou10(Boolean pShrtaisyou10) {
        shrtaisyou10 = pShrtaisyou10 == null ? Boolean.FALSE : pShrtaisyou10;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni10;

    public Integer getUktrjuni10() {
        return uktrjuni10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni10(Integer pUktrjuni10) {
        uktrjuni10 = pUktrjuni10;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi10;

    public Integer getUktrwraibunsi10() {
        return uktrwraibunsi10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi10(Integer pUktrwraibunsi10) {
        uktrwraibunsi10 = pUktrwraibunsi10;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo10;

    public Integer getUktrwraibunbo10() {
        return uktrwraibunbo10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo10(Integer pUktrwraibunbo10) {
        uktrwraibunbo10 = pUktrwraibunbo10;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj10;

    public String getBnktsbuktnmkj10() {
        return bnktsbuktnmkj10;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj10(String pBnktsbuktnmkj10) {
        bnktsbuktnmkj10 = pBnktsbuktnmkj10;
    }

}

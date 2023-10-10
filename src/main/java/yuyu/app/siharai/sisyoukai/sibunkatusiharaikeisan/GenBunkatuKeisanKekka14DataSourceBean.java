package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●分割計算結果１４ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBunkatuKeisanKekka14DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou14;

    public Boolean getShrtaisyou14() {
        return shrtaisyou14 == null ? Boolean.FALSE : shrtaisyou14;
    }

    public void setShrtaisyou14(Boolean pShrtaisyou14) {
        shrtaisyou14 = pShrtaisyou14 == null ? Boolean.FALSE : pShrtaisyou14;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni14;

    public Integer getUktrjuni14() {
        return uktrjuni14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni14(Integer pUktrjuni14) {
        uktrjuni14 = pUktrjuni14;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi14;

    public Integer getUktrwraibunsi14() {
        return uktrwraibunsi14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi14(Integer pUktrwraibunsi14) {
        uktrwraibunsi14 = pUktrwraibunsi14;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo14;

    public Integer getUktrwraibunbo14() {
        return uktrwraibunbo14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo14(Integer pUktrwraibunbo14) {
        uktrwraibunbo14 = pUktrwraibunbo14;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj14;

    public String getBnktsbuktnmkj14() {
        return bnktsbuktnmkj14;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj14(String pBnktsbuktnmkj14) {
        bnktsbuktnmkj14 = pBnktsbuktnmkj14;
    }

}

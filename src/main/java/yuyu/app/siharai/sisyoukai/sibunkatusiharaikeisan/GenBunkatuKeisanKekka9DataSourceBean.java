package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●分割計算結果９ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBunkatuKeisanKekka9DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou9;

    public Boolean getShrtaisyou9() {
        return shrtaisyou9 == null ? Boolean.FALSE : shrtaisyou9;
    }

    public void setShrtaisyou9(Boolean pShrtaisyou9) {
        shrtaisyou9 = pShrtaisyou9 == null ? Boolean.FALSE : pShrtaisyou9;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni9;

    public Integer getUktrjuni9() {
        return uktrjuni9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni9(Integer pUktrjuni9) {
        uktrjuni9 = pUktrjuni9;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi9;

    public Integer getUktrwraibunsi9() {
        return uktrwraibunsi9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi9(Integer pUktrwraibunsi9) {
        uktrwraibunsi9 = pUktrwraibunsi9;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo9;

    public Integer getUktrwraibunbo9() {
        return uktrwraibunbo9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo9(Integer pUktrwraibunbo9) {
        uktrwraibunbo9 = pUktrwraibunbo9;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj9;

    public String getBnktsbuktnmkj9() {
        return bnktsbuktnmkj9;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj9(String pBnktsbuktnmkj9) {
        bnktsbuktnmkj9 = pBnktsbuktnmkj9;
    }

}

package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●分割計算結果１５ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBunkatuKeisanKekka15DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou15;

    public Boolean getShrtaisyou15() {
        return shrtaisyou15 == null ? Boolean.FALSE : shrtaisyou15;
    }

    public void setShrtaisyou15(Boolean pShrtaisyou15) {
        shrtaisyou15 = pShrtaisyou15 == null ? Boolean.FALSE : pShrtaisyou15;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni15;

    public Integer getUktrjuni15() {
        return uktrjuni15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni15(Integer pUktrjuni15) {
        uktrjuni15 = pUktrjuni15;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi15;

    public Integer getUktrwraibunsi15() {
        return uktrwraibunsi15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi15(Integer pUktrwraibunsi15) {
        uktrwraibunsi15 = pUktrwraibunsi15;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo15;

    public Integer getUktrwraibunbo15() {
        return uktrwraibunbo15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo15(Integer pUktrwraibunbo15) {
        uktrwraibunbo15 = pUktrwraibunbo15;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj15;

    public String getBnktsbuktnmkj15() {
        return bnktsbuktnmkj15;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj15(String pBnktsbuktnmkj15) {
        bnktsbuktnmkj15 = pBnktsbuktnmkj15;
    }

}

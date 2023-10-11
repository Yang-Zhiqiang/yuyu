package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●分割計算結果１２ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBunkatuKeisanKekka12DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou12;

    public Boolean getShrtaisyou12() {
        return shrtaisyou12 == null ? Boolean.FALSE : shrtaisyou12;
    }

    public void setShrtaisyou12(Boolean pShrtaisyou12) {
        shrtaisyou12 = pShrtaisyou12 == null ? Boolean.FALSE : pShrtaisyou12;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni12;

    public Integer getUktrjuni12() {
        return uktrjuni12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni12(Integer pUktrjuni12) {
        uktrjuni12 = pUktrjuni12;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi12;

    public Integer getUktrwraibunsi12() {
        return uktrwraibunsi12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi12(Integer pUktrwraibunsi12) {
        uktrwraibunsi12 = pUktrwraibunsi12;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo12;

    public Integer getUktrwraibunbo12() {
        return uktrwraibunbo12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo12(Integer pUktrwraibunbo12) {
        uktrwraibunbo12 = pUktrwraibunbo12;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj12;

    public String getBnktsbuktnmkj12() {
        return bnktsbuktnmkj12;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj12(String pBnktsbuktnmkj12) {
        bnktsbuktnmkj12 = pBnktsbuktnmkj12;
    }

}

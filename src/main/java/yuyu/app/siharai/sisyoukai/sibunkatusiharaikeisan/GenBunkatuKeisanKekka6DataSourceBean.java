package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●分割計算結果６ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBunkatuKeisanKekka6DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou6;

    public Boolean getShrtaisyou6() {
        return shrtaisyou6 == null ? Boolean.FALSE : shrtaisyou6;
    }

    public void setShrtaisyou6(Boolean pShrtaisyou6) {
        shrtaisyou6 = pShrtaisyou6 == null ? Boolean.FALSE : pShrtaisyou6;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni6;

    public Integer getUktrjuni6() {
        return uktrjuni6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni6(Integer pUktrjuni6) {
        uktrjuni6 = pUktrjuni6;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi6;

    public Integer getUktrwraibunsi6() {
        return uktrwraibunsi6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi6(Integer pUktrwraibunsi6) {
        uktrwraibunsi6 = pUktrwraibunsi6;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo6;

    public Integer getUktrwraibunbo6() {
        return uktrwraibunbo6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo6(Integer pUktrwraibunbo6) {
        uktrwraibunbo6 = pUktrwraibunbo6;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj6;

    public String getBnktsbuktnmkj6() {
        return bnktsbuktnmkj6;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj6(String pBnktsbuktnmkj6) {
        bnktsbuktnmkj6 = pBnktsbuktnmkj6;
    }

}

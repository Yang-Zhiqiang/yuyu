package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●分割計算結果３ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBunkatuKeisanKekka3DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou3;

    public Boolean getShrtaisyou3() {
        return shrtaisyou3 == null ? Boolean.FALSE : shrtaisyou3;
    }

    public void setShrtaisyou3(Boolean pShrtaisyou3) {
        shrtaisyou3 = pShrtaisyou3 == null ? Boolean.FALSE : pShrtaisyou3;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni3;

    public Integer getUktrjuni3() {
        return uktrjuni3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni3(Integer pUktrjuni3) {
        uktrjuni3 = pUktrjuni3;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi3;

    public Integer getUktrwraibunsi3() {
        return uktrwraibunsi3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi3(Integer pUktrwraibunsi3) {
        uktrwraibunsi3 = pUktrwraibunsi3;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo3;

    public Integer getUktrwraibunbo3() {
        return uktrwraibunbo3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo3(Integer pUktrwraibunbo3) {
        uktrwraibunbo3 = pUktrwraibunbo3;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj3;

    public String getBnktsbuktnmkj3() {
        return bnktsbuktnmkj3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj3(String pBnktsbuktnmkj3) {
        bnktsbuktnmkj3 = pBnktsbuktnmkj3;
    }

}

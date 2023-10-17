package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●分割計算結果１１ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBunkatuKeisanKekka11DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou11;

    public Boolean getShrtaisyou11() {
        return shrtaisyou11 == null ? Boolean.FALSE : shrtaisyou11;
    }

    public void setShrtaisyou11(Boolean pShrtaisyou11) {
        shrtaisyou11 = pShrtaisyou11 == null ? Boolean.FALSE : pShrtaisyou11;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni11;

    public Integer getUktrjuni11() {
        return uktrjuni11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni11(Integer pUktrjuni11) {
        uktrjuni11 = pUktrjuni11;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi11;

    public Integer getUktrwraibunsi11() {
        return uktrwraibunsi11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi11(Integer pUktrwraibunsi11) {
        uktrwraibunsi11 = pUktrwraibunsi11;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo11;

    public Integer getUktrwraibunbo11() {
        return uktrwraibunbo11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo11(Integer pUktrwraibunbo11) {
        uktrwraibunbo11 = pUktrwraibunbo11;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj11;

    public String getBnktsbuktnmkj11() {
        return bnktsbuktnmkj11;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj11(String pBnktsbuktnmkj11) {
        bnktsbuktnmkj11 = pBnktsbuktnmkj11;
    }

}

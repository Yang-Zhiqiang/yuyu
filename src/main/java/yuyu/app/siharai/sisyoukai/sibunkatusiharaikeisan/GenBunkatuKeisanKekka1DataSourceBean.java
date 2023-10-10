package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●分割計算結果１ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBunkatuKeisanKekka1DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou1;

    public Boolean getShrtaisyou1() {
        return shrtaisyou1 == null ? Boolean.FALSE : shrtaisyou1;
    }

    public void setShrtaisyou1(Boolean pShrtaisyou1) {
        shrtaisyou1 = pShrtaisyou1 == null ? Boolean.FALSE : pShrtaisyou1;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni1;

    public Integer getUktrjuni1() {
        return uktrjuni1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni1(Integer pUktrjuni1) {
        uktrjuni1 = pUktrjuni1;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi1;

    public Integer getUktrwraibunsi1() {
        return uktrwraibunsi1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi1(Integer pUktrwraibunsi1) {
        uktrwraibunsi1 = pUktrwraibunsi1;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo1;

    public Integer getUktrwraibunbo1() {
        return uktrwraibunbo1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo1(Integer pUktrwraibunbo1) {
        uktrwraibunbo1 = pUktrwraibunbo1;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj1;

    public String getBnktsbuktnmkj1() {
        return bnktsbuktnmkj1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj1(String pBnktsbuktnmkj1) {
        bnktsbuktnmkj1 = pBnktsbuktnmkj1;
    }

}

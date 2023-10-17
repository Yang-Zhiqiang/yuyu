package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●分割計算結果１３ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBunkatuKeisanKekka13DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou13;

    public Boolean getShrtaisyou13() {
        return shrtaisyou13 == null ? Boolean.FALSE : shrtaisyou13;
    }

    public void setShrtaisyou13(Boolean pShrtaisyou13) {
        shrtaisyou13 = pShrtaisyou13 == null ? Boolean.FALSE : pShrtaisyou13;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni13;

    public Integer getUktrjuni13() {
        return uktrjuni13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni13(Integer pUktrjuni13) {
        uktrjuni13 = pUktrjuni13;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi13;

    public Integer getUktrwraibunsi13() {
        return uktrwraibunsi13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi13(Integer pUktrwraibunsi13) {
        uktrwraibunsi13 = pUktrwraibunsi13;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo13;

    public Integer getUktrwraibunbo13() {
        return uktrwraibunbo13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo13(Integer pUktrwraibunbo13) {
        uktrwraibunbo13 = pUktrwraibunbo13;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj13;

    public String getBnktsbuktnmkj13() {
        return bnktsbuktnmkj13;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj13(String pBnktsbuktnmkj13) {
        bnktsbuktnmkj13 = pBnktsbuktnmkj13;
    }

}

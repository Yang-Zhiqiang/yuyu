package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●分割計算結果８ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBunkatuKeisanKekka8DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou8;

    public Boolean getShrtaisyou8() {
        return shrtaisyou8 == null ? Boolean.FALSE : shrtaisyou8;
    }

    public void setShrtaisyou8(Boolean pShrtaisyou8) {
        shrtaisyou8 = pShrtaisyou8 == null ? Boolean.FALSE : pShrtaisyou8;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni8;

    public Integer getUktrjuni8() {
        return uktrjuni8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni8(Integer pUktrjuni8) {
        uktrjuni8 = pUktrjuni8;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi8;

    public Integer getUktrwraibunsi8() {
        return uktrwraibunsi8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi8(Integer pUktrwraibunsi8) {
        uktrwraibunsi8 = pUktrwraibunsi8;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo8;

    public Integer getUktrwraibunbo8() {
        return uktrwraibunbo8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo8(Integer pUktrwraibunbo8) {
        uktrwraibunbo8 = pUktrwraibunbo8;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj8;

    public String getBnktsbuktnmkj8() {
        return bnktsbuktnmkj8;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj8(String pBnktsbuktnmkj8) {
        bnktsbuktnmkj8 = pBnktsbuktnmkj8;
    }

}

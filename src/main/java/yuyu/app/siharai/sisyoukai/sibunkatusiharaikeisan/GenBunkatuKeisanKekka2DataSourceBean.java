package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●分割計算結果２ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBunkatuKeisanKekka2DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou2;

    public Boolean getShrtaisyou2() {
        return shrtaisyou2 == null ? Boolean.FALSE : shrtaisyou2;
    }

    public void setShrtaisyou2(Boolean pShrtaisyou2) {
        shrtaisyou2 = pShrtaisyou2 == null ? Boolean.FALSE : pShrtaisyou2;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni2;

    public Integer getUktrjuni2() {
        return uktrjuni2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni2(Integer pUktrjuni2) {
        uktrjuni2 = pUktrjuni2;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi2;

    public Integer getUktrwraibunsi2() {
        return uktrwraibunsi2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi2(Integer pUktrwraibunsi2) {
        uktrwraibunsi2 = pUktrwraibunsi2;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo2;

    public Integer getUktrwraibunbo2() {
        return uktrwraibunbo2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo2(Integer pUktrwraibunbo2) {
        uktrwraibunbo2 = pUktrwraibunbo2;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj2;

    public String getBnktsbuktnmkj2() {
        return bnktsbuktnmkj2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj2(String pBnktsbuktnmkj2) {
        bnktsbuktnmkj2 = pBnktsbuktnmkj2;
    }

}

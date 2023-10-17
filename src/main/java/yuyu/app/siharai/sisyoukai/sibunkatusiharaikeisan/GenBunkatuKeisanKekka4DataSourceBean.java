package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●分割計算結果４ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBunkatuKeisanKekka4DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou4;

    public Boolean getShrtaisyou4() {
        return shrtaisyou4 == null ? Boolean.FALSE : shrtaisyou4;
    }

    public void setShrtaisyou4(Boolean pShrtaisyou4) {
        shrtaisyou4 = pShrtaisyou4 == null ? Boolean.FALSE : pShrtaisyou4;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni4;

    public Integer getUktrjuni4() {
        return uktrjuni4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni4(Integer pUktrjuni4) {
        uktrjuni4 = pUktrjuni4;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi4;

    public Integer getUktrwraibunsi4() {
        return uktrwraibunsi4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi4(Integer pUktrwraibunsi4) {
        uktrwraibunsi4 = pUktrwraibunsi4;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo4;

    public Integer getUktrwraibunbo4() {
        return uktrwraibunbo4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo4(Integer pUktrwraibunbo4) {
        uktrwraibunbo4 = pUktrwraibunbo4;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj4;

    public String getBnktsbuktnmkj4() {
        return bnktsbuktnmkj4;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj4(String pBnktsbuktnmkj4) {
        bnktsbuktnmkj4 = pBnktsbuktnmkj4;
    }

}

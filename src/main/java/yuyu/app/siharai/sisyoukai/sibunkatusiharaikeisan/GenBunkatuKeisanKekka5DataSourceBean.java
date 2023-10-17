package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●分割計算結果５ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBunkatuKeisanKekka5DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou5;

    public Boolean getShrtaisyou5() {
        return shrtaisyou5 == null ? Boolean.FALSE : shrtaisyou5;
    }

    public void setShrtaisyou5(Boolean pShrtaisyou5) {
        shrtaisyou5 = pShrtaisyou5 == null ? Boolean.FALSE : pShrtaisyou5;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni5;

    public Integer getUktrjuni5() {
        return uktrjuni5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni5(Integer pUktrjuni5) {
        uktrjuni5 = pUktrjuni5;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi5;

    public Integer getUktrwraibunsi5() {
        return uktrwraibunsi5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi5(Integer pUktrwraibunsi5) {
        uktrwraibunsi5 = pUktrwraibunsi5;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo5;

    public Integer getUktrwraibunbo5() {
        return uktrwraibunbo5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo5(Integer pUktrwraibunbo5) {
        uktrwraibunbo5 = pUktrwraibunbo5;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj5;

    public String getBnktsbuktnmkj5() {
        return bnktsbuktnmkj5;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj5(String pBnktsbuktnmkj5) {
        bnktsbuktnmkj5 = pBnktsbuktnmkj5;
    }

}

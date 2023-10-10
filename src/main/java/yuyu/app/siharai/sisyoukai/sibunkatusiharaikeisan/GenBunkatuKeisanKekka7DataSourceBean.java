package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●分割計算結果７ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBunkatuKeisanKekka7DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou7;

    public Boolean getShrtaisyou7() {
        return shrtaisyou7 == null ? Boolean.FALSE : shrtaisyou7;
    }

    public void setShrtaisyou7(Boolean pShrtaisyou7) {
        shrtaisyou7 = pShrtaisyou7 == null ? Boolean.FALSE : pShrtaisyou7;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni7;

    public Integer getUktrjuni7() {
        return uktrjuni7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni7(Integer pUktrjuni7) {
        uktrjuni7 = pUktrjuni7;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi7;

    public Integer getUktrwraibunsi7() {
        return uktrwraibunsi7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi7(Integer pUktrwraibunsi7) {
        uktrwraibunsi7 = pUktrwraibunsi7;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo7;

    public Integer getUktrwraibunbo7() {
        return uktrwraibunbo7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo7(Integer pUktrwraibunbo7) {
        uktrwraibunbo7 = pUktrwraibunbo7;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj7;

    public String getBnktsbuktnmkj7() {
        return bnktsbuktnmkj7;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj7(String pBnktsbuktnmkj7) {
        bnktsbuktnmkj7 = pBnktsbuktnmkj7;
    }

}

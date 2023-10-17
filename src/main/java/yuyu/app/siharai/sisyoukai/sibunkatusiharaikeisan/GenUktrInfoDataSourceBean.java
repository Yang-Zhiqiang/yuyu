package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 分割支払計算 - ●受取人情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenUktrInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean shrtaisyou;

    public Boolean getShrtaisyou() {
        return shrtaisyou == null ? Boolean.FALSE : shrtaisyou;
    }

    public void setShrtaisyou(Boolean pShrtaisyou) {
        shrtaisyou = pShrtaisyou == null ? Boolean.FALSE : pShrtaisyou;
    }


    @Range(min="0", max="99")
    private Integer uktrjuni;

    public Integer getUktrjuni() {
        return uktrjuni;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrjuni(Integer pUktrjuni) {
        uktrjuni = pUktrjuni;
    }


    @Range(min="1", max="99")
    private Integer uktrwraibunsi;

    public Integer getUktrwraibunsi() {
        return uktrwraibunsi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunsi(Integer pUktrwraibunsi) {
        uktrwraibunsi = pUktrwraibunsi;
    }


    @Range(min="1", max="100")
    private Integer uktrwraibunbo;

    public Integer getUktrwraibunbo() {
        return uktrwraibunbo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktrwraibunbo(Integer pUktrwraibunbo) {
        uktrwraibunbo = pUktrwraibunbo;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String bnktsbuktnmkj;

    public String getBnktsbuktnmkj() {
        return bnktsbuktnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBnktsbuktnmkj(String pBnktsbuktnmkj) {
        bnktsbuktnmkj = pBnktsbuktnmkj;
    }

}

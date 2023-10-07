package yuyu.app.siharai.sikensaku.sisrchbyoumei;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.def.classification.C_ByoumeiGaitouKbn2;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 病名検索 - searchResults の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSearchResultsDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Length(length=4)
    @AlphaDigit
    private String byoumeicd;

    public String getByoumeicd() {
        return byoumeicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setByoumeicd(String pByoumeicd) {
        byoumeicd = pByoumeicd;
    }


    @MaxLength(max=100)
    @MultiByteStrings
    @InvalidCharacter
    private String byoumeikj;

    public String getByoumeikj() {
        return byoumeikj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setByoumeikj(String pByoumeikj) {
        byoumeikj = pByoumeikj;
    }


    @MaxLength(max=60)
    @MultiByteStrings
    @InvalidCharacter
    private String byoumeikn;

    public String getByoumeikn() {
        return byoumeikn;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setByoumeikn(String pByoumeikn) {
        byoumeikn = pByoumeikn;
    }


    private C_ByoumeiGaitouKbn2 gaitoukbn2;

    public C_ByoumeiGaitouKbn2 getGaitoukbn2() {
        return gaitoukbn2;
    }

    public void setGaitoukbn2(C_ByoumeiGaitouKbn2 pGaitoukbn2) {
        gaitoukbn2 = pGaitoukbn2;
    }


    private String byoumeitourokuno;

    public String getByoumeitourokuno() {
        return byoumeitourokuno;
    }

    public void setByoumeitourokuno(String pByoumeitourokuno) {
        byoumeitourokuno = pByoumeitourokuno;
    }

}

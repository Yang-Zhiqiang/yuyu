package yuyu.app.siharai.sisatei.sisateisb;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.def.classification.C_Delflag;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * （死亡）査定 - viewSindansyoinfoSibouInfo1 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenViewSindansyoinfoSibouInfo1DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String searchlink;

    public String getSearchlink() {
        return searchlink;
    }

    public void setSearchlink(String pSearchlink) {
        searchlink = pSearchlink;
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


    private String sakujyoLink;

    public String getSakujyoLink() {
        return sakujyoLink;
    }

    public void setSakujyoLink(String pSakujyoLink) {
        sakujyoLink = pSakujyoLink;
    }


    private C_Delflag sakujyoflg;

    public C_Delflag getSakujyoflg() {
        return sakujyoflg;
    }

    public void setSakujyoflg(C_Delflag pSakujyoflg) {
        sakujyoflg = pSakujyoflg;
    }


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


    private String byoumeitourokuno;

    public String getByoumeitourokuno() {
        return byoumeitourokuno;
    }

    public void setByoumeitourokuno(String pByoumeitourokuno) {
        byoumeitourokuno = pByoumeitourokuno;
    }

}

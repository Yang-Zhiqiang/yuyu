package yuyu.app.base.system.kadoutimegrouptouroku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 稼働時間グループ登録 - kadouTimeGroupInfoList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKadouTimeGroupInfoListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @MaxLength(max=20)
    @AlphaDigit
    private String kadouTimeGroupCd;

    public String getKadouTimeGroupCd() {
        return kadouTimeGroupCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKadouTimeGroupCd(String pKadouTimeGroupCd) {
        kadouTimeGroupCd = pKadouTimeGroupCd;
    }


    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String kadouTimeGroupNm;

    public String getKadouTimeGroupNm() {
        return kadouTimeGroupNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKadouTimeGroupNm(String pKadouTimeGroupNm) {
        kadouTimeGroupNm = pKadouTimeGroupNm;
    }


    @MaxLength(max=100)
    @InvalidCharacter
    private String kadouTimeGroupDescription;

    public String getKadouTimeGroupDescription() {
        return kadouTimeGroupDescription;
    }

    @Trim("right")
    public void setKadouTimeGroupDescription(String pKadouTimeGroupDescription) {
        kadouTimeGroupDescription = pKadouTimeGroupDescription;
    }


    private String henkouLink;

    public String getHenkouLink() {
        return henkouLink;
    }

    public void setHenkouLink(String pHenkouLink) {
        henkouLink = pHenkouLink;
    }


    private String sakujyoLink;

    public String getSakujyoLink() {
        return sakujyoLink;
    }

    public void setSakujyoLink(String pSakujyoLink) {
        sakujyoLink = pSakujyoLink;
    }

}

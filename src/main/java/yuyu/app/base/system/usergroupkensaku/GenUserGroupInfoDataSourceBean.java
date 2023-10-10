package yuyu.app.base.system.usergroupkensaku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * ユーザーグループ検索 - userGroupInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenUserGroupInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @MaxLength(max=30)
    @AlphaDigit
    private String userGroupCd;

    public String getUserGroupCd() {
        return userGroupCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserGroupCd(String pUserGroupCd) {
        userGroupCd = pUserGroupCd;
    }


    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String userGroupNm;

    public String getUserGroupNm() {
        return userGroupNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUserGroupNm(String pUserGroupNm) {
        userGroupNm = pUserGroupNm;
    }

}

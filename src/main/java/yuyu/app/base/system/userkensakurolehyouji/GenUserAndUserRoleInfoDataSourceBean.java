package yuyu.app.base.system.userkensakurolehyouji;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * ユーザー検索（ロール表示用） - userAndUserRoleInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenUserAndUserRoleInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @MaxLength(max=30)
    @AlphaDigit
    private String userId;

    public String getUserId() {
        return userId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserId(String pUserId) {
        userId = pUserId;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String userNm;

    public String getUserNm() {
        return userNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUserNm(String pUserNm) {
        userNm = pUserNm;
    }


    @MaxLength(max=30)
    @AlphaDigit
    private String roleCd;

    public String getRoleCd() {
        return roleCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRoleCd(String pRoleCd) {
        roleCd = pRoleCd;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String roleNm;

    public String getRoleNm() {
        return roleNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setRoleNm(String pRoleNm) {
        roleNm = pRoleNm;
    }

}

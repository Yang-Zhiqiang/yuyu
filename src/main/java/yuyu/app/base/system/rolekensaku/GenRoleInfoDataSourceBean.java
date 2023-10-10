package yuyu.app.base.system.rolekensaku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * ロール検索 - roleInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenRoleInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

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

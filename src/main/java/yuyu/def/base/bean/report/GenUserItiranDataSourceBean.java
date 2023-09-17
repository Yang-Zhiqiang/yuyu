package yuyu.def.base.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import yuyu.def.classification.C_KyokaKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * ユーザー一覧データソース データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenUserItiranDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenUserItiranDataSourceBean() {
    }

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

    @ValidDate
    private BizDate passwordSetteiYmd;

    public BizDate getPasswordSetteiYmd() {
        return passwordSetteiYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPasswordSetteiYmd(BizDate pPasswordSetteiYmd) {
        passwordSetteiYmd = pPasswordSetteiYmd;
    }

    @ValidDate
    private BizDate passwordYuukouKigenYmd;

    public BizDate getPasswordYuukouKigenYmd() {
        return passwordYuukouKigenYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPasswordYuukouKigenYmd(BizDate pPasswordYuukouKigenYmd) {
        passwordYuukouKigenYmd = pPasswordYuukouKigenYmd;
    }

    private C_KyokaKbn passwordHenkouKyokaKbn;

    public C_KyokaKbn getPasswordHenkouKyokaKbn() {
        return passwordHenkouKyokaKbn;
    }

    public void setPasswordHenkouKyokaKbn(C_KyokaKbn pPasswordHenkouKyokaKbn) {
        passwordHenkouKyokaKbn = pPasswordHenkouKyokaKbn;
    }

    private C_KyokaKbn loginKyokaKbn;

    public C_KyokaKbn getLoginKyokaKbn() {
        return loginKyokaKbn;
    }

    public void setLoginKyokaKbn(C_KyokaKbn pLoginKyokaKbn) {
        loginKyokaKbn = pLoginKyokaKbn;
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

    private Boolean hoyuuRoleKakuninFlg;

    public Boolean getHoyuuRoleKakuninFlg() {
        return hoyuuRoleKakuninFlg;
    }

    public void setHoyuuRoleKakuninFlg(Boolean pHoyuuRoleKakuninFlg) {
        hoyuuRoleKakuninFlg = pHoyuuRoleKakuninFlg;
    }

    private String lastLoginTime;

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLastLoginTime(String pLastLoginTime) {
        lastLoginTime = pLastLoginTime;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}

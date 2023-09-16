package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KyokaKbn;
import yuyu.def.classification.C_PasswordYuukouKikanKbn;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.classification.C_YoukyuuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.id.PKAM_User;
import yuyu.def.db.meta.GenQAM_User;
import yuyu.def.db.meta.QAM_User;
import yuyu.def.db.type.UserType_C_KyokaKbn;
import yuyu.def.db.type.UserType_C_PasswordYuukouKikanKbn;
import yuyu.def.db.type.UserType_C_SpecialUserKbn;
import yuyu.def.db.type.UserType_C_YoukyuuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * ユーザーマスタ テーブルのマッピング情報クラスで、 {@link AM_User} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_User}</td><td colspan="3">ユーザーマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">{@link PKAM_User ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUserNm userNm}</td><td>ユーザー名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUserGroupCd userGroupCd}</td><td>ユーザーグループコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSpecialUserKbn specialUserKbn}</td><td>特別ユーザー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SpecialUserKbn}</td></tr>
 *  <tr><td>{@link #getPassword password}</td><td>パスワード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPasswordSetteiYmd passwordSetteiYmd}</td><td>パスワード設定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getPasswordYuukouKigenYmd passwordYuukouKigenYmd}</td><td>パスワード有効期限年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getPasswordYuukouCountY passwordYuukouCountY}</td><td>パスワード有効年数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getPasswordYuukouCountM passwordYuukouCountM}</td><td>パスワード有効月数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getPasswordYuukouCountD passwordYuukouCountD}</td><td>パスワード有効日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getPasswordYuukouKikanKbn passwordYuukouKikanKbn}</td><td>パスワード有効期間区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PasswordYuukouKikanKbn}</td></tr>
 *  <tr><td>{@link #getPasswordHenkouKyokaKbn passwordHenkouKyokaKbn}</td><td>パスワード変更許可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyokaKbn}</td></tr>
 *  <tr><td>{@link #getPasswordHenkouYoukyuuKbn passwordHenkouYoukyuuKbn}</td><td>パスワード変更要求区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YoukyuuKbn}</td></tr>
 *  <tr><td>{@link #getLoginKyokaKbn loginKyokaKbn}</td><td>ログイン許可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyokaKbn}</td></tr>
 *  <tr><td>{@link #getLoginErrorCount loginErrorCount}</td><td>ログインエラー回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLastLoginTime lastLoginTime}</td><td>最終ログイン時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_User
 * @see     PKAM_User
 * @see     QAM_User
 * @see     GenQAM_User
 */
@MappedSuperclass
@Table(name=GenAM_User.TABLE_NAME)
@IdClass(value=PKAM_User.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KyokaKbn", typeClass=UserType_C_KyokaKbn.class),
    @TypeDef(name="UserType_C_PasswordYuukouKikanKbn", typeClass=UserType_C_PasswordYuukouKikanKbn.class),
    @TypeDef(name="UserType_C_SpecialUserKbn", typeClass=UserType_C_SpecialUserKbn.class),
    @TypeDef(name="UserType_C_YoukyuuKbn", typeClass=UserType_C_YoukyuuKbn.class)
})
public abstract class GenAM_User extends AbstractExDBEntity<AM_User, PKAM_User> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AM_User";
    public static final String USERID                   = "userId";
    public static final String USERNM                   = "userNm";
    public static final String USERGROUPCD              = "userGroupCd";
    public static final String SPECIALUSERKBN           = "specialUserKbn";
    public static final String PASSWORD                 = "password";
    public static final String PASSWORDSETTEIYMD        = "passwordSetteiYmd";
    public static final String PASSWORDYUUKOUKIGENYMD   = "passwordYuukouKigenYmd";
    public static final String PASSWORDYUUKOUCOUNTY     = "passwordYuukouCountY";
    public static final String PASSWORDYUUKOUCOUNTM     = "passwordYuukouCountM";
    public static final String PASSWORDYUUKOUCOUNTD     = "passwordYuukouCountD";
    public static final String PASSWORDYUUKOUKIKANKBN   = "passwordYuukouKikanKbn";
    public static final String PASSWORDHENKOUKYOKAKBN   = "passwordHenkouKyokaKbn";
    public static final String PASSWORDHENKOUYOUKYUUKBN = "passwordHenkouYoukyuuKbn";
    public static final String LOGINKYOKAKBN            = "loginKyokaKbn";
    public static final String LOGINERRORCOUNT          = "loginErrorCount";
    public static final String LASTLOGINTIME            = "lastLoginTime";

    private final PKAM_User primaryKey;

    public GenAM_User() {
        primaryKey = new PKAM_User();
    }

    public GenAM_User(String pUserId) {
        primaryKey = new PKAM_User(pUserId);
    }

    @Transient
    @Override
    public PKAM_User getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAM_User> getMetaClass() {
        return QAM_User.class;
    }

    @Id
    @Column(name=GenAM_User.USERID)
    @MaxLength(max=30)
    @AlphaDigit
    public String getUserId() {
        return getPrimaryKey().getUserId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserId(String pUserId) {
        getPrimaryKey().setUserId(pUserId);
    }

    private String userNm;

    @Column(name=GenAM_User.USERNM)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getUserNm() {
        return userNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUserNm(String pUserNm) {
        userNm = pUserNm;
    }

    private String userGroupCd;

    @Column(name=GenAM_User.USERGROUPCD)
    @MaxLength(max=30)
    @AlphaDigit
    public String getUserGroupCd() {
        return userGroupCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserGroupCd(String pUserGroupCd) {
        userGroupCd = pUserGroupCd;
    }

    private C_SpecialUserKbn specialUserKbn;

    @Type(type="UserType_C_SpecialUserKbn")
    @Column(name=GenAM_User.SPECIALUSERKBN)
    public C_SpecialUserKbn getSpecialUserKbn() {
        return specialUserKbn;
    }

    public void setSpecialUserKbn(C_SpecialUserKbn pSpecialUserKbn) {
        specialUserKbn = pSpecialUserKbn;
    }

    private String password;

    @Column(name=GenAM_User.PASSWORD)
    @AlphaDigit
    public String getPassword() {
        return password;
    }

    public void setPassword(String pPassword) {
        password = pPassword;
    }

    private BizDate passwordSetteiYmd;

    @Type(type="BizDateType")
    @Column(name=GenAM_User.PASSWORDSETTEIYMD)
    @ValidDate
    public BizDate getPasswordSetteiYmd() {
        return passwordSetteiYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPasswordSetteiYmd(BizDate pPasswordSetteiYmd) {
        passwordSetteiYmd = pPasswordSetteiYmd;
    }

    private BizDate passwordYuukouKigenYmd;

    @Type(type="BizDateType")
    @Column(name=GenAM_User.PASSWORDYUUKOUKIGENYMD)
    @ValidDate
    public BizDate getPasswordYuukouKigenYmd() {
        return passwordYuukouKigenYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPasswordYuukouKigenYmd(BizDate pPasswordYuukouKigenYmd) {
        passwordYuukouKigenYmd = pPasswordYuukouKigenYmd;
    }

    private Integer passwordYuukouCountY;

    @Column(name=GenAM_User.PASSWORDYUUKOUCOUNTY)
    @Range(min="0", max="99")
    public Integer getPasswordYuukouCountY() {
        return passwordYuukouCountY;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPasswordYuukouCountY(Integer pPasswordYuukouCountY) {
        passwordYuukouCountY = pPasswordYuukouCountY;
    }

    private Integer passwordYuukouCountM;

    @Column(name=GenAM_User.PASSWORDYUUKOUCOUNTM)
    @Range(min="0", max="11")
    public Integer getPasswordYuukouCountM() {
        return passwordYuukouCountM;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPasswordYuukouCountM(Integer pPasswordYuukouCountM) {
        passwordYuukouCountM = pPasswordYuukouCountM;
    }

    private Integer passwordYuukouCountD;

    @Column(name=GenAM_User.PASSWORDYUUKOUCOUNTD)
    @Range(min="0", max="30")
    public Integer getPasswordYuukouCountD() {
        return passwordYuukouCountD;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPasswordYuukouCountD(Integer pPasswordYuukouCountD) {
        passwordYuukouCountD = pPasswordYuukouCountD;
    }

    private C_PasswordYuukouKikanKbn passwordYuukouKikanKbn;

    @Type(type="UserType_C_PasswordYuukouKikanKbn")
    @Column(name=GenAM_User.PASSWORDYUUKOUKIKANKBN)
    public C_PasswordYuukouKikanKbn getPasswordYuukouKikanKbn() {
        return passwordYuukouKikanKbn;
    }

    public void setPasswordYuukouKikanKbn(C_PasswordYuukouKikanKbn pPasswordYuukouKikanKbn) {
        passwordYuukouKikanKbn = pPasswordYuukouKikanKbn;
    }

    private C_KyokaKbn passwordHenkouKyokaKbn;

    @Type(type="UserType_C_KyokaKbn")
    @Column(name=GenAM_User.PASSWORDHENKOUKYOKAKBN)
    public C_KyokaKbn getPasswordHenkouKyokaKbn() {
        return passwordHenkouKyokaKbn;
    }

    public void setPasswordHenkouKyokaKbn(C_KyokaKbn pPasswordHenkouKyokaKbn) {
        passwordHenkouKyokaKbn = pPasswordHenkouKyokaKbn;
    }

    private C_YoukyuuKbn passwordHenkouYoukyuuKbn;

    @Type(type="UserType_C_YoukyuuKbn")
    @Column(name=GenAM_User.PASSWORDHENKOUYOUKYUUKBN)
    public C_YoukyuuKbn getPasswordHenkouYoukyuuKbn() {
        return passwordHenkouYoukyuuKbn;
    }

    public void setPasswordHenkouYoukyuuKbn(C_YoukyuuKbn pPasswordHenkouYoukyuuKbn) {
        passwordHenkouYoukyuuKbn = pPasswordHenkouYoukyuuKbn;
    }

    private C_KyokaKbn loginKyokaKbn;

    @Type(type="UserType_C_KyokaKbn")
    @Column(name=GenAM_User.LOGINKYOKAKBN)
    public C_KyokaKbn getLoginKyokaKbn() {
        return loginKyokaKbn;
    }

    public void setLoginKyokaKbn(C_KyokaKbn pLoginKyokaKbn) {
        loginKyokaKbn = pLoginKyokaKbn;
    }

    private Integer loginErrorCount;

    @Column(name=GenAM_User.LOGINERRORCOUNT)
    public Integer getLoginErrorCount() {
        return loginErrorCount;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLoginErrorCount(Integer pLoginErrorCount) {
        loginErrorCount = pLoginErrorCount;
    }

    private String lastLoginTime;

    @Column(name=GenAM_User.LASTLOGINTIME)
    public String getLastLoginTime() {
        return lastLoginTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLastLoginTime(String pLastLoginTime) {
        lastLoginTime = pLastLoginTime;
    }
}

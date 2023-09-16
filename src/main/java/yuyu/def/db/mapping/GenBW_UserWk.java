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
import yuyu.def.db.entity.BW_UserWk;
import yuyu.def.db.id.PKBW_UserWk;
import yuyu.def.db.meta.GenQBW_UserWk;
import yuyu.def.db.meta.QBW_UserWk;
import yuyu.def.db.type.UserType_C_KyokaKbn;
import yuyu.def.db.type.UserType_C_PasswordYuukouKikanKbn;
import yuyu.def.db.type.UserType_C_SpecialUserKbn;
import yuyu.def.db.type.UserType_C_YoukyuuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * ユーザーマスタワークテーブル テーブルのマッピング情報クラスで、 {@link BW_UserWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BW_UserWk}</td><td colspan="3">ユーザーマスタワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">{@link PKBW_UserWk ○}</td><td align="center">V</td><td>String</td></tr>
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
 * @see     BW_UserWk
 * @see     PKBW_UserWk
 * @see     QBW_UserWk
 * @see     GenQBW_UserWk
 */
@MappedSuperclass
@Table(name=GenBW_UserWk.TABLE_NAME)
@IdClass(value=PKBW_UserWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KyokaKbn", typeClass=UserType_C_KyokaKbn.class),
    @TypeDef(name="UserType_C_PasswordYuukouKikanKbn", typeClass=UserType_C_PasswordYuukouKikanKbn.class),
    @TypeDef(name="UserType_C_SpecialUserKbn", typeClass=UserType_C_SpecialUserKbn.class),
    @TypeDef(name="UserType_C_YoukyuuKbn", typeClass=UserType_C_YoukyuuKbn.class)
})
public abstract class GenBW_UserWk extends AbstractExDBEntity<BW_UserWk, PKBW_UserWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BW_UserWk";
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

    private final PKBW_UserWk primaryKey;

    public GenBW_UserWk() {
        primaryKey = new PKBW_UserWk();
    }

    public GenBW_UserWk(String pUserId) {
        primaryKey = new PKBW_UserWk(pUserId);
    }

    @Transient
    @Override
    public PKBW_UserWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBW_UserWk> getMetaClass() {
        return QBW_UserWk.class;
    }

    @Id
    @Column(name=GenBW_UserWk.USERID)
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

    @Column(name=GenBW_UserWk.USERNM)
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

    @Column(name=GenBW_UserWk.USERGROUPCD)
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
    @Column(name=GenBW_UserWk.SPECIALUSERKBN)
    public C_SpecialUserKbn getSpecialUserKbn() {
        return specialUserKbn;
    }

    public void setSpecialUserKbn(C_SpecialUserKbn pSpecialUserKbn) {
        specialUserKbn = pSpecialUserKbn;
    }

    private String password;

    @Column(name=GenBW_UserWk.PASSWORD)
    @AlphaDigit
    public String getPassword() {
        return password;
    }

    public void setPassword(String pPassword) {
        password = pPassword;
    }

    private BizDate passwordSetteiYmd;

    @Type(type="BizDateType")
    @Column(name=GenBW_UserWk.PASSWORDSETTEIYMD)
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
    @Column(name=GenBW_UserWk.PASSWORDYUUKOUKIGENYMD)
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

    @Column(name=GenBW_UserWk.PASSWORDYUUKOUCOUNTY)
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

    @Column(name=GenBW_UserWk.PASSWORDYUUKOUCOUNTM)
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

    @Column(name=GenBW_UserWk.PASSWORDYUUKOUCOUNTD)
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
    @Column(name=GenBW_UserWk.PASSWORDYUUKOUKIKANKBN)
    public C_PasswordYuukouKikanKbn getPasswordYuukouKikanKbn() {
        return passwordYuukouKikanKbn;
    }

    public void setPasswordYuukouKikanKbn(C_PasswordYuukouKikanKbn pPasswordYuukouKikanKbn) {
        passwordYuukouKikanKbn = pPasswordYuukouKikanKbn;
    }

    private C_KyokaKbn passwordHenkouKyokaKbn;

    @Type(type="UserType_C_KyokaKbn")
    @Column(name=GenBW_UserWk.PASSWORDHENKOUKYOKAKBN)
    public C_KyokaKbn getPasswordHenkouKyokaKbn() {
        return passwordHenkouKyokaKbn;
    }

    public void setPasswordHenkouKyokaKbn(C_KyokaKbn pPasswordHenkouKyokaKbn) {
        passwordHenkouKyokaKbn = pPasswordHenkouKyokaKbn;
    }

    private C_YoukyuuKbn passwordHenkouYoukyuuKbn;

    @Type(type="UserType_C_YoukyuuKbn")
    @Column(name=GenBW_UserWk.PASSWORDHENKOUYOUKYUUKBN)
    public C_YoukyuuKbn getPasswordHenkouYoukyuuKbn() {
        return passwordHenkouYoukyuuKbn;
    }

    public void setPasswordHenkouYoukyuuKbn(C_YoukyuuKbn pPasswordHenkouYoukyuuKbn) {
        passwordHenkouYoukyuuKbn = pPasswordHenkouYoukyuuKbn;
    }

    private C_KyokaKbn loginKyokaKbn;

    @Type(type="UserType_C_KyokaKbn")
    @Column(name=GenBW_UserWk.LOGINKYOKAKBN)
    public C_KyokaKbn getLoginKyokaKbn() {
        return loginKyokaKbn;
    }

    public void setLoginKyokaKbn(C_KyokaKbn pLoginKyokaKbn) {
        loginKyokaKbn = pLoginKyokaKbn;
    }

    private Integer loginErrorCount;

    @Column(name=GenBW_UserWk.LOGINERRORCOUNT)
    public Integer getLoginErrorCount() {
        return loginErrorCount;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLoginErrorCount(Integer pLoginErrorCount) {
        loginErrorCount = pLoginErrorCount;
    }

    private String lastLoginTime;

    @Column(name=GenBW_UserWk.LASTLOGINTIME)
    public String getLastLoginTime() {
        return lastLoginTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLastLoginTime(String pLastLoginTime) {
        lastLoginTime = pLastLoginTime;
    }
}

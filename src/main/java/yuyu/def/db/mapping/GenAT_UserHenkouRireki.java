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
import yuyu.def.classification.C_RirekiSyuruiKbn;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.classification.C_YoukyuuKbn;
import yuyu.def.db.entity.AT_UserHenkouRireki;
import yuyu.def.db.id.PKAT_UserHenkouRireki;
import yuyu.def.db.meta.GenQAT_UserHenkouRireki;
import yuyu.def.db.meta.QAT_UserHenkouRireki;
import yuyu.def.db.type.UserType_C_KyokaKbn;
import yuyu.def.db.type.UserType_C_PasswordYuukouKikanKbn;
import yuyu.def.db.type.UserType_C_RirekiSyuruiKbn;
import yuyu.def.db.type.UserType_C_SpecialUserKbn;
import yuyu.def.db.type.UserType_C_YoukyuuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * ユーザー変更履歴テーブル テーブルのマッピング情報クラスで、 {@link AT_UserHenkouRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_UserHenkouRireki}</td><td colspan="3">ユーザー変更履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">{@link PKAT_UserHenkouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRirekiSyuruiKbn rirekiSyuruiKbn}</td><td>履歴種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_RirekiSyuruiKbn}</td></tr>
 *  <tr><td>{@link #getUserNm userNm}</td><td>ユーザー名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 * </table>
 * @see     AT_UserHenkouRireki
 * @see     PKAT_UserHenkouRireki
 * @see     QAT_UserHenkouRireki
 * @see     GenQAT_UserHenkouRireki
 */
@MappedSuperclass
@Table(name=GenAT_UserHenkouRireki.TABLE_NAME)
@IdClass(value=PKAT_UserHenkouRireki.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KyokaKbn", typeClass=UserType_C_KyokaKbn.class),
    @TypeDef(name="UserType_C_PasswordYuukouKikanKbn", typeClass=UserType_C_PasswordYuukouKikanKbn.class),
    @TypeDef(name="UserType_C_RirekiSyuruiKbn", typeClass=UserType_C_RirekiSyuruiKbn.class),
    @TypeDef(name="UserType_C_SpecialUserKbn", typeClass=UserType_C_SpecialUserKbn.class),
    @TypeDef(name="UserType_C_YoukyuuKbn", typeClass=UserType_C_YoukyuuKbn.class)
})
public abstract class GenAT_UserHenkouRireki extends AbstractExDBEntity<AT_UserHenkouRireki, PKAT_UserHenkouRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_UserHenkouRireki";
    public static final String UNIQUEID                 = "uniqueId";
    public static final String USERID                   = "userId";
    public static final String RIREKISYURUIKBN          = "rirekiSyuruiKbn";
    public static final String USERNM                   = "userNm";
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

    private final PKAT_UserHenkouRireki primaryKey;

    public GenAT_UserHenkouRireki() {
        primaryKey = new PKAT_UserHenkouRireki();
    }

    public GenAT_UserHenkouRireki(String pUniqueId) {
        primaryKey = new PKAT_UserHenkouRireki(pUniqueId);
    }

    @Transient
    @Override
    public PKAT_UserHenkouRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_UserHenkouRireki> getMetaClass() {
        return QAT_UserHenkouRireki.class;
    }

    @Id
    @Column(name=GenAT_UserHenkouRireki.UNIQUEID)
    public String getUniqueId() {
        return getPrimaryKey().getUniqueId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        getPrimaryKey().setUniqueId(pUniqueId);
    }

    private String userId;

    @Column(name=GenAT_UserHenkouRireki.USERID)
    @MaxLength(max=30)
    @AlphaDigit
    public String getUserId() {
        return userId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserId(String pUserId) {
        userId = pUserId;
    }

    private C_RirekiSyuruiKbn rirekiSyuruiKbn;

    @Type(type="UserType_C_RirekiSyuruiKbn")
    @Column(name=GenAT_UserHenkouRireki.RIREKISYURUIKBN)
    public C_RirekiSyuruiKbn getRirekiSyuruiKbn() {
        return rirekiSyuruiKbn;
    }

    public void setRirekiSyuruiKbn(C_RirekiSyuruiKbn pRirekiSyuruiKbn) {
        rirekiSyuruiKbn = pRirekiSyuruiKbn;
    }

    private String userNm;

    @Column(name=GenAT_UserHenkouRireki.USERNM)
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

    private C_SpecialUserKbn specialUserKbn;

    @Type(type="UserType_C_SpecialUserKbn")
    @Column(name=GenAT_UserHenkouRireki.SPECIALUSERKBN)
    public C_SpecialUserKbn getSpecialUserKbn() {
        return specialUserKbn;
    }

    public void setSpecialUserKbn(C_SpecialUserKbn pSpecialUserKbn) {
        specialUserKbn = pSpecialUserKbn;
    }

    private String password;

    @Column(name=GenAT_UserHenkouRireki.PASSWORD)
    @AlphaDigit
    public String getPassword() {
        return password;
    }

    public void setPassword(String pPassword) {
        password = pPassword;
    }

    private BizDate passwordSetteiYmd;

    @Type(type="BizDateType")
    @Column(name=GenAT_UserHenkouRireki.PASSWORDSETTEIYMD)
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
    @Column(name=GenAT_UserHenkouRireki.PASSWORDYUUKOUKIGENYMD)
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

    @Column(name=GenAT_UserHenkouRireki.PASSWORDYUUKOUCOUNTY)
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

    @Column(name=GenAT_UserHenkouRireki.PASSWORDYUUKOUCOUNTM)
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

    @Column(name=GenAT_UserHenkouRireki.PASSWORDYUUKOUCOUNTD)
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
    @Column(name=GenAT_UserHenkouRireki.PASSWORDYUUKOUKIKANKBN)
    public C_PasswordYuukouKikanKbn getPasswordYuukouKikanKbn() {
        return passwordYuukouKikanKbn;
    }

    public void setPasswordYuukouKikanKbn(C_PasswordYuukouKikanKbn pPasswordYuukouKikanKbn) {
        passwordYuukouKikanKbn = pPasswordYuukouKikanKbn;
    }

    private C_KyokaKbn passwordHenkouKyokaKbn;

    @Type(type="UserType_C_KyokaKbn")
    @Column(name=GenAT_UserHenkouRireki.PASSWORDHENKOUKYOKAKBN)
    public C_KyokaKbn getPasswordHenkouKyokaKbn() {
        return passwordHenkouKyokaKbn;
    }

    public void setPasswordHenkouKyokaKbn(C_KyokaKbn pPasswordHenkouKyokaKbn) {
        passwordHenkouKyokaKbn = pPasswordHenkouKyokaKbn;
    }

    private C_YoukyuuKbn passwordHenkouYoukyuuKbn;

    @Type(type="UserType_C_YoukyuuKbn")
    @Column(name=GenAT_UserHenkouRireki.PASSWORDHENKOUYOUKYUUKBN)
    public C_YoukyuuKbn getPasswordHenkouYoukyuuKbn() {
        return passwordHenkouYoukyuuKbn;
    }

    public void setPasswordHenkouYoukyuuKbn(C_YoukyuuKbn pPasswordHenkouYoukyuuKbn) {
        passwordHenkouYoukyuuKbn = pPasswordHenkouYoukyuuKbn;
    }

    private C_KyokaKbn loginKyokaKbn;

    @Type(type="UserType_C_KyokaKbn")
    @Column(name=GenAT_UserHenkouRireki.LOGINKYOKAKBN)
    public C_KyokaKbn getLoginKyokaKbn() {
        return loginKyokaKbn;
    }

    public void setLoginKyokaKbn(C_KyokaKbn pLoginKyokaKbn) {
        loginKyokaKbn = pLoginKyokaKbn;
    }

    private Integer loginErrorCount;

    @Column(name=GenAT_UserHenkouRireki.LOGINERRORCOUNT)
    public Integer getLoginErrorCount() {
        return loginErrorCount;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLoginErrorCount(Integer pLoginErrorCount) {
        loginErrorCount = pLoginErrorCount;
    }
}

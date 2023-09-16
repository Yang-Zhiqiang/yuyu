package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AT_PasswordRireki;
import yuyu.def.db.id.PKAT_PasswordRireki;
import yuyu.def.db.meta.GenQAT_PasswordRireki;
import yuyu.def.db.meta.QAT_PasswordRireki;

/**
 * パスワード履歴テーブル テーブルのマッピング情報クラスで、 {@link AT_PasswordRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_PasswordRireki}</td><td colspan="3">パスワード履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">{@link PKAT_PasswordRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPassword password}</td><td>パスワード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_PasswordRireki
 * @see     PKAT_PasswordRireki
 * @see     QAT_PasswordRireki
 * @see     GenQAT_PasswordRireki
 */
@MappedSuperclass
@Table(name=GenAT_PasswordRireki.TABLE_NAME)
@IdClass(value=PKAT_PasswordRireki.class)
public abstract class GenAT_PasswordRireki extends AbstractExDBEntity<AT_PasswordRireki, PKAT_PasswordRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_PasswordRireki";
    public static final String UNIQUEID                 = "uniqueId";
    public static final String USERID                   = "userId";
    public static final String PASSWORD                 = "password";

    private final PKAT_PasswordRireki primaryKey;

    public GenAT_PasswordRireki() {
        primaryKey = new PKAT_PasswordRireki();
    }

    public GenAT_PasswordRireki(String pUniqueId) {
        primaryKey = new PKAT_PasswordRireki(pUniqueId);
    }

    @Transient
    @Override
    public PKAT_PasswordRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_PasswordRireki> getMetaClass() {
        return QAT_PasswordRireki.class;
    }

    @Id
    @Column(name=GenAT_PasswordRireki.UNIQUEID)
    public String getUniqueId() {
        return getPrimaryKey().getUniqueId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        getPrimaryKey().setUniqueId(pUniqueId);
    }

    private String userId;

    @Column(name=GenAT_PasswordRireki.USERID)
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

    private String password;

    @Column(name=GenAT_PasswordRireki.PASSWORD)
    @AlphaDigit
    public String getPassword() {
        return password;
    }

    public void setPassword(String pPassword) {
        password = pPassword;
    }
}

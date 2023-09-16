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
import yuyu.def.db.entity.AT_UserRole;
import yuyu.def.db.id.PKAT_UserRole;
import yuyu.def.db.meta.GenQAT_UserRole;
import yuyu.def.db.meta.QAT_UserRole;

/**
 * ユーザーロールテーブル テーブルのマッピング情報クラスで、 {@link AT_UserRole} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_UserRole}</td><td colspan="3">ユーザーロールテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">{@link PKAT_UserRole ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">{@link PKAT_UserRole ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_UserRole
 * @see     PKAT_UserRole
 * @see     QAT_UserRole
 * @see     GenQAT_UserRole
 */
@MappedSuperclass
@Table(name=GenAT_UserRole.TABLE_NAME)
@IdClass(value=PKAT_UserRole.class)
public abstract class GenAT_UserRole extends AbstractExDBEntity<AT_UserRole, PKAT_UserRole> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_UserRole";
    public static final String USERID                   = "userId";
    public static final String ROLECD                   = "roleCd";

    private final PKAT_UserRole primaryKey;

    public GenAT_UserRole() {
        primaryKey = new PKAT_UserRole();
    }

    public GenAT_UserRole(String pUserId, String pRoleCd) {
        primaryKey = new PKAT_UserRole(pUserId, pRoleCd);
    }

    @Transient
    @Override
    public PKAT_UserRole getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_UserRole> getMetaClass() {
        return QAT_UserRole.class;
    }

    @Id
    @Column(name=GenAT_UserRole.USERID)
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

    @Id
    @Column(name=GenAT_UserRole.ROLECD)
    @MaxLength(max=30)
    @AlphaDigit
    public String getRoleCd() {
        return getPrimaryKey().getRoleCd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRoleCd(String pRoleCd) {
        getPrimaryKey().setRoleCd(pRoleCd);
    }
}

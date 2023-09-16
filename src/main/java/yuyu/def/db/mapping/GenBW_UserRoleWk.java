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
import yuyu.def.db.entity.BW_UserRoleWk;
import yuyu.def.db.id.PKBW_UserRoleWk;
import yuyu.def.db.meta.GenQBW_UserRoleWk;
import yuyu.def.db.meta.QBW_UserRoleWk;

/**
 * ユーザーロールワークテーブル テーブルのマッピング情報クラスで、 {@link BW_UserRoleWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BW_UserRoleWk}</td><td colspan="3">ユーザーロールワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">{@link PKBW_UserRoleWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">{@link PKBW_UserRoleWk ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BW_UserRoleWk
 * @see     PKBW_UserRoleWk
 * @see     QBW_UserRoleWk
 * @see     GenQBW_UserRoleWk
 */
@MappedSuperclass
@Table(name=GenBW_UserRoleWk.TABLE_NAME)
@IdClass(value=PKBW_UserRoleWk.class)
public abstract class GenBW_UserRoleWk extends AbstractExDBEntity<BW_UserRoleWk, PKBW_UserRoleWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BW_UserRoleWk";
    public static final String USERID                   = "userId";
    public static final String ROLECD                   = "roleCd";

    private final PKBW_UserRoleWk primaryKey;

    public GenBW_UserRoleWk() {
        primaryKey = new PKBW_UserRoleWk();
    }

    public GenBW_UserRoleWk(String pUserId, String pRoleCd) {
        primaryKey = new PKBW_UserRoleWk(pUserId, pRoleCd);
    }

    @Transient
    @Override
    public PKBW_UserRoleWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBW_UserRoleWk> getMetaClass() {
        return QBW_UserRoleWk.class;
    }

    @Id
    @Column(name=GenBW_UserRoleWk.USERID)
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
    @Column(name=GenBW_UserRoleWk.ROLECD)
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

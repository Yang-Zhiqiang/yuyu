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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_RirekiSyuruiKbn;
import yuyu.def.db.entity.AT_UserRoleRireki;
import yuyu.def.db.id.PKAT_UserRoleRireki;
import yuyu.def.db.meta.GenQAT_UserRoleRireki;
import yuyu.def.db.meta.QAT_UserRoleRireki;
import yuyu.def.db.type.UserType_C_RirekiSyuruiKbn;

/**
 * ユーザーロール履歴テーブル テーブルのマッピング情報クラスで、 {@link AT_UserRoleRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_UserRoleRireki}</td><td colspan="3">ユーザーロール履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">{@link PKAT_UserRoleRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRirekiSyuruiKbn rirekiSyuruiKbn}</td><td>履歴種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_RirekiSyuruiKbn}</td></tr>
 * </table>
 * @see     AT_UserRoleRireki
 * @see     PKAT_UserRoleRireki
 * @see     QAT_UserRoleRireki
 * @see     GenQAT_UserRoleRireki
 */
@MappedSuperclass
@Table(name=GenAT_UserRoleRireki.TABLE_NAME)
@IdClass(value=PKAT_UserRoleRireki.class)
@TypeDefs({
    @TypeDef(name="UserType_C_RirekiSyuruiKbn", typeClass=UserType_C_RirekiSyuruiKbn.class)
})
public abstract class GenAT_UserRoleRireki extends AbstractExDBEntity<AT_UserRoleRireki, PKAT_UserRoleRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_UserRoleRireki";
    public static final String UNIQUEID                 = "uniqueId";
    public static final String USERID                   = "userId";
    public static final String ROLECD                   = "roleCd";
    public static final String RIREKISYURUIKBN          = "rirekiSyuruiKbn";

    private final PKAT_UserRoleRireki primaryKey;

    public GenAT_UserRoleRireki() {
        primaryKey = new PKAT_UserRoleRireki();
    }

    public GenAT_UserRoleRireki(String pUniqueId) {
        primaryKey = new PKAT_UserRoleRireki(pUniqueId);
    }

    @Transient
    @Override
    public PKAT_UserRoleRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_UserRoleRireki> getMetaClass() {
        return QAT_UserRoleRireki.class;
    }

    @Id
    @Column(name=GenAT_UserRoleRireki.UNIQUEID)
    public String getUniqueId() {
        return getPrimaryKey().getUniqueId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        getPrimaryKey().setUniqueId(pUniqueId);
    }

    private String userId;

    @Column(name=GenAT_UserRoleRireki.USERID)
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

    private String roleCd;

    @Column(name=GenAT_UserRoleRireki.ROLECD)
    @MaxLength(max=30)
    @AlphaDigit
    public String getRoleCd() {
        return roleCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRoleCd(String pRoleCd) {
        roleCd = pRoleCd;
    }

    private C_RirekiSyuruiKbn rirekiSyuruiKbn;

    @Type(type="UserType_C_RirekiSyuruiKbn")
    @Column(name=GenAT_UserRoleRireki.RIREKISYURUIKBN)
    public C_RirekiSyuruiKbn getRirekiSyuruiKbn() {
        return rirekiSyuruiKbn;
    }

    public void setRirekiSyuruiKbn(C_RirekiSyuruiKbn pRirekiSyuruiKbn) {
        rirekiSyuruiKbn = pRirekiSyuruiKbn;
    }
}

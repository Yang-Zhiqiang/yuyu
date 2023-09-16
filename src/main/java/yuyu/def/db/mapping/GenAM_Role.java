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
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.id.PKAM_Role;
import yuyu.def.db.meta.GenQAM_Role;
import yuyu.def.db.meta.QAM_Role;
import yuyu.def.db.type.UserType_C_SysSiyouKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * ロールマスタ テーブルのマッピング情報クラスで、 {@link AM_Role} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_Role}</td><td colspan="3">ロールマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">{@link PKAM_Role ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRoleNm roleNm}</td><td>ロール名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRoleSetumei roleSetumei}</td><td>ロール説明</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSysSiyouKbn sysSiyouKbn}</td><td>システム使用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SysSiyouKbn}</td></tr>
 * </table>
 * @see     AM_Role
 * @see     PKAM_Role
 * @see     QAM_Role
 * @see     GenQAM_Role
 */
@MappedSuperclass
@Table(name=GenAM_Role.TABLE_NAME)
@IdClass(value=PKAM_Role.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SysSiyouKbn", typeClass=UserType_C_SysSiyouKbn.class)
})
public abstract class GenAM_Role extends AbstractExDBEntity<AM_Role, PKAM_Role> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AM_Role";
    public static final String ROLECD                   = "roleCd";
    public static final String ROLENM                   = "roleNm";
    public static final String ROLESETUMEI              = "roleSetumei";
    public static final String SYSSIYOUKBN              = "sysSiyouKbn";

    private final PKAM_Role primaryKey;

    public GenAM_Role() {
        primaryKey = new PKAM_Role();
    }

    public GenAM_Role(String pRoleCd) {
        primaryKey = new PKAM_Role(pRoleCd);
    }

    @Transient
    @Override
    public PKAM_Role getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAM_Role> getMetaClass() {
        return QAM_Role.class;
    }

    @Id
    @Column(name=GenAM_Role.ROLECD)
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

    private String roleNm;

    @Column(name=GenAM_Role.ROLENM)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getRoleNm() {
        return roleNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setRoleNm(String pRoleNm) {
        roleNm = pRoleNm;
    }

    private String roleSetumei;

    @Column(name=GenAM_Role.ROLESETUMEI)
    @MaxLength(max=100)
    @MultiByteStrings
    @InvalidCharacter
    public String getRoleSetumei() {
        return roleSetumei;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setRoleSetumei(String pRoleSetumei) {
        roleSetumei = pRoleSetumei;
    }

    private C_SysSiyouKbn sysSiyouKbn;

    @Type(type="UserType_C_SysSiyouKbn")
    @Column(name=GenAM_Role.SYSSIYOUKBN)
    public C_SysSiyouKbn getSysSiyouKbn() {
        return sysSiyouKbn;
    }

    public void setSysSiyouKbn(C_SysSiyouKbn pSysSiyouKbn) {
        sysSiyouKbn = pSysSiyouKbn;
    }
}

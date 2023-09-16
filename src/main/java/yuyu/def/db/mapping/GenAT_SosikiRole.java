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
import yuyu.def.db.entity.AT_SosikiRole;
import yuyu.def.db.id.PKAT_SosikiRole;
import yuyu.def.db.meta.GenQAT_SosikiRole;
import yuyu.def.db.meta.QAT_SosikiRole;

/**
 * 組織ロールテーブル テーブルのマッピング情報クラスで、 {@link AT_SosikiRole} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_SosikiRole}</td><td colspan="3">組織ロールテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTanmatusettisosikicd tanmatusettisosikicd}</td><td>端末設置組織コード</td><td align="center">{@link PKAT_SosikiRole ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">{@link PKAT_SosikiRole ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_SosikiRole
 * @see     PKAT_SosikiRole
 * @see     QAT_SosikiRole
 * @see     GenQAT_SosikiRole
 */
@MappedSuperclass
@Table(name=GenAT_SosikiRole.TABLE_NAME)
@IdClass(value=PKAT_SosikiRole.class)
public abstract class GenAT_SosikiRole extends AbstractExDBEntity<AT_SosikiRole, PKAT_SosikiRole> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_SosikiRole";
    public static final String TANMATUSETTISOSIKICD     = "tanmatusettisosikicd";
    public static final String ROLECD                   = "roleCd";

    private final PKAT_SosikiRole primaryKey;

    public GenAT_SosikiRole() {
        primaryKey = new PKAT_SosikiRole();
    }

    public GenAT_SosikiRole(String pTanmatusettisosikicd, String pRoleCd) {
        primaryKey = new PKAT_SosikiRole(pTanmatusettisosikicd, pRoleCd);
    }

    @Transient
    @Override
    public PKAT_SosikiRole getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_SosikiRole> getMetaClass() {
        return QAT_SosikiRole.class;
    }

    @Id
    @Column(name=GenAT_SosikiRole.TANMATUSETTISOSIKICD)
    public String getTanmatusettisosikicd() {
        return getPrimaryKey().getTanmatusettisosikicd();
    }

    public void setTanmatusettisosikicd(String pTanmatusettisosikicd) {
        getPrimaryKey().setTanmatusettisosikicd(pTanmatusettisosikicd);
    }

    @Id
    @Column(name=GenAT_SosikiRole.ROLECD)
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

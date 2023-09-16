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
import yuyu.def.db.entity.AT_RoleSiyouKanouSosiki;
import yuyu.def.db.id.PKAT_RoleSiyouKanouSosiki;
import yuyu.def.db.meta.GenQAT_RoleSiyouKanouSosiki;
import yuyu.def.db.meta.QAT_RoleSiyouKanouSosiki;

/**
 * ロール使用可能組織テーブル テーブルのマッピング情報クラスで、 {@link AT_RoleSiyouKanouSosiki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_RoleSiyouKanouSosiki}</td><td colspan="3">ロール使用可能組織テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyozokusosikicd syozokusosikicd}</td><td>所属組織コード</td><td align="center">{@link PKAT_RoleSiyouKanouSosiki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">{@link PKAT_RoleSiyouKanouSosiki ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_RoleSiyouKanouSosiki
 * @see     PKAT_RoleSiyouKanouSosiki
 * @see     QAT_RoleSiyouKanouSosiki
 * @see     GenQAT_RoleSiyouKanouSosiki
 */
@MappedSuperclass
@Table(name=GenAT_RoleSiyouKanouSosiki.TABLE_NAME)
@IdClass(value=PKAT_RoleSiyouKanouSosiki.class)
public abstract class GenAT_RoleSiyouKanouSosiki extends AbstractExDBEntity<AT_RoleSiyouKanouSosiki, PKAT_RoleSiyouKanouSosiki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_RoleSiyouKanouSosiki";
    public static final String SYOZOKUSOSIKICD          = "syozokusosikicd";
    public static final String ROLECD                   = "roleCd";

    private final PKAT_RoleSiyouKanouSosiki primaryKey;

    public GenAT_RoleSiyouKanouSosiki() {
        primaryKey = new PKAT_RoleSiyouKanouSosiki();
    }

    public GenAT_RoleSiyouKanouSosiki(String pSyozokusosikicd, String pRoleCd) {
        primaryKey = new PKAT_RoleSiyouKanouSosiki(pSyozokusosikicd, pRoleCd);
    }

    @Transient
    @Override
    public PKAT_RoleSiyouKanouSosiki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_RoleSiyouKanouSosiki> getMetaClass() {
        return QAT_RoleSiyouKanouSosiki.class;
    }

    @Id
    @Column(name=GenAT_RoleSiyouKanouSosiki.SYOZOKUSOSIKICD)
    public String getSyozokusosikicd() {
        return getPrimaryKey().getSyozokusosikicd();
    }

    public void setSyozokusosikicd(String pSyozokusosikicd) {
        getPrimaryKey().setSyozokusosikicd(pSyozokusosikicd);
    }

    @Id
    @Column(name=GenAT_RoleSiyouKanouSosiki.ROLECD)
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

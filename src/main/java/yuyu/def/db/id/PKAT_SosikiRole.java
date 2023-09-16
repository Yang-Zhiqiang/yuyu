package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AT_SosikiRole;
import yuyu.def.db.mapping.GenAT_SosikiRole;
import yuyu.def.db.meta.GenQAT_SosikiRole;
import yuyu.def.db.meta.QAT_SosikiRole;

/**
 * 組織ロールテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_SosikiRole}</td><td colspan="3">組織ロールテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTanmatusettisosikicd tanmatusettisosikicd}</td><td>端末設置組織コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_SosikiRole
 * @see     GenAT_SosikiRole
 * @see     QAT_SosikiRole
 * @see     GenQAT_SosikiRole
 */
public class PKAT_SosikiRole extends AbstractExDBPrimaryKey<AT_SosikiRole, PKAT_SosikiRole> {

    private static final long serialVersionUID = 1L;

    public PKAT_SosikiRole() {
    }

    public PKAT_SosikiRole(String pTanmatusettisosikicd, String pRoleCd) {
        tanmatusettisosikicd = pTanmatusettisosikicd;
        roleCd = pRoleCd;
    }

    @Transient
    @Override
    public Class<AT_SosikiRole> getEntityClass() {
        return AT_SosikiRole.class;
    }

    private String tanmatusettisosikicd;

    public String getTanmatusettisosikicd() {
        return tanmatusettisosikicd;
    }

    public void setTanmatusettisosikicd(String pTanmatusettisosikicd) {
        tanmatusettisosikicd = pTanmatusettisosikicd;
    }
    private String roleCd;

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String pRoleCd) {
        roleCd = pRoleCd;
    }

}
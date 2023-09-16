package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.def.db.mapping.GenAT_UserRole;
import yuyu.def.db.meta.GenQAT_UserRole;
import yuyu.def.db.meta.QAT_UserRole;

/**
 * ユーザーロールテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_UserRole}</td><td colspan="3">ユーザーロールテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_UserRole
 * @see     GenAT_UserRole
 * @see     QAT_UserRole
 * @see     GenQAT_UserRole
 */
public class PKAT_UserRole extends AbstractExDBPrimaryKey<AT_UserRole, PKAT_UserRole> {

    private static final long serialVersionUID = 1L;

    public PKAT_UserRole() {
    }

    public PKAT_UserRole(String pUserId, String pRoleCd) {
        userId = pUserId;
        roleCd = pRoleCd;
    }

    @Transient
    @Override
    public Class<AT_UserRole> getEntityClass() {
        return AT_UserRole.class;
    }

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }
    private String roleCd;

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String pRoleCd) {
        roleCd = pRoleCd;
    }

}
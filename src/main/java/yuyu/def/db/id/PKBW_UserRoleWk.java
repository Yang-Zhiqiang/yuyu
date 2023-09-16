package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.BW_UserRoleWk;
import yuyu.def.db.mapping.GenBW_UserRoleWk;
import yuyu.def.db.meta.GenQBW_UserRoleWk;
import yuyu.def.db.meta.QBW_UserRoleWk;

/**
 * ユーザーロールワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BW_UserRoleWk}</td><td colspan="3">ユーザーロールワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BW_UserRoleWk
 * @see     GenBW_UserRoleWk
 * @see     QBW_UserRoleWk
 * @see     GenQBW_UserRoleWk
 */
public class PKBW_UserRoleWk extends AbstractExDBPrimaryKey<BW_UserRoleWk, PKBW_UserRoleWk> {

    private static final long serialVersionUID = 1L;

    public PKBW_UserRoleWk() {
    }

    public PKBW_UserRoleWk(String pUserId, String pRoleCd) {
        userId = pUserId;
        roleCd = pRoleCd;
    }

    @Transient
    @Override
    public Class<BW_UserRoleWk> getEntityClass() {
        return BW_UserRoleWk.class;
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
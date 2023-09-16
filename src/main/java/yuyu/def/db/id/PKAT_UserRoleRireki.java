package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_UserRoleRireki;
import yuyu.def.db.mapping.GenAT_UserRoleRireki;
import yuyu.def.db.meta.GenQAT_UserRoleRireki;
import yuyu.def.db.meta.QAT_UserRoleRireki;

/**
 * ユーザーロール履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_UserRoleRireki}</td><td colspan="3">ユーザーロール履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>userId</td><td>ユーザーＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>roleCd</td><td>ロールコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rirekiSyuruiKbn</td><td>履歴種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_RirekiSyuruiKbn C_RirekiSyuruiKbn}</td></tr>
 * </table>
 * @see     AT_UserRoleRireki
 * @see     GenAT_UserRoleRireki
 * @see     QAT_UserRoleRireki
 * @see     GenQAT_UserRoleRireki
 */
public class PKAT_UserRoleRireki extends AbstractExDBPrimaryKey<AT_UserRoleRireki, PKAT_UserRoleRireki> {

    private static final long serialVersionUID = 1L;

    public PKAT_UserRoleRireki() {
    }

    public PKAT_UserRoleRireki(String pUniqueId) {
        uniqueId = pUniqueId;
    }

    @Transient
    @Override
    public Class<AT_UserRoleRireki> getEntityClass() {
        return AT_UserRoleRireki.class;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }

}
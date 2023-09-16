package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_PasswordRireki;
import yuyu.def.db.mapping.GenAT_PasswordRireki;
import yuyu.def.db.meta.GenQAT_PasswordRireki;
import yuyu.def.db.meta.QAT_PasswordRireki;

/**
 * パスワード履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_PasswordRireki}</td><td colspan="3">パスワード履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>userId</td><td>ユーザーＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>password</td><td>パスワード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_PasswordRireki
 * @see     GenAT_PasswordRireki
 * @see     QAT_PasswordRireki
 * @see     GenQAT_PasswordRireki
 */
public class PKAT_PasswordRireki extends AbstractExDBPrimaryKey<AT_PasswordRireki, PKAT_PasswordRireki> {

    private static final long serialVersionUID = 1L;

    public PKAT_PasswordRireki() {
    }

    public PKAT_PasswordRireki(String pUniqueId) {
        uniqueId = pUniqueId;
    }

    @Transient
    @Override
    public Class<AT_PasswordRireki> getEntityClass() {
        return AT_PasswordRireki.class;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }

}
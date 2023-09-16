package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AT_MyMenu;
import yuyu.def.db.mapping.GenAT_MyMenu;
import yuyu.def.db.meta.GenQAT_MyMenu;
import yuyu.def.db.meta.QAT_MyMenu;

/**
 * マイメニューテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_MyMenu}</td><td colspan="3">マイメニューテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>subSystemId</td><td>サブシステムＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>categoryId</td><td>カテゴリＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_MyMenu
 * @see     GenAT_MyMenu
 * @see     QAT_MyMenu
 * @see     GenQAT_MyMenu
 */
public class PKAT_MyMenu extends AbstractExDBPrimaryKey<AT_MyMenu, PKAT_MyMenu> {

    private static final long serialVersionUID = 1L;

    public PKAT_MyMenu() {
    }

    public PKAT_MyMenu(String pUserId, String pKinouId) {
        userId = pUserId;
        kinouId = pKinouId;
    }

    @Transient
    @Override
    public Class<AT_MyMenu> getEntityClass() {
        return AT_MyMenu.class;
    }

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }
    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

}
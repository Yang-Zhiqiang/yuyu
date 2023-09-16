package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.WM_TorikomiDaiBunrui;
import yuyu.def.db.mapping.GenWM_TorikomiDaiBunrui;
import yuyu.def.db.meta.GenQWM_TorikomiDaiBunrui;
import yuyu.def.db.meta.QWM_TorikomiDaiBunrui;

/**
 * 取込書類大分類マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WM_TorikomiDaiBunrui}</td><td colspan="3">取込書類大分類マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyzkDaiBunruiId syzkDaiBunruiId}</td><td>所属大分類ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syzkDaiBunruiNm</td><td>所属大分類名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WM_TorikomiDaiBunrui
 * @see     GenWM_TorikomiDaiBunrui
 * @see     QWM_TorikomiDaiBunrui
 * @see     GenQWM_TorikomiDaiBunrui
 */
public class PKWM_TorikomiDaiBunrui extends AbstractExDBPrimaryKey<WM_TorikomiDaiBunrui, PKWM_TorikomiDaiBunrui> {

    private static final long serialVersionUID = 1L;

    public PKWM_TorikomiDaiBunrui() {
    }

    public PKWM_TorikomiDaiBunrui(String pSyzkDaiBunruiId) {
        syzkDaiBunruiId = pSyzkDaiBunruiId;
    }

    @Transient
    @Override
    public Class<WM_TorikomiDaiBunrui> getEntityClass() {
        return WM_TorikomiDaiBunrui.class;
    }

    private String syzkDaiBunruiId;

    public String getSyzkDaiBunruiId() {
        return syzkDaiBunruiId;
    }

    public void setSyzkDaiBunruiId(String pSyzkDaiBunruiId) {
        syzkDaiBunruiId = pSyzkDaiBunruiId;
    }

}
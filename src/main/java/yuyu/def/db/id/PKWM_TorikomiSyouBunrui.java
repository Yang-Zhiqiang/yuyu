package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.WM_TorikomiSyouBunrui;
import yuyu.def.db.mapping.GenWM_TorikomiSyouBunrui;
import yuyu.def.db.meta.GenQWM_TorikomiSyouBunrui;
import yuyu.def.db.meta.QWM_TorikomiSyouBunrui;

/**
 * 取込書類小分類マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WM_TorikomiSyouBunrui}</td><td colspan="3">取込書類小分類マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyzkSyouBunruiId syzkSyouBunruiId}</td><td>所属小分類ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syzkSyouBunruiNm</td><td>所属小分類名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syzkDaiBunruiId</td><td>所属大分類ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WM_TorikomiSyouBunrui
 * @see     GenWM_TorikomiSyouBunrui
 * @see     QWM_TorikomiSyouBunrui
 * @see     GenQWM_TorikomiSyouBunrui
 */
public class PKWM_TorikomiSyouBunrui extends AbstractExDBPrimaryKey<WM_TorikomiSyouBunrui, PKWM_TorikomiSyouBunrui> {

    private static final long serialVersionUID = 1L;

    public PKWM_TorikomiSyouBunrui() {
    }

    public PKWM_TorikomiSyouBunrui(String pSyzkSyouBunruiId) {
        syzkSyouBunruiId = pSyzkSyouBunruiId;
    }

    @Transient
    @Override
    public Class<WM_TorikomiSyouBunrui> getEntityClass() {
        return WM_TorikomiSyouBunrui.class;
    }

    private String syzkSyouBunruiId;

    public String getSyzkSyouBunruiId() {
        return syzkSyouBunruiId;
    }

    public void setSyzkSyouBunruiId(String pSyzkSyouBunruiId) {
        syzkSyouBunruiId = pSyzkSyouBunruiId;
    }

}
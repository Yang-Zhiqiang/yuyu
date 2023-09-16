package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.mapping.GenDM_Jimutetuzuki;
import yuyu.def.db.meta.GenQDM_Jimutetuzuki;
import yuyu.def.db.meta.QDM_Jimutetuzuki;

/**
 * 事務手続マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link DM_Jimutetuzuki}</td><td colspan="3">事務手続マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jimutetuzukinm</td><td>事務手続名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>imagerenkeikbn</td><td>イメージ連携区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ImagerenkeiKbn C_ImagerenkeiKbn}</td></tr>
 *  <tr><td>hyoujijyun</td><td>表示順</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukouteijimutetuzukicd</td><td>主工程事務手続コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     DM_Jimutetuzuki
 * @see     GenDM_Jimutetuzuki
 * @see     QDM_Jimutetuzuki
 * @see     GenQDM_Jimutetuzuki
 */
public class PKDM_Jimutetuzuki extends AbstractExDBPrimaryKey<DM_Jimutetuzuki, PKDM_Jimutetuzuki> {

    private static final long serialVersionUID = 1L;

    public PKDM_Jimutetuzuki() {
    }

    public PKDM_Jimutetuzuki(String pJimutetuzukicd, String pSubSystemId) {
        jimutetuzukicd = pJimutetuzukicd;
        subSystemId = pSubSystemId;
    }

    @Transient
    @Override
    public Class<DM_Jimutetuzuki> getEntityClass() {
        return DM_Jimutetuzuki.class;
    }

    private String jimutetuzukicd;

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }
    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

}
package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.mapping.GenBT_GyoumuKouteiInfo;
import yuyu.def.db.meta.GenQBT_GyoumuKouteiInfo;
import yuyu.def.db.meta.QBT_GyoumuKouteiInfo;

/**
 * 業務用工程情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_GyoumuKouteiInfo}</td><td colspan="3">業務用工程情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>subSystemId</td><td>サブシステムＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jimutetuzukicd</td><td>事務手続コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mosno</td><td>申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skno</td><td>請求番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nksysyno</td><td>年金証書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukouteikanriid</td><td>主工程管理ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukouteijimutetuzukicd</td><td>主工程事務手続コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_GyoumuKouteiInfo
 * @see     GenBT_GyoumuKouteiInfo
 * @see     QBT_GyoumuKouteiInfo
 * @see     GenQBT_GyoumuKouteiInfo
 */
public class PKBT_GyoumuKouteiInfo extends AbstractExDBPrimaryKey<BT_GyoumuKouteiInfo, PKBT_GyoumuKouteiInfo> {

    private static final long serialVersionUID = 1L;

    public PKBT_GyoumuKouteiInfo() {
    }

    public PKBT_GyoumuKouteiInfo(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    @Transient
    @Override
    public Class<BT_GyoumuKouteiInfo> getEntityClass() {
        return BT_GyoumuKouteiInfo.class;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

}
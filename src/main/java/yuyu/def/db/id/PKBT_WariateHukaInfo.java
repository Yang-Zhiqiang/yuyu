package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.BT_WariateHukaInfo;
import yuyu.def.db.mapping.GenBT_WariateHukaInfo;
import yuyu.def.db.meta.GenQBT_WariateHukaInfo;
import yuyu.def.db.meta.QBT_WariateHukaInfo;

/**
 * 割当不可情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_WariateHukaInfo}</td><td colspan="3">割当不可情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getWrthukatskid wrthukatskid}</td><td>割当不可タスクID</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wrthukakaijyotskid</td><td>割当不可解除用タスクID</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_WariateHukaInfo
 * @see     GenBT_WariateHukaInfo
 * @see     QBT_WariateHukaInfo
 * @see     GenQBT_WariateHukaInfo
 */
public class PKBT_WariateHukaInfo extends AbstractExDBPrimaryKey<BT_WariateHukaInfo, PKBT_WariateHukaInfo> {

    private static final long serialVersionUID = 1L;

    public PKBT_WariateHukaInfo() {
    }

    public PKBT_WariateHukaInfo(
        String pKouteikanriid,
        String pSubSystemId,
        String pJimutetuzukicd,
        String pWrthukatskid,
        String pUserId
    ) {
        kouteikanriid = pKouteikanriid;
        subSystemId = pSubSystemId;
        jimutetuzukicd = pJimutetuzukicd;
        wrthukatskid = pWrthukatskid;
        userId = pUserId;
    }

    @Transient
    @Override
    public Class<BT_WariateHukaInfo> getEntityClass() {
        return BT_WariateHukaInfo.class;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }
    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }
    private String jimutetuzukicd;

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }
    private String wrthukatskid;

    public String getWrthukatskid() {
        return wrthukatskid;
    }

    public void setWrthukatskid(String pWrthukatskid) {
        wrthukatskid = pWrthukatskid;
    }
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }

}
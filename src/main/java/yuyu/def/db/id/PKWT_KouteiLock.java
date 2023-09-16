package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.WT_KouteiLock;
import yuyu.def.db.mapping.GenWT_KouteiLock;
import yuyu.def.db.meta.GenQWT_KouteiLock;
import yuyu.def.db.meta.QWT_KouteiLock;

/**
 * 工程ロック情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_KouteiLock}</td><td colspan="3">工程ロック情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>lockTime</td><td>ロック時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lockKey</td><td>ロックキー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getGyoumuKey gyoumuKey}</td><td>業務キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getFlowId flowId}</td><td>フローＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>userId</td><td>ユーザーＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nodeNm</td><td>ノード名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_KouteiLock
 * @see     GenWT_KouteiLock
 * @see     QWT_KouteiLock
 * @see     GenQWT_KouteiLock
 */
public class PKWT_KouteiLock extends AbstractExDBPrimaryKey<WT_KouteiLock, PKWT_KouteiLock> {

    private static final long serialVersionUID = 1L;

    public PKWT_KouteiLock() {
    }

    public PKWT_KouteiLock(String pFlowId, String pGyoumuKey) {
        flowId = pFlowId;
        gyoumuKey = pGyoumuKey;
    }

    @Transient
    @Override
    public Class<WT_KouteiLock> getEntityClass() {
        return WT_KouteiLock.class;
    }

    private String flowId;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String pFlowId) {
        flowId = pFlowId;
    }
    private String gyoumuKey;

    public String getGyoumuKey() {
        return gyoumuKey;
    }

    public void setGyoumuKey(String pGyoumuKey) {
        gyoumuKey = pGyoumuKey;
    }

}
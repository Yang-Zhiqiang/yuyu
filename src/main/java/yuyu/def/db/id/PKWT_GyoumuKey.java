package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.mapping.GenWT_GyoumuKey;
import yuyu.def.db.meta.GenQWT_GyoumuKey;
import yuyu.def.db.meta.QWT_GyoumuKey;

/**
 * 業務キーテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_GyoumuKey}</td><td colspan="3">業務キーテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getFlowId flowId}</td><td>フローＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getGyoumuKey gyoumuKey}</td><td>業務キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tokenId</td><td>トークンＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>createTime</td><td>作成日時</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_GyoumuKey
 * @see     GenWT_GyoumuKey
 * @see     QWT_GyoumuKey
 * @see     GenQWT_GyoumuKey
 */
public class PKWT_GyoumuKey extends AbstractExDBPrimaryKey<WT_GyoumuKey, PKWT_GyoumuKey> {

    private static final long serialVersionUID = 1L;

    public PKWT_GyoumuKey() {
    }

    public PKWT_GyoumuKey(String pFlowId, String pGyoumuKey) {
        flowId = pFlowId;
        gyoumuKey = pGyoumuKey;
    }

    @Transient
    @Override
    public Class<WT_GyoumuKey> getEntityClass() {
        return WT_GyoumuKey.class;
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
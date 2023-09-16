package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.WT_KengenKoutei;
import yuyu.def.db.mapping.GenWT_KengenKoutei;
import yuyu.def.db.meta.GenQWT_KengenKoutei;
import yuyu.def.db.meta.QWT_KengenKoutei;

/**
 * 権限明細（工程）テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_KengenKoutei}</td><td colspan="3">権限明細（工程）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getFlowId flowId}</td><td>フローＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getNodeId nodeId}</td><td>ノードＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_KengenKoutei
 * @see     GenWT_KengenKoutei
 * @see     QWT_KengenKoutei
 * @see     GenQWT_KengenKoutei
 */
public class PKWT_KengenKoutei extends AbstractExDBPrimaryKey<WT_KengenKoutei, PKWT_KengenKoutei> {

    private static final long serialVersionUID = 1L;

    public PKWT_KengenKoutei() {
    }

    public PKWT_KengenKoutei(
        String pRoleCd,
        String pFlowId,
        String pNodeId
    ) {
        roleCd = pRoleCd;
        flowId = pFlowId;
        nodeId = pNodeId;
    }

    @Transient
    @Override
    public Class<WT_KengenKoutei> getEntityClass() {
        return WT_KengenKoutei.class;
    }

    private String roleCd;

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String pRoleCd) {
        roleCd = pRoleCd;
    }
    private String flowId;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String pFlowId) {
        flowId = pFlowId;
    }
    private String nodeId;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String pNodeId) {
        nodeId = pNodeId;
    }

}
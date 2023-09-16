package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.db.mapping.GenDM_JimutetuzukiTask;
import yuyu.def.db.meta.GenQDM_JimutetuzukiTask;
import yuyu.def.db.meta.QDM_JimutetuzukiTask;

/**
 * 事務手続タスクマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link DM_JimutetuzukiTask}</td><td colspan="3">事務手続タスクマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getWorkflowTskId workflowTskId}</td><td>ワークフロータスクID</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>workflowTskNm</td><td>ワークフロータスク名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujijyun</td><td>表示順</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>worklistHyoujiFlag</td><td>工程ワークリスト表示フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     DM_JimutetuzukiTask
 * @see     GenDM_JimutetuzukiTask
 * @see     QDM_JimutetuzukiTask
 * @see     GenQDM_JimutetuzukiTask
 */
public class PKDM_JimutetuzukiTask extends AbstractExDBPrimaryKey<DM_JimutetuzukiTask, PKDM_JimutetuzukiTask> {

    private static final long serialVersionUID = 1L;

    public PKDM_JimutetuzukiTask() {
    }

    public PKDM_JimutetuzukiTask(
        String pSubSystemId,
        String pJimutetuzukicd,
        String pWorkflowTskId
    ) {
        subSystemId = pSubSystemId;
        jimutetuzukicd = pJimutetuzukicd;
        workflowTskId = pWorkflowTskId;
    }

    @Transient
    @Override
    public Class<DM_JimutetuzukiTask> getEntityClass() {
        return DM_JimutetuzukiTask.class;
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
    private String workflowTskId;

    public String getWorkflowTskId() {
        return workflowTskId;
    }

    public void setWorkflowTskId(String pWorkflowTskId) {
        workflowTskId = pWorkflowTskId;
    }

}
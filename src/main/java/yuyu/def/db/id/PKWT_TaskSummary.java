package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.WT_TaskSummary;
import yuyu.def.db.mapping.GenWT_TaskSummary;
import yuyu.def.db.meta.GenQWT_TaskSummary;
import yuyu.def.db.meta.QWT_TaskSummary;

/**
 * タスクサマリテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_TaskSummary}</td><td colspan="3">タスクサマリテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getFlowId flowId}</td><td>フローＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getIwfTskId iwfTskId}</td><td>IWFタスクＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTokenId tokenId}</td><td>トークンＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>flowName</td><td>フロー名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>iwfTskNm</td><td>IWFタスク名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTaskCreateTime taskCreateTime}</td><td>タスク生成時間</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>taskStartTime</td><td>タスク開始時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>taskEndTime</td><td>タスク終了時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>actorId</td><td>アクターＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_TaskSummary
 * @see     GenWT_TaskSummary
 * @see     QWT_TaskSummary
 * @see     GenQWT_TaskSummary
 */
public class PKWT_TaskSummary extends AbstractExDBPrimaryKey<WT_TaskSummary, PKWT_TaskSummary> {

    private static final long serialVersionUID = 1L;

    public PKWT_TaskSummary() {
    }

    public PKWT_TaskSummary(
        String pFlowId,
        String pIwfTskId,
        String pTokenId,
        String pTaskCreateTime
    ) {
        flowId = pFlowId;
        iwfTskId = pIwfTskId;
        tokenId = pTokenId;
        taskCreateTime = pTaskCreateTime;
    }

    @Transient
    @Override
    public Class<WT_TaskSummary> getEntityClass() {
        return WT_TaskSummary.class;
    }

    private String flowId;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String pFlowId) {
        flowId = pFlowId;
    }
    private String iwfTskId;

    public String getIwfTskId() {
        return iwfTskId;
    }

    public void setIwfTskId(String pIwfTskId) {
        iwfTskId = pIwfTskId;
    }
    private String tokenId;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String pTokenId) {
        tokenId = pTokenId;
    }
    private String taskCreateTime;

    public String getTaskCreateTime() {
        return taskCreateTime;
    }

    public void setTaskCreateTime(String pTaskCreateTime) {
        taskCreateTime = pTaskCreateTime;
    }

}
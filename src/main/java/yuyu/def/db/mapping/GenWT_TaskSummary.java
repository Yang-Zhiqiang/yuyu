package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.WT_TaskSummary;
import yuyu.def.db.id.PKWT_TaskSummary;
import yuyu.def.db.meta.GenQWT_TaskSummary;
import yuyu.def.db.meta.QWT_TaskSummary;

/**
 * タスクサマリテーブル テーブルのマッピング情報クラスで、 {@link WT_TaskSummary} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_TaskSummary}</td><td colspan="3">タスクサマリテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getFlowId flowId}</td><td>フローＩＤ</td><td align="center">{@link PKWT_TaskSummary ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIwfTskId iwfTskId}</td><td>IWFタスクＩＤ</td><td align="center">{@link PKWT_TaskSummary ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTokenId tokenId}</td><td>トークンＩＤ</td><td align="center">{@link PKWT_TaskSummary ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFlowName flowName}</td><td>フロー名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIwfTskNm iwfTskNm}</td><td>IWFタスク名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTaskCreateTime taskCreateTime}</td><td>タスク生成時間</td><td align="center">{@link PKWT_TaskSummary ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTaskStartTime taskStartTime}</td><td>タスク開始時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTaskEndTime taskEndTime}</td><td>タスク終了時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getActorId actorId}</td><td>アクターＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_TaskSummary
 * @see     PKWT_TaskSummary
 * @see     QWT_TaskSummary
 * @see     GenQWT_TaskSummary
 */
@MappedSuperclass
@Table(name=GenWT_TaskSummary.TABLE_NAME)
@IdClass(value=PKWT_TaskSummary.class)
public abstract class GenWT_TaskSummary extends AbstractExDBEntity<WT_TaskSummary, PKWT_TaskSummary> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "WT_TaskSummary";
    public static final String FLOWID                   = "flowId";
    public static final String IWFTSKID                 = "iwfTskId";
    public static final String TOKENID                  = "tokenId";
    public static final String FLOWNAME                 = "flowName";
    public static final String IWFTSKNM                 = "iwfTskNm";
    public static final String TASKCREATETIME           = "taskCreateTime";
    public static final String TASKSTARTTIME            = "taskStartTime";
    public static final String TASKENDTIME              = "taskEndTime";
    public static final String ACTORID                  = "actorId";

    private final PKWT_TaskSummary primaryKey;

    public GenWT_TaskSummary() {
        primaryKey = new PKWT_TaskSummary();
    }

    public GenWT_TaskSummary(
        String pFlowId,
        String pIwfTskId,
        String pTokenId,
        String pTaskCreateTime
    ) {
        primaryKey = new PKWT_TaskSummary(
            pFlowId,
            pIwfTskId,
            pTokenId,
            pTaskCreateTime
        );
    }

    @Transient
    @Override
    public PKWT_TaskSummary getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QWT_TaskSummary> getMetaClass() {
        return QWT_TaskSummary.class;
    }

    @Id
    @Column(name=GenWT_TaskSummary.FLOWID)
    public String getFlowId() {
        return getPrimaryKey().getFlowId();
    }

    public void setFlowId(String pFlowId) {
        getPrimaryKey().setFlowId(pFlowId);
    }

    @Id
    @Column(name=GenWT_TaskSummary.IWFTSKID)
    public String getIwfTskId() {
        return getPrimaryKey().getIwfTskId();
    }

    public void setIwfTskId(String pIwfTskId) {
        getPrimaryKey().setIwfTskId(pIwfTskId);
    }

    @Id
    @Column(name=GenWT_TaskSummary.TOKENID)
    public String getTokenId() {
        return getPrimaryKey().getTokenId();
    }

    public void setTokenId(String pTokenId) {
        getPrimaryKey().setTokenId(pTokenId);
    }

    private String flowName;

    @Column(name=GenWT_TaskSummary.FLOWNAME)
    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String pFlowName) {
        flowName = pFlowName;
    }

    private String iwfTskNm;

    @Column(name=GenWT_TaskSummary.IWFTSKNM)
    public String getIwfTskNm() {
        return iwfTskNm;
    }

    public void setIwfTskNm(String pIwfTskNm) {
        iwfTskNm = pIwfTskNm;
    }

    @Id
    @Column(name=GenWT_TaskSummary.TASKCREATETIME)
    public String getTaskCreateTime() {
        return getPrimaryKey().getTaskCreateTime();
    }

    public void setTaskCreateTime(String pTaskCreateTime) {
        getPrimaryKey().setTaskCreateTime(pTaskCreateTime);
    }

    private String taskStartTime;

    @Column(name=GenWT_TaskSummary.TASKSTARTTIME)
    public String getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(String pTaskStartTime) {
        taskStartTime = pTaskStartTime;
    }

    private String taskEndTime;

    @Column(name=GenWT_TaskSummary.TASKENDTIME)
    public String getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(String pTaskEndTime) {
        taskEndTime = pTaskEndTime;
    }

    private String actorId;

    @Column(name=GenWT_TaskSummary.ACTORID)
    public String getActorId() {
        return actorId;
    }

    public void setActorId(String pActorId) {
        actorId = pActorId;
    }
}
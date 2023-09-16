package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.JBPM_TASK;
import yuyu.def.db.id.PKJBPM_TASK;
import yuyu.def.db.meta.GenQJBPM_TASK;
import yuyu.def.db.meta.QJBPM_TASK;

/**
 * ＪＢＰＭタスク テーブルのマッピング情報クラスで、 {@link JBPM_TASK} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JBPM_TASK}</td><td colspan="3">ＪＢＰＭタスク</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getId id_}</td><td>ＪＢＰＭ一意ＩＤ</td><td align="center">{@link PKJBPM_TASK ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getName name_}</td><td>ＪＢＰＭ名前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDescription description_}</td><td>ＪＢＰＭ説明</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getProcessdefinition processDefinition_}</td><td>ＪＢＰＭプロセス定義</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getIsblocking isBlocking_}</td><td>ＪＢＰＭブロックフラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getIssignalling isSignalling_}</td><td>ＪＢＰＭトークン駆動可否</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getCondition condition_}</td><td>ＪＢＰＭ状況</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDuedate dueDate_}</td><td>ＪＢＰＭ期限日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPriority priority_}</td><td>ＪＢＰＭ優先度</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getActoridexpression actorIdExpression_}</td><td>ＪＢＰＭタスクＩＤ表現</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPooledactorsexpression pooledActorsExpression_}</td><td>ＪＢＰＭプールアクター表現</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTaskmgmtdefinition taskMgmtDefinition_}</td><td>ＪＢＰＭタスク管理定義</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getTasknode taskNode_}</td><td>ＪＢＰＭタスクノード</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getStartstate startState_}</td><td>ＪＢＰＭ開始状態</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getAssignmentdelegation assignmentDelegation_}</td><td>ＪＢＰＭ割当委任</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSwimlane swimlane_}</td><td>ＪＢＰＭタスクレーン</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getTaskcontroller taskController_}</td><td>ＪＢＰＭタスクコントローラ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     JBPM_TASK
 * @see     PKJBPM_TASK
 * @see     QJBPM_TASK
 * @see     GenQJBPM_TASK
 */
@MappedSuperclass
@Table(name=GenJBPM_TASK.TABLE_NAME)
@IdClass(value=PKJBPM_TASK.class)
public abstract class GenJBPM_TASK extends AbstractExDBEntityForJBPM<JBPM_TASK, PKJBPM_TASK> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JBPM_TASK";
    public static final String ID_                      = "id_";
    public static final String NAME_                    = "name_";
    public static final String DESCRIPTION_             = "description_";
    public static final String PROCESSDEFINITION_       = "processDefinition_";
    public static final String ISBLOCKING_              = "isBlocking_";
    public static final String ISSIGNALLING_            = "isSignalling_";
    public static final String CONDITION_               = "condition_";
    public static final String DUEDATE_                 = "dueDate_";
    public static final String PRIORITY_                = "priority_";
    public static final String ACTORIDEXPRESSION_       = "actorIdExpression_";
    public static final String POOLEDACTORSEXPRESSION_  = "pooledActorsExpression_";
    public static final String TASKMGMTDEFINITION_      = "taskMgmtDefinition_";
    public static final String TASKNODE_                = "taskNode_";
    public static final String STARTSTATE_              = "startState_";
    public static final String ASSIGNMENTDELEGATION_    = "assignmentDelegation_";
    public static final String SWIMLANE_                = "swimlane_";
    public static final String TASKCONTROLLER_          = "taskController_";

    private final PKJBPM_TASK primaryKey;

    public GenJBPM_TASK() {
        primaryKey = new PKJBPM_TASK();
    }

    public GenJBPM_TASK(Long pId) {
        primaryKey = new PKJBPM_TASK(pId);
    }

    @Transient
    @Override
    public PKJBPM_TASK getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJBPM_TASK> getMetaClass() {
        return QJBPM_TASK.class;
    }

    @Id
    @Column(name=GenJBPM_TASK.ID_)
    public Long getId_() {
        return getPrimaryKey().getId_();
    }

    public void setId_(Long pId) {
        getPrimaryKey().setId_(pId);
    }

    private String name_;

    @Column(name=GenJBPM_TASK.NAME_)
    public String getName_() {
        return name_;
    }

    public void setName_(String pName) {
        name_ = pName;
    }

    private String description_;

    @Column(name=GenJBPM_TASK.DESCRIPTION_)
    public String getDescription() {
        return description_;
    }

    public void setDescription(String pDescription) {
        description_ = pDescription;
    }

    private Long processDefinition_;

    @Column(name=GenJBPM_TASK.PROCESSDEFINITION_)
    public Long getProcessDefinition_() {
        return processDefinition_;
    }

    public void setProcessDefinition_(Long pProcessdefinition) {
        processDefinition_ = pProcessdefinition;
    }

    private String isBlocking_;

    @Column(name=GenJBPM_TASK.ISBLOCKING_)
    public String getIsblocking() {
        return isBlocking_;
    }

    public void setIsblocking(String pIsblocking) {
        isBlocking_ = pIsblocking;
    }

    private String isSignalling_;

    @Column(name=GenJBPM_TASK.ISSIGNALLING_)
    public String getIsSignalling_() {
        return isSignalling_;
    }

    public void setIsSignalling_(String pIssignalling) {
        isSignalling_ = pIssignalling;
    }

    private String condition_;

    @Column(name=GenJBPM_TASK.CONDITION_)
    public String getCondition() {
        return condition_;
    }

    public void setCondition(String pCondition) {
        condition_ = pCondition;
    }

    private String dueDate_;

    @Column(name=GenJBPM_TASK.DUEDATE_)
    public String getDuedate() {
        return dueDate_;
    }

    public void setDuedate(String pDuedate) {
        dueDate_ = pDuedate;
    }

    private Long priority_;

    @Column(name=GenJBPM_TASK.PRIORITY_)
    public Long getPriority() {
        return priority_;
    }

    public void setPriority(Long pPriority) {
        priority_ = pPriority;
    }

    private String actorIdExpression_;

    @Column(name=GenJBPM_TASK.ACTORIDEXPRESSION_)
    public String getActoridexpression() {
        return actorIdExpression_;
    }

    public void setActoridexpression(String pActoridexpression) {
        actorIdExpression_ = pActoridexpression;
    }

    private String pooledActorsExpression_;

    @Column(name=GenJBPM_TASK.POOLEDACTORSEXPRESSION_)
    public String getPooledactorsexpression() {
        return pooledActorsExpression_;
    }

    public void setPooledactorsexpression(String pPooledactorsexpression) {
        pooledActorsExpression_ = pPooledactorsexpression;
    }

    private Long taskMgmtDefinition_;

    @Column(name=GenJBPM_TASK.TASKMGMTDEFINITION_)
    public Long getTaskmgmtdefinition() {
        return taskMgmtDefinition_;
    }

    public void setTaskmgmtdefinition(Long pTaskmgmtdefinition) {
        taskMgmtDefinition_ = pTaskmgmtdefinition;
    }

    private Long taskNode_;

    @Column(name=GenJBPM_TASK.TASKNODE_)
    public Long getTasknode_() {
        return taskNode_;
    }

    public void setTasknode_(Long pTasknode) {
        taskNode_ = pTasknode;
    }

    private Long startState_;

    @Column(name=GenJBPM_TASK.STARTSTATE_)
    public Long getStartstate() {
        return startState_;
    }

    public void setStartstate(Long pStartstate) {
        startState_ = pStartstate;
    }

    private Long assignmentDelegation_;

    @Column(name=GenJBPM_TASK.ASSIGNMENTDELEGATION_)
    public Long getAssignmentdelegation() {
        return assignmentDelegation_;
    }

    public void setAssignmentdelegation(Long pAssignmentdelegation) {
        assignmentDelegation_ = pAssignmentdelegation;
    }

    private Long swimlane_;

    @Column(name=GenJBPM_TASK.SWIMLANE_)
    public Long getSwimlane() {
        return swimlane_;
    }

    public void setSwimlane(Long pSwimlane) {
        swimlane_ = pSwimlane;
    }

    private Long taskController_;

    @Column(name=GenJBPM_TASK.TASKCONTROLLER_)
    public Long getTaskcontroller() {
        return taskController_;
    }

    public void setTaskcontroller(Long pTaskcontroller) {
        taskController_ = pTaskcontroller;
    }
}
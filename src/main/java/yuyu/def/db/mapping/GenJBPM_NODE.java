package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.JBPM_NODE;
import yuyu.def.db.id.PKJBPM_NODE;
import yuyu.def.db.meta.GenQJBPM_NODE;
import yuyu.def.db.meta.QJBPM_NODE;

/**
 * ＪＢＰＭノード テーブルのマッピング情報クラスで、 {@link JBPM_NODE} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JBPM_NODE}</td><td colspan="3">ＪＢＰＭノード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getId id_}</td><td>ＪＢＰＭ一意ＩＤ</td><td align="center">{@link PKJBPM_NODE ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getClass class_}</td><td>ＪＢＰＭ種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getName name_}</td><td>ＪＢＰＭ名前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDescription description_}</td><td>ＪＢＰＭ説明</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getProcessdefinition processDefinition_}</td><td>ＪＢＰＭプロセス定義</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getIsasync isAsync_}</td><td>ＪＢＰＭ非同期可否</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getIsasyncexcl isAsyncExcl_}</td><td>ＪＢＰＭ非同期排他フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getAction action_}</td><td>ＪＢＰＭアクション</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSuperstate superState_}</td><td>ＪＢＰＭスーパー状態</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSubprocname subProcName_}</td><td>ＪＢＰＭサブプロセス名前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSubprocessdefinition subProcessDefinition_}</td><td>ＪＢＰＭサブプロセス定義</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getDecisionexpression decisionExpression_}</td><td>ＪＢＰＭデシジョン表現</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDecisionDelegation decisionDelegation}</td><td>ＪＢＰＭデシジョン委任</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getScript script_}</td><td>ＪＢＰＭスクリプト</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSignal signal_}</td><td>ＪＢＰＭシグナル</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getCreatetasks createTasks_}</td><td>ＪＢＰＭタスク生成有無</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getEndtasks endTasks_}</td><td>ＪＢＰＭタスク終了有無</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getNodecollectionindex nodeCollectionIndex_}</td><td>ＪＢＰＭノード集合インデックス</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     JBPM_NODE
 * @see     PKJBPM_NODE
 * @see     QJBPM_NODE
 * @see     GenQJBPM_NODE
 */
@MappedSuperclass
@Table(name=GenJBPM_NODE.TABLE_NAME)
@IdClass(value=PKJBPM_NODE.class)
public abstract class GenJBPM_NODE extends AbstractExDBEntityForJBPM<JBPM_NODE, PKJBPM_NODE> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JBPM_NODE";
    public static final String ID_                      = "id_";
    public static final String CLASS_                   = "class_";
    public static final String NAME_                    = "name_";
    public static final String DESCRIPTION_             = "description_";
    public static final String PROCESSDEFINITION_       = "processDefinition_";
    public static final String ISASYNC_                 = "isAsync_";
    public static final String ISASYNCEXCL_             = "isAsyncExcl_";
    public static final String ACTION_                  = "action_";
    public static final String SUPERSTATE_              = "superState_";
    public static final String SUBPROCNAME_             = "subProcName_";
    public static final String SUBPROCESSDEFINITION_    = "subProcessDefinition_";
    public static final String DECISIONEXPRESSION_      = "decisionExpression_";
    public static final String DECISIONDELEGATION       = "decisionDelegation";
    public static final String SCRIPT_                  = "script_";
    public static final String SIGNAL_                  = "signal_";
    public static final String CREATETASKS_             = "createTasks_";
    public static final String ENDTASKS_                = "endTasks_";
    public static final String NODECOLLECTIONINDEX_     = "nodeCollectionIndex_";

    private final PKJBPM_NODE primaryKey;

    public GenJBPM_NODE() {
        primaryKey = new PKJBPM_NODE();
    }

    public GenJBPM_NODE(Long pId) {
        primaryKey = new PKJBPM_NODE(pId);
    }

    @Transient
    @Override
    public PKJBPM_NODE getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJBPM_NODE> getMetaClass() {
        return QJBPM_NODE.class;
    }

    @Id
    @Column(name=GenJBPM_NODE.ID_)
    public Long getId_() {
        return getPrimaryKey().getId_();
    }

    public void setId_(Long pId) {
        getPrimaryKey().setId_(pId);
    }

    private String class_;

    @Column(name=GenJBPM_NODE.CLASS_)
    public String getClass_() {
        return class_;
    }

    public void setClass_(String pClass) {
        class_ = pClass;
    }

    private String name_;

    @Column(name=GenJBPM_NODE.NAME_)
    public String getName_() {
        return name_;
    }

    public void setName_(String pName) {
        name_ = pName;
    }

    private String description_;

    @Column(name=GenJBPM_NODE.DESCRIPTION_)
    public String getDescription() {
        return description_;
    }

    public void setDescription(String pDescription) {
        description_ = pDescription;
    }

    private Long processDefinition_;

    @Column(name=GenJBPM_NODE.PROCESSDEFINITION_)
    public Long getProcessDefinition_() {
        return processDefinition_;
    }

    public void setProcessDefinition_(Long pProcessdefinition) {
        processDefinition_ = pProcessdefinition;
    }

    private String isAsync_;

    @Column(name=GenJBPM_NODE.ISASYNC_)
    public String getIsasync() {
        return isAsync_;
    }

    public void setIsasync(String pIsasync) {
        isAsync_ = pIsasync;
    }

    private String isAsyncExcl_;

    @Column(name=GenJBPM_NODE.ISASYNCEXCL_)
    public String getIsasyncexcl() {
        return isAsyncExcl_;
    }

    public void setIsasyncexcl(String pIsasyncexcl) {
        isAsyncExcl_ = pIsasyncexcl;
    }

    private Long action_;

    @Column(name=GenJBPM_NODE.ACTION_)
    public Long getAction() {
        return action_;
    }

    public void setAction(Long pAction) {
        action_ = pAction;
    }

    private Long superState_;

    @Column(name=GenJBPM_NODE.SUPERSTATE_)
    public Long getSuperstate() {
        return superState_;
    }

    public void setSuperstate(Long pSuperstate) {
        superState_ = pSuperstate;
    }

    private String subProcName_;

    @Column(name=GenJBPM_NODE.SUBPROCNAME_)
    public String getSubprocname() {
        return subProcName_;
    }

    public void setSubprocname(String pSubprocname) {
        subProcName_ = pSubprocname;
    }

    private Long subProcessDefinition_;

    @Column(name=GenJBPM_NODE.SUBPROCESSDEFINITION_)
    public Long getSubprocessdefinition() {
        return subProcessDefinition_;
    }

    public void setSubprocessdefinition(Long pSubprocessdefinition) {
        subProcessDefinition_ = pSubprocessdefinition;
    }

    private String decisionExpression_;

    @Column(name=GenJBPM_NODE.DECISIONEXPRESSION_)
    public String getDecisionexpression() {
        return decisionExpression_;
    }

    public void setDecisionexpression(String pDecisionexpression) {
        decisionExpression_ = pDecisionexpression;
    }

    private Long decisionDelegation;

    @Column(name=GenJBPM_NODE.DECISIONDELEGATION)
    public Long getDecisionDelegation() {
        return decisionDelegation;
    }

    public void setDecisionDelegation(Long pDecisionDelegation) {
        decisionDelegation = pDecisionDelegation;
    }

    private Long script_;

    @Column(name=GenJBPM_NODE.SCRIPT_)
    public Long getScript() {
        return script_;
    }

    public void setScript(Long pScript) {
        script_ = pScript;
    }

    private Long signal_;

    @Column(name=GenJBPM_NODE.SIGNAL_)
    public Long getSignal() {
        return signal_;
    }

    public void setSignal(Long pSignal) {
        signal_ = pSignal;
    }

    private String createTasks_;

    @Column(name=GenJBPM_NODE.CREATETASKS_)
    public String getCreatetasks() {
        return createTasks_;
    }

    public void setCreatetasks(String pCreatetasks) {
        createTasks_ = pCreatetasks;
    }

    private String endTasks_;

    @Column(name=GenJBPM_NODE.ENDTASKS_)
    public String getEndtasks() {
        return endTasks_;
    }

    public void setEndtasks(String pEndtasks) {
        endTasks_ = pEndtasks;
    }

    private Long nodeCollectionIndex_;

    @Column(name=GenJBPM_NODE.NODECOLLECTIONINDEX_)
    public Long getNodecollectionindex() {
        return nodeCollectionIndex_;
    }

    public void setNodecollectionindex(Long pNodecollectionindex) {
        nodeCollectionIndex_ = pNodecollectionindex;
    }
}
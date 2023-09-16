package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.JBPM_TASKINSTANCE;
import yuyu.def.db.id.PKJBPM_TASKINSTANCE;
import yuyu.def.db.meta.GenQJBPM_TASKINSTANCE;
import yuyu.def.db.meta.QJBPM_TASKINSTANCE;

/**
 * ＪＢＰＭタスクインスタンス テーブルのマッピング情報クラスで、 {@link JBPM_TASKINSTANCE} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JBPM_TASKINSTANCE}</td><td colspan="3">ＪＢＰＭタスクインスタンス</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getId id_}</td><td>ＪＢＰＭ一意ＩＤ</td><td align="center">{@link PKJBPM_TASKINSTANCE ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getClass class_}</td><td>ＪＢＰＭ種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getVersion version_}</td><td>ＪＢＰＭバージョン</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getName name_}</td><td>ＪＢＰＭ名前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDescription description_}</td><td>ＪＢＰＭ説明</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getActorid actorId_}</td><td>ＪＢＰＭアクターＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreate create_}</td><td>ＪＢＰＭ生成時間</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getStart start_}</td><td>ＪＢＰＭ開始時間</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getEnd end_}</td><td>ＪＢＰＭ終了時間</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getDuedate dueDate_}</td><td>ＪＢＰＭ期限日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPriority priority_}</td><td>ＪＢＰＭ優先度</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getIscancelled isCancelled_}</td><td>ＪＢＰＭキャンセルフラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getIssuspended isSuspended_}</td><td>ＪＢＰＭ一時中止フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getIsopen isOpen_}</td><td>ＪＢＰＭ解放フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getIssignalling isSignalling_}</td><td>ＪＢＰＭトークン駆動可否</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getIsblocking isBlocking_}</td><td>ＪＢＰＭブロックフラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getTask task_}</td><td>ＪＢＰＭタスク</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getToken token_}</td><td>ＪＢＰＭトークン</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getProcinst procInst_}</td><td>ＪＢＰＭ所属プロセスインスタンス</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSwimlaneinstance swimlaneInstance_}</td><td>ＪＢＰＭレーンインスタンス</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getTaskmgmtinstance taskMgmtInstance_}</td><td>ＪＢＰＭタスク管理インスタンス</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     JBPM_TASKINSTANCE
 * @see     PKJBPM_TASKINSTANCE
 * @see     QJBPM_TASKINSTANCE
 * @see     GenQJBPM_TASKINSTANCE
 */
@MappedSuperclass
@Table(name=GenJBPM_TASKINSTANCE.TABLE_NAME)
@IdClass(value=PKJBPM_TASKINSTANCE.class)
public abstract class GenJBPM_TASKINSTANCE extends AbstractExDBEntityForJBPM<JBPM_TASKINSTANCE, PKJBPM_TASKINSTANCE> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JBPM_TASKINSTANCE";
    public static final String ID_                      = "id_";
    public static final String CLASS_                   = "class_";
    public static final String VERSION_                 = "version_";
    public static final String NAME_                    = "name_";
    public static final String DESCRIPTION_             = "description_";
    public static final String ACTORID_                 = "actorId_";
    public static final String CREATE_                  = "create_";
    public static final String START_                   = "start_";
    public static final String END_                     = "end_";
    public static final String DUEDATE_                 = "dueDate_";
    public static final String PRIORITY_                = "priority_";
    public static final String ISCANCELLED_             = "isCancelled_";
    public static final String ISSUSPENDED_             = "isSuspended_";
    public static final String ISOPEN_                  = "isOpen_";
    public static final String ISSIGNALLING_            = "isSignalling_";
    public static final String ISBLOCKING_              = "isBlocking_";
    public static final String TASK_                    = "task_";
    public static final String TOKEN_                   = "token_";
    public static final String PROCINST_                = "procInst_";
    public static final String SWIMLANINSTANCE_         = "swimlanInstance_";
    public static final String TASKMGMTINSTANCE_        = "taskMgmtInstance_";

    private final PKJBPM_TASKINSTANCE primaryKey;

    public GenJBPM_TASKINSTANCE() {
        primaryKey = new PKJBPM_TASKINSTANCE();
    }

    public GenJBPM_TASKINSTANCE(Long pId) {
        primaryKey = new PKJBPM_TASKINSTANCE(pId);
    }

    @Transient
    @Override
    public PKJBPM_TASKINSTANCE getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJBPM_TASKINSTANCE> getMetaClass() {
        return QJBPM_TASKINSTANCE.class;
    }

    @Id
    @Column(name=GenJBPM_TASKINSTANCE.ID_)
    public Long getId_() {
        return getPrimaryKey().getId_();
    }

    public void setId_(Long pId) {
        getPrimaryKey().setId_(pId);
    }

    private String class_;

    @Column(name=GenJBPM_TASKINSTANCE.CLASS_)
    public String getClass_() {
        return class_;
    }

    public void setClass_(String pClass) {
        class_ = pClass;
    }

    private Long version_;

    @Column(name=GenJBPM_TASKINSTANCE.VERSION_)
    public Long getVersion_() {
        return version_;
    }

    public void setVersion_(Long pVersion) {
        version_ = pVersion;
    }

    private String name_;

    @Column(name=GenJBPM_TASKINSTANCE.NAME_)
    public String getName_() {
        return name_;
    }

    public void setName_(String pName) {
        name_ = pName;
    }

    private String description_;

    @Column(name=GenJBPM_TASKINSTANCE.DESCRIPTION_)
    public String getDescription_() {
        return description_;
    }

    public void setDescription_(String pDescription) {
        description_ = pDescription;
    }

    private String actorId_;

    @Column(name=GenJBPM_TASKINSTANCE.ACTORID_)
    public String getActorId_() {
        return actorId_;
    }

    public void setActorId_(String pActorid) {
        actorId_ = pActorid;
    }

    private String create_;

    @Column(name=GenJBPM_TASKINSTANCE.CREATE_)
    public String getCreate_() {
        return create_;
    }

    public void setCreate_(String pCreate) {
        create_ = pCreate;
    }

    private String start_;

    @Column(name=GenJBPM_TASKINSTANCE.START_)
    public String getStart_() {
        return start_;
    }

    public void setStart_(String pStart) {
        start_ = pStart;
    }

    private String end_;

    @Column(name=GenJBPM_TASKINSTANCE.END_)
    public String getEnd_() {
        return end_;
    }

    public void setEnd_(String pEnd) {
        end_ = pEnd;
    }

    private String dueDate_;

    @Column(name=GenJBPM_TASKINSTANCE.DUEDATE_)
    public String getDuedate() {
        return dueDate_;
    }

    public void setDuedate(String pDuedate) {
        dueDate_ = pDuedate;
    }

    private Long priority_;

    @Column(name=GenJBPM_TASKINSTANCE.PRIORITY_)
    public Long getPriority() {
        return priority_;
    }

    public void setPriority(Long pPriority) {
        priority_ = pPriority;
    }

    private String isCancelled_;

    @Column(name=GenJBPM_TASKINSTANCE.ISCANCELLED_)
    public String getIscancelled() {
        return isCancelled_;
    }

    public void setIscancelled(String pIscancelled) {
        isCancelled_ = pIscancelled;
    }

    private String isSuspended_;

    @Column(name=GenJBPM_TASKINSTANCE.ISSUSPENDED_)
    public String getIsSuspended_() {
        return isSuspended_;
    }

    public void setIsSuspended_(String pIssuspended) {
        isSuspended_ = pIssuspended;
    }

    private String isOpen_;

    @Column(name=GenJBPM_TASKINSTANCE.ISOPEN_)
    public String getIsOpen_() {
        return isOpen_;
    }

    public void setIsOpen_(String pIsopen) {
        isOpen_ = pIsopen;
    }

    private String isSignalling_;

    @Column(name=GenJBPM_TASKINSTANCE.ISSIGNALLING_)
    public String getIsSignalling_() {
        return isSignalling_;
    }

    public void setIsSignalling_(String pIssignalling) {
        isSignalling_ = pIssignalling;
    }

    private String isBlocking_;

    @Column(name=GenJBPM_TASKINSTANCE.ISBLOCKING_)
    public String getIsblocking() {
        return isBlocking_;
    }

    public void setIsblocking(String pIsblocking) {
        isBlocking_ = pIsblocking;
    }

    private Long task_;

    @Column(name=GenJBPM_TASKINSTANCE.TASK_)
    public Long getTask_() {
        return task_;
    }

    public void setTask_(Long pTask) {
        task_ = pTask;
    }

    private Long token_;

    @Column(name=GenJBPM_TASKINSTANCE.TOKEN_)
    public Long getToken_() {
        return token_;
    }

    public void setToken_(Long pToken) {
        token_ = pToken;
    }

    private Long procInst_;

    @Column(name=GenJBPM_TASKINSTANCE.PROCINST_)
    public Long getProcInst_() {
        return procInst_;
    }

    public void setProcInst_(Long pProcinst) {
        procInst_ = pProcinst;
    }

    private Long swimlanInstance_;

    @Column(name=GenJBPM_TASKINSTANCE.SWIMLANINSTANCE_)
    public Long getSwimlaninstance() {
        return swimlanInstance_;
    }

    public void setSwimlaninstance(Long pSwimlaninstance) {
        swimlanInstance_ = pSwimlaninstance;
    }

    private Long taskMgmtInstance_;

    @Column(name=GenJBPM_TASKINSTANCE.TASKMGMTINSTANCE_)
    public Long getTaskmgmtinstance() {
        return taskMgmtInstance_;
    }

    public void setTaskmgmtinstance(Long pTaskmgmtinstance) {
        taskMgmtInstance_ = pTaskmgmtinstance;
    }
}
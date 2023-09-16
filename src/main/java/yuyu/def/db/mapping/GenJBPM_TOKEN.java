package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.JBPM_TOKEN;
import yuyu.def.db.id.PKJBPM_TOKEN;
import yuyu.def.db.meta.GenQJBPM_TOKEN;
import yuyu.def.db.meta.QJBPM_TOKEN;

/**
 * ＪＢＰＭトークン テーブルのマッピング情報クラスで、 {@link JBPM_TOKEN} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JBPM_TOKEN}</td><td colspan="3">ＪＢＰＭトークン</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getId id_}</td><td>ＪＢＰＭ一意ＩＤ</td><td align="center">{@link PKJBPM_TOKEN ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getVersion version_}</td><td>ＪＢＰＭバージョン</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getName name_}</td><td>ＪＢＰＭ名前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStart start_}</td><td>ＪＢＰＭ開始時間</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getEnd end_}</td><td>ＪＢＰＭ終了時間</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getNodeenter nodeEnter_}</td><td>ＪＢＰＭノードに入る時間</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getNextlogindex nextLogIndex_}</td><td>ＪＢＰＭ次のログインデックス</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getIsabletoreactivateparent isAbleToReactivateParent_}</td><td>ＪＢＰＭ親の再活性化可否</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getIsterminationimplicit isTerminationImplicit_}</td><td>ＪＢＰＭ衝突中止フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getNode node_}</td><td>ＪＢＰＭノード</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getIssuspended isSuspended_}</td><td>ＪＢＰＭ一時中止フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getLock lock_}</td><td>ＪＢＰＭロック</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getProcessinstance processInstance_}</td><td>ＪＢＰＭプロセスインスタンス</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getParent parent_}</td><td>ＪＢＰＭ親トークン</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSubprocessinstance subProcessInstance_}</td><td>ＪＢＰＭ子プロセスインスタンス</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     JBPM_TOKEN
 * @see     PKJBPM_TOKEN
 * @see     QJBPM_TOKEN
 * @see     GenQJBPM_TOKEN
 */
@MappedSuperclass
@Table(name=GenJBPM_TOKEN.TABLE_NAME)
@IdClass(value=PKJBPM_TOKEN.class)
public abstract class GenJBPM_TOKEN extends AbstractExDBEntityForJBPM<JBPM_TOKEN, PKJBPM_TOKEN> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JBPM_TOKEN";
    public static final String ID_                      = "id_";
    public static final String VERSION_                 = "version_";
    public static final String NAME_                    = "name_";
    public static final String START_                   = "start_";
    public static final String END_                     = "end_";
    public static final String NODEENTER_               = "nodeEnter_";
    public static final String NEXTLOGINDEX_            = "nextLogIndex_";
    public static final String ISABLETOREACTIVATEPARENT_ = "isAbleToReactivateParent_";
    public static final String ISTERMINATIONIMPLICIT_   = "isTerminationImplicit_";
    public static final String NODE_                    = "node_";
    public static final String ISSUSPENDED_             = "isSuspended_";
    public static final String LOCK_                    = "lock_";
    public static final String PROCESSINSTANCE_         = "processInstance_";
    public static final String PARENT_                  = "parent_";
    public static final String SUBPROCESSINSTANCE_      = "subProcessInstance_";

    private final PKJBPM_TOKEN primaryKey;

    public GenJBPM_TOKEN() {
        primaryKey = new PKJBPM_TOKEN();
    }

    public GenJBPM_TOKEN(Long pId) {
        primaryKey = new PKJBPM_TOKEN(pId);
    }

    @Transient
    @Override
    public PKJBPM_TOKEN getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJBPM_TOKEN> getMetaClass() {
        return QJBPM_TOKEN.class;
    }

    @Id
    @Column(name=GenJBPM_TOKEN.ID_)
    public Long getId_() {
        return getPrimaryKey().getId_();
    }

    public void setId_(Long pId) {
        getPrimaryKey().setId_(pId);
    }

    private Long version_;

    @Column(name=GenJBPM_TOKEN.VERSION_)
    public Long getVersion_() {
        return version_;
    }

    public void setVersion_(Long pVersion) {
        version_ = pVersion;
    }

    private String name_;

    @Column(name=GenJBPM_TOKEN.NAME_)
    public String getName_() {
        return name_;
    }

    public void setName_(String pName) {
        name_ = pName;
    }

    private String start_;

    @Column(name=GenJBPM_TOKEN.START_)
    public String getStart() {
        return start_;
    }

    public void setStart(String pStart) {
        start_ = pStart;
    }

    private String end_;

    @Column(name=GenJBPM_TOKEN.END_)
    public String getEnd_() {
        return end_;
    }

    public void setEnd_(String pEnd) {
        end_ = pEnd;
    }

    private String nodeEnter_;

    @Column(name=GenJBPM_TOKEN.NODEENTER_)
    public String getNodeenter() {
        return nodeEnter_;
    }

    public void setNodeenter(String pNodeenter) {
        nodeEnter_ = pNodeenter;
    }

    private Long nextLogIndex_;

    @Column(name=GenJBPM_TOKEN.NEXTLOGINDEX_)
    public Long getNextlogindex() {
        return nextLogIndex_;
    }

    public void setNextlogindex(Long pNextlogindex) {
        nextLogIndex_ = pNextlogindex;
    }

    private String isAbleToReactivateParent_;

    @Column(name=GenJBPM_TOKEN.ISABLETOREACTIVATEPARENT_)
    public String getIsabletoreactivateparent() {
        return isAbleToReactivateParent_;
    }

    public void setIsabletoreactivateparent(String pIsabletoreactivateparent) {
        isAbleToReactivateParent_ = pIsabletoreactivateparent;
    }

    private String isTerminationImplicit_;

    @Column(name=GenJBPM_TOKEN.ISTERMINATIONIMPLICIT_)
    public String getIsterminationimplicit() {
        return isTerminationImplicit_;
    }

    public void setIsterminationimplicit(String pIsterminationimplicit) {
        isTerminationImplicit_ = pIsterminationimplicit;
    }

    private Long node_;

    @Column(name=GenJBPM_TOKEN.NODE_)
    public Long getNode_() {
        return node_;
    }

    public void setNode_(Long pNode) {
        node_ = pNode;
    }

    private String isSuspended_;

    @Column(name=GenJBPM_TOKEN.ISSUSPENDED_)
    public String getIssuspended() {
        return isSuspended_;
    }

    public void setIssuspended(String pIssuspended) {
        isSuspended_ = pIssuspended;
    }

    private String lock_;

    @Column(name=GenJBPM_TOKEN.LOCK_)
    public String getLock() {
        return lock_;
    }

    public void setLock(String pLock) {
        lock_ = pLock;
    }

    private Long processInstance_;

    @Column(name=GenJBPM_TOKEN.PROCESSINSTANCE_)
    public Long getProcessInstance_() {
        return processInstance_;
    }

    public void setProcessInstance_(Long pProcessinstance) {
        processInstance_ = pProcessinstance;
    }

    private Long parent_;

    @Column(name=GenJBPM_TOKEN.PARENT_)
    public Long getParent_() {
        return parent_;
    }

    public void setParent_(Long pParent) {
        parent_ = pParent;
    }

    private Long subProcessInstance_;

    @Column(name=GenJBPM_TOKEN.SUBPROCESSINSTANCE_)
    public Long getSubprocessinstance() {
        return subProcessInstance_;
    }

    public void setSubprocessinstance(Long pSubprocessinstance) {
        subProcessInstance_ = pSubprocessinstance;
    }
}
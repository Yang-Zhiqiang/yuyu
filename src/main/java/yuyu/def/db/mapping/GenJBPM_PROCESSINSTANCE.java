package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.JBPM_PROCESSINSTANCE;
import yuyu.def.db.id.PKJBPM_PROCESSINSTANCE;
import yuyu.def.db.meta.GenQJBPM_PROCESSINSTANCE;
import yuyu.def.db.meta.QJBPM_PROCESSINSTANCE;

/**
 * ＪＢＰＭプロセスインスタンス テーブルのマッピング情報クラスで、 {@link JBPM_PROCESSINSTANCE} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JBPM_PROCESSINSTANCE}</td><td colspan="3">ＪＢＰＭプロセスインスタンス</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getId id_}</td><td>ＪＢＰＭ一意ＩＤ</td><td align="center">{@link PKJBPM_PROCESSINSTANCE ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getVersion version_}</td><td>ＪＢＰＭバージョン</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getKey key_}</td><td>ＪＢＰＭユニークキー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStart start_}</td><td>ＪＢＰＭ開始時間</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getEnd end_}</td><td>ＪＢＰＭ終了時間</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getIssuspended isSuspended_}</td><td>ＪＢＰＭ一時中止フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getProcessdefinition processDefinition_}</td><td>ＪＢＰＭプロセス定義</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getRoottoken rootToken_}</td><td>ＪＢＰＭルートトークン</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSuperprocesstoken superProcessToken_}</td><td>ＪＢＰＭスーパープロセストークン</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     JBPM_PROCESSINSTANCE
 * @see     PKJBPM_PROCESSINSTANCE
 * @see     QJBPM_PROCESSINSTANCE
 * @see     GenQJBPM_PROCESSINSTANCE
 */
@MappedSuperclass
@Table(name=GenJBPM_PROCESSINSTANCE.TABLE_NAME)
@IdClass(value=PKJBPM_PROCESSINSTANCE.class)
public abstract class GenJBPM_PROCESSINSTANCE extends AbstractExDBEntityForJBPM<JBPM_PROCESSINSTANCE, PKJBPM_PROCESSINSTANCE> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JBPM_PROCESSINSTANCE";
    public static final String ID_                      = "id_";
    public static final String VERSION_                 = "version_";
    public static final String KEY_                     = "key_";
    public static final String START_                   = "start_";
    public static final String END_                     = "end_";
    public static final String ISSUSPENDED_             = "isSuspended_";
    public static final String PROCESSDEFINITION_       = "processDefinition_";
    public static final String ROOTTOKEN_               = "rootToken_";
    public static final String SUPERPROCESSTOKEN_       = "superProcessToken_";

    private final PKJBPM_PROCESSINSTANCE primaryKey;

    public GenJBPM_PROCESSINSTANCE() {
        primaryKey = new PKJBPM_PROCESSINSTANCE();
    }

    public GenJBPM_PROCESSINSTANCE(Long pId) {
        primaryKey = new PKJBPM_PROCESSINSTANCE(pId);
    }

    @Transient
    @Override
    public PKJBPM_PROCESSINSTANCE getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJBPM_PROCESSINSTANCE> getMetaClass() {
        return QJBPM_PROCESSINSTANCE.class;
    }

    @Id
    @Column(name=GenJBPM_PROCESSINSTANCE.ID_)
    public Long getId_() {
        return getPrimaryKey().getId_();
    }

    public void setId_(Long pId) {
        getPrimaryKey().setId_(pId);
    }

    private Long version_;

    @Column(name=GenJBPM_PROCESSINSTANCE.VERSION_)
    public Long getVersion_() {
        return version_;
    }

    public void setVersion_(Long pVersion) {
        version_ = pVersion;
    }

    private String key_;

    @Column(name=GenJBPM_PROCESSINSTANCE.KEY_)
    public String getKey() {
        return key_;
    }

    public void setKey(String pKey) {
        key_ = pKey;
    }

    private String start_;

    @Column(name=GenJBPM_PROCESSINSTANCE.START_)
    public String getStart() {
        return start_;
    }

    public void setStart(String pStart) {
        start_ = pStart;
    }

    private String end_;

    @Column(name=GenJBPM_PROCESSINSTANCE.END_)
    public String getEnd_() {
        return end_;
    }

    public void setEnd_(String pEnd) {
        end_ = pEnd;
    }

    private String isSuspended_;

    @Column(name=GenJBPM_PROCESSINSTANCE.ISSUSPENDED_)
    public String getIssuspended_() {
        return isSuspended_;
    }

    public void setIssuspended_(String pIssuspended) {
        isSuspended_ = pIssuspended;
    }

    private Long processDefinition_;

    @Column(name=GenJBPM_PROCESSINSTANCE.PROCESSDEFINITION_)
    public Long getProcessDefinition_() {
        return processDefinition_;
    }

    public void setProcessDefinition_(Long pProcessdefinition) {
        processDefinition_ = pProcessdefinition;
    }

    private Long rootToken_;

    @Column(name=GenJBPM_PROCESSINSTANCE.ROOTTOKEN_)
    public Long getRoottoken_() {
        return rootToken_;
    }

    public void setRoottoken_(Long pRoottoken) {
        rootToken_ = pRoottoken;
    }

    private Long superProcessToken_;

    @Column(name=GenJBPM_PROCESSINSTANCE.SUPERPROCESSTOKEN_)
    public Long getSuperprocesstoken_() {
        return superProcessToken_;
    }

    public void setSuperprocesstoken_(Long pSuperprocesstoken) {
        superProcessToken_ = pSuperprocesstoken;
    }
}
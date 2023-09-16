package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.JBPM_PROCESSDEFINITION;
import yuyu.def.db.id.PKJBPM_PROCESSDEFINITION;
import yuyu.def.db.meta.GenQJBPM_PROCESSDEFINITION;
import yuyu.def.db.meta.QJBPM_PROCESSDEFINITION;

/**
 * ＪＢＰＭプロセス定義 テーブルのマッピング情報クラスで、 {@link JBPM_PROCESSDEFINITION} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JBPM_PROCESSDEFINITION}</td><td colspan="3">ＪＢＰＭプロセス定義</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getId id_}</td><td>ＪＢＰＭ一意ＩＤ</td><td align="center">{@link PKJBPM_PROCESSDEFINITION ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getClass class_}</td><td>ＪＢＰＭ種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getName name_}</td><td>ＪＢＰＭ名前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDescription description_}</td><td>ＪＢＰＭ説明</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getVersion version_}</td><td>ＪＢＰＭバージョン</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getIsterminationimplicit isTerminationImplicit_}</td><td>ＪＢＰＭ衝突中止フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>{@link #getStartstate startState_}</td><td>ＪＢＰＭ開始状態</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     JBPM_PROCESSDEFINITION
 * @see     PKJBPM_PROCESSDEFINITION
 * @see     QJBPM_PROCESSDEFINITION
 * @see     GenQJBPM_PROCESSDEFINITION
 */
@MappedSuperclass
@Table(name=GenJBPM_PROCESSDEFINITION.TABLE_NAME)
@IdClass(value=PKJBPM_PROCESSDEFINITION.class)
public abstract class GenJBPM_PROCESSDEFINITION extends AbstractExDBEntityForJBPM<JBPM_PROCESSDEFINITION, PKJBPM_PROCESSDEFINITION> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JBPM_PROCESSDEFINITION";
    public static final String ID_                      = "id_";
    public static final String CLASS_                   = "class_";
    public static final String NAME_                    = "name_";
    public static final String DESCRIPTION_             = "description_";
    public static final String VERSION_                 = "version_";
    public static final String ISTERMINATIONIMPLICIT_   = "isTerminationImplicit_";
    public static final String STARTSTATE_              = "startState_";

    private final PKJBPM_PROCESSDEFINITION primaryKey;

    public GenJBPM_PROCESSDEFINITION() {
        primaryKey = new PKJBPM_PROCESSDEFINITION();
    }

    public GenJBPM_PROCESSDEFINITION(Long pId) {
        primaryKey = new PKJBPM_PROCESSDEFINITION(pId);
    }

    @Transient
    @Override
    public PKJBPM_PROCESSDEFINITION getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJBPM_PROCESSDEFINITION> getMetaClass() {
        return QJBPM_PROCESSDEFINITION.class;
    }

    @Id
    @Column(name=GenJBPM_PROCESSDEFINITION.ID_)
    public Long getId_() {
        return getPrimaryKey().getId_();
    }

    public void setId_(Long pId) {
        getPrimaryKey().setId_(pId);
    }

    private String class_;

    @Column(name=GenJBPM_PROCESSDEFINITION.CLASS_)
    public String getClass_() {
        return class_;
    }

    public void setClass_(String pClass) {
        class_ = pClass;
    }

    private String name_;

    @Column(name=GenJBPM_PROCESSDEFINITION.NAME_)
    public String getName_() {
        return name_;
    }

    public void setName_(String pName) {
        name_ = pName;
    }

    private String description_;

    @Column(name=GenJBPM_PROCESSDEFINITION.DESCRIPTION_)
    public String getDescription_() {
        return description_;
    }

    public void setDescription_(String pDescription) {
        description_ = pDescription;
    }

    private Long version_;

    @Column(name=GenJBPM_PROCESSDEFINITION.VERSION_)
    public Long getVersion_() {
        return version_;
    }

    public void setVersion_(Long pVersion) {
        version_ = pVersion;
    }

    private String isTerminationImplicit_;

    @Column(name=GenJBPM_PROCESSDEFINITION.ISTERMINATIONIMPLICIT_)
    public String getIsTerminationImplicit_() {
        return isTerminationImplicit_;
    }

    public void setIsTerminationImplicit_(String pIsterminationimplicit) {
        isTerminationImplicit_ = pIsterminationimplicit;
    }

    private Long startState_;

    @Column(name=GenJBPM_PROCESSDEFINITION.STARTSTATE_)
    public Long getStartstate_() {
        return startState_;
    }

    public void setStartstate_(Long pStartstate) {
        startState_ = pStartstate;
    }
}
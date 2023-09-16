package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.db.id.PKDM_JimutetuzukiTask;
import yuyu.def.db.meta.GenQDM_JimutetuzukiTask;
import yuyu.def.db.meta.QDM_JimutetuzukiTask;

/**
 * 事務手続タスクマスタ テーブルのマッピング情報クラスで、 {@link DM_JimutetuzukiTask} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link DM_JimutetuzukiTask}</td><td colspan="3">事務手続タスクマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">{@link PKDM_JimutetuzukiTask ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">{@link PKDM_JimutetuzukiTask ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWorkflowTskId workflowTskId}</td><td>ワークフロータスクID</td><td align="center">{@link PKDM_JimutetuzukiTask ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWorkflowTskNm workflowTskNm}</td><td>ワークフロータスク名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujijyun hyoujijyun}</td><td>表示順</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getWorklistHyoujiFlag worklistHyoujiFlag}</td><td>工程ワークリスト表示フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     DM_JimutetuzukiTask
 * @see     PKDM_JimutetuzukiTask
 * @see     QDM_JimutetuzukiTask
 * @see     GenQDM_JimutetuzukiTask
 */
@MappedSuperclass
@Table(name=GenDM_JimutetuzukiTask.TABLE_NAME)
@IdClass(value=PKDM_JimutetuzukiTask.class)
public abstract class GenDM_JimutetuzukiTask extends AbstractExDBEntity<DM_JimutetuzukiTask, PKDM_JimutetuzukiTask> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "DM_JimutetuzukiTask";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String JIMUTETUZUKICD           = "jimutetuzukicd";
    public static final String WORKFLOWTSKID            = "workflowTskId";
    public static final String WORKFLOWTSKNM            = "workflowTskNm";
    public static final String HYOUJIJYUN               = "hyoujijyun";
    public static final String WORKLISTHYOUJIFLAG       = "worklistHyoujiFlag";

    private final PKDM_JimutetuzukiTask primaryKey;

    public GenDM_JimutetuzukiTask() {
        primaryKey = new PKDM_JimutetuzukiTask();
    }

    public GenDM_JimutetuzukiTask(
        String pSubSystemId,
        String pJimutetuzukicd,
        String pWorkflowTskId
    ) {
        primaryKey = new PKDM_JimutetuzukiTask(
            pSubSystemId,
            pJimutetuzukicd,
            pWorkflowTskId
        );
    }

    @Transient
    @Override
    public PKDM_JimutetuzukiTask getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QDM_JimutetuzukiTask> getMetaClass() {
        return QDM_JimutetuzukiTask.class;
    }

    @Id
    @Column(name=GenDM_JimutetuzukiTask.SUBSYSTEMID)
    public String getSubSystemId() {
        return getPrimaryKey().getSubSystemId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        getPrimaryKey().setSubSystemId(pSubSystemId);
    }

    @Id
    @Column(name=GenDM_JimutetuzukiTask.JIMUTETUZUKICD)
    public String getJimutetuzukicd() {
        return getPrimaryKey().getJimutetuzukicd();
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        getPrimaryKey().setJimutetuzukicd(pJimutetuzukicd);
    }

    @Id
    @Column(name=GenDM_JimutetuzukiTask.WORKFLOWTSKID)
    public String getWorkflowTskId() {
        return getPrimaryKey().getWorkflowTskId();
    }

    public void setWorkflowTskId(String pWorkflowTskId) {
        getPrimaryKey().setWorkflowTskId(pWorkflowTskId);
    }

    private String workflowTskNm;

    @Column(name=GenDM_JimutetuzukiTask.WORKFLOWTSKNM)
    public String getWorkflowTskNm() {
        return workflowTskNm;
    }

    public void setWorkflowTskNm(String pWorkflowTskNm) {
        workflowTskNm = pWorkflowTskNm;
    }

    private Integer hyoujijyun;

    @Column(name=GenDM_JimutetuzukiTask.HYOUJIJYUN)
    public Integer getHyoujijyun() {
        return hyoujijyun;
    }

    public void setHyoujijyun(Integer pHyoujijyun) {
        hyoujijyun = pHyoujijyun;
    }

    private Integer worklistHyoujiFlag;

    @Column(name=GenDM_JimutetuzukiTask.WORKLISTHYOUJIFLAG)
    public Integer getWorklistHyoujiFlag() {
        return worklistHyoujiFlag;
    }

    public void setWorklistHyoujiFlag(Integer pWorklistHyoujiFlag) {
        worklistHyoujiFlag = pWorklistHyoujiFlag;
    }
}

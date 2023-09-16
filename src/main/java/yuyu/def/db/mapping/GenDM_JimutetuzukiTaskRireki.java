package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.DM_JimutetuzukiTaskRireki;
import yuyu.def.db.id.PKDM_JimutetuzukiTaskRireki;
import yuyu.def.db.meta.GenQDM_JimutetuzukiTaskRireki;
import yuyu.def.db.meta.QDM_JimutetuzukiTaskRireki;

/**
 * 事務手続タスクマスタ履歴保存テーブル テーブルのマッピング情報クラスで、 {@link DM_JimutetuzukiTaskRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link DM_JimutetuzukiTaskRireki}</td><td colspan="3">事務手続タスクマスタ履歴保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKensuuHokanYmd kensuuHokanYmd}</td><td>件数保管日</td><td align="center">{@link PKDM_JimutetuzukiTaskRireki ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">{@link PKDM_JimutetuzukiTaskRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">{@link PKDM_JimutetuzukiTaskRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWorkflowTskId workflowTskId}</td><td>ワークフロータスクID</td><td align="center">{@link PKDM_JimutetuzukiTaskRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWorkflowTskNm workflowTskNm}</td><td>ワークフロータスク名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujijyun hyoujijyun}</td><td>表示順</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getWorklistHyoujiFlag worklistHyoujiFlag}</td><td>工程ワークリスト表示フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     DM_JimutetuzukiTaskRireki
 * @see     PKDM_JimutetuzukiTaskRireki
 * @see     QDM_JimutetuzukiTaskRireki
 * @see     GenQDM_JimutetuzukiTaskRireki
 */
@MappedSuperclass
@Table(name=GenDM_JimutetuzukiTaskRireki.TABLE_NAME)
@IdClass(value=PKDM_JimutetuzukiTaskRireki.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenDM_JimutetuzukiTaskRireki extends AbstractExDBEntity<DM_JimutetuzukiTaskRireki, PKDM_JimutetuzukiTaskRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "DM_JimutetuzukiTaskRireki";
    public static final String KENSUUHOKANYMD           = "kensuuHokanYmd";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String JIMUTETUZUKICD           = "jimutetuzukicd";
    public static final String WORKFLOWTSKID            = "workflowTskId";
    public static final String WORKFLOWTSKNM            = "workflowTskNm";
    public static final String HYOUJIJYUN               = "hyoujijyun";
    public static final String WORKLISTHYOUJIFLAG       = "worklistHyoujiFlag";

    private final PKDM_JimutetuzukiTaskRireki primaryKey;

    public GenDM_JimutetuzukiTaskRireki() {
        primaryKey = new PKDM_JimutetuzukiTaskRireki();
    }

    public GenDM_JimutetuzukiTaskRireki(
        BizDate pKensuuHokanYmd,
        String pSubSystemId,
        String pJimutetuzukicd,
        String pWorkflowTskId
    ) {
        primaryKey = new PKDM_JimutetuzukiTaskRireki(
            pKensuuHokanYmd,
            pSubSystemId,
            pJimutetuzukicd,
            pWorkflowTskId
        );
    }

    @Transient
    @Override
    public PKDM_JimutetuzukiTaskRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QDM_JimutetuzukiTaskRireki> getMetaClass() {
        return QDM_JimutetuzukiTaskRireki.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenDM_JimutetuzukiTaskRireki.KENSUUHOKANYMD)
    public BizDate getKensuuHokanYmd() {
        return getPrimaryKey().getKensuuHokanYmd();
    }

    public void setKensuuHokanYmd(BizDate pKensuuHokanYmd) {
        getPrimaryKey().setKensuuHokanYmd(pKensuuHokanYmd);
    }

    @Id
    @Column(name=GenDM_JimutetuzukiTaskRireki.SUBSYSTEMID)
    public String getSubSystemId() {
        return getPrimaryKey().getSubSystemId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        getPrimaryKey().setSubSystemId(pSubSystemId);
    }

    @Id
    @Column(name=GenDM_JimutetuzukiTaskRireki.JIMUTETUZUKICD)
    public String getJimutetuzukicd() {
        return getPrimaryKey().getJimutetuzukicd();
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        getPrimaryKey().setJimutetuzukicd(pJimutetuzukicd);
    }

    @Id
    @Column(name=GenDM_JimutetuzukiTaskRireki.WORKFLOWTSKID)
    public String getWorkflowTskId() {
        return getPrimaryKey().getWorkflowTskId();
    }

    public void setWorkflowTskId(String pWorkflowTskId) {
        getPrimaryKey().setWorkflowTskId(pWorkflowTskId);
    }

    private String workflowTskNm;

    @Column(name=GenDM_JimutetuzukiTaskRireki.WORKFLOWTSKNM)
    public String getWorkflowTskNm() {
        return workflowTskNm;
    }

    public void setWorkflowTskNm(String pWorkflowTskNm) {
        workflowTskNm = pWorkflowTskNm;
    }

    private Integer hyoujijyun;

    @Column(name=GenDM_JimutetuzukiTaskRireki.HYOUJIJYUN)
    public Integer getHyoujijyun() {
        return hyoujijyun;
    }

    public void setHyoujijyun(Integer pHyoujijyun) {
        hyoujijyun = pHyoujijyun;
    }

    private Integer worklistHyoujiFlag;

    @Column(name=GenDM_JimutetuzukiTaskRireki.WORKLISTHYOUJIFLAG)
    public Integer getWorklistHyoujiFlag() {
        return worklistHyoujiFlag;
    }

    public void setWorklistHyoujiFlag(Integer pWorklistHyoujiFlag) {
        worklistHyoujiFlag = pWorklistHyoujiFlag;
    }
}
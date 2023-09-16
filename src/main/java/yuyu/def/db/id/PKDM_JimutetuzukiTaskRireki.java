package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.DM_JimutetuzukiTaskRireki;
import yuyu.def.db.mapping.GenDM_JimutetuzukiTaskRireki;
import yuyu.def.db.meta.GenQDM_JimutetuzukiTaskRireki;
import yuyu.def.db.meta.QDM_JimutetuzukiTaskRireki;

/**
 * 事務手続タスクマスタ履歴保存テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link DM_JimutetuzukiTaskRireki}</td><td colspan="3">事務手続タスクマスタ履歴保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKensuuHokanYmd kensuuHokanYmd}</td><td>件数保管日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getWorkflowTskId workflowTskId}</td><td>ワークフロータスクID</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>workflowTskNm</td><td>ワークフロータスク名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujijyun</td><td>表示順</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>worklistHyoujiFlag</td><td>工程ワークリスト表示フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     DM_JimutetuzukiTaskRireki
 * @see     GenDM_JimutetuzukiTaskRireki
 * @see     QDM_JimutetuzukiTaskRireki
 * @see     GenQDM_JimutetuzukiTaskRireki
 */
public class PKDM_JimutetuzukiTaskRireki extends AbstractExDBPrimaryKey<DM_JimutetuzukiTaskRireki, PKDM_JimutetuzukiTaskRireki> {

    private static final long serialVersionUID = 1L;

    public PKDM_JimutetuzukiTaskRireki() {
    }

    public PKDM_JimutetuzukiTaskRireki(
        BizDate pKensuuHokanYmd,
        String pSubSystemId,
        String pJimutetuzukicd,
        String pWorkflowTskId
    ) {
        kensuuHokanYmd = pKensuuHokanYmd;
        subSystemId = pSubSystemId;
        jimutetuzukicd = pJimutetuzukicd;
        workflowTskId = pWorkflowTskId;
    }

    @Transient
    @Override
    public Class<DM_JimutetuzukiTaskRireki> getEntityClass() {
        return DM_JimutetuzukiTaskRireki.class;
    }

    private BizDate kensuuHokanYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKensuuHokanYmd() {
        return kensuuHokanYmd;
    }

    public void setKensuuHokanYmd(BizDate pKensuuHokanYmd) {
        kensuuHokanYmd = pKensuuHokanYmd;
    }
    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }
    private String jimutetuzukicd;

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }
    private String workflowTskId;

    public String getWorkflowTskId() {
        return workflowTskId;
    }

    public void setWorkflowTskId(String pWorkflowTskId) {
        workflowTskId = pWorkflowTskId;
    }

}
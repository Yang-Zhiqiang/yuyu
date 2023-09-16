package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.id.PKDM_JimutetuzukiTaskRireki;
import yuyu.def.db.mapping.GenDM_JimutetuzukiTaskRireki;
import yuyu.def.db.meta.GenQDM_JimutetuzukiTaskRireki;
import yuyu.def.db.meta.QDM_JimutetuzukiTaskRireki;
import jp.co.slcs.swak.date.BizDate;

/**
 * 事務手続タスクマスタ履歴保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenDM_JimutetuzukiTaskRireki} の JavaDoc を参照してください。
 * @see     GenDM_JimutetuzukiTaskRireki
 * @see     PKDM_JimutetuzukiTaskRireki
 * @see     QDM_JimutetuzukiTaskRireki
 * @see     GenQDM_JimutetuzukiTaskRireki
 */
@Entity
public class DM_JimutetuzukiTaskRireki extends GenDM_JimutetuzukiTaskRireki {

    private static final long serialVersionUID = 1L;

    public DM_JimutetuzukiTaskRireki() {
    }

    public DM_JimutetuzukiTaskRireki(
        BizDate pKensuuHokanYmd,
        String pSubSystemId,
        String pJimutetuzukicd,
        String pWorkflowTskId
        ) {
        super(
            pKensuuHokanYmd,
            pSubSystemId,
            pJimutetuzukicd,
            pWorkflowTskId
            );
    }

    private DM_JimutetuzukiRireki dM_JimutetuzukiRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=DM_JimutetuzukiTaskRireki.KENSUUHOKANYMD , referencedColumnName=DM_JimutetuzukiRireki.KENSUUHOKANYMD, insertable=false, updatable=false),
        @JoinColumn(name=DM_JimutetuzukiTaskRireki.JIMUTETUZUKICD , referencedColumnName=DM_JimutetuzukiRireki.JIMUTETUZUKICD, insertable=false, updatable=false),
        @JoinColumn(name=DM_JimutetuzukiTaskRireki.SUBSYSTEMID , referencedColumnName=DM_JimutetuzukiRireki.SUBSYSTEMID, insertable=false, updatable=false)
    })
    public DM_JimutetuzukiRireki getJimutetuzukiRireki() {
        return dM_JimutetuzukiRireki;
    }

    public void setJimutetuzukiRireki(DM_JimutetuzukiRireki pDM_JimutetuzukiRireki) {
        this.dM_JimutetuzukiRireki = pDM_JimutetuzukiRireki;
    }

}

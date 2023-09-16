package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenDM_JimutetuzukiRireki;
import yuyu.def.workflow.predicate.FilterJimutetuzukiTaskRirekiByWorkflowTskId;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 事務手続マスタ履歴保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenDM_JimutetuzukiRireki} の JavaDoc を参照してください。<br />
 * @see     GenDM_JimutetuzukiRireki<br />
 * @see     PKDM_JimutetuzukiRireki<br />
 * @see     QDM_JimutetuzukiRireki<br />
 * @see     GenQDM_JimutetuzukiRireki<br />
 */
@Entity
public class DM_JimutetuzukiRireki extends GenDM_JimutetuzukiRireki {

    private static final long serialVersionUID = 1L;

    public DM_JimutetuzukiRireki() {
    }

    public DM_JimutetuzukiRireki(
        BizDate pKensuuHokanYmd,
        String pJimutetuzukicd,
        String pSubSystemId
        ) {
        super(
            pKensuuHokanYmd,
            pJimutetuzukicd,
            pSubSystemId
            );
    }

    private List<DM_JimutetuzukiTaskRireki> dM_JimutetuzukiTaskRirekis = Lists.newLinkedList();

    public DM_JimutetuzukiTaskRireki createJimutetuzukiTaskRireki() {
        DM_JimutetuzukiTaskRireki jimutetuzukiTaskRireki =  new DM_JimutetuzukiTaskRireki();
        jimutetuzukiTaskRireki.setJimutetuzukiRireki(this);
        jimutetuzukiTaskRireki.setKensuuHokanYmd(this.getKensuuHokanYmd());
        jimutetuzukiTaskRireki.setJimutetuzukicd(this.getJimutetuzukicd());
        jimutetuzukiTaskRireki.setSubSystemId(this.getSubSystemId());
        getJimutetuzukiTaskRirekis().add(jimutetuzukiTaskRireki);
        return jimutetuzukiTaskRireki;
    }

    public void setJimutetuzukiTaskRirekis(List<DM_JimutetuzukiTaskRireki> pDM_JimutetuzukiTaskRirekis) {
        this.dM_JimutetuzukiTaskRirekis = pDM_JimutetuzukiTaskRirekis;
    }
    @OneToMany (
        mappedBy = "jimutetuzukiRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(DM_JimutetuzukiTaskRireki.KENSUUHOKANYMD+" ASC ,"+DM_JimutetuzukiTaskRireki.SUBSYSTEMID+" ASC ,"
        +DM_JimutetuzukiTaskRireki.JIMUTETUZUKICD+" ASC ,"+DM_JimutetuzukiTaskRireki.WORKFLOWTSKID+" ASC ")
    public  List<DM_JimutetuzukiTaskRireki> getJimutetuzukiTaskRirekis() {
        return dM_JimutetuzukiTaskRirekis;
    }

    @Transient
    public  DM_JimutetuzukiTaskRireki getJimutetuzukiTaskRirekiByWorkflowTskId(String pWorkflowTskId) {
        return Iterables.getFirst(Iterables.filter(getJimutetuzukiTaskRirekis(),
            new FilterJimutetuzukiTaskRirekiByWorkflowTskId(pWorkflowTskId)), null);
    }
}


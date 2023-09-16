package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import yuyu.def.db.mapping.GenDM_Jimutetuzuki;
import yuyu.def.workflow.predicate.FilterJimutetuzukiTaskByWorkflowTskId;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * 事務手続マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenDM_Jimutetuzuki} の JavaDoc を参照してください。<br />
 * @see     GenDM_Jimutetuzuki<br />
 * @see     PKDM_Jimutetuzuki<br />
 * @see     QDM_Jimutetuzuki<br />
 * @see     GenQDM_Jimutetuzuki<br />
 */
@Entity
public class DM_Jimutetuzuki extends GenDM_Jimutetuzuki {

    private static final long serialVersionUID = 1L;

    public DM_Jimutetuzuki() {
    }

    public DM_Jimutetuzuki(String pJimutetuzukicd,String pSubSystemId) {
        super(pJimutetuzukicd,pSubSystemId);
    }



    private List<DM_JimutetuzukiTask> dM_JimutetuzukiTasks = Lists.newLinkedList();
    public DM_JimutetuzukiTask createJimutetuzukiTask() {
        DM_JimutetuzukiTask jimutetuzukiTask =  new DM_JimutetuzukiTask();
        jimutetuzukiTask.setJimutetuzuki(this);
        jimutetuzukiTask.setJimutetuzukicd(this.getJimutetuzukicd());
        jimutetuzukiTask.setSubSystemId(this.getSubSystemId());
        getJimutetuzukiTasks().add(jimutetuzukiTask);
        return jimutetuzukiTask;
    }
    public void setJimutetuzukiTasks(List<DM_JimutetuzukiTask> pDM_JimutetuzukiTasks) {
        this.dM_JimutetuzukiTasks = pDM_JimutetuzukiTasks;
    }
    @OneToMany (
        mappedBy = "jimutetuzuki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(DM_JimutetuzukiTask.SUBSYSTEMID+" ASC ,"+DM_JimutetuzukiTask.JIMUTETUZUKICD+" ASC ,"+DM_JimutetuzukiTask.WORKFLOWTSKID+" ASC ")
    public  List<DM_JimutetuzukiTask> getJimutetuzukiTasks() {
        return dM_JimutetuzukiTasks;
    }

    @Transient
    public  DM_JimutetuzukiTask getJimutetuzukiTaskByWorkflowTskId(String pWorkflowTskId) {
        return Iterables.getFirst(Iterables.filter(getJimutetuzukiTasks(),
            new FilterJimutetuzukiTaskByWorkflowTskId(pWorkflowTskId)), null);
    }
}


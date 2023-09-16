package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenDM_JimutetuzukiTask;


/**
 * 事務手続タスクマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenDM_JimutetuzukiTask} の JavaDoc を参照してください。<br />
 * @see     GenDM_JimutetuzukiTask<br />
 * @see     PKDM_JimutetuzukiTask<br />
 * @see     QDM_JimutetuzukiTask<br />
 * @see     GenQDM_JimutetuzukiTask<br />
 */
@Entity
public class DM_JimutetuzukiTask extends GenDM_JimutetuzukiTask {

    private static final long serialVersionUID = 1L;

    public DM_JimutetuzukiTask() {
    }

    public DM_JimutetuzukiTask(String pSubSystemId,String pJimutetuzukicd,String pWorkflowTskId) {
        super(pSubSystemId,pJimutetuzukicd,pWorkflowTskId);
    }



    private DM_Jimutetuzuki dM_Jimutetuzuki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=DM_JimutetuzukiTask.JIMUTETUZUKICD  , referencedColumnName=DM_Jimutetuzuki.JIMUTETUZUKICD, insertable=false, updatable=false),
        @JoinColumn(name=DM_JimutetuzukiTask.SUBSYSTEMID  , referencedColumnName=DM_Jimutetuzuki.SUBSYSTEMID, insertable=false, updatable=false)
    })
    public DM_Jimutetuzuki getJimutetuzuki() {
        return dM_Jimutetuzuki;
    }

    public void setJimutetuzuki(DM_Jimutetuzuki pDM_Jimutetuzuki) {
        this.dM_Jimutetuzuki = pDM_Jimutetuzuki;
    }

}


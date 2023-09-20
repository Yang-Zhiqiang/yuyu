package yuyu.common.workflow.collection;

import yuyu.def.db.entity.DM_JimutetuzukiTask;

import com.google.common.base.Predicate;

/**
 * イメージワークフロータスクID抽出処理です。<br/>
 */
public class WorkflowTaskFilter implements Predicate<DM_JimutetuzukiTask> {

    private String targetJimutetuzukiCd = null;

    public void setTargetJimutetuzukiCd(String pJimutetuzukiCd) {
        targetJimutetuzukiCd = pJimutetuzukiCd;
    }
    public String getTargetJimutetuzukiCd() {
        return targetJimutetuzukiCd;
    }

    private String targetTaskId = null;

    public void setTargetTaskId(String pTaskId) {
        targetTaskId = pTaskId;
    }
    public String getTargetTaskId() {
        return targetTaskId;
    }

    @Override
    public boolean apply(DM_JimutetuzukiTask jimutetuzuki) {
        if (targetJimutetuzukiCd.equals(jimutetuzuki.getJimutetuzukicd()) &&
                targetTaskId.equals(jimutetuzuki.getWorkflowTskId())) {
            return true;
        }
        return false;
    }
}

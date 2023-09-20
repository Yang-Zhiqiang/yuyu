package yuyu.common.workflow.collection;

import yuyu.def.db.entity.DM_Jimutetuzuki;

import com.google.common.base.Predicate;

/**
 * イメージワークフロー事務手続コード抽出処理です。<br/>
 */
public class WorkflowJimutetuzukiFilter implements Predicate<DM_Jimutetuzuki> {

    private String targetJimutetuzukiCd = null;

    public void setTargetJimutetuzukiCd(String pJimutetuzukiCd) {
        targetJimutetuzukiCd = pJimutetuzukiCd;
    }
    public String getTargetJimutetuzukiCd() {
        return targetJimutetuzukiCd;
    }

    @Override
    public boolean apply(DM_Jimutetuzuki jimutetuzuki) {
        if (targetJimutetuzukiCd.equals(jimutetuzuki.getJimutetuzukicd())) {
            return true;
        }
        return false;
    }
}

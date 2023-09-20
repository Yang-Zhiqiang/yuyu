package yuyu.common.workflow.collection;

import yuyu.def.db.entity.BT_WariateHukaInfo;

import com.google.common.base.Predicate;

/**
 * 【イメージワークフロー割当不可情報抽出処理】
 */
public class WorkflowWariateInfoFilter implements Predicate<BT_WariateHukaInfo> {

    private String targetGyoumuKey = null;

    public void setTargetGyoumuKey(String pGyoumuKey) {
        targetGyoumuKey = pGyoumuKey;
    }
    public String getTargetGyoumuKey() {
        return targetGyoumuKey;
    }

    private String targetFlowNm = null;

    public void setTargetFlowNm(String pFlowNm) {
        targetFlowNm = pFlowNm;
    }
    public String getTargetFlowNm() {
        return targetFlowNm;
    }

    private String targetNodeNm = null;

    public void setTargetNodeNm(String pNodeNm) {
        targetNodeNm = pNodeNm;
    }
    public String getTargetNodeNm() {
        return targetNodeNm;
    }

    @Override
    public boolean apply(BT_WariateHukaInfo wariateInfo) {
        if (targetGyoumuKey.equals(wariateInfo.getKouteikanriid()) &&
                targetFlowNm.equals(wariateInfo.getJimutetuzukicd()) &&
                targetNodeNm.equals(wariateInfo.getWrthukatskid())) {
            return true;
        }
        return false;
    }
}

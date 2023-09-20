package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * スキャン対象取込書類マスタ取得 の処理結果クラスです。<br />
 */
public class GetScanTorikomiSyoruiMstResultBean extends WorkListResultBean{

    public GetScanTorikomiSyoruiMstResultBean() {
    }

    private List<TorikomiSyoruiMstBean> torikomiSyoruiMstBeanList = new ArrayList<TorikomiSyoruiMstBean>();

    public List<TorikomiSyoruiMstBean> getTorikomiSyoruiMstBeanList() {
        return torikomiSyoruiMstBeanList;
    }

    public void setTorikomiSyoruiMstBeanList(List<TorikomiSyoruiMstBean> pTorikomiSyoruiMstBeanList) {
        torikomiSyoruiMstBeanList = pTorikomiSyoruiMstBeanList;
    }
}

package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * 取込書類マスタ取得 の処理結果クラスです。<br />
 */
public class GetTorikomiSyoruiMstResultBean extends WorkListResultBean{

    public GetTorikomiSyoruiMstResultBean() {
    }

    private List<TorikomiSyoruiMstBean> torikomiSyoruiMstBeanList = new ArrayList<TorikomiSyoruiMstBean>();

    public List<TorikomiSyoruiMstBean> getTorikomiSyoruiMstBeanList() {
        return torikomiSyoruiMstBeanList;
    }

    public void setTorikomiSyoruiMstBeanList(List<TorikomiSyoruiMstBean> pTorikomiSyoruiMstBeanList) {
        torikomiSyoruiMstBeanList = pTorikomiSyoruiMstBeanList;
    }
}

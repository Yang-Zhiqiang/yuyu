package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * 書類権限取得 の処理結果クラスです。<br />
 */
public class GetSyoruiKengenResultBean extends WorkListResultBean{

    public GetSyoruiKengenResultBean() {
    }

    private List<SyoruiKengenBean> syoruiKengenBeanList = new ArrayList<SyoruiKengenBean>();

    public List<SyoruiKengenBean> getSyoruiKengenBeanList() {
        return syoruiKengenBeanList;
    }

    public void setSyoruiKengenBeanList(List<SyoruiKengenBean> pSyoruiKengenBeanList) {
        syoruiKengenBeanList = pSyoruiKengenBeanList;
    }
}

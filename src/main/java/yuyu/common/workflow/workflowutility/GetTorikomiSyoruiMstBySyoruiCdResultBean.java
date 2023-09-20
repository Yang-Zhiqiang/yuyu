package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse.TorikomiSyoruiBean;


/**
 * 取込書類マスタ取得 の処理結果クラスです。<br />
 */
public class GetTorikomiSyoruiMstBySyoruiCdResultBean extends WorkListResultBean{

    public GetTorikomiSyoruiMstBySyoruiCdResultBean() {
    }

    private List<TorikomiSyoruiBean> torikomiSyoruiBeanList = new ArrayList<TorikomiSyoruiBean>();

    public List<TorikomiSyoruiBean> getTorikomiSyoruiBeanList() {
        return torikomiSyoruiBeanList;
    }

    public void setTorikomiSyoruiMstBeanList(List<TorikomiSyoruiBean> pTorikomiSyoruiBeanList) {
        torikomiSyoruiBeanList = pTorikomiSyoruiBeanList;
    }
}

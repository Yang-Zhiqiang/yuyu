package yuyu.common.biz.workflow.io.koutei;

import java.util.List;

import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate.WSIkkatuProcessCreateRequest;

/**
 * 一括工程作成サービスの入力Bean
 */
@SuppressWarnings("serial")
public class IkkatuProcessCreateInBean extends WSIkkatuProcessCreateRequest {


    private List<ProcessCreateInBean> oProcessCreateInBeanList_;

    public List<ProcessCreateInBean> getProcessCreateInBeanList() {
        return oProcessCreateInBeanList_;
    }

    public void setProcessCreateInBeanList(List<ProcessCreateInBean> poProcessCreateInBeanList) {
        oProcessCreateInBeanList_ = poProcessCreateInBeanList;
    }

    @Override
    @Deprecated
    public void setMaplistXml(String psMaplistXml) {
    }
}

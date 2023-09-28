package yuyu.common.biz.workflow.io.account;

import java.util.List;

import yuyu.common.biz.workflow.io.account.sub.TaskAuthorityBean;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority.WSCreateTaskAuthorityRequest;


/**
 * タスク権限追加サービスの入力Bean
 */
@SuppressWarnings("serial")
public class CreateTaskAuthorityInBean extends WSCreateTaskAuthorityRequest {

    private List<TaskAuthorityBean> oTaskAuthorityBeanList_;

    public List<TaskAuthorityBean> getTaskAuthorityBeanList() {
        return oTaskAuthorityBeanList_;
    }

    public void setTaskAuthorityBeanList(List<TaskAuthorityBean> poTaskAuthorityBeanList) {
        oTaskAuthorityBeanList_ = poTaskAuthorityBeanList;
    }


    @Override
    @Deprecated
    public void setMaplistXml(String psMaplistXml) {
    }
}

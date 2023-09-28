package yuyu.common.biz.workflow.io.koutei;

import java.util.List;

import yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryByActorBean;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskkensuubyactor.WSGetTaskKensuuByActorResponse;

/**
 * ユーザ別タスク件数照会サービスの出力Bean
 */
@SuppressWarnings("serial")
public class GetTaskKensuuByActorOutBean extends WSGetTaskKensuuByActorResponse {

    private List<TaskSummaryByActorBean> oTaskSummaryBeanByActorList;

    public List<TaskSummaryByActorBean> getTaskSummaryByActorBeanList() {
        return oTaskSummaryBeanByActorList;
    }

    public void setTaskSummaryByActorBeanList(List<TaskSummaryByActorBean> poTaskSummaryByActorBeanList) {
        oTaskSummaryBeanByActorList = poTaskSummaryByActorBeanList;
    }
}

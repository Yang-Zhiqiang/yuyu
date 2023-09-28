package yuyu.common.biz.workflow;

import javax.inject.Inject;

import yuyu.common.biz.workflow.io.data.DeleteProcessAndJBPMRecordInBean;
import yuyu.common.biz.workflow.io.data.DeleteProcessAndJBPMRecordOutBean;
import yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord.DeleteProcessAndJBPMRecordBean;
import yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord.WSDeleteProcessAndJBPMRecordRequest;
import yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord.WSDeleteProcessAndJBPMRecordResponse;

/**
 * イメージワークフローデータ管理サービスのクライアントクラスです。</ br>
 * インジェクトして使用して下さい</ br>
 */
public class IwfDataClient {
    @Inject
    IwfCommonClient client;

    public DeleteProcessAndJBPMRecordOutBean execDeleteProcessAndJBPMRecord(DeleteProcessAndJBPMRecordInBean inBean) {
        try {
            IwfClientUtil.validateInBean(inBean, DeleteProcessAndJBPMRecordBean.class.getSimpleName());

            WSDeleteProcessAndJBPMRecordRequest request = new WSDeleteProcessAndJBPMRecordRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);
            request.setDeleteProcessAndJBPMRecordBeanList(inBean.getDeleteProcessAndJBPMRecordBeanList());

            WSDeleteProcessAndJBPMRecordResponse response = client.execDeleteProcessAndJBPMRecord(request);

            DeleteProcessAndJBPMRecordOutBean outBean = new DeleteProcessAndJBPMRecordOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

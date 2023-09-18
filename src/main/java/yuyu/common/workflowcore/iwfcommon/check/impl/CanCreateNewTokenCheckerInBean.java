package yuyu.common.workflowcore.iwfcommon.check.impl;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

public class CanCreateNewTokenCheckerInBean {

    public CanCreateNewTokenCheckerInBean(){
    }

    public CanCreateNewTokenCheckerInBean(IwfCoreDomManager iwfCoreDomManager, IWorkflowContext workflowContext, String gyoumuKey, String flowId, String requestId) {
        this.iwfCoreDomManager = iwfCoreDomManager;
        this.workflowContext = workflowContext;
        this.gyoumuKey = gyoumuKey;
        this.flowId = flowId;
        this.requestId = requestId;
    }

    private IwfCoreDomManager iwfCoreDomManager;
    private IWorkflowContext workflowContext;
    private String gyoumuKey;
    private String flowId;
    private String requestId;

    public IwfCoreDomManager getIwfCoreDomManager() {
        return iwfCoreDomManager;
    }
    public void setIwfCoreDomManager(IwfCoreDomManager iwfCoreDomManager) {
        this.iwfCoreDomManager = iwfCoreDomManager;
    }
    public IWorkflowContext getWorkflowContext() {
        return workflowContext;
    }
    public void setWorkflowContext(IWorkflowContext workflowContext) {
        this.workflowContext = workflowContext;
    }
    public String getGyoumuKey() {
        return gyoumuKey;
    }
    public void setGyoumuKey(String gyoumuKey) {
        this.gyoumuKey = gyoumuKey;
    }
    public String getFlowId() {
        return flowId;
    }
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }
    public String getRequestId() {
        return requestId;
    }
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}

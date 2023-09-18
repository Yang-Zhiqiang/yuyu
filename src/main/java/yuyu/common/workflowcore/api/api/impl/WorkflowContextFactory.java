package yuyu.common.workflowcore.api.api.impl;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;

/**
 * {@link IWorkflowContext} のインスタンスを生成する Factory です。
 */
public class WorkflowContextFactory {

    public static IWorkflowContext newInstance() throws WorkflowRuntimeException{
        try {
            return SWAKInjector.getInstance(IWorkflowContext.class);
        } catch (Exception e) {
            throw new WorkflowRuntimeException(e);
        }
    }

}

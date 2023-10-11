package yuyu.testinfr.inject;

import yuyu.common.workflowcore.inject.WorkflowcoreCommonModule;

public class WorkflowMockModule extends WorkflowcoreCommonModule {
    @Override
    protected void configure() {

        super.configure();

        //        bind(IwfImageClient.class).to(IwfImageClientMock.class);
        //        bind(IwfKouteiClient.class).to(IwfKouteiClientMock.class);
        //        bind(IwfAccountClient.class).to(IwfAccountClientMock.class);
        //
        //        bind(ScanReceiveInfoBean.class).to(ScanReceiveInfoBeanMock.class);

    }
}

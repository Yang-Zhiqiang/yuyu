package yuyu.common.biz.koutei;

import java.util.List;

import javax.inject.Inject;

/**
 * 業務共通 工程 進捗履歴情報設定UiBean
 */
public class SetProgressHistoryExecUiBeanParamImpl implements SetProgressHistoryExecUiBeanParam{

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    public List<ProgressHistoryDataSourceBeanCommonParam> progressHistoryLst ;

    @Override
    public ProgressHistoryDataSourceBeanCommonParam createProgressHistoryDataSourceBean() {
        return new ProgressHistoryDataSourceBeanCommonParamImpl();
    }

    @Override
    public void convertProgressHistoryForCommonParam(
            List<ProgressHistoryDataSourceBeanCommonParam> progressHistoryDataSourceBeanCommonParamLst) {
        progressHistoryLst = progressHistoryDataSourceBeanCommonParamLst;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public List<ProgressHistoryDataSourceBeanCommonParam> getProgressHistoryDataSourceBeanCommonParamLst(){
        return progressHistoryLst;
    }
}

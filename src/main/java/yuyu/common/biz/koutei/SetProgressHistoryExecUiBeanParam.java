package yuyu.common.biz.koutei;

import java.util.List;

/**
 * 業務共通 工程 進捗履歴情報設定UiBeanパラメータ
 */
public interface SetProgressHistoryExecUiBeanParam {

    ProgressHistoryDataSourceBeanCommonParam createProgressHistoryDataSourceBean();

    void convertProgressHistoryForCommonParam(List<ProgressHistoryDataSourceBeanCommonParam> pDataSourceBeanLst);

    BzWorkflowInfo getBzWorkflowInfo();
}

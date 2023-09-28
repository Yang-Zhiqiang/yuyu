package yuyu.common.biz.workflow.io.koutei;

import java.util.List;

import yuyu.common.biz.workflow.io.koutei.sub.ExecutableTaskInfoBean;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess.WSGetExecutableTasksByProcessResponse;

/**
 * 実行可能タスク情報取得(工程指定)サービスの出力Bean
 */
@SuppressWarnings("serial")
public class GetExecutableTasksByProcessOutBean extends WSGetExecutableTasksByProcessResponse {

    private List<ExecutableTaskInfoBean> oExecutableTaskinfos_;

    public List<ExecutableTaskInfoBean> getExecutableTaskInfos() {
        return oExecutableTaskinfos_;
    }

    public void setExecutableTaskInfos(List<ExecutableTaskInfoBean> pExecutableTaskInfos) {
        oExecutableTaskinfos_ = pExecutableTaskInfos;
    }

}

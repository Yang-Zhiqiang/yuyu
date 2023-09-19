package yuyu.common.workflowcore.core.webservice.provide.common.exdao;

import java.util.Map;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;

/**
 * 実行可能タスク取得Daoインタフェース
 */
public interface ExecutableTaskDao {

    public ExDBResults<ExecutableTaskBean> getExecutableTasksByCond(
        String[] pSyoriStatus,
        String pFlowId,
        String[] pNodeNms,
        String pKouteiKaisiYmdFrom,
        String pKouteiKaisiYmdTo,
        String pKouteiKanryouYmdFrom,
        String pKouteiKanryouYmdTo,
        Map<String, WSExtParam> pExtParam);

}

package yuyu.common.biz.koutei;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.workflow.manager.WorkflowDomManager;

/**
 * 業務共通 工程 工程情報表示設定
 */
public class SetKouteiInfo {

    @Inject
    private static Logger logger;

    @Inject
    private WorkflowDomManager workflowDomManager;

    public void exec(SetKouteiInfoExecUiBeanParam pUiBean) {

        logger.debug("▽ 工程情報表示設定 開始");


        DM_Jimutetuzuki jimutetuzuki = null;
        String subSystemId = "";
        String jimutetuzukinm = "";
        String tskNm = "";


        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);
        subSystemId = kinou.getSubSystemId();

        jimutetuzuki = workflowDomManager.getJimutetuzuki(pUiBean.getBzWorkflowInfo().getJimuTetuzukiCd(), subSystemId);

        if (jimutetuzuki != null) {
            jimutetuzukinm = jimutetuzuki.getJimutetuzukinm();
        }

        if (jimutetuzuki != null) {
            DM_JimutetuzukiTask jimutetuzukiTask =
                jimutetuzuki.getJimutetuzukiTaskByWorkflowTskId(pUiBean.getBzWorkflowInfo().getTaskId());

            if (jimutetuzukiTask != null) {
                tskNm = jimutetuzukiTask.getWorkflowTskNm();
            }
        }

        pUiBean.setVktifdispjimutetuzukinm(jimutetuzukinm);
        pUiBean.setVktifdisptasknm(tskNm);

        logger.debug("△ 工程情報表示設定 終了");
    }

}

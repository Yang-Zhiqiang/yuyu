package yuyu.def.workflow.manager;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.base.manager.DomManager;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DM_JimutetuzukiRireki;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.db.entity.DT_SyoriKensuuHokanJimu;
import yuyu.def.db.entity.DT_SyoriKensuuHokanTask;
import yuyu.def.db.entity.DT_WfSentakujyotaiHozon;
import yuyu.def.workflow.result.bean.JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean;


/**
 * ワークフロー DOM マネージャ インターフェース<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public interface WorkflowDomManager extends DomManager {
    List<DM_Jimutetuzuki> getAllJimutetuzuki();

    DM_Jimutetuzuki getJimutetuzuki(String pJimutetuzukicd, String pSubSystemId);

    List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemId(String pSubSystemId);

    List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemIds(String[] pSubSystemId);

    List<JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean> getJimutetuzukiJimutetuzukiTaskSubSystemsByItems(String[] pJimutetuzukicd, String[] pWorkflowTskId);

    List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd(String[] pSubSystemId);

    List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemIdJimutetuzukicds(String pSubSystemId, String[] pJimutetuzukicd);

    List<DM_Jimutetuzuki> getJimutetuzukisByJimutetuzukicd(String pJimutetuzukicd);

    List<DT_WfSentakujyotaiHozon> getAllWfSentakujyotaiHozon();

    DT_WfSentakujyotaiHozon getWfSentakujyotaiHozon(String pUserId, String pSubSystemId);

    List<DM_JimutetuzukiTask> getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId(String pJimutetuzukicd, String pWorkflowTskId);

    List<DM_JimutetuzukiTask> getJimutetuzukiTasksBySubSystemIdsSyukouteijimutetuzukicd(String[] pSubSystemId);

    List<DM_JimutetuzukiTask> getJimutetuzukiTasksByWorklistHyoujiFlag(String[] pSubSystemId);

    List<DM_JimutetuzukiTask> getJimutetuzukiTasksBySubSystemIds(String[] pSubSystemId);

    List<DM_JimutetuzukiRireki> getAllJimutetuzukiRireki();

    DM_JimutetuzukiRireki getJimutetuzukiRireki(BizDate pKensuuHokanYmd, String pJimutetuzukicd, String pSubSystemId);

    List<DT_SyoriKensuuHokanJimu> getAllSyoriKensuuHokanJimu();

    DT_SyoriKensuuHokanJimu getSyoriKensuuHokanJimu(BizDate pKensuuHokanYmd, String pJimutetuzukicd, String pAccountId);

    List<DT_SyoriKensuuHokanTask> getAllSyoriKensuuHokanTask();

    DT_SyoriKensuuHokanTask getSyoriKensuuHokanTask(BizDate pKensuuHokanYmd, String pJimutetuzukicd, String pTskid, String pAccountId);

}

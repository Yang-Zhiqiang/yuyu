package yuyu.def.workflow.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.base.manager.AbstractDomManager;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DM_JimutetuzukiRireki;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.db.entity.DT_SyoriKensuuHokanJimu;
import yuyu.def.db.entity.DT_SyoriKensuuHokanTask;
import yuyu.def.db.entity.DT_WfSentakujyotaiHozon;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.def.workflow.result.bean.JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean;


/**
 * ワークフロー DOM マネージャ 実装クラス<br />
 * {@link WorkflowDomManager}で宣言したメソッドを実装します。<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public class WorkflowDomManagerImpl extends AbstractDomManager implements WorkflowDomManager {

    @Inject
    private ProcessDomManager processDomManager;

    @Override
    public List<DM_Jimutetuzuki> getAllJimutetuzuki() {
        return processDomManager.getAllJimutetuzuki();
    }

    @Override
    public DM_Jimutetuzuki getJimutetuzuki(String pJimutetuzukicd, String pSubSystemId) {
        return processDomManager.getJimutetuzuki(pJimutetuzukicd, pSubSystemId);
    }

    @Override
    public List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemId(String pSubSystemId) {
        return processDomManager.getJimutetuzukisBySubSystemId(pSubSystemId);
    }

    @Override
    public List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemIds(String[] pSubSystemId) {
        return processDomManager.getJimutetuzukisBySubSystemIds(pSubSystemId);
    }

    @Override
    public List<JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean> getJimutetuzukiJimutetuzukiTaskSubSystemsByItems(String[] pJimutetuzukicd, String[] pWorkflowTskId) {
        return processDomManager.getJimutetuzukiJimutetuzukiTaskSubSystemsByItems(pJimutetuzukicd, pWorkflowTskId);
    }

    @Override
    public List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd(String[] pSubSystemId) {
        return processDomManager.getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd(pSubSystemId);
    }

    @Override
    public List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemIdJimutetuzukicds(String pSubSystemId, String[] pJimutetuzukicd) {
        return processDomManager.getJimutetuzukisBySubSystemIdJimutetuzukicds(pSubSystemId, pJimutetuzukicd);
    }

    @Override
    public List<DM_Jimutetuzuki> getJimutetuzukisByJimutetuzukicd(String pJimutetuzukicd) {
        return processDomManager.getJimutetuzukisByJimutetuzukicd(pJimutetuzukicd);
    }

    @Override
    public List<DT_WfSentakujyotaiHozon> getAllWfSentakujyotaiHozon() {
        return processDomManager.getAllWfSentakujyotaiHozon();
    }

    @Override
    public DT_WfSentakujyotaiHozon getWfSentakujyotaiHozon(String pUserId, String pSubSystemId) {
        return processDomManager.getWfSentakujyotaiHozon(pUserId, pSubSystemId);
    }

    @Override
    public List<DM_JimutetuzukiTask> getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId(String pJimutetuzukicd, String pWorkflowTskId) {
        return processDomManager.getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId(pJimutetuzukicd, pWorkflowTskId);
    }

    @Override
    public List<DM_JimutetuzukiTask> getJimutetuzukiTasksBySubSystemIdsSyukouteijimutetuzukicd(String[] pSubSystemId) {
        return processDomManager.getJimutetuzukiTasksBySubSystemIdsSyukouteijimutetuzukicd(pSubSystemId);
    }

    @Override
    public List<DM_JimutetuzukiTask> getJimutetuzukiTasksByWorklistHyoujiFlag(String[] pSubSystemId) {
        return processDomManager.getJimutetuzukiTasksByWorklistHyoujiFlag(pSubSystemId);
    }

    @Override
    public List<DM_JimutetuzukiTask> getJimutetuzukiTasksBySubSystemIds(String[] pSubSystemId) {
        return processDomManager.getJimutetuzukiTasksBySubSystemIds(pSubSystemId);
    }

    @Override
    public List<DM_JimutetuzukiRireki> getAllJimutetuzukiRireki() {
        return processDomManager.getAllJimutetuzukiRireki();
    }

    @Override
    public DM_JimutetuzukiRireki getJimutetuzukiRireki(BizDate pKensuuHokanYmd, String pJimutetuzukicd, String pSubSystemId) {
        return processDomManager.getJimutetuzukiRireki(pKensuuHokanYmd, pJimutetuzukicd, pSubSystemId);
    }

    @Override
    public List<DT_SyoriKensuuHokanJimu> getAllSyoriKensuuHokanJimu() {
        return processDomManager.getAllSyoriKensuuHokanJimu();
    }

    @Override
    public DT_SyoriKensuuHokanJimu getSyoriKensuuHokanJimu(BizDate pKensuuHokanYmd, String pJimutetuzukicd, String pAccountId) {
        return processDomManager.getSyoriKensuuHokanJimu(pKensuuHokanYmd, pJimutetuzukicd, pAccountId);
    }

    @Override
    public List<DT_SyoriKensuuHokanTask> getAllSyoriKensuuHokanTask() {
        return processDomManager.getAllSyoriKensuuHokanTask();
    }

    @Override
    public DT_SyoriKensuuHokanTask getSyoriKensuuHokanTask(BizDate pKensuuHokanYmd, String pJimutetuzukicd, String pTskid, String pAccountId) {
        return processDomManager.getSyoriKensuuHokanTask(pKensuuHokanYmd, pJimutetuzukicd, pTskid, pAccountId);
    }

}

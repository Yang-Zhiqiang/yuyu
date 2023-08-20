package yuyu.def.workflow.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.dao.DM_JimutetuzukiDao;
import yuyu.def.db.dao.DM_JimutetuzukiRirekiDao;
import yuyu.def.db.dao.DM_JimutetuzukiTaskDao;
import yuyu.def.db.dao.DT_SyoriKensuuHokanJimuDao;
import yuyu.def.db.dao.DT_SyoriKensuuHokanTaskDao;
import yuyu.def.db.dao.DT_WfSentakujyotaiHozonDao;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DM_JimutetuzukiRireki;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.db.entity.DT_SyoriKensuuHokanJimu;
import yuyu.def.db.entity.DT_SyoriKensuuHokanTask;
import yuyu.def.db.entity.DT_WfSentakujyotaiHozon;
import yuyu.def.workflow.result.bean.JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean;
import yuyu.def.workflow.sorter.SortDM_Jimutetuzuki;
import yuyu.def.workflow.sorter.SortDM_JimutetuzukiRireki;
import yuyu.def.workflow.sorter.SortDT_SyoriKensuuHokanJimu;
import yuyu.def.workflow.sorter.SortDT_SyoriKensuuHokanTask;
import yuyu.def.workflow.sorter.SortDT_WfSentakujyotaiHozon;


/**
 * ProcessDomマネージャー<br />
 * Processにおける、DB操作を提供する。<br />
 */
class ProcessDomManager {

    @Inject
    private DM_JimutetuzukiDao jimutetuzukiDao;

    @Inject
    private DM_JimutetuzukiRirekiDao jimutetuzukiRirekiDao;

    @Inject
    private DM_JimutetuzukiTaskDao jimutetuzukiTaskDao;

    @Inject
    private DT_SyoriKensuuHokanJimuDao syoriKensuuHokanJimuDao;

    @Inject
    private DT_SyoriKensuuHokanTaskDao syoriKensuuHokanTaskDao;

    @Inject
    private DT_WfSentakujyotaiHozonDao wfSentakujyotaiHozonDao;

    List<DM_Jimutetuzuki> getAllJimutetuzuki(){
        SortDM_Jimutetuzuki sortDM_Jimutetuzuki = new SortDM_Jimutetuzuki();
        return sortDM_Jimutetuzuki.OrderDM_JimutetuzukiByPkAsc(jimutetuzukiDao.selectAll());
    }

    DM_Jimutetuzuki getJimutetuzuki(String pJimutetuzukicd, String pSubSystemId) {

        return jimutetuzukiDao.getJimutetuzuki(pJimutetuzukicd, pSubSystemId);
    }

    List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemId(String pSubSystemId) {

        return jimutetuzukiDao.getJimutetuzukisBySubSystemId(pSubSystemId);
    }

    List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemIds(String[] pSubSystemId) {

        return jimutetuzukiDao.getJimutetuzukisBySubSystemIds(pSubSystemId);
    }

    List<JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean> getJimutetuzukiJimutetuzukiTaskSubSystemsByItems(String[] pJimutetuzukicd, String[] pWorkflowTskId) {
        List<Object[]> objslist = jimutetuzukiDao.getJimutetuzukiJimutetuzukiTaskSubSystemsByItems(pJimutetuzukicd, pWorkflowTskId);
        List<JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean> returnList = new ArrayList<JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean>();
        for(Object[] objs : objslist){
            JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean bean = new JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean();
            bean.setDM_Jimutetuzuki((DM_Jimutetuzuki) objs[0]);
            bean.setDM_JimutetuzukiTask((DM_JimutetuzukiTask) objs[1]);
            bean.setAS_SubSystem((AS_SubSystem) objs[2]);
            returnList.add(bean);
        }

        return returnList;
    }

    List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd(String[] pSubSystemId) {

        return jimutetuzukiDao.getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd(pSubSystemId);
    }

    List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemIdJimutetuzukicds(String pSubSystemId, String[] pJimutetuzukicd) {

        return jimutetuzukiDao.getJimutetuzukisBySubSystemIdJimutetuzukicds(pSubSystemId, pJimutetuzukicd);
    }

    List<DM_Jimutetuzuki> getJimutetuzukisByJimutetuzukicd(String pJimutetuzukicd) {

        return jimutetuzukiDao.getJimutetuzukisByJimutetuzukicd(pJimutetuzukicd);
    }

    List<DT_WfSentakujyotaiHozon> getAllWfSentakujyotaiHozon(){
        SortDT_WfSentakujyotaiHozon sortDT_WfSentakujyotaiHozon = new SortDT_WfSentakujyotaiHozon();
        return sortDT_WfSentakujyotaiHozon.OrderDT_WfSentakujyotaiHozonByPkAsc(wfSentakujyotaiHozonDao.selectAll());
    }

    DT_WfSentakujyotaiHozon getWfSentakujyotaiHozon(String pUserId, String pSubSystemId) {

        return wfSentakujyotaiHozonDao.getWfSentakujyotaiHozon(pUserId, pSubSystemId);
    }

    List<DM_JimutetuzukiTask> getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId(String pJimutetuzukicd, String pWorkflowTskId) {

        return jimutetuzukiTaskDao.getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId(pJimutetuzukicd, pWorkflowTskId);
    }

    List<DM_JimutetuzukiTask> getJimutetuzukiTasksBySubSystemIdsSyukouteijimutetuzukicd(String[] pSubSystemId) {

        return jimutetuzukiTaskDao.getJimutetuzukiTasksBySubSystemIdsSyukouteijimutetuzukicd(pSubSystemId);
    }

    List<DM_JimutetuzukiTask> getJimutetuzukiTasksByWorklistHyoujiFlag(String[] pSubSystemId) {

        return jimutetuzukiTaskDao.getJimutetuzukiTasksByWorklistHyoujiFlag(pSubSystemId);
    }

    List<DM_JimutetuzukiTask> getJimutetuzukiTasksBySubSystemIds(String[] pSubSystemId) {

        return jimutetuzukiTaskDao.getJimutetuzukiTasksBySubSystemIds(pSubSystemId);
    }

    List<DM_JimutetuzukiRireki> getAllJimutetuzukiRireki(){
        SortDM_JimutetuzukiRireki sortDM_JimutetuzukiRireki = new SortDM_JimutetuzukiRireki();
        return sortDM_JimutetuzukiRireki.OrderDM_JimutetuzukiRirekiByPkAsc(jimutetuzukiRirekiDao.selectAll());
    }

    DM_JimutetuzukiRireki getJimutetuzukiRireki(BizDate pKensuuHokanYmd, String pJimutetuzukicd, String pSubSystemId) {

        return jimutetuzukiRirekiDao.getJimutetuzukiRireki(pKensuuHokanYmd, pJimutetuzukicd, pSubSystemId);
    }

    List<DT_SyoriKensuuHokanJimu> getAllSyoriKensuuHokanJimu(){
        SortDT_SyoriKensuuHokanJimu sortDT_SyoriKensuuHokanJimu = new SortDT_SyoriKensuuHokanJimu();
        return sortDT_SyoriKensuuHokanJimu.OrderDT_SyoriKensuuHokanJimuByPkAsc(syoriKensuuHokanJimuDao.selectAll());
    }

    DT_SyoriKensuuHokanJimu getSyoriKensuuHokanJimu(BizDate pKensuuHokanYmd, String pJimutetuzukicd, String pAccountId) {

        return syoriKensuuHokanJimuDao.getSyoriKensuuHokanJimu(pKensuuHokanYmd, pJimutetuzukicd, pAccountId);
    }

    List<DT_SyoriKensuuHokanTask> getAllSyoriKensuuHokanTask(){
        SortDT_SyoriKensuuHokanTask sortDT_SyoriKensuuHokanTask = new SortDT_SyoriKensuuHokanTask();
        return sortDT_SyoriKensuuHokanTask.OrderDT_SyoriKensuuHokanTaskByPkAsc(syoriKensuuHokanTaskDao.selectAll());
    }

    DT_SyoriKensuuHokanTask getSyoriKensuuHokanTask(BizDate pKensuuHokanYmd, String pJimutetuzukicd, String pTskid, String pAccountId) {

        return syoriKensuuHokanTaskDao.getSyoriKensuuHokanTask(pKensuuHokanYmd, pJimutetuzukicd, pTskid, pAccountId);
    }

}

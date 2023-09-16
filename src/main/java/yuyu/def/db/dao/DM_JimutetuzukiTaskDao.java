package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.db.meta.QDM_Jimutetuzuki;
import yuyu.def.db.meta.QDM_JimutetuzukiTask;
/**
 * 事務手続タスクマスタ(DM_JimutetuzukiTaskDao) アクセス用の DAO クラスです。<br />
 */
public class DM_JimutetuzukiTaskDao extends AbstractDao<DM_JimutetuzukiTask> {

    public DM_JimutetuzukiTaskDao() {
        super(DM_JimutetuzukiTask.class);
    }

    @Deprecated
    public DM_JimutetuzukiTask getJimutetuzukiTask(String pSubSystemId,
        String pJimutetuzukicd,
        String pWorkflowTskId){
        DM_JimutetuzukiTask dM_JimutetuzukiTask =  new DM_JimutetuzukiTask();
        dM_JimutetuzukiTask.setSubSystemId(pSubSystemId);
        dM_JimutetuzukiTask.setJimutetuzukicd(pJimutetuzukicd);
        dM_JimutetuzukiTask.setWorkflowTskId(pWorkflowTskId);
        return this.selectOne(dM_JimutetuzukiTask);
    }

    @Override
    @Deprecated
    public List<DM_JimutetuzukiTask> selectAll() {
        return super.selectAll();
    }

    public List<DM_JimutetuzukiTask> getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId(String pJimutetuzukicd,
        String pWorkflowTskId) {

        DM_JimutetuzukiTask dM_JimutetuzukiTask = new DM_JimutetuzukiTask();
        dM_JimutetuzukiTask.setJimutetuzukicd(pJimutetuzukicd);
        dM_JimutetuzukiTask.setWorkflowTskId(pWorkflowTskId);
        return this.select(dM_JimutetuzukiTask);
    }

    public List<DM_JimutetuzukiTask> getJimutetuzukiTasksBySubSystemIds(String[] pSubSystemId) {


        QDM_JimutetuzukiTask qDM_JimutetuzukiTask = new QDM_JimutetuzukiTask();

        String querySql = $SELECT + qDM_JimutetuzukiTask +
            $FROM + qDM_JimutetuzukiTask.DM_JimutetuzukiTask() +
            $WHERE + qDM_JimutetuzukiTask.subSystemId.in(pSubSystemId) +
            $ORDER_BY(qDM_JimutetuzukiTask.hyoujijyun.asc());
        return em.createJPQL(querySql).bind(qDM_JimutetuzukiTask).getResultList();
    }

    public List<DM_JimutetuzukiTask> getJimutetuzukiTasksBySubSystemIdsSyukouteijimutetuzukicd(String[] pSubSystemId) {


        QDM_Jimutetuzuki qDM_Jimutetuzuki = new QDM_Jimutetuzuki();


        QDM_JimutetuzukiTask qDM_JimutetuzukiTask = new QDM_JimutetuzukiTask();

        String querySql = $SELECT + qDM_JimutetuzukiTask +
            $FROM + qDM_JimutetuzukiTask.DM_JimutetuzukiTask() + "," +
            qDM_Jimutetuzuki.DM_Jimutetuzuki() +
            $WHERE + qDM_JimutetuzukiTask.subSystemId.in(pSubSystemId) +
            $AND + qDM_JimutetuzukiTask.subSystemId.eq(qDM_Jimutetuzuki.subSystemId) +
            $AND + qDM_JimutetuzukiTask.jimutetuzukicd.eq(qDM_Jimutetuzuki.jimutetuzukicd) +
            $AND + $(qDM_Jimutetuzuki.syukouteijimutetuzukicd.isNull() +
                $OR + qDM_Jimutetuzuki.syukouteijimutetuzukicd.eq("")) +
                $ORDER_BY(qDM_JimutetuzukiTask.hyoujijyun.asc());

        return em.createJPQL(querySql).bind(qDM_Jimutetuzuki, qDM_JimutetuzukiTask).getResultList();
    }

    public List<DM_JimutetuzukiTask> getJimutetuzukiTasksByWorklistHyoujiFlag(
        String[] pSubSystemId) {


        QDM_JimutetuzukiTask qDM_JimutetuzukiTask = new QDM_JimutetuzukiTask();

        String querySql = $SELECT + qDM_JimutetuzukiTask +
            $FROM + qDM_JimutetuzukiTask.DM_JimutetuzukiTask() +
            $WHERE + qDM_JimutetuzukiTask.subSystemId.in(pSubSystemId) +
            $AND + qDM_JimutetuzukiTask.worklistHyoujiFlag.eq(1) +
            $ORDER_BY(qDM_JimutetuzukiTask.hyoujijyun.asc());

        return em.createJPQL(querySql).bind(qDM_JimutetuzukiTask).getResultList();
    }
}

package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.meta.QAS_SubSystem;
import yuyu.def.db.meta.QDM_Jimutetuzuki;
import yuyu.def.db.meta.QDM_JimutetuzukiTask;

/**
 * 事務手続マスタ(DM_JimutetuzukiDao) アクセス用の DAO クラスです。<br />
 */
public class DM_JimutetuzukiDao extends AbstractDao<DM_Jimutetuzuki> {

    public DM_JimutetuzukiDao() {
        super(DM_Jimutetuzuki.class);
    }

    public DM_Jimutetuzuki getJimutetuzuki(String pJimutetuzukicd,
        String pSubSystemId){
        DM_Jimutetuzuki dM_Jimutetuzuki =  new DM_Jimutetuzuki();
        dM_Jimutetuzuki.setJimutetuzukicd(pJimutetuzukicd);
        dM_Jimutetuzuki.setSubSystemId(pSubSystemId);
        return this.selectOne(dM_Jimutetuzuki);
    }

    public List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemId(String pSubSystemId) {

        DM_Jimutetuzuki dM_Jimutetuzuki =  new DM_Jimutetuzuki();
        dM_Jimutetuzuki.setSubSystemId(pSubSystemId);
        return this.select(dM_Jimutetuzuki);
    }

    public List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemIds(String[] pSubSystemId) {


        QDM_Jimutetuzuki qDM_Jimutetuzuki = new QDM_Jimutetuzuki();


        String querySql = $SELECT + qDM_Jimutetuzuki +
            $FROM + qDM_Jimutetuzuki.DM_Jimutetuzuki() +
            $WHERE + qDM_Jimutetuzuki.subSystemId.in(pSubSystemId) +
            $ORDER_BY(qDM_Jimutetuzuki.hyoujijyun.asc());

        return em.createJPQL(querySql).bind(qDM_Jimutetuzuki).getResultList();
    }

    public List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd(String[] pSubSystemId) {


        QDM_Jimutetuzuki qDM_Jimutetuzuki = new QDM_Jimutetuzuki();


        String querySql = $SELECT + qDM_Jimutetuzuki +
            $FROM + qDM_Jimutetuzuki.DM_Jimutetuzuki() +
            $WHERE + qDM_Jimutetuzuki.subSystemId.in(pSubSystemId) +
            $AND + $(qDM_Jimutetuzuki.syukouteijimutetuzukicd.isNull() +
                $OR + qDM_Jimutetuzuki.syukouteijimutetuzukicd.eq("")) +
                $ORDER_BY(qDM_Jimutetuzuki.hyoujijyun.asc());

        return em.createJPQL(querySql).bind(qDM_Jimutetuzuki).getResultList();
    }

    public List<DM_Jimutetuzuki> getJimutetuzukisBySubSystemIdJimutetuzukicds(String pSubSystemId,
        String[] pJimutetuzukicd) {


        QDM_Jimutetuzuki qDM_Jimutetuzuki = new QDM_Jimutetuzuki();


        String querySql = $SELECT + qDM_Jimutetuzuki +
            $FROM + qDM_Jimutetuzuki.DM_Jimutetuzuki() +
            $WHERE + qDM_Jimutetuzuki.subSystemId.eq(pSubSystemId) +
            $AND + "(" + qDM_Jimutetuzuki.jimutetuzukicd.in(pJimutetuzukicd) +
            $OR + qDM_Jimutetuzuki.syukouteijimutetuzukicd.in(pJimutetuzukicd) + ")" +
            $ORDER_BY(qDM_Jimutetuzuki.hyoujijyun.asc());

        return em.createJPQL(querySql).bind(qDM_Jimutetuzuki).getResultList();
    }

    public List<Object[]> getJimutetuzukiJimutetuzukiTaskSubSystemsByItems(
        String[] pJimutetuzukicd, String[] pWorkflowTskId) {


        QAS_SubSystem qAS_SubSystem = new QAS_SubSystem("q1");

        QDM_Jimutetuzuki qDM_Jimutetuzuki = new QDM_Jimutetuzuki("q2");

        QDM_JimutetuzukiTask qDM_JimutetuzukiTask = new QDM_JimutetuzukiTask("q3");


        String strSql = $SELECT +
            qDM_Jimutetuzuki + "," +
            qDM_JimutetuzukiTask + "," +
            qAS_SubSystem +
            $FROM + qAS_SubSystem.AS_SubSystem() + "," +
            qDM_Jimutetuzuki.DM_Jimutetuzuki() + "," +
            qDM_JimutetuzukiTask.DM_JimutetuzukiTask() +
            $WHERE + qDM_Jimutetuzuki.subSystemId.eq(qDM_JimutetuzukiTask.subSystemId) +
            $AND + qDM_Jimutetuzuki.jimutetuzukicd.eq(qDM_JimutetuzukiTask.jimutetuzukicd) +
            $AND + qAS_SubSystem.subSystemId.eq(qDM_Jimutetuzuki.subSystemId) +
            $AND + qDM_JimutetuzukiTask.jimutetuzukicd.in(pJimutetuzukicd) +
            $AND + qDM_JimutetuzukiTask.workflowTskId.in(pWorkflowTskId) +
            $ORDER_BY(qAS_SubSystem.sortNo.asc(),
                qDM_Jimutetuzuki.hyoujijyun.asc(),
                qDM_JimutetuzukiTask.hyoujijyun.asc());


        return em.createJPQL(strSql).bind(qAS_SubSystem,qDM_Jimutetuzuki,qDM_JimutetuzukiTask).getResultList();
    }

    public List<DM_Jimutetuzuki> getJimutetuzukisByJimutetuzukicd(String pJimutetuzukicd) {

        DM_Jimutetuzuki dM_Jimutetuzuki =  new DM_Jimutetuzuki();
        dM_Jimutetuzuki.setJimutetuzukicd(pJimutetuzukicd);
        return this.select(dM_Jimutetuzuki);
    }
}

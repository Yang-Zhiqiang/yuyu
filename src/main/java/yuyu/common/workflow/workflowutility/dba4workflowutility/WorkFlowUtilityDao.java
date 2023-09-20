package yuyu.common.workflow.workflowutility.dba4workflowutility;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.db.entity.DM_JimutetuzukiRireki;
import yuyu.def.db.entity.DT_SyoriKensuuHokanJimu;
import yuyu.def.db.entity.DT_SyoriKensuuHokanTask;
import yuyu.def.db.meta.QDM_JimutetuzukiRireki;
import yuyu.def.db.meta.QDT_SyoriKensuuHokanJimu;
import yuyu.def.db.meta.QDT_SyoriKensuuHokanTask;

/**
 * ワークフロー 共通処理 ワークフロー呼出Utility機能DAO
 */
public class WorkFlowUtilityDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<DM_JimutetuzukiRireki> getJimutetuzukiRirekisBySyoriYmdSubSystemIds(BizDate pKensuuHokanYmd,
        String[] pSubSystemId) {

        QDM_JimutetuzukiRireki qDM_JimutetuzukiRireki = new QDM_JimutetuzukiRireki("qDM_JimutetuzukiRireki");

        String strSql = $SELECT + qDM_JimutetuzukiRireki +
            $FROM(qDM_JimutetuzukiRireki) +
            $WHERE + qDM_JimutetuzukiRireki.kensuuHokanYmd.eq(pKensuuHokanYmd) +
            $AND + qDM_JimutetuzukiRireki.subSystemId.in(pSubSystemId) +
            $ORDER_BY(qDM_JimutetuzukiRireki.hyoujijyun.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qDM_JimutetuzukiRireki).getResultList();

    }

    public List<DM_JimutetuzukiRireki> getJimutetuzukiRirekisBySyoriYmdJimutetuzukiSubSystemIds(BizDate pKensuuHokanYmd,
        String pJimutetuzukicd, String[] pSubSystemId) {

        QDM_JimutetuzukiRireki qDM_JimutetuzukiRireki = new QDM_JimutetuzukiRireki("qDM_JimutetuzukiRireki");

        String strSql = $SELECT + qDM_JimutetuzukiRireki +
            $FROM(qDM_JimutetuzukiRireki) +
            $WHERE + qDM_JimutetuzukiRireki.kensuuHokanYmd.eq(pKensuuHokanYmd) +
            $AND + qDM_JimutetuzukiRireki.jimutetuzukicd.eq(pJimutetuzukicd) +
            $AND + qDM_JimutetuzukiRireki.subSystemId.in(pSubSystemId) +
            $ORDER_BY(qDM_JimutetuzukiRireki.hyoujijyun.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qDM_JimutetuzukiRireki).getResultList();

    }

    public List<DT_SyoriKensuuHokanJimu> getSyoriKensuuHokanJimuByKensuHokanbiJimutetuzukiAccountIds(
        BizDate pKensuuHokanYmd, String[] pJimutetuzukicd, String pAccountId) {

        QDT_SyoriKensuuHokanJimu qDT_SyoriKensuuHokanJimu = new QDT_SyoriKensuuHokanJimu("qDT_SyoriKensuuHokanJimu");

        String strSql = $SELECT + qDT_SyoriKensuuHokanJimu +
            $FROM(qDT_SyoriKensuuHokanJimu) +
            $WHERE + qDT_SyoriKensuuHokanJimu.kensuuHokanYmd.eq(pKensuuHokanYmd) +
            $AND + qDT_SyoriKensuuHokanJimu.jimutetuzukicd.in(pJimutetuzukicd);
        if (!BizUtil.isBlank(pAccountId)) {
            strSql = strSql + $AND + qDT_SyoriKensuuHokanJimu.accountId.eq(pAccountId);

        }
        strSql = strSql + $ORDER_BY(qDT_SyoriKensuuHokanJimu.jimutetuzukicd.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qDT_SyoriKensuuHokanJimu).getResultList();

    }

    public List<DT_SyoriKensuuHokanTask> getSyoriKensuuHokanTaskByKensuHokanbiJimutetuzukiTaskIdAccountIds(
        BizDate pKensuuHokanYmd, String pJimutetuzukicd, String[] pTskid, String pAccountId) {

        QDT_SyoriKensuuHokanTask qDT_SyoriKensuuHokanTask = new QDT_SyoriKensuuHokanTask("qDT_SyoriKensuuHokanTask");

        String strSql = $SELECT + qDT_SyoriKensuuHokanTask +
            $FROM(qDT_SyoriKensuuHokanTask) +
            $WHERE + qDT_SyoriKensuuHokanTask.kensuuHokanYmd.eq(pKensuuHokanYmd) +
            $AND + qDT_SyoriKensuuHokanTask.jimutetuzukicd.eq(pJimutetuzukicd) +
            $AND + qDT_SyoriKensuuHokanTask.tskid.in(pTskid);
        if (!BizUtil.isBlank(pAccountId)) {
            strSql = strSql + $AND + qDT_SyoriKensuuHokanTask.accountId.eq(pAccountId);

        }
        strSql = strSql + $ORDER_BY(qDT_SyoriKensuuHokanTask.jimutetuzukicd.asc(),
            qDT_SyoriKensuuHokanTask.tskid.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qDT_SyoriKensuuHokanTask).getResultList();

    }

    public List<DM_JimutetuzukiRireki> getJimutetuzukiRirekisBySyoriYmd(BizDate pKensuuHokanYmd) {

        QDM_JimutetuzukiRireki qDM_JimutetuzukiRireki = new QDM_JimutetuzukiRireki("qDM_JimutetuzukiRireki");

        String strSql = $SELECT + qDM_JimutetuzukiRireki +
            $FROM(qDM_JimutetuzukiRireki) +
            $WHERE + qDM_JimutetuzukiRireki.kensuuHokanYmd.eq(pKensuuHokanYmd);

        return exDBEntityManager.createJPQL(strSql).bind(qDM_JimutetuzukiRireki).getResultList();

    }

    public void delSyoriKensuuHokanJimuBySyoriYmd(BizDate pKensuuHokanYmd) {

        QDT_SyoriKensuuHokanJimu qDT_SyoriKensuuHokanJimu = new QDT_SyoriKensuuHokanJimu("qDT_SyoriKensuuHokanJimu");

        String strSql = $DELETE_FROM(qDT_SyoriKensuuHokanJimu) +
            $WHERE + qDT_SyoriKensuuHokanJimu.kensuuHokanYmd.eq(pKensuuHokanYmd);

        exDBEntityManager.createJPQL(strSql).bind(qDT_SyoriKensuuHokanJimu).executeUpdate();

    }

    public void delSyoriKensuuHokanTaskBySyoriYmd(BizDate pKensuuHokanYmd) {

        QDT_SyoriKensuuHokanTask qDT_SyoriKensuuHokanTask = new QDT_SyoriKensuuHokanTask("qDT_SyoriKensuuHokanTask");

        String strSql = $DELETE_FROM(qDT_SyoriKensuuHokanTask) +
            $WHERE + qDT_SyoriKensuuHokanTask.kensuuHokanYmd.eq(pKensuuHokanYmd);

        exDBEntityManager.createJPQL(strSql).bind(qDT_SyoriKensuuHokanTask).executeUpdate();

    }

    public List<DM_JimutetuzukiRireki> getJimutetuzukiRirekisByFromtoSyoriYmdSubSystemIds(
        BizDate pKensuuHokanYmdFrom, BizDate pKensuuHokanYmdTo, String[] pSubSystemId) {

        QDM_JimutetuzukiRireki qDM_JimutetuzukiRireki = new QDM_JimutetuzukiRireki("qDM_JimutetuzukiRireki");

        String strSql = $SELECT + qDM_JimutetuzukiRireki +
            $FROM(qDM_JimutetuzukiRireki) +
            $WHERE + qDM_JimutetuzukiRireki.kensuuHokanYmd.ge(pKensuuHokanYmdFrom) +
            $AND + qDM_JimutetuzukiRireki.kensuuHokanYmd.le(pKensuuHokanYmdTo) +
            $AND + qDM_JimutetuzukiRireki.subSystemId.in(pSubSystemId) +
            $ORDER_BY(qDM_JimutetuzukiRireki.kensuuHokanYmd.asc(),
                qDM_JimutetuzukiRireki.hyoujijyun.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qDM_JimutetuzukiRireki).getResultList();
    }

    public List<DT_SyoriKensuuHokanJimu> getSyoriKensuuHokanJimuByKensuHokanbiFromtoJimutetuzukiAccountIds(
        BizDate pKensuuHokanYmdFrom, BizDate pKensuuHokanYmdTo, String[] pJimutetuzukicd, String pAccountId) {

        QDT_SyoriKensuuHokanJimu qDT_SyoriKensuuHokanJimu = new QDT_SyoriKensuuHokanJimu("qDT_SyoriKensuuHokanJimu");

        String strSql = $SELECT + qDT_SyoriKensuuHokanJimu +
            $FROM(qDT_SyoriKensuuHokanJimu) +
            $WHERE + qDT_SyoriKensuuHokanJimu.kensuuHokanYmd.ge(pKensuuHokanYmdFrom) +
            $AND + qDT_SyoriKensuuHokanJimu.kensuuHokanYmd.le(pKensuuHokanYmdTo) +
            $AND + qDT_SyoriKensuuHokanJimu.jimutetuzukicd.in(pJimutetuzukicd);
        if (!BizUtil.isBlank(pAccountId)) {
            strSql = strSql + $AND + qDT_SyoriKensuuHokanJimu.accountId.eq(pAccountId);

        }
        strSql = strSql + $ORDER_BY(qDT_SyoriKensuuHokanJimu.kensuuHokanYmd.asc(),
            qDT_SyoriKensuuHokanJimu.jimutetuzukicd.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qDT_SyoriKensuuHokanJimu).getResultList();
    }

    public List<DM_JimutetuzukiRireki> getJimutetuzukiRirekisBySyoriYmdFromtoJimutetuzukiSubSystemIds(
        BizDate pKensuuHokanYmdFrom, BizDate pKensuuHokanYmdTo, String pJimutetuzukicd, String[] pSubSystemId) {

        QDM_JimutetuzukiRireki qDM_JimutetuzukiRireki = new QDM_JimutetuzukiRireki("qDM_JimutetuzukiRireki");

        String strSql = $SELECT + qDM_JimutetuzukiRireki +
            $FROM(qDM_JimutetuzukiRireki) +
            $WHERE + qDM_JimutetuzukiRireki.kensuuHokanYmd.ge(pKensuuHokanYmdFrom) +
            $AND + qDM_JimutetuzukiRireki.kensuuHokanYmd.le(pKensuuHokanYmdTo) +
            $AND + qDM_JimutetuzukiRireki.jimutetuzukicd.eq(pJimutetuzukicd) +
            $AND + qDM_JimutetuzukiRireki.subSystemId.in(pSubSystemId) +
            $ORDER_BY(qDM_JimutetuzukiRireki.kensuuHokanYmd.asc(),
                qDM_JimutetuzukiRireki.hyoujijyun.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qDM_JimutetuzukiRireki).getResultList();
    }

    public List<DT_SyoriKensuuHokanTask> getSyoriKensuuHokanTaskByKensuHokanbiFromtoJimutetuzukiTaskIdAccountIds(
        BizDate pKensuuHokanYmdFrom, BizDate pKensuuHokanYmdTo, String pJimutetuzukicd, String[] pTskid,
        String pAccountId) {

        QDT_SyoriKensuuHokanTask qDT_SyoriKensuuHokanTask = new QDT_SyoriKensuuHokanTask("qDT_SyoriKensuuHokanTask");

        String strSql = $SELECT + qDT_SyoriKensuuHokanTask +
            $FROM(qDT_SyoriKensuuHokanTask) +
            $WHERE + qDT_SyoriKensuuHokanTask.kensuuHokanYmd.ge(pKensuuHokanYmdFrom) +
            $AND + qDT_SyoriKensuuHokanTask.kensuuHokanYmd.le(pKensuuHokanYmdTo) +
            $AND + qDT_SyoriKensuuHokanTask.jimutetuzukicd.eq(pJimutetuzukicd) +
            $AND + qDT_SyoriKensuuHokanTask.tskid.in(pTskid);
        if (!BizUtil.isBlank(pAccountId)) {
            strSql = strSql + $AND + qDT_SyoriKensuuHokanTask.accountId.eq(pAccountId);

        }
        strSql = strSql + $ORDER_BY(qDT_SyoriKensuuHokanTask.kensuuHokanYmd.asc(),
            qDT_SyoriKensuuHokanTask.jimutetuzukicd.asc(),
            qDT_SyoriKensuuHokanTask.tskid.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qDT_SyoriKensuuHokanTask).getResultList();
    }
}

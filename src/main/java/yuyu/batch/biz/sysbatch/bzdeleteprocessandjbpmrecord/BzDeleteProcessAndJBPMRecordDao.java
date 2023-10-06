package yuyu.batch.biz.sysbatch.bzdeleteprocessandjbpmrecord;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.meta.QWT_KouteiRireki;
import yuyu.def.db.meta.QWT_KouteiSummary;

/**
 * 工程履歴・JBPMデータ削除の機能DAOクラスです。<br />
 */
public class BzDeleteProcessAndJBPMRecordDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    List<DelKouteiInfosByKouteiKanryouYmdBean> getDelKouteiInfosByKouteiKanryouYmd(BizDate pKouteiKanryouYmd) {

        QWT_KouteiSummary qWT_KouteiSummary = new QWT_KouteiSummary("qWT_KouteiSummary");

        QWT_KouteiRireki qWT_KouteiRireki = new QWT_KouteiRireki("qWT_KouteiRireki");

        String[] pSyoriStatus = {"90", "99"};

        String sql = $SELECT_DISTINCT + $NEW(DelKouteiInfosByKouteiKanryouYmdBean.class,
                qWT_KouteiSummary.gyoumuKey,
                qWT_KouteiSummary.flowId,
                qWT_KouteiSummary.kouteiKanryouYmd) +
                $FROM (qWT_KouteiSummary,
                        qWT_KouteiRireki) +
                        $WHERE + qWT_KouteiSummary.gyoumuKey.eq(qWT_KouteiRireki.gyoumuKey) +
                        $AND + qWT_KouteiSummary.syoriStatus.in(pSyoriStatus) +
                        $AND + qWT_KouteiSummary.kouteiKanryouYmd.lt(pKouteiKanryouYmd.toString()) +
                        $AND + qWT_KouteiRireki.rirekiKbn.eq(C_RirekiKbn.SYSTEM) +
                        $ORDER_BY (qWT_KouteiSummary.kouteiKanryouYmd.asc());

        return exDBEntityManager.createJPQL(sql, DelKouteiInfosByKouteiKanryouYmdBean.class).bind(qWT_KouteiSummary, qWT_KouteiRireki).getResultList();

    }

    void lockKouteiRireki() {

        String sql = "lock table WT_KouteiRireki_Z in exclusive mode";

        exDBEntityManager.createNativeSQL(sql).executeUpdate();

    }

    void lockJBPMProcessInstance() {

        String sql = "lock table JBPM_PROCESSINSTANCE in exclusive mode";

        exDBEntityManager.createNativeSQL(sql).executeUpdate();

    }

    void lockJBPMModuleInstance() {

        String sql = "lock table JBPM_MODULEINSTANCE in exclusive mode";

        exDBEntityManager.createNativeSQL(sql).executeUpdate();

    }

    void lockJBPMVariableInstance() {

        String sql = "lock table JBPM_VARIABLEINSTANCE in exclusive mode";

        exDBEntityManager.createNativeSQL(sql).executeUpdate();

    }

    void lockJBPMToken() {

        String sql = "lock table JBPM_TOKEN in exclusive mode";

        exDBEntityManager.createNativeSQL(sql).executeUpdate();

    }

    void lockJBPMTokenVariableMap() {

        String sql = "lock table JBPM_TOKENVARIABLEMAP in exclusive mode";

        exDBEntityManager.createNativeSQL(sql).executeUpdate();

    }

    void lockJBPMTaskInstance() {

        String sql = "lock table JBPM_TASKINSTANCE in exclusive mode";

        exDBEntityManager.createNativeSQL(sql).executeUpdate();

    }

}

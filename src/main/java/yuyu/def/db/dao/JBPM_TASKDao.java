package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JBPM_TASK;
import yuyu.def.db.meta.QJBPM_TASK;

/**
 * ＪＢＰＭタスク(JBPM_TASK) テーブルアクセス用の DAO クラスです。
 */
public class JBPM_TASKDao extends AbstractDao<JBPM_TASK> {

    protected JBPM_TASKDao() {
        super(JBPM_TASK.class);
    }

    public List<JBPM_TASK> getAllTask() {

        return selectAll();
    }

    public List<String> getNodesByProcDefId(Long procDefId) {
        QJBPM_TASK qJBPM_TASK = new QJBPM_TASK();

        return em.createJPQL(
            $SELECT + $DISTINCT + qJBPM_TASK.name_ +
            $FROM + qJBPM_TASK.JBPM_TASK() +
            $WHERE + qJBPM_TASK.processDefinition_.eq(procDefId)
            ).bind(qJBPM_TASK).getResultList();
    }
}
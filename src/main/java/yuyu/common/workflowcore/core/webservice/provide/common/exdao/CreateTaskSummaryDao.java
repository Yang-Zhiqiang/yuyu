package yuyu.common.workflowcore.core.webservice.provide.common.exdao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;

import org.apache.commons.lang.ArrayUtils;

import yuyu.def.db.entity.JBPM_TASKINSTANCE;
import yuyu.def.db.meta.QJBPM_PROCESSDEFINITION;
import yuyu.def.db.meta.QJBPM_PROCESSINSTANCE;
import yuyu.def.db.meta.QJBPM_TASKINSTANCE;

/**
 * タスクサマリ作成API用の DAO クラスです。<br />
 */
public class CreateTaskSummaryDao extends AbstractDao<JBPM_TASKINSTANCE> {

    public CreateTaskSummaryDao() {
        super(JBPM_TASKINSTANCE.class);
    }

    public ExDBResults<CreateTaskSummaryBean> getTaskInstances(String[] pFlowids){

        QJBPM_PROCESSDEFINITION qProcDef = new QJBPM_PROCESSDEFINITION("procdef");
        QJBPM_PROCESSINSTANCE qProcIns = new QJBPM_PROCESSINSTANCE("procins");
        QJBPM_TASKINSTANCE qTaskIns = new QJBPM_TASKINSTANCE("taskIns");


        StringBuffer mainQuery = new StringBuffer();

        mainQuery.append(
            $SELECT  + $NEW(
                CreateTaskSummaryBean.class,
                qTaskIns.name_,
                qTaskIns.description_,
                qTaskIns.create_,
                qTaskIns.start_,
                qTaskIns.end_,
                qTaskIns.token_,
                qTaskIns.actorId_,
                qProcDef.name_,
                qProcDef.description_
                ));

        mainQuery.append(
            $FROM +
            qTaskIns.JBPM_TASKINSTANCE() + "," +
            qProcIns.JBPM_PROCESSINSTANCE() + "," +
            qProcDef.JBPM_PROCESSDEFINITION()
            );

        mainQuery.append(
            $WHERE +
            qTaskIns.isSignalling_.eq("1") +
            $AND +
            qTaskIns.isOpen_.eq("1") +
            $AND +
            qTaskIns.procInst_.eq(qProcIns.id_) +
            $AND +
            qProcIns.processDefinition_.eq(qProcDef.id_));


        if (null != pFlowids && !ArrayUtils.isEmpty(pFlowids)) {
            mainQuery.append(
                $AND +
                qProcDef.name_.in(pFlowids));
        }

        return em.createJPQL(
            mainQuery.toString(), CreateTaskSummaryBean.class
            ).bind(
                qTaskIns,
                qProcIns,
                qProcDef
                ).getResults();
    }
}
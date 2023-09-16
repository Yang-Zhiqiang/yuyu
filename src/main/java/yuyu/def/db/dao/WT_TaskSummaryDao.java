package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;

import org.apache.commons.lang.StringUtils;

import yuyu.def.db.entity.WT_TaskSummary;
import yuyu.def.db.id.PKWT_TaskSummary;
import yuyu.def.db.meta.QJBPM_PROCESSDEFINITION;
import yuyu.def.db.meta.QJBPM_TASK;
import yuyu.def.db.meta.QJBPM_TASKINSTANCE;
import yuyu.def.db.meta.QWT_TaskSummary;

/**
 * 業務キーテーブル(WT_TASKSUMMARY) テーブルアクセス用の DAO クラスです。<br />
 *
 */
public class WT_TaskSummaryDao extends AbstractDao<WT_TaskSummary> {

    public WT_TaskSummaryDao() {

        super(WT_TaskSummary.class);
    }

    public WT_TaskSummary getTaskSummary(String pFlowId, String pTaskId, String pTokenID, String pTaskcreatetimeto) {
        return selectPk(new PKWT_TaskSummary(pFlowId, pTaskId, pTokenID, pTaskcreatetimeto));
    }

    public List<WT_TaskSummary> getAllTaskSummary() {

        return selectAll();
    }

    public List<Object[]> getTaskKensuuByCond(String pAccountid, String pWariateumu, String pTaskendumu,
        String pFlowid,
        String pTaskid,
        String pTaskcreatetimefrom, String pTaskcreatetimeto, String pTaskstarttimefrom, String pTaskstarttimeto,
        String pTaskendtimefrom, String pTaskendtimeto) {

        QJBPM_TASKINSTANCE qJBPM_TASKINSTANCE = new QJBPM_TASKINSTANCE("taskins");
        QJBPM_TASK qJBPM_TASK = new QJBPM_TASK("task");
        QJBPM_PROCESSDEFINITION qJBPM_PROCESSDEFINITION = new QJBPM_PROCESSDEFINITION("def");


        StringBuffer mainQuery = new StringBuffer();
        mainQuery.append($SELECT + qJBPM_PROCESSDEFINITION.name_ + "," + qJBPM_PROCESSDEFINITION.description_ + ","
            + qJBPM_TASKINSTANCE.name_ + "," + qJBPM_TASKINSTANCE.description_ + ","
            + $COUNT(qJBPM_TASKINSTANCE.name_) + $AS + "TASK_COUNT" + $FROM);

        mainQuery.append(qJBPM_TASKINSTANCE.JBPM_TASKINSTANCE() + "," + qJBPM_TASK.JBPM_TASK() + ","
            + qJBPM_PROCESSDEFINITION.JBPM_PROCESSDEFINITION());

        mainQuery.append($WHERE + qJBPM_TASKINSTANCE.task_.eq(qJBPM_TASK.id_) + $AND
            + qJBPM_PROCESSDEFINITION.id_.eq(qJBPM_TASK.processDefinition_));


        mainQuery.append(getTaskKensuuWhereQuery(qJBPM_TASKINSTANCE, qJBPM_PROCESSDEFINITION, pAccountid, pWariateumu,
            pTaskendumu,
            pFlowid, pTaskid,
            pTaskcreatetimefrom, pTaskcreatetimeto, pTaskstarttimefrom, pTaskstarttimeto, pTaskendtimefrom,
            pTaskendtimeto));


        mainQuery.append($GROUP_BY + qJBPM_PROCESSDEFINITION.name_ + "," + qJBPM_PROCESSDEFINITION.description_ + ","
            + qJBPM_TASKINSTANCE.name_ + "," + qJBPM_TASKINSTANCE.description_);

        return em.createJPQL(mainQuery.toString()).bind(qJBPM_TASKINSTANCE, qJBPM_TASK, qJBPM_PROCESSDEFINITION)
            .getResultList();
    }

    public List<Object[]> getUserBetsuTaskKensuuByCond(String pAccountid, String pWariateumu, String pTaskendumu,
        String pFlowid,
        String pTaskid,
        String pTaskcreatetimefrom, String pTaskcreatetimeto, String pTaskstarttimefrom, String pTaskstarttimeto,
        String pTaskendtimefrom, String pTaskendtimeto) {

        QJBPM_TASKINSTANCE qJBPM_TASKINSTANCE = new QJBPM_TASKINSTANCE("taskins");
        QJBPM_TASK qJBPM_TASK = new QJBPM_TASK("task");
        QJBPM_PROCESSDEFINITION qJBPM_PROCESSDEFINITION = new QJBPM_PROCESSDEFINITION("def");


        StringBuffer mainQuery = new StringBuffer();
        mainQuery.append($SELECT + qJBPM_PROCESSDEFINITION.name_ + "," + qJBPM_PROCESSDEFINITION.description_ + ","
            + qJBPM_TASKINSTANCE.name_ + "," + qJBPM_TASKINSTANCE.description_ + "," + qJBPM_TASKINSTANCE.actorId_
            + ","
            + $COUNT(qJBPM_TASKINSTANCE.name_) + $AS + "TASK_COUNT" + $FROM);

        mainQuery.append(qJBPM_TASKINSTANCE.JBPM_TASKINSTANCE() + "," + qJBPM_TASK.JBPM_TASK() + ","
            + qJBPM_PROCESSDEFINITION.JBPM_PROCESSDEFINITION());

        mainQuery.append($WHERE + qJBPM_TASKINSTANCE.task_.eq(qJBPM_TASK.id_) + $AND
            + qJBPM_PROCESSDEFINITION.id_.eq(qJBPM_TASK.processDefinition_));


        mainQuery.append(getTaskKensuuWhereQuery(qJBPM_TASKINSTANCE, qJBPM_PROCESSDEFINITION, pAccountid, pWariateumu,
            pTaskendumu,
            pFlowid, pTaskid,
            pTaskcreatetimefrom, pTaskcreatetimeto, pTaskstarttimefrom, pTaskstarttimeto, pTaskendtimefrom,
            pTaskendtimeto));


        mainQuery.append($GROUP_BY + qJBPM_PROCESSDEFINITION.name_ + "," + qJBPM_PROCESSDEFINITION.description_ + ","
            + qJBPM_TASKINSTANCE.name_ + "," + qJBPM_TASKINSTANCE.description_ + "," + qJBPM_TASKINSTANCE.actorId_);

        return em.createJPQL(mainQuery.toString()).bind(qJBPM_TASKINSTANCE, qJBPM_TASK, qJBPM_PROCESSDEFINITION)
            .getResultList();
    }

    private String getTaskKensuuWhereQuery(QJBPM_TASKINSTANCE qJBPM_TASKINSTANCE,
        QJBPM_PROCESSDEFINITION qJBPM_PROCESSDEFINITION, String pAccountid, String pWariateumu, String pTaskendumu, String pFlowid,
        String pTaskid,
        String pTaskcreatetimefrom, String pTaskcreatetimeto, String pTaskstarttimefrom, String pTaskstarttimeto,
        String pTaskendtimefrom, String pTaskendtimeto) {

        StringBuffer sbSql = new StringBuffer();
        sbSql.append($AND + "1 = 1");

        if ("0".equals(pWariateumu)) {
            sbSql.append($AND + qJBPM_TASKINSTANCE.actorId_.isNotNull());
        } else if ("1".equals(pWariateumu)) {
            sbSql.append($AND + qJBPM_TASKINSTANCE.actorId_.isNull());
        }

        if (StringUtils.isNotEmpty(pAccountid)) {
            sbSql.append($AND + " (" + qJBPM_TASKINSTANCE.actorId_.eq(pAccountid) + " )");
        }

        if ("1".equals(pTaskendumu)) {

            sbSql.append($AND + qJBPM_TASKINSTANCE.isSignalling_.eq("1"));
        } else if ("0".equals(pTaskendumu)) {

            sbSql.append($AND + qJBPM_TASKINSTANCE.isSignalling_.eq("0"));
        }

        if (StringUtils.isNotEmpty(pFlowid)) {

            sbSql.append($AND + qJBPM_PROCESSDEFINITION.name_.eq(pFlowid));
        }

        if (StringUtils.isNotEmpty(pTaskid)) {

            sbSql.append($AND + qJBPM_TASKINSTANCE.name_.eq(pTaskid));
        }

        if (StringUtils.isNotEmpty(pTaskcreatetimefrom)) {

            sbSql.append($AND + qJBPM_TASKINSTANCE.create_.ge(pTaskcreatetimefrom));
        }

        if (StringUtils.isNotEmpty(pTaskcreatetimeto)) {

            sbSql.append($AND + qJBPM_TASKINSTANCE.create_.le(pTaskcreatetimeto));
        }

        if (StringUtils.isNotEmpty(pTaskstarttimefrom)) {

            sbSql.append($AND + qJBPM_TASKINSTANCE.start_.ge(pTaskstarttimefrom));
        }

        if (StringUtils.isNotEmpty(pTaskstarttimeto)) {

            sbSql.append($AND + qJBPM_TASKINSTANCE.start_.le(pTaskstarttimeto));
        }

        if (StringUtils.isNotEmpty(pTaskendtimefrom)) {

            sbSql.append($AND + qJBPM_TASKINSTANCE.end_.ge(pTaskendtimefrom));
        }

        if (StringUtils.isNotEmpty(pTaskendtimeto)) {

            sbSql.append($AND + qJBPM_TASKINSTANCE.end_.le(pTaskendtimeto));
        }

        return sbSql.toString();
    }


    public List<WT_TaskSummary> getTaskSummaryByCond(String pAccountid, String pWariateumu, String pTaskendumu,
        String pFlowid,
        String pTaskid,
        String pTaskcreatetimefrom, String pTaskcreatetimeto, String pTaskstarttimefrom, String pTaskstarttimeto,
        String pTaskendtimefrom, String pTaskendtimeto) {

        QWT_TaskSummary qTaskSummary = new QWT_TaskSummary("taskSummary");


        StringBuffer mainQuery = new StringBuffer();
        mainQuery.append($SELECT + qTaskSummary);


        mainQuery.append(getWhereQuery(qTaskSummary, pAccountid, pWariateumu, pTaskendumu, pFlowid, pTaskid,
            pTaskcreatetimefrom, pTaskcreatetimeto, pTaskstarttimefrom, pTaskstarttimeto, pTaskendtimefrom,
            pTaskendtimeto));

        return em.createJPQL(mainQuery.toString()).bind(qTaskSummary).getResultList();
    }

    private String getWhereQuery(QWT_TaskSummary qTaskSummary, String pAccountid, String pWariateumu,
        String pTaskendumu, String pFlowid,
        String pTaskid,
        String pTaskcreatetimefrom, String pTaskcreatetimeto, String pTaskstarttimefrom, String pTaskstarttimeto,
        String pTaskendtimefrom, String pTaskendtimeto) {

        StringBuffer sbSql = new StringBuffer();
        sbSql.append($FROM + qTaskSummary.WT_TaskSummary());
        sbSql.append($WHERE + "1 = 1");

        if ("0".equals(pWariateumu)) {
            sbSql.append($AND + qTaskSummary.actorId.isNotNull());
        } else if ("1".equals(pWariateumu)) {
            sbSql.append($AND + qTaskSummary.actorId.isNull());
        }

        if (StringUtils.isNotEmpty(pAccountid)) {
            sbSql.append($AND + " (" + qTaskSummary.actorId.eq(pAccountid) + " )");
        }

        if ("1".equals(pTaskendumu)) {

            sbSql.append($AND + qTaskSummary.taskEndTime.isNull());
        } else if ("0".equals(pTaskendumu)) {

            sbSql.append($AND + qTaskSummary.taskEndTime.isNotNull());
        }

        if (StringUtils.isNotEmpty(pFlowid)) {

            sbSql.append($AND + qTaskSummary.flowId.eq(pFlowid));
        }

        if (StringUtils.isNotEmpty(pTaskid)) {

            sbSql.append($AND + qTaskSummary.iwfTskId.eq(pTaskid));
        }

        if (StringUtils.isNotEmpty(pTaskcreatetimefrom)) {

            sbSql.append($AND + qTaskSummary.taskCreateTime.ge(pTaskcreatetimefrom));
        }

        if (StringUtils.isNotEmpty(pTaskcreatetimeto)) {

            sbSql.append($AND + qTaskSummary.taskCreateTime.le(pTaskcreatetimeto));
        }

        if (StringUtils.isNotEmpty(pTaskstarttimefrom)) {

            sbSql.append($AND + qTaskSummary.taskStartTime.ge(pTaskstarttimefrom));
        }

        if (StringUtils.isNotEmpty(pTaskstarttimeto)) {

            sbSql.append($AND + qTaskSummary.taskStartTime.le(pTaskstarttimeto));
        }

        if (StringUtils.isNotEmpty(pTaskendtimefrom)) {

            sbSql.append($AND + qTaskSummary.taskEndTime.ge(pTaskendtimefrom));
        }

        if (StringUtils.isNotEmpty(pTaskendtimeto)) {

            sbSql.append($AND + qTaskSummary.taskEndTime.le(pTaskendtimeto));
        }

        return sbSql.toString();
    }

    public int deleteAllTaskSummary() {

        QWT_TaskSummary taskSummary = new QWT_TaskSummary();


        String query = $DELETE_FROM + taskSummary.WT_TaskSummary();


        return execute(query, taskSummary);

    }

    public int deleteTaskSummaryWithFlowIds(String[] flowIds) {

        QWT_TaskSummary taskSummary = new QWT_TaskSummary();


        String query = $DELETE_FROM + taskSummary.WT_TaskSummary() + $WHERE + taskSummary.flowId.in(flowIds);


        return execute(query, taskSummary);
    }
}
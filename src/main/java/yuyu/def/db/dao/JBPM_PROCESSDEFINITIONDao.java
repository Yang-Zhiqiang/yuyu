package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JBPM_PROCESSDEFINITION;
import yuyu.def.db.meta.QJBPM_PROCESSDEFINITION;
import yuyu.def.db.meta.QJBPM_PROCESSINSTANCE;
import yuyu.def.db.meta.QJBPM_TASK;

/**
 * ＪＢＰＭプロセス定義(JBPM_PROCESSDEFINITION) テーブルアクセス用の DAO クラスです。
 */
public class JBPM_PROCESSDEFINITIONDao extends AbstractDao<JBPM_PROCESSDEFINITION> {

    protected JBPM_PROCESSDEFINITIONDao() {
        super(JBPM_PROCESSDEFINITION.class);
    }

    public List<JBPM_PROCESSDEFINITION> getAllProcessDef() {

        return selectAll();
    }

    @SuppressWarnings("deprecation")
    public List<JBPM_PROCESSDEFINITION> getProcessDefsByNames(String[] flowIds){

        QJBPM_PROCESSDEFINITION qProcessdefinition = new QJBPM_PROCESSDEFINITION();

        return em.createJPQL(
            $SELECT + qProcessdefinition +
            $FROM + qProcessdefinition.JBPM_PROCESSDEFINITION() +
            $WHERE + qProcessdefinition.name_ + $IN + createSQL_IN(flowIds)
            ).bind(qProcessdefinition).getResultList();
    }

    public JBPM_PROCESSDEFINITION getProcessDefByProcIns(Long procInsId) {

        QJBPM_PROCESSDEFINITION qProcessdefinition = new QJBPM_PROCESSDEFINITION();
        QJBPM_PROCESSINSTANCE qProcessinstance = new QJBPM_PROCESSINSTANCE();

        StringBuffer sqlSb = new StringBuffer();
        sqlSb.append($SELECT + qProcessdefinition);
        sqlSb.append($FROM + qProcessdefinition.JBPM_PROCESSDEFINITION() + ","
            + qProcessinstance.JBPM_PROCESSINSTANCE());
        sqlSb.append($WHERE + qProcessdefinition.id_.eq(qProcessinstance.processDefinition_));
        sqlSb.append($AND + qProcessinstance.id_.eq(procInsId));

        return em.createJPQL(sqlSb.toString()).bind(qProcessdefinition, qProcessinstance).getSingleResult();
    }

    public List<Object[]> getLatestProcessDefs() {

        QJBPM_PROCESSDEFINITION qProcessdefinition = new QJBPM_PROCESSDEFINITION();

        String query = $SELECT + qProcessdefinition.name_ + "," + $MAX(qProcessdefinition.version_) +
            $FROM + qProcessdefinition.JBPM_PROCESSDEFINITION() + $GROUP_BY + qProcessdefinition.name_;

        return em.createJPQL(query).bind(qProcessdefinition).getResultList();
    }

    public List<Object> getFlowInfo() {

        QJBPM_PROCESSDEFINITION qProcessdefinition = new QJBPM_PROCESSDEFINITION();
        QJBPM_TASK qTask = new QJBPM_TASK();

        String query = $SELECT_DISTINCT + qTask.id_ + "," + qProcessdefinition.name_ + ","
            + qProcessdefinition.description_ +
            $FROM + qProcessdefinition.JBPM_PROCESSDEFINITION() + "," + qTask.JBPM_TASK() +
            $WHERE + qProcessdefinition.id_.eq(qTask.processDefinition_);

        return em.createJPQL(query).bind(qProcessdefinition, qTask).getResultList();
    }

    private String createSQL_IN(Object ary) {


        StringBuilder sb = new StringBuilder("(");

        String[] strAry;
        Integer[] intAry;

        if (ary instanceof Integer[]) {
            intAry = (Integer[]) ary;
            for (int i = 0; i < intAry.length; i++) {
                sb.append(intAry[i]);
                if (i != intAry.length - 1) {
                    sb.append(",");
                }

            }
        } else {
            strAry = (String[]) ary;
            for (int i = 0; i < strAry.length; i++) {
                sb.append("'" + strAry[i] + "'");
                if (i != strAry.length - 1) {
                    sb.append(",");
                }

            }
        }
        sb.append(")");
        return sb.toString();
    }
}
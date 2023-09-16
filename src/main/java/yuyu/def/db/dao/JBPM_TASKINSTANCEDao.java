package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;

import org.apache.commons.lang.StringUtils;

import yuyu.common.workflowcore.core.webservice.common.WSCommonIOKey;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.def.db.entity.JBPM_TASKINSTANCE;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.db.meta.QJBPM_NODE;
import yuyu.def.db.meta.QJBPM_TASKINSTANCE;
import yuyu.def.db.meta.QJBPM_TOKEN;
import yuyu.def.db.meta.QWT_GyoumuKey;
import yuyu.def.db.meta.QWT_KouteiSummary;

/**
 * ＪＢＰＭタスクインスタンス(JBPM_TASKINSTANCE) テーブルアクセス用の DAO クラスです。
 */
public class JBPM_TASKINSTANCEDao extends AbstractDao<JBPM_TASKINSTANCE> {

    protected JBPM_TASKINSTANCEDao() {
        super(JBPM_TASKINSTANCE.class);
    }

    public List<JBPM_TASKINSTANCE> getAllTaskInstance() {

        return selectAll();
    }

    public List<JBPM_TASKINSTANCE> getTaskInstances() {
        QJBPM_TASKINSTANCE qJBPM_TASKINSTANCE = new QJBPM_TASKINSTANCE("taskIns");

        return em.createJPQL(
            $SELECT + qJBPM_TASKINSTANCE +
            $FROM + qJBPM_TASKINSTANCE.JBPM_TASKINSTANCE() +
            $WHERE + qJBPM_TASKINSTANCE.isSignalling_.eq("1")
            ).bind(qJBPM_TASKINSTANCE).getResultList();
    }

    public JBPM_TASKINSTANCE getActiveTaskInstanceWithTokenId(Long pTokenId) {

        JBPM_TASKINSTANCE taskIns = new JBPM_TASKINSTANCE();
        taskIns.setIsSuspended_("0");
        taskIns.setIsOpen_("1");
        taskIns.setToken_(pTokenId);
        return selectOne(taskIns);
    }

    public List<Object[]> getTaskNodeInfo() {

        QJBPM_TOKEN qJBPM_TOKEN = new QJBPM_TOKEN();
        QJBPM_NODE qJBPM_NODE = new QJBPM_NODE();
        QJBPM_TASKINSTANCE qJBPM_TASKINSTANCE = new QJBPM_TASKINSTANCE();

        String query = $SELECT_DISTINCT + qJBPM_TOKEN.processInstance_ + "," + qJBPM_NODE.name_
            + $FROM + qJBPM_TOKEN.JBPM_TOKEN() + "," + qJBPM_NODE.JBPM_NODE() + ","
            + qJBPM_TASKINSTANCE.JBPM_TASKINSTANCE()
            + $WHERE + qJBPM_TOKEN.node_.eq(qJBPM_NODE.id_) + $AND
            + qJBPM_TOKEN.processInstance_.eq(qJBPM_TASKINSTANCE.procInst_)
            + $AND + qJBPM_TOKEN.id_.eq(qJBPM_TASKINSTANCE.token_)
            + $AND + qJBPM_TASKINSTANCE.isSuspended_.eq("0")
            + $AND + qJBPM_TASKINSTANCE.isOpen_.eq("1");


        return em.createJPQL(query).bind(qJBPM_TOKEN, qJBPM_NODE, qJBPM_TASKINSTANCE).getResultList();
    }

    @SuppressWarnings("deprecation")
    public List<JBPM_TASKINSTANCE> getExecutableTasksByCond(String[] pSyoriStatus, String[] pFlowIds,
        String pKouteiKaisiYmdFrom, String pKouteiKaisiYmdTo,
        String pKouteiKanryouYmdFrom, String pKouteiKanryouYmdTo, Map<String, WSExtParam> pExtParam) {

        QJBPM_TASKINSTANCE qJBPM_TASKINSTANCE = new QJBPM_TASKINSTANCE("taskins");
        QWT_KouteiSummary qWT_KouteiSummary = new QWT_KouteiSummary("summary");
        QWT_GyoumuKey qWT_GyoumuKey = new QWT_GyoumuKey("gyoumukey");


        StringBuffer mainQuery = new StringBuffer();
        mainQuery.append($SELECT + qJBPM_TASKINSTANCE + $FROM + qJBPM_TASKINSTANCE.JBPM_TASKINSTANCE() + $WHERE +
            qJBPM_TASKINSTANCE.isSuspended_.eq("0") + $AND + qJBPM_TASKINSTANCE.isOpen_.eq("1") + $AND
            + qJBPM_TASKINSTANCE.token_ + $IN);

        mainQuery.append("(");


        mainQuery.append(getWhereQuery(qWT_KouteiSummary, qWT_GyoumuKey, pSyoriStatus, pFlowIds, pKouteiKaisiYmdFrom,
            pKouteiKaisiYmdTo, pKouteiKanryouYmdFrom, pKouteiKanryouYmdTo, pExtParam));

        mainQuery.append(")");

        return em.createJPQL(mainQuery.toString()).bind(qJBPM_TASKINSTANCE, qWT_KouteiSummary, qWT_GyoumuKey)
            .getResultList();
    }

    private String getWhereQuery(QWT_KouteiSummary qWT_KouteiSummary, QWT_GyoumuKey qWT_GyoumuKey,
        String[] pSyoriStatus, String[] pFlowIds,
        String pKouteiKaisiYmdFrom, String pKouteiKaisiYmdTo,
        String pKouteiKanryouYmdFrom, String pKouteiKanryouYmdTo, Map<String, WSExtParam> pExtParam) {

        StringBuffer sbSql = new StringBuffer();
        sbSql.append($SELECT + qWT_GyoumuKey.tokenId);
        sbSql.append($FROM + qWT_KouteiSummary.WT_KouteiSummary() + "," + qWT_GyoumuKey.WT_GyoumuKey());
        sbSql.append($WHERE + qWT_KouteiSummary.gyoumuKey.eq(qWT_GyoumuKey.gyoumuKey) + $AND
            + qWT_KouteiSummary.flowId.eq(qWT_GyoumuKey.flowId));

        if (null != pSyoriStatus && pSyoriStatus.length != 0) {

            sbSql.append($AND + qWT_KouteiSummary.syoriStatus.in(pSyoriStatus));
        }

        if (null != pFlowIds && pFlowIds.length != 0) {

            sbSql.append($AND + qWT_GyoumuKey.flowId.in(pFlowIds));
        }

        if (StringUtils.isNotEmpty(pKouteiKaisiYmdFrom) || StringUtils.isNotEmpty(pKouteiKaisiYmdTo)) {

            sbSql.append($AND + qWT_KouteiSummary.iwfKouteiKaisiYmd.ge(getYmdFrom(pKouteiKaisiYmdFrom)));
            sbSql.append($AND + qWT_KouteiSummary.iwfKouteiKaisiYmd.le(getYmdTo(pKouteiKaisiYmdTo)));
        }

        if (StringUtils.isNotEmpty(pKouteiKanryouYmdFrom) || StringUtils.isNotEmpty(pKouteiKanryouYmdTo)) {

            sbSql.append($AND + qWT_KouteiSummary.kouteiKanryouYmd.ge(getYmdFrom(pKouteiKanryouYmdFrom)));
            sbSql.append($AND + qWT_KouteiSummary.kouteiKanryouYmd.le(getYmdTo(pKouteiKanryouYmdTo)));
        }






        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam1, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM1)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam2, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM2)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam3, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM3)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam4, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM4)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam5, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM5)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam6, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM6)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam7, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM7)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam8, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM8)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam9, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM9)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam10, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM10)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam11, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM11)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam12, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM12)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam13, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM13)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam14, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM14)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam15, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM15)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam16, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM16)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam17, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM17)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam18, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM18)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam19, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM19)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam20, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM20)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam21, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM21)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam22, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM22)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam23, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM23)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam24, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM24)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam25, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM25)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam26, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM26)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam27, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM27)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam28, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM28)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam29, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM29)));
        sbSql.append(getExtParamQuery(qWT_KouteiSummary.extParam30, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM30)));

        return sbSql.toString();
    }

    @SuppressWarnings("deprecation")
    private String getExtParamQuery( ExDBFieldString<WT_KouteiSummary, String> pField, WSExtParam pExtParam) {

        StringBuilder sbSql = new StringBuilder();

        if (null == pExtParam) {
            return sbSql.toString();
        }


        if (null != pExtParam.getValues()){

            if (1 == pExtParam.getValues().length){
                if (StringUtils.isNotEmpty(pExtParam.getValues()[0])){

                    sbSql.append($AND + pField.eq(pExtParam.getValues()[0]));
                }
            }

            else if (1 < pExtParam.getValues().length){

                sbSql.append($AND + pField.in(pExtParam.getValues()));
            }
        }

        else {

            if (StringUtils.isNotEmpty(pExtParam.getValueFrom())){
                sbSql.append($AND + pField.ge(pExtParam.getValueFrom()));
            }

            if (StringUtils.isNotEmpty(pExtParam.getValueTo())){
                sbSql.append($AND + pField.le(pExtParam.getValueTo()));
            }
        }
        return sbSql.toString();
    }

    private String getYmdFrom(String pYmdFrom) {

        return StringUtils.isEmpty(pYmdFrom) ? "00000000" : pYmdFrom;
    }

    private String getYmdTo(String pYmdTo) {

        return StringUtils.isEmpty(pYmdTo) ? "99999999" : pYmdTo;
    }
}
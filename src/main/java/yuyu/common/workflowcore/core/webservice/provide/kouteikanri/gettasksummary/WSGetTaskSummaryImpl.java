package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary.IWSGetTaskSummaryIOKey.MapKey;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_TaskSummary;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 件数サマリ照会のWebサービスのメインクラスです。<br />
 */
public class WSGetTaskSummaryImpl  implements WSGetTaskSummary {

    final static Logger LOGGER = LoggerFactory.getLogger(WSGetTaskSummary.class);

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;


    public WSGetTaskSummaryImpl() {
        super();
    }


    public WSGetTaskSummaryResponse validate(WSGetTaskSummaryRequest poRequest) throws Exception {

        LOGGER.debug("件数サマリ照会│バリデーションチェック処理を開始します。");

        WSGetTaskSummaryResponse poResponse = new WSGetTaskSummaryResponse();

        String sTaskcreatetimefrom = poRequest.getTaskcreatetimefrom();
        String sTaskcreatetimeto = poRequest.getTaskcreatetimeto();
        String sTaskstarttimefrom = poRequest.getTaskstarttimefrom();
        String sTaskstarttimeto = poRequest.getTaskstarttimeto();
        String sTaskendtimefrom = poRequest.getTaskendtimefrom();
        String sTaskendtimeto = poRequest.getTaskendtimeto();
        String sWariateumu = poRequest.getWariateumu();
        String sTaskendumu = poRequest.getTaskendumu();



        if (StringUtils.isNotEmpty(sTaskcreatetimeto)) {
            if (StringUtils.isEmpty(sTaskcreatetimefrom)) {
                IwfEditMessageUtil.setMsgResultNG(poResponse, IwfMessageCd.IWF4021);
                return poResponse;
            }
        }

        if (StringUtils.isNotEmpty(sTaskcreatetimefrom)) {
            if (StringUtils.isEmpty(sTaskcreatetimeto)) {
                IwfEditMessageUtil.setMsgResultNG(poResponse, IwfMessageCd.IWF4021);
                return poResponse;
            }
        }

        if (StringUtils.isNotEmpty(sTaskstarttimeto)) {
            if (StringUtils.isEmpty(sTaskstarttimefrom)) {
                IwfEditMessageUtil.setMsgResultNG(poResponse, IwfMessageCd.IWF4022);
                return poResponse;
            }
        }

        if (StringUtils.isNotEmpty(sTaskstarttimefrom)) {
            if (StringUtils.isEmpty(sTaskstarttimeto)) {
                IwfEditMessageUtil.setMsgResultNG(poResponse, IwfMessageCd.IWF4022);
                return poResponse;
            }
        }

        if (StringUtils.isNotEmpty(sTaskendtimeto)) {
            if (StringUtils.isEmpty(sTaskendtimefrom)) {
                IwfEditMessageUtil.setMsgResultNG(poResponse, IwfMessageCd.IWF4023);
                return poResponse;
            }
        }

        if (StringUtils.isNotEmpty(sTaskendtimefrom)) {
            if (StringUtils.isEmpty(sTaskendtimeto)) {
                IwfEditMessageUtil.setMsgResultNG(poResponse, IwfMessageCd.IWF4023);
                return poResponse;
            }
        }

        if (StringUtils.isNotEmpty(sWariateumu)) {
            if (!"0".equals(sWariateumu) && !"1".equals(sWariateumu)) {
                IwfEditMessageUtil.setMsgResultNG(poResponse, IwfMessageCd.IWF4026);
                return poResponse;
            }
        }

        if (StringUtils.isNotEmpty(sTaskendumu)) {
            if (!"0".equals(sTaskendumu) && !"1".equals(sTaskendumu)) {
                IwfEditMessageUtil.setMsgResultNG(poResponse, IwfMessageCd.IWF4027);
                return poResponse;
            }
        }

        return poResponse;
    }

    @SuppressWarnings("unchecked")
    @Override
    public WSGetTaskSummaryResponse executeBizMain(WSGetTaskSummaryRequest poRequest) throws Exception {

        WSGetTaskSummaryResponse oWSResponse = new WSGetTaskSummaryResponse();

        oWSResponse =  validate(poRequest);

        if (C_ResultCdKbn.NG.toString().equals(oWSResponse.getKekkastatus())) {
            return oWSResponse;
        }

        String sAccountid = poRequest.getAccountid();
        String sWariateumu = poRequest.getWariateumu();
        String sTaskendumu = poRequest.getTaskendumu();
        String sFlowid = poRequest.getFlowid();
        String sTaskid = poRequest.getTaskid();
        String sTaskcreatetimefrom = IwfCommonLogic.parseJBPMDateTime(poRequest.getTaskcreatetimefrom());
        String sTaskcreatetimeto = IwfCommonLogic.parseJBPMDateTime(poRequest.getTaskcreatetimeto());
        String sTaskstarttimefrom = IwfCommonLogic.parseJBPMDateTime(poRequest.getTaskstarttimefrom());
        String sTaskstarttimeto = IwfCommonLogic.parseJBPMDateTime(poRequest.getTaskstarttimeto());
        String sTaskendtimefrom = IwfCommonLogic.parseJBPMDateTime(poRequest.getTaskendtimefrom());
        String sTaskendtimeto = IwfCommonLogic.parseJBPMDateTime(poRequest.getTaskendtimeto());

        try {
            List<WT_TaskSummary> taskSummaryList = iwfCoreDomManager.getTaskSummaryByCond(sAccountid, sWariateumu,
                sTaskendumu,
                sFlowid, sTaskid,
                sTaskcreatetimefrom, sTaskcreatetimeto, sTaskstarttimefrom, sTaskstarttimeto, sTaskendtimefrom,
                sTaskendtimeto);

            if (taskSummaryList.isEmpty()) {
                IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF4020);

                LOGGER.debug("件数サマリデータが存在しません。");

                return oWSResponse;
            }

            List<Map<String, String>> taskSummaryMaps = new ArrayList<Map<String,String>>();

            for (WT_TaskSummary taskSummary : taskSummaryList) {

                int tokenCount = 0;
                boolean hasBeenAdded = false;

                Map<String, String> summaryMap = new HashMap<String, String>();

                String flowId = taskSummary.getFlowId();
                String taskId = taskSummary.getIwfTskId();

                for (Map<String, String> tmp : taskSummaryMaps) {

                    String tmp_flowId = tmp.get(MapKey.sS_FLOW_ID);
                    String tmp_taskId = tmp.get(MapKey.sS_TASK_ID);

                    if (flowId.equals(tmp_flowId) && taskId.equals(tmp_taskId)) {
                        hasBeenAdded = true;
                        break;
                    }
                }

                if (hasBeenAdded) {
                    continue;
                }

                for (int i = 0; i < taskSummaryList.size(); i++) {
                    WT_TaskSummary summaryN = taskSummaryList.get(i);

                    if (flowId.equals(summaryN.getFlowId()) && taskId.compareTo(summaryN.getIwfTskId()) == 0) {
                        tokenCount = tokenCount + 1;
                    }
                }

                summaryMap.put(MapKey.sS_FLOW_ID, flowId);
                summaryMap.put(MapKey.sS_FLOW_NAME, taskSummary.getFlowName());
                summaryMap.put(MapKey.sS_TASK_ID, taskId.toString());
                summaryMap.put(MapKey.sS_TASK_NAME, taskSummary.getIwfTskNm());
                summaryMap.put(MapKey.sS_TASK_COUNT, String.valueOf(tokenCount));

                taskSummaryMaps.add(summaryMap);
            }

            oWSResponse.setTaskSummaryMaps(taskSummaryMaps.toArray(new Map[] {}));
            IwfEditMessageUtil.setMsgResultOK(oWSResponse, "件数サマリ照会サービス");

        } catch (Exception e) {

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "件数サマリ照会");
        } finally {

        }

        return oWSResponse;
    }

    public WSGetTaskSummaryResponse getBootErrResponse() {
        WSGetTaskSummaryResponse res = new WSGetTaskSummaryResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}

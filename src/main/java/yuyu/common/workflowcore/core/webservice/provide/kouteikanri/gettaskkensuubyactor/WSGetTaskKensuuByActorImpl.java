package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskkensuubyactor;


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
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskkensuubyactor.IWSGetTaskKensuuByActorIOKey.MapKey;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * ユーザ別タスク件数照会のWebサービスのメインクラスです。<br />
 */
public class WSGetTaskKensuuByActorImpl  implements WSGetTaskKensuuByActor {

    final static Logger LOGGER = LoggerFactory.getLogger(WSGetTaskKensuuByActor.class);

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;


    public WSGetTaskKensuuByActorImpl() {
        super();
    }


    public WSGetTaskKensuuByActorResponse validate(WSGetTaskKensuuByActorRequest poRequest) throws Exception {

        LOGGER.debug("ユーザ別タスク件数照会│バリデーションチェック処理を開始します。");

        WSGetTaskKensuuByActorResponse poResponse = new WSGetTaskKensuuByActorResponse();

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
    public WSGetTaskKensuuByActorResponse executeBizMain(WSGetTaskKensuuByActorRequest poRequest) throws Exception {

        WSGetTaskKensuuByActorResponse oWSResponse = new WSGetTaskKensuuByActorResponse();

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
            List<Object[]> taskCountSummaryList = iwfCoreDomManager.getUserBetsuTaskKensuuByCond(sAccountid,
                sWariateumu,
                sTaskendumu,
                sFlowid, sTaskid,
                sTaskcreatetimefrom, sTaskcreatetimeto, sTaskstarttimefrom, sTaskstarttimeto, sTaskendtimefrom,
                sTaskendtimeto);


            if (taskCountSummaryList.isEmpty()) {
                IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF4020);

                LOGGER.debug("ユーザ別タスク件数照会データが存在しません。");

                return oWSResponse;
            }

            List<Map<String, String>> taskSummaryMaps = new ArrayList<Map<String,String>>();

            for (Object[] taskCountSummary : taskCountSummaryList) {

                Map<String, String> summaryMap = new HashMap<String, String>();

                summaryMap.put(MapKey.sS_FLOW_ID, taskCountSummary[0].toString());
                summaryMap.put(MapKey.sS_FLOW_NAME, (null == taskCountSummary[1]) ? null : taskCountSummary[1].toString());
                summaryMap.put(MapKey.sS_TASK_ID, taskCountSummary[2].toString());
                summaryMap.put(MapKey.sS_TASK_NAME, (null == taskCountSummary[3]) ? null : taskCountSummary[3].toString());
                summaryMap.put(MapKey.sS_USER_ID, (null == taskCountSummary[4]) ? null : taskCountSummary[4].toString());
                summaryMap.put(MapKey.sS_TASK_COUNT, taskCountSummary[5].toString());

                taskSummaryMaps.add(summaryMap);
            }

            oWSResponse.setTaskSummaryMaps(taskSummaryMaps.toArray(new Map[] {}));
            IwfEditMessageUtil.setMsgResultOK(oWSResponse, "ユーザ別タスク件数照会サービス");

        } catch (Exception e) {

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "ユーザ別タスク件数照会");
        } finally {

        }

        return oWSResponse;
    }

    public WSGetTaskKensuuByActorResponse getBootErrResponse() {
        WSGetTaskKensuuByActorResponse res = new WSGetTaskKensuuByActorResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}

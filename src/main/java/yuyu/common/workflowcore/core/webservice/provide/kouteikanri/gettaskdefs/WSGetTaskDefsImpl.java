package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.WorkflowAuthInfo;
import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef.TaskDefMapKey;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.IWSGetTaskDefsIOKey.MapKey;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_KengenUmuKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * タスク定義取得サービスのプロバイダークラスです。<br/>
 * 全てのフロー・タスクの定義情報を取得します。
 */
public class WSGetTaskDefsImpl implements WSGetTaskDefs {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private static Logger LOGGER = LoggerFactory.getLogger(WSGetTaskDefsImpl.class);

    public WSGetTaskDefsImpl() {
        super();
    }

    public WSGetTaskDefsResponse validate(
        WSGetTaskDefsRequest request) throws Exception {

        LOGGER.debug("│バリデーションチェック処理・・・");

        WSGetTaskDefsResponse oResponse = new WSGetTaskDefsResponse();

        String sAccountId = request.getAccountid();
        String sFlowId    = request.getFlowid();
        if (StringUtils.isEmpty(sAccountId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "アカウントID");
            return oResponse;
        }
        if (StringUtils.isEmpty(sFlowId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "フローＩＤ");
            return oResponse;
        }

        return oResponse;
    }

    @Override
    public WSGetTaskDefsResponse executeBizMain(
        WSGetTaskDefsRequest request) throws Exception {

        LOGGER.debug("|主処理開始・・・");

        WSGetTaskDefsResponse oResponse = new WSGetTaskDefsResponse();

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String sFlowId    = request.getFlowid();
        String sAccountId = request.getAccountid();
        String sRequestId = request.getRequestid();

        List<HashMap<String, String>> oTaskDefsList = new ArrayList<HashMap<String, String>>();

        IWorkflowContext oWfCtx = WorkflowContextFactory.newInstance();

        try {
            oWfCtx.open();

            IWorkflowProcessDef oWfpdef;
            try {
                oWfpdef = oWfCtx.getProcessDef(sFlowId);
            } catch (WorkflowRuntimeException e) {

                if(oWfCtx.isOpen()){
                    oWfCtx.close();
                }

                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2210);

                return oResponse;
            }


            Set<List<String>> kengenKouteiSet = SWAKInjector.getInstance(WorkflowAuthInfo.class).getProcessAuthByUserId(sAccountId);

            if (kengenKouteiSet.isEmpty()) {
                if (oWfCtx.isOpen()) {
                    oWfCtx.close();
                }
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2211);
                LOGGER.debug("[ReqId=" + sRequestId + "]権限IDが取得できませんでした。");
                return oResponse;
            }

            List<String> authedNodeIds = new ArrayList<String>();
            for(List<String> kengenKoutei : kengenKouteiSet) {
                if(sFlowId.equals(kengenKoutei.get(0))){
                    if(!authedNodeIds.contains(kengenKoutei.get(1))) {
                        authedNodeIds.add(kengenKoutei.get(0));
                    }
                }
            }

            List<Map<String, String>> oWfTaskDefs = oWfpdef.getTaskDefs();

            for (Map<String, String> oWfTaskDef : oWfTaskDefs) {
                HashMap<String, String> oTaskDef = new HashMap<String, String>();

                oTaskDef.putAll(oWfTaskDef);
                if(authedNodeIds.contains(oTaskDef.get(TaskDefMapKey.sTASKNAME))) {
                    oTaskDef.put(MapKey.sTASK_KENGENUMU, C_KengenUmuKbn.ARI.getValue());
                } else {
                    oTaskDef.put(MapKey.sTASK_KENGENUMU, C_KengenUmuKbn.NONE.getValue());
                }

                oTaskDefsList.add(oTaskDef);
            }

            oResponse.setTaskdefs(oTaskDefsList.toArray(new Map[]{}));
            IwfEditMessageUtil.setMsgResultOK(oResponse, "タスク定義取得");

        } catch (Exception e) {

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "タスク定義取得");
        } finally {
            if(oWfCtx.isOpen()){
                oWfCtx.close();
            }

        }

        return oResponse;
    }

    public WSGetTaskDefsResponse getStubResult(
        WSGetTaskDefsRequest request) throws Exception {
        return null;
    }
    public String getServiceName() {
        return WSGetTaskDefsRequest.sSERVICE_NAME;
    }
    public WSGetTaskDefsResponse getBootErrResponse() {
        WSGetTaskDefsResponse res = new WSGetTaskDefsResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}

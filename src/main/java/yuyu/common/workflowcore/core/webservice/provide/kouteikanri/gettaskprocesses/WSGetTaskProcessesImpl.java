package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskprocesses;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * タスク内工程情報取得サービスのプロバイダークラスです。<br />
 */
public class WSGetTaskProcessesImpl implements WSGetTaskProcesses {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(WSGetTaskProcessesImpl.class);

    public WSGetTaskProcessesImpl() {
        super();
    }

    public WSGetTaskProcessesResponse validate(WSGetTaskProcessesRequest request)
        throws Exception {

        WSGetTaskProcessesResponse oResponse =new WSGetTaskProcessesResponse();
        String sFlowId = request.getFlowid();
        String sNodeName = request.getNodename();
        if (StringUtils.isEmpty(sFlowId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "フローＩＤ");
        }
        if (StringUtils.isEmpty(sNodeName)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "ノードＩＤ");
        }
        return oResponse;
    }

    public String getServiceName() {
        return WSGetTaskProcessesRequest.sSERVICE_NAME;
    }

    @Override
    public WSGetTaskProcessesResponse executeBizMain(
        WSGetTaskProcessesRequest request) throws Exception {

        LOGGER.debug("│主処理開始・・・");

        WSGetTaskProcessesResponse oResponse =new WSGetTaskProcessesResponse();
        String sFlowId = request.getFlowid();
        String sNodeName = request.getNodename();

        IWorkflowContext oWfCon = WorkflowContextFactory.newInstance();

        boolean bWFProgress = false;

        try {
            oWfCon.open();
            bWFProgress = true;

            String sTokenId = "";
            String sGyoumukey = "";

            ArrayList<String> oGyoumuKeyList  = new ArrayList<String>();

            List<IWorkflowToken> aTokenList = oWfCon.getProcessDef(sFlowId).getTokensByNodeName(sNodeName);

            for (IWorkflowToken oToken : aTokenList) {
                sTokenId = oToken.getId();

                if(StringUtils.isNotEmpty(sTokenId)){
                    sGyoumukey = _getGyoumuKey(sFlowId, sTokenId);
                    if(StringUtils.isNotEmpty(sGyoumukey)){
                        oGyoumuKeyList.add(sGyoumukey);
                    }
                }
            }

            oResponse.setGyoumukeys(oGyoumuKeyList);

            if(oGyoumuKeyList.isEmpty()){
                IwfEditMessageUtil.setMsgResultWARN(oResponse, IwfMessageCd.IWF2080);
            } else {
                IwfEditMessageUtil.setMsgResultOK(oResponse, "タスク内工程情報取得");
            }

            bWFProgress = false;
            if (oWfCon.isOpen()) {
                oWfCon.close();
            }
        } catch (WorkflowRuntimeException wre) {

            LOGGER.error("IWFで想定外の例外が発生しました。", wre);

            if( !bWFProgress && !oWfCon.isOpen()){

                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0005);
            } else {
                if (oWfCon.isOpen()) {
                    oWfCon.close();
                }
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "タスク内工程情報取得");
            }
        } catch (Exception e) {

            LOGGER.error("想定外のエラーが発生しました。", e);

            if (oWfCon.isOpen()) {
                oWfCon.close();
            }

            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "タスク内工程情報取得");
        }
        return oResponse;
    }

    public WSGetTaskProcessesResponse getStubResult(
        WSGetTaskProcessesRequest request) throws Exception {

        return null;
    }

    private String _getGyoumuKey(final String psFlowId, final String psTokenId) throws Exception {
        String sRet = null;

        List<WT_GyoumuKey> aList = iwfCoreDomManager.getGyoumuKeysByFlowIdTokenId(psFlowId, psTokenId);

        for (WT_GyoumuKey oGyoumu : aList) {
            sRet = oGyoumu.getGyoumuKey();
            break;
        }

        return sRet;
    }

    public WSGetTaskProcessesResponse getBootErrResponse() {
        WSGetTaskProcessesResponse res = new WSGetTaskProcessesResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }
}

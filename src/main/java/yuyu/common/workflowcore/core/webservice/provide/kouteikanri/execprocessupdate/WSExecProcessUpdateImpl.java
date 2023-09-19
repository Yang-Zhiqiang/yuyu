package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate;

import static yuyu.common.workflowcore.core.iwfinfr.util.IwfLockUtils.*;
import static yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd.*;

import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic.Tokens;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 工程情報更新のWebサービスのメインクラスです。<br />
 */
public class WSExecProcessUpdateImpl  implements WSExecProcessUpdate {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private final static Logger LOGGER = LoggerFactory.getLogger(WSExecProcessUpdateImpl.class);

    public WSExecProcessUpdateImpl() {
        super();
    }

    public WSExecProcessUpdateResponse validate(WSExecProcessUpdateRequest poRequest) throws Exception {
        LOGGER.debug("主処理を開始します。");

        WSExecProcessUpdateResponse oResponse = new WSExecProcessUpdateResponse();

        String sGyoumukey = poRequest.getGyoumukey();
        String sFlowid = poRequest.getFlowid();
        String sAccountid = poRequest.getAccountid();
        String sLockkey = poRequest.getLockkey();

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sGyoumukey, "業務キー", 20)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sFlowid, "フローＩＤ", 19)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sAccountid, "アカウントＩＤ", 30)) {
            return oResponse;
        }
        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        if (bLockYouhi) {
            if (StringUtils.isEmpty(sLockkey)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IWF0002, "ロックキー");
            }
        }

        return oResponse;
    }

    @Override
    @Transactional
    public WSExecProcessUpdateResponse executeBizMain(WSExecProcessUpdateRequest poRequest) throws Exception {

        WSExecProcessUpdateResponse oWSResponse = new WSExecProcessUpdateResponse();

        oWSResponse = validate(poRequest);

        if (C_ResultCdKbn.NG.toString().equals(oWSResponse.getKekkastatus())) {
            return oWSResponse;
        }

        String sGyoumukey = poRequest.getGyoumukey();
        String sFlowid = poRequest.getFlowid();
        String sAccountid = poRequest.getAccountid();
        String sLockKey   = poRequest.getLockkey();
        byte[] oExtinfo = null;
        if (poRequest.getExtinfo() != null) {
            oExtinfo = IwfBase64Urls.decodeToString(poRequest.getExtinfo()).getBytes("UTF-8");
        }

        Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(poRequest);

        IWorkflowContext oWfContext = WorkflowContextFactory.newInstance();

        boolean bWFProgress = false;

        try {
            oWfContext.open();
            bWFProgress = true;

            try {
                oWfContext.getProcessDef(sFlowid);
            }
            catch (WorkflowRuntimeException e) {
                iwfCoreDomManager.clear();
                oWfContext.close();
                IwfEditMessageUtil.setMsgResultNG(oWSResponse, IWF2022);
                return oWSResponse;
            }

            IWorkflowToken oToken = Tokens.getActiveToken(iwfCoreDomManager, oWfContext, sGyoumukey, sFlowid);
            if(oToken == null){
                iwfCoreDomManager.clear();
                oWfContext.close();
                IwfEditMessageUtil.setMsgResultNG(oWSResponse, IWF2025);
                return oWSResponse;
            }

            if(!isValidLockKey(oToken, sLockKey)){

                iwfCoreDomManager.clear();
                IwfEditMessageUtil.setMsgResultNG(oWSResponse, IWF2021);

                LOGGER.debug("[ReqId="+ poRequest.getRequestid() + "]ロックキーが無効です。他の作業者がロック中、またはロックが既に解除されています。");
                return oWSResponse;
            }


            IwfCommonLogic.createKouteiRireki(sFlowid,
                oToken.getId(),
                sGyoumukey,
                oToken.getNodeId(),
                oToken.getNodeName(),
                C_IwfSyoriKbn.UPDATE,
                sAccountid,
                C_RirekiKbn.SYSTEM,
                oExtinfo,
                iwfCoreDomManager);

            IwfCommonLogic.updateKouteiSummary(sGyoumukey,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                extParamMap,
                iwfCoreDomManager);

            oWfContext.saveAndClose();
            IwfEditMessageUtil.setMsgResultOK(oWSResponse, "工程情報更新");
        } catch (WorkflowRuntimeException wre) {

            iwfCoreDomManager.clear();

            if( !bWFProgress && !oWfContext.isOpen()){

                IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0005);
            } else {
                if(oWfContext.isOpen()){
                    oWfContext.close();
                }
                LOGGER.error("ワークフロー想定外エラーが発生しました。", wre);
                IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "工程情報更新");
            }
        } catch (Exception e) {

            iwfCoreDomManager.clear();

            if(oWfContext.isOpen()){
                oWfContext.close();
            }

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "工程情報更新");
        } finally {
            if (oWfContext.isOpen()) {
                oWfContext.close();
            }
        }
        return oWSResponse;
    }

    public WSExecProcessUpdateResponse getStubResult(WSExecProcessUpdateRequest poRequest) throws Exception {
        return null;
    }


    public WSExecProcessUpdateResponse getBootErrResponse() {
        WSExecProcessUpdateResponse res = new WSExecProcessUpdateResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}

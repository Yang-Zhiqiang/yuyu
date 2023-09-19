package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate;

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
import yuyu.common.workflowcore.core.iwfinfr.util.enumerate.E_TokenVarKey;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic.Tokens;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.common.workflowcore.iwfcommon.check.Checks;
import yuyu.common.workflowcore.iwfcommon.check.impl.CanCreateNewTokenCheckerInBean;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 工程開始のWebサービスのメインクラスです。
 */
public class WSExecProcessCreateImpl  implements WSExecProcessCreate{

    private static Logger oLogger_ = LoggerFactory.getLogger(WSExecProcessCreateImpl.class);
    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    public WSExecProcessCreateImpl() {
        super();
    }

    @Override
    @Transactional
    public WSExecProcessCreateResponse executeBizMain(WSExecProcessCreateRequest request) throws Exception {
        String sRequestId = request.getRequestid();

        oLogger_.debug("[" + sRequestId +  "]主処理を開始します。");

        WSExecProcessCreateResponse response = new WSExecProcessCreateResponse();

        response = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(response.getKekkastatus())) {
            return response;
        }

        String sGyoumuKey = request.getGyoumukey();
        String sFlowId = request.getFlowid();
        String sAccountId = request.getAccountid();
        @SuppressWarnings("unused")
        String sProcessGroup = request.getProcessgroup();
        byte[] oExtinfo = null;
        if (request.getExtinfo() != null) {
            oExtinfo = IwfBase64Urls.decodeToString(request.getExtinfo()).getBytes("UTF-8");
        }

        String sRirekiTaskName = IwfBase64Urls.decodeToString(request.getRirekiTaskName());

        Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(request);

        IWorkflowContext oWfCtx = WorkflowContextFactory.newInstance();

        boolean bWfCtxMustClose = false;

        try {
            oLogger_.debug("[" + sRequestId +  "]ワークフローコンテキストオープン");

            oWfCtx.open();
            bWfCtxMustClose = true;

            oLogger_.debug("[" + sRequestId +  "]トランザクション開始");

            try {
                oWfCtx.getProcessDef(sFlowId);
            } catch (WorkflowRuntimeException e) {
                iwfCoreDomManager.clear();

                if(oWfCtx.isOpen()){
                    oWfCtx.close();
                }

                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF2053);

                return response;
            }

            CanCreateNewTokenCheckerInBean inBean = new CanCreateNewTokenCheckerInBean(
                iwfCoreDomManager,
                oWfCtx,
                sGyoumuKey,
                sFlowId,
                sRequestId
                );

            if(!Checks.checkCanCreateNewToken(inBean)){
                iwfCoreDomManager.clear();
                if(oWfCtx.isOpen()){
                    oWfCtx.close();
                }
                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF2051, sGyoumuKey);
                return response;
            }


            IWorkflowToken token = Tokens.createNewToken(sFlowId, oWfCtx);

            if(token == null) {
                oLogger_.debug("[" + sRequestId +  "]トークンの作成に失敗しました。");
                iwfCoreDomManager.clear();
                if(oWfCtx.isOpen()){
                    oWfCtx.close();
                }

                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF2050);
                return response;
            }

            token.next();

            String sTokenId = token.getId();

            IwfCommonLogic.modifyGyoumukeyTokenRelation(sGyoumuKey, sFlowId, sTokenId, iwfCoreDomManager, sRequestId);

            IwfCommonLogic.createKouteiRireki(sFlowId,
                sTokenId,
                sGyoumuKey,
                token.getNodeId(),
                token.getNodeName(),
                C_IwfSyoriKbn.PROCESSSTART,
                sAccountId,
                C_RirekiKbn.SYSTEM,
                oExtinfo,
                iwfCoreDomManager);

            oLogger_.debug("[" + sRequestId +  "]工程履歴を登録しました。");

            String taskNodeLocalName = null;
            if (StringUtils.isNotEmpty(sRirekiTaskName)) {
                taskNodeLocalName = sRirekiTaskName;
            }
            else if ( token.getTasks() != null &&  token.getTasks().size() > 0) {
                taskNodeLocalName = oWfCtx.getProcessDef(sFlowId).getTasknodeLocalName(token.getNodeName());
            }

            if (IwfCommonLogic.selKouteiSummry(sGyoumuKey, iwfCoreDomManager) == null) {
                IwfCommonLogic.createKouteiSummary(
                    sGyoumuKey,
                    sFlowId,
                    sAccountId,
                    sAccountId,
                    token.getNodeName(),
                    taskNodeLocalName,
                    null,
                    token.getNodeName(),
                    taskNodeLocalName,
                    token.getStringVariable(E_TokenVarKey.KOUTEI_KAISIDAY.key),
                    null,
                    token.getStringVariable(E_TokenVarKey.SYORI_STATUS.key),
                    extParamMap,
                    iwfCoreDomManager);
            }
            else {
                IwfCommonLogic.updateKouteiSummary(
                    sGyoumuKey,
                    sFlowId,
                    sAccountId,
                    sAccountId,
                    token.getNodeName(),
                    taskNodeLocalName,
                    null,
                    token.getNodeName(),
                    taskNodeLocalName,
                    token.getStringVariable(E_TokenVarKey.KOUTEI_KAISIDAY.key),
                    null,
                    token.getStringVariable(E_TokenVarKey.SYORI_STATUS.key),
                    extParamMap,
                    iwfCoreDomManager);
            }

            oLogger_.debug("[" + sRequestId +  "]データベースコミット完了");

            bWfCtxMustClose = false;
            oWfCtx.saveAndClose();

            IwfEditMessageUtil.setMsgResultOK(response, "工程開始");

        } catch (WorkflowRuntimeException wre) {

            iwfCoreDomManager.clear();

            if( !bWfCtxMustClose && !oWfCtx.isOpen()){

                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0005);
            } else {
                if(oWfCtx.isOpen()){
                    oWfCtx.close();
                }
                oLogger_.error("ワークフロー想定外エラーが発生しました。", wre);
                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0001, "工程開始");
            }
        } catch (Exception e) {

            iwfCoreDomManager.clear();

            if(oWfCtx.isOpen()){
                oWfCtx.close();
            }
            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            oLogger_.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0001, "工程開始");
        } finally {
            if(oWfCtx.isOpen()){
                oWfCtx.close();
            }
        }

        return response;
    }

    public WSExecProcessCreateResponse validate(WSExecProcessCreateRequest request) throws Exception {
        oLogger_.debug("│バリデーションチェック処理・・・");

        WSExecProcessCreateResponse response = new WSExecProcessCreateResponse();

        String sGyoumuKey   = request.getGyoumukey();
        String sFlowId      = request.getFlowid();
        String sAccountId   = request.getAccountid();
        String sRirekiTaskName = request.getRirekiTaskName();
        Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(request);

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, sGyoumuKey, "業務キー", 20)) {
            return response;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, sFlowId, "フローＩＤ", 19)) {
            return response;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, sAccountId, "アカウントＩＤ", 30)) {
            return response;
        }

        if (!IwfValidateUtil.isMaxLenChkOK(response, IwfBase64Urls.decodeToString(sRirekiTaskName), "履歴タスク名", 25)) {
            return response;
        }
        if (!IwfValidateUtil.isExtParamsChkOk(response, extParamMap, 50)) {
            return response;
        }

        return response;

    }

    public String getServiceName() {
        return WSExecProcessCreateRequest.sSERVICE_NAME;
    }

    public WSExecProcessCreateResponse getStubResult(WSExecProcessCreateRequest request) throws Exception {

        return null;
    }

    public WSExecProcessCreateResponse getBootErrResponse() {
        WSExecProcessCreateResponse res = new WSExecProcessCreateResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }
}

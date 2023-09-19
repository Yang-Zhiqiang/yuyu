package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord;


import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 工程履歴作成サービスのプロバイダークラスです。<br/>
 * 指定されたトークンＩＤ・フローＩＤの業務キーに、履歴メッセージと付加情報を追加します。
 */
public class WSCreateProcessRecordImpl implements WSCreateProcessRecord {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private final static Logger LOGGER = LoggerFactory.getLogger(WSCreateProcessRecord.class);

    public WSCreateProcessRecordImpl() {
        super();
    }

    WSCreateProcessRecordResponse validate(
        WSCreateProcessRecordRequest poRequest) throws Exception {
        LOGGER.debug("│バリデーションチェック処理・・・");

        WSCreateProcessRecordResponse oResponse = new WSCreateProcessRecordResponse();

        String sGyoumuKey   = poRequest.getGyoumukey();
        String sFlowId      = poRequest.getFlowid();
        String sAccountId   = poRequest.getAccountid();
        String sRirekimsg   = poRequest.getRirekimsg();
        String sTaskname    = poRequest.getTaskname();

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sGyoumuKey, "業務キー", 20)) {
            return oResponse;
        }

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sFlowId, "フローＩＤ", 19)) {
            return oResponse;
        }

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sAccountId, "アカウントＩＤ", 30)) {
            return oResponse;
        }

        if (!IwfValidateUtil.isMaxLenChkOK(oResponse, IwfBase64Urls.decodeToString(sRirekimsg), "履歴メッセージ", 2000)) {
            return oResponse;
        }

        if (!IwfValidateUtil.isMaxLenChkOK(oResponse, sTaskname, "タスク名", 25)) {
            return oResponse;
        }

        return oResponse;
    }

    @Override
    @Transactional
    public WSCreateProcessRecordResponse executeBizMain(
        WSCreateProcessRecordRequest request) throws Exception {

        WSCreateProcessRecordResponse oResponse = new WSCreateProcessRecordResponse();

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String sGyoumuKey = request.getGyoumukey();
        String sFlowId = request.getFlowid();
        String sAccountId = request.getAccountid();
        String sRequestId = request.getRequestid();
        String sRirekiMsg = IwfBase64Urls.decodeToString(request.getRirekimsg());
        byte[] oExtinfo = null;
        if (request.getExtinfo() != null) {
            oExtinfo = IwfBase64Urls.decodeToString(request.getExtinfo()).getBytes("UTF-8");
        }

        IWorkflowContext oWfCtx = WorkflowContextFactory.newInstance();

        IWorkflowProcessDef oWfProcessDef = null;

        try {
            oWfCtx.open();

            List<WT_GyoumuKey> resultGyoumuCheck = iwfCoreDomManager.getGyoumuKeys(sGyoumuKey);
            Iterator<WT_GyoumuKey> itrGyoumuCheck = resultGyoumuCheck.iterator();
            if(!itrGyoumuCheck.hasNext()){
                iwfCoreDomManager.clear();
                if(oWfCtx.isOpen()){
                    oWfCtx.close();
                }

                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2222);

                return oResponse;
            }

            try {
                oWfProcessDef = oWfCtx.getProcessDef(sFlowId);
            } catch (WorkflowRuntimeException e) {
                iwfCoreDomManager.clear();
                if(oWfCtx.isOpen()){
                    oWfCtx.close();
                }

                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2221);

                return oResponse;
            }

            WT_GyoumuKey gyoumuKey = iwfCoreDomManager.getGyoumuKey(sFlowId, sGyoumuKey);

            String sTokenId = null;

            if(null != gyoumuKey){
                sTokenId = gyoumuKey.getTokenId();
                LOGGER.debug("TOKENID     : " + sTokenId);
            }
            else {
                iwfCoreDomManager.clear();
                if(oWfCtx.isOpen()){
                    oWfCtx.close();
                }

                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2223);
                return oResponse;
            }

            IWorkflowToken oWfToken;
            try {
                oWfToken = oWfProcessDef.getToken(sTokenId);

            } catch (WorkflowRuntimeException e) {
                iwfCoreDomManager.clear();
                if(oWfCtx.isOpen()){
                    oWfCtx.close();
                }

                LOGGER.error("トークンが取得できませんでした。tokenId = " + sTokenId);
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程履歴作成");
                LOGGER.debug("[ReqId="+ sRequestId + "]異常終了しました。");

                return oResponse;
            }

            String sNodeId;
            String sNodeName;
            if (oWfToken == null) {
                sNodeId = "";
                sNodeName = "";
            } else {
                sNodeId = oWfToken.getNodeId();
                sNodeName = oWfToken.getNodeName();
            }

            IwfCommonLogic.createKouteiRireki(
                sFlowId,
                sTokenId,
                sGyoumuKey,
                sNodeId,
                sNodeName             ,
                C_IwfSyoriKbn.BLANK,
                sAccountId,
                C_RirekiKbn.GYOUMU,
                sRirekiMsg,
                oExtinfo,
                iwfCoreDomManager);

            IwfCommonLogic.updateKouteiSummaryTime(sGyoumuKey, iwfCoreDomManager);

            IwfEditMessageUtil.setMsgResultOK(oResponse, "工程履歴作成");

        }
        catch (WorkflowRuntimeException wre) {

            iwfCoreDomManager.clear();

            LOGGER.error("ワークフロー例外が発生しました。", wre);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程履歴作成");

        }
        catch (Exception e) {

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程履歴作成");
        } finally {
            if(oWfCtx.isOpen()){
                oWfCtx.close();
            }
        }

        return oResponse;
    }

    public WSCreateProcessRecordResponse getStubResult(
        WSCreateProcessRecordRequest request) throws Exception {
        return null;
    }

    public String getServiceName() {
        return WSCreateProcessRecordRequest.sSERVICE_NAME;
    }

    public WSCreateProcessRecordResponse getBootErrResponse() {
        WSCreateProcessRecordResponse res = new WSCreateProcessRecordResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }
}

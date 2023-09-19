package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward;

import static yuyu.common.workflowcore.core.iwfinfr.util.IwfLockUtils.*;
import static yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd.*;

import java.util.Iterator;
import java.util.List;
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
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfLockUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.enumerate.E_TokenVarKey;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic.Tokens;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_KouteiSyuuryouFlg;
import yuyu.def.classification.C_ProcessStatusKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_KouteiLock;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.google.common.base.Objects;

/**
 * 工程遷移のWebサービスのメインクラスです。<br />
 */
public class WSExecProcessForwardImpl implements WSExecProcessForward {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private final static Logger LOGGER = LoggerFactory.getLogger(WSExecProcessForwardImpl.class);

    public WSExecProcessForwardImpl() {
        super();
    }

    public String getServiceName() {
        return WSExecProcessForwardRequest.sSERVICE_NAME;
    }

    @Override
    @Transactional
    public WSExecProcessForwardResponse executeBizMain(WSExecProcessForwardRequest poRequest) throws Exception {
        LOGGER.debug("主処理を開始します。");

        WSExecProcessForwardResponse oResponse = new WSExecProcessForwardResponse();

        oResponse = validate(poRequest);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String sGyoumuKey      = poRequest.getGyoumukey();
        String sFlowId         = poRequest.getFlowid();
        String sAccountId      = poRequest.getAccountid();
        String ruleServiceUrl  = poRequest.getRuleServiceUrl();
        String sLockKey        = poRequest.getLockkey();
        byte[] oExtinfo          = null;
        if (poRequest.getExtinfo() != null) {
            oExtinfo = IwfBase64Urls.decodeToString(poRequest.getExtinfo()).getBytes("UTF-8");
        }
        String sRirekiTaskName = IwfBase64Urls.decodeToString(poRequest.getRirekiTaskName());
        String sRequestId      = poRequest.getRequestid();

        String sRuleConditionName = IwfBase64Urls.decodeToString(poRequest.getRuleConditionName());
        String sRuleCondition = IwfBase64Urls.decodeToString(poRequest.getRuleCondition());

        Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(poRequest);

        LOGGER.trace("以下のパラメータで工程遷移を実行します。");
        LOGGER.trace("sGyoumuKey : " + sGyoumuKey);
        LOGGER.trace("sFlowId : " + sFlowId);
        LOGGER.trace("sAccountId : " + sAccountId);
        LOGGER.trace("sRirekiTaskName : " + sRirekiTaskName);

        IWorkflowContext oWfContext = WorkflowContextFactory.newInstance();

        boolean bWfContextIsOpened = false;

        try {
            oWfContext.open();
            bWfContextIsOpened = true;

            try {
                oWfContext.getProcessDef(sFlowId);
            }
            catch (WorkflowRuntimeException e) {
                iwfCoreDomManager.clear();
                IwfEditMessageUtil.setMsgResultNG(oResponse, IWF2022);
                return oResponse;
            }

            List<WT_GyoumuKey> resultGyoumuCheck =  iwfCoreDomManager.getGyoumuKeys(sGyoumuKey);

            Iterator<WT_GyoumuKey> itrGyoumuCheck = resultGyoumuCheck.iterator();
            if(!itrGyoumuCheck.hasNext()){
                iwfCoreDomManager.clear();
                IwfEditMessageUtil.setMsgResultNG(oResponse, IWF2023);
                return oResponse;
            }

            WT_GyoumuKey wtrGyoumu =  iwfCoreDomManager.getGyoumuKey(sFlowId, sGyoumuKey);

            String sTokenId = null;
            if(wtrGyoumu != null){
                sTokenId = wtrGyoumu.getTokenId();
                LOGGER.debug("TOKENID     : " + sTokenId);
            }
            else {
                iwfCoreDomManager.clear();
                IwfEditMessageUtil.setMsgResultNG(oResponse, IWF2020);

                LOGGER.error("[ReqId="+ sRequestId + "]指定されたフローID、業務キーに紐づくトークンIDが取得できませんでした。[sFlowId=" + sFlowId  + ", sGyoumuKey=" + sGyoumuKey + "]");
                return oResponse;
            }

            IWorkflowToken oToken = Tokens.getActiveToken(iwfCoreDomManager, oWfContext, sGyoumuKey, sFlowId);
            if(oToken == null) {

                iwfCoreDomManager.clear();
                IwfEditMessageUtil.setMsgResultNG(oResponse, IWF2025);

                LOGGER.debug("[ReqId="+ sRequestId + "]指定されたフローID、業務キーに紐づくトークンは存在しない、または終了しています。[sFlowId=" + sFlowId  + ", sGyoumuKey=" + sGyoumuKey + "]");
                return oResponse;
            }

            if(!isValidLockKey(oToken, sLockKey)){

                iwfCoreDomManager.clear();
                IwfEditMessageUtil.setMsgResultNG(oResponse, IWF2021);

                LOGGER.debug("[ReqId="+ sRequestId + "]ロックキーが無効です。他の作業者がロック中、またはロックが既に解除されています。");
                return oResponse;
            }

            oToken.setStringVariable(E_TokenVarKey.REQUEST_ID.key, sRequestId);

            oToken.setStringVariable(E_TokenVarKey.RULE_SERVICE_URL.key,ruleServiceUrl);

            oToken.setStringVariable(E_TokenVarKey.RULE_CONDITIONNAME.key, sRuleConditionName);

            oToken.setStringVariable(E_TokenVarKey.RULE_CONDITION.key, sRuleCondition);

            LOGGER.debug(Objects.toStringHelper(this)
                .add("ruleServiceUrl", ruleServiceUrl)
                .toString());

            String sSrcNodeId   = oToken.getNodeId();
            String sSrcNodeName = oToken.getNodeName();

            LOGGER.debug("[ReqId="+ sRequestId + "]工程遷移を実行します。");
            oToken.next();
            LOGGER.debug("[ReqId="+ sRequestId + "]工程遷移を実行しました。");

            if (oToken.hasEnded()){
                oToken.setStringVariable(E_TokenVarKey.SYORI_STATUS.key,      C_ProcessStatusKbn.COMPLETED.getValue());
                oToken.setStringVariable(E_TokenVarKey.KOUTEI_KANRYOUDAY.key, IwfDateUtils.getYYYYMMDD());
                oResponse.setKouteisyuuryouflg(yuyu.def.classification.C_KouteiSyuuryouFlg.SYUURYOU.getValue());

                WT_KouteiLock lockInfo = iwfCoreDomManager.getKouteiLock(sFlowId, sGyoumuKey);
                if (null != lockInfo) {
                    iwfCoreDomManager.delete(lockInfo);
                }

                IwfLockUtils.clearLockVariable(oToken);

                LOGGER.debug("[ReqId="+ sRequestId + "]工程遷移の結果、トークンが終了しました。");
            }

            String summaryCurrentTaskname   = null;
            String summaryKouteikaisibi     = null;
            String summaryKouteikanryoubi   = null;
            String summarySyoristatus       = null;
            String summaryPreviousTasknodeLocalName = null;
            String summaryCurrentTasknodeLocalName = null;

            String sNewFlowId = oToken.getStringVariable(E_TokenVarKey.AUTO_CREATE_FLOWID.key);
            if (StringUtils.isNotEmpty(sNewFlowId)) {
                LOGGER.debug("[ReqId="+ sRequestId + "]工程オートクリエイトを開始します。");
                try {
                    String sKouteiKaisiDay = oToken.getStringVariable(E_TokenVarKey.KOUTEI_KAISIDAY.key);

                    IWorkflowToken oNewToken = IwfCommonLogic.createNewTokenAuto(sNewFlowId, sGyoumuKey, sKouteiKaisiDay, oWfContext, iwfCoreDomManager);

                    oToken.setStringVariable(E_TokenVarKey.SYORI_STATUS.key,      C_ProcessStatusKbn.OTHERFLOW.getValue());

                    oToken.next();

                    IwfCommonLogic.createKouteiRireki(sNewFlowId,
                        oNewToken.getId(),
                        sGyoumuKey,
                        oNewToken.getNodeId(),
                        oNewToken.getNodeName(),
                        C_IwfSyoriKbn.AUTOPROCESSSTART,
                        sAccountId,
                        C_RirekiKbn.SYSTEM,
                        C_IwfSyoriKbn.AUTOPROCESSSTART.getContent(),
                        oExtinfo,
                        iwfCoreDomManager);

                    summaryCurrentTaskname   = oNewToken.getNodeName();
                    summaryKouteikaisibi     = oNewToken.getStringVariable(E_TokenVarKey.KOUTEI_KAISIDAY.key);
                    summaryKouteikanryoubi   = oNewToken.getStringVariable(E_TokenVarKey.KOUTEI_KANRYOUDAY.key);
                    summarySyoristatus       = oNewToken.getStringVariable(E_TokenVarKey.SYORI_STATUS.key);
                    summaryCurrentTasknodeLocalName = oWfContext.getProcessDef(sNewFlowId).getTasknodeLocalName(summaryCurrentTaskname);

                }
                catch (Exception e) {
                    LOGGER.error("[ReqId="+ sRequestId + "]工程オートクリエイト処理でエラーが発生しました。", e);
                    iwfCoreDomManager.clear();
                    IwfEditMessageUtil.setMsgResultNG(oResponse, IWF2026);
                    return oResponse;
                }

                oToken.setStringVariable(E_TokenVarKey.AUTO_CREATE_FLOWID.key, null);

                LOGGER.debug("[ReqId="+ sRequestId + "]工程オートクリエイトが完了しました。");
            }

            oResponse.setAutocreateflowid(sNewFlowId);

            oToken.setStringVariable(E_TokenVarKey.REQUEST_ID.key, null);

            StringBuilder sb = new StringBuilder();
            sb.append(C_IwfSyoriKbn.TRANSIT.getContent());
            sb.append(" [").append(sSrcNodeName).append("→").append(oToken.getNodeName()).append("]");
            String sRirekimsg = sb.toString();

            LOGGER.debug("[ReqId="+ sRequestId + "]工程遷移が完了しました。" + sRirekimsg);

            IwfCommonLogic.createKouteiRireki(sFlowId,
                sTokenId,
                sGyoumuKey,
                sSrcNodeId,
                sSrcNodeName,
                C_IwfSyoriKbn.TRANSIT,
                sAccountId,
                C_RirekiKbn.SYSTEM,
                sRirekimsg,
                oExtinfo,
                iwfCoreDomManager);


            if (StringUtils.isNotEmpty(sRirekiTaskName)) {
                summaryPreviousTasknodeLocalName = sRirekiTaskName;
            }
            else {
                summaryPreviousTasknodeLocalName = oWfContext.getProcessDef(sFlowId).getTasknodeLocalName(sSrcNodeName);
            }

            if (summaryCurrentTaskname == null) {
                summaryCurrentTaskname = oToken.getNodeName();
                summaryKouteikaisibi   = oToken.getStringVariable(E_TokenVarKey.KOUTEI_KAISIDAY.key);
                summaryKouteikanryoubi = oToken.getStringVariable(E_TokenVarKey.KOUTEI_KANRYOUDAY.key);
                summarySyoristatus     = oToken.getStringVariable(E_TokenVarKey.SYORI_STATUS.key);
                summaryCurrentTasknodeLocalName = oWfContext.getProcessDef(sFlowId).getTasknodeLocalName(summaryCurrentTaskname);
            }

            String summaryFlowid = null;
            if (StringUtils.isNotEmpty(sNewFlowId)) {
                summaryFlowid =sNewFlowId;
            }

            IwfCommonLogic.updateKouteiSummary(sGyoumuKey,
                summaryFlowid,
                null,
                sAccountId,
                sSrcNodeName,
                summaryPreviousTasknodeLocalName,
                "",
                summaryCurrentTaskname,
                summaryCurrentTasknodeLocalName,
                summaryKouteikaisibi,
                summaryKouteikanryoubi,
                summarySyoristatus,
                extParamMap,
                iwfCoreDomManager);

            IwfCommonLogic.clearGenzaiAccountid(sGyoumuKey, iwfCoreDomManager);

            LOGGER.debug("[ReqId="+ sRequestId + "]工程履歴を保存しました。");

            bWfContextIsOpened = false;
            oWfContext.saveAndClose();

            if(oResponse.getKouteisyuuryouflg() == null) {
                oResponse.setKouteisyuuryouflg(C_KouteiSyuuryouFlg.KEIZOKUTYUU.getValue());
            }

            IwfEditMessageUtil.setMsgResultOK(oResponse, "工程遷移");
            LOGGER.debug("[ReqId="+ sRequestId + "]工程遷移サービスが正常終了しました。");

        }
        catch (WorkflowRuntimeException wre) {

            iwfCoreDomManager.clear();

            if( !bWfContextIsOpened && !oWfContext.isOpen()){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0005);
            }
            else {
                LOGGER.error("ワークフロー想定外エラーが発生しました。", wre);
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程遷移");
            }
        }
        catch (Exception e) {

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程遷移");

        } finally {

            if(oWfContext.isOpen()){
                oWfContext.close();
            }
        }
        return oResponse;
    }

    public WSExecProcessForwardResponse validate(WSExecProcessForwardRequest poRequest) throws Exception {
        LOGGER.debug("バリデーションチェック処理を開始します。");

        WSExecProcessForwardResponse oResponse = new WSExecProcessForwardResponse();

        String sGyoumuKey        = poRequest.getGyoumukey();
        String sFlowId           = poRequest.getFlowid();
        String sAccountId        = poRequest.getAccountid();
        String sLockkey          = poRequest.getLockkey();
        String sRirekiTaskName   = poRequest.getRirekiTaskName();
        Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(poRequest);

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sGyoumuKey, "業務キー", 20)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sFlowId, "フローＩＤ", 19)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sAccountId, "アカウントＩＤ", 30)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isMaxLenChkOK(oResponse, IwfBase64Urls.decodeToString(sRirekiTaskName), "履歴タスク名", 25)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isExtParamsChkOk(oResponse, extParamMap, 50)) {
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

    public WSExecProcessForwardResponse getStubResult(WSExecProcessForwardRequest poRequest) throws Exception {

        return null;
    }

    public WSExecProcessForwardResponse getBootErrResponse() {
        WSExecProcessForwardResponse res = new WSExecProcessForwardResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }
}

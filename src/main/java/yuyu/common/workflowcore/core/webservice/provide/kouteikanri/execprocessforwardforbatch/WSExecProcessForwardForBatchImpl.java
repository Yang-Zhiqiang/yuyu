package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch;

import static yuyu.common.workflowcore.core.iwfinfr.util.IwfLockUtils.*;
import static yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd.*;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import net.arnx.jsonic.JSONException;

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
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.google.common.base.Objects;

/**
 * 工程遷移（バッチ用）のWebサービスのメインクラスです。<br />
 */
public class WSExecProcessForwardForBatchImpl implements WSExecProcessForwardForBatch {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private final static Logger LOGGER = LoggerFactory.getLogger(WSExecProcessForwardForBatchImpl.class);

    public WSExecProcessForwardForBatchImpl() {
        super();
    }


    public String getServiceName() {
        return WSExecProcessForwardForBatchRequest.sSERVICE_NAME;
    }


    public WSExecProcessForwardForBatchResponse validate(WSExecProcessForwardForBatchRequest poRequest) throws Exception {
        LOGGER.debug("バリデーションチェック処理を開始します。");

        WSExecProcessForwardForBatchResponse oResponse = new WSExecProcessForwardForBatchResponse();

        String sAccountId = poRequest.getAccountid();
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sAccountId, "アカウントＩＤ", 30)) {
            return oResponse;
        }

        int idx = 0;

        List<ProcessForwardBeanForBatch> batchBeanList = poRequest.getProcessForwardForBatchBeanList();
        if (null == batchBeanList || 0 == batchBeanList.size()) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "バッチ工程遷移Beanリスト");
        }

        for (ProcessForwardBeanForBatch batchBean : batchBeanList) {

            ++idx;

            String sGyoumuKey = batchBean.getGyoumukey();
            String sFlowId = batchBean.getFlowid();
            String sRirekiTaskName = batchBean.getRirekiTaskName();
            String sRirekiMsg = batchBean.getRirekiTaskMessage();
            String sLockConfirmKbn = batchBean.getLockConfirmKbn();
            String sLockkey = batchBean.getLockkey();
            Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(batchBean);

            if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sGyoumuKey, idx + "件目の" + "業務キー", 20)) {
                return oResponse;
            }
            if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sFlowId, idx + "件目の" + "フローＩＤ", 19)) {
                return oResponse;
            }
            if (!IwfValidateUtil.isMaxLenChkOK(oResponse, IwfBase64Urls.decodeToString(sRirekiTaskName), idx + "件目の" + "履歴タスク名", 50)) {
                return oResponse;
            }
            if (!IwfValidateUtil.isMaxLenChkOK(oResponse, sRirekiMsg, idx + "件目の" + "履歴メッセージ", 2000)) {
                return oResponse;
            }
            if (!IwfValidateUtil.isExtParamsChkOk(oResponse, extParamMap, 50)) {
                return oResponse;
            }
            if ("1".equals(sLockConfirmKbn)) {
                if (StringUtils.isEmpty(sLockkey)) {
                    IwfEditMessageUtil.setMsgResultNG(oResponse, IWF0002, idx + "件目の" + "ロックキー");
                    return oResponse;
                }
            }
        }

        return oResponse;
    }

    @Override
    @Transactional
    public WSExecProcessForwardForBatchResponse executeBizMain(WSExecProcessForwardForBatchRequest poRequest) throws Exception {
        LOGGER.debug("主処理を開始します。");

        WSExecProcessForwardForBatchResponse oResponse = new WSExecProcessForwardForBatchResponse();

        oResponse = validate(poRequest);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String sRequestId = poRequest.getRequestid();
        String sAccountId = poRequest.getAccountid();
        String ruleServiceUrl = poRequest.getRuleServiceUrl();
        String rirekiYouhi = poRequest.getRirekiYouhi();

        IWorkflowContext oWfContext = WorkflowContextFactory.newInstance();

        boolean bWfContextIsOpened = false;

        List<ProcessForwardBeanForBatch> batchBeanList = poRequest.getProcessForwardForBatchBeanList();

        try {

            int idx = 0;

            oWfContext.open();
            bWfContextIsOpened = true;

            for (ProcessForwardBeanForBatch batchBean : batchBeanList) {

                ++idx;

                String sFlowId = batchBean.getFlowid();
                String sGyoumuKey = batchBean.getGyoumukey();
                String sRirekiTaskName = IwfBase64Urls.decodeToString(batchBean.getRirekiTaskName());
                String sRuleCondition = IwfBase64Urls.decodeToString((String) batchBean.getRuleCondition());
                String sRuleConditionName = IwfBase64Urls.decodeToString(batchBean.getRuleConditionName());
                Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(batchBean);
                byte[] oExtinfo = null;
                if (null != batchBean.getExtInfo()) {
                    oExtinfo = IwfBase64Urls.decodeToString(batchBean.getExtInfo()).getBytes("UTF-8");
                }

                IWorkflowToken oToken = doChkBeforeForward(sRequestId, oWfContext, batchBean, oResponse);
                if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
                    return oResponse;
                }

                oToken.setStringVariable(E_TokenVarKey.REQUEST_ID.key, sRequestId);

                oToken.setStringVariable(E_TokenVarKey.RULE_SERVICE_URL.key, ruleServiceUrl);

                oToken.setStringVariable(E_TokenVarKey.RULE_CONDITIONNAME.key, sRuleConditionName);

                oToken.setStringVariable(E_TokenVarKey.RULE_CONDITION.key, sRuleCondition);

                LOGGER.debug(Objects.toStringHelper(this).add("ruleServiceUrl", ruleServiceUrl).toString());

                String sSrcNodeId = oToken.getNodeId();
                String sSrcNodeName = oToken.getNodeName();

                LOGGER.debug("[ReqId=" + sRequestId + "]工程遷移" + "(" + idx + "件目)" + "を実行します。");
                oToken.next();
                LOGGER.debug("[ReqId=" + sRequestId + "]工程遷移" + "(" + idx + "件目)" + "を実行しました。");

                if (oToken.hasEnded()) {
                    oToken.setStringVariable(E_TokenVarKey.SYORI_STATUS.key, C_ProcessStatusKbn.COMPLETED.getValue());
                    oToken.setStringVariable(E_TokenVarKey.KOUTEI_KANRYOUDAY.key, IwfDateUtils.getYYYYMMDD());
                    oResponse.setKouteisyuuryouflg(yuyu.def.classification.C_KouteiSyuuryouFlg.SYUURYOU.getValue());

                    WT_KouteiLock lockInfo = iwfCoreDomManager.getKouteiLock(sFlowId, sGyoumuKey);
                    if (null != lockInfo) {
                        iwfCoreDomManager.delete(lockInfo);
                    }

                    IwfLockUtils.clearLockVariable(oToken);

                    LOGGER.debug("[ReqId=" + sRequestId + "]工程遷移の結果、トークンが終了しました。");
                }

                ProcessForwardSummaryBean summaryBean = new ProcessForwardSummaryBean();
                String sNewFlowId = oToken.getStringVariable(E_TokenVarKey.AUTO_CREATE_FLOWID.key);
                if(StringUtils.isNotEmpty(sNewFlowId)){
                    doAutoForward(sRequestId, sAccountId, oWfContext, oToken, batchBean, summaryBean, oResponse);
                }
                if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
                    LOGGER.debug("[AutoCreateFlowId(=" + oResponse.getAutocreateflowid() + "]工程遷移" + "(" + idx + "件目)" + "が失敗しました。");
                    return oResponse;
                }

                StringBuilder sb = new StringBuilder();
                sb.append(C_IwfSyoriKbn.TRANSIT.getContent());
                sb.append(" [").append(sSrcNodeName).append("→").append(oToken.getNodeName()).append("]");
                String sRirekimsg = sb.toString();

                LOGGER.debug("[ReqId=" + sRequestId + "]工程遷移" + "(" + idx + "件目)" + "が完了しました。" + sRirekimsg);

                IwfCommonLogic.createKouteiRireki(sFlowId,
                    oToken.getId(),
                    sGyoumuKey,
                    sSrcNodeId,
                    sSrcNodeName,
                    C_IwfSyoriKbn.TRANSIT,
                    sAccountId,
                    C_RirekiKbn.SYSTEM,
                    sRirekimsg,
                    oExtinfo,
                    iwfCoreDomManager);

                if ("1".equals(rirekiYouhi)) {
                    IwfCommonLogic.createKouteiRireki(sFlowId,
                        oToken.getId(),
                        sGyoumuKey,
                        sSrcNodeId,
                        sSrcNodeName,
                        C_IwfSyoriKbn.TRANSIT,
                        sAccountId,
                        C_RirekiKbn.GYOUMU,
                        batchBean.getRirekiTaskMessage(),
                        oExtinfo,
                        iwfCoreDomManager);
                }

                LOGGER.debug("[ReqId=" + sRequestId + "]工程履歴作成" + "(" + idx + "件目)" + "が完了しました。");

                if (null == summaryBean.getSummaryCurrentTaskname()) {
                    summaryBean.setSummaryPreviousTasknodeLocalName(oWfContext.getProcessDef(sFlowId).getTasknodeLocalName(sSrcNodeName));
                    summaryBean.setSummaryCurrentTaskname(oToken.getNodeName());
                    summaryBean.setSummaryKouteikaisibi(oToken.getStringVariable(E_TokenVarKey.KOUTEI_KAISIDAY.key));
                    summaryBean.setSummaryKouteikanryoubi(oToken.getStringVariable(E_TokenVarKey.KOUTEI_KANRYOUDAY.key));
                    summaryBean.setSummarySyoristatus(oToken.getStringVariable(E_TokenVarKey.SYORI_STATUS.key));
                    summaryBean.setSummaryCurrentTasknodeLocalName(oWfContext.getProcessDef(sFlowId).getTasknodeLocalName(oToken.getNodeName()));
                }

                String summaryFlowid = null;
                if (StringUtils.isNotEmpty(sNewFlowId)) {
                    summaryFlowid = sNewFlowId;
                }

                IwfCommonLogic.updateKouteiSummary(sGyoumuKey,
                    summaryFlowid,
                    null,
                    sAccountId,
                    sSrcNodeName,
                    summaryBean.getSummaryPreviousTasknodeLocalName(),
                    "",
                    summaryBean.getSummaryCurrentTaskname(),
                    summaryBean.getSummaryCurrentTasknodeLocalName(),
                    summaryBean.getSummaryKouteikaisibi(),
                    summaryBean.getSummaryKouteikanryoubi(),
                    summaryBean.getSummarySyoristatus(),
                    extParamMap,
                    iwfCoreDomManager);

                IwfCommonLogic.clearGenzaiAccountid(sGyoumuKey, iwfCoreDomManager);

                LOGGER.debug("[ReqId=" + sRequestId + "]工程サマリ更新" + "(" + idx + "件目)" + "が完了しました。");

                if (oResponse.getKouteisyuuryouflg() == null) {
                    oResponse.setKouteisyuuryouflg(C_KouteiSyuuryouFlg.KEIZOKUTYUU.getValue());
                }
            }

            bWfContextIsOpened = false;
            oWfContext.saveAndClose();

            IwfEditMessageUtil.setMsgResultOK(oResponse, "工程遷移（バッチ用）");
            LOGGER.debug("[ReqId=" + sRequestId + "]工程遷移（バッチ用）サービスが正常終了しました。");
        }
        catch (WorkflowRuntimeException wre) {

            iwfCoreDomManager.clear();

            if (!bWfContextIsOpened && !oWfContext.isOpen()) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0005);
            }
            else {
                LOGGER.error("ワークフロー想定外エラーが発生しました。", wre);
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程遷移（バッチ用）");
            }
        }
        catch (Exception e) {

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程遷移（バッチ用）");

        } finally {
            if (oWfContext.isOpen()) {
                oWfContext.close();
            }
        }

        return oResponse;
    }

    private IWorkflowToken doChkBeforeForward(String sRequestId, IWorkflowContext oWfContext,
        ProcessForwardBeanForBatch batchBean,
        WSExecProcessForwardForBatchResponse oResponse) throws Exception {

        String sFlowId = batchBean.getFlowid();
        String sGyoumuKey = batchBean.getGyoumukey();
        String sLockKey = batchBean.getLockkey();
        String sLockConfirmKbn = batchBean.getLockConfirmKbn();

        IWorkflowToken oToken = null;

        try {
            oWfContext.getProcessDef(sFlowId);
        }
        catch (WorkflowRuntimeException e) {
            iwfCoreDomManager.clear();
            IwfEditMessageUtil.setMsgResultNG(oResponse, IWF2022);
            return oToken;
        }

        List<WT_GyoumuKey> resultGyoumuCheck = iwfCoreDomManager.getGyoumuKeys(sGyoumuKey);

        Iterator<WT_GyoumuKey> itrGyoumuCheck = resultGyoumuCheck.iterator();
        if (!itrGyoumuCheck.hasNext()) {
            iwfCoreDomManager.clear();
            IwfEditMessageUtil.setMsgResultNG(oResponse, IWF2023);
            return oToken;
        }

        WT_GyoumuKey itrGyoumu = iwfCoreDomManager.getGyoumuKey(sFlowId, sGyoumuKey);

        String sTokenId = null;
        if (null != itrGyoumu) {
            sTokenId = itrGyoumu.getTokenId();
            LOGGER.debug("TOKENID     : " + sTokenId);
        }
        else {
            iwfCoreDomManager.clear();

            IwfEditMessageUtil.setMsgResultNG(oResponse, IWF2020);
            LOGGER.error("[ReqId=" + sRequestId + "]指定されたフローID、業務キーに紐づくトークンIDが取得できませんでした。[sFlowId=" + sFlowId
                + ", sGyoumuKey=" + sGyoumuKey + "]");
            return oToken;
        }

        oToken = Tokens.getActiveToken(iwfCoreDomManager, oWfContext, sGyoumuKey, sFlowId);
        if (null == oToken) {
            iwfCoreDomManager.clear();

            IwfEditMessageUtil.setMsgResultNG(oResponse, IWF2025);

            LOGGER.debug("[ReqId=" + sRequestId + "]指定されたフローID、業務キーに紐づくトークンは存在しない、または終了しています。[sFlowId="
                + sFlowId + ", sGyoumuKey=" + sGyoumuKey + "]");
            return oToken;
        }

        if ("1".equals(sLockConfirmKbn) && !isValidLockKey(oToken, sLockKey)) {
            iwfCoreDomManager.clear();

            IwfEditMessageUtil.setMsgResultNG(oResponse, IWF2021);

            LOGGER.debug("[ReqId=" + sRequestId + "]ロックキーが無効です。他の作業者がロック中、またはロックが既に解除されています。");

            return oToken;
        }

        return oToken;
    }

    private void doAutoForward(String sRequestId, String sAccountId, IWorkflowContext oWfContext,
        IWorkflowToken oToken,
        ProcessForwardBeanForBatch batchBean,
        ProcessForwardSummaryBean summaryBean,
        WSExecProcessForwardForBatchResponse oResponse) throws UnsupportedEncodingException, JSONException {

        String sNewFlowId = oToken.getStringVariable(E_TokenVarKey.AUTO_CREATE_FLOWID.key);

        LOGGER.debug("[ReqId=" + sRequestId + "]工程オートリクエイトを開始します。");

        String sGyoumuKey = batchBean.getGyoumukey();
        byte[] oExtinfo = null;
        if (null != batchBean.getExtInfo()) {
            oExtinfo = IwfBase64Urls.decodeToString(batchBean.getExtInfo()).getBytes("UTF-8");
        }

        try {
            String sKouteiKaisiDay = oToken.getStringVariable(E_TokenVarKey.KOUTEI_KAISIDAY.key);

            IWorkflowToken oNewToken = IwfCommonLogic.createNewTokenAuto(sNewFlowId, sGyoumuKey, sKouteiKaisiDay,
                oWfContext, iwfCoreDomManager);

            oToken.setStringVariable(E_TokenVarKey.SYORI_STATUS.key, C_ProcessStatusKbn.OTHERFLOW.getValue());

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

            summaryBean.setSummaryCurrentTaskname(oNewToken.getNodeName());
            summaryBean.setSummaryKouteikaisibi(oNewToken.getStringVariable(E_TokenVarKey.KOUTEI_KAISIDAY.key));
            summaryBean.setSummaryKouteikanryoubi(oNewToken.getStringVariable(E_TokenVarKey.KOUTEI_KANRYOUDAY.key));
            summaryBean.setSummarySyoristatus(oNewToken.getStringVariable(E_TokenVarKey.SYORI_STATUS.key));
            summaryBean.setSummaryCurrentTasknodeLocalName(oWfContext.getProcessDef(sNewFlowId).getTasknodeLocalName(oNewToken.getNodeName()));
        }
        catch (Exception e) {
            LOGGER.error("[ReqId=" + sRequestId + "]工程オートリクエイト処理でエラーが発生しました。", e);
            iwfCoreDomManager.clear();

            IwfEditMessageUtil.setMsgResultNG(oResponse, IWF2026);
        }

        oToken.setStringVariable(E_TokenVarKey.AUTO_CREATE_FLOWID.key, null);

        LOGGER.debug("[ReqId=" + sRequestId + "]工程オートリクエイトが完了しました。");

        oResponse.setAutocreateflowid(sNewFlowId);

        oToken.setStringVariable(E_TokenVarKey.REQUEST_ID.key, null);
    }


    public WSExecProcessForwardForBatchResponse getStubResult(WSExecProcessForwardForBatchRequest poRequest) throws Exception {

        return null;
    }

    public WSExecProcessForwardForBatchResponse getBootErrResponse() {
        WSExecProcessForwardForBatchResponse res = new WSExecProcessForwardForBatchResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }
}

package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch;

import static yuyu.common.workflowcore.core.iwfinfr.util.IwfLockUtils.*;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.util.string.StringUtil;

import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
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
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.WT_KouteiRireki;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 工程情報更新（バッチ用）のWebサービスのメインクラスです。<br />
 */
public class WSExecProcessUpdateForBatchImpl implements WSExecProcessUpdateForBatch {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private final static Logger LOGGER = LoggerFactory.getLogger(WSExecProcessUpdateForBatchImpl.class);

    public WSExecProcessUpdateForBatchImpl() {
        super();
    }

    public String getServiceName() {
        return WSExecProcessUpdateForBatchRequest.sSERVICE_NAME;
    }

    public WSExecProcessUpdateForBatchResponse validate(WSExecProcessUpdateForBatchRequest pRequest) throws Exception {
        LOGGER.debug("バリデーションチェック処理を開始します。");

        WSExecProcessUpdateForBatchResponse oResponse = new WSExecProcessUpdateForBatchResponse();

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, pRequest.getAccountid(), "アカウントＩＤ", 30)) {
            return oResponse;
        }
        List<ProcessUpdateBeanForBatch> batchBeanList = pRequest.getProcessUpdateBeanForBatchList();
        if (null == batchBeanList || 0 == batchBeanList.size()) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "バッチ工程情報更新Beanリスト");
            return oResponse;
        }
        boolean isLockConfirm = false;
        String sLockConfirmKbn = pRequest.getLockConfirmKbn();
        if(!StringUtil.isNullOrBlank(sLockConfirmKbn)){
            if(StringUtil.isNullOrBlank(C_UmuKbn.getContentByValue(sLockConfirmKbn))){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0006, "ロック確認区分");
                return oResponse;
            }
            isLockConfirm = C_UmuKbn.ARI.toString().equals(pRequest.getLockConfirmKbn());
        }
        for (ProcessUpdateBeanForBatch batchBean : batchBeanList) {

            String sGyoumukey = batchBean.getGyoumukey();

            if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sGyoumukey, "業務キー", 20)) {
                oResponse.setErrGyoumukey(sGyoumukey);
                return oResponse;
            }
            if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, batchBean.getFlowid(), "フローＩＤ", 19)) {
                oResponse.setErrGyoumukey(sGyoumukey);
                return oResponse;
            }
            if (!IwfValidateUtil.isExtParamsChkOk(oResponse, IwfCommonLogic.getExtParams(batchBean), 50)) {
                oResponse.setErrGyoumukey(sGyoumukey);
                return oResponse;
            }
            if (isLockConfirm) {
                if (StringUtil.isNullOrBlank(batchBean.getLockkey())) {
                    setErrGyoumukeyResult(sGyoumukey, oResponse, IwfMessageCd.IWF0002, "ロックキー");
                    return oResponse;
                }
            }
        }
        return oResponse;
    }

    @Override
    @Transactional
    public WSExecProcessUpdateForBatchResponse executeBizMain(WSExecProcessUpdateForBatchRequest pRequest) throws Exception {
        LOGGER.debug("主処理を開始します。");

        WSExecProcessUpdateForBatchResponse oResponse = validate(pRequest);
        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }
        executeProcessUpdateForBatch(pRequest, oResponse);
        return oResponse;
    }

    private WSExecProcessUpdateForBatchResponse executeProcessUpdateForBatch(WSExecProcessUpdateForBatchRequest pRequest,
        WSExecProcessUpdateForBatchResponse pResponse) throws Exception {

        String sRequestId = pRequest.getRequestid();
        String sAccountId = pRequest.getAccountid();
        boolean isLockConfirm = C_UmuKbn.ARI.toString().equals(pRequest.getLockConfirmKbn());
        List<ProcessUpdateBeanForBatch> batchBeanList = pRequest.getProcessUpdateBeanForBatchList();

        String sGyoumukey = "";

        IWorkflowContext oWfContext = WorkflowContextFactory.newInstance();

        try(EntityUpdater<WT_KouteiSummary> updater = new EntityUpdater<>();
            EntityInserter<WT_KouteiRireki> inserter = new EntityInserter<>()){

            oWfContext.open();

            for (ProcessUpdateBeanForBatch batchBean : batchBeanList) {


                sGyoumukey = batchBean.getGyoumukey();
                String sFlowid = batchBean.getFlowid();
                byte[] oExtinfo = null;
                if (batchBean.getExtInfo() != null) {
                    oExtinfo = IwfBase64Urls.decodeToString(batchBean.getExtInfo()).getBytes("UTF-8");
                }
                Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(batchBean);


                try {
                    oWfContext.getProcessDef(sFlowid);
                } catch (WorkflowRuntimeException e) {
                    oWfContext.close();
                    setErrGyoumukeyResult(sGyoumukey, pResponse, IwfMessageCd.IWF2022);
                    return pResponse;
                }
                IWorkflowToken oToken = Tokens.getActiveToken(iwfCoreDomManager, oWfContext, sGyoumukey, sFlowid);
                if(oToken == null){
                    oWfContext.close();
                    setErrGyoumukeyResult(sGyoumukey, pResponse, IwfMessageCd.IWF2025);
                    return pResponse;
                }
                if (isLockConfirm) {
                    if(!isValidLockKey(oToken, batchBean.getLockkey())){
                        oWfContext.close();
                        setErrGyoumukeyResult(sGyoumukey, pResponse, IwfMessageCd.IWF2021);
                        return pResponse;
                    }
                }


                String sSysDate = IwfDateUtils.getSysDate();

                WT_KouteiSummary wt_KouteiSummary = iwfCoreDomManager.getKouteiSummary(sGyoumukey);

                wt_KouteiSummary.setLastSyoriTime(sSysDate);
                IwfCommonLogic.setExtParams(wt_KouteiSummary, extParamMap);
                updater.add(wt_KouteiSummary);


                WT_KouteiRireki wt_KouteiRireki = new WT_KouteiRireki();
                wt_KouteiRireki.setTokenId(oToken.getId());
                wt_KouteiRireki.setSyoriTime(sSysDate);
                wt_KouteiRireki.setFlowId(sFlowid);
                wt_KouteiRireki.setGyoumuKey(sGyoumukey);
                wt_KouteiRireki.setNodeId(oToken.getNodeId());
                wt_KouteiRireki.setNodeNm(oToken.getNodeName());
                wt_KouteiRireki.setUserId(sAccountId);
                wt_KouteiRireki.setIwfSyoriKbn(C_IwfSyoriKbn.UPDATE);
                wt_KouteiRireki.setRrkMsg(C_IwfSyoriKbn.UPDATE.getContent());
                wt_KouteiRireki.setRirekiKbn(C_RirekiKbn.SYSTEM);
                wt_KouteiRireki.setExtInfo(oExtinfo);
                inserter.add(wt_KouteiRireki);
            }
            sGyoumukey = null;

            oWfContext.saveAndClose();

            IwfEditMessageUtil.setMsgResultOK(pResponse, "工程情報更新（バッチ用）");
            LOGGER.debug("[ReqId=" + sRequestId + "]工程情報更新（バッチ用）サービスが正常終了しました。");
        }
        catch (Exception e) {

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }
            LOGGER.error("想定外のエラーが発生しました。", e);
            setErrGyoumukeyResult(sGyoumukey, pResponse, IwfMessageCd.IWF0001, "工程情報更新（バッチ用）");

        } finally {
            if (oWfContext.isOpen()) {
                oWfContext.close();
            }
        }
        return pResponse;
    }

    private void setErrGyoumukeyResult(String pErrGyoumukey, WSExecProcessUpdateForBatchResponse pWSResponse, IwfMessageCd pIwfMsgCd, String ... pIwfMsgParam){
        IwfEditMessageUtil.setMsgResultNG(pWSResponse, pIwfMsgCd, pIwfMsgParam);
        pWSResponse.setErrGyoumukey(pErrGyoumukey);
    }

    public WSExecProcessUpdateForBatchResponse getBootErrResponse() {
        WSExecProcessUpdateForBatchResponse res = new WSExecProcessUpdateForBatchResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }
}

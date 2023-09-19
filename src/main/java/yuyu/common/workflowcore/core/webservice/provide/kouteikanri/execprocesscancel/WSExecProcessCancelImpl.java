package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel;

import static yuyu.common.workflowcore.core.iwfinfr.util.IwfLockUtils.*;

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
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic.Tokens;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_ProcessStatusKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WT_KouteiLock;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 工程中断サービスのプロバイダークラスです。</br>
 */
public class WSExecProcessCancelImpl implements WSExecProcessCancel {

    public static final String GENZAI_NODE_ID = "cancel";

    private static Logger oLogger_ = LoggerFactory.getLogger(WSExecProcessCancelImpl.class);
    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    public WSExecProcessCancelImpl()  {
        super();
    }


    public String getServiceName() {
        return WSExecProcessCancelRequest.sSERVICE_NAME;
    }


    public WSExecProcessCancelResponse validate(WSExecProcessCancelRequest poRequest) throws Exception {
        oLogger_.debug("│バリデーションチェック処理・・・");

        WSExecProcessCancelResponse oResponse = new WSExecProcessCancelResponse();

        String sGyoumuKey   = poRequest.getGyoumukey();
        String sFlowId      = poRequest.getFlowid();
        String sAccountId   = poRequest.getAccountid();
        String sLockkey     = poRequest.getLockkey();

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sGyoumuKey, "業務キー", 20)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sFlowId, "フローＩＤ", 19)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sAccountId, "アカウントＩＤ", 30)) {
            return oResponse;
        }
        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        if (bLockYouhi) {
            if (StringUtils.isEmpty(sLockkey)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse,
                    IwfMessageCd.IWF0002, "ロックキー");
            }
        }
        return oResponse;

    }


    @Override
    @Transactional
    public WSExecProcessCancelResponse executeBizMain(WSExecProcessCancelRequest poRequest) throws Exception {

        WSExecProcessCancelResponse oResponse = new WSExecProcessCancelResponse();

        oResponse = validate(poRequest);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String sGyoumuKey   = poRequest.getGyoumukey();
        String sFlowId      = poRequest.getFlowid();
        String sAccountId   = poRequest.getAccountid();
        byte[] oExtinfo     = null;
        if (poRequest.getExtinfo() != null) {

            oExtinfo = IwfBase64Urls.decodeToString(poRequest.getExtinfo()).getBytes("UTF-8");
        }
        String sRequestId   = poRequest.getRequestid();
        String sLockkey     = poRequest.getLockkey();

        oLogger_.debug("[ReqId="+ sRequestId + "]主処理を開始します。");

        IWorkflowContext oWfContext = WorkflowContextFactory.newInstance();

        boolean bWfCtxMustClose = false;

        try {
            oWfContext.open();
            bWfCtxMustClose = true;

            oLogger_.debug("[ReqId="+ sRequestId + "]トークンを取得します。");

            IWorkflowToken oToken = Tokens.getActiveToken(iwfCoreDomManager, oWfContext, sGyoumuKey, sFlowId);

            if(oToken == null){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2190);
                oLogger_.debug("[ReqId="+ sRequestId + "]指定されたフローID、業務キーに紐づくトークンは存在しない、または終了しています。[sFlowId=" + sFlowId  + ", sGyoumuKey=" + sGyoumuKey + "]");

                if(oWfContext.isOpen()) {
                    oWfContext.close();
                }

                return oResponse;
            }

            oLogger_.debug("[ReqId="+ sRequestId + "]排他チェックを実行します。");
            if(!isValidLockKey(oToken, sLockkey)){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2191);
                oLogger_.debug("[ReqId="+ sRequestId + "]ロックキーが無効です。他の作業者がロック中、またはロックが既に解除されています。");

                if(oWfContext.isOpen()) {
                    oWfContext.close();
                }

                return oResponse;
            }

            oLogger_.debug("[ReqId="+ sRequestId + "]トークンの更新を実行します。");
            Map<String, IWorkflowToken> map = oToken.getDescendants();
            for(IWorkflowToken descendant : map.values()){
                descendant.end();
            }
            oLogger_.debug("[ReqId="+ sRequestId + "]子孫トークンを終了しました。");
            oToken.end();
            oLogger_.debug("[ReqId="+ sRequestId + "]自トークンを終了しました。");

            String sSysDate = IwfDateUtils.getYYYYMMDD();

            oToken.setStringVariable(E_TokenVarKey.SYORI_STATUS.key,      C_ProcessStatusKbn.CANCELED.getValue());
            oToken.setStringVariable(E_TokenVarKey.KOUTEI_KANRYOUDAY.key, sSysDate);

            WT_KouteiLock lockInfo = iwfCoreDomManager.getKouteiLock(sFlowId, sGyoumuKey);
            if (null != lockInfo) {
                iwfCoreDomManager.delete(lockInfo);
            }

            IwfLockUtils.clearLockVariable(oToken);

            oLogger_.debug("[ReqId="+ sRequestId + "]工程履歴を作成します。");

            IwfCommonLogic.createKouteiRireki(sFlowId,
                oToken.getId(),
                sGyoumuKey,
                oToken.getNodeId(),
                oToken.getNodeName(),
                C_IwfSyoriKbn.PROCESSCANCEL,
                sAccountId,
                C_RirekiKbn.SYSTEM,
                oExtinfo,
                iwfCoreDomManager);

            IwfCommonLogic.updateKouteiSummary(sGyoumuKey,
                null,
                null,
                null,
                null,
                null,
                "",
                GENZAI_NODE_ID,
                null,
                null,
                oToken.getStringVariable(E_TokenVarKey.KOUTEI_KANRYOUDAY.key),
                oToken.getStringVariable(E_TokenVarKey.SYORI_STATUS.key),
                null,
                iwfCoreDomManager);

            IwfCommonLogic.clearGenzaiAccountid(sGyoumuKey, iwfCoreDomManager);

            oLogger_.debug("[ReqId="+ sRequestId + "]コンテキストをクローズします。");

            oWfContext.saveAndClose();
            bWfCtxMustClose = false;

            IwfEditMessageUtil.setMsgResultOK(oResponse, "工程中断");
        } catch (WorkflowRuntimeException wre) {

            if( !bWfCtxMustClose && !oWfContext.isOpen()){

                if(oWfContext.isOpen()) {
                    oWfContext.close();
                }
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0005);
            } else {
                if(oWfContext.isOpen()) {
                    oWfContext.close();
                }
                oLogger_.error("ワークフロー想定外エラーが発生しました。", wre);
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程中断");
            }
        }
        catch (Exception e) {

            if(oWfContext.isOpen()) {
                oWfContext.close();
            }
            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            oLogger_.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程中断");
        } finally {
            if(oWfContext.isOpen()){
                oWfContext.close();
            }
        }

        return oResponse;
    }


    public WSExecProcessCancelResponse getStubResult(WSExecProcessCancelRequest poRequest) throws Exception {

        return null;
    }


    public WSExecProcessCancelResponse getBootErrResponse() {
        WSExecProcessCancelResponse res = new WSExecProcessCancelResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}

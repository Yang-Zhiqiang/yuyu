package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward;

import static yuyu.common.workflowcore.core.iwfinfr.util.IwfLockUtils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfLockUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.enumerate.E_TokenVarKey;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_ProcessStatusKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_KouteiLock;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 強制工程遷移サービスのプロバイダークラスです。<br/>
 */
public class WSExecForceProcessForwardImpl implements  WSExecForceProcessForward {

    private static Logger oLogger_ = LoggerFactory.getLogger(WSExecForceProcessForwardImpl.class);
    @Inject
    private IwfCoreDomManager iwfCoreDomManager;
    public WSExecForceProcessForwardImpl()  {
        super();
    }

    public WSExecForceProcessForwardResponse validate(WSExecForceProcessForwardRequest poRequest) throws Exception {
        oLogger_.debug("│バリデーションチェック処理・・・");

        WSExecForceProcessForwardResponse oResponse = new WSExecForceProcessForwardResponse();

        String sGyoumuKey   = poRequest.getGyoumukey();
        String sFlowId      = poRequest.getFlowid();
        String sAccountId   = poRequest.getAccountid();
        String sSrcNodeName = poRequest.getSrcnodename();
        String sDstNodeName = poRequest.getDestnodename();
        String sLockKey     = poRequest.getLockkey();

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sGyoumuKey, "業務キー", 20)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sFlowId, "フローＩＤ", 19)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sAccountId, "アカウントＩＤ", 30)) {
            return oResponse;
        }
        if (StringUtils.isEmpty(sSrcNodeName)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "遷移元ノード名");
            return oResponse;
        }
        if (StringUtils.isEmpty(sDstNodeName)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "遷移先ノード名");
            return oResponse;
        }
        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        if (bLockYouhi) {
            if (StringUtils.isEmpty(sLockKey)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse,
                    IwfMessageCd.IWF0002, "ロックキー");
            }
        }
        return oResponse;

    }
    @Override
    @Transactional
    public WSExecForceProcessForwardResponse executeBizMain(WSExecForceProcessForwardRequest poRequest) throws Exception {

        String sRequestId   = poRequest.getRequestid();
        oLogger_.debug("[ReqId="+ sRequestId + "]主処理を開始します。");

        WSExecForceProcessForwardResponse oResponse = new WSExecForceProcessForwardResponse();

        oResponse = validate(poRequest);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String sGyoumuKey   = poRequest.getGyoumukey();
        String sFlowId      = poRequest.getFlowid();
        String sAccountId   = poRequest.getAccountid();
        String sSrcNodeName = poRequest.getSrcnodename();
        String sDstNodeName = poRequest.getDestnodename();
        String sLockKey     = poRequest.getLockkey();

        IWorkflowContext oWfContext = WorkflowContextFactory.newInstance();
        oWfContext.open();

        boolean bWfCtxMustClose = false;

        try {
            bWfCtxMustClose = true;

            IWorkflowProcessDef process =  oWfContext.getProcessDef(sFlowId);

            WT_GyoumuKey gyoumukey = iwfCoreDomManager.getGyoumuKey(sFlowId, sGyoumuKey);

            List<String> tokenIds = new ArrayList<String>();

            if(gyoumukey != null){
                tokenIds.add(gyoumukey.getTokenId());
            }

            IWorkflowToken oWfToken = null;
            for(String tokenid : tokenIds){
                String nodeName = process.getToken(tokenid).getNodeName();
                if(sSrcNodeName.equals(nodeName)){
                    oWfToken = process.getToken(tokenid);
                    break;
                }
            }
            if(oWfToken == null){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2170);
                oLogger_.debug("[ReqId="+ sRequestId + "] 指定された遷移元ノードには、トークンが存在しません。");
                return oResponse;
            }
            if(!oWfToken.isRootToken()){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2171);
                oLogger_.debug("[ReqId="+ sRequestId + "]指定された業務キーに紐づくトークンは、ルートトークンではありませんでした。");
                return oResponse;
            }
            if(!isValidLockKey(oWfToken, sLockKey)){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2172);
                oLogger_.debug("[ReqId="+ sRequestId + "]ロックキーが無効です。他の作業者がロック中、またはロックが既に解除されています。");
                return oResponse;
            }
            Map<String, IWorkflowToken> descendants =  oWfToken.getDescendants();
            for(String key : descendants.keySet()){
                descendants.get(key).end();
            }

            String sSrcNodeId = oWfToken.getNodeId();

            oWfToken.transfer(sSrcNodeName, sDstNodeName);

            if(oWfToken.hasEnded()){
                oWfToken.setStringVariable(E_TokenVarKey.SYORI_STATUS.key,      C_ProcessStatusKbn.COMPLETED.getValue());
                oWfToken.setStringVariable(IwfDateUtils.getYYYYMMDD(), E_TokenVarKey.KOUTEI_KANRYOUDAY.key);

                WT_KouteiLock lockInfo = iwfCoreDomManager.getKouteiLock(sFlowId, sGyoumuKey);
                if (null != lockInfo) {
                    iwfCoreDomManager.delete(lockInfo);
                }

                IwfLockUtils.clearLockVariable(oWfToken);
            }

            StringBuilder sb = new StringBuilder();
            sb.append(C_IwfSyoriKbn.FORCETRANSIT.getContent());
            sb.append(" ");
            sb.append("遷移元：");
            sb.append(sSrcNodeName);
            sb.append(" ");
            sb.append("遷移先：");
            sb.append(oWfToken.getNodeName());
            String sRirekimsg = sb.toString();

            IwfCommonLogic.createKouteiRireki(sFlowId,
                oWfToken.getId(),
                sGyoumuKey,
                sSrcNodeId,
                sSrcNodeName,
                C_IwfSyoriKbn.FORCETRANSIT,
                sAccountId,
                C_RirekiKbn.SYSTEM,
                sRirekimsg,
                null,
                iwfCoreDomManager);

            IwfCommonLogic.updateKouteiSummary(sGyoumuKey,
                sFlowId,
                null,
                sAccountId,
                sSrcNodeName,
                oWfContext.getProcessDef(sFlowId).getTasknodeLocalName(sSrcNodeName),
                "",
                oWfToken.getNodeName(),
                oWfContext.getProcessDef(sFlowId).getTasknodeLocalName(oWfToken.getNodeName()),
                oWfToken.getStringVariable(E_TokenVarKey.KOUTEI_KAISIDAY.key),
                oWfToken.getStringVariable(E_TokenVarKey.KOUTEI_KANRYOUDAY.key),
                oWfToken.getStringVariable(E_TokenVarKey.SYORI_STATUS.key),
                IwfCommonLogic.getExtParams(poRequest),
                iwfCoreDomManager);

            IwfCommonLogic.clearGenzaiAccountid(sGyoumuKey, iwfCoreDomManager);

            bWfCtxMustClose = false;
            oWfContext.saveAndClose();

            IwfEditMessageUtil.setMsgResultOK(oResponse, "強制工程遷移実行("+ sSrcNodeName + "-->"+ sDstNodeName +")");

            return oResponse;
        } catch (WorkflowRuntimeException wre) {

            iwfCoreDomManager.clear();

            if( !bWfCtxMustClose && !oWfContext.isOpen()){

                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0005);
            } else {
                oWfContext.close();
                oLogger_.error("ワークフロー想定外エラーが発生しました。", wre);
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "強制工程遷移");
            }
        } catch (Exception e) {

            iwfCoreDomManager.clear();
            oWfContext.close();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            oLogger_.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "強制工程遷移");
        } finally {
            if(oWfContext.isOpen()){
                oWfContext.close();
            }
        }
        oLogger_.debug("[ReqId="+ sRequestId + "]主処理を終了します。");
        return oResponse;
    }

    public WSExecForceProcessForwardResponse getStubResult(WSExecForceProcessForwardRequest poRequest) throws Exception {

        return null;
    }

    public WSExecForceProcessForwardResponse getBootErrResponse() {
        WSExecForceProcessForwardResponse res = new WSExecForceProcessForwardResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}

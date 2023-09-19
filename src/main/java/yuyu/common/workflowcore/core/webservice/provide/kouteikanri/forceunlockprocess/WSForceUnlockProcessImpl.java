package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess;

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
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfLockUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic.Tokens;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_UnlockResultKbn;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_KouteiLock;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 強制工程アンロックサービスのプロバイダークラスです。<br/>
 */
public class WSForceUnlockProcessImpl implements WSForceUnlockProcess {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private final static Logger LOGGER = LoggerFactory.getLogger(WSForceUnlockProcessImpl.class);

    private IWorkflowContext oWfCon_;

    public WSForceUnlockProcessImpl(){
        super();
    }

    public WSForceUnlockProcessResponse validate(WSForceUnlockProcessRequest request)
        throws Exception {
        WSForceUnlockProcessResponse oResponse = new WSForceUnlockProcessResponse();

        String sGyoumukey = request.getGyoumukey();
        String sFlowId = request.getFlowid();

        if (StringUtils.isEmpty(sGyoumukey)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "業務キー");
            return oResponse;
        }

        if (StringUtils.isEmpty(sFlowId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "フローＩＤ");
            return oResponse;
        }

        return oResponse;
    }

    public String getServiceName() {

        return WSForceUnlockProcessRequest.sSERVICE_NAME;
    }

    @Override
    @Transactional
    public WSForceUnlockProcessResponse executeBizMain(WSForceUnlockProcessRequest request)
        throws Exception {

        WSForceUnlockProcessResponse oResponse = new WSForceUnlockProcessResponse();

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        if(!bLockYouhi) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2203);
            return oResponse;
        }

        String sGyoumukey = request.getGyoumukey();
        String sFlowId = request.getFlowid();
        oWfCon_ = WorkflowContextFactory.newInstance();

        boolean bWFProgress = false;

        try {
            oWfCon_.open();
            bWFProgress = true;

            String sTokenId = _getTokenId(sGyoumukey, sFlowId);

            if (StringUtils.isEmpty(sTokenId)) {
                bWFProgress = false;
                if (oWfCon_.isOpen()) {
                    oWfCon_.close();
                }
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2200);
                return oResponse;
            }

            IWorkflowToken oToken = Tokens.getActiveToken(iwfCoreDomManager, oWfCon_, sGyoumukey, sFlowId);
            if (null == oToken) {
                if (oWfCon_.isOpen()) {
                    oWfCon_.close();
                }

                WT_KouteiLock lockInfo = iwfCoreDomManager.getKouteiLock(sFlowId, sGyoumukey);
                if (null != lockInfo) {
                    iwfCoreDomManager.delete(lockInfo);
                }

                IwfLockUtils.clearLockVariable(oToken);

                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2202);

                return oResponse;
            }

            C_UnlockResultKbn oUnlockResult = IwfLockUtils.forceUnlock(oToken);

            if (C_UnlockResultKbn.OK.eq(oUnlockResult)) {
                IwfEditMessageUtil.setMsgResultOK(oResponse, "強制工程アンロック");
                oWfCon_.saveAndClose();

                WT_KouteiLock lockInfo = iwfCoreDomManager.getKouteiLock(sFlowId, sGyoumukey);
                if (null != lockInfo) {
                    iwfCoreDomManager.delete(lockInfo);
                }

            } else if (C_UnlockResultKbn.NOLOCK.eq(oUnlockResult)) {
                IwfEditMessageUtil.setMsgResultWARN(oResponse, IwfMessageCd.IWF2201);
            } else {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "強制工程アンロック");
            }
        } catch (WorkflowRuntimeException wre) {

            if( !bWFProgress && !oWfCon_.isOpen()){

                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0005);
            } else {
                LOGGER.error("ワークフロー想定外エラーが発生しました。", wre);
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "強制工程アンロック");
            }
        } catch (Exception e) {

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "強制工程アンロック");
        } finally {
            if (oWfCon_.isOpen()) {
                oWfCon_.close();
            }
        }
        return oResponse;
    }
    public WSForceUnlockProcessResponse getStubResult(WSForceUnlockProcessRequest request)
        throws Exception {
        return null;
    }

    public WSForceUnlockProcessResponse getBootErrResponse() {
        WSForceUnlockProcessResponse res = new WSForceUnlockProcessResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }


    private String _getTokenId(final String psGyoumukey, final String psFlowId) throws Exception {

        WT_GyoumuKey wT_GyoumuKey = iwfCoreDomManager.getGyoumuKey(psFlowId, psGyoumukey);
        if (null != wT_GyoumuKey) {
            return wT_GyoumuKey.getTokenId();
        }
        return null;
    }
}

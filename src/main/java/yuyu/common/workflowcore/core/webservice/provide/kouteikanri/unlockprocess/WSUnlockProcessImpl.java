package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess;

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
 * 工程アンロックサービスのプロバイダークラスです。
 */
public class WSUnlockProcessImpl implements WSUnlockProcess {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    final static Logger LOGGER = LoggerFactory.getLogger(WSUnlockProcessImpl.class);

    private IWorkflowContext oWfCon_;

    public WSUnlockProcessImpl(){
        super();
    }

    public WSUnlockProcessResponse validate(WSUnlockProcessRequest request)
        throws Exception {
        WSUnlockProcessResponse oResponse = new WSUnlockProcessResponse();

        String sGyoumukey = request.getGyoumukey();
        String sFlowId = request.getFlowid();
        String sLockKey = request.getLockkey();

        if (StringUtils.isEmpty(sGyoumukey)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "業務キー");
            return oResponse;
        }

        if (StringUtils.isEmpty(sFlowId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "フローＩＤ");
            return oResponse;
        }

        if (StringUtils.isEmpty(sLockKey)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "ロックキー");
            return oResponse;
        }
        return oResponse;
    }

    public String getServiceName() {

        return WSUnlockProcessRequest.sSERVICE_NAME;
    }

    @Override
    @Transactional
    public WSUnlockProcessResponse executeBizMain(WSUnlockProcessRequest request)
        throws Exception {

        WSUnlockProcessResponse oResponse = new WSUnlockProcessResponse();

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        if(!bLockYouhi) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2104);
            return oResponse;
        }

        String sGyoumukey = request.getGyoumukey();
        String sFlowId = request.getFlowid();
        String sLockKey = request.getLockkey();

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
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2100);
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

                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2103);

                return oResponse;
            }

            C_UnlockResultKbn oUnlockResult = IwfLockUtils.setUnlock(oToken, sLockKey);

            if (C_UnlockResultKbn.OK.eq(oUnlockResult)) {
                IwfEditMessageUtil.setMsgResultOK(oResponse, "工程アンロック");
                oResponse.setGyoumukey(sGyoumukey);
                oWfCon_.saveAndClose();

                WT_KouteiLock lockInfo = iwfCoreDomManager.getKouteiLock(sFlowId, sGyoumukey);
                if (null != lockInfo) {
                    iwfCoreDomManager.delete(lockInfo);
                }

            } else if (C_UnlockResultKbn.NOLOCK.eq(oUnlockResult)) {
                IwfEditMessageUtil.setMsgResultWARN(oResponse, IwfMessageCd.IWF2101);
                oResponse.setGyoumukey(sGyoumukey);
            } else if (C_UnlockResultKbn.LOCK_KEY_ERR.eq(oUnlockResult)) {
                IwfEditMessageUtil.setMsgResultWARN(oResponse, IwfMessageCd.IWF2102);
                oResponse.setGyoumukey(sGyoumukey);
            } else {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程アンロック");
            }

            bWFProgress = false;
        } catch (WorkflowRuntimeException wre) {

            if( !bWFProgress && !oWfCon_.isOpen()){

                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0005);
            } else {
                LOGGER.error("ワークフロー想定外エラーが発生しました。", wre);
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程アンロック");
            }
        } catch (Exception e) {

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程アンロック");
        } finally {
            if (oWfCon_.isOpen()) {
                oWfCon_.close();
            }
        }
        return oResponse;
    }

    public WSUnlockProcessResponse getStubResult(WSUnlockProcessRequest request)
        throws Exception {
        return null;
    }

    public WSUnlockProcessResponse getBootErrResponse() {
        WSUnlockProcessResponse res = new WSUnlockProcessResponse();
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

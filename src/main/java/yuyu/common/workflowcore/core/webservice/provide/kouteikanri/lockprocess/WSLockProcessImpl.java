package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess;

import static yuyu.common.workflowcore.core.iwfinfr.util.enumerate.E_TokenVarKey.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.util.ExceptionUtil;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBTransactional;
import jp.co.slcs.swak.db.ExDBTransactional.TransactionalCode;

import org.apache.commons.lang.StringUtils;
import org.hibernate.StaleObjectStateException;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfLockUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic.Tokens;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_LockKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_KouteiLock;
import yuyu.def.db.id.PKWT_KouteiLock;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 工程ロックサービスメイン
 */
public class WSLockProcessImpl implements WSLockProcess {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    final static Logger LOGGER = LoggerFactory.getLogger(WSLockProcessImpl.class);

    private IWorkflowContext oWfCon_;

    WSLockProcessResponse oResponse = new WSLockProcessResponse();

    private String lockTime = StringUtils.EMPTY;

    public WSLockProcessImpl() {
        super();
    }

    public WSLockProcessResponse validate(WSLockProcessRequest request)
        throws Exception {

        String sGyoumukey = request.getGyoumukey();
        String sFlowId    = request.getFlowid();
        String sLockKey    = request.getLockkey();

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sGyoumukey, "業務キー", 20)) {
            return oResponse;
        }

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sFlowId, "フローＩＤ", 19)) {
            return oResponse;
        }

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sLockKey, "ロックキー", 30)) {
            return oResponse;
        }

        return oResponse;
    }

    public String getServiceName() {

        return WSLockProcessRequest.sSERVICE_NAME;
    }

    @Override
    public WSLockProcessResponse executeBizMain(final WSLockProcessRequest request)
        throws Exception {

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        if (!bLockYouhi) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2093);
            return oResponse;
        }

        try {
            ExDBTransactional.run
            (
                new TransactionalCode() {
                    @Override
                    public void accept(ExDBEntityManager entityManager){
                        bizMain(request, entityManager);
                    }
                }
                );
        }catch (Exception e) {
            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }
            if (!C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
                if (ExceptionUtil.contains(e, StaleObjectStateException.class)) {
                    LOGGER.debug(e.getMessage(), e);
                    IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2091, "工程ロック");
                } else {
                    LOGGER.error(e.getMessage(), e);
                    IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程ロック");
                }
            }
        }catch (Throwable t) {
            if (!C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
                LOGGER.error(t.getMessage(), t);
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程ロック");
            }
        }

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        return oResponse;
    }

    public void bizMain(WSLockProcessRequest request, ExDBEntityManager entityManager) throws RuntimeException{
        String sGyoumukey = request.getGyoumukey();
        String sLockKey = request.getLockkey();
        String sFlowId = request.getFlowid();
        String sAccountid = request.getAccountid();
        oWfCon_ = WorkflowContextFactory.newInstance();

        boolean bWFProgress = false;

        try {

            oWfCon_.open();
            bWFProgress = true;

            String sTokenId = _getTokenId(sGyoumukey, sFlowId);

            if (StringUtils.isEmpty(sTokenId)) {

                if(oWfCon_.isOpen()){
                    oWfCon_.close();
                }
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2090);

                return;
            }

            IWorkflowToken oToken = Tokens.getActiveToken(iwfCoreDomManager, oWfCon_, sGyoumukey, sFlowId);
            if(oToken == null) {
                if(oWfCon_.isOpen()){
                    oWfCon_.close();
                }

                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2092);

                return;
            }

            C_LockKbn oLockStatus =  IwfLockUtils.setLock(oToken, sLockKey);

            if (C_LockKbn.LOCK_OK.eq(oLockStatus)) {

                lockTime = oToken.getRootToken().getStringVariable(LOCK_TIME.key);

                IwfEditMessageUtil.setMsgResultOK(oResponse, "工程ロック");
                oResponse.setGyoumukey(sGyoumukey);


                PKWT_KouteiLock pkLock = new PKWT_KouteiLock(sFlowId, sGyoumukey);
                WT_KouteiLock lockInfo = entityManager.findByPK(pkLock);
                if (null != lockInfo) {
                    lockInfo.setLockTime(lockTime);
                    lockInfo.setLockKey(sLockKey);
                    lockInfo.setNodeNm(oToken.getNodeName());
                    lockInfo.setUserId(sAccountid);
                } else {
                    WT_KouteiLock kouteiLockInfo = new WT_KouteiLock();
                    kouteiLockInfo.setFlowId(sFlowId);
                    kouteiLockInfo.setGyoumuKey(sGyoumukey);
                    kouteiLockInfo.setLockKey(sLockKey);
                    kouteiLockInfo.setNodeNm(oToken.getNodeName());
                    kouteiLockInfo.setLockTime(lockTime);
                    kouteiLockInfo.setUserId(sAccountid);
                    entityManager.persist(kouteiLockInfo);
                }

            } else if (C_LockKbn.LOCK_OTHER.eq(oLockStatus)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2091);
                oResponse.setGyoumukey(sGyoumukey);  // いる？
            } else {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程ロック");
            }

        } catch (RuntimeException e) {
            LOGGER.info(e.getMessage(), e);

            if (e instanceof WorkflowRuntimeException) {
                if (!bWFProgress && !oWfCon_.isOpen()) {

                    IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0005);
                } else {
                    IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程ロック");
                }
            } else {
                if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                    throw e;
                }
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程ロック");
            }
            oWfCon_.rollbackAndClose();

        } catch(Exception e){
            LOGGER.info(e.getMessage(), e);

            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程ロック");

            oWfCon_.rollbackAndClose();
        } finally {
            if (oWfCon_.isOpen()) {
                oWfCon_.close();
            }
            oWfCon_.commitAndClose();
        }
    }

    private String _getTokenId(final String psGyoumukey, final String psFlowId) throws Exception {

        WT_GyoumuKey wT_GyoumuKey = iwfCoreDomManager.getGyoumuKey(psFlowId, psGyoumukey);
        if (null != wT_GyoumuKey) {
            return wT_GyoumuKey.getTokenId();
        }
        return null;
    }

    public WSLockProcessResponse getBootErrResponse() {
        WSLockProcessResponse res = new WSLockProcessResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}

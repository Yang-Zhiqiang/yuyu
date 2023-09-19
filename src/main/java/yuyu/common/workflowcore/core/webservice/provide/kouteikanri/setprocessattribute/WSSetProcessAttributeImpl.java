package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.setprocessattribute;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfLockUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.enumerate.E_TokenVarKey;
import yuyu.def.classification.C_LockKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_UnlockResultKbn;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 工程属性設定サービスメイン<br/>
 * 業務キー・フローＩＤからトークンを取得し、JSONデータをトークンに設定する
 */
public class WSSetProcessAttributeImpl implements WSSetProcessAttribute {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private IWorkflowContext oWfCon_;

    public WSSetProcessAttributeImpl() {
        super();
    }

    private String sFlowId_;
    public WSSetProcessAttributeResponse validate(
        WSSetProcessAttributeRequest request) throws Exception {

        WSSetProcessAttributeResponse oResponse = new WSSetProcessAttributeResponse();

        String sGyoumukey = request.getGyoumukey();
        String sFlowId = request.getFlowid();
        sFlowId_ = sFlowId;
        String sJSONObj = request.getJsondata();
        String sLockKey = request.getLockkey();

        if (StringUtils.isEmpty(sGyoumukey)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "業務キー");
        }

        if (StringUtils.isEmpty(sFlowId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "フローＩＤ");
        }

        if (StringUtils.isEmpty(sJSONObj)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "ＪＳＯＮオブジェクト");
        }

        if (StringUtils.isEmpty(sLockKey)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "ロックキー");
        }

        return oResponse;
    }

    public String getServiceName() {

        return WSSetProcessAttributeRequest.sSERVICE_NAME;
    }

    @Override
    public WSSetProcessAttributeResponse executeBizMain(
        WSSetProcessAttributeRequest request) throws Exception {

        WSSetProcessAttributeResponse oResponse = new WSSetProcessAttributeResponse();

        String sGyoumukey = request.getGyoumukey();
        String sFlowId    = request.getFlowid();
        String sJSONData   = request.getJsondata();
        String sLockKey = request.getLockkey();

        oWfCon_ = WorkflowContextFactory.newInstance();

        boolean bWFProgress = false;

        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();

        try {

            oWfCon_.open();
            bWFProgress = true;

            String sTokenId = _getTokenId(sGyoumukey, sFlowId);
            if (StringUtils.isEmpty(sTokenId)) {
                if(oWfCon_.isOpen()){
                    oWfCon_.close();
                }
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2122);
                return oResponse;
            }

            IWorkflowToken oToken = oWfCon_.getProcessDef(sFlowId_).getToken(sTokenId);
            if(oToken == null){
                if (oWfCon_.isOpen()) {
                    oWfCon_.close();
                }
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程属性設定");
                return oResponse;
            }

            C_LockKbn oLockStatus =  IwfLockUtils.setLock(oToken, sLockKey);

            if (C_LockKbn.LOCK_OTHER.eq(oLockStatus)) {
                if (bLockYouhi) {
                    IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2120);
                    oWfCon_.close();
                    return oResponse;
                } else {
                    IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2121);
                    oWfCon_.close();
                    return oResponse;
                }
            } else if (C_LockKbn.LOCK_NG.eq(oLockStatus)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程属性設定");
                oWfCon_.close();
                return oResponse;
            }

            oToken.setStringVariable(E_TokenVarKey.JSON_OBJECT.key, sJSONData);

            C_UnlockResultKbn oUnlockResult = IwfLockUtils.setUnlock(oToken, sLockKey);

            if(!C_UnlockResultKbn.OK.eq(oUnlockResult)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程属性設定");
                oWfCon_.close();
                return oResponse;
            }

        } catch (WorkflowRuntimeException wre) {
            wre.printStackTrace();

            if( !bWFProgress && !oWfCon_.isOpen()){

                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0005);
            } else {
                if (oWfCon_.isOpen()) {
                    oWfCon_.close();
                }
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程属性設定");
            }
        } catch (Exception e) {
            e.printStackTrace();

            if (oWfCon_.isOpen()) {
                oWfCon_.close();
            }

            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001,  "工程属性設定");
        } finally {
            if(oWfCon_.isOpen()){
                oWfCon_.close();
            }
        }
        return oResponse;
    }
    public WSSetProcessAttributeResponse getStubResult(
        WSSetProcessAttributeRequest request) throws Exception {
        return null;
    }
    public WSSetProcessAttributeResponse getBootErrResponse() {
        WSSetProcessAttributeResponse res = new WSSetProcessAttributeResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

    private String _getTokenId(final String psGyoumukey, final String psFlowId) throws Exception {

        String sReturn = null;
        WT_GyoumuKey wT_GyoumuKey = iwfCoreDomManager.getGyoumuKey(psFlowId, psGyoumukey);
        if (null != wT_GyoumuKey) {
            sReturn = wT_GyoumuKey.getTokenId();
        }
        return sReturn;
    }

}

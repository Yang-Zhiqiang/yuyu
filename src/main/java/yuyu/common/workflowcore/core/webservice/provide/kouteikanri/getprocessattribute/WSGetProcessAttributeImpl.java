package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessattribute;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.enumerate.E_TokenVarKey;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 工程属性取得サービスのプロバイダークラスです。<br/>
 * 業務キー･フローＩＤからトークンを取得し、工程属性情報を取得する
 */
public class WSGetProcessAttributeImpl implements WSGetProcessAttribute {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(WSGetProcessAttributeImpl.class);

    private IWorkflowContext oWfCon_;

    private final String sJSON_DATA = E_TokenVarKey.JSON_OBJECT.toString();

    public WSGetProcessAttributeImpl() {
        super();
    }

    public WSGetProcessAttributeResponse validate(
        WSGetProcessAttributeRequest request) throws Exception {

        WSGetProcessAttributeResponse oResponse = new WSGetProcessAttributeResponse();

        String sGyoumukey = request.getGyoumukey();
        String sFlowId  = request.getFlowid();

        if (StringUtils.isEmpty(sGyoumukey)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "業務キー");
        }

        if (StringUtils.isEmpty(sFlowId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "フローＩＤ");
        }
        return oResponse;
    }

    public String getServiceName() {

        return WSGetProcessAttributeRequest.sSERVICE_NAME;
    }

    private String sFlowId_;

    @Override
    @Transactional
    public WSGetProcessAttributeResponse executeBizMain(
        WSGetProcessAttributeRequest request) throws Exception {

        WSGetProcessAttributeResponse oResponse = new WSGetProcessAttributeResponse();

        String sGyoumukey = request.getGyoumukey();
        String sFlowId = request.getFlowid();
        sFlowId_ = sFlowId;
        @SuppressWarnings("unused")
        String sRequestId = request.getRequestid();
        oWfCon_ = WorkflowContextFactory.newInstance();

        try {

            oWfCon_.open();

            LOGGER.debug("業務キー・フローＩＤからトークンIDを取得");
            String sTokenId = _getTokenId(sGyoumukey, sFlowId);

            if (StringUtils.isEmpty(sTokenId)) {

                if(oWfCon_.isOpen()){
                    oWfCon_.close();
                }
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001 , "工程属性取得");
                return oResponse;
            }

            LOGGER.debug("トークンIDからJSONオブジェクト取得");
            String sJSONResult = _getJSONData(sTokenId);

            if (StringUtils.isEmpty(sJSONResult)) {
                LOGGER.debug("ＳＯＮオブジェクトが空でした。");
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程属性取得");
                return oResponse;
            }

            IwfEditMessageUtil.setMsgResultOK(oResponse, "工程属性取得");
            oResponse.setJsonstrings(sJSONResult);

        } catch (Exception oEx) {

            LOGGER.debug("想定外のエラーが発生しました。", oEx);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程属性取得");

        } finally {
            if(oWfCon_.isOpen()){
                oWfCon_.close();
            }
        }
        return oResponse;
    }

    public WSGetProcessAttributeResponse getStubResult(
        WSGetProcessAttributeRequest request) throws Exception {
        return null;
    }

    private String _getTokenId(final String psGyoumukey, final String psFlowId) throws Exception {

        String sTokenId = null;
        WT_GyoumuKey wT_GyoumuKey = iwfCoreDomManager.getGyoumuKey(psFlowId, psGyoumukey);
        if (null != wT_GyoumuKey) {
            sTokenId = wT_GyoumuKey.getTokenId();
        }

        return sTokenId;

    }
    public WSGetProcessAttributeResponse getBootErrResponse() {
        WSGetProcessAttributeResponse res = new WSGetProcessAttributeResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

    private String _getJSONData(final String pstokenId) throws Exception {

        IWorkflowToken oToken = oWfCon_.getProcessDef(sFlowId_).getToken(pstokenId);
        if (oToken == null) {
            return null;
        }

        String oRes = oToken.getStringVariable(sJSON_DATA);

        if (oRes != null) {
            return oRes;
        } else {
            return null;
        }
    }

}

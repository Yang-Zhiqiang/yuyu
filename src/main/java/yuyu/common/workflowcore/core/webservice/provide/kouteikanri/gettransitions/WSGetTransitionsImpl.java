package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettransitions;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 分岐先取得サービスのプロバイダークラスです。<br/>
 * 指定されたノードの分岐先を取得する。
 */
public class WSGetTransitionsImpl implements WSGetTransitions {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;
    final static Logger LOGGER = LoggerFactory.getLogger(WSGetTransitionsImpl.class);

    public WSGetTransitionsImpl() {
        super();
    }

    public WSGetTransitionsResponse validate(
        WSGetTransitionsRequest request) throws Exception {

        WSGetTransitionsResponse oResponse = new WSGetTransitionsResponse();

        String sFlowId    = request.getFlowid();
        String sNodename  = request.getNodename();

        if (StringUtils.isEmpty(sFlowId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "フローＩＤ");
        }
        if (StringUtils.isEmpty(sNodename)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "ノード名");
        }

        return oResponse;
    }

    @Override
    public WSGetTransitionsResponse executeBizMain(
        WSGetTransitionsRequest poRequest) throws Exception {

        String sRequestId   = poRequest.getRequestid();

        LOGGER.debug("[ReqId="+ sRequestId + "]主処理を開始します。");


        WSGetTransitionsResponse oResponse = new WSGetTransitionsResponse();

        IWorkflowContext oWFCtx = null;
        try {

            String sFlowId    = poRequest.getFlowid();
            String sNodename  = poRequest.getNodename();


            oWFCtx = WorkflowContextFactory.newInstance();
            oWFCtx.open();

            List<String> transitions = oWFCtx.getProcessDef(sFlowId).getTransitions(sNodename);

            oResponse.setDestnodes(transitions.toArray(new String[]{}));
            IwfEditMessageUtil.setMsgResultOK(oResponse, "分岐先取得");

        } catch (Exception e) {
            LOGGER.debug("[ReqId="+ sRequestId + "]想定外のエラーが発生しました。");
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "分岐先取得");
            return oResponse;
        }finally{
            if(oWFCtx != null){
                oWFCtx.close();
            }
        }
        LOGGER.debug("[ReqId="+ sRequestId + "]主処理を終了します。");
        return oResponse;
    }
    public WSGetTransitionsResponse getStubResult(
        WSGetTransitionsRequest request) throws Exception {
        return null;
    }

    public String getServiceName() {
        return WSGetTransitionsRequest.sSERVICE_NAME;
    }

    public WSGetTransitionsResponse getBootErrResponse() {
        WSGetTransitionsResponse res = new WSGetTransitionsResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}

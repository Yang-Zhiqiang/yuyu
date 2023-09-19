package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessinfo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowTask;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 工程情報取得サービスのプロバイダークラスです。<br />
 */
public class WSGetProcessInfoImpl implements WSGetProcessInfo {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private static final Logger logger = LoggerFactory.getLogger(WSGetProcessInfoImpl.class);

    public WSGetProcessInfoImpl() {
        super();
    }

    public WSGetProcessInfoResponse validate(WSGetProcessInfoRequest request)
        throws Exception {

        logger.debug("│バリデーションチェック処理・・・");

        WSGetProcessInfoResponse oResponse = new WSGetProcessInfoResponse();

        String[] sGyoumuKeys = request.getGyoumukeys();
        String   sFlowId = request.getFlowid();

        if (sGyoumuKeys == null) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "業務キー");
        }
        if (StringUtils.isEmpty(sFlowId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "フローＩＤ");
        }
        return oResponse;
    }

    public String getServiceName() {
        return WSGetProcessInfoRequest.sSERVICE_NAME;
    }

    @Override
    public WSGetProcessInfoResponse executeBizMain(
        WSGetProcessInfoRequest request) throws Exception {

        logger.debug("│主処理開始・・・");
        WSGetProcessInfoResponse oResponse = new WSGetProcessInfoResponse();

        String[] sGyoumuKeys = request.getGyoumukeys();
        String   sFlowId = request.getFlowid();

        IWorkflowContext oWfCon = WorkflowContextFactory.newInstance();

        ArrayList<String>   oNodeList     = new ArrayList<String>();
        ArrayList<String[]> oGroupIdList  = new ArrayList<String[]>();
        ArrayList<String>   oTaskWariList = new ArrayList<String>();

        try {
            oWfCon.open();

            for (String sKey : sGyoumuKeys) {

                logger.debug("| 業務キー : "+ sKey + " | フローID : "+ sFlowId);

                if (StringUtils.isNotBlank(sKey) && StringUtils.isNotBlank(sFlowId)) {
                } else {
                    oNodeList.add(null);
                    oTaskWariList.add(null);
                    oGroupIdList.add(null);

                    continue;
                }

                String sTokenId = _getTokenId(sKey, sFlowId);

                if (sTokenId == null) {
                    oNodeList.add(null);
                    oTaskWariList.add(null);
                    oGroupIdList.add(null);

                    continue;
                }

                IWorkflowToken token = oWfCon.getProcessDef(sFlowId).getToken(sTokenId);

                String sNodeName = token.getNodeName();

                List<IWorkflowTask> oTask = oWfCon.getProcessDef(sFlowId).getToken(sTokenId).getTasks();

                String sTmpWari = null;
                String[] sTmpGroup = null;
                for (IWorkflowTask oTaskInfo : oTask) {
                    sTmpWari = oTaskInfo.getUserId();
                    sTmpGroup = oTaskInfo.getUserGroup();

                    if (StringUtils.isBlank(sTmpWari)) {
                        sTmpWari = null;
                    }
                    if (sTmpGroup != null && sTmpGroup.length > 0) {
                    } else {
                        sTmpGroup = null;
                    }

                    break;
                }
                oNodeList.add(sNodeName);
                oTaskWariList.add(sTmpWari);
                oGroupIdList.add(sTmpGroup);
            }

            oResponse.setNodenames(oNodeList);
            oResponse.setWariateuserid(oTaskWariList);
            oResponse.setWaritategroupids(oGroupIdList);

            IwfEditMessageUtil.setMsgResultOK(oResponse, "工程情報取得");

            oWfCon.close();
        } catch (Exception e) {

            logger.error("想定外のエラーが発生しました。", e);

            if(oWfCon.isOpen()){
                oWfCon.close();
            }

            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程情報取得");

        } finally {
            if(oWfCon.isOpen()){
                oWfCon.close();
            }
        }
        return oResponse;
    }

    public WSGetProcessInfoResponse getStubResult(
        WSGetProcessInfoRequest request) throws Exception {

        return null;
    }

    public WSGetProcessInfoResponse getBootErrResponse() {
        WSGetProcessInfoResponse res = new WSGetProcessInfoResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

    private String _getTokenId(final String psGyoumuKey, final String psFlowId) throws Exception {

        String sReturn = null;
        WT_GyoumuKey wT_GyoumuKey = iwfCoreDomManager.getGyoumuKey(psFlowId, psGyoumuKey);
        if (null != wT_GyoumuKey) {
            sReturn = wT_GyoumuKey.getTokenId();
        }

        logger.debug("| 取得TokenID : " + sReturn);
        return sReturn;
    }
}
package yuyu.common.workflowcore.core.webservice.provide.accountkanri.gettaskauthinfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef.TaskDefMapKey;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_KengenKoutei;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * タスク権限情報取得サービスのプロバイダークラスです。<br/>
 *
 * あるタスクの実行権限を持つロールコードを取得します。<Br/>
 *
 */
public class WSGetTaskAuthInfoImpl implements WSGetTaskAuthInfo {

    private final static Logger LOGGER = LoggerFactory.getLogger(WSGetTaskAuthInfoImpl.class);

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;


    public String getServiceName() {
        return WSGetTaskAuthInfoRequest.sSERVICE_NAME;
    }


    public WSGetTaskAuthInfoResponse validate(WSGetTaskAuthInfoRequest poRequest)
        throws Exception {

        LOGGER.debug("│バリデーションチェック処理・・・");

        WSGetTaskAuthInfoResponse oWSResponse = new WSGetTaskAuthInfoResponse();


        if(StringUtils.isEmpty(poRequest.getFlowid())){
            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0002, "フローＩＤ");
        }
        if(StringUtils.isEmpty(poRequest.getTaskname())){
            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0002, "タスク名");
        }

        return oWSResponse;
    }

    @Override
    public WSGetTaskAuthInfoResponse executeBizMain(
        WSGetTaskAuthInfoRequest poRequest) throws Exception {

        LOGGER.debug("│主処理開始・・・");

        WSGetTaskAuthInfoResponse oWSResponse = new WSGetTaskAuthInfoResponse();

        String sFlowid = poRequest.getFlowid();
        String sTaskname = poRequest.getTaskname();
        String sRequestid = poRequest.getRequestid();

        LOGGER.debug("フローID：" + sFlowid);
        LOGGER.debug("タスク名：" + sTaskname);
        LOGGER.debug("リクエストＩＤ：" + sRequestid);

        IWorkflowContext oWfCtx = WorkflowContextFactory.newInstance();

        try {

            oWfCtx.open();

            try {
                oWfCtx.getProcessDef(sFlowid);
            }
            catch (WorkflowRuntimeException e) {
                IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001);
                LOGGER.error("プロセス定義が取得できませんでした。");

                return oWSResponse;
            }

            List<String> taskNames = new ArrayList<String>();
            for (Map<String, String> taskdefsMap : oWfCtx.getProcessDef(sFlowid).getTaskDefs()) {
                taskNames.add(taskdefsMap.get(TaskDefMapKey.sTASKNAME));
            }

            if(!taskNames.contains(sTaskname)) {
                IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001);
                LOGGER.error("指定されたタスク名はフローに定義されていません。");
                return oWSResponse;
            }


            List<WT_KengenKoutei> kouteiList = iwfCoreDomManager.getKengenKouteisByFlowIdNodeId(sFlowid,sTaskname);

            Iterator<WT_KengenKoutei> itrKoutei = kouteiList.iterator();

            List<String> kengenList = new ArrayList<String>();

            if(!itrKoutei.hasNext()) {
                LOGGER.debug("権限工程レコードを取得できませんでした。");
                oWSResponse.setAuthids(new String[0]);
            }
            else {
                LOGGER.debug("権限工程レコードを取得しました。");
                while(itrKoutei.hasNext()){
                    WT_KengenKoutei koutei = itrKoutei.next();

                    LOGGER.debug("ロールコード：" + koutei.getRoleCd());
                    kengenList.add(koutei.getRoleCd());
                }

                String[] kengenIds = kengenList.toArray(new String[0]);

                oWSResponse.setAuthids(kengenIds);
            }

            IwfEditMessageUtil.setMsgResultOK(oWSResponse, "タスク権限情報取得");

            return oWSResponse;
        }
        catch (Exception e) {

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("タスク権限情報取得サービス実行中にエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "タスク権限情報取得");

            return oWSResponse;
        }
        finally {
            if(oWfCtx.isOpen()){
                oWfCtx.close();
            }
        }
    }


    public WSGetTaskAuthInfoResponse getBootErrResponse() {
        WSGetTaskAuthInfoResponse res = new WSGetTaskAuthInfoResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }


    public WSGetTaskAuthInfoResponse getStubResult(
        WSGetTaskAuthInfoRequest request) throws Exception {
        return null;
    }

}

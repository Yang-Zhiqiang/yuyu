package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.exception.CoreRuntimeException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowTask;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_TaskKbn;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.google.common.collect.Collections2;

/**
 * タスク一覧取得サービスメイン<br />
 * フローID、ノード名、タスク区分を指定して、業務キーの一覧を取得する。
 */
public class WSGetTasksImpl implements WSGetTasks {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private final static Logger LOGGER = LoggerFactory.getLogger(WSGetTasksImpl.class);

    public WSGetTasksImpl() {
        super();
    }

    public WSGetTasksResponse validate(
        WSGetTasksRequest request) throws Exception {

        WSGetTasksResponse oResponse = new WSGetTasksResponse();

        String sFlowId    = request.getFlowid();
        String sNodename  = request.getNodename();
        String sAccountId = request.getAccountid();
        String sTaskkbn   = request.getTaskkbn();

        if (StringUtils.isEmpty(sFlowId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "フローＩＤ");
            return oResponse;
        }
        if (StringUtils.isEmpty(sNodename)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "ノード名");
            return oResponse;
        }
        if (StringUtils.isEmpty(sAccountId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "アカウントＩＤ");
            return oResponse;
        }

        if(!StringUtils.isEmpty(sTaskkbn)){
            try {
                C_TaskKbn.valueOf(sTaskkbn);
            } catch (CoreRuntimeException e) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0006, "タスク区分");
            }
        }

        return oResponse;
    }

    @Override
    public WSGetTasksResponse executeBizMain(
        WSGetTasksRequest request) throws Exception {

        WSGetTasksResponse oResponse = new WSGetTasksResponse();

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        IWorkflowContext oWFCtx = WorkflowContextFactory.newInstance();
        String sAccountId = request.getAccountid();
        String sTaskKbn   = request.getTaskkbn();
        String sFlowId    = request.getFlowid();
        String sNodename  = request.getNodename();
        Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(request);

        try {

            LOGGER.trace("対象となりうるタスクをすべて取得");

            oWFCtx.open();

            LOGGER.trace("プロセス定義存在チェック");

            try {
                oWFCtx.getProcessDef(request.getFlowid());
            } catch (WorkflowRuntimeException e) {
                if(oWFCtx.isOpen()){
                    oWFCtx.close();
                }

                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2141);

                return oResponse;
            }

            LOGGER.debug("対象トークンのノード実行権限をチェックする。FlowId, NodeName, AccountId = " + sFlowId + ", " + sNodename + ", " + sAccountId);
            if(IwfCommonLogic.isNotExistKengen(iwfCoreDomManager, oResponse, sFlowId, sAccountId, sNodename)){
                if(oWFCtx.isOpen()){
                    oWFCtx.close();
                }
                LOGGER.info("タスクの実行権限がありません。");
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2142);
                return oResponse;
            }

            List<String> gyoumuKeys = new ArrayList<String>();
            List<IWorkflowTask> tasks = oWFCtx.getTasks(sFlowId, sNodename);

            if(!tasks.isEmpty()){
                LOGGER.trace("取得したタスクをアカウントID、タスク区分にて絞込み");

                Collection<IWorkflowTask> filteredTasks =
                    Collections2.filter(tasks,CommonGetTasks.checkCondition(sAccountId, sTaskKbn));

                for( IWorkflowTask task : filteredTasks){
                    String gyoumukey = CommonGetTasks.getGyoumuKey(task.getRootTokenId(), extParamMap, iwfCoreDomManager);
                    if (StringUtils.isNotEmpty(gyoumukey)) {
                        gyoumuKeys.add(gyoumukey);
                    }
                }

            }


            IwfEditMessageUtil.setMsgResultOK(oResponse, "タスク一覧取得");

            oResponse.setGyoumukeys(gyoumuKeys.toArray(new String[]{}));

        } catch (WorkflowRuntimeException e) {

            LOGGER.error("ワークフロー実行時にエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "タスク一覧取得");
            return oResponse;

        } catch (Exception e) {

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "タスク一覧取得");
            return oResponse;
        } finally {
            if(oWFCtx.isOpen()){
                oWFCtx.close();
            }
        }
        return oResponse;
    }

    public WSGetTasksResponse getStubResult(
        WSGetTasksRequest request) throws Exception {
        return null;
    }

    public String getServiceName() {
        return WSGetTasksRequest.sSERVICE_NAME;
    }

    public WSGetTasksResponse getBootErrResponse() {
        WSGetTasksResponse res = new WSGetTasksResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}

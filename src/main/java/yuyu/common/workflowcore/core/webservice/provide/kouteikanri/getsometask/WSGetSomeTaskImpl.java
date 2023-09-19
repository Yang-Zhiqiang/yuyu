package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask;

import static com.google.common.base.Predicates.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.exception.CoreRuntimeException;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowTask;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_TaskKbn;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.google.common.collect.Collections2;
/**
 * 単一タスク取得サービスのプロバイダークラスです。<br/>
 * フローID、ノード名、タスク区分を指定して、合致する業務キーのうち、いずれか一つを返却する。<br/>
 * 条件に合致する業務キーが複数ある場合は、返却する業務キーの優先度をつける。直前に返却した業務キーほど優先度が低くなる。
 */
public class WSGetSomeTaskImpl implements WSGetSomeTask {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    public WSGetSomeTaskImpl() {
        super();
    }

    public WSGetSomeTaskResponse validate(
        WSGetSomeTaskRequest request) throws Exception {

        WSGetSomeTaskResponse oResponse = new WSGetSomeTaskResponse();

        String sFlowId    = request.getFlowid();
        String sNodename  = request.getNodename();
        String sTaskkbn   = request.getTaskkbn();
        String sRequestid = request.getRequestid();

        if (StringUtils.isEmpty(sFlowId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "フローＩＤ");
        }
        if (StringUtils.isEmpty(sNodename)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "ノード名");
        }
        if (StringUtils.isEmpty(sRequestid)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "リクエストID");
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
    @Transactional
    public WSGetSomeTaskResponse executeBizMain(
        WSGetSomeTaskRequest request) throws Exception {

        WSGetSomeTaskResponse oResponse = new WSGetSomeTaskResponse();

        IWorkflowContext oWFCtx = null;

        try {


            oWFCtx = WorkflowContextFactory.newInstance();
            oWFCtx.open();

            List<IWorkflowTask> tasks = CommonGetSomeTask.getTasks(oWFCtx, request.getFlowid(), request.getNodename());
            if(tasks.isEmpty()){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2150);
                return oResponse;
            }


            String sAccountId = request.getAccountid();
            String sTaskKbn   = request.getTaskkbn();

            Collection<IWorkflowTask> filteredtasks =
                Collections2.filter(tasks, and(
                    CommonGetSomeTask.asSameAccountAs(sAccountId, baseDomManager),
                    CommonGetSomeTask.asSameTaskKbnAs(sTaskKbn)));

            if(filteredtasks.isEmpty()){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2150);
                return oResponse;
            }

            List<String> gyoumuKeys = new ArrayList<String>();
            for( IWorkflowTask task : filteredtasks){
                String gyoumukey = CommonGetSomeTask.getGyoumuKey(task.getRootTokenId(), iwfCoreDomManager);
                gyoumuKeys.add(gyoumukey);
            }


            Collections.shuffle(gyoumuKeys);

            String first  = gyoumuKeys.get(0);
            String second = null;
            if(gyoumuKeys.size() > 1){
                second = gyoumuKeys.get(1);
            }
            String gyoumukey = null;
            if(second == null){
                gyoumukey = first;
            }
            else{
                String zenkai = GyoumukeyHistory.getInstance().getFirst();
                if(first.equals(zenkai)){
                    gyoumukey = second;
                }else{
                    gyoumukey = first;
                }
            }

            GyoumukeyHistory.getInstance().add(gyoumukey);


            IwfEditMessageUtil.setMsgResultOK(oResponse, "単一タスク取得");

            oResponse.setGyoumukey(gyoumukey);

        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "単一タスク取得");
            return oResponse;
        }finally{
            if(oWFCtx != null){
                oWFCtx.close();
            }
            iwfCoreDomManager.clear();
        }
        return oResponse;
    }

    public WSGetSomeTaskResponse getStubResult(
        WSGetSomeTaskRequest request) throws Exception {
        return null;
    }
    public String getServiceName() {
        return WSGetSomeTaskRequest.sSERVICE_NAME;
    }
    public WSGetSomeTaskResponse getBootErrResponse() {
        WSGetSomeTaskResponse res = new WSGetSomeTaskResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}

package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowTask;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.def.classification.C_TaskKbn;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.google.common.base.Predicate;

/**
 * タスク一覧取得サービスメイン<br/>
 * フローID、ノード名、タスク区分を指定して、合致する業務キーのうち、いずれか一つを返却する。
 * 条件に合致する業務キーが複数ある場合は、返却する業務キーの優先度をつける。直前に返却した業務キーほど優先度が低くなる。
 */
public class CommonGetTasks {

    private CommonGetTasks(){}

    static String getGyoumuKey(Long tokenid, Map<String, WSExtParam> extParamMap, IwfCoreDomManager iwfCoreDomManager){

        List<WT_GyoumuKey> wtGyoumukeys = iwfCoreDomManager.getGyoumuKeys(null, String.valueOf(tokenid));

        if(null != wtGyoumukeys && !(wtGyoumukeys.isEmpty())){

            List<WT_KouteiSummary> wtKouteiSummarys = iwfCoreDomManager.getKouteiSummarys(new String[] { wtGyoumukeys
                .get(0).getGyoumuKey() }, null, null, null, null, null, null, null, null, null, null, null,
                extParamMap);

            if(null != wtKouteiSummarys && !(wtKouteiSummarys.isEmpty())){
                return wtKouteiSummarys.get(0).getGyoumuKey();
            }
        }

        return null;
    }

    static List<IWorkflowTask> getTasks(IWorkflowContext oWfCtx, String flowid, String nodename){
        List<IWorkflowTask> tasks = new ArrayList<IWorkflowTask>();
        List<IWorkflowToken> oTokens = oWfCtx.getProcessDef(flowid).getTokensByNodeName(nodename);

        if(oTokens.isEmpty()){
            return tasks;
        }
        for(IWorkflowToken token : oTokens){
            List<IWorkflowTask> t =  oWfCtx.getProcessDef(flowid).getToken(token.getId()).getTasks();

            if(t.size() > 0){
                tasks.addAll(t);
            }
        }
        return tasks;

    }

    static Predicate<IWorkflowTask> checkCondition(final String accountId, final String conditionTaskkbn) {

        Predicate<IWorkflowTask>  predicateResult = new Predicate<IWorkflowTask>(){
            @Override
            public boolean apply(IWorkflowTask tasks) {

                if (StringUtils.isEmpty(conditionTaskkbn)) {
                    return false;
                }

                if(C_TaskKbn.KOJIN.eq(C_TaskKbn.valueOf(conditionTaskkbn))){
                    if(accountId.equals(tasks.getUserId())){
                        return true;
                    }else{
                        return false;
                    }
                }
                else if(C_TaskKbn.KYOUYUU.eq(C_TaskKbn.valueOf(conditionTaskkbn))){
                    if(tasks.assigned()){
                        return false;
                    }else{
                        return true;
                    }
                }
                return false;
            }
        };


        return predicateResult;
    }

}

package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowTask;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_TaskKbn;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

/**
 * 単一タスク取得サービスメインです。<br/>
 * フローID、ノード名、タスク区分を指定して、合致する業務キーのうち、いずれか一つを返却する。
 * 条件に合致する業務キーが複数ある場合は、返却する業務キーの優先度をつける。直前に返却した業務キーほど優先度が低くなる。
 */
public class CommonGetSomeTask {

    private CommonGetSomeTask(){}

    static String getGyoumuKey(Long tokenid, IwfCoreDomManager iwfCoreDomManager){
        List<WT_GyoumuKey> wtGyoumukeys = iwfCoreDomManager.getGyoumuKeysByTokenId(String.valueOf(tokenid));
        return wtGyoumukeys.get(0).getGyoumuKey();
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

    static Predicate<IWorkflowTask> asSameTaskKbnAs(final String conditionTaskkbn) {
        Predicate<IWorkflowTask>  predicateTaskkbn = null;

        if(StringUtils.isEmpty(conditionTaskkbn)){
            predicateTaskkbn = Predicates.alwaysTrue();
        }else{
            predicateTaskkbn = new Predicate<IWorkflowTask>(){
                @Override
                public boolean apply(IWorkflowTask tasks) {

                    if(C_TaskKbn.KOJIN.eq(C_TaskKbn.valueOf(conditionTaskkbn))){
                        if(tasks.assigned()){
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
        }
        return predicateTaskkbn;
    }

    static Predicate<IWorkflowTask> asSameAccountAs(String accountId, BaseDomManager baseDomManager) {

        Predicate<IWorkflowTask>  predicateAccount = null;
        if(StringUtils.isNotEmpty(accountId)){

            final List<String> roles = new ArrayList<String>();
            List<AT_UserRole> userRoles = baseDomManager.getUser(accountId).getUserRoles();

            for(AT_UserRole bean : userRoles){
                roles.add(bean.getRoleCd());
            }

            predicateAccount = new Predicate<IWorkflowTask>(){
                @Override
                public boolean apply(IWorkflowTask token) {
                    String[] availableKengens = token.getUserGroup();
                    for(String kengen : availableKengens){
                        if(roles.contains(kengen)){
                            return true;
                        }
                    }
                    return false;
                }
            };
        }
        return predicateAccount;
    }

}

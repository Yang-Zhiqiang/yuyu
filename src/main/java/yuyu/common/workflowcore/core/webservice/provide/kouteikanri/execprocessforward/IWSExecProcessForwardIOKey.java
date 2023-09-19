package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward;

/**
 * 工程遷移WEBサービスの入出力パラメータキーです。
 */
public interface IWSExecProcessForwardIOKey {

    interface IN {
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_FLOWID= "flowid";
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_LOCKKEY= "lockkey";
        public static final String sS_RULE_SERVICEURL = "rulesSrviceUrl";
        public static final String sS_RIREKI_TASKNAME= "rirekitaskname";
        public static final String sS_EXTINFO = "extinfo";
        public static final String sS_RULE_CONDITIONNAME = "ruleconditionname";
        public static final String sS_RULE_CONDITION = "rulecondition";
    }

    interface OUT{
        public static final String sS_KOUTEISYUURYOUFLG= "kouteisyuuryouflg";
        public static final String sS_AUTOCREATEFLOWID= "autocreateflowid";
    }
}

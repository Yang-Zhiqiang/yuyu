package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch;

/**
 * 工程遷移（バッチ用）WEBサービスの入出力パラメータキーです。
 */
public interface IWSExecProcessForwardForBatchIOKey {

    interface IN {
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_RULE_SERVICEURL = "rulesSrviceUrl";
        public static final String sS_RIREKI_SAKUSEI_YOUHI = "rirekiYouhi";
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_FLOWID= "flowid";
        public static final String sS_LOCKKEY= "lockkey";
        public static final String sS_RIREKI_TASKNAME= "rirekitaskname";
        public static final String sS_EXTINFO = "extinfo";
        public static final String sS_RULE_CONDITIONNAME = "ruleconditionname";
        public static final String sS_RULE_CONDITION = "rulecondition";
    }

    interface SUMMARY {
        public static final String sS_SUMMARY_PREVIOUS_TASKNODE_LOCALNAME= "summaryPreviousTasknodeLocalName";
        public static final String sS_SUMMARY_CURRENT_TASKNODE_LOCALNAME = "summaryCurrentTasknodeLocalName";
        public static final String sS_SUMMARY_CURRENT_TASKNAME = "summaryCurrentTaskname";
        public static final String sS_SUMMARY_KOUTEI_KAISIBI= "summaryKouteikaisibi";
        public static final String sS_SUMMARY_KOUTEI_KANRYOUBI= "summaryKouteikanryoubi";
        public static final String sS_SUMMARY_SYORISTATUS= "summarySyoristatus";
    }

    interface OUT{
        public static final String sS_KOUTEISYUURYOUFLG= "kouteisyuuryouflg";
        public static final String sS_AUTOCREATEFLOWID= "autocreateflowid";
    }
}

package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs;

/**
 * タスク定義取得サービスの入出力パラメータキー<br />
 */
public interface IWSGetTaskDefsIOKey {

    interface IN {
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_FLOWID= "flowid";
    }

    interface OUT {
        public static final String sO_TASKDEFS= "taskdefs";
    }

    interface MapKey{
        public static final String sS_FLOW_ID         = "flowid";
        public static final String sS_FLOW_LOCALNAME  = "flowlocalname";
        public static final String sS_FLOW_SORTORDER  = "flowsortorder";
        public static final String sTASK_NAME         = "taskname";
        public static final String sTASK_LOCALNAME    = "tasklocalname";
        public static final String sTASK_KENGENUMU       = "taskkengenumu";
        public static final String sTASK_SORTORDER    = "tasksortorder";
    }

}

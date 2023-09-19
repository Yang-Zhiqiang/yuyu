package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummarybyactor;

/**
 * ユーザー別件数サマリ照会WEBサービスの入出力パラメータキーです。
 */
public interface IWSGetTaskSummaryByActorIOKey {

    interface IN {
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_WARIATEUMU= "wariateumu";
        public static final String sS_TASKENDUMU= "taskendumu";
        public static final String sS_FLOWID = "flowid";
        public static final String sS_TASKID = "taskid";
        public static final String sS_TASKCREATETIME_FROM = "taskcreatetimefrom";
        public static final String sS_TASKCREATETIME_TO = "taskcreatetimeto";
        public static final String sS_TASKSTARTTIME_FROM = "taskstarttimefrom";
        public static final String sS_TASKSTARTTIME_TO = "taskstarttimeto";
        public static final String sS_TASKENDTIME_FROM = "taskendtimefrom";
        public static final String sS_TASKENDTIME_TO = "taskendtimeto";
    }

    interface OUT {
        public static final String sO_TASKSUMMARYMAPS = "tasksummarymaps";
    }

    interface MapKey {
        public static final String sS_FLOW_ID = "flowid";
        public static final String sS_TASK_ID = "taskid";
        public static final String sS_FLOW_NAME = "flowname";
        public static final String sS_TASK_NAME = "taskname";
        public static final String sS_USER_ID = "userid";
        public static final String sS_TASK_COUNT = "taskcount";
    }
}

package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart;

/**
 * タスク開始WEBサービスの入出力パラメータキーです。
 */
public interface IWSExecTaskStartIOKey {

    interface IN {
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_FLOWID= "flowid";
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_LOCKKEY= "lockkey";
        public static final String sS_TASKNAME= "taskname";
        public static final String sS_EXTINFO= "extinfo";
    }
}

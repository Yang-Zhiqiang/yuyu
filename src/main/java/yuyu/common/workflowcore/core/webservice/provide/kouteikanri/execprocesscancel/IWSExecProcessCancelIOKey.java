package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel;

/**
 * 工程中断WEBサービスの入出力パラメータキーです。
 */
public interface IWSExecProcessCancelIOKey {

    interface IN {
        public static final String sS_GYOUMUKEY   = "gyoumukey";
        public static final String sS_FLOWID      = "flowid";
        public static final String sS_ACCOUNTID   = "accountid";
        public static final String sS_LOCKKEY= "lockkey";
        public static final String sS_EXTINFO= "extinfo";
    }
}

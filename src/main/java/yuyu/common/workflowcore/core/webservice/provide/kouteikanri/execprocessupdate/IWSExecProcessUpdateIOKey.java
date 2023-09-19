package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate;

/**
 * 工程情報更新WEBサービスの入出力パラメータキーです。
 */
public interface IWSExecProcessUpdateIOKey {

    interface IN {
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_FLOWID= "flowid";
        public static final String sS_NODENAME= "nodename";
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_LOCKKEY= "lockkey";
        public static final String sS_EXTINFO = "extinfo";
    }
}

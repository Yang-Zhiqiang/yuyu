package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward;

/**
 * 強制工程遷移WEBサービスの入出力パラメータキーです。<br/>
 */
public interface IWSExecForceProcessForwardIOKey {

    interface IN {
        public static final String sS_GYOUMUKEY    = "gyoumukey";
        public static final String sS_FLOWID       = "flowid";
        public static final String sS_ACCOUNTID    = "accountid";
        public static final String sS_SRCNODENAME  = "srcnodename";
        public static final String sS_DESTNODENAME = "destnodename";
        public static final String sS_LOCKKEY      = "lockkey";
    }
}

package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate;

/**
 * 工程開始WEBサービスの入出力パラメータキーです。
 */
public interface IWSExecProcessCreateIOKey {

    interface IN {
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_FLOWID= "flowid";
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_PROCESSGROUP= "processgroup";
        public static final String sS_RIREKI_TASKNAME= "rirekitaskname";
        public static final String sS_EXTINFO= "extinfo";
    }
}

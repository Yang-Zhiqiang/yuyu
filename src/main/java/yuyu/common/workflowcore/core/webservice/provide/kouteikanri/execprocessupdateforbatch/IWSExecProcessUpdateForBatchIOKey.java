package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch;

/**
 * 工程情報更新（バッチ用）WEBサービスの入出力パラメータキーです。
 */
public interface IWSExecProcessUpdateForBatchIOKey {

    interface IN {
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_FLOWID= "flowid";
        public static final String sS_LOCKKEY= "lockkey";
        public static final String sS_LOCKCONFIRMKBN= "lockconfirmkbn";
        public static final String sS_EXTINFO = "extinfo";
    }

    interface OUT{
        public static final String sS_ERRGYOUMUKEY= "errgyoumukey";
    }
}

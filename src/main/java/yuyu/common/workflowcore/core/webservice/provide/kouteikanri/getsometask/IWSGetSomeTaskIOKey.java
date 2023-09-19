package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask;

/**
 * 単一タスク取得サービスの入出力パラメータキーです。<br />
 */
public interface IWSGetSomeTaskIOKey {

    interface IN {
        public static final String sS_FLOWID= "flowid";
        public static final String sS_NODENAME= "nodename";
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_TASKKBN= "taskkbn";
    }

    interface OUT {
        public static final String sS_GYOUMUKEY= "gyoumukey";
    }
}

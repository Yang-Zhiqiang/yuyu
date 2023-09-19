package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate;

/**
 * 一括工程開始WEBサービスの入出力パラメータキーです。
 */
public interface IWSIkkatuProcessCreateIOKey {

    interface IN {
        public static final String sS_MAPLISTXML= "maplistxml";
    }

    interface MapKey{

        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_FLOWID= "flowid";
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_PROCESSGROUP= "processgroup";
        public static final String sS_EXTINFO= "extinfo";

    }
}

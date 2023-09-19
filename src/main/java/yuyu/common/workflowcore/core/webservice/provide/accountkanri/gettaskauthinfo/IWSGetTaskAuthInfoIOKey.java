package yuyu.common.workflowcore.core.webservice.provide.accountkanri.gettaskauthinfo;

/**
 * タスク権限情報取得サービスの入出力パラメータキーです。
 */
public interface IWSGetTaskAuthInfoIOKey {


    interface IN {
        public static final String sS_FLOWID= "flowid";
        public static final String sS_TASKNAME= "taskname";
    }

    interface OUT {
        public static final String sS_AUTHIDSS= "authidss";
    }

}

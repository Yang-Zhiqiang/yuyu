package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskprocesses;

/**
 * タスク内工程情報取得サービスの入出力パラメータキー<br />
 */
public interface IWSGetTaskProcessesIOKey {

    interface IN {
        public static final String sS_FLOWID= "flowid";
        public static final String sS_NODENAME= "nodename";
    }

    interface OUT {
        public static final String sO_GYOUMUKEYS= "gyoumukeys";
    }

}

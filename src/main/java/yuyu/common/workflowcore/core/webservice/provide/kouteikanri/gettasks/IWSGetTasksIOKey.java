package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks;
/**
 * タスク一覧取得サービスの入出力パラメータキー<br />
 */
public interface IWSGetTasksIOKey {

    interface IN {
        public static final String sS_FLOWID       = "flowid";
        public static final String sS_NODENAME     = "nodename";
        public static final String sS_ACCOUNTID    = "accountid";
        public static final String sS_TASKKBN      = "taskkbn";
    }

    interface OUT {
        public static final String sS_GYOUMUKEYSS  = "gyoumukeyss";
    }
}

package yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority;

/**
 * タスク権限追加サービスのIOキーです。
 */
public interface IWSCreateTaskAuthorityIOKey {

    interface IN {
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_MAPLISTXML= "maplistxml";

    }


    interface MapKey{
        public static final String sS_FLOWID= "flowid";
        public static final String sS_NODENAME= "nodename";
        public static final String sS_ROLECD = "rolecd";

    }
}

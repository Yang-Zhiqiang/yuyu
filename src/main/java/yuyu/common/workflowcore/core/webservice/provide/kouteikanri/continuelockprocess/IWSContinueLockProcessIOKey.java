package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.continuelockprocess;

/**
 * 工程ロックサービスの入出力キー
 */
public interface IWSContinueLockProcessIOKey {

    interface IN {
        public static final String sS_FLOWID= "flowid";
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_LOCKKEY= "lockkey";
        public static final String sS_ACCOUNTID= "accountid";
    }

    interface OUT {
        public static final String sS_GYOUMUKEY= "gyoumukey";
    }
}

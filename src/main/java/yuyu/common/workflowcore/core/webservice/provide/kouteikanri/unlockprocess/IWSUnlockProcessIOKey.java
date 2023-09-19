package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess;

/**
 * 工程アンロックサービスの入出力キー
 */
public interface IWSUnlockProcessIOKey {

    interface IN {
        public static final String sS_FLOWID= "flowid";
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_LOCKKEY= "lockkey";
    }

    interface OUT {
        public static final String sS_GYOUMUKEY= "gyoumukey";
    }
}

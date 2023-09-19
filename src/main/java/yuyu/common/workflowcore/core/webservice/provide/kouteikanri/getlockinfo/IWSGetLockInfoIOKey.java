package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo;

/**
 * 工程ロック情報取得サービスの入出力キー
 */
public interface IWSGetLockInfoIOKey {

    interface IN {
        public static final String sS_FLOWID= "flowid";
        public static final String sS_GYOUMUKEY= "gyoumukey";

    }

    interface OUT {
        public static final String sO_LOCKINFOMAPS     = "lockinfomaps";
    }

    interface MapKey{
        public static final String sS_GYOUMUKEY      = "gyoumukey";
        public static final String sS_FLOW_ID        = "flowid";
        public static final String sS_NODE_NAME      = "nodename";
        public static final String sS_ACCOUNT_ID     = "accountid";
        public static final String sS_LOCKKEY        = "lockkey";
        public static final String sS_LOCKTiME       = "locktime";
    }
}

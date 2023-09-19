package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess;

/**
 * 強制工程アンロックサービスの入出力キーです。<br/>
 */
public interface IWSForceUnlockProcessIOKey {

    interface IN {
        public static final String sS_FLOWID       = "flowid";
        public static final String sS_GYOUMUKEY    = "gyoumukey";
    }

    interface OUT {
        public static final String sS_GYOUMUKEY    = "gyoumukey";
    }
}

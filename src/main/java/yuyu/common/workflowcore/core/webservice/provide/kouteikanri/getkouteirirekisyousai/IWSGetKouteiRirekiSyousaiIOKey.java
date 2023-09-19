package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai;

/**
 * 工程履歴詳細取得サービスのIOキーです。
 */
public interface IWSGetKouteiRirekiSyousaiIOKey {
    interface IN {
        public static final String sS_FLOWID         = "flowid";
        public static final String sS_GYOUMUKEY      = "gyoumukey";
        public static final String sS_RIREKIKBN      = "rirekikbn";
    }

    interface OUT {
        public static final String sO_RIREKIMAPS     = "rirekimaps";
    }

    interface MapKey{
        public static final String sS_SYORITiME        = "syoritime";
        public static final String sS_GYOUMUKEY      = "gyoumukey";
        public static final String sS_FLOW_ID          = "flowid";
        public static final String sS_FLOW_LOCALNAME  = "flowlocalname";
        public static final String sS_NODE_NAME        = "nodename";
        public static final String sS_NODE_LOCALNAME  = "nodelocalname";
        public static final String sS_ACCOUNT_ID     = "accountid";
        public static final String sS_SYORI_KBN      = "syorikbn";
        public static final String sS_RIREKI_KBN      = "rirekikbn";
        public static final String sS_RIREKI_MESSAGE = "rirekimessage";
        public static final String sS_EXT_INFO = "extinfo";
    }
}

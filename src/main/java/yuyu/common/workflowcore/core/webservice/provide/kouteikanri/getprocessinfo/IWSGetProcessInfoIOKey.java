package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessinfo;

/**
 * 工程情報取得サービスの入出力パラメータキー<br />
 */
public interface IWSGetProcessInfoIOKey {

    interface IN {
        public static final String sS_GYOUMUKEYSS= "gyoumukeys";
        public static final String sS_FLOWID= "flowid";
        public static final String sS_IPADDRESS= "ipaddress";
    }

    interface OUT {
        public static final String sO_NODENAMES= "nodenames";
        public static final String sO_WARITATEGROUPIDS= "waritategroupids";
        public static final String sO_WARIATEUSERID= "wariateuserid";
    }

}

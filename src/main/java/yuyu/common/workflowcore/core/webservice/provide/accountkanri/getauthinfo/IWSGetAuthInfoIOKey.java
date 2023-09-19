package yuyu.common.workflowcore.core.webservice.provide.accountkanri.getauthinfo;

/**
 * 権限情報取得サービスの入出力パラメータキーです。
 */
public interface IWSGetAuthInfoIOKey {


    interface IN {
        public static final String sS_AUTHID= "authid";
        public static final String sS_AUTHNAME= "authname";
        public static final String sS_FLOWID= "flowid";
        public static final String sS_NODEID= "nodeid";
        public static final String sS_TORIKOMISYORUICD= "torikomisyoruicd";
    }

    interface OUT {
        public static final String sO_AUTHINFOS= "authinfos";
        public static final String sS_AUTHID= "authid";
        public static final String sS_AUTHNAME= "authname";
        public static final String sS_FLOWIDSS= "flowids";
        public static final String sS_NODEIDSS= "nodeids";
        public static final String sS_TORIKOMISYORUICDSS= "torikomisyoruicds";
    }

}

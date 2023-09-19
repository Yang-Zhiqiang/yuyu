package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettransitions;

/**
 * 分岐先取得サービスの入出力パラメータキー<br />
 */
public interface IWSGetTransitionsIOKey {

    interface IN {
        public static final String sS_FLOWID      = "flowid";
        public static final String sS_NODENAME    = "nodename";

    }

    interface OUT {
        public static final String sS_DESTNODESS   = "destnodess";
    }
}

package yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage;

/**
 * 入力パラメータキー
 */
public interface IWSPutArrivalImageIOKey {

    interface IN {
        public static final String sS_ACCOUNTID = "accountid";
        public static final String sS_ARRIVEKEY = "arrivekey";
        public static final String sS_IMAGEDATASTR = "imagedatastr";
    }

    interface OUT {
        public static final String sS_CBERRMSG= "cberrmsg";
    }
}

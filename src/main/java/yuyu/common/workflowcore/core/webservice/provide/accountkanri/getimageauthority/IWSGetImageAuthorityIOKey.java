package yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority;


/**
 * 書類権限情報取得サービスの入出力パラメータキーです。
 */
public interface IWSGetImageAuthorityIOKey {

    interface IN {
        public static final String sS_IMAGEAUTHID = "imageauthid";
    }

    interface OUT {
        public static final String sS_TORIKOMISYORUICDS = "torikomisyoruicds";
    }
}

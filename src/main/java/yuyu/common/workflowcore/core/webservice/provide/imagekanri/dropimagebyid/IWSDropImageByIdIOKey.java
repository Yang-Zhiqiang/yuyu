package yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid;

/**
 * ID指定イメージ削除サービス入出力キー
 */
public interface IWSDropImageByIdIOKey {

    interface IN {
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_IMAGEIDSS= "imageids";
        public static final String sS_EXT_INFO = "extinfo";
    }
}

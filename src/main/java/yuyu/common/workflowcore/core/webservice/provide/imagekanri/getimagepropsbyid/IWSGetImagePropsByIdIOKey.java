package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagepropsbyid;

/**
 * ID指定イメージプロパティ取得サービス入出力キー
 */
public interface IWSGetImagePropsByIdIOKey {

    interface IN {
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_IMAGEIDSS= "imageids";
        public static final String sS_REQUESTID= "requestid";

    }

    interface OUT {
        public static final String sO_IMAGEPROPSLIST= "imagepropslist";
        public static final String sS_IMAGEID= "imageid";
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_TORIKOMISYORUICD= "torikomisyoruicd";
        public static final String sS_SYORUITOUTYAKUTIME= "syoruitoutyakutime";
        public static final String sS_KOUTEIJYOUTAI= "kouteijyoutai";
        public static final String sS_KENGENUMU= "kengenumu";
    }

}

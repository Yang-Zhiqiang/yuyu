package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid;

/**
 * ID指定イメージ取得サービス入出力キー
 */
public interface IWSGetImageByIdIOKey {

    interface IN {
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_IMAGEIDSS= "imageids";
    }

    interface OUT {
        public static final String sO_IMAGEINFOLIST= "imageinfolist";
        public static final String sS_IMAGEID= "imageid";
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_TORIKOMISYORUICD= "torikomisyoruicd";
        public static final String sS_SYORUITOUTYAKUTIME= "syoruitoutyakutime";
        public static final String sS_KENGENUMU= "kengenumu";
        public static final String sO_PDFIMAGE= "pdfimage";
    }

}

package yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimages;

/**
 * 対象イメージ取得サービス入出力キー
 */
public interface IWSGetTargetImagesIOKey {

    interface IN {
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_FLOWID= "flowid";
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_TORIKOMISYORUICD= "torikomisyoruicd";
        public static final String sS_SYORUITOUTYAKUYMDFROM= "syoruitoutyakuymdfrom";
        public static final String sS_SYORUITOUTYAKUYMDTO= "syoruitoutyakuymdto";
        public static final String sS_SYZKDAIBUNRUIID= "syzkdaibunruiid";
        public static final String sS_SYZKSYOUBUNRUIID= "syzksyoubunruiid";
        public static final String sS_KOUTEIJYOUTAI= "kouteijyoutai";
    }

    interface OUT {
        public static final String sO_IMAGEINFOLIST= "imageinfolist";
        public static final String sS_IMAGEID= "imageid";
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_TORIKOMISYORUICD= "torikomisyoruicd";
        public static final String sS_SYORUITOUTYAKUTIME= "syoruitoutyakutime";
        public static final String sS_KOUTEIJYOUTAI= "kouteijyoutai";
        public static final String sS_KENGENUMU= "kengenumu";
        public static final String sO_PDFIMAGE= "pdfimage";
    }

}

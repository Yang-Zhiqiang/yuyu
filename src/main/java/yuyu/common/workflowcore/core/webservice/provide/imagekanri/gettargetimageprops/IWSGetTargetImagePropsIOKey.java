package yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops;

/**
 * 対象イメージプロパティ取得サービス入出力キー
 */
public interface IWSGetTargetImagePropsIOKey {

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
        public static final String sO_IMAGEPROPSLIST= "imagepropslist";
        public static final String sS_IMAGEID= "imageid";
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_TORIKOMISYORUICD= "torikomisyoruicd";
        public static final String sS_TOUROKUTIME= "tourokutime";
        public static final String sS_SYORUITOUTYAKUTIME= "syoruitoutyakutime";
        public static final String sS_KOUTEIJYOUTAI= "kouteijyoutai";
        public static final String sS_KENGENUMU= "kengenumu";
        public static final String sS_TOUROKUACCOUNTID= "tourokuaccountid";
        public static final String sS_PAGECOUNT = "pagecount";
    }

}

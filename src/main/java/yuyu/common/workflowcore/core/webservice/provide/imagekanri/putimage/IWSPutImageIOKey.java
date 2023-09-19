package yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage;

public interface IWSPutImageIOKey {

    interface IN {
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_FLOWID= "flowid";
        public static final String sS_GYOUMUKEY = "gyoumukey";
        public static final String sS_SYORUICD  = "syoruicd";
        public static final String sS_SYORUITOUTYAKUTIME= "syoruitoutyakutime";
        public static final String sS_TOUROKUTIME= "tourokutime";
        public static final String sS_IMAGEDATASTR= "imagedatastr";
        public static final String sS_EXT_INFO = "extinfo";
    }

    interface OUT {
        public static final String sS_IMGID      = "imgid";
    }
}

package iwf.callback.arriveimage.imageTerminator;

/**
 * 入力パラメータキー
 */
public interface IWSImageteminatorIOKey {

    interface IN {
        public static final String sS_TOUTYAKUKEY = "toutyakukey";
        public static final String sS_APPKEY = "appkey";
        public static final String sS_SYORUICD = "syoruicd";
        public static final String sS_FLOWID = "flowid";
        public static final String sS_SUBSYSTEMID = "subsystemid";
        public static final String sS_IMAGEID = "imageid";
    }

    interface OUT {
        public static final String sS_CBERRMSG= "cberrmsg";
    }
}

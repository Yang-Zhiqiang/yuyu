package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice;

public interface IWSGetExpectedArrivalNoticeIOKey {

    interface IN {
        public static final String sS_ARRIVEKEY = "arrivekey";
        public static final String sS_TORIKOMISYORUICD = "torikomisyoruicd";
        public static final String sS_GYOUMUKEY = "gyoumukey";
        public static final String sS_FLOWID = "flowid";
        public static final String sS_SUBSYSTEMID = "subsystemid";
    }

    interface OUT {
        public static final String sO_NOTICEMAPS     = "noticemaps";
    }

    interface MapKey{
        public static final String sS_ARRIVEKEY = "arrivekey";
        public static final String sS_TORIKOMISYORUICD = "torikomisyoruicd";
        public static final String sS_GYOUMUKEY = "gyoumukey";
        public static final String sS_FLOWID = "flowid";
        public static final String sS_SUBSYSTEMID = "subsystemid";
    }
}

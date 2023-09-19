package yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst;

/**
 * 取込書類マスタ情報取得サービス入出力キー
 */
public interface IWSGetTorikomiSyoruiMstIOKey {

    interface IN {
        public static final String sS_TORIKOMISYORUICD= "torikomisyoruicd";
        public static final String sS_SYZKDAIBUNRUIID= "syzkdaibunruiid";
        public static final String sS_SYZKSYOUBUNRUIID= "syzksyoubunruiid";
        public static final String sS_FLOWID= "flowid";
        public static final String sS_NODEID= "nodeid";
    }

    interface OUT {
        public static final String sO_TORIKOMISYORUILIST= "torikomisyoruilist";

        public static final String sS_TORIKOMISYORUICD= "torikomisyoruicd";
        public static final String sS_TORIKOMISYORUINM= "torikomisyoruinm";
        public static final String sS_TORIKOMISYORUIRYAKU= "torikomisyoruiryaku";
        public static final String sS_SYZKDAIBUNRUIID= "syzkdaibunruiid";
        public static final String sS_SYZKSYOUBUNRUIID= "syzksyoubunruiid";
        public static final String sS_ZIPHOZONKBN= "ziphozonkbn";
        public static final String sS_KOUTEISEIGYOUMUKBN= "kouteiseigyoumukbn";
        public static final String sS_FLOWID= "flowid";
        public static final String sS_NODEID= "nodeid";

    }

}

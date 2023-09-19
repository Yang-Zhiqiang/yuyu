package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.setprocessattribute;

/**
 * 工程属性設定サービスの入出力キー
 */
public interface IWSSetProcessAttributeIOKey {

    interface IN {
        public static final String sS_FLOWID= "flowid";
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_JSONDATA= "jsondata";
        public static final String sS_LOCKKEY= "lockkey";
    }
}

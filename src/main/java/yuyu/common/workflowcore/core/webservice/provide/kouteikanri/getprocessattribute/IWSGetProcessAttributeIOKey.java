package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getprocessattribute;

/**
 * 工程属性取得サービスの入出力キー
 */
public interface IWSGetProcessAttributeIOKey {

    interface IN {
        public static final String sS_FLOWID= "flowid";
        public static final String sS_GYOUMUKEY= "gyoumukey";
    }

    interface OUT {
        public static final String sS_JSONSTRINGS= "jsonstrings";
    }
}

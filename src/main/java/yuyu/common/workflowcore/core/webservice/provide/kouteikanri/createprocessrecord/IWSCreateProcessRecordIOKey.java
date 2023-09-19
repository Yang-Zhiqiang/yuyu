package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord;

/**
 * 工程履歴作成サービスの入出力パラメータキー<br />
 */
public interface IWSCreateProcessRecordIOKey {

    interface IN {
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_FLOWID= "flowid";
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_RIREKIMSG= "rirekimsg";
        public static final String sS_EXTINFO= "extinfo";
        public static final String sS_TASKNAME= "taskname";
    }
}

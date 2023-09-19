package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess;

/**
 * 実行可能タスク情報取得サービスの入出力パラメータキー<br />
 */
public interface IWSGetExecutableTasksByProcessIOKey {

    interface IN {
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_SYORISTATUS = "syoriStatus";
        public static final String sS_FLOWIDS = "flowids";
        public static final String sS_KOUTEIKAISIYMD_FROM = "kouteikaisiymdfrom";
        public static final String sS_KOUTEIKAISIYMD_TO = "kouteikaisiymdto";
        public static final String sS_KOUTEIKANRYOUYMD_FROM = "kouteikanryouymdfrom";
        public static final String sS_KOUTEIKANRYOUYMD_TO = "kouteikanryouymdto";
    }

    interface OUT {
        public static final String sS_FLOWIDSS= "flowids";
        public static final String sS_NODENAMES= "nodenames";
        public static final String sS_TASKCOUNTKOJINS= "taskcountkojins";
        public static final String sS_TASKCOUNTKYOUYUUS= "taskcountkyouyuus";
    }
}

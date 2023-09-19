package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks;

/**
 * 実行可能タスク情報取得サービスの入出力パラメータキー<br />
 */
public interface IWSGetExecutableTasksIOKey {

    interface IN {
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_FLOWID= "flowid";
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_KENSUU_SYUTOKU_YOUHI= "kensuusyutokuyouhi";
    }

    interface OUT {
        public static final String sS_FLOWIDSS= "flowidss";
        public static final String sS_NODENAMES= "nodenames";
        public static final String sS_TASKCOUNTKOJINS= "taskcountkojins";
        public static final String sS_TASKCOUNTKYOUYUUS= "taskcountkyouyuus";

    }
}

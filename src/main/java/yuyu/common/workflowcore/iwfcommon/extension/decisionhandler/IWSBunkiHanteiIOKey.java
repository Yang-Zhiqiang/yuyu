package yuyu.common.workflowcore.iwfcommon.extension.decisionhandler;

public interface IWSBunkiHanteiIOKey {

    interface IN {
        public static final String sS_RULE  =      "rule";
        public static final String sS_REQUESTID  = "requestid";
        public static final String sS_RULECONDITIONNAME = "ruleconditionname";
        public static final String sS_RULECONDITION = "rulecondition";
    }

    interface OUT {
        public static final String sS_KEKKASTATUS =  "kekkastatus";
        public static final String sS_SYOUSAIMSGCD = "syousaimsgcd";
        public static final String sS_SYOUSAIMSG =   "syousaimsg";
        public static final String sS_HANTEIKEKKA =  "hanteikekka";
    }
}

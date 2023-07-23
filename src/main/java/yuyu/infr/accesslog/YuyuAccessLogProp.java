package yuyu.infr.accesslog;

import jp.co.slcs.swak.core.accesslog.AccessLogProp;

/**
 * ゆうゆう生保アプリケーションのアクセスログ追加属性です。
 */
public class YuyuAccessLogProp extends AccessLogProp {

    private static final long serialVersionUID = 5868014308233909064L;

    public static final String        MDC_KEY_SUBSYSTEM_ID   = "SubsystemId";

    public static final String        MDC_KEY_CATEGORY_ID    = "CategoryId";

    public static final String        MDC_KEY_KINOU_ID       = "KinouId";

    public static final String        MDC_KEY_CLASS_NAME     = "ClassName";

    public static final YuyuAccessLogProp SubsystemId = new YuyuAccessLogProp(MDC_KEY_SUBSYSTEM_ID);

    public static final YuyuAccessLogProp CategoryId  = new YuyuAccessLogProp(MDC_KEY_CATEGORY_ID );

    public static final YuyuAccessLogProp KinouId     = new YuyuAccessLogProp(MDC_KEY_KINOU_ID    );

    public static final YuyuAccessLogProp ClassName   = new YuyuAccessLogProp(MDC_KEY_CLASS_NAME  );

    protected YuyuAccessLogProp(String pMdcKey) {
        super(pMdcKey);
    }

}

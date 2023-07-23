package yuyu.infr.accesslog;

import jp.co.slcs.swak.core.accesslog.AccessLogProp;

/**
 * ゆうゆう生保アプリケーションのアクセスログのWEBサービス用属性です。
 */
public class YuyuAccessLogWSProp extends AccessLogProp {

    private static final long serialVersionUID = 5868014308233909064L;

    public static final String        MDC_KEY_SUBSYSTEM_ID   = "SubsystemId";

    public static final String        MDC_KEY_CATEGORY_ID    = "CategoryId";

    public static final String        MDC_KEY_KINOU_ID       = "KinouId";

    public static final String        MDC_KEY_CLASS_NAME     = "ClassName";

    public static final YuyuAccessLogWSProp SubsystemId = new YuyuAccessLogWSProp(MDC_KEY_SUBSYSTEM_ID);

    public static final YuyuAccessLogWSProp CategoryId  = new YuyuAccessLogWSProp(MDC_KEY_CATEGORY_ID );

    public static final YuyuAccessLogWSProp KinouId     = new YuyuAccessLogWSProp(MDC_KEY_KINOU_ID    );

    public static final YuyuAccessLogWSProp ClassName   = new YuyuAccessLogWSProp(MDC_KEY_CLASS_NAME  );

    protected YuyuAccessLogWSProp(String pMdcKey) {
        super(pMdcKey);
    }

}

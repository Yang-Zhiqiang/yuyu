package yuyu.infr.accesslog;

/**
 * 端末タイプ、物理組織コード、論理組織コード、端末状態表示の設定をするクラスです。
 */
public class YuyuAccessLogExtensionProp extends YuyuAccessLogProp{

    private static final long serialVersionUID = 1L;

    public static final String        MDC_KEY_TANMATUTYPE           = "TanmatuType";

    public static final String        MDC_KEY_BUTSURISOSIKICD       = "ButsuriSosikiCd";

    public static final String        MDC_KEY_RONRISOSIKICD         = "RonriSosikiCd";

    public static final String        MDC_KEY_TANMATUJYOUTAIHYOUJI  = "TanmatuJyoutaiHyouji";

    public static final YuyuAccessLogProp TanmatuType          = new YuyuAccessLogProp(MDC_KEY_TANMATUTYPE  );

    public static final YuyuAccessLogProp ButsuriSosikiCd      = new YuyuAccessLogProp(MDC_KEY_BUTSURISOSIKICD  );

    public static final YuyuAccessLogProp RonriSosikiCd        = new YuyuAccessLogProp(MDC_KEY_RONRISOSIKICD  );

    public static final YuyuAccessLogProp TanmatuJyoutaiHyouji = new YuyuAccessLogProp(MDC_KEY_TANMATUJYOUTAIHYOUJI  );


    protected YuyuAccessLogExtensionProp(String pMdcKey){
        super(pMdcKey);
    }

}

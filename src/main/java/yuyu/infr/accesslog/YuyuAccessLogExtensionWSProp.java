package yuyu.infr.accesslog;

/**
 * WEBサービス用アクセスログ出力
 * WEBサービス用に端末タイプ、物理組織コード、論理組織コード、端末状態表示の設定をするクラスです。
 */
public class YuyuAccessLogExtensionWSProp extends YuyuAccessLogExtensionProp{

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("hiding")
    public static final YuyuAccessLogExtensionProp TanmatuType          = new YuyuAccessLogExtensionProp(MDC_KEY_TANMATUTYPE  );

    @SuppressWarnings("hiding")
    public static final YuyuAccessLogExtensionProp ButsuriSosikiCd      = new YuyuAccessLogExtensionProp(MDC_KEY_BUTSURISOSIKICD  );

    @SuppressWarnings("hiding")
    public static final YuyuAccessLogExtensionProp RonriSosikiCd        = new YuyuAccessLogExtensionProp(MDC_KEY_RONRISOSIKICD  );

    @SuppressWarnings("hiding")
    public static final YuyuAccessLogExtensionProp TanmatuJyoutaiHyouji = new YuyuAccessLogExtensionProp(MDC_KEY_TANMATUJYOUTAIHYOUJI  );


    protected YuyuAccessLogExtensionWSProp(String pMdcKey){
        super(pMdcKey);
    }

}

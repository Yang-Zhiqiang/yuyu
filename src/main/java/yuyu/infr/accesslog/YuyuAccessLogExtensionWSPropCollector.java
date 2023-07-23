package yuyu.infr.accesslog;

/**
 * WEBサービス用アクセスログ出力
 * WEBサービス用に端末タイプ、物理組織コード、論理組織コード、端末状態表示の設定をするクラスです。
 */
public class YuyuAccessLogExtensionWSPropCollector extends YuyuAccessLogExtensionPropCollector{

    @Override
    protected void setPropRest() {
        if(YuyuAccessLogExtensionWSProp.TanmatuType.get() == null) {
            YuyuAccessLogExtensionWSProp.TanmatuType         .set("");
        }
        if(YuyuAccessLogExtensionWSProp.ButsuriSosikiCd.get() == null) {
            YuyuAccessLogExtensionWSProp.ButsuriSosikiCd     .set("");
        }
        if(YuyuAccessLogExtensionWSProp.RonriSosikiCd.get() == null) {
            YuyuAccessLogExtensionWSProp.RonriSosikiCd       .set("");
        }
        if(YuyuAccessLogExtensionWSProp.TanmatuJyoutaiHyouji.get() == null) {
            YuyuAccessLogExtensionWSProp.TanmatuJyoutaiHyouji.set("");
        }
    }

}

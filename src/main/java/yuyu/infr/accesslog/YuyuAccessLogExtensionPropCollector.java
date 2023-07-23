package yuyu.infr.accesslog;

import javax.servlet.http.HttpServletRequest;

import jp.co.slcs.swak.core.accesslog.AccessLogProp;
import jp.co.slcs.swak.core.accesslog.AccessLogPropCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.resource.WebRequestType;
import jp.co.slcs.swak.web.resource.WebRequestType.WebRequestTypes;
import yuyu.infr.auth.RayHttpHeaderBean;

import com.google.common.collect.Sets;
import com.google.inject.ProvisionException;

/**
 * 端末タイプ、物理組織コード、論理組織コード、端末状態表示の設定をするクラスです。
 */
public class YuyuAccessLogExtensionPropCollector implements AccessLogPropCollector{

    private static final Iterable<YuyuAccessLogProp> props = Sets.newHashSet(
        YuyuAccessLogExtensionProp.TanmatuType,
        YuyuAccessLogExtensionProp.ButsuriSosikiCd,
        YuyuAccessLogExtensionProp.RonriSosikiCd,
        YuyuAccessLogExtensionProp.TanmatuJyoutaiHyouji
        );

    @Override
    public Iterable<? extends AccessLogProp> props() {
        return props;
    }

    @Override
    public void collect() {
        WebRequestType webRequestType = null;

        try {
            SWAKInjector.getInstance(HttpServletRequest.class);
            webRequestType = SWAKInjector.getInstance(WebRequestType.class);
        } catch (Exception e) {
            YuyuAccessLogExtensionProp.TanmatuType         .set(null);
            YuyuAccessLogExtensionProp.ButsuriSosikiCd     .set(null);
            YuyuAccessLogExtensionProp.RonriSosikiCd       .set(null);
            YuyuAccessLogExtensionProp.TanmatuJyoutaiHyouji.set(null);

            return;
        }

        if (webRequestType != null && WebRequestTypes.ONLINE.equals(webRequestType.getType())) {
            setPropOnline();
        } else if (webRequestType != null && WebRequestTypes.REST.equals(webRequestType.getType())) {
            setPropRest();

        } else {
            setPropOther();
        }
    }

    protected void setPropOnline() {
        YuyuAccessLogExtensionProp.TanmatuType         .set("0");
        YuyuAccessLogExtensionProp.ButsuriSosikiCd     .set("");

        try{
            YuyuAccessLogExtensionProp.RonriSosikiCd   .set(SWAKInjector.getInstance(RayHttpHeaderBean.class).getTmSosikiCd());
        }catch(ProvisionException e){
            YuyuAccessLogExtensionProp.RonriSosikiCd   .set("");
        }

        YuyuAccessLogExtensionProp.TanmatuJyoutaiHyouji.set("");
    }

    protected void setPropRest() {
        YuyuAccessLogExtensionProp.TanmatuType         .set("");
        YuyuAccessLogExtensionProp.ButsuriSosikiCd     .set("");
        YuyuAccessLogExtensionProp.RonriSosikiCd       .set("");
        YuyuAccessLogExtensionProp.TanmatuJyoutaiHyouji.set("");
    }

    protected void setPropOther() {
        YuyuAccessLogExtensionProp.TanmatuType         .set("");
        YuyuAccessLogExtensionProp.ButsuriSosikiCd     .set("");
        YuyuAccessLogExtensionProp.RonriSosikiCd       .set("");
        YuyuAccessLogExtensionProp.TanmatuJyoutaiHyouji.set("");
    }

}

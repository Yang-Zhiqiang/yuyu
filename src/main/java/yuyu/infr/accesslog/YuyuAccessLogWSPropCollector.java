package yuyu.infr.accesslog;

import javax.servlet.http.HttpServletRequest;

import jp.co.slcs.swak.core.accesslog.AccessLogPropCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.action.ActionProvider;
import jp.co.slcs.swak.web.resource.WebRequestType;
import jp.co.slcs.swak.web.resource.WebRequestType.WebRequestTypes;

import com.google.common.collect.Sets;

public class YuyuAccessLogWSPropCollector implements AccessLogPropCollector {

    private static final Iterable<YuyuAccessLogWSProp> props = Sets.newHashSet(
        YuyuAccessLogWSProp.SubsystemId,
        YuyuAccessLogWSProp.CategoryId,
        YuyuAccessLogWSProp.KinouId,
        YuyuAccessLogWSProp.ClassName
        );

    @Override
    public Iterable<YuyuAccessLogWSProp> props() {
        return props;
    }

    @Override
    public void collect() {
        WebRequestType webRequestType = null;

        try {
            SWAKInjector.getInstance(HttpServletRequest.class);
            webRequestType = SWAKInjector.getInstance(WebRequestType.class);
        } catch (Exception e) {
            YuyuAccessLogProp.ClassName  .set("(none)");
            YuyuAccessLogProp.KinouId    .set("(none)");
            YuyuAccessLogProp.CategoryId .set("(none)");
            YuyuAccessLogProp.SubsystemId.set("(none)");
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
        ActionProvider actionProvider = SWAKInjector.getInstance(ActionProvider.class);
        Class<?> actionClass = actionProvider.getActionClass();
        if (actionClass != null) {
            String[] packages = actionClass.getPackage().getName().split("\\.");
            YuyuAccessLogWSProp.ClassName  .set(actionClass.getSimpleName());
            YuyuAccessLogWSProp.KinouId    .set((packages.length >= 1) ? packages[packages.length - 1] : "(none)");
            YuyuAccessLogWSProp.CategoryId .set((packages.length >= 2) ? packages[packages.length - 2] : "(none)");
            YuyuAccessLogWSProp.SubsystemId.set((packages.length >= 3) ? packages[packages.length - 3] : "(none)");
        } else {
            YuyuAccessLogWSProp.ClassName  .set("(none)");
            YuyuAccessLogWSProp.KinouId    .set("(none)");
            YuyuAccessLogWSProp.CategoryId .set("(none)");
            YuyuAccessLogWSProp.SubsystemId.set("(none)");
        }
    }

    protected void setPropRest() {
        if(YuyuAccessLogWSProp.ClassName.get() == "") {
            YuyuAccessLogWSProp.ClassName  .set("(none)");
        }
        if(YuyuAccessLogWSProp.KinouId.get() == "") {
            YuyuAccessLogWSProp.KinouId    .set("webservice");
        }
        if(YuyuAccessLogWSProp.CategoryId.get() == "") {
            YuyuAccessLogWSProp.CategoryId .set("(none)");
        }
        if(YuyuAccessLogWSProp.SubsystemId.get() == "") {
            YuyuAccessLogWSProp.SubsystemId.set("(none)");
        }
    }

    protected void setPropOther() {
        YuyuAccessLogWSProp.ClassName  .set("(unknown)");
        YuyuAccessLogWSProp.KinouId    .set("(unknown)");
        YuyuAccessLogWSProp.CategoryId .set("(unknown)");
        YuyuAccessLogWSProp.SubsystemId.set("(unknown)");
    }

}

package yuyu.infr.accesslog;

import javax.servlet.http.HttpServletRequest;

import jp.co.slcs.swak.core.accesslog.AccessLogPropCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.action.ActionProvider;
import jp.co.slcs.swak.web.resource.WebRequestType;
import jp.co.slcs.swak.web.resource.WebRequestType.WebRequestTypes;

import com.google.common.collect.Sets;

public class YuyuAccessLogPropCollector implements AccessLogPropCollector {

    private static final Iterable<YuyuAccessLogProp> props = Sets.newHashSet(
        YuyuAccessLogProp.SubsystemId,
        YuyuAccessLogProp.CategoryId,
        YuyuAccessLogProp.KinouId,
        YuyuAccessLogProp.ClassName
    );

    @Override
    public Iterable<YuyuAccessLogProp> props() {
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
            YuyuAccessLogProp.ClassName  .set(actionClass.getSimpleName());
            YuyuAccessLogProp.KinouId    .set((packages.length >= 1) ? packages[packages.length - 1] : "(none)");
            YuyuAccessLogProp.CategoryId .set((packages.length >= 2) ? packages[packages.length - 2] : "(none)");
            YuyuAccessLogProp.SubsystemId.set((packages.length >= 3) ? packages[packages.length - 3] : "(none)");
        } else {
            YuyuAccessLogProp.ClassName  .set("(none)");
            YuyuAccessLogProp.KinouId    .set("(none)");
            YuyuAccessLogProp.CategoryId .set("(none)");
            YuyuAccessLogProp.SubsystemId.set("(none)");
        }
    }

    protected void setPropRest() {
        YuyuAccessLogProp.ClassName  .set("(none)");
        YuyuAccessLogProp.KinouId    .set("webservice");
        YuyuAccessLogProp.CategoryId .set("(none)");
        YuyuAccessLogProp.SubsystemId.set("(none)");
    }

    protected void setPropOther() {
        YuyuAccessLogProp.ClassName  .set("(unknown)");
        YuyuAccessLogProp.KinouId    .set("(unknown)");
        YuyuAccessLogProp.CategoryId .set("(unknown)");
        YuyuAccessLogProp.SubsystemId.set("(unknown)");
    }

}

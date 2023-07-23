package yuyu.infr.batch.accesslog;

import jp.co.slcs.swak.auth.Credentials;
import jp.co.slcs.swak.batch.engine.BatchJob;
import jp.co.slcs.swak.batch.inject.scope.BatchScope;
import jp.co.slcs.swak.core.accesslog.AccessLogProp;
import jp.co.slcs.swak.core.accesslog.AccessLogPropCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.accesslog.YuyuAccessLogProp;

import com.google.common.collect.Sets;

public class YuyuBatchAccessLogPropCollector implements AccessLogPropCollector {

    private static final Iterable<AccessLogProp> props = Sets.newHashSet(
        YuyuAccessLogProp.SubsystemId,
        YuyuAccessLogProp.CategoryId,
        YuyuAccessLogProp.KinouId,
        YuyuAccessLogProp.ClassName,
        AccessLogProp.SyoriUserId
    );

    @Override
    public Iterable<AccessLogProp> props() {
        return props;
    }

    @Override
    public void collect() {
        BatchScope scope = SWAKInjector.getInstance(BatchScope.class);
        if (! scope.contains(BatchJob.class)) {
            YuyuAccessLogProp.SubsystemId.setTemporary("base");
            YuyuAccessLogProp.CategoryId .setTemporary("infr");
            YuyuAccessLogProp.KinouId    .setTemporary("batch");
            YuyuAccessLogProp.ClassName  .setTemporary(AccessLogProp.ActionId.get());
            return;
        }

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);
        if (kinou != null) {
            YuyuAccessLogProp.ClassName  .set(AccessLogProp.ActionId.get());
            YuyuAccessLogProp.KinouId    .set(kinou.getKinouId());
            YuyuAccessLogProp.CategoryId .set(kinou.getCategoryId());
            YuyuAccessLogProp.SubsystemId.set(kinou.getSubSystemId());
        }

        Credentials credentials = SWAKInjector.getInstance(Credentials.class);
        if (credentials != null) {
            AccessLogProp.SyoriUserId.set(credentials.getUsername());
        }
    }

}

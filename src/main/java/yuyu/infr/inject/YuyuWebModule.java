package yuyu.infr.inject;

import java.lang.reflect.Method;

import javax.inject.Named;

import jp.co.slcs.swak.auth.Credentials;
import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.batch.client.AbstractBatchClient;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.inject.ServiceInitializer;
import jp.co.slcs.swak.core.inject.ServiceTerminator;
import jp.co.slcs.swak.core.inject.scope.ThreadScope;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.uniquekey.AppIdentifierManager;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.uniquekey.UnitUniqueKeyGenerator;
import jp.co.slcs.swak.uniquekey.inject.UniqueKeyGeneratorModule;
import jp.co.slcs.swak.util.schedule.ScheduleManager;
import jp.co.slcs.swak.util.security.SecurityPolicy;
import jp.co.slcs.swak.util.security.SecurityPolicyConfig;
import jp.co.slcs.swak.validation.Groups;
import jp.co.slcs.swak.web.action.ActionScoped;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import jp.co.slcs.swak.web.message.MessageResolver;
import jp.co.slcs.swak.web.processor.Preprocessor;
import jp.co.slcs.swak.web.servlet.ServletInitializer;
import yuyu.common.workflowcore.WorkflowAuthInfo;
import yuyu.common.workflowcore.WorkflowAuthInfoImpl;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_BatchKidouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.aop.ActionInterceptor;
import yuyu.infr.batchclient.YuyuBatchClient;
import yuyu.infr.message.YuyuMessageResolver;
import yuyu.infr.processor.YuyuPreprocessor;
import yuyu.infr.security.YuyuSecurityPolicy;
import yuyu.infr.uniquekey.YuyuAppIdentifierManager;
import yuyu.infr.web.YuyuServletInitializer;

import com.google.common.base.Strings;
import com.google.inject.Provides;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import com.google.inject.servlet.SessionScoped;

/**
 * ゆうゆう生保Webアプリケーションの実装クラスバインディング定義を行う Google Guice 用の設定モジュールです。
 */
public class YuyuWebModule extends UniqueKeyGeneratorModule implements ServiceInitializer, ServiceTerminator {

    @Override
    protected void configure() {
        super.configure();

        bindScope(BatchScoped.class, ThreadScope.instance);

        bind(C_BatchKidouKbn.class).toInstance(C_BatchKidouKbn.GAMEN);

        bind(ServletInitializer .class).to(YuyuServletInitializer    .class);
        bind(SecurityPolicy     .class).to(YuyuSecurityPolicy        .class);
        bind(MessageResolver    .class).to(YuyuMessageResolver       .class);
        bind(Preprocessor       .class).to(YuyuPreprocessor          .class);
        bind(AbstractBatchClient.class).to(YuyuBatchClient           .class);

        bind(WorkflowAuthInfo.class).to(WorkflowAuthInfoImpl.class).in(SessionScoped.class);

        bindInstance(SecurityPolicyConfig.instance);

        bind(AS_Kinou                     .class)
            .toProvider(KinouProvider     .class)
            .in(ActionScoped              .class);

        bind(String                       .class)
            .annotatedWith(Names.named(RequestUriProvider.BIND_NAME))
            .toProvider(RequestUriProvider.class)
            .in(ConversationScoped        .class);

        bindInterceptor(
                Matchers.annotatedWith(UIBean.class),
                new AbstractMatcher<Method>() {
                    @Override
                    public boolean matches(Method pMethod) {
                        return pMethod.getDeclaringClass().isAnnotationPresent(UIBean.class);
                    }
                },
                ActionInterceptor.instance
                );

    }

    @Override
    protected UniqueKeyGenerator getUniqueKeyGenerator() {
        return new UnitUniqueKeyGenerator();
    }

    @Override
    protected Class<? extends AppIdentifierManager> getAppIdentifierManagerClass() {
        return YuyuAppIdentifierManager.class;
    }

    @Override
    public void initialize() {
        initValidationGroups();
    }

    protected void initValidationGroups() {
        String groupPackage = YuyuBaseConfig.getInstance().getValidationGroupsPackage();
        if (!Strings.isNullOrEmpty(groupPackage)) {
            Groups.addFromPackage(groupPackage);
        }
        Groups.freeze();
    }

    @Override
    public void terminate() {
        SWAKInjector.getInstance(ScheduleManager.class).terminate();
    }

    @Provides
    @Named("userId")
    protected String provideUserId(Credentials c) {
        return c == null ? null : c.getUsername();
    }

    @Provides
    @BatchScoped
    @Named("batchSyoriYmd")
    protected BizDate provideBatchSyoriYmd(BaseDomManager domManager) {
        BizDate syoriYmd = domManager.getBatchDate();
        if (syoriYmd == null) {
            throw new BizAppException("バッチ実行日更新が一度も実行されていません。");
        }
        return syoriYmd;
    }
}

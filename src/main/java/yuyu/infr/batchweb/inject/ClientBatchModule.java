package yuyu.infr.batchweb.inject;

import jp.co.slcs.swak.core.inject.AbstractSWAKModule;
import jp.co.slcs.swak.web.aop.UiBeanLogger;
import yuyu.infr.batchweb.interceptors.ClientInterceptor;
/**
 * クライアントバッチモジュール
 */
public class ClientBatchModule extends AbstractSWAKModule {

    @Override
    protected void configure() {

        bindInterceptor(UiBeanLogger.actionClassMatcher,UiBeanLogger.eventHandlerMethodMatcher,
                ClientInterceptor.INSTANCE);
    }

}

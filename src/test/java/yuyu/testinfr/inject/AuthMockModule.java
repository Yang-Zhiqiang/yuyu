package yuyu.testinfr.inject;

import yuyu.infr.inject.YuyuCommonModule;

/**
 * 認証情報テスト用インジェクトモジュール
 */
public class AuthMockModule extends YuyuCommonModule {
    @Override
    protected void configure() {
        super.configure();

        //        bind(RayHttpHeaderBean.class).to(RayHttpHeaderBeanMock.class);
    }
}
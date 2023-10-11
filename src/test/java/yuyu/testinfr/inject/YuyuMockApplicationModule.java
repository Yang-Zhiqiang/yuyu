package yuyu.testinfr.inject;


import yuyu.infr.inject.YuyuWebModule;

public class YuyuMockApplicationModule extends YuyuWebModule {

    @Override
    protected void configure() {
        super.configure();
        //        bind(Credentials .class).to(MockCredentials .class);
        //        bind(OutputReport.class).to(MockOutputReport.class);
        //        bind(FileHozonUtil.class).to(MockFileHozonUtil.class);

        //        bind(BaseUserInfo.class).to(MockBaseUserInfo.class);
        //        bind(BizUserInfo.class).to(MockBizUserInfo.class);
        //        bind(BosyuuUserInfo.class).to(MockBosyuuUserInfo.class);
    }

    @Override
    public void initialize() {
        //      Pages.initialize();
        initValidationGroups();
    }
}

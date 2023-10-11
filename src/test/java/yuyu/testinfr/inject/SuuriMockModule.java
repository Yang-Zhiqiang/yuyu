package yuyu.testinfr.inject;

import yuyu.common.suuri.inject.SuuriCommonModule;

/**
 * 数理共通テスト用インジェクトモジュール
 */
public class SuuriMockModule extends SuuriCommonModule {
    @Override
    protected void configure() {
        super.configure();
        //
        //        bind(SrSuuriKbnHenkanSet.class).to(SrSuuriKbnHenkanSetMock.class);
        //        bind(SrSuuriGouseiRateKeisan.class).to(SrSuuriGouseiRateKeisanMock.class);
        //        bind(SrGetTokutejitenSyohnInfo.class).to(SrGetTokutejitenSyohnInfoMock.class);
    }
}
package yuyu.testinfr.inject;

import yuyu.common.bosyuu.inject.BosyuuCommonModule;

/**
 * 保険募集テスト用インジェクトモジュール
 */
public class BosyuuMockModule extends BosyuuCommonModule {
    @Override
    protected void configure() {
        super.configure();

        //        bind(HbSeihoWebHanteiKengen.class).to(HbSeihoWebHanteiKengenMock.class);

    }

}

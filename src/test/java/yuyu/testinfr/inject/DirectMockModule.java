package yuyu.testinfr.inject;

import yuyu.common.direct.inject.DirectCommonModule;

/**
 * 業務共通テスト用インジェクトモジュール
 */
public class DirectMockModule extends DirectCommonModule {
    @Override
    protected void configure() {
        super.configure();
        //        bind(HozenKeiyakuIdouJyoutaiSyutoku.class).to(HozenKeiyakuIdouJyoutaiSyutokuMock.class);
        //
        //        bind(DsDB2Util.class).to(DsDB2UtilMock.class);
        //
        //        bind(DsGetKeiyakuSyousai.class).to(DsGetKeiyakuSyousaiMock.class);
        //
        //        bind(DsNayose.class).to(DsNayoseMock.class);
        //
        //        bind(CheckDsKaiyaku.class).to(CheckDsKaiyakuMock.class);
        //
        //        bind(DsGetKeiyakuCommon.class).to(DsGetKeiyakuCommonMock.class);
        //
        //        bind(DsGetSeigyo.class).to(DsGetSeigyoMock.class);
        //
        //        bind(GetDairitenKobetuJyouhou.class).to(GetDairitenKobetuJyouhouMock.class);
        //
        //        bind(CheckDsTorihikiService.class).to(CheckDsTorihikiServiceMock.class);
        //
        //        bind(DsTumitatekinItenCheck.class).to(DsTumitatekinItenCheckMock.class);
        //
        //        bind(DsSaibanSyori.class).to(DsSaibanSyoriMock.class);
        //
        //        bind(CheckKaiyakuUketuke.class).to(CheckKaiyakuUketukeMock.class);
        //
        //        bind(DsDataMaintenanceHantei.class).to(DsDataMaintenanceHanteiMock.class);

    }
}
package yuyu.testinfr.inject;

import yuyu.common.hozen.inject.HozenCommonModule;


/**
 * 契約保全テスト用インジェクトモジュール
 */
public class HozenMockModule extends HozenCommonModule {
    @Override
    protected void configure() {

        super.configure();

        //        bind(KhozenCommonParam.class).to(KhozenCommonParamMock.class);
        //
        //        bind(EditKhHenkouRirekiTbl.class).to(EditKhHenkouRirekiTblMock.class);
        //
        //        bind(SyouhntaniKousingoPkeisan.class).to(SyouhntaniKousingoPkeisanMock.class);
        //
        //        bind(KeisanKihrkP.class).to(KeisanKihrkPMock.class);
        //
        //        bind(BzSakuinTsnSyoukaiMq.class).to(BzSakuinTsnSyoukaiMqMock.class);
        //
        //        bind(KeisanHtyKeihi.class).to(KeisanHtyKeihiMock.class);
        //
        //        bind(KeisanV.class).to(KeisanVMock.class);
        //
        //        bind(TokujoSSakugenNaiyouKeisan.class).to(TokujoSSakugenNaiyouKeisanMock.class);
        //
        //        bind(KeisanWKijunYM.class).to(KeisanWKijunYMMock.class);
        //
        //        bind(KeisanSP.class).to(KeisanSPMock.class);
        //
        //        bind(KeisanCV.class).to(KeisanCVMock.class);
        //
        //        bind(PALBetuSakuinSyoukai.class).to(PALBetuSakuinSyoukaiMock.class);
        //
        //        bind(SetDenSimebi.class).to(SetDenSimebiMock.class);
        //
        //        bind(SyouhnTaniKeisanMsyMkeiP.class).to(SyouhnTaniKeisanMsyMkeiPMock.class);
        //
        //        bind(EditSyoukenTbl.class).to(EditSyoukenTblMock.class);
        //
        //        bind(EditKoujyoSyoumeiTbl.class).to(EditKoujyoSyoumeiTblMock.class);
        //
        //        bind(EditSuiihyouTbl.class).to(EditSuiihyouTblMock.class);
        //
        //        bind(EditSeikyuusyoTbl.class).to(EditSeikyuusyoTblMock.class);
        //
        //        bind(WSuiihyou.class).to(WSuiihyouMock.class);
        //
        //        bind(WSuiihyouSyuusin2.class).to(WSuiihyouSyuusin2Mock.class);
        //
        //        bind(KeisanWItiji.class).to(KeisanWItijiMock.class);
        //
        //        bind(SetYuuyokknmanryobi.class).to(SetYuuyokknmanryobiMock.class);
        //
        //        bind(KeisanGaikaItijiSkHiritu.class).to(KeisanGaikaItijiSkHirituMock.class);
        //
        //        bind(EditTtdkKanryouTbl.class).to(EditTtdkKanryouTblMock.class);
        //
        //        bind(KhHituyousyoruiHantei.class).to(KhHituyousyoruiHanteiMock.class);
        //
        //        bind(KeisanKijyungk.class).to(KeisanKijyungkMock.class);
        //
        //        bind(SetOutoubi.class).to(SetOutoubiMock.class);
        //
        //        bind(SetKessanNensibi.class).to(SetKessanNensibiMock.class);
        //
        //        bind(KhCheckBankMaster.class).to(KhCheckBankMasterMock.class);
        //
        //        bind(EditKykSyhnRirekiTbl.class).to(EditKykSyhnRirekiTblMock.class);
        //
        //        bind(CommonSiwake.class).to(CommonSiwakeMock.class);
        //
        //        bind(EditDairitenTesuuryouTbl.class).to(EditDairitenTesuuryouTblMock.class);
        //
        //        bind(CheckYuukouJyoutai.class).to(CheckYuukouJyoutaiMock.class);
        //
        //        bind(HanteiTetuduki.class).to(HanteiTetudukiMock.class);
        //
        //        bind(CheckKaiyaku.class).to(CheckKaiyakuMock.class);
        //
        //        bind(CalcHkShrKngk.class).to(CalcHkShrKngkMock.class);
        //
        //        bind(KeisanWExt.class).to(KeisanWExtMock.class);
        //
        //        bind(KeisanW.class).to(KeisanWMock.class);
        //
        //        bind(KeisanSisuuRendouNkKykTmttkn.class).to(KeisanSisuuRendouNkKykTmttknMock.class);
        //
        //        bind(CheckTmttkinIten.class).to(CheckTmttkinItenMock.class);
        //
        //        bind(KeisanSisuuRendouNkTmttkn.class).to(KeisanSisuuRendouNkTmttknMock.class);
        //
        //        bind(WSuiihyouNenkin.class).to(WSuiihyouNenkinMock.class);
        //
        //        bind(KeisanTmHntiSisuuRendouTmttkn.class).to(KeisanTmHntiSisuuRendouTmttknMock.class);
        //
        //        bind(KeisanNkNengk.class).to(KeisanNkNengkMock.class);
        //
        //        bind(SetHurikaebi.class).to(SetHurikaebiMock.class);
        //
        //        bind(KeisanIkkatuWaribikiP.class).to(KeisanIkkatuWaribikiPMock.class);
        //
        //        bind(CheckZeiseiTkkkTkykHukaJyouken.class).to(CheckZeiseiTkkkTkykHukaJyoukenMock.class);
        //
        //        bind(KeisanIkkatuPGk.class).to(KeisanIkkatuPGkMock.class);
        //
        //        bind(CheckDShrSibou.class).to(CheckDShrSibouMock.class);
        //
        //        bind(KeisanZennouNyuukinGk.class).to(KeisanZennouNyuukinGkMock.class);
        //
        //        bind(GetZennouKikanRiritu.class).to(GetZennouKikanRirituMock.class);
        //
        //        bind(GetKhTuusanyouKngk.class).to(GetKhTuusanyouKngkMock.class);
        //
        //        bind(SetHokenNnd.class).to(SetHokenNndMock.class);
        //
        //        bind(CheckYuuyokkngai.class).to(CheckYuuyokkngaiMock.class);
        //
        //        bind(CheckKzhuriKouza.class).to(CheckKzhuriKouzaMock.class);
        //
        //        //        bind(CheckDShrKaiyaku.class).to(CheckDShrKaiyakuMock.class);
        //
        //        bind(KeisanIkkatuNyuukinGk.class).to(KeisanIkkatuNyuukinGkMock.class);
        //
        //        bind(EditKoujyonaiyouTbl.class).to(EditKoujyonaiyouTblMock.class);
        //
        //        bind(AnsyuuCommonSiwake.class).to(AnsyuuCommonSiwakeMock.class);
        //
        //        bind(KeisanVHeijyun.class).to(KeisanVHeijyunMock.class);
        //
        //        bind(KeisanZennouKoujyogaku.class).to(KeisanZennouKoujyogakuMock.class);
        //
        //        bind(KoujyoSyoumeiUtil.class).to(KoujyoSyoumeiUtilMock.class);
        //
        //        bind(KeisanGaikaP.class).to(KeisanGaikaPMock.class);
        //
        //        bind(JtKaisukeisan.class).to(JtKaisukeisanMock.class);
        //
        //        bind(KeisanWHeijyun.class).to(KeisanWHeijyunMock.class);
        //
        //        bind(KeisanDCommonSibou.class).to(KeisanDCommonSibouMock.class);
        //
        //        bind(KeisanZennouSeisanGk.class).to(KeisanZennouSeisanGkMock.class);
        //
        //        bind(KeisanMsyMkeiP.class).to(KeisanMsyMkeiPMock.class);
        //
        //        //        bind(KeisanDCommonKaiyaku.class).to(KeisanDCommonKaiyakuMock.class);
        //
        //        bind(KeisanKhGensen.class).to(KeisanKhGensenMock.class);
        //
        //        bind(KeisanPJyuutougk.class).to(KeisanPJyuutougkMock.class);
        //
        //        bind(GetDRiritu.class).to(GetDRirituMock.class);
        //
        //        bind(AnsyuuSetTetudukityuuiInfo.class).to(AnsyuuSetTetudukityuuiInfoMock.class);
        //
        //        bind(SetDNnd.class).to(SetDNndMock.class);
        //
        //        bind(NaiteiKakuteiRateHantei.class).to(NaiteiKakuteiRateHanteiMock.class);
        //
        //        bind(CheckDSeigou.class).to(CheckDSeigouMock.class);
        //
        //        bind(CheckDJyoutai.class).to(CheckDJyoutaiMock.class);
        //
        //        bind(BzGetSosikiMadogutiInfo.class).to(BzGetSosikiMadogutiInfoMock.class);
        //
        //        bind(BzGetBankData.class).to(BzGetBankDataMock.class);
        //
        //        bind(CommonSiwakeUtil.class).to(CommonSiwakeUtilMock.class);
        //
        //        bind(DBAccessDCommon.class).to(DBAccessDCommonMock.class);
        //
        //        bind(EditSeihowebIdouRirekiTbl.class).to(EditSeihowebIdouRirekiTblMock.class);
        //
        //        bind(KeisanD.class).to(KeisanDMock.class);
        //
        //        //        bind(KeisanDGanrikin.class).to(KeisanDGanrikinMock.class);
        //
        //        bind(KeisanVHeijyunTangetu.class).to(KeisanVHeijyunTangetuMock.class);
        //
        //        bind(EditSyoukenTblNenkin2.class).to(EditSyoukenTblNenkin2Mock.class);
        //
        //        bind(EditSyoukenTblSyuusin.class).to(EditSyoukenTblSyuusinMock.class);
        //
        //        bind(EditSyoukenTblNenkin.class).to(EditSyoukenTblNenkinMock .class);
        //
        //        bind(EditKykNaiyouOsirase1.class).to(EditKykNaiyouOsirase1Mock .class);
        //
        //        bind(EditKykNaiyouOsirase2.class).to(EditKykNaiyouOsirase2Mock .class);
        //
        //        bind(EditKykNaiyouOsirase3.class).to(EditKykNaiyouOsirase3Mock .class);
        //
        //        bind(EditKykNaiyouOsiraseKytKm.class).to(EditKykNaiyouOsiraseKytKmMock .class);
        //
        //        bind(KeisanHrrtksnHrkPGkgk.class).to(KeisanHrrtksnHrkPGkgkMock.class);
        //
        //        bind(KeisanDCommonDShr.class).to(KeisanDCommonDShrMock .class);
        //
        //        bind(WSuiihyouNenkin2.class).to(WSuiihyouNenkin2Mock .class);
        //
        //        bind(HanteiKhSisuurendoTmttknJyoutai.class).to(HanteiKhSisuurendoTmttknJyoutaiMock.class);
        //
        //        bind(KeisanSisuuRendouNkTmttknYendtHnk.class).to(KeisanSisuuRendouNkTmttknYendtHnkMock.class);
        //
        //        bind(KeisanCommonKaiyaku.class).to(KeisanCommonKaiyakuMock.class);

        //        bind(KeisanTeikishrkin.class).to(KeisanTeikishrkinMock.class);
    }
}

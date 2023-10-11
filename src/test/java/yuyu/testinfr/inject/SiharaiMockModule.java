package yuyu.testinfr.inject;

import yuyu.common.siharai.inject.SiharaiCommonModule;

/**
 * 保険金給付金支払テスト用インジェクトモジュール
 */
public class SiharaiMockModule extends SiharaiCommonModule {
    @Override
    protected void configure() {

        super.configure();

        //        bind(SiMsgHikisuuSettei.class).to(SiMsgHikisuuSetteiMock.class);
        //        bind(KeiyakuInfoSyutoku.class).to(KeiyakuInfoSyutokuMock.class);
        //        bind(ChkSubSksInfo.class).to(ChkSubSksInfoMock.class);
        //        bind(SiharaiPreReportRenkeiBean.class).to(SiharaiPreReportRenkeiBeanMock.class);
        //        bind(SiSetUiBean.class).to(SiSetUiBeanMock.class);
        //        bind(CalcHkShrKngk.class).to(CalcHkShrKngkMock.class);
        //        bind(CalcHkHtykeihi.class).to(CalcHkHtykeihiMock.class);
        //        bind(ChkSubSksyaInfo.class).to(ChkSubSksyaInfoMock.class);
        //        bind(ChkSubSinkensyaInfo.class).to(ChkSubSinkensyaInfoMock.class);
        //        bind(ChkSubShskInfo.class).to(ChkSubShskInfoMock.class);
        //        bind(ChkSubhassoKbn.class).to(ChkSubhassoKbnMock.class);
        //        bind(ChkSubHonninkakunin.class).to(ChkSubHonninkakuninMock.class);
        //        bind(ChkSubKijyunYmd.class).to(ChkSubKijyunYmdMock.class);
        //        bind(ChkSubGeninKbn.class).to(ChkSubGeninKbnMock.class);
        //        bind(ChkSubSyoumetu.class).to(ChkSubSyoumetuMock.class);
        //        bind(ChkSubDoujiSeikyuuSyori.class).to(ChkSubDoujiSeikyuuSyoriMock.class);
        //        bind(ChkSubKhSyorityuu.class).to(ChkSubKhSyorityuuMock.class);
        //        bind(ChkSubSknnKaisiYmd.class).to(ChkSubSknnKaisiYmdMock.class);
        //        bind(ChkSubHknKkn.class).to(ChkSubHknKknMock.class);
        //        bind(ChkSubTtdktyuui.class).to(ChkSubTtdktyuuiMock.class);
        //        bind(ChkSubUketorinin.class).to(ChkSubUketorininMock.class);
        //        bind(ChkSubSinsaTyuui.class).to(ChkSubSinsaTyuuiMock.class);
        //        bind(ChkSubMRFKouzaTratki.class).to(ChkSubMRFKouzaTratkiMock.class);
        //        bind(SiSKNaiyouChkkekkaSettei.class).to(SiSKNaiyouChkkekkaSetteiMock.class);
        //        bind(ChkSubJisatuMenseki.class).to(ChkSubJisatuMensekiMock.class);
        //        bind(ChkSubSknnKaisiYmdSatei.class).to(ChkSubSknnKaisiYmdSateiMock.class);
        //        bind(ChkSubMeigihenkou.class).to(ChkSubMeigihenkouMock.class);
        //        bind(ChkSubStknset.class).to(ChkSubStknsetMock.class);
        //        bind(ChkSubHasanTousan.class).to(ChkSubHasanTousanMock.class);
        //        bind(ChkSubSasiosae.class).to(ChkSubSasiosaeMock.class);
        //        bind(ChkSubSousasyoukai.class).to(ChkSubSousasyoukaiMock.class);
        //        bind(ChkSubHusyounosi.class).to(ChkSubHusyounosiMock.class);
        //        bind(ChkSubKaigaiSb.class).to(ChkSubKaigaiSbMock.class);
        //        bind(ChkSubHansya.class).to(ChkSubHansyaMock.class);
        //        bind(ChkSubSkSyorui.class).to(ChkSubSkSyoruiMock.class);
        //        bind(SiSateiKmkChkkekkaSettei.class).to(SiSateiKmkChkkekkaSetteiMock.class);
        //        bind(SetteiShrhousiteiKbn.class).to(SetteiShrhousiteiKbnMock.class);
        //        bind(SiHituyousyoruiHantei.class).to(SiHituyousyoruiHanteiMock.class);
        //        bind(CalcJdkghkKngk.class).to(CalcJdkghkKngkMock.class);
        //
        //        bind(ChkSubUketoriHouhou.class).to(ChkSubUketoriHouhouMock.class);
        //        bind(ChkSubSaigaiGaitou.class).to(ChkSubSaigaiGaitouMock.class);
        //        bind(ChkSubSaikenInfo.class).to(ChkSubSaikenInfoMock.class);
        //        bind(ChkSubSaisatei.class).to(ChkSubSaisateiMock.class);
        //        bind(ChkSubSaikenKaiykMouside.class).to(ChkSubSaikenKaiykMousideMock.class);
        //        bind(ChkSubSaisateiSatei.class).to(ChkSubSaisateiSateiMock.class);
        //        bind(SaigaiGaitouHantei.class).to(SaigaiGaitouHanteiMock.class);
        //        bind(JisatuMensekiKikanHantei.class).to(JisatuMensekiKikanHanteiMock.class);
        //
        //        bind(ChkSubKeiyakusyaHnk.class).to(ChkSubKeiyakusyaHnkMock.class);
        //        bind(ChkSubDsKaiykSyori.class).to(ChkSubDsKaiykSyoriMock.class);
        //        bind(ChkSubKykYmd.class).to(ChkSubKykYmdMock.class);
        //        bind(ChkSubEndtHenkouYmd.class).to(ChkSubEndtHenkouYmdMock.class);
        //        bind(ChkSubHnrkinMbr.class).to(ChkSubHnrkinMbrMock.class);
        //        bind(ChkSubSgSbJisatuMenseki.class).to(ChkSubSgSbJisatuMensekiMock.class);
        //        bind(ChkSubD.class).to(ChkSubDMock.class);
        //        bind(ChkSubPHrkmYuuyokkn.class).to(ChkSubPHrkmYuuyokknMock.class);
        //
        //        bind(CalcHkShrKngkItijibrSysn.class).to(CalcHkShrKngkItijibrSysnMock.class);
        //        bind(CalcHkShrKngkItijibrKojinNk.class).to(CalcHkShrKngkItijibrKojinNkMock.class);
        //        bind(CalcHkKngkHijynbrKojinNk.class).to(CalcHkKngkHijynbrKojinNkMock.class);
        //        bind(SiMeisaiCommonHensyu.class).to(SiMeisaiCommonHensyuMock.class);
        //        bind(GetSibouymdW.class).to(GetSibouymdWMock.class);
        //        bind(ChkSubTmttknJyoutai.class).to(ChkSubTmttknJyoutaiMock.class);

    }
}

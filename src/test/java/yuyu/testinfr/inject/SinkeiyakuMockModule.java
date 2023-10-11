package yuyu.testinfr.inject;

import yuyu.common.sinkeiyaku.inject.SinkeiyakuCommonModule;

/**
 * 新契約テスト用インジェクトモジュール
 */
public class SinkeiyakuMockModule extends SinkeiyakuCommonModule {
    @Override
    protected void configure() {
        super.configure();

        //        bind(GetLincTourokuS.class).to(GetLincTourokuSMock.class);
        //
        //        bind(HanteiZennouKaisuu.class).to(HanteiZennouKaisuuMock.class);
        //
        //        bind(EditTblAtukaisya.class).to(EditTblAtukaisyaMock.class);
        //
        //        bind(SkHituyousyoruiHantei.class).to(SkHituyousyoruiHanteiMock.class);
        //
        //        bind(SkProcessCreate.class).to(SkProcessCreateMock.class);
        //
        //        bind(SkProcessForwardKetteiHoryuuHubiOnline.class).to(SkProcessForwardKetteiHoryuuHubiOnlineMock.class);
        //
        //        bind(GetDairitenInfo.class).to(GetDairitenInfoMock.class);
        //
        //        bind(GetSkChannelInfo.class).to(GetSkChannelInfoMock.class);
        //
        //        bind(GetUktYouFlg.class).to(GetUktYouFlgMock.class);
        //
        //        bind(KeisanSP.class).to(KeisanSPMock.class);
        //
        //        bind(CheckSaiteiP.class).to(CheckSaiteiPMock.class);
        //
        //        bind(HandSateiKetteiHantei.class).to(HandSateiKetteiHanteiMock.class);
        //
        //        bind(GetRsgakukei.class).to(GetRsgakukeiMock.class);
        //
        //        bind(SetSknnkaisiymd.class).to(SetSknnkaisiymdMock.class);
        //
        //        bind(CheckTblNyuukinHenkin.class).to(CheckTblNyuukinHenkinMock.class);
        //
        //        bind(SetSyouhinSedai.class).to(SetSyouhinSedaiMock.class);
        //
        //        bind(CheckHatubaikkn.class).to(CheckHatubaikknMock.class);
        //
        //        bind(SetHutuuSibouS.class).to(SetHutuuSibouSMock.class);
        //
        //        bind(GetKiteiCheckYenkansangk.class).to(GetKiteiCheckYenkansangkMock.class);
        //
        //        bind(SetKisoKoumoku.class).to(SetKisoKoumokuMock.class);
        //
        //        bind(Nayose.class).to(NayoseMock.class);
        //
        //        bind(CheckTblMosDairiten.class).to(CheckTblMosDairitenMock.class);
        //
        //        bind(CheckTblMosKihon.class).to(CheckTblMosKihonMock.class);
        //
        //        bind(CheckTblMosSyouhin.class).to(CheckTblMosSyouhinMock.class);
        //
        //        bind(CheckTblUketorinin.class).to(CheckTblUketorininMock.class);
        //
        //        bind(CheckSentakujyouhou.class).to(CheckSentakujyouhouMock.class);
        //
        //        bind(CheckFatca.class).to(CheckFatcaMock.class);
        //
        //        bind(CheckTblKouzaJyouhou.class).to(CheckTblKouzaJyouhouMock.class);
        //
        //        bind(CheckTblKokutisyo.class).to(CheckTblKokutisyoMock.class);
        //
        //        bind(SetSP.class).to(SetSPMock.class);
        //
        //        bind(CheckSP.class).to(CheckSPMock.class);
        //
        //        bind(CheckSkTuusan.class).to(CheckSkTuusanMock.class);
        //
        //        bind(CheckTuusan.class).to(CheckTuusanMock.class);
        //
        //        bind(HanteiKykKakunin.class).to(HanteiKykKakuninMock.class);
        //
        //        bind(SateiKetteiJissiRuleHantei.class).to(SateiKetteiJissiRuleHanteiMock.class);
        //
        //        bind(CheckNyuukin.class).to(CheckNyuukinMock.class);
        //
        //        bind(CheckHubiKanri.class).to(CheckHubiKanriMock.class);
        //
        //        bind(CheckSeirituHoryuu.class).to(CheckSeirituHoryuuMock.class);
        //
        //        bind(Seiritu.class).to(SeirituMock.class);
        //
        //        bind(EditPrintFile.class).to(EditPrintFileMock.class);
        //
        //        bind(HanteiHituyouSyorui.class).to(HanteiHituyouSyoruiMock.class);
        //
        //        bind(Kettei.class).to(KetteiMock.class);
        //
        //        bind(SetSateijt.class).to(SetSateijtMock.class);
        //
        //        bind(JidouSetSyokika.class).to(JidouSetSyokikaMock.class);
        //
        //        bind(ConvertChannelcd.class).to(ConvertChannelcdMock.class);
        //
        //        bind(CheckYoteiKykYmd.class).to(CheckYoteiKykYmdMock.class);
        //
        //        bind(EditSeihoWebRenkeiKoumoku.class).to(EditSeihoWebRenkeiKoumokuMock.class);
        //
        //        bind(SeihowebMosnaiCheck.class).to(SeihowebMosnaiCheckMock.class);
        //
        //        bind(GetSinkeiyakuGuidance.class).to(GetSinkeiyakuGuidanceMock.class);
        //
        //        bind(SkPreSyoruiTorikomi.class).to(SkPreSyoruiTorikomiMock.class);
        //
        //        bind(CheckSbUktHhkn.class).to(CheckSbUktHhknMock.class);
        //
        //        bind(CheckUktBnWari.class).to(CheckUktBnWariMock.class);
        //
        //        bind(CheckSeiYmd.class).to(CheckSeiYmdMock.class);
        //
        //        bind(SetKyuuhuNitigaku.class).to(SetKyuuhuNitigakuMock.class);
        //
        //        bind(CheckMRKanren.class).to(CheckMRKanrenMock.class);
        //
        //        bind(SetHubiMsg.class).to(SetHubiMsgMock.class);
        //
        //        bind(GetSyoruicd.class).to(GetSyoruicdMock.class);
        //
        //        bind(SkProcessForwardMoschkExec.class).to(SkProcessForwardMoschkExecMock.class);
        //
        //        bind(SkProcessForwardTeisei.class).to(SkProcessForwardTeiseiMock.class);
        //
        //        bind(SkProcessForwardMoschkExecBatch.class).to(SkProcessForwardMoschkExecBatchMock.class);
        //
        //        bind(HubiMsgEdit.class).to(HubiMsgEditMock.class);
        //
        //        bind(CheckDoujiMos.class).to(CheckDoujiMosMock.class);
        //
        //        bind(SkProcessForwardSeiritu.class).to(SkProcessForwardSeirituMock.class);
        //
        //        bind(CheckNkUktKbn.class).to(CheckNkUktKbnMock.class);
        //
        //        bind(HanteiMoschk.class).to(HanteiMoschkMock.class);
        //
        //        bind(EditPdfYoteirirtu.class).to(EditPdfYoteirirtuMock.class);
        //
        //        bind(EditNenkinKoumokuUtil.class).to(EditNenkinKoumokuUtilMock.class);
        //
        //        bind(EditDairitenAtesaki.class).to(EditDairitenAtesakiMock.class);
        //
        //        bind(GetHknsyuruinm.class).to(GetHknsyuruinmMock.class);
        //
        //        bind(GetDairitenKobetuJyouhou.class).to(GetDairitenKobetuJyouhouMock.class);
        //
        //        bind(MousikomiNoUtil.class).to(MousikomiNoUtilMock.class);
        //
        //        bind(SyouhinUtil.class).to(SyouhinUtilMock.class);
        //
        //        bind(ConvNenSaiManki.class).to(ConvNenSaiMankiMock.class);
        //
        //        bind(EditHeijyunbaraiP.class).to(EditHeijyunbaraiPMock.class);
        //
        //        bind(CheckHrkKeiro.class).to(CheckHrkKeiroMock.class);
        //
        //        bind(CheckZennouKanren.class).to(CheckZennouKanrenMock.class);
        //
        //        bind(CheckKykSeiYmdKanren.class).to(CheckKykSeiYmdKanrenMock.class);
        //
        //        bind(CheckKykKanren.class).to(CheckKykKanrenMock.class);
        //
        //        bind(CheckNnknTokuyaku.class).to(CheckNnknTokuyakuMock.class);
        //
        //        bind(CheckPmentkKanren.class).to(CheckPmentkKanrenMock.class);
        //
        //        bind(DrtenTkykTratkiHantei.class).to(DrtenTkykTratkiHanteiMock.class);
        //
        //        bind(CheckUktNinzuu.class).to(CheckUktNinzuuMock.class);
        //
        //        bind(CheckHokenRyouYuukouKigen.class).to(CheckHokenRyouYuukouKigenMock.class);
        //
        //        bind(CheckKirikaeTratkikkn.class).to(CheckKirikaeTratkikknMock.class);
        //
        //        bind(CheckLivHuka.class).to(CheckLivHukaMock.class);
        //
        //        bind(CheckSntkHouSyouhin.class).to(CheckSntkHouSyouhinMock.class);
        //
        //        bind(CheckHrkKaisuu.class).to(CheckHrkKaisuuMock.class);
        //
        //        bind(CheckMeigininNmKanaCall.class).to(CheckMeigininNmKanaCallMock.class);
        //
        //        bind(CheckTelNoCall.class).to(CheckTelNoCallMock.class);
        //
        //        bind(CheckKykSeibetu.class).to(CheckKykSeibetuMock.class);
        //
        //        bind(HanteiKirikaeYuukou.class).to(HanteiKirikaeYuukouMock.class);
        //
        //        bind(CheckShiteiKeiyakubi.class).to(CheckShiteiKeiyakubiMock.class);
        //
        //        //bind(SkZennouIkkatuUtil.class).to(SkZennouIkkatuUtilMock.class);
        //
        //        bind(CheckYakkanJyuryouHouhou.class).to(CheckYakkanJyuryouHouhouMock.class);
    }
}
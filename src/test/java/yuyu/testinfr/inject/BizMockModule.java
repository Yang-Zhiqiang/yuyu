package yuyu.testinfr.inject;

import yuyu.common.biz.inject.BizCommonModule;

/**
 * 業務共通テスト用インジェクトモジュール
 */
public class BizMockModule extends BizCommonModule {
    @Override
    protected void configure() {
        super.configure();

        //        bind(BzGetImageProps.class).to(BzGetImagePropsMock.class);
        //
        //        bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMock.class);
        //
        //        bind(BzProcessForward.class).to(BzProcessForwardMock.class);
        //
        //        bind(GetSyoruittykymd.class).to(GetSyoruittykymdMock.class);
        //
        //        bind(GetProgressHistory.class).to(GetProgressHistoryMock.class);
        //
        //        bind(BzKykNaiyouHaneiMq.class).to(BzKykNaiyouHaneiMqMock.class);
        //
        //        bind(BzGetSousasyaSyozokuSosikiData.class).to(BzGetSousasyaSyozokuSosikiDataMock.class);
        //
        //        bind(UpdateJimustartymd.class).to(UpdateJimustartymdMock.class);
        //
        //        bind(BzTaskStart.class).to(BzTaskStartMock.class);
        //
        //        bind(SetWariateHukaInfo.class).to(SetWariateHukaInfoMock.class);
        //
        //        bind(BzWorkflowInfo.class).to(BzWorkflowInfoMock.class);
        //
        //        bind(BzProcessForwardForBatch.class).to(BzProcessForwardForBatchMock.class);
        //
        //        bind(BzLockProcess.class).to(BzLockProcessMock.class);
        //
        //        bind(SetKouteiKanriId.class).to(SetKouteiKanriIdMock.class);
        //        bind(BzUnlockProcess.class).to(BzUnlockProcessMock.class);
        //        bind(BzOutputProcessRecord.class).to(BzOutputProcessRecordMock.class);
        //
        //        bind(BzGetAgInfo.class).to(BzGetAgInfoMock.class);
        //
        //        bind(BzProcessCreate.class).to(BzProcessCreateMock.class);
        //
        //        bind(BzSakuinTsnSyoukaiMq.class).to(BzSakuinTsnSyoukaiMqMock.class);
        //        bind(BzFbSoukinDataSks.class).to(BzFbSoukinDataSksMock.class);
        //        bind(BzGkfbSoukinDataSks.class).to(BzGkfbSoukinDataSksMock.class);
        //        bind(CheckKinouModeKengen.class).to(CheckKinouModeKengenMock.class);
        //
        //        bind(BzGetAgInfoKinyuuKikan.class).to(BzGetAgInfoKinyuuKikanMock.class);
        //
        //        bind(BzGetBsInfoKouin.class).to(BzGetBsInfoKouinMock.class);
        //
        //        bind(BzGetBankData.class).to(BzGetBankDataMock.class);
        //
        //        bind(BzProcessForward.class).to(BzProcessForwardMock.class);
        //
        //        bind(BetukutiKeiyakuInfoGet.class).to(BetukutiKeiyakuInfoGetMock.class);
        //
        //        bind(GetAdrData.class).to(GetAdrDataMock.class);
        //
        //        bind(KeisanTienrisoku.class).to(KeisanTienrisokuMock.class);
        //
        //        bind(BzGetProcessRecord.class).to(BzGetProcessRecordMock.class);
        //
        //        bind(BzShiharaiDenpyouDateShutoku.class).to(BzShiharaiDenpyouDateShutokuMock.class);
        //
        //        bind(BzDenpyouDataSks.class).to(BzDenpyouDataSksMock.class);
        //
        //        bind(GetKawaseRate.class).to(GetKawaseRateMock.class);
        //
        //        bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMock.class);
        //
        //        bind(BzTrksTjtIdouNaiyouSakujyo.class).to(BzTrksTjtIdouNaiyouSakujyoMock.class);
        //
        //        bind(CheckKouzaNo.class).to(CheckKouzaNoMock.class);
        //
        //        bind(BzGetSosikiData.class).to(BzGetSosikiDataMock.class);
        //        bind(SiTienRisokuKikanKeisan.class).to(SiTienRisokuKikanKeisanMock.class);
        //
        //        bind(BzTrksIraiMq.class).to(BzTrksIraiMqMock.class);
        //
        //        bind(BzGetSosikiMadogutiInfo.class).to(BzGetSosikiMadogutiInfoMock.class);
        //
        //        bind(Tuusan.class).to(TuusanMock.class);
        //
        //        bind(MqApiCaller.class).to(MqApiCallerStub.class);
        //
        //        bind(DairitenTesuuryouInfoSyutoku.class).to(DairitenTesuuryouInfoSyutokuMock.class);
        //
        //        bind(BzGetBsInfo.class).to(BzGetBsInfoMock.class);
        //
        //        bind(GetSyoriKokouteiInfo.class).to(GetSyoriKokouteiInfoMock.class);
        //
        //        bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMock.class);
        //
        //        bind(IwfKouteiClient.class).to(IwfKouteiClientMock.class);
        //
        //        bind(BzProcessUpdate.class).to(BzProcessUpdateMock.class);
        //
        //        bind(BzContinueLockProcess.class).to(BzContinueLockProcessMock.class);
        //
        //        bind(BzEndProcess.class).to(BzEndProcessMock.class);
        //
        //        bind(BzForceProcessForward.class).to(BzForceProcessForwardMock.class);
        //
        //        bind(BzGetTuukeiBunwari.class).to(BzGetTuukeiBunwariMock.class);
        //
        //        bind(BzChkBsYuukou.class).to(BzChkBsYuukouMock.class);
        //
        //        bind(CheckTaskKengen.class).to(CheckTaskKengenMock.class);
        //
        //        bind(ConvertYuutyoSitencd.class).to(ConvertYuutyoSitencdMock.class);
        //
        //        bind(SetHokenNenrei.class).to(SetHokenNenreiMock.class);
        //
        //        bind(HanteiHokenKikan.class).to(HanteiHokenKikanMock.class);
        //
        //        bind(BzProcessUpdateForBatch.class).to(BzProcessUpdateForBatchMock.class);
        //
        //        bind(SetNenrei.class).to(SetNenreiMock.class);
        //
        //        bind(BzGetAdrData.class).to(BzGetAdrDataMock.class);
        //
        //        bind(BzGetExecutableTasks.class).to(BzGetExecutableTasksMock.class);
        //
        //        bind(BzSaibanNayose.class).to(BzSaibanNayoseMock.class);
        //
        //        bind(KeisanKyhNg.class).to(KeisanKyhNgMock.class);
        //
        //        bind(BzGetPrate.class).to(BzGetPrateMock.class);
        //
        //        bind(BzGetDrate.class).to(BzGetDrateMock.class);
        //
        //        bind(BzGyoumuCdSyutoku.class).to(BzGyoumuCdSyutokuMock.class);
        //
        //        bind(GetYoteiriritu.class).to(GetYoteirirituMock.class);
        //
        //        bind(GetSjkkktyouseiyouriritu.class).to(GetSjkkktyouseiyourirituMock.class);
        //
        //        bind(BzGetVrate.class).to(BzGetVrateMock.class);
        //
        //        bind(BzGetAgInfoJimusyo.class).to(BzGetAgInfoJimusyoMock.class);
        //
        //        bind(GetSisuu.class).to(GetSisuuMock.class);
        //
        //        bind(HenkanTuuka.class).to(HenkanTuukaMock.class);
        //
        //        bind(BzGetBsInfoBstrkno.class).to(BzGetBsInfoBstrknoMock.class);
        //
        //        bind(BzChkBsYuukouHengaku.class).to(BzChkBsYuukouHengakuMock.class);
        //
        //        bind(BzChkAgYuukou.class).to(BzChkAgYuukouMock.class);
        //
        //        bind(BzGetBuntanInfo.class).to(BzGetBuntanInfoMock.class);
        //
        //        bind(KeisanAzukariGanrikin.class).to(KeisanAzukariGanrikinMock.class);
        //
        //        bind(GetBunsyoNo.class).to(GetBunsyoNoMock.class);
        //
        //        bind(BzGetImage.class).to(BzGetImageMock.class);
        //
        //        bind(BzGetDairitenItakuSyouhn.class).to(BzGetDairitenItakuSyouhnMock.class);
    }
}
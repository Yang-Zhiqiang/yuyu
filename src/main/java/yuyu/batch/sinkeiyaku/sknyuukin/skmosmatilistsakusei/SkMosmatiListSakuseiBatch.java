package yuyu.batch.sinkeiyaku.sknyuukin.skmosmatilistsakusei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.sinkeiyaku.skcommon.GetNyuukinOyadrtenNm;
import yuyu.common.sinkeiyaku.skcommon.GetSkChannelInfo;
import yuyu.common.sinkeiyaku.skcommon.GetSyoruicd;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.db.entity.HT_HrkmNyknData;
import yuyu.def.db.entity.HV_MosSyoruiMitoutyakuList;
import yuyu.def.sinkeiyaku.bean.report.SkMossyoruijyoukyoulistDataSourceBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 入金 申込書類未到着リスト作成
 */
public class SkMosmatiListSakuseiBatch implements Batch {

    private final String MOS_SYORUI_SOUHU_JKLIST = "申込書類送付状況リスト";

    private final String OYA_DRTEN_CD_INIT = "####";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        long syoriKensuu = 0;

        String sysTime = BizDate.getSysDateTimeMilli();

        BzGetSosikiData getSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        GetNyuukinOyadrtenNm getNyuukinOyadrtenNm = SWAKInjector.getInstance(GetNyuukinOyadrtenNm.class);

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

        String beforeOyaDrtenCd = OYA_DRTEN_CD_INIT;

        String oyaDairitenNm = "";

        String utdskknnm1kj = "";

        String utdskknnm2kj = "";

        List<IReportDataSouceBean> sMDSList = new ArrayList<>();

        String dairitenKykSosikiCd = YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd();

        String kanjiSosikiNm = "";

        BzGetSosikiDataBean bzGetSosikiDataBean = getSosikiData.exec(dairitenKykSosikiCd);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            kanjiSosikiNm = bzGetSosikiDataBean.getKanjisosikinm20();
        }

        Integer nykKrEigyouNissu = YuyuSinkeiyakuConfig.getInstance().getNykKrEigyouNissu();

        BizDate taisyouYmd = bzBatchParam.getSyoriYmd().addBusinessDays(-nykKrEigyouNissu);

        try (ExDBResults<HV_MosSyoruiMitoutyakuList> mosSyoruiMitoutyakuList = sinkeiyakuDomManager
            .getMosSyoruiMitoutyakuListsByKnjyymdLe(taisyouYmd);
            EntityUpdater<HT_HrkmNyknData> htHrkmNyknEntityUpdater = new EntityUpdater<>();
            EntityUpdater<HT_GaikaHrkmNyknData> htGaikaHrkmNyknEntityUpdater = new EntityUpdater<>()) {

            for (HV_MosSyoruiMitoutyakuList mosSyoruiMitoutyaku : mosSyoruiMitoutyakuList) {

                syoriKensuu = syoriKensuu + 1;

                String oyaDrtenCd = mosSyoruiMitoutyaku.getOyadrtencd();

                if (!beforeOyaDrtenCd.equals(oyaDrtenCd)) {

                    pdfOutPut(beforeOyaDrtenCd, kanjiSosikiNm, oyaDairitenNm, utdskknnm1kj, utdskknnm2kj, sMDSList);
                }

                oyaDairitenNm = "";
                utdskknnm1kj = "";
                utdskknnm2kj = "";

                oyaDairitenNm = mosSyoruiMitoutyaku.getNyuukinoyadrtennm();
                if (BizUtil.isBlank(oyaDairitenNm)) {
                    oyaDairitenNm = getNyuukinOyadrtenNm.exec(oyaDrtenCd);
                }

                List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(oyaDrtenCd);

                for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanList) {

                    if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                        if (BizUtil.isBlank(oyaDairitenNm)) {
                            oyaDairitenNm = bzGetAgInfoBean.getKanjiDairitenNm();
                        }

                        HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou =
                            sinkeiyakuDomManager.getSkDairitenKobetuJyouhou(bzGetAgInfoBean.getOyadrtenCd());

                        if (skDairitenKobetuJyouhou != null) {

                            if (!BizUtil.isBlank(skDairitenKobetuJyouhou.getUtdskknnm1kj())) {
                                utdskknnm1kj = skDairitenKobetuJyouhou.getUtdskknnm1kj();
                            }
                            if (!BizUtil.isBlank(skDairitenKobetuJyouhou.getUtdskknnm2kj())) {
                                utdskknnm2kj = "（" + skDairitenKobetuJyouhou.getUtdskknnm2kj() + "）";
                            }
                        }

                        break;
                    }
                }

                String mostokusokuumu = "";

                if (C_UmuKbn.ARI.eq(mosSyoruiMitoutyaku.getMostokusokuumu())) {

                    mostokusokuumu = "*";
                }

                BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(mosSyoruiMitoutyaku.getBankcd(),
                    mosSyoruiMitoutyaku.getSitencd(), null);

                SkMossyoruijyoukyoulistDataSourceBean sMDSBean = SWAKInjector
                    .getInstance(SkMossyoruijyoukyoulistDataSourceBean.class);

                sMDSBean.setIrMostokusokuumu(mostokusokuumu);

                sMDSBean.setIrDrtennmkj(oyaDairitenNm);

                if (mosSyoruiMitoutyaku.getKnjyymd() == null) {
                    sMDSBean.setIrKnjyymd("");
                }
                else {
                    sMDSBean.setIrKnjyymd(dateDOTWarekiNoEx(mosSyoruiMitoutyaku.getKnjyymd()));
                }

                sMDSBean.setIrMosno(mosSyoruiMitoutyaku.getNykmosno());

                sMDSBean.setIrHrkmirninnm(mosSyoruiMitoutyaku.getHrkmirninnm());

                sMDSBean.setIrBanknmkj(bzGetBankDataBean.getBankNmKj());

                sMDSBean.setIrSitennmkj(bzGetBankDataBean.getSitenNmKj());

                sMDSBean.setIrHrkmgk(mosSyoruiMitoutyaku.getTrhkkgk());

                sMDSList.add(sMDSBean);

                if (C_Tuukasyu.JPY.eq(mosSyoruiMitoutyaku.getTuukasyu())) {

                    HT_HrkmNyknData htHrkmNyknData = sinkeiyakuDomManager.getHrkmNyknData(C_DensysKbn.SKEI,
                        mosSyoruiMitoutyaku.getSyoriYmd(), mosSyoruiMitoutyaku.getItirenno());

                    htHrkmNyknData.setMostokusokuumu(C_UmuKbn.ARI);

                    htHrkmNyknData.setGyoumuKousinKinou(kinou.getKinouId());

                    htHrkmNyknData.setGyoumuKousinsyaId(baseUserInfo.getUserId());

                    htHrkmNyknData.setGyoumuKousinTime(sysTime);

                    htHrkmNyknEntityUpdater.add(htHrkmNyknData);
                }
                else {

                    HT_GaikaHrkmNyknData htGaikaHrkmNyknData = sinkeiyakuDomManager.getGaikaHrkmNyknData(
                        C_DensysKbn.SKEI, mosSyoruiMitoutyaku.getSyoriYmd(), mosSyoruiMitoutyaku.getItirenno());

                    htGaikaHrkmNyknData.setMostokusokuumu(C_UmuKbn.ARI);

                    htGaikaHrkmNyknData.setGyoumuKousinKinou(kinou.getKinouId());

                    htGaikaHrkmNyknData.setGyoumuKousinsyaId(baseUserInfo.getUserId());

                    htGaikaHrkmNyknData.setGyoumuKousinTime(sysTime);

                    htGaikaHrkmNyknEntityUpdater.add(htGaikaHrkmNyknData);
                }

                beforeOyaDrtenCd = mosSyoruiMitoutyaku.getOyadrtencd();
            }

            pdfOutPut(beforeOyaDrtenCd, kanjiSosikiNm, oyaDairitenNm, utdskknnm1kj, utdskknnm2kj, sMDSList);

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu),
            MOS_SYORUI_SOUHU_JKLIST));
    }

    private void pdfOutPut(String pBeforuOyaDrtenCd, String pKanjiSosikiNm, String pOyaDairitenNm,
        String pUtdskknnm1kj, String pUtdskknnm2kj, List<IReportDataSouceBean> sMDSList) {

        if (!pBeforuOyaDrtenCd.equals(OYA_DRTEN_CD_INIT)) {

            GetSkChannelInfo getSkChannelInfo = SWAKInjector.getInstance(GetSkChannelInfo.class);

            getSkChannelInfo.exec(null, pBeforuOyaDrtenCd);

            String sapodetelno = getSkChannelInfo.getSapodetelno();

            String sapodefaxno = getSkChannelInfo.getSapodefaxno();

            BzDairitenAtesakiBean bzDairitenAtesakiBean = SWAKInjector.getInstance(BzDairitenAtesakiBean.class);

            bzDairitenAtesakiBean
            .setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJIWarekiNoEx(bzBatchParam.getSyoriYmd()));

            bzDairitenAtesakiBean.setIrDrtenutdskknnm1(pUtdskknnm1kj);

            bzDairitenAtesakiBean.setIrDrtenutdskknnm2(pUtdskknnm2kj);

            bzDairitenAtesakiBean.setIrHknkisynm(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());

            bzDairitenAtesakiBean.setIrToiawasesosiki(pKanjiSosikiNm);

            bzDairitenAtesakiBean.setIrToiawasetantounm(pKanjiSosikiNm);

            bzDairitenAtesakiBean.setIrToiawasetelno(sapodetelno);

            BzDairitenAtesakiBean bzDAtesakiBean = SWAKInjector.getInstance(BzDairitenAtesakiBean.class);

            bzDAtesakiBean.setIrHknkisynm(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());

            bzDAtesakiBean.setIrToiawasesosiki(pKanjiSosikiNm.concat(" 行"));

            bzDAtesakiBean.setIrToiawasefaxno(sapodefaxno);

            bzDAtesakiBean.setIrDrtennmkj(pOyaDairitenNm);

            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
            C_SyoruiCdKbn skMossouhujyoukyoulistSouhu = C_SyoruiCdKbn.SK_MOSSOUHUJYOUKYOULIST_SOUHU;

            GetSyoruicd getSyoruicd = SWAKInjector.getInstance(GetSyoruicd.class);

            C_SyoruiCdKbn skMossouhujyoukyouList = getSyoruicd.getSyoruicd_Mossouhujklst();

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(), kinou.getCategoryId(),
                kinou.getKinouId(), skMossouhujyoukyoulistSouhu, skMossouhujyoukyouList);

            reportServicesBean.setKensakuKeys(pBeforuOyaDrtenCd);
            reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

            reportServicesBean.addParamObjects(skMossouhujyoukyoulistSouhu, bzDairitenAtesakiBean);

            reportServicesBean.addParamObjects(skMossouhujyoukyouList, sMDSList, bzDAtesakiBean);

            reportServicesBean.setSyoruiCdKbnIdx(getSyoruicd.getSyoruicd_Mossouhujklst_idx());

            createReport.execNoCommit(reportServicesBean);

            sMDSList.clear();
        }
    }

    private String dateDOTWarekiNoEx(BizDate pSource){

        try {
            String retStr = new BizDateFormat("G.yy.MM.dd",FillStyle.Blank).format(pSource);

            return retStr;
        }
        catch(Exception exp) {
            if (pSource == null) {
                return null;
            }

            return pSource.toString();
        }
    }
}

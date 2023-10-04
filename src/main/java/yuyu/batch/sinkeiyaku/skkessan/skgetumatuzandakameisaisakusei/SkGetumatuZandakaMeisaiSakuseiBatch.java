package yuyu.batch.sinkeiyaku.skkessan.skgetumatuzandakameisaisakusei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.skkessan.skgetumatuzandakameisaisakusei.dba.SkGetumatuZandakaMeisaiSakuseiDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.skcommon.GetRsgakukei;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkGetumatuzandakaBean;
import yuyu.def.sinkeiyaku.bean.report.SkKariukeHuhopkakinBean;
import yuyu.def.sinkeiyaku.bean.report.SkKariukehuhopkakinDataSourceBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_Nyuukin;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 決算  新契約月末残高明細作成
 */
public class SkGetumatuZandakaMeisaiSakuseiBatch implements Batch {

    private List<IReportDataSouceBean> skKrhuhoPkakinDsBeanLst = new ArrayList<>();

    private long syoriKensuu = 0;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private CreateReport createReport;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private SkGetumatuZandakaMeisaiSakuseiDao skGetumatuZandakaMeisaiSakuseiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "処理年月日", String.valueOf(syoriYmd)));

        BizDateYM syoriYm = syoriYmd.getBizDateYM();
        BizDateYM syoriPreYm = syoriYm.getPreviousMonth();
        BizDate syoriPreYmd = syoriPreYm.getLastDay();

        BizDate onegetuTyoukaYmd = syoriPreYmd.getBusinessDay(CHolidayAdjustingMode.NEXT_IN_THIS_MONTH);

        String atesaki = "";
        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        String dairitenKykSosikiCd = YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd();

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(dairitenKykSosikiCd);

        if (bzGetSosikiDataBean != null) {

            atesaki = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());
        }

        String tyouhyouYmd = DateFormatUtil.dateKANJI(syoriYmd);
        String syuukeiYm = DateFormatUtil.dateYmKANJINoEx(syoriYm);

        SkKariukeHuhopkakinBean skKariukeHuhopkakinBean =
            SWAKInjector.getInstance(SkKariukeHuhopkakinBean.class);

        skKariukeHuhopkakinBean.setIrAtesaki(atesaki);
        skKariukeHuhopkakinBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
        skKariukeHuhopkakinBean.setIrSyuukeiym(syuukeiYm + "末");

        SkGetumatuzandakaBean skGetumatuzandakaBean = SWAKInjector.getInstance(SkGetumatuzandakaBean .class);

        List<HT_SyoriCTL> syoriCTLLst = skGetumatuZandakaMeisaiSakuseiDao.getSyoriCTLsByHnknsyoriymdPkakinsyoriymdKyktuukasyulst(
            syoriYmd, new C_Tuukasyu[]{C_Tuukasyu.USD, C_Tuukasyu.AUD});

        createKrhuhoPkakin(syoriCTLLst, syoriYmd, onegetuTyoukaYmd, skGetumatuzandakaBean);

        try (ExDBResults<HT_SyoriCTL> syoriCTLExDBResults =
            skGetumatuZandakaMeisaiSakuseiDao.getSyoriCTLsBySeiritukbnSrsyoriymdNyksyoriymdKyktuukasyulst(
                syoriYmd, new C_Tuukasyu[]{C_Tuukasyu.USD, C_Tuukasyu.AUD})) {

            calKariukeikingokei(syoriCTLExDBResults, syoriYmd, skGetumatuzandakaBean);
        }

        skGetumatuzandakaBean.setIrAtesaki(atesaki);
        skGetumatuzandakaBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
        skGetumatuzandakaBean.setIrSyuukeiym(syuukeiYm);

        C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.SK_KARIUKEHUHOPKAKIN1MKEIKA;

        skKariukeHuhopkakinBean.setIrSyoruicd(syoruiCd);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCd);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(
            syoruiCd,
            skKrhuhoPkakinDsBeanLst,
            skKariukeHuhopkakinBean);

        createReport.execNoCommit(reportServicesBean);

        syoruiCd = C_SyoruiCdKbn.SK_GETUMATUZANDAKACHKLIST;

        skGetumatuzandakaBean.setIrSyoruicd(syoruiCd);

        reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCd);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(
            syoruiCd,
            skGetumatuzandakaBean);

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(syoriKensuu), "仮受（普保Ｐ過金）１ヵ月超経過リスト"));

        syoriKensuu = 0;
        skKrhuhoPkakinDsBeanLst = new ArrayList<>();


        skGetumatuzandakaBean = SWAKInjector.getInstance(SkGetumatuzandakaBean .class);

        List<HT_SyoriCTL> syoriCTLYendtLst = skGetumatuZandakaMeisaiSakuseiDao.getSyoriCTLsByHnknsyoriymdPkakinsyoriymdKyktuukasyulst(
            syoriYmd, C_Tuukasyu.JPY);

        createKrhuhoPkakin(syoriCTLYendtLst, syoriYmd, onegetuTyoukaYmd, skGetumatuzandakaBean);

        try (ExDBResults<HT_SyoriCTL> syoriCTLExDBResults =
            skGetumatuZandakaMeisaiSakuseiDao.getSyoriCTLsBySeiritukbnSrsyoriymdNyksyoriymdKyktuukasyulst(syoriYmd, C_Tuukasyu.JPY)) {

            calKariukeikingokei(syoriCTLExDBResults, syoriYmd, skGetumatuzandakaBean);
        }

        skGetumatuzandakaBean.setIrAtesaki(atesaki);
        skGetumatuzandakaBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
        skGetumatuzandakaBean.setIrSyuukeiym(syuukeiYm);

        syoruiCd = C_SyoruiCdKbn.SK_KARIUKEHUHOPKAKIN1MKEIKA_YENDT;

        skKariukeHuhopkakinBean.setIrSyoruicd(syoruiCd);

        reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCd);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(
            syoruiCd,
            skKrhuhoPkakinDsBeanLst,
            skKariukeHuhopkakinBean);

        createReport.execNoCommit(reportServicesBean);

        syoruiCd = C_SyoruiCdKbn.SK_GETUMATUZANDAKACHKLIST_YENDT;

        skGetumatuzandakaBean.setIrSyoruicd(syoruiCd);

        reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCd);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(
            syoruiCd,
            skGetumatuzandakaBean);

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(syoriKensuu), "仮受（普保Ｐ過金）１ヵ月超経過リスト（円建）"));

    }

    private void createKrhuhoPkakin(List<HT_SyoriCTL> pSyoriCTLLst, BizDate pSyoriYmd, BizDate pOnegetuTyoukaYmd,
        SkGetumatuzandakaBean pSkGetumatuzandakaBean) {

        BizCurrency gkkrkhuho2enPkakin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency gkkrkhuho2doruPkakinden = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency gkkrkhuho2doruPkakin = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        BizCurrency gkkrkhuho2goudoruPkakinden = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency gkkrkhuho2goudoruPkakin = BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR);

        SortHT_Nyuukin sortNyuukin = SWAKInjector.getInstance(SortHT_Nyuukin.class);
        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        for (HT_SyoriCTL syoriCTL : pSyoriCTLLst) {

            String mosNo = syoriCTL.getMosno();

            List<HT_Nyuukin> nyuukinLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).getNyuukins();
            nyuukinLst = sortNyuukin.OrderHT_NyuukinByNyksyoriymdDesc(nyuukinLst);

            BizDate saisinNukinYmd = null;

            if (nyuukinLst.size() > 0) {

                saisinNukinYmd = nyuukinLst.get(0).getNyksyoriymd();
            }

            BizDate keikaKijyunYmd = saisinNukinYmd;

            List<HT_Henkin> henkinLst = sinkeiyakuDomManager.getHenkinsByMosnoHnknsyoriymd(mosNo, pSyoriYmd);

            for (HT_Henkin henkin : henkinLst) {

                C_Tuukasyu hnknTuukaSyu = henkin.getHnkntuukasyu();

                if (C_Tuukasyu.JPY.eq(hnknTuukaSyu)) {

                    gkkrkhuho2enPkakin = gkkrkhuho2enPkakin.add(henkin.getHnkngk());
                }
                else if (C_Tuukasyu.USD.eq(hnknTuukaSyu)) {

                    gkkrkhuho2doruPkakin = gkkrkhuho2doruPkakin.add(henkin.getHnkngk());

                    List<BizCurrency> pkakinDenpyoGkYenGoukeiLst =
                        sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByHenkin(mosNo, henkin.getRenno(), C_Tuukasyu.USD,
                            pSyoriYmd, pSyoriYmd);

                    if (pkakinDenpyoGkYenGoukeiLst != null && pkakinDenpyoGkYenGoukeiLst.size() > 0) {
                        gkkrkhuho2doruPkakinden = gkkrkhuho2doruPkakinden.add(
                            pkakinDenpyoGkYenGoukeiLst.get(0));
                    }
                }
                else if(C_Tuukasyu.AUD.eq(hnknTuukaSyu)) {

                    gkkrkhuho2goudoruPkakin = gkkrkhuho2goudoruPkakin.add(henkin.getHnkngk());

                    List<BizCurrency> pkakinDenpyoGkYenGoukeiLst =
                        sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByHenkin(mosNo, henkin.getRenno(), C_Tuukasyu.AUD,
                            pSyoriYmd, pSyoriYmd);

                    if (pkakinDenpyoGkYenGoukeiLst != null && pkakinDenpyoGkYenGoukeiLst.size() > 0) {
                        gkkrkhuho2goudoruPkakinden = gkkrkhuho2goudoruPkakinden.add(
                            pkakinDenpyoGkYenGoukeiLst.get(0));
                    }
                }

                BizDate suitouYmd = henkin.getPkakinsyoriymd();

                if (BizDateUtil.compareYmd(keikaKijyunYmd, suitouYmd) == BizDateUtil.COMPARE_GREATER) {

                    suitouYmd = keikaKijyunYmd;
                }
                suitouYmd = suitouYmd.addBusinessDays(1);

                if (BizDateUtil.compareYmd(suitouYmd, pOnegetuTyoukaYmd) <= BizDateUtil.COMPARE_EQUAL) {

                    HT_MosDairiten mosDairiten = syoriCTL.getMosDairitenByRenno(1);

                    String aAtukaikojinCd = mosDairiten.getDaibosyuucd();

                    List<BzGetAgInfoBean> bzGetAgInfoBeanlst = bzGetAgInfo.exec(mosDairiten.getTratkiagcd());

                    String drtenNm = "";

                    for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanlst) {

                        if (bzGetAgInfoBean != null &&
                            C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                            drtenNm = bzGetAgInfoBean.getKanjiDairitenNm();
                            break;
                        }
                    }

                    String suitouymd = DateFormatUtil.dateKANJI(suitouYmd);

                    SkKariukehuhopkakinDataSourceBean skKrhuhoPkakinDsBean =
                        SWAKInjector.getInstance(SkKariukehuhopkakinDataSourceBean.class);

                    skKrhuhoPkakinDsBean.setIrMosno(mosNo);
                    skKrhuhoPkakinDsBean.setIrSuitouymdseireki(suitouymd);
                    skKrhuhoPkakinDsBean.setIrHnknriyuukbn(henkin.getHnknriyuukbn().getContent());
                    skKrhuhoPkakinDsBean.setIrHnkngkkngk(henkin.getHnkngk());
                    skKrhuhoPkakinDsBean.setIrDrtennmkj(drtenNm);
                    skKrhuhoPkakinDsBean.setIrAatukaikojincd(aAtukaikojinCd);

                    skKrhuhoPkakinDsBeanLst.add(skKrhuhoPkakinDsBean);

                    syoriKensuu++ ;
                }
            }
        }

        pSkGetumatuzandakaBean.setIrGkkrkhuho2enpkakin(gkkrkhuho2enPkakin);
        pSkGetumatuzandakaBean.setIrGkkrkhuho2dorupkakinden(gkkrkhuho2doruPkakinden);
        pSkGetumatuzandakaBean.setIrGkkrkhuho2dorupkakin(gkkrkhuho2doruPkakin);
        pSkGetumatuzandakaBean.setIrGkkrkhuho2audpkakinden(gkkrkhuho2goudoruPkakinden);
        pSkGetumatuzandakaBean.setIrGkkrkhuho2goudorupkakin(gkkrkhuho2goudoruPkakin);
    }

    private void calKariukeikingokei(ExDBResults<HT_SyoriCTL> pSyoriCTLExDBResults, BizDate pSyoriYmd,
        SkGetumatuzandakaBean pSkGetumatuzandakaBean) {

        BizCurrency gkkrkhuho2enFst = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency gkkrkhuho2doruFstden = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency gkkrkhuho2doruFst = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        BizCurrency gkkrkhuho2goudoruFstden = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency gkkrkhuho2goudoruFst = BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR);

        for (HT_SyoriCTL syoriCTL : pSyoriCTLExDBResults) {

            GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);
            BizDate zenjituSyoriYmd = pSyoriYmd.getPreviousDay();
            getRsgakukei.getPkakinsumiRsgaku(syoriCTL, zenjituSyoriYmd);

            C_Tuukasyu tuukasyu = getRsgakukei.getTuukasyu();

            if (C_Tuukasyu.JPY.eq(tuukasyu)) {

                gkkrkhuho2enFst = gkkrkhuho2enFst.add(getRsgakukei.getRsgakukei());
            }
            else if (C_Tuukasyu.USD.eq(tuukasyu)) {

                gkkrkhuho2doruFst = gkkrkhuho2doruFst.add(getRsgakukei.getRsgakukei());

                List<BizCurrency> henkinDenpyouGkYenGoukeiLst =
                    sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByPkakinsyoriymd(syoriCTL.getMosno(),
                        C_Tuukasyu.USD, pSyoriYmd);
                List<BizCurrency> nyukinDenpyouGkYenGoukeiLst =
                    sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByNyksyoriymd(syoriCTL.getMosno(),
                        C_Tuukasyu.USD, pSyoriYmd);

                if (nyukinDenpyouGkYenGoukeiLst != null && nyukinDenpyouGkYenGoukeiLst.size() > 0) {
                    gkkrkhuho2doruFstden = gkkrkhuho2doruFstden.add(
                        nyukinDenpyouGkYenGoukeiLst.get(0));
                }

                if (henkinDenpyouGkYenGoukeiLst != null && henkinDenpyouGkYenGoukeiLst.size() > 0) {
                    gkkrkhuho2doruFstden = gkkrkhuho2doruFstden.subtract(
                        henkinDenpyouGkYenGoukeiLst.get(0));
                }

            }
            else if (C_Tuukasyu.AUD.eq(tuukasyu)) {

                gkkrkhuho2goudoruFst = gkkrkhuho2goudoruFst.add(getRsgakukei.getRsgakukei());

                List<BizCurrency> henkinDenpyouGkYenGoukeiLst =
                    sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByPkakinsyoriymd(syoriCTL.getMosno(),
                        C_Tuukasyu.AUD, pSyoriYmd);
                List<BizCurrency> nyukinDenpyouGkYenGoukeiLst =
                    sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByNyksyoriymd(syoriCTL.getMosno(),
                        C_Tuukasyu.AUD, pSyoriYmd);

                if (nyukinDenpyouGkYenGoukeiLst != null && nyukinDenpyouGkYenGoukeiLst.size() > 0) {
                    gkkrkhuho2goudoruFstden = gkkrkhuho2goudoruFstden.add(
                        nyukinDenpyouGkYenGoukeiLst.get(0));
                }

                if (henkinDenpyouGkYenGoukeiLst != null && henkinDenpyouGkYenGoukeiLst.size() > 0) {
                    gkkrkhuho2goudoruFstden = gkkrkhuho2goudoruFstden.subtract(
                        henkinDenpyouGkYenGoukeiLst.get(0));
                }
            }
        }

        pSkGetumatuzandakaBean.setIrGkkrkhuho2enfst(gkkrkhuho2enFst);
        pSkGetumatuzandakaBean.setIrGkkrkhuho2dorufstden(gkkrkhuho2doruFstden);
        pSkGetumatuzandakaBean.setIrGkkrkhuho2dorufst(gkkrkhuho2doruFst);
        pSkGetumatuzandakaBean.setIrGkkrkhuho2goudorufstden(gkkrkhuho2goudoruFstden);
        pSkGetumatuzandakaBean.setIrGkkrkhuho2goudorufst(gkkrkhuho2goudoruFst);
    }

}

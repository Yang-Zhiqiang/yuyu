package yuyu.batch.sinkeiyaku.skkessan.skpkakinzandakameisaisakusei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.skkessan.skpkakinzandakameisaisakusei.dba.SkPKakinZandakaMeisaiSakuseiDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkKariukekinpkakinBean;
import yuyu.def.sinkeiyaku.bean.report.SkKariukekinpkakinDataSourceBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 決算 新契約Ｐ過金残高明細作成
 */
public class SkPKakinZandakaMeisaiSakuseiBatch implements Batch {

    private static final String SHNKNM_6 = "第１四半期";

    private static final String SHNKNM_9 = "半期";

    private static final String SHNKNM_12 = "第３四半期";

    private static final String SHNKNM_3 = "決算";

    private String atesaki;

    private String tyouhyouYmd;

    private long count;

    private BizDate syoriYmd;

    private String syoriKbn;

    private BizDate kijyunYmd;

    private C_SyoruiCdKbn syoruiCd;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SkPKakinZandakaMeisaiSakuseiBatchParam skPKakinZandakaMeisaiSakuseiBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SkPKakinZandakaMeisaiSakuseiDao skPKakinZandakaMeisaiSakuseiDao;

    @Inject
    private CreateReport createReport;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return skPKakinZandakaMeisaiSakuseiBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syoriYmd = skPKakinZandakaMeisaiSakuseiBatchParam.getSyoriYmd();
        syoriKbn = skPKakinZandakaMeisaiSakuseiBatchParam.getSyoriKbn();
        count = 0;

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage("処理区分"), String.valueOf(syoriKbn)));

        if ("1".equals(syoriKbn)) {

            kijyunYmd = syoriYmd;
        }
        else {

            BizDate syoriYmdPerMatujitu = syoriYmd.getBizDateYM().getPreviousMonth().getLastDay();
            kijyunYmd = syoriYmdPerMatujitu.addBusinessDays(-1, true);
        }

        if ("1".equals(syoriKbn)) {

            syoruiCd = C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI;
        }
        else {

            syoruiCd = C_SyoruiCdKbn.SK_KARIUKEKINPKAKINZANDAKAMEISAILIST;
        }



        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
        String dairitenKykSosikiCd = YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd();
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(dairitenKykSosikiCd);

        atesaki = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());
        tyouhyouYmd = DateFormatUtil.dateKANJI(syoriYmd);

        List<String> yuukoutuukasyuList = YuyuSinkeiyakuConfig.getInstance().getYuukoutuukasyuList();

        createTyouhyou(yuukoutuukasyuList, new C_Tuukasyu[]{C_Tuukasyu.USD, C_Tuukasyu.AUD});

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(count), syoruiCd.getContent()));

        if ("1".equals(syoriKbn)) {

            syoruiCd = C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI_YENDT;
        }
        else {

            syoruiCd = C_SyoruiCdKbn.SK_KARIUKEKINPKAKINZANDAKAMEISAILIST_YENDT;
        }

        count = 0;
        yuukoutuukasyuList =  new ArrayList<>();

        yuukoutuukasyuList.add(C_Tuukasyu.JPY.getValue());

        createTyouhyou(yuukoutuukasyuList, new C_Tuukasyu[]{C_Tuukasyu.JPY});

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(count), syoruiCd.getContent()));

    }

    private void createTyouhyou(List<String> pYuukoutuukasyuLst, C_Tuukasyu[] pKyktuukasyuLst) {

        SkKariukekinpkakinBean skKariukekinpkakinBean = SWAKInjector.getInstance(SkKariukekinpkakinBean .class);
        List<IReportDataSouceBean> skKariukekinpkakinDataSourceBeanList = new ArrayList<>();
        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDataSourceBean = SWAKInjector.getInstance(SkKariukekinpkakinDataSourceBean.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        String tyouhyouTitle = createTitle();

        skKariukekinpkakinBean.setIrAtesaki(atesaki);
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
        skKariukekinpkakinBean.setIrTyouhyoutitle(tyouhyouTitle);
        skKariukekinpkakinBean.setIrSyoruicd(syoruiCd);

        for (String yuukoutuukasyu : pYuukoutuukasyuLst) {

            C_Tuukasyu tuukasyu = C_Tuukasyu.valueOf(yuukoutuukasyu);
            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(tuukasyu);
            BizCurrency gkkrkPkakin = BizCurrency.valueOf(0, currencyType);
            BizCurrency gkkrkPkakinDengkyen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            long tuukyuukoukensuu = 0;
            BizCurrency kawasesasoneki = BizCurrency.valueOf(0, currencyType);
            BizNumber kawaserate = null;
            BizCurrency kanzanGaku = null;

            List<HT_SyoriCTL> syoriCTLList =
                skPKakinZandakaMeisaiSakuseiDao.getSyoriCTLsByHnknsyoriymdPkakinsyoriymdHnkntuukasyuKyktuukasyulst(kijyunYmd, tuukasyu, pKyktuukasyuLst);

            for (HT_SyoriCTL syoriCTL : syoriCTLList) {

                if ("1".equals(syoriKbn) ||
                    (!C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn()) ||
                        (syoriCTL.getSrsyoriymd() != null &&
                        BizDateUtil.compareYmd(syoriCTL.getSrsyoriymd(), syoriYmd) == BizDateUtil.COMPARE_GREATER))) {

                    String mosno = syoriCTL.getMosno();

                    List<HT_Henkin> henkinList =
                        skPKakinZandakaMeisaiSakuseiDao.getHenkinsByMosnoHnknsyoriymdHnkntuukasyu(mosno, kijyunYmd, tuukasyu);

                    for (HT_Henkin henkin : henkinList) {

                        gkkrkPkakin = gkkrkPkakin.add(henkin.getHnkngk());

                        List<BizCurrency> skDenpyoDataSumDenyenkagk =
                            sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByHenkin(mosno, henkin.getRenno(), tuukasyu, kijyunYmd, kijyunYmd);

                        gkkrkPkakinDengkyen = gkkrkPkakinDengkyen.add(skDenpyoDataSumDenyenkagk.get(0));

                        BizCurrency dengk = skDenpyoDataSumDenyenkagk.get(0);

                        BizDate suitouYmd = henkin.getPkakinsyoriymd();

                        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

                        String kyknmkn;

                        if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {

                            kyknmkn = mosKihon.getHhknnmkn();
                        }
                        else {

                            kyknmkn = mosKihon.getKyknmkn();
                        }

                        skKariukekinpkakinDataSourceBean = SWAKInjector.getInstance(SkKariukekinpkakinDataSourceBean.class);
                        String irRyosyuymd = null;
                        String irSuitouymd = null;

                        if (syoriCTL.getRyosyuymd() != null) {

                            irRyosyuymd = String.valueOf(syoriCTL.getRyosyuymd());
                        }

                        if (suitouYmd != null) {

                            irSuitouymd = String.valueOf(suitouYmd);
                        }

                        skKariukekinpkakinDataSourceBean.setIrTuukasyu(tuukasyu);
                        skKariukekinpkakinDataSourceBean.setIrSyuukeitani(tuukasyu.getContent() + "入金");
                        skKariukekinpkakinDataSourceBean.setIrMosno(mosKihon.getMosno());
                        skKariukekinpkakinDataSourceBean.setIrKyknmkn(kyknmkn);
                        skKariukekinpkakinDataSourceBean.setIrRyosyuymd(irRyosyuymd);
                        skKariukekinpkakinDataSourceBean.setIrSuitouymd(irSuitouymd);
                        skKariukekinpkakinDataSourceBean.setIrPkakingkyen(dengk);
                        skKariukekinpkakinDataSourceBean.setIrPkakingk(henkin.getHnkngk());
                        skKariukekinpkakinDataSourceBean.setIrKensuugoukei(null);
                        skKariukekinpkakinDataSourceBean.setIrKingakugoukeiyen(null);
                        skKariukekinpkakinDataSourceBean.setIrKingakugoukei(null);
                        skKariukekinpkakinDataSourceBean.setIrYenkansantkykwsrate(null);
                        skKariukekinpkakinDataSourceBean.setIrYenkansanpkakingkgoukei(null);
                        skKariukekinpkakinDataSourceBean.setIrKawasesasoneki(null);

                        skKariukekinpkakinDataSourceBeanList.add(skKariukekinpkakinDataSourceBean);
                        count = count + 1;
                        tuukyuukoukensuu = tuukyuukoukensuu + 1;
                    }
                }
            }

            if (tuukyuukoukensuu == 0) {

                skKariukekinpkakinDataSourceBean = SWAKInjector.getInstance(SkKariukekinpkakinDataSourceBean.class);

                skKariukekinpkakinDataSourceBean.setIrTuukasyu(tuukasyu);
                skKariukekinpkakinDataSourceBean.setIrSyuukeitani(tuukasyu.getContent() + "入金");
                skKariukekinpkakinDataSourceBean.setIrMosno("");
                skKariukekinpkakinDataSourceBean.setIrKyknmkn("");
                skKariukekinpkakinDataSourceBean.setIrRyosyuymd("");
                skKariukekinpkakinDataSourceBean.setIrSuitouymd("");
                skKariukekinpkakinDataSourceBean.setIrPkakingkyen(null);
                skKariukekinpkakinDataSourceBean.setIrPkakingk(null);
                skKariukekinpkakinDataSourceBean.setIrKensuugoukei(BizNumber.ZERO);
                skKariukekinpkakinDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skKariukekinpkakinDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0, currencyType));
                skKariukekinpkakinDataSourceBean.setIrYenkansantkykwsrate(BizNumber.ZERO);
                skKariukekinpkakinDataSourceBean.setIrYenkansanpkakingkgoukei(null);
                skKariukekinpkakinDataSourceBean.setIrKawasesasoneki(null);

                skKariukekinpkakinDataSourceBeanList.add(skKariukekinpkakinDataSourceBean);
            }
            else {

                if (!C_Tuukasyu.JPY.equals(tuukasyu)) {

                    getKawaseRate.exec(kijyunYmd, C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                        tuukasyu, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.JISSEIRATE,
                        C_EigyoubiHoseiKbn.BLNK, C_YouhiKbn.HUYOU);
                    kawaserate = getKawaseRate.getKawaserate();
                    kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY, gkkrkPkakin, kawaserate, C_HasuusyoriKbn.SUTE);
                    kawasesasoneki = gkkrkPkakinDengkyen.subtract(kanzanGaku);
                }

                skKariukekinpkakinDataSourceBean =
                    (SkKariukekinpkakinDataSourceBean)skKariukekinpkakinDataSourceBeanList.get(skKariukekinpkakinDataSourceBeanList.size()-1);
                skKariukekinpkakinDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(tuukyuukoukensuu));
                skKariukekinpkakinDataSourceBean.setIrKingakugoukeiyen(gkkrkPkakinDengkyen);
                skKariukekinpkakinDataSourceBean.setIrKingakugoukei(gkkrkPkakin);
                skKariukekinpkakinDataSourceBean.setIrYenkansantkykwsrate(kawaserate);
                skKariukekinpkakinDataSourceBean.setIrYenkansanpkakingkgoukei(kanzanGaku);
                skKariukekinpkakinDataSourceBean.setIrKawasesasoneki(kawasesasoneki);
            }
        }


        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCd);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(
            syoruiCd,
            skKariukekinpkakinDataSourceBeanList,
            skKariukekinpkakinBean );

        createReport.execNoCommit(reportServicesBean);

    }

    private String createTitle() {

        String tyouhyouTitle;

        if ("1".equals(syoriKbn)) {

            tyouhyouTitle = DateFormatUtil.dateYmKANJINoEx(kijyunYmd.getBizDateYM());
            tyouhyouTitle = tyouhyouTitle + "末" + "　" + syoruiCd.getContent();
        }
        else {

            tyouhyouTitle = DateFormatUtil .dateYKANJISeirekiNendo(kijyunYmd);

            String shnknm = "";
            if (kijyunYmd.getMonth() == 6) {
                shnknm = SHNKNM_6;
            }
            else if (kijyunYmd.getMonth() == 9) {
                shnknm = SHNKNM_9;
            }
            else if (kijyunYmd.getMonth() == 12) {
                shnknm = SHNKNM_12;
            }
            else if (kijyunYmd.getMonth() == 3) {
                shnknm = SHNKNM_3;
            }

            tyouhyouTitle = tyouhyouTitle + shnknm + "　" + syoruiCd.getContent();
        }

        return tyouhyouTitle;
    }
}

package yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba.GinkouMdhnJdNyknTsygKsansBySyoriYmdNyksyoriymdRstuukasyuBean;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba.GinkouMdhnJdNyknTsygsBySyoriYmdNyksyoriymdRstuukasyuBean;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba.MosTorikesiKgKsansBySyoriYmdKnjyymdRstuukasyuBean;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba.MosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuBean;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba.SkHurikominyuukinListSakuseiDao;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba.SyougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBean;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba.SyougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBean;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba.SyougouittiNeKgKsansBySyoriYmdKnjyymdrstuukasyuBean;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba.SyougouittiNeKgsBySyoriYmdKnjyymdrstuukasyuBean;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba.TjtKgsByDensyskbnSyoriYmdBean;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba.YokuziturkKgKsansByDensyskbnSyorizumiflgAzkrhrdsymdBean;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba.YokuziturkKgsByDensyskbnSyoriYmdZengetuLastdSyorizumiflgBean;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba.YuukoukknKsansBySyoriYmdKnjyymdRstuukasyuBean;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba.YuukoukknsBySyoriYmdKnjyymdRstuukasyuBean;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba.ZenzitukKgBySyoriYmdKessanKbnRstuukasyuNyktyhyoutListBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.common.sinkeiyaku.skcommon.GetSyoruicd;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_JidouSyuunouMeisai2;
import yuyu.def.sinkeiyaku.bean.report.SkJidounyuukinmeisailistDataSourceBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.result.bean.GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean;
import yuyu.def.sinkeiyaku.result.bean.GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean;
import yuyu.def.sinkeiyaku.result.bean.GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;

/**
 * 新契約 入金 自動入金明細リスト作成
 */
public class SkHurikominyuukinListSakuseiBatch implements Batch {

    private static final int INTEGER1 = 1;

    private static final int INTEGER4 = 4;

    private static final int INTEGER7 = 7;

    private static final int INTEGER10 = 10;

    private static final String HITUGIJILSTNM = "＜自動収納 照合一致・不一致明細書（普保Ⅱ）＞";

    private static final String KESSANJIDAI1SIHANNKILSTNM = " 第１四半期用 自動収納 照合一致・不一致明細書（普保Ⅱ）＞";

    private static final String KESSANJIHANNKILSTNM = " 半期用 自動収納 照合一致・不一致明細書（普保Ⅱ）＞";

    private static final String KESSANJIDAI3SIHANNKILSTNM = " 第３四半期用 自動収納 照合一致・不一致明細書（普保Ⅱ）＞";

    private static final String KESSANJIKESSANLSTNM = " 決算用 自動収納 照合一致・不一致明細書（普保Ⅱ）＞";

    private static final String LEFTKAKUYINYOUFU = "＜ ";

    private static final String HITUGIJILSTNMYENDT = "＜自動収納 照合一致・不一致明細書（普保Ⅱ）（円建）＞";

    private static final String KESSANJIDAI1SIHANNKILSTNM_YENDT = " 第１四半期用 自動収納 照合一致・不一致明細書（普保Ⅱ）（円建）＞";

    private static final String KESSANJIHANNKILSTNM_YENDT = " 半期用 自動収納 照合一致・不一致明細書（普保Ⅱ）（円建）＞";

    private static final String KESSANJIDAI3SIHANNKILSTNM_YENDT = " 第３四半期用 自動収納 照合一致・不一致明細書（普保Ⅱ）（円建）＞";

    private static final String KESSANJIKESSANLSTNM_YENDT = " 決算用 自動収納 照合一致・不一致明細書（普保Ⅱ）（円建）＞";

    private String ateSaki;

    private boolean kessanTuikoFlg;

    private boolean kessanTuikoKikannNai;

    private BizDate zengetuDensimeYmd;

    private String listNm;

    private BizDate kessankiSyoniti;

    private int nyktyhyoutKbnsetFlg;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private CreateReport createReport;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private SkHurikominyuukinListSakuseiDao skHurikominyuukinListSakuseiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate kidouSyoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(kidouSyoriYmd)));

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);

        ateSaki = bzGetSosikiData.exec(YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd()).getKanjisosikinm20();

        zengetuDensimeYmd = setDenSimebi.exec(kidouSyoriYmd);

        int syoriM = kidouSyoriYmd.getMonth();

        kessankiSyoniti = null;

        if (syoriM >= INTEGER4 && syoriM <= 6) {

            kessankiSyoniti = BizDateYM.valueOf(kidouSyoriYmd.getYear(), INTEGER4).getFirstDay();
        }
        else if (syoriM >= INTEGER7 && syoriM <= 9) {

            kessankiSyoniti = BizDateYM.valueOf(kidouSyoriYmd.getYear(), INTEGER7).getFirstDay();
        }
        else if (syoriM >= INTEGER10 && syoriM <= 12) {

            kessankiSyoniti = BizDateYM.valueOf(kidouSyoriYmd.getYear(), INTEGER10).getFirstDay();
        }
        else if (syoriM >= INTEGER1 && syoriM <= 3) {

            kessankiSyoniti = BizDateYM.valueOf(kidouSyoriYmd.getYear(), INTEGER1).getFirstDay();
        }

        if (kessankiSyoniti != null) {

            kessankiSyoniti = kessankiSyoniti.getBusinessDay(CHolidayAdjustingMode.NEXT);
        }


        kessanTuikoFlg = false;

        kessanTuikoKikannNai = false;

        if (syoriM == INTEGER4 || syoriM == INTEGER7 || syoriM == INTEGER10 || syoriM == INTEGER1) {

            kessanTuikoKikannNai = true;
        }

        if (kessanTuikoKikannNai &&
            BizDateUtil.compareYmd(kidouSyoriYmd, kessankiSyoniti) != BizDateUtil.COMPARE_LESSER &&
            BizDateUtil.compareYmd(kidouSyoriYmd, zengetuDensimeYmd) != BizDateUtil.COMPARE_GREATER) {

            kessanTuikoFlg = true;
        }

        ArrayList<IReportDataSouceBean> skJidounyuukinmeisailistDataSourceBeanLst = Lists.newArrayList();
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        nyktyhyoutKbnsetFlg = 1;
        listNm = HITUGIJILSTNM;

        createNtjJidouNyknmsList(C_Tuukasyu.JPY, skJidounyuukinmeisailistDataSourceBeanLst);

        createNtjJidouNyknmsList(C_Tuukasyu.USD, skJidounyuukinmeisailistDataSourceBeanLst);

        createNtjJidouNyknmsList(C_Tuukasyu.AUD, skJidounyuukinmeisailistDataSourceBeanLst);

        GetSyoruicd getSyoruicd = SWAKInjector.getInstance(GetSyoruicd.class);
        syoruiCdKbn = getSyoruicd.getSyoruicd_Jnyknmeisailist();
        createJidouNyknmsListRpt(skJidounyuukinmeisailistDataSourceBeanLst, syoruiCdKbn);

        skJidounyuukinmeisailistDataSourceBeanLst = Lists.newArrayList();
        nyktyhyoutKbnsetFlg = 2;
        listNm = HITUGIJILSTNMYENDT;

        createNtjJidouNyknmsList(C_Tuukasyu.JPY, skJidounyuukinmeisailistDataSourceBeanLst);

        createJidouNyknmsListRpt(skJidounyuukinmeisailistDataSourceBeanLst, C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST_YENDT);

        if (kessanTuikoFlg) {

            BizDate zengetuMatujitu = kidouSyoriYmd.getBizDateYM().getPreviousMonth().getLastDay();

            String nenDo = DateFormatUtil.dateYKANJISeirekiNendo(zengetuMatujitu);

            listNm = "";

            if (syoriM == INTEGER7) {

                listNm = LEFTKAKUYINYOUFU + nenDo + KESSANJIDAI1SIHANNKILSTNM;
            }
            else if (syoriM == INTEGER10) {

                listNm = LEFTKAKUYINYOUFU + nenDo + KESSANJIHANNKILSTNM;
            }
            else if (syoriM == INTEGER1) {

                listNm = LEFTKAKUYINYOUFU + nenDo + KESSANJIDAI3SIHANNKILSTNM;
            }
            else if (syoriM == INTEGER4) {

                listNm = LEFTKAKUYINYOUFU + nenDo + KESSANJIKESSANLSTNM;
            }

            skJidounyuukinmeisailistDataSourceBeanLst.clear();
            nyktyhyoutKbnsetFlg = 1;

            createKsnJidouNyknmsList(C_Tuukasyu.JPY, skJidounyuukinmeisailistDataSourceBeanLst);

            createKsnJidouNyknmsList(C_Tuukasyu.USD, skJidounyuukinmeisailistDataSourceBeanLst);

            createKsnJidouNyknmsList(C_Tuukasyu.AUD, skJidounyuukinmeisailistDataSourceBeanLst);

            createJidouNyknmsListRpt(skJidounyuukinmeisailistDataSourceBeanLst, C_SyoruiCdKbn.SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN);

            skJidounyuukinmeisailistDataSourceBeanLst = Lists.newArrayList();
            nyktyhyoutKbnsetFlg = 2;

            listNm = "";

            if (syoriM == INTEGER7) {

                listNm = LEFTKAKUYINYOUFU + nenDo + KESSANJIDAI1SIHANNKILSTNM_YENDT;
            }
            else if (syoriM == INTEGER10) {

                listNm = LEFTKAKUYINYOUFU + nenDo + KESSANJIHANNKILSTNM_YENDT;
            }
            else if (syoriM == INTEGER1) {

                listNm = LEFTKAKUYINYOUFU + nenDo + KESSANJIDAI3SIHANNKILSTNM_YENDT;
            }
            else if (syoriM == INTEGER4) {

                listNm = LEFTKAKUYINYOUFU + nenDo + KESSANJIKESSANLSTNM_YENDT;
            }

            createKsnJidouNyknmsList(C_Tuukasyu.JPY, skJidounyuukinmeisailistDataSourceBeanLst);

            createJidouNyknmsListRpt(skJidounyuukinmeisailistDataSourceBeanLst, C_SyoruiCdKbn.SK_JIDSYUUNOUSYOUGOUMEISAI_KESSAN_YENDT);
        }
    }

    private void createJidouNyknmsListRpt(
        ArrayList<IReportDataSouceBean> pSkJidounyuukinmeisailistDataSourceBeanLst, C_SyoruiCdKbn pSyoruiCdKbn) {

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            pSyoruiCdKbn);

        reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

        reportServicesBean.addParamObjects(pSyoruiCdKbn, pSkJidounyuukinmeisailistDataSourceBeanLst);

        createReport.execNoCommit(reportServicesBean);
    }

    private void createNtjJidouNyknmsList(C_Tuukasyu pTuukasyu,
        ArrayList<IReportDataSouceBean> pSkJidounyuukinmeisailistDataSourceBeanLst) {

        BizDate zengetuMatujitu = null;
        BizDate syoriYmd = null;
        BizDate kidouSyoriYmd = bzBatchParam.getSyoriYmd();

        if (kessanTuikoFlg) {

            zengetuMatujitu = kidouSyoriYmd.getBizDateYM().getPreviousMonth().getLastDay();

            syoriYmd = kidouSyoriYmd;
        }

        C_KessanKbn kessanKbn = C_KessanKbn.TUUJYOU;
        List<MosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuBean> mosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuBeanLst = null;
        BizDate denYmd = kidouSyoriYmd.addBusinessDays(INTEGER1);
        List<YokuziturkKgsByDensyskbnSyoriYmdZengetuLastdSyorizumiflgBean> yokukurikosigkInfoEnLst = null;
        List<TjtKgsByDensyskbnSyoriYmdBean> tjtKgsByDensyskbnSyoriYmdBeanLst = null;
        List<GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean> yokukurikosigkInfoGaikaLst   = null;
        List<GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean> gkTjtKgsByDensyskbnSyoriYmdTuukasyuBeanLst = null;
        C_NyktyhyoutKbn[] nyktyhyoutKbnList = null;

        if (nyktyhyoutKbnsetFlg == 1) {

            nyktyhyoutKbnList = new C_NyktyhyoutKbn[2];
            nyktyhyoutKbnList[0] = C_NyktyhyoutKbn.NONE;
            nyktyhyoutKbnList[1] = C_NyktyhyoutKbn.GAIKADATE;

        }
        else if (nyktyhyoutKbnsetFlg == 2) {

            nyktyhyoutKbnList = new C_NyktyhyoutKbn[1];
            nyktyhyoutKbnList[0] = C_NyktyhyoutKbn.YENDATE;
        }

        List<SyougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBean> syougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBeanLst =
            skHurikominyuukinListSakuseiDao.getSyougouittiKgsBySyoriYmdRyosyuymdRstuukasyuNyktyhyoutlst(
                kidouSyoriYmd, zengetuMatujitu, pTuukasyu, nyktyhyoutKbnList);

        List<SyougouittiNeKgsBySyoriYmdKnjyymdrstuukasyuBean> syougouittiNeKgsBySyoriYmdKnjyymdrstuukasyuBeanLst =
            skHurikominyuukinListSakuseiDao.getSyougouittiNeKgsBySyoriYmdKnjyymdrstuukasyuNyktyhyoutlst(
                kidouSyoriYmd, zengetuMatujitu, pTuukasyu, nyktyhyoutKbnList);

        mosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuBeanLst =
            skHurikominyuukinListSakuseiDao.getMosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuNyktyhyoutlst(
                kidouSyoriYmd, zengetuMatujitu, pTuukasyu, nyktyhyoutKbnList);

        List<YuukoukknsBySyoriYmdKnjyymdRstuukasyuBean> yuukoukknsBySyoriYmdKnjyymdRstuukasyuBeanLst =
            skHurikominyuukinListSakuseiDao.getYuukoukknsBySyoriYmdKnjyymdRstuukasyuNyktyhyoutlst(
                kidouSyoriYmd, zengetuMatujitu, pTuukasyu, nyktyhyoutKbnList);

        List<GinkouMdhnJdNyknTsygsBySyoriYmdNyksyoriymdRstuukasyuBean> ginkouMdhnJdNyknTsygsBySyoriYmdNyksyoriymdRstuukasyuBeanLst =
            skHurikominyuukinListSakuseiDao.getGinkouMdhnJdNyknTsygsBySyoriYmdNyksyoriymdRstuukasyuNyktyhyoutlst(
                kidouSyoriYmd, zengetuMatujitu, pTuukasyu, nyktyhyoutKbnList);

        BizCurrency tjGkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency yokuKurikosiGkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            yokukurikosigkInfoEnLst =
                skHurikominyuukinListSakuseiDao.getYokuziturkKgsByDensyskbnSyoriYmdZengetuLastdSyorizumiflgNyktyhyoutlst(
                    syoriYmd, zengetuMatujitu, nyktyhyoutKbnList);

            tjtKgsByDensyskbnSyoriYmdBeanLst = skHurikominyuukinListSakuseiDao.getTjtKgsByDensyskbnSyoriYmdNyktyhyoutlst(kidouSyoriYmd, nyktyhyoutKbnList);

            tjGkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            yokuKurikosiGkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        }
        else {

            yokukurikosigkInfoGaikaLst =
                sinkeiyakuDomManager.getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu(syoriYmd, zengetuMatujitu, pTuukasyu);

            gkTjtKgsByDensyskbnSyoriYmdTuukasyuBeanLst =
                sinkeiyakuDomManager.getGkTjtKgsByDensyskbnSyoriYmdTuukasyu(kidouSyoriYmd, pTuukasyu);

            if (gkTjtKgsByDensyskbnSyoriYmdTuukasyuBeanLst != null &&
                gkTjtKgsByDensyskbnSyoriYmdTuukasyuBeanLst.size() != 0) {

                if (gkTjtKgsByDensyskbnSyoriYmdTuukasyuBeanLst.get(0).getDengkSum() != null) {

                    tjGkYen = gkTjtKgsByDensyskbnSyoriYmdTuukasyuBeanLst.get(0).getDengkSum();
                }
            }

            if (yokukurikosigkInfoGaikaLst != null && yokukurikosigkInfoGaikaLst.size() != 0) {

                if (yokukurikosigkInfoGaikaLst.get(0).getDengkSum() != null) {

                    yokuKurikosiGkYen = yokukurikosigkInfoGaikaLst.get(0).getDengkSum();
                }
            }
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType tuukaType = henkanTuuka.henkanTuukaKbnToType(pTuukasyu);
        BizCurrency sgIttiGk = BizCurrency.valueOf(0, tuukaType);
        BizCurrency sgIttiGkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        Integer sgIttiGkKensuu = new Integer(0);
        BizCurrency hrkmTsrykinGk = BizCurrency.valueOf(0, tuukaType);
        Integer hrkmTsrykinGkKensuu = new Integer(0);
        BizCurrency sgHuittiGk = BizCurrency.valueOf(0, tuukaType);
        Integer sgHuittiGkKensuu = new Integer(0);
        BizCurrency mosTrksGk = BizCurrency.valueOf(0, tuukaType);
        Integer mosTrksGkKensuu = new Integer(0);
        BizCurrency yuukouKknKeikaGk = BizCurrency.valueOf(0, tuukaType);
        Integer yuukouKknKeikagkKensuu = new Integer(0);
        BizCurrency bankMdhntgtgknGk = BizCurrency.valueOf(0, tuukaType);
        Integer bankMdhntgtgknGkKensuu = new Integer(0);
        BizCurrency yokuKurikosiGk = BizCurrency.valueOf(0, tuukaType);
        Integer yokuKurikosiGkKensuu = new Integer(0);
        BizCurrency tjGk = BizCurrency.valueOf(0, tuukaType);
        Integer tjGkKensuu = new Integer(0);
        BizCurrency zenjituKurikosiGk = BizCurrency.valueOf(0, tuukaType);
        Integer zenjituKurikosiGkKensuu = new Integer(0);
        C_NyktyhyoutKbn nyktyhyoutKbn = C_NyktyhyoutKbn.NONE;

        if (nyktyhyoutKbnsetFlg == 1) {

            nyktyhyoutKbn = C_NyktyhyoutKbn.GAIKADATE;

        }
        else if (nyktyhyoutKbnsetFlg == 2) {

            nyktyhyoutKbn = C_NyktyhyoutKbn.YENDATE;
        }

        if (syougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBeanLst != null &&
            syougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBeanLst.size() != 0) {

            if (syougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getHrkmtsrySum() != null) {

                hrkmTsrykinGk = syougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getHrkmtsrySum();
            }
            if (syougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getRsgakuSum() != null) {

                sgIttiGk = syougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getRsgakuSum().add(hrkmTsrykinGk);
            }
            if (syougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getRsgakuenSum() != null) {

                sgIttiGkYen = syougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getRsgakuenSum();
            }

            sgIttiGkKensuu =
                new Integer(syougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getSyoriYmdCount().intValue());

            hrkmTsrykinGkKensuu =
                new Integer(syougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getSyoriYmdCount().intValue());
        }

        if (syougouittiNeKgsBySyoriYmdKnjyymdrstuukasyuBeanLst != null &&
            syougouittiNeKgsBySyoriYmdKnjyymdrstuukasyuBeanLst.size() != 0) {

            if (syougouittiNeKgsBySyoriYmdKnjyymdrstuukasyuBeanLst.get(0).getTrhkkgkSum() != null) {

                sgHuittiGk = syougouittiNeKgsBySyoriYmdKnjyymdrstuukasyuBeanLst.get(0).getTrhkkgkSum();
            }
            sgHuittiGkKensuu =
                new Integer(syougouittiNeKgsBySyoriYmdKnjyymdrstuukasyuBeanLst.get(0).getNyksyoriymdCount().intValue());
        }

        if (mosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuBeanLst != null &&
            mosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuBeanLst.size() != 0) {

            if (mosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuBeanLst.get(0).getTrhkkgkSum() != null) {

                mosTrksGk = mosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuBeanLst.get(0).getTrhkkgkSum();
            }

            mosTrksGkKensuu = new Integer(mosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuBeanLst.get(0)
                .getHrkmdeldataskbtkeyCount().intValue());
        }

        if (yuukoukknsBySyoriYmdKnjyymdRstuukasyuBeanLst != null &&
            yuukoukknsBySyoriYmdKnjyymdRstuukasyuBeanLst.size() != 0) {

            if (yuukoukknsBySyoriYmdKnjyymdRstuukasyuBeanLst.get(0).getTrhkkgkSum() != null) {

                yuukouKknKeikaGk = yuukoukknsBySyoriYmdKnjyymdRstuukasyuBeanLst.get(0).getTrhkkgkSum();
            }

            yuukouKknKeikagkKensuu = new Integer(yuukoukknsBySyoriYmdKnjyymdRstuukasyuBeanLst.get(0).
                getNyksyoriymdCount().intValue());
        }

        if (ginkouMdhnJdNyknTsygsBySyoriYmdNyksyoriymdRstuukasyuBeanLst != null &&
            ginkouMdhnJdNyknTsygsBySyoriYmdNyksyoriymdRstuukasyuBeanLst.size() != 0) {

            if (ginkouMdhnJdNyknTsygsBySyoriYmdNyksyoriymdRstuukasyuBeanLst.get(0).getTrhkkgkSum() != null) {

                bankMdhntgtgknGk = ginkouMdhnJdNyknTsygsBySyoriYmdNyksyoriymdRstuukasyuBeanLst.get(0).getTrhkkgkSum();
            }

            bankMdhntgtgknGkKensuu =
                ginkouMdhnJdNyknTsygsBySyoriYmdNyksyoriymdRstuukasyuBeanLst.get(0).getNyksyoriymdCount().intValue();

        }

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            if (yokukurikosigkInfoEnLst != null && yokukurikosigkInfoEnLst.size() != 0) {

                if (yokukurikosigkInfoEnLst.get(0).getTrhkkgkSum() != null) {

                    yokuKurikosiGk = yokukurikosigkInfoEnLst.get(0).getTrhkkgkSum();
                }

                yokuKurikosiGkKensuu =
                    new Integer(yokukurikosigkInfoEnLst.get(0).getSyoriYmdCount().intValue());
            }
        }
        else {

            if (yokukurikosigkInfoGaikaLst != null && yokukurikosigkInfoGaikaLst.size() != 0) {

                if (yokukurikosigkInfoGaikaLst.get(0).getTrhkkgkSum() != null) {

                    yokuKurikosiGk = yokukurikosigkInfoGaikaLst.get(0).getTrhkkgkSum();
                }

                yokuKurikosiGkKensuu = new Integer(yokukurikosigkInfoGaikaLst.get(0).getSyoriYmdCount().intValue());
            }
        }

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            if (tjtKgsByDensyskbnSyoriYmdBeanLst != null && tjtKgsByDensyskbnSyoriYmdBeanLst.size() != 0) {

                if (tjtKgsByDensyskbnSyoriYmdBeanLst.get(0).getTrhkkgkSum() != null) {

                    tjGk = tjtKgsByDensyskbnSyoriYmdBeanLst.get(0).getTrhkkgkSum();
                }

                tjGkKensuu = tjtKgsByDensyskbnSyoriYmdBeanLst.get(0).getSyoriYmdCount().intValue();
            }
        }
        else {

            if (gkTjtKgsByDensyskbnSyoriYmdTuukasyuBeanLst != null &&
                gkTjtKgsByDensyskbnSyoriYmdTuukasyuBeanLst.size() != 0) {

                if (gkTjtKgsByDensyskbnSyoriYmdTuukasyuBeanLst.get(0).getTrhkkgkSum() != null) {

                    tjGk = gkTjtKgsByDensyskbnSyoriYmdTuukasyuBeanLst.get(0).getTrhkkgkSum();
                }

                tjGkKensuu = gkTjtKgsByDensyskbnSyoriYmdTuukasyuBeanLst.get(0).getSyoriYmdCount().intValue();
            }
        }

        BizDate zengetuDensimeYmdNoNextEigyoubi = zengetuDensimeYmd.addBusinessDays(INTEGER1);

        BizDate kidouSyoriYmdNoMaeEigyoubi = kidouSyoriYmd.addBusinessDays(-1);

        if (kessanTuikoKikannNai &&
            BizDateUtil.compareYmd(kidouSyoriYmd, zengetuDensimeYmdNoNextEigyoubi) == BizDateUtil.COMPARE_EQUAL) {

            ZenzitukKgBySyoriYmdKessanKbnRstuukasyuNyktyhyoutListBean zenjitukurikosigkInfo1 =
                skHurikominyuukinListSakuseiDao.getZenzitukKgBySyoriYmdKessanKbnRstuukasyuNyktyhyoutList(
                    kidouSyoriYmdNoMaeEigyoubi, C_KessanKbn.TUUJYOU, pTuukasyu, nyktyhyoutKbnList);

            ZenzitukKgBySyoriYmdKessanKbnRstuukasyuNyktyhyoutListBean zenjitukurikosigkInfo2 =
                skHurikominyuukinListSakuseiDao.getZenzitukKgBySyoriYmdKessanKbnRstuukasyuNyktyhyoutList(
                    kidouSyoriYmdNoMaeEigyoubi, C_KessanKbn.KESSAN, pTuukasyu, nyktyhyoutKbnList);

            if (zenjitukurikosigkInfo1 != null) {

                zenjituKurikosiGk = zenjitukurikosigkInfo1.getYokukurikosigk();

                zenjituKurikosiGkKensuu = zenjitukurikosigkInfo1.getYokukurikosikensuu().intValue();
            }

            if (zenjitukurikosigkInfo2 != null) {

                zenjituKurikosiGk = zenjituKurikosiGk.add(zenjitukurikosigkInfo2.getYokukurikosigk());

                zenjituKurikosiGkKensuu = zenjituKurikosiGkKensuu + zenjitukurikosigkInfo2.getYokukurikosikensuu().intValue();
            }
        }
        else if (BizDateUtil.compareYmd(kidouSyoriYmd, kessankiSyoniti)== BizDateUtil.COMPARE_EQUAL){

        }
        else {

            ZenzitukKgBySyoriYmdKessanKbnRstuukasyuNyktyhyoutListBean zenjitukurikosigkInfo =
                skHurikominyuukinListSakuseiDao.getZenzitukKgBySyoriYmdKessanKbnRstuukasyuNyktyhyoutList(
                    kidouSyoriYmdNoMaeEigyoubi, kessanKbn, pTuukasyu, nyktyhyoutKbnList);

            if (zenjitukurikosigkInfo != null) {

                zenjituKurikosiGk = zenjitukurikosigkInfo.getYokukurikosigk();

                zenjituKurikosiGkKensuu = zenjitukurikosigkInfo.getYokukurikosikensuu().intValue();
            }
        }

        HT_JidouSyuunouMeisai2 jidouSyuunouMeisai2 = new HT_JidouSyuunouMeisai2();

        jidouSyuunouMeisai2.setSyoriYmd(kidouSyoriYmd);
        jidouSyuunouMeisai2.setKessankbn(kessanKbn);
        jidouSyuunouMeisai2.setRstuukasyu(pTuukasyu);
        jidouSyuunouMeisai2.setSgittikensuu(sgIttiGkKensuu);
        jidouSyuunouMeisai2.setSgittigk(sgIttiGk);
        jidouSyuunouMeisai2.setSgittigkyen(sgIttiGkYen);
        jidouSyuunouMeisai2.setSghuittikensuu(sgHuittiGkKensuu);
        jidouSyuunouMeisai2.setSghuittigk(sgHuittiGk);
        jidouSyuunouMeisai2.setMostrkskensuu(mosTrksGkKensuu);
        jidouSyuunouMeisai2.setMostrksgk(mosTrksGk);
        jidouSyuunouMeisai2.setYuukoukknkeikakensuu(yuukouKknKeikagkKensuu);
        jidouSyuunouMeisai2.setYuukoukknkeikagk(yuukouKknKeikaGk);
        jidouSyuunouMeisai2.setYokukurikosikensuu(yokuKurikosiGkKensuu);
        jidouSyuunouMeisai2.setYokukurikosigk(yokuKurikosiGk);
        jidouSyuunouMeisai2.setYokukurikosigkyen(yokuKurikosiGkYen);
        jidouSyuunouMeisai2.setJnykntsgkensuu(bankMdhntgtgknGkKensuu);
        jidouSyuunouMeisai2.setJnykntsggk(bankMdhntgtgknGk);
        jidouSyuunouMeisai2.setTjkensuu(tjGkKensuu);
        jidouSyuunouMeisai2.setTjgk(tjGk);
        jidouSyuunouMeisai2.setTjgkyen(tjGkYen);
        jidouSyuunouMeisai2.setZenjitukurikosikensuu(zenjituKurikosiGkKensuu);
        jidouSyuunouMeisai2.setZenjitukurikosigk(zenjituKurikosiGk);
        jidouSyuunouMeisai2.setHrkmtsrykensuu(hrkmTsrykinGkKensuu);
        jidouSyuunouMeisai2.setHrkmtsrykingk(hrkmTsrykinGk);
        jidouSyuunouMeisai2.setNyktyhyoutkbn(nyktyhyoutKbn);
        jidouSyuunouMeisai2.setGyoumuKousinsyaId(bzBatchParam.getUserId());
        jidouSyuunouMeisai2.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(jidouSyuunouMeisai2);

        sinkeiyakuDomManager.insert(jidouSyuunouMeisai2);

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean =
            SWAKInjector.getInstance(SkJidounyuukinmeisailistDataSourceBean.class);

        String tyouhyouAteSaki = ViewReport.editOntyuu(ateSaki);

        String tyouhyouYmd = DateFormatUtil.dateKANJI(kidouSyoriYmd);

        String editAutoDenYmd = DateFormatUtil.dateKANJI(denYmd);

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki(tyouhyouAteSaki);
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
        skJidounyuukinmeisailistDataSourceBean.setIrListnm(listNm);
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka(pTuukasyu.getContent() + "入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd(editAutoDenYmd);
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(tjGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(tjGk);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(tjGkYen);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(zenjituKurikosiGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(zenjituKurikosiGk);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(hrkmTsrykinGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(hrkmTsrykinGk);
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd(YuyuSinkeiyakuConfig.getInstance().getJigyouhicd());
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(sgIttiGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(sgIttiGk);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(sgIttiGkYen);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(sgHuittiGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(sgHuittiGk);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(mosTrksGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(mosTrksGk);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(yuukouKknKeikagkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(yuukouKknKeikaGk);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(yokuKurikosiGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(yokuKurikosiGk);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(yokuKurikosiGkYen);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(bankMdhntgtgknGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(bankMdhntgtgknGk);

        pSkJidounyuukinmeisailistDataSourceBeanLst.add(skJidounyuukinmeisailistDataSourceBean);

    }

    private void createKsnJidouNyknmsList(C_Tuukasyu pTuukasyu,
        ArrayList<IReportDataSouceBean> pSkJidounyuukinmeisailistDataSourceBeanLst) {

        BizDate kidouSyoriYmd = bzBatchParam.getSyoriYmd();
        BizDate zengetuMatujitu = kidouSyoriYmd.getBizDateYM().getPreviousMonth().getLastDay();
        C_KessanKbn kessanKbn = C_KessanKbn.KESSAN;
        BizDate denYmd = zengetuMatujitu;
        List<YokuziturkKgKsansByDensyskbnSyorizumiflgAzkrhrdsymdBean> yokuKurikosiGkInfoEnLst = null;
        List<GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean> yokuKurikosiGkInfoGaikaLst = null;
        C_KessanKbn zenjituKurikosiKessanKbn = null;
        C_NyktyhyoutKbn[] nyktyhyoutKbnList = null;

        if (nyktyhyoutKbnsetFlg == 1) {

            nyktyhyoutKbnList = new C_NyktyhyoutKbn[2];
            nyktyhyoutKbnList[0] = C_NyktyhyoutKbn.NONE;
            nyktyhyoutKbnList[1] = C_NyktyhyoutKbn.GAIKADATE;

        }
        else if (nyktyhyoutKbnsetFlg == 2) {

            nyktyhyoutKbnList = new C_NyktyhyoutKbn[1];
            nyktyhyoutKbnList[0] = C_NyktyhyoutKbn.YENDATE;
        }

        if (BizDateUtil.compareYmd(kidouSyoriYmd, kessankiSyoniti) == BizDateUtil.COMPARE_EQUAL) {
            zenjituKurikosiKessanKbn = C_KessanKbn.TUUJYOU;
        }
        else {
            zenjituKurikosiKessanKbn = C_KessanKbn.KESSAN;
        }

        List<SyougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBean> syougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBeanLst =
            skHurikominyuukinListSakuseiDao.getSyougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuNyktyhyoutlst(
                kidouSyoriYmd, zengetuMatujitu, pTuukasyu, nyktyhyoutKbnList);

        List<SyougouittiNeKgKsansBySyoriYmdKnjyymdrstuukasyuBean> syougouittiNeKgKsansBySyoriYmdKnjyymdrstuukasyuBeanLst =
            skHurikominyuukinListSakuseiDao.getSyougouittiNeKgKsansBySyoriYmdKnjyymdrstuukasyuNyktyhyoutlst(
                kidouSyoriYmd, zengetuMatujitu, pTuukasyu, nyktyhyoutKbnList);

        List<MosTorikesiKgKsansBySyoriYmdKnjyymdRstuukasyuBean> mosTorikesiKgKsansBySyoriYmdKnjyymdRstuukasyuBeanLst =
            skHurikominyuukinListSakuseiDao.getMosTorikesiKgKsansBySyoriYmdKnjyymdRstuukasyuNyktyhyoutlst(
                kidouSyoriYmd, zengetuMatujitu, pTuukasyu, nyktyhyoutKbnList);

        List<YuukoukknKsansBySyoriYmdKnjyymdRstuukasyuBean> yuukoukknKsansBySyoriYmdKnjyymdRstuukasyuBeanLst =
            skHurikominyuukinListSakuseiDao.getYuukoukknKsansBySyoriYmdKnjyymdRstuukasyuNyktyhyoutlst(
                kidouSyoriYmd, zengetuMatujitu, pTuukasyu, nyktyhyoutKbnList);

        List<GinkouMdhnJdNyknTsygKsansBySyoriYmdNyksyoriymdRstuukasyuBean> ginkouMdhnJdNyknTsygKsansBySyoriYmdNyksyoriymdRstuukasyuBeanLst =
            skHurikominyuukinListSakuseiDao.getGinkouMdhnJdNyknTsygKsansBySyoriYmdNyksyoriymdRstuukasyuNyktyhyoutlst(
                kidouSyoriYmd, zengetuMatujitu, pTuukasyu, nyktyhyoutKbnList);

        BizCurrency yokuKurikosiGkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            yokuKurikosiGkInfoEnLst = skHurikominyuukinListSakuseiDao.getYokuziturkKgKsansByDensyskbnSyorizumiflgAzkrhrdsymdNyktyhyoutlst(
                zengetuMatujitu, nyktyhyoutKbnList);
            yokuKurikosiGkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }
        else {

            yokuKurikosiGkInfoGaikaLst =
                sinkeiyakuDomManager.getGkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyu(zengetuMatujitu, pTuukasyu);

            if (yokuKurikosiGkInfoGaikaLst != null && yokuKurikosiGkInfoGaikaLst.size() != 0) {

                if (yokuKurikosiGkInfoGaikaLst.get(0).getDengkSum() != null) {

                    yokuKurikosiGkYen = yokuKurikosiGkInfoGaikaLst.get(0).getDengkSum();
                }
            }
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType TuukaType = henkanTuuka.henkanTuukaKbnToType(pTuukasyu);
        BizCurrency sgIttiGk = BizCurrency.valueOf(0, TuukaType);
        BizCurrency sgIttiGkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        Integer sgIttiGkKensuu = new Integer(0);
        BizCurrency hrkmTsrykinGk = BizCurrency.valueOf(0, TuukaType);
        Integer hrkmTsrykinGkKensuu = new Integer(0);
        BizCurrency sgHuittiGk = BizCurrency.valueOf(0, TuukaType);
        Integer sgHuittiGkKensuu = new Integer(0);
        BizCurrency mosTrksGk = BizCurrency.valueOf(0, TuukaType);
        Integer mosTrksGkKensuu = new Integer(0);
        BizCurrency yuukouKknKeikaGk = BizCurrency.valueOf(0, TuukaType);
        Integer yuukouKknKeikagkKensuu = new Integer(0);
        BizCurrency bankMdhntgtgknGk = BizCurrency.valueOf(0, TuukaType);
        Integer bankMdhntgtgknGkKensuu = new Integer(0);
        BizCurrency yokuKurikosiGk = BizCurrency.valueOf(0, TuukaType);
        Integer yokuKurikosiGkKensuu = new Integer(0);
        BizCurrency tjGk = BizCurrency.valueOf(0, TuukaType);
        Integer tjGkKensuu = new Integer(0);
        BizCurrency zenjituKurikosiGk = BizCurrency.valueOf(0, TuukaType);
        Integer zenjituKurikosiGkKensuu = new Integer(0);
        BizCurrency tjGkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        C_NyktyhyoutKbn nyktyhyoutKbn = C_NyktyhyoutKbn.NONE;

        if (nyktyhyoutKbnsetFlg == 1) {

            nyktyhyoutKbn = C_NyktyhyoutKbn.GAIKADATE;

        }
        else if (nyktyhyoutKbnsetFlg == 2) {

            nyktyhyoutKbn = C_NyktyhyoutKbn.YENDATE;
        }

        if (syougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBeanLst != null &&
            syougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBeanLst.size() != 0) {

            if (syougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getHrkmtsrySum() != null) {

                hrkmTsrykinGk = syougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getHrkmtsrySum();
            }

            if (syougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getRsgakuSum() != null) {

                sgIttiGk = syougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getRsgakuSum().add(hrkmTsrykinGk);
            }

            if (syougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getRsgakuenSum() != null) {

                sgIttiGkYen = syougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getRsgakuenSum();
            }

            sgIttiGkKensuu =
                new Integer(syougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getSyoriYmdCount().intValue());

            hrkmTsrykinGkKensuu =
                new Integer(syougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBeanLst.get(0).getSyoriYmdCount().intValue());
        }

        if (syougouittiNeKgKsansBySyoriYmdKnjyymdrstuukasyuBeanLst != null &&
            syougouittiNeKgKsansBySyoriYmdKnjyymdrstuukasyuBeanLst.size() != 0) {

            if (syougouittiNeKgKsansBySyoriYmdKnjyymdrstuukasyuBeanLst.get(0).getTrhkkgkSum() != null) {

                sgHuittiGk = syougouittiNeKgKsansBySyoriYmdKnjyymdrstuukasyuBeanLst.get(0).getTrhkkgkSum();
            }

            sgHuittiGkKensuu =
                new Integer(syougouittiNeKgKsansBySyoriYmdKnjyymdrstuukasyuBeanLst.get(0).getNyksyoriymdCount().intValue());
        }

        if (mosTorikesiKgKsansBySyoriYmdKnjyymdRstuukasyuBeanLst != null &&
            mosTorikesiKgKsansBySyoriYmdKnjyymdRstuukasyuBeanLst.size() != 0) {

            if (mosTorikesiKgKsansBySyoriYmdKnjyymdRstuukasyuBeanLst.get(0).getTrhkkgkSum() != null) {

                mosTrksGk = mosTorikesiKgKsansBySyoriYmdKnjyymdRstuukasyuBeanLst.get(0).getTrhkkgkSum();
            }

            mosTrksGkKensuu =
                new Integer(mosTorikesiKgKsansBySyoriYmdKnjyymdRstuukasyuBeanLst.get(0).getHrkmdeldataskbtkeyCount().intValue());
        }

        if (yuukoukknKsansBySyoriYmdKnjyymdRstuukasyuBeanLst != null &&
            yuukoukknKsansBySyoriYmdKnjyymdRstuukasyuBeanLst.size() != 0) {

            if (yuukoukknKsansBySyoriYmdKnjyymdRstuukasyuBeanLst.get(0).getTrhkkgkSum() != null) {

                yuukouKknKeikaGk = yuukoukknKsansBySyoriYmdKnjyymdRstuukasyuBeanLst.get(0).getTrhkkgkSum();
            }

            yuukouKknKeikagkKensuu =
                new Integer(yuukoukknKsansBySyoriYmdKnjyymdRstuukasyuBeanLst.get(0).getNyksyoriymdCount().intValue());
        }

        if (ginkouMdhnJdNyknTsygKsansBySyoriYmdNyksyoriymdRstuukasyuBeanLst != null &&
            ginkouMdhnJdNyknTsygKsansBySyoriYmdNyksyoriymdRstuukasyuBeanLst.size() != 0) {

            if (ginkouMdhnJdNyknTsygKsansBySyoriYmdNyksyoriymdRstuukasyuBeanLst.get(0).getTrhkkgkSum() != null) {

                bankMdhntgtgknGk = ginkouMdhnJdNyknTsygKsansBySyoriYmdNyksyoriymdRstuukasyuBeanLst.get(0).getTrhkkgkSum();
            }

            bankMdhntgtgknGkKensuu =
                new Integer(ginkouMdhnJdNyknTsygKsansBySyoriYmdNyksyoriymdRstuukasyuBeanLst.get(0).getNyksyoriymdCount().intValue());
        }

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            if (yokuKurikosiGkInfoEnLst != null && yokuKurikosiGkInfoEnLst.size() != 0) {

                if (yokuKurikosiGkInfoEnLst.get(0).getTrhkkgkSum() != null) {

                    yokuKurikosiGk = yokuKurikosiGkInfoEnLst.get(0).getTrhkkgkSum();
                }

                yokuKurikosiGkKensuu = new Integer(yokuKurikosiGkInfoEnLst.get(0).getSyoriYmdCount().intValue());
            }
        }
        else {

            if (yokuKurikosiGkInfoGaikaLst != null && yokuKurikosiGkInfoGaikaLst.size() != 0) {

                if (yokuKurikosiGkInfoGaikaLst.get(0).getTrhkkgkSum() != null) {

                    yokuKurikosiGk = yokuKurikosiGkInfoGaikaLst.get(0).getTrhkkgkSum();
                }

                yokuKurikosiGkKensuu = new Integer(yokuKurikosiGkInfoGaikaLst.get(0).getSyoriYmdCount().intValue());
            }
        }

        BizDate kidouSyoriYmdNoMaeEigyoubi = kidouSyoriYmd.addBusinessDays(-1);

        ZenzitukKgBySyoriYmdKessanKbnRstuukasyuNyktyhyoutListBean zenjitukurikosigkInfo =
            skHurikominyuukinListSakuseiDao.getZenzitukKgBySyoriYmdKessanKbnRstuukasyuNyktyhyoutList(
                kidouSyoriYmdNoMaeEigyoubi, zenjituKurikosiKessanKbn, pTuukasyu, nyktyhyoutKbnList);

        if (zenjitukurikosigkInfo != null) {

            zenjituKurikosiGk = zenjitukurikosigkInfo.getYokukurikosigk();
            zenjituKurikosiGkKensuu = zenjitukurikosigkInfo.getYokukurikosikensuu().intValue();
        }

        HT_JidouSyuunouMeisai2 jidouSyuunouMeisai2 = new HT_JidouSyuunouMeisai2();

        jidouSyuunouMeisai2.setSyoriYmd(kidouSyoriYmd);
        jidouSyuunouMeisai2.setKessankbn(kessanKbn);
        jidouSyuunouMeisai2.setRstuukasyu(pTuukasyu);
        jidouSyuunouMeisai2.setSgittikensuu(sgIttiGkKensuu);
        jidouSyuunouMeisai2.setSgittigk(sgIttiGk);
        jidouSyuunouMeisai2.setSgittigkyen(sgIttiGkYen);
        jidouSyuunouMeisai2.setSghuittikensuu(sgHuittiGkKensuu);
        jidouSyuunouMeisai2.setSghuittigk(sgHuittiGk);
        jidouSyuunouMeisai2.setMostrkskensuu(mosTrksGkKensuu);
        jidouSyuunouMeisai2.setMostrksgk(mosTrksGk);
        jidouSyuunouMeisai2.setYuukoukknkeikakensuu(yuukouKknKeikagkKensuu);
        jidouSyuunouMeisai2.setYuukoukknkeikagk(yuukouKknKeikaGk);
        jidouSyuunouMeisai2.setYokukurikosikensuu(yokuKurikosiGkKensuu);
        jidouSyuunouMeisai2.setYokukurikosigk(yokuKurikosiGk);
        jidouSyuunouMeisai2.setYokukurikosigkyen(yokuKurikosiGkYen);
        jidouSyuunouMeisai2.setJnykntsgkensuu(bankMdhntgtgknGkKensuu);
        jidouSyuunouMeisai2.setJnykntsggk(bankMdhntgtgknGk);
        jidouSyuunouMeisai2.setTjkensuu(tjGkKensuu);
        jidouSyuunouMeisai2.setTjgk(tjGk);
        jidouSyuunouMeisai2.setTjgkyen(tjGkYen);
        jidouSyuunouMeisai2.setZenjitukurikosikensuu(zenjituKurikosiGkKensuu);
        jidouSyuunouMeisai2.setZenjitukurikosigk(zenjituKurikosiGk);
        jidouSyuunouMeisai2.setHrkmtsrykensuu(hrkmTsrykinGkKensuu);
        jidouSyuunouMeisai2.setHrkmtsrykingk(hrkmTsrykinGk);
        jidouSyuunouMeisai2.setNyktyhyoutkbn(nyktyhyoutKbn);
        jidouSyuunouMeisai2.setGyoumuKousinsyaId(bzBatchParam.getUserId());
        jidouSyuunouMeisai2.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(jidouSyuunouMeisai2);

        sinkeiyakuDomManager.insert(jidouSyuunouMeisai2);

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean =
            SWAKInjector.getInstance(SkJidounyuukinmeisailistDataSourceBean.class);

        String tyouhyouAteSaki = ViewReport.editOntyuu(ateSaki);

        String tyouhyouYmd = DateFormatUtil.dateKANJI(kidouSyoriYmd);

        String editAutoDenYmd = DateFormatUtil.dateKANJI(denYmd);

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki(tyouhyouAteSaki);
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
        skJidounyuukinmeisailistDataSourceBean.setIrListnm(listNm);
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka(pTuukasyu.getContent() + "入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd(editAutoDenYmd);
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(tjGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(tjGk);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(tjGkYen);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(zenjituKurikosiGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(zenjituKurikosiGk);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(hrkmTsrykinGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(hrkmTsrykinGk);
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd(YuyuSinkeiyakuConfig.getInstance().getJigyouhicd());
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(sgIttiGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(sgIttiGk);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(sgIttiGkYen);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(sgHuittiGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(sgHuittiGk);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(mosTrksGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(mosTrksGk);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(yuukouKknKeikagkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(yuukouKknKeikaGk);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(yokuKurikosiGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(yokuKurikosiGk);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(yokuKurikosiGkYen);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(bankMdhntgtgknGkKensuu);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(bankMdhntgtgknGk);

        pSkJidounyuukinmeisailistDataSourceBeanLst.add(skJidounyuukinmeisailistDataSourceBean);

    }
}
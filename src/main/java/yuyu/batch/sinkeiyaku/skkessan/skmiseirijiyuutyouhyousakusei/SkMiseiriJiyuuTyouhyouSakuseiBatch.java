package yuyu.batch.sinkeiyaku.skkessan.skmiseirijiyuutyouhyousakusei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.skkessan.skmiseirijiyuutyouhyousakusei.dba.SkMiseiriJiyuuTyouhyouSakuseiDao;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_MiseirijiyuuMeisai;
import yuyu.def.sinkeiyaku.bean.report.SkKessanMiseiriBean;
import yuyu.def.sinkeiyaku.bean.report.SkMiseirijiyuuKrkmeisaiDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkMiseirijiyuuKrksyuukeiBean;
import yuyu.def.sinkeiyaku.bean.report.SkMiseirijiyuuNyuukinhubiDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkMiseirijiyuuSeirituhoryuuDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkMiseirijiyuuSyoruihubiDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkMiseirikariukekinmeisaiDataSourceBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 決算 未整理事由別明細帳票作成
 */
public class SkMiseiriJiyuuTyouhyouSakuseiBatch implements Batch {

    private String kanjiSosikinm = "";

    private String tyouhyouYmd = "";

    private String nendo = "";

    private String shnkNm = "";

    private SkKessanMiseiriBean miseiriKariukekinBean;

    private List<IReportDataSouceBean> miseiriKariukekinMeisaiLst;

    private BizNumber miseiriKariukekinMeisaiSouKs;

    private SkKessanMiseiriBean miseirijiyuuSeirituhoryuuBean;

    private List<IReportDataSouceBean> miseirijiyuuSeirituhoryuuLst;

    private BizNumber miseirijiyuuSeirituhoryuuSouKs;

    private SkKessanMiseiriBean nyuukinHubiBean;

    private List<IReportDataSouceBean> nyuukinHubiMeisaiLst;

    private BizNumber nyuukinHubiMeisaiSouKensuu;

    private SkKessanMiseiriBean miseirijiyuuSyoruihubiTdBean;

    private List<IReportDataSouceBean> miseirijiyuuSyoruihubiTdLst;

    private BizNumber miseirijiyuuSyoruihubiTdSouKs;

    private SkKessanMiseiriBean miseirijiyuuSyoruihubiFsBean;

    private List<IReportDataSouceBean> miseirijiyuuSyoruihubiFsLst;

    private BizNumber miseirijiyuuSyoruihubiFsSouKs;

    private SkKessanMiseiriBean miseirijiyuuKrkmeisaiBean;

    private List<IReportDataSouceBean> miseirijiyuuKrkmeisaiLst;

    private BizNumber miseirijiyuuKrkmeisaiSouKs;

    private List<SkMiseirijiyuuKrksyuukeiBean> miseirijiyuuKrksyuukeiLst;

    private BizNumber miseirijiyuuKrksyuukeiSouKs;

    private List<C_Tuukasyu> kyktuukasyuList;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private CreateReport createReport;

    @Inject
    private SkMiseiriJiyuuTyouhyouSakuseiDao skMiseiriJiyuuTyouhyouSakuseiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, "処理年月日", String.valueOf(syoriYmd)));

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean sosikiDataBean =
            bzGetSosikiData.exec(YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd());

        if (C_SosikimasterUmuKbn.ARI.eq(sosikiDataBean.getSosikimasterumukbn())) {

            kanjiSosikinm = ViewReport.editOntyuu(sosikiDataBean.getKanjisosikinm20());
        }

        tyouhyouYmd = DateFormatUtil.dateKANJI(syoriYmd);

        nendo = DateFormatUtil.dateYKANJISeirekiNendo(syoriYmd.getBizDateYM().getPreviousMonth().getLastDay());

        int syoriM = syoriYmd.getMonth();

        if (syoriM == 6 || syoriM == 7) {
            shnkNm = "第１四半期";
        }
        else if (syoriM == 9 || syoriM == 10) {
            shnkNm = "半期";
        }
        else if (syoriM == 12 || syoriM == 1) {
            shnkNm = "第３四半期";
        }
        else if (syoriM == 3 || syoriM == 4) {
            shnkNm = "決算";
        }

        List<C_Tuukasyu> tuukasyuLst = new ArrayList<>();

        tuukasyuLst.add(C_Tuukasyu.JPY);
        tuukasyuLst.add(C_Tuukasyu.USD);
        tuukasyuLst.add(C_Tuukasyu.AUD);

        kyktuukasyuList = new ArrayList<>();
        kyktuukasyuList.add(C_Tuukasyu.USD);
        kyktuukasyuList.add(C_Tuukasyu.AUD);

        createSkMiseirikariukekinmeisaiLstAndSkMiseirijiyuuSeirituhoryuuLst(tuukasyuLst);
        createSkMiseirijiyuuKrkmeisaiLstAndSkMiseirijiyuuKrksyuukeiLst(tuukasyuLst);
        createSkMiseirijiyuuNyuukinhubiLst(tuukasyuLst);
        createSkMiseirijiyuuSyoruihubiTandokuLst(tuukasyuLst);
        createSkMiseirijiyuuSyoruihubiFukusuuLst(tuukasyuLst);

        createSkMiseirikariukekinmeisai(C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);
        createSkMiseirijiyuuNyuukinhubi(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);
        createSkMiseirijiyuuSyoruihubiTandoku(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);
        createSkMiseirijiyuuSyoruihubiFukusuu(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU);
        createSkMiseirijiyuuSeirituhoryuu(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);
        createSkMiseirijiyuuKrkmeisai(C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST);
        createSkMiseirijiyuuKrksyuukei(C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(miseiriKariukekinMeisaiSouKs), "未整理仮受金明細件数"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(nyuukinHubiMeisaiSouKensuu), "入金内容不備契約明細件数"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(miseirijiyuuSyoruihubiTdSouKs), "未整理事由明細（書類不備）単独件数"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(miseirijiyuuSyoruihubiFsSouKs), "未整理事由明細（書類不備）複数件数"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(miseirijiyuuSeirituhoryuuSouKs), "未整理事由明細（成立保留受付中）件数"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(miseirijiyuuKrkmeisaiSouKs), "未整理事由別仮受金明細リスト件数"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(miseirijiyuuKrksyuukeiSouKs), "未整理事由別仮受金集計表件数"));

        miseiriKariukekinMeisaiSouKs = BizNumber.ZERO;
        nyuukinHubiMeisaiSouKensuu = BizNumber.ZERO;
        miseirijiyuuSyoruihubiTdSouKs = BizNumber.ZERO;
        miseirijiyuuSyoruihubiFsSouKs = BizNumber.ZERO;
        miseirijiyuuSeirituhoryuuSouKs = BizNumber.ZERO;
        miseirijiyuuKrkmeisaiSouKs = BizNumber.ZERO;
        miseirijiyuuKrksyuukeiSouKs = BizNumber.ZERO;
        miseiriKariukekinBean = SWAKInjector.getInstance(SkKessanMiseiriBean.class);
        miseiriKariukekinMeisaiLst = new ArrayList<>();
        nyuukinHubiMeisaiLst = new ArrayList<>();
        miseirijiyuuSyoruihubiTdBean = SWAKInjector.getInstance(SkKessanMiseiriBean.class);
        miseirijiyuuSyoruihubiTdLst = new ArrayList<>();
        miseirijiyuuSyoruihubiFsBean = SWAKInjector.getInstance(SkKessanMiseiriBean.class);
        miseirijiyuuSyoruihubiFsLst = new ArrayList<>();
        miseirijiyuuSeirituhoryuuBean = SWAKInjector.getInstance(SkKessanMiseiriBean.class);
        miseirijiyuuSeirituhoryuuLst = new ArrayList<>();
        miseirijiyuuKrkmeisaiBean = SWAKInjector.getInstance(SkKessanMiseiriBean.class);
        miseirijiyuuKrkmeisaiLst = new ArrayList<>();
        miseirijiyuuKrksyuukeiLst = new ArrayList<>();

        tuukasyuLst = new ArrayList<>();

        tuukasyuLst.add(C_Tuukasyu.JPY);

        kyktuukasyuList = new ArrayList<>();
        kyktuukasyuList.add(C_Tuukasyu.JPY);

        createSkMiseirikariukekinmeisaiLstAndSkMiseirijiyuuSeirituhoryuuLst(tuukasyuLst);
        createSkMiseirijiyuuKrkmeisaiLstAndSkMiseirijiyuuKrksyuukeiLst(tuukasyuLst);
        createSkMiseirijiyuuNyuukinhubiLst(tuukasyuLst);
        createSkMiseirijiyuuSyoruihubiTandokuLst(tuukasyuLst);
        createSkMiseirijiyuuSyoruihubiFukusuuLst(tuukasyuLst);

        createSkMiseirikariukekinmeisai(C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI_YENDT);
        createSkMiseirijiyuuNyuukinhubi(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI_YENDT);
        createSkMiseirijiyuuSyoruihubiTandoku(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN_YENDT);
        createSkMiseirijiyuuSyoruihubiFukusuu(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_HUKU_YENDT);
        createSkMiseirijiyuuSeirituhoryuu(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU_YENDT);
        createSkMiseirijiyuuKrkmeisai(C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST_YENDT);
        createSkMiseirijiyuuKrksyuukei(C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI_YENDT);

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(miseiriKariukekinMeisaiSouKs), "未整理仮受金明細（円建）件数"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(nyuukinHubiMeisaiSouKensuu), "入金内容不備契約明細（円建）件数"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(miseirijiyuuSyoruihubiTdSouKs), "未整理事由明細（書類不備）単独（円建）件数"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(miseirijiyuuSyoruihubiFsSouKs), "未整理事由明細（書類不備）複数（円建）件数"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(miseirijiyuuSeirituhoryuuSouKs), "未整理事由明細（成立保留受付中）（円建）件数"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(miseirijiyuuKrkmeisaiSouKs), "未整理事由別仮受金明細リスト（円建）件数"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(miseirijiyuuKrksyuukeiSouKs), "未整理事由別仮受金集計表（円建）件数"));
    }

    private void createSkMiseirikariukekinmeisaiLstAndSkMiseirijiyuuSeirituhoryuuLst(
        List<C_Tuukasyu> pTuukasyuLst) {

        miseiriKariukekinBean = SWAKInjector.getInstance(SkKessanMiseiriBean.class);
        miseirijiyuuSeirituhoryuuBean = SWAKInjector.getInstance(SkKessanMiseiriBean.class);

        miseiriKariukekinBean.setIrAtesaki(kanjiSosikinm);
        miseiriKariukekinBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
        miseiriKariukekinBean.setIrNendo(nendo);
        miseiriKariukekinBean.setIrShnknm(shnkNm);

        if (!kyktuukasyuList.contains(C_Tuukasyu.JPY)) {

            miseiriKariukekinBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");
        }
        else {

            miseiriKariukekinBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）（円建）");
        }

        miseirijiyuuSeirituhoryuuBean.setIrAtesaki(kanjiSosikinm);
        miseirijiyuuSeirituhoryuuBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
        miseirijiyuuSeirituhoryuuBean.setIrNendo(nendo);
        miseirijiyuuSeirituhoryuuBean.setIrShnknm(shnkNm);
        if (!kyktuukasyuList.contains(C_Tuukasyu.JPY)) {

            miseirijiyuuSeirituhoryuuBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);
        }
        else {

            miseirijiyuuSeirituhoryuuBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU_YENDT);
        }

        miseiriKariukekinMeisaiLst = new ArrayList<>();
        miseirijiyuuSeirituhoryuuLst = new ArrayList<>();
        miseiriKariukekinMeisaiSouKs = BizNumber.ZERO;
        miseirijiyuuSeirituhoryuuSouKs = BizNumber.ZERO;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType tuukaType = null;
        BizNumber meisaiKensuu = BizNumber.ZERO;
        BizCurrency meisaiRsgkGoukeiYen = BizCurrency.valueOf(0);
        BizCurrency meisaiRsgkGoukei = BizCurrency.valueOf(0);
        BizNumber seirituMeisaiKensuu = BizNumber.ZERO;
        BizCurrency seirituMeisaiRsgkGoukeiYen = BizCurrency.valueOf(0);
        BizCurrency seirituMeisaiRsgkGoukei = BizCurrency.valueOf(0);
        String sknnKaisiYmd = "";
        String kykYmd = "";
        String rsYmd = "";

        for (C_Tuukasyu tuukaSyu : pTuukasyuLst) {

            try (ExDBResults<HT_MiseirijiyuuMeisai> miseirijiyuuMeisaiLst =
                skMiseiriJiyuuTyouhyouSakuseiDao.getMosnoMiseirijiyuuMeisaisByRstuukasyuKyktuukasyulst(tuukaSyu,
                    kyktuukasyuList.toArray(new C_Tuukasyu[kyktuukasyuList.size()]))){

                tuukaType = henkanTuuka.henkanTuukaKbnToType(tuukaSyu);

                meisaiKensuu = BizNumber.ZERO;
                meisaiRsgkGoukeiYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                meisaiRsgkGoukei = BizCurrency.valueOf(0, tuukaType);
                seirituMeisaiKensuu = BizNumber.ZERO;
                seirituMeisaiRsgkGoukeiYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                seirituMeisaiRsgkGoukei = BizCurrency.valueOf(0, tuukaType);

                SkMiseirikariukekinmeisaiDataSourceBean skMiseiriKrkMeisaiDsBeanGoukei =
                    SWAKInjector.getInstance(SkMiseirikariukekinmeisaiDataSourceBean.class);
                SkMiseirijiyuuSeirituhoryuuDataSourceBean skMisrjyuSeirituhoryuuDsBeanGoukei =
                    SWAKInjector.getInstance(SkMiseirijiyuuSeirituhoryuuDataSourceBean.class);

                Iterator<HT_MiseirijiyuuMeisai> iterator = miseirijiyuuMeisaiLst.iterator();

                while (iterator.hasNext()) {

                    HT_MiseirijiyuuMeisai miseirijiyuuMeisai = iterator.next();
                    sknnKaisiYmd = "";
                    kykYmd = "";
                    rsYmd = "";
                    BizCurrency rsgakuYen = miseirijiyuuMeisai.getRsgakuen();
                    BizCurrency rsgakuGaika = miseirijiyuuMeisai.getRsgakugaika();
                    BizCurrency krkdai1kaikeijyougkyen = miseirijiyuuMeisai.getKrkdai1kaikeijyougkyen();
                    BizCurrency krkdai1kaikeijyougkgaika = miseirijiyuuMeisai.getKrkdai1kaikeijyougkgaika();

                    if (miseirijiyuuMeisai.getSknnkaisiymd() != null) {
                        sknnKaisiYmd = miseirijiyuuMeisai.getSknnkaisiymd().toString();
                    }

                    if (miseirijiyuuMeisai.getKykymd() != null) {
                        kykYmd = miseirijiyuuMeisai.getKykymd().toString();
                    }

                    if (miseirijiyuuMeisai.getSyokairsymd() != null) {
                        rsYmd = miseirijiyuuMeisai.getSyokairsymd().toString();
                    }

                    SkMiseirikariukekinmeisaiDataSourceBean skMiseirikariukekinmeisaiDataSourceBean =
                        SWAKInjector.getInstance(SkMiseirikariukekinmeisaiDataSourceBean.class);

                    skMiseirikariukekinmeisaiDataSourceBean.setIrNyukintuuka(tuukaSyu.getContent());
                    skMiseirikariukekinmeisaiDataSourceBean.setIrMosno(miseirijiyuuMeisai.getMosno());
                    skMiseirikariukekinmeisaiDataSourceBean.setIrKyknmkn(miseirijiyuuMeisai.getKyknmkn());
                    skMiseirikariukekinmeisaiDataSourceBean.setIrSknnkaisiymd(sknnKaisiYmd);
                    skMiseirikariukekinmeisaiDataSourceBean.setIrKykymd(kykYmd);
                    skMiseirikariukekinmeisaiDataSourceBean.setIrRyosyuymd(rsYmd);
                    skMiseirikariukekinmeisaiDataSourceBean.setIrRsgakuyen(krkdai1kaikeijyougkyen);
                    skMiseirikariukekinmeisaiDataSourceBean.setIrRsgaku(krkdai1kaikeijyougkgaika);
                    skMiseirikariukekinmeisaiDataSourceBean.setIrKensuugoukei(null);
                    skMiseirikariukekinmeisaiDataSourceBean.setIrKingakugoukeiyen(null);
                    skMiseirikariukekinmeisaiDataSourceBean.setIrKingakugoukei(null);

                    meisaiKensuu = meisaiKensuu.add(BizNumber.ONE);
                    meisaiRsgkGoukeiYen = meisaiRsgkGoukeiYen.add(krkdai1kaikeijyougkyen);
                    meisaiRsgkGoukei = meisaiRsgkGoukei.add(krkdai1kaikeijyougkgaika);

                    miseiriKariukekinMeisaiLst.add(skMiseirikariukekinmeisaiDataSourceBean);

                    skMiseiriKrkMeisaiDsBeanGoukei = skMiseirikariukekinmeisaiDataSourceBean;

                    if ( "03".equals(miseirijiyuuMeisai.getMiseirijiyuukbn()) &&
                        "03".equals(miseirijiyuuMeisai.getMiseirijiyuudetailkbn())) {

                        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean =
                            SWAKInjector.getInstance(SkMiseirijiyuuSeirituhoryuuDataSourceBean.class);

                        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrNyukintuuka(tuukaSyu.getContent());
                        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrMosno(miseirijiyuuMeisai.getMosno());
                        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrKyknmkn(miseirijiyuuMeisai.getKyknmkn());
                        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrRsgakuyen(rsgakuYen);
                        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrRsgaku(rsgakuGaika);
                        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrKensuugoukei(null);
                        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrKingakugoukeiyen(null);
                        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrKingakugoukei(null);

                        seirituMeisaiKensuu = seirituMeisaiKensuu.add(BizNumber.ONE);
                        seirituMeisaiRsgkGoukeiYen = seirituMeisaiRsgkGoukeiYen.add(rsgakuYen);
                        seirituMeisaiRsgkGoukei = seirituMeisaiRsgkGoukei.add(rsgakuGaika);

                        miseirijiyuuSeirituhoryuuLst.add(skMiseirijiyuuSeirituhoryuuDataSourceBean);

                        skMisrjyuSeirituhoryuuDsBeanGoukei = skMiseirijiyuuSeirituhoryuuDataSourceBean;
                    }
                }

                skMiseiriKrkMeisaiDsBeanGoukei.setIrKensuugoukei(meisaiKensuu);
                skMiseiriKrkMeisaiDsBeanGoukei.setIrKingakugoukeiyen(meisaiRsgkGoukeiYen);
                skMiseiriKrkMeisaiDsBeanGoukei.setIrKingakugoukei(meisaiRsgkGoukei);

                skMisrjyuSeirituhoryuuDsBeanGoukei.setIrKensuugoukei(seirituMeisaiKensuu);
                skMisrjyuSeirituhoryuuDsBeanGoukei.setIrKingakugoukeiyen(seirituMeisaiRsgkGoukeiYen);
                skMisrjyuSeirituhoryuuDsBeanGoukei.setIrKingakugoukei(seirituMeisaiRsgkGoukei);

                if (meisaiKensuu.compareTo(BizNumber.ZERO) == 0) {

                    skMiseiriKrkMeisaiDsBeanGoukei.setIrNyukintuuka(tuukaSyu.getContent());
                    skMiseiriKrkMeisaiDsBeanGoukei.setIrMosno("");
                    skMiseiriKrkMeisaiDsBeanGoukei.setIrKyknmkn("");
                    skMiseiriKrkMeisaiDsBeanGoukei.setIrSknnkaisiymd("");
                    skMiseiriKrkMeisaiDsBeanGoukei.setIrKykymd("");
                    skMiseiriKrkMeisaiDsBeanGoukei.setIrRyosyuymd("");
                    skMiseiriKrkMeisaiDsBeanGoukei.setIrRsgakuyen(null);
                    skMiseiriKrkMeisaiDsBeanGoukei.setIrRsgaku(null);

                    miseiriKariukekinMeisaiLst.add(skMiseiriKrkMeisaiDsBeanGoukei);
                }

                if (seirituMeisaiKensuu.compareTo(BizNumber.ZERO) == 0) {

                    skMisrjyuSeirituhoryuuDsBeanGoukei.setIrNyukintuuka(tuukaSyu.getContent());
                    skMisrjyuSeirituhoryuuDsBeanGoukei.setIrMosno("");
                    skMisrjyuSeirituhoryuuDsBeanGoukei.setIrKyknmkn("");
                    skMisrjyuSeirituhoryuuDsBeanGoukei.setIrRsgakuyen(null);
                    skMisrjyuSeirituhoryuuDsBeanGoukei.setIrRsgaku(null);

                    miseirijiyuuSeirituhoryuuLst.add(skMisrjyuSeirituhoryuuDsBeanGoukei);
                }

                miseiriKariukekinMeisaiSouKs = miseiriKariukekinMeisaiSouKs.add(meisaiKensuu);
                miseirijiyuuSeirituhoryuuSouKs = miseirijiyuuSeirituhoryuuSouKs.add(seirituMeisaiKensuu);
            }
        }
    }

    private void createSkMiseirijiyuuKrkmeisaiLstAndSkMiseirijiyuuKrksyuukeiLst(
        List<C_Tuukasyu> pTuukasyuLst) {

        miseirijiyuuKrkmeisaiBean = SWAKInjector.getInstance(SkKessanMiseiriBean.class);

        miseirijiyuuKrkmeisaiBean.setIrAtesaki(kanjiSosikinm);
        miseirijiyuuKrkmeisaiBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
        miseirijiyuuKrkmeisaiBean.setIrNendo(nendo);
        miseirijiyuuKrkmeisaiBean.setIrShnknm(shnkNm);
        if (!kyktuukasyuList.contains(C_Tuukasyu.JPY)) {

            miseirijiyuuKrkmeisaiBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST);
        }
        else {

            miseirijiyuuKrkmeisaiBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST_YENDT);
        }

        miseirijiyuuKrkmeisaiLst = new ArrayList<>();
        miseirijiyuuKrkmeisaiSouKs = BizNumber.ZERO;
        miseirijiyuuKrksyuukeiLst = new ArrayList<>();
        miseirijiyuuKrksyuukeiSouKs = BizNumber.ZERO;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType tuukaType = null;

        BizCurrency krkhuho2SyoukaiGoukei = BizCurrency.valueOf(0);
        BizCurrency krkhuho2KobetuGoukei = BizCurrency.valueOf(0);
        BizCurrency krkhuho2syoukaiSyoukei = BizCurrency.valueOf(0);
        BizCurrency krkhuho2kobetuSyoukei = BizCurrency.valueOf(0);

        Integer pageNo = 0;

        for (C_Tuukasyu tuukaSyu : pTuukasyuLst) {

            try (ExDBResults<HT_MiseirijiyuuMeisai> miseirijiyuuMeisaiLst =
                skMiseiriJiyuuTyouhyouSakuseiDao.getMiseirijiyuukbnMiseirijiyuuMeisaisByRstuukasyuKyktuukasyulst(tuukaSyu,
                    kyktuukasyuList.toArray(new C_Tuukasyu[kyktuukasyuList.size()]))){

                tuukaType = henkanTuuka.henkanTuukaKbnToType(tuukaSyu);

                Iterator<HT_MiseirijiyuuMeisai> iterator = miseirijiyuuMeisaiLst.iterator();

                pageNo = pageNo + 1;

                krkhuho2syoukaiSyoukei = BizCurrency.valueOf(0, tuukaType);
                krkhuho2kobetuSyoukei = BizCurrency.valueOf(0, tuukaType);
                krkhuho2SyoukaiGoukei = BizCurrency.valueOf(0, tuukaType);
                krkhuho2KobetuGoukei = BizCurrency.valueOf(0, tuukaType);

                SkMiseirijiyuuKrksyuukeiBean skMiseirijiyuuKrksyuukeiBean =
                    SWAKInjector.getInstance(SkMiseirijiyuuKrksyuukeiBean.class);

                skMiseirijiyuuKrksyuukeiBean.setIrAtesaki(kanjiSosikinm);
                skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
                skMiseirijiyuuKrksyuukeiBean.setIrNendo(nendo);
                skMiseirijiyuuKrksyuukeiBean.setIrShnknm(shnkNm);
                skMiseirijiyuuKrksyuukeiBean.setIrPageno(pageNo);
                skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka(tuukaSyu.getContent());
                if (!kyktuukasyuList.contains(C_Tuukasyu.JPY)) {

                    skMiseirijiyuuKrksyuukeiBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);
                }
                else {

                    skMiseirijiyuuKrksyuukeiBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI_YENDT);
                }

                skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
                skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
                skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
                skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
                skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
                skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

                skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
                skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
                skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
                skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

                skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
                skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
                skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
                skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
                skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

                skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
                skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

                skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, tuukaType));
                skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
                skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
                skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
                skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

                if (!iterator.hasNext()) {

                    SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean =
                        SWAKInjector.getInstance(SkMiseirijiyuuKrkmeisaiDataSourceBean.class);

                    skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMiseirijiyuukbn("");
                    skMiseirijiyuuKrkmeisaiDataSourceBean.setIrNyukintuuka(tuukaSyu.getContent());
                    skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMosno("");
                    skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKyknmkn("");
                    skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukai(null);
                    skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetu(null);
                    skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(0, tuukaType));
                    skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(0, tuukaType));
                    skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(0, tuukaType));
                    skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(0, tuukaType));

                    miseirijiyuuKrkmeisaiLst.add(skMiseirijiyuuKrkmeisaiDataSourceBean);
                    miseirijiyuuKrksyuukeiLst.add(skMiseirijiyuuKrksyuukeiBean);
                }
                else {
                    long kensuu = 0;
                    BizCurrency rsgakuGaika = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency rsgakuYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    String miseirijiyuuDetailKbn = "";
                    String miseiriJiyuuKbn = "";
                    String miseiriJiyuuKbnHntiyu = "";
                    String miseiriJiyuuKbnBf = "";

                    SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean = null;

                    BizCurrency msrgkMskseikirnrknrknasi = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency msrgkMskseikirnrknrknasiYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer msrkensuuMskskrnrknrkns = 0;
                    BizCurrency msrgkSkktnrkmr = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency msrgkSkktnrkmrYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer msrkensuuSkktnrkmr = 0;
                    BizCurrency msrgkSisyaketmr = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency msrgkSisyaketmrYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer msrkensuuSisyaketmr = 0;
                    BizCurrency msrgkKhnkmhbari = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency msrgkKhnkmhbariYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer msrkensuuKhnkmhbari = 0;
                    BizCurrency msrgkKethhbari = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency msrgkKethhbariYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer msrkensuuKethhbari = 0;
                    BizCurrency msrgkEtc = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency msrgkEtcYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer msrkensuuEtc = 0;
                    BizCurrency dkhkttykgKetsyadkhketty = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency dkhkttykgKetsyadkhkettyYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer dkhkttykensuKtsydkhktty = 0;
                    BizCurrency dkhkttykgSisnirty = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency dkhkttykgSisnirtyYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer dkhkttykensuSisnirty = 0;
                    BizCurrency dkhkttykgHnsskykkakjsty = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency dkhkttykgHnsskykkakjstyYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer dkhkttykensuHnsskykkakjs = 0;
                    BizCurrency dkhkttykgTkbtjknsydksmk = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency dkhkttykgTkbtjknsydksmkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer dkhkttykensuTkbtjknsydks = 0;
                    BizCurrency ketkankgNyknniyuhb = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency ketkankgNyknniyuhbYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer ketkankenuuNyknniyuhb = 0;
                    BizCurrency ketkankgSyrihb = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency ketkankgSyrihbYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer ketkankenuuSyrihb = 0;
                    BizCurrency ketkankgSirthukety = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency ketkankgSirthuketyYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer ketkankenuuSirthukety = 0;
                    BizCurrency ketkankgSimihknkyksykity = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency ketkankgSimihknkyksykityYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer ketkankenuuSihkyksykity = 0;
                    BizCurrency ketkankgEtc = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency ketkankgEtcYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer ketkankenuuEtc = 0;
                    BizCurrency sknnkisyknndkgMsirt = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency sknnkisyknndkgMsirtYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer sknnkisyknndkensuuMsirt = 0;
                    BizCurrency sknnkisyknndkgSirt = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency sknnkisyknndkgSirtYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer sknnkisyknndkensuuSirt = 0;
                    BizCurrency hsirtkgMawsenk = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency hsirtkgMawsenkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer hsirtkensuuMawsenk = 0;
                    BizCurrency hsirtkgMskmtrks = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency hsirtkgMskmtrksYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer hsirtkensuuMskmtrks = 0;
                    BizCurrency hsirtkgYkkknkik = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency hsirtkgYkkknkikYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer hsirtkkensuuYkkknkik = 0;
                    BizCurrency hsirtkgNyknskj = BizCurrency.valueOf(0, tuukaType);
                    BizCurrency hsirtkgNyknskjYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    Integer hsirtkensuuNyknskj = 0;

                    while (iterator.hasNext()) {

                        HT_MiseirijiyuuMeisai miseirijiyuuMeisai = iterator.next();

                        kensuu++;
                        miseiriJiyuuKbn = miseirijiyuuMeisai.getMiseirijiyuukbn();
                        miseirijiyuuDetailKbn = miseirijiyuuMeisai.getMiseirijiyuudetailkbn();
                        miseiriJiyuuKbnHntiyu = miseiriJiyuuKbn + miseirijiyuuDetailKbn;
                        rsgakuGaika = miseirijiyuuMeisai.getRsgakugaika();
                        rsgakuYen = miseirijiyuuMeisai.getRsgakuen();

                        if (kensuu != 1) {
                            if (!miseiriJiyuuKbnBf.equals(miseiriJiyuuKbnHntiyu)) {

                                miseiriJiyuuKbnBf = miseiriJiyuuKbnHntiyu;

                                skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetusyoukei(krkhuho2kobetuSyoukei);
                                skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaisyoukei(krkhuho2syoukaiSyoukei);

                                krkhuho2syoukaiSyoukei = BizCurrency.valueOf(0, tuukaType);
                                krkhuho2kobetuSyoukei = BizCurrency.valueOf(0, tuukaType);
                            }

                            miseirijiyuuKrkmeisaiLst.add(skMiseirijiyuuKrkmeisaiDataSourceBean);
                        }
                        else {
                            miseiriJiyuuKbnBf = miseiriJiyuuKbnHntiyu;
                        }

                        skMiseirijiyuuKrkmeisaiDataSourceBean =
                            SWAKInjector.getInstance(SkMiseirijiyuuKrkmeisaiDataSourceBean.class);

                        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMiseirijiyuukbn(miseiriJiyuuKbnHntiyu);
                        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrNyukintuuka(tuukaSyu.getContent());
                        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMosno(miseirijiyuuMeisai.getMosno());
                        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKyknmkn(miseirijiyuuMeisai.getKyknmkn());
                        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukai(miseirijiyuuMeisai.getKrkhuho2syoukai());
                        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetu(miseirijiyuuMeisai.getKrkhuho2kobetu());
                        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaisyoukei(null);
                        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetusyoukei(null);
                        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaigoukei(null);
                        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetugoukei(null);

                        miseirijiyuuKrkmeisaiSouKs = miseirijiyuuKrkmeisaiSouKs.add(BizNumber.ONE);
                        krkhuho2syoukaiSyoukei = krkhuho2syoukaiSyoukei.add(
                            skMiseirijiyuuKrkmeisaiDataSourceBean.getIrKrkhuho2syoukai());
                        krkhuho2kobetuSyoukei = krkhuho2kobetuSyoukei.add(
                            skMiseirijiyuuKrkmeisaiDataSourceBean.getIrKrkhuho2kobetu());
                        krkhuho2SyoukaiGoukei = krkhuho2SyoukaiGoukei.add(
                            skMiseirijiyuuKrkmeisaiDataSourceBean.getIrKrkhuho2syoukai());
                        krkhuho2KobetuGoukei = krkhuho2KobetuGoukei.add(
                            skMiseirijiyuuKrkmeisaiDataSourceBean.getIrKrkhuho2kobetu());

                        if ("01".equals(miseiriJiyuuKbn)) {
                            if ("01".equals(miseirijiyuuDetailKbn)) {

                                msrgkMskseikirnrknrknasi = msrgkMskseikirnrknrknasi.add(rsgakuGaika);
                                msrgkMskseikirnrknrknasiYen = msrgkMskseikirnrknrknasiYen.add(rsgakuYen);
                                msrkensuuMskskrnrknrkns++;
                            }
                            else if ("07".equals(miseirijiyuuDetailKbn)) {

                                msrgkSkktnrkmr = msrgkSkktnrkmr.add(rsgakuGaika);
                                msrgkSkktnrkmrYen = msrgkSkktnrkmrYen.add(rsgakuYen);
                                msrkensuuSkktnrkmr++;
                            }
                            else if ("03".equals(miseirijiyuuDetailKbn)) {

                                msrgkSisyaketmr = msrgkSisyaketmr.add(rsgakuGaika);
                                msrgkSisyaketmrYen = msrgkSisyaketmrYen.add(rsgakuYen);
                                msrkensuuSisyaketmr++;
                            }
                            else if ("04".equals(miseirijiyuuDetailKbn)) {

                                msrgkKhnkmhbari = msrgkKhnkmhbari.add(rsgakuGaika);
                                msrgkKhnkmhbariYen = msrgkKhnkmhbariYen.add(rsgakuYen);
                                msrkensuuKhnkmhbari++;
                            }
                            else if ("05".equals(miseirijiyuuDetailKbn)) {

                                msrgkKethhbari = msrgkKethhbari.add(rsgakuGaika);
                                msrgkKethhbariYen = msrgkKethhbariYen.add(rsgakuYen);
                                msrkensuuKethhbari++;
                            }
                            else if ("06".equals(miseirijiyuuDetailKbn)) {

                                msrgkEtc = msrgkEtc.add(rsgakuGaika);
                                msrgkEtcYen = msrgkEtcYen.add(rsgakuYen);
                                msrkensuuEtc++;
                            }
                        }
                        if ("02".equals(miseiriJiyuuKbn)) {

                            if ("01".equals(miseirijiyuuDetailKbn)) {

                                dkhkttykgKetsyadkhketty = dkhkttykgKetsyadkhketty.add(rsgakuGaika);
                                dkhkttykgKetsyadkhkettyYen = dkhkttykgKetsyadkhkettyYen.add(rsgakuYen);
                                dkhkttykensuKtsydkhktty++;
                            }
                            else if ("02".equals(miseirijiyuuDetailKbn)) {

                                dkhkttykgSisnirty = dkhkttykgSisnirty.add(rsgakuGaika);
                                dkhkttykgSisnirtyYen = dkhkttykgSisnirtyYen.add(rsgakuYen);
                                dkhkttykensuSisnirty++;
                            }
                            else if ("03".equals(miseirijiyuuDetailKbn)) {

                                dkhkttykgHnsskykkakjsty = dkhkttykgHnsskykkakjsty.add(rsgakuGaika);
                                dkhkttykgHnsskykkakjstyYen = dkhkttykgHnsskykkakjstyYen.add(rsgakuYen);
                                dkhkttykensuHnsskykkakjs++;
                            }
                            else if ("04".equals(miseirijiyuuDetailKbn)) {

                                dkhkttykgTkbtjknsydksmk = dkhkttykgTkbtjknsydksmk.add(rsgakuGaika);
                                dkhkttykgTkbtjknsydksmkYen = dkhkttykgTkbtjknsydksmkYen.add(rsgakuYen);
                                dkhkttykensuTkbtjknsydks++;
                            }
                        }
                        if ("03".equals(miseiriJiyuuKbn)) {
                            if ("01".equals(miseirijiyuuDetailKbn)) {

                                ketkankgNyknniyuhb = ketkankgNyknniyuhb.add(rsgakuGaika);
                                ketkankgNyknniyuhbYen = ketkankgNyknniyuhbYen.add(rsgakuYen);
                                ketkankenuuNyknniyuhb++;
                            }
                            else if ("02".equals(miseirijiyuuDetailKbn)) {

                                ketkankgSyrihb = ketkankgSyrihb.add(rsgakuGaika);
                                ketkankgSyrihbYen = ketkankgSyrihbYen.add(rsgakuYen);
                                ketkankenuuSyrihb++;
                            }
                            else if ("03".equals(miseirijiyuuDetailKbn)) {

                                ketkankgSirthukety = ketkankgSirthukety.add(rsgakuGaika);
                                ketkankgSirthuketyYen = ketkankgSirthuketyYen.add(rsgakuYen);
                                ketkankenuuSirthukety++;
                            }
                            else if ("04".equals(miseirijiyuuDetailKbn)) {

                                ketkankgSimihknkyksykity = ketkankgSimihknkyksykity.add(rsgakuGaika);
                                ketkankgSimihknkyksykityYen = ketkankgSimihknkyksykityYen.add(rsgakuYen);
                                ketkankenuuSihkyksykity++;
                            }
                            else if ("05".equals(miseirijiyuuDetailKbn)) {

                                ketkankgEtc = ketkankgEtc.add(rsgakuGaika);
                                ketkankgEtcYen = ketkankgEtcYen.add(rsgakuYen);
                                ketkankenuuEtc++;
                            }
                        }
                        if ("10".equals(miseiriJiyuuKbn)) {
                            if ("01".equals(miseirijiyuuDetailKbn)) {

                                sknnkisyknndkgMsirt = sknnkisyknndkgMsirt.add(rsgakuGaika);
                                sknnkisyknndkgMsirtYen = sknnkisyknndkgMsirtYen.add(rsgakuYen);
                                sknnkisyknndkensuuMsirt++;
                            }
                            else if ("02".equals(miseirijiyuuDetailKbn)) {

                                sknnkisyknndkgSirt = sknnkisyknndkgSirt.add(rsgakuGaika);
                                sknnkisyknndkgSirtYen = sknnkisyknndkgSirtYen.add(rsgakuYen);
                                sknnkisyknndkensuuSirt++;
                            }
                        }
                        if ("20".equals(miseiriJiyuuKbn)) {
                            if ("01".equals(miseirijiyuuDetailKbn)) {

                                hsirtkgMawsenk = hsirtkgMawsenk.add(rsgakuGaika);
                                hsirtkgMawsenkYen = hsirtkgMawsenkYen.add(rsgakuYen);
                                hsirtkensuuMawsenk++;
                            }
                            else if ("02".equals(miseirijiyuuDetailKbn)) {

                                hsirtkgMskmtrks = hsirtkgMskmtrks.add(rsgakuGaika);
                                hsirtkgMskmtrksYen = hsirtkgMskmtrksYen.add(rsgakuYen);
                                hsirtkensuuMskmtrks++;
                            }
                            else if ("03".equals(miseirijiyuuDetailKbn)) {

                                hsirtkgYkkknkik = hsirtkgYkkknkik.add(rsgakuGaika);
                                hsirtkgYkkknkikYen = hsirtkgYkkknkikYen.add(rsgakuYen);
                                hsirtkkensuuYkkknkik++;
                            }
                            else if ("04".equals(miseirijiyuuDetailKbn)) {

                                hsirtkgNyknskj = hsirtkgNyknskj.add(rsgakuGaika);
                                hsirtkgNyknskjYen = hsirtkgNyknskjYen.add(rsgakuYen);
                                hsirtkensuuNyknskj++;
                            }
                        }
                    }

                    skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(msrgkMskseikirnrknrknasi);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(msrgkMskseikirnrknrknasiYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(msrkensuuMskskrnrknrkns);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(msrgkSkktnrkmr);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(msrgkSkktnrkmrYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(msrkensuuSkktnrkmr);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(msrgkSisyaketmr);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(msrgkSisyaketmrYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(msrkensuuSisyaketmr);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(msrgkKhnkmhbari);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(msrgkKhnkmhbariYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(msrkensuuKhnkmhbari);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(msrgkKethhbari);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(msrgkKethhbariYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(msrkensuuKethhbari);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(msrgkEtc);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(msrgkEtcYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(msrkensuuEtc);
                    skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(dkhkttykgKetsyadkhketty);
                    skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(dkhkttykgKetsyadkhkettyYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(dkhkttykensuKtsydkhktty);
                    skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(dkhkttykgSisnirty);
                    skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(dkhkttykgSisnirtyYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(dkhkttykensuSisnirty);
                    skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(dkhkttykgHnsskykkakjsty);
                    skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(dkhkttykgHnsskykkakjstyYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(dkhkttykensuHnsskykkakjs);
                    skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(dkhkttykgTkbtjknsydksmk);
                    skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(dkhkttykgTkbtjknsydksmkYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(dkhkttykensuTkbtjknsydks);
                    skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(ketkankgNyknniyuhb);
                    skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(ketkankgNyknniyuhbYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(ketkankenuuNyknniyuhb);
                    skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(ketkankgSyrihb);
                    skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(ketkankgSyrihbYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(ketkankenuuSyrihb);
                    skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(ketkankgSirthukety);
                    skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(ketkankgSirthuketyYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(ketkankenuuSirthukety);
                    skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(ketkankgSimihknkyksykity);
                    skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(ketkankgSimihknkyksykityYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(ketkankenuuSihkyksykity);
                    skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(ketkankgEtc);
                    skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(ketkankgEtcYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(ketkankenuuEtc);
                    skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(sknnkisyknndkgMsirt);
                    skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(sknnkisyknndkgMsirtYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(sknnkisyknndkensuuMsirt);
                    skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(sknnkisyknndkgSirt);
                    skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(sknnkisyknndkgSirtYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(sknnkisyknndkensuuSirt);
                    skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(hsirtkgMawsenk);
                    skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(hsirtkgMawsenkYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(hsirtkensuuMawsenk);
                    skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(hsirtkgMskmtrks);
                    skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(hsirtkgMskmtrksYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(hsirtkensuuMskmtrks);
                    skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(hsirtkgYkkknkik);
                    skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(hsirtkgYkkknkikYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(hsirtkkensuuYkkknkik);
                    skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(hsirtkgNyknskj);
                    skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(hsirtkgNyknskjYen);
                    skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(hsirtkensuuNyknskj);

                    miseirijiyuuKrksyuukeiLst.add(skMiseirijiyuuKrksyuukeiBean);

                    miseirijiyuuKrksyuukeiSouKs = miseirijiyuuKrksyuukeiSouKs.add(BizNumber.ONE);

                    skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetusyoukei(krkhuho2kobetuSyoukei);
                    skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaisyoukei(krkhuho2syoukaiSyoukei);
                    skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetugoukei(krkhuho2KobetuGoukei);
                    skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaigoukei(krkhuho2SyoukaiGoukei);

                    miseirijiyuuKrkmeisaiLst.add(skMiseirijiyuuKrkmeisaiDataSourceBean);
                }
            }
        }
    }

    private void createSkMiseirijiyuuNyuukinhubiLst(List<C_Tuukasyu> pTuukasyuLst) {

        nyuukinHubiBean = SWAKInjector.getInstance(SkKessanMiseiriBean.class);

        nyuukinHubiBean.setIrAtesaki(kanjiSosikinm);
        nyuukinHubiBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
        nyuukinHubiBean.setIrNendo(nendo);
        nyuukinHubiBean.setIrShnknm(shnkNm);
        if (!kyktuukasyuList.contains(C_Tuukasyu.JPY)) {

            nyuukinHubiBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);
        }
        else {

            nyuukinHubiBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI_YENDT);
        }

        nyuukinHubiMeisaiLst = new ArrayList<>();
        nyuukinHubiMeisaiSouKensuu = BizNumber.ZERO;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType tuukaType = null;
        BizNumber kensuuSyoukeiNkjt = BizNumber.ZERO;
        BizCurrency rsKgSyoukeiNkjtYen = BizCurrency.valueOf(0);
        BizCurrency rsKgSyoukeiNkjt = BizCurrency.valueOf(0);
        BizNumber kensuuGoukei = BizNumber.ZERO;
        BizCurrency rsKgGoukeiYen = BizCurrency.valueOf(0);
        BizCurrency rsKgGoukei = BizCurrency.valueOf(0);

        for (C_Tuukasyu tuukaSyu : pTuukasyuLst) {

            try (ExDBResults<HT_MiseirijiyuuMeisai> miseirijiyuuMeisaiLst =
                skMiseiriJiyuuTyouhyouSakuseiDao.getNyuukinjoutaikbnMiseirijiyuuMeisaisByRstuukasyuKyktuukasyulst(
                    tuukaSyu, kyktuukasyuList.toArray(new C_Tuukasyu[kyktuukasyuList.size()]))){

                Iterator<HT_MiseirijiyuuMeisai> iterator = miseirijiyuuMeisaiLst.iterator();

                tuukaType = henkanTuuka.henkanTuukaKbnToType(tuukaSyu);

                kensuuSyoukeiNkjt = BizNumber.ZERO;
                rsKgSyoukeiNkjtYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                rsKgSyoukeiNkjt = BizCurrency.valueOf(0, tuukaType);
                kensuuGoukei = BizNumber.ZERO;
                rsKgGoukeiYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                rsKgGoukei = BizCurrency.valueOf(0, tuukaType);

                if (!iterator.hasNext()) {

                    SkMiseirijiyuuNyuukinhubiDataSourceBean skMiseirijiyuuNyuukinhubiDsBean =
                        SWAKInjector.getInstance(SkMiseirijiyuuNyuukinhubiDataSourceBean.class);

                    skMiseirijiyuuNyuukinhubiDsBean.setIrNyukintuuka(tuukaSyu.getContent());
                    skMiseirijiyuuNyuukinhubiDsBean.setIrMosno("");
                    skMiseirijiyuuNyuukinhubiDsBean.setIrKyknmkn("");
                    skMiseirijiyuuNyuukinhubiDsBean.setIrSknnkaisiymd("");
                    skMiseirijiyuuNyuukinhubiDsBean.setIrKykymd("");
                    skMiseirijiyuuNyuukinhubiDsBean.setIrRyosyuymd("");
                    skMiseirijiyuuNyuukinhubiDsBean.setIrNyuukinjoutaikbn("");
                    skMiseirijiyuuNyuukinhubiDsBean.setIrRsgakuyen(null);
                    skMiseirijiyuuNyuukinhubiDsBean.setIrRsgaku(null);

                    skMiseirijiyuuNyuukinhubiDsBean.setIrMiseirijiyuukensuusyoukei(BizNumber.ZERO);
                    skMiseirijiyuuNyuukinhubiDsBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    skMiseirijiyuuNyuukinhubiDsBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(0, tuukaType));
                    skMiseirijiyuuNyuukinhubiDsBean.setIrKensuugoukei(BizNumber.ZERO);
                    skMiseirijiyuuNyuukinhubiDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    skMiseirijiyuuNyuukinhubiDsBean.setIrKingakugoukei(BizCurrency.valueOf(0, tuukaType));

                    nyuukinHubiMeisaiLst.add(skMiseirijiyuuNyuukinhubiDsBean);
                }
                else {

                    long kensuu = 0;
                    C_NyuukinjyoutaiKbn nyuukinJoutaiKbn = null;
                    C_NyuukinjyoutaiKbn nyuukinJoutaiKbnBf = null;
                    SkMiseirijiyuuNyuukinhubiDataSourceBean skMiseirijiyuuNyuukinhubiDsBean = null;
                    String sknnKaisiYmd = "";
                    String kykYmd = "";
                    String syokairsYmd = "";

                    while (iterator.hasNext()) {

                        HT_MiseirijiyuuMeisai miseirijiyuuMeisai = iterator.next();

                        kensuu++;
                        nyuukinJoutaiKbn = miseirijiyuuMeisai.getNyuukinjoutaikbn();
                        sknnKaisiYmd = "";
                        kykYmd = "";
                        syokairsYmd = "";

                        if (kensuu != 1) {
                            if (!nyuukinJoutaiKbnBf.eq(nyuukinJoutaiKbn)) {

                                nyuukinJoutaiKbnBf = nyuukinJoutaiKbn;

                                skMiseirijiyuuNyuukinhubiDsBean.setIrMiseirijiyuukensuusyoukei(kensuuSyoukeiNkjt);
                                skMiseirijiyuuNyuukinhubiDsBean.setIrMiseirijiyuukngkskeiyen(rsKgSyoukeiNkjtYen);
                                skMiseirijiyuuNyuukinhubiDsBean.setIrMiseirijiyuukngksyoukei(rsKgSyoukeiNkjt);

                                kensuuSyoukeiNkjt = BizNumber.ZERO;
                                rsKgSyoukeiNkjtYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                rsKgSyoukeiNkjt = BizCurrency.valueOf(0, tuukaType);

                            }

                            nyuukinHubiMeisaiLst.add(skMiseirijiyuuNyuukinhubiDsBean);
                        }
                        else {
                            nyuukinJoutaiKbnBf = nyuukinJoutaiKbn;
                        }

                        skMiseirijiyuuNyuukinhubiDsBean =
                            SWAKInjector.getInstance(SkMiseirijiyuuNyuukinhubiDataSourceBean.class);

                        if (miseirijiyuuMeisai.getSknnkaisiymd() != null) {

                            sknnKaisiYmd = miseirijiyuuMeisai.getSknnkaisiymd().toString();
                        }

                        if (miseirijiyuuMeisai.getKykymd() != null) {

                            kykYmd = miseirijiyuuMeisai.getKykymd().toString();
                        }

                        if (miseirijiyuuMeisai.getSyokairsymd() != null) {

                            syokairsYmd = miseirijiyuuMeisai.getSyokairsymd().toString();
                        }

                        skMiseirijiyuuNyuukinhubiDsBean.setIrNyukintuuka(tuukaSyu.getContent());
                        skMiseirijiyuuNyuukinhubiDsBean.setIrMosno(miseirijiyuuMeisai.getMosno());
                        skMiseirijiyuuNyuukinhubiDsBean.setIrKyknmkn(miseirijiyuuMeisai.getKyknmkn());
                        skMiseirijiyuuNyuukinhubiDsBean.setIrSknnkaisiymd(sknnKaisiYmd);
                        skMiseirijiyuuNyuukinhubiDsBean.setIrKykymd(kykYmd);
                        skMiseirijiyuuNyuukinhubiDsBean.setIrRyosyuymd(syokairsYmd);
                        skMiseirijiyuuNyuukinhubiDsBean.setIrNyuukinjoutaikbn(nyuukinJoutaiKbn.getValue());
                        skMiseirijiyuuNyuukinhubiDsBean.setIrRsgakuyen(miseirijiyuuMeisai.getRsgakuen());
                        skMiseirijiyuuNyuukinhubiDsBean.setIrRsgaku(miseirijiyuuMeisai.getRsgakugaika());
                        skMiseirijiyuuNyuukinhubiDsBean.setIrMiseirijiyuukensuusyoukei(null);
                        skMiseirijiyuuNyuukinhubiDsBean.setIrMiseirijiyuukngkskeiyen(null);
                        skMiseirijiyuuNyuukinhubiDsBean.setIrMiseirijiyuukngksyoukei(null);
                        skMiseirijiyuuNyuukinhubiDsBean.setIrKensuugoukei(null);
                        skMiseirijiyuuNyuukinhubiDsBean.setIrKingakugoukeiyen(null);
                        skMiseirijiyuuNyuukinhubiDsBean.setIrKingakugoukei(null);

                        kensuuSyoukeiNkjt = kensuuSyoukeiNkjt.add(BizNumber.ONE);
                        rsKgSyoukeiNkjtYen = rsKgSyoukeiNkjtYen.add(skMiseirijiyuuNyuukinhubiDsBean.getIrRsgakuyen());
                        rsKgSyoukeiNkjt = rsKgSyoukeiNkjt.add(skMiseirijiyuuNyuukinhubiDsBean.getIrRsgaku());

                        kensuuGoukei = kensuuGoukei.add(BizNumber.ONE);
                        rsKgGoukeiYen = rsKgGoukeiYen.add(skMiseirijiyuuNyuukinhubiDsBean.getIrRsgakuyen());
                        rsKgGoukei = rsKgGoukei.add(skMiseirijiyuuNyuukinhubiDsBean.getIrRsgaku());
                    }

                    skMiseirijiyuuNyuukinhubiDsBean.setIrMiseirijiyuukensuusyoukei(kensuuSyoukeiNkjt);
                    skMiseirijiyuuNyuukinhubiDsBean.setIrMiseirijiyuukngkskeiyen(rsKgSyoukeiNkjtYen);
                    skMiseirijiyuuNyuukinhubiDsBean.setIrMiseirijiyuukngksyoukei(rsKgSyoukeiNkjt);
                    skMiseirijiyuuNyuukinhubiDsBean.setIrKensuugoukei(kensuuGoukei);
                    skMiseirijiyuuNyuukinhubiDsBean.setIrKingakugoukeiyen(rsKgGoukeiYen);
                    skMiseirijiyuuNyuukinhubiDsBean.setIrKingakugoukei(rsKgGoukei);

                    nyuukinHubiMeisaiLst.add(skMiseirijiyuuNyuukinhubiDsBean);
                }

                nyuukinHubiMeisaiSouKensuu = nyuukinHubiMeisaiSouKensuu.add(kensuuGoukei);
            }
        }
    }

    private void createSkMiseirijiyuuSyoruihubiTandokuLst(List<C_Tuukasyu> pTuukasyuLst) {

        miseirijiyuuSyoruihubiTdBean = SWAKInjector.getInstance(SkKessanMiseiriBean.class);

        miseirijiyuuSyoruihubiTdBean.setIrAtesaki(kanjiSosikinm);
        miseirijiyuuSyoruihubiTdBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
        miseirijiyuuSyoruihubiTdBean.setIrNendo(nendo);
        miseirijiyuuSyoruihubiTdBean.setIrShnknm(shnkNm);
        if (!kyktuukasyuList.contains(C_Tuukasyu.JPY)) {

            miseirijiyuuSyoruihubiTdBean.setIrTyouhyoutitle("（ＮＯ．１）普保Ⅱ");
        }
        else {

            miseirijiyuuSyoruihubiTdBean.setIrTyouhyoutitle("（ＮＯ．１）普保Ⅱ（円建）");
        }
        miseirijiyuuSyoruihubiTdBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.TAISYOU);

        miseirijiyuuSyoruihubiTdLst = new ArrayList<>();
        miseirijiyuuSyoruihubiTdSouKs = BizNumber.ZERO;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType tuukaType = null;

        BizNumber kennsuuSyoukei = BizNumber.ZERO;
        BizCurrency rskgSyoukeiYen = BizCurrency.valueOf(0);
        BizCurrency rskgSyoukei = BizCurrency.valueOf(0);
        BizNumber kensuuGoukei = BizNumber.ZERO;
        BizCurrency rskgGoukeiYen = BizCurrency.valueOf(0);
        BizCurrency rskgGoukei = BizCurrency.valueOf(0);

        for (C_Tuukasyu tuukaSyu : pTuukasyuLst) {

            try (ExDBResults<HT_MiseirijiyuuMeisai> miseirijiyuuMeisaiLst =
                skMiseiriJiyuuTyouhyouSakuseiDao.getSyoruisyuruikbnMiseirijiyuuMeisaisByRstuukasyuKyktuukasyulstSyoruihubikensuuEq(
                    tuukaSyu, kyktuukasyuList.toArray(new C_Tuukasyu[kyktuukasyuList.size()]))) {

                Iterator<HT_MiseirijiyuuMeisai> iterator = miseirijiyuuMeisaiLst.iterator();

                tuukaType = henkanTuuka.henkanTuukaKbnToType(tuukaSyu);

                kennsuuSyoukei = BizNumber.ZERO;
                rskgSyoukeiYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                rskgSyoukei = BizCurrency.valueOf(0, tuukaType);
                kensuuGoukei = BizNumber.ZERO;
                rskgGoukeiYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                rskgGoukei = BizCurrency.valueOf(0, tuukaType);

                if (!iterator.hasNext()) {

                    SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDsBean =
                        SWAKInjector.getInstance(SkMiseirijiyuuSyoruihubiDataSourceBean.class);

                    skMiseirijiyuuSyoruihubiDsBean.setIrNyukintuuka(tuukaSyu.getContent());
                    skMiseirijiyuuSyoruihubiDsBean.setIrMosno("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrKyknmkn("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrRsgakuyen(null);
                    skMiseirijiyuuSyoruihubiDsBean.setIrRsgaku(null);
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn1("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn2("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn3("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn4("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn5("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn6("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn7("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn8("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn9("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn10("");

                    skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukensuusyoukei(BizNumber.ZERO);
                    skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(0, tuukaType));
                    skMiseirijiyuuSyoruihubiDsBean.setIrKensuugoukei(BizNumber.ZERO);
                    skMiseirijiyuuSyoruihubiDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    skMiseirijiyuuSyoruihubiDsBean.setIrKingakugoukei(BizCurrency.valueOf(0, tuukaType));

                    miseirijiyuuSyoruihubiTdLst.add(skMiseirijiyuuSyoruihubiDsBean);
                }
                else {

                    long kensuu = 0;
                    String syoruikbn1 = "";
                    String syoruikbn1Bf = "";
                    SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDsBean = null;

                    while (iterator.hasNext()) {

                        HT_MiseirijiyuuMeisai miseirijiyuuMeisai = iterator.next();

                        kensuu++;
                        syoruikbn1 = miseirijiyuuMeisai.getSyoruikbn1();

                        if (kensuu != 1) {
                            if (!syoruikbn1Bf.equals(syoruikbn1)) {

                                syoruikbn1Bf = syoruikbn1;

                                skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukensuusyoukei(kennsuuSyoukei);
                                skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukngkskeiyen(rskgSyoukeiYen);
                                skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukngksyoukei(rskgSyoukei);

                                kennsuuSyoukei = BizNumber.ZERO;
                                rskgSyoukeiYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                rskgSyoukei = BizCurrency.valueOf(0, tuukaType);
                            }

                            miseirijiyuuSyoruihubiTdLst.add(skMiseirijiyuuSyoruihubiDsBean);
                        }
                        else {
                            syoruikbn1Bf = syoruikbn1;
                        }

                        skMiseirijiyuuSyoruihubiDsBean =
                            SWAKInjector.getInstance(SkMiseirijiyuuSyoruihubiDataSourceBean.class);

                        skMiseirijiyuuSyoruihubiDsBean.setIrNyukintuuka(tuukaSyu.getContent());
                        skMiseirijiyuuSyoruihubiDsBean.setIrMosno(miseirijiyuuMeisai.getMosno());
                        skMiseirijiyuuSyoruihubiDsBean.setIrKyknmkn(miseirijiyuuMeisai.getKyknmkn());
                        skMiseirijiyuuSyoruihubiDsBean.setIrRsgakuyen(miseirijiyuuMeisai.getRsgakuen());
                        skMiseirijiyuuSyoruihubiDsBean.setIrRsgaku(miseirijiyuuMeisai.getRsgakugaika());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn1(syoruikbn1);
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn2(miseirijiyuuMeisai.getSyoruikbn2());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn3(miseirijiyuuMeisai.getSyoruikbn3());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn4(miseirijiyuuMeisai.getSyoruikbn4());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn5(miseirijiyuuMeisai.getSyoruikbn5());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn6(miseirijiyuuMeisai.getSyoruikbn6());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn7(miseirijiyuuMeisai.getSyoruikbn7());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn8(miseirijiyuuMeisai.getSyoruikbn8());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn9(miseirijiyuuMeisai.getSyoruikbn9());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn10(miseirijiyuuMeisai.getSyoruikbn10());
                        skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukensuusyoukei(null);
                        skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukngkskeiyen(null);
                        skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukngksyoukei(null);
                        skMiseirijiyuuSyoruihubiDsBean.setIrKensuugoukei(null);
                        skMiseirijiyuuSyoruihubiDsBean.setIrKingakugoukeiyen(null);
                        skMiseirijiyuuSyoruihubiDsBean.setIrKingakugoukei(null);

                        kennsuuSyoukei = kennsuuSyoukei.add(BizNumber.ONE);
                        rskgSyoukeiYen = rskgSyoukeiYen.add(skMiseirijiyuuSyoruihubiDsBean.getIrRsgakuyen());
                        rskgSyoukei = rskgSyoukei.add(skMiseirijiyuuSyoruihubiDsBean.getIrRsgaku());

                        kensuuGoukei = kensuuGoukei.add(BizNumber.ONE);
                        rskgGoukeiYen = rskgGoukeiYen.add(skMiseirijiyuuSyoruihubiDsBean.getIrRsgakuyen());
                        rskgGoukei = rskgGoukei.add(skMiseirijiyuuSyoruihubiDsBean.getIrRsgaku());
                    }

                    skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukensuusyoukei(kennsuuSyoukei);
                    skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukngkskeiyen(rskgSyoukeiYen);
                    skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukngksyoukei(rskgSyoukei);
                    skMiseirijiyuuSyoruihubiDsBean.setIrKensuugoukei(kensuuGoukei);
                    skMiseirijiyuuSyoruihubiDsBean.setIrKingakugoukeiyen(rskgGoukeiYen);
                    skMiseirijiyuuSyoruihubiDsBean.setIrKingakugoukei(rskgGoukei);

                    miseirijiyuuSyoruihubiTdLst.add(skMiseirijiyuuSyoruihubiDsBean);
                }

                miseirijiyuuSyoruihubiTdSouKs = miseirijiyuuSyoruihubiTdSouKs.add(kensuuGoukei);
            }
        }
    }

    private void createSkMiseirijiyuuSyoruihubiFukusuuLst(List<C_Tuukasyu> pTuukasyuLst) {

        miseirijiyuuSyoruihubiFsBean = SWAKInjector.getInstance(SkKessanMiseiriBean.class);

        miseirijiyuuSyoruihubiFsBean.setIrAtesaki(kanjiSosikinm);
        miseirijiyuuSyoruihubiFsBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
        miseirijiyuuSyoruihubiFsBean.setIrNendo(nendo);
        miseirijiyuuSyoruihubiFsBean.setIrShnknm(shnkNm);
        if (!kyktuukasyuList.contains(C_Tuukasyu.JPY)) {

            miseirijiyuuSyoruihubiFsBean.setIrTyouhyoutitle("（ＮＯ．２）普保Ⅱ");
        }
        else {

            miseirijiyuuSyoruihubiFsBean.setIrTyouhyoutitle("（ＮＯ．２）普保Ⅱ（円建）");
        }
        miseirijiyuuSyoruihubiFsBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.HITAISYOU);

        miseirijiyuuSyoruihubiFsLst = new ArrayList<>();
        miseirijiyuuSyoruihubiFsSouKs = BizNumber.ZERO;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType tuukaType = null;

        BizNumber kensuuGoukei = BizNumber.ZERO;
        BizCurrency rsgkGoukeiYen = BizCurrency.valueOf(0);
        BizCurrency rsgkGoukei = BizCurrency.valueOf(0);

        for (C_Tuukasyu tuukaSyu : pTuukasyuLst) {

            try (ExDBResults<HT_MiseirijiyuuMeisai> miseirijiyuuMeisaiLst =
                skMiseiriJiyuuTyouhyouSakuseiDao.getSyoruisyuruikbnMiseirijiyuuMeisaisByRstuukasyuKyktuukasyulstSyoruihubikensuuNe(
                    tuukaSyu, kyktuukasyuList.toArray(new C_Tuukasyu[kyktuukasyuList.size()]))) {

                Iterator<HT_MiseirijiyuuMeisai> iterator = miseirijiyuuMeisaiLst.iterator();

                tuukaType = henkanTuuka.henkanTuukaKbnToType(tuukaSyu);

                kensuuGoukei = BizNumber.ZERO;
                rsgkGoukeiYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                rsgkGoukei = BizCurrency.valueOf(0, tuukaType);

                if (!iterator.hasNext()) {

                    SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDsBean =
                        SWAKInjector.getInstance(SkMiseirijiyuuSyoruihubiDataSourceBean.class);

                    skMiseirijiyuuSyoruihubiDsBean.setIrNyukintuuka(tuukaSyu.getContent());
                    skMiseirijiyuuSyoruihubiDsBean.setIrMosno("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrKyknmkn("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrRsgakuyen(null);
                    skMiseirijiyuuSyoruihubiDsBean.setIrRsgaku(null);
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn1("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn2("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn3("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn4("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn5("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn6("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn7("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn8("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn9("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn10("");
                    skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukensuusyoukei(BizNumber.ZERO);
                    skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(0, tuukaType));
                    skMiseirijiyuuSyoruihubiDsBean.setIrKensuugoukei(BizNumber.ZERO);
                    skMiseirijiyuuSyoruihubiDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    skMiseirijiyuuSyoruihubiDsBean.setIrKingakugoukei(BizCurrency.valueOf(0, tuukaType));

                    miseirijiyuuSyoruihubiFsLst.add(skMiseirijiyuuSyoruihubiDsBean);
                }
                else {

                    SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDsBeanGoukei =
                        SWAKInjector.getInstance(SkMiseirijiyuuSyoruihubiDataSourceBean.class);

                    while (iterator.hasNext()) {

                        HT_MiseirijiyuuMeisai miseirijiyuuMeisai = iterator.next();

                        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDsBean =
                            SWAKInjector.getInstance(SkMiseirijiyuuSyoruihubiDataSourceBean.class);

                        skMiseirijiyuuSyoruihubiDsBean.setIrNyukintuuka(tuukaSyu.getContent());
                        skMiseirijiyuuSyoruihubiDsBean.setIrMosno(miseirijiyuuMeisai.getMosno());
                        skMiseirijiyuuSyoruihubiDsBean.setIrKyknmkn(miseirijiyuuMeisai.getKyknmkn());
                        skMiseirijiyuuSyoruihubiDsBean.setIrRsgakuyen(miseirijiyuuMeisai.getRsgakuen());
                        skMiseirijiyuuSyoruihubiDsBean.setIrRsgaku(miseirijiyuuMeisai.getRsgakugaika());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn1(miseirijiyuuMeisai.getSyoruikbn1());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn2(miseirijiyuuMeisai.getSyoruikbn2());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn3(miseirijiyuuMeisai.getSyoruikbn3());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn4(miseirijiyuuMeisai.getSyoruikbn4());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn5(miseirijiyuuMeisai.getSyoruikbn5());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn6(miseirijiyuuMeisai.getSyoruikbn6());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn7(miseirijiyuuMeisai.getSyoruikbn7());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn8(miseirijiyuuMeisai.getSyoruikbn8());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn9(miseirijiyuuMeisai.getSyoruikbn9());
                        skMiseirijiyuuSyoruihubiDsBean.setIrSyoruisyuruikbn10(miseirijiyuuMeisai.getSyoruikbn10());
                        skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukensuusyoukei(null);
                        skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukngkskeiyen(null);
                        skMiseirijiyuuSyoruihubiDsBean.setIrMiseirijiyuukngksyoukei(null);
                        skMiseirijiyuuSyoruihubiDsBean.setIrKensuugoukei(null);
                        skMiseirijiyuuSyoruihubiDsBean.setIrKingakugoukeiyen(null);
                        skMiseirijiyuuSyoruihubiDsBean.setIrKingakugoukei(null);

                        miseirijiyuuSyoruihubiFsLst.add(skMiseirijiyuuSyoruihubiDsBean);

                        kensuuGoukei = kensuuGoukei.add(BizNumber.ONE);
                        rsgkGoukeiYen = rsgkGoukeiYen.add(skMiseirijiyuuSyoruihubiDsBean.getIrRsgakuyen());
                        rsgkGoukei = rsgkGoukei.add(skMiseirijiyuuSyoruihubiDsBean.getIrRsgaku());
                        skMiseirijiyuuSyoruihubiDsBeanGoukei = skMiseirijiyuuSyoruihubiDsBean;
                    }

                    skMiseirijiyuuSyoruihubiDsBeanGoukei.setIrKensuugoukei(kensuuGoukei);
                    skMiseirijiyuuSyoruihubiDsBeanGoukei.setIrKingakugoukeiyen(rsgkGoukeiYen);
                    skMiseirijiyuuSyoruihubiDsBeanGoukei.setIrKingakugoukei(rsgkGoukei);
                }

                miseirijiyuuSyoruihubiFsSouKs = miseirijiyuuSyoruihubiFsSouKs.add(kensuuGoukei);
            }
        }
    }

    private void createSkMiseirikariukekinmeisai(C_SyoruiCdKbn pSyoruiCdKbn) {

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            pSyoruiCdKbn);

        reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

        reportServicesBean.addParamObjects(
            pSyoruiCdKbn,
            miseiriKariukekinMeisaiLst,
            miseiriKariukekinBean);

        createReport.execNoCommit(reportServicesBean);
    }

    private void createSkMiseirijiyuuNyuukinhubi(C_SyoruiCdKbn pSyoruiCdKbn) {

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            pSyoruiCdKbn);

        reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

        reportServicesBean.addParamObjects(
            pSyoruiCdKbn,
            nyuukinHubiMeisaiLst,
            nyuukinHubiBean);

        createReport.execNoCommit(reportServicesBean);
    }

    private void createSkMiseirijiyuuSyoruihubiTandoku(C_SyoruiCdKbn pSyoruiCdKbn) {

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            pSyoruiCdKbn);

        reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

        reportServicesBean.addParamObjects(
            pSyoruiCdKbn,
            miseirijiyuuSyoruihubiTdLst,
            miseirijiyuuSyoruihubiTdBean);

        createReport.execNoCommit(reportServicesBean);
    }

    private void createSkMiseirijiyuuSyoruihubiFukusuu(C_SyoruiCdKbn pSyoruiCdKbn) {

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            pSyoruiCdKbn);

        reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

        reportServicesBean.addParamObjects(
            pSyoruiCdKbn,
            miseirijiyuuSyoruihubiFsLst,
            miseirijiyuuSyoruihubiFsBean);

        createReport.execNoCommit(reportServicesBean);
    }

    private void createSkMiseirijiyuuSeirituhoryuu(C_SyoruiCdKbn pSyoruiCdKbn) {

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            pSyoruiCdKbn);

        reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

        reportServicesBean.addParamObjects(
            pSyoruiCdKbn,
            miseirijiyuuSeirituhoryuuLst,
            miseirijiyuuSeirituhoryuuBean);

        createReport.execNoCommit(reportServicesBean);
    }

    private void createSkMiseirijiyuuKrkmeisai(C_SyoruiCdKbn pSyoruiCdKbn) {

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            pSyoruiCdKbn);

        reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

        reportServicesBean.addParamObjects(
            pSyoruiCdKbn,
            miseirijiyuuKrkmeisaiLst,
            miseirijiyuuKrkmeisaiBean);

        createReport.execNoCommit(reportServicesBean);
    }

    private void createSkMiseirijiyuuKrksyuukei(C_SyoruiCdKbn pSyoruiCdKbn) {

        for (SkMiseirijiyuuKrksyuukeiBean skMiseirijiyuuKrksyuukeiBean : miseirijiyuuKrksyuukeiLst) {
            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(),
                kinou.getCategoryId(),
                kinou.getKinouId(),
                pSyoruiCdKbn);

            reportServicesBean.setKensakuKeys(skMiseirijiyuuKrksyuukeiBean.getIrPageno().toString());
            reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

            reportServicesBean.addParamObjects(
                pSyoruiCdKbn,
                skMiseirijiyuuKrksyuukeiBean);

            createReport.execNoCommit(reportServicesBean);
        }
    }
}

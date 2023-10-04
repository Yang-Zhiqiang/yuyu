package yuyu.batch.sinkeiyaku.skkessan.skhkskinknkwasssneklisakusei;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.skkessan.skhkskinknkwasssneklisakusei.dba.SkHkskiNknKwasssnekLiSakuseiDao;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_DensimeNenkanSchedule;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkHkskinknkwasssnekBean;
import yuyu.def.sinkeiyaku.bean.report.SkHkskinknkwasssnekDataSourceBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 決算 複数回入金為替差損益リスト作成
 */
public class SkHkskiNknKwasssnekLiSakuseiBatch implements Batch {

    private BizDate kijyunymdKaisibi;

    private BizDate kijyunymdSyuuryubi;

    private long syouriKensuu;

    private C_Tuukasyu rstuukasyu;

    private String tuukasyu;

    private BizCurrency tuukasyugkKawasesasoneki;

    private long tuukasyuSyouriKensuu;

    private int renNo;

    private BizCurrency mosnoKawasesasoneki;

    private List<IReportDataSouceBean> skHkskinknkwasssnekDataSourceBeanList;

    private BizDate pkakinKijyunymdKaisibi;

    private BizDate pkakinKijyunymdSyuuryubi;

    private BizCurrency tuukasyuSykigkkawasesasoneki;

    private BizCurrency mosnoDai1kaiGaiRyosyugk;

    private BizCurrency mosnoNyknFsKasiDengk;

    private String kyknmKn;

    private String seirituYmd;

    private int renNo2;

    private BizCurrency mosnoPkakinKarisyokaidngaku;

    private BizCurrency mosnoPkakinPkakingk;

    private BizCurrency mosnoPkakinKasisyokaidngaku;

    private BizCurrency syokaidenGaiRyosyugk;

    private BizCurrency syokaidngakugk;

    private BizCurrency seiritudnGaiRyosyugk;

    private int over10LineKaipageFlg;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkHkskiNknKwasssnekLiSakuseiDao skHkskiNknKwasssnekLiSakuseiDao;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private CreateReport createReport;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        BizDate kijyunYmd = bzBatchParam.getSyoriYmd();
        kijyunymdKaisibi = kijyunYmd.addMonths(-3).getBizDateYM().getFirstDay();
        kijyunymdSyuuryubi = kijyunYmd.getBizDateYM().getPreviousMonth().getLastDay();
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.SK_HUKUSUUKAINYUUKINKAWASESASONEKI;
        String syoruiNm = "複数回入金・過剰入金為替差損益";
        BizDateYM kijyunKaisibiYm = kijyunYmd.addMonths(-3).getBizDateYM();
        BizDateYM kijyunSyuuryubiYM = kijyunYmd.getBizDateYM();

        BM_DensimeNenkanSchedule densimeNenkanSchedule = bizDomManager.getDensimeNenkanSchedule(kijyunKaisibiYm);

        if (densimeNenkanSchedule == null)  {

            return;
        }

        pkakinKijyunymdKaisibi = densimeNenkanSchedule.getZengetudensimeymd();

        densimeNenkanSchedule = bizDomManager.getDensimeNenkanSchedule(kijyunSyuuryubiYM);

        if (densimeNenkanSchedule == null)  {

            return;
        }

        pkakinKijyunymdSyuuryubi = densimeNenkanSchedule.getZengetudensimeymd();

        String dairitenKykSosikiCd = YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd();
        String atesaki = "";

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(dairitenKykSosikiCd, null);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            atesaki = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());
        }

        String tyouhyousakuseiYmd = DateFormatUtil.dateKANJI(kijyunYmd);

        String shnkNm = "";
        if (kijyunYmd.getMonth() == 7) {

            shnkNm = "第１四半期";
        }
        else if (kijyunYmd.getMonth() == 10) {

            shnkNm = "半期";
        }
        else if (kijyunYmd.getMonth() == 1) {

            shnkNm = "第３四半期";
        }
        else if (kijyunYmd.getMonth() == 4) {

            shnkNm = "決算";
        }

        String tyouhyouTitle = DateFormatUtil.dateYKANJISeirekiNendo(kijyunymdSyuuryubi);

        tyouhyouTitle = tyouhyouTitle + shnkNm + "　" + syoruiNm;

        SkHkskinknkwasssnekBean skHkskinknkwasssnekBean = SWAKInjector.getInstance(SkHkskinknkwasssnekBean .class);

        skHkskinknkwasssnekBean.setIrAtesaki(atesaki);
        skHkskinknkwasssnekBean.setIrTyouhyousakuseiymd(tyouhyousakuseiYmd);
        skHkskinknkwasssnekBean.setIrTyouhyoutitle(tyouhyouTitle);

        skHkskinknkwasssnekDataSourceBeanList = new ArrayList<>();
        syouriKensuu = 0;

        List<String> GaikaYuukoutuukasyuList = YuyuSinkeiyakuConfig.getInstance().getGaikaYuukoutuukasyuList();

        for (String gaikaYuukoutuukasyu : GaikaYuukoutuukasyuList) {

            rstuukasyu =  C_Tuukasyu.valueOf(gaikaYuukoutuukasyu);
            tuukasyu = rstuukasyu.getContent() + "入金";
            tuukasyugkKawasesasoneki = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            tuukasyuSyouriKensuu = 0;
            tuukasyuSykigkkawasesasoneki= BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

            createTyouhyouMs();

            if (tuukasyuSyouriKensuu == 0) {

                for (int i = 0; i < 12; i++) {

                    SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean =
                        SWAKInjector.getInstance(SkHkskinknkwasssnekDataSourceBean.class);
                    skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka(tuukasyu);

                    if (i == 10) {

                        skHkskinknkwasssnekDataSourceBean.setNyknGukiTitle("第１回合計為替差益");
                        skHkskinknkwasssnekDataSourceBean.setIrGkkawasesaeki(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    }
                    if (i == 11) {

                        skHkskinknkwasssnekDataSourceBean.setNyknGukiTitle("第１回合計為替差損");
                        skHkskinknkwasssnekDataSourceBean.setIrGkkawasesason(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                        skHkskinknkwasssnekDataSourceBean.setIrTuukasyugkkawasesaeki(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                        skHkskinknkwasssnekDataSourceBean.setIrTuukasyugkkawasesason(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                        skHkskinknkwasssnekDataSourceBean.setIrTuukasyusykigkkawasesaeki(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                        skHkskinknkwasssnekDataSourceBean.setIrTuukasyusykigkkawasesason(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    }

                    skHkskinknkwasssnekDataSourceBeanList.add(skHkskinknkwasssnekDataSourceBean);
                }
            }
        }

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCdKbn);

        reportServicesBean.setSyoriYmd(kijyunYmd);

        reportServicesBean.addParamObjects(
            syoruiCdKbn,
            skHkskinknkwasssnekDataSourceBeanList,
            skHkskinknkwasssnekBean);

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syouriKensuu), syoruiCdKbn.getContent()));
    }

    private void createTyouhyouMs() {

        try (ExDBResults<HT_SyoriCTL> syoriCTLList = skHkskiNknKwasssnekLiSakuseiDao.getHkskiNknKwasssnekData(
            kijyunymdKaisibi, kijyunymdSyuuryubi, rstuukasyu, pkakinKijyunymdKaisibi, pkakinKijyunymdSyuuryubi)) {

            for (HT_SyoriCTL syoriCTL : syoriCTLList) {

                List<HT_Nyuukin> nyuukinList = skHkskiNknKwasssnekLiSakuseiDao.getNyuukins(syoriCTL.getMosno(), rstuukasyu);

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(rstuukasyu);

                renNo = 1;
                mosnoDai1kaiGaiRyosyugk = BizCurrency.valueOf(0, currencyType);
                mosnoNyknFsKasiDengk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                mosnoKawasesasoneki = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                over10LineKaipageFlg = 1;
                int nyuukinCount = 0;
                int henkinCount = 0;

                HT_MosKihon mosKihon = syoriCTL.getMosKihon();

                if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {

                    kyknmKn = mosKihon.getHhknnmkn();
                }
                else {

                    kyknmKn = mosKihon.getKyknmkn();
                }

                if (syoriCTL.getSrsyoriymd() == null){

                    seirituYmd = "";
                }
                else {

                    seirituYmd = String.valueOf(syoriCTL.getSrsyoriymd());
                }

                for (HT_Nyuukin nyuukin : nyuukinList) {

                    HT_SkDenpyoData skDenpyoData = sinkeiyakuDomManager.getSkDenpyoData(nyuukin.getDenrenno(), 1);

                    BizCurrency tyakkindenGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    BizCurrency kawasesasoneki = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                    GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    getKawaseRate.exec(nyuukin.getTyakkinymd(),
                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                        nyuukin.getRstuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.JISSEIRATE,
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                        C_YouhiKbn.HUYOU);

                    BizNumber tyakkinkwsRate = getKawaseRate.getKawaserate();
                    tyakkindenGk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, nyuukin.getRsgaku(), tyakkinkwsRate, C_HasuusyoriKbn.SUTE);

                    kawasesasoneki = tyakkindenGk.subtract(skDenpyoData.getDenyenkagk());

                    SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean =
                        SWAKInjector.getInstance(SkHkskinknkwasssnekDataSourceBean.class);

                    skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka(tuukasyu);
                    skHkskinknkwasssnekDataSourceBean.setIrMosno(syoriCTL.getMosno());
                    skHkskinknkwasssnekDataSourceBean.setIrKyknmkn(kyknmKn);
                    skHkskinknkwasssnekDataSourceBean.setIrSeiritujk(syoriCTL.getSeiritukbn().getContent());
                    skHkskinknkwasssnekDataSourceBean.setIrSeirituymd(seirituYmd);
                    skHkskinknkwasssnekDataSourceBean.setIrRenno(renNo++);
                    skHkskinknkwasssnekDataSourceBean.setIrNyknsyoriymd(String.valueOf(nyuukin.getNyksyoriymd()));
                    skHkskinknkwasssnekDataSourceBean.setIrTyakkinymd(String.valueOf(nyuukin.getTyakkinymd()));
                    skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymd(String.valueOf(skDenpyoData.getFstpryosyuymd()));
                    skHkskinknkwasssnekDataSourceBean.setIrTyakkinkwsrate(tyakkinkwsRate);
                    skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymdkwsrate(skDenpyoData.getDenkawaserate());
                    skHkskinknkwasssnekDataSourceBean.setIrRsgaku(nyuukin.getRsgaku());
                    skHkskinknkwasssnekDataSourceBean.setIrTyakkindengk(tyakkindenGk);
                    skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymddengk(skDenpyoData.getDenyenkagk());
                    skHkskinknkwasssnekDataSourceBean.setIrZenhnkn(nyuukin.getZenhnknkbn().getContent());
                    skHkskinknkwasssnekDataSourceBean.setIrKawasesasoneki(kawasesasoneki);

                    nyuukinCount = nyuukinCount + 1;
                    setTitleFlg(skHkskinknkwasssnekDataSourceBean, nyuukinCount, nyuukinList.size(), 0);

                    skHkskinknkwasssnekDataSourceBeanList.add(skHkskinknkwasssnekDataSourceBean);

                    mosnoDai1kaiGaiRyosyugk = mosnoDai1kaiGaiRyosyugk.add(nyuukin.getRsgaku());

                    mosnoNyknFsKasiDengk = mosnoNyknFsKasiDengk.add(skDenpyoData.getDenyenkagk());

                    mosnoKawasesasoneki = mosnoKawasesasoneki.add(kawasesasoneki);
                    tuukasyugkKawasesasoneki = tuukasyugkKawasesasoneki.add(kawasesasoneki);
                    tuukasyuSyouriKensuu = tuukasyuSyouriKensuu + 1;
                }

                addBlankLine(syoriCTL, nyuukinList.size());

                List<HT_Henkin> henkinList = syoriCTL.getHenkins();

                renNo2 = 1;
                mosnoPkakinKarisyokaidngaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                mosnoPkakinPkakingk = BizCurrency.valueOf(0, currencyType);
                mosnoPkakinKasisyokaidngaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                for (HT_Henkin hnkin : henkinList) {

                    if (rstuukasyu.eq(hnkin.getHnkntuukasyu())) {

                        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean =
                            SWAKInjector.getInstance(SkHkskinknkwasssnekDataSourceBean.class);

                        HT_SkDenpyoData skDenpyoDataPkakinKarisyokai =
                            sinkeiyakuDomManager.getSkDenpyoData(hnkin.getPkakindenrenno(), 1);

                        HT_SkDenpyoData skDenpyoDataPkakin =
                            sinkeiyakuDomManager.getSkDenpyoData(hnkin.getPkakindenrenno(), 2);

                        HT_SkDenpyoData skDenpyoDataPkakinKasisyokai =
                            sinkeiyakuDomManager.getSkDenpyoData(hnkin.getPkakindenrenno(), 3);

                        if (skDenpyoDataPkakinKasisyokai == null) {

                            skHkskinknkwasssnekDataSourceBean.setIrKasisyokaidngaku(null);
                        }
                        else {

                            skHkskinknkwasssnekDataSourceBean.setIrKasisyokaidngaku(skDenpyoDataPkakinKasisyokai.getDenyenkagk());
                        }

                        skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka(tuukasyu);
                        skHkskinknkwasssnekDataSourceBean.setIrMosno(syoriCTL.getMosno());
                        skHkskinknkwasssnekDataSourceBean.setIrKyknmkn(kyknmKn);
                        skHkskinknkwasssnekDataSourceBean.setIrSeiritujk(syoriCTL.getSeiritukbn().getContent());
                        skHkskinknkwasssnekDataSourceBean.setIrSeirituymd(seirituYmd);
                        skHkskinknkwasssnekDataSourceBean.setIrRenno2(renNo2++);
                        skHkskinknkwasssnekDataSourceBean.setIrPkakinsyoriymd(String.valueOf(hnkin.getPkakinsyoriymd()));
                        skHkskinknkwasssnekDataSourceBean.setIrPkakinrsymdkwsrate(skDenpyoDataPkakin.getDenkawaserate());
                        skHkskinknkwasssnekDataSourceBean.setIrKarisyokaidngaku(skDenpyoDataPkakinKarisyokai.getDenyenkagk());
                        skHkskinknkwasssnekDataSourceBean.setIrPkakingk(hnkin.getHnkngk());
                        skHkskinknkwasssnekDataSourceBean.setIrPkakindengk(skDenpyoDataPkakin.getDenyenkagk());

                        henkinCount = henkinCount + 1;
                        setTitleFlg(skHkskinknkwasssnekDataSourceBean, henkinCount, 0, 1);

                        skHkskinknkwasssnekDataSourceBeanList.add(skHkskinknkwasssnekDataSourceBean);

                        mosnoPkakinKarisyokaidngaku = mosnoPkakinKarisyokaidngaku.add(skDenpyoDataPkakinKarisyokai.getDenyenkagk());

                        mosnoPkakinPkakingk = mosnoPkakinPkakingk.add(hnkin.getHnkngk());

                        if (skHkskinknkwasssnekDataSourceBean.getIrKasisyokaidngaku() != null) {

                            mosnoPkakinKasisyokaidngaku = mosnoPkakinKasisyokaidngaku.add(skDenpyoDataPkakinKasisyokai.getDenyenkagk());
                        }
                    }
                }

                if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn()) && rstuukasyu.eq(mosKihon.getHrktuukasyu())) {

                    syokaidenGaiRyosyugk = mosnoDai1kaiGaiRyosyugk.subtract(mosnoPkakinPkakingk);
                    syokaidngakugk = mosnoNyknFsKasiDengk.add(mosnoPkakinKasisyokaidngaku).subtract(mosnoPkakinKarisyokaidngaku);
                    seiritudnGaiRyosyugk = syokaidenGaiRyosyugk;
                    BizCurrency seirituDngaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                    HT_SkDenpyoData skDenpyoDataSeiritudn =
                        skHkskiNknKwasssnekLiSakuseiDao.getSkDenpyoDatas(syoriCTL.getMosno(), C_DensyoriKbn.SEIRITU, 1).get(0);

                    seirituDngaku = skDenpyoDataSeiritudn.getDenyenkagk();

                    SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean =
                        (SkHkskinknkwasssnekDataSourceBean)skHkskinknkwasssnekDataSourceBeanList.get(skHkskinknkwasssnekDataSourceBeanList.size() - 1);

                    skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka(tuukasyu);
                    skHkskinknkwasssnekDataSourceBean.setIrMosno(syoriCTL.getMosno());
                    skHkskinknkwasssnekDataSourceBean.setIrKyknmkn(kyknmKn);
                    skHkskinknkwasssnekDataSourceBean.setIrSeiritujk(syoriCTL.getSeiritukbn().getContent());
                    skHkskinknkwasssnekDataSourceBean.setIrSeirituymd(seirituYmd);
                    skHkskinknkwasssnekDataSourceBean.setIrRenno3(1);
                    skHkskinknkwasssnekDataSourceBean.setIrSyokaidnrsgakugk(syokaidenGaiRyosyugk);
                    skHkskinknkwasssnekDataSourceBean.setIrSyokaidngakugk(syokaidngakugk);
                    skHkskinknkwasssnekDataSourceBean.setIrRenno4(1);
                    skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsymd(String.valueOf(syoriCTL.getRyosyuymd()));
                    skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsymdkwsrate(skDenpyoDataSeiritudn.getDenkawaserate());
                    skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsgaku(seiritudnGaiRyosyugk);
                    skHkskinknkwasssnekDataSourceBean.setIrSeiritudngaku(seirituDngaku);
                    skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(over10LineKaipageFlg);

                    BizCurrency mosnoSyokaigkkawasesasoneki = syokaidngakugk.subtract(seirituDngaku);

                    if (mosnoSyokaigkkawasesasoneki.compareTo(
                        BizCurrency.valueOf(0, mosnoSyokaigkkawasesasoneki.getType())) == 0) {

                        skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesaeki(BizCurrency.valueOf(0));
                        skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesason(BizCurrency.valueOf(0));
                    }
                    else if (mosnoSyokaigkkawasesasoneki.compareTo(
                        BizCurrency.valueOf(0, mosnoSyokaigkkawasesasoneki.getType())) < 0) {

                        skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesaeki(BizCurrency.valueOf(0));
                        skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesason(BizCurrency.valueOf(
                            new BigDecimal(mosnoSyokaigkkawasesasoneki.toAdsoluteString()).abs()));
                    }
                    else {

                        skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesaeki(mosnoSyokaigkkawasesasoneki);
                        skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesason(BizCurrency.valueOf(0));
                    }

                    tuukasyuSykigkkawasesasoneki = tuukasyuSykigkkawasesasoneki.add(mosnoSyokaigkkawasesasoneki);
                }

                syouriKensuu = syouriKensuu + 1;
            }

            if (tuukasyuSyouriKensuu >= 1) {
                SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean =
                    (SkHkskinknkwasssnekDataSourceBean)skHkskinknkwasssnekDataSourceBeanList.get(skHkskinknkwasssnekDataSourceBeanList.size() - 1);

                if (tuukasyugkKawasesasoneki.compareTo(
                    BizCurrency.valueOf(0, tuukasyugkKawasesasoneki.getType())) == 0) {

                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyugkkawasesaeki(BizCurrency.valueOf(0));
                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyugkkawasesason(BizCurrency.valueOf(0));
                }

                else if (tuukasyugkKawasesasoneki.compareTo(
                    BizCurrency.valueOf(0, tuukasyugkKawasesasoneki.getType())) < 0) {

                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyugkkawasesaeki(BizCurrency.valueOf(0));
                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyugkkawasesason(BizCurrency.valueOf(
                        new BigDecimal(tuukasyugkKawasesasoneki.toAdsoluteString()).abs()));
                }
                else {

                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyugkkawasesaeki(tuukasyugkKawasesasoneki);
                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyugkkawasesason(BizCurrency.valueOf(0));
                }

                if (tuukasyuSykigkkawasesasoneki.compareTo(
                    BizCurrency.valueOf(0, tuukasyuSykigkkawasesasoneki.getType())) == 0) {

                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyusykigkkawasesaeki(BizCurrency.valueOf(0));
                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyusykigkkawasesason(BizCurrency.valueOf(0));
                }

                else if (tuukasyuSykigkkawasesasoneki.compareTo(
                    BizCurrency.valueOf(0, tuukasyuSykigkkawasesasoneki.getType())) < 0) {

                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyusykigkkawasesaeki(BizCurrency.valueOf(0));
                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyusykigkkawasesason(BizCurrency.valueOf(
                        new BigDecimal(tuukasyuSykigkkawasesasoneki.toAdsoluteString()).abs()));
                }
                else {

                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyusykigkkawasesaeki(tuukasyuSykigkkawasesasoneki);
                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyusykigkkawasesason(BizCurrency.valueOf(0));
                }
            }
        }
    }

    private void addBlankLine(HT_SyoriCTL pSyoriCTL, int pNyuukinListSize) {

        int blankLineKensuu = 0;

        if (pNyuukinListSize % 10 != 0) {
            blankLineKensuu = 10 - (pNyuukinListSize % 10) + 4;
        }
        else {
            blankLineKensuu = 4;
        }

        for (int i = 0; i < blankLineKensuu; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean =
                SWAKInjector.getInstance(SkHkskinknkwasssnekDataSourceBean.class);

            skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka(tuukasyu);
            skHkskinknkwasssnekDataSourceBean.setIrMosno(pSyoriCTL.getMosno());
            skHkskinknkwasssnekDataSourceBean.setIrKyknmkn(kyknmKn);
            skHkskinknkwasssnekDataSourceBean.setIrSeiritujk(pSyoriCTL.getSeiritukbn().getContent());
            skHkskinknkwasssnekDataSourceBean.setIrSeirituymd(seirituYmd);
            skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(over10LineKaipageFlg);

            skHkskinknkwasssnekDataSourceBeanList.add(skHkskinknkwasssnekDataSourceBean);
        }

        SkHkskinknkwasssnekDataSourceBean dsBeanGoukei1 =
            (SkHkskinknkwasssnekDataSourceBean)skHkskinknkwasssnekDataSourceBeanList.get(
                skHkskinknkwasssnekDataSourceBeanList.size() - 4);

        dsBeanGoukei1.setNyknGukiTitle("第１回合計為替差益");
        if (mosnoKawasesasoneki.compareTo(
            BizCurrency.valueOf(0, mosnoKawasesasoneki.getType())) == 0) {
            dsBeanGoukei1.setIrGkkawasesaeki(BizCurrency.valueOf(0));
        }
        else if (mosnoKawasesasoneki.compareTo(
            BizCurrency.valueOf(0, mosnoKawasesasoneki.getType())) < 0) {

            dsBeanGoukei1.setIrGkkawasesaeki(BizCurrency.valueOf(0));
        }
        else {
            dsBeanGoukei1.setIrGkkawasesaeki(mosnoKawasesasoneki);
        }

        SkHkskinknkwasssnekDataSourceBean dsBeanGoukei2 =
            (SkHkskinknkwasssnekDataSourceBean)skHkskinknkwasssnekDataSourceBeanList.get(
                skHkskinknkwasssnekDataSourceBeanList.size() - 3);
        dsBeanGoukei2.setNyknGukiTitle("第１回合計為替差損");

        if (mosnoKawasesasoneki.compareTo(
            BizCurrency.valueOf(0, mosnoKawasesasoneki.getType())) == 0) {

            dsBeanGoukei2.setIrGkkawasesason(BizCurrency.valueOf(0));
        }
        else if (mosnoKawasesasoneki.compareTo(
            BizCurrency.valueOf(0, mosnoKawasesasoneki.getType())) < 0) {

            dsBeanGoukei2.setIrGkkawasesason(BizCurrency.valueOf(
                new BigDecimal(mosnoKawasesasoneki.toAdsoluteString()).abs()));
        }
        else {

            dsBeanGoukei2.setIrGkkawasesason(BizCurrency.valueOf(0));
        }
    }

    private void setTitleFlg(SkHkskinknkwasssnekDataSourceBean pSkHkskinknkwasssnekDataSourceBean,
        int pCurrentSyoriCount, int pSyoriLstSize, int pTBLHantei) {

        if (pTBLHantei == 0) {

            if (pSyoriLstSize <= 10) {
                if (pCurrentSyoriCount == 1) {
                    pSkHkskinknkwasssnekDataSourceBean.setHnknTitleHyoujiFlg("2");
                }
            }
            else {

                if (pCurrentSyoriCount > 10) {

                    if (pCurrentSyoriCount % 10 == 1) {

                        over10LineKaipageFlg++;
                    }

                    int lastPage = 0;

                    if (pSyoriLstSize % 10 == 0) {
                        lastPage = pSyoriLstSize / 10 - 1;
                    }
                    else {
                        lastPage = pSyoriLstSize / 10;
                    }

                    if (lastPage * 10 + 1 == pCurrentSyoriCount) {

                        pSkHkskinknkwasssnekDataSourceBean.setHnknTitleHyoujiFlg("2");
                    }
                }
            }

            pSkHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(over10LineKaipageFlg);
        }

        if (pTBLHantei == 1) {

            if (pCurrentSyoriCount > 10) {

                if (pCurrentSyoriCount % 10 == 1) {

                    pSkHkskinknkwasssnekDataSourceBean.setHnknTitleHyoujiFlg("1");
                    over10LineKaipageFlg++;
                }
            }

            pSkHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(over10LineKaipageFlg);
        }
    }
}

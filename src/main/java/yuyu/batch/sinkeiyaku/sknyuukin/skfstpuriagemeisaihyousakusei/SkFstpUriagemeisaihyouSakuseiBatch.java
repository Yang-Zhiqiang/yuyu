package yuyu.batch.sinkeiyaku.sknyuukin.skfstpuriagemeisaihyousakusei;

import java.util.ArrayList;
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
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skfstpuriagemeisaihyousakusei.dba.SkFstpUriagemeisaihyouSakuseiDao;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UriagekekkaKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_SkUriageData;
import yuyu.def.sinkeiyaku.bean.report.SkFstpuriagemeisaiBean;
import yuyu.def.sinkeiyaku.bean.report.SkFstpuriagemeisaiDataSourceBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 入金 初回保険料売上請求明細票作成
 */
public class SkFstpUriagemeisaihyouSakuseiBatch implements Batch {

    private int renNo;

    private long goukeiKensuu;

    private BizCurrency goukeiGk;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkFstpUriagemeisaihyouSakuseiDao skFstpUriagemeisaihyouSakuseiDao;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BzBatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        SkFstpuriagemeisaiBean skFstpuriagemeisaiBean = null;
        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        String dairitenKykSosikiCd = YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd();
        String kanjiSosikiNm = "";

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(dairitenKykSosikiCd, null);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            kanjiSosikiNm = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());
        }

        String tyouhyouYmd = DateFormatUtil.dateKANJI(syoriYmd);

        skFstpuriagemeisaiBean = new SkFstpuriagemeisaiBean();

        String syuukeiComment = MessageUtil.getMessage(MessageId.IHF1018);

        skFstpuriagemeisaiBean.setIrAtesaki(kanjiSosikiNm);
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.JCB.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment(syuukeiComment);

        List<IReportDataSouceBean> skFstpuriagemeisaiDsBeanList = new ArrayList<>();

        renNo = 0;
        goukeiKensuu = 0;
        goukeiGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        List<String> cardkaisyaGroupJcbList = YuyuSinkeiyakuConfig.getInstance().getCardkaisyaGroupJcbList();
        List<C_CardBrandKbn> cardBrandKbnJcbList = convertToKbn(cardkaisyaGroupJcbList);

        try (
            ExDBResults<HT_SkUriageData> skUriageDataList =
            skFstpUriagemeisaihyouSakuseiDao.getSkUriageData(
                BizDate.valueOf(syoriYmd.getPreviousMonth().getBizDateYM().toString() + "19"),
                BizDate.valueOf(syoriYmd.getBizDateYM().toString() + "18"),
                C_UriagekekkaKbn.URIAGEOK,
                cardBrandKbnJcbList)) {

            skFstpuriagemeisaiDsBeanList = tyouhyouDtlSksUragdtl(skUriageDataList);
        }

        if (goukeiKensuu == 0) {

            SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDsBean = new SkFstpuriagemeisaiDataSourceBean();

            skFstpuriagemeisaiDsBean.setIrKensuugoukei(BizNumber.ZERO);
            skFstpuriagemeisaiDsBean.setIrGoukeikingk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

            skFstpuriagemeisaiDsBeanList.add(skFstpuriagemeisaiDsBean);
        }

        C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_JCB;

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCd);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(
            syoruiCd,
            skFstpuriagemeisaiDsBeanList,
            skFstpuriagemeisaiBean);

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(goukeiKensuu),
            "初回保険料クレジットカード扱売上請求明細票（ＪＣＢ）"));


        skFstpuriagemeisaiBean = new SkFstpuriagemeisaiBean();

        syuukeiComment = MessageUtil.getMessage(MessageId.IHF1019);

        skFstpuriagemeisaiBean.setIrAtesaki(kanjiSosikiNm);
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.VISA.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment(syuukeiComment);

        skFstpuriagemeisaiDsBeanList = new ArrayList<>();

        renNo = 0;
        goukeiKensuu = 0;
        goukeiGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        List<String> cardkaisyaGroupVisaList = YuyuSinkeiyakuConfig.getInstance().getCardkaisyaGroupVisaList();
        List<C_CardBrandKbn> cardBrandKbnVisaList = convertToKbn(cardkaisyaGroupVisaList);

        try (
            ExDBResults<HT_SkUriageData> skUriageDataList =
            skFstpUriagemeisaihyouSakuseiDao.getSkUriageData(
                BizDate.valueOf(syoriYmd.getPreviousMonth().getBizDateYM().toString() + "16"),
                BizDate.valueOf(syoriYmd.getBizDateYM().toString() + "15"),
                C_UriagekekkaKbn.URIAGEOK,
                cardBrandKbnVisaList)) {

            skFstpuriagemeisaiDsBeanList = tyouhyouDtlSksUragdtl(skUriageDataList);
        }

        if (goukeiKensuu == 0) {

            SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDsBean = new SkFstpuriagemeisaiDataSourceBean();

            skFstpuriagemeisaiDsBean.setIrKensuugoukei(BizNumber.ZERO);
            skFstpuriagemeisaiDsBean.setIrGoukeikingk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

            skFstpuriagemeisaiDsBeanList.add(skFstpuriagemeisaiDsBean);
        }

        syoruiCd = C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA;

        reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCd);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(
            syoruiCd,
            skFstpuriagemeisaiDsBeanList,
            skFstpuriagemeisaiBean);

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(goukeiKensuu),
            "初回保険料クレジットカード扱売上請求明細票（ＶＩＳＡ）"));

    }

    private List<IReportDataSouceBean> tyouhyouDtlSksUragdtl(ExDBResults<HT_SkUriageData> pUragMisiList) {

        List<IReportDataSouceBean> skFstpuriagemeisaiDsBeanList = new ArrayList<>();

        for (HT_SkUriageData skUriageData : pUragMisiList) {

            renNo = renNo + 1;
            goukeiKensuu = goukeiKensuu + 1;
            goukeiGk = goukeiGk.add(skUriageData.getUriagegk());

            String hknsyurui = skUriageData.getHknsyuruino().getContent(C_HknsyuruiNo.PATTERN_AISYOUMEI);
            if (hknsyurui.length() > 18) {
                hknsyurui = hknsyurui.substring(0, 18);
            }

            SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDsBean = new SkFstpuriagemeisaiDataSourceBean();

            skFstpuriagemeisaiDsBean.setIrRenno(renNo);
            skFstpuriagemeisaiDsBean.setIrCardbrand(skUriageData.getCardbrandkbn().getContent());
            skFstpuriagemeisaiDsBean.setIrDatasousinymd(skUriageData.getCarddatasousinymd().toString());
            skFstpuriagemeisaiDsBean.setIrMosno(skUriageData.getMosno());
            skFstpuriagemeisaiDsBean.setIrRsgaku(skUriageData.getUriagegk());
            skFstpuriagemeisaiDsBean.setIrRyosyuymd(skUriageData.getUriageymd().toString());
            skFstpuriagemeisaiDsBean.setIrHknsyurui(hknsyurui);
            skFstpuriagemeisaiDsBean.setIrKykymd(skUriageData.getKykymd().toString());
            skFstpuriagemeisaiDsBean.setIrSeirituymd(skUriageData.getSrsyoriymd().toString());
            skFstpuriagemeisaiDsBean.setIrCreditkessaiyouno(skUriageData.getCreditkessaiyouno());
            skFstpuriagemeisaiDsBean.setIrKensuugoukei(BizNumber.valueOf(goukeiKensuu));
            skFstpuriagemeisaiDsBean.setIrGoukeikingk(goukeiGk);

            skFstpuriagemeisaiDsBeanList.add(skFstpuriagemeisaiDsBean);
        }

        return skFstpuriagemeisaiDsBeanList;
    }

    private List<C_CardBrandKbn> convertToKbn(List<String> pStringList) {

        List<C_CardBrandKbn> kbnList = new ArrayList<>();

        for (String kbn : pStringList) {
            kbnList.add(C_CardBrandKbn.valueOf(kbn));
        }

        return kbnList;
    }
}

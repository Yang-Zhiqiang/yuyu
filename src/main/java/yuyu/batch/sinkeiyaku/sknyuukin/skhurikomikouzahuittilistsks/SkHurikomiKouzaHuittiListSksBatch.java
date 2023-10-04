package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomikouzahuittilistsks;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikomikouzahuittilistsks.dba.SikinidouInfoBean;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikomikouzahuittilistsks.dba.SkHurikomiKouzaHuittiListSksDao;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.kaikei.BzSikinIdouListCsvFSksTblTrk;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.sinkeiyaku.bean.report.SkSikinIdouListHrkmKouzaHuittibunBean;
import yuyu.def.sinkeiyaku.bean.report.SkSikinIdouListHrkmKouzaHuittibunDataSourceBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;

/**
 * 新契約 入金 振込口座不一致リスト作成
 */
public class SkHurikomiKouzaHuittiListSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkHurikomiKouzaHuittiListSksDao skHurikomiKouzaHuittiListSksDao;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        long totalKns = 0;
        long skHurikomiKouzaHuittiKns = 0;

        try (ExDBResults<SikinidouInfoBean> exDbResults =
            skHurikomiKouzaHuittiListSksDao.getSikinidouInfosBySyoriYmd(bzBatchParam.getSyoriYmd())) {

            Iterator<SikinidouInfoBean> sikinidouInfoBeanLst = exDbResults.iterator();

            if (sikinidouInfoBeanLst.hasNext()) {
                SkSikinIdouListHrkmKouzaHuittibunBean skSikinIdouListHrkmKouzaHuittibunBean =
                    SWAKInjector.getInstance(SkSikinIdouListHrkmKouzaHuittibunBean.class);
                skSikinIdouListHrkmKouzaHuittibunBean.setIrTyouhyousakuseiymd(DateFormatUtil
                    .dateKANJI(bzBatchParam.getSyoriYmd()));

                List<IReportDataSouceBean> iReportDataSouceBeanLst = Lists.newArrayList();
                String zenkaiTaisyouKouzaCd = "";
                String taisyouKouzaCd = "";
                C_Tuukasyu seitoukouzatuukasyu = C_Tuukasyu.BLNK;
                String seitoukouzabankcd = "";
                String seitoukouzasitencd = "";
                String seitoukouzano = "";
                C_Tuukasyu sikinidoumototuukasyu = C_Tuukasyu.BLNK;
                String sikinidoumotobankcd = "";
                String sikinidoumotositencd = "";
                String sikinidoumotokouzano = "";
                BizCurrency idougaku = BizCurrency.valueOf(0);
                int loopKns = 0;
                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

                while (sikinidouInfoBeanLst.hasNext()) {

                    SikinidouInfoBean sikinidouInfoBean = sikinidouInfoBeanLst.next();
                    if (loopKns == 0) {

                        idougaku = BizCurrency.valueOf(0,
                            henkanTuuka.henkanTuukaKbnToType(sikinidouInfoBean.getSikinidoumototuukasyu()));
                        loopKns++;
                    }

                    skHurikomiKouzaHuittiKns++;

                    batchLogger.info("申込番号　＝" + sikinidouInfoBean.getNykmosno());

                    taisyouKouzaCd = sikinidouInfoBean.getSikinidoumotohonkouzacd()
                        + sikinidouInfoBean.getSikinidousakihonkouzacd();

                    if (!zenkaiTaisyouKouzaCd.equals(taisyouKouzaCd) && !BizUtil.isBlank(zenkaiTaisyouKouzaCd)) {

                        totalKns++;

                        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean =
                            SWAKInjector.getInstance(SkSikinIdouListHrkmKouzaHuittibunDataSourceBean.class);

                        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzatuukasyu(seitoukouzatuukasyu);
                        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzabanccd(seitoukouzabankcd);
                        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzasitencd(seitoukouzasitencd);
                        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzano(seitoukouzano);
                        skSikinIdouListHrkmKouzaHuittibunDataSourceBean
                        .setIrSikinidoumototuukasyu(sikinidoumototuukasyu);
                        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotobankcd(sikinidoumotobankcd);
                        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotositencd(sikinidoumotositencd);
                        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotokouzano(sikinidoumotokouzano);
                        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidougaku(idougaku);

                        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean);

                        idougaku = BizCurrency.valueOf(0,
                            henkanTuuka.henkanTuukaKbnToType(sikinidouInfoBean.getSikinidoumototuukasyu()));
                    }

                    zenkaiTaisyouKouzaCd = taisyouKouzaCd;
                    seitoukouzatuukasyu = sikinidouInfoBean.getSikinidousakihontuukasyu();
                    seitoukouzabankcd = sikinidouInfoBean.getSikinidousakihonbankcd();
                    seitoukouzasitencd = sikinidouInfoBean.getSikinidousakihonsitencd();
                    seitoukouzano = sikinidouInfoBean.getSikinidousakihonkouzano();
                    sikinidoumototuukasyu = sikinidouInfoBean.getSikinidoumototuukasyu();
                    sikinidoumotobankcd = sikinidouInfoBean.getSikinidoumotobankcd();
                    sikinidoumotositencd = sikinidouInfoBean.getSikinidoumotositencd();
                    sikinidoumotokouzano = sikinidouInfoBean.getSikinidoumotokouzano();
                    idougaku = idougaku.add(sikinidouInfoBean.getSikinidougaku());
                }

                SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean =
                    SWAKInjector.getInstance(SkSikinIdouListHrkmKouzaHuittibunDataSourceBean.class);

                skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzatuukasyu(seitoukouzatuukasyu);
                skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzabanccd(seitoukouzabankcd);
                skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzasitencd(seitoukouzasitencd);
                skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzano(seitoukouzano);
                skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumototuukasyu(sikinidoumototuukasyu);
                skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotobankcd(sikinidoumotobankcd);
                skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotositencd(sikinidoumotositencd);
                skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotokouzano(sikinidoumotokouzano);
                skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidougaku(idougaku);

                iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean);

                totalKns++;

                C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.SK_SIKINIDOULIST_HRKMKZHUITTI;

                CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

                ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean("biz", "bzkaikei",
                    kinou.getKinouId(), syoruiCdKbn);

                reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

                reportServicesBean.addParamObjects(syoruiCdKbn, iReportDataSouceBeanLst,
                    skSikinIdouListHrkmKouzaHuittibunBean);

                createReport.execNoCommit(reportServicesBean);

                BzSikinIdouListCsvFSksTblTrk bzSikinIdouListCsvFSksTblTrk = SWAKInjector.getInstance(BzSikinIdouListCsvFSksTblTrk.class);

                bzSikinIdouListCsvFSksTblTrk.exec(bzBatchParam.getSyoriYmd(), iReportDataSouceBeanLst);

            }

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(skHurikomiKouzaHuittiKns),
            "振込口座不一致件数"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(totalKns), "資金移動リスト（振込口座不一致分）"));
    }
}
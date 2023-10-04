package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomiteisei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikomiteisei.dba.SkHurikomiTeiseiDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.db.entity.HT_HrkmNyknData;
import yuyu.def.sinkeiyaku.bean.report.SkHurikominyuukinteiseilistBean;
import yuyu.def.sinkeiyaku.bean.report.SkHurikominyuukinteiseilistDataSourceBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 入金 振込入金データ訂正
 */
public class SkHurikomiTeiseiBatch implements Batch {

    private final String FILTER_ID = "Sk002";

    private final String HT_HRKMNYKNDATA_TABLE_ID = "HT_HrkmNyknData";

    private final String HT_GAIKAHRKMNYKNDATA_TABLE_ID = "HT_GaikaHrkmNyknData";

    private long syoriKensuu = 0;

    private String reportData = "";

    private C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;

    List<IReportDataSouceBean> sHDSBeanList = new ArrayList<>();

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SkHurikomiTeiseiBatchParam sHTParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean recoveryBean;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private SkHurikomiTeiseiDao skHurikomiTeiseiDao;

    @Override
    public BatchParam getParam() {
        return sHTParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(sHTParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            String.valueOf(sHTParam.getIbKakutyoujobcd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "口座種類区分",
            String.valueOf(sHTParam.getKzsyuruikbn())));

        BzGetSosikiData getSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        SkHurikominyuukinteiseilistBean sHBean = SWAKInjector
            .getInstance(SkHurikominyuukinteiseilistBean.class);
        String dairitenKykSosikiCd = YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd();
        String kanjiSosikiNm = "";

        BzGetSosikiDataBean bzGetSosikiDataBean = getSosikiData.exec(dairitenKykSosikiCd);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            kanjiSosikiNm = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());
        }
        sHBean.setIrAtesaki(kanjiSosikiNm);

        sHBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJISeirekiNoZero(sHTParam.getSyoriYmd()));

        if (C_KouzasyuruiKbn.YENKOUZA.eq(sHTParam.getKzsyuruikbn())) {

            try (ExDBUpdatableResults<HT_HrkmNyknData> kmNyknDataList = skHurikomiTeiseiDao
                .getHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbnNyktyhyoutlst(sHTParam.getIbKakutyoujobcd(),
                    sHTParam.getSyoriYmd(), 2, new C_NyktyhyoutKbn[] {C_NyktyhyoutKbn.NONE, C_NyktyhyoutKbn.GAIKADATE});) {

                createHurikominyuukinTeiseiData(kmNyknDataList);

                reportData = "振込入金訂正データリスト(円貨)";

                syoruiCdKbn = C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_ENKA;

                recoveryBean.initializeBlank();

                createReport(sHBean);

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), reportData));
            }

            syoriKensuu = 0;
            reportData = "";
            syoruiCdKbn = C_SyoruiCdKbn.BLNK;
            sHDSBeanList = new ArrayList<>();

            try (ExDBUpdatableResults<HT_HrkmNyknData> kmNyknDataList = skHurikomiTeiseiDao
                .getHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbnNyktyhyoutlst(sHTParam.getIbKakutyoujobcd(),
                    sHTParam.getSyoriYmd(), 2, C_NyktyhyoutKbn.YENDATE);) {

                createHurikominyuukinTeiseiData(kmNyknDataList);

                reportData = "振込入金訂正データリスト(円貨)（円建）";

                syoruiCdKbn = C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_ENKA_YENDT;

                recoveryBean.initializeBlank();

                createReport(sHBean);

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), reportData));
            }

        }
        else {

            String ksnymd = "";

            String knjyymd = "";

            try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> kaHrkmNyknDataList = sinkeiyakuDomManager
                .getGaikaHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbn(sHTParam.getIbKakutyoujobcd(),
                    sHTParam.getSyoriYmd(), 2);) {

                for (HT_GaikaHrkmNyknData gaiKaHrkmNyknData : kaHrkmNyknDataList) {

                    recoveryBean.setIbKakutyoujobcd(sHTParam.getIbKakutyoujobcd());

                    recoveryBean.setIbTableid(HT_GAIKAHRKMNYKNDATA_TABLE_ID);

                    recoveryBean.setIbRecoveryfilterid(FILTER_ID);

                    recoveryBean.setIbRecoveryfilterkey1(String.valueOf(gaiKaHrkmNyknData.getDensyskbn()));

                    recoveryBean.setIbRecoveryfilterkey2(String.valueOf(gaiKaHrkmNyknData.getSyoriYmd()));

                    recoveryBean.setIbRecoveryfilterkey3(gaiKaHrkmNyknData.getItirenno());

                    List<HT_GaikaHrkmNyknData> gaikaHrkmNyknDataList = sinkeiyakuDomManager
                        .getGaikaHrkmNyknDatasByBankcdSitencdItems(
                            gaiKaHrkmNyknData.getBankcd(), gaiKaHrkmNyknData.getSitencd(),
                            gaiKaHrkmNyknData.getKouzano(), gaiKaHrkmNyknData.getTrhkkgk(),
                            gaiKaHrkmNyknData.getHrkmirninnm140(), gaiKaHrkmNyknData.getSyoriYmd(), 1);

                    if (gaikaHrkmNyknDataList.size() != 0) {


                        sinkeiyakuDomManager.delete(gaiKaHrkmNyknData);

                        sinkeiyakuDomManager.delete(gaikaHrkmNyknDataList.get(0));


                        SkHurikominyuukinteiseilistDataSourceBean sHDSBean = SWAKInjector
                            .getInstance(SkHurikominyuukinteiseilistDataSourceBean.class);

                        if (gaikaHrkmNyknDataList.get(0).getKsnymd() == null) {
                            ksnymd = "";
                        } else {
                            ksnymd = String.valueOf(gaikaHrkmNyknDataList.get(0).getKsnymd());
                        }

                        if (gaikaHrkmNyknDataList.get(0).getKnjyymd() == null) {
                            knjyymd = "";
                        } else {
                            knjyymd = String.valueOf(gaikaHrkmNyknDataList.get(0).getKnjyymd());
                        }

                        sHDSBean.setIrBankcd(gaikaHrkmNyknDataList.get(0).getBankcd());

                        sHDSBean.setIrSitencd(gaikaHrkmNyknDataList.get(0).getSitencd());

                        sHDSBean.setIrYokinkbn(gaikaHrkmNyknDataList.get(0).getYokinkbn());

                        sHDSBean.setIrKouzano(gaikaHrkmNyknDataList.get(0).getKouzano());

                        sHDSBean.setIrHrkmirninnm48(gaikaHrkmNyknDataList.get(0).getHrkmirninnm());

                        sHDSBean.setIrNyknkkngk(gaikaHrkmNyknDataList.get(0).getTrhkkgk());

                        sHDSBean.setIrKsnymd(ksnymd);

                        sHDSBean.setIrKnjyymd(knjyymd);

                        sHDSBean.setIrIribaraikbn(String.valueOf(gaikaHrkmNyknDataList.get(0).getIribaraikbn()));

                        sHDSBean.setIrTrhkkbn(String.valueOf(gaikaHrkmNyknDataList.get(0).getTrhkkbn()));

                        sHDSBean.setIrHrkmirnincd("");

                        sHDSBeanList.add(sHDSBean);

                        syoriKensuu++;
                    }
                }

                reportData = "振込入金訂正データリスト(外貨)";

                syoruiCdKbn = C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_GAIKA;

                recoveryBean.initializeBlank();

                createReport(sHBean);

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), reportData));
            }
        }

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

    private void createHurikominyuukinTeiseiData(ExDBUpdatableResults<HT_HrkmNyknData> pKmNyknDataList) {

        String azkrhrdsymd = "";

        String knjyymd = "";

        for (HT_HrkmNyknData hrkmNyknData : pKmNyknDataList) {

            recoveryBean.setIbKakutyoujobcd(sHTParam.getIbKakutyoujobcd());

            recoveryBean.setIbTableid(HT_HRKMNYKNDATA_TABLE_ID);

            recoveryBean.setIbRecoveryfilterid(FILTER_ID);

            recoveryBean.setIbRecoveryfilterkey1(String.valueOf(hrkmNyknData.getDensyskbn()));

            recoveryBean.setIbRecoveryfilterkey2(String.valueOf(hrkmNyknData.getSyoriYmd()));

            recoveryBean.setIbRecoveryfilterkey3(hrkmNyknData.getItirenno());

            List<HT_HrkmNyknData> hrkmNyknDataList = sinkeiyakuDomManager.getHrkmNyknDatasByBankcdSitencdItems(
                hrkmNyknData.getBankcd(), hrkmNyknData.getSitencd(), hrkmNyknData.getYokinkbn(),
                hrkmNyknData.getKouzano(), hrkmNyknData.getTrhkkgk(), hrkmNyknData.getHrkmirninnm140(),
                hrkmNyknData.getSyoriYmd(), 1);

            if (hrkmNyknDataList.size() != 0) {
                sinkeiyakuDomManager.delete(hrkmNyknData);

                sinkeiyakuDomManager.delete(hrkmNyknDataList.get(0));

                SkHurikominyuukinteiseilistDataSourceBean sHDSBean = SWAKInjector
                    .getInstance(SkHurikominyuukinteiseilistDataSourceBean.class);

                if (hrkmNyknDataList.get(0).getAzkrhrdsymd() == null) {
                    azkrhrdsymd = "";
                } else {
                    azkrhrdsymd = String.valueOf(hrkmNyknDataList.get(0).getAzkrhrdsymd());
                }
                if (hrkmNyknDataList.get(0).getKnjyymd() == null) {
                    knjyymd = "";
                } else {
                    knjyymd = String.valueOf(hrkmNyknDataList.get(0).getKnjyymd());
                }

                sHDSBean.setIrBankcd(hrkmNyknDataList.get(0).getBankcd());

                sHDSBean.setIrSitencd(hrkmNyknDataList.get(0).getSitencd());

                sHDSBean.setIrYokinkbn(hrkmNyknDataList.get(0).getYokinkbn());

                sHDSBean.setIrKouzano(hrkmNyknDataList.get(0).getKouzano());

                sHDSBean.setIrHrkmirninnm48(hrkmNyknDataList.get(0).getHrkmirninnm());

                sHDSBean.setIrNyknkkngk(hrkmNyknDataList.get(0).getTrhkkgk());

                sHDSBean.setIrKsnymd(azkrhrdsymd);

                sHDSBean.setIrKnjyymd(knjyymd);

                sHDSBean.setIrIribaraikbn(String.valueOf(hrkmNyknDataList.get(0).getIribaraikbn()));

                sHDSBean.setIrTrhkkbn(String.valueOf(hrkmNyknDataList.get(0).getTrhkkbn()));

                sHDSBean.setIrHrkmirnincd(hrkmNyknDataList.get(0).getHrkmirnincd());

                sHDSBeanList.add(sHDSBean);

                syoriKensuu++;
            }
        }
    }

    private void createReport(SkHurikominyuukinteiseilistBean pSHBean) {

        if (sHDSBeanList.size() > 0) {

            pSHBean.setIrSyoruicd(syoruiCdKbn);

            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU, kinou.getCategoryId(),
                kinou.getKinouId(), syoruiCdKbn);

            reportServicesBean.setSyoriYmd(sHTParam.getSyoriYmd());

            reportServicesBean.addParamObjects(syoruiCdKbn, sHDSBeanList, pSHBean);

            createReport.execNoCommit(reportServicesBean);
        }
    }
}

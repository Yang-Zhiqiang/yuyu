package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomisakujyo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.db.entity.HT_HrkmNyknData;
import yuyu.def.db.entity.HT_HrkmNyknSakujyo;
import yuyu.def.sinkeiyaku.bean.report.SkMisslistBean;
import yuyu.def.sinkeiyaku.bean.report.SkMisslistDetailBean;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 入金 振込入金データ削除クラス
 */
public class SkHurikomiSakujyoBatch implements Batch {

    private final String HRKMNYKNSAKUJYOID = "HT_HrkmNyknSakujyo";

    private final String HRKMNYKNSAKUJYOFILTERID = "Sk003";

    private final String SKHURIKOMISAKUJYO = "振込入金データ削除";

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

    @Inject
    private CreateReport createReport;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            bzBatchParam.getIbKakutyoujobcd()));

        try (ExDBUpdatableResults<HT_HrkmNyknSakujyo> hrkmNyknSakujyoLst = sinkeiyakuDomManager.
            getHrkmNyknSakujyosByKakutyoujobcdSyorizumiflg(bzBatchParam.getIbKakutyoujobcd(),
                C_Syorizumiflg.MISYORI);
            EntityUpdater<HT_HrkmNyknData> hrkmNyknDataUpdater = new EntityUpdater<>();
            EntityUpdater<HT_GaikaHrkmNyknData> gaikaHrkmNyknDataUpdater = new EntityUpdater<>()) {

            long syoriKensuuari = 0;
            long syoriKensuunasi = 0;
            List<IReportDataSouceBean> skMisslistDetailBeanLst = new ArrayList<>();

            String sysTime = BizDate.getSysDateTimeMilli();

            for (HT_HrkmNyknSakujyo hrkmNyknSakujyo : hrkmNyknSakujyoLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(HRKMNYKNSAKUJYOID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(HRKMNYKNSAKUJYOFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(hrkmNyknSakujyo.getHrkmdeldataskbtkey());

                if (C_Tuukasyu.JPY.eq(hrkmNyknSakujyo.getRstuukasyu())) {

                    List<HT_HrkmNyknData> hrkmNyknDataLst = sinkeiyakuDomManager.
                        getHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(hrkmNyknSakujyo.getNykmosno(),
                            hrkmNyknSakujyo.getOyadrtencd(),
                            hrkmNyknSakujyo.getHrkmirninnm(),
                            hrkmNyknSakujyo.getTrhkkgk());

                    if (hrkmNyknDataLst.size() == 0) {

                        SkMisslistDetailBean skMisslistDetailBean = SWAKInjector
                            .getInstance(SkMisslistDetailBean.class);

                        skMisslistDetailBean.setIrMosno(hrkmNyknSakujyo.getNykmosno());
                        if (hrkmNyknSakujyo.getHrkmirninnm().length() > 30) {
                            skMisslistDetailBean.setIrMisslistmsg(MessageUtil.getMessage(MessageId.EHA1040,
                                hrkmNyknSakujyo.getNykmosno(),
                                hrkmNyknSakujyo.getOyadrtencd(),
                                hrkmNyknSakujyo.getHrkmirninnm().substring(0, 30),
                                ViewReport.editCommaTuuka(hrkmNyknSakujyo.getTrhkkgk(), BizUtil.ZERO_FILL),
                                hrkmNyknSakujyo.getRstuukasyu().getValue()));
                        }
                        else {
                            skMisslistDetailBean.setIrMisslistmsg(MessageUtil.getMessage(MessageId.EHA1040,
                                hrkmNyknSakujyo.getNykmosno(),
                                hrkmNyknSakujyo.getOyadrtencd(),
                                hrkmNyknSakujyo.getHrkmirninnm(),
                                ViewReport.editCommaTuuka(hrkmNyknSakujyo.getTrhkkgk(), BizUtil.ZERO_FILL),
                                hrkmNyknSakujyo.getRstuukasyu().getValue()));
                        }

                        skMisslistDetailBeanLst.add(skMisslistDetailBean);
                        syoriKensuuari++;
                    }
                    else {

                        hrkmNyknDataLst.get(0).setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
                        hrkmNyknDataLst.get(0).setGyoumuKousinKinou(kinou.getKinouId());
                        hrkmNyknDataLst.get(0).setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        hrkmNyknDataLst.get(0).setGyoumuKousinTime(sysTime);

                        hrkmNyknSakujyo.setNyksyoriymd(hrkmNyknDataLst.get(0).getSyoriYmd());
                        hrkmNyknSakujyo.setItirenno(hrkmNyknDataLst.get(0).getItirenno());
                        hrkmNyknSakujyo.setKnjyymd(hrkmNyknDataLst.get(0).getAzkrhrdsymd());
                        hrkmNyknSakujyo.setSyoriYmd(bzBatchParam.getSyoriYmd());
                        hrkmNyknSakujyo.setKouzano(hrkmNyknDataLst.get(0).getKouzano());
                        hrkmNyknSakujyo.setHrkmirnincd(hrkmNyknDataLst.get(0).getHrkmirnincd());
                        hrkmNyknSakujyo.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
                        hrkmNyknSakujyo.setHrkmnykndatarenmotoKbn(hrkmNyknDataLst.get(0).getHrkmnykndatarenmotoKbn());
                        hrkmNyknSakujyo.setNyktyhyoutkbn(hrkmNyknDataLst.get(0).getNyktyhyoutkbn());
                        hrkmNyknSakujyo.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        hrkmNyknSakujyo.setGyoumuKousinTime(sysTime);

                        hrkmNyknDataUpdater.add(hrkmNyknDataLst.get(0));

                        syoriKensuunasi++;
                    }
                }
                else {

                    List<HT_GaikaHrkmNyknData> gaikaHrkmNyknDataLst = sinkeiyakuDomManager.
                        getGaikaHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(hrkmNyknSakujyo.getNykmosno(),
                            hrkmNyknSakujyo.getOyadrtencd(),
                            hrkmNyknSakujyo.getHrkmirninnm(),
                            hrkmNyknSakujyo.getTrhkkgk());

                    if (gaikaHrkmNyknDataLst.size() == 0) {

                        SkMisslistDetailBean skMisslistDetailBean = SWAKInjector
                            .getInstance(SkMisslistDetailBean.class);

                        skMisslistDetailBean.setIrMosno(hrkmNyknSakujyo.getNykmosno());
                        if (hrkmNyknSakujyo.getHrkmirninnm().length() > 30) {
                            skMisslistDetailBean.setIrMisslistmsg(MessageUtil.getMessage(MessageId.EHA1040,
                                hrkmNyknSakujyo.getNykmosno(),
                                hrkmNyknSakujyo.getOyadrtencd(),
                                hrkmNyknSakujyo.getHrkmirninnm().substring(0, 30),
                                ViewReport.editCommaTuuka(hrkmNyknSakujyo.getTrhkkgk(), BizUtil.ZERO_FILL),
                                hrkmNyknSakujyo.getRstuukasyu().getValue()));
                        }
                        else {
                            skMisslistDetailBean.setIrMisslistmsg(MessageUtil.getMessage(MessageId.EHA1040,
                                hrkmNyknSakujyo.getNykmosno(),
                                hrkmNyknSakujyo.getOyadrtencd(),
                                hrkmNyknSakujyo.getHrkmirninnm(),
                                ViewReport.editCommaTuuka(hrkmNyknSakujyo.getTrhkkgk(), BizUtil.ZERO_FILL),
                                hrkmNyknSakujyo.getRstuukasyu().getValue()));
                        }

                        skMisslistDetailBeanLst.add(skMisslistDetailBean);
                        syoriKensuuari++;
                    }
                    else {

                        gaikaHrkmNyknDataLst.get(0).setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
                        gaikaHrkmNyknDataLst.get(0).setGyoumuKousinKinou(kinou.getKinouId());
                        gaikaHrkmNyknDataLst.get(0).setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        gaikaHrkmNyknDataLst.get(0).setGyoumuKousinTime(sysTime);

                        hrkmNyknSakujyo.setNyksyoriymd(gaikaHrkmNyknDataLst.get(0).getSyoriYmd());
                        hrkmNyknSakujyo.setItirenno(gaikaHrkmNyknDataLst.get(0).getItirenno());
                        hrkmNyknSakujyo.setKnjyymd(gaikaHrkmNyknDataLst.get(0).getKsnymd());
                        hrkmNyknSakujyo.setSyoriYmd(bzBatchParam.getSyoriYmd());
                        hrkmNyknSakujyo.setKouzano(gaikaHrkmNyknDataLst.get(0).getKouzano());
                        hrkmNyknSakujyo.setHrkmirnincd("");
                        hrkmNyknSakujyo.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
                        hrkmNyknSakujyo.setHrkmnykndatarenmotoKbn(
                            gaikaHrkmNyknDataLst.get(0).getHrkmnykndatarenmotoKbn());
                        hrkmNyknSakujyo.setNyktyhyoutkbn(C_NyktyhyoutKbn.GAIKADATE);
                        hrkmNyknSakujyo.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        hrkmNyknSakujyo.setGyoumuKousinTime(sysTime);

                        gaikaHrkmNyknDataUpdater.add(gaikaHrkmNyknDataLst.get(0));

                        syoriKensuunasi++;
                    }
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (skMisslistDetailBeanLst.size() > 0) {
                ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                    ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                    kinou.getCategoryId(),
                    kinou.getKinouId(),
                    C_SyoruiCdKbn.SK_HURIKOMINYKNSAKUJOMISSLIST);

                reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());
                SkMisslistBean skMisslistBean = SWAKInjector.getInstance(SkMisslistBean.class);
                skMisslistBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJI(bzBatchParam.getSyoriYmd()));
                skMisslistBean.setIrKensuu((int) syoriKensuuari);
                skMisslistBean.setIrKinounm(SKHURIKOMISAKUJYO);
                reportServicesBean.addParamObjects(C_SyoruiCdKbn.SK_HURIKOMINYKNSAKUJOMISSLIST,
                    skMisslistDetailBeanLst,
                    skMisslistBean);

                createReport.execNoCommit(reportServicesBean);

            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0018, String.valueOf(syoriKensuuari)));

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0019, String.valueOf(syoriKensuunasi)));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}

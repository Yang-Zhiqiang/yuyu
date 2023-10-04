package yuyu.batch.sinkeiyaku.sknyuukin.skfstpuriagekekkahanei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skfstpuriagekekkahanei.dba.SkFstpUriageKekkaHaneiDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UriagekekkaKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_SkUriageData;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuKekkaTr;
import yuyu.def.sinkeiyaku.bean.report.SkFsturiagekekkaerrorlistDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkSyanailistheaderBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 入金 初回保険料売上請求結果反映
 */
public class SkFstpUriageKekkaHaneiBatch implements Batch {

    private static final String TABLEID = ZT_FstpUriageSeikyuuKekkaTr.TABLE_NAME;

    private static final String FILTERID = "Bz111";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkFstpUriageKekkaHaneiDao fstpUriageKekkaHaneiDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syoriCnt = 0;
        long errorListCnt = 0;
        long updateCnt = 0;

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        String userId = bzBatchParam.getUserId();
        String sysDateTime = BizDate.getSysDateTimeMilli();

        SkSyanailistheaderBean syanailistheaderBean = new SkSyanailistheaderBean();
        SkFsturiagekekkaerrorlistDataSourceBean fstpUriagekekkaErrorlistDsBean = null;
        List<IReportDataSouceBean> fstpUriagekekkaErrorlistDsBeanList = new ArrayList<>();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));

        String dairitenKykSosikiCd = YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd();
        String kanjiSosikiNm = "";

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(dairitenKykSosikiCd, null);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            kanjiSosikiNm = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());
        }

        String tyouhyouYmd = DateFormatUtil.dateKANJI(syoriYmd);

        syanailistheaderBean.setIrAtesakisosiki(kanjiSosikiNm);
        syanailistheaderBean.setIrTyouhyousakuseiymd(tyouhyouYmd);

        try (
            ExDBResults<ZT_FstpUriageSeikyuuKekkaTr> fstpUriageSeikyuuKekkaTrList = fstpUriageKekkaHaneiDao
            .getFstUriageKekkaTrs(kakutyoujobCd);
            EntityUpdater<HT_SkUriageData> entityUpdater = new EntityUpdater<>()) {

            for (ZT_FstpUriageSeikyuuKekkaTr fstpUriageSeikyuuKekkaTr : fstpUriageSeikyuuKekkaTrList) {

                syoriCnt++;

                String trHurikaeKekkaCd = fstpUriageSeikyuuKekkaTr.getZtrhurikaekekkacd();
                C_CreditUriageNgJiyuuKbn hurikaeKekkaCd = C_CreditUriageNgJiyuuKbn.valueOf(trHurikaeKekkaCd);

                if ("0".equals(trHurikaeKekkaCd)) {
                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                    bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(fstpUriageSeikyuuKekkaTr
                        .getZtrcreditkessaiyouno());

                    HT_SkUriageData skUriageData = fstpUriageKekkaHaneiDao.getSkUriageDataInfo(
                        fstpUriageSeikyuuKekkaTr.getZtrcreditkessaiyouno());

                    if (skUriageData != null) {

                        skUriageData.setCreditkaiinnokami6keta(fstpUriageSeikyuuKekkaTr.getZtrcreditkaiinnokami6keta());
                        skUriageData.setCreditkaiinnosimo4keta(fstpUriageSeikyuuKekkaTr.getZtrcreditkaiinnosimo4keta());
                        skUriageData.setCredituriagengjiyuu(hurikaeKekkaCd);
                        skUriageData.setUriagekekkakbn(C_UriagekekkaKbn.URIAGEOK);
                        skUriageData.setUriageseikyuuerrorcd(fstpUriageSeikyuuKekkaTr.getZtruriageseikyuuerrorcd());
                        skUriageData.setGyoumuKousinsyaId(userId);
                        skUriageData.setGyoumuKousinTime(sysDateTime);

                        entityUpdater.add(skUriageData);

                        updateCnt++;
                    }
                }
                else {
                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                    bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(fstpUriageSeikyuuKekkaTr
                        .getZtrcreditkessaiyouno());

                    errorListCnt++;

                    fstpUriagekekkaErrorlistDsBean = new SkFsturiagekekkaerrorlistDataSourceBean();

                    fstpUriagekekkaErrorlistDsBean.setIrCreditkessaiyouno(
                        fstpUriageSeikyuuKekkaTr.getZtrcreditkessaiyouno());
                    fstpUriagekekkaErrorlistDsBean.setIrCredituriagegk(
                        BizCurrency.valueOf(fstpUriageSeikyuuKekkaTr.getZtrseikyuukngk(), BizCurrencyTypes.YEN));
                    fstpUriagekekkaErrorlistDsBean.setIrCredituriagengjiyuu(hurikaeKekkaCd);
                    fstpUriagekekkaErrorlistDsBean.setIrSeikyuuerrorriyuu(
                        hurikaeKekkaCd.getContent(C_CreditUriageNgJiyuuKbn.PATTERN_SKDISP));
                    fstpUriagekekkaErrorlistDsBean.setIrUriageseikyuuerrcd(
                        fstpUriageSeikyuuKekkaTr.getZtruriageseikyuuerrorcd());
                    fstpUriagekekkaErrorlistDsBean.setIrKensuugoukei(BizNumber.valueOf(errorListCnt));

                    fstpUriagekekkaErrorlistDsBeanList.add(fstpUriagekekkaErrorlistDsBean);

                    HT_SkUriageData skUriageData = fstpUriageKekkaHaneiDao.getSkUriageDataInfo(
                        fstpUriageSeikyuuKekkaTr.getZtrcreditkessaiyouno());

                    if (skUriageData != null) {

                        skUriageData.setCreditkaiinnokami6keta(fstpUriageSeikyuuKekkaTr.getZtrcreditkaiinnokami6keta());
                        skUriageData.setCreditkaiinnosimo4keta(fstpUriageSeikyuuKekkaTr.getZtrcreditkaiinnosimo4keta());
                        skUriageData.setCredituriagengjiyuu(hurikaeKekkaCd);
                        skUriageData.setUriagekekkakbn(C_UriagekekkaKbn.URIAGENG);
                        skUriageData.setUriageseikyuuerrorcd(fstpUriageSeikyuuKekkaTr.getZtruriageseikyuuerrorcd());
                        skUriageData.setGyoumuKousinsyaId(userId);
                        skUriageData.setGyoumuKousinTime(sysDateTime);

                        entityUpdater.add(skUriageData);

                        updateCnt++;
                    }
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        if (errorListCnt == 0) {
            fstpUriagekekkaErrorlistDsBean = new SkFsturiagekekkaerrorlistDataSourceBean();

            fstpUriagekekkaErrorlistDsBean.setIrKensuugoukei(BizNumber.ZERO);

            fstpUriagekekkaErrorlistDsBeanList.add(fstpUriagekekkaErrorlistDsBean);
        }

        C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUERRORLIST;
        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCd);

        reportServicesBean.setSyoriYmd(syoriYmd);
        reportServicesBean.addParamObjects(syoruiCd, fstpUriagekekkaErrorlistDsBeanList, syanailistheaderBean);

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCnt),
            "初回保険料売上請求結果反映"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(errorListCnt),
            "初回保険料売上請求エラーリスト"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(updateCnt),
            "新契約売上データテーブル"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}

package yuyu.batch.hozen.khansyuu.khminusuriagekykdtllistsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khminusuriagekykdtllistsks.dba.KhMinusUriageKykDtlListSksDao;
import yuyu.batch.hozen.khansyuu.khminusuriagekykdtllistsks.dba.MinusUriageKykDtlListSksTaisyouBean;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_MinusUriageKykDtlList;
import yuyu.def.hozen.bean.report.KhMinusUriageKykDtlListBean;
import yuyu.def.hozen.bean.report.KhMinusUriageKykDtlListDataSourceBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 案内収納 マイナス売上契約明細リスト作成
 */
public class KhMinusUriageKykDtlListSksBatch implements Batch {

    private static final String TABLEID = IT_MinusUriageKykDtlList.TABLE_NAME;

    private static final String FILTERID = "Bz001";

    private  static final String TANTOSITUCD = C_Tantositucd.SYUUNOUSV.getValue() + "0000";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KhMinusUriageKykDtlListSksDao khMinusUriageKykDtlListSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BaseDomManager baseDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobcd));

        int syoriKensuu= 0;
        BizCurrency goukeikingk = BizCurrency.valueOf(0);
        String tantosituNm = "";
        BizDateYM syoriYm = syoriYmd.getBizDateYM();
        BizDateYM syoriYmZengetu = syoriYm.getPreviousMonth();
        BizDate kijyunYmd = BizDate.valueOf(syoriYm, 16).getBusinessDay(CHolidayAdjustingMode.NEXT);

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(TANTOSITUCD);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {
            tantosituNm = bzGetSosikiDataBean.getKanjisosikinm20();
        }

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        BizDate taisyoukknfrom;
        BizDate taisyoukknto;
        if(syoriYmd.compareTo(kijyunYmd) >= 0){
            taisyoukknfrom = BizDate.valueOf(syoriYm, 1);
            taisyoukknto = BizDate.valueOf(syoriYm, 15);
        } else {
            taisyoukknfrom = BizDate.valueOf(syoriYmZengetu, 16);
            taisyoukknto = syoriYmZengetu.getLastDay();
        }

        try (ExDBResults<MinusUriageKykDtlListSksTaisyouBean> sksTaisyouBeansLst =
            khMinusUriageKykDtlListSksDao.getMinusUriageKykDtlListSksTaisyouBeans(ibKakutyoujobcd, taisyoukknfrom, taisyoukknto);) {

            for (MinusUriageKykDtlListSksTaisyouBean sksTaisyouBean : sksTaisyouBeansLst) {
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(sksTaisyouBean.getSyono());

                String kinounm = baseDomManager.getKinou(sksTaisyouBean.getKinouid()).getKinouNm();

                KhMinusUriageKykDtlListDataSourceBean dataSourceBean = SWAKInjector.getInstance(KhMinusUriageKykDtlListDataSourceBean.class);

                dataSourceBean.setIrSyono(sksTaisyouBean.getSyono());
                dataSourceBean.setIrUriageymd(sksTaisyouBean.getUriagenengappi());
                dataSourceBean.setIrCreditkessaiyouno(sksTaisyouBean.getCreditkessaiyouno());
                dataSourceBean.setIrJyuutouym(sksTaisyouBean.getJyuutouym());
                dataSourceBean.setIrCredituriagegk(sksTaisyouBean.getCredituriagegk());
                dataSourceBean.setIrKinounm(kinounm);

                iReportDataSouceBeanLst.add(dataSourceBean);

                syoriKensuu = syoriKensuu + 1;
                goukeikingk = goukeikingk.add(sksTaisyouBean.getCredituriagegk());
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        if (syoriKensuu > 0) {
            KhMinusUriageKykDtlListBean khMinusUriageKykDtlListBean = SWAKInjector.getInstance(
                KhMinusUriageKykDtlListBean.class);

            khMinusUriageKykDtlListBean.setIrTantousitunm(tantosituNm);
            khMinusUriageKykDtlListBean.setIrSyoribi(syoriYmd);
            khMinusUriageKykDtlListBean.setIrKensuu(syoriKensuu);
            khMinusUriageKykDtlListBean.setIrGoukeikingk(goukeikingk);

            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(),
                kinou.getCategoryId(),
                kinou.getKinouId(),
                C_SyoruiCdKbn.AS_MINUSURIAGEKYKDTLLIST);

            reportServicesBean.addParamObjects(iReportDataSouceBeanLst, khMinusUriageKykDtlListBean, syoriYmd);

            createReport.execNoCommit(reportServicesBean);
        }

        BizDate uriagenengappi;
        if(syoriYmd.compareTo(kijyunYmd) >= 0){
            uriagenengappi = BizDate.valueOf(syoriYm, 1);
        } else {
            uriagenengappi = BizDate.valueOf(syoriYmZengetu, 16);
        }

        khMinusUriageKykDtlListSksDao.deleteMinusUriageKykDtlList(uriagenengappi);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}

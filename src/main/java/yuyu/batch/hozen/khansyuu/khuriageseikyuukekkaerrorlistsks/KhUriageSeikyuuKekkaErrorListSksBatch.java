package yuyu.batch.hozen.khansyuu.khuriageseikyuukekkaerrorlistsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khuriageseikyuukekkaerrorlistsks.dba.KhUriageSeikyuuKekkaErrorListSksDao;
import yuyu.batch.hozen.khansyuu.khuriageseikyuukekkaerrorlistsks.dba.UriageSeikyuuKekkaErrorListSksTaisyouBean;
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
import yuyu.def.db.entity.IT_UriageSeikyuuKkErrorList;
import yuyu.def.hozen.bean.report.KhUriageSeikyuuKekkaErrorListBean;
import yuyu.def.hozen.bean.report.KhUriageSeikyuuKekkaErrorListDataSourceBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 案内収納 売上請求結果エラーリスト作成
 */
public class KhUriageSeikyuuKekkaErrorListSksBatch implements Batch {

    private static final String TABLEID = IT_UriageSeikyuuKkErrorList.TABLE_NAME;

    private static final String FILTERID = "Bz001";

    private  static final String TANTOSITUCD = C_Tantositucd.SYUUNOUSV.getValue() + "0000";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KhUriageSeikyuuKekkaErrorListSksDao khUriageSeikyuuKekkaErrorListSksDao;

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
            String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobcd));

        int syoriKensuu= 0;
        String tantosituNm = "";

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(TANTOSITUCD);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {
            tantosituNm = bzGetSosikiDataBean.getKanjisosikinm20();
        }

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();


        try (ExDBResults<UriageSeikyuuKekkaErrorListSksTaisyouBean> sksTaisyouBeansLst =
            khUriageSeikyuuKekkaErrorListSksDao.getUriageSeikyuuKekkaErrorListSksTaisyouBeans(ibKakutyoujobcd, syoriYmd);) {

            for (UriageSeikyuuKekkaErrorListSksTaisyouBean sksTaisyouBean : sksTaisyouBeansLst) {
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(sksTaisyouBean.getSyono());

                AS_Kinou kinouTbl = baseDomManager.getKinou(sksTaisyouBean.getKinouId());
                String kinouNm = kinouTbl.getKinouNm();

                KhUriageSeikyuuKekkaErrorListDataSourceBean dataSourceBean = SWAKInjector.getInstance(
                    KhUriageSeikyuuKekkaErrorListDataSourceBean.class);

                dataSourceBean.setIrSyono(sksTaisyouBean.getSyono());
                dataSourceBean.setIrCreditkessaiyouno(sksTaisyouBean.getCreditkessaiyouno());
                dataSourceBean.setIrUriageymd(sksTaisyouBean.getUriagenengappi());
                dataSourceBean.setIrCredituriagegk(sksTaisyouBean.getCredituriagegk());
                dataSourceBean.setIrCredituriagengjiyuu(sksTaisyouBean.getCredituriagengjiyuu());
                dataSourceBean.setIrErrorcd(sksTaisyouBean.getUriageseikyuuerrorcd());
                dataSourceBean.setIrAuthorikbn(sksTaisyouBean.getAuthorikbn());
                dataSourceBean.setIrKinounm(kinouNm);
                dataSourceBean.setIrCredituriageseikyuukbn(sksTaisyouBean.getCredituriageseikyuukbn());

                iReportDataSouceBeanLst.add(dataSourceBean);

                syoriKensuu = syoriKensuu + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        if (syoriKensuu > 0) {
            KhUriageSeikyuuKekkaErrorListBean uriageSeikyuuKekkaErrorListBean = SWAKInjector.getInstance(
                KhUriageSeikyuuKekkaErrorListBean.class);

            uriageSeikyuuKekkaErrorListBean.setIrTantousitunm(tantosituNm);
            uriageSeikyuuKekkaErrorListBean.setIrSyoribi(syoriYmd);
            uriageSeikyuuKekkaErrorListBean.setIrKensuu(syoriKensuu);

            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(),
                kinou.getCategoryId(),
                kinou.getKinouId(),
                C_SyoruiCdKbn.AS_URIAGESEIKYUUKEKKA_ERRORLIST);

            reportServicesBean.addParamObjects(iReportDataSouceBeanLst, uriageSeikyuuKekkaErrorListBean, syoriYmd);

            createReport.execNoCommit(reportServicesBean);
        }

        khUriageSeikyuuKekkaErrorListSksDao.deleteUriageSeikyuuKekkaErrorList(syoriYmd);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}

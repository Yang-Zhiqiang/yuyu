package yuyu.batch.hozen.khansyuu.khyuukoukakuninerrorlistsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khyuukoukakuninerrorlistsks.dba.KhYuukouKakuninErrorListSksDao;
import yuyu.batch.hozen.khansyuu.khyuukoukakuninerrorlistsks.dba.YuukouKakErrorListBean;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_YuukouKakErrorList;
import yuyu.def.hozen.bean.report.KhYuukouKakuninErrorListBean;
import yuyu.def.hozen.bean.report.KhYuukouKakuninErrorListDataSourceBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 案内収納 有効確認エラーリスト作成
 */
public class KhYuukouKakuninErrorListSksBatch implements Batch {

    private static final String TABLEID = IT_YuukouKakErrorList.TABLE_NAME;

    private static final String FILTERID = "Bz001";

    private static final String SAKUSEI_SOSIKICD = C_Tantositucd.SYUUNOUSV + "0000";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhYuukouKakuninErrorListSksDao khYuukouKakuninErrorListSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        Integer syoriKensuu = 0;
        List<IReportDataSouceBean> KhYuukouKakuninErrorListDsLst = new ArrayList<IReportDataSouceBean>();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), bzBatchParam.getIbKakutyoujobcd()));

        try (ExDBResults<YuukouKakErrorListBean> khyuukoukakuninerrorlist =
            khYuukouKakuninErrorListSksDao.getYuukouKakErrorListBeans(bzBatchParam.getIbKakutyoujobcd(),
                bzBatchParam.getSyoriYmd().getBizDateYM());) {
            for (YuukouKakErrorListBean yuukouKakErrorListBean : khyuukoukakuninerrorlist) {
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(yuukouKakErrorListBean.getSyono());

                KhYuukouKakuninErrorListDataSourceBean dataSourceBean = SWAKInjector.
                    getInstance(KhYuukouKakuninErrorListDataSourceBean.class);

                dataSourceBean.setIrSyono(yuukouKakErrorListBean.getSyono());
                dataSourceBean.setIrCreditkessaiyouno(yuukouKakErrorListBean.getCreditkessaiyouno());
                dataSourceBean.setIrCredityuukoukakym(String.valueOf(yuukouKakErrorListBean.getCredityuukoukakym()));
                dataSourceBean.setIrCredityuukoukakkekka(yuukouKakErrorListBean.getCredityuukoukakkekka());

                KhYuukouKakuninErrorListDsLst.add(dataSourceBean);

                syoriKensuu = syoriKensuu + 1;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        if (KhYuukouKakuninErrorListDsLst.size() > 0) {
            String krkLstSakuseiSosikiNm;
            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            BzGetSosikiDataBean sakuseiSosikiDataBean = bzGetSosikiData.exec(SAKUSEI_SOSIKICD);

            if (C_SosikimasterUmuKbn.ARI.eq(sakuseiSosikiDataBean.getSosikimasterumukbn())) {

                krkLstSakuseiSosikiNm = sakuseiSosikiDataBean.getKanjisosikinm20();
            }
            else {

                krkLstSakuseiSosikiNm = "";
            }

            KhYuukouKakuninErrorListBean khYuukouKakuninErrorListBean = SWAKInjector.
                getInstance(KhYuukouKakuninErrorListBean.class);

            khYuukouKakuninErrorListBean.setIrSakuseisosiki(krkLstSakuseiSosikiNm);
            khYuukouKakuninErrorListBean.setIrTyouhyousakuseiymd(String.valueOf(bzBatchParam.getSyoriYmd()));
            khYuukouKakuninErrorListBean.setIrKensuu(KhYuukouKakuninErrorListDsLst.size());

            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(),
                kinou.getCategoryId(),
                kinou.getKinouId(),
                C_SyoruiCdKbn.AS_YUUKOUKAKUNIN_ERRORLIST);

            reportServicesBean.addParamObjects(KhYuukouKakuninErrorListDsLst, khYuukouKakuninErrorListBean);
            reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

            createReport.execNoCommit(reportServicesBean);
        }

        khYuukouKakuninErrorListSksDao.deleteYuukouKakErrorList(bzBatchParam.getSyoriYmd().getBizDateYM());

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}

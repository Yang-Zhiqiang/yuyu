package yuyu.batch.hozen.khkessan.khzennoumkkpkssamplelistsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khkessan.khzennoumkkpkssamplelistsks.dba.KhZennouMkkPKsSampleListSksDao;
import yuyu.batch.hozen.khkessan.khzennoumkkpkssamplelistsks.dba.ZennouMkkPKsSampleListInfoBean;
import yuyu.batch.hozen.khkessan.khzennoumkkpkssamplelistsks.dba.ZennouMkkPKsSampleListPtnInfoBean;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.hozen.bean.report.KhZennouMkkPKsSampleListBean;
import yuyu.def.hozen.bean.report.KhZennouMkkPKsSampleListDataSourceBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 決算 前納未経過Ｐ検証サンプルリスト作成
 */
public class KhZennouMkkPKsSampleListSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KhZennouMkkPKsSampleListSksDao khZennouMkkPKsSampleListSksDao;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), bzBatchParam.getIbKakutyoujobcd()));

        long syoriCount = 0;

        List<IReportDataSouceBean> ireportDataSouceBeanLst = new ArrayList<>();
        List<ZennouMkkPKsSampleListPtnInfoBean> zennouMkkPKsSampleListPtnInfoBeanLst =
            khZennouMkkPKsSampleListSksDao.getZennouMkkPKsSampleListPtnInfoBeans();

        for (ZennouMkkPKsSampleListPtnInfoBean zennouMkkPKsSampleListPtnInfoBean : zennouMkkPKsSampleListPtnInfoBeanLst) {

            List<ZennouMkkPKsSampleListInfoBean> zennouMkkPKsSampleListInfoBeanL = khZennouMkkPKsSampleListSksDao.getZennouMkkPKsSampleListInfoBeans(
                bzBatchParam.getSyoriYmd(),
                zennouMkkPKsSampleListPtnInfoBean.getZennoutoukeilistkbn(),
                zennouMkkPKsSampleListPtnInfoBean.getZennoukbn(),
                zennouMkkPKsSampleListPtnInfoBean.getKbnkeirisegcd());

            for (ZennouMkkPKsSampleListInfoBean zennouMkkPKsSampleListInfoBean : zennouMkkPKsSampleListInfoBeanL) {

                KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDataSourceBean =
                    SWAKInjector.getInstance(KhZennouMkkPKsSampleListDataSourceBean.class);

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

                BizCurrency zennoukaisijizndk = BizCurrency.valueOf(0);
                BizCurrency tndmatutkyzndk = BizCurrency.valueOf(0);
                BizCurrency zennoukaisizndkgaika = BizCurrency.valueOf(0);
                BizCurrency tndmatutkyzndkgaika = BizCurrency.valueOf(0);

                C_Tuukasyu calctuukaSyu =  henkanTuuka.henkanTuukaTypeToKbn(
                    zennouMkkPKsSampleListInfoBean.getZennoukaisijizndk().getType());

                if (C_Tuukasyu.JPY.eq(calctuukaSyu)) {

                    zennoukaisijizndk = zennouMkkPKsSampleListInfoBean.getZennoukaisijizndk();
                    tndmatutkyzndk = zennouMkkPKsSampleListInfoBean.getTndmatuzndk();
                    zennoukaisizndkgaika = BizCurrency.valueOf(0);
                    tndmatutkyzndkgaika = BizCurrency.valueOf(0);

                }
                else {
                    zennoukaisijizndk = zennouMkkPKsSampleListInfoBean.getZennoukaisijizndktkmatu();
                    tndmatutkyzndk = zennouMkkPKsSampleListInfoBean.getTndmatuzndktkmatu();
                    zennoukaisizndkgaika = zennouMkkPKsSampleListInfoBean.getZennoukaisijizndk();
                    tndmatutkyzndkgaika = zennouMkkPKsSampleListInfoBean.getTndmatuzndk();
                }

                khZennouMkkPKsSampleListDataSourceBean.setIrZnnmkkpkssamplekslsttitle(
                    zennouMkkPKsSampleListPtnInfoBean.getZnnmkkpkssamplekslsttitle());
                khZennouMkkPKsSampleListDataSourceBean.setIrSyono(zennouMkkPKsSampleListInfoBean.getSyono());
                khZennouMkkPKsSampleListDataSourceBean.setIrZennoutoukeilistkbn(
                    zennouMkkPKsSampleListInfoBean.getZennoutoukeilistkbn().getValue());
                khZennouMkkPKsSampleListDataSourceBean.setIrZennoukbn(zennouMkkPKsSampleListInfoBean.getZennoukbn().getValue());
                khZennouMkkPKsSampleListDataSourceBean.setIrKbnkeirisegcd(
                    zennouMkkPKsSampleListInfoBean.getKbnkeirisegcd().getValue());
                khZennouMkkPKsSampleListDataSourceBean.setIrZennoukaisiym(
                    zennouMkkPKsSampleListInfoBean.getZennoustartym());
                khZennouMkkPKsSampleListDataSourceBean.setIrKeiyakuymd8keta(
                    zennouMkkPKsSampleListInfoBean.getKeiyakuymd());
                khZennouMkkPKsSampleListDataSourceBean.setIrZennounyuukinymd(
                    zennouMkkPKsSampleListInfoBean.getZennounyuukinymd());
                khZennouMkkPKsSampleListDataSourceBean.setIrZennouwrbkrt(
                    zennouMkkPKsSampleListInfoBean.getZennouwrbkrt());
                khZennouMkkPKsSampleListDataSourceBean.setIrZennoukaisizndk(zennoukaisijizndk);
                khZennouMkkPKsSampleListDataSourceBean.setIrTndmatutkyrt(
                    zennouMkkPKsSampleListInfoBean.getTndmatutkyrt());
                khZennouMkkPKsSampleListDataSourceBean.setIrTndmatutkyzndk(tndmatutkyzndk);
                khZennouMkkPKsSampleListDataSourceBean.setIrZennoukaisizndkgaika(zennoukaisizndkgaika);
                khZennouMkkPKsSampleListDataSourceBean.setIrTndmatutkyzndkgaika(tndmatutkyzndkgaika);
                ireportDataSouceBeanLst.add(khZennouMkkPKsSampleListDataSourceBean);
                syoriCount = syoriCount + 1;
            }
        }

        if (syoriCount == 0) {
            KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDataSourceBean =
                SWAKInjector.getInstance(KhZennouMkkPKsSampleListDataSourceBean.class);
            khZennouMkkPKsSampleListDataSourceBean.setIrZnnmkkpkssamplekslsttitle(
                zennouMkkPKsSampleListPtnInfoBeanLst.get(0).getZnnmkkpkssamplekslsttitle());
            khZennouMkkPKsSampleListDataSourceBean.setIrSyono("");
            khZennouMkkPKsSampleListDataSourceBean.setIrZennoutoukeilistkbn("");
            khZennouMkkPKsSampleListDataSourceBean.setIrZennoukbn("");
            khZennouMkkPKsSampleListDataSourceBean.setIrKbnkeirisegcd("");
            khZennouMkkPKsSampleListDataSourceBean.setIrZennoukaisiym(null);
            khZennouMkkPKsSampleListDataSourceBean.setIrKeiyakuymd8keta(null);
            khZennouMkkPKsSampleListDataSourceBean.setIrZennounyuukinymd(null);
            khZennouMkkPKsSampleListDataSourceBean.setIrZennouwrbkrt(BizNumber.ZERO);
            khZennouMkkPKsSampleListDataSourceBean.setIrZennoukaisizndk(BizCurrency.valueOf(0));
            khZennouMkkPKsSampleListDataSourceBean.setIrTndmatutkyrt(BizNumber.ZERO);
            khZennouMkkPKsSampleListDataSourceBean.setIrTndmatutkyzndk(BizCurrency.valueOf(0));
            khZennouMkkPKsSampleListDataSourceBean.setIrZennoukaisizndkgaika(BizCurrency.valueOf(0));
            khZennouMkkPKsSampleListDataSourceBean.setIrTndmatutkyzndkgaika(BizCurrency.valueOf(0));
            ireportDataSouceBeanLst.add(khZennouMkkPKsSampleListDataSourceBean);
        }

        KhZennouMkkPKsSampleListBean khZennouMkkPKsSampleListBean =
            SWAKInjector.getInstance(KhZennouMkkPKsSampleListBean.class);
        khZennouMkkPKsSampleListBean.setIrSakuseiymd(bzBatchParam.getSyoriYmd().toString());

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesGengkBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            C_SyoruiCdKbn.AS_ZENNOUMKKPKSSAMPLELIST);

        reportServicesGengkBean.addParamObjects(ireportDataSouceBeanLst, khZennouMkkPKsSampleListBean);
        reportServicesGengkBean.setSyoriYmd(bzBatchParam.getSyoriYmd());
        createReport.execNoCommit(reportServicesGengkBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCount)));
    }
}

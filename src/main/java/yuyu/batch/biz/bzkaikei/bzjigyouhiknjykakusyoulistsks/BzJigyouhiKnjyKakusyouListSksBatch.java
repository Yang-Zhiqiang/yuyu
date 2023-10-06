package yuyu.batch.biz.bzkaikei.bzjigyouhiknjykakusyoulistsks;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.report.BzJigyouhiKnjyKakusyouListBean;
import yuyu.def.biz.bean.report.BzJigyouhiKnjyKakusyouListDataSourceBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.BT_HuriDenpyou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 事業費勘定確証リスト作成のバッチクラスです。</br>
 *
 */
public class BzJigyouhiKnjyKakusyouListSksBatch implements Batch {

    private static final String SIHARAI_GYOUMUSITU_CD = "564";

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BzJigyouhiKnjyKakusyouListSksDao jigyouhiListDao;

    @Inject
    private CreateReport createReport;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private static Logger logger;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003),String.valueOf(bzBatchParam.getSyoriYmd())));

        List<BT_HuriDenpyou> denpyouLst = jigyouhiListDao.getJigyouhiHuriDenpyouBySyoriYmd(bzBatchParam.getSyoriYmd());

        if (denpyouLst.isEmpty()) {
            logger.debug("処理対象の事業費が存在しないため、処理を終了します。");
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, "0"));
            return;
        }

        int syoriKensu = 0;
        List<BzJigyouhiKnjyKakusyouListDataSourceBean> jigyouhiDsBeanList = Lists.newArrayList();

        for (BT_HuriDenpyou denpyou : denpyouLst) {

            BzJigyouhiKnjyKakusyouListDataSourceBean dsBean =
                getDataSourceBean(jigyouhiDsBeanList, denpyou.getTorihikino(), denpyou.getJigyouhiutiwakecd(), denpyou.getTaisyakukbn());

            if (dsBean == null) {
                jigyouhiDsBeanList.add(createDataSourceBean(denpyou));
            }
            else {
                BizCurrency sum = dsBean.getIrJigyouhikingaku().add(denpyou.getDenyenkagk());
                dsBean.setIrJigyouhikingaku(sum);
            }
            syoriKensu++;
        }

        TantousituPredicate predicate = new TantousituPredicate(SIHARAI_GYOUMUSITU_CD);

        List<BzJigyouhiKnjyKakusyouListDataSourceBean> siharaiGyoumusituList = ImmutableList.copyOf(Iterables.filter(jigyouhiDsBeanList, predicate));

        createReport(C_SyoruiCdKbn.BZ_JIGYOUHIKANJYOUKAKUSYOULIST_1, siharaiGyoumusituList);

        logger.debug(String.format("支払業務室 処理件数：%d件", siharaiGyoumusituList.size()));

        Iterables.removeIf(jigyouhiDsBeanList, predicate);

        List<BzJigyouhiKnjyKakusyouListDataSourceBean> hozenSiharaiServiceList = Lists.newArrayList(jigyouhiDsBeanList);

        createReport(C_SyoruiCdKbn.BZ_JIGYOUHIKANJYOUKAKUSYOULIST_2, hozenSiharaiServiceList);

        logger.debug(String.format("保全支払サービス室 処理件数：%d件", hozenSiharaiServiceList.size()));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensu)));
    }

    private BzJigyouhiKnjyKakusyouListDataSourceBean getDataSourceBean(List<BzJigyouhiKnjyKakusyouListDataSourceBean> pDsBeanList, String pTorihikiNo, String pJigyouhiUtiwakeCd, C_TaisyakuKbn pTaisyakuKbn) {

        for (BzJigyouhiKnjyKakusyouListDataSourceBean dsBean : pDsBeanList) {

            if (dsBean.getIrTorihikino().equals(pTorihikiNo) &&
                dsBean.getIrTaisyakukbn().eq(pTaisyakuKbn) &&
                dsBean.getIrJigyouhiutiwakecd().equals(pJigyouhiUtiwakeCd)) {
                return dsBean;
            }
        }
        return null;
    }

    private BzJigyouhiKnjyKakusyouListDataSourceBean createDataSourceBean(BT_HuriDenpyou pDenpyou) {

        BzJigyouhiKnjyKakusyouListDataSourceBean dsBean = SWAKInjector.getInstance(BzJigyouhiKnjyKakusyouListDataSourceBean.class);

        String atesakikaCd;

        if (pDenpyou.getTantocd() == null || pDenpyou.getTantocd().eq(C_TantouCdKbn.BLNK0)) {
            atesakikaCd = pDenpyou.getHuridenatesakicd();
        }
        else {
            BM_TantouCd tantouCd = bizDomManager.getTantouCd(pDenpyou.getTantocd());
            atesakikaCd = tantouCd.getBusitucd();
        }

        AM_Sosiki sosiki = baseDomManager.getSosiki(atesakikaCd + "0000");

        String atesakiBukaNm = sosiki.getKanjisosikinm20();

        dsBean.setIrAtesakikacd(atesakikaCd);
        dsBean.setIrAtesakibukanm(atesakiBukaNm);
        dsBean.setIrTorihikiymd(pDenpyou.getDenymd());
        dsBean.setIrTorihikino(pDenpyou.getTorihikino());
        dsBean.setIrTaisyakukbn(pDenpyou.getTaisyakukbn());
        dsBean.setIrKanjihimokunm(pDenpyou.getJigyouhiutiwakenm());
        dsBean.setIrJigyouhiutiwakecd(pDenpyou.getJigyouhiutiwakecd());
        dsBean.setIrJigyouhikingaku(pDenpyou.getDenyenkagk());

        return dsBean;
    }

    private void createReport(C_SyoruiCdKbn pSyoruiCdKbn, List<BzJigyouhiKnjyKakusyouListDataSourceBean> pBeanList) {

        if (pBeanList.isEmpty()) {
            return;
        }

        BzJigyouhiKnjyKakusyouListBean bean = SWAKInjector.getInstance(BzJigyouhiKnjyKakusyouListBean.class);

        bean.setIrJigyouhilistsakuseiymd(bzBatchParam.getSyoriYmd());

        ReportServicesBean reportServicesBean =
            createReport.createNewReportServiceBean(kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(), pSyoruiCdKbn);

        reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

        List<IReportDataSouceBean> reportBeanList = Arrays.asList(Iterables.toArray(pBeanList, IReportDataSouceBean.class));

        reportServicesBean.addParamObjects(reportBeanList, bean);

        createReport.exec(reportServicesBean);
    }
}
package yuyu.batch.biz.bzkaikei.bzsikinidoulistsksendthnk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistsksendthnk.dba.BzSikinIdouListSksEndtHnkDao;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistsksendthnk.dba.EndtHnkSikinIdouListSksBySyoriYmdBean;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.kaikei.BzSikinIdouListCsvFSksTblTrk;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.report.BzSikinIdouListYendthnkbunBean;
import yuyu.def.biz.bean.report.BzSikinIdouListYendthnkbunDataSourceBean;
import yuyu.def.classification.C_KeiriyendthnkKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Ordering;

/**
 * 業務共通 経理・会計 資金移動リスト作成(円建変更)
 */
public class BzSikinIdouListSksEndtHnkBatch implements Batch {

    private static final String YENDTHNKTORIKESI = "取消分";

    private static final String SIKINIDOUKBNYENDTHNKTORIKESI = "円建変更取消分";

    private static final String TYUUKIMSG = "円建変更取消が発生した場合は、取引通貨額を円本口座から外貨本口座へ資金移動";

    @Inject
    private BzSikinIdouListSksEndtHnkDao bzSikinIdouListSksEndtHnkDao;

    @Inject
    private CreateReport createReport;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        try(ExDBResults<EndtHnkSikinIdouListSksBySyoriYmdBean> endtHnkSikinIdouLst =
            bzSikinIdouListSksEndtHnkDao.getEndtHnkSikinIdouListSksBySyoriYmd(syoriYmd)) {

            List<BzSikinIdouListYendthnkbunDataSourceBean> bzSikinIdouLst = new ArrayList<>();
            int count = 0;
            String sikinidoukbnnm = null;
            String tyuukimsg = null;
            String yendthnkkbnNm = null;

            for (EndtHnkSikinIdouListSksBySyoriYmdBean endtHnkSikinIdou : endtHnkSikinIdouLst) {

                if (C_KeiriyendthnkKbn.TORIKESI.eq(endtHnkSikinIdou.getKeiriyendthnkkbn())) {

                    sikinidoukbnnm = SIKINIDOUKBNYENDTHNKTORIKESI;
                    tyuukimsg = TYUUKIMSG;
                    yendthnkkbnNm = YENDTHNKTORIKESI;
                }
                else {
                    sikinidoukbnnm = "";
                    tyuukimsg = "";
                    yendthnkkbnNm = "";
                }

                BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdou =
                    SWAKInjector.getInstance(BzSikinIdouListYendthnkbunDataSourceBean.class);

                bzSikinIdou.setIrKeirisikinidougroupno(endtHnkSikinIdou.getSikinidougroupkbn());
                bzSikinIdou.setIrSikinidoukbnnm(sikinidoukbnnm);
                bzSikinIdou.setIrKeirisiteituukasyu(endtHnkSikinIdou.getSiteituuka());
                bzSikinIdou.setIrSeg1cd(endtHnkSikinIdou.getKbnkeirisegcd());
                bzSikinIdou.setIrKeirisiteituukagkgaika(endtHnkSikinIdou.getSiteituukagk());
                bzSikinIdou.setIrKeiritrhktuukasyu(endtHnkSikinIdou.getTrhktuuka());
                bzSikinIdou.setIrKeiritrhktuukagk(endtHnkSikinIdou.getTrhktuukagk());
                bzSikinIdou.setIrKeiriyendthnkkbnnm(yendthnkkbnNm);
                bzSikinIdou.setIrSikinidoulisttyuukimsg(tyuukimsg);

                bzSikinIdouLst.add(bzSikinIdou);

                count++;
            }

            BzSikinIdouListYendthnkbunDataSourceBeanSortComparator bzSikinIdouListYendthnkbunDataSourceBeanSortComparator =
                SWAKInjector.getInstance(BzSikinIdouListYendthnkbunDataSourceBeanSortComparator.class);

            Ordering<BzSikinIdouListYendthnkbunDataSourceBean> bzSikinIdouListYendthnkbunDataSourceBean =
                Ordering.from(bzSikinIdouListYendthnkbunDataSourceBeanSortComparator);

            bzSikinIdouLst = bzSikinIdouListYendthnkbunDataSourceBean.sortedCopy(bzSikinIdouLst);

            List<IReportDataSouceBean> iReportSokuzibunLst = calcGkGoukei(bzSikinIdouLst);

            if (iReportSokuzibunLst.size() > 0) {

                BzSikinIdouListYendthnkbunBean bzSikinIdou = SWAKInjector.getInstance(BzSikinIdouListYendthnkbunBean.class);

                bzSikinIdou.setIrSyoribiwareki(DateFormatUtil.dateKANJI(syoriYmd));

                ReportServicesBean reportServicesBean =
                    createReport.createNewReportServiceBean(kinou.getSubSystemId(), kinou.getCategoryId(),
                        kinou.getKinouId(), C_SyoruiCdKbn.CM_SIKINIDOULIST_YENDTHNK);

                reportServicesBean.setSyoriYmd(syoriYmd);

                reportServicesBean.addParamObjects(iReportSokuzibunLst, bzSikinIdou);

                createReport.exec(reportServicesBean);

                BzSikinIdouListCsvFSksTblTrk bzSikinIdouListCsvFSksTblTrk = SWAKInjector.getInstance(BzSikinIdouListCsvFSksTblTrk.class);

                bzSikinIdouListCsvFSksTblTrk.exec(syoriYmd, iReportSokuzibunLst);
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
        }
    }

    private List<IReportDataSouceBean> calcGkGoukei(
        List<BzSikinIdouListYendthnkbunDataSourceBean> pBzSikinIdouLst) {

        BizCurrency siteituukaGoukeiGk = BizCurrency.valueOf(0);
        BizCurrency trhktuukaGoukeiGk = BizCurrency.valueOf(0);
        C_SikinidougroupKbn sikinIdouGroupKbnBefore = null;
        C_Tuukasyu siteituukaBefore = null;
        String sikinIdouKbnNmBefore = null;
        List<IReportDataSouceBean> ireportDataSouceBeanLst = new ArrayList<>();

        for (BzSikinIdouListYendthnkbunDataSourceBean sikinIdouListYendthnkbunDataSourceBean : pBzSikinIdouLst) {

            if (sikinIdouGroupKbnBefore == null && siteituukaBefore == null && sikinIdouKbnNmBefore == null) {

                trhktuukaGoukeiGk = BizCurrency.valueOf(0);
                siteituukaGoukeiGk = BizCurrency.valueOf(0, sikinIdouListYendthnkbunDataSourceBean.getIrKeirisiteituukagkgaika().getType());
            }
            else {

                if (!sikinIdouListYendthnkbunDataSourceBean.getIrKeirisikinidougroupno().eq(sikinIdouGroupKbnBefore)
                    || !sikinIdouListYendthnkbunDataSourceBean.getIrKeirisiteituukasyu().eq(siteituukaBefore)
                    || !sikinIdouListYendthnkbunDataSourceBean.getIrSikinidoukbnnm().equals(sikinIdouKbnNmBefore)) {

                    BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBeanLast =
                        (BzSikinIdouListYendthnkbunDataSourceBean)ireportDataSouceBeanLst.get(ireportDataSouceBeanLst.size() - 1);
                    bzSikinIdouListYendthnkbunDataSourceBeanLast.setTrhktuukagoukeigk(trhktuukaGoukeiGk);
                    bzSikinIdouListYendthnkbunDataSourceBeanLast.setSiteituukagoukeigk(siteituukaGoukeiGk);

                    trhktuukaGoukeiGk = BizCurrency.valueOf(0);
                    siteituukaGoukeiGk = BizCurrency.valueOf(0, sikinIdouListYendthnkbunDataSourceBean.getIrKeirisiteituukagkgaika().getType());
                }
            }

            trhktuukaGoukeiGk = trhktuukaGoukeiGk.add(sikinIdouListYendthnkbunDataSourceBean.getIrKeiritrhktuukagk());
            siteituukaGoukeiGk = siteituukaGoukeiGk.add(sikinIdouListYendthnkbunDataSourceBean.getIrKeirisiteituukagkgaika());

            sikinIdouGroupKbnBefore = sikinIdouListYendthnkbunDataSourceBean.getIrKeirisikinidougroupno();
            siteituukaBefore = sikinIdouListYendthnkbunDataSourceBean.getIrKeirisiteituukasyu();
            sikinIdouKbnNmBefore = sikinIdouListYendthnkbunDataSourceBean.getIrSikinidoukbnnm();

            ireportDataSouceBeanLst.add(sikinIdouListYendthnkbunDataSourceBean);
        }

        if (ireportDataSouceBeanLst.size() > 0) {

            BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBeanLast =
                (BzSikinIdouListYendthnkbunDataSourceBean)ireportDataSouceBeanLst.get(ireportDataSouceBeanLst.size() - 1);

            bzSikinIdouListYendthnkbunDataSourceBeanLast.setTrhktuukagoukeigk(trhktuukaGoukeiGk);
            bzSikinIdouListYendthnkbunDataSourceBeanLast.setSiteituukagoukeigk(siteituukaGoukeiGk);
        }

        return ireportDataSouceBeanLst;
    }
}
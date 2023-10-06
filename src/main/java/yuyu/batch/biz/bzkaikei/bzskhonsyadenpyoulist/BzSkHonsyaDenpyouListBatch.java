package yuyu.batch.biz.bzkaikei.bzskhonsyadenpyoulist;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.report.BzSkHonsyaDenpyouListBean;
import yuyu.def.biz.bean.report.BzSkHonsyaDenpyouListDataSourceBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.bean.BzSkHonsyaDenpyousByDenymdTaisyakukbnBean;
import yuyu.def.classification.C_SkDenlistsksKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 業務共通 経理・会計 新契約本社用伝票リスト作成
 */
public class BzSkHonsyaDenpyouListBatch implements Batch{

    private final String GETUMATUSHIME = "RGAIM000";

    @Inject
    private BizDomManager bizDomManager;

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

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        BizDate denpyouDateFrom = null;
        BizDate denpyouDateTo = null;
        C_SkDenlistsksKbn skDenlistsksKbn = C_SkDenlistsksKbn.BLNK;
        int maxCount = 0;
        int count = 0;
        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        if (GETUMATUSHIME.equals(bzBatchParam.getIbKakutyoujobcd())) {

            denpyouDateFrom = bzBatchParam.getSyoriYmd().getBizDateYM().getFirstDay();
            denpyouDateTo = bzBatchParam.getSyoriYmd().getBizDateYM().getLastDay();
            skDenlistsksKbn = C_SkDenlistsksKbn.GETUMATUSIME;
        }
        else {

            denpyouDateFrom = bzBatchParam.getSyoriYmd().getBizDateYM().getPreviousMonth().getFirstDay();
            denpyouDateTo = bzBatchParam.getSyoriYmd().getBizDateYM().getPreviousMonth().getLastDay();
            skDenlistsksKbn = C_SkDenlistsksKbn.DENPYOUSIME;
        }

        List<BzSkHonsyaDenpyousByDenymdTaisyakukbnBean> bzSkHonsyaDenpyousKarikataBeanLst =
            bizDomManager.getBzSkHonsyaDenpyousByDenymdTaisyakukbn(denpyouDateFrom,
                denpyouDateTo, C_TaisyakuKbn.KARIKATA);

        List<BzSkHonsyaDenpyousByDenymdTaisyakukbnBean> bzSkHonsyaDenpyousKasikataBeanLst =
            bizDomManager.getBzSkHonsyaDenpyousByDenymdTaisyakukbn(denpyouDateFrom,
                denpyouDateTo, C_TaisyakuKbn.KASIKATA);

        if (bzSkHonsyaDenpyousKarikataBeanLst.size() >= bzSkHonsyaDenpyousKasikataBeanLst.size()) {

            maxCount = bzSkHonsyaDenpyousKarikataBeanLst.size();
        }
        else {

            maxCount = bzSkHonsyaDenpyousKasikataBeanLst.size();
        }
        while (count < maxCount) {

            BzSkHonsyaDenpyouListDataSourceBean bzSkHonsyaDenpyouListBean =
                SWAKInjector.getInstance(BzSkHonsyaDenpyouListDataSourceBean.class);

            if (bzSkHonsyaDenpyousKarikataBeanLst.size() > count) {

                bzSkHonsyaDenpyouListBean.setIrKanjyoukmkcdkari(
                    bzSkHonsyaDenpyousKarikataBeanLst.get(count).getKanjyoukmkcd().getValue());
                bzSkHonsyaDenpyouListBean.setIrKarikanjyoukmknm(
                    bzSkHonsyaDenpyousKarikataBeanLst.get(count).getKanjyoukmknm());
                bzSkHonsyaDenpyouListBean.setIrDengkkari(
                    bzSkHonsyaDenpyousKarikataBeanLst.get(count).getDenyenkagkSum());
                bzSkHonsyaDenpyouListBean.setIrKensuukari(
                    BizNumber.valueOf(bzSkHonsyaDenpyousKarikataBeanLst.get(count).getDenyenkagkCount()));
            }

            if (bzSkHonsyaDenpyousKasikataBeanLst.size() > count) {

                bzSkHonsyaDenpyouListBean.setIrKanjyoukmkcdkasi(
                    bzSkHonsyaDenpyousKasikataBeanLst.get(count).getKanjyoukmkcd().getValue());
                bzSkHonsyaDenpyouListBean.setIrKasikanjyoukmknm(
                    bzSkHonsyaDenpyousKasikataBeanLst.get(count).getKanjyoukmknm());
                bzSkHonsyaDenpyouListBean.setIrDengkkasi(
                    bzSkHonsyaDenpyousKasikataBeanLst.get(count).getDenyenkagkSum());
                bzSkHonsyaDenpyouListBean.setIrKensuukasi(
                    BizNumber.valueOf(bzSkHonsyaDenpyousKasikataBeanLst.get(count).getDenyenkagkCount()));
            }

            iReportDataSouceBeanLst.add(bzSkHonsyaDenpyouListBean);

            count++;
        }

        if (iReportDataSouceBeanLst.size() > 0) {

            BzSkHonsyaDenpyouListBean bzSkHonsyaDenpyouListBean =
                SWAKInjector.getInstance(BzSkHonsyaDenpyouListBean.class);

            bzSkHonsyaDenpyouListBean.setIrSyoriymd(DateFormatUtil.dateKANJISeirekiNoZero(bzBatchParam.getSyoriYmd()));
            bzSkHonsyaDenpyouListBean.setIrSuitouym(DateFormatUtil.dateYmKANJI(denpyouDateFrom.getBizDateYM()));
            bzSkHonsyaDenpyouListBean.setIrDenlistskskbn(skDenlistsksKbn);

            ReportServicesBean reportServicesBean =
                createReport.createNewReportServiceBean(kinou.getSubSystemId(), kinou.getCategoryId(),
                    kinou.getKinouId(),C_SyoruiCdKbn.CM_SKHONSYADENPYOULIST);

            reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

            reportServicesBean.addParamObjects(iReportDataSouceBeanLst, bzSkHonsyaDenpyouListBean);

            createReport.exec(reportServicesBean);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }
}

package yuyu.batch.biz.bzkaikei.bzsikinidoulistskshtkin;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistskshtkin.dba.BzSikinIdouListSksHtkinDao;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistskshtkin.dba.HtkinSikinIdouListSksWkAllkmBean;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistskshtkin.dba.HtkinSikinIdouListSksWkBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.kaikei.BzSikinIdouListCsvFSksTblTrk;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.report.BzSikinIdouListHtkinBean;
import yuyu.def.biz.bean.report.BzSikinIdouListHtkinDataSourceBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_HtkinSikinIdouListSksRk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 業務共通 経理・会計 資金移動リスト作成(配当金)クラス
 */
public class BzSikinIdouListSksHtkinBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    BzSikinIdouListSksHtkinDao bzSikinIdouListSksHtkinDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private CreateReport createReport;

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

        try (
            ExDBResults<HtkinSikinIdouListSksWkBean> htkinSikinIdouListSksWkBeanList = bzSikinIdouListSksHtkinDao
            .getAllHtkinSikinIdouListSksWkBeans();

            ExDBResults<HtkinSikinIdouListSksWkAllkmBean> htkinSikinIdouListSksWkAllkmBeanList = bzSikinIdouListSksHtkinDao
                .getAllHtkinSikinIdouListSksWkAllkmBeans();

            EntityInserter<BT_HtkinSikinIdouListSksRk> htkinSikinIdouListSksRkInserter = new EntityInserter<>();) {

            List<IReportDataSouceBean> bzSikinIdouListHtkinDataSourceBeanList = new ArrayList<>();

            long syorikensuu = 0;

            for (HtkinSikinIdouListSksWkBean htkinSikinIdouListSksWkBean : htkinSikinIdouListSksWkBeanList) {

                BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean =
                    new BzSikinIdouListHtkinDataSourceBean();

                bzSikinIdouListHtkinDataSourceBean.setIrKeirisikinidougroupno(htkinSikinIdouListSksWkBean
                    .getSikinidougroupkbn());
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukasyu(htkinSikinIdouListSksWkBean.getSiteituuka());
                bzSikinIdouListHtkinDataSourceBean.setIrSeg1cd(htkinSikinIdouListSksWkBean.getSeg1cd());
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukagkgaika(htkinSikinIdouListSksWkBean
                    .getSiteituukagk());
                bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukasyu(htkinSikinIdouListSksWkBean.getTrhktuuka());
                bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukagk(htkinSikinIdouListSksWkBean.getTrhktuukagk());

                bzSikinIdouListHtkinDataSourceBeanList.add(bzSikinIdouListHtkinDataSourceBean);

                syorikensuu++;
            }

            for (HtkinSikinIdouListSksWkAllkmBean htkinSikinIdouListSksWkAllkmBean : htkinSikinIdouListSksWkAllkmBeanList) {
                BT_HtkinSikinIdouListSksRk htkinSikinIdouListSksRk = new BT_HtkinSikinIdouListSksRk();

                htkinSikinIdouListSksRk.setSyono(htkinSikinIdouListSksWkAllkmBean.getSyono());
                htkinSikinIdouListSksRk.setKijyunymd(htkinSikinIdouListSksWkAllkmBean.getKijyunymd());
                htkinSikinIdouListSksRk.setHaitounendo(htkinSikinIdouListSksWkAllkmBean.getHaitounendo());
                htkinSikinIdouListSksRk.setSiteituuka(htkinSikinIdouListSksWkAllkmBean.getSiteituuka());
                htkinSikinIdouListSksRk.setSiteituukagk(htkinSikinIdouListSksWkAllkmBean.getSiteituukagk());
                htkinSikinIdouListSksRk.setTrhktuuka(htkinSikinIdouListSksWkAllkmBean.getTrhktuuka());
                htkinSikinIdouListSksRk.setTrhktuukagk(htkinSikinIdouListSksWkAllkmBean.getTrhktuukagk());
                htkinSikinIdouListSksRk.setSeg1cd(htkinSikinIdouListSksWkAllkmBean.getSeg1cd());
                htkinSikinIdouListSksRk.setSikinidougroupkbn(htkinSikinIdouListSksWkAllkmBean.getSikinidougroupkbn());
                htkinSikinIdouListSksRk.setSikinidoukawaserate(htkinSikinIdouListSksWkAllkmBean.getSikinidoukawaserate());

                BizPropertyInitializer.initialize(htkinSikinIdouListSksRk);
                htkinSikinIdouListSksRkInserter.add(htkinSikinIdouListSksRk);
            }

            if (bzSikinIdouListHtkinDataSourceBeanList.size() > 0) {

                BzSikinIdouListHtkinBean bzSikinIdouListHtkinBean = new BzSikinIdouListHtkinBean();

                bzSikinIdouListHtkinBean.setIrSyoriymd(DateFormatUtil.dateKANJI(syoriYmd));

                ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
                    kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.CM_SIKINIDOULIST_HTKIN);

                reportServicesBean.setSyoriYmd(syoriYmd);

                reportServicesBean.addParamObjects(bzSikinIdouListHtkinDataSourceBeanList, bzSikinIdouListHtkinBean);

                createReport.execNoCommit(reportServicesBean);

                BzSikinIdouListCsvFSksTblTrk bzSikinIdouListCsvFSksTblTrk = SWAKInjector.getInstance(BzSikinIdouListCsvFSksTblTrk.class);

                bzSikinIdouListCsvFSksTblTrk.exec(syoriYmd, bzSikinIdouListHtkinDataSourceBeanList);
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syorikensuu)));
        }
    }
}

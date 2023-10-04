package yuyu.batch.sinkeiyaku.sknyuukin.skcredittourokuerrorlistsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityDeleter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skcredittourokuerrorlistsks.dba.SkCreditTourokuErrorlistSksDao;
import yuyu.batch.sinkeiyaku.sknyuukin.skcredittourokuerrorlistsks.dba.SkCreditTrkHaneierrListBean;
import yuyu.batch.sinkeiyaku.sknyuukin.skcredittourokuerrorlistsks.dba.SkCreditTrkNgListBean;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HW_CreditTrkHaneierrList;
import yuyu.def.db.entity.HW_CreditTrkNgList;
import yuyu.def.sinkeiyaku.bean.report.SkCreditcardkaiintourokunglistDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkCreditcardtourokuhaneierrlistDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkSyanailistheaderBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 入金 クレジットカード登録エラーリスト作成
 */
public class SkCreditTourokuErrorlistSksBatch implements Batch{

    private Integer errorListSksCount = 0;

    private Integer ngListSksCount = 0;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkCreditTourokuErrorlistSksDao skCreditTourokuErrorlistSksDao;

    @Inject
    private CreateReport createReport;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Override
    public BzBatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            "処理年月日", String.valueOf(syoriYmd)));

        SkSyanailistheaderBean skSyanailistheaderBean =  SWAKInjector.getInstance(SkSyanailistheaderBean.class);
        String kanjiSosikinm = "";
        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(
            YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd(), null);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            kanjiSosikinm = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());
        }

        skSyanailistheaderBean.setIrAtesakisosiki(kanjiSosikinm);
        skSyanailistheaderBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJI(syoriYmd));

        sksCreditTourokuErrorList(skSyanailistheaderBean);

        sksCreditTrkNgList(skSyanailistheaderBean);

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(errorListSksCount), "クレジットカード登録反映エラーリスト"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(ngListSksCount), "クレジットカード会員登録ＮＧリスト"));
    }

    private void sksCreditTourokuErrorList(SkSyanailistheaderBean pSkSyanailistheaderBean) {

        List<IReportDataSouceBean> skCreditcardtourokuhaneierrlistDataSourceBeanList = new ArrayList<>();

        try (
            ExDBResults<SkCreditTrkHaneierrListBean> creditTrkHaneierrListBeans = skCreditTourokuErrorlistSksDao.
            getCreditTrkHaneierrListBeans();
            EntityDeleter<HW_CreditTrkHaneierrList> errorListDelList = new EntityDeleter<HW_CreditTrkHaneierrList>();
            ) {

            for (SkCreditTrkHaneierrListBean skCreditTrkHaneierrListBean : creditTrkHaneierrListBeans) {
                SkCreditcardtourokuhaneierrlistDataSourceBean skCreditcardtourokuhaneierrlistDataSourceBean = new
                    SkCreditcardtourokuhaneierrlistDataSourceBean();

                skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhoukbn(skCreditTrkHaneierrListBean.
                    getCredittrkhoukbn());
                skCreditcardtourokuhaneierrlistDataSourceBean.setIrSosikicd(skCreditTrkHaneierrListBean.getSosikicd());
                skCreditcardtourokuhaneierrlistDataSourceBean.setIrMosno(skCreditTrkHaneierrListBean.getMosno());
                skCreditcardtourokuhaneierrlistDataSourceBean.setIrCreditkessaiyouno(skCreditTrkHaneierrListBean.
                    getCreditkessaiyouno());
                skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhaneierrriyuu(skCreditTrkHaneierrListBean.
                    getCredittrkhaneierrriyuu());

                skCreditcardtourokuhaneierrlistDataSourceBeanList.add(skCreditcardtourokuhaneierrlistDataSourceBean);

                HW_CreditTrkHaneierrList creditTrkHaneierrListDelEntity = sinkeiyakuDomManager.getCreditTrkHaneierrList(
                    skCreditTrkHaneierrListBean.getTyouhyouymd(),
                    skCreditTrkHaneierrListBean.getDatarenno());

                errorListDelList.add(creditTrkHaneierrListDelEntity);

                errorListSksCount = errorListSksCount + 1;
            }

            createReport(C_SyoruiCdKbn.SK_CREDITCARDTOUROKUHANEIERRORLIST,
                pSkSyanailistheaderBean, skCreditcardtourokuhaneierrlistDataSourceBeanList);
        }
    }

    private void sksCreditTrkNgList(SkSyanailistheaderBean pSkSyanailistheaderBean) {

        List<IReportDataSouceBean> skCreditcardtourokuhaneierrlistDataSourceBeanList = new ArrayList<>();

        try (
            ExDBResults<SkCreditTrkNgListBean> skCreditTrkNgListBeans = skCreditTourokuErrorlistSksDao.
            getCreditTrkNgListBeans();
            EntityDeleter<HW_CreditTrkNgList> creditTrkNgListDelList = new EntityDeleter<HW_CreditTrkNgList>();
            ) {
            for (SkCreditTrkNgListBean skCreditTrkNgListBean : skCreditTrkNgListBeans) {
                SkCreditcardkaiintourokunglistDataSourceBean skCreditcardkaiintourokunglistDataSourceBean = new
                    SkCreditcardkaiintourokunglistDataSourceBean();

                skCreditcardkaiintourokunglistDataSourceBean.setIrMosno(skCreditTrkNgListBean.getMosno());
                skCreditcardkaiintourokunglistDataSourceBean.setIrCreditkessaiyouno(
                    skCreditTrkNgListBean.getCreditkessaiyouno());
                skCreditcardkaiintourokunglistDataSourceBean.setIrCreditqrerrorcd(
                    skCreditTrkNgListBean.getCreditqrerrorcd());
                skCreditcardkaiintourokunglistDataSourceBean.setIrBluegateerrorcd(
                    skCreditTrkNgListBean.getBluegateerrorcd());
                skCreditcardkaiintourokunglistDataSourceBean.setIrDbhanei(skCreditTrkNgListBean.getDbhaneikbn());
                skCreditcardkaiintourokunglistDataSourceBean.setIrCredittrkhaneierrriyuu(
                    skCreditTrkNgListBean.getCredittrkhaneierrriyuu());

                skCreditcardtourokuhaneierrlistDataSourceBeanList.add(skCreditcardkaiintourokunglistDataSourceBean);

                HW_CreditTrkNgList creditTrkNgListDelEntity = sinkeiyakuDomManager.getCreditTrkNgList(
                    skCreditTrkNgListBean.getTyouhyouymd(), skCreditTrkNgListBean.getDatarenno());

                creditTrkNgListDelList.add(creditTrkNgListDelEntity);

                ngListSksCount = ngListSksCount + 1;
            }

            createReport(C_SyoruiCdKbn.SK_CREDITCARDKAIINTOUROKUNGLIST,
                pSkSyanailistheaderBean, skCreditcardtourokuhaneierrlistDataSourceBeanList);
        }
    }

    private void createReport(C_SyoruiCdKbn pSyoruiCdKbn, SkSyanailistheaderBean pSkSyanailistheaderBean,
        List<IReportDataSouceBean> pIReportDataSouceBeansLst) {
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            pSyoruiCdKbn);

        reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

        reportServicesBean.addParamObjects(
            pSyoruiCdKbn,
            pIReportDataSouceBeansLst,
            pSkSyanailistheaderBean
            );

        createReport.execNoCommit(reportServicesBean);
    }
}

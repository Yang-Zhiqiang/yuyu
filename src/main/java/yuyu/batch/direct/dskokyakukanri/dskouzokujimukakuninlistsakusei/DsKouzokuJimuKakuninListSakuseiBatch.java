package yuyu.batch.direct.dskokyakukanri.dskouzokujimukakuninlistsakusei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.MT_DsKouzokuJimuKakunin;
import yuyu.def.direct.bean.report.DsKzkjmkknListBean;
import yuyu.def.direct.bean.report.DsKzkjmkknListDataSourceBean;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * ダイレクトサービス 顧客管理 ＤＳ後続事務確認リスト作成クラス
 */
public class DsKouzokuJimuKakuninListSakuseiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        int syoriKensuu = 0;
        String keiyakusyaNm = "";

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        try (ExDBResults<MT_DsKouzokuJimuKakunin> dsKouzokuJimuKakuninLst =
            directDomManager.getDsKouzokuJimuKakuninsByHasseiymd(syoriYmd);) {

            List<IReportDataSouceBean> dsKzkjmkknListDataSourceBeanLst = new ArrayList<>();

            for (MT_DsKouzokuJimuKakunin dsKouzokuJimuKakuninBean : dsKouzokuJimuKakuninLst) {

                List<HT_SyoriCTL> syoriCTLLst =
                    sinkeiyakuDomManager.getSyoriCTLsBySyono(dsKouzokuJimuKakuninBean.getSyono());

                if (syoriCTLLst.size() > 0) {

                    HT_MosKihon mosKihon = syoriCTLLst.get(0).getMosKihon();

                    if (mosKihon != null) {
                        if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())){
                            keiyakusyaNm = mosKihon.getHhknnmkj();
                        } else {
                            keiyakusyaNm = mosKihon.getKyknmkj();
                        }
                    }
                }

                DsKzkjmkknListDataSourceBean dsKzkjmkknListDataSourceBean =
                    SWAKInjector.getInstance(DsKzkjmkknListDataSourceBean.class);

                dsKzkjmkknListDataSourceBean.setIrDskzkjmkknhsjykbn(dsKouzokuJimuKakuninBean.getDskzkjmkknhsjykbn());
                dsKzkjmkknListDataSourceBean.setIrSyono(dsKouzokuJimuKakuninBean.getSyono());
                dsKzkjmkknListDataSourceBean.setIrKyknmkj(keiyakusyaNm);
                dsKzkjmkknListDataSourceBean.setIrMessage("");

                dsKzkjmkknListDataSourceBeanLst.add(dsKzkjmkknListDataSourceBean);

                syoriKensuu++;

                keiyakusyaNm = "";
            }

            String syoriYmdSeireki = DateFormatUtil.dateKANJISeirekiNoZero(syoriYmd);

            DsKzkjmkknListBean dsKzkjmkknListBean = SWAKInjector.getInstance(DsKzkjmkknListBean.class);

            dsKzkjmkknListBean.setIrTyouhyousakuseiymd(syoriYmdSeireki);
            dsKzkjmkknListBean.setIrKensuu(syoriKensuu);

            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
                kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.DS_KOUZOKUJIMUKAKUNINLIST);

            reportServicesBean.addParamObjects(dsKzkjmkknListDataSourceBeanLst, dsKzkjmkknListBean);

            reportServicesBean.setSyoriYmd(syoriYmd);

            createReport.execNoCommit(reportServicesBean);

            batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syoriKensuu)));
        }
    }
}
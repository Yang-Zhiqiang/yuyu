package yuyu.batch.biz.bzkaikei.bzsikinidoulistsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.kaikei.BzSikinIdouListCsvFSksTblTrk;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.report.BzSikinIdouListSokujibunBean;
import yuyu.def.biz.bean.report.BzSikinIdouListSokujibunDataSourceBean;
import yuyu.def.biz.bean.report.BzSikinIdouListTyakkinbibunBean;
import yuyu.def.biz.bean.report.BzSikinIdouListTyakkinbibunDataSourceBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.bean.SokujiSikinIdouListSkssBySyoriYmdBean;
import yuyu.def.biz.result.bean.TyakkinSikinIdouListSkssBySyoriYmdBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 業務共通 経理・会計 資金移動リスト作成
 */
public class BzSikinIdouListSksBatch implements Batch {

    private static final int ZERO = 0;

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

        try(ExDBResults<SokujiSikinIdouListSkssBySyoriYmdBean> sokujiSikinIdouLst =
            bizDomManager.getSokujiSikinIdouListSkssBySyoriYmd(bzBatchParam.getSyoriYmd());
            ExDBResults<TyakkinSikinIdouListSkssBySyoriYmdBean> tyakkinSikinIdouLst =
                bizDomManager.getTyakkinSikinIdouListSkssBySyoriYmd(bzBatchParam.getSyoriYmd())) {

            List<IReportDataSouceBean> iReportSokuzibunLst = new ArrayList<>();
            int count = 0;
            SokujiSikinIdouListSkssBySyoriYmdBean sokujiSikinIdouBef = null;
            BizCurrency siteiTuukaGkKeiBef = BizCurrency.valueOf(0);
            BzSikinIdouListSokujibunDataSourceBean bzSikinIdou;

            for (SokujiSikinIdouListSkssBySyoriYmdBean sokujiSikinIdou : sokujiSikinIdouLst) {

                if (sokujiSikinIdouBef != null) {
                    if (!sokujiSikinIdou.getSikinidougroupkbn().eq(sokujiSikinIdouBef.getSikinidougroupkbn()) ||
                        !sokujiSikinIdou.getKyktuukasyu().eq(sokujiSikinIdouBef.getKyktuukasyu())) {

                        bzSikinIdou =
                            SWAKInjector.getInstance(BzSikinIdouListSokujibunDataSourceBean.class);

                        bzSikinIdou.setIrKeirisikinidougroupno(sokujiSikinIdouBef.getSikinidougroupkbn());
                        bzSikinIdou.setIrKeirisiteituukasyu(sokujiSikinIdouBef.getKyktuukasyu());
                        bzSikinIdou.setIrKeirisiteituukagkkei(siteiTuukaGkKeiBef);
                        bzSikinIdou.setIrKaipageno(ZERO);

                        iReportSokuzibunLst.add(bzSikinIdou);

                        siteiTuukaGkKeiBef = BizCurrency.valueOf(0, sokujiSikinIdou.getKeiyakutuukagkSum().getType());

                    }
                }
                else {
                    siteiTuukaGkKeiBef = BizCurrency.valueOf(0, sokujiSikinIdou.getKeiyakutuukagkSum().getType());
                }

                bzSikinIdou = SWAKInjector.getInstance(BzSikinIdouListSokujibunDataSourceBean.class);
                bzSikinIdou.setIrKeirisikinidougroupno(sokujiSikinIdou.getSikinidougroupkbn());
                bzSikinIdou.setIrSeg1cd(sokujiSikinIdou.getSeg1cd());
                bzSikinIdou.setIrKeirisiteituukasyu(sokujiSikinIdou.getKyktuukasyu());
                bzSikinIdou.setIrKeirisiteituukagkgaika(sokujiSikinIdou.getKeiyakutuukagkSum());
                bzSikinIdou.setIrKeirisikinidoumeisaikbnnm(sokujiSikinIdou.getSikinidoumeisaikbn().getContent());
                bzSikinIdou.setIrKaipageno(ZERO);

                iReportSokuzibunLst.add(bzSikinIdou);

                siteiTuukaGkKeiBef = siteiTuukaGkKeiBef.add(sokujiSikinIdou.getKeiyakutuukagkSum());

                sokujiSikinIdouBef = sokujiSikinIdou;

                count++;
            }

            if (sokujiSikinIdouBef != null) {
                bzSikinIdou = SWAKInjector.getInstance(BzSikinIdouListSokujibunDataSourceBean.class);

                bzSikinIdou.setIrKeirisikinidougroupno(sokujiSikinIdouBef.getSikinidougroupkbn());
                bzSikinIdou.setIrKeirisiteituukasyu(sokujiSikinIdouBef.getKyktuukasyu());
                bzSikinIdou.setIrKeirisiteituukagkkei(siteiTuukaGkKeiBef);
                bzSikinIdou.setIrKaipageno(ZERO);

                iReportSokuzibunLst.add(bzSikinIdou);
            }

            List<IReportDataSouceBean> iReportChakkinhibunLst = new ArrayList<>();

            for (TyakkinSikinIdouListSkssBySyoriYmdBean tyakkinSikinIdou : tyakkinSikinIdouLst) {

                BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibun =
                    SWAKInjector.getInstance(BzSikinIdouListTyakkinbibunDataSourceBean.class);

                bzSikinIdouListTyakkinbibun.setIrKeirisikinidougroupno(tyakkinSikinIdou.getSikinidougroupkbn());
                bzSikinIdouListTyakkinbibun.setIrTyakkinymdwareki(
                    DateFormatUtil.dateKANJI(tyakkinSikinIdou.getTyakkinymd()));
                bzSikinIdouListTyakkinbibun.setIrSeg1cd(tyakkinSikinIdou.getSeg1cd());
                bzSikinIdouListTyakkinbibun.setIrKeirisiteituukasyu(tyakkinSikinIdou.getKyktuukasyu());
                bzSikinIdouListTyakkinbibun.setIrKeirisiteituukagkgaika(tyakkinSikinIdou.getKeiyakutuukagkSum());
                bzSikinIdouListTyakkinbibun.setIrKeirisikinidoumeisaikbnnm(
                    tyakkinSikinIdou.getSikinidoumeisaikbn().getContent());
                bzSikinIdouListTyakkinbibun.setIrTyakkinymd8keta(tyakkinSikinIdou.getTyakkinymd());

                iReportChakkinhibunLst.add(bzSikinIdouListTyakkinbibun);

                count++;
            }

            BzSikinIdouListCsvFSksTblTrk bzSikinIdouListCsvFSksTblTrk = SWAKInjector.getInstance(BzSikinIdouListCsvFSksTblTrk.class);

            if (iReportSokuzibunLst.size() > 0) {

                BzSikinIdouListSokujibunBean bzSikinIdouBean = SWAKInjector.getInstance(BzSikinIdouListSokujibunBean.class);

                bzSikinIdouBean.setIrSyoribiwareki(DateFormatUtil.dateKANJI(bzBatchParam.getSyoriYmd()));

                ReportServicesBean reportServicesBean =
                    createReport.createNewReportServiceBean(kinou.getSubSystemId(), kinou.getCategoryId(),
                        kinou.getKinouId(),C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

                reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

                reportServicesBean.addParamObjects(iReportSokuzibunLst, bzSikinIdouBean);

                createReport.exec(reportServicesBean);

                bzSikinIdouListCsvFSksTblTrk.exec(bzBatchParam.getSyoriYmd(), iReportSokuzibunLst);

            }

            if (iReportChakkinhibunLst.size() > 0) {

                BzSikinIdouListTyakkinbibunBean bzSikinIdouBean =
                    SWAKInjector.getInstance(BzSikinIdouListTyakkinbibunBean.class);

                bzSikinIdouBean.setIrSyoribiwareki(DateFormatUtil.dateKANJI(bzBatchParam.getSyoriYmd()));

                ReportServicesBean reportServicesBean =
                    createReport.createNewReportServiceBean(kinou.getSubSystemId(), kinou.getCategoryId(),
                        kinou.getKinouId(),C_SyoruiCdKbn.CM_SIKINIDOULIST_TYAKKINBI);

                reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

                reportServicesBean.addParamObjects(iReportChakkinhibunLst, bzSikinIdouBean);

                createReport.exec(reportServicesBean);

                bzSikinIdouListCsvFSksTblTrk.exec(bzBatchParam.getSyoriYmd(), iReportChakkinhibunLst);
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
        }
    }
}
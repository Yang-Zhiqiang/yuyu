package yuyu.batch.sinkeiyaku.sknyuukin.skmihenkinlistsakusei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skmihenkinlistsakusei.dba.SkMihenkinListSakuseiDao;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkHenkinmisyorilistDetailBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.sorter.SortHT_Nyuukin;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;

/**
 * 新契約 入金 未返金リスト作成処理
 */
public class SkMihenkinListSakuseiBatch implements Batch {

    private long syoriKensuu = 0;

    private BizDate bizDate = null;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private CreateReport createReport;

    @Inject
    private SkMihenkinListSakuseiDao skMihenkinListSakuseiDao;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        bizDate = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "処理年月日", String.valueOf(bizDate)));

        int keikaNisuu = YuyuSinkeiyakuConfig.getInstance().getHnknMsyrKeikaNissu();

        BizDate keikaSyoriYmd = bizDate.addDays(-keikaNisuu);

        C_Tuukasyu[] kyktuukasyuLst = new C_Tuukasyu[] {C_Tuukasyu.USD, C_Tuukasyu.AUD};

        syoriKensuu = 0;

        List<IReportDataSouceBean> iReportDataSouceBeanLst1 = createHnKnMisyoriList(keikaSyoriYmd, kyktuukasyuLst);

        if (iReportDataSouceBeanLst1.size() > 0) {

            C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.SK_HENKINMISYORILIST;

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(), syoruiCd);

            reportServicesBean.setSyoriYmd(bizDate);

            reportServicesBean.addParamObjects(syoruiCd, iReportDataSouceBeanLst1);

            createReport.execNoCommit(reportServicesBean);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "返金未処理リスト"));


        kyktuukasyuLst = new C_Tuukasyu[] {C_Tuukasyu.JPY};

        syoriKensuu = 0;

        List<IReportDataSouceBean> iReportDataSouceBeanLstYendt = createHnKnMisyoriList(keikaSyoriYmd, kyktuukasyuLst);

        if (iReportDataSouceBeanLstYendt.size() > 0) {

            C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.SK_HENKINMISYORILIST_YENDT;

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(), syoruiCd);

            reportServicesBean.setSyoriYmd(bizDate);

            reportServicesBean.addParamObjects(syoruiCd, iReportDataSouceBeanLstYendt);

            createReport.execNoCommit(reportServicesBean);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "返金未処理リスト（円建）"));
    }


    private List<IReportDataSouceBean> createHnKnMisyoriList(BizDate pkeikaSyoriYmd, C_Tuukasyu[] pTuukasyuList) {

        String kykNmKj = "";
        String oyadrtenNm = "";
        BizDate srSyoriYmd = null;
        List<IReportDataSouceBean> iReportDataSouceBeanLst = Lists.newArrayList();
        SkHenkinmisyorilistDetailBean skHenkinmisyorilistDetailBean = null;
        HT_MosKihon mosKihon = null;
        HT_MosDairiten mosDairiten = null;
        List<HT_Nyuukin> nyuukinLst = null;
        BizDate lastrsYmd = null;
        String oyadairitenCd = "";
        String toriatukaiDairitenCd = "";
        String mosNo = "";
        String tyouhyouYmd = "";
        String srsyoriYmdSeireki = "";
        String lastrsYmdSeireki = "";
        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
        SortHT_Nyuukin nyuukinSort = SWAKInjector.getInstance(SortHT_Nyuukin.class);
        String currentOyadrtencd = "";
        int currentPageNo = 0;
        int currentRowCount = 0;


        try (ExDBResults<HT_SyoriCTL> exDBResults = skMihenkinListSakuseiDao.getSyoriCTLsByPkakinsyoriymdNyknnrkumuKyktuukasyulst(pkeikaSyoriYmd, pTuukasyuList)) {

            for (HT_SyoriCTL syoriCTL : exDBResults) {

                kykNmKj = "";
                oyadrtenNm = "";
                srSyoriYmd = null;
                lastrsYmd = null;
                oyadairitenCd = "";
                toriatukaiDairitenCd = "";
                mosNo = syoriCTL.getMosno();
                tyouhyouYmd = "";
                srsyoriYmdSeireki = "";
                lastrsYmdSeireki = "";
                mosKihon = syoriCTL.getMosKihon();

                if (mosKihon != null) {

                    if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {

                        kykNmKj = mosKihon.getHhknnmkj();
                    }
                    else {

                        kykNmKj = mosKihon.getKyknmkj();
                    }
                }

                mosDairiten = syoriCTL.getMosDairitenByRenno(1);

                if (mosDairiten != null && !BizUtil.isBlank(mosDairiten.getOyadrtencd())) {

                    oyadairitenCd = mosDairiten.getOyadrtencd();
                    toriatukaiDairitenCd = mosDairiten.getTratkiagcd();

                    List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(oyadairitenCd);

                    for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {

                        if (bzGetAgInfoBean != null && C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                            oyadrtenNm = bzGetAgInfoBean.getKanjiDairitenNm();

                            break;
                        }
                    }
                }

                nyuukinLst = syoriCTL.getNyuukins();

                if (nyuukinLst.size() > 0) {

                    nyuukinLst = nyuukinSort.OrderHT_NyuukinByRyosyuymdDesc(nyuukinLst);

                    lastrsYmd = nyuukinLst.get(0).getRyosyuymd();
                }

                if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn()) || C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {

                    srSyoriYmd = syoriCTL.getSrsyoriymd();
                }

                skHenkinmisyorilistDetailBean = SWAKInjector.getInstance(SkHenkinmisyorilistDetailBean.class);

                tyouhyouYmd = DateFormatUtil.dateKANJI(bizDate);

                if (srSyoriYmd != null) {

                    srsyoriYmdSeireki = DateFormatUtil.dateDOTSeireki(srSyoriYmd);
                }

                if (lastrsYmd != null) {

                    lastrsYmdSeireki = DateFormatUtil.dateDOTSeireki(lastrsYmd);
                }

                syoriKensuu++;

                currentRowCount++;

                if (!currentOyadrtencd.equals(oyadairitenCd)
                    || 1 == syoriKensuu) {
                    currentPageNo++;
                    currentRowCount = 1;
                    currentOyadrtencd = oyadairitenCd;
                }
                else if (currentRowCount%25 == 1) {
                    currentPageNo++;
                    currentRowCount = 1;
                }

                skHenkinmisyorilistDetailBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
                skHenkinmisyorilistDetailBean.setIrDrtencd(oyadairitenCd);
                skHenkinmisyorilistDetailBean.setIrDrtennmkj(oyadrtenNm);
                skHenkinmisyorilistDetailBean.setIrMosno(mosNo);
                skHenkinmisyorilistDetailBean.setIrTratkiagcd(toriatukaiDairitenCd);
                skHenkinmisyorilistDetailBean.setIrKyknmkj(kykNmKj);
                skHenkinmisyorilistDetailBean.setIrSeiritujk(syoriCTL.getSeiritukbn().getContent());
                skHenkinmisyorilistDetailBean.setIrSrsyoriymd(srsyoriYmdSeireki);
                skHenkinmisyorilistDetailBean.setIrLastrsymd(lastrsYmdSeireki);
                skHenkinmisyorilistDetailBean.setIrPageno(currentPageNo);
                if (C_Tuukasyu.JPY.eq(pTuukasyuList[0])) {
                    skHenkinmisyorilistDetailBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HENKINMISYORILIST_YENDT);
                }
                else {
                    skHenkinmisyorilistDetailBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HENKINMISYORILIST);
                }

                iReportDataSouceBeanLst.add(skHenkinmisyorilistDetailBean);
            }
        }
        if (iReportDataSouceBeanLst.size() > 0) {

            for (IReportDataSouceBean iReportDataSouceBean : iReportDataSouceBeanLst) {

                skHenkinmisyorilistDetailBean = (SkHenkinmisyorilistDetailBean) iReportDataSouceBean;
                skHenkinmisyorilistDetailBean.setIrKensuu((int) syoriKensuu);
                skHenkinmisyorilistDetailBean.setIrSoupagesuu(currentPageNo);
            }
        }

        return iReportDataSouceBeanLst;

    }
}

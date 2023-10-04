package yuyu.batch.sinkeiyaku.sknyuukin.skmosmatikeikalistsakusei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skmosmatikeikalistsakusei.dba.SkMosmatiKeikaListSakuseiDao;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.skcommon.GetSyoruicd;
import yuyu.common.sinkeiyaku.skcommon.SetNyknRnrkhyouYmd;
import yuyu.def.MessageId;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HW_MosMatiKknKeikaWk;
import yuyu.def.sinkeiyaku.bean.report.SkMossyoruimitoutyakulistBean;
import yuyu.def.sinkeiyaku.bean.report.SkMossyoruimitoutyakulistDataSourceBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 入金 申込書類未到着期間経過リスト作成
 */
public class SkMosmatiKeikaListSakuseiBatch implements Batch {

    private List<IReportDataSouceBean> skMossyoruimitoutyakulistDataSourceBeanLst = null;

    private long syoriKensuu = 0;

    private BizDate syoriYmd = null;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private CreateReport createReport;

    @Inject
    private SkMosmatiKeikaListSakuseiDao skMosmatiKeikaListSakuseiDao;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syoriYmd = bzBatchParam.getSyoriYmd();

        syoriKensuu = 0;

        skMossyoruimitoutyakulistDataSourceBeanLst = new ArrayList<>();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "処理年月日", String.valueOf(syoriYmd)));

        String dairitenKykSosikiCd = YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd();

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(dairitenKykSosikiCd, null);

        String kanjiSosikinm = "";

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {
            kanjiSosikinm = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());
        }

        String tyouhyouYmd = DateFormatUtil.dateKANJI(syoriYmd);

        SkMossyoruimitoutyakulistBean skMossyoruimitoutyakulistBean =
            SWAKInjector.getInstance(SkMossyoruimitoutyakulistBean.class);

        skMossyoruimitoutyakulistBean.setIrAtesaki(kanjiSosikinm);
        skMossyoruimitoutyakulistBean.setIrTyouhyousakuseiymd(tyouhyouYmd);

        createMossyoruimitoutyakulist(C_Tuukasyu.JPY, new C_NyktyhyoutKbn[] {C_NyktyhyoutKbn.NONE, C_NyktyhyoutKbn.GAIKADATE});

        createMossyoruimitoutyakulist(C_Tuukasyu.USD, new C_NyktyhyoutKbn[] {C_NyktyhyoutKbn.NONE, C_NyktyhyoutKbn.GAIKADATE});

        createMossyoruimitoutyakulist(C_Tuukasyu.AUD, new C_NyktyhyoutKbn[] {C_NyktyhyoutKbn.NONE, C_NyktyhyoutKbn.GAIKADATE});

        GetSyoruicd getSyoruicd = SWAKInjector.getInstance(GetSyoruicd.class);

        C_SyoruiCdKbn syoruiCdKbn = getSyoruicd.getSyoruicd_Mosmttkikankeikalist();

        skMossyoruimitoutyakulistBean.setIrSyoruicd(syoruiCdKbn);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCdKbn);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(
            syoruiCdKbn,
            skMossyoruimitoutyakulistDataSourceBeanLst,
            skMossyoruimitoutyakulistBean
            );

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "申込書類未到着期間経過リスト"));

        syoriKensuu = 0;

        skMossyoruimitoutyakulistDataSourceBeanLst = new ArrayList<>();

        createMossyoruimitoutyakulist(C_Tuukasyu.JPY, new C_NyktyhyoutKbn[] {C_NyktyhyoutKbn.YENDATE});

        syoruiCdKbn = C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST_YENDT;

        skMossyoruimitoutyakulistBean.setIrSyoruicd(syoruiCdKbn);

        reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCdKbn);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(
            syoruiCdKbn,
            skMossyoruimitoutyakulistDataSourceBeanLst,
            skMossyoruimitoutyakulistBean
            );

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "申込書類未到着期間経過リスト（円建）"));

    }

    private void createMossyoruimitoutyakulist(C_Tuukasyu pNyukintuuka, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        try (ExDBResults<HW_MosMatiKknKeikaWk> mosMatiKknKeikaWkLst =
            skMosmatiKeikaListSakuseiDao.getMosMatiKknKeikaWksBySyoriYmdRstuukasyuNyktyhyoutlst(syoriYmd, pNyukintuuka, pNyktyhyoutKbnList)) {

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pNyukintuuka);

            Iterator<HW_MosMatiKknKeikaWk> iterator = mosMatiKknKeikaWkLst.iterator();

            if (!iterator.hasNext()) {

                SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean =
                    SWAKInjector.getInstance(SkMossyoruimitoutyakulistDataSourceBean.class);

                skMossyoruimitoutyakulistDataSourceBean.setIrNyukintuuka(pNyukintuuka.getContent() + "入金");
                skMossyoruimitoutyakulistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(0));
                skMossyoruimitoutyakulistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0, currencyType));

                skMossyoruimitoutyakulistDataSourceBeanLst.add(skMossyoruimitoutyakulistDataSourceBean);
            }
            else {

                SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean = null;
                String knjyYmd = "";
                String nyksyoriYmd = "";
                String oyadairitenNm = "";
                SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBeanGoukei =
                    SWAKInjector.getInstance(SkMossyoruimitoutyakulistDataSourceBean.class);
                BizNumber kensuuGoukei = BizNumber.ZERO;
                BizCurrency kingakuGoukei = BizCurrency.valueOf(0, currencyType);
                SetNyknRnrkhyouYmd setNyknRnrkhyouYmd =  SWAKInjector.getInstance(SetNyknRnrkhyouYmd.class);

                while(iterator.hasNext()){

                    HW_MosMatiKknKeikaWk mosMatiKknKeikaWk = iterator.next();

                    skMossyoruimitoutyakulistDataSourceBean =
                        SWAKInjector.getInstance(SkMossyoruimitoutyakulistDataSourceBean.class);
                    knjyYmd = "";
                    nyksyoriYmd = "";
                    oyadairitenNm = "";
                    kensuuGoukei = kensuuGoukei.add(BizNumber.ONE);
                    kingakuGoukei = kingakuGoukei.add(mosMatiKknKeikaWk.getTrhkkgk());

                    oyadairitenNm = mosMatiKknKeikaWk.getNyuukinoyadrtennm();

                    if (mosMatiKknKeikaWk.getKnjyymd() != null) {

                        knjyYmd = DateFormatUtil.dateDOTNoEx(mosMatiKknKeikaWk.getKnjyymd());
                    }

                    BizDate nyknRenrakuhyouYmd = setNyknRnrkhyouYmd.exec(
                        mosMatiKknKeikaWk.getHrkmnykndatarenmotoKbn(), mosMatiKknKeikaWk.getNyksyoriymd());

                    if (nyknRenrakuhyouYmd != null) {
                        nyksyoriYmd = DateFormatUtil.dateDOTNoEx(nyknRenrakuhyouYmd);
                    }

                    skMossyoruimitoutyakulistDataSourceBean.setIrNyukintuuka(pNyukintuuka.getContent() + "入金");
                    skMossyoruimitoutyakulistDataSourceBean.setIrDrtennmkj(oyadairitenNm);
                    skMossyoruimitoutyakulistDataSourceBean.setIrKnjyymd(knjyYmd);
                    skMossyoruimitoutyakulistDataSourceBean.setIrMosno(mosMatiKknKeikaWk.getMosno());
                    skMossyoruimitoutyakulistDataSourceBean.setIrHrkmirninnm(mosMatiKknKeikaWk.getHrkmirninnm());
                    skMossyoruimitoutyakulistDataSourceBean.setIrNyknkkngk(mosMatiKknKeikaWk.getTrhkkgk());
                    skMossyoruimitoutyakulistDataSourceBean.setIrNyknrnrkhyouymd(nyksyoriYmd);
                    skMossyoruimitoutyakulistDataSourceBean.setIrKensuugoukei5(null);
                    skMossyoruimitoutyakulistDataSourceBean.setIrKingakugoukei(null);

                    skMossyoruimitoutyakulistDataSourceBeanLst.add(skMossyoruimitoutyakulistDataSourceBean);

                    syoriKensuu++ ;

                    skMossyoruimitoutyakulistDataSourceBeanGoukei = skMossyoruimitoutyakulistDataSourceBean;
                }

                skMossyoruimitoutyakulistDataSourceBeanGoukei.setIrKensuugoukei5(BizNumber.valueOf(kensuuGoukei));
                skMossyoruimitoutyakulistDataSourceBeanGoukei.setIrKingakugoukei(kingakuGoukei);
            }
        }
    }
}
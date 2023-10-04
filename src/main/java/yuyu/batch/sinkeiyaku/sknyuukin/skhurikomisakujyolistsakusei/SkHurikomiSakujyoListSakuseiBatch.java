package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomisakujyolistsakusei;

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
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikomisakujyolistsakusei.dba.SkHurikomiSakujyoListSakuseiDao;
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
import yuyu.def.db.entity.HT_HrkmNyknSakujyo;
import yuyu.def.sinkeiyaku.bean.report.SkSakujokeiyakumeisailistBean;
import yuyu.def.sinkeiyaku.bean.report.SkSakujokeiyakumeisailistDataSourceBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 入金 振込入金削除リスト作成
 */
public class SkHurikomiSakujyoListSakuseiBatch implements Batch {

    private List<IReportDataSouceBean> skSakujokeiyakumeisailistDataSourceBeanLst = null;

    private long syoriKensuu = 0;

    private BizDate syoriYmd = null;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private CreateReport createReport;

    @Inject
    private SkHurikomiSakujyoListSakuseiDao skHurikomiSakujyoListSakuseiDao;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BzBatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syoriYmd = bzBatchParam.getSyoriYmd();

        syoriKensuu = 0;

        skSakujokeiyakumeisailistDataSourceBeanLst = new ArrayList<>();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "処理年月日", String.valueOf(syoriYmd)));

        String kanjiSosikinm = "";

        String dairitenKykSosikicd = YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd();

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(dairitenKykSosikicd, null);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            kanjiSosikinm = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());
        }

        String  tyouhyouYmd = DateFormatUtil.dateKANJI(syoriYmd);

        SkSakujokeiyakumeisailistBean skSakujokeiyakumeisailistBean =
            SWAKInjector.getInstance(SkSakujokeiyakumeisailistBean.class);

        skSakujokeiyakumeisailistBean.setIrAtesaki(kanjiSosikinm);
        skSakujokeiyakumeisailistBean.setIrTyouhyousakuseiymd(tyouhyouYmd);

        createSakujokeiyakumeisailist(C_Tuukasyu.JPY, new C_NyktyhyoutKbn[] { C_NyktyhyoutKbn.NONE,
            C_NyktyhyoutKbn.GAIKADATE });

        createSakujokeiyakumeisailist(C_Tuukasyu.USD, new C_NyktyhyoutKbn[] { C_NyktyhyoutKbn.NONE,
            C_NyktyhyoutKbn.GAIKADATE });

        createSakujokeiyakumeisailist(C_Tuukasyu.AUD, new C_NyktyhyoutKbn[] { C_NyktyhyoutKbn.NONE,
            C_NyktyhyoutKbn.GAIKADATE });

        GetSyoruicd getSyoruicd = SWAKInjector.getInstance(GetSyoruicd.class);

        C_SyoruiCdKbn syoruiCdKbn = getSyoruicd.getSyoruicd_Sakujyokykmeisailist();

        skSakujokeiyakumeisailistBean.setIrSyoruicd(syoruiCdKbn);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCdKbn);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(
            syoruiCdKbn,
            skSakujokeiyakumeisailistDataSourceBeanLst,
            skSakujokeiyakumeisailistBean
            );

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "削除契約明細リスト"));

        syoriKensuu = 0;

        skSakujokeiyakumeisailistDataSourceBeanLst = new ArrayList<>();

        createSakujokeiyakumeisailist(C_Tuukasyu.JPY, new C_NyktyhyoutKbn[] {C_NyktyhyoutKbn.YENDATE});

        syoruiCdKbn = C_SyoruiCdKbn.SK_SAKUJOKYKMEISAILIST_YENDT;

        skSakujokeiyakumeisailistBean.setIrSyoruicd(syoruiCdKbn);

        reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCdKbn);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(
            syoruiCdKbn,
            skSakujokeiyakumeisailistDataSourceBeanLst,
            skSakujokeiyakumeisailistBean
            );

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "削除契約明細リスト（円建）"));

    }

    private void createSakujokeiyakumeisailist(C_Tuukasyu nyukintuuka, C_NyktyhyoutKbn[] nyktyhyoutKbnLst) {

        try (ExDBResults<HT_HrkmNyknSakujyo> hrkmNyknSakujyoLst =
            skHurikomiSakujyoListSakuseiDao.getHrkmNyknSakujyosBySyoriYmdSyorizumiflgRstuukasyuNyktyhyoutlst(syoriYmd,
                nyukintuuka, nyktyhyoutKbnLst)) {

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(nyukintuuka);

            Iterator<HT_HrkmNyknSakujyo> iterator = hrkmNyknSakujyoLst.iterator();

            if (!iterator.hasNext()) {

                SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean =
                    SWAKInjector.getInstance(SkSakujokeiyakumeisailistDataSourceBean.class);

                skSakujokeiyakumeisailistDataSourceBean.setIrNyukintuuka(nyukintuuka.getContent() + "入金");
                skSakujokeiyakumeisailistDataSourceBean.setIrKensuugoukei(BizNumber.ZERO);
                skSakujokeiyakumeisailistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0, currencyType));

                skSakujokeiyakumeisailistDataSourceBeanLst.add(skSakujokeiyakumeisailistDataSourceBean);
            }
            else {

                SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean = null;
                String knjyYmd = "";
                String nyksyoriYmd = "";
                SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBeanGoukei =
                    SWAKInjector.getInstance(SkSakujokeiyakumeisailistDataSourceBean.class);
                BizNumber kensuuGoukei = BizNumber.ZERO;
                BizCurrency kingakuGoukei = BizCurrency.valueOf(0, currencyType);
                SetNyknRnrkhyouYmd setNyknRnrkhyouYmd = SWAKInjector.getInstance(SetNyknRnrkhyouYmd.class);

                while (iterator.hasNext()) {

                    HT_HrkmNyknSakujyo htHrkmNyknSakujyo = iterator.next();

                    skSakujokeiyakumeisailistDataSourceBean =
                        SWAKInjector.getInstance(SkSakujokeiyakumeisailistDataSourceBean.class);
                    knjyYmd = "";
                    nyksyoriYmd = "";
                    kensuuGoukei = kensuuGoukei.add(BizNumber.ONE);
                    kingakuGoukei = kingakuGoukei.add(htHrkmNyknSakujyo.getTrhkkgk());

                    if (htHrkmNyknSakujyo.getKnjyymd() != null) {

                        knjyYmd = DateFormatUtil.dateDOTNoEx(htHrkmNyknSakujyo.getKnjyymd());
                    }

                    BizDate nyknRnrkhyouYmd =setNyknRnrkhyouYmd.exec(htHrkmNyknSakujyo.getHrkmnykndatarenmotoKbn(),
                        htHrkmNyknSakujyo.getNyksyoriymd());

                    if (nyknRnrkhyouYmd != null) {

                        nyksyoriYmd = DateFormatUtil.dateDOTNoEx(nyknRnrkhyouYmd);
                    }

                    skSakujokeiyakumeisailistDataSourceBean.setIrNyukintuuka(htHrkmNyknSakujyo.getRstuukasyu().getContent() + "入金");
                    skSakujokeiyakumeisailistDataSourceBean.setIrOyadrtencd(htHrkmNyknSakujyo.getOyadrtencd());
                    skSakujokeiyakumeisailistDataSourceBean.setIrMosno(htHrkmNyknSakujyo.getNykmosno());
                    skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirninnm(htHrkmNyknSakujyo.getHrkmirninnm());
                    skSakujokeiyakumeisailistDataSourceBean.setIrNyknkkngk(htHrkmNyknSakujyo.getTrhkkgk());
                    skSakujokeiyakumeisailistDataSourceBean.setIrKnjyymd(knjyYmd);
                    skSakujokeiyakumeisailistDataSourceBean.setIrNyknsyoriymd(nyksyoriYmd);
                    skSakujokeiyakumeisailistDataSourceBean.setIrKouzano(htHrkmNyknSakujyo.getKouzano());
                    skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirnincd(htHrkmNyknSakujyo.getHrkmirnincd());
                    skSakujokeiyakumeisailistDataSourceBean.setIrKensuugoukei(null);
                    skSakujokeiyakumeisailistDataSourceBean.setIrKingakugoukei(null);

                    skSakujokeiyakumeisailistDataSourceBeanLst.add(skSakujokeiyakumeisailistDataSourceBean);

                    syoriKensuu++ ;

                    skSakujokeiyakumeisailistDataSourceBeanGoukei = skSakujokeiyakumeisailistDataSourceBean;
                }

                skSakujokeiyakumeisailistDataSourceBeanGoukei.setIrKensuugoukei(BizNumber.valueOf(kensuuGoukei));
                skSakujokeiyakumeisailistDataSourceBeanGoukei.setIrKingakugoukei(kingakuGoukei);
            }
        }
    }
}

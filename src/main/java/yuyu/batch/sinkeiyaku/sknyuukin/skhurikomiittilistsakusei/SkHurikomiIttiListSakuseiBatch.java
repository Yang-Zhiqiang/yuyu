package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomiittilistsakusei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikomiittilistsakusei.dba.SkHurikomiIttiListSakuseiDao;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.skcommon.GetSyoruicd;
import yuyu.common.sinkeiyaku.skcommon.SetNyknRnrkhyouYmd;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HW_HrkmNyknTaisyouWk;
import yuyu.def.sinkeiyaku.bean.report.SkDai1kaihokenryouittilistBean;
import yuyu.def.sinkeiyaku.bean.report.SkDai1kaihokenryouittilistDataSourceBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 入金 振込入金一致リスト作成
 */
public class SkHurikomiIttiListSakuseiBatch implements Batch {

    private List<IReportDataSouceBean> skDai1kaihokenryouittilistDataSourceBeanLst = null;

    private long syoriKensuu = 0;

    private BizDate syoriYmd = null;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private CreateReport createReport;

    @Inject
    private SkHurikomiIttiListSakuseiDao skHurikomiIttiListSakuseiDao;

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

        syoriYmd = bzBatchParam.getSyoriYmd();

        syoriKensuu = 0;

        skDai1kaihokenryouittilistDataSourceBeanLst = new ArrayList<>();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "処理年月日", String.valueOf(syoriYmd)));

        String dairitenKykSosikiCd = YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd();
        String kanjiSosikiNm = "";

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(dairitenKykSosikiCd, null);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            kanjiSosikiNm = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());
        }

        String tyouhyouYmd = DateFormatUtil.dateKANJI(syoriYmd);

        SkDai1kaihokenryouittilistBean skDai1kaihokenryouittilistBean =
            SWAKInjector.getInstance(SkDai1kaihokenryouittilistBean.class);

        skDai1kaihokenryouittilistBean.setIrAtesaki(kanjiSosikiNm);
        skDai1kaihokenryouittilistBean.setIrTyouhyousakuseiymd(tyouhyouYmd);

        createDai1kaihokenryouittilist(C_Tuukasyu.JPY, new C_NyktyhyoutKbn[] {C_NyktyhyoutKbn.NONE, C_NyktyhyoutKbn.GAIKADATE});

        createDai1kaihokenryouittilist(C_Tuukasyu.USD, new C_NyktyhyoutKbn[] {C_NyktyhyoutKbn.NONE, C_NyktyhyoutKbn.GAIKADATE});

        createDai1kaihokenryouittilist(C_Tuukasyu.AUD, new C_NyktyhyoutKbn[] {C_NyktyhyoutKbn.NONE, C_NyktyhyoutKbn.GAIKADATE});

        GetSyoruicd getSyoruicd = SWAKInjector.getInstance(GetSyoruicd.class);

        C_SyoruiCdKbn syoruiCdKbn = getSyoruicd.getSyoruicd_Dai1hknryittilist();

        skDai1kaihokenryouittilistBean.setIrSyoruicd(syoruiCdKbn);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCdKbn);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(
            syoruiCdKbn,
            skDai1kaihokenryouittilistDataSourceBeanLst,
            skDai1kaihokenryouittilistBean
            );

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "第１回保険料一致リスト"));

        syoriKensuu = 0;

        skDai1kaihokenryouittilistDataSourceBeanLst = new ArrayList<>();

        createDai1kaihokenryouittilist(C_Tuukasyu.JPY, new C_NyktyhyoutKbn[] {C_NyktyhyoutKbn.YENDATE});

        syoruiCdKbn = C_SyoruiCdKbn.SK_1PNYKNITTILIST_YENDT;

        skDai1kaihokenryouittilistBean.setIrSyoruicd(syoruiCdKbn);

        reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCdKbn);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(
            syoruiCdKbn,
            skDai1kaihokenryouittilistDataSourceBeanLst,
            skDai1kaihokenryouittilistBean
            );

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "第１回保険料一致リスト（円建）"));
    }

    private void createDai1kaihokenryouittilist(C_Tuukasyu pNyukintuuka, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        try (ExDBResults<HW_HrkmNyknTaisyouWk> hrkmNyknTaisyouWkLst =
                skHurikomiIttiListSakuseiDao.getHrkmNyknTaisyouWksBySyoriYmdRstuukasyuNyktyhyoutlst(syoriYmd, pNyukintuuka, pNyktyhyoutKbnList)) {

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pNyukintuuka);

            Iterator<HW_HrkmNyknTaisyouWk> iterator = hrkmNyknTaisyouWkLst.iterator();

            if (!iterator.hasNext()) {

                SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean =
                    SWAKInjector.getInstance(SkDai1kaihokenryouittilistDataSourceBean.class);

                skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka(pNyukintuuka.getContent() + "入金");
                skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei5(BizNumber.ZERO);
                skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0, currencyType));
                skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaipgoukei(BizCurrency.valueOf(0, currencyType));
                skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsrygoukei(BizCurrency.valueOf(0, currencyType));

                skDai1kaihokenryouittilistDataSourceBeanLst.add(skDai1kaihokenryouittilistDataSourceBean);
            }
            else {

                SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean = null;
                HT_SyoriCTL syoriCTL = null;
                String seiritujk = "";
                BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = null;
                HT_MosDairiten mosDairiten = null;
                String oyadrtencd = null;
                String drtennm = null;
                BizCurrency dai1kaip = null;
                String ryosyuYmd = null;
                String nyksyoriYmd = null;
                String jigyouhiCd = YuyuSinkeiyakuConfig.getInstance().getJigyouhicd();
                SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDsBeanGoukei =
                    SWAKInjector.getInstance(SkDai1kaihokenryouittilistDataSourceBean.class);
                BizNumber kensuuGoukei = BizNumber.ZERO;
                BizCurrency kingakuGoukei = BizCurrency.valueOf(0, currencyType);
                BizCurrency hrkmtsryGoukei = BizCurrency.valueOf(0, currencyType);
                BizCurrency dai1kaipGoukei = BizCurrency.valueOf(0, currencyType);
                SetNyknRnrkhyouYmd setNyknRnrkhyouYmd =  SWAKInjector.getInstance(SetNyknRnrkhyouYmd.class);

                while (iterator.hasNext()) {

                    HW_HrkmNyknTaisyouWk hrkmNyknTaisyouWk = iterator.next();

                    skDai1kaihokenryouittilistDataSourceBean =
                        SWAKInjector.getInstance(SkDai1kaihokenryouittilistDataSourceBean.class);

                    seiritujk = "";
                    oyadrtencd = "";
                    drtennm = "";
                    dai1kaip = BizCurrency.optional();
                    ryosyuYmd = "";
                    nyksyoriYmd = "";
                    kensuuGoukei = kensuuGoukei.add(BizNumber.ONE);
                    kingakuGoukei = kingakuGoukei.add(hrkmNyknTaisyouWk.getRsgaku());
                    hrkmtsryGoukei = hrkmtsryGoukei.add(hrkmNyknTaisyouWk.getHrkmtsry());

                    syoriCTL = sinkeiyakuDomManager.getSyoriCTL(hrkmNyknTaisyouWk.getMosno());

                    if (syoriCTL == null) {
                        throw new BizAppException(
                            MessageId.EBS0004, HT_SyoriCTL.TABLE_NAME, HT_SyoriCTL.MOSNO, hrkmNyknTaisyouWk.getMosno());
                    }

                    seiritujk = syoriCTL.getSeiritukbn().getContent();

                    mosDairiten = syoriCTL.getMosDairitenByRenno(1);

                    if (mosDairiten != null) {
                        oyadrtencd = mosDairiten.getOyadrtencd();
                    }
                    else {
                        oyadrtencd = "";
                    }

                    bzGetAgInfoBeanLst = bzGetAgInfo.exec(oyadrtencd);

                    for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
                        if (bzGetAgInfoBean != null &&
                            C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                            drtennm = bzGetAgInfoBean.getKanjiDairitenNm();

                            break;
                        }
                    }

                    dai1kaip = hrkmNyknTaisyouWk.getRsgaku().add(hrkmNyknTaisyouWk.getHrkmtsry());
                    dai1kaipGoukei = dai1kaipGoukei.add(dai1kaip);

                    if (hrkmNyknTaisyouWk.getRyosyuymd() != null) {
                        ryosyuYmd = DateFormatUtil.dateDOTNoEx(hrkmNyknTaisyouWk.getRyosyuymd());
                    }

                    BizDate nyknRenrakuhyouYmd = setNyknRnrkhyouYmd.exec(
                        hrkmNyknTaisyouWk.getHrkmnykndatarenmotoKbn(), hrkmNyknTaisyouWk.getNyksyoriymd());

                    if (nyknRenrakuhyouYmd != null) {
                        nyksyoriYmd = DateFormatUtil.dateDOTNoEx(nyknRenrakuhyouYmd);
                    }

                    skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka(
                        hrkmNyknTaisyouWk.getRstuukasyu().getContent() + "入金");
                    skDai1kaihokenryouittilistDataSourceBean.setIrJigyouhiutiwakecd(jigyouhiCd);
                    skDai1kaihokenryouittilistDataSourceBean.setIrDrtennmkj(drtennm);
                    skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd(ryosyuYmd);
                    skDai1kaihokenryouittilistDataSourceBean.setIrMosno(hrkmNyknTaisyouWk.getMosno());
                    skDai1kaihokenryouittilistDataSourceBean.setIrHrkmirninnm(hrkmNyknTaisyouWk.getHrkmirninnm());
                    skDai1kaihokenryouittilistDataSourceBean.setIrNyknkkngk(hrkmNyknTaisyouWk.getRsgaku());
                    skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaip(dai1kaip);
                    skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsry(hrkmNyknTaisyouWk.getHrkmtsry());
                    skDai1kaihokenryouittilistDataSourceBean.setIrNyknrnrkhyouymd(nyksyoriYmd);
                    skDai1kaihokenryouittilistDataSourceBean.setIrSeiritujk(seiritujk);
                    skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei5(null);
                    skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(null);
                    skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaipgoukei(null);
                    skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsrygoukei(null);

                    skDai1kaihokenryouittilistDataSourceBeanLst.add(skDai1kaihokenryouittilistDataSourceBean);

                    syoriKensuu++ ;
                    skDai1kaihokenryouittilistDsBeanGoukei = skDai1kaihokenryouittilistDataSourceBean;
                }

                skDai1kaihokenryouittilistDsBeanGoukei.setIrKensuugoukei5(kensuuGoukei);
                skDai1kaihokenryouittilistDsBeanGoukei.setIrKingakugoukei(kingakuGoukei);
                skDai1kaihokenryouittilistDsBeanGoukei.setIrDai1kaipgoukei(dai1kaipGoukei);
                skDai1kaihokenryouittilistDsBeanGoukei.setIrHrkmtsrygoukei(hrkmtsryGoukei);
            }
        }
    }
}

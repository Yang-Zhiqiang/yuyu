package yuyu.batch.suuri.srkessan.srskoikomisyuukeihyoupdenpyoulist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.suuri.srcommon.SrFindTekiyouCategory;
import yuyu.common.suuri.srcommon.SrFindTekiyouCategoryBean;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_FuriTaniHanteiKekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.suuri.bean.report.SrSkOikomiPDenpyouBean;
import yuyu.def.suuri.bean.report.SrSkOikomiPDenpyouDataSourceBean;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.result.bean.SkOikmTyouseiDenpyouHkrDnpsBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約追込集計表（保険料伝票リスト）作成クラス
 */
public class SrSkOikomiSyuukeihyouPDenpyouList implements Batch {

    @Inject
    private SrSkOikomiSyuukeihyouPDenpyouListBatchParam srSkOikomiSyuukeihyouPDenpyouListBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private CreateReport createReport;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BizDomManager bizDomManager;

    private static final String GOUKEI = "合計";

    private int kensuu;

    @Override
    public BatchParam getParam() {
        return srSkOikomiSyuukeihyouPDenpyouListBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        srSkOikomiSyuukeihyouPDenpyouListBatchParam.setParam();

        try (
            ExDBResults<SkOikmTyouseiDenpyouHkrDnpsBean> skOikmTyouseiDenpyouHkrDnpsBeanLst = suuriDomManager
            .getSkOikmTyouseiDenpyouHkrDnps();) {

            SrSkOikomiPDenpyouBean srSkOikomiPDenpyouBean = null;
            List<IReportDataSouceBean> srSkOikomiPDenpyouDataSourceBeanLst = new ArrayList<>();
            List<SrSkOikomiPDenpyouDataSourceBean> srSkOikomiPDenpyouDataSourceBeanTmpLst = new ArrayList<>();
            SkOikmTyouseiDenpyouHkrDnpsBean skOikmTyouseiDenpyouHkrDnpsPreBean = SWAKInjector
                .getInstance(SkOikmTyouseiDenpyouHkrDnpsBean.class);
            kensuu = 0;

            Iterator<SkOikmTyouseiDenpyouHkrDnpsBean> skOikmTyouseiDenpyouHkrDnpsBeanIt =
                skOikmTyouseiDenpyouHkrDnpsBeanLst.iterator();

            if (!skOikmTyouseiDenpyouHkrDnpsBeanIt.hasNext()) {
                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                    String.valueOf(srSkOikomiPDenpyouDataSourceBeanLst.size()), "新契約追込集計表（保険料伝票リスト）"));

                return;
            }

            while (skOikmTyouseiDenpyouHkrDnpsBeanIt.hasNext()) {
                SkOikmTyouseiDenpyouHkrDnpsBean skOikmTyouseiDenpyouHkrDnpsBean = skOikmTyouseiDenpyouHkrDnpsBeanIt
                    .next();

                if (srSkOikomiPDenpyouBean == null) {

                    srSkOikomiPDenpyouBean = SWAKInjector.getInstance(SrSkOikomiPDenpyouBean.class);

                    srSkOikomiPDenpyouBean.setIrKessannnd(srSkOikomiSyuukeihyouPDenpyouListBatchParam
                        .getNendo());
                    srSkOikomiPDenpyouBean.setIrKessanki(srSkOikomiSyuukeihyouPDenpyouListBatchParam
                        .getKessankiKanji());
                    srSkOikomiPDenpyouBean.setIrSakuseiymdwareki(DateFormatUtil
                        .dateKANJINoEx(srSkOikomiSyuukeihyouPDenpyouListBatchParam.getSyoriYmd()));

                    skOikmTyouseiDenpyouHkrDnpsPreBean = skOikmTyouseiDenpyouHkrDnpsBean;
                    kensuu = 1;

                    continue;
                }

                C_FuriTaniHanteiKekkaKbn kekkaKbn = getTaniKbn(skOikmTyouseiDenpyouHkrDnpsBean,
                    skOikmTyouseiDenpyouHkrDnpsPreBean);

                if (C_FuriTaniHanteiKekkaKbn.DOUITUDENMEISAI.eq(kekkaKbn)) {

                    skOikmTyouseiDenpyouHkrDnpsPreBean.setDenyenkagk(skOikmTyouseiDenpyouHkrDnpsPreBean.getDenyenkagk()
                        .add(skOikmTyouseiDenpyouHkrDnpsBean.getDenyenkagk()));

                    kensuu = kensuu + 1;
                }
                else if (C_FuriTaniHanteiKekkaKbn.DOUITUDEN.eq(kekkaKbn)) {

                    addSkOikomiPDenpyouMeisai(srSkOikomiPDenpyouDataSourceBeanTmpLst,
                        skOikmTyouseiDenpyouHkrDnpsPreBean);

                    skOikmTyouseiDenpyouHkrDnpsPreBean = skOikmTyouseiDenpyouHkrDnpsBean;

                    kensuu = 1;
                }
                else if (C_FuriTaniHanteiKekkaKbn.BETUDEN.eq(kekkaKbn)) {

                    addSkOikomiPDenpyouMeisai(srSkOikomiPDenpyouDataSourceBeanTmpLst,
                        skOikmTyouseiDenpyouHkrDnpsPreBean);

                    Boolean result = createMeisaiGoukei(srSkOikomiPDenpyouDataSourceBeanTmpLst);

                    if (result) {

                        srSkOikomiPDenpyouDataSourceBeanLst.addAll(srSkOikomiPDenpyouDataSourceBeanTmpLst);
                    }

                    srSkOikomiPDenpyouDataSourceBeanTmpLst = new ArrayList<>();

                    skOikmTyouseiDenpyouHkrDnpsPreBean = skOikmTyouseiDenpyouHkrDnpsBean;
                    kensuu = 1;
                }
            }

            addSkOikomiPDenpyouMeisai(srSkOikomiPDenpyouDataSourceBeanTmpLst, skOikmTyouseiDenpyouHkrDnpsPreBean);

            Boolean result = createMeisaiGoukei(srSkOikomiPDenpyouDataSourceBeanTmpLst);

            if (result) {

                srSkOikomiPDenpyouDataSourceBeanLst.addAll(srSkOikomiPDenpyouDataSourceBeanTmpLst);
            }

            if (srSkOikomiPDenpyouDataSourceBeanLst.size() > 0) {

                ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                    kinou.getSubSystemId(),
                    kinou.getCategoryId(),
                    kinou.getKinouId(),
                    C_SyoruiCdKbn.SR_OIKOMISYUUKEIPDENPYOU);

                reportServicesBean.setSyoriYmd(srSkOikomiSyuukeihyouPDenpyouListBatchParam.getSyoriYmd());

                reportServicesBean.addParamObjects(
                    srSkOikomiPDenpyouDataSourceBeanLst,
                    srSkOikomiPDenpyouBean);

                createReport.exec(new ReportServicesBean[] { reportServicesBean });
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(srSkOikomiPDenpyouDataSourceBeanLst.size()), "新契約追込集計表（保険料伝票リスト）"));
        }
    }

    private C_FuriTaniHanteiKekkaKbn getTaniKbn(SkOikmTyouseiDenpyouHkrDnpsBean pSkOikmTyouseiDenpyouHkrDnpsBean,
        SkOikmTyouseiDenpyouHkrDnpsBean pSkOikmTyouseiDenpyouHkrDnpsPreBean) {

        if (pSkOikmTyouseiDenpyouHkrDnpsBean.getHuridenatesakicd().equals(
            pSkOikmTyouseiDenpyouHkrDnpsPreBean.getHuridenatesakicd()) &&
            pSkOikmTyouseiDenpyouHkrDnpsBean.getTantocd().eq(
                pSkOikmTyouseiDenpyouHkrDnpsPreBean.getTantocd())) {
            if (pSkOikmTyouseiDenpyouHkrDnpsBean.getKanjyoukmkgroupkbn().eq(
                pSkOikmTyouseiDenpyouHkrDnpsPreBean.getKanjyoukmkgroupkbn()) &&
                pSkOikmTyouseiDenpyouHkrDnpsBean.getKanjyoukmkcd().eq(
                    pSkOikmTyouseiDenpyouHkrDnpsPreBean.getKanjyoukmkcd()) &&
                    pSkOikmTyouseiDenpyouHkrDnpsBean.getTaisyakukbn().eq(
                        pSkOikmTyouseiDenpyouHkrDnpsPreBean.getTaisyakukbn()) &&
                        pSkOikmTyouseiDenpyouHkrDnpsBean.getNaibukeiyakukbn().eq(
                            pSkOikmTyouseiDenpyouHkrDnpsPreBean.getNaibukeiyakukbn()) &&
                            pSkOikmTyouseiDenpyouHkrDnpsBean.getTekiyoukbn().eq(
                                pSkOikmTyouseiDenpyouHkrDnpsPreBean.getTekiyoukbn()) &&
                                pSkOikmTyouseiDenpyouHkrDnpsBean.getSeg1cd().eq(
                                    pSkOikmTyouseiDenpyouHkrDnpsPreBean.getSeg1cd())) {
                return C_FuriTaniHanteiKekkaKbn.DOUITUDENMEISAI;
            }

            return C_FuriTaniHanteiKekkaKbn.DOUITUDEN;
        }

        return C_FuriTaniHanteiKekkaKbn.BETUDEN;
    }

    private void addSkOikomiPDenpyouMeisai(
        List<SrSkOikomiPDenpyouDataSourceBean> pSrSkOikomiPDenpyouDataSourceBeanLst,
        SkOikmTyouseiDenpyouHkrDnpsBean pSkOikmTyouseiDenpyouHkrDnpsBean) {

        pSrSkOikomiPDenpyouDataSourceBeanLst.add(editSkOikomiPDenpyouMeisai(pSkOikmTyouseiDenpyouHkrDnpsBean));
    }

    private SrSkOikomiPDenpyouDataSourceBean editSkOikomiPDenpyouMeisai(
        SkOikmTyouseiDenpyouHkrDnpsBean pSkOikmTyouseiDenpyouHkrDnpsBean) {

        SrSkOikomiPDenpyouDataSourceBean srSkOikomiPDenpyouDataSourceBean = SWAKInjector
            .getInstance(SrSkOikomiPDenpyouDataSourceBean.class);

        String soshikiCd = null;

        BM_TantouCd bmTantouCd = bizDomManager.getTantouCd(pSkOikmTyouseiDenpyouHkrDnpsBean.getTantocd());

        if (bmTantouCd != null && !BizUtil.isBlank(bmTantouCd.getBusitucd())) {

            soshikiCd = bmTantouCd.getBusitucd() + "0000";
        }
        else {

            soshikiCd = pSkOikmTyouseiDenpyouHkrDnpsBean.getHuridenatesakicd() + "0000";
        }

        AM_Sosiki sosiki = baseDomManager.getSosiki(soshikiCd);

        srSkOikomiPDenpyouDataSourceBean.setIrHuridenatesakinm(sosiki.getKanjisosikinm20());

        SrFindTekiyouCategory srFindTekiyouCategory = SWAKInjector.getInstance(SrFindTekiyouCategory.class);
        SrFindTekiyouCategoryBean srFindTekiyouCategoryBean = srFindTekiyouCategory.getAppropriateTekiyou(
            pSkOikmTyouseiDenpyouHkrDnpsBean.getKanjyoukmkcd(),
            pSkOikmTyouseiDenpyouHkrDnpsBean.getTekiyoukbn(),
            pSkOikmTyouseiDenpyouHkrDnpsBean.getNaibukeiyakukbn(),
            pSkOikmTyouseiDenpyouHkrDnpsBean.getSeg1cd(),
            pSkOikmTyouseiDenpyouHkrDnpsBean.getSegnm());

        if (C_TaisyakuKbn.KASIKATA.eq(pSkOikmTyouseiDenpyouHkrDnpsBean.getTaisyakukbn())) {

            srSkOikomiPDenpyouDataSourceBean.setIrKanjyoukmkcdkasi(pSkOikmTyouseiDenpyouHkrDnpsBean.getKanjyoukmkcd()
                .getValue());
            srSkOikomiPDenpyouDataSourceBean.setIrKasikanjyoukmknm(pSkOikmTyouseiDenpyouHkrDnpsBean.getKanjyoukmknm());
            srSkOikomiPDenpyouDataSourceBean.setIrTekiyoucdkasi(srFindTekiyouCategoryBean.getTekiyoucd());
            srSkOikomiPDenpyouDataSourceBean.setIrTekiyoukasi(srFindTekiyouCategoryBean.getTekiyounm());
            srSkOikomiPDenpyouDataSourceBean.setIrKasikatagk(pSkOikmTyouseiDenpyouHkrDnpsBean.getDenyenkagk());
            srSkOikomiPDenpyouDataSourceBean.setIrGoukeikensuukasikata(BizNumber.valueOf(kensuu));
        }

        return srSkOikomiPDenpyouDataSourceBean;
    }

    private Boolean createMeisaiGoukei(List<SrSkOikomiPDenpyouDataSourceBean> pSrSkOikomiPDenpyouDataSourceBeanLst) {

        BizCurrency kasiKataGk = BizCurrency.valueOf(0);
        BizNumber kasiKensuu = BizNumber.valueOf(0);

        for (SrSkOikomiPDenpyouDataSourceBean srSkOikomiPDenpyouDataSourceBean : pSrSkOikomiPDenpyouDataSourceBeanLst) {

            kasiKataGk = kasiKataGk.add(srSkOikomiPDenpyouDataSourceBean.getIrKasikatagk());
            kasiKensuu = kasiKensuu.add(srSkOikomiPDenpyouDataSourceBean.getIrGoukeikensuukasikata());
        }

        if (kasiKensuu.equals(BizNumber.valueOf(0))) {

            return false;
        }

        SrSkOikomiPDenpyouDataSourceBean srSkOikomiPDenpyouDataSourceBean = SWAKInjector
            .getInstance(SrSkOikomiPDenpyouDataSourceBean.class);

        srSkOikomiPDenpyouDataSourceBean.setIrHuridenatesakinm(pSrSkOikomiPDenpyouDataSourceBeanLst.get(0)
            .getIrHuridenatesakinm());
        srSkOikomiPDenpyouDataSourceBean.setIrKasikanjyoukmknm(GOUKEI);
        srSkOikomiPDenpyouDataSourceBean.setIrKasikatagk(kasiKataGk);
        srSkOikomiPDenpyouDataSourceBean.setIrGoukeikensuukasikata(kasiKensuu);

        pSrSkOikomiPDenpyouDataSourceBeanLst.add(srSkOikomiPDenpyouDataSourceBean);

        return true;
    }
}

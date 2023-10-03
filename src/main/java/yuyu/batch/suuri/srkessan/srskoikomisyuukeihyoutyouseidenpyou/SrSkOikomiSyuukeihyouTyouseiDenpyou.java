package yuyu.batch.suuri.srkessan.srskoikomisyuukeihyoutyouseidenpyou;

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
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.suuri.bean.report.SrSkOikomiTyouseiDenpyouBean;
import yuyu.def.suuri.bean.report.SrSkOikomiTyouseiDenpyouDataSourceBean;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.result.bean.SkOikmTyouseiDenpyouInfosBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約追込集計表（調整伝票）作成クラス
 */
public class SrSkOikomiSyuukeihyouTyouseiDenpyou implements Batch {

    @Inject
    private SrSkOikomiSyuukeihyouTyouseiDenpyouBatchParam srSkOikomiSyuukeihyouTyouseiDenpyouBatchParam;

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
        return srSkOikomiSyuukeihyouTyouseiDenpyouBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        srSkOikomiSyuukeihyouTyouseiDenpyouBatchParam.setParam();

        try (ExDBResults<SkOikmTyouseiDenpyouInfosBean> skOikmTyouseiDenpyouInfosBeanLst = suuriDomManager
            .getSkOikmTyouseiDenpyouInfos();) {

            SrSkOikomiTyouseiDenpyouBean srSkOikomiTyouseiDenpyouBean = null;
            List<IReportDataSouceBean> srSkOikomiTyouseiDenpyouDataSourceBeanLst = new ArrayList<>();
            List<SrSkOikomiTyouseiDenpyouDataSourceBean> srSkOikomiTyouseiDenpyouDataSourceBeanTmpLst =
                new ArrayList<>();
            SkOikmTyouseiDenpyouInfosBean skOikmTyouseiDenpyouInfosBeanPre = SWAKInjector
                .getInstance(SkOikmTyouseiDenpyouInfosBean.class);
            kensuu = 0;


            Iterator<SkOikmTyouseiDenpyouInfosBean> iterator = skOikmTyouseiDenpyouInfosBeanLst.iterator();
            if (!iterator.hasNext()) {
                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                    String.valueOf(srSkOikomiTyouseiDenpyouDataSourceBeanLst.size()), "新契約追込集計表（調整伝票）"));

                return;
            }

            while (iterator.hasNext()) {
                SkOikmTyouseiDenpyouInfosBean skOikmTyouseiDenpyouInfosBean = iterator.next();

                if (srSkOikomiTyouseiDenpyouBean == null) {

                    srSkOikomiTyouseiDenpyouBean = SWAKInjector.getInstance(SrSkOikomiTyouseiDenpyouBean.class);

                    srSkOikomiTyouseiDenpyouBean.setIrKessannnd(srSkOikomiSyuukeihyouTyouseiDenpyouBatchParam
                        .getNendo());
                    srSkOikomiTyouseiDenpyouBean.setIrKessanki(srSkOikomiSyuukeihyouTyouseiDenpyouBatchParam
                        .getKessankiKanji());
                    srSkOikomiTyouseiDenpyouBean.setIrSakuseiymdwareki(DateFormatUtil
                        .dateKANJINoEx(srSkOikomiSyuukeihyouTyouseiDenpyouBatchParam.getSyoriYmd()));

                    skOikmTyouseiDenpyouInfosBeanPre = skOikmTyouseiDenpyouInfosBean;
                    kensuu = 1;
                    continue;
                }

                C_FuriTaniHanteiKekkaKbn kekkaKbn = getTaniKbn(skOikmTyouseiDenpyouInfosBean,
                    skOikmTyouseiDenpyouInfosBeanPre);

                if (C_FuriTaniHanteiKekkaKbn.DOUITUDENMEISAI.eq(kekkaKbn)) {

                    skOikmTyouseiDenpyouInfosBeanPre.setDenyenkagk(
                        skOikmTyouseiDenpyouInfosBeanPre.getDenyenkagk()
                        .add(skOikmTyouseiDenpyouInfosBean.getDenyenkagk()));

                    kensuu = kensuu + 1;
                }
                else if (C_FuriTaniHanteiKekkaKbn.DOUITUDEN.eq(kekkaKbn)) {

                    addSkOikmTyouseiDenpyouMeisai(srSkOikomiTyouseiDenpyouDataSourceBeanTmpLst,
                        skOikmTyouseiDenpyouInfosBeanPre);

                    skOikmTyouseiDenpyouInfosBeanPre = skOikmTyouseiDenpyouInfosBean;

                    kensuu = 1;
                }
                else if (C_FuriTaniHanteiKekkaKbn.BETUDEN.eq(kekkaKbn)) {

                    addSkOikmTyouseiDenpyouMeisai(srSkOikomiTyouseiDenpyouDataSourceBeanTmpLst,
                        skOikmTyouseiDenpyouInfosBeanPre);

                    Boolean result = createMeisaiGoukei(srSkOikomiTyouseiDenpyouDataSourceBeanTmpLst);

                    if (result) {

                        srSkOikomiTyouseiDenpyouDataSourceBeanLst.addAll(
                            srSkOikomiTyouseiDenpyouDataSourceBeanTmpLst);
                    }

                    srSkOikomiTyouseiDenpyouDataSourceBeanTmpLst = new ArrayList<>();

                    skOikmTyouseiDenpyouInfosBeanPre = skOikmTyouseiDenpyouInfosBean;
                    kensuu = 1;
                }
            }

            addSkOikmTyouseiDenpyouMeisai(srSkOikomiTyouseiDenpyouDataSourceBeanTmpLst,
                skOikmTyouseiDenpyouInfosBeanPre);

            Boolean result = createMeisaiGoukei(srSkOikomiTyouseiDenpyouDataSourceBeanTmpLst);

            if (result) {

                srSkOikomiTyouseiDenpyouDataSourceBeanLst.addAll(srSkOikomiTyouseiDenpyouDataSourceBeanTmpLst);
            }

            if (srSkOikomiTyouseiDenpyouDataSourceBeanLst.size() > 0) {

                ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                    kinou.getSubSystemId(),
                    kinou.getCategoryId(),
                    kinou.getKinouId(),
                    C_SyoruiCdKbn.SR_OIKOMISYUUKEIHYOUTYOUSEI);

                reportServicesBean.setSyoriYmd(srSkOikomiSyuukeihyouTyouseiDenpyouBatchParam.getSyoriYmd());

                reportServicesBean.addParamObjects(
                    srSkOikomiTyouseiDenpyouDataSourceBeanLst,
                    srSkOikomiTyouseiDenpyouBean);

                createReport.exec(new ReportServicesBean[] { reportServicesBean });
            }
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(srSkOikomiTyouseiDenpyouDataSourceBeanLst.size()), "新契約追込集計表（調整伝票）"));
        }
    }

    private C_FuriTaniHanteiKekkaKbn getTaniKbn(SkOikmTyouseiDenpyouInfosBean pSkOikmTyouseiDenpyouInfosBean,
        SkOikmTyouseiDenpyouInfosBean pSkOikmTyouseiDenpyouInfosBeanPre) {

        if (pSkOikmTyouseiDenpyouInfosBean.getHuridenatesakicd().equals(
            pSkOikmTyouseiDenpyouInfosBeanPre.getHuridenatesakicd())
            && pSkOikmTyouseiDenpyouInfosBean.getTantocd().eq(pSkOikmTyouseiDenpyouInfosBeanPre.getTantocd())) {
            if (pSkOikmTyouseiDenpyouInfosBean.getKanjyoukmkgroupkbn().eq(
                pSkOikmTyouseiDenpyouInfosBeanPre.getKanjyoukmkgroupkbn())
                && pSkOikmTyouseiDenpyouInfosBean.getKanjyoukmkcd().eq(
                    pSkOikmTyouseiDenpyouInfosBeanPre.getKanjyoukmkcd())
                    &&pSkOikmTyouseiDenpyouInfosBean.getTaisyakukbn().eq(
                        pSkOikmTyouseiDenpyouInfosBeanPre.getTaisyakukbn())
                        && pSkOikmTyouseiDenpyouInfosBean.getNaibukeiyakukbn().eq(
                            pSkOikmTyouseiDenpyouInfosBeanPre.getNaibukeiyakukbn())
                            && pSkOikmTyouseiDenpyouInfosBean.getTekiyoukbn().eq(
                                pSkOikmTyouseiDenpyouInfosBeanPre.getTekiyoukbn())
                                && pSkOikmTyouseiDenpyouInfosBean.getSeg1cd().eq(
                                    pSkOikmTyouseiDenpyouInfosBeanPre.getSeg1cd())) {

                return C_FuriTaniHanteiKekkaKbn.DOUITUDENMEISAI;
            }

            return C_FuriTaniHanteiKekkaKbn.DOUITUDEN;
        }

        return C_FuriTaniHanteiKekkaKbn.BETUDEN;
    }

    private void addSkOikmTyouseiDenpyouMeisai(
        List<SrSkOikomiTyouseiDenpyouDataSourceBean> pSrSkOikomiTyouseiDenpyouDataSourceBeanLst,
        SkOikmTyouseiDenpyouInfosBean pSkOikmTyouseiDenpyouInfosBean) {

        for (SrSkOikomiTyouseiDenpyouDataSourceBean srSkOikomiTyouseiDenpyouDataSourceBean : pSrSkOikomiTyouseiDenpyouDataSourceBeanLst) {

            if (C_TaisyakuKbn.KARIKATA.eq(pSkOikmTyouseiDenpyouInfosBean.getTaisyakukbn()) &&
                BizUtil.isBlank(srSkOikomiTyouseiDenpyouDataSourceBean.getIrKanjyoukmkcdkari())) {

                editSkOikmTyouseiDenpyouMeisai(srSkOikomiTyouseiDenpyouDataSourceBean, pSkOikmTyouseiDenpyouInfosBean);

                return;
            }
            else if (C_TaisyakuKbn.KASIKATA.eq(pSkOikmTyouseiDenpyouInfosBean.getTaisyakukbn()) &&
                BizUtil.isBlank(srSkOikomiTyouseiDenpyouDataSourceBean.getIrKanjyoukmkcdkasi())) {

                editSkOikmTyouseiDenpyouMeisai(srSkOikomiTyouseiDenpyouDataSourceBean, pSkOikmTyouseiDenpyouInfosBean);

                return;
            }
        }

        pSrSkOikomiTyouseiDenpyouDataSourceBeanLst.add(editSkOikmTyouseiDenpyouMeisai(null,
            pSkOikmTyouseiDenpyouInfosBean));
    }

    private SrSkOikomiTyouseiDenpyouDataSourceBean editSkOikmTyouseiDenpyouMeisai(
        SrSkOikomiTyouseiDenpyouDataSourceBean pSrSkOikomiTyouseiDenpyouDataSourceBean,
        SkOikmTyouseiDenpyouInfosBean pSkOikmTyouseiDenpyouInfosBean) {

        if (pSrSkOikomiTyouseiDenpyouDataSourceBean == null) {

            SrSkOikomiTyouseiDenpyouDataSourceBean srSkOikomiTyouseiDenpyouDataSourceBeanTmp = SWAKInjector
                .getInstance(SrSkOikomiTyouseiDenpyouDataSourceBean.class);

            String soshikiCd = null;
            BM_TantouCd tantouCd = null;

            if (pSkOikmTyouseiDenpyouInfosBean.getTantocd() != null &&
                !C_TantouCdKbn.BLNK0.eq(pSkOikmTyouseiDenpyouInfosBean.getTantocd())) {

                tantouCd = bizDomManager.getTantouCd(pSkOikmTyouseiDenpyouInfosBean.getTantocd());
            }
            if (tantouCd != null && !BizUtil.isBlank(tantouCd.getBusitucd())) {

                soshikiCd = tantouCd.getBusitucd() + "0000";
            }
            else {

                soshikiCd = pSkOikmTyouseiDenpyouInfosBean.getHuridenatesakicd() + "0000";
            }
            AM_Sosiki sosiki = baseDomManager.getSosiki(soshikiCd);

            srSkOikomiTyouseiDenpyouDataSourceBeanTmp.setIrHuridenatesakinm(sosiki.getKanjisosikinm20());

            SrFindTekiyouCategory srFindTekiyouCategory = SWAKInjector.getInstance(SrFindTekiyouCategory.class);
            SrFindTekiyouCategoryBean srFindTekiyouCategoryBean = srFindTekiyouCategory.getAppropriateTekiyou(
                pSkOikmTyouseiDenpyouInfosBean.getKanjyoukmkcd(),
                pSkOikmTyouseiDenpyouInfosBean.getTekiyoukbn(),
                pSkOikmTyouseiDenpyouInfosBean.getNaibukeiyakukbn(),
                pSkOikmTyouseiDenpyouInfosBean.getSeg1cd(),
                pSkOikmTyouseiDenpyouInfosBean.getSegnm());

            if (C_TaisyakuKbn.KARIKATA.eq(pSkOikmTyouseiDenpyouInfosBean.getTaisyakukbn())) {

                srSkOikomiTyouseiDenpyouDataSourceBeanTmp.setIrKanjyoukmkcdkari(pSkOikmTyouseiDenpyouInfosBean
                    .getKanjyoukmkcd().getValue());
                srSkOikomiTyouseiDenpyouDataSourceBeanTmp.setIrKarikanjyoukmknm(pSkOikmTyouseiDenpyouInfosBean
                    .getKanjyoukmknm());
                srSkOikomiTyouseiDenpyouDataSourceBeanTmp.setIrTekiyoucdkari(srFindTekiyouCategoryBean.getTekiyoucd());
                srSkOikomiTyouseiDenpyouDataSourceBeanTmp.setIrTekiyoukari(srFindTekiyouCategoryBean.getTekiyounm());
                srSkOikomiTyouseiDenpyouDataSourceBeanTmp.setIrKarikatagk(pSkOikmTyouseiDenpyouInfosBean
                    .getDenyenkagk());
                srSkOikomiTyouseiDenpyouDataSourceBeanTmp.setIrGoukeikensuukarikata(BizNumber.valueOf(kensuu));
            }
            else if (C_TaisyakuKbn.KASIKATA.eq(pSkOikmTyouseiDenpyouInfosBean.getTaisyakukbn())) {

                srSkOikomiTyouseiDenpyouDataSourceBeanTmp.setIrKanjyoukmkcdkasi(pSkOikmTyouseiDenpyouInfosBean
                    .getKanjyoukmkcd().getValue());
                srSkOikomiTyouseiDenpyouDataSourceBeanTmp.setIrKasikanjyoukmknm(pSkOikmTyouseiDenpyouInfosBean
                    .getKanjyoukmknm());
                srSkOikomiTyouseiDenpyouDataSourceBeanTmp.setIrTekiyoucdkasi(srFindTekiyouCategoryBean.getTekiyoucd());
                srSkOikomiTyouseiDenpyouDataSourceBeanTmp.setIrTekiyoukasi(srFindTekiyouCategoryBean.getTekiyounm());
                srSkOikomiTyouseiDenpyouDataSourceBeanTmp.setIrKasikatagk(pSkOikmTyouseiDenpyouInfosBean
                    .getDenyenkagk());
                srSkOikomiTyouseiDenpyouDataSourceBeanTmp.setIrGoukeikensuukasikata(BizNumber.valueOf(kensuu));

            }

            return srSkOikomiTyouseiDenpyouDataSourceBeanTmp;
        }

        SrFindTekiyouCategory srFindTekiyouCategory = SWAKInjector.getInstance(SrFindTekiyouCategory.class);
        SrFindTekiyouCategoryBean srFindTekiyouCategoryBean = srFindTekiyouCategory.getAppropriateTekiyou(
            pSkOikmTyouseiDenpyouInfosBean.getKanjyoukmkcd(),
            pSkOikmTyouseiDenpyouInfosBean.getTekiyoukbn(),
            pSkOikmTyouseiDenpyouInfosBean.getNaibukeiyakukbn(),
            pSkOikmTyouseiDenpyouInfosBean.getSeg1cd(),
            pSkOikmTyouseiDenpyouInfosBean.getSegnm());

        if (C_TaisyakuKbn.KARIKATA.eq(pSkOikmTyouseiDenpyouInfosBean.getTaisyakukbn())) {

            pSrSkOikomiTyouseiDenpyouDataSourceBean.setIrKanjyoukmkcdkari(pSkOikmTyouseiDenpyouInfosBean
                .getKanjyoukmkcd().getValue());
            pSrSkOikomiTyouseiDenpyouDataSourceBean.setIrKarikanjyoukmknm(pSkOikmTyouseiDenpyouInfosBean
                .getKanjyoukmknm());
            pSrSkOikomiTyouseiDenpyouDataSourceBean.setIrTekiyoucdkari(srFindTekiyouCategoryBean.getTekiyoucd());
            pSrSkOikomiTyouseiDenpyouDataSourceBean.setIrTekiyoukari(srFindTekiyouCategoryBean.getTekiyounm());
            pSrSkOikomiTyouseiDenpyouDataSourceBean.setIrKarikatagk(pSkOikmTyouseiDenpyouInfosBean.getDenyenkagk());
            pSrSkOikomiTyouseiDenpyouDataSourceBean.setIrGoukeikensuukarikata(BizNumber.valueOf(kensuu));

        }
        else if (C_TaisyakuKbn.KASIKATA.eq(pSkOikmTyouseiDenpyouInfosBean.getTaisyakukbn())) {

            pSrSkOikomiTyouseiDenpyouDataSourceBean.setIrKanjyoukmkcdkasi(pSkOikmTyouseiDenpyouInfosBean
                .getKanjyoukmkcd().getValue());
            pSrSkOikomiTyouseiDenpyouDataSourceBean.setIrKasikanjyoukmknm(pSkOikmTyouseiDenpyouInfosBean
                .getKanjyoukmknm());
            pSrSkOikomiTyouseiDenpyouDataSourceBean.setIrTekiyoucdkasi(srFindTekiyouCategoryBean.getTekiyoucd());
            pSrSkOikomiTyouseiDenpyouDataSourceBean.setIrTekiyoukasi(srFindTekiyouCategoryBean.getTekiyounm());
            pSrSkOikomiTyouseiDenpyouDataSourceBean.setIrKasikatagk(pSkOikmTyouseiDenpyouInfosBean.getDenyenkagk());
            pSrSkOikomiTyouseiDenpyouDataSourceBean.setIrGoukeikensuukasikata(BizNumber.valueOf(kensuu));
        }

        return pSrSkOikomiTyouseiDenpyouDataSourceBean;
    }

    private Boolean createMeisaiGoukei(
        List<SrSkOikomiTyouseiDenpyouDataSourceBean> pSrSkOikomiTyouseiDenpyouDataSourceBeanLst) {

        BizCurrency kariKataGk = BizCurrency.valueOf(0);
        BizNumber kariKensuu = BizNumber.valueOf(0);
        BizCurrency kasiKataGk = BizCurrency.valueOf(0);
        BizNumber kasiKensuu = BizNumber.valueOf(0);

        for (SrSkOikomiTyouseiDenpyouDataSourceBean srSkOikomiTyouseiDenpyouDataSourceBean : pSrSkOikomiTyouseiDenpyouDataSourceBeanLst) {

            kariKataGk = kariKataGk.add(srSkOikomiTyouseiDenpyouDataSourceBean.getIrKarikatagk());
            kariKensuu = kariKensuu.add(srSkOikomiTyouseiDenpyouDataSourceBean.getIrGoukeikensuukarikata());
            kasiKataGk = kasiKataGk.add(srSkOikomiTyouseiDenpyouDataSourceBean.getIrKasikatagk());
            kasiKensuu = kasiKensuu.add(srSkOikomiTyouseiDenpyouDataSourceBean.getIrGoukeikensuukasikata());

            if(BizUtil.isBlank(srSkOikomiTyouseiDenpyouDataSourceBean.getIrKanjyoukmkcdkari())){
                srSkOikomiTyouseiDenpyouDataSourceBean.setIrKarikatagk(null);
                srSkOikomiTyouseiDenpyouDataSourceBean.setIrGoukeikensuukarikata(null);
            }

            if(BizUtil.isBlank(srSkOikomiTyouseiDenpyouDataSourceBean.getIrKanjyoukmkcdkasi())){
                srSkOikomiTyouseiDenpyouDataSourceBean.setIrKasikatagk(null);
                srSkOikomiTyouseiDenpyouDataSourceBean.setIrGoukeikensuukasikata(null);
            }
        }

        if (kariKensuu.equals(BizNumber.valueOf(0)) && kasiKensuu.equals(BizNumber.valueOf(0))) {

            return false;
        }

        SrSkOikomiTyouseiDenpyouDataSourceBean srSkOikomiTyouseiDenpyouDataSourceBean = SWAKInjector
            .getInstance(SrSkOikomiTyouseiDenpyouDataSourceBean.class);

        srSkOikomiTyouseiDenpyouDataSourceBean.setIrHuridenatesakinm(pSrSkOikomiTyouseiDenpyouDataSourceBeanLst.get(0)
            .getIrHuridenatesakinm());
        srSkOikomiTyouseiDenpyouDataSourceBean.setIrKarikanjyoukmknm(GOUKEI);
        srSkOikomiTyouseiDenpyouDataSourceBean.setIrKarikatagk(kariKataGk);
        srSkOikomiTyouseiDenpyouDataSourceBean.setIrGoukeikensuukarikata(kariKensuu);
        srSkOikomiTyouseiDenpyouDataSourceBean.setIrKasikanjyoukmknm(GOUKEI);
        srSkOikomiTyouseiDenpyouDataSourceBean.setIrKasikatagk(kasiKataGk);
        srSkOikomiTyouseiDenpyouDataSourceBean.setIrGoukeikensuukasikata(kasiKensuu);

        pSrSkOikomiTyouseiDenpyouDataSourceBeanLst.add(srSkOikomiTyouseiDenpyouDataSourceBean);

        return true;
    }
}

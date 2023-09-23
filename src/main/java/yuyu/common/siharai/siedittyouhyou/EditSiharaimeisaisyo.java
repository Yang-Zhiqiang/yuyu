package yuyu.common.siharai.siedittyouhyou;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.siharai.sicommon.SiMeisaiCommonHensyu;
import yuyu.common.siharai.sicommon.SiMeisaiCommonHensyuResultBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.siharai.bean.report.SiShrmeisaiBean;
import yuyu.def.siharai.bean.report.SiShrmeisaiDataSourceBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 支払明細書編集
 */
public class EditSiharaimeisaisyo {

    private static final String BLNK = "";

    public static final int LINEMAXLEN = 24;

    private static final String FREEMSG_SANDZEIKIN = "FREEMSG_SANDZEIKIN";

    private static final String FREEMSG_ZEIKINSYURUI = "FREEMSG_ZEIKINSYURUI";

    private static final String FREEMSG_SOUZOKUZEI = "FREEMSG_SOUZOKUZEI";

    private static final String FREEMSG_SYOTOKUZEI = "FREEMSG_SYOTOKUZEI";

    private static final String FREEMSG_ZOUYOZEI = "FREEMSG_ZOUYOZEI";

    private static final String FREEMSG_KAZEINENDO = "FREEMSG_KAZEINENDO";

    private static final String FREEMSG_TYOUSYOTST = "FREEMSG_TYOUSYOTST";

    private static final String FREEMSG_ZEIMUINFO = "FREEMSG_ZEIMUINFO";

    private static final String FREEMSG_ZEIMUINFOHIJNGAIKA = "FREEMSG_ZEIMUINFOHIJNGAIKA";

    private static final String FREEMSG_ZEIMUINFOHIJNYEN = "FREEMSG_ZEIMUINFOHIJNYEN";

    private static final String FREEMSG_KZITYSYOU = "FREEMSG_KZITYSYOU";

    private static final String FREEMSG_KYKSYAHNK = "FREEMSG_KYKSYAHNK";

    private static final String FREEMSG_SIHOSOKU = "FREEMSG_SIHOSOKU";

    private static final String FREEMSG_AZUKARIKIN = "FREEMSG_AZUKARIKIN";

    private static final String FREEMSG_MISYUUP = "FREEMSG_MISYUUP";

    private static final String FREEMSG_ZENNOUHNKN = "FREEMSG_ZENNOUHNKN";

    private static final String FREEMSG_MIKEIKAP = "FREEMSG_MIKEIKAP";

    private static final int FREEMSGGYOUSUU = 46;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private static Logger logger;

    @Inject
    private CreateReport createReport;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    public EditSiharaimeisaisyo() {
        super();
    }

    public List<ReportServicesBean> exec(EditSiharaimeisaisyoBean pEditSiharaimeisaisyoBean) {

        logger.debug("▽ 支払明細書編集 開始");

        if (pEditSiharaimeisaisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd() == null) {
            throw new BizAppException(MessageId.EJS1005, "syoriYmd");
        }
        if (pEditSiharaimeisaisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd() == null
            || C_SyoruiCdKbn.BLNK.eq(pEditSiharaimeisaisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd())) {
            throw new BizAppException(MessageId.EJS1005, "syoruiCd");
        }
        if (pEditSiharaimeisaisyoBean.getSeikyuusyaInfoBean() == null) {
            throw new BizAppException(MessageId.EJS1005, "seikyuusyaInfoBean");
        }
        if (pEditSiharaimeisaisyoBean.getToiawaseInfoBean() == null) {
            throw new BizAppException(MessageId.EJS1005, "toiawaseInfoBean");
        }
        if (pEditSiharaimeisaisyoBean.getSiDetailLst() == null) {
            throw new BizAppException(MessageId.EJS1005, "siDetailLst");
        }

        List<SiShrmeisaiDataSourceBean> siShrmeisaiDataSourceBeanList = editMeisai(pEditSiharaimeisaisyoBean);
        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        iReportDataSouceBeanLst.addAll(siShrmeisaiDataSourceBeanList);

        BizCurrency shrgkKei;
        if (isNotTuukasyuJPY(pEditSiharaimeisaisyoBean.getShrTuukasyu())) {
            shrgkKei = pEditSiharaimeisaisyoBean.getShrGk();
        } else {
            if (isTuukasyuJPY(pEditSiharaimeisaisyoBean.getKykTuukasyu())) {
                shrgkKei = pEditSiharaimeisaisyoBean.getShrGk();
            } else {
                shrgkKei = pEditSiharaimeisaisyoBean.getYenShrgk();
            }
        }

        List<ReportServicesBean> reportServicesBeanList = new ArrayList<>();

        String saikennmkj = pEditSiharaimeisaisyoBean.getSaikensyaInfoBean().getSaikennmkj();
        if (saikennmkj != null && !BLNK.equals(saikennmkj)) {

            SiShrmeisaiBean siShrmeisaiBeanForUketorinin = createSiShrmeisaiBeanForUketorinin(
                pEditSiharaimeisaisyoBean, shrgkKei);
            ReportServicesBean reportServicesBeanUketori = createReportServicesBean(pEditSiharaimeisaisyoBean);
            reportServicesBeanUketori.addParamObjects(iReportDataSouceBeanLst, siShrmeisaiBeanForUketorinin);
            reportServicesBeanList.add(reportServicesBeanUketori);

            SiShrmeisaiBean siShrmeisaiBeanForSaikensha = createSiShrmeisaiBeanForSaikensha(pEditSiharaimeisaisyoBean,
                shrgkKei);
            ReportServicesBean reportServicesBeanSaikensha = createReportServicesBean(pEditSiharaimeisaisyoBean);
            reportServicesBeanSaikensha.addParamObjects(iReportDataSouceBeanLst, siShrmeisaiBeanForSaikensha);
            reportServicesBeanList.add(reportServicesBeanSaikensha);

        } else {

            SiShrmeisaiBean siShrmeisaiBean = createSiShrmeisaiBeanForNormal(pEditSiharaimeisaisyoBean, shrgkKei);
            ReportServicesBean reportServicesBean = createReportServicesBean(pEditSiharaimeisaisyoBean);
            reportServicesBean.addParamObjects(iReportDataSouceBeanLst, siShrmeisaiBean);
            reportServicesBeanList.add(reportServicesBean);
        }

        logger.debug("△ 支払明細書編集 終了");

        return reportServicesBeanList;
    }

    private List<SiShrmeisaiDataSourceBean> editMeisai(EditSiharaimeisaisyoBean pEditSiharaimeisaisyoBean) {
        List<SiShrmeisaiDataSourceBean> siShrmeisaiDataSourceBeanLst = new ArrayList<>();

        SiMeisaiCommonHensyu siMeisaiCommonHensyu = SWAKInjector.getInstance(SiMeisaiCommonHensyu.class);
        C_ErrorKbn result = siMeisaiCommonHensyu.siMeisaiHensyu(pEditSiharaimeisaisyoBean.getSk(),
            pEditSiharaimeisaisyoBean.getSiDetailLst(), pEditSiharaimeisaisyoBean.getSibouYmd(),
            C_KanryotuutioutKbn.PDF);

        if (C_ErrorKbn.ERROR.eq(result)) {
            throw new BizAppException(MessageId.EJA1027);
        }

        List<SiMeisaiCommonHensyuResultBean> siMeisaiCommonHensyuResultBeanList = siMeisaiCommonHensyu
            .getSiMeisaiHensyuResult();

        for (SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBean : siMeisaiCommonHensyuResultBeanList) {
            SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean = SWAKInjector
                .getInstance(SiShrmeisaiDataSourceBean.class);
            siShrmeisaiDataSourceBean.setIrKyuuhuname(siMeisaiCommonHensyuResultBean.getTekiYou());
            siShrmeisaiDataSourceBean.setIrKyhkg(siMeisaiCommonHensyuResultBean.getShrGkMeisai());
            siShrmeisaiDataSourceBean.setIrShrdetailbikou(siMeisaiCommonHensyuResultBean.getDetailBikou());
            siShrmeisaiDataSourceBeanLst.add(siShrmeisaiDataSourceBean);
        }

        return siShrmeisaiDataSourceBeanLst;
    }

    private SiShrmeisaiBean createSiShrmeisaiBeanForUketorinin(EditSiharaimeisaisyoBean pEditSiharaimeisaisyoBean,
        BizCurrency shrgkKei) {
        SiShrmeisaiBean siShrmeisaiBean = createCommonSiShrmeisaiBean(pEditSiharaimeisaisyoBean, shrgkKei);

        SeikyuusyaInfoBean seikyuusyaInfoBean = pEditSiharaimeisaisyoBean.getSeikyuusyaInfoBean();
        siShrmeisaiBean.setIrShsyno(seikyuusyaInfoBean.getTsinyno());

        String[] results = ViewReport.editAdrDisp(LINEMAXLEN,
            seikyuusyaInfoBean.getTsinadr1kj(),
            seikyuusyaInfoBean.getTsinadr2kj(),
            seikyuusyaInfoBean.getTsinadr3kj());
        siShrmeisaiBean.setIrShadr1kj(results[0]);
        siShrmeisaiBean.setIrShadr2kj(results[1]);
        if (results.length > 2) {
            siShrmeisaiBean.setIrShadr3kj(results[2]);
        }

        siShrmeisaiBean.setIrShsnmkj(seikyuusyaInfoBean.getSeikyuusyanmKj());

        siShrmeisaiBean.setIrHhknnmkj(pEditSiharaimeisaisyoBean.getHhknnmKj());
        siShrmeisaiBean.setIrBanknmkj(BLNK);
        siShrmeisaiBean.setIrSitennmkj(BLNK);
        siShrmeisaiBean.setIrYokinknmkj(BLNK);
        siShrmeisaiBean.setIrKouzano(BLNK);
        siShrmeisaiBean.setIrKzmeiginmkn(BLNK);
        siShrmeisaiBean.setIrSaikenshrumukbn(C_UmuKbn.ARI);

        return siShrmeisaiBean;
    }

    private SiShrmeisaiBean createSiShrmeisaiBeanForSaikensha(EditSiharaimeisaisyoBean pEditSiharaimeisaisyoBean,
        BizCurrency shrgkKei) {
        SiShrmeisaiBean siShrmeisaiBean = createCommonSiShrmeisaiBean(pEditSiharaimeisaisyoBean, shrgkKei);

        SaikensyaInfoBean saikensyaInfoBean = pEditSiharaimeisaisyoBean.getSaikensyaInfoBean();
        siShrmeisaiBean.setIrShsyno(saikensyaInfoBean.getSaikennyno());

        String[] results = ViewReport.editAdrDisp(LINEMAXLEN,
            saikensyaInfoBean.getSaikenadr1kj(),
            saikensyaInfoBean.getSaikenadr2kj(),
            saikensyaInfoBean.getSaikenadr3kj());
        siShrmeisaiBean.setIrShadr1kj(results[0]);
        siShrmeisaiBean.setIrShadr2kj(results[1]);
        if (results.length > 2) {
            siShrmeisaiBean.setIrShadr3kj(results[2]);
        }

        siShrmeisaiBean.setIrShsnmkj(saikensyaInfoBean.getSaikennmkj());

        siShrmeisaiBean.setIrHhknnmkj(BLNK);
        siShrmeisaiBean.setIrBanknmkj(pEditSiharaimeisaisyoBean.getBanknmKj());
        siShrmeisaiBean.setIrSitennmkj(pEditSiharaimeisaisyoBean.getSitennmKj());
        siShrmeisaiBean.setIrYokinknmkj(pEditSiharaimeisaisyoBean.getYokinKbn().getContent());
        siShrmeisaiBean.setIrKouzano(pEditSiharaimeisaisyoBean.getKouzaNo());
        siShrmeisaiBean.setIrKzmeiginmkn(pEditSiharaimeisaisyoBean.getKzmeiginmKn());
        siShrmeisaiBean.setIrSaikenshrumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrItjsytkkgkhyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrItjsytknaiyouhyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrKztkgkhyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrKztnaiyouhyoujiumukbn(C_UmuKbn.NONE);
        return siShrmeisaiBean;
    }

    private SiShrmeisaiBean createSiShrmeisaiBeanForNormal(EditSiharaimeisaisyoBean pEditSiharaimeisaisyoBean,
        BizCurrency shrgkKei) {
        SiShrmeisaiBean siShrmeisaiBean = createCommonSiShrmeisaiBean(pEditSiharaimeisaisyoBean, shrgkKei);

        SeikyuusyaInfoBean seikyuusyaInfoBean = pEditSiharaimeisaisyoBean.getSeikyuusyaInfoBean();
        siShrmeisaiBean.setIrShsyno(seikyuusyaInfoBean.getTsinyno());

        String[] results = ViewReport.editAdrDisp(LINEMAXLEN,
            seikyuusyaInfoBean.getTsinadr1kj(),
            seikyuusyaInfoBean.getTsinadr2kj(),
            seikyuusyaInfoBean.getTsinadr3kj());
        siShrmeisaiBean.setIrShadr1kj(results[0]);
        siShrmeisaiBean.setIrShadr2kj(results[1]);
        if (results.length > 2) {
            siShrmeisaiBean.setIrShadr3kj(results[2]);
        }

        siShrmeisaiBean.setIrShsnmkj(seikyuusyaInfoBean.getSeikyuusyanmKj());

        siShrmeisaiBean.setIrHhknnmkj(pEditSiharaimeisaisyoBean.getHhknnmKj());
        siShrmeisaiBean.setIrBanknmkj(pEditSiharaimeisaisyoBean.getBanknmKj());
        siShrmeisaiBean.setIrSitennmkj(pEditSiharaimeisaisyoBean.getSitennmKj());
        siShrmeisaiBean.setIrYokinknmkj(pEditSiharaimeisaisyoBean.getYokinKbn().getContent());
        siShrmeisaiBean.setIrKouzano(pEditSiharaimeisaisyoBean.getKouzaNo());
        siShrmeisaiBean.setIrKzmeiginmkn(pEditSiharaimeisaisyoBean.getKzmeiginmKn());
        siShrmeisaiBean.setIrSaikenshrumukbn(C_UmuKbn.NONE);

        return siShrmeisaiBean;
    }

    private SiShrmeisaiBean createCommonSiShrmeisaiBean(EditSiharaimeisaisyoBean pEditSiharaimeisaisyoBean,
        BizCurrency shrgkKei) {
        SiShrmeisaiBean siShrmeisaiBean = SWAKInjector.getInstance(SiShrmeisaiBean.class);

        C_UmuKbn itjsytkkgkhyoujiumukbn = C_UmuKbn.NONE;
        C_UmuKbn itjsytknaiyouhyoujiumukbn = C_UmuKbn.NONE;
        C_UmuKbn kztkgkhyoujiumukbn = C_UmuKbn.NONE;
        C_UmuKbn kztnaiyouhyoujiumukbn = C_UmuKbn.NONE;

        if (C_ZeitratkiKbn.ITIJI.eq(pEditSiharaimeisaisyoBean.getZeitratkiKbn())) {
            if (C_Tuukasyu.JPY.eq(pEditSiharaimeisaisyoBean.getShrTuukasyu())) {
                itjsytkkgkhyoujiumukbn = C_UmuKbn.ARI;

            } else {

                itjsytkkgkhyoujiumukbn = C_UmuKbn.ARI;
                itjsytknaiyouhyoujiumukbn = C_UmuKbn.ARI;
            }
        }

        if (C_ZeitratkiKbn.SOUZOKU.eq(pEditSiharaimeisaisyoBean.getZeitratkiKbn()) ||
            C_ZeitratkiKbn.ZOUYO.eq(pEditSiharaimeisaisyoBean.getZeitratkiKbn())) {
            if (!C_Tuukasyu.JPY.eq(pEditSiharaimeisaisyoBean.getShrTuukasyu())) {
                kztkgkhyoujiumukbn = C_UmuKbn.ARI;
                kztnaiyouhyoujiumukbn = C_UmuKbn.ARI;
            }
        }


        C_UmuKbn kouzaHyoujiUmu = C_UmuKbn.ARI;

        if (C_UmuKbn.NONE.eq(pEditSiharaimeisaisyoBean.getKouzaHyoujiUmu())) {
            kouzaHyoujiUmu = C_UmuKbn.NONE;
        }

        List<JM_SiTyouhyoumsg> freeMsgListSandzeikin = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_SANDZEIKIN);
        List<JM_SiTyouhyoumsg> freeMsgListZeikinsyurui = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_ZEIKINSYURUI);
        List<JM_SiTyouhyoumsg> freeMsgListSouzokuzei = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_SOUZOKUZEI);
        List<JM_SiTyouhyoumsg> freeMsgListSyotokuzei = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_SYOTOKUZEI);
        List<JM_SiTyouhyoumsg> freeMsgListZouyozei = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_ZOUYOZEI);
        List<JM_SiTyouhyoumsg> freeMsgListKazeinendo = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_KAZEINENDO);
        List<JM_SiTyouhyoumsg> freeMsgListTyousyotst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_TYOUSYOTST);
        List<JM_SiTyouhyoumsg> freeMsgListZeimuinfo = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_ZEIMUINFO);
        List<JM_SiTyouhyoumsg> freeMsgListZeimuinfohijngaika = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_ZEIMUINFOHIJNGAIKA);
        List<JM_SiTyouhyoumsg> freeMsgListZeimuinfohijnyen = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_ZEIMUINFOHIJNYEN);
        List<JM_SiTyouhyoumsg> freeMsgListKzitysyou = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_KZITYSYOU);
        List<JM_SiTyouhyoumsg> freeMsgListKyksyahnk = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_KYKSYAHNK);
        List<JM_SiTyouhyoumsg> freeMsgListSihosoku = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_SIHOSOKU);
        List<JM_SiTyouhyoumsg> freeMsgListAzukarikin = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_AZUKARIKIN);
        List<JM_SiTyouhyoumsg> freeMsgListMisyuup = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_MISYUUP);
        List<JM_SiTyouhyoumsg> freeMsgListZennouhnkn = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_ZENNOUHNKN);
        List<JM_SiTyouhyoumsg> freeMsgListMikeikap = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(), FREEMSG_MIKEIKAP);

        List<JM_SiTyouhyoumsg> freeMsgList = new ArrayList<>();

        freeMsgList.addAll(freeMsgListSandzeikin);
        freeMsgList.addAll(freeMsgListZeikinsyurui);
        freeMsgList.addAll(freeMsgListSouzokuzei);
        freeMsgList.addAll(freeMsgListSyotokuzei);
        freeMsgList.addAll(freeMsgListZouyozei);
        freeMsgList.addAll(freeMsgListKazeinendo);
        freeMsgList.addAll(freeMsgListTyousyotst);

        if (C_Tuukasyu.JPY.eq(pEditSiharaimeisaisyoBean.getShrTuukasyu())) {
            if (C_ZeitratkiKbn.ITIJI.eq(pEditSiharaimeisaisyoBean.getZeitratkiKbn())) {
                if (!C_Kykjyoutai.ITIJIBARAI.eq(pEditSiharaimeisaisyoBean.getKykjyoutai())) {
                    freeMsgList.addAll(freeMsgListZeimuinfohijnyen);
                }
                if (pEditSiharaimeisaisyoBean.getKykHnkKaisuu() > 0) {
                    freeMsgList.addAll(freeMsgListKyksyahnk);
                }
            }
        } else {
            if (C_ZeitratkiKbn.ITIJI.eq(pEditSiharaimeisaisyoBean.getZeitratkiKbn())) {
                if (!C_Kykjyoutai.ITIJIBARAI.eq(pEditSiharaimeisaisyoBean.getKykjyoutai())) {
                    freeMsgList.addAll(freeMsgListZeimuinfohijngaika);
                } else {
                    freeMsgList.addAll(freeMsgListZeimuinfo);
                }
                if (pEditSiharaimeisaisyoBean.getKykHnkKaisuu() > 0) {
                    freeMsgList.addAll(freeMsgListKyksyahnk);
                }
            } else {
                freeMsgList.addAll(freeMsgListKzitysyou);
            }
        }

        if (!pEditSiharaimeisaisyoBean.getSk().getAzukarikingk()
            .equalsValue(BizCurrency.valueOf(0, pEditSiharaimeisaisyoBean.getSk().getAzukarikingk().getType()))
            || !pEditSiharaimeisaisyoBean.getSk().getMisyuup()
            .equalsValue(BizCurrency.valueOf(0, pEditSiharaimeisaisyoBean.getSk().getMisyuup().getType()))
            || !pEditSiharaimeisaisyoBean.getSk().getZennouseisankgk()
            .equalsValue(BizCurrency.valueOf(0, pEditSiharaimeisaisyoBean.getSk().getZennouseisankgk().getType()))
            || !pEditSiharaimeisaisyoBean.getSk().getMikeikap()
            .equalsValue(BizCurrency.valueOf(0, pEditSiharaimeisaisyoBean.getSk().getMikeikap().getType()))) {
            freeMsgList.addAll(freeMsgListSihosoku);
            if (!pEditSiharaimeisaisyoBean.getSk().getAzukarikingk()
                .equalsValue(BizCurrency.valueOf(0, pEditSiharaimeisaisyoBean.getSk().getAzukarikingk().getType()))) {
                freeMsgList.addAll(freeMsgListAzukarikin);
            }
            if (!pEditSiharaimeisaisyoBean.getSk().getMisyuup()
                .equalsValue(BizCurrency.valueOf(0, pEditSiharaimeisaisyoBean.getSk().getMisyuup().getType()))) {
                freeMsgList.addAll(freeMsgListMisyuup);
            }
            if (!pEditSiharaimeisaisyoBean.getSk().getZennouseisankgk()
                .equalsValue(BizCurrency.valueOf(0, pEditSiharaimeisaisyoBean.getSk().getZennouseisankgk().getType()))) {
                freeMsgList.addAll(freeMsgListZennouhnkn);
            } else {
                if (!pEditSiharaimeisaisyoBean.getSk().getMikeikap()
                    .equalsValue(BizCurrency.valueOf(0, pEditSiharaimeisaisyoBean.getSk().getMikeikap().getType()))) {
                    freeMsgList.addAll(freeMsgListMikeikap);
                }
            }
        }

        String[] freeMsg = new String[FREEMSGGYOUSUU];

        for (int i = 0; i < freeMsgList.size(); i++) {
            freeMsg[i] = freeMsgList.get(i).getTyouhyoumsg();
        }

        siShrmeisaiBean.setIrItjsytkkgkhyoujiumukbn(itjsytkkgkhyoujiumukbn);
        siShrmeisaiBean.setIrItjsytknaiyouhyoujiumukbn(itjsytknaiyouhyoujiumukbn);
        siShrmeisaiBean.setIrKztkgkhyoujiumukbn(kztkgkhyoujiumukbn);
        siShrmeisaiBean.setIrKztnaiyouhyoujiumukbn(kztnaiyouhyoujiumukbn);
        siShrmeisaiBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJINoEx(pEditSiharaimeisaisyoBean
            .getSiTyouhyouHensyuuCommonBean().getSyoriYmd()));

        siShrmeisaiBean.setIrKouzahyoujiumukbn(kouzaHyoujiUmu);

        ToiawaseInfoBean toiawaseInfoBean = pEditSiharaimeisaisyoBean.getToiawaseInfoBean();
        siShrmeisaiBean.setIrToiawasesosiki(toiawaseInfoBean.getSosikiNm());
        siShrmeisaiBean.setIrToiawaseyno(toiawaseInfoBean.getTsinyno());
        siShrmeisaiBean.setIrToiawaseadr1kj(toiawaseInfoBean.getTsinadr1kj());
        siShrmeisaiBean.setIrToiawaseadr2kj(toiawaseInfoBean.getTsinadr2kj());
        siShrmeisaiBean.setIrToiawaseadr3kj(toiawaseInfoBean.getTsinadr3kj());
        siShrmeisaiBean.setIrToiawasetelno(toiawaseInfoBean.getTsintelno());

        siShrmeisaiBean.setIrSyono(ConvertUtil.toZenNumeric(ConvertUtil.toZenAlphabet(
            pEditSiharaimeisaisyoBean.getSyoNo(), 0)));
        siShrmeisaiBean.setIrKyknmkj(pEditSiharaimeisaisyoBean.getKyknmKj());
        siShrmeisaiBean.setIrShrgk(shrgkKei);
        siShrmeisaiBean.setIrTyakkinymd(editZenkakuWarekiYmd(pEditSiharaimeisaisyoBean.getTyakkinYmd()));
        siShrmeisaiBean.setIrShrgk2(shrgkKei);
        siShrmeisaiBean.setIrSynykngk(pEditSiharaimeisaisyoBean.getSynykngk());
        siShrmeisaiBean.setIrHtykeihi(pEditSiharaimeisaisyoBean.getHtykeihi());
        siShrmeisaiBean.setIrCctelno(pEditSiharaimeisaisyoBean.getCctelNo());
        siShrmeisaiBean.setIrShrtuukasyu(pEditSiharaimeisaisyoBean.getShrTuukasyu());
        siShrmeisaiBean.setIrItjsytkkgkhyoujiumukbn(itjsytkkgkhyoujiumukbn);
        siShrmeisaiBean.setIrKztkgkhyoujiumukbn(kztkgkhyoujiumukbn);
        siShrmeisaiBean.setIrKztkgk(pEditSiharaimeisaisyoBean.getKztkgk());
        siShrmeisaiBean.setIrKykhnkkaisuu(pEditSiharaimeisaisyoBean.getKykHnkKaisuu());
        siShrmeisaiBean.setIrShrkyksyahtykeihi(pEditSiharaimeisaisyoBean.getShrKykHtyKeihi());
        siShrmeisaiBean.setIrMsg1(freeMsg[0]);
        siShrmeisaiBean.setIrMsg2(freeMsg[1]);
        siShrmeisaiBean.setIrMsg3(freeMsg[2]);
        siShrmeisaiBean.setIrMsg4(freeMsg[3]);
        siShrmeisaiBean.setIrMsg5(freeMsg[4]);
        siShrmeisaiBean.setIrMsg6(freeMsg[5]);
        siShrmeisaiBean.setIrMsg7(freeMsg[6]);
        siShrmeisaiBean.setIrMsg8(freeMsg[7]);
        siShrmeisaiBean.setIrMsg9(freeMsg[8]);
        siShrmeisaiBean.setIrMsg10(freeMsg[9]);
        siShrmeisaiBean.setIrMsg11(freeMsg[10]);
        siShrmeisaiBean.setIrMsg12(freeMsg[11]);
        siShrmeisaiBean.setIrMsg13(freeMsg[12]);
        siShrmeisaiBean.setIrMsg14(freeMsg[13]);
        siShrmeisaiBean.setIrMsg15(freeMsg[14]);
        siShrmeisaiBean.setIrMsg16(freeMsg[15]);
        siShrmeisaiBean.setIrMsg17(freeMsg[16]);
        siShrmeisaiBean.setIrMsg18(freeMsg[17]);
        siShrmeisaiBean.setIrMsg19(freeMsg[18]);
        siShrmeisaiBean.setIrMsg20(freeMsg[19]);
        siShrmeisaiBean.setIrMsg21(freeMsg[20]);
        siShrmeisaiBean.setIrMsg22(freeMsg[21]);
        siShrmeisaiBean.setIrMsg23(freeMsg[22]);
        siShrmeisaiBean.setIrMsg24(freeMsg[23]);
        siShrmeisaiBean.setIrMsg25(freeMsg[24]);
        siShrmeisaiBean.setIrMsg26(freeMsg[25]);
        siShrmeisaiBean.setIrMsg27(freeMsg[26]);
        siShrmeisaiBean.setIrMsg28(freeMsg[27]);
        siShrmeisaiBean.setIrMsg29(freeMsg[28]);
        siShrmeisaiBean.setIrMsg30(freeMsg[29]);
        siShrmeisaiBean.setIrMsg31(freeMsg[30]);
        siShrmeisaiBean.setIrMsg32(freeMsg[31]);
        siShrmeisaiBean.setIrMsg33(freeMsg[32]);
        siShrmeisaiBean.setIrMsg34(freeMsg[33]);
        siShrmeisaiBean.setIrMsg35(freeMsg[34]);
        siShrmeisaiBean.setIrMsg36(freeMsg[35]);
        siShrmeisaiBean.setIrMsg37(freeMsg[36]);
        siShrmeisaiBean.setIrMsg38(freeMsg[37]);
        siShrmeisaiBean.setIrMsg39(freeMsg[38]);
        siShrmeisaiBean.setIrMsg40(freeMsg[39]);
        siShrmeisaiBean.setIrMsg41(freeMsg[40]);
        siShrmeisaiBean.setIrMsg42(freeMsg[41]);
        siShrmeisaiBean.setIrMsg43(freeMsg[42]);
        siShrmeisaiBean.setIrMsg44(freeMsg[43]);
        siShrmeisaiBean.setIrMsg45(freeMsg[44]);
        siShrmeisaiBean.setIrMsg46(freeMsg[45]);

        return siShrmeisaiBean;
    }

    private ReportServicesBean createReportServicesBean(EditSiharaimeisaisyoBean pEditSiharaimeisaisyoBean) {
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(), kinou
            .getCategoryId(), kinou.getKinouId(), pEditSiharaimeisaisyoBean.getSiTyouhyouHensyuuCommonBean()
            .getSyoruiCd());
        reportServicesBean.setKensakuKeys(pEditSiharaimeisaisyoBean.getSyoNo());
        reportServicesBean.setSyoriYmd(pEditSiharaimeisaisyoBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd());
        return reportServicesBean;
    }

    private String editZenkakuWarekiYmd(BizDate date) {
        return ConvertUtil.toZenNumeric(DateFormatUtil.dateKANJINoEx(date));
    }

    private boolean isTuukasyuJPY(C_Tuukasyu tuukasyu) {
        return C_Tuukasyu.JPY.eq(tuukasyu);
    }

    private boolean isNotTuukasyuJPY(C_Tuukasyu tuukasyu) {
        return !isTuukasyuJPY(tuukasyu);
    }

}

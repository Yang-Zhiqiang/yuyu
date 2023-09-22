package yuyu.common.sinkeiyaku.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzProcessForward;
import yuyu.common.biz.koutei.BzProcessForwardInBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 工程 新契約工程遷移（申込内容チェック実行）
 */
public class SkProcessForwardMoschkExec {

    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private C_MostenkenyhKbn MOSTENKENYHKBN = C_MostenkenyhKbn.HUYOU;

    private C_UmuKbn HUBITOUROKUUMU = C_UmuKbn.NONE;

    public SkProcessForwardMoschkExec() {
        super();
    }

    public void exec(SkProcessForwardInBean pSkProcessForwardInBean) {

        logger.debug("▽ 新契約工程遷移（申込内容チェック実行） 開始");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pSkProcessForwardInBean.getMosNo());

        if (C_UmuKbn.ARI.eq(syoriCTL.getKthhbkbn())) {

            SkProcessForwardKetteiHoryuuHubiOnline skProcessForwardKetteiHoryuuHubiOnline =
                SWAKInjector.getInstance(SkProcessForwardKetteiHoryuuHubiOnline.class);

            skProcessForwardKetteiHoryuuHubiOnline.exec(pSkProcessForwardInBean);
        }

        else if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())) {

            SkProcessForwardSeiritu skProcessForwardSeiritu =SWAKInjector.getInstance(SkProcessForwardSeiritu.class);

            skProcessForwardSeiritu.exec(pSkProcessForwardInBean);
        }

        else if (C_UmuKbn.ARI.eq(syoriCTL.getMosnrkumu())) {

            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            HT_MosKihon mosKihon = syoriCTL.getMosKihon();

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary
                .exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanList != null && bzGetProcessSummaryOutBeanList.size() > 0) {

                if (C_MostenkenyhKbn.YOU.eq(syoriCTL.getMostenken1jiyhkbn()) ||
                    C_MostenkenyhKbn.YOU.eq(syoriCTL.getMostenken2jiyhkbn()) ) {

                    MOSTENKENYHKBN = C_MostenkenyhKbn.YOU;
                }
                else {
                    MOSTENKENYHKBN = C_MostenkenyhKbn.HUYOU;
                }

                boolean result = getHubiSyouSaiJyouHouBln(syoriCTL);

                if (result) {

                    HUBITOUROKUUMU = C_UmuKbn.ARI;
                }
                else {
                    HUBITOUROKUUMU = C_UmuKbn.NONE;
                }


                BzProcessForwardInBean bzProcessForwardInBean = new BzProcessForwardInBean();
                SkMainDairitenRuleBean skMainDairitenRuleBean = new SkMainDairitenRuleBean();

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                if (checkForwardExec(syoriCTL, bzGetProcessSummaryOutBean, pSkProcessForwardInBean)) {

                    skMainDairitenRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skMainDairitenRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getSeiritukbn())));
                    skMainDairitenRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getMosnrkumu())));
                    skMainDairitenRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
                        C_SntkhouKbn.PATTERN_DEFAULT,
                        String.valueOf(mosKihon.getSntkhoukbn())));
                    skMainDairitenRuleBean.setKktnrkUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getKktnrkumu())));
                    skMainDairitenRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                        C_VrfjkKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getKktnrkvrfjkkbn())));
                    skMainDairitenRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                        C_MostenkenjyouKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getMostenkenjoukbn())));
                    skMainDairitenRuleBean.setKetteiKbn(C_KetteiKbn.getContentByValue(
                        C_KetteiKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getKetteikbn())));
                    skMainDairitenRuleBean.setSateijtKbn(C_SateijtKbn.getContentByValue(
                        C_SateijtKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getSateijtkbn())));
                    skMainDairitenRuleBean.setSrhhbKbn(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getSrhhbkbn())));

                    bzProcessForwardInBean.setIwfApiRuleBean(skMainDairitenRuleBean);

                    execProcessForward(pSkProcessForwardInBean, bzGetProcessSummaryOutBean, bzProcessForwardInBean);
                }

                bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

                SkTenkenRuleBean skTenkenRuleBean = new SkTenkenRuleBean();

                bzProcessForwardInBean = new BzProcessForwardInBean();

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                if (checkForwardExec(syoriCTL, bzGetProcessSummaryOutBean, pSkProcessForwardInBean)) {

                    skTenkenRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skTenkenRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getSeiritukbn())));
                    skTenkenRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getMosnrkumu())));
                    skTenkenRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
                        C_SntkhouKbn.PATTERN_DEFAULT,
                        String.valueOf(mosKihon.getSntkhoukbn())));
                    skTenkenRuleBean.setKktnrkUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getKktnrkumu())));
                    skTenkenRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                        C_VrfjkKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getKktnrkvrfjkkbn())));
                    skTenkenRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                        C_MostenkenjyouKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getMostenkenjoukbn())));

                    bzProcessForwardInBean.setIwfApiRuleBean(skTenkenRuleBean);

                    execProcessForward(pSkProcessForwardInBean, bzGetProcessSummaryOutBean, bzProcessForwardInBean);
                }

                bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

                SkKankyouRuleBean skKankyouRuleBean = new SkKankyouRuleBean();

                bzProcessForwardInBean = new BzProcessForwardInBean();

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                if (checkForwardExec(syoriCTL, bzGetProcessSummaryOutBean, pSkProcessForwardInBean)) {

                    skKankyouRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skKankyouRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getSeiritukbn())));
                    skKankyouRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
                        C_MostenkenyhKbn.PATTERN_DEFAULT,
                        String.valueOf(MOSTENKENYHKBN)));
                    skKankyouRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                        C_MostenkenjyouKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getMostenkenjoukbn())));
                    skKankyouRuleBean.setKnkysateijyouKbn(C_KnkysateijyouKbn.getContentByValue(
                        C_KnkysateijyouKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getKnkysateijyoukbn())));
                    skKankyouRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getKthhbkbn())));
                    skKankyouRuleBean.setLincjkKbn(C_LincjkKbn.getContentByValue(
                        C_LincjkKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getLincjkkbn())));

                    bzProcessForwardInBean.setIwfApiRuleBean(skKankyouRuleBean);

                    execProcessForward(pSkProcessForwardInBean, bzGetProcessSummaryOutBean, bzProcessForwardInBean);
                }

                bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

                SkImuRuleBean skImuRuleBean = new SkImuRuleBean();

                bzProcessForwardInBean = new BzProcessForwardInBean();

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                if (checkForwardExec(syoriCTL, bzGetProcessSummaryOutBean, pSkProcessForwardInBean)) {

                    skImuRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skImuRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getSeiritukbn())));
                    skImuRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
                        C_MostenkenyhKbn.PATTERN_DEFAULT,
                        String.valueOf(MOSTENKENYHKBN)));
                    skImuRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                        C_MostenkenjyouKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getMostenkenjoukbn())));
                    skImuRuleBean.setImusateijyouKbn(C_ImusateijyouKbn.getContentByValue(
                        C_ImusateijyouKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getImusateijyoukbn())));
                    skImuRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getKthhbkbn())));

                    bzProcessForwardInBean.setIwfApiRuleBean(skImuRuleBean);

                    execProcessForward(pSkProcessForwardInBean, bzGetProcessSummaryOutBean, bzProcessForwardInBean);
                }

                bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

                SkHubiTourokuRuleBean skHubiTourokuRuleBean = new SkHubiTourokuRuleBean();

                bzProcessForwardInBean = new BzProcessForwardInBean();

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                if (checkForwardExec(syoriCTL, bzGetProcessSummaryOutBean, pSkProcessForwardInBean)) {

                    skHubiTourokuRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skHubiTourokuRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getSeiritukbn())));
                    skHubiTourokuRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
                        C_MostenkenyhKbn.PATTERN_DEFAULT,
                        String.valueOf(MOSTENKENYHKBN)));
                    skHubiTourokuRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                        C_MostenkenjyouKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getMostenkenjoukbn())));
                    skHubiTourokuRuleBean.setMihassinhubiUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getMihassinhubiumu())));
                    skHubiTourokuRuleBean.setHubihassintnsUmu(C_HubihassintnsKbn.getContentByValue(
                        C_HubihassintnsKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardInBean.getHubihassintnsKbn())));
                    skHubiTourokuRuleBean.setHubitourokuUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(HUBITOUROKUUMU)));
                    skHubiTourokuRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getKthhbkbn())));

                    bzProcessForwardInBean.setIwfApiRuleBean(skHubiTourokuRuleBean);

                    execProcessForward(pSkProcessForwardInBean, bzGetProcessSummaryOutBean, bzProcessForwardInBean);
                }
            }
        }

        if (C_YouhiKbn.YOU.eq(pSkProcessForwardInBean.getMoscheckrirekiyhKbn())) {

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanList == null || bzGetProcessSummaryOutBeanList.size() == 0) {

                bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                bzGetProcessSummaryInBean.setSyoNo(syoriCTL.getSyono());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                if (bzGetProcessSummaryOutBeanList == null || bzGetProcessSummaryOutBeanList.size() == 0) {

                    return;
                }

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);
            }
            else {

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);
            }

            bzOutputProcessRecord.exec(bzGetProcessSummaryOutBean.getKouteiKanriId(),
                bzGetProcessSummaryOutBean.getJimuTetuzukiCd(),
                pSkProcessForwardInBean.getSyoriComment(),
                pSkProcessForwardInBean.getTskNm(),
                pSkProcessForwardInBean.getSyorikekkaKbn());
        }

        logger.debug("△ 新契約工程遷移（申込内容チェック実行） 終了");
    }

    private boolean getHubiSyouSaiJyouHouBln(HT_SyoriCTL pSyoriCTL) {

        boolean result = false;

        List<HT_SkHubi> skHubiList = pSyoriCTL.getSkHubis();

        for (int i = 0; i < skHubiList.size(); i++) {

            List<HT_SkHubiDetail> skHubiDetailList = skHubiList.get(i).getSkHubiDetails();

            if (skHubiDetailList.size() > 0) {

                result = true;

                break;
            }
        }

        return result;
    }

    private void execProcessForward(SkProcessForwardInBean pSkProcessForwardInBean,
        BzGetProcessSummaryOutBean pBzGetProcessSummaryOutBean,
        BzProcessForwardInBean pBzProcessForwardInBean) {

        BzProcessForward bzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        String bforeNowTantId = pBzGetProcessSummaryOutBean.getNowTantId();
        String bforeNowNodeId = pBzGetProcessSummaryOutBean.getNowNodoId();

        pBzProcessForwardInBean.setKouteiKanriId(pBzGetProcessSummaryOutBean.getKouteiKanriId());
        pBzProcessForwardInBean.setJimuTetuzukiCd(pBzGetProcessSummaryOutBean.getJimuTetuzukiCd());
        pBzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
        pBzProcessForwardInBean.setSyorikekkaKbn(pSkProcessForwardInBean.getMostenkenkekkaKbn());
        pBzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

        bzProcessForward.exec(pBzProcessForwardInBean);

        if (bforeNowTantId != null && bforeNowTantId.length() > 0) {

            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

            bzGetProcessSummaryInBean.setKouteiKanriId(pBzGetProcessSummaryOutBean.getKouteiKanriId());

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary
                .exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanList != null && bzGetProcessSummaryOutBeanList.size() > 0) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                if (bforeNowNodeId.equals(bzGetProcessSummaryOutBean.getNowNodoId())
                    && !ISkCommonKoumoku.NODEID_KOUTEIKAISI.equals(bzGetProcessSummaryOutBean.getNowNodoId())
                    && !ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(bzGetProcessSummaryOutBean.getNowNodoId())) {

                    BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

                    bzTaskStart.exec(pBzGetProcessSummaryOutBean.getKouteiKanriId(),
                        pBzGetProcessSummaryOutBean.getJimuTetuzukiCd(),
                        bzGetProcessSummaryOutBean.getNowNodoId(),
                        pSkProcessForwardInBean.getKouteiLockkey(),
                        bforeNowTantId);
                }
            }
        }
    }

    private boolean checkForwardExec(HT_SyoriCTL pSyoriCtl,
        BzGetProcessSummaryOutBean pBzGetProcessSummaryOutBean,
        SkProcessForwardInBean pSkProcessForwardInBean) {

        if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryOutBean.getJimuTetuzukiCd())) {

            if (C_SntkhouKbn.KKT.eq(pSyoriCtl.getMosKihon().getSntkhoukbn())) {

                if (C_UmuKbn.ARI.eq(pSyoriCtl.getKktnrkumu())) {

                    if (C_MostenkenjyouKbn.NONE.eq(pSyoriCtl.getMostenkenjoukbn())
                        || C_MostenkenjyouKbn.MOSTENKEN_ZUMI.eq(pSyoriCtl.getMostenkenjoukbn())) {

                        if (C_KetteiKbn.NONE.eq(pSyoriCtl.getKetteikbn())) {

                            if (ISkCommonKoumoku.NODEID_KETTEI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                return false;
                            }
                        }
                        else {

                            if (C_UmuKbn.ARI.eq(pSyoriCtl.getSrhhbkbn())) {

                                if (ISkCommonKoumoku.NODEID_SEIRITUHORYUUHUBI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                    return false;
                                }
                            }
                            else {

                                if (C_SateijtKbn.SATEI_TYUU.eq(pSyoriCtl.getSateijtkbn())) {

                                    if (ISkCommonKoumoku.NODEID_SATEI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                        return false;
                                    }
                                }
                                else {

                                    if (ISkCommonKoumoku.NODEID_SEIRITU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                        return false;
                                    }
                                }
                            }
                        }
                    }
                    else {

                        if (ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                }
                else {

                    if (C_VrfjkKbn.KANRYOU.eq(pSyoriCtl.getKktnrkvrfjkkbn())) {

                        if (C_MostenkenjyouKbn.NONE.eq(pSyoriCtl.getMostenkenjoukbn())
                            || C_MostenkenjyouKbn.MOSTENKEN_ZUMI.eq(pSyoriCtl.getMostenkenjoukbn())) {

                            if (C_KetteiKbn.NONE.eq(pSyoriCtl.getKetteikbn())) {

                                if (ISkCommonKoumoku.NODEID_KETTEI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                    return false;
                                }
                            }
                            else {

                                if (C_UmuKbn.ARI.eq(pSyoriCtl.getSrhhbkbn())) {

                                    if (ISkCommonKoumoku.NODEID_SEIRITUHORYUUHUBI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                        return false;
                                    }
                                }
                                else {

                                    if (C_SateijtKbn.SATEI_TYUU.eq(pSyoriCtl.getSateijtkbn())) {

                                        if (ISkCommonKoumoku.NODEID_SATEI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                            return false;
                                        }
                                    }
                                    else {

                                        if (ISkCommonKoumoku.NODEID_SEIRITU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                            return false;
                                        }
                                    }
                                }
                            }

                        }
                        else {

                            if (ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                return false;
                            }
                        }
                    }
                    else {

                        if (ISkCommonKoumoku.NODEID_SYORUINYUURYOKU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                }

            }
            else {

                if (C_MostenkenjyouKbn.NONE.eq(pSyoriCtl.getMostenkenjoukbn())
                    || C_MostenkenjyouKbn.MOSTENKEN_ZUMI.eq(pSyoriCtl.getMostenkenjoukbn())) {

                    if (C_KetteiKbn.NONE.eq(pSyoriCtl.getKetteikbn())) {

                        if (ISkCommonKoumoku.NODEID_KETTEI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else {

                        if (C_UmuKbn.ARI.eq(pSyoriCtl.getSrhhbkbn())) {

                            if (ISkCommonKoumoku.NODEID_SEIRITUHORYUUHUBI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                return false;
                            }
                        }
                        else {

                            if (C_SateijtKbn.SATEI_TYUU.eq(pSyoriCtl.getSateijtkbn())) {

                                if (ISkCommonKoumoku.NODEID_SATEI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                    return false;
                                }
                            }
                            else {

                                if (ISkCommonKoumoku.NODEID_SEIRITU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                    return false;
                                }
                            }
                        }
                    }
                }
                else {

                    if (ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                        return false;
                    }
                }
            }
        }
        else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryOutBean.getJimuTetuzukiCd())) {

            if (C_SntkhouKbn.KKT.eq(pSyoriCtl.getMosKihon().getSntkhoukbn())) {

                if (C_UmuKbn.ARI.eq(pSyoriCtl.getKktnrkumu())) {

                    if (C_MostenkenjyouKbn.TENKENMATI_1.eq(pSyoriCtl.getMostenkenjoukbn())) {

                        if (ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else if (C_MostenkenjyouKbn.TENKENMATI_2.eq(pSyoriCtl.getMostenkenjoukbn())) {

                        if (ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_2JI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else if (C_MostenkenjyouKbn.TENKENMATI_HUBI.eq(pSyoriCtl.getMostenkenjoukbn())) {

                        if (ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_HUBI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else if (C_MostenkenjyouKbn.NONE.eq(pSyoriCtl.getMostenkenjoukbn())
                        || C_MostenkenjyouKbn.MOSTENKEN_ZUMI.eq(pSyoriCtl.getMostenkenjoukbn())) {

                        if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                }
                else {

                    if (C_VrfjkKbn.KANRYOU.eq(pSyoriCtl.getKktnrkvrfjkkbn())) {

                        if (C_MostenkenjyouKbn.TENKENMATI_1.eq(pSyoriCtl.getMostenkenjoukbn())) {

                            if (ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                return false;
                            }
                        }
                        else if (C_MostenkenjyouKbn.TENKENMATI_2.eq(pSyoriCtl.getMostenkenjoukbn())) {

                            if (ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_2JI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                return false;
                            }
                        }
                        else if (C_MostenkenjyouKbn.TENKENMATI_HUBI.eq(pSyoriCtl.getMostenkenjoukbn())) {

                            if (ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_HUBI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                return false;
                            }
                        }
                        else if (C_MostenkenjyouKbn.NONE.eq(pSyoriCtl.getMostenkenjoukbn())
                            || C_MostenkenjyouKbn.MOSTENKEN_ZUMI.eq(pSyoriCtl.getMostenkenjoukbn())) {

                            if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                                return false;
                            }
                        }
                    }
                    else {

                        if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                }
            }
            else {
                if (C_MostenkenjyouKbn.TENKENMATI_1.eq(pSyoriCtl.getMostenkenjoukbn())) {

                    if (ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                        return false;
                    }
                }
                else if (C_MostenkenjyouKbn.TENKENMATI_2.eq(pSyoriCtl.getMostenkenjoukbn())) {

                    if (ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_2JI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                        return false;
                    }
                }
                else if (C_MostenkenjyouKbn.TENKENMATI_HUBI.eq(pSyoriCtl.getMostenkenjoukbn())) {

                    if (ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_HUBI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                        return false;
                    }
                }
                else if (C_MostenkenjyouKbn.NONE.eq(pSyoriCtl.getMostenkenjoukbn())
                    || C_MostenkenjyouKbn.MOSTENKEN_ZUMI.eq(pSyoriCtl.getMostenkenjoukbn())) {

                    if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                        return false;
                    }
                }
            }
        }
        else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryOutBean.getJimuTetuzukiCd())) {

            if (C_MostenkenyhKbn.YOU.eq(MOSTENKENYHKBN)) {

                if (C_MostenkenjyouKbn.NONE.eq(pSyoriCtl.getMostenkenjoukbn())
                    || C_MostenkenjyouKbn.TENKENMATI_1.eq(pSyoriCtl.getMostenkenjoukbn())
                    || C_MostenkenjyouKbn.TENKENMATI_2.eq(pSyoriCtl.getMostenkenjoukbn())) {

                    if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                        return false;
                    }
                }
                else {

                    if (C_UmuKbn.ARI.eq(pSyoriCtl.getMihassinhubiumu())
                        || C_HubihassintnsKbn.ARI.eq(pSkProcessForwardInBean.getHubihassintnsKbn())
                        || (C_UmuKbn.NONE.eq(HUBITOUROKUUMU)) && C_UmuKbn.ARI.eq(pSyoriCtl.getKthhbkbn())) {

                        if (ISkCommonKoumoku.NODEID_SKHUBINAIYOUKAKHASSIN.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else {

                        if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                }
            }
            else {

                if (C_MostenkenjyouKbn.TENKENMATI_1.eq(pSyoriCtl.getMostenkenjoukbn())
                    || C_MostenkenjyouKbn.TENKENMATI_2.eq(pSyoriCtl.getMostenkenjoukbn())) {

                    if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                        return false;
                    }
                }
                else {

                    if (C_UmuKbn.ARI.eq(pSyoriCtl.getMihassinhubiumu())
                        || C_HubihassintnsKbn.ARI.eq(pSkProcessForwardInBean.getHubihassintnsKbn())
                        || (C_UmuKbn.NONE.eq(HUBITOUROKUUMU)) && C_UmuKbn.ARI.eq(pSyoriCtl.getKthhbkbn())) {

                        if (ISkCommonKoumoku.NODEID_SKHUBINAIYOUKAKHASSIN.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else {

                        if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                }
            }
        }
        else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryOutBean.getJimuTetuzukiCd())) {

            if (C_MostenkenyhKbn.YOU.eq(MOSTENKENYHKBN)) {

                if (C_MostenkenjyouKbn.MOSTENKEN_ZUMI.eq(pSyoriCtl.getMostenkenjoukbn())) {

                    if (C_KnkysateijyouKbn.SATEIMATI_1.eq(pSyoriCtl.getKnkysateijyoukbn())) {

                        if (ISkCommonKoumoku.NODEID_KANKYOUSATEI_1JI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else if (C_KnkysateijyouKbn.SATEIMATI_2A.eq(pSyoriCtl.getKnkysateijyoukbn()) && C_UmuKbn.NONE.eq(pSyoriCtl.getKthhbkbn())) {

                        if (ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIA.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else if (C_KnkysateijyouKbn.SATEIMATI_2B.eq(pSyoriCtl.getKnkysateijyoukbn()) && C_UmuKbn.NONE.eq(pSyoriCtl.getKthhbkbn())) {

                        if (ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIB.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else if (C_KnkysateijyouKbn.NONE.eq(pSyoriCtl.getKnkysateijyoukbn())
                        || C_KnkysateijyouKbn.SATEIZUMI.eq(pSyoriCtl.getKnkysateijyoukbn())
                        || (C_KnkysateijyouKbn.SATEIMATI_2A.eq(pSyoriCtl.getKnkysateijyoukbn()) && C_UmuKbn.ARI.eq(pSyoriCtl.getKthhbkbn()))
                        || (C_KnkysateijyouKbn.SATEIMATI_2B.eq(pSyoriCtl.getKnkysateijyoukbn()) && C_UmuKbn.ARI.eq(pSyoriCtl.getKthhbkbn()))) {

                        if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                }
                else {

                    if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                        return false;
                    }
                }
            }
            else {

                if (C_MostenkenjyouKbn.NONE.eq(pSyoriCtl.getMostenkenjoukbn())
                    || C_MostenkenjyouKbn.MOSTENKEN_ZUMI.eq(pSyoriCtl.getMostenkenjoukbn())) {

                    if (C_KnkysateijyouKbn.SATEIMATI_1.eq(pSyoriCtl.getKnkysateijyoukbn())) {

                        if (ISkCommonKoumoku.NODEID_KANKYOUSATEI_1JI.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else if (C_KnkysateijyouKbn.SATEIMATI_2A.eq(pSyoriCtl.getKnkysateijyoukbn()) && C_UmuKbn.NONE.eq(pSyoriCtl.getKthhbkbn())) {

                        if (ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIA.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else if (C_KnkysateijyouKbn.SATEIMATI_2B.eq(pSyoriCtl.getKnkysateijyoukbn()) && C_UmuKbn.NONE.eq(pSyoriCtl.getKthhbkbn())) {

                        if (ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIB.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else if (C_KnkysateijyouKbn.NONE.eq(pSyoriCtl.getKnkysateijyoukbn())
                        || C_KnkysateijyouKbn.SATEIZUMI.eq(pSyoriCtl.getKnkysateijyoukbn())
                        || (C_KnkysateijyouKbn.SATEIMATI_2A.eq(pSyoriCtl.getKnkysateijyoukbn()) && C_UmuKbn.ARI.eq(pSyoriCtl.getKthhbkbn()))
                        || (C_KnkysateijyouKbn.SATEIMATI_2B.eq(pSyoriCtl.getKnkysateijyoukbn()) && C_UmuKbn.ARI.eq(pSyoriCtl.getKthhbkbn()))) {

                        if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                }
                else {

                    if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                        return false;
                    }
                }
            }
        }
        else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryOutBean.getJimuTetuzukiCd())) {

            if (C_MostenkenyhKbn.YOU.eq(MOSTENKENYHKBN)) {

                if (C_MostenkenjyouKbn.MOSTENKEN_ZUMI.eq(pSyoriCtl.getMostenkenjoukbn())) {

                    if (C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(pSyoriCtl.getImusateijyoukbn()) && C_UmuKbn.NONE.eq(pSyoriCtl.getKthhbkbn())) {

                        if (ISkCommonKoumoku.NODEID_IMUSATEI_KANI_UW.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else if (C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(pSyoriCtl.getImusateijyoukbn()) && C_UmuKbn.NONE.eq(pSyoriCtl.getKthhbkbn())) {

                        if (ISkCommonKoumoku.NODEID_IMUSATEI_KANI_MD.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else if (C_ImusateijyouKbn.NONE.eq(pSyoriCtl.getImusateijyoukbn())
                        || C_ImusateijyouKbn.SATEIZUMI.eq(pSyoriCtl.getImusateijyoukbn())
                        || (C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(pSyoriCtl.getImusateijyoukbn()) && C_UmuKbn.ARI.eq(pSyoriCtl.getKthhbkbn()))
                        || (C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(pSyoriCtl.getImusateijyoukbn()) && C_UmuKbn.ARI.eq(pSyoriCtl.getKthhbkbn()))) {

                        if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                }
                else {

                    if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                        return false;
                    }
                }
            }
            else {

                if (C_MostenkenjyouKbn.NONE.eq(pSyoriCtl.getMostenkenjoukbn())
                    || C_MostenkenjyouKbn.MOSTENKEN_ZUMI.eq(pSyoriCtl.getMostenkenjoukbn())) {

                    if (C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(pSyoriCtl.getImusateijyoukbn()) && C_UmuKbn.NONE.eq(pSyoriCtl.getKthhbkbn())) {

                        if (ISkCommonKoumoku.NODEID_IMUSATEI_KANI_UW.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else if (C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(pSyoriCtl.getImusateijyoukbn()) && C_UmuKbn.NONE.eq(pSyoriCtl.getKthhbkbn())) {

                        if (ISkCommonKoumoku.NODEID_IMUSATEI_KANI_MD.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                    else if (C_ImusateijyouKbn.NONE.eq(pSyoriCtl.getImusateijyoukbn())
                        || C_ImusateijyouKbn.SATEIZUMI.eq(pSyoriCtl.getImusateijyoukbn())
                        || (C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(pSyoriCtl.getImusateijyoukbn()) && C_UmuKbn.ARI.eq(pSyoriCtl.getKthhbkbn()))
                        || (C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(pSyoriCtl.getImusateijyoukbn()) && C_UmuKbn.ARI.eq(pSyoriCtl.getKthhbkbn()))) {

                        if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                            return false;
                        }
                    }
                }
                else {

                    if (ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(pBzGetProcessSummaryOutBean.getNowNodoId())) {

                        return false;
                    }
                }
            }
        }

        return true;

    }
}

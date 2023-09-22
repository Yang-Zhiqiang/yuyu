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
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 工程 新契約工程遷移（ペーパーレス申込入力）
 */
public class SkProcessForwardPaperlessMousikomi {

    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public SkProcessForwardPaperlessMousikomi() {
        super();
    }

    public void kouteiSeni(SkProcessForwardInBean pSkProcessForwardInBean) {

        logger.debug("▽ 新契約工程遷移（ペーパーレス申込入力） 開始");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pSkProcessForwardInBean.getMosNo());
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        C_MostenkenyhKbn mostenkenYhKbn;
        C_UmuKbn hbtrUmu = C_UmuKbn.NONE;
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean;
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzProcessForwardInBean bzProcessForwardInBean;
        BzProcessForward bzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);

        if (C_MostenkenyhKbn.YOU.eq(syoriCTL.getMostenken1jiyhkbn()) ||
            C_MostenkenyhKbn.YOU.eq(syoriCTL.getMostenken2jiyhkbn())) {
            mostenkenYhKbn = C_MostenkenyhKbn.YOU;
        }
        else {
            mostenkenYhKbn = C_MostenkenyhKbn.HUYOU;
        }

        List<HT_SkHubi> skHubiLst = syoriCTL.getSkHubis();

        for (HT_SkHubi skHubi : skHubiLst) {
            List<HT_SkHubiDetail> skHubiDetailLst = skHubi.getSkHubiDetails();

            if (skHubiDetailLst.size() > 0) {
                hbtrUmu = C_UmuKbn.ARI;
                break;
            }
        }

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        BzGetProcessSummaryOutBean drtProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

        SkMainDairitenRuleBean skMainDairitenRuleBean = SWAKInjector.getInstance(SkMainDairitenRuleBean.class);

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

        bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

        bzProcessForwardInBean.setKouteiKanriId(drtProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardInBean.setJimuTetuzukiCd(drtProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
        bzProcessForwardInBean.setIwfApiRuleBean(skMainDairitenRuleBean);
        bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

        bzProcessForward.exec(bzProcessForwardInBean);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTMOS);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        BzGetProcessSummaryOutBean mosProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

        SkInputMosRuleBean skInputMosRuleBean = SWAKInjector.getInstance(SkInputMosRuleBean.class);

        skInputMosRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
        skInputMosRuleBean.setMosuketukeKbn(C_MosUketukeKbn.getContentByValue(
            C_MosUketukeKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getMosuketukekbn())));
        skInputMosRuleBean.setMosnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
            C_VrfjkKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getMosnrkvrfjkkbn())));

        bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

        bzProcessForwardInBean.setKouteiKanriId(mosProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardInBean.setJimuTetuzukiCd(mosProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
        bzProcessForwardInBean.setIwfApiRuleBean(skInputMosRuleBean);
        bzProcessForwardInBean.setSyorikekkaKbn(pSkProcessForwardInBean.getSyorikekkaKbn());
        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

        bzProcessForward.exec(bzProcessForwardInBean);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        BzGetProcessSummaryOutBean kktProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

        SkInputKokutiRuleBean skInputKokutiRuleBean = SWAKInjector.getInstance(SkInputKokutiRuleBean.class);

        skInputKokutiRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
        skInputKokutiRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getSeiritukbn())));
        skInputKokutiRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getMosnrkumu())));
        skInputKokutiRuleBean.setMosuketukeKbn(C_MosUketukeKbn.getContentByValue(
            C_MosUketukeKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getMosuketukekbn())));
        skInputKokutiRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
            C_SntkhouKbn.PATTERN_DEFAULT,
            String.valueOf(mosKihon.getSntkhoukbn())));
        skInputKokutiRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
            C_VrfjkKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getKktnrkvrfjkkbn())));

        bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

        bzProcessForwardInBean.setKouteiKanriId(kktProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardInBean.setJimuTetuzukiCd(kktProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
        bzProcessForwardInBean.setIwfApiRuleBean(skInputKokutiRuleBean);
        bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

        bzProcessForward.exec(bzProcessForwardInBean);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        BzGetProcessSummaryOutBean tenkenProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

        SkTenkenRuleBean skTenkenRuleBean = SWAKInjector.getInstance(SkTenkenRuleBean.class);

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

        bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

        bzProcessForwardInBean.setKouteiKanriId(tenkenProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardInBean.setJimuTetuzukiCd(tenkenProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
        bzProcessForwardInBean.setIwfApiRuleBean(skTenkenRuleBean);
        bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

        bzProcessForward.exec(bzProcessForwardInBean);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        BzGetProcessSummaryOutBean kkstProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

        SkKankyouRuleBean skKankyouRuleBean = SWAKInjector.getInstance(SkKankyouRuleBean.class);

        skKankyouRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
        skKankyouRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getSeiritukbn())));
        skKankyouRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
            C_MostenkenyhKbn.PATTERN_DEFAULT,
            String.valueOf(mostenkenYhKbn)));
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


        bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

        bzProcessForwardInBean.setKouteiKanriId(kkstProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardInBean.setJimuTetuzukiCd(kkstProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
        bzProcessForwardInBean.setIwfApiRuleBean(skKankyouRuleBean);
        bzProcessForwardInBean.setSyorikekkaKbn(pSkProcessForwardInBean.getKnksateikekkaKbn());
        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

        bzProcessForward.exec(bzProcessForwardInBean);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        BzGetProcessSummaryOutBean imustProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

        SkImuRuleBean skImuRuleBean = SWAKInjector.getInstance(SkImuRuleBean.class);

        skImuRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
        skImuRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getSeiritukbn())));
        skImuRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
            C_MostenkenyhKbn.PATTERN_DEFAULT,
            String.valueOf(mostenkenYhKbn)));
        skImuRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
            C_MostenkenjyouKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getMostenkenjoukbn())));
        skImuRuleBean.setImusateijyouKbn(C_ImusateijyouKbn.getContentByValue(
            C_ImusateijyouKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getImusateijyoukbn())));
        skImuRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getKthhbkbn())));

        bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

        bzProcessForwardInBean.setKouteiKanriId(imustProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardInBean.setJimuTetuzukiCd(imustProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
        bzProcessForwardInBean.setIwfApiRuleBean(skImuRuleBean);
        bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

        bzProcessForward.exec(bzProcessForwardInBean);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        BzGetProcessSummaryOutBean hbtrProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = SWAKInjector.getInstance(SkHubiTourokuRuleBean.class);

        skHubiTourokuRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
        skHubiTourokuRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getSeiritukbn())));
        skHubiTourokuRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
            C_MostenkenyhKbn.PATTERN_DEFAULT,
            String.valueOf(mostenkenYhKbn)));
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
            String.valueOf(hbtrUmu)));
        skHubiTourokuRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getKthhbkbn())));

        bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

        bzProcessForwardInBean.setKouteiKanriId(hbtrProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardInBean.setJimuTetuzukiCd(hbtrProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
        bzProcessForwardInBean.setIwfApiRuleBean(skHubiTourokuRuleBean);
        bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

        bzProcessForward.exec(bzProcessForwardInBean);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        BzGetProcessSummaryOutBean skDrtProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

        BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);

        bzOutputProcessRecord.exec(skDrtProcessSummaryOutBean.getKouteiKanriId(),
            skDrtProcessSummaryOutBean.getJimuTetuzukiCd(),
            pSkProcessForwardInBean.getSyoriComment(),
            pSkProcessForwardInBean.getTskNm(),
            pSkProcessForwardInBean.getSyorikekkaKbn());

        SkProcessForwardMoschkExec skProcessForwardMoschkExec = SWAKInjector.getInstance(SkProcessForwardMoschkExec.class);

        skProcessForwardMoschkExec.exec(pSkProcessForwardInBean);

        logger.debug("△ 新契約工程遷移（ペーパーレス申込入力） 終了");
    }
}

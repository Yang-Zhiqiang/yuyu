package yuyu.common.sinkeiyaku.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzLockProcess;
import yuyu.common.biz.koutei.BzLockProcessOutBean;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzProcessForward;
import yuyu.common.biz.koutei.BzProcessForwardInBean;
import yuyu.common.biz.koutei.BzUnlockProcess;
import yuyu.common.biz.koutei.GetSyoruittykymd;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_KouteiLockKekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 工程 新契約工程遷移（当日成立取消）
 */
public class SkProcessForwardToujituSeirituTorikesi {

    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public SkProcessForwardToujituSeirituTorikesi() {
        super();
    }

    public void exec(SkProcessForwardInBean pSkProcessForwardInBean) {

        logger.debug("▽ 新契約工程遷移（当日成立取消） 開始");

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzProcessForward bzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pSkProcessForwardInBean.getMosNo());

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        C_MostenkenyhKbn mostenkenyhKbn = C_MostenkenyhKbn.NONE;

        if (C_MostenkenyhKbn.YOU.eq(syoriCTL.getMostenken1jiyhkbn()) ||
            C_MostenkenyhKbn.YOU.eq(syoriCTL.getMostenken2jiyhkbn()) ) {

            mostenkenyhKbn = C_MostenkenyhKbn.YOU;
        }
        else {
            mostenkenyhKbn = C_MostenkenyhKbn.HUYOU;
        }

        C_UmuKbn hubitourokuUmu = C_UmuKbn.NONE;

        boolean result = getHubiSyouSaiJyouHouBln(syoriCTL);

        if (result) {

            hubitourokuUmu = C_UmuKbn.ARI;
        }
        else {
            hubitourokuUmu = C_UmuKbn.NONE;
        }

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        SkMainDairitenRuleBean skMainDairitenRuleBean = SWAKInjector.getInstance(SkMainDairitenRuleBean.class);

        BzProcessForwardInBean bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

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

        bzProcessForwardInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
        bzProcessForwardInBean.setIwfApiRuleBean(skMainDairitenRuleBean);
        bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

        bzProcessForward.exec(bzProcessForwardInBean);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        SkInputKokutiRuleBean skInputKokutiRuleBean = SWAKInjector.getInstance(SkInputKokutiRuleBean.class);

        bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

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

        bzProcessForwardInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
        bzProcessForwardInBean.setIwfApiRuleBean(skInputKokutiRuleBean);
        bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

        bzProcessForward.exec(bzProcessForwardInBean);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        SkTenkenRuleBean skTenkenRuleBean = SWAKInjector.getInstance(SkTenkenRuleBean.class);

        bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

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

        bzProcessForwardInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
        bzProcessForwardInBean.setIwfApiRuleBean(skTenkenRuleBean);
        bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

        bzProcessForward.exec(bzProcessForwardInBean);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        SkKankyouRuleBean skKankyouRuleBean = SWAKInjector.getInstance(SkKankyouRuleBean.class);

        bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

        skKankyouRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
        skKankyouRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getSeiritukbn())));
        skKankyouRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
            C_MostenkenyhKbn.PATTERN_DEFAULT,
            String.valueOf(mostenkenyhKbn)));
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


        bzProcessForwardInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
        bzProcessForwardInBean.setIwfApiRuleBean(skKankyouRuleBean);
        bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

        bzProcessForward.exec(bzProcessForwardInBean);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        SkImuRuleBean skImuRuleBean = SWAKInjector.getInstance(SkImuRuleBean.class);

        bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

        skImuRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
        skImuRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getSeiritukbn())));
        skImuRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
            C_MostenkenyhKbn.PATTERN_DEFAULT,
            String.valueOf(mostenkenyhKbn)));
        skImuRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
            C_MostenkenjyouKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getMostenkenjoukbn())));
        skImuRuleBean.setImusateijyouKbn(C_ImusateijyouKbn.getContentByValue(
            C_ImusateijyouKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getImusateijyoukbn())));
        skImuRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getKthhbkbn())));

        bzProcessForwardInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
        bzProcessForwardInBean.setIwfApiRuleBean(skImuRuleBean);
        bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

        bzProcessForward.exec(bzProcessForwardInBean);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = SWAKInjector.getInstance(SkHubiTourokuRuleBean.class);

        bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

        skHubiTourokuRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
        skHubiTourokuRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getSeiritukbn())));
        skHubiTourokuRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
            C_MostenkenyhKbn.PATTERN_DEFAULT,
            String.valueOf(mostenkenyhKbn)));
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
            String.valueOf(hubitourokuUmu)));
        skHubiTourokuRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(syoriCTL.getKthhbkbn())));

        bzProcessForwardInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
        bzProcessForwardInBean.setIwfApiRuleBean(skHubiTourokuRuleBean);
        bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

        bzProcessForward.exec(bzProcessForwardInBean);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        SkHubiKaisyouRuleBean skHubiKaisyouRuleBean = SWAKInjector.getInstance(SkHubiKaisyouRuleBean.class);

        bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanList.size() > 0) {

            bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

            skHubiKaisyouRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
            skHubiKaisyouRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                C_SeirituKbn.PATTERN_DEFAULT,
                String.valueOf(syoriCTL.getSeiritukbn())));
            skHubiKaisyouRuleBean.setHubikaisyoujoutaiKbn(C_HubikaisyoujoutaiKbn.getContentByValue(
                C_HubikaisyoujoutaiKbn.PATTERN_DEFAULT,
                String.valueOf(syoriCTL.getHubikaisyoujoutaikbn())));

            bzProcessForwardInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
            bzProcessForwardInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
            bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
            bzProcessForwardInBean.setIwfApiRuleBean(skHubiKaisyouRuleBean);
            bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
            bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

            bzProcessForward.exec(bzProcessForwardInBean);
        }

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        SkKeiyakukakuninRuleBean skKeiyakukakuninRuleBean = SWAKInjector.getInstance(SkKeiyakukakuninRuleBean.class);

        bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanList.size() > 0) {

            bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

            skKeiyakukakuninRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
            skKeiyakukakuninRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                C_SeirituKbn.PATTERN_DEFAULT,
                String.valueOf(syoriCTL.getSeiritukbn())));
            skKeiyakukakuninRuleBean.setKetteiKbn(C_KetteiKbn.getContentByValue(
                C_KetteiKbn.PATTERN_DEFAULT,
                String.valueOf(syoriCTL.getKetteikbn())));
            skKeiyakukakuninRuleBean.setKykkakjkKbn(C_KykkakjkKbn.getContentByValue(
                C_KykkakjkKbn.PATTERN_DEFAULT,
                String.valueOf(syoriCTL.getKykkakjkkbn())));

            bzProcessForwardInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
            bzProcessForwardInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
            bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
            bzProcessForwardInBean.setIwfApiRuleBean(skKeiyakukakuninRuleBean);
            bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
            bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

            bzProcessForward.exec(bzProcessForwardInBean);
        }

        HT_KnksateiRireki knksateiRireki =
            sinkeiyakuDomManager.getKnksateiRirekiByMosnoMaxRenno(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

        GetSyoruittykymd getSyoruittykymd = SWAKInjector.getInstance(GetSyoruittykymd.class);
        BizDate trkSseikyutykYmd = getSyoruittykymd.exec(bzGetProcessSummaryOutBean.getKouteiKanriId(),
            C_SyoruiCdKbn.SK_TRKSSEIKYU);

        if (trkSseikyutykYmd != null &&
            !(C_SateiketsyorinmKbn.TORIKESI.eq(knksateiRireki.getSateiketsyorinmkbn()) &&
                C_SyorikekkaKbn.KANRYOU.eq(knksateiRireki.getKnksateikekkakbn()))) {

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            SkTorikesiRuleBean skTorikesiRuleBean = SWAKInjector.getInstance(SkTorikesiRuleBean.class);

            bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanList.size() >0) {

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                skTorikesiRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                    C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                skTorikesiRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                    C_SeirituKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getSeiritukbn())));
                skTorikesiRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getMosnrkumu())));

                bzProcessForwardInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
                bzProcessForwardInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
                bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
                bzProcessForwardInBean.setIwfApiRuleBean(skTorikesiRuleBean);
                bzProcessForwardInBean.setSyorikekkaKbn(pSkProcessForwardInBean.getSyorikekkaKbn());
                bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

                bzProcessForward.exec(bzProcessForwardInBean);
            }
        }

        if (C_YouhiKbn.YOU.eq(pSkProcessForwardInBean.getHnkninputTorikesiyhKbn())) {

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            SkHenkinRuleBean skHenkinRuleBean = SWAKInjector.getInstance(SkHenkinRuleBean.class);

            bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanList.size() > 0) {

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                List<HT_Henkin> henkinList = syoriCTL.getHenkinsByHnknsyoriymdNull();

                if (henkinList.size() == 0) {

                    BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);

                    BzLockProcessOutBean bzLockProcessOutBean = bzLockProcess.exec(
                        bzGetProcessSummaryOutBean.getKouteiKanriId(),
                        bzGetProcessSummaryOutBean.getJimuTetuzukiCd());

                    if (!C_KouteiLockKekkaKbn.SUCCESS.eq(bzLockProcessOutBean.getKouteiLockKekkaKbn())) {
                        throw new BizLogicException(MessageId.EBA0110);
                    }

                    skHenkinRuleBean.setNyknnrkUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getNyknnrkumu())));
                    skHenkinRuleBean.setPkakinUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(C_UmuKbn.NONE)));

                    bzProcessForwardInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
                    bzProcessForwardInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
                    bzProcessForwardInBean.setKouteiLockKey(bzLockProcessOutBean.getKouteiLockKey());
                    bzProcessForwardInBean.setSyoriComment(pSkProcessForwardInBean.getSyoriComment());
                    bzProcessForwardInBean.setIwfApiRuleBean(skHenkinRuleBean);
                    bzProcessForwardInBean.setSyorikekkaKbn(pSkProcessForwardInBean.getSyorikekkaKbn());
                    bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

                    bzProcessForward.exec(bzProcessForwardInBean);

                    BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);

                    bzUnlockProcess.exec(bzGetProcessSummaryOutBean.getKouteiKanriId(),
                        bzGetProcessSummaryOutBean.getJimuTetuzukiCd(),
                        bzLockProcessOutBean.getKouteiLockKey());
                }
            }
        }

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

        bzOutputProcessRecord.exec(bzGetProcessSummaryOutBean.getKouteiKanriId(),
            bzGetProcessSummaryOutBean.getJimuTetuzukiCd(),
            pSkProcessForwardInBean.getSyoriComment(),
            pSkProcessForwardInBean.getTskNm(),
            pSkProcessForwardInBean.getSyorikekkaKbn());

        SkProcessForwardMoschkExec skProcessForwardMoschkExec = SWAKInjector.getInstance(SkProcessForwardMoschkExec.class);

        skProcessForwardMoschkExec.exec(pSkProcessForwardInBean);

        logger.debug("△ 新契約工程遷移（当日成立取消） 終了");
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

}

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
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
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
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 工程 新契約工程遷移（新契約不備解消）
 */
public class SkProcessForwardHubiKaisyou {

    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public SkProcessForwardHubiKaisyou() {
        super();
    }

    public void exec(SkProcessForwardInBean pSkProcessForwardInBean) {

        logger.debug("▽ 新契約工程遷移（新契約不備解消） 開始");

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

        String mostenkentnsketsyaCd = "";

        if (ISkCommonKoumoku.KETTEISYACD_KYOUYOU.equals(pSkProcessForwardInBean.getMostenkentnsketsyaCd()) ||
            (C_UmuKbn.ARI.eq(syoriCTL.getKthhbkbn()) &&
                C_MostenkenjyouKbn.TENKENMATI_HUBI.eq(syoriCTL.getMostenkenjoukbn()) &&
                !C_SyorikekkaKbn.TENSOU_TENKEN_HUBI.eq(pSkProcessForwardInBean.getMostenkenkekkaKbn()))) {

            mostenkentnsketsyaCd = "";
        }
        else {
            mostenkentnsketsyaCd = pSkProcessForwardInBean.getMostenkentnsketsyaCd();
        }

        String knktnsketsyaCd = "";

        if (ISkCommonKoumoku.KETTEISYACD_KYOUYOU.equals(pSkProcessForwardInBean.getKnktnsketsyaCd()) ||
            (C_UmuKbn.ARI.eq(syoriCTL.getKthhbkbn()) &&
                C_MostenkenjyouKbn.TENKENMATI_HUBI.eq(syoriCTL.getMostenkenjoukbn()) &&
                !C_SyorikekkaKbn.TENSOU_TENKEN_HUBI.eq(pSkProcessForwardInBean.getMostenkenkekkaKbn()))) {

            knktnsketsyaCd = "";
        }
        else {
            knktnsketsyaCd = pSkProcessForwardInBean.getKnktnsketsyaCd();
        }

        String imutnsketsyaCd = "";

        if (ISkCommonKoumoku.KETTEISYACD_KYOUYOU.equals(pSkProcessForwardInBean.getImutnsketsyaCd()) ||
            (C_UmuKbn.ARI.eq(syoriCTL.getKthhbkbn()) &&
                C_MostenkenjyouKbn.TENKENMATI_HUBI.eq(syoriCTL.getMostenkenjoukbn()) &&
                !C_SyorikekkaKbn.TENSOU_TENKEN_HUBI.eq(pSkProcessForwardInBean.getMostenkenkekkaKbn()))) {

            imutnsketsyaCd = "";
        }
        else {
            imutnsketsyaCd = pSkProcessForwardInBean.getImutnsketsyaCd();
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

        if (C_SyorikekkaKbn.TENSOU_TENKEN_1.eq(pSkProcessForwardInBean.getMostenkenkekkaKbn()) ||
            C_SyorikekkaKbn.TENSOU_TENKEN_2.eq(pSkProcessForwardInBean.getMostenkenkekkaKbn()) ||
            C_SyorikekkaKbn.TENSOU_TENKEN_HUBI.eq(pSkProcessForwardInBean.getMostenkenkekkaKbn())) {

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
            bzProcessForwardInBean.setSyorikekkaKbn(pSkProcessForwardInBean.getMostenkenkekkaKbn());
            bzProcessForwardInBean.setSaiwariateUserId(mostenkentnsketsyaCd);
            bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

            bzProcessForward.exec(bzProcessForwardInBean);
        }
        else {
            if (C_SyorikekkaKbn.TENSOU_KANKYOU_1.eq(pSkProcessForwardInBean.getKnksateikekkaKbn()) ||
                C_SyorikekkaKbn.TENSOU_KANKYOU_2A.eq(pSkProcessForwardInBean.getKnksateikekkaKbn()) ||
                C_SyorikekkaKbn.TENSOU_KANKYOU_2B.eq(pSkProcessForwardInBean.getKnksateikekkaKbn())) {

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
                bzProcessForwardInBean.setSyorikekkaKbn(pSkProcessForwardInBean.getKnksateikekkaKbn());
                bzProcessForwardInBean.setSaiwariateUserId(knktnsketsyaCd);
                bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

                bzProcessForward.exec(bzProcessForwardInBean);
            }

            if (C_SyorikekkaKbn.TENSOU_IMU_KANIUW.eq(pSkProcessForwardInBean.getImusateikekkaKbn()) ||
                C_SyorikekkaKbn.TENSOU_IMU_KANIMD.eq(pSkProcessForwardInBean.getImusateikekkaKbn())) {

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
                bzProcessForwardInBean.setSyorikekkaKbn(pSkProcessForwardInBean.getImusateikekkaKbn());
                bzProcessForwardInBean.setSaiwariateUserId(imutnsketsyaCd);
                bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

                bzProcessForward.exec(bzProcessForwardInBean);
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

        logger.debug("△ 新契約工程遷移（新契約不備解消） 終了");
    }

}

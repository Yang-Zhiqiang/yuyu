package yuyu.common.sinkeiyaku.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzProcessForward;
import yuyu.common.biz.koutei.BzProcessForwardInBean;
import yuyu.common.biz.koutei.CheckTaskKengen;
import yuyu.common.biz.koutei.GetSyoruittykymd;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MostenkenRankKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosKihonVrf;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 工程 新契約工程遷移（変更訂正）
 */
public class SkProcessForwardTeisei {

    private static final String SYORI_COMMENT = "申込内容の訂正が行われたため、申込点検（１次）へ自動転送します。";

    private static final String KINOUID_MOSTENKEN = "skmousikomitenken";
    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    public SkProcessForwardTeisei() {
        super();
    }

    public void exec(SkProcessForwardInBean pSkProcessForwardInBean) {

        logger.debug("▽ 新契約工程遷移（変更訂正） 開始");

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzProcessForward bzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);
        String mainKouteiKanriId = null;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pSkProcessForwardInBean.getMosNo());

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        C_SntkhouKbn sntkhouKbn = C_SntkhouKbn.BLNK;

        if (mosKihon == null) {
            HT_MosKihonVrf mMosKihonVrf = syoriCTL.getMosKihonVrf();

            sntkhouKbn = mMosKihonVrf.getSntkhoukbn();

        } else {
            sntkhouKbn = mosKihon.getSntkhoukbn();
        }

        C_MostenkenyhKbn mostenkenyhKbn = C_MostenkenyhKbn.NONE;

        if (C_MostenkenyhKbn.YOU.eq(syoriCTL.getMostenken1jiyhkbn()) ||
            C_MostenkenyhKbn.YOU.eq(syoriCTL.getMostenken2jiyhkbn()) ) {

            mostenkenyhKbn = C_MostenkenyhKbn.YOU;
        }
        else {
            mostenkenyhKbn = C_MostenkenyhKbn.HUYOU;
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
        mainKouteiKanriId = bzGetProcessSummaryOutBean.getKouteiKanriId();

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
            String.valueOf(sntkhouKbn)));
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

        if (!C_SntkhouKbn.KKT.eq(sntkhouKbn) ||
            (C_SntkhouKbn.KKT.eq(sntkhouKbn) &&
                ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(bzGetProcessSummaryOutBean.getNowNodoId()))) {

            GetSyoruittykymd getSyoruittykymd = SWAKInjector.getInstance(GetSyoruittykymd.class);

            BizDate syoruittykYmd = getSyoruittykymd.exec(mainKouteiKanriId, C_SyoruiCdKbn.SK_KOKUSYO);

            if (syoruittykYmd != null) {

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
                    String.valueOf(sntkhouKbn)));
                skInputKokutiRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                    C_VrfjkKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getKktnrkvrfjkkbn())));

                bzProcessForwardInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
                bzProcessForwardInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
                bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
                bzProcessForwardInBean.setIwfApiRuleBean(skInputKokutiRuleBean);
                bzProcessForwardInBean.setSyorikekkaKbn(pSkProcessForwardInBean.getSyorikekkaKbn());
                bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

                bzProcessForward.exec(bzProcessForwardInBean);
            }
        }

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
            String.valueOf(sntkhouKbn)));
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
        bzProcessForwardInBean.setSaiwariateUserId(editMostenkentnsketsyaCd(skTenkenRuleBean));
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

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

        bzOutputProcessRecord.exec(bzGetProcessSummaryOutBean.getKouteiKanriId(),
            bzGetProcessSummaryOutBean.getJimuTetuzukiCd(),
            SYORI_COMMENT,
            pSkProcessForwardInBean.getTskNm(),
            C_SyorikekkaKbn.IRAI_TENKEN_1);

        logger.debug("△ 新契約工程遷移（変更訂正） 終了");
    }


    private String editMostenkentnsketsyaCd(SkTenkenRuleBean pSkTenkenRuleBean) {

        String mostenkentnsketsyaCd = "";

        boolean ketteiSyaKengenRst = true;

        boolean KinouModeKengenRst = true;

        boolean taskKengenRst = true;

        if (!C_SeirituKbn.NONE.getContent().equals(pSkTenkenRuleBean.getSeirituKbn())) {

            return mostenkentnsketsyaCd;
        }
        else if (C_UmuKbn.NONE.getContent().equals(pSkTenkenRuleBean.getMosnrkUmu())) {

            return mostenkentnsketsyaCd;
        }
        else if (C_SntkhouKbn.KKT.getContent().equals(pSkTenkenRuleBean.getSntkhouKbn()) &&
            !C_VrfjkKbn.KANRYOU.getContent().equals(pSkTenkenRuleBean.getKktnrkvrfjkKbn())) {

            return mostenkentnsketsyaCd;
        }

        HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(baseUserInfo.getUserId());

        if (ketteiSya != null) {

            if (C_MostenkenRankKbn.BLNK.eq(ketteiSya.getMostenkenrankkbn())
                || C_MostenkenRankKbn.NONE.eq(ketteiSya.getMostenkenrankkbn())) {

                ketteiSyaKengenRst = false;
            }
        }
        else {
            ketteiSyaKengenRst = false;
        }

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        KinouModeKengenRst = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
            baseUserInfo.getUserId(),
            KINOUID_MOSTENKEN,
            C_SkkinouModeIdKbn.MOSTENKEN_1JI.getValue());

        CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);

        taskKengenRst = checkTaskKengen.exec(
            baseUserInfo.getUserId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN,
            ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI);

        if (ketteiSyaKengenRst && KinouModeKengenRst && taskKengenRst) {

            mostenkentnsketsyaCd = baseUserInfo.getUserId();
        }

        return mostenkentnsketsyaCd;
    }
}

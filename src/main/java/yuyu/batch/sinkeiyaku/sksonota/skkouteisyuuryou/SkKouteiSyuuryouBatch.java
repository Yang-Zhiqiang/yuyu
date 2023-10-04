package yuyu.batch.sinkeiyaku.sksonota.skkouteisyuuryou;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzProcessForwardForBatch;
import yuyu.common.biz.koutei.BzProcessForwardForBatchInBean;
import yuyu.common.sinkeiyaku.koutei.SkHubiKaisyouRuleBean;
import yuyu.common.sinkeiyaku.koutei.SkHubiTourokuRuleBean;
import yuyu.common.sinkeiyaku.koutei.SkImuRuleBean;
import yuyu.common.sinkeiyaku.koutei.SkInputKokutiRuleBean;
import yuyu.common.sinkeiyaku.koutei.SkInputMosRuleBean;
import yuyu.common.sinkeiyaku.koutei.SkKankyouRuleBean;
import yuyu.common.sinkeiyaku.koutei.SkKeiyakukakuninRuleBean;
import yuyu.common.sinkeiyaku.koutei.SkMainDairitenRuleBean;
import yuyu.common.sinkeiyaku.koutei.SkTenkenRuleBean;
import yuyu.common.sinkeiyaku.koutei.SkTorikesiRuleBean;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 その他 新契約工程終了処理
 */
public class SkKouteiSyuuryouBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final String TASKNAME = "新契約工程終了処理";

    private final String SYOURICOMMENT = "新契約事務手続を終了します。";

    @Inject
    private SkKouteiSyuuryouBatchParam skKouteiSyuuryouBatchParam;
    @Override
    public BatchParam getParam() {
        return skKouteiSyuuryouBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = skKouteiSyuuryouBatchParam.getSyoriYmd();

        int maxSyoricnt = skKouteiSyuuryouBatchParam.getMaxsyoricnt();

        boolean zanariFlg = false;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "最大処理件数",
            String.valueOf(maxSyoricnt)));

        try (ExDBResults<HT_SyoriCTL> syoriCTLExDBResults = sinkeiyakuDomManager.getSyoriCTLsBySrsyoriymd(
            skKouteiSyuuryouBatchParam.getSyoriYmd())) {

            int syoriKensuu = 0;

            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            BzProcessForwardForBatch bzProcessForwardForBatch = SWAKInjector
                .getInstance(BzProcessForwardForBatch.class);

            List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanList = new ArrayList<>();

            for (HT_SyoriCTL syoriCTL : syoriCTLExDBResults) {

                if(syoriKensuu >= maxSyoricnt){
                    zanariFlg = true;
                    break;
                }

                C_MostenkenyhKbn mostenkenyhKbn = null;

                C_UmuKbn umuKbn = null;

                if (C_MostenkenyhKbn.YOU.eq(syoriCTL.getMostenken1jiyhkbn())
                    || C_MostenkenyhKbn.YOU.eq(syoriCTL.getMostenken2jiyhkbn())) {

                    mostenkenyhKbn = C_MostenkenyhKbn.YOU;

                }
                else {
                    mostenkenyhKbn = C_MostenkenyhKbn.HUYOU;
                }

                Boolean resultRtn = getHubiSyouSaiJyouHouBln(syoriCTL);

                if (resultRtn) {

                    umuKbn = C_UmuKbn.ARI;

                }
                else {

                    umuKbn = C_UmuKbn.NONE;

                }

                BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryInBean.class);

                SkMainDairitenRuleBean skMainDairitenRuleBean = SWAKInjector
                    .getInstance(SkMainDairitenRuleBean.class);

                BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean = SWAKInjector
                    .getInstance(BzProcessForwardForBatchInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

                bzGetProcessSummaryInBean.setMosNo(syoriCTL.getMosno());

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary
                    .exec(bzGetProcessSummaryInBean);

                if (bzGetProcessSummaryOutBeanList.size() == 0) {

                    continue;
                }

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                skMainDairitenRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                    C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SkkouteikanryouKbn.KANRYOU)));

                skMainDairitenRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                    C_SeirituKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getSeiritukbn())));

                skMainDairitenRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getMosnrkumu())));

                skMainDairitenRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
                    C_SntkhouKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getMosKihon().getSntkhoukbn())));

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

                bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

                bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());

                bzProcessForwardForBatchInBean.setTaskNm(TASKNAME);

                bzProcessForwardForBatchInBean.setSyoriComment(SYOURICOMMENT);

                bzProcessForwardForBatchInBean.setIwfApiRuleBean(skMainDairitenRuleBean);

                bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

                bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                SkInputMosRuleBean skInputMosRuleBean = SWAKInjector.getInstance(SkInputMosRuleBean.class);

                bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTMOS);

                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

                bzGetProcessSummaryInBean.setMosNo(syoriCTL.getMosno());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                skInputMosRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                    C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SkkouteikanryouKbn.KANRYOU)));

                skInputMosRuleBean.setMosuketukeKbn(C_MosUketukeKbn.getContentByValue(
                    C_MosUketukeKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getMosuketukekbn())));

                skInputMosRuleBean.setMosnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                    C_VrfjkKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getMosnrkvrfjkkbn())));

                bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

                bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());

                bzProcessForwardForBatchInBean.setIwfApiRuleBean(skInputMosRuleBean);

                bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

                bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                SkInputKokutiRuleBean skInputKokutiRuleBean = SWAKInjector.getInstance(SkInputKokutiRuleBean.class);

                bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI);

                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

                bzGetProcessSummaryInBean.setMosNo(syoriCTL.getMosno());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                skInputKokutiRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                    C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SkkouteikanryouKbn.KANRYOU)));

                skInputKokutiRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                    C_SeirituKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getSeiritukbn())));

                skInputKokutiRuleBean.setMosuketukeKbn(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getMosuketukekbn())));

                skInputKokutiRuleBean.setMosnrkUmu(C_MosUketukeKbn.getContentByValue(
                    C_MosUketukeKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getMosnrkumu())));

                skInputKokutiRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
                    C_SntkhouKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getMosKihon().getSntkhoukbn())));

                skInputKokutiRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                    C_VrfjkKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getKktnrkvrfjkkbn())));

                bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

                bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());

                bzProcessForwardForBatchInBean.setIwfApiRuleBean(skInputKokutiRuleBean);

                bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

                bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                SkTenkenRuleBean skTenkenRuleBean = SWAKInjector.getInstance(SkTenkenRuleBean.class);

                bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);

                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

                bzGetProcessSummaryInBean.setMosNo(syoriCTL.getMosno());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                skTenkenRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                    C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SkkouteikanryouKbn.KANRYOU)));

                skTenkenRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                    C_SeirituKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getSeiritukbn())));

                skTenkenRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getMosnrkumu())));

                skTenkenRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
                    C_SntkhouKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getMosKihon().getSntkhoukbn())));

                skTenkenRuleBean.setKktnrkUmu(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getKktnrkumu())));

                skTenkenRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                    C_VrfjkKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getKktnrkvrfjkkbn())));

                skTenkenRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                    C_MostenkenjyouKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getMostenkenjoukbn())));

                bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

                bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());

                bzProcessForwardForBatchInBean.setIwfApiRuleBean(skTenkenRuleBean);

                bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

                bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                SkKankyouRuleBean skKankyouRuleBean = SWAKInjector.getInstance(SkKankyouRuleBean.class);

                bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);

                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

                bzGetProcessSummaryInBean.setMosNo(syoriCTL.getMosno());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                skKankyouRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                    C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SkkouteikanryouKbn.KANRYOU)));

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

                bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

                bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());

                bzProcessForwardForBatchInBean.setIwfApiRuleBean(skKankyouRuleBean);

                bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

                bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                SkImuRuleBean skImuRuleBean = SWAKInjector.getInstance(SkImuRuleBean.class);

                bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);

                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

                bzGetProcessSummaryInBean.setMosNo(syoriCTL.getMosno());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                skImuRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                    C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SkkouteikanryouKbn.KANRYOU)));

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

                bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

                bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());

                bzProcessForwardForBatchInBean.setIwfApiRuleBean(skImuRuleBean);

                bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

                bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                SkHubiTourokuRuleBean skHubiTourokuRuleBean = SWAKInjector.getInstance(SkHubiTourokuRuleBean.class);

                bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);

                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

                bzGetProcessSummaryInBean.setMosNo(syoriCTL.getMosno());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                skHubiTourokuRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                    C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SkkouteikanryouKbn.KANRYOU)));

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
                    String.valueOf(C_HubihassintnsKbn.BLNK)));

                skHubiTourokuRuleBean.setHubitourokuUmu(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(umuKbn)));

                skHubiTourokuRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getKthhbkbn())));

                bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

                bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());

                bzProcessForwardForBatchInBean.setIwfApiRuleBean(skHubiTourokuRuleBean);

                bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

                bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                SkHubiKaisyouRuleBean skHubiKaisyouRuleBean = SWAKInjector.getInstance(SkHubiKaisyouRuleBean.class);

                bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU);

                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

                bzGetProcessSummaryInBean.setMosNo(syoriCTL.getMosno());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                if (bzGetProcessSummaryOutBeanList.size() > 0) {

                    bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                    skHubiKaisyouRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.KANRYOU)));

                    skHubiKaisyouRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getSeiritukbn())));

                    skHubiKaisyouRuleBean.setHubikaisyoujoutaiKbn(C_HubikaisyoujoutaiKbn.getContentByValue(
                        C_HubikaisyoujoutaiKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getHubikaisyoujoutaikbn())));

                    bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

                    bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());

                    bzProcessForwardForBatchInBean.setIwfApiRuleBean(skHubiKaisyouRuleBean);

                    bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);
                }

                bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                SkKeiyakukakuninRuleBean skKeiyakukakuninRuleBean = SWAKInjector
                    .getInstance(SkKeiyakukakuninRuleBean.class);

                bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN);

                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

                bzGetProcessSummaryInBean.setMosNo(syoriCTL.getMosno());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                if (bzGetProcessSummaryOutBeanList.size() > 0) {

                    bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                    skKeiyakukakuninRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.KANRYOU)));
                    skKeiyakukakuninRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getSeiritukbn())));

                    skKeiyakukakuninRuleBean.setKetteiKbn(C_KetteiKbn.getContentByValue(
                        C_KetteiKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getKetteikbn())));

                    skKeiyakukakuninRuleBean.setKykkakjkKbn(C_KykkakjkKbn.getContentByValue(
                        C_KykkakjkKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getKykkakjkkbn())));

                    bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

                    bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());

                    bzProcessForwardForBatchInBean.setIwfApiRuleBean(skKeiyakukakuninRuleBean);

                    bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);
                }

                bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                SkTorikesiRuleBean skTorikesiRuleBean = SWAKInjector.getInstance(SkTorikesiRuleBean.class);

                bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI);

                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

                bzGetProcessSummaryInBean.setMosNo(syoriCTL.getMosno());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                if (bzGetProcessSummaryOutBeanList.size() > 0) {

                    bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                    skTorikesiRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.KANRYOU)));
                    skTorikesiRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getSeiritukbn())));
                    skTorikesiRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getMosnrkumu())));

                    bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

                    bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());

                    bzProcessForwardForBatchInBean.setIwfApiRuleBean(skTorikesiRuleBean);

                    bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);
                }
                syoriKensuu++;

            }

            bzProcessForwardForBatch.exec(bzProcessForwardForBatchInBeanList);

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), TASKNAME));

            if(zanariFlg){
                batchLogger.info("繰越対象あり");
            }
        }
    }

    private Boolean getHubiSyouSaiJyouHouBln(HT_SyoriCTL pSyoriCTL) {

        Boolean resultRtn = false;

        List<HT_SkHubi> skHubiList = pSyoriCTL.getSkHubis();

        for (HT_SkHubi skHubi : skHubiList) {

            List<HT_SkHubiDetail> skHubiDetailList = skHubi.getSkHubiDetails();

            if (skHubiDetailList.size() > 0) {

                resultRtn = true;

                break;

            }
        }

        return resultRtn;
    }
}

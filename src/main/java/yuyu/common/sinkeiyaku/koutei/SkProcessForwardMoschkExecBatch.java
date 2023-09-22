package yuyu.common.sinkeiyaku.koutei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzProcessForwardForBatchInBean;
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
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 工程 新契約工程遷移（申込内容チェック実行）_バッチ用
 */
public class SkProcessForwardMoschkExecBatch {

    @Inject
    private static Logger logger;

    private C_MostenkenyhKbn MOSTENKENYHKBN = C_MostenkenyhKbn.HUYOU;

    private C_UmuKbn HUBITOUROKUUMU = C_UmuKbn.NONE;

    public SkProcessForwardMoschkExecBatch() {
        super();
    }

    public List<BzProcessForwardForBatchInBean> exec(SkProcessForwardForBatchInBean pSkProcessForwardForBatchInBean) {

        logger.debug("▽ 新契約工程遷移（申込内容チェック実行）_バッチ用 開始");

        SkProcessForwardKetteiHoryuuHubiBatch skProcessForwardKetteiHoryuuHubiBatch = SWAKInjector.getInstance(
            SkProcessForwardKetteiHoryuuHubiBatch.class);
        SkProcessForwardSeirituBatch skProcessForwardSeirituBatch = SWAKInjector.getInstance(
            SkProcessForwardSeirituBatch.class);

        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanList = new ArrayList<>();

        if (C_UmuKbn.ARI.eq(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKthhbkbn())) {

            List<BzProcessForwardForBatchInBean> processForwardKetteiHoryuuHubiList =
                skProcessForwardKetteiHoryuuHubiBatch.exec(pSkProcessForwardForBatchInBean);

            if (processForwardKetteiHoryuuHubiList != null
                && processForwardKetteiHoryuuHubiList.size() > 0) {

                bzProcessForwardForBatchInBeanList.addAll(processForwardKetteiHoryuuHubiList);
            }
        }
        else if (C_SeirituKbn.SEIRITU.eq(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())) {

            List<BzProcessForwardForBatchInBean> processForwardSeirituList =
                skProcessForwardSeirituBatch.exec(pSkProcessForwardForBatchInBean);

            if (processForwardSeirituList != null
                && processForwardSeirituList.size() > 0) {

                bzProcessForwardForBatchInBeanList.addAll(processForwardSeirituList);
            }
        }
        else if (C_UmuKbn.ARI.eq(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosnrkumu())) {

            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean;

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = new ArrayList<>();

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                .getInstance(BzGetProcessSummaryOutBean.class);

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanList != null && bzGetProcessSummaryOutBeanList.size() > 0) {

                SkTenkenRuleBean skTenkenRuleBean;
                SkKankyouRuleBean skKankyouRuleBean;
                SkImuRuleBean skImuRuleBean;
                SkHubiTourokuRuleBean skHubiTourokuRuleBean;
                BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean;

                if (C_MostenkenyhKbn.YOU.eq(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMostenken1jiyhkbn()) ||
                    C_MostenkenyhKbn.YOU.eq(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMostenken2jiyhkbn()) ) {

                    MOSTENKENYHKBN = C_MostenkenyhKbn.YOU;
                }
                else {
                    MOSTENKENYHKBN = C_MostenkenyhKbn.HUYOU;
                }

                HUBITOUROKUUMU = pSkProcessForwardForBatchInBean.getSkHubiDetailUmu();

                bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                skTenkenRuleBean = SWAKInjector.getInstance(SkTenkenRuleBean.class);

                bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                if (checkForwardExec(pSkProcessForwardForBatchInBean.getHtSyoriCTL(), bzGetProcessSummaryOutBean)) {

                    skTenkenRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skTenkenRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
                    skTenkenRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosnrkumu())));
                    skTenkenRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
                        C_SntkhouKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosKihon().getSntkhoukbn())));
                    skTenkenRuleBean.setKktnrkUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKktnrkumu())));
                    skTenkenRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                        C_VrfjkKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKktnrkvrfjkkbn())));
                    skTenkenRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                        C_MostenkenjyouKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMostenkenjoukbn())));

                    bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
                    bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
                    bzProcessForwardForBatchInBean.setIwfApiRuleBean(skTenkenRuleBean);

                    bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);
                }

                bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                skKankyouRuleBean = SWAKInjector.getInstance(SkKankyouRuleBean.class);

                bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                if (checkForwardExec(pSkProcessForwardForBatchInBean.getHtSyoriCTL(), bzGetProcessSummaryOutBean)) {

                    skKankyouRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skKankyouRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
                    skKankyouRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
                        C_MostenkenyhKbn.PATTERN_DEFAULT,
                        String.valueOf(MOSTENKENYHKBN)));
                    skKankyouRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                        C_MostenkenjyouKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMostenkenjoukbn())));
                    skKankyouRuleBean.setKnkysateijyouKbn(C_KnkysateijyouKbn.getContentByValue(
                        C_KnkysateijyouKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKnkysateijyoukbn())));
                    skKankyouRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKthhbkbn())));
                    skKankyouRuleBean.setLincjkKbn(C_LincjkKbn.getContentByValue(
                        C_LincjkKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getLincjkkbn())));

                    bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
                    bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
                    bzProcessForwardForBatchInBean.setIwfApiRuleBean(skKankyouRuleBean);

                    bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);
                }

                bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                skImuRuleBean = SWAKInjector.getInstance(SkImuRuleBean.class);

                bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                if (checkForwardExec(pSkProcessForwardForBatchInBean.getHtSyoriCTL(), bzGetProcessSummaryOutBean)) {

                    skImuRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skImuRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
                    skImuRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
                        C_MostenkenyhKbn.PATTERN_DEFAULT,
                        String.valueOf(MOSTENKENYHKBN)));
                    skImuRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                        C_MostenkenjyouKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMostenkenjoukbn())));
                    skImuRuleBean.setImusateijyouKbn(C_ImusateijyouKbn.getContentByValue(
                        C_ImusateijyouKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getImusateijyoukbn())));
                    skImuRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKthhbkbn())));

                    bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
                    bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
                    bzProcessForwardForBatchInBean.setIwfApiRuleBean(skImuRuleBean);

                    bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);
                }

                bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                skHubiTourokuRuleBean = SWAKInjector.getInstance(SkHubiTourokuRuleBean.class);

                bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

                bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                if (checkForwardExec(pSkProcessForwardForBatchInBean.getHtSyoriCTL(), bzGetProcessSummaryOutBean)) {

                    skHubiTourokuRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skHubiTourokuRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
                    skHubiTourokuRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
                        C_MostenkenyhKbn.PATTERN_DEFAULT,
                        String.valueOf(MOSTENKENYHKBN)));
                    skHubiTourokuRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                        C_MostenkenjyouKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMostenkenjoukbn())));
                    skHubiTourokuRuleBean.setMihassinhubiUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMihassinhubiumu())));
                    skHubiTourokuRuleBean.setHubihassintnsUmu(C_HubihassintnsKbn.getContentByValue(
                        C_HubihassintnsKbn.PATTERN_DEFAULT,
                        String.valueOf(C_HubihassintnsKbn.BLNK)));
                    skHubiTourokuRuleBean.setHubitourokuUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getSkHubiDetailUmu())));
                    skHubiTourokuRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKthhbkbn())));

                    bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
                    bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
                    bzProcessForwardForBatchInBean.setIwfApiRuleBean(skHubiTourokuRuleBean);

                    bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);
                }
            }
        }

        logger.debug("△ 新契約工程遷移（申込内容チェック実行）_バッチ用 終了");

        return bzProcessForwardForBatchInBeanList;
    }

    private boolean checkForwardExec(HT_SyoriCTL pSyoriCtl,
        BzGetProcessSummaryOutBean pBzGetProcessSummaryOutBean) {

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
                        || (C_UmuKbn.NONE.eq(HUBITOUROKUUMU) && C_UmuKbn.ARI.eq(pSyoriCtl.getKthhbkbn()))) {

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
                        || (C_UmuKbn.NONE.eq(HUBITOUROKUUMU) && C_UmuKbn.ARI.eq(pSyoriCtl.getKthhbkbn()))) {

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

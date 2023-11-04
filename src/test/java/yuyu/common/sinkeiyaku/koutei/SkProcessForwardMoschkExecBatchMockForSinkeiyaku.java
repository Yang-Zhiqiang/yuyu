package yuyu.common.sinkeiyaku.koutei;

import java.util.ArrayList;
import java.util.List;

import yuyu.common.biz.koutei.BzProcessForwardForBatchInBean;

/**
 * {@link SkProcessForwardMoschkExecBatch}のモッククラスです。<br />
 */
public class SkProcessForwardMoschkExecBatchMockForSinkeiyaku extends SkProcessForwardMoschkExecBatch {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public List<BzProcessForwardForBatchInBean> exec(SkProcessForwardForBatchInBean pSkProcessForwardForBatchInBean) {

        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst = new ArrayList<>();
        if (caller == SkProcessForwardHurikomiNyuukinTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)){

                return bzProcessForwardForBatchInBeanLst;
            }

            if(TESTPATTERN2.equals(SYORIPTN)){

                if ("870000023".equals(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosno())) {

                    BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean1 = new BzProcessForwardForBatchInBean();
                    bzProcessForwardForBatchInBean1.setKouteiKanriId("kouteikanri3");
                    bzProcessForwardForBatchInBean1.setJimuTetuzukiCd("SkMainDairiten");
                    bzProcessForwardForBatchInBean1.setTaskNm("sinkeiyakuBatch21");
                    bzProcessForwardForBatchInBean1.setSyoriComment("決定保留不備が発生したため、申込点検（点検後不備）へ自動依頼します。");
                    SkMainDairitenRuleBean skMainDairitenRuleBean = new SkMainDairitenRuleBean();
                    skMainDairitenRuleBean.setSkkouteikanryouKbn("処理中");
                    skMainDairitenRuleBean.setSeirituKbn("成立");
                    skMainDairitenRuleBean.setMosnrkUmu("あり");
                    skMainDairitenRuleBean.setSntkhouKbn("告知扱");
                    skMainDairitenRuleBean.setKktnrkUmu("あり");
                    skMainDairitenRuleBean.setKktnrkvrfjkKbn("２次入力待ち");
                    skMainDairitenRuleBean.setMostenkenjouKbn("点検待ち（１次）");
                    skMainDairitenRuleBean.setKetteiKbn("決定済");
                    skMainDairitenRuleBean.setSateijtKbn("査定済");
                    bzProcessForwardForBatchInBean1.setIwfApiRuleBean(skMainDairitenRuleBean);
                    bzProcessForwardForBatchInBeanLst.add(bzProcessForwardForBatchInBean1);

                    BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean2 = new BzProcessForwardForBatchInBean();
                    bzProcessForwardForBatchInBean2.setKouteiKanriId("kouteikanri4");
                    bzProcessForwardForBatchInBean2.setJimuTetuzukiCd("SkTenken");
                    bzProcessForwardForBatchInBean2.setTaskNm(null);
                    bzProcessForwardForBatchInBean2.setSyoriComment(null);
                    SkTenkenRuleBean skTenkenRuleBean = new SkTenkenRuleBean();
                    skTenkenRuleBean.setSkkouteikanryouKbn("処理中");
                    skTenkenRuleBean.setSeirituKbn("成立");
                    skTenkenRuleBean.setMosnrkUmu("あり");
                    skTenkenRuleBean.setSntkhouKbn("告知扱");
                    skTenkenRuleBean.setKktnrkUmu("あり");
                    skTenkenRuleBean.setKktnrkvrfjkKbn("２次入力待ち");
                    skTenkenRuleBean.setMostenkenjouKbn("点検待ち（１次）");
                    bzProcessForwardForBatchInBean2.setIwfApiRuleBean(skTenkenRuleBean);
                    bzProcessForwardForBatchInBeanLst.add(bzProcessForwardForBatchInBean2);

                    BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean3 = new BzProcessForwardForBatchInBean();
                    bzProcessForwardForBatchInBean3.setKouteiKanriId("kouteikanri5");
                    bzProcessForwardForBatchInBean3.setJimuTetuzukiCd("SkKankyou");
                    bzProcessForwardForBatchInBean3.setTaskNm(null);
                    bzProcessForwardForBatchInBean3.setSyoriComment(null);
                    SkKankyouRuleBean skKankyouRuleBean = new SkKankyouRuleBean();
                    skKankyouRuleBean.setSkkouteikanryouKbn("処理中");
                    skKankyouRuleBean.setSeirituKbn("成立");
                    skKankyouRuleBean.setMostenkenyhKbn("実施不要");
                    skKankyouRuleBean.setMostenkenjouKbn("点検待ち（１次）");
                    skKankyouRuleBean.setKnkysateijyouKbn(null);
                    skKankyouRuleBean.setKthhbKbn("あり");
                    bzProcessForwardForBatchInBean3.setIwfApiRuleBean(skKankyouRuleBean);
                    bzProcessForwardForBatchInBeanLst.add(bzProcessForwardForBatchInBean3);

                }
                else if ("870000031".equals(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosno())) {

                    BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean = new BzProcessForwardForBatchInBean();
                    bzProcessForwardForBatchInBean.setKouteiKanriId("kouteikanri6");
                    bzProcessForwardForBatchInBean.setJimuTetuzukiCd("SkMainDairiten");
                    bzProcessForwardForBatchInBean.setTaskNm("sinkeiyakuBatch22");
                    bzProcessForwardForBatchInBean.setSyoriComment("決定保留不備が発生したため、申込点検（点検後不備）へ自動依頼します。");
                    SkMainDairitenRuleBean skMainDairitenRuleBean = new SkMainDairitenRuleBean();
                    skMainDairitenRuleBean.setSkkouteikanryouKbn("処理中");
                    skMainDairitenRuleBean.setSeirituKbn("成立");
                    skMainDairitenRuleBean.setMosnrkUmu("あり");
                    skMainDairitenRuleBean.setSntkhouKbn("告知扱");
                    skMainDairitenRuleBean.setKktnrkUmu("あり");
                    skMainDairitenRuleBean.setKktnrkvrfjkKbn("２次入力待ち");
                    skMainDairitenRuleBean.setMostenkenjouKbn("点検待ち（１次）");
                    skMainDairitenRuleBean.setKetteiKbn("決定済");
                    skMainDairitenRuleBean.setSateijtKbn("査定済");
                    bzProcessForwardForBatchInBean.setIwfApiRuleBean(skMainDairitenRuleBean);
                    bzProcessForwardForBatchInBeanLst.add(bzProcessForwardForBatchInBean);
                }

                return bzProcessForwardForBatchInBeanLst;
            }
        }
        return super.exec(pSkProcessForwardForBatchInBean);
    }
}

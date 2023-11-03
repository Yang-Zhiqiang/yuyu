package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardTokuninTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardToujituSeirituTorikesiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardYuukoukikanKeikaHanteiTest_exec;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;

/**
 * {@link BzGetProcessSummary}のモッククラスです。<br />
 */
public class BzGetProcessSummaryMockForSinkeiyaku1 extends BzGetProcessSummaryMockForSinkeiyaku {

    @Override
    public List<BzGetProcessSummaryOutBean> exec(BzGetProcessSummaryInBean pBzGetProcessSummaryInBean) {

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = new ArrayList<>();

        if (caller == SkProcessForwardTokuninTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == SkProcessForwardYuukoukikanKeikaHanteiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skinputkokuti");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skimu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1006");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubitouroku");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1007");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubikaisyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1008");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkeiyakukakunin");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1009");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktorikesi");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }

        if (caller == SkProcessForwardToujituSeirituTorikesiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skinputkokuti");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skimu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1006");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubitouroku");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1007");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubikaisyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1008");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkeiyakukakunin");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1009");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhenkin");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkInputKokuti");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkTenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkImu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2006");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkHubiTouroku");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2009");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkHenkin");
                }
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkInputKokuti");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkTenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkImu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3006");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkHubiTouroku");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3007");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkHubiKaisyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3008");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKeiyakukakunin");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3009");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkHenkin");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skinputkokuti");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skimu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4006");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubitouroku");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4007");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubikaisyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4008");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkeiyakukakunin");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4009");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhenkin");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }

        }

        return bzGetProcessSummaryOutBeanLst;
    }
}

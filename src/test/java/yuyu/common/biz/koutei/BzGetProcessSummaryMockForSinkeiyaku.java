package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHenkinNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHubiKaisyouTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHubiTourokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHurikomiNyuukinTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardImuSateiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKankyouSateiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKeiyakuKakuninIraiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKeiyakuKakuninKekkaTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKetteiHoryuuHubiBatchTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKetteiHoryuuHubiOnlineTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKokutisyoNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKyouseiHandTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMoschkExecTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomiTenkenTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomiTorikesiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomisyoNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardNyuukinNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardPaperlessMousikomiTest_kouteiSeni;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardSeirituHoryuuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardTeiseiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardTokuninTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardToujituSeirituTorikesiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardYuukoukikanKeikaHanteiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdateTest_changeKouteikanriMosNo;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdateTest_editProcessUpdateForBatchInfo;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdateTest_exec_1;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdateTest_exec_2;
import yuyu.common.sinkeiyaku.skcommon.EditCsvHubiMikaiTest_exec_2;
import yuyu.common.sinkeiyaku.skcommon.EditCsvHubiMikaiTest_exec_3;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkPreSyoruiTorikomiTest_sinkykSyoruiTorikomi;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link BzGetProcessSummary}のモッククラスです。<br />
 */
public class BzGetProcessSummaryMockForSinkeiyaku extends BzGetProcessSummary{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN12 = "12";

    public static final String TESTPATTERN13 = "13";

    public static final String TESTPATTERN14 = "14";

    public static final String TESTPATTERN15 = "15";

    public static final String TESTPATTERN16 = "16";

    public static final String TESTPATTERN17 = "17";

    public static final String TESTPATTERN18 = "18";

    public static final String TESTPATTERN19 = "19";

    public static final String TESTPATTERN20 = "20";

    public static final String TESTPATTERN21 = "21";

    public static final String TESTPATTERN22 = "22";

    public static final String TESTPATTERN23 = "23";

    public static final String TESTPATTERN24 = "24";

    public static final String TESTPATTERN25 = "25";

    public static final String TESTPATTERN26_1 = "26-1";

    public static final String TESTPATTERN26_2 = "26-2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public List<BzGetProcessSummaryOutBean> exec(BzGetProcessSummaryInBean pBzGetProcessSummaryInBean) {

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = new ArrayList<>();

        if (caller == SkProcessForwardImuSateiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5101");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5102");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skimu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5103");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5104");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubitouroku");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5105");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubikaisyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5106");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkeiyakukakunin");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5107");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktorikesi");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5112");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skinputkokuti");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5101");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5102");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skimu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5103");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5104");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubitouroku");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5101");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5102");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skimu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5108");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5103");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5104");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubitouroku");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5101");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5102");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skimu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5104");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubitouroku");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5101");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }

        if (caller == SkProcessForwardHenkinNyuuryokuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                bzGetProcessSummaryOutBean.setKouteiKanriId("1234");
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                if(!BizUtil.isBlank(pBzGetProcessSummaryInBean.getSyoNo())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);

                    bzGetProcessSummaryOutBean.setKouteiKanriId("12340009");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                bzGetProcessSummaryOutBean.setKouteiKanriId("12340010");
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == SkProcessForwardHubiKaisyouTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
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
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == SkProcessForwardHubiTourokuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1011");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubitouroku");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1012");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubikaisyou");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1011");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubitouroku");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }

        if (caller == SkProcessForwardHurikomiNyuukinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                bzGetProcessSummaryOutBean.setKouteiKanriId("kouteikanri1");
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("kouteikanri2");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("kouteikanri4");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkTenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("kouteikanri5");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("kouteikanri6");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkImu");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }

        if (caller == SkProcessForwardKyouseiHandTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }

        if (caller == SkProcessForwardMousikomisyoNyuuryokuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTMOS.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skinputmos");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skinputkokuti");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    if ("780123451".equals(pBzGetProcessSummaryInBean.getMosNo())) {
                        return bzGetProcessSummaryOutBeanLst;
                    }
                    else if ("780123469".equals(pBzGetProcessSummaryInBean.getMosNo())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("1005");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("sktorikesi");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                        return bzGetProcessSummaryOutBeanLst;
                    }
                    else if ("780123477".equals(pBzGetProcessSummaryInBean.getMosNo())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("1005");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("sktorikesi1");

                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean2.setKouteiKanriId("1005");
                        bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("sktorikesi2");

                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean3 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean3.setKouteiKanriId("1005");
                        bzGetProcessSummaryOutBean3.setJimuTetuzukiCd("sktorikesi3");

                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean3);

                        return bzGetProcessSummaryOutBeanLst;
                    }
                    else {
                        return bzGetProcessSummaryOutBeanLst;
                    }
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }

        if (caller == SkProcessForwardKokutisyoNyuuryokuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

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
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktenken");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skinputkokuti");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktenken");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skinputkokuti");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktenken");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skinputkokuti");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktenken");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skinputkokuti");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktenken");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }

        if (caller == SkProcessForwardKetteiHoryuuHubiOnlineTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                    bzGetProcessSummaryOutBean.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMISYOTORIKOMI);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkTenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkImu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkHubiTouroku");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                    bzGetProcessSummaryOutBean.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMISYONYUURYOKU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkTenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkImu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkHubiTouroku");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                    bzGetProcessSummaryOutBean.setNowNodoId(ISkCommonKoumoku.NODEID_SYORUINYUURYOKU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkTenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkImu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkHubiTouroku");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                    bzGetProcessSummaryOutBean.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkTenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkImu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkHubiTouroku");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                    bzGetProcessSummaryOutBean.setNowNodoId(ISkCommonKoumoku.NODEID_KETTEI);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkTenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkImu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setNowTantId("JUnit");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkHubiTouroku");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                return bzGetProcessSummaryOutBeanLst;
            }
        }

        if (caller == SkProcessForwardKeiyakuKakuninKekkaTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKeiyakukakunin");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
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
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKeiyakukakunin");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
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
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKeiyakukakunin");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
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
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKeiyakukakunin");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKeiyakukakunin");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == SkProcessForwardKankyouSateiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010005");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1006");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010006");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1007");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010007");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1008");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010008");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1008");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010008");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1008");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010008");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1008");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010008");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }

        }
        if (caller == SkProcessForwardKeiyakuKakuninIraiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setSeirituKbn(C_SeirituKbn.BLNK);
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2001");
                    bzGetProcessSummaryOutBean.setSeirituKbn(C_SeirituKbn.SEIRITU);
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd()) && pBzGetProcessSummaryInBean.getSyoNo() != null) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }

                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == SkProcessForwardMoschkExecTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                bzGetProcessSummaryOutBean.setKouteiKanriId("1234");
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                bzGetProcessSummaryOutBean1.setKouteiKanriId("5678");
                bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("SkMainDairiten");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                bzGetProcessSummaryOutBean2.setKouteiKanriId("5679");
                bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("SkMainDairiten");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                if (!BizUtil.isBlank(pBzGetProcessSummaryInBean.getSyoNo())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                if (!BizUtil.isBlank(pBzGetProcessSummaryInBean.getSyoNo())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("skmaindairiten");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean2.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("skmaindairiten");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                if (BizUtil.isBlank(pBzGetProcessSummaryInBean.getKouteiKanriId())) {
                    if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                        .getJimuTetuzukiCd())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("2001");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                        bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SATEI);
                        bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    }
                    else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                        .getJimuTetuzukiCd())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("2002");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                        bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SATEI);
                        bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    }
                    else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                        .getJimuTetuzukiCd())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("2003");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                        bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKAISI);
                        bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    }
                    else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                        .getJimuTetuzukiCd())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("2004");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                        bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKAISI);
                        bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    }
                    else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                        .getJimuTetuzukiCd())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("2005");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                        bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SATEI);
                        bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    }
                }
                else if ("2001".equals(pBzGetProcessSummaryInBean.getKouteiKanriId())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SATEI);
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if ("2002".equals(pBzGetProcessSummaryInBean.getKouteiKanriId())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SEIRITU);
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean2.setNowNodoId(ISkCommonKoumoku.NODEID_SATEI);
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                }
                else if ("2003".equals(pBzGetProcessSummaryInBean.getKouteiKanriId())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKAISI);
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }

                else if ("2004".equals(pBzGetProcessSummaryInBean.getKouteiKanriId())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKAISI);
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KETTEI);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean2.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean2.setNowNodoId(ISkCommonKoumoku.NODEID_SATEI);
                    bzGetProcessSummaryOutBean2.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean2.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean2.setNowNodoId(ISkCommonKoumoku.NODEID_SATEI);
                    bzGetProcessSummaryOutBean2.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KANKYOUSATEI_1JI);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean2.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean2.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKAISI);
                    bzGetProcessSummaryOutBean2.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_IMUSATEI_KANI_UW);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean2.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean2.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKAISI);
                    bzGetProcessSummaryOutBean2.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SKHUBINAIYOUKAKHASSIN);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean2.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean2.setNowNodoId(ISkCommonKoumoku.NODEID_SATEI);
                    bzGetProcessSummaryOutBean2.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SEIRITUHORYUUHUBI);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KANKYOUSATEI_1JI);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_IMUSATEI_KANI_UW);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SKHUBINAIYOUKAKHASSIN);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SATEI);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIA);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_IMUSATEI_KANI_MD);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SKHUBINAIYOUKAKHASSIN);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SEIRITU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIB);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN13.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KETTEI);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIA);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_IMUSATEI_KANI_MD);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SKHUBINAIYOUKAKHASSIN);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN14.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SEIRITUHORYUUHUBI);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIB);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN15.equals(SYORIPTN)) {
                if (BizUtil.isBlank(pBzGetProcessSummaryInBean.getKouteiKanriId())) {
                    if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                        .getJimuTetuzukiCd())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("2001");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                        bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SATEI);
                        bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    }
                    else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                        .getJimuTetuzukiCd())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("2002");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                        bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                        bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    }
                    else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                        .getJimuTetuzukiCd())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("2003");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                        bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                        bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    }
                    else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                        .getJimuTetuzukiCd())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("2004");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                        bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                        bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    }
                    else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                        .getJimuTetuzukiCd())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("2005");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                        bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                        bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    }
                }
                else if ("2005".equals(pBzGetProcessSummaryInBean.getKouteiKanriId())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN16.equals(SYORIPTN)) {
                if (BizUtil.isBlank(pBzGetProcessSummaryInBean.getKouteiKanriId())) {
                    if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                        .getJimuTetuzukiCd())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("2001");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                        bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SEIRITU);
                        bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    }
                    else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                        .getJimuTetuzukiCd())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("2002");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                        bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                        bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    }
                    else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                        .getJimuTetuzukiCd())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("2003");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                        bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                        bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    }
                    else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                        .getJimuTetuzukiCd())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("2004");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                        bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                        bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    }
                    else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                        .getJimuTetuzukiCd())) {
                        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                            .getInstance(BzGetProcessSummaryOutBean.class);
                        bzGetProcessSummaryOutBean1.setKouteiKanriId("2005");
                        bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                        bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                        bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                        bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                    }
                }
                else if ("2004".equals(pBzGetProcessSummaryInBean.getKouteiKanriId())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN17.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN18.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SYORUINYUURYOKU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN19.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KETTEI);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN20.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SEIRITUHORYUUHUBI);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN21.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SATEI);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN22.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_SEIRITU);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN23.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN24.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_2JI);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN25.equals(SYORIPTN)) {
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_HUBI);
                    bzGetProcessSummaryOutBean1.setNowTantId("担当者ID１０");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                    bzGetProcessSummaryOutBean1.setNowNodoId(ISkCommonKoumoku.NODEID_KOUTEIKANRYOU);
                    bzGetProcessSummaryOutBean1.setNowTantId("");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }
                return bzGetProcessSummaryOutBeanLst;
            }

        }
        if (caller == SkProcessForwardMousikomiTenkenTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skimu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubitouroku");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1006");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubikaisyou");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skimu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubitouroku");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == SkProcessForwardTeiseiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
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
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI);
                    bzGetProcessSummaryOutBean.setNowNodoId("state-kouteikanryou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
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
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI);
                    bzGetProcessSummaryOutBean.setNowNodoId("state-kouteikaisi");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
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
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI);
                    bzGetProcessSummaryOutBean.setNowNodoId("state-kouteikaisi");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("4005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }

        }
        if (caller == SkProcessForwardSeirituHoryuuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1234");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5678");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }

        }
        else if (caller == SkProcessForwardKetteiHoryuuHubiBatchTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("101");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("102");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkTenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("103");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("104");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkImu");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("101");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                    bzGetProcessSummaryOutBean.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMISYOTORIKOMI);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("102");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkTenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("103");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("104");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkImu");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("101");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                    bzGetProcessSummaryOutBean.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMISYONYUURYOKU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("102");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkTenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("103");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("104");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkImu");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("101");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                    bzGetProcessSummaryOutBean.setNowNodoId(ISkCommonKoumoku.NODEID_SYORUINYUURYOKU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("102");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkTenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("103");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("104");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkImu");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("101");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkMainDairiten");
                    bzGetProcessSummaryOutBean.setNowNodoId(ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("102");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkTenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("103");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkKankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("104");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("SkImu");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == SkProcessForwardPaperlessMousikomiTest_kouteiSeni.class) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                .getInstance(BzGetProcessSummaryOutBean.class);
            if (TESTPATTERN1.equals(SYORIPTN)) {

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTMOS
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTMOS);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1006");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1007");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                }
            }

            bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

            return bzGetProcessSummaryOutBeanLst;
        }
        if (caller == SkProcessForwardMousikomiTorikesiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI);
                }
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1006");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1007");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1008");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1009");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN);
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI);
                }
                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1006");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1007");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == SkProcessForwardNyuukinNyuuryokuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1234");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == SkProcessForwardTokuninTest_exec.class) {
            BzGetProcessSummaryMockForSinkeiyaku1 bzSakuinTsnSyoukaiMqMockForSinkeiyaku1 = SWAKInjector
                .getInstance(BzGetProcessSummaryMockForSinkeiyaku1.class);
            bzGetProcessSummaryOutBeanLst = bzSakuinTsnSyoukaiMqMockForSinkeiyaku1.exec(pBzGetProcessSummaryInBean);
            return bzGetProcessSummaryOutBeanLst;
        }
        if (caller == SkProcessForwardYuukoukikanKeikaHanteiTest_exec.class) {
            BzGetProcessSummaryMockForSinkeiyaku1 bzSakuinTsnSyoukaiMqMockForSinkeiyaku1 = SWAKInjector
                .getInstance(BzGetProcessSummaryMockForSinkeiyaku1.class);
            bzGetProcessSummaryOutBeanLst = bzSakuinTsnSyoukaiMqMockForSinkeiyaku1.exec(pBzGetProcessSummaryInBean);
            return bzGetProcessSummaryOutBeanLst;
        }
        if (caller == SkProcessForwardToujituSeirituTorikesiTest_exec.class) {
            BzGetProcessSummaryMockForSinkeiyaku1 bzSakuinTsnSyoukaiMqMockForSinkeiyaku1 = SWAKInjector
                .getInstance(BzGetProcessSummaryMockForSinkeiyaku1.class);
            bzGetProcessSummaryOutBeanLst = bzSakuinTsnSyoukaiMqMockForSinkeiyaku1.exec(pBzGetProcessSummaryInBean);
            return bzGetProcessSummaryOutBeanLst;
        }
        if (caller == SkProcessUpdateTest_exec_1.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5301");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5302");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);
                }
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == SkProcessUpdateTest_exec_2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5302");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);
                }
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }

        }
        if (caller == SkProcessUpdateTest_editProcessUpdateForBatchInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5201");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5301");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5302");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);
                }
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == SkProcessUpdateTest_changeKouteikanriMosNo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                bzGetProcessSummaryOutBean.setKouteiKanriId("5301");
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == SkPreSyoruiTorikomiTest_sinkykSyoruiTorikomi.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                super.exec(pBzGetProcessSummaryInBean);

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryOutBean.setKouteiKanriId("");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        else if (caller == EditCsvHubiMikaiTest_exec_2.class) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                .getInstance(BzGetProcessSummaryOutBean.class);
            bzGetProcessSummaryOutBean.setJimuStartYmd(BizDate.valueOf("20160420"));
            bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            return bzGetProcessSummaryOutBeanLst;
        }
        else if (caller == EditCsvHubiMikaiTest_exec_3.class) {
            super.exec(pBzGetProcessSummaryInBean);

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                .getInstance(BzGetProcessSummaryOutBean.class);
            bzGetProcessSummaryOutBean.setJimuStartYmd(BizDate.valueOf("20160420"));
            bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            return bzGetProcessSummaryOutBeanLst;
        }
        if (caller == SkProcessCreateTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)){
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector.getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setSyoNo("11807111118");
                bzGetProcessSummaryOutBean.setMosNo("791112238");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector.getInstance(BzGetProcessSummaryOutBean.class);
                super.exec(pBzGetProcessSummaryInBean);
                bzGetProcessSummaryOutBean.setSyoNo("11807111118");
                bzGetProcessSummaryOutBean.setMosNo("791112238");
                bzGetProcessSummaryOutBean.setKouteiKanriId("10010");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
                bzGetProcessSummaryOutBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
                bzGetProcessSummaryOutBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAINDEXNK_SISUU);
                bzGetProcessSummaryOutBean.setDairitencd1("5200015");
                bzGetProcessSummaryOutBean.setDairitencd2(null);
                bzGetProcessSummaryOutBean.setJimuyoucd("");
                bzGetProcessSummaryOutBean.setJmycdMisetteiKbn(C_UmuKbn.ARI);
                bzGetProcessSummaryOutBean.setDoujimosumu(C_UmuKbn.NONE);
                bzGetProcessSummaryOutBean.setMosymd(BizDate.valueOf("20181109"));
                bzGetProcessSummaryOutBean.setJimuStartYmdTime("20190109110739195");
                bzGetProcessSummaryOutBean.setSyoNo("19806000015");
                bzGetProcessSummaryOutBean.setMosNo("860000041");
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                bzGetProcessSummaryOutBean.setKetteiKbn(C_KetteiKbn.NONE);
                bzGetProcessSummaryOutBean.setSeirituKbn(C_SeirituKbn.NONE);
                bzGetProcessSummaryOutBean.setLincjkKbn(C_LincjkKbn.MIHANTEI);

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
                bzGetProcessSummaryOutBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
                bzGetProcessSummaryOutBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAINDEXNK_SISUU);
                bzGetProcessSummaryOutBean.setDairitencd1("5200015");
                bzGetProcessSummaryOutBean.setDairitencd2(null);
                bzGetProcessSummaryOutBean.setJimuyoucd("");
                bzGetProcessSummaryOutBean.setJmycdMisetteiKbn(C_UmuKbn.ARI);
                bzGetProcessSummaryOutBean.setDoujimosumu(C_UmuKbn.NONE);
                bzGetProcessSummaryOutBean.setMosymd(BizDate.valueOf("20181109"));
                bzGetProcessSummaryOutBean.setJimuStartYmdTime("20190109110739195");
                bzGetProcessSummaryOutBean.setSyoNo("19806000015");
                bzGetProcessSummaryOutBean.setMosNo("860000041");
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                bzGetProcessSummaryOutBean.setKetteiKbn(C_KetteiKbn.NONE);
                bzGetProcessSummaryOutBean.setSeirituKbn(C_SeirituKbn.NONE);
                bzGetProcessSummaryOutBean.setLincjkKbn(C_LincjkKbn.MIHANTEI);
                bzGetProcessSummaryOutBean.setNowNodoId("1");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN26_1.equals(SYORIPTN)) {
                SYORIPTN = TESTPATTERN26_2;

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
                bzGetProcessSummaryOutBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
                bzGetProcessSummaryOutBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAINDEXNK_SISUU);
                bzGetProcessSummaryOutBean.setDairitencd1("5200015");
                bzGetProcessSummaryOutBean.setDairitencd2(null);
                bzGetProcessSummaryOutBean.setJimuyoucd(null);
                bzGetProcessSummaryOutBean.setJmycdMisetteiKbn(C_UmuKbn.ARI);
                bzGetProcessSummaryOutBean.setDoujimosumu(C_UmuKbn.NONE);
                bzGetProcessSummaryOutBean.setMosymd(BizDate.valueOf("20181109"));
                bzGetProcessSummaryOutBean.setJimuStartYmdTime("20190109110739195");
                bzGetProcessSummaryOutBean.setSyoNo("19806000015");
                bzGetProcessSummaryOutBean.setMosNo("860000041");
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                bzGetProcessSummaryOutBean.setKetteiKbn(C_KetteiKbn.NONE);
                bzGetProcessSummaryOutBean.setSeirituKbn(C_SeirituKbn.NONE);
                bzGetProcessSummaryOutBean.setLincjkKbn(C_LincjkKbn.MIHANTEI);

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN26_2.equals(SYORIPTN)) {
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        return super.exec(pBzGetProcessSummaryInBean);
    }
}

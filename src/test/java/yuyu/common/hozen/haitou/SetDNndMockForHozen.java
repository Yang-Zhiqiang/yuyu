package yuyu.common.hozen.haitou;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * {@link SetDNnd}のモッククラスです。<br />
 */
public class SetDNndMockForHozen extends SetDNnd {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public DRateBean exec(
        BizDate pKykymd,
        BizDate pYendthnkymd,
        IT_KhHaitouKanri tyokuzenHaitouKanri,
        BizDate pCalckijyunymd) {

        DRateBean dRateBean = new DRateBean();
        List<HaitouKaisuuBean> haitouKaisuuBeanLst = new ArrayList<HaitouKaisuuBean>();

        if (KeisanDGanrikinTest_exec2.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBeanbefore = new HaitouKaisuuBean();
                haitouKaisuuBeanbefore.setKikanfrom(BizDate.valueOf(20180607));
                haitouKaisuuBeanbefore.setKikanto(BizDate.valueOf(20180807));
                haitouKaisuuBeanbefore.setHaitoukaisuu(0);

                haitouKaisuuBeanLst.add(haitouKaisuuBeanbefore);
                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);
                return dRateBean;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                HaitouKaisuuBean haitouKaisuuBeanbefore = new HaitouKaisuuBean();
                haitouKaisuuBeanbefore.setKikanfrom(BizDate.valueOf(20180607));
                haitouKaisuuBeanbefore.setKikanto(BizDate.valueOf(20180707));
                haitouKaisuuBeanbefore.setHaitoukaisuu(0);

                HaitouKaisuuBean haitouKaisuuBeanafter = new HaitouKaisuuBean();
                haitouKaisuuBeanafter.setKikanfrom(BizDate.valueOf(20180807));
                haitouKaisuuBeanafter.setKikanto(BizDate.valueOf(20180907));
                haitouKaisuuBeanafter.setHaitoukaisuu(0);

                haitouKaisuuBeanLst.add(haitouKaisuuBeanbefore);
                haitouKaisuuBeanLst.add(haitouKaisuuBeanafter);
                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);
                return dRateBean;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                dRateBean = null;
                return dRateBean;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);
                return dRateBean;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                HaitouKaisuuBean haitouKaisuuBeanbefore = new HaitouKaisuuBean();
                haitouKaisuuBeanbefore.setKikanfrom(BizDate.valueOf(20181101));
                haitouKaisuuBeanbefore.setKikanto(BizDate.valueOf(20181112));
                haitouKaisuuBeanbefore.setHaitoukaisuu(0);

                HaitouKaisuuBean haitouKaisuuBeanafter = new HaitouKaisuuBean();
                haitouKaisuuBeanafter.setKikanfrom(BizDate.valueOf(20180807));
                haitouKaisuuBeanafter.setKikanto(BizDate.valueOf(20181121));
                haitouKaisuuBeanafter.setHaitoukaisuu(0);

                haitouKaisuuBeanLst.add(haitouKaisuuBeanbefore);
                haitouKaisuuBeanLst.add(haitouKaisuuBeanafter);
                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);
                return dRateBean;
            }
        }

        return super.exec(pKykymd, pYendthnkymd, tyokuzenHaitouKanri, pCalckijyunymd);
    }


    @Override
    public DRateBean exec(
        BizDate pKykymd,
        BizDate pYendthnkymd,
        IT_KhTumitateDKanri tyokuzenTumitateDKanri,
        BizDate pCalckijyunymd) {

        DRateBean dRateBean = new DRateBean();
        List<HaitouKaisuuBean> haitouKaisuuBeanLst = new ArrayList<HaitouKaisuuBean>();

        if (KeisanDGanrikinTest_exec3.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBeanbefore = new HaitouKaisuuBean();
                haitouKaisuuBeanbefore.setKikanfrom(BizDate.valueOf(20170512));
                haitouKaisuuBeanbefore.setKikanto(BizDate.valueOf(20180907));
                haitouKaisuuBeanbefore.setHaitoukaisuu(0);

                haitouKaisuuBeanLst.add(haitouKaisuuBeanbefore);
                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);
                return dRateBean;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                HaitouKaisuuBean haitouKaisuuBeanbefore = new HaitouKaisuuBean();
                haitouKaisuuBeanbefore.setKikanfrom(BizDate.valueOf(20170512));
                haitouKaisuuBeanbefore.setKikanto(BizDate.valueOf(20181112));
                haitouKaisuuBeanbefore.setHaitoukaisuu(0);

                HaitouKaisuuBean haitouKaisuuBeanafter = new HaitouKaisuuBean();
                haitouKaisuuBeanafter.setKikanfrom(BizDate.valueOf(20180807));
                haitouKaisuuBeanafter.setKikanto(BizDate.valueOf(20180907));
                haitouKaisuuBeanafter.setHaitoukaisuu(0);

                haitouKaisuuBeanLst.add(haitouKaisuuBeanbefore);
                haitouKaisuuBeanLst.add(haitouKaisuuBeanafter);
                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);
                return dRateBean;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                dRateBean = null;
                return dRateBean;
            }

            if (TESTPATTERN4.equals(SYORIPTN)) {
                HaitouKaisuuBean haitouKaisuuBeanbefore = new HaitouKaisuuBean();
                haitouKaisuuBeanbefore.setKikanfrom(BizDate.valueOf(20181101));
                haitouKaisuuBeanbefore.setKikanto(BizDate.valueOf(20181112));
                haitouKaisuuBeanbefore.setHaitoukaisuu(0);

                HaitouKaisuuBean haitouKaisuuBeanafter = new HaitouKaisuuBean();
                haitouKaisuuBeanafter.setKikanfrom(BizDate.valueOf(20180807));
                haitouKaisuuBeanafter.setKikanto(BizDate.valueOf(20181121));
                haitouKaisuuBeanafter.setHaitoukaisuu(0);

                haitouKaisuuBeanLst.add(haitouKaisuuBeanbefore);
                haitouKaisuuBeanLst.add(haitouKaisuuBeanafter);
                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);
                return dRateBean;
            }
        }

        return super.exec(pKykymd, pYendthnkymd, tyokuzenTumitateDKanri, pCalckijyunymd);
    }

    @Override
    public DRateBean exec(
        BizDate pKykymd,
        BizDate pYendthnkymd,
        String pSyono,
        BizDate pCalckijyunymd) {

        DRateBean dRateBean = new DRateBean();
        List<HaitouKaisuuBean> haitouKaisuuBeanLst = new ArrayList<HaitouKaisuuBean>();

        if (KeisanDCommonTest_calcD.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                return dRateBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                return dRateBean;
            }
        }

        if (KeisanDCommonTest_calcKariwariateDGanrikin.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                return dRateBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                return dRateBean;
            }
        }

        if (KeisanDCommonTest_calcTumitateDGanrikin.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                return dRateBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                return dRateBean;
            }
        }

        if (KeisanDCommonDShrTest_calcDShrgkAllhikidasi.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                return dRateBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                return dRateBean;
            }
        }

        if (KeisanDCommonDShrTest_calcDShrgkItibuhikidasi.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                return dRateBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                return dRateBean;
            }
        }

        if (KeisanDCommonGengakuTest_calcDShrgk.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                return dRateBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                return dRateBean;
            }
        }

        if (KeisanDCommonKaiyakuTest_calcDShrgk.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                return dRateBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                if (KeisanDCommonKaiyakuTest_calcDShrgk.kaisuu == 0) {

                    HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                    haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                    haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                    HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                    haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                    haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                    haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                    haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                    dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                    KeisanDCommonKaiyakuTest_calcDShrgk.kaisuu++;
                    return dRateBean;
                }
                return null;
            }
        }

        if (KeisanDCommonSibouTest_calcDShrgk.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                return dRateBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                if (KeisanDCommonSibouTest_calcDShrgk.kaisuu == 0) {

                    HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                    haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                    haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                    HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                    haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                    haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                    haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                    haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                    dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                    KeisanDCommonSibouTest_calcDShrgk.kaisuu++;
                    return dRateBean;
                }
                return null;
            }
        }

        if (KeisanDCommonYendtHnk_calcDkngk.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                return dRateBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                if (KeisanDCommonYendtHnk_calcDkngk.kaisuu == 0) {

                    HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                    haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                    haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                    HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                    haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                    haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                    haitouKaisuuBeanLst.add(haitouKaisuuBean1);
                    haitouKaisuuBeanLst.add(haitouKaisuuBean2);

                    dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

                    KeisanDCommonYendtHnk_calcDkngk.kaisuu++;
                    return dRateBean;
                }
                return null;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return null;
            }
        }

        return super.exec(pKykymd, pYendthnkymd, pSyono, pCalckijyunymd);
    }

    @Override
    public DRateBean exec(
        IT_KykKihon pKykKihon,
        IT_KykSyouhn pKykSyouhn,
        BizDate pDretokijyunymd,
        BizDate pCalckijyunymd,
        BizDate pSyoriYmd,
        C_UmuKbn pKessanumu) {

        DRateBean dRateBean = new DRateBean();
        DRateSyutokuInfoBean dRateSyutokuInfoBean = new DRateSyutokuInfoBean();
        HaitouKaisuuBean haitouKaisuuBean = new HaitouKaisuuBean();
        List<HaitouKaisuuBean> haitouKaisuuBeanLst = new ArrayList<HaitouKaisuuBean>();

        dRateBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);
        dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

        if (KeisanDCommonTest_calcD.class == caller) {

            dRateSyutokuInfoBean.setSyouhncd("M111");
            haitouKaisuuBean.setKikanfrom(BizDate.valueOf(20020203));
            haitouKaisuuBeanLst.add(haitouKaisuuBean);

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return dRateBean;
            }
        }

        if (KeisanDCommonTest_calcKariwariateDGanrikin.class == caller) {

            dRateSyutokuInfoBean.setSyouhncd("M111");
            haitouKaisuuBean.setKikanfrom(BizDate.valueOf(20020203));
            haitouKaisuuBeanLst.add(haitouKaisuuBean);

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return dRateBean;
            }
        }

        if (KeisanDCommonTest_calcTumitateDGanrikin.class == caller) {

            dRateSyutokuInfoBean.setSyouhncd("M111");
            haitouKaisuuBean.setKikanfrom(BizDate.valueOf(20020203));
            haitouKaisuuBeanLst.add(haitouKaisuuBean);

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return dRateBean;
            }
        }

        if (KeisanDCommonYendtHnk_calcDkngk.class == caller) {

            dRateSyutokuInfoBean.setSyouhncd("M111");
            haitouKaisuuBean.setKikanfrom(BizDate.valueOf(20020203));
            haitouKaisuuBeanLst.add(haitouKaisuuBean);

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                dRateBean.getDRateSyutokuInfoBean().setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return dRateBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                dRateBean.getDRateSyutokuInfoBean().setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return dRateBean;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return dRateBean;
            }
        }

        return super.exec(pKykKihon, pKykSyouhn, pDretokijyunymd, pCalckijyunymd, pSyoriYmd, pKessanumu);
    }

    @Override
    public List<DRateBean> execCorrespoindingOverAYear(
        BizDate pKykymd,
        String pSyono,
        BizDate pCalckijyunymd,
        BizDate pTyouseizCalckijyunymd) {

        List<DRateBean> dRateBeanLst = new ArrayList<>();

        DRateBean dRateBean = new DRateBean();
        DRateSyutokuInfoBean dRateSyutokuInfoBean = new DRateSyutokuInfoBean();
        if (KeisanDCommonTest_calcKariwariateDGanrikin.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return dRateBeanLst;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                dRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
                dRateBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);

                dRateBeanLst.add(dRateBean);

                return dRateBeanLst;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                dRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
                dRateBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);

                dRateBeanLst.add(dRateBean);

                return dRateBeanLst;
            }

        }

        if (KeisanDCommonTest_calcTumitateDGanrikin.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return dRateBeanLst;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                dRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
                dRateBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);

                dRateBeanLst.add(dRateBean);

                return dRateBeanLst;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                dRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
                dRateBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);

                dRateBeanLst.add(dRateBean);

                return dRateBeanLst;
            }

        }

        if (KeisanDCommonDShrTest_calcDShrgkAllhikidasi.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return dRateBeanLst;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                dRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
                dRateBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);

                dRateBeanLst.add(dRateBean);

                return dRateBeanLst;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                dRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
                dRateBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);

                dRateBeanLst.add(dRateBean);

                return dRateBeanLst;
            }

        }

        if (KeisanDCommonDShrTest_calcDShrgkItibuhikidasi.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return dRateBeanLst;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                dRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
                dRateBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);

                dRateBeanLst.add(dRateBean);

                return dRateBeanLst;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                dRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
                dRateBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);

                dRateBeanLst.add(dRateBean);

                return dRateBeanLst;
            }

        }

        if (KeisanDCommonGengakuTest_calcDShrgk.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return dRateBeanLst;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                dRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
                dRateBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);

                dRateBeanLst.add(dRateBean);

                return dRateBeanLst;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                dRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
                dRateBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);

                dRateBeanLst.add(dRateBean);

                return dRateBeanLst;
            }

        }

        if (KeisanDCommonKaiyakuTest_calcDShrgk.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return dRateBeanLst;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                dRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
                dRateBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);

                dRateBeanLst.add(dRateBean);

                return dRateBeanLst;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                if (KeisanDCommonKaiyakuTest_calcDShrgk.kaisuu == 0) {

                    dRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
                    dRateBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);

                    dRateBeanLst.add(dRateBean);
                    KeisanDCommonKaiyakuTest_calcDShrgk.kaisuu++;
                    return dRateBeanLst;

                }

                return dRateBeanLst;
            }
        }

        return super.execCorrespoindingOverAYear(pKykymd, pSyono, pCalckijyunymd, pTyouseizCalckijyunymd);
    }

}

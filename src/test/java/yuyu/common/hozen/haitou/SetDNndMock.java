package yuyu.common.hozen.haitou;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * {@link SetDNnd}のモッククラスです。<br />
 */
public class SetDNndMock extends SetDNnd {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;


    public DRateBean exec(
        BizDate pKykymd,
        BizDate pYendthnkymd,
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

                dRateBean =null;
                return dRateBean;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);
                return dRateBean;
            }
        }else if (KeisanDGanrikinTest_exec3.class == caller) {
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

                dRateBean =null;
                return dRateBean;
            }
        }
        if (KeisanDCommonTest_calcKariwariateDGanrikin.class == caller ||
            KeisanDCommonTest_calcTumitateDGanrikin.class == caller ||
            KeisanDCommonGengakuTest_calcDShrgk.class == caller ||
            KeisanDCommonDShrTest_calcDShrgkAllhikidasi.class == caller ||
            KeisanDCommonDShrTest_calcDShrgkItibuhikidasi.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<HaitouKaisuuBean>();
                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanList.add(haitouKaisuuBean1);
                haitouKaisuuBeanList.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanList);

                return dRateBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<HaitouKaisuuBean>();
                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanList.add(haitouKaisuuBean1);
                haitouKaisuuBeanList.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanList);

                return dRateBean;
            }
        } else if (KeisanDCommonKaiyakuTest_calcDShrgk.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<HaitouKaisuuBean>();
                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanList.add(haitouKaisuuBean1);
                haitouKaisuuBeanList.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanList);

                return dRateBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (KeisanDCommonKaiyakuTest_calcDShrgk.kaisuu == 0) {
                    List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<HaitouKaisuuBean>();
                    HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                    haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                    haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                    HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                    haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                    haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                    haitouKaisuuBeanList.add(haitouKaisuuBean1);
                    haitouKaisuuBeanList.add(haitouKaisuuBean2);

                    dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanList);

                    KeisanDCommonKaiyakuTest_calcDShrgk.kaisuu++;
                    return dRateBean;
                }
                return null;
            }
        } else if (KeisanDCommonSibouTest_calcDShrgk.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<HaitouKaisuuBean>();
                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanList.add(haitouKaisuuBean1);
                haitouKaisuuBeanList.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanList);

                return dRateBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (KeisanDCommonSibouTest_calcDShrgk.kaisuu == 0) {
                    List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<HaitouKaisuuBean>();
                    HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                    haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                    haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                    HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                    haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                    haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                    haitouKaisuuBeanList.add(haitouKaisuuBean1);
                    haitouKaisuuBeanList.add(haitouKaisuuBean2);

                    dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanList);

                    KeisanDCommonSibouTest_calcDShrgk.kaisuu++;
                    return dRateBean;
                }
                return null;
            }
        } else if (KeisanDCommonYendtHnk_calcDkngk.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<HaitouKaisuuBean>();
                HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                haitouKaisuuBeanList.add(haitouKaisuuBean1);
                haitouKaisuuBeanList.add(haitouKaisuuBean2);

                dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanList);

                return dRateBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (KeisanDCommonYendtHnk_calcDkngk.kaisuu == 0) {
                    List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<HaitouKaisuuBean>();
                    HaitouKaisuuBean haitouKaisuuBean1 = new HaitouKaisuuBean();
                    haitouKaisuuBean1.setKikanfrom(BizDate.valueOf(20020203));
                    haitouKaisuuBean1.setKikanto(BizDate.valueOf(20020205));
                    HaitouKaisuuBean haitouKaisuuBean2 = new HaitouKaisuuBean();
                    haitouKaisuuBean2.setKikanfrom(BizDate.valueOf(20020303));
                    haitouKaisuuBean2.setKikanto(BizDate.valueOf(20020305));
                    haitouKaisuuBeanList.add(haitouKaisuuBean1);
                    haitouKaisuuBeanList.add(haitouKaisuuBean2);

                    dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanList);

                    KeisanDCommonYendtHnk_calcDkngk.kaisuu++;
                    return dRateBean;
                }
                return null;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return null;
            }
        }

        return null;
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
        dRateSyutokuInfoBean.setSyouhncd("M111");
        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<HaitouKaisuuBean>();
        HaitouKaisuuBean haitouKaisuuBean = new HaitouKaisuuBean();
        haitouKaisuuBean.setKikanfrom(BizDate.valueOf(20020203));
        haitouKaisuuBeanList.add(haitouKaisuuBean);

        dRateBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);
        dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanList);

        if (KeisanDCommonTest_calcD.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return dRateBean;
            }
        } else if (KeisanDCommonYendtHnk_calcDkngk.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                dRateBean.getDRateSyutokuInfoBean().setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return dRateBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                dRateBean.getDRateSyutokuInfoBean().setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return dRateBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return dRateBean;
            }
        }
        return super.exec(pKykKihon, pKykSyouhn, pDretokijyunymd, pCalckijyunymd, pSyoriYmd, pKessanumu);
    }
}

package yuyu.common.biz.bzcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.koutei.BzIwfUtilConstants;
import yuyu.common.siharai.chksk.CheckSbSkNaiyouTest_exec;
import yuyu.common.siharai.chksk.ChkSubSkSyoruiTest_exec;
import yuyu.common.siharai.koutei.SiGetSyoruittykymdTest_exec;
import yuyu.common.siharai.sicommon.SaigaiGaitouHanteiTest_chkKyuusyorui;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateTest_exec;
import yuyu.common.sinkeiyaku.moschk.HandSateiKetteiHanteiTest_exec;
import yuyu.common.sinkeiyaku.moschk.HanteiHituyouSyoruiTest_exec;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * {@link BzGetImageProps}のモッククラスです。<br />
 */
public class BzGetImagePropsMock extends BzGetImageProps {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    @Override
    public BzGetImagePropsOutBean exec(BzGetImagePropsInBean pBzGetImagePropsInBean) {

        BzGetImagePropsOutBean outBean = SWAKInjector.getInstance(BzGetImagePropsOutBean.class);

        if (caller == ChkSubSkSyoruiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                List<BzGetImagePropsBean> bzGetImagePropsBeanLst = new ArrayList<>();
                BzGetImagePropsBean bzGetImagePropsBean = new BzGetImagePropsBean();
                bzGetImagePropsBeanLst.add(bzGetImagePropsBean);
                outBean.setBzGetImagePropsBeanLst(bzGetImagePropsBeanLst);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                List<BzGetImagePropsBean> bzGetImagePropsBeanLst = new ArrayList<>();
                outBean.setBzGetImagePropsBeanLst(bzGetImagePropsBeanLst);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                outBean.setBzGetImagePropsBeanLst(null);
            }
            return outBean;

        }

        if (caller == SiGetSyoruittykymdTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            super.exec(pBzGetImagePropsInBean);
            outBean.setKekkaStatus("0");
            outBean.setSyousaiMsgCd("IWF0000");

            return outBean;
        }
        if (caller == SiGetSyoruittykymdTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            super.exec(pBzGetImagePropsInBean);
            outBean.setKekkaStatus("0");
            outBean.setSyousaiMsgCd("IWF0000");
            List<BzGetImagePropsBean> list = new ArrayList<>();
            BzGetImagePropsBean bean = new BzGetImagePropsBean();
            bean.setSyoruiTtykYmdTime("20150716010203004");
            list.add(bean);
            outBean.setBzGetImagePropsBeanLst(list);
            return outBean;

        }
        if (caller == SiGetSyoruittykymdTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            super.exec(pBzGetImagePropsInBean);
            outBean.setKekkaStatus("0");
            outBean.setSyousaiMsgCd("IWF0000");
            List<BzGetImagePropsBean> list = new ArrayList<>();
            BzGetImagePropsBean bean = new BzGetImagePropsBean();
            bean.setSyoruiTtykYmdTime("20150716010203001");
            list.add(bean);
            bean = new BzGetImagePropsBean();
            bean.setSyoruiTtykYmdTime("20150716010203001");
            list.add(bean);
            bean = new BzGetImagePropsBean();
            bean.setSyoruiTtykYmdTime("20150717010203001");
            list.add(bean);
            bean = new BzGetImagePropsBean();
            bean.setSyoruiTtykYmdTime("20150715010203001");
            list.add(bean);
            outBean.setBzGetImagePropsBeanLst(list);
            return outBean;

        }
        if (caller == SiGetSyoruittykymdTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            super.exec(pBzGetImagePropsInBean);
            outBean.setKekkaStatus("9");
            outBean.setSyousaiMsgCd("IWF0002");
            return outBean;

        }
        if (caller == CheckSbSkNaiyouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            outBean.setKekkaStatus("0");
            outBean.setSyousaiMsgCd("IWF0000");
            List<BzGetImagePropsBean> list = new ArrayList<>();
            BzGetImagePropsBean bean = new BzGetImagePropsBean();
            bean.setSyoruiTtykYmdTime("20160321180203001");
            list.add(bean);
            outBean.setBzGetImagePropsBeanLst(list);
            return outBean;
        }
        if (caller == HandSateiKetteiHanteiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            outBean.setKekkaStatus("0");
            outBean.setSyousaiMsgCd("IWF0000");
            List<BzGetImagePropsBean> list = new ArrayList<>();
            BzGetImagePropsBean bean = new BzGetImagePropsBean();
            bean.setSyoruiTtykYmdTime("20171018");
            bean.setSyoruiCd(C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI);
            list.add(bean);
            bean = new BzGetImagePropsBean();
            bean.setSyoruiTtykYmdTime("20171018");
            bean.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
            list.add(bean);
            bean = new BzGetImagePropsBean();
            bean.setSyoruiTtykYmdTime("20171018");
            bean.setSyoruiCd(C_SyoruiCdKbn.WF_QRSEAL);
            list.add(bean);
            bean = new BzGetImagePropsBean();
            bean.setSyoruiTtykYmdTime("20171018");
            bean.setSyoruiCd(C_SyoruiCdKbn.USERITIRANHYOU);
            list.add(bean);
            outBean.setBzGetImagePropsBeanLst(list);
            return outBean;
        }
        if (caller == HandSateiKetteiHanteiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            outBean.setKekkaStatus("1");
            outBean.setSyousaiMsgCd("IWF0000");
            List<BzGetImagePropsBean> list = new ArrayList<>();
            BzGetImagePropsBean bean = new BzGetImagePropsBean();
            bean.setSyoruiTtykYmdTime("20171018");
            bean.setSyoruiCd(C_SyoruiCdKbn.KK_ADRHNK_SKS);
            list.add(bean);
            outBean.setBzGetImagePropsBeanLst(list);
            return outBean;
        }
        if (caller == HandSateiKetteiHanteiTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            outBean.setKekkaStatus("0");
            outBean.setSyousaiMsgCd("IWF0000");
            List<BzGetImagePropsBean> list = new ArrayList<>();
            BzGetImagePropsBean bean = new BzGetImagePropsBean();
            bean.setSyoruiTtykYmdTime("20171018");
            bean.setSyoruiCd(C_SyoruiCdKbn.SK_DAISANSYAUKTHOUSYO);
            list.add(bean);
            bean = new BzGetImagePropsBean();
            bean.setSyoruiTtykYmdTime("20171018");
            bean.setSyoruiCd(C_SyoruiCdKbn.SK_FATCAKAKUNINSYO);
            list.add(bean);
            outBean.setBzGetImagePropsBeanLst(list);
            return outBean;
        }
        if (caller == HandSateiKetteiHanteiTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            outBean.setKekkaStatus("0");
            outBean.setSyousaiMsgCd("IWF0000");
            List<BzGetImagePropsBean> list = new ArrayList<>();
            BzGetImagePropsBean bean = new BzGetImagePropsBean();
            bean.setSyoruiTtykYmdTime("20171018");
            bean.setSyoruiCd(C_SyoruiCdKbn.SK_AEOISINKITODOKEDESYO);
            list.add(bean);
            outBean.setBzGetImagePropsBeanLst(list);
            return outBean;
        }
        if (caller == SaigaiGaitouHanteiTest_chkKyuusyorui.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                outBean.setBzGetImagePropsBeanLst(null);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                List<BzGetImagePropsBean> bzGetImagePropsBeanLst = new ArrayList<>();
                outBean.setBzGetImagePropsBeanLst(bzGetImagePropsBeanLst);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                List<BzGetImagePropsBean> bzGetImagePropsBeanLst = new ArrayList<>();
                BzGetImagePropsBean bzGetImagePropsBean = new BzGetImagePropsBean();
                bzGetImagePropsBeanLst.add(bzGetImagePropsBean);
                outBean.setBzGetImagePropsBeanLst(bzGetImagePropsBeanLst);
            }
            return outBean;
        }

        if (caller == HanteiHituyouSyoruiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                outBean.setKekkaStatus("9");
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                outBean.setKekkaStatus("0");

                List<BzGetImagePropsBean> bzGetImagePropsBeanLst = new ArrayList<>();
                outBean.setBzGetImagePropsBeanLst(bzGetImagePropsBeanLst);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                outBean.setKekkaStatus("0");

                List<BzGetImagePropsBean> bzGetImagePropsBeanLst = new ArrayList<>();

                BzGetImagePropsBean BzGetImagePropsBean = new BzGetImagePropsBean();
                BzGetImagePropsBean.setSyoruiCd(C_SyoruiCdKbn.SK_MOSSYO);

                bzGetImagePropsBeanLst.add(BzGetImagePropsBean);

                outBean.setBzGetImagePropsBeanLst(bzGetImagePropsBeanLst);
            }

            else if (TESTPATTERN4.equals(SYORIPTN)) {
                outBean.setKekkaStatus("0");

                List<BzGetImagePropsBean> bzGetImagePropsBeanLst = new ArrayList<>();

                BzGetImagePropsBean BzGetImagePropsBean = new BzGetImagePropsBean();
                BzGetImagePropsBean.setSyoruiCd(C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO);

                bzGetImagePropsBeanLst.add(BzGetImagePropsBean);

                BzGetImagePropsBean = new BzGetImagePropsBean();
                BzGetImagePropsBean.setSyoruiCd(C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI);

                bzGetImagePropsBeanLst.add(BzGetImagePropsBean);

                BzGetImagePropsBean = new BzGetImagePropsBean();
                BzGetImagePropsBean.setSyoruiCd(C_SyoruiCdKbn.SK_DAISANSYAUKTHOUSYO);

                bzGetImagePropsBeanLst.add(BzGetImagePropsBean);

                outBean.setBzGetImagePropsBeanLst(bzGetImagePropsBeanLst);
            }

            return outBean;
        }

        if (caller == SkProcessCreateTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                outBean.setKekkaStatus(BzIwfUtilConstants.API_RESULTCD_OK);

                List<BzGetImagePropsBean> bzGetImagePropsBeanLst = new ArrayList<>();
                BzGetImagePropsBean BzGetImagePropsBean = new BzGetImagePropsBean();
                BzGetImagePropsBean.setSyoruiCd(C_SyoruiCdKbn.SK_DAISANSYAUKTHOUSYO);
                bzGetImagePropsBeanLst.add(BzGetImagePropsBean);

                outBean.setBzGetImagePropsBeanLst(bzGetImagePropsBeanLst);
                return outBean;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                outBean.setKekkaStatus(BzIwfUtilConstants.API_RESULTCD_OK);
                List<BzGetImagePropsBean> bzGetImagePropsBeanLst = new ArrayList<>();
                outBean.setBzGetImagePropsBeanLst(bzGetImagePropsBeanLst);

                return outBean;
            }
        }

        return super.exec(pBzGetImagePropsInBean);
    }

}

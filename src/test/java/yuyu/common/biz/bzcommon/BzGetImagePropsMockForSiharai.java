package yuyu.common.biz.bzcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.siharai.chksk.CheckSbSkNaiyouTest_exec;
import yuyu.common.siharai.chksk.ChkSubSaigaiGaitouTest_exec;
import yuyu.common.siharai.chksk.ChkSubSgSbJisatuMensekiTest_exec;
import yuyu.common.siharai.chksk.ChkSubSkSyoruiTest_exec;
import yuyu.common.siharai.koutei.SiGetSyoruittykymdTest_exec;
import yuyu.common.siharai.sicommon.SaigaiGaitouHanteiTest_chkKyuusyorui;

/**
 * {@link BzGetImageProps}のモッククラスです。<br />
 */
public class BzGetImagePropsMockForSiharai extends BzGetImageProps {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BzGetImagePropsOutBean exec(BzGetImagePropsInBean pBzGetImagePropsInBean) {

        BzGetImagePropsOutBean outBean = SWAKInjector.getInstance(BzGetImagePropsOutBean.class);

        if (caller == ChkSubSgSbJisatuMensekiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                List<BzGetImagePropsBean> list = new ArrayList<>();
                BzGetImagePropsBean bean = new BzGetImagePropsBean();
                bean.setSyoruiTtykYmdTime("20171018");
                list.add(bean);
                outBean.setBzGetImagePropsBeanLst(list);
                return outBean;
            }
        }

        if (caller == ChkSubSaigaiGaitouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                List<BzGetImagePropsBean> bzGetImagePropsBeanLst = new ArrayList<>();
                BzGetImagePropsBean bzGetImagePropsBean = new BzGetImagePropsBean();
                bzGetImagePropsBeanLst.add(bzGetImagePropsBean);
                outBean.setBzGetImagePropsBeanLst(bzGetImagePropsBeanLst);
            }
            return outBean;
        }

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

        if (caller == SiGetSyoruittykymdTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                super.exec(pBzGetImagePropsInBean);
                outBean.setKekkaStatus("0");
                outBean.setSyousaiMsgCd("IWF0000");
                return outBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
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
            else if (TESTPATTERN3.equals(SYORIPTN)) {
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
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                super.exec(pBzGetImagePropsInBean);
                outBean.setKekkaStatus("9");
                outBean.setSyousaiMsgCd("IWF0002");
                return outBean;
            }
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
        return super.exec(pBzGetImagePropsInBean);
    }
}

package yuyu.common.biz.bzdairiten;

import java.util.ArrayList;
import java.util.List;

import yuyu.common.sinkeiyaku.moschk.CheckTblMosDairitenTest_exec;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DiritenjyouhouKbn;

/**
 * {@link BzGetAgInfoJimusyo}のモッククラスです。<br />
 */
public class BzGetAgInfoJimusyoMockForSinkeiyaku extends BzGetAgInfoJimusyo {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    @Override
    public List<BzGetAgInfoBean> exec(String pOyadrtenCd, String pDrtenjimCd) {

        if (caller == CheckTblMosDairitenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                bzGetAgInfoBean.setOyadrtenCd("9001717");
                bzGetAgInfoBean.setDrtenCd("");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                return bzGetAgInfoBeanLst;
            }
            else if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                bzGetAgInfoBean.setChannelCd(C_Channelcd.SINKIN);
                bzGetAgInfoBean.setOyadrtenCd("9001717");
                bzGetAgInfoBean.setDrtenCd("");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                bzGetAgInfoBean1.setChannelCd(C_Channelcd.MIZUHO);
                bzGetAgInfoBean1.setOyadrtenCd("2001718");
                bzGetAgInfoBean.setDrtenCd("");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
                bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                bzGetAgInfoBean2.setChannelCd(C_Channelcd.MIZUHO);
                bzGetAgInfoBean2.setOyadrtenCd("2001718");
                bzGetAgInfoBean.setDrtenCd("");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);
                return bzGetAgInfoBeanLst;
            }
            else if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("1206206");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                bzGetAgInfoBean.setDrtenCd("3001719");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                bzGetAgInfoBean.setOyadrtenCd("9001717");
                bzGetAgInfoBean.setDrtenCd("3001717");
                bzGetAgInfoBean.setDaiBosyuuCd("123452");
                bzGetAgInfoBean.setDrtKanrisosikiCd1("4000017");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
                return bzGetAgInfoBeanLst;
            }
        }
        return super.exec(pOyadrtenCd, pDrtenjimCd);
    }
}
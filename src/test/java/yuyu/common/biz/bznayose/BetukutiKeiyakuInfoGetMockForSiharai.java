package yuyu.common.biz.bznayose;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutokuTest_getInfos;
import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.def.classification.C_SysCdKbn;

/**
 * {@link BetukutiKeiyakuInfoGet}のモッククラスです。<br />
 */
public class BetukutiKeiyakuInfoGetMockForSiharai extends BetukutiKeiyakuInfoGet {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    @Override
    public BetukutiKeiyakuInfoResultBean exec(BetukutiKeiyakuInfoGetParam pBetukutiKeiyakuInfoGetParam) {
        BetukutiKeiyakuInfoResultBean betukutiKeiyakuInfoResultBean = SWAKInjector
            .getInstance(BetukutiKeiyakuInfoResultBean.class);

        if (caller == KeiyakuInfoSyutokuTest_getInfos.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return betukutiKeiyakuInfoResultBean;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                BetukutiKeiyakuInfoBean  betukutiKeiyakuInfoBean = SWAKInjector.getInstance(BetukutiKeiyakuInfoBean.class);
                betukutiKeiyakuInfoBean.setBtkyksyono("11810111152");
                betukutiKeiyakuInfoBean.setSyscdkbn(C_SysCdKbn.RAY);
                betukutiKeiyakuInfoBean.setBetukutikeiyakukbn(C_BetukutiKeiyakuKbn.KEIYAKU);
                List<BetukutiKeiyakuInfoBean>  betukutiKeiyakuInfoBeanLst = new ArrayList<>();
                betukutiKeiyakuInfoBeanLst.add(betukutiKeiyakuInfoBean);
                betukutiKeiyakuInfoResultBean.setBetukutiKeiyakuInfoBeanLst(betukutiKeiyakuInfoBeanLst);
                return betukutiKeiyakuInfoResultBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                List<BetukutiKeiyakuInfoBean>  betukutiKeiyakuInfoBeanLst = new ArrayList<>();
                BetukutiKeiyakuInfoBean  betukutiKeiyakuInfoBean = SWAKInjector.getInstance(BetukutiKeiyakuInfoBean.class);
                betukutiKeiyakuInfoBean.setBtkyksyono("11810111118");
                betukutiKeiyakuInfoBean.setSyscdkbn(C_SysCdKbn.RAY);
                betukutiKeiyakuInfoBean.setBetukutikeiyakukbn(C_BetukutiKeiyakuKbn.NENKIN);
                betukutiKeiyakuInfoBeanLst.add(betukutiKeiyakuInfoBean);
                BetukutiKeiyakuInfoBean  betukutiKeiyakuInfoBean1 = SWAKInjector.getInstance(BetukutiKeiyakuInfoBean.class);
                betukutiKeiyakuInfoBean1.setBtkyksyono("11810111163");
                betukutiKeiyakuInfoBean1.setSyscdkbn(C_SysCdKbn.RAY);
                betukutiKeiyakuInfoBean1.setBetukutikeiyakukbn(C_BetukutiKeiyakuKbn.KEIYAKU);
                betukutiKeiyakuInfoBeanLst.add(betukutiKeiyakuInfoBean1);
                BetukutiKeiyakuInfoBean  betukutiKeiyakuInfoBean2 = SWAKInjector.getInstance(BetukutiKeiyakuInfoBean.class);
                betukutiKeiyakuInfoBean2.setBtkyksyono("11810111129");
                betukutiKeiyakuInfoBean2.setSyscdkbn(C_SysCdKbn.PAL);
                betukutiKeiyakuInfoBean2.setBetukutikeiyakukbn(C_BetukutiKeiyakuKbn.KEIYAKU);
                betukutiKeiyakuInfoBeanLst.add(betukutiKeiyakuInfoBean2);
                BetukutiKeiyakuInfoBean  betukutiKeiyakuInfoBean3 = SWAKInjector.getInstance(BetukutiKeiyakuInfoBean.class);
                betukutiKeiyakuInfoBean3.setBtkyksyono("11810111196");
                betukutiKeiyakuInfoBean3.setSyscdkbn(C_SysCdKbn.RAY);
                betukutiKeiyakuInfoBean3.setBetukutikeiyakukbn(C_BetukutiKeiyakuKbn.KEIYAKU);
                betukutiKeiyakuInfoBeanLst.add(betukutiKeiyakuInfoBean3);
                BetukutiKeiyakuInfoBean  betukutiKeiyakuInfoBean4 = SWAKInjector.getInstance(BetukutiKeiyakuInfoBean.class);
                betukutiKeiyakuInfoBean4.setBtkyksyono("11810111200");
                betukutiKeiyakuInfoBean4.setSyscdkbn(C_SysCdKbn.RAY);
                betukutiKeiyakuInfoBean4.setBetukutikeiyakukbn(C_BetukutiKeiyakuKbn.KEIYAKU);
                betukutiKeiyakuInfoBeanLst.add(betukutiKeiyakuInfoBean4);

                betukutiKeiyakuInfoResultBean.setBetukutiKeiyakuInfoBeanLst(betukutiKeiyakuInfoBeanLst);
                return betukutiKeiyakuInfoResultBean;
            }
        }

        return super.exec(pBetukutiKeiyakuInfoGetParam);
    }

}

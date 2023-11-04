package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UnitFundKbn;

/**
 * {@link KeisanCV}のモッククラスです<br />
 */
public class KeisanCVMockForHozen extends KeisanCV {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(String pSyoukenNo, BizDate pCalcKijyunYmd, C_Tuukasyu pKeiyakuTuukasyu) {

        if (caller == SetHosyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pSyoukenNo, pCalcKijyunYmd, pKeiyakuTuukasyu);
    }

    @Override
    public List<CVBean> getCVBeanList() {

        if (caller == SetHosyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                CVBean cVBean = new CVBean();
                cVBean.setUnitFundKbn(C_UnitFundKbn.USDFUND);
                cVBean.setUnitSuu(BizNumber.valueOf(1000));
                cVBean.setFundIndex(BizNumber.valueOf(11));
                cVBean.setFundBetuTumitatekin(BizCurrency.valueOf(11000));
                cVBean.setWariAi(50);
                List<CVBean>  cvBeanList = new ArrayList<>();
                cvBeanList.add(cVBean);
                return cvBeanList;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                CVBean cVBean1 = new CVBean();
                cVBean1.setUnitFundKbn(C_UnitFundKbn.USDFUND);
                cVBean1.setUnitSuu(BizNumber.valueOf(1000));
                cVBean1.setFundIndex(BizNumber.valueOf(11));
                cVBean1.setFundBetuTumitatekin(BizCurrency.valueOf(11000));
                cVBean1.setWariAi(60);
                List<CVBean>  cvBeanList = new ArrayList<>();
                cvBeanList.add(cVBean1);

                CVBean cVBean2 = new CVBean();
                cVBean2.setUnitFundKbn(C_UnitFundKbn.EURFUND);
                cVBean2.setUnitSuu(BizNumber.valueOf(2000));
                cVBean2.setFundIndex(BizNumber.valueOf(12));
                cVBean2.setFundBetuTumitatekin(BizCurrency.valueOf(24000));
                cVBean2.setWariAi(70);
                cvBeanList.add(cVBean2);

                CVBean cVBean3 = new CVBean();
                cVBean3.setUnitFundKbn(C_UnitFundKbn.AUDFUND);
                cVBean3.setUnitSuu(BizNumber.valueOf(3000));
                cVBean3.setFundIndex(BizNumber.valueOf(13));
                cVBean3.setFundBetuTumitatekin(BizCurrency.valueOf(39000));
                cVBean3.setWariAi(80);
                cvBeanList.add(cVBean3);
                return cvBeanList;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                List<CVBean>  cvBeanList = new ArrayList<>();
                return cvBeanList;
            }
        }
        return super.getCVBeanList();
    }

}

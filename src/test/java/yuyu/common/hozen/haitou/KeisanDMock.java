package yuyu.common.hozen.haitou;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.hozen.haitou.SetDNnd.DRateSyutokuInfoBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;

/**
 * {@link KeisanD}のモッククラスです。<br />
 */
public class KeisanDMock extends KeisanD {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(KeisanDBean pKeisanDBean) {
        if (KeisanDCommonTest_calcD.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        } else if (KeisanDCommonYendtHnk_calcDkngk.class == caller) {
            return C_ErrorKbn.OK;
        }
        return super.exec(pKeisanDBean);
    }

    @Override
    public DRateSyutokuInfoBean getDRateSyutokuInfoBean() {

        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);
        SetDNnd.DRateSyutokuInfoBean dRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();

        if(KeisanDCommonYendtHnk_calcDkngk.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                dRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                return dRateSyutokuInfoBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                dRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
                return dRateSyutokuInfoBean;
            }
        }
        return super.getDRateSyutokuInfoBean();
    }

    @Override
    public BizCurrency getD() {
        if(KeisanDCommonYendtHnk_calcDkngk.class == caller) {
            return BizCurrency.valueOf(100);
        }
        return super.getD();
    }
}

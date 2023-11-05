package yuyu.common.hozen.ascommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 年１回払年２回払領収金額計算{@link KeisanNenHalfyRsgaku}のモッククラスです。<br />
 */
public class KeisanNenHalfyRsgakuMockForKhansyuu extends KeisanNenHalfyRsgaku {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public C_ErrorKbn exec(KeisanNenHalfyRsgakuBean pKeisanNenHalfyRsgakuBean) {

        if (caller == KeisanRsgakuTest_exec1.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
        }
        return super.exec(pKeisanNenHalfyRsgakuBean);
    }

    @Override
    public String getErrorRiyuu () {

        if (caller == KeisanRsgakuTest_exec1.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return KeisanRsgakuConstants.ERRRIYUU_HRKKWSRATEKJYMD_ERR;
            }
        }

        return super.getErrorRiyuu();
    }

    @Override
    public KeisanRsgkOutBean getKeisanRsgkOutBean() {


        if (caller == KeisanRsgakuTest_exec1.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                KeisanRsgkOutBean keisanRsgkOutBean = SWAKInjector.getInstance(KeisanRsgkOutBean.class);
                keisanRsgkOutBean.setRsgakuGoukei(BizCurrency.valueOf(1000));
                keisanRsgkOutBean.setIktwaribikikgkGoukei(BizCurrency.valueOf(0));
                List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanLst = new ArrayList<KeisanRsgkUtiwakeBean>();
                KeisanRsgkUtiwakeBean keisanRsgkUtiwakeBean = SWAKInjector.getInstance(KeisanRsgkUtiwakeBean.class);
                keisanRsgkUtiwakeBean.setJyutoustartym(BizDateYM.valueOf(202009));
                keisanRsgkUtiwakeBean.setJyuutounensuu(0);
                keisanRsgkUtiwakeBean.setJyuutoutukisuu(6);
                keisanRsgkUtiwakeBean.setRsgaku(BizCurrency.valueOf(5000));
                keisanRsgkUtiwakeBean.setRyosyukwsratekjymd(BizDate.valueOf(20200814));
                keisanRsgkUtiwakeBean.setRyosyukwsrate(BizNumber.valueOf(2));
                keisanRsgkUtiwakeBean.setIktnyuukinnumu(C_UmuKbn.ARI);
                keisanRsgkUtiwakeBean.setIktwaribikikgk(BizCurrency.valueOf(100));
                keisanRsgkUtiwakeBeanLst.add(keisanRsgkUtiwakeBean);
                keisanRsgkOutBean.setKeisanRsgkUtiwakeBeanLst(keisanRsgkUtiwakeBeanLst);

                return keisanRsgkOutBean;
            }
        }

        return super.getKeisanRsgkOutBean();
    }

    @Override
    public List<String> getErrorCd() {

        if (caller == KeisanRsgakuTest_exec1.class) {

            List<String> errorCd = new ArrayList<String>();

            if (TESTPATTERN2.equals(SYORIPTN)) {

                errorCd.add(KeisanRsgakuConstants.ERRCD_HRKKWSRATEKJYMD_ERR);
                return errorCd;
            }
        }
        return super.getErrorCd();
    }
}
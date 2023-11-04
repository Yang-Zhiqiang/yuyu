package yuyu.common.hozen.ascommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkyksntkhijynsysn.DwGetHozenKykSntkHijynSysnImplTest_execPostForm;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * {@link KeisanRsgaku}のモッククラスです。<br />
 */
public class KeisanRsgakuMockForDirect extends KeisanRsgaku {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    @Override
    public C_ErrorKbn exec(IT_KykKihon pKykKihon, C_Nykkeiro pNykkeiro, C_NyknaiyouKbn pNyknaiyouKbn,
        BizDate pRsymd, BizDateYM pJyutoustartym, Integer pJyuutounensuu, Integer pJyuutoutukisuu) {

        if (DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
        }
        return super.exec(pKykKihon, pNykkeiro, pNyknaiyouKbn, pRsymd, pJyutoustartym, pJyuutounensuu, pJyuutoutukisuu);
    }

    @Override
    public List<String> getErrorCd() {
        if (DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class == caller) {

            List<String> errorCd = new ArrayList<String>();
            if (TESTPATTERN2.equals(SYORIPTN)) {

                errorCd.add(KeisanRsgakuConstants.ERRCD_HRKKWSRATEKJYMD_ERR);
                return errorCd;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                errorCd.add(KeisanRsgakuConstants.ERRCD_KAWASERATESYUTOKUERR);
                return errorCd;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                errorCd.add(KeisanRsgakuConstants.ERRCD_WARIBIKITEKIYOUKIKAN_ERR);
                return errorCd;
            }
        }
        return super.getErrorCd();
    }

    @Override
    public KeisanRsgkOutBean getKeisanRsgkOutBean() {

        if (DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

            List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList =  new ArrayList<>();
            KeisanRsgkOutBean keisanRsgkOutBean = SWAKInjector.getInstance(KeisanRsgkOutBean.class);

            KeisanRsgkUtiwakeBean keisanRsgkUtiwakeBean = SWAKInjector.getInstance(KeisanRsgkUtiwakeBean.class);
            keisanRsgkUtiwakeBean.setRsgaku(BizCurrency.valueOf(123));
            keisanRsgkUtiwakeBean.setRyosyukwsratekjymd(BizDate.valueOf(20200814));
            keisanRsgkUtiwakeBean.setRyosyukwsrate(BizNumber.valueOf(2));
            keisanRsgkUtiwakeBeanList.add(keisanRsgkUtiwakeBean);
            keisanRsgkOutBean.setKeisanRsgkUtiwakeBeanLst(keisanRsgkUtiwakeBeanList);
            return keisanRsgkOutBean;
            }
        }
        return super.getKeisanRsgkOutBean();
    }
}

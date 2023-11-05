package yuyu.common.hozen.ascommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec1;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec3;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec4;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec6;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec7;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec8;
import yuyu.common.hozen.khcommon.KykHenkoujiZnnJytTrksKsnTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * {@link KeisanRsgaku}のモッククラスです。<br />
 */
public class KeisanRsgakuMockForKhansyuu extends KeisanRsgaku {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    @Override
    public C_ErrorKbn exec(IT_KykKihon pKykKihon, C_Nykkeiro pNykkeiro, C_NyknaiyouKbn pNyknaiyouKbn,
        BizDate pRsymd, BizDateYM pJyutoustartym, Integer pJyuutounensuu, Integer pJyuutoutukisuu) {

        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec6.class ||
            caller == CommonNyuukinTest_exec7.class ||
            caller == CommonNyuukinTest_exec8.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN) ||
                TESTPATTERN4.equals(SYORIPTN) ||
                TESTPATTERN5.equals(SYORIPTN) ||
                TESTPATTERN6.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }

        if (caller == KykHenkoujiZnnJytTrksKsnTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pKykKihon, pNykkeiro, pNyknaiyouKbn, pRsymd, pJyutoustartym, pJyuutounensuu, pJyuutoutukisuu);
    }

    @Override
    public KeisanRsgkOutBean getKeisanRsgkOutBean() {

        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec6.class ||
            caller == CommonNyuukinTest_exec7.class ||
            caller == CommonNyuukinTest_exec8.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList =  new ArrayList<>();
                KeisanRsgkOutBean keisanRsgkOutBean = SWAKInjector.getInstance(KeisanRsgkOutBean.class);

                KeisanRsgkUtiwakeBean keisanRsgkUtiwakeBean = SWAKInjector.getInstance(KeisanRsgkUtiwakeBean.class);
                keisanRsgkUtiwakeBean.setJyutoustartym(BizDateYM.valueOf(201603));
                keisanRsgkUtiwakeBean.setJyuutounensuu(0);
                keisanRsgkUtiwakeBean.setJyuutoutukisuu(1);
                keisanRsgkUtiwakeBean.setRsgaku(BizCurrency.valueOf(3000));
                keisanRsgkUtiwakeBean.setRyosyukwsratekjymd(BizDate.valueOf(20200814));
                keisanRsgkUtiwakeBean.setRyosyukwsrate(BizNumber.valueOf(2));
                keisanRsgkUtiwakeBean.setIktnyuukinnumu(C_UmuKbn.ARI);
                keisanRsgkUtiwakeBean.setIktwaribikikgk(BizCurrency.valueOf(100));
                keisanRsgkUtiwakeBeanList.add(keisanRsgkUtiwakeBean);
                keisanRsgkOutBean.setKeisanRsgkUtiwakeBeanLst(keisanRsgkUtiwakeBeanList);
                keisanRsgkOutBean.setRsgakuGoukei(BizCurrency.valueOf(10));
                return keisanRsgkOutBean;
            }

            else if (TESTPATTERN3.equals(SYORIPTN)) {
                List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList =  new ArrayList<>();
                KeisanRsgkOutBean keisanRsgkOutBean = SWAKInjector.getInstance(KeisanRsgkOutBean.class);

                KeisanRsgkUtiwakeBean keisanRsgkUtiwakeBean = SWAKInjector.getInstance(KeisanRsgkUtiwakeBean.class);
                keisanRsgkUtiwakeBean.setJyutoustartym(BizDateYM.valueOf(201603));
                keisanRsgkUtiwakeBean.setJyuutounensuu(0);
                keisanRsgkUtiwakeBean.setJyuutoutukisuu(1);
                keisanRsgkUtiwakeBean.setRsgaku(BizCurrency.valueOf(1000));
                keisanRsgkUtiwakeBean.setIktnyuukinnumu(C_UmuKbn.ARI);
                keisanRsgkUtiwakeBean.setIktwaribikikgk(BizCurrency.valueOf(0));
                keisanRsgkUtiwakeBeanList.add(keisanRsgkUtiwakeBean);

                KeisanRsgkUtiwakeBean keisanRsgkUtiwakeBean2 = SWAKInjector.getInstance(KeisanRsgkUtiwakeBean.class);
                keisanRsgkUtiwakeBean2.setJyutoustartym(BizDateYM.valueOf(201604));
                keisanRsgkUtiwakeBean2.setJyuutounensuu(0);
                keisanRsgkUtiwakeBean2.setJyuutoutukisuu(1);
                keisanRsgkUtiwakeBean2.setRsgaku(BizCurrency.valueOf(1000));
                keisanRsgkUtiwakeBean2.setIktnyuukinnumu(C_UmuKbn.NONE);
                keisanRsgkUtiwakeBean2.setIktwaribikikgk(BizCurrency.valueOf(0));
                keisanRsgkUtiwakeBeanList.add(keisanRsgkUtiwakeBean2);


                KeisanRsgkUtiwakeBean keisanRsgkUtiwakeBean3 = SWAKInjector.getInstance(KeisanRsgkUtiwakeBean.class);
                keisanRsgkUtiwakeBean3.setJyutoustartym(BizDateYM.valueOf(201605));
                keisanRsgkUtiwakeBean3.setJyuutounensuu(0);
                keisanRsgkUtiwakeBean3.setJyuutoutukisuu(1);
                keisanRsgkUtiwakeBean3.setRsgaku(BizCurrency.valueOf(1000));
                keisanRsgkUtiwakeBean3.setRyosyukwsratekjymd(BizDate.valueOf(20200814));
                keisanRsgkUtiwakeBean3.setRyosyukwsrate(BizNumber.valueOf(2));
                keisanRsgkUtiwakeBean3.setIktnyuukinnumu(C_UmuKbn.ARI);
                keisanRsgkUtiwakeBean3.setIktwaribikikgk(BizCurrency.valueOf(100));
                keisanRsgkUtiwakeBeanList.add(keisanRsgkUtiwakeBean3);

                keisanRsgkOutBean.setKeisanRsgkUtiwakeBeanLst(keisanRsgkUtiwakeBeanList);
                keisanRsgkOutBean.setRsgakuGoukei(BizCurrency.valueOf(5000));
                return keisanRsgkOutBean;
            }

            else if (TESTPATTERN4.equals(SYORIPTN)) {
                List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList =  new ArrayList<>();
                KeisanRsgkOutBean keisanRsgkOutBean = SWAKInjector.getInstance(KeisanRsgkOutBean.class);

                KeisanRsgkUtiwakeBean keisanRsgkUtiwakeBean = SWAKInjector.getInstance(KeisanRsgkUtiwakeBean.class);
                keisanRsgkUtiwakeBean.setJyutoustartym(BizDateYM.valueOf(201603));
                keisanRsgkUtiwakeBean.setJyuutounensuu(0);
                keisanRsgkUtiwakeBean.setJyuutoutukisuu(1);
                keisanRsgkUtiwakeBean.setRsgaku(BizCurrency.valueOf(3000));
                keisanRsgkUtiwakeBean.setRyosyukwsratekjymd(BizDate.valueOf(20200814));
                keisanRsgkUtiwakeBean.setRyosyukwsrate(BizNumber.valueOf(2));
                keisanRsgkUtiwakeBean.setIktnyuukinnumu(C_UmuKbn.ARI);
                keisanRsgkUtiwakeBean.setIktwaribikikgk(BizCurrency.valueOf(500));
                keisanRsgkUtiwakeBeanList.add(keisanRsgkUtiwakeBean);
                keisanRsgkOutBean.setKeisanRsgkUtiwakeBeanLst(keisanRsgkUtiwakeBeanList);
                keisanRsgkOutBean.setRsgakuGoukei(BizCurrency.valueOf(1));
                return keisanRsgkOutBean;
            }

            else if (TESTPATTERN5.equals(SYORIPTN)) {
                List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList =  new ArrayList<>();
                KeisanRsgkOutBean keisanRsgkOutBean = SWAKInjector.getInstance(KeisanRsgkOutBean.class);

                KeisanRsgkUtiwakeBean keisanRsgkUtiwakeBean = SWAKInjector.getInstance(KeisanRsgkUtiwakeBean.class);
                keisanRsgkUtiwakeBean.setJyutoustartym(BizDateYM.valueOf(201512));
                keisanRsgkUtiwakeBean.setJyuutounensuu(1);
                keisanRsgkUtiwakeBean.setJyuutoutukisuu(2);
                keisanRsgkUtiwakeBean.setRsgaku(BizCurrency.valueOf(123));
                keisanRsgkUtiwakeBean.setRyosyukwsratekjymd(BizDate.valueOf(20200814));
                keisanRsgkUtiwakeBean.setRyosyukwsrate(BizNumber.valueOf(2));
                keisanRsgkUtiwakeBean.setIktnyuukinnumu(C_UmuKbn.ARI);
                keisanRsgkUtiwakeBean.setIktwaribikikgk(BizCurrency.valueOf(100));
                keisanRsgkUtiwakeBeanList.add(keisanRsgkUtiwakeBean);
                keisanRsgkOutBean.setKeisanRsgkUtiwakeBeanLst(keisanRsgkUtiwakeBeanList);
                keisanRsgkOutBean.setRsgakuGoukei(BizCurrency.valueOf(20));
                return keisanRsgkOutBean;
            }

            else if (TESTPATTERN6.equals(SYORIPTN)) {
                List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList =  new ArrayList<>();
                KeisanRsgkOutBean keisanRsgkOutBean = SWAKInjector.getInstance(KeisanRsgkOutBean.class);

                keisanRsgkOutBean.setKeisanRsgkUtiwakeBeanLst(keisanRsgkUtiwakeBeanList);
                keisanRsgkOutBean.setRsgakuGoukei(BizCurrency.valueOf(5000));
                return keisanRsgkOutBean;
            }
        }

        if (caller == KykHenkoujiZnnJytTrksKsnTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList =  new ArrayList<>();
                KeisanRsgkOutBean keisanRsgkOutBean = SWAKInjector.getInstance(KeisanRsgkOutBean.class);

                KeisanRsgkUtiwakeBean keisanRsgkUtiwakeBean = SWAKInjector.getInstance(KeisanRsgkUtiwakeBean.class);
                keisanRsgkUtiwakeBean.setJyutoustartym(BizDateYM.valueOf(201603));
                keisanRsgkUtiwakeBean.setJyuutounensuu(0);
                keisanRsgkUtiwakeBean.setJyuutoutukisuu(1);
                keisanRsgkUtiwakeBean.setRsgaku(BizCurrency.valueOf(3000));
                keisanRsgkUtiwakeBean.setRyosyukwsratekjymd(BizDate.valueOf(20200814));
                keisanRsgkUtiwakeBean.setRyosyukwsrate(BizNumber.valueOf(2));
                keisanRsgkUtiwakeBean.setIktnyuukinnumu(C_UmuKbn.ARI);
                keisanRsgkUtiwakeBean.setIktwaribikikgk(BizCurrency.valueOf(100));
                keisanRsgkUtiwakeBeanList.add(keisanRsgkUtiwakeBean);
                keisanRsgkOutBean.setKeisanRsgkUtiwakeBeanLst(keisanRsgkUtiwakeBeanList);
                keisanRsgkOutBean.setRsgakuGoukei(BizCurrency.valueOf(1000));
                keisanRsgkOutBean.setIktwaribikikgkGoukei(BizCurrency.valueOf(1000));
                return keisanRsgkOutBean;
            }
        }

        return super.getKeisanRsgkOutBean();
    }

    @Override
    public String getErrorRiyuu() {

        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec6.class ||
            caller == CommonNyuukinTest_exec7.class ||
            caller == CommonNyuukinTest_exec8.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return "保険料領収通貨取得エラー";
            }
        }
        return super.getErrorRiyuu();
    }

}

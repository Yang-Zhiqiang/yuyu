package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.common.biz.kaikei.BzHijynbrSikinIdouDataTysytTset_keisanHijynbrSikinIdougk;
import yuyu.common.direct.dscommon.DsDataMaintenanceHanteiTest_exec;
import yuyu.common.hozen.haitou.SetHokenNndTest_exec;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanTest_exec;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TykzentykgoKbn;

/**
 * 直前直後応当日設定のモッククラスです。<br />
 */
public class SetOutoubiMock extends SetOutoubi {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private String flag = "";

    @Override
    public BizDate exec(C_TykzentykgoKbn pTykzenTykgoKbn, BizDate pKijyunYmd,
        C_Hrkkaisuu pHhrkkaisuu, BizDate pHanteiYmd) {
        if (caller == SyouhnTaniKeisanMsyMkeiPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            if ("".equals(flag)) {
                flag = "1";
                return BizDate.valueOf("20171101");
            }
            else if ("1".equals(flag)) {
                flag = "2";
                return BizDate.valueOf("20171001");
            }
            else if ("2".equals(flag)) {
                flag = "";
                return BizDate.valueOf("20171102");
            }

        }
        else if (caller == SyouhnTaniKeisanMsyMkeiPTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            if ("".equals(flag)) {
                flag = "1";
                return BizDate.valueOf("20171201");
            }
            else if ("1".equals(flag)) {
                flag = "";
                return BizDate.valueOf("20171202");
            }
        }
        else if (caller == SyouhnTaniKeisanMsyMkeiPTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            if ("".equals(flag)) {
                flag = "1";
                return BizDate.valueOf("20171001");
            }
            else if ("1".equals(flag)) {
                flag = "";
                return BizDate.valueOf("20170902");
            }
        }
        else if (caller == SyouhnTaniKeisanMsyMkeiPTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {

            return BizDate.valueOf("20171101");

        }
        else if (caller == SyouhnTaniKeisanMsyMkeiPTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {

            return BizDate.valueOf("20171001");

        }
        else if (caller == KeisanMsyMkeiPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            return BizDate.valueOf("20180701");

        }
        else if (caller == KeisanMsyMkeiPTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            if ("".equals(flag)) {
                flag = "1";
                return BizDate.valueOf("20180701");
            }
            else if ("1".equals(flag)) {
                flag = "";
                return BizDate.valueOf("20181001");
            }

        }
        else if (caller == KeisanMsyMkeiPTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {

            return BizDate.valueOf("20171214");

        }
        else if (caller == KeisanMsyMkeiPTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
            if ("".equals(flag)) {
                flag = "1";
                return BizDate.valueOf("20171214");
            }
            else if ("1".equals(flag)) {
                flag = "";
                return BizDate.valueOf("20071202");
            }

        }
        else if (caller == EditKoujyonaiyouTblTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDate.valueOf("20151201");
        }
        else if (caller == EditKoujyonaiyouTblTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizDate.valueOf("20160501");
        }
        //        else if (caller == KeisanMsyMkeiPTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
        //
        //            return BizDate.valueOf("20171114");
        //
        //        }
        else if (caller == KeisanZennouSeisanGkTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDate.valueOf("20190401");
        }
        else if (caller == KeisanZennouSeisanGkTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizDate.valueOf("20180129");
        }
        else if (caller == KeisanZennouSeisanGkTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return BizDate.valueOf("20190129");
        }
        else if (caller == KeisanZennouSeisanGkTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return BizDate.valueOf("20160401");
        }
        else if (caller == KeisanZennouSeisanGkTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {
            return BizDate.valueOf("20170223");
        }
        else if (caller == KeisanZennouSeisanGkTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            return BizDate.valueOf("20171001");
        }
        else if (caller == KeisanZennouSeisanGkTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
            return BizDate.valueOf("20170409");
        }
        else if (caller == KeisanZennouSeisanGkTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            return BizDate.valueOf("20180509");
        }
        else if (caller == KeisanZennouSeisanGkTest_exec.class && TESTPATTERN9.equals(SYORIPTN)) {
            return BizDate.valueOf("20170509");
        }
        else if (caller == SetHokenNndTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            if(C_TykzentykgoKbn.TYKZEN.eq(pTykzenTykgoKbn)) {
                return BizDate.valueOf(20181101);
            }
            else if (C_TykzentykgoKbn.TYKGO.eq(pTykzenTykgoKbn)){
                return BizDate.valueOf(20181130);
            }
        }

        else if (caller == SetHosyouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            return BizDate.valueOf(20170510);

        }

        else if (caller == SiSiharaiKingakuKeisanTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf(20181101);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)){
                return BizDate.valueOf(20181130);
            }
        }

        else if (caller == EditSyoukenTbltest_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf("20200101");
            }
        }

        else if (caller == BzHijynbrSikinIdouDataTysytTset_keisanHijynbrSikinIdougk.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf("20190101");
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizDate.valueOf("20160103");
            }
        }

        else if(caller == EditSyoukenTblSyuusinTest_editTBL.class){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf("20181101");
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizDate.valueOf("20200101");
            }
        }

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDate.valueOf("20110203");
        }

        else if(caller == WSuiihyouNenkin2Test_exec.class){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf(20190311);
            }

            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizDate.valueOf(20190312);
            }

            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizDate.valueOf(20190313);
            }

            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizDate.valueOf(20200229);
            }
        }

        else if (caller == KeisanWKijunYMTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf(20160218);
            }
        }

        else if(caller == HanteiKhSisuurendoTmttknJyoutaiTest_exec.class){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf(20180901);
            }
        }

        else if(caller == DsDataMaintenanceHanteiTest_exec.class){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf(20190902);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizDate.valueOf(20190903);
            }
        }

        return super.exec(pTykzenTykgoKbn, pKijyunYmd, pHhrkkaisuu, pHanteiYmd);

    }

}

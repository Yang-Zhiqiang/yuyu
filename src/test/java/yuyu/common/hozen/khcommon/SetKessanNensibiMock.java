package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.hozen.haitou.CheckDJyoutaiTest_exec;
import yuyu.common.hozen.haitou.CheckDSeigouTest_checkKykMfHaitounendo;
import yuyu.common.hozen.haitou.KeisanDCommonDShrTest_calcDShrgkAllhikidasi;
import yuyu.common.hozen.haitou.KeisanDCommonDShrTest_calcDShrgkItibuhikidasi;
import yuyu.common.hozen.haitou.KeisanDCommonGengakuTest_calcDShrgk;
import yuyu.common.hozen.haitou.KeisanDCommonKaiyakuTest_calcDShrgk;
import yuyu.common.hozen.haitou.KeisanDCommonSibouTest_calcDShrgk;
import yuyu.common.hozen.haitou.KeisanDGanrikinTest_exec2;
import yuyu.common.hozen.haitou.KeisanDGanrikinTest_exec3;
import yuyu.common.hozen.haitou.KeisanDTest_exec;
import yuyu.common.hozen.haitou.SetDNndTest_exec;
import yuyu.common.hozen.haitou.SetHokenNndTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosSyouhinTest_exec;

/**
 * {@link SetKessanNensibi}のモッククラスです。<br />
 */
public class SetKessanNensibiMock extends SetKessanNensibi {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    @Override
    public BizDate exec(BizDate pHanteibi) {
        if(caller == CheckTblMosSyouhinTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1){
                return BizDate.valueOf("20160727");
            }
            else if (SYORIPTN == TESTPATTERN2){
                return BizDate.valueOf("20200727");
            }
        }
        else if(caller == KeisanDTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1){
                return BizDate.valueOf("20151015");
            }
        }
        else if(caller == CheckDJyoutaiTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1){
                return BizDate.valueOf("20170727");
            }
            else if (SYORIPTN == TESTPATTERN2){
                return BizDate.valueOf("20160727");
            }
            else if (SYORIPTN == TESTPATTERN3){
                return BizDate.valueOf("20150727");
            }
            else if (SYORIPTN == TESTPATTERN4){
                return BizDate.valueOf("20120727");
            }
        }
        else if (caller == SetHokenNndTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDate.valueOf(20181120);
        }
        else if (caller == CheckDSeigouTest_checkKykMfHaitounendo.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDate.valueOf(20171120);
        }

        if (caller == KeisanDGanrikinTest_exec2.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizDate.valueOf(20181101);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizDate.valueOf(20181102);

            }
        }

        if (caller == KeisanDGanrikinTest_exec3.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizDate.valueOf(20181101);
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizDate.valueOf(20181102);

            }
        }

        if (caller == CommonSiwakeUtilTest_execPKanjokamokuHantei.class) {
            return BizDate.valueOf(20181001);
        }
        else if (caller == CommonSiwakeUtilTest_execKihrkmPKanjokamokuHantei.class) {
            return BizDate.valueOf(20181001);
        }

        if (caller == CheckDSeigouTest_checkKykMfHaitounendo.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf(20161101);
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizDate.valueOf(20171102);
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizDate.valueOf(20181103);
            }
        }

        if (SetDNndTest_exec.class == caller) {
            return BizDate.valueOf(20170203);
        }

        if (KeisanDCommonKaiyakuTest_calcDShrgk.class == caller ||
            KeisanDCommonSibouTest_calcDShrgk.class == caller ||
            KeisanDCommonGengakuTest_calcDShrgk.class == caller ||
            KeisanDCommonDShrTest_calcDShrgkAllhikidasi.class == caller ||
            KeisanDCommonDShrTest_calcDShrgkItibuhikidasi.class == caller) {
            return BizDate.valueOf(20200202);
        }

        return super.exec(pHanteibi);
    }
}

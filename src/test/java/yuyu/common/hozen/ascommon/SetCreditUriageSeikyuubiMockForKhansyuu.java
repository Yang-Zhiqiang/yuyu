package yuyu.common.hozen.ascommon;

import yuyu.common.hozen.ascommon.EditHrhnKanryoTuutiTest_editTBL;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.sinkeiyaku.moschk.CheckNyuukinTest_exec;
import jp.co.slcs.swak.date.BizDate;

/**
 * クレカ売上請求日設定のモッククラスです。<br />
 */
public class SetCreditUriageSeikyuubiMockForKhansyuu extends SetCreditUriageSeikyuubi{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public int kaisu = 0;

    @Override
    public void exec(BizDate pCalckijyunYmd) {

        if (caller == EditHrhnKanryoTuutiTest_editTBL.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                return;
            }

            if (TESTPATTERN4.equals(SYORIPTN)) {

                return;
            }

            if (TESTPATTERN5.equals(SYORIPTN)) {

                return;
            }

            if (TESTPATTERN6.equals(SYORIPTN)) {

                return;
            }

            if (TESTPATTERN7.equals(SYORIPTN)) {

                return;
            }
        }

        super.exec(pCalckijyunYmd);

    }

    @Override
    public BizDate getJikaiUrsktysytbi() {

        if (caller == EditHrhnKanryoTuutiTest_editTBL.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizDate.valueOf("20171201");
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizDate.valueOf("20171101");
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                return BizDate.valueOf("20171001");
            }

            if (TESTPATTERN4.equals(SYORIPTN)) {

                return BizDate.valueOf("20170901");
            }

            if (TESTPATTERN5.equals(SYORIPTN)) {

                return BizDate.valueOf("20170801");
            }

            if (TESTPATTERN6.equals(SYORIPTN)) {

                return BizDate.valueOf("20170701");
            }

            if (TESTPATTERN7.equals(SYORIPTN)) {

                return BizDate.valueOf("20191101");
            }
        }

        if (caller == CheckNyuukinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (kaisu == 0) {
                    kaisu++;
                    return BizDate.valueOf("20181121");
                }
                return BizDate.valueOf("20181121");
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (kaisu == 0) {
                    kaisu++;
                    return BizDate.valueOf("20181021");
                }
                return BizDate.valueOf("20190722");
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (kaisu == 0) {
                    kaisu++;
                    return BizDate.valueOf("20181021");
                }
                return BizDate.valueOf("20180522");
            }
        }

        return super.getJikaiUrsktysytbi();
    }

    @Override
    public BizDate getZenkaiUrskbi() {

        return super.getZenkaiUrskbi();
    }

    @Override
    public BizDate getJikaiUrskbi() {

        if (caller == EditHrhnKanryoTuutiTest_editTBL.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizDate.valueOf("20191101");
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizDate.valueOf("20171115");
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                return BizDate.valueOf("20171015");
            }

            if (TESTPATTERN4.equals(SYORIPTN)) {

                return BizDate.valueOf("20170915");
            }

            if (TESTPATTERN5.equals(SYORIPTN)) {

                return BizDate.valueOf("20170815");
            }

            if (TESTPATTERN6.equals(SYORIPTN)) {

                return BizDate.valueOf("20191101");
            }

            if (TESTPATTERN7.equals(SYORIPTN)) {

                return BizDate.valueOf("20170815");
            }
        }

        return super.getJikaiUrskbi();
    }

    @Override
    public BizDate getJikaiUrskKekHaneibi() {

        return super.getJikaiUrskKekHaneibi();
    }

}

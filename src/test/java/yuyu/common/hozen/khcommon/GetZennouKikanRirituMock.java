package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 前納期間利率取得のモッククラスです。<br />
 */
public class GetZennouKikanRirituMock extends GetZennouKikanRiritu {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN12 = "12";

    public static final String TESTPATTERN13 = "13";

    public static final String TESTPATTERN14 = "14";

    public static final String TESTPATTERN15 = "15";

    public static final String TESTPATTERN16 = "16";

    public static final String TESTPATTERN17 = "17";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static int index = 0;

    private BizNumber zennouKikanRiritu;

    private List<BizDate> zennouTmttrituHnkbiList;

    @Override
    public BizNumber getZennouKikanRiritu() {
        if (caller == KeisanZennouSeisanGkTest_exec.class) {
            return zennouKikanRiritu;
        }
        return super.getZennouKikanRiritu();
    }

    @Override
    public List<BizDate> getZennouTmttrituHnkbiList() {
        if (caller == KeisanZennouSeisanGkTest_exec.class) {
            return zennouTmttrituHnkbiList;
        }
        return super.getZennouTmttrituHnkbiList();
    }

    @Override
    public C_ErrorKbn exec(BizDate pZennoufrom, BizDate pZennouto, BizDate pKykymd) {

        zennouTmttrituHnkbiList = new ArrayList<>();
        if ((caller == KeisanZennouSeisanGkTest_exec1.class) && TESTPATTERN1.equals(SYORIPTN)) {

            zennouKikanRiritu = BizNumber.valueOf(0);
            zennouTmttrituHnkbiList = null;
            return C_ErrorKbn.ERROR;
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN1.equals(SYORIPTN)) {

            zennouKikanRiritu = BizNumber.valueOf(0);
            zennouTmttrituHnkbiList = null;
            return C_ErrorKbn.ERROR;
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN2.equals(SYORIPTN)) {

            switch (index++) {
                case 0:
                    zennouKikanRiritu = BizNumber.valueOf(0.023);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 1:
                    return C_ErrorKbn.ERROR;
                default:
                    break;
            }
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN3.equals(SYORIPTN)) {
            switch (index++) {
                case 0:
                    zennouKikanRiritu = BizNumber.valueOf(0.023);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 1:
                    zennouKikanRiritu = BizNumber.valueOf(0.023);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 2:
                    return C_ErrorKbn.ERROR;
                default:
                    break;
            }
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN4.equals(SYORIPTN)) {

            switch (index++) {
                case 0:
                    zennouKikanRiritu = BizNumber.valueOf(0.023);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 1:
                    zennouKikanRiritu = BizNumber.valueOf(0.023);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 2:
                    zennouKikanRiritu = BizNumber.valueOf(0.023);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                default:
                    break;
            }
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN5.equals(SYORIPTN)) {

            switch (index++) {
                case 0:
                    zennouKikanRiritu = BizNumber.valueOf(0.023);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 1:
                    zennouKikanRiritu = BizNumber.valueOf(0.023);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                default:
                    break;
            }
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN6.equals(SYORIPTN)) {

            zennouKikanRiritu = BizNumber.valueOf(0.023);
            zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
            return C_ErrorKbn.OK;
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN7.equals(SYORIPTN)) {

            zennouKikanRiritu = BizNumber.valueOf(0.02016666666);
            zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
            return C_ErrorKbn.OK;
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN8.equals(SYORIPTN)) {

            switch (index++) {
                case 0:
                    zennouKikanRiritu = BizNumber.valueOf(0.001);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 1:
                    zennouKikanRiritu = BizNumber.valueOf(0);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 2:
                    zennouKikanRiritu = BizNumber.valueOf(0.001);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                default:
                    break;
            }
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN9.equals(SYORIPTN)) {

            switch (index++) {
                case 0:
                    zennouKikanRiritu = BizNumber.valueOf(0.022);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 1:
                    zennouKikanRiritu = BizNumber.valueOf(0.015583333);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                default:
                    break;
            }
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN10.equals(SYORIPTN)) {

            switch (index++) {
                case 0:
                    zennouKikanRiritu = BizNumber.valueOf(0.1);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 1:
                    zennouKikanRiritu = BizNumber.valueOf(0.6);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 2:
                    zennouKikanRiritu = BizNumber.valueOf(0.002);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 3:
                    zennouKikanRiritu = BizNumber.valueOf(0.601);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 4:
                    zennouKikanRiritu = BizNumber.valueOf(0.001);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                default:
                    break;
            }
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN11.equals(SYORIPTN)) {

            switch (index++) {
                case 0:
                    zennouKikanRiritu = BizNumber.valueOf(0.0116666666);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 1:
                    zennouKikanRiritu = BizNumber.valueOf(0.0015);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                default:
                    break;
            }
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN12.equals(SYORIPTN)) {

            switch (index++) {
                case 0:
                    zennouKikanRiritu = BizNumber.valueOf(0.0116666666);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 1:
                    zennouKikanRiritu = BizNumber.valueOf(0.0015);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                default:
                    break;
            }
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN13.equals(SYORIPTN)) {

            switch (index++) {
                case 0:
                    zennouKikanRiritu = BizNumber.valueOf(0.0033333333);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 1:
                    zennouKikanRiritu = BizNumber.valueOf(0.01);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                default:
                    break;
            }
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN14.equals(SYORIPTN)) {

            C_ErrorKbn errorKbn = C_ErrorKbn.OK;
            zennouKikanRiritu = BizNumber.valueOf(0);
            zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
            return errorKbn;
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN15.equals(SYORIPTN)) {

            C_ErrorKbn errorKbn = C_ErrorKbn.OK;
            zennouKikanRiritu = BizNumber.valueOf(0.022);
            zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
            return errorKbn;
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN16.equals(SYORIPTN)) {

            switch (index++) {
                case 0:
                    zennouKikanRiritu = BizNumber.valueOf(0.001);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 1:
                    zennouKikanRiritu = BizNumber.valueOf(0);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 2:
                    zennouKikanRiritu = BizNumber.valueOf(0.001);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                default:
                    break;
            }
        }
        if ((caller == KeisanZennouSeisanGkTest_exec.class) && TESTPATTERN17.equals(SYORIPTN)) {

            switch (index++) {
                case 0:
                    zennouKikanRiritu = BizNumber.valueOf(0.2);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 1:
                    zennouKikanRiritu = BizNumber.valueOf(0);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                case 2:
                    zennouKikanRiritu = BizNumber.valueOf(0.2);
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                default:
                    break;
            }
        }
        return super.exec(pZennoufrom, pZennouto, pKykymd);
    }
}

package yuyu.common.hozen.ascommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 前納期間利率取得処理２{@link GetZennouKikanRiritu2}のモッククラスです。<br />
 */
public class GetZennouKikanRiritu2MockForKhansyuu extends GetZennouKikanRiritu2 {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

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

    public static final String TESTPATTERN18 = "18";

    public static final String TESTPATTERN19 = "19";

    public static final String TESTPATTERN20 = "20";

    private BizNumber zennouKikanRiritu = BizNumber.valueOf(0);

    private List<BizDate> zennouTmttrituHnkbiList = new ArrayList<>();

    @Override
    public C_ErrorKbn exec(C_Tuukasyu pTuukasyu, BizDate pKikanfrom, BizDate pKikanto, BizDate pKykYmd) {

        if (caller == KeisanZennouSeisanGk2Test_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20170214)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(1.5);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20200918));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20170301)) == BizDateUtil.COMPARE_EQUAL) {
                    return C_ErrorKbn.ERROR;
                }
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20170214)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(1.4);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20201001));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20180401)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(1.5);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20200101));
                    return C_ErrorKbn.OK;
                }
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                zennouKikanRiritu = BizNumber.valueOf(0.023);
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20170214)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20200707));
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20180401)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20200101));
                }
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                zennouKikanRiritu = BizNumber.valueOf(0.02016666666);
                zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20150814)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.001);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20150901)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180102));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20160401)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.001);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180103));
                    return C_ErrorKbn.OK;
                }
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20161109)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.022);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20170223)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.015583333);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
            }
            if (TESTPATTERN8.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20131201)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.1);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20140201)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.6);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20150201)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.002);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20160201)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.601);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20171001)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.001);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
            }
            if (TESTPATTERN9.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20170809)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.0116666666);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20170409)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.0015);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
            }
            if (TESTPATTERN10.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20170409)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.0033333333);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20170509)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.01);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
            }
            if (TESTPATTERN11.equals(SYORIPTN)) {
                zennouKikanRiritu = BizNumber.valueOf(0);
                zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN12.equals(SYORIPTN)) {
                zennouKikanRiritu = BizNumber.valueOf(0.022);
                zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN13.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20150815)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.2);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20150901)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20160401)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.2);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
            }
            if (TESTPATTERN14.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20170214)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(1.4);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20201001));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20170201)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(1.5);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20200101));
                    return C_ErrorKbn.OK;
                }
                else {
                    return C_ErrorKbn.ERROR;
                }
            }

            if (TESTPATTERN15.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20150813)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.001);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20150901)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20160401)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.001);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
            }

            if (TESTPATTERN16.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20191026)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.001);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20191101)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20200401)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouKikanRiritu = BizNumber.valueOf(0.001);
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20180101));
                    return C_ErrorKbn.OK;
                }
            }
            if (TESTPATTERN17.equals(SYORIPTN)) {
                zennouKikanRiritu = BizNumber.valueOf(0.023);
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20150214)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20200707));
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20160101)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20200101));
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20170401)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20200505));
                }
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN18.equals(SYORIPTN)) {
                zennouKikanRiritu = BizNumber.valueOf(0.023);
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20130214)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20200707));
                }
                else if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20130401)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20200101));
                }
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN19.equals(SYORIPTN)) {
                zennouKikanRiritu = BizNumber.valueOf(0.023);
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20170214)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20200707));
                }
                return C_ErrorKbn.OK;
            }

            if (TESTPATTERN20.equals(SYORIPTN)) {
                zennouKikanRiritu = BizNumber.valueOf(0.023);
                if (BizDateUtil.compareYmd(pKikanfrom, BizDate.valueOf(20160323)) == BizDateUtil.COMPARE_EQUAL) {
                    zennouTmttrituHnkbiList.clear();
                    zennouTmttrituHnkbiList.add(BizDate.valueOf(20200707));
                }
                return C_ErrorKbn.OK;
            }
        }
        return super.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
    }

    @Override
    public BizNumber getZennouKikanRiritu() {

        if (caller == KeisanZennouSeisanGk2Test_exec.class) {
            return zennouKikanRiritu;
        }
        return super.getZennouKikanRiritu();
    }

    @Override
    public List<BizDate> getZennouTmttrituHnkbiList() {

        if (caller == KeisanZennouSeisanGk2Test_exec.class) {
            return zennouTmttrituHnkbiList;
        }
        return super.getZennouTmttrituHnkbiList();
    }
}

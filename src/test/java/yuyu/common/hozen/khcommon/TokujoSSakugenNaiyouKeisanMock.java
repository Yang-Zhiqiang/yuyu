package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.hozen.khcommon.SsakugenBean;
import yuyu.common.hozen.khcommon.TokujoSSakugenNaiyouKeisan;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link TokujoSSakugenNaiyouKeisan}のモッククラスです。<br />
 */
public class TokujoSSakugenNaiyouKeisanMock extends TokujoSSakugenNaiyouKeisan {

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec() {
        if(caller == SetHosyouTest_exec.class) {
            return C_ErrorKbn.OK;
        }

        return super.exec();
    }

    @Override
    public SsakugenBean[] getSsakugenBeans() {

        if(caller == SetHosyouTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            SsakugenBean[] ssakugenBeans = new SsakugenBean[1];
            SsakugenBean ssakugenBean = new SsakugenBean();
            ssakugenBean.setStartNendoYmd(BizDate.valueOf(20160101));
            ssakugenBean.setEndNendoYmd(BizDate.valueOf(20161201));
            ssakugenBean.setS(BizCurrency.valueOf(10000));
            ssakugenBeans[0] = ssakugenBean;
            return ssakugenBeans;
        }

        if(caller == SetHosyouTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {
            SsakugenBean[] ssakugenBeans = new SsakugenBean[3];
            SsakugenBean ssakugenBean1 = new SsakugenBean();
            ssakugenBean1.setStartNendoYmd(BizDate.valueOf(20160101));
            ssakugenBean1.setEndNendoYmd(BizDate.valueOf(20161201));
            ssakugenBean1.setS(BizCurrency.valueOf(10000));
            ssakugenBeans[0] = ssakugenBean1;

            SsakugenBean ssakugenBean2 = new SsakugenBean();
            ssakugenBean2.setStartNendoYmd(BizDate.valueOf(20160102));
            ssakugenBean2.setEndNendoYmd(BizDate.valueOf(20161202));
            ssakugenBean2.setS(BizCurrency.valueOf(20000));
            ssakugenBeans[1] = ssakugenBean2;

            SsakugenBean ssakugenBean3 = new SsakugenBean();
            ssakugenBean3.setStartNendoYmd(BizDate.valueOf(20160103));
            ssakugenBean3.setEndNendoYmd(BizDate.valueOf(20161203));
            ssakugenBean3.setS(BizCurrency.valueOf(30000));
            ssakugenBeans[2] = ssakugenBean3;
            return ssakugenBeans;
        }

        if(caller == SetHosyouTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            SsakugenBean[] ssakugenBeans = new SsakugenBean[5];
            SsakugenBean ssakugenBean1 = new SsakugenBean();
            ssakugenBean1.setStartNendoYmd(BizDate.valueOf(20160101));
            ssakugenBean1.setEndNendoYmd(BizDate.valueOf(20161201));
            ssakugenBean1.setS(BizCurrency.valueOf(10000));
            ssakugenBeans[0] = ssakugenBean1;

            SsakugenBean ssakugenBean2 = new SsakugenBean();
            ssakugenBean2.setStartNendoYmd(BizDate.valueOf(20160102));
            ssakugenBean2.setEndNendoYmd(BizDate.valueOf(20161202));
            ssakugenBean2.setS(BizCurrency.valueOf(20000));
            ssakugenBeans[1] = ssakugenBean2;

            SsakugenBean ssakugenBean3 = new SsakugenBean();
            ssakugenBean3.setStartNendoYmd(BizDate.valueOf(20160103));
            ssakugenBean3.setEndNendoYmd(BizDate.valueOf(20161203));
            ssakugenBean3.setS(BizCurrency.valueOf(30000));
            ssakugenBeans[2] = ssakugenBean3;

            SsakugenBean ssakugenBean4 = new SsakugenBean();
            ssakugenBean4.setStartNendoYmd(BizDate.valueOf(20160104));
            ssakugenBean4.setEndNendoYmd(BizDate.valueOf(20161204));
            ssakugenBean4.setS(BizCurrency.valueOf(40000));
            ssakugenBeans[3] = ssakugenBean4;

            SsakugenBean ssakugenBean5 = new SsakugenBean();
            ssakugenBean5.setStartNendoYmd(BizDate.valueOf(20160105));
            ssakugenBean5.setEndNendoYmd(BizDate.valueOf(20161205));
            ssakugenBean5.setS(BizCurrency.valueOf(50000));
            ssakugenBeans[4] = ssakugenBean5;
            return ssakugenBeans;
        }

        return null;
    }
}
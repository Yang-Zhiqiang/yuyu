package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link BizDateUtil}クラスに含まれる、{@link BizDateUtil#getDateAfterPeriod(BizDate,int,int)} メソッドのテストです。
 */

@RunWith(OrderedRunner.class)
public class BizDateUtilTest_getDateAfterPeriod {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }
    @Test
    @TestOrder(10)
    public void testNormalParam01(){
        BizDate inputDate = BizDate.valueOf("20150331");
        int year = 2;
        int month = 1;
        BizDate outputDate = BizDateUtil.getDateAfterPeriod(inputDate, year, month);
        BizDate expect = BizDate.valueOf("20170501");
        exDateEquals(outputDate, expect, "保険期間計算（後倒し対応用）日付");
    }

    @Test
    @TestOrder(20)
    public void testNormalParam02(){
        BizDate inputDate = BizDate.valueOf("20150331");
        int year = 0;
        int month = 3;
        BizDate outputDate = BizDateUtil.getDateAfterPeriod(inputDate, year, month);
        BizDate expect = BizDate.valueOf("20150701");
        exDateEquals(outputDate, expect, "保険期間計算（後倒し対応用）日付");
    }

    @Test
    @TestOrder(30)
    public void testNormalParam03(){
        BizDate inputDate = BizDate.valueOf("20160229");
        int year = 1;
        int month = 0;
        BizDate outputDate = BizDateUtil.getDateAfterPeriod(inputDate, year, month);
        BizDate expect = BizDate.valueOf("20170301");
        exDateEquals(outputDate, expect, "保険期間計算（後倒し対応用）日付");
    }

    @Test
    @TestOrder(40)
    public void testNormalParam04(){
        BizDate inputDate = BizDate.valueOf("20160229");
        int year = 0;
        int month = 0;
        BizDate outputDate = BizDateUtil.getDateAfterPeriod(inputDate, year, month);
        BizDate expect = BizDate.valueOf("20160229");
        exDateEquals(outputDate, expect, "保険期間計算（後倒し対応用）日付");
    }

    @Test
    @TestOrder(50)
    public void testNormalParam05(){
        BizDate inputDate = BizDate.valueOf("20161205");
        int year = 2;
        int month = 3;
        BizDate outputDate = BizDateUtil.getDateAfterPeriod(inputDate, year, month);
        BizDate expect = BizDate.valueOf("20190305");
        exDateEquals(outputDate, expect, "保険期間計算（後倒し対応用）日付");
    }

    @Test
    @TestOrder(60)
    public void testNormalParam06_1(){
        BizDate inputDate = BizDate.valueOf("20180630");
        int year = 2;
        int month = 2;
        BizDate outputDate = BizDateUtil.getDateAfterPeriod(inputDate, year, month);
        BizDate expect = BizDate.valueOf("20200830");
        exDateEquals(outputDate, expect, "保険期間計算（後倒し対応用）日付");
    }

    @Test
    @TestOrder(70)
    public void testNormalParam06_2(){
        BizDate inputDate = BizDate.valueOf("20180630");
        int year = 2;
        int month = 3;
        BizDate outputDate = BizDateUtil.getDateAfterPeriod(inputDate, year, month);
        BizDate expect = BizDate.valueOf("20200930");
        exDateEquals(outputDate, expect, "保険期間計算（後倒し対応用）日付");
    }


    @Test
    @TestOrder(80)
    public void testNormalParam06_3(){
        BizDate inputDate = BizDate.valueOf("20180227");
        int year = 2;
        int month = 0;
        BizDate outputDate = BizDateUtil.getDateAfterPeriod(inputDate, year, month);
        BizDate expect = BizDate.valueOf("20200227");
        exDateEquals(outputDate, expect, "保険期間計算（後倒し対応用）日付");
    }


    @Test
    @TestOrder(90)
    public void testNormalParam06_4(){
        BizDate inputDate = BizDate.valueOf("20180228");
        int year = 2;
        int month = 0;
        BizDate outputDate = BizDateUtil.getDateAfterPeriod(inputDate, year, month);
        BizDate expect = BizDate.valueOf("20200228");
        exDateEquals(outputDate, expect, "保険期間計算（後倒し対応用）日付");
    }

    @Test
    @TestOrder(100)
    public void testNormalParam06_5(){
        BizDate inputDate = BizDate.valueOf("20200228");
        int year = 1;
        int month = 0;
        BizDate outputDate = BizDateUtil.getDateAfterPeriod(inputDate, year, month);
        BizDate expect = BizDate.valueOf("20210228");
        exDateEquals(outputDate, expect, "保険期間計算（後倒し対応用）日付");
    }

    @Test
    @TestOrder(110)
    public void testNormalParam06_6(){
        BizDate inputDate = BizDate.valueOf("20200229");
        int year = 1;
        int month = 0;
        BizDate outputDate = BizDateUtil.getDateAfterPeriod(inputDate, year, month);
        BizDate expect = BizDate.valueOf("20210301");
        exDateEquals(outputDate, expect, "保険期間計算（後倒し対応用）日付");
    }

    @Test
    @TestOrder(120)
    public void testNormalParam06_7(){
        BizDate inputDate = BizDate.valueOf("20180101");
        int year = 1;
        int month = 13;
        BizDate outputDate = BizDateUtil.getDateAfterPeriod(inputDate, year, month);
        BizDate expect = BizDate.valueOf("20200201");
        exDateEquals(outputDate, expect, "保険期間計算（後倒し対応用）日付");
    }
}

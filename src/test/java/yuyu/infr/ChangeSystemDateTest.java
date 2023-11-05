package yuyu.infr;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * テスト基盤のシステムテスト日付変更メソッドテスト用クラス
 */
@RunWith(OrderedRunner.class)
public class ChangeSystemDateTest extends AbstractTest {

    @Test
    @TestOrder(10)
    @Transactional
    public void test01() {

        String sysDate = BizDate.getSysDate().toString();
        changeSystemDate(BizDate.getSysDate());
        assertEquals(sysDate, BizDate.getSysDate().toString());

        changeSystemDate(BizDate.valueOf("20151130"));
        assertEquals("20151130", BizDate.getSysDate().toString());

        changeSystemDate(BizDate.valueOf("20150831"));
        assertEquals("20150831", BizDate.getSysDate().toString());

        changeSystemDate(BizDate.valueOf("20150228"));
        assertEquals("20150228", BizDate.getSysDate().toString());

        changeSystemDate(BizDate.valueOf("20141231"));
        assertEquals("20141231", BizDate.getSysDate().toString());

        changeSystemDate(BizDate.valueOf("20150101"));
        assertEquals("20150101", BizDate.getSysDate().toString());

        changeSystemDate(BizDate.valueOf("20120229"));
        assertEquals("20120229", BizDate.getSysDate().toString());

        changeSystemDate(BizDate.valueOf("20200811"));
        assertEquals("20200811", BizDate.getSysDate().toString());

        //        logger.debug(current.toString());
    }

}

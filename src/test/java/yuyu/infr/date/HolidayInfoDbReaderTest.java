package yuyu.infr.date;

import static org.junit.Assert.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWAKTestRunner.class)
public class HolidayInfoDbReaderTest {

    @Test
    public void test01() {
        assertEquals("BankHolidays", BizDate.getDefaultHolidayCode());

        assertFalse(BizDate.valueOf(2015, 2, 17).isHoliday());
        assertFalse(BizDate.valueOf(2015, 2, 17).isLegalHoliday());

        assertTrue (BizDate.valueOf(2015, 2, 15).isHoliday());
        assertFalse(BizDate.valueOf(2015, 2, 15).isLegalHoliday());

        assertTrue (BizDate.valueOf(2015, 2, 11).isHoliday());
        assertTrue (BizDate.valueOf(2015, 2, 11).isLegalHoliday());
    }
}

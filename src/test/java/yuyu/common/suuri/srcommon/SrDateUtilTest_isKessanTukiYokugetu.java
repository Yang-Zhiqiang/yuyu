package yuyu.common.suuri.srcommon;

import static org.junit.Assert.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;

import yuyu.testinfr.TestOrder;

/**
 * 数理日付ユーティリティクラスの決算翌月判定メソッド
 *  {@link SrDateUtil#isKessanTukiYokugetu(BizDate)} テスト用クラスです。<br />
 */
public class SrDateUtilTest_isKessanTukiYokugetu {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void paramNull() {
        BizDate bizDate = null;
        assertFalse(SrDateUtil.isKessanTukiYokugetu(bizDate));
    }

    //    @Test
    //    @TestOrder(20)
    //    public void paramBlank() {
    //        BizDate bizDate = BizDate.valueOf("");
    //        assertFalse(SrDateUtil.isKessanTukiYokugetu(bizDate));
    //    }

    @Test
    @TestOrder(30)
    public void notRekijyou() {
        BizDate bizDate = BizDate.valueOf("20160431");
        assertFalse(SrDateUtil.isKessanTukiYokugetu(bizDate));
    }

    @Test
    @TestOrder(40)
    public void rekijyou() {
        BizDate bizDate = BizDate.valueOf("20160412");
        assertTrue(SrDateUtil.isKessanTukiYokugetu(bizDate));
    }

    @Test
    @TestOrder(50)
    public void kessan3QYokugetu() {
        BizDate bizDate = BizDate.valueOf("20160101");
        assertTrue(SrDateUtil.isKessanTukiYokugetu(bizDate));
    }

    @Test
    @TestOrder(60)
    public void kessan4QYokugetu() {
        BizDate bizDate = BizDate.valueOf("20160410");
        assertTrue(SrDateUtil.isKessanTukiYokugetu(bizDate));
    }

    @Test
    @TestOrder(70)
    public void kessan1QYokugetu() {
        BizDate bizDate = BizDate.valueOf("20160720");
        assertTrue(SrDateUtil.isKessanTukiYokugetu(bizDate));
    }

    @Test
    @TestOrder(80)
    public void kessan2QYokugetu() {
        BizDate bizDate = BizDate.valueOf("20161030");
        assertTrue(SrDateUtil.isKessanTukiYokugetu(bizDate));
    }

    @Test
    @TestOrder(90)
    public void notKessanYokugetu() {
        BizDate bizDate = BizDate.valueOf("20160831");
        assertFalse(SrDateUtil.isKessanTukiYokugetu(bizDate));
    }
}

package yuyu.common.suuri.srcommon;

import static org.junit.Assert.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;

import yuyu.testinfr.TestOrder;

/**
 * 数理日付ユーティリティクラスの決算月判定メソッド
 *  {@link SrDateUtil#isKessanTuki(BizDate)} テスト用クラスです。<br />
 */
public class SrDateUtilTest_isKessanTuki {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void paramNull() {
        BizDate bizDate = null;
        assertFalse(SrDateUtil.isKessanTuki(bizDate));
    }

    //    @Test
    //    @TestOrder(20)
    //    public void paramBlank() {
    //        BizDate bizDate = BizDate.valueOf("");
    //        assertFalse(SrDateUtil.isKessanTuki(bizDate));
    //    }

    @Test
    @TestOrder(30)
    public void notRekijyou() {
        BizDate bizDate = BizDate.valueOf("20160230");
        assertFalse(SrDateUtil.isKessanTuki(bizDate));
    }

    @Test
    @TestOrder(40)
    public void rekijyou() {
        BizDate bizDate = BizDate.valueOf("20160601");
        assertTrue(SrDateUtil.isKessanTuki(bizDate));
    }

    @Test
    @TestOrder(50)
    public void kessan4Q() {
        BizDate bizDate = BizDate.valueOf("20160301");
        assertTrue(SrDateUtil.isKessanTuki(bizDate));
    }

    @Test
    @TestOrder(60)
    public void kessan1Q() {
        BizDate bizDate = BizDate.valueOf("20160605");
        assertTrue(SrDateUtil.isKessanTuki(bizDate));
    }

    @Test
    @TestOrder(70)
    public void kessan2Q() {
        BizDate bizDate = BizDate.valueOf("20160910");
        assertTrue(SrDateUtil.isKessanTuki(bizDate));
    }

    @Test
    @TestOrder(80)
    public void kessan3Q() {
        BizDate bizDate = BizDate.valueOf("20161220");
        assertTrue(SrDateUtil.isKessanTuki(bizDate));
    }

    @Test
    @TestOrder(90)
    public void notKessan() {
        BizDate bizDate = BizDate.valueOf("20160130");
        assertFalse(SrDateUtil.isKessanTuki(bizDate));
    }
}

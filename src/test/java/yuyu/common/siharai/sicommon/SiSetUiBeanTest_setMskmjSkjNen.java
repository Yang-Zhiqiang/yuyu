package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.SetNenreiMock;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setMskmjSkjNen(BizDate, BizDate, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setMskmjSkjNen {

    @Inject
    private SiSetUiBean siSetUiBean;

    @BeforeClass
    public static void testInit() {
        SetNenreiMock.caller = SiSetUiBeanTest_setMskmjSkjNen.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        SetNenreiMock.caller = null;
        SetNenreiMock.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testSetMskmjSkjNen_A1() {

        MockObjectManager.initialize();
        SetNenreiMock.SYORIPTN = SetNenreiMock.TESTPATTERN1;

        String mskmjSkjNen = siSetUiBean.setMskmjSkjNen(BizDate.valueOf("20160103"), null, BizDate.valueOf("20010102"));

        exStringEquals(mskmjSkjNen, "", "申込時請求時年齢");
    }

    @Test
    @TestOrder(20)
    public void testSetMskmjSkjNen_A2() {

        MockObjectManager.initialize();
        SetNenreiMock.SYORIPTN = SetNenreiMock.TESTPATTERN1;

        String mskmjSkjNen = siSetUiBean.setMskmjSkjNen(BizDate.valueOf("20160101"), null, BizDate.valueOf("20010102"));

        exStringEquals(mskmjSkjNen, "（申込時：　15歳）", "申込時請求時年齢");
    }

    @Test
    @TestOrder(30)
    public void testSetMskmjSkjNen_A3() {

        MockObjectManager.initialize();
        SetNenreiMock.SYORIPTN = SetNenreiMock.TESTPATTERN1;

        String mskmjSkjNen = siSetUiBean.setMskmjSkjNen(BizDate.valueOf("20160101"), BizDate.valueOf("20160102"),
            BizDate.valueOf("20010102"));

        exStringEquals(mskmjSkjNen, "（申込時：　15歳　請求時：　16歳）", "申込時請求時年齢");
        BizDate mosymd = (BizDate) MockObjectManager.getArgument(SetNenreiMock.class, "exec", 0, 0);
        exDateEquals(mosymd, BizDate.valueOf("20160101"), "基準日(申込日)");
        BizDate seiymd = (BizDate) MockObjectManager.getArgument(SetNenreiMock.class, "exec", 0, 1);
        exDateEquals(seiymd, BizDate.valueOf("20010102"), "生年月日");
        BizDate syoruiukeymd = (BizDate) MockObjectManager.getArgument(SetNenreiMock.class, "exec", 1, 0);
        exDateEquals(syoruiukeymd, BizDate.valueOf("20160102"), "基準日(書類受付日)");
        BizDate seiymd1 = (BizDate) MockObjectManager.getArgument(SetNenreiMock.class, "exec", 1, 1);
        exDateEquals(seiymd1, BizDate.valueOf("20010102"), "生年月日");

    }

    @Test
    @TestOrder(40)
    public void testSetMskmjSkjNen_A4() {

        MockObjectManager.initialize();
        SetNenreiMock.SYORIPTN = SetNenreiMock.TESTPATTERN1;

        String mskmjSkjNen = siSetUiBean.setMskmjSkjNen(BizDate.valueOf("20160103"), BizDate.valueOf("20160102"),
            BizDate.valueOf("20010102"));

        exStringEquals(mskmjSkjNen, "", "申込時請求時年齢");

    }

    @Test
    @TestOrder(50)
    public void testSetMskmjSkjNen_A5() {

        MockObjectManager.initialize();
        SetNenreiMock.SYORIPTN = SetNenreiMock.TESTPATTERN1;

        String mskmjSkjNen = siSetUiBean.setMskmjSkjNen(BizDate.valueOf("20160101"), BizDate.valueOf("20160103"),
            BizDate.valueOf("20010102"));

        exStringEquals(mskmjSkjNen, "", "申込時請求時年齢");

    }

}

package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 外貨終身一時払用予定新契約費率計算クラスのメソッド {@link KeisanGaikaItijiSkHiritu#exec(BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanGaikaItijiSkHirituTest_exec {

    @Inject
    private KeisanGaikaItijiSkHiritu keisanGaikaItijiSkHiritu;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0050);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.75000));

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0500);
        Integer pHhknNen = 80;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(4.00000));

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0050);
        Integer pHhknNen = 49;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.75000));

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0500);
        Integer pHhknNen =50;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(4.00000));

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0050);
        Integer pHhknNen = 80;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.50000));

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0500);
        Integer pHhknNen = 81;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(4.00000));

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0050);
        Integer pHhknNen = 90;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.50000));

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0500);
        Integer pHhknNen = 90;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(4.00000));

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0055);
        Integer pHhknNen = 90;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.55000));

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0050);
        Integer pHhknNen = 73;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.56250));

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0060);
        Integer pHhknNen = 90;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.60000));

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0055);
        Integer pHhknNen = 73;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.61875));

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0050);
        Integer pHhknNen = 72;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.62500));

    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0065);
        Integer pHhknNen = 90;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.65000));

    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0060);
        Integer pHhknNen = 73;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.67500));

    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0050);
        Integer pHhknNen = 71;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.68750));

    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0055);
        Integer pHhknNen = 72;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.68750));

    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0070);
        Integer pHhknNen = 90;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.70000));

    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0065);
        Integer pHhknNen = 73;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.73125));

    }


    @Test
    @TestOrder(200)
    public void testExec_A20() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0055);
        Integer pHhknNen = 71;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.75625));

    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0070);
        Integer pHhknNen = 73;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.78750));

    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0080);
        Integer pHhknNen = 90;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.80000));

    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0065);
        Integer pHhknNen = 72;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.81250));

    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0055);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.82500));

    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0075);
        Integer pHhknNen = 73;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.84375));

    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0085);
        Integer pHhknNen = 90;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.85000));

    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0070);
        Integer pHhknNen = 72;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.87500));

    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0065);
        Integer pHhknNen = 71;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.89375));

    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0090);
        Integer pHhknNen = 90;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.90000));

    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0075);
        Integer pHhknNen = 72;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.93750));

    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0095);
        Integer pHhknNen = 90;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.95000));
    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0085);
        Integer pHhknNen = 73;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.95625));

    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0070);
        Integer pHhknNen = 71;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.96250));

    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0065);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.97500));

    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0100);
        Integer pHhknNen = 90;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.00000));

    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0090);
        Integer pHhknNen = 73;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.01250));

    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0075);
        Integer pHhknNen = 71;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.03125));

    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0070);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.05000));

    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0085);
        Integer pHhknNen = 72;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.06250));

    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0095);
        Integer pHhknNen = 73;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.06875));

    }

    @Test
    @TestOrder(410)
    public void testExec_A41() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0080);
        Integer pHhknNen = 71;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.10000));

    }

    @Test
    @TestOrder(420)
    public void testExec_A42() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0075);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.12500));

    }

    @Test
    @TestOrder(430)
    public void testExec_A43() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0085);
        Integer pHhknNen = 71;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.16875));

    }

    @Test
    @TestOrder(440)
    public void testExec_A44() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0095);
        Integer pHhknNen = 72;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.18750));

    }

    @Test
    @TestOrder(450)
    public void testExec_A45() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0080);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.20000));
    }

    @Test
    @TestOrder(460)
    public void testExec_A46() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0090);
        Integer pHhknNen = 71;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.23750));

    }

    @Test
    @TestOrder(470)
    public void testExec_A47() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0140);
        Integer pHhknNen = 90;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.25000));

    }

    @Test
    @TestOrder(480)
    public void testExec_A48() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0085);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.27500));

    }

    @Test
    @TestOrder(490)
    public void testExec_A49() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0095);
        Integer pHhknNen = 71;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.30625));

    }

    @Test
    @TestOrder(500)
    public void testExec_A50() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0090);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.35000));

    }

    @Test
    @TestOrder(510)
    public void testExec_A51() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0100);
        Integer pHhknNen = 71;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.37500));

    }

    @Test
    @TestOrder(520)
    public void testExec_A52() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0095);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.42500));

    }

    @Test
    @TestOrder(530)
    public void testExec_A53() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0100);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.50000));
    }

    @Test
    @TestOrder(540)
    public void testExec_A54() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0105);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.62500));

    }

    @Test
    @TestOrder(550)
    public void testExec_A55() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0110);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.75000));

    }

    @Test
    @TestOrder(560)
    public void testExec_A56() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0115);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.87500));

    }

    @Test
    @TestOrder(570)
    public void testExec_A57() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0120);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(2.00000));

    }

    @Test
    @TestOrder(580)
    public void testExec_A58() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0125);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(2.12500));

    }

    @Test
    @TestOrder(590)
    public void testExec_A59() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0130);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(2.25000));

    }

    @Test
    @TestOrder(600)
    public void testExec_A60() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0135);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(2.37500));
    }

    @Test
    @TestOrder(610)
    public void testExec_A61() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0140);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(2.50000));

    }

    @Test
    @TestOrder(620)
    public void testExec_A62() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0145);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(2.62500));

    }

    @Test
    @TestOrder(630)
    public void testExec_A63() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0150);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(2.75000));

    }

    @Test
    @TestOrder(640)
    public void testExec_A64() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0155);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(2.87500));

    }

    @Test
    @TestOrder(650)
    public void testExec_A65() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0160);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(3.00000));

    }

    @Test
    @TestOrder(660)
    public void testExec_A66() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0165);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(3.12500));
    }

    @Test
    @TestOrder(670)
    public void testExec_A67() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0170);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(3.25000));

    }

    @Test
    @TestOrder(680)
    public void testExec_A68() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0175);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(3.37500));

    }

    @Test
    @TestOrder(690)
    public void testExec_A69() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0180);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(3.50000));

    }

    @Test
    @TestOrder(700)
    public void testExec_A70() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0185);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(3.62500));

    }

    @Test
    @TestOrder(710)
    public void testExec_A71() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0190);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(3.75000));

    }

    @Test
    @TestOrder(720)
    public void testExec_A72() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0195);
        Integer pHhknNen = 40;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(3.87500));
    }

    @Test
    @TestOrder(730)
    public void testExec_A73() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0050);
        Integer pHhknNen = 70;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.75000));

    }

    @Test
    @TestOrder(740)
    public void testExec_A74() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0050);
        Integer pHhknNen = 74;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.50000));

    }

    @Test
    @TestOrder(750)
    public void testExec_A75() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0055);
        Integer pHhknNen = 70;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.82500));

    }

    @Test
    @TestOrder(760)
    public void testExec_A76() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0055);
        Integer pHhknNen = 74;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.55000));
    }

    @Test
    @TestOrder(770)
    public void testExec_A77() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0060);
        Integer pHhknNen = 70;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.90000));

    }

    @Test
    @TestOrder(780)
    public void testExec_A78() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0060);
        Integer pHhknNen = 72;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.75000));

    }

    @Test
    @TestOrder(790)
    public void testExec_A79() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0060);
        Integer pHhknNen = 74;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.60000));

    }

    @Test
    @TestOrder(800)
    public void testExec_A80() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0065);
        Integer pHhknNen = 70;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.97500));

    }

    @Test
    @TestOrder(810)
    public void testExec_A81() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0065);
        Integer pHhknNen = 74;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.65000));

    }

    @Test
    @TestOrder(820)
    public void testExec_A82() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0070);
        Integer pHhknNen = 70;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.05000));

    }

    @Test
    @TestOrder(830)
    public void testExec_A83() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0070);
        Integer pHhknNen = 74;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.70000));

    }

    @Test
    @TestOrder(840)
    public void testExec_A84() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0075);
        Integer pHhknNen = 70;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.12500));

    }

    @Test
    @TestOrder(850)
    public void testExec_A85() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0075);
        Integer pHhknNen = 74;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.75000));

    }

    @Test
    @TestOrder(860)
    public void testExec_A86() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0080);
        Integer pHhknNen = 70;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.20000));

    }

    @Test
    @TestOrder(870)
    public void testExec_A87() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0080);
        Integer pHhknNen = 72;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.00000));

    }

    @Test
    @TestOrder(880)
    public void testExec_A88() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0080);
        Integer pHhknNen = 73;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.90000));

    }

    @Test
    @TestOrder(890)
    public void testExec_A89() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0080);
        Integer pHhknNen = 74;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.80000));

    }

    @Test
    @TestOrder(900)
    public void testExec_A90() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0085);
        Integer pHhknNen = 70;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.27500));
    }

    @Test
    @TestOrder(910)
    public void testExec_A91() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0085);
        Integer pHhknNen = 74;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.85000));

    }

    @Test
    @TestOrder(920)
    public void testExec_A92() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0090);
        Integer pHhknNen = 70;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.35000));

    }

    @Test
    @TestOrder(930)
    public void testExec_A93() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0090);
        Integer pHhknNen = 72;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.12500));

    }

    @Test
    @TestOrder(940)
    public void testExec_A94() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0090);
        Integer pHhknNen = 74;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.90000));

    }

    @Test
    @TestOrder(950)
    public void testExec_A95() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0095);
        Integer pHhknNen = 70;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.42500));

    }

    @Test
    @TestOrder(960)
    public void testExec_A96() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0095);
        Integer pHhknNen = 74;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(0.95000));

    }

    @Test
    @TestOrder(970)
    public void testExec_A97() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0100);
        Integer pHhknNen = 70;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.50000));

    }

    @Test
    @TestOrder(980)
    public void testExec_A98() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0100);
        Integer pHhknNen = 71;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.37500));
    }

    @Test
    @TestOrder(990)
    public void testExec_A99() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0100);
        Integer pHhknNen = 73;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.12500));

    }

    @Test
    @TestOrder(1000)
    public void testExec_A100() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0100);
        Integer pHhknNen = 74;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.00000));

    }

    @Test
    @TestOrder(1010)
    public void testExec_A101() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0115);
        Integer pHhknNen = 76;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.12500));

    }

    @Test
    @TestOrder(1020)
    public void testExec_A102() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0115);
        Integer pHhknNen = 77;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.00000));

    }

    @Test
    @TestOrder(1030)
    public void testExec_A103() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0130);
        Integer pHhknNen = 70;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(2.25000));

    }

    @Test
    @TestOrder(1040)
    public void testExec_A104() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0130);
        Integer pHhknNen = 71;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(2.12500));

    }

    @Test
    @TestOrder(1050)
    public void testExec_A105() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0130);
        Integer pHhknNen = 79;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.12500));
    }

    @Test
    @TestOrder(1060)
    public void testExec_A106() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0130);
        Integer pHhknNen = 80;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(1.00000));

    }

    @Test
    @TestOrder(1070)
    public void testExec_A107() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0150);
        Integer pHhknNen = 74;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(2.25000));

    }

    @Test
    @TestOrder(1080)
    public void testExec_A108() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0150);
        Integer pHhknNen = 75;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(2.12500));

    }

    @Test
    @TestOrder(1090)
    public void testExec_A109() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0175);
        Integer pHhknNen = 79;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(2.25000));

    }

    @Test
    @TestOrder(1100)
    public void testExec_A110() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0175);
        Integer pHhknNen = 80;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(2.12500));

    }

    @Test
    @TestOrder(1110)
    public void testExec_A111() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0200);
        Integer pHhknNen = 70;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(4.00000));
    }

    @Test
    @TestOrder(1120)
    public void testExec_A112() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0200);
        Integer pHhknNen = 71;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(3.87500));

    }

    @Test
    @TestOrder(1130)
    public void testExec_A113() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0225);
        Integer pHhknNen = 75;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(4.00000));

    }

    @Test
    @TestOrder(1140)
    public void testExec_A114() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0225);
        Integer pHhknNen = 76;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(3.87500));

    }

    @Test
    @TestOrder(1150)
    public void testExec_A115() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0245);
        Integer pHhknNen = 79;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(4.00000));

    }

    @Test
    @TestOrder(1160)
    public void testExec_A116() {

        BizNumber pYoteiRiritu = BizNumber.valueOf(0.0245);
        Integer pHhknNen = 80;

        BizNumber yoteiSinkykhiRitu = keisanGaikaItijiSkHiritu.exec(pYoteiRiritu, pHhknNen);

        assertEquals(yoteiSinkykhiRitu,BizNumber.valueOf(3.87500));

    }

}

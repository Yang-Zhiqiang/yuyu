package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 一時払用解約返戻金計算のメソッド {@link KeisanWItiji#exec(BizDate, BizDateYM, KeisanWExtBean) } テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanWItijiTest_exec2 {

    @Inject
    private KeisanWItiji keisanWItiji;

    @Test
    @TestOrder(2010)
    public void testExec_C1() {

        String syouhncd = "ﾕﾍ";
        BizNumber yoteiriritu = BizNumber.valueOf(0.05);

        String yoteirirituRange = keisanWItiji.setYoteirirituHantei(syouhncd, yoteiriritu);

        exStringEquals(yoteirirituRange, "", "予定利率レンジ種類");

    }

    @Test
    @TestOrder(2020)
    public void testExec_C2() {

        String syouhncd = "ﾕﾍ";
        BizNumber yoteiriritu = BizNumber.valueOf(0.04);

        String yoteirirituRange = keisanWItiji.setYoteirirituHantei(syouhncd, yoteiriritu);

        exStringEquals(yoteirirituRange, "1", "予定利率レンジ種類");

    }

    @Test
    @TestOrder(2030)
    public void testExec_C3() {

        String syouhncd = "ﾕﾍ";
        BizNumber yoteiriritu = BizNumber.valueOf(0.013);

        String yoteirirituRange = keisanWItiji.setYoteirirituHantei(syouhncd, yoteiriritu);

        exStringEquals(yoteirirituRange, "1", "予定利率レンジ種類");

    }

    @Test
    @TestOrder(2040)
    public void testExec_C4() {

        String syouhncd = "ﾕﾍ";
        BizNumber yoteiriritu = BizNumber.valueOf(0.012);

        String yoteirirituRange = keisanWItiji.setYoteirirituHantei(syouhncd, yoteiriritu);

        exStringEquals(yoteirirituRange, "2", "予定利率レンジ種類");

    }

    @Test
    @TestOrder(2050)
    public void testExec_C5() {

        String syouhncd = "ﾕﾍ";
        BizNumber yoteiriritu = BizNumber.valueOf(0.0105);

        String yoteirirituRange = keisanWItiji.setYoteirirituHantei(syouhncd, yoteiriritu);

        exStringEquals(yoteirirituRange, "2", "予定利率レンジ種類");

    }

    @Test
    @TestOrder(2060)
    public void testExec_C6() {

        String syouhncd = "ﾕﾍ";
        BizNumber yoteiriritu = BizNumber.valueOf(0.0104);

        String yoteirirituRange = keisanWItiji.setYoteirirituHantei(syouhncd, yoteiriritu);

        exStringEquals(yoteirirituRange, "3", "予定利率レンジ種類");

    }

    @Test
    @TestOrder(2070)
    public void testExec_C7() {

        String syouhncd = "ﾕﾍ";
        BizNumber yoteiriritu = BizNumber.valueOf(0.008);

        String yoteirirituRange = keisanWItiji.setYoteirirituHantei(syouhncd, yoteiriritu);

        exStringEquals(yoteirirituRange, "3", "予定利率レンジ種類");

    }

    @Test
    @TestOrder(2080)
    public void testExec_C8() {

        String syouhncd = "ﾕﾍ";
        BizNumber yoteiriritu = BizNumber.valueOf(0.007);

        String yoteirirituRange = keisanWItiji.setYoteirirituHantei(syouhncd, yoteiriritu);

        exStringEquals(yoteirirituRange, "4", "予定利率レンジ種類");

    }

    @Test
    @TestOrder(2090)
    public void testExec_C9() {

        String syouhncd = "ﾕﾍ";
        BizNumber yoteiriritu = BizNumber.valueOf(0.005);

        String yoteirirituRange = keisanWItiji.setYoteirirituHantei(syouhncd, yoteiriritu);

        exStringEquals(yoteirirituRange, "4", "予定利率レンジ種類");

    }

    @Test
    @TestOrder(2100)
    public void testExec_C10() {

        String syouhncd = "ﾕﾍ";
        BizNumber yoteiriritu = BizNumber.valueOf(0.004);

        String yoteirirituRange = keisanWItiji.setYoteirirituHantei(syouhncd, yoteiriritu);

        exStringEquals(yoteirirituRange, "", "予定利率レンジ種類");

    }

    @Test
    @TestOrder(2110)
    public void testExec_C11() {

        String syouhncd = "ﾕｻ";
        BizNumber yoteiriritu = BizNumber.valueOf(0.07);

        String yoteirirituRange = keisanWItiji.setYoteirirituHantei(syouhncd, yoteiriritu);

        exStringEquals(yoteirirituRange, "", "予定利率レンジ種類");

    }

}
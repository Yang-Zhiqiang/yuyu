package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 配当共通計算のメソッド {@link KeisanDCommon#calcWrmdsKngk(BizCurrency, List<BizNumber>)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanDCommonTest_calcWrmdsKngk {

    @Inject
    private KeisanDCommon keisanDCommon;

    @Test
    @TestOrder(10)
    public void testCalcWrmdsKngk_A1() {

        List<BizNumber> haitouRirituList = new ArrayList<BizNumber>();
        haitouRirituList.add(BizNumber.valueOf(10));
        haitouRirituList.add(BizNumber.valueOf(8));
        haitouRirituList.add(BizNumber.valueOf(2));
        BizCurrency pWrmdsAfGk = keisanDCommon.calcWrmdsKngk(BizCurrency.valueOf(1000), haitouRirituList);

        exBizCalcbleEquals(pWrmdsAfGk, BizCurrency.valueOf(4), "割戻し後金額");
    }



    @Test
    @TestOrder(20)
    public void testCalcWrmdsKngk_A2() {

        List<BizNumber> haitouRirituList = new ArrayList<BizNumber>();
        haitouRirituList.add(BizNumber.valueOf(1));
        BizCurrency pWrmdsAfGk = keisanDCommon.calcWrmdsKngk(BizCurrency.valueOf(1000), haitouRirituList);

        exBizCalcbleEquals(pWrmdsAfGk, BizCurrency.valueOf(500), "割戻し後金額");
    }

    @Test
    @TestOrder(30)
    public void testCalcWrmdsKngk_A3() {

        List<BizNumber> haitouRirituList = new ArrayList<BizNumber>();
        BizCurrency pWrmdsAfGk = keisanDCommon.calcWrmdsKngk(BizCurrency.valueOf(123), haitouRirituList);

        exBizCalcbleEquals(pWrmdsAfGk, BizCurrency.valueOf(123), "割戻し後金額");
    }
}

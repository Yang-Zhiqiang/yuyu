package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

/**
 * 配当共通計算のメソッド {@link KeisanDCommon#getCoordinatedCalcYmd(BizDate, BizDate, BizDateYM)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanDCommonTest_getCoordinatedCalcYmd {

    @Inject
    private KeisanDCommon keisanDCommon;

    @Test
    @TestOrder(10)
    public void testGetCoordinatedCalcYmd_A1() {

        BizDate calckijyunymdTyouseiz = keisanDCommon.getCoordinatedCalcYmd(BizDate.valueOf(20120302),
            BizDate.valueOf(20170301), BizDateYM.valueOf(201703));

        exDateEquals(calckijyunymdTyouseiz, BizDate.valueOf(20170301), "計算基準日（調整済）");
    }

    @Test
    @TestOrder(20)
    public void testGetCoordinatedCalcYmd_A2() {

        BizDate calckijyunymdTyouseiz = keisanDCommon.getCoordinatedCalcYmd(BizDate.valueOf(20120302),
            BizDate.valueOf(20170302), BizDateYM.valueOf(201703));

        exDateEquals(calckijyunymdTyouseiz, BizDate.valueOf(20170302), "計算基準日（調整済）");
    }

    @Test
    @TestOrder(30)
    public void testGetCoordinatedCalcYmd_A3() {

        BizDate calckijyunymdTyouseiz = keisanDCommon.getCoordinatedCalcYmd(BizDate.valueOf(20120302),
            BizDate.valueOf(20170303), BizDateYM.valueOf(201703));

        exDateEquals(calckijyunymdTyouseiz, BizDate.valueOf(20170302), "計算基準日（調整済）");
    }
}

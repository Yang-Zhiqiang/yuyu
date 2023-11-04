package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 前納控除証明額計算クラスのメソッド {@link KeisanZennouKoujyogaku#keisanTukiZennouSymt(BizCurrency,BizCurrency,
 * BizDate,String,BizDateYM,BizDateYM,BizDateYM)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouKoujyogakuTest_keisanTukiZennouSymt {

    @Inject
    private KeisanZennouKoujyogaku keisanZennouKoujyogaku;

    @Test
    @TestOrder(10)
    public void testkeisanTukiZennouSymt_A1() {

        BizCurrency kjsmyouzennounyuukinkgk = BizCurrency.valueOf(350000);
        BizCurrency hrkp = BizCurrency.valueOf(250000);
        BizDate kjsmyouzennoukaisiymd = BizDate.valueOf(20181202);
        String kjsmyouzennoukikanm = "8";
        BizDateYM symKaisiYm = BizDateYM.valueOf(201802);
        BizDateYM symEndYm = BizDateYM.valueOf(201808);
        BizDateYM seisanKaisiYm = BizDateYM.valueOf(201805);

        BizCurrency keisanTukiZennouGngk = keisanZennouKoujyogaku.keisanTukiZennouSymt(kjsmyouzennounyuukinkgk, hrkp,
            kjsmyouzennoukaisiymd, kjsmyouzennoukikanm, symKaisiYm, symEndYm, seisanKaisiYm);

        exBizCalcbleEquals(keisanTukiZennouGngk, BizCurrency.valueOf(175000), "月払前納控除証明精算額");
    }
}

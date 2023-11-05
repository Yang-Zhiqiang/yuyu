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
 * 前納控除証明額計算クラスのメソッド {@link KeisanZennouKoujyogaku#keisanTukiZennouGngk(BizCurrency,BizCurrency,
 * BizCurrency,BizCurrency,BizDate,String,BizDateYM,BizDateYM,BizDateYM)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouKoujyogakuTest_keisanTukiZennouGngk {

    @Inject
    private KeisanZennouKoujyogaku keisanZennouKoujyogaku;

    @Test
    @TestOrder(10)
    public void testKeisanTukiZennouGngk_A1() {

        BizCurrency kjsmyouzennounyuukinkgk = BizCurrency.valueOf(180000);
        BizCurrency henKjsmyouzennounyuukinkgk = BizCurrency.valueOf(150000);
        BizCurrency hrkp = BizCurrency.valueOf(30000);
        BizCurrency henHrkp = BizCurrency.valueOf(20000);
        BizDate kjsmyouzennoukaisiymd = BizDate.valueOf(20180601);
        String kjsmyouzennoukikanm = "5";
        BizDateYM symKaisiYm = BizDateYM.valueOf(201703);
        BizDateYM symEndYm = BizDateYM.valueOf(201812);
        BizDateYM seisanKaisiYm = BizDateYM.valueOf(201704);

        BizCurrency keisanTukiZennouGngk = keisanZennouKoujyogaku.keisanTukiZennouGngk(kjsmyouzennounyuukinkgk, henKjsmyouzennounyuukinkgk, hrkp, henHrkp,
            kjsmyouzennoukaisiymd, kjsmyouzennoukikanm, symKaisiYm, symEndYm, seisanKaisiYm);

        exBizCalcbleEquals(keisanTukiZennouGngk, BizCurrency.valueOf(136000), "月払前納控除証明精算額");
    }
}

package yuyu.common.hozen.ascommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

/**
 * マイナス売上日設定のメソッド {@link SetMinusUriagebi#exec(BizDate pSyoriYmd)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetMinusUriagebiTest_exec {

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        SetMinusUriagebi setMinusUriagebi = SWAKInjector.getInstance(SetMinusUriagebi.class);

        BizDate pSyoriYmd = BizDate.valueOf("2020/09/01");

        setMinusUriagebi.exec(pSyoriYmd);

        exDateEquals(setMinusUriagebi.getUriageSeikyuuYmd(), BizDate.valueOf("2020/09/03"), "売上請求日");

        exDateEquals(setMinusUriagebi.getDenpyouYmd(), BizDate.valueOf("2020/09/03"), "伝票日付");
    }


    @Test
    @TestOrder(20)
    public void testExec_A2() {

        SetMinusUriagebi setMinusUriagebi = SWAKInjector.getInstance(SetMinusUriagebi.class);

        BizDate pSyoriYmd = BizDate.valueOf("2020/09/03");

        setMinusUriagebi.exec(pSyoriYmd);

        exDateEquals(setMinusUriagebi.getUriageSeikyuuYmd(), BizDate.valueOf("2020/09/07"), "売上請求日");

        exDateEquals(setMinusUriagebi.getDenpyouYmd(), BizDate.valueOf("2020/09/07"), "伝票日付");
    }

}

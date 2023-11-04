package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;

import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.testinfr.TestOrder;

/**
 * 入金連絡票日付設定のメソッド {@link SetNyknRnrkhyouYmd#exec(C_HrkmnykndatarenmotoKbn, BizDate)} テスト用クラスです。<br />
 */
public class SetNyknRnrkhyouYmdTest_exec {

    private SetNyknRnrkhyouYmd setNyknRnrkhyouYmd;

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        setNyknRnrkhyouYmd= SWAKInjector.getInstance(SetNyknRnrkhyouYmd.class);
        BizDate nyknRnrkhyouYmd = setNyknRnrkhyouYmd.exec(null, BizDate.valueOf("20171004"));
        exBooleanEquals(nyknRnrkhyouYmd == null, true, "入金連絡票日付");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        setNyknRnrkhyouYmd= SWAKInjector.getInstance(SetNyknRnrkhyouYmd.class);
        BizDate nyknRnrkhyouYmd = setNyknRnrkhyouYmd.exec(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI, null);
        exBooleanEquals(nyknRnrkhyouYmd == null, true, "入金連絡票日付");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        setNyknRnrkhyouYmd= SWAKInjector.getInstance(SetNyknRnrkhyouYmd.class);
        BizDate nyknRnrkhyouYmd = setNyknRnrkhyouYmd.exec(C_HrkmnykndatarenmotoKbn.NYKNMEISAI, BizDate.valueOf("20171005"));
        exDateEquals(nyknRnrkhyouYmd, BizDate.valueOf("20171006"), "入金連絡票日付");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        setNyknRnrkhyouYmd= SWAKInjector.getInstance(SetNyknRnrkhyouYmd.class);
        BizDate nyknRnrkhyouYmd = setNyknRnrkhyouYmd.exec(C_HrkmnykndatarenmotoKbn.NYKNMEISAI, BizDate.valueOf("20171006"));
        exDateEquals(nyknRnrkhyouYmd, BizDate.valueOf("20171010"), "入金連絡票日付");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        setNyknRnrkhyouYmd= SWAKInjector.getInstance(SetNyknRnrkhyouYmd.class);
        BizDate nyknRnrkhyouYmd = setNyknRnrkhyouYmd.exec(C_HrkmnykndatarenmotoKbn.NYKNMEISAI, BizDate.valueOf("20171014"));
        exDateEquals(nyknRnrkhyouYmd, BizDate.valueOf("20171016"), "入金連絡票日付");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        setNyknRnrkhyouYmd= SWAKInjector.getInstance(SetNyknRnrkhyouYmd.class);
        BizDate nyknRnrkhyouYmd = setNyknRnrkhyouYmd.exec(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI, BizDate.valueOf("20171004"));
        exBooleanEquals(nyknRnrkhyouYmd == null, true, "入金連絡票日付");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        setNyknRnrkhyouYmd= SWAKInjector.getInstance(SetNyknRnrkhyouYmd.class);
        BizDate nyknRnrkhyouYmd = setNyknRnrkhyouYmd.exec(C_HrkmnykndatarenmotoKbn.ONLINE, BizDate.valueOf("20171004"));
        exDateEquals(nyknRnrkhyouYmd, BizDate.valueOf("20171004"), "入金連絡票日付");
    }

}

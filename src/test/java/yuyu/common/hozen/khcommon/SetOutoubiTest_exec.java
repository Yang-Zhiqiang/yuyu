package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 直前直後応当日設定クラスのメソッド {@link SetOutoubi#exec(C_TykzentykgoKbn, BizDate, C_Hrkkaisuu, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetOutoubiTest_exec {

    @Inject
    private SetOutoubi setOutoubi;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }


    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate outouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, BizDate.valueOf("20150520"), C_Hrkkaisuu.BLNK, BizDate.valueOf("20150520"));

        exDateEquals(outouYmd, null, "応当日");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate outouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, BizDate.valueOf("20150520"), C_Hrkkaisuu.ITIJI, BizDate.valueOf("20150520"));

        exDateEquals(outouYmd, null, "応当日");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate outouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, BizDate.valueOf("20150510"), C_Hrkkaisuu.NEN, BizDate.valueOf("20150520"));

        exDateEquals(outouYmd, BizDate.valueOf("20160510"), "応当日");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizDate outouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, BizDate.valueOf("20160229"), C_Hrkkaisuu.NEN, BizDate.valueOf("20160520"));

        exDateEquals(outouYmd, BizDate.valueOf("20170228"), "応当日");

    }

    @Test
    @TestOrder(50)
    public void testExec_B1() {

        BizDate outouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, BizDate.valueOf("20150520"), C_Hrkkaisuu.TUKI, BizDate.valueOf("20150520"));

        exDateEquals(outouYmd, BizDate.valueOf("20150620"), "応当日");

    }

    @Test
    @TestOrder(60)
    public void testExec_B2() {

        BizDate outouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, BizDate.valueOf("20150525"), C_Hrkkaisuu.HALFY, BizDate.valueOf("20150520"));

        exDateEquals(outouYmd, BizDate.valueOf("20150525"), "応当日");

    }

    @Test
    @TestOrder(70)
    public void testExec_B3() {

        BizDate outouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, BizDate.valueOf("20150520"), C_Hrkkaisuu.NEN, BizDate.valueOf("20150520"));

        exDateEquals(outouYmd, BizDate.valueOf("20150520"), "応当日");

    }

    @Test
    @TestOrder(80)
    public void testExec_B4() {

        BizDate outouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, BizDate.valueOf("20150125"), C_Hrkkaisuu.TUKI, BizDate.valueOf("20150520"));

        exDateEquals(outouYmd, BizDate.valueOf("20150425"), "応当日");

    }

    @Test
    @TestOrder(90)
    public void testExec_B5() {

        BizDate outouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, BizDate.valueOf("20150525"), C_Hrkkaisuu.HALFY, BizDate.valueOf("20150520"));

        exDateEquals(outouYmd, BizDate.valueOf("20141125"), "応当日");

    }

    @Test
    @TestOrder(100)
    public void testExec_B6() {

        BizDate outouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, BizDate.valueOf("20150125"), C_Hrkkaisuu.HALFY, BizDate.valueOf("20150520"));

        exDateEquals(outouYmd, BizDate.valueOf("20150125"), "応当日");

    }

}

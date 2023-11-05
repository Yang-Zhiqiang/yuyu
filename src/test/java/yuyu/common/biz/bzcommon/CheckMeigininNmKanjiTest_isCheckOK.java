package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kojinhjn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 漢字名義人チェック {@link CheckMeigininNmKanji#isCheckOK(String, C_Kojinhjn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckMeigininNmKanjiTest_isCheckOK extends AbstractTest {

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String pMeigininNmKanji = null;

        C_Kojinhjn pKojinHoujinKbn = C_Kojinhjn.KOJIN;

        Boolean result = CheckMeigininNmKanji.isCheckOK(pMeigininNmKanji, pKojinHoujinKbn);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String pMeigininNmKanji = "";

        C_Kojinhjn pKojinHoujinKbn = C_Kojinhjn.KOJIN;

        Boolean result = CheckMeigininNmKanji.isCheckOK(pMeigininNmKanji, pKojinHoujinKbn);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String pMeigininNmKanji = "漢";

        C_Kojinhjn pKojinHoujinKbn = C_Kojinhjn.HJN;

        Boolean result = CheckMeigininNmKanji.isCheckOK(pMeigininNmKanji, pKojinHoujinKbn);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String pMeigininNmKanji = "漢";

        C_Kojinhjn pKojinHoujinKbn = C_Kojinhjn.KOJIN;

        Boolean result = CheckMeigininNmKanji.isCheckOK(pMeigininNmKanji, pKojinHoujinKbn);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String pMeigininNmKanji = "漢字　名義";

        C_Kojinhjn pKojinHoujinKbn = C_Kojinhjn.KOJIN;

        Boolean result = CheckMeigininNmKanji.isCheckOK(pMeigininNmKanji, pKojinHoujinKbn);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        String pMeigininNmKanji = "漢字　漢　字";

        C_Kojinhjn pKojinHoujinKbn = C_Kojinhjn.KOJIN;

        Boolean result = CheckMeigininNmKanji.isCheckOK(pMeigininNmKanji, pKojinHoujinKbn);

        exBooleanEquals(result, false, "チェック結果");
    }
}


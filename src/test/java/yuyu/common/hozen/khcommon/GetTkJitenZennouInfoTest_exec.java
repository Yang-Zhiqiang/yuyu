package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 特定時点前納情報取得クラスのメソッド {@link GetTkJitenZennouInfo#exec(C_ZennouSeisanKbn, BizDate, IT_Zennou)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class GetTkJitenZennouInfoTest_exec {

    @Inject
    private GetTkJitenZennouInfo getTkJitenZennouInfo;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_特定時点前納情報取得";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetTkJitenZennouInfoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon("17810000016");
        IT_Zennou pZennou = pAnsyuKihon.getZennous().get(0);
        C_ZennouSeisanKbn pZennouSeisanKbn = C_ZennouSeisanKbn.SEISANZUMI;
        BizDate pZennouHanteiKijyunymd = BizDate.valueOf(20180601);

        IT_Zennou zennou= getTkJitenZennouInfo.exec(pZennouSeisanKbn, pZennouHanteiKijyunymd, pZennou);

        exBizCalcbleEquals(zennou.getZennounyuukinkgk(), BizCurrency.valueOf(1000), "前納入金額");
        exBizCalcbleEquals(zennou.getZennoujihrkp(), BizCurrency.valueOf(1100), "前納時払込保険料");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon("17810000027");
        IT_Zennou pZennou = pAnsyuKihon.getZennous().get(0);
        C_ZennouSeisanKbn pZennouSeisanKbn = C_ZennouSeisanKbn.SEISANZUMI;
        BizDate pZennouHanteiKijyunymd = BizDate.valueOf(20180601);

        IT_Zennou zennou= getTkJitenZennouInfo.exec(pZennouSeisanKbn, pZennouHanteiKijyunymd, pZennou);

        exBizCalcbleEquals(zennou.getZennounyuukinkgk(), BizCurrency.valueOf(1000), "前納入金額");
        exBizCalcbleEquals(zennou.getZennoujihrkp(), BizCurrency.valueOf(1100), "前納時払込保険料");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon("17810000038");
        IT_Zennou pZennou = pAnsyuKihon.getZennous().get(0);
        C_ZennouSeisanKbn pZennouSeisanKbn = C_ZennouSeisanKbn.SEISANZUMI;
        BizDate pZennouHanteiKijyunymd = BizDate.valueOf(20180601);

        IT_Zennou zennou= getTkJitenZennouInfo.exec(pZennouSeisanKbn, pZennouHanteiKijyunymd, pZennou);

        exBizCalcbleEquals(zennou.getZennounyuukinkgk(), BizCurrency.valueOf(100), "前納入金額");
        exBizCalcbleEquals(zennou.getZennoujihrkp(), BizCurrency.valueOf(300), "前納時払込保険料");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon("17810000049");
        IT_Zennou pZennou = pAnsyuKihon.getZennous().get(0);
        C_ZennouSeisanKbn pZennouSeisanKbn = C_ZennouSeisanKbn.MISEISAN;
        BizDate pZennouHanteiKijyunymd = BizDate.valueOf(20180601);

        IT_Zennou zennou= getTkJitenZennouInfo.exec(pZennouSeisanKbn, pZennouHanteiKijyunymd, pZennou);

        exBizCalcbleEquals(zennou.getZennounyuukinkgk(), BizCurrency.valueOf(1000), "前納入金額");
        exBizCalcbleEquals(zennou.getZennoujihrkp(), BizCurrency.valueOf(1100), "前納時払込保険料");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon("17810000050");
        IT_Zennou pZennou = pAnsyuKihon.getZennous().get(1);
        C_ZennouSeisanKbn pZennouSeisanKbn = C_ZennouSeisanKbn.MISEISAN;
        BizDate pZennouHanteiKijyunymd = BizDate.valueOf(20180601);

        IT_Zennou zennou= getTkJitenZennouInfo.exec(pZennouSeisanKbn, pZennouHanteiKijyunymd, pZennou);

        exBizCalcbleEquals(zennou.getZennounyuukinkgk(), BizCurrency.valueOf(1100), "前納入金額");
        exBizCalcbleEquals(zennou.getZennoujihrkp(), BizCurrency.valueOf(1200), "前納時払込保険料");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon("17810000061");
        IT_Zennou pZennou = pAnsyuKihon.getZennous().get(1);
        C_ZennouSeisanKbn pZennouSeisanKbn = C_ZennouSeisanKbn.MISEISAN;
        BizDate pZennouHanteiKijyunymd = BizDate.valueOf(20180601);

        IT_Zennou zennou= getTkJitenZennouInfo.exec(pZennouSeisanKbn, pZennouHanteiKijyunymd, pZennou);

        exBizCalcbleEquals(zennou.getZennounyuukinkgk(), BizCurrency.valueOf(1100), "前納入金額");
        exBizCalcbleEquals(zennou.getZennoujihrkp(), BizCurrency.valueOf(1200), "前納時払込保険料");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon("17810000072");
        IT_Zennou pZennou = pAnsyuKihon.getZennous().get(1);
        C_ZennouSeisanKbn pZennouSeisanKbn = C_ZennouSeisanKbn.MISEISAN;
        BizDate pZennouHanteiKijyunymd = BizDate.valueOf(20180602);

        IT_Zennou zennou= getTkJitenZennouInfo.exec(pZennouSeisanKbn, pZennouHanteiKijyunymd, pZennou);

        exBizCalcbleEquals(zennou.getZennounyuukinkgk(), BizCurrency.valueOf(1200), "前納入金額");
        exBizCalcbleEquals(zennou.getZennoujihrkp(), BizCurrency.valueOf(1300), "前納時払込保険料");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon("17810000083");
        IT_Zennou pZennou = pAnsyuKihon.getZennous().get(1);
        C_ZennouSeisanKbn pZennouSeisanKbn = C_ZennouSeisanKbn.MISEISAN;
        BizDate pZennouHanteiKijyunymd = BizDate.valueOf(20180801);

        IT_Zennou zennou= getTkJitenZennouInfo.exec(pZennouSeisanKbn, pZennouHanteiKijyunymd, pZennou);

        exBizCalcbleEquals(zennou.getZennounyuukinkgk(), BizCurrency.valueOf(1200), "前納入金額");
        exBizCalcbleEquals(zennou.getZennoujihrkp(), BizCurrency.valueOf(1300), "前納時払込保険料");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon("17810000094");
        IT_Zennou pZennou = pAnsyuKihon.getZennous().get(1);
        C_ZennouSeisanKbn pZennouSeisanKbn = C_ZennouSeisanKbn.MISEISAN;
        BizDate pZennouHanteiKijyunymd = BizDate.valueOf(20180802);

        IT_Zennou zennou= getTkJitenZennouInfo.exec(pZennouSeisanKbn, pZennouHanteiKijyunymd, pZennou);

        exBizCalcbleEquals(zennou.getZennounyuukinkgk(), BizCurrency.valueOf(1200), "前納入金額");
        exBizCalcbleEquals(zennou.getZennoujihrkp(), BizCurrency.valueOf(1300), "前納時払込保険料");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon("17810000108");
        IT_Zennou pZennou = pAnsyuKihon.getZennous().get(2);
        C_ZennouSeisanKbn pZennouSeisanKbn = C_ZennouSeisanKbn.MISEISAN;
        BizDate pZennouHanteiKijyunymd = BizDate.valueOf(20180501);

        IT_Zennou zennou= getTkJitenZennouInfo.exec(pZennouSeisanKbn, pZennouHanteiKijyunymd, pZennou);

        exBizCalcbleEquals(zennou.getZennounyuukinkgk(), BizCurrency.valueOf(1100), "前納入金額");
        exBizCalcbleEquals(zennou.getZennoujihrkp(), BizCurrency.valueOf(1200), "前納時払込保険料");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon("17807000016");
        IT_Zennou pZennou = pAnsyuKihon.getZennous().get(2);
        C_ZennouSeisanKbn pZennouSeisanKbn = C_ZennouSeisanKbn.MISEISAN;
        BizDate pZennouHanteiKijyunymd = BizDate.valueOf(20180501);

        IT_Zennou zennou= getTkJitenZennouInfo.exec(pZennouSeisanKbn, pZennouHanteiKijyunymd, pZennou);

        exBizCalcbleEquals(zennou.getZennounyuukinkgk(), BizCurrency.valueOf(1000), "前納入金額");
        exBizCalcbleEquals(zennou.getZennoujihrkp(), BizCurrency.valueOf(1100), "前納時払込保険料");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon("17807000027");
        IT_Zennou pZennou = pAnsyuKihon.getZennous().get(2);
        C_ZennouSeisanKbn pZennouSeisanKbn = C_ZennouSeisanKbn.MISEISAN;
        BizDate pZennouHanteiKijyunymd = BizDate.valueOf(20180501);

        IT_Zennou zennou= getTkJitenZennouInfo.exec(pZennouSeisanKbn, pZennouHanteiKijyunymd, pZennou);

        exBizCalcbleEquals(zennou.getZennounyuukinkgk(), BizCurrency.valueOf(1200), "前納入金額");
        exBizCalcbleEquals(zennou.getZennoujihrkp(), BizCurrency.valueOf(1300), "前納時払込保険料");

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon("17807000038");
        IT_Zennou pZennou = pAnsyuKihon.getZennous().get(0);
        C_ZennouSeisanKbn pZennouSeisanKbn = C_ZennouSeisanKbn.MISEISAN;
        BizDate pZennouHanteiKijyunymd = BizDate.valueOf(20180501);

        IT_Zennou zennou= getTkJitenZennouInfo.exec(pZennouSeisanKbn, pZennouHanteiKijyunymd, pZennou);

        exBizCalcbleEquals(zennou.getZennounyuukinkgk(), BizCurrency.valueOf(1200), "前納入金額");
        exBizCalcbleEquals(zennou.getZennoujihrkp(), BizCurrency.valueOf(1300), "前納時払込保険料");

    }
}

package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * DS解約処理中チェッククラスのメソッド {@link ChkSubDsKaiykSyori#exec(String, List<ChkKekkaBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubDsKaiykSyoriTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_DS解約処理中チェック";

    private final static String sheetName = "INデータ";

    @Inject
    private ChkSubDsKaiykSyori chkSubDsKaiykSyori;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(ChkSubDsKaiykSyoriTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhHenkouUktk());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubDsKaiykSyori.exec("11810111118", chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "チェック結果Beanリストの件数");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubDsKaiykSyori.exec("11810111129", chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "チェック結果Beanリストの件数");
        ChkKekkaBean chkKekkaBean = chkKekkaBeanLst.get(0);
        exStringEquals(chkKekkaBean.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBean.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBean.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBean.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBean.getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBean.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.DSKAIYAKUSYORI_CHK,
            "請求内容チェック区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubDsKaiykSyori.exec("11810111130", chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "チェック結果Beanリストの件数");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubDsKaiykSyori.exec("11810111141", chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "チェック結果Beanリストの件数");
        ChkKekkaBean chkKekkaBean = chkKekkaBeanLst.get(0);
        exStringEquals(chkKekkaBean.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBean.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBean.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBean.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBean.getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBean.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.DSKAIYAKUSYORI_CHK,
            "請求内容チェック区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubDsKaiykSyori.exec("11807111152", chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "チェック結果Beanリストの件数");
        ChkKekkaBean chkKekkaBean = chkKekkaBeanLst.get(0);
        exStringEquals(chkKekkaBean.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBean.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBean.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBean.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBean.getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBean.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.DSKAIYAKUSYORI_CHK,
            "請求内容チェック区分");

    }

}

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
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 返戻金未払いチェッククラスのメソッド {@link ChkSubHnrkinMbr#exec(JT_SiKykKihon, List<ChkKekkaBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubHnrkinMbrTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_返戻金未払いチェック";

    private final static String sheetName = "INデータ";

    @Inject
    private ChkSubHnrkinMbr chkSubHnrkinMbr;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(ChkSubHnrkinMbrTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        JT_SiKykKihon siKykKihon = siharaiDomManager.getSiKykKihon("11807111118");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubHnrkinMbr.exec(siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "チェック結果Beanリストの件数");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        JT_SiKykKihon siKykKihon = siharaiDomManager.getSiKykKihon("11807111129");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubHnrkinMbr.exec(siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "チェック結果Beanリストの件数");
        ChkKekkaBean chkKekkaBean = chkKekkaBeanLst.get(0);
        exStringEquals(chkKekkaBean.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBean.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBean.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBean.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBean.getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBean.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEBETU_CHK,
            "請求内容チェック区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        JT_SiKykKihon siKykKihon = siharaiDomManager.getSiKykKihon("11807111130");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubHnrkinMbr.exec(siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "チェック結果Beanリストの件数");
        ChkKekkaBean chkKekkaBean = chkKekkaBeanLst.get(0);
        exStringEquals(chkKekkaBean.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBean.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBean.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBean.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBean.getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBean.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEDOU_CHK,
            "請求内容チェック区分");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        JT_SiKykKihon siKykKihon = siharaiDomManager.getSiKykKihon("11807111141");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubHnrkinMbr.exec(siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "チェック結果Beanリストの件数");
        ChkKekkaBean chkKekkaBean = chkKekkaBeanLst.get(0);
        exStringEquals(chkKekkaBean.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBean.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBean.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBean.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBean.getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBean.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEBETU_CHK,
            "請求内容チェック区分");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        JT_SiKykKihon siKykKihon = siharaiDomManager.getSiKykKihon("11807111152");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubHnrkinMbr.exec(siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "チェック結果Beanリストの件数");
        ChkKekkaBean chkKekkaBean = chkKekkaBeanLst.get(0);
        exStringEquals(chkKekkaBean.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBean.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBean.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBean.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBean.getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBean.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEBETU_CHK,
            "請求内容チェック区分");

    }


    @Test
    @TestOrder(60)
    public void testExec_A6() {

        JT_SiKykKihon siKykKihon = siharaiDomManager.getSiKykKihon("11807111163");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubHnrkinMbr.exec(siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "チェック結果Beanリストの件数");
        ChkKekkaBean chkKekkaBean = chkKekkaBeanLst.get(0);
        exStringEquals(chkKekkaBean.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBean.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBean.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBean.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBean.getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBean.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEDOU_CHK,
            "請求内容チェック区分");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        JT_SiKykKihon siKykKihon = siharaiDomManager.getSiKykKihon("11807111174");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubHnrkinMbr.exec(siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "チェック結果Beanリストの件数");
        ChkKekkaBean chkKekkaBean = chkKekkaBeanLst.get(0);
        exStringEquals(chkKekkaBean.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBean.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBean.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBean.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBean.getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBean.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEBETU_CHK,
            "請求内容チェック区分");

    }
}

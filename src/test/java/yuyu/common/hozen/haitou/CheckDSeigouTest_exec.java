package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 配当整合チェッククラスのメソッド {@link CheckDSeigou#exec(String,BizDateY,BizDate,BizDate,BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDSeigouTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当整合チェック";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(DBAccessDCommon.class).to(DBAccessDCommonMockForHozen.class);
                bind(SetHokenNnd.class).to(SetHokenNndMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        MockObjectManager.initialize();
        DBAccessDCommonMockForHozen.caller = CheckDSeigouTest_exec.class;
        SetHokenNndMockForHozen.caller = CheckDSeigouTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        DBAccessDCommonMockForHozen.caller = null;
        DBAccessDCommonMockForHozen.SYORIPTN = null;
        SetHokenNndMockForHozen.caller = null;
        SetHokenNndMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckDSeigouTest_exec.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String pSyono = "60806000022";
        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = BizDate.valueOf(20180606);
        BizDate pYendtHnkYmd = BizDate.valueOf(20180607);
        BizDate pSyoriYmd = null;
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_ErrorKbn errorKbn = checkDSeigou.exec(pSyono, pKykMfHaitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String pSyono = null;
        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = BizDate.valueOf(20180606);
        BizDate pYendtHnkYmd = BizDate.valueOf(20180607);
        BizDate pSyoriYmd = BizDate.valueOf(20180606);
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_ErrorKbn errorKbn = checkDSeigou.exec(pSyono, pKykMfHaitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "処理結果");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String pSyono = "60806000022";
        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = BizDate.valueOf(20180609);
        BizDate pYendtHnkYmd = BizDate.valueOf(20180607);
        BizDate pSyoriYmd = BizDate.valueOf(20180608);
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_ErrorKbn errorKbn = checkDSeigou.exec(pSyono, pKykMfHaitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);

        exClassificationEquals(checkDSeigou.getKykMfHaitounendoHuseigouUmu(), C_UmuKbn.NONE, "契約MF配当年度不整合有無");
        exClassificationEquals(checkDSeigou.getHaitoukanriTBLHuseigouUmu(), C_UmuKbn.NONE, "配当管理TBL不整合有無");
        exClassificationEquals(checkDSeigou.getTumitateDkanriTBLHuseigouUmu(), C_UmuKbn.NONE, "積立Ｄ管理ＴＢＬ不整合有無");
        exClassificationEquals(checkDSeigou.getDHuseigouUmu(), C_UmuKbn.NONE, "配当不整合有無");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "処理結果");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN1;

        String pSyono = "60806000022";
        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = BizDate.valueOf(20180608);
        BizDate pYendtHnkYmd = BizDate.valueOf(20180607);
        BizDate pSyoriYmd = BizDate.valueOf(20180609);
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_ErrorKbn errorKbn = checkDSeigou.exec(pSyono, pKykMfHaitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "処理結果");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN1;

        String pSyono = "60806000022";
        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = BizDate.valueOf(20180609);
        BizDate pYendtHnkYmd = BizDate.valueOf(20180607);
        BizDate pSyoriYmd = BizDate.valueOf(20180609);
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_ErrorKbn errorKbn = checkDSeigou.exec(pSyono, pKykMfHaitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "処理結果");
    }

    @Test
    @TestOrder(55)
    public void testExec_A6() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;

        String pSyono = "60806000022";
        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = BizDate.valueOf(20180609);
        BizDate pYendtHnkYmd = BizDate.valueOf(20180607);
        BizDate pSyoriYmd = BizDate.valueOf(20180609);
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_ErrorKbn errorKbn = checkDSeigou.exec(pSyono, pKykMfHaitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "処理結果");
    }

    @Test
    @TestOrder(60)
    public void testExec_A7() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN3;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN3;

        String pSyono = "60806000011";
        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = null;
        BizDate pYendtHnkYmd = BizDate.valueOf(20180609);
        BizDate pSyoriYmd = BizDate.valueOf(20180302);
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_ErrorKbn errorKbn = checkDSeigou.exec(pSyono, pKykMfHaitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);

        exClassificationEquals(checkDSeigou.getKykMfHaitounendoHuseigouUmu(), C_UmuKbn.ARI, "契約MF配当年度不整合有無");
        exClassificationEquals(checkDSeigou.getHaitoukanriTBLHuseigouUmu(), C_UmuKbn.NONE, "配当管理TBL不整合有無");
        exClassificationEquals(checkDSeigou.getTumitateDkanriTBLHuseigouUmu(), C_UmuKbn.NONE, "積立Ｄ管理ＴＢＬ不整合有無");
        exClassificationEquals(checkDSeigou.getDHuseigouUmu(), C_UmuKbn.ARI, "配当不整合有無");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "処理結果");
    }

    @Test
    @TestOrder(70)
    public void testExec_A8() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN4;

        String pSyono = "60806000044";
        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = null;
        BizDate pYendtHnkYmd = BizDate.valueOf(20180609);
        BizDate pSyoriYmd = BizDate.valueOf(20180509);
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_ErrorKbn errorKbn = checkDSeigou.exec(pSyono, pKykMfHaitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);

        exClassificationEquals(checkDSeigou.getKykMfHaitounendoHuseigouUmu(), C_UmuKbn.NONE, "契約MF配当年度不整合有無");
        exClassificationEquals(checkDSeigou.getHaitoukanriTBLHuseigouUmu(), C_UmuKbn.ARI, "配当管理TBL不整合有無");
        exClassificationEquals(checkDSeigou.getTumitateDkanriTBLHuseigouUmu(), C_UmuKbn.NONE, "積立Ｄ管理ＴＢＬ不整合有無");
        exClassificationEquals(checkDSeigou.getDHuseigouUmu(), C_UmuKbn.ARI, "配当不整合有無");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "処理結果");
    }

    @Test
    @TestOrder(80)
    public void testExec_A9() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN5;

        String pSyono = "60806000033";
        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = null;
        BizDate pYendtHnkYmd = BizDate.valueOf(20180609);
        BizDate pSyoriYmd = BizDate.valueOf(20180509);
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_ErrorKbn errorKbn = checkDSeigou.exec(pSyono, pKykMfHaitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);

        exClassificationEquals(checkDSeigou.getKykMfHaitounendoHuseigouUmu(), C_UmuKbn.NONE, "契約MF配当年度不整合有無");
        exClassificationEquals(checkDSeigou.getHaitoukanriTBLHuseigouUmu(), C_UmuKbn.NONE, "配当管理TBL不整合有無");
        exClassificationEquals(checkDSeigou.getTumitateDkanriTBLHuseigouUmu(), C_UmuKbn.ARI, "積立Ｄ管理ＴＢＬ不整合有無");
        exClassificationEquals(checkDSeigou.getDHuseigouUmu(), C_UmuKbn.ARI, "配当不整合有無");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "処理結果");
    }

    @Test
    @TestOrder(90)
    public void testExec_A10() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN6;

        String pSyono = "60806000011";
        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = null;
        BizDate pYendtHnkYmd = BizDate.valueOf(20180609);
        BizDate pSyoriYmd = BizDate.valueOf(20180509);
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_ErrorKbn errorKbn = checkDSeigou.exec(pSyono, pKykMfHaitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);

        exClassificationEquals(checkDSeigou.getKykMfHaitounendoHuseigouUmu(), C_UmuKbn.NONE, "契約MF配当年度不整合有無");
        exClassificationEquals(checkDSeigou.getHaitoukanriTBLHuseigouUmu(), C_UmuKbn.NONE, "配当管理TBL不整合有無");
        exClassificationEquals(checkDSeigou.getTumitateDkanriTBLHuseigouUmu(), C_UmuKbn.NONE, "積立Ｄ管理ＴＢＬ不整合有無");
        exClassificationEquals(checkDSeigou.getDHuseigouUmu(), C_UmuKbn.NONE, "配当不整合有無");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "処理結果");
    }
}

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
 * 配当整合チェッククラスのメソッド {@link CheckDSeigou#init()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDSeigouTest_init {

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
        DBAccessDCommonMockForHozen.caller = CheckDSeigouTest_init.class;
        SetHokenNndMockForHozen.caller = CheckDSeigouTest_init.class;
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
            testDataAndTblMap = testDataMaker.getInData(CheckDSeigouTest_init.class,
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
    @TestOrder(130)
    public void testInit_A1() {

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

        exClassificationEquals(checkDSeigou.getKykMfHaitounendoHuseigouUmu(), C_UmuKbn.ARI, "契約MF配当年度不整合有無");
        exClassificationEquals(checkDSeigou.getHaitoukanriTBLHuseigouUmu(), C_UmuKbn.NONE, "配当管理TBL不整合有無");
        exClassificationEquals(checkDSeigou.getTumitateDkanriTBLHuseigouUmu(), C_UmuKbn.NONE, "積立Ｄ管理ＴＢＬ不整合有無");
        exClassificationEquals(checkDSeigou.getDHuseigouUmu(), C_UmuKbn.ARI, "配当不整合有無");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "処理結果");

        checkDSeigou.init();

        exClassificationEquals(checkDSeigou.getKykMfHaitounendoHuseigouUmu(), null, "契約MF配当年度不整合有無");
        exClassificationEquals(checkDSeigou.getHaitoukanriTBLHuseigouUmu(), null, "配当管理TBL不整合有無");
        exClassificationEquals(checkDSeigou.getTumitateDkanriTBLHuseigouUmu(), null, "積立Ｄ管理ＴＢＬ不整合有無");
        exClassificationEquals(checkDSeigou.getDHuseigouUmu(), null, "配当不整合有無");
    }

}

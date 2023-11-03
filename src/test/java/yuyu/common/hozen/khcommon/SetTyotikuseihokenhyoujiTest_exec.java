package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 貯蓄性保険表示設定のメソッド {@link SetTyotikuseihokenhyouji#exec(IT_KykKihon)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetTyotikuseihokenhyoujiTest_exec {

    @Inject
    private SetTyotikuseihokenhyouji setTyotikuseihokenhyouji;

    @Inject
    private HozenDomManager hozenDomManager;

    private C_ErrorKbn erroKbn;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_貯蓄性保険表示設定";

    private final static String sheetName = "INデータ";

    private final static String syoNo1  = "11807111129";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanW.class).to(KeisanWMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanWMockForHozen.caller = SetTyotikuseihokenhyoujiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

        KeisanWMockForHozen.caller = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(SetTyotikuseihokenhyoujiTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo1);

        erroKbn = setTyotikuseihokenhyouji.exec(pKykKihon);

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(setTyotikuseihokenhyouji.getHouteityotkhknhyj(),C_UmuKbn.ARI, "法定貯蓄性保険表示");
        exClassificationEquals(setTyotikuseihokenhyouji.getTyotkhknhyj(),C_UmuKbn.NONE, "貯蓄性保険表示");
    }
}

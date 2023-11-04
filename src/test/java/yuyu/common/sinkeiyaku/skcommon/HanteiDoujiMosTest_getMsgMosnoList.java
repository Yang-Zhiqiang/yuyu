package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 同時申込判定クラスのメソッド {@link HanteiDoujiMos#getMsgMosnoList()} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class HanteiDoujiMosTest_getMsgMosnoList {


    @Inject
    private HanteiDoujiMos hanteiDoujiMos;

    private final static String fileName = "UT_SP_単体テスト仕様書_同時申込判定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HanteiDoujiMosTest_getMsgMosnoList.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testGetMsgMosnoList_A1() {
        hanteiDoujiMos.hanteiDoujiMos("791112493");
        exStringEquals(hanteiDoujiMos.getMsgMosnoList() ,"（RAY：なし、PAL：あり）" , "メッセージ用申込番号リスト");
    }

    @Test
    @TestOrder(20)
    public void testGetMsgMosnoList_A2() {
        hanteiDoujiMos.hanteiDoujiMos("791112477");
        exStringEquals(hanteiDoujiMos.getMsgMosnoList() ,"（RAY：791112469、PAL：なし）" , "メッセージ用申込番号リスト");
    }

    @Test
    @TestOrder(30)
    public void testGetMsgMosnoList_A3() {
        hanteiDoujiMos.hanteiDoujiMos("791112451");
        exStringEquals(hanteiDoujiMos.getMsgMosnoList() ,"（RAY：791112444、791112436、791112428、PAL：あり）" , "メッセージ用申込番号リスト");
    }

}

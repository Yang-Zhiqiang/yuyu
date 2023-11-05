package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 同時申込判定クラスのメソッド {@link HanteiDoujiMos#hanteiDoujiMos(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiDoujiMosTest_hanteiDoujiMos {


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
            testDataAndTblMap = testDataMaker.getInData(HanteiDoujiMosTest_hanteiDoujiMos.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
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
    public void testHanteiDoujiMos_A1(){
        C_ErrorKbn errorKbn = hanteiDoujiMos.hanteiDoujiMos("791112519");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR , "エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testHanteiDoujiMos_A2(){
        C_ErrorKbn errorKbn = hanteiDoujiMos.hanteiDoujiMos("791112501");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK , "エラー区分");
        exNumericEquals(hanteiDoujiMos.getMosnoList().size(), 0 , "メンバ変数．申込番号リストの件数");
        exClassificationEquals(hanteiDoujiMos.getDoujiMosUmu(), C_UmuKbn.NONE , "同時申込有無");
    }

    @Test
    @TestOrder(30)
    public void testHanteiDoujiMos_A3(){
        C_ErrorKbn errorKbn = hanteiDoujiMos.hanteiDoujiMos("791112493");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK , "エラー区分");
        exNumericEquals(hanteiDoujiMos.getMosnoList().size(), 0 , "メンバ変数．申込番号リストの件数");
        exClassificationEquals(hanteiDoujiMos.getDoujiMosUmu(), C_UmuKbn.ARI , "同時申込有無");
    }

    @Test
    @TestOrder(40)
    public void testHanteiDoujiMos_A4(){
        C_ErrorKbn errorKbn = hanteiDoujiMos.hanteiDoujiMos("791112485");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK , "エラー区分");
        exNumericEquals(hanteiDoujiMos.getMosnoList().size(), 0 , "メンバ変数．申込番号リストの件数");
        exClassificationEquals(hanteiDoujiMos.getDoujiMosUmu(), C_UmuKbn.NONE , "同時申込有無");
    }

    @Test
    @TestOrder(50)
    public void testHanteiDoujiMos_A5(){
        C_ErrorKbn errorKbn = hanteiDoujiMos.hanteiDoujiMos("791112477");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK , "エラー区分");
        exNumericEquals(hanteiDoujiMos.getMosnoList().size(), 1 , "メンバ変数．申込番号リストの件数");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(0), "791112469" , "申込番号");
        exClassificationEquals(hanteiDoujiMos.getDoujiMosUmu(), C_UmuKbn.ARI , "同時申込有無");
    }

    @Test
    @TestOrder(60)
    public void testHanteiDoujiMos_A6(){
        C_ErrorKbn errorKbn = hanteiDoujiMos.hanteiDoujiMos("791112451");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK , "エラー区分");
        exNumericEquals(hanteiDoujiMos.getMosnoList().size(), 10 , "メンバ変数．申込番号リストの件数");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(0), "791112444" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(1), "791112436" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(2), "791112428" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(3), "791112303" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(4), "791112311" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(5), "791112329" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(6), "791112337" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(7), "791112345" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(8), "791112352" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(9), "791112360" , "申込番号");
        exClassificationEquals(hanteiDoujiMos.getDoujiMosUmu(), C_UmuKbn.ARI , "同時申込有無");
    }

    @Test
    @TestOrder(70)
    public void testHanteiDoujiMos_A7(){
        C_ErrorKbn errorKbn = hanteiDoujiMos.hanteiDoujiMos("861112308");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK , "エラー区分");
        exNumericEquals(hanteiDoujiMos.getMosnoList().size(), 10 , "メンバ変数．申込番号リストの件数");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(0), "861112316" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(1), "861112324" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(2), "861112332" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(3), "861112340" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(4), "861112357" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(5), "861112365" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(6), "861112373" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(7), "861112381" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(8), "861112399" , "申込番号");
        exStringEquals(hanteiDoujiMos.getMosnoList().get(9), "861112407" , "申込番号");
        exClassificationEquals(hanteiDoujiMos.getDoujiMosUmu(), C_UmuKbn.ARI , "同時申込有無");
    }

    @Test
    @TestOrder(80)
    public void testHanteiDoujiMos_A8(){
        C_ErrorKbn errorKbn = hanteiDoujiMos.hanteiDoujiMos("861112423");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK , "エラー区分");
        exNumericEquals(hanteiDoujiMos.getMosnoList().size(), 0 , "メンバ変数．申込番号リストの件数");
        exClassificationEquals(hanteiDoujiMos.getDoujiMosUmu(), C_UmuKbn.NONE , "同時申込有無");
    }

}

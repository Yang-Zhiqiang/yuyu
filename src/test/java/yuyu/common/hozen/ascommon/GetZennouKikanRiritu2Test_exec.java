package yuyu.common.hozen.ascommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 前納期間利率取得処理２クラスのメソッド {@link getZennouKikanRiritu2#exec(
 * C_Tuukasyu, BizDate, BizDate, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetZennouKikanRiritu2Test_exec {

    @Inject
    private GetZennouKikanRiritu2 getZennouKikanRiritu2;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_前納期間利率取得処理２";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetZennouKikanRiritu2Test_exec.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllZennouTumitateRitu());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        BizDate pKikanfrom = BizDate.valueOf("20180101");
        BizDate pKikanto = BizDate.valueOf("20190117");
        BizDate pKykYmd = BizDate.valueOf("20181101");
        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, null, "前納期間利率");
        exListEquals(zennouTmttrituHnkbiList, null, "前納積立率変更日リスト");
        exListEquals(newZennouTmttrituList, null, "変更後前納積立率リスト");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        BizDate pKikanfrom = BizDate.valueOf("20180110");
        BizDate pKikanto = BizDate.valueOf("20180125");
        BizDate pKykYmd = BizDate.valueOf("20181101");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, null, "前納期間利率");
        exListEquals(zennouTmttrituHnkbiList, null, "前納積立率変更日リスト");
        exListEquals(newZennouTmttrituList, null, "変更後前納積立率リスト");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        BizDate pKikanfrom = BizDate.valueOf("20180110");
        BizDate pKikanto = BizDate.valueOf("20181224");
        BizDate pKykYmd = BizDate.valueOf("20181101");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, null, "前納期間利率");
        exListEquals(zennouTmttrituHnkbiList, null, "前納積立率変更日リスト");
        exListEquals(newZennouTmttrituList, null, "変更後前納積立率リスト");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        BizDate pKikanfrom = BizDate.valueOf("20180110");
        BizDate pKikanto = BizDate.valueOf("20181230");
        BizDate pKykYmd = BizDate.valueOf("20181101");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, null, "前納期間利率");
        exListEquals(zennouTmttrituHnkbiList, null, "前納積立率変更日リスト");
        exListEquals(newZennouTmttrituList, null, "変更後前納積立率リスト");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizDate pKikanfrom = BizDate.valueOf("20180114");
        BizDate pKikanto = BizDate.valueOf("20181130");
        BizDate pKykYmd = BizDate.valueOf("20181114");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, BizNumber.valueOf(7.0565833333), "前納期間利率");
        exNumericEquals(zennouTmttrituHnkbiList.size(), 1, "前納積立率変更日リスト");
        exDateEquals(zennouTmttrituHnkbiList.get(0), BizDate.valueOf("20180214"), "前納積立率変更日");
        exNumericEquals(newZennouTmttrituList.size(), 1, "変更後前納積立率リスト");
        exBizCalcbleEquals(newZennouTmttrituList.get(0), BizNumber.valueOf(7.789), "変更後前納積立率");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizDate pKikanfrom = BizDate.valueOf("20180114");
        BizDate pKikanto = BizDate.valueOf("20181129");
        BizDate pKykYmd = BizDate.valueOf("20181114");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, BizNumber.valueOf(6.4075000000), "前納期間利率");
        exNumericEquals(zennouTmttrituHnkbiList.size(), 1, "前納積立率変更日リスト");
        exDateEquals(zennouTmttrituHnkbiList.get(0), BizDate.valueOf("20180214"), "前納積立率変更日");
        exNumericEquals(newZennouTmttrituList.size(), 1, "変更後前納積立率リスト");
        exBizCalcbleEquals(newZennouTmttrituList.get(0), BizNumber.valueOf(7.789), "変更後前納積立率");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizDate pKikanfrom = BizDate.valueOf("20180114");
        BizDate pKikanto = BizDate.valueOf("20181128");
        BizDate pKykYmd = BizDate.valueOf("20181114");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, BizNumber.valueOf(6.4075000000), "前納期間利率");
        exNumericEquals(zennouTmttrituHnkbiList.size(), 1, "前納積立率変更日リスト");
        exDateEquals(zennouTmttrituHnkbiList.get(0), BizDate.valueOf("20180214"), "前納積立率変更日");
        exNumericEquals(newZennouTmttrituList.size(), 1, "変更後前納積立率リスト");
        exBizCalcbleEquals(newZennouTmttrituList.get(0), BizNumber.valueOf(7.789), "変更後前納積立率");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void insertTestDataTwo() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetZennouKikanRiritu2Test_exec.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(90)
    public void testExec_A8() {
        BizDate pKikanfrom = BizDate.valueOf("20180906");
        BizDate pKikanto = BizDate.valueOf("20181130");
        BizDate pKykYmd = BizDate.valueOf("20181101");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, BizNumber.valueOf(1.1140000000), "前納期間利率");
        exNumericEquals(zennouTmttrituHnkbiList.size(),1, "前納積立率変更日リスト");
        exDateEquals(zennouTmttrituHnkbiList.get(0), BizDate.valueOf("20181001"), "前納積立率変更日");
        exNumericEquals(newZennouTmttrituList.size(), 1, "変更後前納積立率リスト");
        exBizCalcbleEquals(newZennouTmttrituList.get(0), BizNumber.valueOf(5.567), "変更後前納積立率");
    }

    @Test
    @TestOrder(100)
    public void testExec_A9() {
        BizDate pKikanfrom = BizDate.valueOf("20180906");
        BizDate pKikanto = BizDate.valueOf("20181130");
        BizDate pKykYmd = BizDate.valueOf("20181128");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, BizNumber.valueOf(1.1140000000), "前納期間利率");
        exNumericEquals(zennouTmttrituHnkbiList.size(),2, "前納積立率変更日リスト");
        exDateEquals(zennouTmttrituHnkbiList.get(0), BizDate.valueOf("20180928"), "前納積立率変更日");
        exDateEquals(zennouTmttrituHnkbiList.get(1), BizDate.valueOf("20181128"), "前納積立率変更日");
        exNumericEquals(newZennouTmttrituList.size(), 2, "変更後前納積立率リスト");
        exBizCalcbleEquals(newZennouTmttrituList.get(0), BizNumber.valueOf(5.567), "変更後前納積立率");
        exBizCalcbleEquals(newZennouTmttrituList.get(1), BizNumber.valueOf(6.678), "変更後前納積立率");
    }

    @Test
    @TestOrder(110)
    public void testExec_A10() {
        BizDate pKikanfrom = BizDate.valueOf("20181010");
        BizDate pKikanto = BizDate.valueOf("20181115");
        BizDate pKykYmd = BizDate.valueOf("20181111");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, null, "前納期間利率");
        exNumericEquals(zennouTmttrituHnkbiList.size(),0, "前納積立率変更日リスト");
        exNumericEquals(newZennouTmttrituList.size(), 0, "変更後前納積立率リスト");
    }

    @Test
    @TestOrder(120)
    public void testExec_A11() {
        BizDate pKikanfrom = BizDate.valueOf("20181010");
        BizDate pKikanto = BizDate.valueOf("20181126");
        BizDate pKykYmd = BizDate.valueOf("20181126");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, BizNumber.valueOf(0.9278333333), "前納期間利率");
        exNumericEquals(zennouTmttrituHnkbiList.size(),1, "前納積立率変更日リスト");
        exDateEquals(zennouTmttrituHnkbiList.get(0), BizDate.valueOf("20181126"), "前納積立率変更日");
        exNumericEquals(newZennouTmttrituList.size(), 1, "変更後前納積立率リスト");
        exBizCalcbleEquals(newZennouTmttrituList.get(0), BizNumber.valueOf(6.678), "変更後前納積立率");
    }

    @Test
    @TestOrder(130)
    public void testExec_A12() {
        BizDate pKikanfrom = BizDate.valueOf("20181010");
        BizDate pKikanto = BizDate.valueOf("20181125");
        BizDate pKykYmd = BizDate.valueOf("20181125");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, BizNumber.valueOf(0.4639166666), "前納期間利率");
        exNumericEquals(zennouTmttrituHnkbiList.size(),1, "前納積立率変更日リスト");
        exDateEquals(zennouTmttrituHnkbiList.get(0), BizDate.valueOf("20181125"), "前納積立率変更日");
        exNumericEquals(newZennouTmttrituList.size(), 1, "変更後前納積立率リスト");
        exBizCalcbleEquals(newZennouTmttrituList.get(0), BizNumber.valueOf(6.678), "変更後前納積立率");
    }

    @Test
    @TestOrder(140)
    public void testExec_A13() {
        BizDate pKikanfrom = BizDate.valueOf("20181010");
        BizDate pKikanto = BizDate.valueOf("20181124");
        BizDate pKykYmd = BizDate.valueOf("20181124");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, BizNumber.valueOf(0.4639166666), "前納期間利率");
        exNumericEquals(zennouTmttrituHnkbiList.size(),1, "前納積立率変更日リスト");
        exDateEquals(zennouTmttrituHnkbiList.get(0), BizDate.valueOf("20181124"), "前納積立率変更日");
        exNumericEquals(newZennouTmttrituList.size(), 1, "変更後前納積立率リスト");
        exBizCalcbleEquals(newZennouTmttrituList.get(0), BizNumber.valueOf(6.678), "変更後前納積立率");
    }

    @Test
    @TestOrder(150)
    public void testExec_A14() {
        BizDate pKikanfrom = BizDate.valueOf("20181010");
        BizDate pKikanto = BizDate.valueOf("20181009");
        BizDate pKykYmd = BizDate.valueOf("20181124");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, null, "前納期間利率");
        exListEquals(zennouTmttrituHnkbiList, null, "前納積立率変更日リスト");
        exListEquals(newZennouTmttrituList, null, "変更後前納積立率リスト");
    }

    @Test
    @TestOrder(160)
    public void testExec_A15() {
        BizDate pKikanfrom = BizDate.valueOf("20181120");
        BizDate pKikanto = BizDate.valueOf("20181120");
        BizDate pKykYmd = BizDate.valueOf("20181120");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, BizNumber.ZERO, "前納期間利率");
        exNumericEquals(zennouTmttrituHnkbiList.size(),0, "前納積立率変更日リスト");
        exNumericEquals(newZennouTmttrituList.size(), 0, "変更後前納積立率リスト");
    }

    @Test
    @TestOrder(170)
    public void testExec_A16() {
        BizDate pKikanfrom = BizDate.valueOf("20181120");
        BizDate pKikanto = BizDate.valueOf("20191120");
        BizDate pKykYmd = BizDate.valueOf("20181120");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, BizNumber.valueOf(6.678), "前納期間利率");
        exNumericEquals(zennouTmttrituHnkbiList.size(),0, "前納積立率変更日リスト");
        exNumericEquals(newZennouTmttrituList.size(), 0, "変更後前納積立率リスト");
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void insertTestDataThree() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetZennouKikanRiritu2Test_exec.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(190)
    public void testExec_A17() {
        BizDate pKikanfrom = BizDate.valueOf("20181120");
        BizDate pKikanto = BizDate.valueOf("20191120");
        BizDate pKykYmd = BizDate.valueOf("20181120");

        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;

        C_ErrorKbn errorKbn = getZennouKikanRiritu2.exec(pTuukasyu, pKikanfrom, pKikanto, pKykYmd);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();
        List<BizDate> zennouTmttrituHnkbiList = getZennouKikanRiritu2.getZennouTmttrituHnkbiList();
        List<BizNumber> newZennouTmttrituList = getZennouKikanRiritu2.getNewZennouTmttrituList();
        exBizCalcbleEquals(zennouKikanRiritu, BizNumber.valueOf(0.0006), "前納期間利率");
        exNumericEquals(zennouTmttrituHnkbiList.size(),1, "前納積立率変更日リスト");
        exDateEquals(zennouTmttrituHnkbiList.get(0), BizDate.valueOf("20191120"), "前納積立率変更日");
        exNumericEquals(newZennouTmttrituList.size(), 1, "変更後前納積立率リスト");
        exBizCalcbleEquals(newZennouTmttrituList.get(0), BizNumber.valueOf(0.0007), "変更後前納積立率");
    }
}

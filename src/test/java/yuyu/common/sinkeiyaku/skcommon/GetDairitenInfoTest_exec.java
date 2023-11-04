package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 代理店情報取得クラスのメソッド {@link GetDairitenInfo#exec(String, String, String, BizDate)} テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetDairitenInfoTest_exec {

    @Inject
    private GetDairitenInfo getDairitenInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書_代理店情報取得";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditTblAtukaisyaTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDairiten());
        bizDomManager.delete(bizDomManager.getAllBosyuunin());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String tratkiagNm = "";

        String oyadrtenNm = "1100003";

        String bosyuuNm = "";

        BizDate mosymd = BizDate.valueOf("20150624");

        getDairitenInfo.exec(tratkiagNm, oyadrtenNm, bosyuuNm, mosymd);

        exStringEquals(getDairitenInfo.getTratkiagnm(), "取扱代理店名", "取扱代理店名");
        exStringEquals(getDairitenInfo.getOyadrtennm(), "取扱代理店名", "親代理店名");
        exStringEquals(getDairitenInfo.getBosyuunm(), "", "募集人名");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String tratkiagNm = "1100004";

        String oyadrtenNm = "";

        String bosyuuNm = "";

        BizDate mosymd = BizDate.valueOf("20150624");

        getDairitenInfo.exec(tratkiagNm, oyadrtenNm, bosyuuNm, mosymd);

        exStringEquals(getDairitenInfo.getTratkiagnm(), "親代理店名", "取扱代理店名");
        exStringEquals(getDairitenInfo.getOyadrtennm(), "", "親代理店名");
        exStringEquals(getDairitenInfo.getBosyuunm(), "", "募集人名");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String tratkiagNm = "1100006";

        String oyadrtenNm = "1100007";

        String bosyuuNm = "";

        BizDate mosymd = BizDate.valueOf("20150624");

        getDairitenInfo.exec(tratkiagNm, oyadrtenNm, bosyuuNm, mosymd);

        exStringEquals(getDairitenInfo.getTratkiagnm(), "取扱代理店名０", "取扱代理店名");
        exStringEquals(getDairitenInfo.getOyadrtennm(), "取扱代理店名１", "親代理店名");
        exStringEquals(getDairitenInfo.getBosyuunm(), "", "募集人名");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String tratkiagNm = "";

        String oyadrtenNm = "";

        String bosyuuNm = "110010";

        BizDate mosymd = BizDate.valueOf("20150624");

        getDairitenInfo.exec(tratkiagNm, oyadrtenNm, bosyuuNm, mosymd);

        exStringEquals(getDairitenInfo.getTratkiagnm(), "", "取扱代理店名");
        exStringEquals(getDairitenInfo.getOyadrtennm(), "", "親代理店名");
        exStringEquals(getDairitenInfo.getBosyuunm(), "募集人名", "募集人名");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String tratkiagNm = "1100006";

        String oyadrtenNm = "1100007";

        String bosyuuNm = null;

        BizDate mosymd = BizDate.valueOf("20150624");

        getDairitenInfo.exec(tratkiagNm, oyadrtenNm, bosyuuNm, mosymd);

        exStringEquals(getDairitenInfo.getTratkiagnm(), "取扱代理店名０", "取扱代理店名");
        exStringEquals(getDairitenInfo.getOyadrtennm(), "取扱代理店名１", "親代理店名");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        String tratkiagNm = null;

        String oyadrtenNm = null;

        String bosyuuNm = "110010";

        BizDate mosymd = BizDate.valueOf("20150624");

        getDairitenInfo.exec(tratkiagNm, oyadrtenNm, bosyuuNm, mosymd);

        exStringEquals(getDairitenInfo.getBosyuunm(), "募集人名", "募集人名");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        String tratkiagNm = "1100006";

        String oyadrtenNm = "1100007";

        String bosyuuNm = "018605";

        BizDate mosymd = BizDate.valueOf("20150624");

        getDairitenInfo.exec(tratkiagNm, oyadrtenNm, bosyuuNm, mosymd);

        exStringEquals(getDairitenInfo.getTratkiagnm(), "取扱代理店名０", "取扱代理店名");
        exStringEquals(getDairitenInfo.getOyadrtennm(), "取扱代理店名１", "親代理店名");
        exStringEquals(getDairitenInfo.getBosyuunm(), "", "募集人名");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        String tratkiagNm = "0000004";

        String oyadrtenNm = "0000006";

        String bosyuuNm = "110010";

        BizDate mosymd = BizDate.valueOf("20150624");

        getDairitenInfo.exec(tratkiagNm, oyadrtenNm, bosyuuNm, mosymd);

        exStringEquals(getDairitenInfo.getTratkiagnm(), "", "取扱代理店名");
        exStringEquals(getDairitenInfo.getOyadrtennm(), "", "親代理店名");
        exStringEquals(getDairitenInfo.getBosyuunm(), "募集人名", "募集人名");
    }
}
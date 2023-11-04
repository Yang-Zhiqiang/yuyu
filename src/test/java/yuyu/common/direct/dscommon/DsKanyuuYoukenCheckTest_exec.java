package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ加入要件チェッククラスのメソッド {@link DsKanyuuYoukenCheck#exec(String pSyoNo} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsKanyuuYoukenCheckTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ加入要件チェック";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsKanyuuYoukenCheckTest_exec.class, fileName, sheetName);
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
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        DsKanyuuYoukenCheck dsKanyuuYoukenCheck = SWAKInjector.getInstance(DsKanyuuYoukenCheck.class);

        String syoNo = "17806000013";

        DsKanyuuYoukenCheckBean dsKanyuuYoukenCheckBean = dsKanyuuYoukenCheck.exec(syoNo);

        exClassificationEquals(dsKanyuuYoukenCheckBean.getDsKanyuuYoukenCheckKbn(), C_ErrorKbn.OK, "ＤＳ加入要件チェック区分");
        exClassificationEquals(dsKanyuuYoukenCheckBean.getKyksyaYisiNouryoukuNasiUmuKbn(), C_UmuKbn.NONE,
            "契約者意思能力なし有無区分");
        exClassificationEquals(dsKanyuuYoukenCheckBean.getKyksyaYukueFumeiUmuKbn(), C_UmuKbn.NONE, "契約者行方不明有無区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        DsKanyuuYoukenCheck dsKanyuuYoukenCheck = SWAKInjector.getInstance(DsKanyuuYoukenCheck.class);

        String syoNo = "17806000024";

        DsKanyuuYoukenCheckBean dsKanyuuYoukenCheckBean = dsKanyuuYoukenCheck.exec(syoNo);

        exClassificationEquals(dsKanyuuYoukenCheckBean.getDsKanyuuYoukenCheckKbn(), C_ErrorKbn.ERROR, "ＤＳ加入要件チェック区分");
        exClassificationEquals(dsKanyuuYoukenCheckBean.getKyksyaYisiNouryoukuNasiUmuKbn(), C_UmuKbn.ARI,
            "契約者意思能力なし有無区分");
        exClassificationEquals(dsKanyuuYoukenCheckBean.getKyksyaYukueFumeiUmuKbn(), C_UmuKbn.NONE, "契約者行方不明有無区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        DsKanyuuYoukenCheck dsKanyuuYoukenCheck = SWAKInjector.getInstance(DsKanyuuYoukenCheck.class);

        String syoNo = "17806000035";

        DsKanyuuYoukenCheckBean dsKanyuuYoukenCheckBean = dsKanyuuYoukenCheck.exec(syoNo);

        exClassificationEquals(dsKanyuuYoukenCheckBean.getDsKanyuuYoukenCheckKbn(), C_ErrorKbn.ERROR, "ＤＳ加入要件チェック区分");
        exClassificationEquals(dsKanyuuYoukenCheckBean.getKyksyaYisiNouryoukuNasiUmuKbn(), C_UmuKbn.NONE,
            "契約者意思能力なし有無区分");
        exClassificationEquals(dsKanyuuYoukenCheckBean.getKyksyaYukueFumeiUmuKbn(), C_UmuKbn.ARI, "契約者行方不明有無区分");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        DsKanyuuYoukenCheck dsKanyuuYoukenCheck = SWAKInjector.getInstance(DsKanyuuYoukenCheck.class);

        String syoNo = "17806000046";

        DsKanyuuYoukenCheckBean dsKanyuuYoukenCheckBean = dsKanyuuYoukenCheck.exec(syoNo);

        exClassificationEquals(dsKanyuuYoukenCheckBean.getDsKanyuuYoukenCheckKbn(), C_ErrorKbn.ERROR, "ＤＳ加入要件チェック区分");
        exClassificationEquals(dsKanyuuYoukenCheckBean.getKyksyaYisiNouryoukuNasiUmuKbn(), C_UmuKbn.ARI,
            "契約者意思能力なし有無区分");
        exClassificationEquals(dsKanyuuYoukenCheckBean.getKyksyaYukueFumeiUmuKbn(), C_UmuKbn.ARI, "契約者行方不明有無区分");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        DsKanyuuYoukenCheck dsKanyuuYoukenCheck = SWAKInjector.getInstance(DsKanyuuYoukenCheck.class);

        String syoNo = "17806000057";

        DsKanyuuYoukenCheckBean dsKanyuuYoukenCheckBean = dsKanyuuYoukenCheck.exec(syoNo);

        exClassificationEquals(dsKanyuuYoukenCheckBean.getDsKanyuuYoukenCheckKbn(), C_ErrorKbn.OK, "ＤＳ加入要件チェック区分");
        exClassificationEquals(dsKanyuuYoukenCheckBean.getKyksyaYisiNouryoukuNasiUmuKbn(), C_UmuKbn.NONE,
            "契約者意思能力なし有無区分");
        exClassificationEquals(dsKanyuuYoukenCheckBean.getKyksyaYukueFumeiUmuKbn(), C_UmuKbn.NONE, "契約者行方不明有無区分");

    }

    @Test
    @TestOrder(60)
    public void testExec_B1() {

        DsKanyuuYoukenCheck dsKanyuuYoukenCheck = SWAKInjector.getInstance(DsKanyuuYoukenCheck.class);

        BizDate pKykseiymd = null;

        C_ErrorKbn nenErrorkKbn = dsKanyuuYoukenCheck.checkDsKanyuuNenrei(pKykseiymd);

        exClassificationEquals(nenErrorkKbn, C_ErrorKbn.ERROR, "ＤＳ加入年齢エラー区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_B2() {

        DsKanyuuYoukenCheck dsKanyuuYoukenCheck = SWAKInjector.getInstance(DsKanyuuYoukenCheck.class);

        BizDate pKykseiymd = BizDate.valueOf("20010906");

        C_ErrorKbn nenErrorkKbn = dsKanyuuYoukenCheck.checkDsKanyuuNenrei(pKykseiymd);

        exClassificationEquals(nenErrorkKbn, C_ErrorKbn.ERROR, "ＤＳ加入年齢エラー区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_B3() {

        DsKanyuuYoukenCheck dsKanyuuYoukenCheck = SWAKInjector.getInstance(DsKanyuuYoukenCheck.class);

        BizDate pKykseiymd = BizDate.valueOf("20010905");

        C_ErrorKbn nenErrorkKbn = dsKanyuuYoukenCheck.checkDsKanyuuNenrei(pKykseiymd);

        exClassificationEquals(nenErrorkKbn, C_ErrorKbn.OK, "ＤＳ加入年齢エラー区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_B4() {

        DsKanyuuYoukenCheck dsKanyuuYoukenCheck = SWAKInjector.getInstance(DsKanyuuYoukenCheck.class);

        BizDate pKykseiymd = BizDate.valueOf("20010904");

        C_ErrorKbn nenErrorkKbn = dsKanyuuYoukenCheck.checkDsKanyuuNenrei(pKykseiymd);

        exClassificationEquals(nenErrorkKbn, C_ErrorKbn.OK, "ＤＳ加入年齢エラー区分");
    }

}

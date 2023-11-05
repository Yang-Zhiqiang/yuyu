package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutaiMockForDirect;
import yuyu.def.classification.C_DsDataMaintenanceRiyuuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳデータメンテナンス中判定のメソッド{@link DsDataMaintenanceHantei#exec(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsDataMaintenanceHanteiTest_exec extends AbstractTest{

    @Inject
    private DsDataMaintenanceHantei dsDataMaintenanceHantei;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳデータメンテナンス中判定";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HanteiKhSisuurendoTmttknJyoutai.class).to(HanteiKhSisuurendoTmttknJyoutaiMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        HanteiKhSisuurendoTmttknJyoutaiMockForDirect.caller = DsDataMaintenanceHanteiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        HanteiKhSisuurendoTmttknJyoutaiMockForDirect.caller = null;
        HanteiKhSisuurendoTmttknJyoutaiMockForDirect.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsDataMaintenanceHanteiTest_exec.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() throws Exception {

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("60806000011");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.NONE, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.BLNK, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() throws Exception {

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("60806000022");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.NONE, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.BLNK, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() throws Exception {

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("60806000033");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.NONE, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.BLNK, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() throws Exception {

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("60806000055");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.NONE, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.BLNK, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() throws Exception {

        changeSystemDate(BizDate.valueOf(20190903));

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("60806000066");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.ARI, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.ZENNOUJYUUTOUSYORITYUU, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() throws Exception {

        changeSystemDate(BizDate.valueOf(20190902));

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("60806000077");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.ARI, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.ZENNOUJYUUTOUSYORITYUU, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() throws Exception {

        changeSystemDate(BizDate.valueOf(20190902));

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("60806000088");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.NONE, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.BLNK, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() throws Exception {

        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190903));

        HanteiKhSisuurendoTmttknJyoutaiMockForDirect.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForDirect.TESTPATTERN1;

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("60806000044");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.NONE, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.BLNK, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() throws Exception {

        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190903));

        HanteiKhSisuurendoTmttknJyoutaiMockForDirect.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForDirect.TESTPATTERN2;

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("60806000099");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.ARI, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.TUMITATEKINMIHANEI, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() throws Exception {

        changeSystemDate(BizDate.valueOf(20190903));

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("60806000103");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.NONE, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.BLNK, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() throws Exception {

        changeSystemDate(BizDate.valueOf(20190903));

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("60806000114");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.ARI, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.KOURYOKUHASSEIYMDMITOURAI, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() throws Exception {

        changeSystemDate(BizDate.valueOf(20190903));

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("17806000013");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.NONE, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.BLNK, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() throws Exception {

        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190903));

        HanteiKhSisuurendoTmttknJyoutaiMockForDirect.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForDirect.TESTPATTERN1;

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("60806000125");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.NONE, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.BLNK, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() throws Exception {

        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190903));

        HanteiKhSisuurendoTmttknJyoutaiMockForDirect.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForDirect.TESTPATTERN2;

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("60806000136");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.ARI, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.TUMITATEKINMIHANEI, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() throws Exception {

        changeSystemDate(BizDate.valueOf(20190903));

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("60806000147");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.NONE, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.BLNK, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() throws Exception {

        changeSystemDate(BizDate.valueOf(20190903));

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("17810000016");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.ARI, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.ZENNOUJYUUTOUSYORITYUU, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() throws Exception {

        changeSystemDate(BizDate.valueOf(20190902));

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("17810000027");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.ARI, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.ZENNOUJYUUTOUSYORITYUU, "ＤＳデータメンテナンス理由区分");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() throws Exception {

        changeSystemDate(BizDate.valueOf(20190902));

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec("17810000038");

        exClassificationEquals(dsDataMaintenanceHanteiBean.getKekkaKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn(), C_UmuKbn.NONE, "ＤＳデータメンテナンス有無区分");
        exClassificationEquals(dsDataMaintenanceHanteiBean.getDsDataMaintenanceRiyuuKbn(), C_DsDataMaintenanceRiyuuKbn.BLNK, "ＤＳデータメンテナンス理由区分");
    }
}

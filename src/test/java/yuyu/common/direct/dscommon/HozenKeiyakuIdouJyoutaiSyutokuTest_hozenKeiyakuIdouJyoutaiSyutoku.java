package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForDirect;
import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukshantkekKbn;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保全契約異動状態取得のメソッド{@link HozenKeiyakuIdouJyoutaiSyutoku#hozenKeiyakuIdouJyoutaiSyutoku(String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutoku {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保全契約異動状態取得";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HozenKeiyakuIdouJyoutaiSyutoku.class).to(HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.class);
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForDirect.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void testInit() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.caller = HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutoku.class;
        BzGetProcessSummaryMockForDirect.caller = HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutoku.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.caller = null;
        BzGetProcessSummaryMockForDirect.caller = null;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = null;
        BzGetProcessSummaryMockForDirect.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(
                HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutoku.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);


        hozenDomManager.delete(hozenDomManager.getAllKhMeigiHenkouWk());


        hozenDomManager.delete(hozenDomManager.getAllKhJyuusyoHenkouWk());


        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    public void testHozenKeiyakuIdouJyoutaiSyutoku_A1() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN2;

        String pSyoNo = "31809111327";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean  idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.ERROR, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.ERROR, "異動中区分");


        String syoNo = (String)MockObjectManager.
            getArgument(HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.class, "keiyakuJyoutaiYuukouseiHantei", 0, 0);

        exStringEquals(syoNo, "31809111327", "証券番号");
    }

    @Test
    @TestOrder(20)
    public void testHozenKeiyakuIdouJyoutaiSyutoku_A2() {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        String pSyoNo = "17806000035";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.ERROR, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.ERROR, "異動中区分");
    }

    @Test
    @TestOrder(30)
    public void testHozenKeiyakuIdouJyoutaiSyutoku_A3() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        String pSyoNo = "17806000046";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.ERROR, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.ERROR, "異動中区分");
    }

    @Test
    @TestOrder(40)
    public void testHozenKeiyakuIdouJyoutaiSyutoku_A4() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        String pSyoNo = "17806000057";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.ERROR, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.ERROR, "異動中区分");
    }

    @Test
    @TestOrder(50)
    public void testHozenKeiyakuIdouJyoutaiSyutoku_A5() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        String pSyoNo = "17806000068";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        C_UmuKbn meigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getMeigiHenkouUmuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");
        exClassificationEquals(meigiHenkouUmuKbn, C_UmuKbn.ARI, "名義変更有無区分");
    }

    @Test
    @TestOrder(60)
    public void testHozenKeiyakuIdouJyoutaiSyutoku_A6() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        String pSyoNo = "17806000079";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        C_UmuKbn meigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getMeigiHenkouUmuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");
        exClassificationEquals(meigiHenkouUmuKbn, C_UmuKbn.ARI, "名義変更有無区分");
    }

    @Test
    @TestOrder(70)
    public void testHozenKeiyakuIdouJyoutaiSyutoku_A7() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        String pSyoNo = "17806000080";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        C_UmuKbn meigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getMeigiHenkouUmuKbn();
        C_UmuKbn juushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getJuushoHenkouUmuKbn();

        C_UmuKbn yotenSouiUmuKbn = idouJyoutaiSyutokuBean.getYotenSouiUmuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");
        exClassificationEquals(meigiHenkouUmuKbn, C_UmuKbn.ARI, "名義変更有無区分");
        exClassificationEquals(juushoHenkouUmuKbn, C_UmuKbn.NONE, "住所変更有無区");
        exClassificationEquals(yotenSouiUmuKbn, C_UmuKbn.ARI, "四点相違有無区分");
    }

    @Test
    @TestOrder(80)
    public void testHozenKeiyakuIdouJyoutaiSyutoku_A8() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        String pSyoNo = "17806000091";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        C_UmuKbn meigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getMeigiHenkouUmuKbn();
        C_UmuKbn juushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getJuushoHenkouUmuKbn();

        C_UmuKbn yotenSouiUmuKbn = idouJyoutaiSyutokuBean.getYotenSouiUmuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");
        exClassificationEquals(meigiHenkouUmuKbn, C_UmuKbn.NONE, "名義変更有無区分");
        exClassificationEquals(juushoHenkouUmuKbn, C_UmuKbn.ARI, "住所変更有無区");
        exClassificationEquals(yotenSouiUmuKbn, C_UmuKbn.ARI, "四点相違有無区分");
    }

    @Test
    @TestOrder(90)
    public void testHozenKeiyakuIdouJyoutaiSyutoku_A9() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        BzGetProcessSummaryMockForDirect.SYORIPTN = BzGetProcessSummaryMockForDirect.TESTPATTERN1;

        String pSyoNo = "17806000105";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        C_UmuKbn meigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getMeigiHenkouUmuKbn();
        C_UmuKbn juushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getJuushoHenkouUmuKbn();

        C_UmuKbn srMeigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrMeigiHenkouUmuKbn();

        C_UmuKbn srJuushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrJuushoHenkouUmuKbn();

        C_UmuKbn yotenSouiUmuKbn = idouJyoutaiSyutokuBean.getYotenSouiUmuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");
        exClassificationEquals(meigiHenkouUmuKbn, C_UmuKbn.NONE, "名義変更有無区分");
        exClassificationEquals(juushoHenkouUmuKbn, C_UmuKbn.NONE, "住所変更有無区");
        exClassificationEquals(srMeigiHenkouUmuKbn, C_UmuKbn.ARI, "処理中名義変更有無区分");
        exClassificationEquals(srJuushoHenkouUmuKbn, C_UmuKbn.ARI, "処理中住所変更有無区分");
        exClassificationEquals(yotenSouiUmuKbn, C_UmuKbn.ARI, "四点相違有無区分");
    }

    @Test
    @TestOrder(100)
    public void testHozenKeiyakuIdouJyoutaiSyutoku_A10() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        BzGetProcessSummaryMockForDirect.SYORIPTN = BzGetProcessSummaryMockForDirect.TESTPATTERN2;

        String pSyoNo = "17806000116";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        C_UmuKbn meigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getMeigiHenkouUmuKbn();
        C_UmuKbn juushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getJuushoHenkouUmuKbn();

        C_UmuKbn srMeigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrMeigiHenkouUmuKbn();

        C_UmuKbn srJuushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrJuushoHenkouUmuKbn();

        C_UmuKbn yotenSouiUmuKbn = idouJyoutaiSyutokuBean.getYotenSouiUmuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUNASHI, "異動中区分");
        exClassificationEquals(meigiHenkouUmuKbn, C_UmuKbn.NONE, "名義変更有無区分");
        exClassificationEquals(juushoHenkouUmuKbn, C_UmuKbn.NONE, "住所変更有無区");
        exClassificationEquals(srMeigiHenkouUmuKbn, C_UmuKbn.NONE, "処理中名義変更有無区分");
        exClassificationEquals(srJuushoHenkouUmuKbn, C_UmuKbn.NONE, "処理中住所変更有無区分");
        exClassificationEquals(yotenSouiUmuKbn, C_UmuKbn.NONE, "四点相違有無区分");
    }

    @Test
    @TestOrder(110)
    public void testHozenKeiyakuIdouJyoutaiSyutoku_A11() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        BzGetProcessSummaryMockForDirect.SYORIPTN = BzGetProcessSummaryMockForDirect.TESTPATTERN3;

        String pSyoNo = "17806000127";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        C_UmuKbn meigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getMeigiHenkouUmuKbn();
        C_UmuKbn juushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getJuushoHenkouUmuKbn();

        C_UmuKbn srMeigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrMeigiHenkouUmuKbn();

        C_UmuKbn srJuushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrJuushoHenkouUmuKbn();

        C_UmuKbn yotenSouiUmuKbn = idouJyoutaiSyutokuBean.getYotenSouiUmuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUNASHI, "異動中区分");
        exClassificationEquals(meigiHenkouUmuKbn, C_UmuKbn.NONE, "名義変更有無区分");
        exClassificationEquals(juushoHenkouUmuKbn, C_UmuKbn.NONE, "住所変更有無区");
        exClassificationEquals(srMeigiHenkouUmuKbn, C_UmuKbn.NONE, "処理中名義変更有無区分");
        exClassificationEquals(srJuushoHenkouUmuKbn, C_UmuKbn.NONE, "処理中住所変更有無区分");
        exClassificationEquals(yotenSouiUmuKbn, C_UmuKbn.NONE, "四点相違有無区分");
    }
}
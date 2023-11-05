package yuyu.common.direct.dscommon;

import static org.junit.Assert.*;
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
import yuyu.def.classification.C_DsPhrkhouhenkouKahiSeigyoKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ制御情報取得クラスのメソッド {@link DsGetSeigyo#getSyoriKahi(DsSyouhinBean pDsSyouhinBean)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class DsGetSeigyoTest_getSyoriKahi extends AbstractTest {

    @Inject
    private DsGetSeigyo dsGetSeigyo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ制御情報取得";
    private final static String sheetName = "INデータ";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(DsDataMaintenanceHantei.class).to(DsDataMaintenanceHanteiMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        DsDataMaintenanceHanteiMockForDirect.caller = DsGetSeigyoTest_getSyoriKahi.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.caller = null;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsGetSeigyoTest_getSyoriKahi.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);

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
    public void testGetSyoriKahi_A1() {
        changeSystemDate(BizDate.valueOf("20180212"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);
        dsSyouhinBean.setSyoNo("11807111199");
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testGetSyoriKahi_A2() {
        changeSystemDate(BizDate.valueOf("20180212"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);
        dsSyouhinBean.setSyoNo("11807111129");
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testGetSyoriKahi_A3() {
        changeSystemDate(BizDate.valueOf("20180212"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);
        dsSyouhinBean.setSyoNo("11807111130");
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testGetSyoriKahi_A4() {
        changeSystemDate(BizDate.valueOf("20180212"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);
        dsSyouhinBean.setSyoNo("11807111141");
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(50)
    public void testGetSyoriKahi_A5() {
        changeSystemDate(BizDate.valueOf("20180801"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);
        dsSyouhinBean.setSyoNo("11807111152");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(60)
    public void testGetSyoriKahi_A6() {
        changeSystemDate(BizDate.valueOf("20180801"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);
        dsSyouhinBean.setSyoNo("11807111163");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.KA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(70)
    public void testGetSyoriKahi_A7() {
        changeSystemDate(BizDate.valueOf("20180801"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);
        dsSyouhinBean.setSyoNo("11807111174");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(80)
    public void testGetSyoriKahi_A8() {
        changeSystemDate(BizDate.valueOf("20180212"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTITIJIBRNK);
        dsSyouhinBean.setSyoNo("11807111185");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(90)
    public void testGetSyoriKahi_A9() {
        changeSystemDate(BizDate.valueOf("20180212"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTITIJIBRNK);
        dsSyouhinBean.setSyoNo("11807111196");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.KA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(100)
    public void testGetSyoriKahi_A10() {
        changeSystemDate(BizDate.valueOf("20180212"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTITIJIBRNK);
        dsSyouhinBean.setSyoNo("11807111200");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(110)
    public void testGetSyoriKahi_A11() {
        changeSystemDate(BizDate.valueOf("20180212"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTITIJIBRNK);
        dsSyouhinBean.setSyoNo("11807111211");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.KA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(120)
    public void testGetSyoriKahi_A12() {
        changeSystemDate(BizDate.valueOf("20180212"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTITIJIBRNK);
        dsSyouhinBean.setSyoNo("11807111222");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.KA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(130)
    public void testGetSyoriKahi_A13() {
        changeSystemDate(BizDate.valueOf("20180212"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTITIJIBRNK);
        dsSyouhinBean.setSyoNo("11807111233");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(140)
    public void testGetSyoriKahi_A14() {
        changeSystemDate(BizDate.valueOf("20180212"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTITIJIBRNK);
        dsSyouhinBean.setSyoNo("17809000252");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.HUKA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.HUKA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.HUKA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.HUKA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.HUKA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.HUKA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(150)
    public void testGetSyoriKahi_A15() {
        changeSystemDate(BizDate.valueOf("20180212"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.BLNK);
        dsSyouhinBean.setSyoNo("17809000274");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertNull(syoriKahiBean.getKjsmSaihakkouKahiKbn());
        assertNull(syoriKahiBean.getKykMeigihnkKahiKbn());
        assertNull(syoriKahiBean.getSyoukenSaihkKahiKbn());
        assertNull(syoriKahiBean.getStdrskTkyTthkKahiKbn());
        assertNull(syoriKahiBean.getTargetTkhkKahiKbn());
        assertNull(syoriKahiBean.getKykNiyuSyoukaiKahiKbn());
        assertNull(syoriKahiBean.getTumitatekinItenKahiKbn());
        assertNull(syoriKahiBean.getDsKaiyakuKahiKbn());
        assertNull(syoriKahiBean.getAdrHenkouKahiKbn());
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(190)
    public void testGetSyoriKahi_A19() {
        changeSystemDate(BizDate.valueOf("20190325"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTHIJYNBRNK);
        dsSyouhinBean.setSyoNo("17810000016");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(200)
    public void testGetSyoriKahi_A20() {
        changeSystemDate(BizDate.valueOf("20190325"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTHIJYNBRNK);
        dsSyouhinBean.setSyoNo("17810000027");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.KA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(210)
    public void testGetSyoriKahi_A21() {
        changeSystemDate(BizDate.valueOf("20190325"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTHIJYNBRNK);
        dsSyouhinBean.setSyoNo("17810000038");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(260)
    public void testGetSyoriKahi_A26() {
        changeSystemDate(BizDate.valueOf("20190826"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRNK);
        dsSyouhinBean.setSyoNo("60806000011");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(270)
    public void testGetSyoriKahi_A27() {
        changeSystemDate(BizDate.valueOf("20190826"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRNK);
        dsSyouhinBean.setSyoNo("60806000022");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.KA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(280)
    public void testGetSyoriKahi_A28() {
        changeSystemDate(BizDate.valueOf("20190826"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRNK);
        dsSyouhinBean.setSyoNo("60806000033");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }
    @Test
    @TestOrder(290)
    public void testGetSyoriKahi_A29() {
        changeSystemDate(BizDate.valueOf("20190826"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTITIJIBRNK);
        dsSyouhinBean.setSyoNo("60806000044");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        assertNull(syoriKahiBean.getKjsmSaihakkouKahiKbn());
        assertNull(syoriKahiBean.getKykMeigihnkKahiKbn());
        assertNull(syoriKahiBean.getSyoukenSaihkKahiKbn());
        assertNull(syoriKahiBean.getStdrskTkyTthkKahiKbn());
        assertNull(syoriKahiBean.getTargetTkhkKahiKbn());
        assertNull(syoriKahiBean.getKykNiyuSyoukaiKahiKbn());
        assertNull(syoriKahiBean.getTumitatekinItenKahiKbn());
        assertNull(syoriKahiBean.getDsKaiyakuKahiKbn());
        assertNull(syoriKahiBean.getAdrHenkouKahiKbn());
        assertNull(syoriKahiBean.getPhrkhouHenkouKahiKbn());
    }

    @Test
    @TestOrder(300)
    public void testGetSyoriKahi_A30() {
        changeSystemDate(BizDate.valueOf("20190826"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTITIJIBRNK);
        dsSyouhinBean.setSyoNo("60806000044");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN2;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.HUKA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.HUKA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(310)
    public void testGetSyoriKahi_A31() {
        changeSystemDate(BizDate.valueOf("20190826"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN);
        dsSyouhinBean.setSyoNo("99806001010");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.KA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.KA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(320)
    public void testGetSyoriKahi_A32() {
        changeSystemDate(BizDate.valueOf("20190826"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN);
        dsSyouhinBean.setSyoNo("99806001021");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN2;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.KA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.HUKA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.HUKA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.KOUHURIHENKOUNOMIKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(330)
    public void testGetSyoriKahi_A33() {
        changeSystemDate(BizDate.valueOf("20190826"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN);
        dsSyouhinBean.setSyoNo("99806001032");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN2;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.HUKA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.HUKA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(340)
    public void testGetSyoriKahi_A34() {
        changeSystemDate(BizDate.valueOf("20190826"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN);
        dsSyouhinBean.setSyoNo("99806001043");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN2;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.HUKA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.HUKA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.KA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }

    @Test
    @TestOrder(340)
    public void testGetSyoriKahi_A35() {
        changeSystemDate(BizDate.valueOf("20190826"));
        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN);
        dsSyouhinBean.setSyoNo("60806000055");
        MockObjectManager.initialize();
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        exClassificationEquals(syoriKahiBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(syoriKahiBean.getKjsmSaihakkouKahiKbn(), C_KahiKbn.HUKA, "控除証明書再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getKykMeigihnkKahiKbn(), C_KahiKbn.HUKA, "名義変更処理可否区分");
        exClassificationEquals(syoriKahiBean.getSyoukenSaihkKahiKbn(), C_KahiKbn.HUKA, "証券再発行処理可否区分");
        exClassificationEquals(syoriKahiBean.getStdrskTkyTthkKahiKbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(syoriKahiBean.getTargetTkhkKahiKbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(syoriKahiBean.getKykNiyuSyoukaiKahiKbn(), C_KahiKbn.HUKA, "契約内容照会可否区分");
        exClassificationEquals(syoriKahiBean.getTumitatekinItenKahiKbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
        exClassificationEquals(syoriKahiBean.getDsKaiyakuKahiKbn(), C_KahiKbn.HUKA, "ＤＳ解約可否区分");
        exClassificationEquals(syoriKahiBean.getAdrHenkouKahiKbn(), C_KahiKbn.HUKA, "住所変更可否区分");
        exClassificationEquals(syoriKahiBean.getPhrkhouHenkouKahiKbn(), C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA, "保険料払込方法変更可否区分");
    }
}
